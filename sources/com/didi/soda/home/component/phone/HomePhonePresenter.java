package com.didi.soda.home.component.phone;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.skeleton.dialog.VerticalTransformAnimation;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.ITransformAnimation;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.home.manager.HomeSimpleOmegaHelper;
import com.didi.soda.home.manager.PolicyNotifyHelper;
import com.didi.soda.home.page.SubscribePhonePage;
import com.taxis99.R;

public class HomePhonePresenter extends ICustomerPresenter<HomePhoneView> {

    /* renamed from: a */
    private String f45089a;

    /* renamed from: b */
    private int f45090b;

    /* renamed from: c */
    private int f45091c;

    public void submit(String str) {
        ((HomePhoneView) getLogicView()).showOrHideLoading(true);
        PolicyNotifyHelper.submit(getScopeContext(), this.f45089a, str, false, new PolicyNotifyHelper.VoidCallback() {
            public final void invoke(boolean z) {
                HomePhonePresenter.this.m33466a(z);
            }
        });
        HomeSimpleOmegaHelper.trackHomePhonePageCK(this.f45091c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33466a(boolean z) {
        ((HomePhoneView) getLogicView()).showOrHideLoading(false);
        if (z) {
            ((HomePhoneView) getLogicView()).hideSoftInput();
            Bundle bundle = new Bundle();
            bundle.putInt(Const.PageParams.SUB_BACK_FROM_PHONE, 1);
            getScopeContext().getNavigator().finish(bundle);
        }
    }

    public void showPhoneCode() {
        CountryListDialog.show(getScopeContext(), new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                HomePhonePresenter.this.m33465a(str, i);
            }
        }, this.f45090b, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange, new CountryListDialogAnimation());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33465a(String str, int i) {
        this.f45089a = str;
        this.f45090b = i;
        ((HomePhoneView) getLogicView()).updateCallingCode(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m33464a();
        ((HomePhoneView) getLogicView()).updateCallingCode(this.f45089a);
        HomeSimpleOmegaHelper.trackHomePhonePageSW(this.f45091c);
    }

    /* renamed from: a */
    private void m33464a() {
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString(SubscribePhonePage.PARAM_CALLING_CODE);
        this.f45089a = string;
        if (TextUtils.isEmpty(string)) {
            this.f45089a = "+1";
        }
        this.f45090b = bundle.getInt(SubscribePhonePage.PARAM_COUNTRY_ID, 0);
        this.f45091c = bundle.getInt("param_error_code", 0);
    }

    private static class CountryListDialogAnimation implements ITransformAnimation {
        private CountryListDialogAnimation() {
        }

        public TransformAnimation getEnterAnimation() {
            return new VerticalTransformAnimation();
        }

        public TransformAnimation getExitAnimation() {
            return new VerticalTransformAnimation();
        }
    }
}
