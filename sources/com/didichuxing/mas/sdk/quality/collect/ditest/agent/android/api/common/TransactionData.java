package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common;

public class TransactionData {

    /* renamed from: a */
    private final long f50484a;

    /* renamed from: b */
    private final String f50485b;

    /* renamed from: c */
    private final String f50486c;

    /* renamed from: d */
    private final String f50487d;

    /* renamed from: e */
    private final long f50488e;

    /* renamed from: f */
    private final int f50489f;

    /* renamed from: g */
    private int f50490g;

    /* renamed from: h */
    private final Object f50491h = new Object();

    /* renamed from: i */
    private final long f50492i;

    /* renamed from: j */
    private final long f50493j;

    /* renamed from: k */
    private final String f50494k;

    /* renamed from: l */
    private int f50495l;

    /* renamed from: m */
    private String f50496m;

    /* renamed from: n */
    private boolean f50497n;

    /* renamed from: o */
    private String f50498o;

    /* renamed from: p */
    private String f50499p;

    public TransactionData(String str, String str2, String str3, long j, int i, int i2, long j2, long j3, String str4, int i3, String str5, boolean z, String str6, String str7) {
        this.f50485b = str;
        this.f50486c = str2;
        this.f50487d = str3;
        this.f50488e = j;
        this.f50489f = i;
        this.f50490g = i2;
        this.f50492i = j2;
        this.f50493j = j3;
        this.f50494k = str4;
        this.f50484a = System.currentTimeMillis();
        this.f50495l = i3;
        this.f50496m = str5;
        this.f50497n = z;
        this.f50498o = str6;
        this.f50499p = str7;
    }

    public String getUrl() {
        return this.f50485b;
    }

    public String getHttpMethod() {
        return this.f50486c;
    }

    public String getCarrier() {
        return this.f50487d;
    }

    public int getStatusCode() {
        return this.f50489f;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.f50491h) {
            i = this.f50490g;
        }
        return i;
    }

    public void setErrorCode(int i) {
        synchronized (this.f50491h) {
            this.f50490g = i;
        }
    }

    public long getBytesSent() {
        return this.f50492i;
    }

    public long getBytesReceived() {
        return this.f50493j;
    }

    public String getWanType() {
        return this.f50494k;
    }

    public long getTimestamp() {
        return this.f50484a;
    }

    public long getTime() {
        return this.f50488e;
    }

    public TransactionData clone() {
        return new TransactionData(this.f50485b, this.f50486c, this.f50487d, this.f50488e, this.f50489f, this.f50490g, this.f50492i, this.f50493j, this.f50494k, this.f50495l, this.f50496m, this.f50497n, this.f50498o, this.f50499p);
    }

    public int getBusinessType() {
        return this.f50495l;
    }

    public void setBusinessType(int i) {
        this.f50495l = i;
    }

    public String getTraceId() {
        return this.f50496m;
    }

    public void setTraceId(String str) {
        this.f50496m = str;
    }

    public boolean isForground() {
        return this.f50497n;
    }

    public String getErrCodeClass() {
        return this.f50498o;
    }

    public void setErrCodeClass(String str) {
        this.f50498o = str;
    }

    public String getErrCodeInfo() {
        return this.f50499p;
    }

    public void setErrCodeInfo(String str) {
        this.f50499p = str;
    }

    public String toString() {
        return "TransactionData{timestamp=" + this.f50484a + ", url='" + this.f50485b + '\'' + ", httpMethod='" + this.f50486c + '\'' + ", carrier='" + this.f50487d + '\'' + ", time=" + this.f50488e + ", statusCode=" + this.f50489f + ", errorCode=" + this.f50490g + ", errorCodeLock=" + this.f50491h + ", bytesSent=" + this.f50492i + ", bytesReceived=" + this.f50493j + ", wanType='" + this.f50494k + '\'' + ", forground=" + this.f50497n + '}';
    }
}
