package com.didichuxing.mas.sdk.quality.collect.netmonitor;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.SavedState;
import com.didichuxing.mas.sdk.quality.collect.netmonitor.HeartbeatInfoCollector;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.TraceRouteWithPing;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class NetHeartbeat implements Runnable {

    /* renamed from: a */
    private static final String f50743a = "NetHeartbeat";

    /* renamed from: b */
    private static int f50744b = 3600000;

    /* renamed from: c */
    private static NetHeartbeat f50745c = null;

    /* renamed from: d */
    private static long f50746d = 0;

    /* renamed from: e */
    private static long f50747e = 0;

    /* renamed from: f */
    private static long f50748f = 0;

    /* renamed from: g */
    private static List<BizInfo> f50749g = null;

    /* renamed from: h */
    private static String f50750h = null;

    /* renamed from: i */
    private static boolean f50751i = false;

    /* renamed from: j */
    private HeartbeatMessage f50752j;

    /* renamed from: k */
    private String f50753k = ("netmonitor" + new SimpleDateFormat("yyyyMMdd").format(new Date()));

    /* renamed from: l */
    private SavedState f50754l;

    private NetHeartbeat(Context context) {
        this.f50754l = new SavedState(context);
        m37781a();
    }

    public static void initBizConfig(String str) {
        if (f50749g == null) {
            f50749g = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(new JSONTokener(str));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    f50749g.add(new BizInfo(jSONObject.getInt("i"), jSONObject.getString("u")));
                }
            } catch (JSONException e) {
                SystemUtils.log(6, f50743a, "config format err:" + e.toString() + "conf:" + str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 66);
            }
        }
    }

    public static void start(Context context) {
        if (!f50751i) {
            f50751i = true;
            HeartbeatInfoCollector.init(context);
            new Thread(getInstance(context), "Omega-HeartBeat").start();
        }
    }

    public static synchronized NetHeartbeat getInstance(Context context) {
        NetHeartbeat netHeartbeat;
        synchronized (NetHeartbeat.class) {
            if (f50745c == null) {
                f50745c = new NetHeartbeat(context);
            }
            netHeartbeat = f50745c;
        }
        return netHeartbeat;
    }

    public static void setHeartBeatInterval(int i) {
        f50744b = i;
    }

    public static void setReportUrl(String str) {
        f50750h = str;
    }

    /* renamed from: a */
    private void m37781a() {
        HeartbeatMessage heartbeatMessage = new HeartbeatMessage();
        this.f50752j = heartbeatMessage;
        heartbeatMessage.setCarrier(HeartbeatInfoCollector.getCarrier());
        this.f50752j.setPackageName(HeartbeatInfoCollector.getPackageName());
    }

    /* renamed from: b */
    private boolean m37782b() {
        int cityId = CustomCollector.getCityId();
        this.f50752j.setNetMode(HeartbeatInfoCollector.getNetworkType());
        this.f50752j.setCityId(cityId);
        this.f50752j.setUid(CustomCollector.getUid());
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation()) {
            double[] location = LocationCollector.getLocation();
            if (location != null && location.length >= 2) {
                this.f50752j.setLat(location[0]);
                this.f50752j.setLng(location[1]);
            }
            HeartbeatInfoCollector.GSMCellLocationInfo gSMCellLocationInfo = HeartbeatInfoCollector.getGSMCellLocationInfo();
            this.f50752j.setLac(gSMCellLocationInfo.getLac());
            this.f50752j.setCellId(gSMCellLocationInfo.getCellid());
        }
        this.f50752j.setDns(TraceRouteWithPing.getDNS());
        for (BizInfo next : f50749g) {
            this.f50752j.setReqTime(next.getReqTime());
            this.f50752j.setBizId(next.getBizId());
            this.f50752j.setErrCount(getErrCount(next.getBizId()));
            f50746d = System.currentTimeMillis();
            String generatorQueryString = this.f50752j.generatorQueryString();
            SystemUtils.log(3, f50743a, "net monitor query:" + generatorQueryString, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 166);
            String httpPost = HttpSender.httpPost(next.getUrl(), generatorQueryString);
            SystemUtils.log(3, f50743a, "net monitor:" + httpPost, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 168);
            f50747e = System.currentTimeMillis();
            if (httpPost == null) {
                next.setReqTime(-1);
                addErrCount(next.getBizId());
            } else {
                cleanErrCount(next.getBizId());
                NetHeartbeatResponse netHeartbeatResponse = new NetHeartbeatResponse();
                netHeartbeatResponse.initNetHeartbeatResponse(httpPost);
                if (!netHeartbeatResponse.success || netHeartbeatResponse.getCode() != 0) {
                    SystemUtils.log(3, f50743a, "Heartbeat fail:" + netHeartbeatResponse.getMsg(), (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat", 185);
                    next.setReqTime(0);
                } else {
                    long cost = (long) netHeartbeatResponse.getCost();
                    f50748f = cost;
                    next.setReqTime((f50747e - f50746d) - cost);
                    if (netHeartbeatResponse.isNeedPing() || netHeartbeatResponse.isNeedTraceRoute()) {
                        new Thread(new TraceThread(netHeartbeatResponse.isNeedPing(), netHeartbeatResponse.isNeedTraceRoute(), next, f50750h, this.f50752j), "Omega-heartbeat").start();
                    }
                }
            }
        }
        return true;
    }

    public void run() {
        while (true) {
            if (m37782b()) {
                try {
                    Thread.sleep((long) f50744b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class NetHeartbeatResponse {
        private int code;
        private int cost;
        private String msg;
        private boolean needPing;
        private boolean needTraceRoute;
        /* access modifiers changed from: private */
        public boolean success;

        private NetHeartbeatResponse() {
        }

        public void initNetHeartbeatResponse(String str) {
            this.needPing = false;
            this.needTraceRoute = false;
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.code = jSONObject.getInt("code");
                this.msg = jSONObject.getString("msg");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                this.needPing = jSONObject2.getBoolean("needPing");
                this.needTraceRoute = jSONObject2.getBoolean("needRoute");
                this.cost = jSONObject2.getInt("cost");
                this.success = true;
            } catch (JSONException e) {
                SystemUtils.log(6, NetHeartbeat.f50743a, "parse response fail:" + e.toString() + "res:" + str, (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat$NetHeartbeatResponse", 243);
                this.success = false;
            }
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public int getCost() {
            return this.cost;
        }

        public boolean isNeedTraceRoute() {
            return this.needTraceRoute;
        }

        public boolean isNeedPing() {
            return this.needPing;
        }
    }

    public void cleanErrCount(int i) {
        if (this.f50754l != null && this.f50753k != null) {
            String str = this.f50753k + i;
            this.f50753k = str;
            this.f50754l.save(str, 0);
        }
    }

    public int getErrCount(int i) {
        if (this.f50754l == null || this.f50753k == null) {
            return 0;
        }
        String str = this.f50753k + i;
        this.f50753k = str;
        return this.f50754l.getInt(str);
    }

    public void addErrCount(int i) {
        if (this.f50754l != null && this.f50753k != null) {
            String str = this.f50753k + i;
            this.f50753k = str;
            SavedState savedState = this.f50754l;
            savedState.save(str, savedState.getInt(str) + 1);
        }
    }
}
