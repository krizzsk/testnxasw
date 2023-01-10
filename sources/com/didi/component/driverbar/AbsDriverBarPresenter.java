package com.didi.component.driverbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.core.model.response.DTSDKCarModel;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.Preconditions;

public abstract class AbsDriverBarPresenter extends BaseExpressPresenter<IDriverBarView> implements IViewContainer {
    public static final int BUTTON_CONTROL_BIT_INDEX_PHONE = 6;

    /* renamed from: a */
    private IComponent f14754a;

    /* renamed from: b */
    private IComponent f14755b;

    /* renamed from: c */
    private String f14756c;

    /* renamed from: d */
    private String f14757d;

    /* renamed from: e */
    private String f14758e;

    /* renamed from: f */
    private Bundle f14759f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14760g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsDriverBarPresenter.this.m12170b();
        }
    };

    /* renamed from: h */
    private boolean f14761h;
    protected IViewContainer.IComponentCreator mComponentCreator;

    public void bluetoothMeetClick() {
    }

    /* access modifiers changed from: protected */
    public abstract void buildDriverCarInfo(DTSDKDriverModel dTSDKDriverModel, DTSDKCarModel dTSDKCarModel);

    /* access modifiers changed from: protected */
    public abstract String getIMGuideText();

    /* access modifiers changed from: protected */
    public String getPhoneGuideText() {
        return "";
    }

    public void nearPickUpSwitch() {
    }

    public AbsDriverBarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Phone.EVENT_PHONE_SECURITY_NOTIFY, this.f14760g);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Phone.EVENT_PHONE_SECURITY_NOTIFY, this.f14760g);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }

    public void buildInnerComponent() {
        if (this.mComponentCreator != null) {
            Bundle bundle = getBundle();
            IComponent iComponent = this.f14754a;
            if (iComponent != null) {
                this.mComponentCreator.removeComponent(iComponent);
            }
            this.f14754a = m12168a(ComponentType.IM_ENTRANCE, ((IDriverBarView) this.mView).getContainer(1), bundle);
            IComponent iComponent2 = this.f14755b;
            if (iComponent2 != null) {
                this.mComponentCreator.removeComponent(iComponent2);
            }
            this.f14755b = m12168a(ComponentType.PHONE_ENTRANCE, ((IDriverBarView) this.mView).getContainer(2), bundle);
        }
    }

    public void buildInnerComponent(String str, String str2, String str3) {
        buildInnerComponent(str, str2, str3, (Bundle) null);
    }

    public void buildInnerComponent(String str, String str2, String str3, Bundle bundle) {
        this.f14756c = str;
        this.f14757d = str2;
        this.f14758e = str3;
        this.f14759f = bundle;
        buildInnerComponent();
    }

    /* access modifiers changed from: protected */
    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("im_option", this.f14756c);
        bundle.putString("phone_option", this.f14757d);
        bundle.putString("source", this.f14758e);
        Bundle bundle2 = this.f14759f;
        if (Preconditions.nonNull(bundle2)) {
            bundle.putAll(bundle2);
        }
        this.f14759f = null;
        return bundle;
    }

    /* renamed from: a */
    private IComponent m12168a(String str, ViewGroup viewGroup, Bundle bundle) {
        IComponent newComponent = this.mComponentCreator.newComponent(str, viewGroup, bundle);
        View view = null;
        IView view2 = newComponent != null ? newComponent.getView() : null;
        if (view2 != null) {
            view = view2.getView();
        }
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) newComponent.getView().getView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            if (viewGroup != null) {
                viewGroup.addView(view, layoutParams);
            }
        }
        return newComponent;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12170b() {
        if (((IDriverBarView) this.mView).isPhoneVisible() && !this.f14761h) {
            boolean phoneHintFlag = GlobalSPUtil.getPhoneHintFlag(this.mContext);
            String phoneGuideText = getPhoneGuideText();
            if (phoneHintFlag && CarOrderHelper.isWaitDriver() && !TextUtil.isEmpty(phoneGuideText)) {
                ((IDriverBarView) this.mView).showPhoneGuide(phoneGuideText);
                GlobalSPUtil.setPhoneHintFlag(this.mContext, false);
            }
        }
    }

    public void onDriverHeaderClick(String str) {
        OmegaSDKAdapter.trackEvent("gp_ driverhead_ck");
        Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        this.mContext.startActivity(intent);
    }

    public void onBenefitTextClick(String str) {
        Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
        this.mContext.startActivity(intent);
    }
}
