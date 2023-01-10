package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.a */
/* compiled from: AsyncPoster */
class C13006a implements Runnable {

    /* renamed from: a */
    private final C13010e f38618a = new C13010e();

    /* renamed from: b */
    private final EventDispatcherImpl f38619b;

    C13006a(EventDispatcherImpl eventDispatcherImpl) {
        this.f38619b = eventDispatcherImpl;
    }

    /* renamed from: a */
    public void mo98021a(C13013h hVar, Event event) {
        this.f38618a.mo98033a(C13009d.m29133a(hVar, event));
        EventDispatcherImpl.f38605a.execute(this);
    }

    public void run() {
        C13009d a = this.f38618a.mo98031a();
        if (a != null) {
            this.f38619b.mo98005a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
