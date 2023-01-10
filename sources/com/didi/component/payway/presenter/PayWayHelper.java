package com.didi.component.payway.presenter;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.travel.psnger.model.response.EstimateItem;

public class PayWayHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayMethodSelectAdapter f17013a = new PayMethodAdapterImpl();

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<Boolean> f17014b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (PayWayHelper.this.f17013a != null) {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (estimateItem == null || estimateItem.payWayList == null || estimateItem.payWayList.size() == 0) {
                    PayWayHelper.this.f17013a.notifyRefreshFailed();
                } else {
                    DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    payMethodListParam.list = DateConverUtils.converPayMethodInfoList(estimateItem.payWayList);
                    payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(estimateItem.payGroupList);
                    payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(estimateItem.payCfgInfo);
                    PayWayHelper.this.f17013a.notifyRefreshSuccess(payMethodListParam);
                }
            }
            PayWayHelper.this.m14256b();
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17015c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f17013a != null) {
                PayWayHelper.this.f17013a.notifyRefreshFailed();
            }
            PayWayHelper.this.m14256b();
        }
    };

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17016d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f17013a != null) {
                PayWayHelper.this.f17013a.notifyRefreshFailed();
            }
            PayWayHelper.this.m14256b();
        }
    };

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17017e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f17013a != null) {
                PayWayHelper.this.f17013a.notifyRefreshFinished();
            }
            PayWayHelper.this.m14256b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam> f17018f = new BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam>() {
        public void onEvent(String str, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
            if (PayWayHelper.this.f17013a != null) {
                PayWayHelper.this.f17013a.notifyRefreshSuccess(payMethodListParam);
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, PayWayHelper.this.f17018f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, PayWayHelper.this.f17019g);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17019g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PayWayHelper.this.f17013a != null) {
                PayWayHelper.this.f17013a.notifyRefreshFailed();
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, PayWayHelper.this.f17018f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, PayWayHelper.this.f17019g);
        }
    };

    public PayMethodSelectAdapter getPayMethodAdapter() {
        return this.f17013a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14255a() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f17014b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f17015c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f17016d);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f17017e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14256b() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f17014b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f17015c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f17016d);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f17017e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14259c() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, this.f17018f);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, this.f17019g);
    }

    class PayMethodAdapterImpl extends PayMethodSelectAdapter {
        PayMethodAdapterImpl() {
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            if (entrance == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE) {
                PayWayHelper.this.m14259c();
            } else {
                PayWayHelper.this.m14255a();
            }
        }
    }
}
