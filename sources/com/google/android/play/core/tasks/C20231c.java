package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
final class C20231c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f56356a;

    /* renamed from: b */
    final /* synthetic */ C20232d f56357b;

    C20231c(C20232d dVar, Task task) {
        this.f56357b = dVar;
        this.f56356a = task;
    }

    public final void run() {
        synchronized (this.f56357b.f56359b) {
            if (this.f56357b.f56360c != null) {
                this.f56357b.f56360c.onFailure(this.f56356a.getException());
            }
        }
    }
}
