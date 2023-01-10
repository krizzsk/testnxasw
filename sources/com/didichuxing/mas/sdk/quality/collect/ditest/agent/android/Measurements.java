package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.util.Log;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.C16586Util;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Measurements {

    /* renamed from: A */
    private static final String f50399A = "c";

    /* renamed from: B */
    private static final String f50400B = "w";

    /* renamed from: C */
    private static final String f50401C = "ne";

    /* renamed from: D */
    private static final String f50402D = "he";

    /* renamed from: E */
    private static final String f50403E = "ti";
    public static final ArrayList<String> EXCEPT_KEY_PREFIX_EVENT_LIST = new ArrayList<String>() {
        {
            add(Measurements.f50428w);
            add(Measurements.f50429x);
            add(Measurements.f50430y);
            add("t");
            add("c");
            add("w");
            add(Measurements.f50401C);
            add(Measurements.f50402D);
            add(Measurements.f50403E);
            add(Measurements.f50404F);
            add("url");
            add("up");
            add("down");
            add("time");
            add("carrier");
            add("wanType");
            add("errorCode");
            add("stateCode");
            add("traceid");
            add("httpdns");
            add("localError");
        }
    };

    /* renamed from: F */
    private static final String f50404F = "hds";
    public static boolean FLAG_SYNCING = false;

    /* renamed from: G */
    private static final String[] f50405G = {"url", "up", "down", "time", "carrier", "wanType", "errorCode", "stateCode", "traceid", "httpdns"};
    public static final String HTTP_API_ERR_DIAG_EVENT = "http_api_err_diag";
    public static final String HTTP_ERROR_CODE_EXCEPTION_CLASS = "class";
    public static final String HTTP_ERROR_CODE_EXCEPTION_INFO = "info";
    public static final String HTTP_ERROR_CODE_PING_INFO = "pingInfo";
    public static final String HTTP_ERROR_CODE_ROUTE_INFO = "routeInfo";
    public static final String HTTP_ERROR_CODE_TRACE_HOST = "traceHost";

    /* renamed from: a */
    private static final AgentLog f50406a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final String f50407b = "http_api_stat";

    /* renamed from: c */
    private static final String f50408c = "up";

    /* renamed from: d */
    private static final String f50409d = "down";

    /* renamed from: e */
    private static final String f50410e = "url";

    /* renamed from: f */
    private static final String f50411f = "stateCode";

    /* renamed from: g */
    private static final String f50412g = "errorCode";

    /* renamed from: h */
    private static final String f50413h = "time";

    /* renamed from: i */
    private static final String f50414i = "traceid";

    /* renamed from: j */
    private static final String f50415j = "wanType";

    /* renamed from: k */
    private static final String f50416k = "carrier";

    /* renamed from: l */
    private static final String f50417l = "method";

    /* renamed from: m */
    private static final String f50418m = "httpdns";

    /* renamed from: n */
    private static final String f50419n = "localError";

    /* renamed from: o */
    private static final String f50420o = "errTrace";

    /* renamed from: p */
    private static final String f50421p = "state";

    /* renamed from: q */
    private static final String f50422q = "foreground";

    /* renamed from: r */
    private static final String f50423r = "background";

    /* renamed from: s */
    private static long f50424s = 0;

    /* renamed from: t */
    private static boolean f50425t = false;

    /* renamed from: u */
    private static boolean f50426u = false;

    /* renamed from: v */
    private static final String f50427v = "omg_np";

    /* renamed from: w */
    private static final String f50428w = "i";

    /* renamed from: x */
    private static final String f50429x = "u";

    /* renamed from: y */
    private static final String f50430y = "d";

    /* renamed from: z */
    private static final String f50431z = "t";

    public static void initialize() {
        f50406a.info("Measurement Engine initialized.");
        TaskQueue.start();
    }

    public static void shutdown() {
        TaskQueue.stop();
        f50406a.info("Measurement Engine shutting down.");
    }

    public static void addHttpError(String str, String str2, int i, String str3, int i2, String str4, boolean z, String str5, String str6, Map<String, String> map) {
        String str7 = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("time", 0);
        hashMap.put("url", str);
        hashMap.put("up", 0);
        hashMap.put("down", 0);
        hashMap.put("stateCode", Integer.valueOf(i));
        hashMap.put("errorCode", 0);
        hashMap.put("wanType", str7);
        hashMap.put("carrier", str6);
        hashMap.put("method", str2);
        if (z) {
            hashMap.put("state", "foreground");
        } else {
            hashMap.put("state", "background");
        }
        hashMap.put("traceid", str4 == null ? "" : str4);
        if (!Agent.isUploadErrorDiag()) {
            int i3 = i;
        } else if (i != 200 && !"none".equals(str7)) {
            if (Agent.canUploadNetErrEvent()) {
                trackNetEvent("http_api_err_diag", (String) null, hashMap);
            } else if (!f50425t) {
                m37657b();
                f50425t = true;
            }
        }
        if (!MASConfig.DEBUG_MODEL && Agent.isUploadNetPerf()) {
            OmegaSDKAdapter.trackMasEvent(f50407b, (String) null, hashMap);
        }
        HttpTransactionMeasurement httpTransactionMeasurement = new HttpTransactionMeasurement(str, str2, i, 0, 0, 0, 0, i2, str4);
        if (Agent.isNetEventLogEnabled()) {
            Agent.getImpl().addNetEventLog(httpTransactionMeasurement);
        }
        if (Agent.isUploadAllNetEnabled() && m37656a()) {
            m37655a(httpTransactionMeasurement);
        }
    }

    public static void addHttpTransaction(HttpTransactionMeasurement httpTransactionMeasurement) {
        HashMap hashMap = new HashMap();
        if (httpTransactionMeasurement.getOkHttp3Data() != null) {
            hashMap.putAll(httpTransactionMeasurement.getOkHttp3Data());
            if (!httpTransactionMeasurement.getOkHttp3Data().containsKey("wanType")) {
                hashMap.put("wanType", httpTransactionMeasurement.getWanType());
            } else {
                httpTransactionMeasurement.setWanType(httpTransactionMeasurement.getOkHttp3Data().get("wanType").toString());
            }
            if (!httpTransactionMeasurement.getOkHttp3Data().containsKey("carrier")) {
                hashMap.put("carrier", httpTransactionMeasurement.getCarrier());
            } else {
                httpTransactionMeasurement.setCarrier(httpTransactionMeasurement.getOkHttp3Data().get("carrier").toString());
            }
            if (httpTransactionMeasurement.getException() != null) {
                hashMap.put("localError", httpTransactionMeasurement.getException().toString());
                if (Math.random() < Agent.getImpl().getAgentConfig().getExceptionCollectRate()) {
                    hashMap.put("errTrace", Log.getStackTraceString(httpTransactionMeasurement.getException()));
                }
            }
        } else {
            hashMap.put("time", Double.valueOf(httpTransactionMeasurement.getTotalTime()));
            hashMap.put("url", httpTransactionMeasurement.getUrl());
            hashMap.put("up", Long.valueOf(httpTransactionMeasurement.getBytesSent()));
            hashMap.put("down", Long.valueOf(httpTransactionMeasurement.getBytesReceived()));
            hashMap.put("stateCode", Integer.valueOf(httpTransactionMeasurement.getStatusCode()));
            hashMap.put("errorCode", Integer.valueOf(httpTransactionMeasurement.getErrorCode()));
            hashMap.put("traceid", httpTransactionMeasurement.getTraceId() == null ? "" : httpTransactionMeasurement.getTraceId());
            hashMap.put("wanType", httpTransactionMeasurement.getWanType());
            hashMap.put("carrier", httpTransactionMeasurement.getCarrier());
            hashMap.put("method", httpTransactionMeasurement.getHttpMethod());
        }
        if (!"none".equals(httpTransactionMeasurement.getWanType())) {
            if (httpTransactionMeasurement.isForeground()) {
                hashMap.put("state", "foreground");
            } else {
                hashMap.put("state", "background");
            }
            if (!MASConfig.DEBUG_MODEL && Agent.isUploadNetPerf()) {
                if (httpTransactionMeasurement.getErrorCode() == -1) {
                    if (httpTransactionMeasurement.getErrCodeClass() != null) {
                        hashMap.put("class", httpTransactionMeasurement.getErrCodeClass());
                    }
                    if (httpTransactionMeasurement.getErrCodeInfo() != null) {
                        hashMap.put("info", httpTransactionMeasurement.getErrCodeInfo());
                    }
                }
                OmegaSDKAdapter.trackMasEvent(f50407b, (String) null, hashMap);
            }
            if (Agent.isNetEventLogEnabled()) {
                Agent.getImpl().addNetEventLog(httpTransactionMeasurement);
            }
            if (Agent.isUploadAllNetEnabled()) {
                if (m37656a()) {
                    m37655a(httpTransactionMeasurement);
                } else if (!f50426u) {
                    OmegaSDKAdapter.trackMasEvent("omg_np_over_threshold", (String) null, new HashMap<String, Object>() {
                        {
                            put("cur", Long.valueOf(Agent.getImpl().getAgentConfig().getAllNetUploadLimit()));
                            put("allow", Long.valueOf(Agent.getImpl().getAgentConfig().getAllNetUploadLimit()));
                        }
                    });
                    f50426u = true;
                }
            }
            if (Agent.isUploadErrorDiag() && !"none".equals(httpTransactionMeasurement.getWanType())) {
                if (httpTransactionMeasurement.getErrorCode() != 0 || httpTransactionMeasurement.getStatusCode() != 200 || httpTransactionMeasurement.getTotalTime() > ((double) Agent.getImpl().getAgentConfig().getOverRequestTime())) {
                    if (Agent.canUploadNetErrEvent()) {
                        if (httpTransactionMeasurement.getUrl() == null) {
                            return;
                        }
                        if (httpTransactionMeasurement.getErrorCode() != 0) {
                            if (httpTransactionMeasurement.getErrorCode() == -1) {
                                if (httpTransactionMeasurement.getErrCodeClass() != null) {
                                    hashMap.put("class", httpTransactionMeasurement.getErrCodeClass());
                                }
                                if (httpTransactionMeasurement.getErrCodeInfo() != null) {
                                    hashMap.put("info", httpTransactionMeasurement.getErrCodeInfo());
                                }
                            }
                            String host = C16586Util.getHost(httpTransactionMeasurement.getUrl());
                            if (host == null || FLAG_SYNCING) {
                                trackNetEvent("http_api_err_diag", (String) null, hashMap);
                                return;
                            }
                            FLAG_SYNCING = true;
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = f50424s;
                            if (currentTimeMillis - j > 60000) {
                                f50424s = System.currentTimeMillis();
                                new Thread(new DiagThread(host, hashMap), "Omega-measurement").start();
                                return;
                            }
                            hashMap.put("lastCheckTs", Long.valueOf(j));
                            trackNetEvent("http_api_err_diag", (String) null, hashMap);
                            return;
                        }
                        trackNetEvent("http_api_err_diag", (String) null, hashMap);
                    } else if (!f50425t) {
                        m37657b();
                        f50425t = true;
                    }
                }
            }
        }
    }

    public static void addHttpError(TransactionData transactionData, String str, Map<String, String> map) {
        addHttpError(transactionData.getUrl(), transactionData.getHttpMethod(), transactionData.getStatusCode(), str, transactionData.getBusinessType(), transactionData.getTraceId(), transactionData.isForground(), transactionData.getWanType(), transactionData.getCarrier(), map);
    }

    /* renamed from: a */
    private static void m37655a(HttpTransactionMeasurement httpTransactionMeasurement) {
        String urlPath;
        String url = httpTransactionMeasurement.getUrl();
        if (Agent.getImpl().getAgentConfig().inAllNetUploadWhiteList(url) && (urlPath = C16586Util.getUrlPath(url)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(f50428w, urlPath);
            hashMap.put(f50429x, Long.valueOf(httpTransactionMeasurement.getBytesSent()));
            hashMap.put(f50430y, Long.valueOf(httpTransactionMeasurement.getBytesReceived()));
            hashMap.put("t", Double.valueOf(httpTransactionMeasurement.getTotalTime()));
            if (httpTransactionMeasurement.getTraceId() != null) {
                hashMap.put(f50403E, httpTransactionMeasurement.getTraceId());
            }
            hashMap.put("c", httpTransactionMeasurement.getCarrier());
            hashMap.put(f50404F, Integer.valueOf(httpTransactionMeasurement.getHttpdns()));
            if (httpTransactionMeasurement.getErrorCode() != 0) {
                hashMap.put(f50401C, Integer.valueOf(httpTransactionMeasurement.getErrorCode()));
            }
            if (httpTransactionMeasurement.getStatusCode() != 200) {
                hashMap.put(f50402D, Integer.valueOf(httpTransactionMeasurement.getStatusCode()));
            }
            hashMap.put("w", httpTransactionMeasurement.getWanType());
            Map<String, Object> okHttp3Data = httpTransactionMeasurement.getOkHttp3Data();
            if (okHttp3Data != null) {
                for (String remove : f50405G) {
                    okHttp3Data.remove(remove);
                }
                hashMap.putAll(okHttp3Data);
                if (httpTransactionMeasurement.getException() != null) {
                    hashMap.put("localError", httpTransactionMeasurement.getException().toString());
                    if (Math.random() < Agent.getImpl().getAgentConfig().getExceptionCollectRate()) {
                        hashMap.put("errTrace", Log.getStackTraceString(httpTransactionMeasurement.getException()));
                    }
                }
            }
            trackNetEvent(f50427v, (String) null, hashMap);
        }
    }

    /* renamed from: a */
    private static boolean m37656a() {
        return !Agent.getImpl().upperLimitToday("omg_np_limit", Agent.getImpl().getAgentConfig().getAllNetUploadLimit());
    }

    /* renamed from: b */
    private static void m37657b() {
        OmegaSDKAdapter.trackMasEvent("http_err_diag_over_threshold", (String) null, new HashMap<String, Object>() {
            {
                put("cur", Integer.valueOf(Agent.getImpl().getAgentConfig().getMaxUploadNetErrEventPerDay()));
                put("allow", Integer.valueOf(Agent.getImpl().getAgentConfig().getMaxUploadNetErrEventPerDay()));
            }
        });
    }

    public static void trackNetEvent(String str, String str2, Map<String, Object> map) {
        int i;
        HashMap hashMap = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = EXCEPT_KEY_PREFIX_EVENT_LIST.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(next)) {
                        break;
                    }
                } else {
                    i = 0;
                    break;
                }
            }
            if (i != 0) {
                hashMap.put(next, map.get(next));
            } else {
                hashMap.put("nt_" + next, map.get(next));
            }
        }
        if (!AppStateMonitor.getInstance().isInForeground()) {
            i = 2;
        }
        hashMap.put(Constants.NT_APPSTATE, Integer.valueOf(i));
        OmegaSDKAdapter.trackMasEvent(str, str2, hashMap);
    }
}
