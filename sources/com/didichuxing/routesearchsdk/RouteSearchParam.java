package com.didichuxing.routesearchsdk;

import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.Collections;
import java.util.List;

public class RouteSearchParam {

    /* renamed from: a */
    final BizType f51075a;

    /* renamed from: b */
    final double f51076b;

    /* renamed from: c */
    final double f51077c;

    /* renamed from: d */
    final double f51078d;

    /* renamed from: e */
    final double f51079e;

    /* renamed from: f */
    final String f51080f;

    /* renamed from: g */
    final String f51081g;

    /* renamed from: h */
    final String f51082h;

    /* renamed from: i */
    final int f51083i;

    /* renamed from: j */
    final List<OdPoint> f51084j;

    /* renamed from: k */
    final CallFrom f51085k;

    /* renamed from: l */
    TravelMode f51086l;

    /* renamed from: m */
    final String f51087m;

    /* renamed from: n */
    final String f51088n;

    /* renamed from: o */
    final String f51089o;

    /* renamed from: p */
    final long f51090p;

    /* renamed from: q */
    final List<OidPidPair> f51091q;

    /* renamed from: r */
    final List<GpsLocation> f51092r;

    /* renamed from: s */
    final int f51093s;

    public enum BizType {
        BRAZIL,
        TAIWAN,
        GLOBAL
    }

    RouteSearchParam(Builder builder) {
        this.f51075a = builder.bizType;
        this.f51076b = builder.startLat;
        this.f51077c = builder.startLng;
        this.f51078d = builder.endLat;
        this.f51079e = builder.endLng;
        this.f51080f = builder.token;
        this.f51081g = builder.productId;
        this.f51082h = builder.phoneNum;
        this.f51084j = builder.odPoints;
        this.f51083i = builder.orderStage;
        this.f51086l = builder.travelMode;
        this.f51085k = builder.caller;
        this.f51087m = builder.countryId;
        this.f51089o = builder.travelId;
        this.f51088n = builder.traceInfo;
        this.f51091q = builder.oidPidPairs;
        this.f51090p = builder.driverId;
        this.f51092r = builder.recentLocList;
        this.f51093s = builder.bizGroup;
    }

    public String checkParam() {
        CallFrom callFrom;
        if (this.f51075a == null) {
            return "bizType";
        }
        if (this.f51076b == 0.0d) {
            return "startLat";
        }
        if (this.f51077c == 0.0d) {
            return "startLng";
        }
        if (this.f51078d == 0.0d) {
            return "endLat";
        }
        if (this.f51079e == 0.0d || (callFrom = this.f51085k) == null || callFrom.equals(CallFrom.UNKNOWN)) {
            return "endLng";
        }
        if (TextUtils.isEmpty(this.f51080f)) {
            return "token";
        }
        return null;
    }

    public static class Builder {
        int bizGroup;
        BizType bizType;
        CallFrom caller = CallFrom.UNKNOWN;
        String countryId;
        long driverId;
        double endLat;
        double endLng;
        List<OdPoint> odPoints;
        List<OidPidPair> oidPidPairs = Collections.emptyList();
        int orderStage;
        String phoneNum;
        String productId;
        List<GpsLocation> recentLocList;
        double startLat;
        double startLng;
        String token;
        String traceInfo;
        String travelId;
        TravelMode travelMode;

        public Builder(BizType bizType2, double d, double d2, double d3, double d4, String str) {
            this.bizType = bizType2;
            this.startLat = d;
            this.startLng = d2;
            this.endLat = d3;
            this.endLng = d4;
            this.token = str;
        }

        public Builder setProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder setPhoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder setOrderStage(int i) {
            this.orderStage = i;
            return this;
        }

        public Builder setOdPoints(List<OdPoint> list) {
            this.odPoints = list;
            return this;
        }

        public Builder setTravelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder setCaller(CallFrom callFrom) {
            this.caller = callFrom;
            return this;
        }

        public Builder setCountryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder setTravelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder setTraceInfo(String str) {
            this.traceInfo = str;
            return this;
        }

        public Builder setBizGroup(int i) {
            this.bizGroup = i;
            return this;
        }

        public Builder setOidPidPairsList(List<OidPidPair> list) {
            this.oidPidPairs = list;
            return this;
        }

        public Builder setDriverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder setRecentLocList(List<GpsLocation> list) {
            this.recentLocList = list;
            return this;
        }

        public RouteSearchParam build() {
            return new RouteSearchParam(this);
        }
    }
}
