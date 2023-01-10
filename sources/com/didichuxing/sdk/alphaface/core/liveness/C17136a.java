package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.a */
/* compiled from: AbsDetect */
abstract class C17136a<Out> {

    /* renamed from: a */
    protected final AlphaFaceNativeProxy f51281a;

    /* renamed from: b */
    protected final C17138c f51282b;

    /* renamed from: c */
    protected final LivenessConfig f51283c;

    /* renamed from: d */
    protected final LivenessManager f51284d;

    /* renamed from: e */
    protected C17136a f51285e;

    /* renamed from: a */
    public abstract Out mo127155a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo127158b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3);

    /* renamed from: b */
    public abstract boolean mo127159b();

    /* renamed from: c */
    public abstract void mo127160c();

    public C17136a(LivenessManager livenessManager) {
        this.f51284d = livenessManager;
        this.f51281a = livenessManager.mo127138a();
        this.f51283c = livenessManager.mo127139b();
        this.f51282b = livenessManager.mo127140c();
    }

    /* renamed from: a */
    public void mo127156a(C17136a aVar) {
        this.f51285e = aVar;
    }

    /* renamed from: a */
    public final void mo127157a(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        if (mo127159b()) {
            C17136a aVar = this.f51285e;
            if (aVar != null) {
                aVar.mo127158b(bArr, i, i2, i3, f, f2, f3);
                return;
            }
        }
        mo127158b(bArr, i, i2, i3, f, f2, f3);
    }

    /* renamed from: d */
    public void mo127161d() {
        for (C17136a aVar = this; aVar != null; aVar = aVar.f51285e) {
            aVar.mo127160c();
        }
    }
}
