package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.background.ApplicationStateMonitor;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.BaseMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpTransactionMeasurement extends BaseMeasurement {

    /* renamed from: a */
    private String f50582a;

    /* renamed from: b */
    private String f50583b;

    /* renamed from: c */
    private double f50584c;

    /* renamed from: d */
    private int f50585d;

    /* renamed from: e */
    private int f50586e;

    /* renamed from: f */
    private long f50587f;

    /* renamed from: g */
    private long f50588g;

    /* renamed from: h */
    private String f50589h;

    /* renamed from: i */
    private String f50590i;

    /* renamed from: j */
    private int f50591j;

    /* renamed from: k */
    private String f50592k;

    /* renamed from: l */
    private boolean f50593l;

    /* renamed from: m */
    private String f50594m;

    /* renamed from: n */
    private String f50595n;

    /* renamed from: o */
    private Exception f50596o;

    /* renamed from: p */
    private Map<String, Object> f50597p;

    /* renamed from: q */
    private int f50598q;

    public HttpTransactionMeasurement(String str, String str2, int i, long j, long j2, long j3, long j4, int i2, String str3) {
        super(MeasurementType.Network);
        this.f50589h = "unknown";
        this.f50590i = "unknown";
        setName(str);
        setStartTime(j);
        setEndTime(j + j2);
        setExclusiveTime(j2);
        this.f50582a = str;
        this.f50583b = str2;
        this.f50585d = i;
        this.f50587f = j3;
        this.f50588g = j4;
        this.f50584c = (double) j2;
        this.f50591j = i2;
        this.f50592k = str3;
        this.f50593l = ApplicationStateMonitor.getInstance().isForegrounded();
        this.f50590i = Agent.getActiveNetworkWanType();
        this.f50589h = Agent.getActiveNetworkCarrier();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, long j, long j2, long j3, long j4, int i3, String str3, String str4, String str5) {
        this(str, str2, i, j, j2, j3, j4, i3, str3);
        this.f50586e = i2;
        this.f50594m = str4;
        this.f50595n = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpTransactionMeasurement(String str, String str2, int i, int i2, int i3, long j, long j2, long j3, long j4, int i4, String str3, Exception exc, Map<String, Object> map) {
        this(str, str2, i2, j, j2, j3, j4, i4, str3);
        this.f50598q = i;
        this.f50586e = i3;
        this.f50596o = exc;
        this.f50597p = map;
    }

    public String getUrl() {
        return this.f50582a;
    }

    public String getHttpMethod() {
        return this.f50583b;
    }

    public double getTotalTime() {
        return this.f50584c;
    }

    public int getStatusCode() {
        return this.f50585d;
    }

    public int getErrorCode() {
        return this.f50586e;
    }

    public long getBytesSent() {
        return this.f50587f;
    }

    public long getBytesReceived() {
        return this.f50588g;
    }

    public void setUrl(String str) {
        this.f50582a = str;
    }

    public String getCarrier() {
        return this.f50589h;
    }

    public String getWanType() {
        return this.f50590i;
    }

    public void setWanType(String str) {
        this.f50590i = str;
    }

    public void setCarrier(String str) {
        this.f50589h = str;
    }

    public int getBusinessId() {
        return this.f50591j;
    }

    public boolean isForeground() {
        return this.f50593l;
    }

    public String getTraceId() {
        return this.f50592k;
    }

    public String getErrCodeClass() {
        return this.f50594m;
    }

    public void setErrCodeClass(String str) {
        this.f50594m = str;
    }

    public String getErrCodeInfo() {
        return this.f50595n;
    }

    public void setErrCodeInfo(String str) {
        this.f50595n = str;
    }

    public Exception getException() {
        return this.f50596o;
    }

    public void setException(Exception exc) {
        this.f50596o = exc;
    }

    public Map<String, Object> getOkHttp3Data() {
        return this.f50597p;
    }

    public void setOkHttp3Data(Map<String, Object> map) {
        this.f50597p = map;
    }

    public int getHttpdns() {
        return this.f50598q;
    }

    public void setHttpdns(int i) {
        this.f50598q = i;
    }

    public String toString() {
        return "HttpTransactionMeasurement{url='" + this.f50582a + '\'' + ", httpMethod='" + this.f50583b + '\'' + ", totalTime=" + this.f50584c + '\'' + ", statusCode=" + this.f50585d + '\'' + ", errorCode=" + this.f50586e + '\'' + ", bytesSent=" + this.f50587f + '\'' + ", bytesReceived=" + this.f50588g + '\'' + ", wan=" + this.f50590i + '\'' + ", carrier=" + this.f50589h + '\'' + ", businessId=" + this.f50591j + '\'' + ", traceId=" + this.f50592k + '\'' + ", forground=" + this.f50593l;
    }
}
