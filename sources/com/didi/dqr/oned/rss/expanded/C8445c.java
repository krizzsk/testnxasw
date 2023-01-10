package com.didi.dqr.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.oned.rss.expanded.c */
/* compiled from: ExpandedRow */
final class C8445c {

    /* renamed from: a */
    private final List<C8444b> f20694a;

    /* renamed from: b */
    private final int f20695b;

    /* renamed from: c */
    private final boolean f20696c;

    C8445c(List<C8444b> list, int i, boolean z) {
        this.f20694a = new ArrayList(list);
        this.f20695b = i;
        this.f20696c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C8444b> mo63362a() {
        return this.f20694a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63364b() {
        return this.f20695b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo63365c() {
        return this.f20696c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63363a(List<C8444b> list) {
        return this.f20694a.equals(list);
    }

    public String toString() {
        return "{ " + this.f20694a + " }";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C8445c)) {
            return false;
        }
        C8445c cVar = (C8445c) obj;
        if (!this.f20694a.equals(cVar.mo63362a()) || this.f20696c != cVar.f20696c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f20694a.hashCode() ^ Boolean.valueOf(this.f20696c).hashCode();
    }
}
