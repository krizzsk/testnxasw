package com.didiglobal.privacy.domainmonitor.model;

public class OmegaReportParams {

    /* renamed from: a */
    private String f53063a;

    /* renamed from: b */
    private String f53064b;

    /* renamed from: c */
    private String f53065c;

    /* renamed from: d */
    private String f53066d;

    /* renamed from: e */
    private String f53067e;

    /* renamed from: f */
    private String f53068f;

    /* renamed from: g */
    private String f53069g;

    public OmegaReportParams(String str, String str2, String str3) {
        this(str, str2, str3, "");
    }

    public OmegaReportParams(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, "", "");
    }

    public OmegaReportParams(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f53063a = str;
        this.f53064b = str2;
        this.f53065c = str3;
        this.f53066d = str4;
        this.f53067e = str5;
        this.f53068f = str6;
    }

    public String getUrl() {
        return this.f53063a;
    }

    public void setUrl(String str) {
        this.f53063a = str;
    }

    public String getHost() {
        return this.f53064b;
    }

    public void setHost(String str) {
        this.f53064b = str;
    }

    public String getSource() {
        return this.f53065c;
    }

    public void setSource(String str) {
        this.f53065c = str;
    }

    public String getTraceId() {
        return this.f53066d;
    }

    public void setTraceId(String str) {
        this.f53066d = str;
    }

    public String getBffName() {
        return this.f53067e;
    }

    public void setBffName(String str) {
        this.f53067e = str;
    }

    public String getNetSource() {
        return this.f53068f;
    }

    public void setNetSource(String str) {
        this.f53068f = str;
    }

    public String getAlarmTag() {
        return this.f53069g;
    }

    public void setAlarmTag(String str) {
        this.f53069g = str;
    }
}
