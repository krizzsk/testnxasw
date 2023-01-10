package com.didi.sdk.event;

import java.lang.reflect.Method;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.sdk.event.f */
/* compiled from: SubscriberMethod */
final class C13011f {

    /* renamed from: a */
    final Method f38634a;

    /* renamed from: b */
    final ThreadMode f38635b;

    /* renamed from: c */
    final Class<?> f38636c;

    /* renamed from: d */
    String f38637d;

    C13011f(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f38634a = method;
        this.f38635b = threadMode;
        this.f38636c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C13011f)) {
            return false;
        }
        m29138a();
        C13011f fVar = (C13011f) obj;
        fVar.m29138a();
        return this.f38637d.equals(fVar.f38637d);
    }

    /* renamed from: a */
    private synchronized void m29138a() {
        if (this.f38637d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f38634a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f38634a.getName());
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(this.f38636c.getName());
            this.f38637d = sb.toString();
        }
    }

    public int hashCode() {
        return this.f38634a.hashCode();
    }
}
