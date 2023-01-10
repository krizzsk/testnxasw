package com.didi.dimina.webview.jsbridge;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.webview.container.FusionWebView;
import com.didi.dimina.webview.exception.BridgeCallException;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewJavascriptBridge {

    /* renamed from: a */
    private static final String f20160a = "WebViewJavascriptBridge";
    public static final Map<String, ExportNamespace> namespaceMap = new HashMap();

    /* renamed from: b */
    private final Activity f20161b;

    /* renamed from: c */
    private final FusionWebView f20162c;

    /* renamed from: d */
    private long f20163d = 0;

    /* renamed from: e */
    private final Map<String, CallbackFunction> f20164e = new HashMap();

    public static void export(String str, Class cls) {
        namespaceMap.put(str, new ExportNamespace(str, cls));
    }

    public WebViewJavascriptBridge(Activity activity, FusionWebView fusionWebView) {
        this.f20161b = activity;
        this.f20162c = fusionWebView;
    }

    public void handleInvokeFromJs(String str) {
        InvokeMessage parseInvokeMessage = BridgeHelper.parseInvokeMessage(str);
        parseInvokeMessage.setInvokeFrom("fusion");
        try {
            invokeNativeMethod(parseInvokeMessage);
        } catch (BridgeCallException e) {
            e.printStackTrace();
        }
    }

    public Object invokeNativeMethod(InvokeMessage invokeMessage) {
        ExportNamespace exportNamespace = namespaceMap.get(invokeMessage.getModuleName());
        if (exportNamespace != null) {
            Class exportClass = exportNamespace.getExportClass();
            Method targetMethod = exportNamespace.getTargetMethod(invokeMessage.getFunctionName());
            if (targetMethod != null) {
                return m17025a(exportClass, targetMethod, invokeMessage);
            }
            m17026a(invokeMessage, "400");
            return null;
        }
        m17026a(invokeMessage, "403");
        return null;
    }

    /* renamed from: a */
    private Object m17025a(Class cls, Method method, InvokeMessage invokeMessage) {
        Object invoke;
        Object[] argsForNative = invokeMessage.getArgsForNative();
        String invokeFrom = invokeMessage.getInvokeFrom();
        Class<CallbackFunction>[] parameterTypes = method.getParameterTypes();
        try {
            int length = parameterTypes.length;
            for (int i = 0; i < length; i++) {
                Class<CallbackFunction> cls2 = parameterTypes[i];
                if (cls2.isInterface() && cls2 == CallbackFunction.class) {
                    if (i == length - 1 && argsForNative.length < length) {
                        Object[] objArr = new Object[(argsForNative.length + 1)];
                        System.arraycopy(argsForNative, 0, objArr, 0, argsForNative.length);
                        objArr[i] = new DummyCallbackToJS();
                        argsForNative = objArr;
                    } else if (argsForNative[i] == null) {
                        argsForNative[i] = new DummyCallbackToJS();
                    } else if ("ancient".equals(invokeFrom)) {
                        argsForNative[i] = new AncientCallbackToJS(this, (Integer) argsForNative[i], invokeMessage.getTraceId());
                    } else if ("previous".equals(invokeFrom)) {
                        argsForNative[i] = new PreviousCallbackToJS(this, invokeMessage.getPreviousCallId(), String.valueOf(argsForNative[i]), invokeMessage.getTraceId());
                    } else {
                        argsForNative[i] = new DefaultCallbackToJS(this, String.valueOf(argsForNative[i]), invokeMessage.getTraceId());
                    }
                }
            }
            if (Modifier.isStatic(method.getModifiers())) {
                try {
                    invoke = method.invoke(cls, argsForNative);
                } catch (IllegalAccessException e) {
                    m17028a((Exception) e, invokeMessage);
                    return null;
                } catch (InvocationTargetException e2) {
                    m17028a((Exception) e2, invokeMessage);
                    return null;
                } catch (IllegalArgumentException e3) {
                    m17026a(invokeMessage, "401");
                    m17028a((Exception) e3, invokeMessage);
                    return null;
                } catch (NullPointerException e4) {
                    m17028a((Exception) e4, invokeMessage);
                    return null;
                }
            } else {
                invoke = method.invoke(this.f20162c.getExportModuleInstance(cls), argsForNative);
            }
            return invoke;
        } catch (Exception e5) {
            throw new RuntimeException("executeTargetMethod error invoke info:" + invokeMessage, e5);
        }
    }

    /* renamed from: a */
    private void m17028a(Exception exc, InvokeMessage invokeMessage) {
        throw new BridgeCallException("Bridge invoke Detail:\n" + invokeMessage.toString() + "\nError occur in :" + this.f20162c.getUrl() + "\n", exc);
    }

    /* renamed from: a */
    private void m17026a(InvokeMessage invokeMessage, String str) {
        OmegaSDKAdapter.trackEvent("tone_p_x_fusion_jsbridge", str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62915a(CallbackMessage callbackMessage) {
        executeCallJS(String.format("javascript:Fusion.callbackJS('%s', %s);", new Object[]{callbackMessage.getCallbackId(), callbackMessage.getArgumentsAsJSONArray().toString()}));
    }

    public void invokeJSMethod(String str, String str2, Object... objArr) {
        int i;
        JSONArray jSONArray = new JSONArray();
        if (objArr == null) {
            i = 0;
        } else {
            i = objArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            CallbackFunction callbackFunction = objArr[i2];
            if (callbackFunction instanceof CallbackFunction) {
                long j = this.f20163d + 1;
                this.f20163d = j;
                String valueOf = String.valueOf(j);
                String format = String.format("__${%s}__", new Object[]{valueOf});
                this.f20164e.put(valueOf, callbackFunction);
                jSONArray.put(format);
            } else {
                jSONArray.put(callbackFunction);
            }
        }
        m17030a(str, str2, jSONArray.toString());
    }

    /* renamed from: a */
    private void m17030a(String str, String str2, String str3) {
        InvokeMessage invokeMessage = new InvokeMessage();
        invokeMessage.setModuleName(str);
        invokeMessage.setFunctionName(str2);
        invokeMessage.setArgs(str3);
        executeCallJS(String.format("javascript:Fusion.invokeJSMethod('%s', '%s', %s);", new Object[]{invokeMessage.getModuleName(), invokeMessage.getFunctionName(), invokeMessage.getArgs()}));
    }

    public void handleResponseFromJS(String str) {
        InvokeMessage parseInvokeMessage = BridgeHelper.parseInvokeMessage(str);
        CallbackFunction callbackFunction = this.f20164e.get(parseInvokeMessage.getFunctionName());
        if (callbackFunction != null) {
            callbackFunction.onCallBack(parseInvokeMessage.getArgsForNative());
            this.f20164e.remove(parseInvokeMessage.getFunctionName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17029a(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f20162c.evaluateJavascript(str, (ValueCallback) null);
        } else {
            this.f20162c.loadUrl(str);
        }
    }

    public void executeCallJS(final String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m17029a(str);
        } else {
            this.f20161b.runOnUiThread(new Runnable() {
                public void run() {
                    WebViewJavascriptBridge.this.m17029a(str);
                }
            });
        }
    }

    public JSONArray getExportModules() {
        Collection<ExportNamespace> values = namespaceMap.values();
        JSONArray jSONArray = new JSONArray();
        for (ExportNamespace next : values) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("module", next.getExportModuleName());
                jSONObject.put("methods", next.getExportMethodNames());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public ExportNamespace getExportModule(String str) {
        return namespaceMap.get(str);
    }
}
