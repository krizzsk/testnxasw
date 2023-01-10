package com.didichuxing.dfbasesdk.logupload2;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class LogReporter2 {

    /* renamed from: f */
    private static final String f49308f = "logNum";

    /* renamed from: g */
    private static final String f49309g = "seqId";

    /* renamed from: h */
    private static final String f49310h = "clientTime";

    /* renamed from: i */
    private static final String f49311i = "channel";

    /* renamed from: j */
    private static final String f49312j = "1";

    /* renamed from: k */
    private static final String f49313k = "logDBData";

    /* renamed from: a */
    private String f49314a;

    /* renamed from: b */
    private String f49315b;

    /* renamed from: c */
    private final Map<String, Object> f49316c;

    /* renamed from: d */
    private String f49317d;

    /* renamed from: e */
    private final String f49318e;

    public LogReporter2(String str) {
        this(str, (Map<String, Object>) null);
    }

    public LogReporter2(String str, Map<String, Object> map) {
        this.f49314a = str;
        this.f49316c = map;
        if (map != null) {
            this.f49317d = GsonUtils.toJson(map);
        }
        this.f49318e = UUID.randomUUID().toString();
        CrashHandler.getInstance().init(AppContextHolder.getAppContext());
        checkLogDataBase();
    }

    public void setFullUrl(String str) {
        this.f49314a = str;
    }

    @Deprecated
    public static void setRsaPublic(String str, String str2) {
        LogInnerTask.m36980a().setEncrypt(str, !TextUtils.isEmpty(str2));
    }

    public void setEncrypt(String str, boolean z) {
        LogInnerTask.m36980a().setEncrypt(str, z);
    }

    public void setCallerVersion(String str, String str2) {
        LogInnerTask.m36980a().setCallerVersion(str, str2);
    }

    public void setCallerName(String str) {
        this.f49315b = str;
    }

    public static void saveDBStatus(boolean z) {
        new SPHelper(AppContextHolder.getAppContext(), "share_data").put(f49313k, Boolean.valueOf(z)).apply();
    }

    public static void checkLogDataBase() {
        if (((Boolean) new SPHelper(AppContextHolder.getAppContext(), "share_data").get(f49313k, true)).booleanValue()) {
            LogDBTask.m36957b().mo122289a();
        }
    }

    public String getSeqId() {
        return this.f49318e;
    }

    /* renamed from: a */
    private void m36991a(String str, String str2) {
        LogInnerTask.m36980a().mo122310a(str2, str, this.f49317d);
    }

    public <T> void log(T t, String str, String str2) {
        String str3;
        JSONObject jSONObject;
        if (t != null && !TextUtils.isEmpty(str)) {
            if (t instanceof IOnesdkLog) {
                str3 = GsonUtils.toJson(t, true);
            } else if (t instanceof BaseLogBean) {
                BaseLogBean baseLogBean = (BaseLogBean) t;
                baseLogBean.clientTime = System.currentTimeMillis();
                baseLogBean.seqId = this.f49318e;
                baseLogBean.channel = "1";
                baseLogBean.logNum = LogInnerTask.m36980a().mo122309a(m36992b(str, str2));
                str3 = GsonUtils.toJsonStr(baseLogBean);
            } else if (t instanceof Map) {
                Map map = (Map) t;
                map.put(f49309g, this.f49318e);
                map.put(f49310h, Long.valueOf(System.currentTimeMillis()));
                map.put("channel", "1");
                map.put(f49308f, Integer.valueOf(LogInnerTask.m36980a().mo122309a(m36992b(str, str2))));
                str3 = GsonUtils.toJsonStr(map);
            } else {
                try {
                    if (t instanceof JSONObject) {
                        jSONObject = (JSONObject) t;
                    } else {
                        jSONObject = new JSONObject(GsonUtils.toJsonStr(t));
                    }
                    jSONObject.put(f49309g, this.f49318e);
                    jSONObject.put(f49310h, System.currentTimeMillis());
                    jSONObject.put("channel", "1");
                    jSONObject.put(f49308f, LogInnerTask.m36980a().mo122309a(m36992b(str, str2)));
                    str3 = jSONObject.toString();
                } catch (Throwable unused) {
                    str3 = "{}";
                }
            }
            m36991a(str3, str);
        }
    }

    @Deprecated
    public <T> void log(T t) {
        log(t, this.f49314a, this.f49315b);
    }

    /* renamed from: a */
    private String m36990a() {
        return m36992b(this.f49314a, this.f49315b);
    }

    /* renamed from: b */
    private String m36992b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        String trim = str.toLowerCase().trim();
        int indexOf = trim.indexOf(HWMapConstant.HTTP.SEPARATOR);
        int indexOf2 = trim.indexOf(63);
        int i = indexOf >= 0 ? indexOf + 3 : 0;
        if (indexOf2 < 0) {
            indexOf2 = trim.length();
        }
        return trim.substring(i, indexOf2);
    }

    @Deprecated
    public void log(Map<String, Object> map) {
        log(map, this.f49314a, this.f49315b);
    }
}
