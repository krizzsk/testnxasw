package com.didi.component.groupform.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BrazilCarTypeUtil;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.config.DynamicConfigManager;
import com.didi.component.common.pininput.PinInputActivity;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.groupform.view.IGroupFormView;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbsGroupFormPresenter extends BaseExpressPresenter<IGroupFormView> implements IViewContainer {
    public static final int REQUEST_CODE_PIN_INPUT = 101;
    public static final int REQUEST_CODE_REGULAR_TAXI_GUIDE = 100;

    /* renamed from: a */
    private final Logger f15886a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private boolean f15887b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<Boolean> f15888c = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str)) {
                ((IGroupFormView) AbsGroupFormPresenter.this.mView).setOptionViews(new ArrayList());
                ((IGroupFormView) AbsGroupFormPresenter.this.mView).setEnabled(AbsGroupFormPresenter.this.isActionfilter(bool.booleanValue()));
                AbsGroupFormPresenter.this.updateNewEstButtonText();
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15889d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                AbsGroupFormPresenter.this.updateButtonStatus();
                ((IGroupFormView) AbsGroupFormPresenter.this.mView).setEnabled(false);
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15890e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsGroupFormPresenter.this.m13194f();
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15891f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ((IGroupFormView) AbsGroupFormPresenter.this.mView).updateText();
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15892g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsGroupFormPresenter.this.handleTwoPriceSelectSeatConfirmEvent();
        }
    };

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15893h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsGroupFormPresenter.this.onConfirmPriceIntercept();
        }
    };
    protected BusinessContext mBusinessContext;
    protected IViewContainer.IComponentCreator mComponentCreator;
    protected ComponentParams mComponentParams;

    /* access modifiers changed from: protected */
    public int getMaxColCount() {
        return 3;
    }

    public boolean isActionfilter(boolean z) {
        return z;
    }

    public AbsGroupFormPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
        this.mBusinessContext = componentParams.bizCtx;
        BrazilCarTypeUtil.initOptionsApollo();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m13187b();
        m13194f();
        m13189c();
    }

    /* renamed from: b */
    private void m13187b() {
        ((IGroupFormView) this.mView).setMaxColCount(getMaxColCount());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        ((IGroupFormView) this.mView).onDestroy();
        m13190d();
    }

    /* renamed from: c */
    private void m13189c() {
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f15888c);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15889d);
        subscribe(BaseEventKeys.Confirm.EVENT_REFRESH_FORM_OPERATION_ITEMS, this.f15890e);
        subscribe(BaseEventKeys.Form.KEY_UPDATE_FORM_OPTIONS, this.f15891f);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_CONFIRM, this.f15892g);
        subscribe(BaseEventKeys.CarPool.EVENT_ONE_PRICE_SELECT_CONFIRM, this.f15893h);
    }

    /* renamed from: d */
    private void m13190d() {
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f15888c);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f15889d);
        unsubscribe(BaseEventKeys.Confirm.EVENT_REFRESH_FORM_OPERATION_ITEMS, this.f15890e);
        unsubscribe(BaseEventKeys.Form.KEY_UPDATE_FORM_OPTIONS, this.f15891f);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_CONFIRM, this.f15892g);
        unsubscribe(BaseEventKeys.CarPool.EVENT_ONE_PRICE_SELECT_CONFIRM, this.f15893h);
    }

    public void showNoviceGuidance(int i) {
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_NOVICE_GUIDANCE_FOR_SUBSTITUTE_CALL, Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void handleTwoPriceSelectSeatConfirmEvent() {
        onConfirmPriceIntercept();
    }

    public void onConfirmPriceIntercept() {
        if (!showPinInputPage()) {
            onConfirmPrice();
        }
    }

    public void onConfirmPrice() {
        this.f15886a.info("Click send order btn", new Object[0]);
        m13193e();
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
    }

    public boolean showPinInputPage() {
        if (!m13185a(FormStore.getInstance().getPayWay()) || hasPin()) {
            return false;
        }
        FormStore.getInstance().setSkipEstimateGet(true);
        startActivityForResult(PinInputActivity.getIntent(this.mContext), 101);
        return true;
    }

    public boolean hasPin() {
        String userPin = NationComponentDataUtil.getUserPin(this.mContext);
        GLog.m11354d("UserInfoPin", "UserInfo.getPin=" + userPin);
        return !TextUtils.isEmpty(userPin) && userPin.length() == 3;
    }

    /* renamed from: a */
    private boolean m13185a(String str) {
        int i;
        if (!isPricingTaxi()) {
            return false;
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 128 || i == 256 || i == 512) {
            return true;
        }
        return false;
    }

    public boolean isPricingTaxi() {
        return DynamicConfigManager.getInstance().checkConfigEnable(FormStore.getInstance().Bid, DynamicConfigManager.FUNCTION_KEY_PRICING_MODE, false);
    }

    /* access modifiers changed from: protected */
    public void updateButtonStatus() {
        dealBtnText();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            boolean z = true;
            if (newEstimateItem.carConfig != null && newEstimateItem.carConfig.carAvailable == 0) {
                z = false;
            }
            ((IGroupFormView) this.mView).setEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    public void updateNewEstButtonText() {
        dealBtnText();
    }

    /* access modifiers changed from: protected */
    public void dealBtnText() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.confirmText)) {
            ((IGroupFormView) this.mView).setButtonText(ResourcesHelper.getString(this.mContext, R.string.global_confirm_btn_new));
        } else {
            ((IGroupFormView) this.mView).setButtonText(newEstimateItem.carConfig.confirmText);
        }
    }

    /* renamed from: e */
    private void m13193e() {
        int i;
        String str;
        HashMap hashMap = new HashMap();
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        String str2 = "";
        int i2 = 0;
        if (estimateItem != null) {
            if (estimateItem.payWayList != null) {
                Iterator<PayWayModel.PayWayItem> it = estimateItem.payWayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PayWayModel.PayWayItem next = it.next();
                    if (next.isSelected() == 1) {
                        str = next.title;
                        break;
                    }
                }
            }
            str = str2;
            hashMap.put("dynamic", 0);
            hashMap.put("payment", str);
            hashMap.put("cartype", Integer.valueOf(newEstimateItem.getCarLevel()));
            hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
            hashMap.put("has_tips", 0);
            hashMap.put("order_type", Integer.valueOf(Long.valueOf(FormStore.getInstance().getTransportTime()).longValue() == 0 ? 0 : 1));
        }
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
            hashMap.put("price_estimated", Float.valueOf(newEstimateItem.feeNumber));
        }
        hashMap.put("business_id", BusinessDataUtil.getProductId());
        List<PayWayModel.PayWayItem> payWaySelectedItem = FormStore.getInstance().getPayWaySelectedItem();
        if (payWaySelectedItem == null || payWaySelectedItem.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (PayWayModel.PayWayItem payWayItem : payWaySelectedItem) {
                i |= payWayItem.tag;
            }
        }
        hashMap.put("paytype", Integer.valueOf(i));
        Address startAddress = FormStore.getInstance().getDepartureAddress() == null ? FormStore.getInstance().getStartAddress() : FormStore.getInstance().getDepartureAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (startAddress != null) {
            hashMap.put("from_addr", !TextUtils.isEmpty(startAddress.address) ? startAddress.address : startAddress.displayName);
            hashMap.put("from_poi_id", startAddress.poiId == null ? str2 : startAddress.poiId);
            hashMap.put("from_lng", Double.valueOf(startAddress.getLongitude()));
            hashMap.put("from_lat", Double.valueOf(startAddress.getLatitude()));
            hashMap.put("from_srctag", startAddress.getSrcTag() == null ? str2 : startAddress.getSrcTag());
        }
        if (endAddress != null) {
            hashMap.put("to_addr", !TextUtils.isEmpty(endAddress.address) ? endAddress.address : endAddress.displayName);
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, endAddress.poiId == null ? str2 : endAddress.poiId);
            hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
            if (endAddress.getSrcTag() != null) {
                str2 = endAddress.getSrcTag();
            }
            hashMap.put("to_srctag", str2);
        }
        hashMap.put("eta", Integer.valueOf(FormStore.getInstance().getEta()));
        String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
        if (estimateModelTraceId != null) {
            hashMap.put("estimate_trace_id", estimateModelTraceId);
        }
        hashMap.put("nearcar", Integer.valueOf(FormStore.getInstance().getNearbyCarNum()));
        hashMap.put("type", 0);
        EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem2 == null || newEstimateItem2.carConfig == null)) {
            if (newEstimateItem2.carConfig.guideType != null) {
                hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem2.carConfig.guideType.toString());
            }
            hashMap.put("default_select", newEstimateItem2.carConfig.selectDefault);
            if (newEstimateItem2.carConfig.extraData != null) {
                newEstimateItem2.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        if (newEstimateItem2 != null && !CollectionUtils.isEmpty((Collection<?>) newEstimateItem2.carPayInfo)) {
            int i3 = 0;
            while (i2 < newEstimateItem2.carPayInfo.size()) {
                CarPayInfoModel carPayInfoModel = newEstimateItem2.carPayInfo.get(i2);
                if (carPayInfoModel.payTag == 256 && carPayInfoModel.payExtraItemInfos != null) {
                    int size = carPayInfoModel.payExtraItemInfos.size();
                    if (size == 1) {
                        i3 = 1;
                    }
                    if (size > 1) {
                        i3 = 2;
                    }
                }
                i2++;
            }
            i2 = i3;
        }
        hashMap.put("card_status", Integer.valueOf(i2));
        GlobalOmegaUtils.trackEvent("pas_carconfirm_submit_ck", (Map<String, Object>) hashMap);
        if (FormStore.getInstance().isFromOpenRide()) {
            GlobalOmegaUtils.trackEvent("Pas_99GO_orderconfirm_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m13194f() {
        if (this.mComponentCreator != null) {
            ((IGroupFormView) this.mView).setOptionViews(new ArrayList());
        }
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }

    public IViewContainer.IComponentCreator getComponentCreator() {
        return this.mComponentCreator;
    }

    public IComponent inflateComponent(String str, ViewGroup viewGroup) {
        IComponent newComponent = this.mComponentCreator.newComponent(str, viewGroup);
        if (newComponent != null && newComponent.getView() != null && newComponent.getView().getView() != null) {
            return newComponent;
        }
        this.mComponentCreator.removeComponent(newComponent);
        return null;
    }

    public void removeComponent(IComponent iComponent) {
        this.mComponentCreator.removeComponent(iComponent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101 && i2 == -1 && hasPin()) {
            onConfirmPrice();
        }
        super.onActivityResult(i, i2, intent);
    }
}
