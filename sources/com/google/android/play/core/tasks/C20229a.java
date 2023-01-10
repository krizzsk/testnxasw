package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
final class C20229a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f56351a;

    /* renamed from: b */
    final /* synthetic */ C20230b f56352b;

    C20229a(C20230b bVar, Task task) {
        this.f56352b = bVar;
        this.f56351a = task;
    }

    public final void run() {
        synchronized (this.f56352b.f56354b) {
            if (this.f56352b.f56355c != null) {
                this.f56352b.f56355c.onComplete(this.f56351a);
            }
        }
    }
}
