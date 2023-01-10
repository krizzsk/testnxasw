package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cg */
final class C20084cg extends C20081cd {

    /* renamed from: a */
    private final C20083cf f56107a = new C20083cf();

    C20084cg() {
    }

    /* renamed from: a */
    public final void mo164321a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f56107a.mo164324a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
