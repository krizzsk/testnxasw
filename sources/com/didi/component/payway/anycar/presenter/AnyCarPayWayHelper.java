package com.didi.component.payway.anycar.presenter;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;

public class AnyCarPayWayHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayMethodSelectAdapter f16959a = new PayMethodAdapterImpl();

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<Boolean> f16960b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayModel anyCarPayModel = null;
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    anyCarPayModel = confirmListener.getAnycarPayModel();
                }
                if (anyCarPayModel == null || anyCarPayModel.payWayList == null || anyCarPayModel.payWayList.size() == 0) {
                    AnyCarPayWayHelper.this.f16959a.notifyRefreshFailed();
                } else {
                    DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    payMethodListParam.list = DateConverUtils.converPayMethodInfoList(anyCarPayModel.payWayList);
                    payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(anyCarPayModel.carPayGroupInfo);
                    payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(anyCarPayModel.payCfgInfo);
                    AnyCarPayWayHelper.this.f16959a.notifyRefreshSuccess(payMethodListParam);
                }
            }
            AnyCarPayWayHelper.this.m14200b();
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16961c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayWayHelper.this.f16959a.notifyRefreshFailed();
            }
            AnyCarPayWayHelper.this.m14200b();
        }
    };

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16962d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayWayHelper.this.f16959a.notifyRefreshFailed();
            }
            AnyCarPayWayHelper.this.m14200b();
        }
    };

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16963e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayWayHelper.this.f16959a.notifyRefreshFinished();
            }
            AnyCarPayWayHelper.this.m14200b();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam> f16964f = new BaseEventPublisher.OnEventListener<DidiGlobalPayMethodListData.PayMethodListParam>() {
        public void onEvent(String str, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayWayHelper.this.f16959a.notifyRefreshSuccess(payMethodListParam);
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, AnyCarPayWayHelper.this.f16964f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, AnyCarPayWayHelper.this.f16965g);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16965g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AnyCarPayWayHelper.this.f16959a != null) {
                AnyCarPayWayHelper.this.f16959a.notifyRefreshFailed();
            }
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, AnyCarPayWayHelper.this.f16964f);
            BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, AnyCarPayWayHelper.this.f16965g);
        }
    };

    public PayMethodSelectAdapter getPayMethodAdapter() {
        return this.f16959a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14199a() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f16960b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f16961c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f16962d);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f16963e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14200b() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f16960b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f16961c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f16962d);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f16963e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14203c() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.SPLIT_FARE_REFRESH_DATA);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_SUCCESS, this.f16964f);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Home.SPLIT_FARE_REFRESH_CALLBACK_FAIL, this.f16965g);
    }

    class PayMethodAdapterImpl extends PayMethodSelectAdapter {
        PayMethodAdapterImpl() {
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            if (entrance == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE) {
                AnyCarPayWayHelper.this.m14203c();
            } else {
                AnyCarPayWayHelper.this.m14199a();
            }
        }
    }
}
