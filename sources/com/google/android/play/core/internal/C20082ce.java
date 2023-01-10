package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.ce */
final class C20082ce extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f56104a;

    public C20082ce(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f56104a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            C20082ce ceVar = (C20082ce) obj;
            return this.f56104a == ceVar.f56104a && get() == ceVar.get();
        }
    }

    public final int hashCode() {
        return this.f56104a;
    }
}
