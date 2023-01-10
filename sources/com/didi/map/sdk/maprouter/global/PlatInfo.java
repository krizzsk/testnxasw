package com.didi.map.sdk.maprouter.global;

import com.didi.map.sdk.maprouter.MapType;
import com.didi.map.sdk.maprouter.OnNavTtsListener;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.Locale;

public class PlatInfo {

    /* renamed from: a */
    private static final String f30764a = "GlobalInfo";

    /* renamed from: b */
    private static PlatInfo f30765b;

    /* renamed from: c */
    private String f30766c = "";

    /* renamed from: d */
    private String f30767d = "";

    /* renamed from: e */
    private String f30768e = "";

    /* renamed from: f */
    private String f30769f = "";

    /* renamed from: g */
    private long f30770g;

    /* renamed from: h */
    private String f30771h = "";

    /* renamed from: i */
    private int f30772i = 0;

    /* renamed from: j */
    private String f30773j = "";

    /* renamed from: k */
    private String f30774k = "";

    /* renamed from: l */
    private OnNavTtsListener f30775l = null;

    /* renamed from: m */
    private int f30776m = -1;

    /* renamed from: n */
    private String f30777n = "";

    /* renamed from: o */
    private int f30778o = 0;

    /* renamed from: p */
    private String f30779p = "";

    /* renamed from: q */
    private String f30780q = "";

    /* renamed from: r */
    private int f30781r = -1;

    /* renamed from: s */
    private MapType f30782s = MapType.google;

    /* renamed from: t */
    private boolean f30783t = true;

    public String getCountryLanguage() {
        return this.f30766c;
    }

    public void setCountryLanguage(String str) {
        this.f30766c = str;
    }

    public static PlatInfo getInstance() {
        synchronized (PlatInfo.class) {
            if (f30765b == null) {
                f30765b = new PlatInfo();
            }
        }
        return f30765b;
    }

    public String getClientVersion() {
        return this.f30767d;
    }

    public void setClientVersion(String str) {
        this.f30767d = str;
    }

    public int getBizType() {
        return this.f30772i;
    }

    public void setBizType(int i) {
        this.f30772i = i;
    }

    @Deprecated
    public String getCountryID() {
        return this.f30773j;
    }

    @Deprecated
    public void setCountryID(String str) {
        this.f30773j = str;
    }

    public String getCountryCode() {
        return this.f30774k;
    }

    public void setCountryCode(String str) {
        this.f30774k = str;
    }

    public String getDriverPhoneNumber() {
        return this.f30768e;
    }

    public void setDriverPhoneNumber(String str) {
        this.f30768e = str;
    }

    public String getDriverTicket() {
        return this.f30769f;
    }

    public void setDriverTicket(String str) {
        this.f30769f = str;
    }

    public long getDriverId() {
        return this.f30770g;
    }

    public void setDriverId(long j) {
        this.f30770g = j;
    }

    public String getTraverId() {
        return this.f30771h;
    }

    public void setTraverId(String str) {
        this.f30771h = str;
    }

    public MapType getMapType() {
        return this.f30782s;
    }

    public void setMapType(MapType mapType) {
        this.f30782s = mapType;
    }

    public void setOnNavTtsListener(OnNavTtsListener onNavTtsListener) {
        this.f30775l = onNavTtsListener;
    }

    public OnNavTtsListener getOnNavTtsListener() {
        return this.f30775l;
    }

    public String toString() {
        return String.format(Locale.CHINA, "PlatInfo:(clientVersion=%s,driverPhoneNumber =%s,driverTicket =%s,driverId =%d, traverId= %s,bizType = %d,countryID= %s,countryCode= %s)", new Object[]{this.f30767d, this.f30768e, this.f30769f, Long.valueOf(this.f30770g), this.f30771h, Integer.valueOf(this.f30772i), this.f30773j, this.f30774k});
    }

    public int getOrderStage() {
        return this.f30776m;
    }

    public void setOrderStage(int i) {
        this.f30776m = i;
    }

    public boolean isPushConnect() {
        return this.f30783t;
    }

    public void setPushConnect(boolean z) {
        this.f30783t = z;
    }

    public String getDomainFlavor() {
        return this.f30777n;
    }

    public void setDomainFlavor(String str) {
        this.f30777n = str;
    }

    public String getPoiMapDomain() {
        String str = this.f30780q;
        if (str != null && str.length() > 0) {
            return this.f30780q;
        }
        return "https://poimap" + this.f30777n + ".didiglobal.com";
    }

    public String getApiMapDomain() {
        String str = this.f30779p;
        if (str != null && str.length() > 0) {
            return this.f30779p;
        }
        return "https://apimap" + this.f30777n + ".didiglobal.com";
    }

    public int getTerminalId() {
        return this.f30781r;
    }

    public void setTerminalId(int i) {
        this.f30781r = i;
    }

    public TravelMode getTravelMode() {
        int i = this.f30778o;
        if (i == 0) {
            return TravelMode.DRIVING;
        }
        if (i == 1) {
            return TravelMode.WALKING;
        }
        if (i == 2) {
            return TravelMode.BYCYCLING;
        }
        if (i != 3) {
            return TravelMode.DRIVING;
        }
        return TravelMode.TWOWHEELER;
    }

    public int getTravelModeNum() {
        return this.f30778o;
    }

    public void setTravelModeNum(int i) {
        this.f30778o = i;
    }

    public boolean isCanoe() {
        int i = this.f30781r;
        return i == 300302 || i == 300301;
    }

    public String getFullDomainApiMap() {
        return this.f30779p;
    }

    public void setFullDomainApiMap(String str) {
        this.f30779p = str;
    }

    public String getFullDomainPoiMap() {
        return this.f30780q;
    }

    public void setFullDomainPoiMap(String str) {
        this.f30780q = str;
    }
}
