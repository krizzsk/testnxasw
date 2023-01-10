package com.didi.dimina.container.bridge.plugin;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.plugin.exception.GlobalBridgeModuleRegisteredException;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalJSModuleManager {

    /* renamed from: a */
    private static final Map<String, Class<? extends BaseServiceModule>> f18643a = new HashMap();

    /* renamed from: b */
    private static final List<Class<? extends BaseServiceModule>> f18644b = new ArrayList();

    /* renamed from: c */
    private static final Map<DMMina, Map<String, JSModuleWrapper>> f18645c = new HashMap();

    /* renamed from: d */
    private static final Map<DMMina, InternalJSMethodsOperator> f18646d = new HashMap();

    private GlobalJSModuleManager() {
    }

    public static synchronized JSModuleWrapper getRegisterJSModule(DMMina dMMina, String str) {
        JSModuleWrapper jSModuleWrapper;
        synchronized (GlobalJSModuleManager.class) {
            jSModuleWrapper = getGlobalJSModuleTables(dMMina).get(str);
        }
        return jSModuleWrapper;
    }

    public static synchronized Map<String, JSModuleWrapper> getGlobalJSModuleTables(DMMina dMMina) {
        Map<String, JSModuleWrapper> map;
        synchronized (GlobalJSModuleManager.class) {
            map = f18645c.get(dMMina);
            if (map == null) {
                map = new HashMap<>();
                for (Map.Entry next : f18643a.entrySet()) {
                    map.put(next.getKey(), new JSModuleWrapper((String) next.getKey(), (Class) next.getValue()));
                }
                f18645c.put(dMMina, map);
            }
        }
        return map;
    }

    public static synchronized List<JSModuleWrapper> getDMServiceSubJSModuleWrapper(DMMina dMMina) {
        List<JSModuleWrapper> listInternalMethodsWrapper;
        synchronized (GlobalJSModuleManager.class) {
            InternalJSMethodsOperator internalJSMethodsOperator = f18646d.get(dMMina);
            if (internalJSMethodsOperator == null) {
                internalJSMethodsOperator = new InternalJSMethodsOperator();
                for (Class<? extends BaseServiceModule> a : f18644b) {
                    internalJSMethodsOperator.mo59731a(a);
                }
                f18646d.put(dMMina, internalJSMethodsOperator);
            }
            listInternalMethodsWrapper = internalJSMethodsOperator.getListInternalMethodsWrapper();
        }
        return listInternalMethodsWrapper;
    }

    public static synchronized void release(DMMina dMMina) {
        synchronized (GlobalJSModuleManager.class) {
            f18646d.remove(dMMina);
            f18645c.remove(dMMina);
        }
    }

    public static synchronized void registerJSModule(String str, Class<? extends BaseServiceModule> cls) throws GlobalBridgeModuleRegisteredException {
        synchronized (GlobalJSModuleManager.class) {
            if (!f18643a.containsKey(str)) {
                f18643a.put(str, cls);
            } else {
                throw new GlobalBridgeModuleRegisteredException("moduleName: " + str + " 已经注册过了,不允许重复注册, 已注册的类名是:" + f18643a.get(str).getName());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void registerDMServiceSubJSModule(java.lang.Class<? extends com.didi.dimina.container.messager.jsmodule.BaseServiceModule> r2) {
        /*
            java.lang.Class<com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager> r0 = com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x0018
            java.util.List<java.lang.Class<? extends com.didi.dimina.container.messager.jsmodule.BaseServiceModule>> r1 = f18644b     // Catch:{ all -> 0x0015 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            java.util.List<java.lang.Class<? extends com.didi.dimina.container.messager.jsmodule.BaseServiceModule>> r1 = f18644b     // Catch:{ all -> 0x0015 }
            r1.add(r2)     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)
            return
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0018:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager.registerDMServiceSubJSModule(java.lang.Class):void");
    }
}
