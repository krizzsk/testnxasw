package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.e */
/* compiled from: PendingPostQueue */
final class C13010e {

    /* renamed from: a */
    private C13009d f38632a;

    /* renamed from: b */
    private C13009d f38633b;

    C13010e() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo98033a(C13009d dVar) {
        if (dVar != null) {
            try {
                if (this.f38633b != null) {
                    this.f38633b.f38631c = dVar;
                    this.f38633b = dVar;
                } else if (this.f38632a == null) {
                    this.f38633b = dVar;
                    this.f38632a = dVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C13009d mo98031a() {
        C13009d dVar;
        dVar = this.f38632a;
        if (this.f38632a != null) {
            C13009d dVar2 = this.f38632a.f38631c;
            this.f38632a = dVar2;
            if (dVar2 == null) {
                this.f38633b = null;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C13009d mo98032a(int i) throws InterruptedException {
        if (this.f38632a == null) {
            wait((long) i);
        }
        return mo98031a();
    }
}
