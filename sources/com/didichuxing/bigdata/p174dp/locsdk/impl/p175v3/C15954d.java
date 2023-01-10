package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.d */
/* compiled from: LocBizWraper */
class C15954d<T> {

    /* renamed from: a */
    private List<C15955e<T>> f48593a = new CopyOnWriteArrayList();

    C15954d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121180a(C15955e eVar) {
        if (!this.f48593a.contains(eVar)) {
            this.f48593a.add(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo121181b(C15955e eVar) {
        if (this.f48593a.contains(eVar)) {
            this.f48593a.remove(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public T mo121179a(T t) {
        for (C15955e next : this.f48593a) {
            if (t == null) {
                break;
            }
            t = next.intercept(t);
        }
        return t;
    }
}
