package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.BaseMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.MeasurementType;
import java.util.Map;

public class HttpErrorMeasurement extends BaseMeasurement {

    /* renamed from: a */
    private String f50577a;

    /* renamed from: b */
    private int f50578b;

    /* renamed from: c */
    private String f50579c;

    /* renamed from: d */
    private String f50580d;

    /* renamed from: e */
    private Map<String, String> f50581e;

    public HttpErrorMeasurement(String str, int i) {
        super(MeasurementType.HttpError);
        setUrl(str);
        setName(str);
        setHttpStatusCode(i);
        setStartTime(System.currentTimeMillis());
    }

    public void setUrl(String str) {
        this.f50577a = str;
    }

    public void setHttpStatusCode(int i) {
        this.f50578b = i;
    }

    public void setResponseBody(String str) {
        this.f50579c = str;
    }

    public void setStackTrace(String str) {
        this.f50580d = str;
    }

    public void setParams(Map<String, String> map) {
        this.f50581e = map;
    }

    public String getUrl() {
        return this.f50577a;
    }

    public int getHttpStatusCode() {
        return this.f50578b;
    }

    public String getResponseBody() {
        return this.f50579c;
    }

    public String getStackTrace() {
        return this.f50580d;
    }

    public Map<String, String> getParams() {
        return this.f50581e;
    }
}
