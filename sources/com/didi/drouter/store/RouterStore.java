package com.didi.drouter.store;

import android.net.Uri;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterLogger;
import com.didi.sdk.service.ForegroundService;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class RouterStore {
    public static final String HOST = "host";

    /* renamed from: a */
    static final String f21128a = "RegexRouter";

    /* renamed from: b */
    private static final Map<String, Object> f21129b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final Map<Class<? extends IRouterInterceptor>, RouterMeta> f21130c = new ArrayMap();

    /* renamed from: d */
    private static final Map<Class<?>, Set<RouterMeta>> f21131d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final Set<String> f21132e = new CopyOnWriteArraySet();

    /* renamed from: f */
    private static final CountDownLatch f21133f = new CountDownLatch(1);

    /* renamed from: g */
    private static volatile boolean f21134g;

    public static void load(String str) {
        if (!f21132e.contains(str)) {
            synchronized (RouterStore.class) {
                if (!f21132e.contains(str)) {
                    f21132e.add(str);
                    RouterLogger.getCoreLogger().mo63950d("[===DRouter load start in %s===]", Thread.currentThread().getName());
                    long currentTimeMillis = System.currentTimeMillis();
                    m17827a("Router", f21129b, str);
                    m17827a("Interceptor", f21130c, str);
                    m17827a(ForegroundService.NOTIFICATION_CHANNEL_GROUP_NAME, f21131d, str);
                    RouterLogger.getCoreLogger().mo63950d("[===DRouter load complete=== waste time: %sms]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if ("host".equals(str)) {
                        Statistics.m17828a();
                        f21134g = true;
                        f21133f.countDown();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m17827a(String str, Map<?, ?> map, String str2) {
        try {
            MetaLoader metaLoader = (MetaLoader) ReflectUtil.getInstance(Class.forName(String.format("com.didi.drouter.loader.%s.%sLoader", new Object[]{str2, str})), new Object[0]);
            if (metaLoader != null) {
                metaLoader.load(map);
                RouterLogger.getCoreLogger().mo63950d("%sLoader in %s load success", str, str2);
            }
        } catch (ClassNotFoundException unused) {
            RouterLogger.getCoreLogger().mo63951e("%sLoader in %s not found", str, str2);
        }
    }

    public static Set<RouterMeta> getRouterMetas(Uri uri) {
        m17825a();
        ArraySet arraySet = new ArraySet();
        Object obj = f21129b.get(uri.toString());
        if (obj instanceof RouterMeta) {
            arraySet.add((RouterMeta) obj);
        }
        Map map = (Map) f21129b.get(f21128a);
        if (map != null) {
            for (RouterMeta routerMeta : map.values()) {
                if (routerMeta.isRegexMatch(uri)) {
                    arraySet.add(routerMeta);
                }
            }
        }
        return arraySet;
    }

    public static Map<Class<? extends IRouterInterceptor>, RouterMeta> getInterceptors() {
        m17825a();
        return f21130c;
    }

    public static Set<RouterMeta> getServiceMetas(Class<?> cls) {
        m17825a();
        Set<RouterMeta> set = f21131d.get(cls);
        return set == null ? Collections.emptySet() : set;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6 A[SYNTHETIC, Splitter:B:25:0x00b6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.didi.drouter.store.IRegister register(final com.didi.drouter.store.RouterKey r11, final com.didi.drouter.router.IRouterHandler r12) {
        /*
            java.lang.Class<com.didi.drouter.store.RouterStore> r0 = com.didi.drouter.store.RouterStore.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x00bd
            if (r12 == 0) goto L_0x00bd
            m17825a()     // Catch:{ all -> 0x00c5 }
            int r1 = com.didi.drouter.store.RouterMeta.HANDLER     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterMeta r2 = com.didi.drouter.store.RouterMeta.build(r1)     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r1.getScheme()     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r1.getHost()     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getPath()     // Catch:{ all -> 0x00c5 }
            r1 = 0
            r6 = r1
            java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x00c5 }
            java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[] r7 = r11.f21098b     // Catch:{ all -> 0x00c5 }
            int r8 = r11.f21099c     // Catch:{ all -> 0x00c5 }
            r9 = 0
            boolean r10 = r11.f21100d     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterMeta r1 = r2.assembleRouter((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.Class<?>) r6, (java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[]) r7, (int) r8, (int) r9, (boolean) r10)     // Catch:{ all -> 0x00c5 }
            r1.setHandler(r11, r12)     // Catch:{ all -> 0x00c5 }
            boolean r2 = r1.isRegexUri()     // Catch:{ all -> 0x00c5 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0066
            java.util.Map<java.lang.String, java.lang.Object> r2 = f21129b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "RegexRouter"
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x00c5 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x00c5 }
            if (r2 != 0) goto L_0x0054
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x00c5 }
            r2.<init>()     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = f21129b     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "RegexRouter"
            r5.put(r6, r2)     // Catch:{ all -> 0x00c5 }
        L_0x0054:
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            boolean r5 = r2.containsKey(r5)     // Catch:{ all -> 0x00c5 }
            if (r5 != 0) goto L_0x007d
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r2.put(r5, r1)     // Catch:{ all -> 0x00c5 }
            goto L_0x007b
        L_0x0066:
            java.util.Map<java.lang.String, java.lang.Object> r2 = f21129b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            boolean r2 = r2.containsKey(r5)     // Catch:{ all -> 0x00c5 }
            if (r2 != 0) goto L_0x007d
            java.util.Map<java.lang.String, java.lang.Object> r2 = f21129b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r2.put(r5, r1)     // Catch:{ all -> 0x00c5 }
        L_0x007b:
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            if (r2 == 0) goto L_0x00b6
            androidx.lifecycle.LifecycleOwner r2 = r11.f21101e     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x0092
            androidx.lifecycle.LifecycleOwner r2 = r11.f21101e     // Catch:{ all -> 0x00c5 }
            androidx.lifecycle.Lifecycle r2 = r2.getLifecycle()     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterStore$1 r5 = new com.didi.drouter.store.RouterStore$1     // Catch:{ all -> 0x00c5 }
            r5.<init>(r11, r12)     // Catch:{ all -> 0x00c5 }
            r2.addObserver(r5)     // Catch:{ all -> 0x00c5 }
        L_0x0092:
            com.didi.drouter.utils.RouterLogger r2 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "register \"%s\" with handler \"%s\" success"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r6[r3] = r1     // Catch:{ all -> 0x00c5 }
            java.lang.Class r1 = r12.getClass()     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x00c5 }
            r6[r4] = r1     // Catch:{ all -> 0x00c5 }
            r2.mo63950d(r5, r6)     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterRegister r1 = new com.didi.drouter.store.RouterRegister     // Catch:{ all -> 0x00c5 }
            r1.<init>((com.didi.drouter.store.RouterKey) r11, (com.didi.drouter.router.IRouterHandler) r12, (boolean) r4)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)
            return r1
        L_0x00b6:
            com.didi.drouter.store.RouterRegister r1 = new com.didi.drouter.store.RouterRegister     // Catch:{ all -> 0x00c5 }
            r1.<init>((com.didi.drouter.store.RouterKey) r11, (com.didi.drouter.router.IRouterHandler) r12, (boolean) r3)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)
            return r1
        L_0x00bd:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c5 }
            java.lang.String r12 = "argument null illegal error"
            r11.<init>(r12)     // Catch:{ all -> 0x00c5 }
            throw r11     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.store.RouterStore.register(com.didi.drouter.store.RouterKey, com.didi.drouter.router.IRouterHandler):com.didi.drouter.store.IRegister");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r1.remove(r11.getLegalUri()) != null) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m17826a(com.didi.drouter.store.RouterKey r11, com.didi.drouter.router.IRouterHandler r12) {
        /*
            java.lang.Class<com.didi.drouter.store.RouterStore> r0 = com.didi.drouter.store.RouterStore.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x0080
            if (r12 == 0) goto L_0x0080
            int r1 = com.didi.drouter.store.RouterMeta.HANDLER     // Catch:{ all -> 0x007d }
            com.didi.drouter.store.RouterMeta r2 = com.didi.drouter.store.RouterMeta.build(r1)     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r1.getScheme()     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r1.getHost()     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f21097a     // Catch:{ all -> 0x007d }
            java.lang.String r5 = r1.getPath()     // Catch:{ all -> 0x007d }
            r1 = 0
            r6 = r1
            java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x007d }
            java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[] r7 = r11.f21098b     // Catch:{ all -> 0x007d }
            int r8 = r11.f21099c     // Catch:{ all -> 0x007d }
            r9 = 0
            boolean r10 = r11.f21100d     // Catch:{ all -> 0x007d }
            com.didi.drouter.store.RouterMeta r11 = r2.assembleRouter((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.Class<?>) r6, (java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[]) r7, (int) r8, (int) r9, (boolean) r10)     // Catch:{ all -> 0x007d }
            boolean r1 = r11.isRegexUri()     // Catch:{ all -> 0x007d }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0050
            java.util.Map<java.lang.String, java.lang.Object> r1 = f21129b     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "RegexRouter"
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x007d }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
            java.lang.String r4 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
        L_0x004c:
            r1 = 1
            goto L_0x005d
        L_0x004e:
            r1 = 0
            goto L_0x005d
        L_0x0050:
            java.util.Map<java.lang.String, java.lang.Object> r1 = f21129b     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
            goto L_0x004c
        L_0x005d:
            if (r1 == 0) goto L_0x0080
            com.didi.drouter.utils.RouterLogger r1 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "unregister \"%s\" with handler \"%s\" success"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x007d }
            java.lang.String r11 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            r5[r3] = r11     // Catch:{ all -> 0x007d }
            java.lang.Class r11 = r12.getClass()     // Catch:{ all -> 0x007d }
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x007d }
            r5[r2] = r11     // Catch:{ all -> 0x007d }
            r1.mo63950d(r4, r5)     // Catch:{ all -> 0x007d }
            goto L_0x0080
        L_0x007d:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        L_0x0080:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.store.RouterStore.m17826a(com.didi.drouter.store.RouterKey, com.didi.drouter.router.IRouterHandler):void");
    }

    public static synchronized <T> IRegister register(final ServiceKey<T> serviceKey, final T t) {
        RouterRegister routerRegister;
        synchronized (RouterStore.class) {
            if (serviceKey != null) {
                if (!(serviceKey.f21135a == null || t == null)) {
                    RouterMeta assembleService = RouterMeta.build(RouterMeta.SERVICE).assembleService((Class<?>) null, serviceKey.f21136b, serviceKey.f21137c, 0, 0);
                    assembleService.setService(serviceKey, t);
                    serviceKey.f21139e = assembleService;
                    Set set = f21131d.get(serviceKey.f21135a);
                    if (set == null) {
                        set = Collections.newSetFromMap(new ConcurrentHashMap());
                        f21131d.put(serviceKey.f21135a, set);
                    }
                    set.add(assembleService);
                    if (serviceKey.f21138d != null) {
                        serviceKey.f21138d.getLifecycle().addObserver(new LifecycleObserver() {
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            public void onDestroy(LifecycleOwner lifecycleOwner) {
                                RouterStore.unregister(serviceKey, t);
                            }
                        });
                    }
                    RouterLogger.getCoreLogger().mo63950d("register \"%s\" with service \"%s\" success, size:%s", serviceKey.f21135a.getSimpleName(), t, Integer.valueOf(set.size()));
                    routerRegister = new RouterRegister((ServiceKey<?>) serviceKey, (Object) t, true);
                }
            }
            throw new IllegalArgumentException("argument null illegal error");
        }
        return routerRegister;
    }

    public static synchronized void unregister(ServiceKey<?> serviceKey, Object obj) {
        synchronized (RouterStore.class) {
            if (!(serviceKey == null || obj == null)) {
                Set set = f21131d.get(serviceKey.f21135a);
                if (set != null && set.remove(serviceKey.f21139e)) {
                    RouterLogger.getCoreLogger().mo63950d("unregister \"%s\" with service \"%s\" success", serviceKey.f21135a.getSimpleName(), obj);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m17825a() {
        if (!f21134g) {
            load("host");
            try {
                f21133f.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
