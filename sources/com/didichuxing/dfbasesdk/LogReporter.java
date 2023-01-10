package com.didichuxing.dfbasesdk;

import com.didichuxing.dfbasesdk.logupload.LogSaver;
import com.didichuxing.dfbasesdk.logupload.LoggerParam;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class LogReporter implements ILogReporter {

    /* renamed from: a */
    private String f49131a;

    /* renamed from: b */
    private String f49132b;

    /* renamed from: c */
    private String f49133c = UUID.randomUUID().toString();

    /* renamed from: d */
    private String f49134d;

    /* renamed from: e */
    private final String f49135e;

    /* renamed from: f */
    private String f49136f;

    /* renamed from: g */
    private final String f49137g;

    public LogReporter(String str, String str2, String str3, String str4, String str5) {
        this.f49131a = str;
        this.f49132b = str2;
        this.f49134d = str3;
        this.f49135e = str4;
        this.f49137g = str5;
    }

    public void setAppealId(String str) {
        this.f49136f = str;
    }

    public void report(String str) {
        report(str, (Map<String, Object>) null);
    }

    public void reportEventWithCode(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(i));
        report(str, hashMap);
    }

    public void report(String str, Map<String, Object> map) {
        report(str, map, (Map<String, Object>) null);
    }

    public void report(String str, Map<String, Object> map, Map<String, Object> map2) {
        LoggerParam a = m36797a(str);
        if (map != null) {
            a.eventDetail = GsonUtils.toJson(map);
        } else {
            a.eventDetail = "{}";
        }
        if (map2 != null) {
            a.extra = GsonUtils.toJson(map2);
        } else {
            a.extra = "{}";
        }
        LogSaver.getInstance().save(a);
    }

    /* renamed from: a */
    private LoggerParam m36797a(String str) {
        LoggerParam loggerParam = new LoggerParam();
        loggerParam.token = this.f49132b;
        loggerParam.bizCode = this.f49131a;
        loggerParam.seqId = this.f49133c;
        loggerParam.channel = "1";
        loggerParam.eventId = str;
        loggerParam.sessionId = this.f49134d;
        return loggerParam;
    }

    public void report(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        LoggerParam a = m36797a(str);
        if (jSONObject != null) {
            a.eventDetail = jSONObject.toString();
        } else {
            a.eventDetail = "{}";
        }
        if (jSONObject2 != null) {
            a.extra = jSONObject2.toString();
        } else {
            a.extra = "{}";
        }
        LogSaver.getInstance().save(a);
    }

    public void enter() {
        LogSaver.getInstance().setSdkVer(this.f49137g);
        LogSaver.getInstance().onEnter(AppContextHolder.getAppContext(), this.f49134d, this.f49135e);
    }

    public void exit() {
        LogSaver.getInstance().onExit();
    }

    public void setSessionId(String str) {
        this.f49134d = str;
        LogSaver.getInstance().setSessionId(str);
    }
}
