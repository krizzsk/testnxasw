package com.didi.sdk.event;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.sdk.event.b */
/* compiled from: BackgroundPoster */
final class C13007b implements Runnable {

    /* renamed from: a */
    private final C13010e f38620a = new C13010e();

    /* renamed from: b */
    private volatile boolean f38621b;

    /* renamed from: c */
    private final EventDispatcherImpl f38622c;

    C13007b(EventDispatcherImpl eventDispatcherImpl) {
        this.f38622c = eventDispatcherImpl;
    }

    /* renamed from: a */
    public void mo98023a(C13013h hVar, Event event) {
        C13009d a = C13009d.m29133a(hVar, event);
        synchronized (this) {
            this.f38620a.mo98033a(a);
            if (!this.f38621b) {
                this.f38621b = true;
                EventDispatcherImpl.f38605a.execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                C13009d a = this.f38620a.mo98032a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f38620a.mo98031a();
                        if (a == null) {
                            this.f38621b = false;
                            this.f38621b = false;
                            return;
                        }
                    }
                }
                this.f38622c.mo98005a(a);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                try {
                    SystemUtils.log(5, "Event", Thread.currentThread().getName() + " was interruppted", interruptedException, "com.didi.sdk.event.BackgroundPoster", 47);
                    return;
                } finally {
                    this.f38621b = false;
                }
            }
        }
    }
}
