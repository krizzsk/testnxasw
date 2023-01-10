package com.didi.drouter.service;

import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.remote.RemoteBridge;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.store.Statistics;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ServiceAgent<T> {

    /* renamed from: a */
    private static final Map<Class<?>, Object> f21086a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final Map<Class<?>, WeakReference<Object>> f21087b = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<Class<?>, RouterMeta> f21088c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Class<T> f21089d;

    /* renamed from: e */
    private String f21090e = "";

    /* renamed from: f */
    private Object f21091f;

    /* renamed from: g */
    private String f21092g;

    /* renamed from: h */
    private int f21093h;

    /* renamed from: i */
    private WeakReference<LifecycleOwner> f21094i;

    /* renamed from: j */
    private T f21095j;

    ServiceAgent(Class<T> cls) {
        Statistics.track("service");
        this.f21089d = cls;
        for (RouterMeta next : RouterStore.getServiceMetas(cls)) {
            if (next.getRouterType() == RouterMeta.SERVICE && !next.isDynamic()) {
                this.f21088c.put(next.getTargetClass(), next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63872a(String str) {
        if (str == null) {
            str = "";
        }
        this.f21090e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63871a(Object obj) {
        this.f21091f = obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63876b(String str) {
        this.f21092g = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63869a(int i) {
        this.f21093h = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63870a(LifecycleOwner lifecycleOwner) {
        this.f21094i = lifecycleOwner != null ? new WeakReference<>(lifecycleOwner) : null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63875b(T t) {
        this.f21095j = t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<Class<? extends T>> mo63867a() {
        ArrayList arrayList = new ArrayList();
        if (this.f21089d != null) {
            for (RouterMeta next : this.f21088c.values()) {
                if (!next.isDynamic() && m17814a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                    arrayList.add(next.getTargetClass());
                }
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new ServiceComparator());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Class<? extends T> mo63873b() {
        List a = mo63867a();
        if (!a.isEmpty()) {
            return (Class) a.get(0);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<T> mo63868a(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        Class<T> cls = this.f21089d;
        if (cls != null) {
            for (RouterMeta next : RouterStore.getServiceMetas(cls)) {
                if (next.isDynamic() && m17814a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                    arrayList.add(next.getService());
                }
            }
            for (Class a : mo63867a()) {
                Object a2 = m17812a((Class<?>) a, objArr);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public T mo63874b(Object... objArr) {
        if (!TextUtils.isEmpty(this.f21092g)) {
            RouterLogger.getCoreLogger().mo63950d("[..] Get remote service \"%s\" by RemoteBridge", this.f21089d.getSimpleName());
            return RemoteBridge.load(this.f21092g, this.f21093h, this.f21094i).getService(this.f21089d, this.f21090e, this.f21091f, objArr);
        }
        for (RouterMeta next : RouterStore.getServiceMetas(this.f21089d)) {
            if (next.isDynamic() && m17814a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                RouterLogger.getCoreLogger().mo63950d("[..] Get local dynamic service \"%s\" with result \"%s\"", this.f21089d.getSimpleName(), next.getService().getClass().getName());
                return next.getService();
            }
        }
        T a = m17812a((Class<?>) mo63873b(), objArr);
        if (a == null) {
            RouterLogger coreLogger = RouterLogger.getCoreLogger();
            Object[] objArr2 = new Object[2];
            objArr2[0] = this.f21089d.getSimpleName();
            T t = this.f21095j;
            objArr2[1] = t != null ? t.getClass().getName() : null;
            coreLogger.mo63952w("[..] Get local service \"%s\" fail with default instance \"%s\"", objArr2);
            return this.f21095j;
        } else if (this.f21089d != ICallService.class || !CallHandler.isCallService(a)) {
            RouterLogger.getCoreLogger().mo63950d("[..] Get local static service \"%s\" with result \"%s\"", this.f21089d.getSimpleName(), a.getClass().getSimpleName());
            return a;
        } else {
            RouterLogger.getCoreLogger().mo63950d("[..] Get local ICallService service \"%s\" with result \"%s\"", this.f21089d.getSimpleName(), a.getClass().getSimpleName());
            return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f21089d}, new CallHandler(a));
        }
    }

    /* renamed from: a */
    private boolean m17814a(String str, IFeatureMatcher<Object> iFeatureMatcher) {
        return this.f21090e.equals(str) && (iFeatureMatcher == null || iFeatureMatcher.match(this.f21091f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        return r9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m17812a(java.lang.Class<?> r8, java.lang.Object... r9) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0004
            r8 = 0
            return r8
        L_0x0004:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f21086a
            java.lang.Object r0 = r0.get(r8)
            if (r0 != 0) goto L_0x0020
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r1 = f21087b
            boolean r1 = r1.containsKey(r8)
            if (r1 == 0) goto L_0x0020
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f21087b
            java.lang.Object r0 = r0.get(r8)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
        L_0x0020:
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0095
            java.lang.Class<com.didi.drouter.service.ServiceLoader> r3 = com.didi.drouter.service.ServiceLoader.class
            monitor-enter(r3)
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f21086a     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x0043
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r4 = f21087b     // Catch:{ all -> 0x0092 }
            boolean r4 = r4.containsKey(r8)     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0043
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f21087b     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0092 }
        L_0x0043:
            if (r0 != 0) goto L_0x0090
            java.lang.Object r9 = com.didi.drouter.utils.ReflectUtil.getInstance((java.lang.Class<?>) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x0092 }
            if (r9 == 0) goto L_0x008f
            com.didi.drouter.utils.RouterLogger r0 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = "[..] Get service \"%s\" instance by create new"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0092 }
            java.lang.Class r6 = r9.getClass()     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x0092 }
            r5[r1] = r6     // Catch:{ all -> 0x0092 }
            r0.mo63950d(r4, r5)     // Catch:{ all -> 0x0092 }
            java.util.Map<java.lang.Class<?>, com.didi.drouter.store.RouterMeta> r0 = r7.f21088c     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            com.didi.drouter.store.RouterMeta r0 = (com.didi.drouter.store.RouterMeta) r0     // Catch:{ all -> 0x0092 }
            int r0 = r0.getCache()     // Catch:{ all -> 0x0092 }
            r1 = 2
            if (r0 != r1) goto L_0x0075
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f21086a     // Catch:{ all -> 0x0092 }
            r0.put(r8, r9)     // Catch:{ all -> 0x0092 }
            goto L_0x008d
        L_0x0075:
            java.util.Map<java.lang.Class<?>, com.didi.drouter.store.RouterMeta> r0 = r7.f21088c     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            com.didi.drouter.store.RouterMeta r0 = (com.didi.drouter.store.RouterMeta) r0     // Catch:{ all -> 0x0092 }
            int r0 = r0.getCache()     // Catch:{ all -> 0x0092 }
            if (r0 != r2) goto L_0x008d
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f21087b     // Catch:{ all -> 0x0092 }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0092 }
            r1.<init>(r9)     // Catch:{ all -> 0x0092 }
            r0.put(r8, r1)     // Catch:{ all -> 0x0092 }
        L_0x008d:
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            return r9
        L_0x008f:
            r0 = r9
        L_0x0090:
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            goto L_0x0095
        L_0x0092:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            throw r8
        L_0x0095:
            if (r0 == 0) goto L_0x00ac
            com.didi.drouter.utils.RouterLogger r8 = com.didi.drouter.utils.RouterLogger.getCoreLogger()
            java.lang.String r9 = "[..] Get service \"%s\" instance by cache"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2[r1] = r3
            r8.mo63950d(r9, r2)
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.service.ServiceAgent.m17812a(java.lang.Class, java.lang.Object[]):java.lang.Object");
    }

    private static class CallHandler implements InvocationHandler {
        Object callService;

        CallHandler(Object obj) {
            this.callService = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr[0];
            if (objArr2 == null) {
                objArr2 = new Object[]{null};
            }
            Object obj2 = this.callService;
            if ((obj2 instanceof ICallService0) && objArr2.length == 0) {
                return ((ICallService0) obj2).call();
            }
            Object obj3 = this.callService;
            if ((obj3 instanceof ICallService1) && objArr2.length == 1) {
                return ((ICallService1) obj3).call(objArr2[0]);
            }
            Object obj4 = this.callService;
            if ((obj4 instanceof ICallService2) && objArr2.length == 2) {
                return ((ICallService2) obj4).call(objArr2[0], objArr2[1]);
            }
            Object obj5 = this.callService;
            if ((obj5 instanceof ICallService3) && objArr2.length == 3) {
                return ((ICallService3) obj5).call(objArr2[0], objArr2[1], objArr2[2]);
            }
            Object obj6 = this.callService;
            if ((obj6 instanceof ICallService4) && objArr2.length == 4) {
                return ((ICallService4) obj6).call(objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
            }
            Object obj7 = this.callService;
            if ((obj7 instanceof ICallService5) && objArr2.length == 5) {
                return ((ICallService5) obj7).call(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4]);
            }
            Object obj8 = this.callService;
            if (obj8 instanceof ICallServiceN) {
                return ((ICallServiceN) obj8).call(objArr2);
            }
            RouterLogger.getCoreLogger().mo63951e("%s not match with argument length %s ", this.callService.getClass().getSimpleName(), Integer.valueOf(objArr2.length));
            return null;
        }

        static boolean isCallService(Object obj) {
            return (obj instanceof ICallService0) || (obj instanceof ICallService1) || (obj instanceof ICallService2) || (obj instanceof ICallService3) || (obj instanceof ICallService4) || (obj instanceof ICallService5) || (obj instanceof ICallServiceN);
        }
    }

    private class ServiceComparator implements Comparator<Class<?>> {
        private ServiceComparator() {
        }

        public int compare(Class<?> cls, Class<?> cls2) {
            return ((RouterMeta) ServiceAgent.this.f21088c.get(cls2)).getPriority() - ((RouterMeta) ServiceAgent.this.f21088c.get(cls)).getPriority();
        }
    }
}
