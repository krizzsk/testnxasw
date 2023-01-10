package com.didi.dqr.oned.rss.expanded.decoders;

final class CurrentParsingState {

    /* renamed from: a */
    private int f20699a = 0;

    /* renamed from: b */
    private State f20700b = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63372a() {
        return this.f20699a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63373a(int i) {
        this.f20699a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63374b(int i) {
        this.f20699a += i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo63375b() {
        return this.f20700b == State.ALPHA;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo63376c() {
        return this.f20700b == State.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo63377d() {
        return this.f20700b == State.ISO_IEC_646;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo63378e() {
        this.f20700b = State.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo63379f() {
        this.f20700b = State.ALPHA;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo63380g() {
        this.f20700b = State.ISO_IEC_646;
    }
}
