package com.didichuxing.sofa.permission;

import com.didichuxing.sofa.permission.PermissionResultCallback;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didichuxing.sofa.permission.d */
/* compiled from: PermHelperRegistry */
class C17282d {

    /* renamed from: a */
    private static final Map<String, Class<? extends C17281c>> f51718a = new HashMap();

    /* renamed from: b */
    private static final Map<String, C17281c> f51719b = new HashMap();

    C17282d() {
    }

    /* renamed from: a */
    static synchronized void m38880a(String str, Class<? extends C17281c> cls) {
        synchronized (C17282d.class) {
            f51718a.put(str, cls);
        }
    }

    /* renamed from: a */
    static synchronized C17281c m38879a(String str) {
        synchronized (C17282d.class) {
            C17281c cVar = f51719b.get(str);
            if (cVar == null) {
                Class cls = f51718a.get(str);
                if (cls == null) {
                    return null;
                }
                try {
                    C17281c cVar2 = (C17281c) cls.newInstance();
                    try {
                        f51719b.put(str, cVar2);
                        cVar = cVar2;
                    } catch (Exception e) {
                        e = e;
                        cVar = cVar2;
                        e.printStackTrace();
                        return cVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return cVar;
                }
            }
        }
    }

    /* renamed from: a */
    static synchronized C17281c m38878a() {
        C17281c cVar;
        synchronized (C17282d.class) {
            String canonicalName = PermissionResultCallback.class.getCanonicalName();
            cVar = f51719b.get(canonicalName);
            if (cVar == null) {
                cVar = new PermissionResultCallback.PermissionHelper();
                f51719b.put(canonicalName, cVar);
            }
        }
        return cVar;
    }
}
