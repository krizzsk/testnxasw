package com.didi.component.openride;

import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.BaseDeepLinkEvent;
import com.didi.component.business.event.OpenRideDeepLinkEvent;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.openride.newscan.GlobalQRScanActivity;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.PayMethodInfoResult;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.unifylogin.api.OneLoginFacade;
import com.taxis99.R;

public abstract class AbsNewOpenRidePresenter extends BaseExpressPresenter<INewOpenRideView> {

    /* renamed from: a */
    private static final int f16555a = 100;

    /* renamed from: c */
    private static final int f16556c = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f16557b;

    /* renamed from: d */
    private int f16558d = -1;
    protected BaseEventPublisher.OnEventListener<BaseDeepLinkEvent> mDeepLinkReceiver = new BaseEventPublisher.OnEventListener<BaseDeepLinkEvent>() {
        public void onEvent(String str, BaseDeepLinkEvent baseDeepLinkEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            if (baseDeepLinkEvent != null && (baseDeepLinkEvent instanceof OpenRideDeepLinkEvent)) {
                AbsNewOpenRidePresenter.this.checkOpenRideAvailable();
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<PayMethodInfoResult> mShowListener = new BaseEventPublisher.OnEventListener<PayMethodInfoResult>() {
        public void onEvent(String str, PayMethodInfoResult payMethodInfoResult) {
            FormStore.getInstance().setOpenRideHasOnlinePayAbility(payMethodInfoResult.checkResult);
            FormStore.getInstance().setOpenRideBrand(payMethodInfoResult.openRideBrand);
            AbsNewOpenRidePresenter.this.onOpenRideEntranceClick();
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowSugPageListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE.equals(str)) {
                AbsNewOpenRidePresenter.this.m13911d();
            }
        }
    };

    public abstract void onOpenRideEntranceClick();

    public AbsNewOpenRidePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, this.mDeepLinkReceiver);
        subscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.mShowSugPageListener);
        subscribe(BaseEventKeys.OpenRide.EVENT_SHOW_OPEN_RIDE, this.mShowListener);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        unsubscribe(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, this.mDeepLinkReceiver);
        unsubscribe(BaseEventKeys.OpenRide.EVENT_OPEN_RIDE_SHOW_SUG_PAGE, this.mShowSugPageListener);
        unsubscribe(BaseEventKeys.OpenRide.EVENT_SHOW_OPEN_RIDE, this.mShowListener);
        super.onRemove();
    }

    public void setVisible(boolean z) {
        ((INewOpenRideView) this.mView).setVisible(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13904a(PayMethodInfoResult payMethodInfoResult) {
        if (payMethodInfoResult != null) {
            FormStore.getInstance().setOpenRideHasOnlinePayAbility(payMethodInfoResult.checkResult);
            FormStore.getInstance().setOpenRideBrand(payMethodInfoResult.openRideBrand);
            m13910c();
        }
    }

    public void addOnlineCreditCard() {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), requestCodeForHost(100), addCardParam);
    }

    /* renamed from: b */
    private void m13909b() {
        CarRequest.confirmPinCode(this.mContext, FormStore.getInstance().getDriverCode(), new ResponseListener<PinCodeInfoResult>() {
            public void onFinish(PinCodeInfoResult pinCodeInfoResult) {
            }

            public void onSuccess(PinCodeInfoResult pinCodeInfoResult) {
                FormStore.getInstance().setDriverInfo(pinCodeInfoResult);
                if (FormStore.getInstance().getOpenRideHasOnlinePayAbility() && !FormStore.getInstance().isOpenRideFromDeepLinkBindCardSuc()) {
                    AbsNewOpenRidePresenter absNewOpenRidePresenter = AbsNewOpenRidePresenter.this;
                    absNewOpenRidePresenter.startActivity(GlobalQRScanActivity.getIntent(absNewOpenRidePresenter.mContext));
                }
            }

            public void onError(PinCodeInfoResult pinCodeInfoResult) {
                AbsNewOpenRidePresenter.this.m13905a(pinCodeInfoResult);
            }

            public void onFail(PinCodeInfoResult pinCodeInfoResult) {
                AbsNewOpenRidePresenter.this.m13905a(pinCodeInfoResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13905a(PinCodeInfoResult pinCodeInfoResult) {
        if (pinCodeInfoResult != null && !pinCodeInfoResult.isAvailable()) {
            if (pinCodeInfoResult.errno == -1) {
                ToastHelper.showShortInfo(this.mContext, this.mContext.getString(R.string.global_open_ride_net_error), (int) R.drawable.global_toast_error);
            } else {
                ToastHelper.showShortInfo(this.mContext, pinCodeInfoResult.errmsg, (int) R.drawable.global_toast_error);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                FormStore.getInstance().setIsOpenRideFromDeepLinkBindCardSuc(true);
                startActivity(GlobalQRScanActivity.getIntent(this.mContext));
                return;
            }
            if (FormStore.getInstance().isOpenRideFromDeepLink()) {
                FormStore.getInstance().setIsOpenRideFromDeepLink(false);
            }
            FormStore.getInstance().setIsFromOpenRide(false);
        }
    }

    /* access modifiers changed from: protected */
    public void checkOpenRideAvailable() {
        if (!this.f16557b) {
            int carWanliuUserType = BFFStore.getCarWanliuUserType(this.mContext);
            this.f16557b = true;
            CarRequest.checkOpenRide(this.mContext, 1, 0, carWanliuUserType, new ResponseListener<PayMethodInfoResult>() {
                public void onError(PayMethodInfoResult payMethodInfoResult) {
                }

                public void onFail(PayMethodInfoResult payMethodInfoResult) {
                }

                public void onSuccess(PayMethodInfoResult payMethodInfoResult) {
                    AbsNewOpenRidePresenter.this.m13904a(payMethodInfoResult);
                }

                public void onFinish(PayMethodInfoResult payMethodInfoResult) {
                    boolean unused = AbsNewOpenRidePresenter.this.f16557b = false;
                }
            });
        }
    }

    /* renamed from: c */
    private void m13910c() {
        if (!FormStore.getInstance().isOpenRideFromDeepLink()) {
            return;
        }
        if (FormStore.getInstance().getOpenRideHasOnlinePayAbility()) {
            m13909b();
            return;
        }
        m13909b();
        addOnlineCreditCard();
    }

    /* renamed from: a */
    private void m13906a(final boolean z) {
        if (this.f16558d != -1) {
            this.f16558d = z ? 1 : 0;
            return;
        }
        GlobalSPUtil.setOpenRideAvailable(this.mContext, z);
        UiThreadHandler.post(new Runnable() {
            public void run() {
                AbsNewOpenRidePresenter.this.setVisible(z);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void refreshOpenRideEntranceVisible() {
        if (GlobalSPUtil.isOpenRideAvailable(this.mContext)) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    AbsNewOpenRidePresenter.this.setVisible(true);
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m13911d() {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            doPublish(BaseEventKeys.Home.EVENT_SHOW_SUG_PAGE_FROM_NEW_OPEN_RIDE, 2);
        } else {
            OneLoginFacade.getAction().go2Login(this.mContext);
        }
    }

    public Animations getAnimations() {
        return new Animations(R.anim.bottom_in, 0, R.anim.bottom_out, 0);
    }
}
