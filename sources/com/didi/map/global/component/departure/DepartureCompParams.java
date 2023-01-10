package com.didi.map.global.component.departure;

import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.CallFrom;

public class DepartureCompParams {

    /* renamed from: a */
    private long f27113a;

    /* renamed from: b */
    private DepartureLocationInfo f27114b;

    /* renamed from: c */
    private CallFrom f27115c;

    /* renamed from: d */
    private RecPointStyle f27116d;

    /* renamed from: e */
    private PinStyle f27117e;

    /* renamed from: f */
    private DepartureFenceOptions f27118f;

    /* renamed from: g */
    private boolean f27119g;

    /* renamed from: h */
    private boolean f27120h;

    /* renamed from: i */
    private boolean f27121i;

    /* renamed from: j */
    private boolean f27122j;

    /* renamed from: k */
    private boolean f27123k;

    /* renamed from: l */
    private boolean f27124l;

    /* renamed from: m */
    private int f27125m;

    /* renamed from: n */
    private boolean f27126n;

    /* renamed from: o */
    private boolean f27127o;

    /* renamed from: p */
    private float f27128p = -1.0f;

    /* renamed from: q */
    private boolean f27129q;

    /* renamed from: r */
    private ApiType f27130r;

    /* renamed from: s */
    private NLPRegisterParam f27131s;

    /* renamed from: t */
    private ZoneCircleOption f27132t;

    /* renamed from: u */
    private int f27133u;

    /* renamed from: v */
    private boolean f27134v;

    /* renamed from: w */
    private boolean f27135w;

    /* renamed from: x */
    private Address f27136x;

    public NLPRegisterParam getNlpRegisterParam() {
        return this.f27131s;
    }

    public ZoneCircleOption getCircleOptions() {
        return this.f27132t;
    }

    public boolean isHasWayPoint() {
        return this.f27135w;
    }

    public Address getEndPoint() {
        return this.f27136x;
    }

    public int getSceneType() {
        return this.f27133u;
    }

    public long getDepartureTime() {
        return this.f27113a;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f27114b;
    }

    public CallFrom getReqCallerId() {
        return this.f27115c;
    }

    public RecPointStyle getRecStyle() {
        return this.f27116d;
    }

    public PinStyle getPinStyle() {
        return this.f27117e;
    }

    public boolean isPinVisible() {
        return this.f27119g;
    }

    public boolean isRecPointVisible() {
        return this.f27120h;
    }

    public boolean isTerminalViewVisible() {
        return this.f27126n;
    }

    public boolean isConfirmPickupCardViewVisible() {
        return this.f27127o;
    }

    public boolean isFenceVisible() {
        return this.f27121i;
    }

    public float getZoom() {
        return this.f27128p;
    }

    public boolean isRequireByDrag() {
        return this.f27129q;
    }

    public ApiType getApiType() {
        return this.f27130r;
    }

    public boolean isBubbleVisible() {
        return this.f27122j;
    }

    public boolean isGuideLineVisible() {
        return this.f27123k;
    }

    public boolean isWalkDropVisible() {
        return this.f27124l;
    }

    public int getGuideLineColor() {
        return this.f27125m;
    }

    public DepartureFenceOptions getFenceOptions() {
        return this.f27118f;
    }

    public ZoneCircleOption getCircleOption() {
        return this.f27132t;
    }

    public boolean isCacheEnable() {
        return this.f27134v;
    }

    public DepartureCompParams(Builder builder) {
        this.f27114b = builder.locationInfo;
        this.f27115c = builder.reqCallerId;
        this.f27116d = builder.recStyle;
        this.f27117e = builder.pinStyle;
        this.f27128p = builder.zoom;
        this.f27121i = builder.isFenceVisible;
        this.f27119g = builder.isPinVisible;
        this.f27122j = builder.isBubbleVisible;
        this.f27113a = builder.departureTime;
        this.f27120h = builder.isRecPointVisible;
        this.f27126n = builder.isTerminalViewVisible;
        this.f27127o = builder.isConfirmPickupCardViewVisible;
        this.f27129q = builder.requireByDrag;
        this.f27123k = builder.isGuideLineVisible;
        this.f27125m = builder.guideLineColor;
        this.f27118f = builder.fenceOptions;
        this.f27132t = builder.circleOptions;
        this.f27133u = builder.sceneType;
        this.f27134v = builder.isCacheEnable;
        this.f27131s = builder.nlpRegisterParam;
        if (builder.apiType == null) {
            this.f27130r = ApiType.DEPARTURE_POI_INFO;
        } else {
            this.f27130r = builder.apiType;
        }
        this.f27135w = builder.hasWayPoint;
        this.f27136x = builder.endPoint;
        this.f27124l = builder.isWalkDropVisible;
    }

    public static class Builder {
        ApiType apiType = ApiType.DEPARTURE_POI_INFO;
        /* access modifiers changed from: private */
        public ZoneCircleOption circleOptions;
        /* access modifiers changed from: private */
        public long departureTime;
        /* access modifiers changed from: private */
        public Address endPoint;
        /* access modifiers changed from: private */
        public DepartureFenceOptions fenceOptions;
        /* access modifiers changed from: private */
        public int guideLineColor;
        /* access modifiers changed from: private */
        public boolean hasWayPoint;
        /* access modifiers changed from: private */
        public boolean isBubbleVisible;
        /* access modifiers changed from: private */
        public boolean isCacheEnable;
        /* access modifiers changed from: private */
        public boolean isConfirmPickupCardViewVisible;
        /* access modifiers changed from: private */
        public boolean isFenceVisible;
        /* access modifiers changed from: private */
        public boolean isGuideLineVisible;
        /* access modifiers changed from: private */
        public boolean isPinVisible;
        /* access modifiers changed from: private */
        public boolean isRecPointVisible;
        /* access modifiers changed from: private */
        public boolean isTerminalViewVisible = true;
        /* access modifiers changed from: private */
        public boolean isWalkDropVisible;
        /* access modifiers changed from: private */
        public DepartureLocationInfo locationInfo;
        /* access modifiers changed from: private */
        public NLPRegisterParam nlpRegisterParam;
        /* access modifiers changed from: private */
        public PinStyle pinStyle;
        /* access modifiers changed from: private */
        public RecPointStyle recStyle;
        CallFrom reqCallerId = null;
        /* access modifiers changed from: private */
        public boolean requireByDrag;
        /* access modifiers changed from: private */
        public int sceneType = 0;
        /* access modifiers changed from: private */
        public float zoom = -1.0f;

        public Builder setEndPoint(Address address) {
            this.endPoint = address;
            return this;
        }

        public Builder hasWayPoint(boolean z) {
            this.hasWayPoint = z;
            return this;
        }

        public Builder departureTime(long j) {
            this.departureTime = j;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            this.locationInfo = departureLocationInfo;
            return this;
        }

        public Builder recStyle(RecPointStyle recPointStyle) {
            this.recStyle = recPointStyle;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder fenceOptions(DepartureFenceOptions departureFenceOptions) {
            this.fenceOptions = departureFenceOptions;
            return this;
        }

        public Builder zoom(float f) {
            this.zoom = f;
            return this;
        }

        public Builder callFrom(CallFrom callFrom) {
            this.reqCallerId = callFrom;
            return this;
        }

        public Builder isPinVisible(boolean z) {
            this.isPinVisible = z;
            return this;
        }

        public Builder isRecPointVisible(boolean z) {
            this.isRecPointVisible = z;
            return this;
        }

        public Builder isFenceVisible(boolean z) {
            this.isFenceVisible = z;
            return this;
        }

        public Builder isBubbleVisible(boolean z) {
            this.isBubbleVisible = z;
            return this;
        }

        public Builder guideLineColor(int i) {
            this.guideLineColor = i;
            return this;
        }

        public Builder isGuideLineVisible(boolean z) {
            this.isGuideLineVisible = z;
            return this;
        }

        public Builder isTerminalViewVisible(boolean z) {
            this.isTerminalViewVisible = z;
            return this;
        }

        public Builder isConfirmPickupPointCardViewVisible(boolean z) {
            this.isConfirmPickupCardViewVisible = z;
            return this;
        }

        public Builder requireByDrag(boolean z) {
            this.requireByDrag = z;
            return this;
        }

        public Builder apiType(ApiType apiType2) {
            this.apiType = apiType2;
            return this;
        }

        public Builder zoneCircleOptions(ZoneCircleOption zoneCircleOption) {
            this.circleOptions = zoneCircleOption;
            return this;
        }

        public Builder sceneType(int i) {
            this.sceneType = i;
            return this;
        }

        public Builder cacheEnable(boolean z) {
            this.isCacheEnable = z;
            return this;
        }

        public Builder isWalkDropVisible(boolean z) {
            this.isWalkDropVisible = z;
            return this;
        }

        public Builder setNlpRegisterParam(NLPRegisterParam nLPRegisterParam) {
            this.nlpRegisterParam = nLPRegisterParam;
            return this;
        }

        public DepartureCompParams build() {
            return new DepartureCompParams(this);
        }
    }
}
