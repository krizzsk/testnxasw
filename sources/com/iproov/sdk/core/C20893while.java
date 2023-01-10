package com.iproov.sdk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.iproov.sdk.core.while */
/* compiled from: PatchDetector */
public class C20893while {

    /* renamed from: a */
    static final Map<C20882import, C20894do> f57188a = new HashMap();

    /* renamed from: com.iproov.sdk.core.while$do */
    /* compiled from: PatchDetector */
    static class C20894do {

        /* renamed from: do */
        private long f57189do;

        /* renamed from: if */
        Boolean f57190if = null;

        public C20894do(C20882import importR) {
        }

        /* renamed from: do */
        public synchronized long mo171517do() {
            return this.f57189do;
        }

        /* renamed from: do */
        public synchronized void mo171518do(long j) {
            this.f57189do = j;
        }
    }

    /* renamed from: com.iproov.sdk.core.while$if */
    /* compiled from: PatchDetector */
    static class C20895if {

        /* renamed from: do */
        public final String f57191do;

        /* renamed from: if */
        public final String f57192if;

        public C20895if(StackTraceElement stackTraceElement) {
            this.f57191do = stackTraceElement.getClassName();
            this.f57192if = stackTraceElement.getMethodName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C20895if.class != obj.getClass()) {
                return false;
            }
            C20895if ifVar = (C20895if) obj;
            if (!Objects.equals(this.f57191do, ifVar.f57191do) || !Objects.equals(this.f57192if, ifVar.f57192if)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f57191do, this.f57192if});
        }

        public String toString() {
            return "M{c='" + this.f57191do + '\'' + ", m='" + this.f57192if + '\'' + '}';
        }
    }

    /* renamed from: do */
    public static void m43453do(C20882import importR) {
        Map<C20882import, C20894do> map = f57188a;
        C20894do doVar = map.get(importR);
        long currentTimeMillis = System.currentTimeMillis();
        if (doVar == null) {
            doVar = new C20894do(importR);
            map.put(importR, doVar);
        } else if (doVar.f57190if == Boolean.FALSE || doVar.mo171517do() > currentTimeMillis) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 5) {
            C20895if ifVar = new C20895if(stackTrace[3]);
            boolean z = true;
            boolean z2 = importR.f57167do.contains(ifVar.f57191do) && !ifVar.equals(new C20895if(stackTrace[4]));
            Boolean bool = doVar.f57190if;
            if (bool == null) {
                z = z2;
            } else if (!bool.booleanValue() || !z2) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            doVar.f57190if = valueOf;
            C20781b.m43064a(importR, valueOf);
        }
        doVar.mo171518do(currentTimeMillis + importR.f57168if);
    }
}
