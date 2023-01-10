package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import com.didichuxing.mas.sdk.quality.report.utils.ApiSigner;
import com.threatmetrix.TrustDefender.yyqyyy;
import didihttpdns.p233db.DnsConstants;
import java.util.HashMap;

public class HeartbeatMessage {

    /* renamed from: a */
    private int f50730a;

    /* renamed from: b */
    private String f50731b;

    /* renamed from: c */
    private int f50732c;

    /* renamed from: d */
    private int f50733d;

    /* renamed from: e */
    private double f50734e;

    /* renamed from: f */
    private double f50735f;

    /* renamed from: g */
    private long f50736g;

    /* renamed from: h */
    private int f50737h;

    /* renamed from: i */
    private String f50738i;

    /* renamed from: j */
    private String f50739j;

    /* renamed from: k */
    private int f50740k;

    /* renamed from: l */
    private int f50741l;

    /* renamed from: m */
    private int f50742m;

    public void setCityId(int i) {
        this.f50730a = i;
    }

    public void setUid(String str) {
        this.f50731b = str;
    }

    public void setNetMode(int i) {
        this.f50732c = i;
    }

    public void setCarrier(int i) {
        this.f50733d = i;
    }

    public void setLat(double d) {
        this.f50734e = d;
    }

    public void setLng(double d) {
        this.f50735f = d;
    }

    public void setReqTime(long j) {
        this.f50736g = j;
    }

    public void setBizId(int i) {
        this.f50737h = i;
    }

    public void setPackageName(String str) {
        this.f50738i = str;
    }

    public void setLac(int i) {
        this.f50740k = i;
    }

    public void setCellId(int i) {
        this.f50741l = i;
    }

    public void setDns(String str) {
        this.f50739j = str;
    }

    public int getCityId() {
        return this.f50730a;
    }

    public String getUid() {
        return this.f50731b;
    }

    public int getNetMode() {
        return this.f50732c;
    }

    public int getCarrier() {
        return this.f50733d;
    }

    public double getLat() {
        return this.f50734e;
    }

    public double getLng() {
        return this.f50735f;
    }

    public int getErrCount() {
        return this.f50742m;
    }

    public void setErrCount(int i) {
        this.f50742m = i;
    }

    public String generatorQueryString() {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", this.f50731b);
        hashMap.put("cityId", Integer.valueOf(this.f50730a));
        hashMap.put("netMode", Integer.valueOf(this.f50732c));
        hashMap.put("os", 1);
        hashMap.put(yyqyyy.qyqyyy.b0066ff0066f0066, Integer.valueOf(this.f50740k));
        hashMap.put("cellId", Integer.valueOf(this.f50741l));
        hashMap.put("lat", Double.valueOf(this.f50734e));
        hashMap.put("lng", Double.valueOf(this.f50735f));
        hashMap.put("timeCost", Long.valueOf(this.f50736g));
        hashMap.put(DnsConstants.DNS_TABLE_NAME, this.f50739j);
        hashMap.put("packageName", this.f50738i);
        hashMap.put("bizId", Integer.valueOf(this.f50737h));
        hashMap.put("carrier", Integer.valueOf(this.f50733d));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("errCount", Integer.valueOf(this.f50742m));
        return ApiSigner.sign(hashMap);
    }
}
