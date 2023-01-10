package com.didi.component.bubbleLayout.impl;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.component.bubbleLayout.AbsBubbleLayoutPresenter;
import com.didi.component.bubbleLayout.IBubbleLayoutView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.bubbleLayout.view.BubbleAnimationLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.event.VerticalDataUpdateEvent;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.OmegaCommonParamsTrackUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.StartEndCardModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class BubbleLayoutPresenter extends AbsBubbleLayoutPresenter {

    /* renamed from: a */
    private static final String f12948a = "BubbleLayout";

    /* renamed from: b */
    private IViewContainer.IComponentCreator f12949b;

    /* renamed from: c */
    private BusinessContext f12950c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BubbleAnimationLayout f12951d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AnycarBubbleLayout f12952e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f12953f;

    /* renamed from: g */
    private View f12954g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public StartEndCardModel f12955h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Logger f12956i = LoggerFactory.getLogger(f12948a);

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12957j = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.hideAndShow();
            } else if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                BubbleLayoutPresenter.this.m10933d();
            } else if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                BubbleLayoutPresenter.this.m10935e();
            } else if (BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.refreshBestView();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.hideBottomCard();
                BubbleLayoutPresenter.this.f12951d.setBottomCardHeight(0);
            } else if (BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.showBottomCard();
                BubbleLayoutPresenter.this.m10941h();
                BubbleLayoutPresenter.this.m10935e();
                BubbleLayoutPresenter.this.doPublish(BaseEventKeys.DDMirror.EVENT_MSG_ESTIMATE_COMPONENT_SHOWN);
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.scrollToTop();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.scrollToBottom();
            } else if (BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM.equals(str)) {
                BubbleLayoutPresenter.this.f12951d.hideBottomCard();
                BubbleLayoutPresenter.this.m10943i();
            } else if (BaseEventKeys.Estimate.ESTIMATE_IS_LOADING.equals(str)) {
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null && confirmListener.isConfirmAddressPage() && confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f12956i.info("anycar ESTIMATE_IS_LOADING current page is confirmaddrss", new Object[0]);
                } else if (BubbleLayoutPresenter.this.f12952e != null) {
                    BubbleLayoutPresenter.this.f12952e.setVisibility(0);
                    BubbleLayoutPresenter.this.f12952e.showLoading();
                }
            }
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12958k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            BubbleLayoutPresenter.this.f12952e.handleMsg();
            BubbleLayoutPresenter.this.f12952e.updatePreferenceStatus(true);
            BubbleLayoutPresenter.this.f12952e.updateSwipeTips(false);
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Boolean> f12959l = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE.equals(str)) {
                Logger f = BubbleLayoutPresenter.this.f12956i;
                f.info("ANYCAR_EYEBALL_RESPONSE  result =" + bool, new Object[0]);
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener == null || !confirmListener.isConfirmAddressPage() || !confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f12951d.hideViewByAnycar();
                    if (BubbleLayoutPresenter.this.f12952e != null) {
                        BubbleLayoutPresenter.this.f12952e.setVisibility(0);
                        if (bool.booleanValue()) {
                            BubbleLayoutPresenter.this.f12952e.showEstimateWithAnimation(false);
                            BubbleLayoutPresenter.this.f12952e.updatePreferenceData();
                            BubbleLayoutPresenter.this.f12952e.handleMsg();
                            BubbleLayoutPresenter.this.f12952e.handleAbnormal(false);
                            return;
                        }
                        BubbleLayoutPresenter.this.f12952e.handleAbnormal(true);
                        return;
                    }
                    return;
                }
                BubbleLayoutPresenter.this.hideLoading();
                BubbleLayoutPresenter.this.f12956i.info(" ANYCAR_EYEBALL_RESPONSE current page is confirmaddrss", new Object[0]);
            } else if (BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT.equals(str)) {
                Logger f2 = BubbleLayoutPresenter.this.f12956i;
                f2.info("NEW_ESTIMATE_RESULT  result =" + bool, new Object[0]);
                BubbleLayoutPresenter.this.hideLoading();
                if (BubbleLayoutPresenter.this.f12952e != null && bool.booleanValue()) {
                    BubbleLayoutPresenter.this.f12952e.setVisibility(8);
                    BubbleLayoutPresenter.this.f12951d.hideAnycarByOldEstimate();
                }
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12960m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            BubbleLayoutPresenter.this.f12951d.hideViewByAnycar();
            BubbleLayoutPresenter.this.f12952e.updateAbnormal((EstimateAbnormalModel) null);
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener<EstimateAbnormalModel> f12961n = new BaseEventPublisher.OnEventListener<EstimateAbnormalModel>() {
        public void onEvent(String str, EstimateAbnormalModel estimateAbnormalModel) {
            BubbleLayoutPresenter.this.f12951d.hideViewByAnycar();
            BubbleLayoutPresenter.this.f12952e.updateAbnormal(estimateAbnormalModel);
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<VerticalDataUpdateEvent> f12962p = new BaseEventPublisher.OnEventListener<VerticalDataUpdateEvent>() {
        public void onEvent(String str, VerticalDataUpdateEvent verticalDataUpdateEvent) {
            if (BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE.equals(str)) {
                GLog.m11354d(BubbleLayoutPresenter.f12948a, "EVENT_VERTICAL_DATA_UPDATE offsetY: " + verticalDataUpdateEvent.offsetY);
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener == null || !confirmListener.isConfirmAddressPage() || !confirmListener.getIsAnyCar()) {
                    BubbleLayoutPresenter.this.f12951d.setTopOffsetY(verticalDataUpdateEvent.offsetY);
                    BubbleLayoutPresenter.this.f12951d.setCanPullUp(verticalDataUpdateEvent.canPullUp);
                    if (verticalDataUpdateEvent.bottomOffsetY > 0) {
                        BubbleLayoutPresenter.this.f12951d.setBottomCardHeight(verticalDataUpdateEvent.bottomOffsetY);
                    }
                    boolean unused = BubbleLayoutPresenter.this.f12953f = true;
                    if (verticalDataUpdateEvent.isShowAnimation) {
                        BubbleLayoutPresenter.this.f12951d.showEstimatePage();
                        return;
                    }
                    return;
                }
                BubbleLayoutPresenter.this.f12956i.info("EVENT_VERTICAL_DATA_UPDATE current page is confirmaddrss", new Object[0]);
            }
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<StartEndCardModel> f12963q = new BaseEventPublisher.OnEventListener<StartEndCardModel>() {
        public void onEvent(String str, StartEndCardModel startEndCardModel) {
            StartEndCardModel unused = BubbleLayoutPresenter.this.f12955h = startEndCardModel;
            GLog.m11354d("lxsminibus", "startEndCardModel");
        }
    };

    public BubbleLayoutPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f12950c = componentParams.bizCtx;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f12949b = iComponentCreator;
        this.f12951d = (BubbleAnimationLayout) ((IBubbleLayoutView) this.mView).getView();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m10929b();
        m10940g();
        m10927a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* renamed from: a */
    private void m10927a(Bundle bundle) {
        if (bundle == null || !bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false)) {
            m10935e();
        } else {
            m10933d();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m10931c();
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage((String) null);
    }

    /* renamed from: b */
    private void m10929b() {
        subscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, this.f12962p);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f12957j);
        subscribe("event_confirm_boarding_enable_city", this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM, this.f12957j);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f12963q);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f12957j);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f12959l);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f12959l);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f12958k);
        subscribe(BaseEventKeys.AnyCar.ESTIMATE_ABNORMAL_TRANSFER_ANYCAR, this.f12961n);
        subscribe(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR, this.f12960m);
    }

    /* renamed from: c */
    private void m10931c() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, this.f12962p);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_HIDE_ANIMATION, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f12957j);
        unsubscribe("event_confirm_boarding_enable_city", this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_PAGE_SUB_TITLE_SHOWED, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM, this.f12957j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_START_END, this.f12963q);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f12957j);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f12959l);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f12959l);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f12958k);
        unsubscribe(BaseEventKeys.AnyCar.ESTIMATE_ABNORMAL_TRANSFER_ANYCAR, this.f12961n);
        unsubscribe(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR, this.f12960m);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10933d() {
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage(GPageIdConstant.G_PAGE_ID_PICONF);
        if (!GPageIdConstant.G_PAGE_ID_PICONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        }
        m10945k();
        this.f12951d.showConfirmAddressPage();
        doPublish(BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10935e() {
        if (!this.f12953f) {
            SystemUtils.log(3, f12948a, "switchToEstimatePage: post", (Throwable) null, "com.didi.component.bubbleLayout.impl.BubbleLayoutPresenter", 319);
            this.f12951d.post(new Runnable() {
                public void run() {
                    BubbleLayoutPresenter.this.m10938f();
                }
            });
        } else {
            SystemUtils.log(3, f12948a, "switchToEstimatePage: direct perform", (Throwable) null, "com.didi.component.bubbleLayout.impl.BubbleLayoutPresenter", 327);
            m10938f();
        }
        OmegaCommonParamsTrackUtil.setCurrentStateInConfirmPage(GPageIdConstant.G_PAGE_ID_CONF);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10938f() {
        m10944j();
        this.f12951d.showEstimatePage();
        doPublish(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN);
    }

    /* renamed from: g */
    private void m10940g() {
        if (this.f12949b != null) {
            this.f12951d.removeAllViews();
            m10941h();
            this.f12951d.bindView(m10924a("estimate", this.f12951d, (Bundle) null), m10924a(ComponentType.GROUP_FORM_CONTAINER, this.f12951d, (Bundle) null), m10924a(ComponentType.CONFIRM_BROADING_POINT, this.f12951d, (Bundle) null), (View) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AnycarBubbleLayout anycarBubbleLayout = this.f12952e;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.removeAllViews();
            }
            AnycarBubbleLayout anycarBubbleLayout2 = new AnycarBubbleLayout(this.mContext);
            this.f12952e = anycarBubbleLayout2;
            this.f12951d.addView(anycarBubbleLayout2, layoutParams);
            this.f12951d.bindAnycarView(this.f12952e);
            this.f12952e.bindView(m10924a(ComponentType.ANYCAR_LIST, this.f12952e.getContentView(), (Bundle) null), m10924a(ComponentType.ANYCAR_GROUP_FORM_CONTAINER, this.f12952e.getFormContentView(), (Bundle) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10941h() {
        View view = this.f12954g;
        if (view == null) {
            View view2 = new View(this.mContext);
            this.f12954g = view2;
            view2.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UiUtils.dip2px(this.mContext, 84.0f));
            layoutParams.addRule(12);
            this.f12951d.addView(this.f12954g, layoutParams);
            return;
        }
        view.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m10943i() {
        View view = this.f12954g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private View m10924a(String str, ViewGroup viewGroup, Bundle bundle) {
        IComponent newComponent = this.f12949b.newComponent(str, viewGroup, bundle);
        RelativeLayout.LayoutParams layoutParams = null;
        if (newComponent == null || newComponent.getView() == null || newComponent.getView().getView() == null) {
            return null;
        }
        if (newComponent.getView().getView().getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) newComponent.getView().getView().getLayoutParams();
        }
        if (newComponent.getView().getView().getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) newComponent.getView().getView().getLayoutParams();
            layoutParams2.weight = -1.0f;
            viewGroup.addView(newComponent.getView().getView(), layoutParams2);
        } else {
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if ("estimate".equals(str)) {
                layoutParams.topMargin = UiUtils.getStatusBarHeight(this.mContext);
            } else {
                layoutParams.addRule(12);
            }
            viewGroup.addView(newComponent.getView().getView(), layoutParams);
        }
        return newComponent.getView().getView();
    }

    /* renamed from: j */
    private void m10944j() {
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        HashMap hashMap = new HashMap();
        Address startAddress = FormStore.getInstance().getDepartureAddress() == null ? FormStore.getInstance().getStartAddress() : FormStore.getInstance().getDepartureAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        String str = "";
        if (startAddress != null) {
            hashMap.put("from_poi_id", startAddress.poiId == null ? str : startAddress.poiId);
            hashMap.put("from_lng", Double.valueOf(startAddress.getLongitude()));
            hashMap.put("from_lat", Double.valueOf(startAddress.getLatitude()));
            hashMap.put("from_search_id", startAddress.searchId == null ? str : startAddress.searchId);
            hashMap.put("from_srctag", startAddress.getSrcTag() == null ? str : startAddress.getSrcTag());
        }
        if (endAddress != null) {
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId == null ? str : endAddress.poiId);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
            hashMap.put("to_search_id", endAddress.searchId == null ? str : endAddress.searchId);
            if (endAddress.getSrcTag() != null) {
                str = endAddress.getSrcTag();
            }
            hashMap.put("to_srctag", str);
        }
        SceneHelper instance = SceneHelper.getInstance();
        if (!instance.isFromPickupPoint() && !instance.isOrderIntercepted()) {
            hashMap.put("scene", "AA");
            hashMap.put("rider", Integer.valueOf(FormStore.getInstance().getSeatCount()));
            instance.traceBubbleEventIfNeed(this.mContext, hashMap);
        }
        if (FormStore.getInstance().isFromOpenRide()) {
            GlobalOmegaUtils.trackEvent("Pas_99GO_orderconfirm_sw", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: k */
    private void m10945k() {
        String str;
        double d;
        double d2;
        Address departureAddress = FormStore.getInstance().getDepartureAddress();
        if (departureAddress == null) {
            departureAddress = FormStore.getInstance().getStartAddress();
        }
        if (departureAddress == null) {
            str = LocationController.getInstance().getReverseDisplayName();
        } else {
            str = departureAddress.getDisplayName();
        }
        if (departureAddress != null) {
            d2 = departureAddress.getLatitude();
            d = departureAddress.getLongitude();
        } else {
            d2 = LocationController.getInstance().getLat(this.mContext);
            d = LocationController.getInstance().getLng(this.mContext);
        }
        HashMap hashMap = new HashMap();
        SceneHelper instance = SceneHelper.getInstance();
        instance.setFromPickupPoint(true);
        instance.setFromPickupPoARA(true);
        hashMap.put("scene", "AA");
        hashMap.put("addr", str);
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        String str2 = "";
        if (departureAddress != null) {
            hashMap.put("from_poi_id", departureAddress.poiId == null ? str2 : departureAddress.poiId);
            hashMap.put("from_lng", Double.valueOf(departureAddress.getLongitude()));
            hashMap.put("from_lat", Double.valueOf(departureAddress.getLatitude()));
        }
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (endAddress != null) {
            if (endAddress.poiId != null) {
                str2 = endAddress.poiId;
            }
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, str2);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
        }
        instance.setParamsAFA(hashMap);
        instance.setParamsABA(hashMap);
        hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
        StartEndCardModel startEndCardModel = this.f12955h;
        if (startEndCardModel != null && !CollectionUtils.isEmpty((Map) startEndCardModel.extraLogData)) {
            hashMap.putAll(this.f12955h.extraLogData);
        }
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        GlobalOmegaUtils.trackEvent("pas_pickupconfirm_sw", (Map<String, Object>) hashMap);
        this.f12955h = null;
        GLog.m11354d("lxsminibus", "trackPickUpConfirmShowEvent");
    }
}
