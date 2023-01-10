package com.didi.onehybrid.jsbridge;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.exception.BridgeCallException;
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
    private static final String f32086a = "WebViewJavascriptBridge";
    public static final Map<String, ExportNamespace> namespaceMap = new HashMap();

    /* renamed from: b */
    private Activity f32087b;

    /* renamed from: c */
    private FusionWebView f32088c;

    /* renamed from: d */
    private FusionRuntimeInfo f32089d;

    /* renamed from: e */
    private long f32090e = 0;

    /* renamed from: f */
    private Map<String, CallbackFunction> f32091f = new HashMap();

    public static void export(String str, Class cls) {
        namespaceMap.put(str, new ExportNamespace(str, cls));
    }

    public WebViewJavascriptBridge(HybridableContainer hybridableContainer) {
        this.f32087b = hybridableContainer.getActivity();
        FusionWebView webView = hybridableContainer.getWebView();
        this.f32088c = webView;
        this.f32089d = webView.getFusionRuntimeInfo();
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
        this.f32089d.recordBridgeInvoke(invokeMessage);
        ExportNamespace exportNamespace = namespaceMap.get(invokeMessage.getModuleName());
        if (exportNamespace != null) {
            Class exportClass = exportNamespace.getExportClass();
            Method targetMethod = exportNamespace.getTargetMethod(invokeMessage.getFunctionName());
            if (targetMethod != null) {
                return m24414a(exportClass, targetMethod, invokeMessage);
            }
            m24415a(invokeMessage, "400");
            return null;
        }
        m24415a(invokeMessage, "403");
        return null;
    }

    /* renamed from: a */
    private Object m24414a(Class cls, Method method, InvokeMessage invokeMessage) {
        Object invoke;
        Object[] argsForNative = invokeMessage.getArgsForNative();
        String invokeFrom = invokeMessage.getInvokeFrom();
        Class<CallbackFunction>[] parameterTypes = method.getParameterTypes();
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
                m24417a((Exception) e, invokeMessage);
                return null;
            } catch (InvocationTargetException e2) {
                m24417a((Exception) e2, invokeMessage);
                return null;
            } catch (IllegalArgumentException e3) {
                m24415a(invokeMessage, "401");
                m24417a((Exception) e3, invokeMessage);
                return null;
            } catch (NullPointerException e4) {
                m24417a((Exception) e4, invokeMessage);
                return null;
            }
        } else {
            invoke = method.invoke(this.f32088c.getExportModuleInstance(cls), argsForNative);
        }
        return invoke;
    }

    /* renamed from: a */
    private void m24417a(Exception exc, InvokeMessage invokeMessage) {
        throw new BridgeCallException("Bridge invoke Detail:\n" + invokeMessage.toString() + "\n" + "Error occur in :" + this.f32088c.getUrl() + "\n", exc);
    }

    /* renamed from: a */
    private void m24415a(InvokeMessage invokeMessage, String str) {
        OmegaSDKAdapter.trackEvent("tone_p_x_fusion_jsbridge", str);
        this.f32089d.recordBridgeException(invokeMessage.getTraceId(), str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo86625a(CallbackMessage callbackMessage) {
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
                long j = this.f32090e + 1;
                this.f32090e = j;
                String valueOf = String.valueOf(j);
                String format = String.format("__${%s}__", new Object[]{valueOf});
                this.f32091f.put(valueOf, callbackFunction);
                jSONArray.put(format);
            } else {
                jSONArray.put(callbackFunction);
            }
        }
        m24419a(str, str2, jSONArray.toString());
    }

    /* renamed from: a */
    private void m24419a(String str, String str2, String str3) {
        InvokeMessage invokeMessage = new InvokeMessage();
        invokeMessage.setModuleName(str);
        invokeMessage.setFunctionName(str2);
        invokeMessage.setArgs(str3);
        executeCallJS(String.format("javascript:Fusion.invokeJSMethod('%s', '%s', %s);", new Object[]{invokeMessage.getModuleName(), invokeMessage.getFunctionName(), invokeMessage.getArgs()}));
    }

    public void handleResponseFromJS(String str) {
        InvokeMessage parseInvokeMessage = BridgeHelper.parseInvokeMessage(str);
        CallbackFunction callbackFunction = this.f32091f.get(parseInvokeMessage.getFunctionName());
        if (callbackFunction != null) {
            callbackFunction.onCallBack(parseInvokeMessage.getArgsForNative());
            this.f32091f.remove(parseInvokeMessage.getFunctionName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24418a(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f32088c.evaluateJavascript(str, (ValueCallback) null);
        } else {
            this.f32088c.loadUrl(str);
        }
    }

    public void executeCallJS(final String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m24418a(str);
        } else {
            this.f32087b.runOnUiThread(new Runnable() {
                public void run() {
                    WebViewJavascriptBridge.this.m24418a(str);
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

    public FusionRuntimeInfo getFusionRuntimeInfo() {
        return this.f32089d;
    }
}
