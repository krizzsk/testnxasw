package com.didi.dimina.starbox.websocket;

import android.os.Handler;
import android.text.TextUtils;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class V8Debugger {

    /* renamed from: f */
    private static final int f20054f = 0;

    /* renamed from: g */
    private static final int f20055g = 1;

    /* renamed from: h */
    private static final int f20056h = 2;

    /* renamed from: i */
    private static final String f20057i = "Runtime.runIfWaitingForDebugger";

    /* renamed from: j */
    private static final String f20058j = "Debugger.paused";

    /* renamed from: k */
    private static final String f20059k = "Debugger.resumed";

    /* renamed from: l */
    private static final String f20060l = "Debugger.resume";

    /* renamed from: m */
    private static final String f20061m = "Debugger.pause";

    /* renamed from: n */
    private static final String f20062n = "Debugger.enable";

    /* renamed from: o */
    private static final String f20063o = "Debugger.disable";

    /* renamed from: p */
    private static final String f20064p = "chrome_socket_closed";

    /* renamed from: q */
    private static final String f20065q = "websocket";

    /* renamed from: a */
    private final V8InspectorDelegate f20066a;

    /* renamed from: b */
    private final Handler f20067b;

    /* renamed from: c */
    private final Map<String, JSONObject> f20068c = Collections.synchronizedMap(new LinkedHashMap());

    /* renamed from: d */
    private final AtomicInteger f20069d = new AtomicInteger(0);

    /* renamed from: e */
    private int f20070e = 0;

    public V8Debugger(V8InspectorDelegate v8InspectorDelegate, Handler handler) {
        this.f20066a = v8InspectorDelegate;
        this.f20067b = handler;
    }

    public void onMessage(String str) {
        if (TextUtils.equals(f20064p, str)) {
            sendMessage2V8(f20063o, (JSONObject) null);
            return;
        }
        ChromeMessage newInstance = ChromeMessage.newInstance(str);
        if (newInstance != null) {
            if (TextUtils.equals(newInstance.method, f20062n)) {
                this.f20070e = 1;
            }
            sendMessage2V8(newInstance.method, newInstance.params);
        }
    }

    public void sendMessage2V8(final String str, final JSONObject jSONObject) {
        if (this.f20070e == 2 || this.f20066a == null) {
            synchronized (this.f20068c) {
                this.f20068c.put(str, jSONObject);
            }
            return;
        }
        Handler handler = this.f20067b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    V8Debugger.this.m16999a(str, jSONObject);
                }
            });
        } else {
            m16999a(str, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16999a(String str, JSONObject jSONObject) {
        Object obj;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("id")) {
                    obj = jSONObject.remove("id");
                    jSONObject2.put("id", obj);
                    jSONObject2.put("method", str);
                    jSONObject2.put("params", jSONObject);
                    this.f20066a.dispatchProtocolMessage(jSONObject2.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        obj = Integer.valueOf(this.f20069d.incrementAndGet());
        jSONObject2.put("id", obj);
        jSONObject2.put("method", str);
        jSONObject2.put("params", jSONObject);
        this.f20066a.dispatchProtocolMessage(jSONObject2.toString());
    }

    public final void recordMsgState(String str) {
        V8Response newInstance = V8Response.newInstance(str);
        if (newInstance != null) {
            if (!newInstance.method.equalsIgnoreCase("Debugger.scriptParsed")) {
                log("status：" + this.f20070e + ",onResponse: " + str);
            } else if (!TextUtils.isEmpty(newInstance.params.optString("url"))) {
                log("status：" + this.f20070e + ",onResponse: " + str);
            }
        }
        String str2 = newInstance != null ? newInstance.method : null;
        if (str2 != null) {
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 100879227) {
                if (hashCode == 720033066 && str2.equals(f20059k)) {
                    c = 1;
                }
            } else if (str2.equals(f20058j)) {
                c = 0;
            }
            if (c != 0) {
                if (c == 1 && this.f20070e == 2) {
                    this.f20070e = 1;
                }
            } else if (this.f20070e == 0) {
                m16999a(f20060l, (JSONObject) null);
            } else if (newInstance.params != null) {
                this.f20070e = 2;
            }
        }
    }

    public final void waitFrontendMessageOnPause() {
        if (this.f20070e != 2) {
            log("Debugger paused without connection.  Resuming J2V8");
            m16999a(f20060l, (JSONObject) null);
            return;
        }
        synchronized (this.f20068c) {
            if (!this.f20068c.isEmpty()) {
                for (Map.Entry next : this.f20068c.entrySet()) {
                    m17000b((String) next.getKey(), (JSONObject) next.getValue());
                }
                this.f20068c.clear();
            }
        }
    }

    /* renamed from: b */
    private void m17000b(String str, JSONObject jSONObject) {
        m16999a(str, jSONObject);
    }

    public static void log(String str) {
        LogUtil.m16840e("websocket", str);
    }

    public static class ChromeMessage {

        /* renamed from: id */
        public Long f20071id;
        public String method;
        public JSONObject params;

        public static ChromeMessage newInstance(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ChromeMessage chromeMessage = new ChromeMessage();
                chromeMessage.f20071id = Long.valueOf(jSONObject.optLong("id"));
                chromeMessage.method = jSONObject.optString("method");
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                chromeMessage.params = optJSONObject;
                if (optJSONObject == null) {
                    chromeMessage.params = new JSONObject();
                }
                chromeMessage.params.put("id", chromeMessage.f20071id);
                return chromeMessage;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class V8Response {

        /* renamed from: id */
        public int f20072id;
        public String method;
        public JSONObject params;
        public JSONObject result;

        public static V8Response newInstance(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                V8Response v8Response = new V8Response();
                v8Response.f20072id = jSONObject.optInt("id");
                v8Response.method = jSONObject.optString("method");
                v8Response.result = jSONObject.optJSONObject("result");
                v8Response.params = jSONObject.optJSONObject("params");
                return v8Response;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
