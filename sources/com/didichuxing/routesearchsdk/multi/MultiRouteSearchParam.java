package com.didichuxing.routesearchsdk.multi;

import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class MultiRouteSearchParam {

    /* renamed from: a */
    private String f51115a;

    /* renamed from: b */
    private String f51116b;

    /* renamed from: c */
    private String f51117c;

    /* renamed from: d */
    private String f51118d;

    /* renamed from: e */
    private long f51119e;

    /* renamed from: f */
    private CallFrom f51120f;

    /* renamed from: g */
    private int f51121g;

    /* renamed from: h */
    private String f51122h;

    /* renamed from: i */
    private String f51123i;

    /* renamed from: j */
    private List<SingleRouteReqParam> f51124j;

    public long getPassengerId() {
        return this.f51119e;
    }

    public String getToken() {
        return this.f51115a;
    }

    public String getPhoneNum() {
        return this.f51116b;
    }

    public String getCountryId() {
        return this.f51117c;
    }

    public String getProductId() {
        return this.f51118d;
    }

    public CallFrom getCaller() {
        return this.f51120f;
    }

    public int getOrderStage() {
        return this.f51121g;
    }

    public String getDidiVersion() {
        return this.f51122h;
    }

    public String getOrderId() {
        return this.f51123i;
    }

    public List<SingleRouteReqParam> getRouteReq() {
        return this.f51124j;
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, List<SingleRouteReqParam> list) {
        this(str, str2, str3, str4, j, callFrom, 0, (String) null, (String) null, list);
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, String str5, List<SingleRouteReqParam> list) {
        this(str, str2, str3, str4, j, callFrom, 0, (String) null, str5, list);
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, int i, String str5, String str6, List<SingleRouteReqParam> list) {
        this.f51115a = str;
        this.f51116b = str2;
        this.f51117c = str3;
        this.f51118d = str4;
        this.f51120f = callFrom;
        this.f51124j = list;
        this.f51119e = j;
        this.f51121g = i;
        this.f51122h = str5;
        this.f51123i = str6;
    }
}
