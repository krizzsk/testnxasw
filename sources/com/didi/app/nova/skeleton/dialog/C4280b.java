package com.didi.app.nova.skeleton.dialog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.app.nova.skeleton.dialog.b */
/* compiled from: Stack */
final class C4280b implements Iterable<C4279a> {

    /* renamed from: a */
    private final Deque<C4279a> f10276a = new ArrayDeque();

    C4280b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo45804a() {
        return this.f10276a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo45805b() {
        return this.f10276a.size();
    }

    public Iterator<C4279a> iterator() {
        return this.f10276a.iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C4279a mo45807c() {
        return this.f10276a.peek();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C4279a mo45809d() {
        return this.f10276a.pop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45803a(C4279a aVar) {
        this.f10276a.removeFirstOccurrence(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45806b(C4279a aVar) {
        this.f10276a.push(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo45808c(C4279a aVar) {
        return this.f10276a.contains(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public List<C4279a> mo45810e() {
        ArrayList arrayList = new ArrayList();
        while (!mo45804a()) {
            arrayList.add(mo45809d());
        }
        return arrayList;
    }
}
