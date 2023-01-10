package com.didi.sdk.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.didi.sdk.event.c */
/* compiled from: HandlerPoster */
final class C13008c extends Handler {

    /* renamed from: a */
    private final C13010e f38623a = new C13010e();

    /* renamed from: b */
    private final int f38624b;

    /* renamed from: c */
    private final EventDispatcherImpl f38625c;

    /* renamed from: d */
    private boolean f38626d;

    C13008c(EventDispatcherImpl eventDispatcherImpl, Looper looper, int i) {
        super(looper);
        this.f38625c = eventDispatcherImpl;
        this.f38624b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo98025a(C13013h hVar, Event event) {
        C13009d a = C13009d.m29133a(hVar, event);
        synchronized (this) {
            this.f38623a.mo98033a(a);
            if (!this.f38626d) {
                this.f38626d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new StoreException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C13009d a = this.f38623a.mo98031a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f38623a.mo98031a();
                        if (a == null) {
                            this.f38626d = false;
                            this.f38626d = false;
                            return;
                        }
                    }
                }
                this.f38625c.mo98005a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f38624b));
            if (sendMessage(obtainMessage())) {
                this.f38626d = true;
                return;
            }
            throw new StoreException("Could not send handler message");
        } catch (Throwable th) {
            this.f38626d = false;
            throw th;
        }
    }
}
