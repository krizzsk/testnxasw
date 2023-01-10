package com.didi.component.comp_recommend_boarding_point.present;

import android.os.Bundle;
import android.os.CountDownTimer;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_recommend_boarding_point.AbsRecommendBoardingPointPresent;
import com.didi.component.comp_recommend_boarding_point.view.RecommendBoardingPointView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.SPUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;

public class RecommendBoardingPointPresent extends AbsRecommendBoardingPointPresent<RecommendBoardingPointView> implements IXpCardBindDataReady, IXpCardLifeCycle {

    /* renamed from: a */
    private static final String f14197a = "RecommendBoardingPointPresent";

    /* renamed from: b */
    private String f14198b;

    /* renamed from: c */
    private String f14199c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f14200d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SecRouteInfoEx f14201e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f14202f;

    /* renamed from: g */
    private boolean f14203g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f14204h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f14205i;

    /* renamed from: j */
    private int f14206j;

    /* renamed from: k */
    private int f14207k;

    /* renamed from: l */
    private CountDownTimer f14208l;

    /* renamed from: m */
    private PickupPoint f14209m;

    /* renamed from: n */
    private final BaseEventPublisher.OnEventListener<SecRouteInfoEx> f14210n = new BaseEventPublisher.OnEventListener<SecRouteInfoEx>() {
        public void onEvent(String str, SecRouteInfoEx secRouteInfoEx) {
            GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onEvent:mRecommendBoardingPointShowEventListener mViewBind " + RecommendBoardingPointPresent.this.f14202f);
            if (!RecommendBoardingPointPresent.this.f14204h) {
                SecRouteInfoEx unused = RecommendBoardingPointPresent.this.f14201e = secRouteInfoEx;
                SPUtils.put(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", secRouteInfoEx.getCurPPGrtMsg());
                SPUtils.put(RecommendBoardingPointPresent.this.mContext, "CantChgMsg", secRouteInfoEx.getCantChgMsg());
                if (RecommendBoardingPointPresent.this.f14202f) {
                    RecommendBoardingPointPresent.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
                }
                if (!GlobalApolloUtil.isShowNotify() || secRouteInfoEx == null || TextUtil.isEmpty(secRouteInfoEx.getMainTitle()) || TextUtil.isEmpty(secRouteInfoEx.getSubTitle())) {
                    GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onEvent: title or subtitle is null");
                    return;
                }
                GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onEvent: showNotification");
                GlobalRichInfo globalRichInfo = new GlobalRichInfo();
                globalRichInfo.setInfo(secRouteInfoEx.getMainTitle());
                String content = globalRichInfo.getContent();
                GlobalRichInfo globalRichInfo2 = new GlobalRichInfo();
                globalRichInfo2.setInfo(secRouteInfoEx.getSubTitle());
                NotificationUtils.getInstance(DIDIApplication.getAppContext()).showNotification(1114, content, globalRichInfo2.getContent(), true, false, false, (String) null);
            }
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14211p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onEvent:mHideCardListener " + RecommendBoardingPointPresent.this.f14204h);
            if (RecommendBoardingPointPresent.this.f14204h) {
                int unused = RecommendBoardingPointPresent.this.f14205i = 3;
                RecommendBoardingPointPresent.this.m11781c();
            }
        }
    };

    /* renamed from: q */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14212q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (SPUtils.get(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", "") != null) {
                String str2 = (String) SPUtils.get(RecommendBoardingPointPresent.this.mContext, "CurPPGrtMsg", "");
                if (!TextUtil.isEmpty(str2)) {
                    LEGOToastHelper.showShortToast(RecommendBoardingPointPresent.this.mContext, str2, R.drawable.common_toast_icon_failure);
                } else {
                    GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onEvent: secRouteInfoEx.getCurPPGrtMsg() is null");
                }
            }
        }
    };

    /* renamed from: r */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14213r = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (RecommendBoardingPointPresent.this.f14204h) {
                RecommendBoardingPointPresent.this.m11777b();
            }
        }
    };

    /* renamed from: j */
    static /* synthetic */ int m11791j(RecommendBoardingPointPresent recommendBoardingPointPresent) {
        int i = recommendBoardingPointPresent.f14200d;
        recommendBoardingPointPresent.f14200d = i - 1;
        return i;
    }

    public RecommendBoardingPointPresent(ComponentParams componentParams) {
        super(componentParams.bizCtx.getContext());
        GLog.m11357e(f14197a, "RecommendBoardingPointPresent: ");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        GLog.m11357e(f14197a, "onAdd: ");
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW, this.f14210n);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_HIDE, this.f14211p);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14213r);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW_TOAST, this.f14212q);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11777b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return;
        }
        if (order.status == 4 || order.status == 1) {
            int i = order.substatus;
            if (i == 4003 || i == 4004 || i == 4007) {
                this.f14205i = 4;
                m11781c();
                String str = (String) SPUtils.get(this.mContext, "CantChgMsg", "");
                if (!TextUtil.isEmpty(str)) {
                    LEGOToastHelper.showShortToast(this.mContext, str, R.drawable.common_toast_icon_failure);
                }
            }
        }
    }

    /* renamed from: a */
    private void m11770a(SecRouteInfoEx secRouteInfoEx) {
        this.f14209m = secRouteInfoEx.getPickupPoint();
        this.f14200d = secRouteInfoEx.getRouteTerm();
        this.f14198b = secRouteInfoEx.getChgSuccMsg();
        this.f14199c = secRouteInfoEx.getCantChgMsg();
        String mainTitle = secRouteInfoEx.getMainTitle();
        String subTitle = secRouteInfoEx.getSubTitle();
        String useMsg = secRouteInfoEx.getUseMsg();
        ((RecommendBoardingPointView) this.mView).setTitle(mainTitle);
        ((RecommendBoardingPointView) this.mView).setContent(subTitle);
        ((RecommendBoardingPointView) this.mView).setButtonText(useMsg);
        this.f14206j = secRouteInfoEx.getBubType();
        final String ignMsg = secRouteInfoEx.getIgnMsg();
        m11784d();
        C56865 r1 = new CountDownTimer((long) (this.f14200d * 1000), 1000) {
            public void onFinish() {
            }

            public void onTick(long j) {
                String str;
                RecommendBoardingPointPresent.m11791j(RecommendBoardingPointPresent.this);
                if (!TextUtil.isEmpty(ignMsg)) {
                    str = ignMsg + "(" + RecommendBoardingPointPresent.this.f14200d + "s)";
                } else {
                    GLog.m11359i("RecommendBoardingPointPresentbindData>> getIgnMsg is null");
                    str = "(" + RecommendBoardingPointPresent.this.f14200d + "s)";
                }
                if (RecommendBoardingPointPresent.this.f14200d > 0) {
                    ((RecommendBoardingPointView) RecommendBoardingPointPresent.this.mView).setTime(str);
                } else {
                    ((RecommendBoardingPointView) RecommendBoardingPointPresent.this.mView).setTime("");
                }
                if (RecommendBoardingPointPresent.this.f14200d < 1 && RecommendBoardingPointPresent.this.f14204h) {
                    int unused = RecommendBoardingPointPresent.this.f14205i = 1;
                    GLog.m11354d(RecommendBoardingPointPresent.f14197a, "onTick mRouteTerm<1");
                    RecommendBoardingPointPresent.this.m11773a(false);
                }
            }
        };
        this.f14208l = r1;
        r1.start();
    }

    public void cardUseDismissClick(boolean z) {
        PickupPoint pickupPoint;
        this.f14205i = 2;
        if (!z || (pickupPoint = this.f14209m) == null) {
            m11773a(false);
        } else {
            m11771a(pickupPoint);
        }
        m11784d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11773a(boolean z) {
        m11782c(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11781c() {
        m11782c(false);
    }

    /* renamed from: b */
    private void m11778b(boolean z) {
        String str;
        int i;
        if (z) {
            str = this.f14198b;
            i = R.drawable.common_toast_icon_success;
        } else {
            str = this.f14199c;
            i = R.drawable.common_toast_icon_failure;
        }
        if (!TextUtil.isEmpty(str)) {
            LEGOToastHelper.showShortToast(this.mContext, str, i);
        }
    }

    /* renamed from: a */
    private void m11771a(PickupPoint pickupPoint) {
        GLog.m11357e(f14197a, "updateAddress: ");
        final Address b = m11776b(pickupPoint);
        final CarOrder order = CarOrderHelper.getOrder();
        if (order == null || TextUtil.isEmpty(order.oid)) {
            GLog.m11354d("updateAddress", "route is null");
            return;
        }
        final LatLng latLng = new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue());
        CarRequest.updatePickUp(this.mContext, order.oid, b, new ResponseListener<BaseObject>() {
            public void onSuccess(BaseObject baseObject) {
                super.onSuccess(baseObject);
                GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onSuccess: ");
                order.showUpdatePickUpPop = false;
                order.startAddress = b;
                RecommendBoardingPointPresent.this.doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_UPDATE_ADDRESS, latLng);
                RecommendBoardingPointPresent.this.doPublish("event_sctx_state_change");
                RecommendBoardingPointPresent.this.m11774a(true, order.oid);
            }

            public void onError(BaseObject baseObject) {
                super.onError(baseObject);
                GLog.m11353d("onError: " + baseObject.toString());
                GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onError: ");
                RecommendBoardingPointPresent.this.m11774a(false, order.oid);
            }

            public void onFail(BaseObject baseObject) {
                super.onFail(baseObject);
                GLog.m11353d("onError: " + baseObject.toString());
                GLog.m11357e(RecommendBoardingPointPresent.f14197a, "onFail: ");
                RecommendBoardingPointPresent.this.m11774a(false, order.oid);
            }

            public void onFinish(BaseObject baseObject) {
                super.onFinish(baseObject);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11774a(boolean z, String str) {
        if (z) {
            this.f14207k = 1;
            m11773a(true);
        } else {
            this.f14207k = 0;
            m11782c(false);
        }
        m11772a(str);
        m11778b(z);
    }

    /* renamed from: b */
    private Address m11776b(PickupPoint pickupPoint) {
        Address address = new Address();
        address.latitude = pickupPoint.lat.doubleValue();
        address.longitude = pickupPoint.lng.doubleValue();
        address.displayName = pickupPoint.displayName;
        address.address = pickupPoint.address;
        address.fullName = pickupPoint.fullName;
        address.poiId = pickupPoint.poiId;
        address.srcTag = pickupPoint.srcTag;
        return address;
    }

    /* renamed from: c */
    private void m11782c(boolean z) {
        this.f14203g = true;
        ((RecommendBoardingPointView) this.mView).hideView();
        if (this.f14204h) {
            m11785d(false);
        }
        this.f14204h = false;
        doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NEW);
        if (!z) {
            GLog.m11354d(f14197a, "hideCard unClick");
            doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_DISMISS);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        GLog.m11357e(f14197a, "onRemove: ");
        super.onRemove();
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW, this.f14210n);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_HIDE, this.f14211p);
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14213r);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW_TOAST, this.f14212q);
        m11784d();
        if (this.f14204h) {
            m11782c(false);
        }
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        GLog.m11357e(f14197a, "viewBindBizDataReady:mIsHideCard " + this.f14203g);
        if (this.f14203g) {
            iXpCardBindDataReadyCallback.ready(false);
            this.f14204h = false;
            return;
        }
        SecRouteInfoEx secRouteInfoEx = this.f14201e;
        if (secRouteInfoEx == null) {
            iXpCardBindDataReadyCallback.ready(false);
            this.f14204h = false;
        } else {
            m11770a(secRouteInfoEx);
            iXpCardBindDataReadyCallback.ready(true);
            this.f14204h = true;
        }
        this.f14202f = true;
    }

    public void onCardAdd() {
        GLog.m11357e(f14197a, "onCardAdd: ");
        m11785d(true);
    }

    public void onCardRemove() {
        GLog.m11357e(f14197a, "onCardRemove: ");
        m11784d();
    }

    /* renamed from: d */
    private void m11785d(boolean z) {
        String str;
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        hashMap.put("g_OrderId", (order == null || TextUtil.isEmpty(order.oid)) ? "" : order.oid);
        if (z) {
            hashMap.put("k", "show");
            hashMap.put(RavenKey.VERSION, Const.ComponentType.BANNER);
            str = "ibt_gp_tbd_sw";
        } else {
            hashMap.put("k", "click");
            hashMap.put(RavenKey.VERSION, "dismiss");
            hashMap.put("style", Integer.valueOf(this.f14205i));
            str = "ibt_gp_tbd_ck";
        }
        hashMap.put("type", Integer.valueOf(this.f14206j));
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "tbd_banner");
        hashMap.put("pretab", "pick");
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m11772a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("g_OrderId", str);
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "tochange");
        hashMap.put("type", Integer.valueOf(this.f14206j));
        hashMap.put("style", Integer.valueOf(this.f14207k));
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "tbd_banner");
        hashMap.put("pretab", "pick");
        GlobalOmegaUtils.trackEvent("ibt_gp_tbd_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: d */
    private void m11784d() {
        CountDownTimer countDownTimer = this.f14208l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f14208l = null;
        }
    }
}
