package com.didi.soda.home.policy;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.push.CustomerPushReport;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.PrivacyContentStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.p165h5.CustomerH5UrlConst;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.home.policy.model.PrivacyContentEntity;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class HomePolicyHelper {
    public static final int FIRST_POLICY_ACCEPTED = 0;
    public static final int UPDATED_POLICY_ACCEPTED = 1;

    /* renamed from: a */
    private static final String f45208a = HomePolicyHelper.class.getSimpleName();

    /* renamed from: b */
    private DialogInstrument f45209b;

    /* renamed from: c */
    private boolean f45210c;

    /* renamed from: d */
    private OnPolicyDialogClickListener f45211d;

    /* renamed from: e */
    private OnShowPolicyUpdateDialogListener f45212e;

    /* renamed from: f */
    private int f45213f;

    /* renamed from: g */
    private Dialog f45214g;
    public boolean mPolicyDialogNeedShow;

    public interface OnPolicyDialogClickListener {
        void confirmListener();
    }

    public interface OnShowPolicyUpdateDialogListener {
        void onAction();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SceneOfPolicy {
        public static final int FromHomePage = 1;
        public static final int FromSuperApp = 2;
    }

    private HomePolicyHelper() {
        this.mPolicyDialogNeedShow = true;
        this.f45210c = false;
    }

    private static class HomePolicyHelperHolder {
        /* access modifiers changed from: private */
        public static final HomePolicyHelper mHomePolicyHelper = new HomePolicyHelper();

        private HomePolicyHelperHolder() {
        }
    }

    public static HomePolicyHelper getInstance() {
        return HomePolicyHelperHolder.mHomePolicyHelper;
    }

    public HomePolicyHelper updatePolicyConfig(DialogInstrument dialogInstrument, int i) {
        resetPolicyConfig();
        this.f45209b = dialogInstrument;
        this.f45213f = i;
        return this;
    }

    public boolean needShowPolicyDialog() {
        boolean z = m33549a() || m33552b();
        this.mPolicyDialogNeedShow = false;
        return z;
    }

    public void checkReShowPolicyDialog() {
        if (2 == this.f45213f) {
            needShowPolicyDialog();
        }
    }

    public void resetPolicyConfig() {
        this.mPolicyDialogNeedShow = true;
        this.f45210c = false;
    }

    /* renamed from: a */
    private boolean m33549a() {
        if (!this.mPolicyDialogNeedShow || ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mHomePolicyAccepted) {
            return false;
        }
        m33553c();
        return true;
    }

    /* renamed from: b */
    private boolean m33552b() {
        if (!this.mPolicyDialogNeedShow) {
            return false;
        }
        PrivacyContentEntity data = ((PrivacyContentStorage) SingletonFactory.get(PrivacyContentStorage.class)).getData();
        String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
        String countryCode = LocationUtil.getCountryCode();
        if (TextUtils.isEmpty(data.getUrl()) || !m33550a(data) || !TextUtils.equals(langTag, data.getLang()) || !TextUtils.equals(countryCode, data.getCountryCode())) {
            return false;
        }
        OnShowPolicyUpdateDialogListener onShowPolicyUpdateDialogListener = this.f45212e;
        if (onShowPolicyUpdateDialogListener != null) {
            onShowPolicyUpdateDialogListener.onAction();
            HomeOmegaHelper.getInstance().trackLawDialog(1);
        }
        this.mPolicyDialogNeedShow = false;
        return true;
    }

    /* renamed from: a */
    private boolean m33550a(PrivacyContentEntity privacyContentEntity) {
        try {
            if (TextUtils.isEmpty(privacyContentEntity.getVersion()) || TextUtils.isEmpty(privacyContentEntity.getAcceptedVersion())) {
                return false;
            }
            String[] split = privacyContentEntity.getVersion().split("\\.");
            String[] split2 = privacyContentEntity.getAcceptedVersion().split("\\.");
            if (split == null || split2 == null || split.length < 2 || split2.length < 2) {
                return false;
            }
            int compareTo = Integer.valueOf(split[0]).compareTo(Integer.valueOf(split2[0]));
            int compareTo2 = Integer.valueOf(split[1]).compareTo(Integer.valueOf(split2[1]));
            if (compareTo > 0 || (compareTo == 0 && compareTo2 > 0)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void savePolicyUpdateState() {
        PrivacyContentStorage privacyContentStorage = (PrivacyContentStorage) SingletonFactory.get(PrivacyContentStorage.class);
        PrivacyContentEntity data = privacyContentStorage.getData();
        if (!TextUtils.isEmpty(data.getVersion())) {
            data.setAcceptedVersion(data.getVersion());
            privacyContentStorage.setData(data);
        }
    }

    public void savePolicyAcceptedState() {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        if (!data.mHomePolicyAccepted) {
            data.mHomePolicyAccepted = true;
            appConfigStorage.setData(data);
        }
        savePolicyUpdateState();
    }

    public void setOnPolicyDialogClickListener(OnPolicyDialogClickListener onPolicyDialogClickListener) {
        this.f45211d = onPolicyDialogClickListener;
    }

    public void setOnShowPolicyUpdateDialogListener(OnShowPolicyUpdateDialogListener onShowPolicyUpdateDialogListener) {
        this.f45212e = onShowPolicyUpdateDialogListener;
    }

    /* renamed from: c */
    private void m33553c() {
        if (this.f45209b != null) {
            View inflate = LayoutInflater.from(GlobalContext.getContext()).inflate(R.layout.customer_item_law_check, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.customer_tv_law_item_link);
            textView.setText(ResourceHelper.getString(R.string.customer_check_law_title));
            ((TextView) inflate.findViewById(R.id.customer_tv_law_item_desc)).setText(ResourceHelper.getString(R.string.customer_check_law_desc, "99", "99"));
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomePolicyHelper.this.m33547a(view);
                }
            });
            $$Lambda$HomePolicyHelper$xTjKPinAqSKv6eUcGVJW2YGmsHg r8 = new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    HomePolicyHelper.this.m33551b(rFDialog);
                }
            };
            $$Lambda$HomePolicyHelper$kkZw3horEcPXjxIPVAa5kx_yJf0 r9 = new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    HomePolicyHelper.this.m33548a(rFDialog);
                }
            };
            if (!this.f45210c) {
                this.f45214g = DialogUtil.showCheckLawDialog(this.f45209b, f45208a, R.string.customer_check_law_title, inflate, r8, r9);
                this.f45210c = true;
                this.mPolicyDialogNeedShow = false;
                HomeOmegaHelper.getInstance().trackLawDialog(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33547a(View view) {
        if (this.f45213f == 2) {
            DiRouter.request().path("webPage").putBoolean(Const.PageParams.POLICY_DETAIL_PAGE, true).putString("url", CustomerH5UrlConst.getLawUrl()).open();
            Dialog dialog = this.f45214g;
            if (dialog != null) {
                dialog.dismiss();
                this.mPolicyDialogNeedShow = true;
                this.f45210c = false;
            }
        } else {
            DiRouter.request().path("webPage").putString("url", CustomerH5UrlConst.getLawUrl()).putBoolean(Const.PageParams.POLICY_DETAIL_PAGE, true).open();
        }
        HomeOmegaHelper.getInstance().trackLawDialogPolicyClick(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33551b(RFDialog rFDialog) {
        rFDialog.dismiss();
        this.f45210c = false;
        HomeOmegaHelper.getInstance().trackLawDialogClick(true, 0);
        savePolicyAcceptedState();
        OnPolicyDialogClickListener onPolicyDialogClickListener = this.f45211d;
        if (onPolicyDialogClickListener != null) {
            onPolicyDialogClickListener.confirmListener();
        }
        CustomerPushReport.getInstance().noticeMessageFcmParam(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33548a(RFDialog rFDialog) {
        HomeOmegaHelper.getInstance().trackLawDialogClick(false, 0);
        CustomerPushReport.getInstance().noticeMessageFcmParam(false);
        if (!GlobalContext.isEmbed()) {
            ToastUtil.showCustomerToast(GlobalContext.getPageInstrument().getRootPage().getScopeContext(), ResourceHelper.getString(R.string.customer_check_law_warn));
        } else if (this.f45213f == 2) {
            ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popBackStack();
        } else {
            ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).switchToRiderTab();
        }
    }
}
