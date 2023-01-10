package com.didi.aoe.library.core;

import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.core.p100io.AoeParcelImpl;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import com.didi.aoe.library.modeloption.loader.impl.LocalOnlyModelOptionLoader;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.aoe.library.core.c */
/* compiled from: ComponentProvider */
final class C4157c {

    /* renamed from: a */
    private static final Logger f10021a = LoggerFactory.getLogger("ComponentProvider");

    /* renamed from: b */
    private static final Map<String, AoeProcessor.ModelOptionLoaderComponent> f10022b = new HashMap();

    /* renamed from: c */
    private static final Map<String, AoeProcessor.InterpreterComponent> f10023c = new HashMap();

    /* renamed from: d */
    private static final Map<String, AoeProcessor.ParcelComponent> f10024d = new HashMap();

    private C4157c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized <T> void m8698a(java.lang.String r3, java.lang.Class<T> r4, java.util.Map<java.lang.String, T> r5) {
        /*
            java.lang.Class<com.didi.aoe.library.core.c> r0 = com.didi.aoe.library.core.C4157c.class
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0055
            boolean r1 = r5.containsKey(r3)     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0055
        L_0x000c:
            java.lang.Class r1 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x0048 }
            java.lang.Class r2 = r1.getClass()     // Catch:{ Exception -> 0x0048 }
            boolean r2 = r4.isAssignableFrom(r2)     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x0022
            r5.put(r3, r1)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0050
        L_0x0022:
            com.didi.aoe.library.lang.AoeRuntimeException r3 = new com.didi.aoe.library.lang.AoeRuntimeException     // Catch:{ Exception -> 0x0048 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r5.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0048 }
            r5.append(r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = " you registered is not an instance of "
            r5.append(r1)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0048 }
            r5.append(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0048 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0048 }
            throw r3     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r3 = move-exception
            com.didi.aoe.library.logging.Logger r4 = f10021a     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = "release error"
            r4.error((java.lang.String) r5, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r0)
            return
        L_0x0052:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x0055:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.library.core.C4157c.m8698a(java.lang.String, java.lang.Class, java.util.Map):void");
    }

    /* renamed from: a */
    public static AoeProcessor.ModelOptionLoaderComponent m8697a(String str) {
        m8698a(str, AoeProcessor.ModelOptionLoaderComponent.class, f10022b);
        AoeProcessor.ModelOptionLoaderComponent modelOptionLoaderComponent = f10022b.get(str);
        return modelOptionLoaderComponent == null ? new LocalOnlyModelOptionLoader() : modelOptionLoaderComponent;
    }

    /* renamed from: b */
    public static AoeProcessor.InterpreterComponent m8699b(String str) {
        m8698a(str, AoeProcessor.InterpreterComponent.class, f10023c);
        return f10023c.get(str);
    }

    /* renamed from: c */
    public static AoeProcessor.ParcelComponent m8700c(String str) {
        m8698a(str, AoeProcessor.ParcelComponent.class, f10024d);
        AoeProcessor.ParcelComponent parcelComponent = f10024d.get(str);
        return parcelComponent == null ? new AoeParcelImpl() : parcelComponent;
    }
}
