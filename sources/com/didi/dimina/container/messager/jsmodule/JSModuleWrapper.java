package com.didi.dimina.container.messager.jsmodule;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.BaseHybridModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class JSModuleWrapper {

    /* renamed from: a */
    private final String f18761a;

    /* renamed from: b */
    private final Class<?> f18762b;

    /* renamed from: c */
    private Map<String, Method> f18763c;

    /* renamed from: d */
    private BaseServiceModule f18764d;

    /* renamed from: e */
    private WeakHashMap<WebViewEngine, BaseHybridModule> f18765e;

    public JSModuleWrapper(String str, Class<?> cls) {
        this.f18761a = str;
        this.f18762b = cls;
    }

    public String getJSModuleName() {
        return this.f18761a;
    }

    public Class<?> getJSModuleClass() {
        return this.f18762b;
    }

    public Collection<String> getMethodNames() {
        if (this.f18763c == null) {
            this.f18763c = m15940a();
        }
        return this.f18763c.keySet();
    }

    public Method getTargetMethod(String str) {
        if (this.f18763c == null) {
            this.f18763c = m15940a();
        }
        return this.f18763c.get(str);
    }

    /* renamed from: a */
    private Map<String, Method> m15940a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f18762b.getMethods()) {
            JsInterface jsInterface = (JsInterface) method.getAnnotation(JsInterface.class);
            if (jsInterface != null) {
                for (String put : jsInterface.value()) {
                    hashMap.put(put, method);
                }
            }
        }
        return hashMap;
    }

    public BaseServiceModule getServiceModuleInstance(DMMina dMMina) {
        if (this.f18764d == null) {
            Object[] objArr = {dMMina};
            Class[] clsArr = new Class[1];
            for (int i = 0; i < 1; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            try {
                this.f18764d = (BaseServiceModule) this.f18762b.getConstructor(clsArr).newInstance(objArr);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return this.f18764d;
    }

    public void releaseServiceModuleInstance() {
        BaseServiceModule baseServiceModule = this.f18764d;
        if (baseServiceModule != null) {
            try {
                baseServiceModule.onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BaseHybridModule getWebViewModuleInstance(WebViewEngine webViewEngine, Object[] objArr) {
        if (this.f18765e == null) {
            this.f18765e = new WeakHashMap<>();
        }
        BaseHybridModule baseHybridModule = this.f18765e.get(webViewEngine);
        if (baseHybridModule == null) {
            try {
                baseHybridModule = (BaseHybridModule) this.f18762b.getConstructor(new Class[]{WebViewEngine.class}).newInstance(objArr);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (baseHybridModule != null) {
                this.f18765e.put(webViewEngine, baseHybridModule);
            }
        }
        return baseHybridModule;
    }

    public void releaseWebViewModuleInstance(WebViewEngine webViewEngine) {
        BaseHybridModule remove;
        WeakHashMap<WebViewEngine, BaseHybridModule> weakHashMap = this.f18765e;
        if (weakHashMap != null && (remove = weakHashMap.remove(webViewEngine)) != null) {
            try {
                remove.onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
