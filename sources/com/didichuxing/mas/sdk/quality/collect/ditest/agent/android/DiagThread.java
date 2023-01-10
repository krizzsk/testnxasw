package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.Map;

public class DiagThread implements Runnable {

    /* renamed from: a */
    private String f50397a;

    /* renamed from: b */
    private Map<String, Object> f50398b;

    public DiagThread(String str, Map<String, Object> map) {
        this.f50397a = str;
        if (map != null) {
            this.f50398b = map;
        } else {
            this.f50398b = new HashMap();
        }
    }

    public void run() {
        String str;
        String str2;
        try {
            if (this.f50397a == null || "".equals(this.f50397a)) {
                str2 = null;
                str = null;
            } else {
                str2 = TraceRouteWithPing.executeTraceroute(this.f50397a, 30);
                str = TraceRouteWithPing.ping(3, 3, this.f50397a);
            }
            if (str2 != null) {
                this.f50398b.put("routeInfo", str2);
                this.f50398b.put("traceHost", this.f50397a);
            }
            if (str != null) {
                this.f50398b.put("pingInfo", str);
            }
            Measurements.trackNetEvent("http_api_err_diag", (String) null, this.f50398b);
        } catch (Throwable th) {
            Measurements.FLAG_SYNCING = false;
            throw th;
        }
        Measurements.FLAG_SYNCING = false;
    }
}
