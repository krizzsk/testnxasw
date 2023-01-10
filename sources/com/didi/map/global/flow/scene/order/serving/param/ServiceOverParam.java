package com.didi.map.global.flow.scene.order.serving.param;

import android.content.Context;
import com.didi.map.global.flow.model.WayPointParam;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.HashMap;

public class ServiceOverParam extends PageSceneParam {

    /* renamed from: a */
    private boolean f29410a = true;

    /* renamed from: b */
    private long f29411b;

    /* renamed from: c */
    private int f29412c;

    /* renamed from: d */
    private long f29413d;

    /* renamed from: e */
    private long f29414e;

    /* renamed from: f */
    private String f29415f;

    /* renamed from: g */
    private String f29416g;

    /* renamed from: h */
    private String f29417h;

    /* renamed from: i */
    private String f29418i;

    /* renamed from: j */
    private String f29419j;

    /* renamed from: k */
    private int f29420k;

    /* renamed from: l */
    private HashMap<MapElementId, CommonMarkerParam> f29421l;

    /* renamed from: m */
    private WayPointParam f29422m;

    /* renamed from: n */
    private boolean f29423n;

    public ServiceOverParam(Builder builder) {
        super(builder);
        this.f29410a = builder.showRouteLine;
        this.f29411b = builder.driverId;
        this.f29412c = builder.biztype;
        this.f29413d = builder.startTime;
        this.f29414e = builder.endTime;
        this.f29415f = builder.clientVersion;
        this.f29416g = builder.token;
        this.f29417h = builder.passengerPhoneNumber;
        this.f29418i = builder.imei;
        this.f29419j = builder.orderId;
        this.f29420k = builder.orderStatus;
        this.f29421l = builder.markerParams;
        this.f29422m = builder.wayPointParam;
        this.f29423n = builder.isNewVersion;
        this.f29421l = builder.markerParams;
    }

    public boolean isShowRouteLine() {
        return this.f29410a;
    }

    public long getDriverId() {
        return this.f29411b;
    }

    public int getBiztype() {
        return this.f29412c;
    }

    public long getStartTime() {
        return this.f29413d;
    }

    public long getEndTime() {
        return this.f29414e;
    }

    public String getClientVersion() {
        return this.f29415f;
    }

    public String getToken() {
        return this.f29416g;
    }

    public String getPassengerPhoneNumber() {
        return this.f29417h;
    }

    public String getImei() {
        return this.f29418i;
    }

    public String getOrderId() {
        return this.f29419j;
    }

    public int getOrderStatus() {
        return this.f29420k;
    }

    public HashMap<MapElementId, CommonMarkerParam> getMarkerParams() {
        return this.f29421l;
    }

    public CommonMarkerParam getMarkerParam(MapElementId mapElementId) {
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f29421l;
        if (hashMap == null || !hashMap.containsKey(mapElementId)) {
            return null;
        }
        return this.f29421l.get(mapElementId);
    }

    public WayPointParam getWayPointParam() {
        return this.f29422m;
    }

    public boolean isNewVersion() {
        return this.f29423n;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public int biztype;
        /* access modifiers changed from: private */
        public String clientVersion;
        /* access modifiers changed from: private */
        public long driverId;
        /* access modifiers changed from: private */
        public long endTime;
        /* access modifiers changed from: private */
        public String imei;
        /* access modifiers changed from: private */
        public boolean isNewVersion;
        /* access modifiers changed from: private */
        public HashMap<MapElementId, CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public int orderStatus;
        /* access modifiers changed from: private */
        public String passengerPhoneNumber;
        /* access modifiers changed from: private */
        public boolean showRouteLine = true;
        /* access modifiers changed from: private */
        public long startTime;
        /* access modifiers changed from: private */
        public String token;
        /* access modifiers changed from: private */
        public WayPointParam wayPointParam;

        public Builder setShowRouteLine(boolean z) {
            this.showRouteLine = z;
            return this;
        }

        public Builder setDriverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder setBiztype(int i) {
            this.biztype = i;
            return this;
        }

        public Builder setStartTime(long j) {
            this.startTime = j;
            return this;
        }

        public Builder setEndTime(long j) {
            this.endTime = j;
            return this;
        }

        public Builder setClientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setPassengerPhoneNumber(String str) {
            this.passengerPhoneNumber = str;
            return this;
        }

        public Builder setImei(String str) {
            this.imei = str;
            return this;
        }

        public Builder setOrderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder setOrderStatus(int i) {
            this.orderStatus = i;
            return this;
        }

        public Builder setMarkerParams(HashMap<MapElementId, CommonMarkerParam> hashMap) {
            this.markerParams = hashMap;
            return this;
        }

        public Builder setWayPointParam(WayPointParam wayPointParam2) {
            this.wayPointParam = wayPointParam2;
            return this;
        }

        public Builder setNewVersion(boolean z) {
            this.isNewVersion = z;
            return this;
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public ServiceOverParam build() {
            return new ServiceOverParam(this);
        }
    }
}
