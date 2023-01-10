package com.didi.dimina.container.messager;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.messager.MessageHandler;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.monitor.TimeTrackMonitor;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

public class DMMessageTransfer {
    public static final String DM_MESSAGE_THREAD = "DMMessageTransfer_Thread";

    /* renamed from: a */
    private static final String f18746a = "DiminaServiceBridge";

    /* renamed from: b */
    private static final String f18747b = "invokeCallbackHandler";

    /* renamed from: c */
    private static final String f18748c = "subscribeHandler";

    /* renamed from: d */
    private final DMMina f18749d;

    /* renamed from: e */
    private boolean f18750e = false;

    /* renamed from: f */
    private final LinkedList<Runnable> f18751f = new LinkedList<>();

    /* renamed from: g */
    private volatile boolean f18752g;

    /* renamed from: h */
    private Handler f18753h;

    /* renamed from: i */
    private final HandlerThread f18754i;

    public DMMessageTransfer(int i) {
        HandlerThread handlerThread = new HandlerThread(DM_MESSAGE_THREAD);
        this.f18754i = handlerThread;
        handlerThread.start();
        this.f18753h = new Handler(this.f18754i.getLooper());
        this.f18752g = true;
        this.f18749d = DMMinaPool.get(i);
        try {
            MessageHandler.sEnableAllBridgeListener = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, false)).booleanValue();
            MessageHandler.sEnableFirstDomReadyBridgeListener = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, false)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enableServiceMessageTransform() {
        this.f18752g = false;
    }

    public Object invokeNativeFromService(JSArray jSArray) {
        return TimeTrackMonitor.timeTrackAction(this.f18749d.getConfig().getLaunchConfig().getMonitorLogConfig().getJsCoreLog(), jSArray, new Function0(jSArray) {
            public final /* synthetic */ JSArray f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke() {
                return DMMessageTransfer.this.m15916a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Object m15916a(JSArray jSArray) {
        if (jSArray.length() == 0 || this.f18752g) {
            return "";
        }
        String string = jSArray.getString(0);
        String jSONString = jSArray.getObject(1).toJSONString();
        String string2 = jSArray.getString(2);
        String string3 = TextUtil.isEmpty(jSArray.getString(3)) ? "DMServiceBridgeModule" : jSArray.getString(3);
        if (TextUtil.isEmpty(string2)) {
            return m15928b(jSArray, string, string2, jSONString, string3);
        }
        this.f18753h.post(new Runnable(jSArray, string, string2, jSONString, string3) {
            public final /* synthetic */ JSArray f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ String f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DMMessageTransfer.this.m15928b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Object m15928b(JSArray jSArray, String str, String str2, String str3, String str4) {
        try {
            return m15918a(str4, str, TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3), str2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m16839e("jsArray-Native: " + jSArray.toJSONArray());
            TraceUtil.trackEventError(this.f18749d.getMinaIndex(), "JSEngineException", 1011, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    private Object m15918a(String str, String str2, JSONObject jSONObject, String str3) {
        return MessageHandler.handleFromService(this.f18749d, str, str2, jSONObject, new MessageHandler.Callback(str3) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onResult(JSONObject jSONObject) {
                DMMessageTransfer.this.m15931c(this.f$1, jSONObject);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15931c(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            invokeCallbackToService(str, jSONObject);
        }
    }

    public void sendMessageToServiceFromNative(String str, JSONObject jSONObject) {
        m15926a(f18746a, f18747b, m15919a(str, jSONObject));
    }

    public void invokeCallbackToService(String str, JSONObject jSONObject) {
        m15926a(f18746a, f18747b, m15927b(str, jSONObject));
    }

    public void sendMessageToServiceFromWebView(String str) {
        JSEngineWrapper jSEngine = this.f18749d.getJSEngine();
        jSEngine.executeScript("javascript: DiminaServiceBridge.subscribeHandler(" + str + ")");
    }

    /* renamed from: a */
    private void m15926a(String str, String str2, JSONObject jSONObject) {
        JSEngineWrapper jSEngine = this.f18749d.getJSEngine();
        jSEngine.executeScript("javascript: " + str + "." + str2 + "(" + jSONObject + ")");
    }

    public void invokeNativeFromWebView(WebViewEngine webViewEngine, String str, String str2, String str3, String str4) {
        this.f18753h.post(new Runnable(str4, str, str2, str3, webViewEngine) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ WebViewEngine f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DMMessageTransfer.this.m15930b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15930b(String str, String str2, String str3, String str4, WebViewEngine webViewEngine) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "DMWebViewBridgeModule";
            }
            m15925a(str, str2, str3, str4, webViewEngine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m15925a(String str, String str2, String str3, String str4, WebViewEngine webViewEngine) {
        String str5 = str;
        String str6 = str2;
        MessageHandler.handleFromWebView(this.f18749d, str5, str6, JSONUtil.toJSONObject(str3), webViewEngine, new MessageHandler.Callback(webViewEngine, str4) {
            public final /* synthetic */ WebViewEngine f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResult(JSONObject jSONObject) {
                DMMessageTransfer.this.m15924a(this.f$1, this.f$2, jSONObject);
            }
        });
    }

    public void sendMessageToWebView(int i, String str) {
        m15921a(i, "javascript: DiminaWebViewBridge.subscribeHandler(" + str + ")");
    }

    public void sendMessageToWebView(WebViewEngine webViewEngine, String str, JSONObject jSONObject) {
        JSONObject a = m15919a(str, jSONObject);
        m15922a(webViewEngine, "javascript: DiminaWebViewBridge.invokeCallbackHandler(" + a.toString() + ")");
    }

    /* renamed from: invokeCallbackToWebView */
    public void m15924a(WebViewEngine webViewEngine, String str, JSONObject jSONObject) {
        if (webViewEngine != null) {
            JSONObject b = m15927b(str, jSONObject);
            m15922a(webViewEngine, "javascript: DiminaWebViewBridge.invokeCallbackHandler(" + b + ")");
        }
    }

    /* renamed from: a */
    private void m15921a(int i, String str) {
        WebViewEngine webViewEngine = this.f18749d.getDmWebViewManager().get(Integer.valueOf(i));
        if (webViewEngine != null) {
            m15922a(webViewEngine, str);
        }
    }

    public void ddInvokeJSToJSEngineWhileBusinessReady(Runnable runnable) {
        if (this.f18750e) {
            runnable.run();
        } else {
            this.f18751f.addLast(runnable);
        }
    }

    public void setBusinessReady() {
        if (!this.f18750e) {
            this.f18750e = true;
            Iterator it = this.f18751f.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }

    /* renamed from: a */
    private void m15922a(WebViewEngine webViewEngine, String str) {
        if (webViewEngine != null) {
            UIHandlerUtil.runOnUiThread(new Runnable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WebViewEngine.this.evaluateJavascript(this.f$1, (WebViewEngine.WebViewEngineValueCallback<String>) null);
                }
            });
        }
    }

    public void release() {
        this.f18752g = true;
        UIHandlerUtil.post(new Runnable() {
            public final void run() {
                DMMessageTransfer.this.m15920a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15920a() {
        Handler handler = this.f18753h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f18753h = null;
        }
        HandlerThread handlerThread = this.f18754i;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public void evaluateJavascriptWebView(WebViewEngine webViewEngine, String str, WebViewEngine.WebViewEngineValueCallback<String> webViewEngineValueCallback) {
        UIHandlerUtil.runOnUiThread(new Runnable(str, webViewEngineValueCallback) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ WebViewEngine.WebViewEngineValueCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                WebViewEngine.this.evaluateJavascript(this.f$1, this.f$2);
            }
        });
    }

    /* renamed from: a */
    private JSONObject m15919a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "payload", (Object) jSONObject);
        JSONUtil.put(jSONObject2, "event", (Object) str);
        return jSONObject2;
    }

    /* renamed from: b */
    private JSONObject m15927b(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "payload", (Object) jSONObject);
        JSONUtil.put(jSONObject2, "invokeId", (Object) str);
        return jSONObject2;
    }
}
