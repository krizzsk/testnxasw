package com.didi.map.sdk.env;

import java.util.HashMap;

public class PaxEnvironment {

    /* renamed from: a */
    private static PaxEnvironment f30722a;

    /* renamed from: b */
    private IBizDataGetter f30723b = null;

    /* renamed from: c */
    private RoleType f30724c = RoleType.PASSENGER;

    /* renamed from: d */
    private Page f30725d = Page.OTHER_PAGE;

    /* renamed from: e */
    private Page f30726e = Page.OTHER_PAGE;

    /* renamed from: f */
    private PointType f30727f = PointType.OTHER;

    /* renamed from: g */
    private final HashMap<String, Object> f30728g = new HashMap<>();

    public static PaxEnvironment getInstance() {
        synchronized (PaxEnvironment.class) {
            if (f30722a == null) {
                f30722a = new PaxEnvironment();
            }
        }
        return f30722a;
    }

    public String getAppVersion() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getAppVersion();
    }

    public void setBizDataGetter(IBizDataGetter iBizDataGetter) {
        this.f30723b = iBizDataGetter;
    }

    public String getPhoneNumber() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getPhoneNumber();
    }

    public String getToken() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getToken();
    }

    public String getUid() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getUid();
    }

    public String getProductId() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "30008";
        }
        return iBizDataGetter.getProductId();
    }

    public int getCityId() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return 0;
        }
        return iBizDataGetter.getCityId();
    }

    public String getCountryCode() {
        IBizDataGetter iBizDataGetter = this.f30723b;
        if (iBizDataGetter == null) {
            return "";
        }
        return iBizDataGetter.getCountryCode();
    }

    public RoleType getRoleType() {
        return this.f30724c;
    }

    public void setRoleTypeInternal(RoleType roleType) {
        this.f30724c = roleType;
    }

    public Page getPage() {
        return this.f30725d;
    }

    public void setPage(Page page) {
        Page page2 = this.f30725d;
        if (page2 != null) {
            this.f30726e = page2;
            this.f30725d = page;
        }
    }

    public Page getEntrance() {
        return this.f30726e;
    }

    public void setPointType(PointType pointType) {
        if (pointType != null) {
            this.f30727f = pointType;
        }
    }

    public PointType getPointType() {
        return this.f30727f;
    }

    public Object getCache(String str) {
        return this.f30728g.get(str);
    }

    public void setCache(String str, Object obj) {
        this.f30728g.put(str, obj);
    }
}
