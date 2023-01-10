package com.didi.rfusion.widget.floating;

import android.util.SparseArray;

/* renamed from: com.didi.rfusion.widget.floating.a */
/* compiled from: RFFloatingController */
class C12381a {

    /* renamed from: a */
    private SparseArray<C12382b> f36339a = new SparseArray<>();

    /* renamed from: b */
    private Integer f36340b;

    C12381a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94309a(int i) {
        this.f36340b = Integer.valueOf(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94311b(int i) {
        if (!m27389e(i)) {
            this.f36339a.put(i, new C12382b(true));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94312c(int i) {
        if (m27389e(i)) {
            this.f36339a.remove(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94310a(int i, boolean z) {
        C12382b f = m27390f(i);
        if (f != null) {
            f.f36341a = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo94313d(int i) {
        C12382b f = m27390f(i);
        if (f == null) {
            return false;
        }
        return f.f36341a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer mo94308a() {
        return this.f36340b;
    }

    /* renamed from: e */
    private boolean m27389e(int i) {
        return this.f36339a.indexOfKey(i) >= 0;
    }

    /* renamed from: f */
    private C12382b m27390f(int i) {
        return this.f36339a.get(i);
    }
}
