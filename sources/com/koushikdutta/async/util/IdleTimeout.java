package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;

public class IdleTimeout extends TimeoutBase {

    /* renamed from: a */
    Runnable f58313a;

    /* renamed from: b */
    Object f58314b;

    public IdleTimeout(AsyncServer asyncServer, long j) {
        super(asyncServer, j);
    }

    public IdleTimeout(Handler handler, long j) {
        super(handler, j);
    }

    public void setTimeout(Runnable runnable) {
        this.f58313a = runnable;
    }

    public void reset() {
        this.handlerish.removeAllCallbacks(this.f58314b);
        this.f58314b = this.handlerish.postDelayed(this.f58313a, this.delay);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m44200a() {
        this.handlerish.removeAllCallbacks(this.f58314b);
    }

    public void cancel() {
        this.handlerish.post(new Runnable() {
            public final void run() {
                IdleTimeout.this.m44200a();
            }
        });
    }
}
