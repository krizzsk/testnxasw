package com.didi.foundation.sdk.liveconnection;

import android.content.Context;

public class Option {

    /* renamed from: a */
    private Context f23048a;

    /* renamed from: b */
    private String f23049b;

    /* renamed from: c */
    private String f23050c;

    /* renamed from: d */
    private int f23051d;

    /* renamed from: e */
    private String f23052e;

    /* renamed from: f */
    private int f23053f;

    /* renamed from: g */
    private double f23054g;

    /* renamed from: h */
    private double f23055h;

    /* renamed from: i */
    private int f23056i;

    /* renamed from: j */
    private int f23057j;

    /* renamed from: k */
    private String f23058k;

    public Option() {
    }

    public Option(Context context, String str, String str2, int i, String str3, int i2, double d, double d2, int i3, int i4, String str4) {
        this.f23048a = context;
        this.f23049b = str;
        this.f23050c = str2;
        this.f23051d = i;
        this.f23052e = str3;
        this.f23053f = i2;
        this.f23054g = d;
        this.f23055h = d2;
        this.f23056i = i3;
        this.f23057j = i4;
        this.f23058k = str4;
    }

    public String getAppId() {
        return this.f23058k;
    }

    public Context getContext() {
        return this.f23048a;
    }

    public void setAppId(String str) {
        this.f23058k = str;
    }

    public void setContext(Context context) {
        this.f23048a = context;
    }

    public String getPhone() {
        return this.f23049b;
    }

    public void setPhone(String str) {
        this.f23049b = str;
    }

    public String getToken() {
        return this.f23050c;
    }

    public void setToken(String str) {
        this.f23050c = str;
    }

    public int getRole() {
        return this.f23051d;
    }

    public void setRole(int i) {
        this.f23051d = i;
    }

    public String getIp() {
        return this.f23052e;
    }

    public void setIp(String str) {
        this.f23052e = str;
    }

    public int getPort() {
        return this.f23053f;
    }

    public void setPort(int i) {
        this.f23053f = i;
    }

    public double getLatitude() {
        return this.f23054g;
    }

    public void setLatitude(double d) {
        this.f23054g = d;
    }

    public double getLongitude() {
        return this.f23055h;
    }

    public void setLongitude(double d) {
        this.f23055h = d;
    }

    public int getCityId() {
        return this.f23056i;
    }

    public void setCityId(int i) {
        this.f23056i = i;
    }

    public int getFlowTag() {
        return this.f23057j;
    }

    public void setFlowTag(int i) {
        this.f23057j = i;
    }
}
