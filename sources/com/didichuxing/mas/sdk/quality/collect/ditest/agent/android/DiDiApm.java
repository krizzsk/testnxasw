package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AndroidAgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.NullAgentLog;
import java.util.Map;

public class DiDiApm {
    public static final boolean DEBUG = true;

    /* renamed from: a */
    private static final AgentLog f50391a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private static final AgentConfiguration f50392b = new AgentConfiguration();

    /* renamed from: c */
    private static boolean f50393c = false;

    /* renamed from: f */
    private static DiDiApm f50394f;

    /* renamed from: d */
    private boolean f50395d = true;

    /* renamed from: e */
    private int f50396e = 3;

    /* renamed from: a */
    private boolean m37654a() {
        return false;
    }

    private DiDiApm() {
    }

    public static synchronized DiDiApm getInstance() {
        DiDiApm diDiApm;
        synchronized (DiDiApm.class) {
            if (f50394f == null) {
                f50394f = new DiDiApm();
            }
            diDiApm = f50394f;
        }
        return diDiApm;
    }

    public static void launch(Context context) {
        getInstance().withLogLevel(3).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public static void debugLaunch(Context context) {
        f50391a.debug("DiDi Apm Debug Mode!");
        getInstance().withLogLevel(5).withLoggingEnabled(true).withDisabled(false).start(context);
    }

    public DiDiApm withLoggingEnabled(boolean z) {
        this.f50395d = z;
        return this;
    }

    public DiDiApm withLogLevel(int i) {
        this.f50396e = i;
        return this;
    }

    public DiDiApm withDisabled(boolean z) {
        f50392b.setDisabled(z);
        return this;
    }

    public void setDisabled(boolean z) {
        f50392b.setDisabled(z);
    }

    public static void setApmNetEnable(boolean z) {
        f50392b.setApmNetEnable(z);
    }

    public static void setApmUiEnable(boolean z) {
        f50392b.setApmUiEnable(z);
    }

    public static void setUploadNetPerfEnable(boolean z) {
        f50392b.setUploadNetPerf(z);
    }

    public static void setUploadErrorDiagEnable(boolean z) {
        f50392b.setUploadErrorDiag(z);
    }

    public static void setNetEventLogUploadInterval(long j) {
        f50392b.setNetEventLogUploadInterval(j);
    }

    public void start(Context context) {
        if (f50393c) {
            f50391a.debug("DiDiApm is already running.");
            return;
        }
        try {
            f50391a.info("didi apm start!");
            AgentLogManager.setAgentLog(this.f50395d ? new AndroidAgentLog() : new NullAgentLog());
            f50391a.setLevel(this.f50396e);
            AndroidAgentImpl.init(context, f50392b);
            f50393c = true;
        } catch (Throwable th) {
            f50391a.error("Error occurred while starting the DiDi Apm agent!", th);
        }
    }

    public static boolean isStarted() {
        return f50393c;
    }

    public static void shutdown() {
        if (f50393c) {
            try {
                Agent.getImpl().stop();
            } finally {
                f50393c = false;
            }
        }
    }

    public static void setMaxTrafficPerDay(long j) {
        f50392b.setMaxTrafficPerDay(j);
    }

    public static void setMaxTrafficFiveMins(long j) {
        f50392b.setMaxTrafficFiveMinutes(j);
    }

    public static void setOverRequestTime(long j) {
        f50392b.setOverRequestTime(j);
    }

    public static void setMaxDiagPerDay(int i) {
        f50392b.setMaxUploadNetErrEventPerDay(i);
    }

    public static void setNetEventLogEnabled(boolean z) {
        f50392b.setNetEventLogEnabled(z);
    }

    public static void setMaxNetEventUploadNum(long j) {
        f50392b.setMaxNetEventUploadNum(j);
    }

    public static void setAllNetUploadEnable(boolean z) {
        f50392b.setAllNetUploadEnable(z);
    }

    public static void setAllNetUploadLimit(long j) {
        f50392b.setAllNetUploadLimit(j);
    }

    public static void initUploadUrls(String str) {
        if (!"".equals(str)) {
            if ("all".equals(str)) {
                f50392b.setUploadAllUrlEnable(true);
            } else {
                f50392b.setUploadAllUrlEnable(false);
            }
            f50392b.initWhiteListAllNetCollectMap(str);
        }
    }

    public static void addUploadUrlWhiteList(String str) {
        f50392b.addUploadUrlWhiteList(str);
    }

    public static void addUploadUrlWhiteListAll(Map<String, Boolean> map) {
        f50392b.addUploadUrlWhiteListAll(map);
    }

    public static void clearUploadUrlWhiteList() {
        f50392b.clearUploadUrlPath();
    }

    public static void setExceptionCollectRate(double d) {
        f50392b.setExceptionCollectRate(d);
    }
}
