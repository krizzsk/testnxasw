package com.didi.map.global.sctx.model;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.List;
import java.util.Objects;

public class SctxTripParam {

    /* renamed from: A */
    private final long f30104A;

    /* renamed from: B */
    private SctxService.SctxSearchGetter f30105B;

    /* renamed from: C */
    private VamosExpansionParam f30106C;

    /* renamed from: D */
    private boolean f30107D;

    /* renamed from: E */
    private int f30108E;

    /* renamed from: F */
    private int f30109F;

    /* renamed from: G */
    private boolean f30110G;

    /* renamed from: H */
    private TravelMode f30111H;

    /* renamed from: I */
    private int f30112I;

    /* renamed from: J */
    private boolean f30113J;

    /* renamed from: a */
    private final Map f30114a;

    /* renamed from: b */
    private final Context f30115b;

    /* renamed from: c */
    private final Context f30116c;

    /* renamed from: d */
    private final String f30117d;

    /* renamed from: e */
    private final String f30118e;

    /* renamed from: f */
    private final int f30119f;

    /* renamed from: g */
    private final int f30120g;

    /* renamed from: h */
    private final boolean f30121h;
    protected transient int hashCode;

    /* renamed from: i */
    private final long f30122i;

    /* renamed from: j */
    private final List<OdPoint> f30123j;

    /* renamed from: k */
    private final LatLng f30124k;

    /* renamed from: l */
    private final LatLng f30125l;

    /* renamed from: m */
    private final String f30126m;

    /* renamed from: n */
    private final long f30127n;

    /* renamed from: o */
    private final String f30128o;

    /* renamed from: p */
    private final String f30129p;

    /* renamed from: q */
    private final boolean f30130q;

    /* renamed from: r */
    private final boolean f30131r;

    /* renamed from: s */
    private final String f30132s;

    /* renamed from: t */
    private final String f30133t;

    /* renamed from: u */
    private final String f30134u;

    /* renamed from: v */
    private final BitmapDescriptor f30135v;

    /* renamed from: w */
    private final boolean f30136w;

    /* renamed from: x */
    private final List<String> f30137x;

    /* renamed from: y */
    private final int f30138y;

    /* renamed from: z */
    private final long f30139z;

    public String getOrderId() {
        return this.f30118e;
    }

    public int getBizType() {
        return this.f30119f;
    }

    public int getTripState() {
        return this.f30120g;
    }

    public boolean isArrivedPickupPoint() {
        return this.f30121h;
    }

    public LatLng getPickupPoint() {
        return this.f30124k;
    }

    public LatLng getEndPoint() {
        return this.f30125l;
    }

    public String getToken() {
        return this.f30126m;
    }

    public long getDriverId() {
        return this.f30127n;
    }

    public String getTripId() {
        return this.f30128o;
    }

    public String getLastOrderId() {
        return this.f30129p;
    }

    public boolean isShowExtendedAnimation() {
        return this.f30130q;
    }

    public boolean isReadOnly() {
        return this.f30131r;
    }

    public String getClientVersion() {
        return this.f30132s;
    }

    public String getCountryId() {
        return this.f30133t;
    }

    public String getImei() {
        return this.f30134u;
    }

    public Map getMap() {
        return this.f30114a;
    }

    public Context getContext() {
        return this.f30115b;
    }

    public Context getActivityContext() {
        return this.f30116c;
    }

    public String getPassengerPhone() {
        return this.f30117d;
    }

    public BitmapDescriptor getCarBitmapDescriptor() {
        return this.f30135v;
    }

    public boolean isIs3DEnabled() {
        return this.f30136w;
    }

    public List<String> getCar3DIcons() {
        return this.f30137x;
    }

    public int getzIndex() {
        return this.f30138y;
    }

    public long getRouteExtensionAnimationDuration() {
        return this.f30139z;
    }

    public long getOraRequestInterval() {
        return this.f30104A;
    }

    public long getWayPointsTimestamp() {
        return this.f30122i;
    }

    public List<OdPoint> getWayPoints() {
        return this.f30123j;
    }

    public SctxService.SctxSearchGetter getSctxSearchGetter() {
        return this.f30105B;
    }

    public VamosExpansionParam getVamosExpansionParam() {
        return this.f30106C;
    }

    public void dispose() {
        this.f30105B = null;
    }

    public boolean isNewVersion() {
        return this.f30107D;
    }

    public boolean showRecommendPickupPoint() {
        return this.f30110G;
    }

    public int getLineColor() {
        return this.f30108E;
    }

    public int getLineWidth() {
        return this.f30109F;
    }

    public TravelMode getTravelMode() {
        return this.f30111H;
    }

    public int getBizGroup() {
        return this.f30112I;
    }

    public boolean isBackgroundOra() {
        return this.f30113J;
    }

    private SctxTripParam(Builder builder) {
        this.hashCode = 0;
        this.f30111H = TravelMode.DRIVING;
        this.f30118e = builder.orderId;
        this.f30119f = builder.bizType;
        this.f30120g = builder.tripState;
        this.f30121h = builder.isArrivedPickupPoint;
        this.f30122i = builder.wayPointsTimestamp;
        this.f30123j = builder.wayPoints;
        this.f30124k = builder.pickupPoint;
        this.f30125l = builder.endPoint;
        this.f30126m = builder.token;
        this.f30127n = builder.driverId;
        this.f30128o = builder.tripId;
        this.f30129p = builder.lastOrderId;
        this.f30130q = builder.isShowExtendedAnimation;
        this.f30131r = builder.isReadOnly;
        this.f30132s = builder.clientVersion;
        this.f30133t = builder.countryId;
        this.f30134u = builder.imei;
        this.f30135v = builder.carBitmapDescriptor;
        this.f30136w = builder.is3DEnabled;
        this.f30137x = builder.car3DIcons;
        this.f30138y = builder.zIndex;
        this.f30105B = builder.sctxSearchGetter;
        this.f30139z = builder.routeExtensionAnimationDuration;
        this.f30104A = builder.oraRequestInterval;
        this.f30106C = builder.vamosExpansionParam;
        this.f30114a = builder.map;
        this.f30115b = builder.context;
        this.f30116c = builder.activityContext;
        this.f30117d = builder.passengerPhone;
        this.f30107D = builder.newVersion;
        this.f30110G = builder.showRecommendPickupPoint;
        this.f30108E = builder.lineColor;
        this.f30109F = builder.lineWidth;
        this.f30111H = builder.travelMode;
        this.f30112I = builder.bizGroup;
        this.f30113J = builder.backgroundOra;
    }

    public static class Builder {
        Context activityContext;
        boolean backgroundOra;
        int bizGroup;
        int bizType;
        boolean bluetoothNotify;
        List<String> car3DIcons;
        BitmapDescriptor carBitmapDescriptor;
        String clientVersion;
        Context context;
        String countryId;
        long driverId;
        LatLng endPoint;
        String imei;
        boolean is3DEnabled;
        boolean isArrivedPickupPoint;
        boolean isReadOnly;
        boolean isShowExtendedAnimation;
        String lastOrderId;
        int lineColor;
        int lineWidth;
        Map map;
        boolean newVersion;
        LatLng oasisDriverEndPoint;
        long oraRequestInterval;
        String orderId;
        String passengerPhone;
        LatLng pickupPoint;
        long routeExtensionAnimationDuration;
        SctxService.SctxSearchGetter sctxSearchGetter;
        boolean showRecommendPickupPoint;
        String token;
        TravelMode travelMode;
        String tripId;
        int tripState;
        VamosExpansionParam vamosExpansionParam;
        List<OdPoint> wayPoints;
        long wayPointsTimestamp;
        int zIndex;

        public SctxTripParam build() {
            return new SctxTripParam(this);
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder bizType(int i) {
            this.bizType = i;
            return this;
        }

        public Builder tripState(int i) {
            this.tripState = i;
            return this;
        }

        public Builder pickupPoint(LatLng latLng) {
            this.pickupPoint = latLng;
            return this;
        }

        public Builder endPoint(LatLng latLng) {
            this.endPoint = latLng;
            return this;
        }

        public Builder oasisDriverEndPoint(LatLng latLng) {
            this.oasisDriverEndPoint = latLng;
            return this;
        }

        public Builder isArrivedPickupPoint(boolean z) {
            this.isArrivedPickupPoint = z;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder tripId(String str) {
            this.tripId = str;
            return this;
        }

        public Builder driverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder isShowExtendedAnimation(boolean z) {
            this.isShowExtendedAnimation = z;
            return this;
        }

        public Builder isReadOnly(boolean z) {
            this.isReadOnly = z;
            return this;
        }

        public Builder lastOrderId(String str) {
            this.lastOrderId = str;
            return this;
        }

        public Builder clientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder carBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
            this.carBitmapDescriptor = bitmapDescriptor;
            return this;
        }

        public Builder car3DIcons(List<String> list) {
            this.car3DIcons = list;
            return this;
        }

        public Builder car3DEnabled(boolean z) {
            this.is3DEnabled = z;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder routeExtensionAnimationDuration(long j) {
            this.routeExtensionAnimationDuration = j;
            return this;
        }

        public Builder oraRequestInterval(long j) {
            this.oraRequestInterval = j;
            return this;
        }

        public Builder map(Map map2) {
            this.map = map2;
            return this;
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder activityContext(Context context2) {
            this.activityContext = context2;
            return this;
        }

        public Builder passengerPhone(String str) {
            this.passengerPhone = str;
            return this;
        }

        public Builder wayPointsTimestamp(long j) {
            this.wayPointsTimestamp = j;
            return this;
        }

        public Builder wayPoints(List<OdPoint> list) {
            this.wayPoints = list;
            return this;
        }

        public Builder vamosExpansionParam(VamosExpansionParam vamosExpansionParam2) {
            this.vamosExpansionParam = vamosExpansionParam2;
            return this;
        }

        public Builder sctxSearchGetter(SctxService.SctxSearchGetter sctxSearchGetter2) {
            this.sctxSearchGetter = sctxSearchGetter2;
            return this;
        }

        public Builder newVersion(boolean z) {
            this.newVersion = z;
            return this;
        }

        public Builder showRecommendPickupPoint(boolean z) {
            this.showRecommendPickupPoint = z;
            return this;
        }

        public Builder lineColor(int i) {
            this.lineColor = i;
            return this;
        }

        public Builder lineWidth(int i) {
            this.lineWidth = i;
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder enableBluetoothNotify(boolean z) {
            this.bluetoothNotify = z;
            return this;
        }

        public Builder bizGroup(int i) {
            this.bizGroup = i;
            return this;
        }

        public Builder backgroundOra(boolean z) {
            this.backgroundOra = z;
            return this;
        }
    }

    public boolean isSameParam(SctxTripParam sctxTripParam) {
        if (sctxTripParam == this) {
            return true;
        }
        if (m23440a(this.f30115b, sctxTripParam.f30115b) && m23440a(this.f30116c, sctxTripParam.f30116c) && m23440a(this.f30114a, sctxTripParam.f30114a) && m23440a(this.f30118e, sctxTripParam.f30118e) && m23440a(this.f30124k, sctxTripParam.f30124k) && m23440a(this.f30125l, sctxTripParam.f30125l)) {
            VamosExpansionParam vamosExpansionParam = this.f30106C;
            LatLng latLng = null;
            LatLng latLng2 = vamosExpansionParam == null ? null : vamosExpansionParam.driverTripDestPoint;
            VamosExpansionParam vamosExpansionParam2 = sctxTripParam.f30106C;
            if (vamosExpansionParam2 != null) {
                latLng = vamosExpansionParam2.driverTripDestPoint;
            }
            if (!m23440a(latLng2, latLng) || !m23440a(Integer.valueOf(this.f30120g), Integer.valueOf(sctxTripParam.f30120g)) || !m23440a(Integer.valueOf(this.f30119f), Integer.valueOf(sctxTripParam.f30119f)) || !m23440a(this.f30117d, sctxTripParam.f30117d) || !m23440a(Long.valueOf(this.f30127n), Long.valueOf(sctxTripParam.f30127n)) || !m23440a(this.f30134u, sctxTripParam.f30134u) || !m23440a(this.f30126m, sctxTripParam.f30126m) || !m23440a(this.f30132s, sctxTripParam.f30132s) || !m23440a(this.f30129p, sctxTripParam.f30129p) || !m23440a(this.f30133t, sctxTripParam.f30133t) || !m23440a(this.f30128o, sctxTripParam.f30128o) || !m23440a(Boolean.valueOf(this.f30131r), Boolean.valueOf(sctxTripParam.f30131r)) || !m23440a(Long.valueOf(this.f30122i), Long.valueOf(sctxTripParam.f30122i)) || !m23440a(Boolean.valueOf(this.f30107D), Boolean.valueOf(sctxTripParam.f30107D)) || !m23440a(Boolean.valueOf(this.f30110G), Boolean.valueOf(sctxTripParam.f30110G)) || !m23440a(Integer.valueOf(this.f30108E), Integer.valueOf(sctxTripParam.f30108E)) || !m23440a(Integer.valueOf(this.f30109F), Integer.valueOf(sctxTripParam.f30109F)) || !m23440a(this.f30111H, sctxTripParam.f30111H) || !m23440a(Integer.valueOf(this.f30112I), Integer.valueOf(sctxTripParam.f30112I)) || this.f30113J != sctxTripParam.f30113J) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m23440a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }
}
