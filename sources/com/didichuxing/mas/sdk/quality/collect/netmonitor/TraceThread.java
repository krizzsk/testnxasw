package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.ApiSigner;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceThread implements Runnable {

    /* renamed from: a */
    private static final String f50755a = "TraceThread";

    /* renamed from: b */
    private boolean f50756b;

    /* renamed from: c */
    private boolean f50757c;

    /* renamed from: d */
    private BizInfo f50758d;

    /* renamed from: e */
    private String f50759e = "";

    /* renamed from: f */
    private String f50760f = "";

    /* renamed from: g */
    private String f50761g = "";

    /* renamed from: h */
    private String f50762h = "";

    /* renamed from: i */
    private String f50763i = "";

    /* renamed from: j */
    private HeartbeatMessage f50764j;

    public TraceThread(boolean z, boolean z2, BizInfo bizInfo, String str, HeartbeatMessage heartbeatMessage) {
        this.f50756b = z;
        this.f50757c = z2;
        this.f50758d = bizInfo;
        this.f50763i = str;
        this.f50764j = heartbeatMessage;
    }

    public static String getHost(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        Matcher matcher = Pattern.compile("(?<=//|)((\\w|-)+\\.)+\\w+").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public void run() {
        Thread.currentThread().setName(getClass().getName());
        BizInfo bizInfo = this.f50758d;
        if (bizInfo != null && this.f50763i != null) {
            String host = getHost(bizInfo.getUrl());
            if (host != null) {
                if (this.f50756b) {
                    this.f50761g = TraceRouteWithPing.ping(5, 10, host);
                    this.f50759e = host;
                }
                if (this.f50757c) {
                    this.f50762h = TraceRouteWithPing.executeTraceroute(host, 30);
                    this.f50760f = host;
                }
                if (this.f50761g != null || this.f50762h != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pingAddress", this.f50759e);
                    hashMap.put("pingInfo", this.f50761g);
                    hashMap.put("routeAddress", this.f50760f);
                    hashMap.put("routeInfo", this.f50762h);
                    hashMap.put("bizId", Integer.valueOf(this.f50758d.getBizId()));
                    HeartbeatMessage heartbeatMessage = this.f50764j;
                    if (heartbeatMessage != null) {
                        hashMap.put("uid", heartbeatMessage.getUid());
                        hashMap.put("carrier", Integer.valueOf(this.f50764j.getCarrier()));
                        hashMap.put("cityId", Integer.valueOf(this.f50764j.getCityId()));
                        hashMap.put("netMode", Integer.valueOf(this.f50764j.getNetMode()));
                        hashMap.put("os", 1);
                        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
                            hashMap.put("lat", Double.valueOf(this.f50764j.getLat()));
                            hashMap.put("lng", Double.valueOf(this.f50764j.getLng()));
                        }
                    }
                    HttpSender.httpPost(this.f50763i, ApiSigner.sign(hashMap));
                    return;
                }
                return;
            }
            SystemUtils.log(6, f50755a, "domain url is null, bizId:" + this.f50758d.getBizId(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.TraceThread", 110);
        }
    }
}
