package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
final class C20233e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f56361a;

    /* renamed from: b */
    final /* synthetic */ C20234f f56362b;

    C20233e(C20234f fVar, Task task) {
        this.f56362b = fVar;
        this.f56361a = task;
    }

    public final void run() {
        synchronized (this.f56362b.f56364b) {
            if (this.f56362b.f56365c != null) {
                this.f56362b.f56365c.onSuccess(this.f56361a.getResult());
            }
        }
    }
}
