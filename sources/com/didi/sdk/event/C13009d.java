package com.didi.sdk.event;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.event.d */
/* compiled from: PendingPost */
final class C13009d {

    /* renamed from: d */
    private static final List<C13009d> f38628d = new ArrayList();

    /* renamed from: a */
    Event f38629a;

    /* renamed from: b */
    C13013h f38630b;

    /* renamed from: c */
    C13009d f38631c;

    private C13009d(Event event, C13013h hVar) {
        this.f38629a = event;
        this.f38630b = hVar;
    }

    /* renamed from: a */
    static C13009d m29133a(C13013h hVar, Event event) {
        synchronized (f38628d) {
            int size = f38628d.size();
            if (size <= 0) {
                return new C13009d(event, hVar);
            }
            C13009d remove = f38628d.remove(size - 1);
            remove.f38629a = event;
            remove.f38630b = hVar;
            remove.f38631c = null;
            return remove;
        }
    }

    /* renamed from: a */
    static void m29134a(C13009d dVar) {
        dVar.f38629a = null;
        dVar.f38630b = null;
        dVar.f38631c = null;
        synchronized (f38628d) {
            if (f38628d.size() < 10000) {
                f38628d.add(dVar);
            }
        }
    }
}
