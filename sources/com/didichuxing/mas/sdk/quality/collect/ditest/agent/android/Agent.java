package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Encoder;
import com.didichuxing.mas.sdk.quality.collect.ditest.assistant.EnvSwitchManager;

public class Agent {
    public static final String VERSION = "1.1.0";

    /* renamed from: a */
    private static final AgentImpl f50360a = new NullAgentImpl();

    /* renamed from: b */
    private static Object f50361b = new Object();

    /* renamed from: c */
    private static AgentImpl f50362c = f50360a;

    /* renamed from: d */
    private static boolean f50363d = false;

    public static String getVersion() {
        return "1.1.0";
    }

    public static void setImpl(AgentImpl agentImpl) {
        synchronized (f50361b) {
            if (f50362c == null) {
                f50362c = f50360a;
            } else {
                f50362c = agentImpl;
            }
        }
    }

    public static AgentImpl getImpl() {
        AgentImpl agentImpl;
        synchronized (f50361b) {
            agentImpl = f50362c;
        }
        return agentImpl;
    }

    public static int getResponseBodyLimit() {
        return getImpl().getResponseBodyLimit();
    }

    public static String getActiveNetworkCarrier() {
        return getImpl().getNetworkCarrier();
    }

    public static String getActiveNetworkWanType() {
        return getImpl().getNetworkWanType();
    }

    public static void disable() {
        getImpl().disable();
    }

    public static boolean isDisabled() {
        return getImpl().isDisabled();
    }

    public static void start() {
        getImpl().start();
    }

    public static void stop() {
        getImpl().stop();
    }

    public static void setLocation(String str, String str2) {
        getImpl().setLocation(str, str2);
    }

    public static Encoder getEncoder() {
        return getImpl().getEncoder();
    }

    public static boolean isEnvSwitchEnable() {
        return f50363d && EnvSwitchManager.getInstance().isEffect();
    }

    public static void setEnvSwitchEnable(Boolean bool) {
        f50363d = bool.booleanValue();
    }

    public static boolean isApmNetEnable() {
        return getImpl().isApmNetEnable();
    }

    public static boolean isApmUiEnable() {
        return getImpl().isApmUiEnable();
    }

    public static boolean isUploadNetPerf() {
        return getImpl().isUploadNetPerf();
    }

    public static boolean isUploadErrorDiag() {
        return getImpl().isUploadErrorDiag();
    }

    public static boolean canUploadNetErrEvent() {
        return getImpl().canUploadNetErrEvent();
    }

    public static boolean isNetEventLogEnabled() {
        return getImpl().getAgentConfig().isNetEventLogEnabled();
    }

    public static boolean isUploadAllNetEnabled() {
        return getImpl().getAgentConfig().isAllNetUploadEnable();
    }

    public static long getMaxTrafficFiveMinutes() {
        return getImpl().getAgentConfig().getMaxTrafficFiveMinutes();
    }

    public static long getMaxTrafficPerDay() {
        return getImpl().getAgentConfig().getMaxTrafficPerDay();
    }
}
