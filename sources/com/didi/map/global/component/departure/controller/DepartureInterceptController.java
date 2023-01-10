package com.didi.map.global.component.departure.controller;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

public class DepartureInterceptController {

    /* renamed from: a */
    private String f27304a = "DepartureController";

    /* renamed from: b */
    private Map f27305b;

    /* renamed from: c */
    private boolean f27306c = false;

    /* renamed from: d */
    private Context f27307d;

    /* renamed from: e */
    private FenceController f27308e;

    /* renamed from: f */
    private DepartureControllerParams f27309f;

    /* renamed from: g */
    private OrderInterceptMode f27310g = OrderInterceptMode.MODE_NORMAL;

    /* renamed from: h */
    private int f27311h = 0;

    /* renamed from: i */
    private IInterceptListener f27312i;

    /* renamed from: j */
    private String f27313j;

    /* renamed from: k */
    private boolean f27314k = false;

    /* renamed from: l */
    private DepartureAddress f27315l;

    /* renamed from: m */
    private DIDILocation f27316m;

    public interface IInterceptListener {
        void onContinue();

        void onIntercept(OrderInterceptMode orderInterceptMode, boolean z);

        void onStart();
    }

    public DepartureInterceptController(DepartureControllerParams departureControllerParams) {
        if (departureControllerParams != null) {
            this.f27305b = departureControllerParams.getMap();
            this.f27307d = departureControllerParams.getContext();
            this.f27308e = departureControllerParams.getFenceController();
            this.f27309f = departureControllerParams;
        }
    }

    public boolean isHasDragged() {
        return this.f27314k;
    }

    public void setHasDragged(boolean z) {
        this.f27314k = z;
    }

    public void updateNewRequestLocation(DepartureAddress departureAddress, String str) {
        DepartureAddress departureAddress2;
        if (this.f27312i != null && this.f27306c) {
            this.f27306c = false;
            if (departureAddress == null || (departureAddress2 = this.f27315l) == null || LatLngUtils.isSameLatLng(departureAddress2.getPosition(), departureAddress.getPosition())) {
                this.f27312i.onIntercept(this.f27310g, false);
            } else {
                this.f27312i.onIntercept(this.f27310g, true);
            }
        }
        this.f27315l = departureAddress;
        DLog.m10773d(this.f27304a, "更新 departure address", new Object[0]);
        if (str == null || str.isEmpty()) {
            this.f27313j = "verybad";
        } else {
            this.f27313j = str;
        }
    }

    public void upDateCurrentLocation(DIDILocation dIDILocation) {
        this.f27316m = dIDILocation;
    }

    public void addInterceptListener(IInterceptListener iInterceptListener) {
        if (m21583a()) {
            DLog.m10773d(this.f27304a, "new intercept", new Object[0]);
            addInterceptListenerNew(iInterceptListener);
            return;
        }
        DLog.m10773d(this.f27304a, "old intercept", new Object[0]);
        addInterceptListenerOld(iInterceptListener);
    }

    /* renamed from: a */
    private boolean m21583a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_pickup_intercept_fix_ab");
            if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
                int intValue = ((Integer) experiment.getParam("enable", 0)).intValue();
                DLog.m10773d("global_pickup_intercept_fix_ab", "" + intValue, new Object[0]);
                if (intValue == 1) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            DLog.m10773d("global_pickup_intercept_fix_ab", "" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
        return false;
    }

    public void addInterceptListenerNew(IInterceptListener iInterceptListener) {
        this.f27312i = iInterceptListener;
        if (this.f27309f == null || iInterceptListener == null || this.f27306c) {
            DLog.m10773d(this.f27304a, "param=null || listener==null || mIsIntercept=true", new Object[0]);
            return;
        }
        DepartureAddress departureAddress = this.f27315l;
        if (departureAddress == null || departureAddress.getAddress() == null || this.f27315l.getPosition() == null) {
            DLog.m10773d(this.f27304a, "departureAddress 位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng position = this.f27315l.getPosition();
        this.f27311h = this.f27315l.getAddress().operationType;
        if (m21584a(position)) {
            iInterceptListener.onContinue();
            return;
        }
        String str = this.f27304a;
        DLog.m10773d(str, "当前位置定位精度" + this.f27313j, new Object[0]);
        String str2 = this.f27304a;
        DLog.m10773d(str2, "interceptSceneType = 获取选点类型" + this.f27311h, new Object[0]);
        if (isHasDragged()) {
            DLog.m10773d(this.f27304a, "用户拖拽地图", new Object[0]);
            this.f27311h = 1;
        }
        if (m21587b(position)) {
            OrderInterceptMode orderInterceptMode = OrderInterceptMode.MODE_START_NEAR_END;
            this.f27310g = orderInterceptMode;
            iInterceptListener.onIntercept(orderInterceptMode, false);
            return;
        }
        if (this.f27316m == null) {
            this.f27316m = LocationHelper2.getLastKnownLocation(this.f27307d, LocationRegisterParam.LocType.FLP);
        }
        DIDILocation dIDILocation = this.f27316m;
        if (dIDILocation == null) {
            DLog.m10773d(this.f27304a, "定位位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng latLng = new LatLng(dIDILocation.getLatitude(), this.f27316m.getLongitude());
        if (this.f27311h == 0) {
            if (m21585a(latLng, position)) {
                this.f27306c = true;
                DLog.m10773d(this.f27304a, "默认场景触发重新请求上车点", new Object[0]);
                iInterceptListener.onStart();
                return;
            }
            iInterceptListener.onContinue();
        } else if (m21586a(this.f27316m, latLng, position)) {
            OrderInterceptMode orderInterceptMode2 = OrderInterceptMode.MODE_START_POSITION_TO_FAR;
            this.f27310g = orderInterceptMode2;
            iInterceptListener.onIntercept(orderInterceptMode2, false);
        } else {
            iInterceptListener.onContinue();
        }
    }

    public void addInterceptListenerOld(IInterceptListener iInterceptListener) {
        this.f27312i = iInterceptListener;
        if (this.f27309f == null || iInterceptListener == null || this.f27306c) {
            DLog.m10773d(this.f27304a, "param=null || listener==null || mIsIntercept=true", new Object[0]);
            return;
        }
        DepartureAddress departureAddress = this.f27315l;
        if (departureAddress == null || departureAddress.getAddress() == null || this.f27315l.getPosition() == null || this.f27316m == null) {
            DLog.m10773d(this.f27304a, "departureAddress 位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng position = this.f27315l.getPosition();
        LatLng latLng = new LatLng(this.f27316m.getLatitude(), this.f27316m.getLongitude());
        this.f27311h = this.f27315l.getAddress().operationType;
        if (m21584a(position)) {
            iInterceptListener.onContinue();
            return;
        }
        String str = this.f27304a;
        DLog.m10773d(str, "当前位置定位精度" + this.f27313j, new Object[0]);
        String str2 = this.f27304a;
        DLog.m10773d(str2, "interceptSceneType = 获取选点类型" + this.f27311h, new Object[0]);
        if (isHasDragged()) {
            DLog.m10773d(this.f27304a, "用户拖拽地图", new Object[0]);
            this.f27311h = 1;
        }
        if (m21587b(position)) {
            OrderInterceptMode orderInterceptMode = OrderInterceptMode.MODE_START_NEAR_END;
            this.f27310g = orderInterceptMode;
            iInterceptListener.onIntercept(orderInterceptMode, false);
        } else if (this.f27311h == 0) {
            if (m21585a(latLng, position)) {
                this.f27306c = true;
                DLog.m10773d(this.f27304a, "默认场景触发重新请求上车点", new Object[0]);
                iInterceptListener.onStart();
                return;
            }
            iInterceptListener.onContinue();
        } else if (m21586a(this.f27316m, latLng, position)) {
            OrderInterceptMode orderInterceptMode2 = OrderInterceptMode.MODE_START_POSITION_TO_FAR;
            this.f27310g = orderInterceptMode2;
            iInterceptListener.onIntercept(orderInterceptMode2, false);
        } else {
            iInterceptListener.onContinue();
        }
    }

    /* renamed from: a */
    private boolean m21586a(DIDILocation dIDILocation, LatLng latLng, LatLng latLng2) {
        DepartureAddress departureAddress;
        String str = this.f27304a;
        DLog.m10773d(str, "非默认场景用户移动速度： " + dIDILocation.getSpeed(), new Object[0]);
        if (dIDILocation.getSpeed() < ((float) InterceptConfig.getInstance().filter_loc_speed)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
            String str2 = this.f27304a;
            DLog.m10773d(str2, "非默认场景，两点距离：" + computeDistanceBetween, new Object[0]);
            if (computeDistanceBetween > InterceptConfig.getInstance().filter_sel_min_start_loc_dist && computeDistanceBetween < InterceptConfig.getInstance().filter_sel_max_start_loc_dist && InterceptConfig.getInstance().allow_loc_acc_level.contains(this.f27313j) && (departureAddress = this.f27315l) != null && departureAddress.getAddress() != null) {
                String str3 = this.f27304a;
                DLog.m10773d(str3, "非默认场景- 是否有定点完单" + this.f27315l.getAddress().getPickupPointOrderStatus(), new Object[0]);
                if (this.f27315l.getAddress().getPickupPointOrderStatus() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m21584a(LatLng latLng) {
        if (latLng == null) {
            DLog.m10773d(this.f27304a, "departure ==null", new Object[0]);
            return true;
        } else if (this.f27305b == null || this.f27309f == null || this.f27308e == null) {
            DLog.m10773d(this.f27304a, "必要参数为null，不拦截", new Object[0]);
            return true;
        } else if (!InterceptConfig.getInstance().enable) {
            DLog.m10773d(this.f27304a, "appllo 控制器设置不拦截", new Object[0]);
            return true;
        } else if (!DepartureDataStore.getInstance().isInterceptTimeInvalid()) {
            DLog.m10773d(this.f27304a, "时间频次不符 不拦截", new Object[0]);
            return true;
        } else if (this.f27308e.isInFence(latLng) == 0 || this.f27308e.isInFence(latLng) == 1) {
            String str = this.f27304a;
            DLog.m10773d(str, " 当前点在场站/禁停围栏内，不拦截" + this.f27308e.isInFence(latLng), new Object[0]);
            return true;
        } else if (this.f27309f.getSceneType() != 1) {
            return false;
        } else {
            DLog.m10773d(this.f27304a, "拼车不拦截", new Object[0]);
            return true;
        }
    }

    /* renamed from: b */
    private boolean m21587b(LatLng latLng) {
        DepartureControllerParams departureControllerParams;
        if (!(latLng == null || (departureControllerParams = this.f27309f) == null || departureControllerParams.getEndPoint() == null || this.f27309f.isHasWayPoint())) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(this.f27309f.getEndPoint(), latLng);
            String str = this.f27304a;
            DLog.m10773d(str, "start position" + latLng.toString(), new Object[0]);
            String str2 = this.f27304a;
            DLog.m10773d(str2, "end position" + this.f27309f.getEndPoint().toString(), new Object[0]);
            String str3 = this.f27304a;
            DLog.m10773d(str3, "拦截判断起终点直线距离:" + computeDistanceBetween, new Object[0]);
            if (computeDistanceBetween < InterceptConfig.getInstance().filter_start_end_dist) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m21585a(LatLng latLng, LatLng latLng2) {
        DLog.m10773d(this.f27304a, "默认场景判断开始- ", new Object[0]);
        if (InterceptConfig.getInstance().allow_loc_acc_level.contains(this.f27313j)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
            String str = this.f27304a;
            DLog.m10773d(str, "默认场景上车点推荐过远- distance =" + computeDistanceBetween, new Object[0]);
            DepartureAddress departureAddress = this.f27315l;
            if (departureAddress == null || departureAddress.getAddress() == null) {
                return false;
            }
            String str2 = this.f27304a;
            DLog.m10773d(str2, "默认场景上车点推荐过远- has_pickup_point_order =" + this.f27315l.getAddress().getPickupPointOrderStatus(), new Object[0]);
            if (computeDistanceBetween <= InterceptConfig.getInstance().filter_rec_start_loc_dist || this.f27315l.getAddress().getPickupPointOrderStatus() != 0) {
                return false;
            }
            this.f27310g = OrderInterceptMode.MODE_REC_POSITION_TO_FAR;
        } else if (!InterceptConfig.getInstance().allow_loc_acc_level_bad.equalsIgnoreCase(this.f27313j)) {
            return false;
        } else {
            this.f27310g = OrderInterceptMode.MODE_REC_POSITION_LEVEL_BAD;
            DLog.m10773d(this.f27304a, "定位精度极差-", new Object[0]);
        }
        return true;
    }
}
