package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.cf */
final class C20083cf {

    /* renamed from: a */
    private final ConcurrentHashMap<C20082ce, List<Throwable>> f56105a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f56106b = new ReferenceQueue<>();

    C20083cf() {
    }

    /* renamed from: a */
    public final List<Throwable> mo164324a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f56106b.poll();
            if (poll == null) {
                break;
            }
            this.f56105a.remove(poll);
        }
        List<Throwable> list = this.f56105a.get(new C20082ce(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f56105a.putIfAbsent(new C20082ce(th, this.f56106b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
