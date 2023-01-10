package com.iproov.sdk;

import android.content.Context;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.LoginLogger;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.C20748do;
import com.iproov.sdk.bridge.C20749if;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.core.C20886return;
import com.iproov.sdk.core.C20889this;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.logging.IPLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p095switch.C3679throw;
import p095switch.C3680try;
import p218io.socket.client.Socket;

public class NativeBridge {
    private static final String JAVASCRIPT_INTERFACE_NAME = "iProovNativeBridge";
    /* access modifiers changed from: private */
    public static final String TAG = "NativeBridge";
    private IProov.Listener listener;

    /* renamed from: com.iproov.sdk.NativeBridge$do */
    class C20736do implements IProov.Listener {

        /* renamed from: do */
        final /* synthetic */ WebView f56837do;

        C20736do(NativeBridge nativeBridge, WebView webView) {
            this.f56837do = webView;
        }

        public void onCancelled() {
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (Map<String, Object>) null));
        }

        public void onConnected() {
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if(AnalyseTickHelper.SDK_CONNECTED, (Map<String, Object>) null));
        }

        public void onConnecting() {
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if(Socket.EVENT_CONNECTING, (Map<String, Object>) null));
        }

        public void onError(IProovException iProovException) {
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if("error", Collections.singletonMap("error", iProovException.getLocalizedMessage())));
        }

        public void onFailure(IProov.FailureResult failureResult) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", failureResult.reason);
            hashMap.put("feedbackCode", failureResult.feedbackCode);
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if(LoginLogger.EVENT_EXTRAS_FAILURE, hashMap));
        }

        public void onProcessing(double d, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("progress", Double.valueOf(d));
            hashMap.put("message", str);
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if("processing", hashMap));
        }

        public void onSuccess(IProov.SuccessResult successResult) {
            NativeBridge.evaluateJavascript(this.f56837do, new C20749if("success", Collections.singletonMap("token", successResult.token)));
        }
    }

    /* renamed from: com.iproov.sdk.NativeBridge$if */
    private static class C20737if {

        /* renamed from: do */
        private final Context f56838do;

        /* renamed from: for  reason: not valid java name */
        private final boolean f62339for;

        /* renamed from: if */
        private final WebView f56839if;

        /* synthetic */ C20737if(WebView webView, boolean z, C20736do doVar) {
            this(webView, z);
        }

        @JavascriptInterface
        public boolean launch(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = C3680try.m7471if(jSONObject, "token");
                String str3 = C3680try.m7471if(jSONObject, "streaming_url");
                JSONObject optJSONObject = jSONObject.optJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                if (C3679throw.m7443do(str2)) {
                    IPLog.m43490e(NativeBridge.TAG, "Token not specified");
                    NativeBridge.evaluateJavascript(this.f56839if, new C20749if("error", Collections.singletonMap("error", "Token not specified")));
                    return false;
                } else if (C3679throw.m7443do(str3)) {
                    IPLog.m43490e(NativeBridge.TAG, "Streaming URL not specified");
                    NativeBridge.evaluateJavascript(this.f56839if, new C20749if("error", Collections.singletonMap("error", "Streaming URL not specified")));
                    return false;
                } else {
                    try {
                        try {
                            IProov.m42836a(this.f56838do, str3, str2, new C20886return(OptionsBridge.fromJson(this.f56838do, optJSONObject), new C20889this(C20889this.C20890do.NATIVE_BRIDGE)));
                            return true;
                        } catch (IProovException e) {
                            e.printStackTrace();
                            IPLog.m43494w(NativeBridge.TAG, "Failed to launch via native bridge");
                            return false;
                        }
                    } catch (IProovException e2) {
                        e2.printStackTrace();
                        IPLog.m43494w(NativeBridge.TAG, "Failed to launch via native bridge");
                        return false;
                    }
                }
            } catch (JSONException unused) {
                IPLog.m43490e(NativeBridge.TAG, "Failed to parse JSON launch configuration");
                NativeBridge.evaluateJavascript(this.f56839if, new C20749if("error", Collections.singletonMap("error", "Failed to parse JSON launch configuration")));
                return false;
            }
        }

        @JavascriptInterface
        public String publicKey() {
            if (this.f62339for) {
                IPLog.m43494w(NativeBridge.TAG, "Failed to get public key because cryptography is not enabled");
                return null;
            }
            try {
                return IProov.getKeyPair(this.f56838do).getPublicKey().getPem();
            } catch (IProovException e) {
                e.printStackTrace();
                IPLog.m43494w(NativeBridge.TAG, "Error signing data");
                return null;
            }
        }

        @JavascriptInterface
        public String sign(String str) {
            if (this.f62339for) {
                IPLog.m43494w(NativeBridge.TAG, "Failed to sign data because cryptography is not enabled");
                return null;
            } else if (str == null) {
                IPLog.m43494w(NativeBridge.TAG, "Error signing data, input can not be null");
                return null;
            } else {
                try {
                    return C3679throw.m7440do(IProov.getKeyPair(this.f56838do).sign(Base64.decode(str, 2)));
                } catch (IProovException e) {
                    e.printStackTrace();
                    String access$200 = NativeBridge.TAG;
                    IPLog.m43494w(access$200, "Error signing data: " + e.getMessage());
                    return null;
                }
            }
        }

        private C20737if(WebView webView, boolean z) {
            this.f56838do = webView.getContext().getApplicationContext();
            this.f56839if = webView;
            this.f62339for = z;
        }
    }

    /* access modifiers changed from: private */
    public static void evaluateJavascript(WebView webView, C20748do doVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Executing JS: ");
        sb.append(doVar.mo171273do());
        C3679throw.m7442do((Runnable) new Runnable(webView, doVar) {
            public final /* synthetic */ WebView f$0;
            public final /* synthetic */ C20748do f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                this.f$0.evaluateJavascript(this.f$1.mo171273do(), (ValueCallback) null);
            }
        });
    }

    private IProov.Listener webViewBridgeListener(WebView webView) {
        return new C20736do(this, webView);
    }

    public void install(WebView webView, boolean z) {
        if (webView == null) {
            IPLog.m43490e(TAG, "Cannot install into a null webView");
            return;
        }
        if (!webView.getSettings().getJavaScriptEnabled()) {
            IPLog.m43490e(TAG, "Native Bridge requires WebView Javascript execution to be enabled");
        }
        IProov.Listener webViewBridgeListener = IProov.nativeBridge.webViewBridgeListener(webView);
        this.listener = webViewBridgeListener;
        IProov.registerListener(webViewBridgeListener);
        webView.addJavascriptInterface(new C20737if(webView, z, (C20736do) null), JAVASCRIPT_INTERFACE_NAME);
    }

    public void uninstall(WebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface(JAVASCRIPT_INTERFACE_NAME);
        }
        IProov.Listener listener2 = this.listener;
        if (listener2 != null) {
            IProov.unregisterListener(listener2);
            this.listener = null;
        }
    }
}
