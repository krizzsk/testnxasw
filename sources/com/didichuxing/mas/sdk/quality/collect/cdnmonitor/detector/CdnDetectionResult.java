package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector;

import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname.CNameUtils;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.ping.PingResult;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import com.threatmetrix.TrustDefender.yyqyyy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CdnDetectionResult {

    /* renamed from: a */
    private String f50308a;

    /* renamed from: b */
    private String f50309b;

    /* renamed from: c */
    private String f50310c = "android";

    /* renamed from: d */
    private int f50311d = 1;

    /* renamed from: e */
    private String f50312e;

    /* renamed from: f */
    private int f50313f;

    /* renamed from: g */
    private int f50314g;

    /* renamed from: h */
    private double f50315h;

    /* renamed from: i */
    private double f50316i;

    /* renamed from: j */
    private long f50317j;

    /* renamed from: k */
    private String f50318k;

    /* renamed from: l */
    private String f50319l;

    /* renamed from: m */
    private int f50320m = 1000;

    /* renamed from: n */
    private String f50321n;

    /* renamed from: o */
    private String f50322o;

    /* renamed from: p */
    private int f50323p = 0;

    /* renamed from: q */
    private int f50324q;

    /* renamed from: r */
    private String f50325r = "";

    /* renamed from: s */
    private float f50326s;

    /* renamed from: t */
    private float f50327t;

    /* renamed from: u */
    private String f50328u;

    /* renamed from: v */
    private String f50329v;

    public CdnDetectionResult(String str) {
        this.f50319l = str;
    }

    public int getDetectErrCode() {
        return this.f50320m;
    }

    public void setDetectErrCode(int i) {
        this.f50320m = i;
    }

    public void fetchEnvironmentParameters() {
        this.f50308a = NetworkCollector.getNetworkOperatorType();
        this.f50309b = NetworkCollector.getNetworkType();
        this.f50312e = CustomCollector.getUid();
        this.f50313f = NetworkCollector.getLac();
        this.f50314g = NetworkCollector.getCellid();
        double[] location = LocationCollector.getLocation();
        if (location != null && location.length >= 2) {
            this.f50316i = location[0];
            this.f50315h = location[1];
        }
        this.f50317j = System.currentTimeMillis();
        String dns = TraceRouteWithPing.getDNS();
        this.f50318k = dns;
        this.f50329v = CNameUtils.getNetCName(this.f50319l, dns);
    }

    public void setPingInfo(PingResult pingResult) {
        this.f50325r = pingResult.getDetectIp();
        this.f50326s = pingResult.getPingTime();
        this.f50327t = pingResult.getPingErrorRadio();
        this.f50328u = pingResult.getPingResponse();
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("carrier", this.f50308a);
        hashMap.put("networkType", this.f50309b);
        hashMap.put(ServerParam.PARAM_DDRIVER_OSTYPE, this.f50310c);
        hashMap.put("appId", Integer.valueOf(this.f50311d));
        hashMap.put("uid", this.f50312e);
        hashMap.put(yyqyyy.qyqyyy.b0066ff0066f0066, Integer.valueOf(this.f50313f));
        hashMap.put("cellId", Integer.valueOf(this.f50314g));
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
            hashMap.put("lng", Double.valueOf(this.f50316i));
            hashMap.put("lat", Double.valueOf(this.f50315h));
        }
        hashMap.put("timeStamp", Long.valueOf(this.f50317j));
        hashMap.put("localDns", this.f50318k);
        hashMap.put("detectUrl", this.f50319l);
        hashMap.put("detectErrCode", Integer.valueOf(this.f50320m));
        hashMap.put("downFileMd5", this.f50321n);
        hashMap.put("resHeaders", this.f50322o);
        hashMap.put("httpDuration", Integer.valueOf(this.f50324q));
        hashMap.put("contentLength", Integer.valueOf(this.f50323p));
        hashMap.put("detectIp", this.f50325r);
        hashMap.put("pingTime", Float.valueOf(this.f50326s));
        hashMap.put("pingErrorRatio", Float.valueOf(this.f50327t));
        hashMap.put("pingResponse", this.f50328u);
        hashMap.put("cname", this.f50329v);
        return hashMap;
    }

    public void addDetectionResult(int i, int i2, Map<String, List<String>> map, int i3) {
        this.f50320m = i;
        this.f50324q = i2;
        this.f50322o = m37635a(map);
        this.f50323p = i3;
    }

    /* renamed from: a */
    private String m37635a(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(Const.jsQuote);
                sb.append((String) next.getKey());
                sb.append("\":\"");
                sb.append(JsonUtil.list2Json((List) next.getValue()));
                sb.append(Const.jsQuote);
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        } catch (Exception unused) {
            OLog.m37867w("headerFields toJson error");
        }
        sb.append("}");
        return sb.toString();
    }

    public boolean hasError() {
        return getDetectErrCode() != 2200;
    }

    public void setDownFileMd5(String str) {
        this.f50321n = str;
    }
}
