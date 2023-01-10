package com.didi.map.sdk.nav.inertia;

public class SctxStateInfo {

    /* renamed from: a */
    private SctxStateEnum f30925a;

    /* renamed from: b */
    private boolean f30926b = false;

    public SctxStateEnum getState() {
        return this.f30925a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo83748a(SctxStateEnum sctxStateEnum) {
        this.f30925a = sctxStateEnum;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo83749a(boolean z) {
        this.f30926b = z;
    }

    public boolean isExceptionState() {
        return this.f30926b;
    }

    public String toString() {
        return "SctxStateInfo{state=" + this.f30925a + ", isExceptionState=" + this.f30926b + '}';
    }
}
