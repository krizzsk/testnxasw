package com.didi.beatles.p101im.p102db.entity;

/* renamed from: com.didi.beatles.im.db.entity.IMUserDaoEntity */
public class IMUserDaoEntity {

    /* renamed from: a */
    private long f11040a;

    /* renamed from: b */
    private String f11041b;

    /* renamed from: c */
    private String f11042c;

    /* renamed from: d */
    private int f11043d;

    /* renamed from: e */
    private String f11044e;

    /* renamed from: f */
    private String f11045f;

    public IMUserDaoEntity() {
    }

    public IMUserDaoEntity(long j, String str, String str2, int i, String str3, String str4) {
        this.f11040a = j;
        this.f11041b = str;
        this.f11042c = str2;
        this.f11043d = i;
        this.f11044e = str3;
        this.f11045f = str4;
    }

    public long getUser_id() {
        return this.f11040a;
    }

    public void setUser_id(long j) {
        this.f11040a = j;
    }

    public String getUser_name() {
        return this.f11041b;
    }

    public void setUser_name(String str) {
        this.f11041b = str;
    }

    public String getAvatar_url() {
        return this.f11042c;
    }

    public void setAvatar_url(String str) {
        this.f11042c = str;
    }

    public int getM_icon() {
        return this.f11043d;
    }

    public void setM_icon(int i) {
        this.f11043d = i;
    }

    public String getReserveStr1() {
        return this.f11044e;
    }

    public void setReserveStr1(String str) {
        this.f11044e = str;
    }

    public String getReserveStr2() {
        return this.f11045f;
    }

    public void setReserveStr2(String str) {
        this.f11045f = str;
    }
}
