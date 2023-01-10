package com.didi.component.ridestatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.I18NUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.ridestatus.view.OptimizeRideStatusView;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p171v2.TravelUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OnServiceRideStatusPresenter extends AbsRideStatusPresenter<OptimizeRideStatusView> {

    /* renamed from: h */
    private static final int f17184h = 200;

    /* renamed from: i */
    private static final int f17185i = 2;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17186a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                TravelUtil.getOrderDetail(OnServiceRideStatusPresenter.this.mComponentProxy.getSession(), order.oid, new ITravelOrderListener() {
                    public void onError(int i, String str) {
                    }

                    public void onFail(int i, String str) {
                    }

                    public void onTimeout(String str) {
                    }

                    public void onSuccess(ICarOrder iCarOrder) {
                        CarOrder carOrder = (CarOrder) iCarOrder;
                        if (carOrder != null && carOrder.substatus == 4004) {
                            CarOrderHelper.saveOrder(carOrder);
                            OnServiceRideStatusPresenter.this.passengerLate();
                        }
                    }
                });
            }
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17187b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OnServiceRideStatusPresenter.this.m14402b();
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17188c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OnServiceRideStatusPresenter.this.m14404c();
        }
    };

    /* renamed from: d */
    BaseEventPublisher.OnEventListener<EtaEda> f17189d = new BaseEventPublisher.OnEventListener<EtaEda>() {
        public void onEvent(String str, EtaEda etaEda) {
            CarOrder order;
            if (!OnServiceRideStatusPresenter.this.f17193j && etaEda != null && etaEda.eda < 200 && etaEda.eta < 2 && (order = CarOrderHelper.getOrder()) != null && order.substatus == 4001 && order.prepareSCModel != null && !TextUtils.isEmpty(order.prepareSCModel.pushArrivedImmediately)) {
                OnServiceRideStatusPresenter.this.handleEtaRideStatus();
                boolean unused = OnServiceRideStatusPresenter.this.f17193j = true;
            }
        }
    };

    /* renamed from: e */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17190e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarOrder order = CarOrderHelper.getOrder();
            OnServiceRideStatusPresenter onServiceRideStatusPresenter = OnServiceRideStatusPresenter.this;
            onServiceRideStatusPresenter.makeAddCardModel(order, onServiceRideStatusPresenter.mContext.getString(R.string.ride_status_title_pay_off_line), OnServiceRideStatusPresenter.this.mContext.getString(R.string.ride_status_content_pay_off_line));
        }
    };

    /* renamed from: f */
    BaseEventPublisher.OnEventListener<SctxStateInfo> f17191f = new BaseEventPublisher.OnEventListener<SctxStateInfo>() {
        public void onEvent(String str, SctxStateInfo sctxStateInfo) {
            if ("event_sctx_state_change".equals(str)) {
                OnServiceRideStatusPresenter.this.m14398a(sctxStateInfo);
            }
        }
    };

    /* renamed from: g */
    private final Logger f17192g = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f17193j = false;

    /* renamed from: k */
    private Timer f17194k;

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Boolean> f17195l = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            CarOrder order = CarOrderHelper.getOrder();
            if (bool == null || bool.booleanValue()) {
                OnServiceRideStatusPresenter onServiceRideStatusPresenter = OnServiceRideStatusPresenter.this;
                onServiceRideStatusPresenter.makeAddCardModel(order, onServiceRideStatusPresenter.mContext.getString(R.string.ride_status_title_wait_driver), OnServiceRideStatusPresenter.this.mPreContentText);
                return;
            }
            String string = OnServiceRideStatusPresenter.this.mContext.getString(R.string.ride_status_title_driver_finishing_last_order);
            int interlinkOrderPerceptionGroupNo = GlobalApolloUtil.getInterlinkOrderPerceptionGroupNo();
            if (interlinkOrderPerceptionGroupNo == 1) {
                string = OnServiceRideStatusPresenter.this.mContext.getString(R.string.ride_status_title_driver_finishing_last_order_optm_group1);
            } else if (interlinkOrderPerceptionGroupNo == 2) {
                string = OnServiceRideStatusPresenter.this.mContext.getString(R.string.ride_status_title_driver_finishing_last_order_optm_group2);
            } else if (interlinkOrderPerceptionGroupNo == 3) {
                string = OnServiceRideStatusPresenter.this.mContext.getString(R.string.ride_status_title_driver_finishing_last_order_optm_group3);
            }
            OnServiceRideStatusPresenter onServiceRideStatusPresenter2 = OnServiceRideStatusPresenter.this;
            onServiceRideStatusPresenter2.makeAddCardModel(order, string, onServiceRideStatusPresenter2.mPreContentText);
        }
    };

    /* renamed from: m */
    private String f17196m = null;
    protected int mCurrentCarPoolStatus = 0;
    protected int mCurrentStatus = -1;

    /* renamed from: n */
    private String f17197n = null;

    /* access modifiers changed from: protected */
    public void travelStartSoon() {
    }

    public OnServiceRideStatusPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m14402b();
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17187b);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_CASH_ARRIVED_DESTINATION, this.f17190e);
        subscribe(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED, this.f17188c);
        subscribe(BaseEventKeys.Service.EVENT_POINT_PASSED_OF_CONTINUOUS_ORDERS, this.f17195l);
        subscribe("event_sctx_state_change", this.f17191f);
        if (!FormStore.getInstance().isFromOpenRide()) {
            subscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f17189d);
            subscribe(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE, this.f17186a);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17187b);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_CASH_ARRIVED_DESTINATION, this.f17190e);
        unsubscribe(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED, this.f17188c);
        unsubscribe(BaseEventKeys.Service.EVENT_POINT_PASSED_OF_CONTINUOUS_ORDERS, this.f17195l);
        unsubscribe("event_sctx_state_change", this.f17191f);
        if (!FormStore.getInstance().isFromOpenRide()) {
            unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f17189d);
            unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE, this.f17186a);
        }
        m14409e();
        this.mPreTitleText = null;
        this.mPreContentText = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14402b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (!(this.mCurrentStatus == order.substatus && order.orderState != null && this.mCurrentCarPoolStatus == order.orderState.carpoolStatus) && !BusinessDataUtil.onInterceptOrderStatus(order, this.mCurrentStatus)) {
                this.mCurrentStatus = order.substatus;
                if (order.orderState != null) {
                    this.mCurrentCarPoolStatus = order.orderState.carpoolStatus;
                }
                if (order.status == 1) {
                    waitDriver();
                    return;
                }
                switch (this.mCurrentStatus) {
                    case 4001:
                        waitDriver();
                        return;
                    case 4002:
                        driverLate();
                        return;
                    case 4003:
                        driverArrived();
                        return;
                    case 4004:
                        passengerLate();
                        return;
                    case 4005:
                    case 4006:
                        onService();
                        return;
                    case 4007:
                        travelStartSoon();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14404c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if ((order.substatus == 4006 || order.substatus == 4005) && order.wayPointList != null && order.wayPointList.size() > 0) {
                onService();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getWaitDriverContentText(CarOrder carOrder) {
        if (carOrder == null) {
            return null;
        }
        DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo = carOrder.prepareSCModel;
        if (CarOrderHelper.isCarPoolLineHaveOrder() && carOrder.striveInfo != null && carOrder.striveInfo.priority_strive == 1) {
            m14399a(carOrder);
            return TextUtils.isEmpty(carOrder.striveInfo.strive_msg) ? ResourcesHelper.getString(this.mContext, R.string.global_wait_4_drivers_order_strive) : carOrder.striveInfo.strive_msg;
        } else if (dTSDKPushInfo != null && !TextUtils.isEmpty(dTSDKPushInfo.pushTips)) {
            return m14395a(dTSDKPushInfo);
        } else {
            if (!carOrder.isBooking()) {
                return null;
            }
            return this.mContext.getResources().getString(R.string.ride_status_content_booking_wait_driver, new Object[]{I18NUtils.getMonthDayAndHourMinute(carOrder.transportTime)});
        }
    }

    /* renamed from: a */
    private void m14399a(CarOrder carOrder) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", Integer.valueOf(carOrder.productid));
        hashMap.put("order_status", Integer.valueOf(carOrder.substatus));
        OmegaSDKAdapter.trackEvent("gp_triptilt_content_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private String m14395a(DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo) {
        if (dTSDKPushInfo.passengerDutyTime <= 0 || TextUtils.isEmpty(dTSDKPushInfo.passengerDutyContent)) {
            return dTSDKPushInfo.pushTips;
        }
        long currentTimeMillis = (dTSDKPushInfo.passengerDutyTime * 1000) - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            return dTSDKPushInfo.passengerDutyContent;
        }
        m14396a(currentTimeMillis);
        return dTSDKPushInfo.pushTips;
    }

    /* access modifiers changed from: protected */
    public void waitDriver() {
        CarOrder order = CarOrderHelper.getOrder();
        if (FormStore.getInstance().isFromOpenRide()) {
            makeAddCardModel((CarOrder) null, this.mContext.getResources().getString(R.string.global_openride_ride_status_about_to_start), (String) null);
            return;
        }
        String string = this.mContext.getResources().getString(R.string.ride_status_title_wait_driver_subtitle);
        if (order.striveInfo != null && order.striveInfo.priority_strive == 1) {
            m14399a(order);
            string = TextUtils.isEmpty(order.striveInfo.strive_msg) ? this.mContext.getResources().getString(R.string.global_wait_4_drivers_order_strive) : order.striveInfo.strive_msg;
        }
        makeAddCardModel(order, string, getWaitDriverContentText(order));
    }

    /* access modifiers changed from: protected */
    public void driverLate() {
        CarOrder order = CarOrderHelper.getOrder();
        String str = null;
        if (FormStore.getInstance().isFromOpenRide()) {
            makeAddCardModel((CarOrder) null, this.mContext.getResources().getString(R.string.global_openride_ride_status_about_to_start), (String) null);
            return;
        }
        if (!(order == null || order.prepareSCModel == null)) {
            str = order.prepareSCModel.pushTips;
        }
        String string = this.mContext.getResources().getString(R.string.ride_status_title_wait_driver);
        if (order.striveInfo != null && order.striveInfo.priority_strive == 1) {
            m14399a(order);
            string = TextUtils.isEmpty(order.striveInfo.strive_msg) ? this.mContext.getResources().getString(R.string.global_wait_4_drivers_order_strive) : order.striveInfo.strive_msg;
        }
        makeAddCardModel(order, string, str);
    }

    /* access modifiers changed from: protected */
    public void passengerLate() {
        CarOrder order = CarOrderHelper.getOrder();
        String str = null;
        if (FormStore.getInstance().isFromOpenRide()) {
            makeAddCardModel((CarOrder) null, this.mContext.getResources().getString(R.string.global_openride_ride_status_about_to_start), (String) null);
            return;
        }
        if (!(order == null || order.prepareSCModel == null)) {
            str = order.prepareSCModel.pushTipsPassengerLate;
        }
        makeAddCardModel(order, this.mContext.getResources().getString(R.string.ride_status_title_passenger_late), str);
    }

    /* access modifiers changed from: protected */
    public void driverArrived() {
        CarOrder order = CarOrderHelper.getOrder();
        String str = null;
        if (FormStore.getInstance().isFromOpenRide()) {
            makeAddCardModel((CarOrder) null, this.mContext.getResources().getString(R.string.global_openride_ride_status_about_to_start), (String) null);
            return;
        }
        if (order != null && order.substatus == 4003 && order.prepareSCModel != null && order.prepareSCModel.isServiceControl == 1 && m14401b(order) <= 0) {
            str = order.prepareSCModel.pushTipsPassengerLate;
        }
        if (!(str != null || order == null || order.prepareSCModel == null)) {
            str = order.prepareSCModel.pushTips;
        }
        makeAddCardModel(order, this.mContext.getResources().getString(R.string.ride_status_title_driver_arrival), str);
    }

    /* access modifiers changed from: protected */
    public void onService() {
        String str;
        String str2;
        CarOrder order = CarOrderHelper.getOrder();
        if (order.wayPointList == null || order.wayPointList.size() <= 0) {
            str2 = (order == null || order.prepareSCModel == null) ? null : order.prepareSCModel.pushTips;
            str = this.mContext.getResources().getString(R.string.ride_status_title_start_bill);
        } else {
            if (order.wayPointList.size() == 1 && order.wayPointList.get(0).getTripState() == 0) {
                str2 = this.mContext.getString(R.string.global_go_to_way_point);
            } else if (order.wayPointList.size() == 2 && order.wayPointList.get(0).getTripState() == 0) {
                str2 = this.mContext.getString(R.string.global_go_to_way_point_one);
            } else if (order.wayPointList.size() == 2 && order.wayPointList.get(1).getTripState() == 0) {
                str2 = this.mContext.getString(R.string.global_go_to_way_point_two);
            } else {
                str2 = this.mContext.getString(R.string.global_go_to_destination);
            }
            str = this.mContext.getResources().getString(R.string.ride_status_title_start_bill_way_point);
        }
        if (FormStore.getInstance().isFromOpenRide()) {
            makeAddCardModel((CarOrder) null, this.mContext.getResources().getString(R.string.global_openride_ride_status_title_start_bill), (String) null);
        } else {
            makeAddCardModel(order, str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14398a(SctxStateInfo sctxStateInfo) {
        if (sctxStateInfo != null && CarOrderHelper.isWaitDriver()) {
            if (sctxStateInfo.isExceptionState()) {
                String string = ResourcesHelper.getString(this.mContext, R.string.global_map_car_exception_tip_title);
                String string2 = ResourcesHelper.getString(this.mContext, R.string.global_map_car_exception_tip_content);
                if (!TextUtils.equals(this.mPreContentText, string2)) {
                    this.f17196m = this.mPreContentText;
                    this.f17197n = this.mPreTitleText;
                }
                makeAddCardModel((CarOrder) null, string, string2);
                GLog.m11354d("zl-sctx-tips", "show warning.");
                return;
            }
            m14407d();
            GLog.m11354d("zl-sctx-tips", "hide warning.");
        }
    }

    /* renamed from: d */
    private void m14407d() {
        if (!TextUtils.isEmpty(this.f17196m) || !TextUtils.isEmpty(this.f17197n)) {
            makeAddCardModel((CarOrder) null, this.f17197n, this.f17196m);
        }
    }

    /* renamed from: b */
    private long m14401b(CarOrder carOrder) {
        long j;
        DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo = carOrder.prepareSCModel;
        long j2 = carOrder.arriveTime;
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 > 0) {
            long j3 = currentTimeMillis - j2;
            if (j3 > 0) {
                j = j3 / 1000;
                return Math.max(((long) (dTSDKPushInfo.serviceControlWaitTime * 60)) - j, 0);
            }
        }
        j = 0;
        return Math.max(((long) (dTSDKPushInfo.serviceControlWaitTime * 60)) - j, 0);
    }

    /* access modifiers changed from: protected */
    public void handleEtaRideStatus() {
        CarOrder order = CarOrderHelper.getOrder();
        makeAddCardModel(order, this.mContext.getString(R.string.ride_status_title_driver_will_arrive_soon), order.prepareSCModel.pushArrivedImmediately);
    }

    /* renamed from: a */
    private void m14396a(long j) {
        Logger logger = this.f17192g;
        logger.info("startTimer timer delay:" + j, new Object[0]);
        Timer timer = new Timer();
        this.f17194k = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        CarOrder order = CarOrderHelper.getOrder();
                        if (order != null) {
                            if (order.status == 1 || order.substatus == 4001) {
                                OnServiceRideStatusPresenter.this.waitDriver();
                            }
                        }
                    }
                });
                OnServiceRideStatusPresenter.this.m14409e();
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m14409e() {
        Timer timer = this.f17194k;
        if (timer != null) {
            timer.cancel();
            this.f17194k = null;
        }
    }
}
