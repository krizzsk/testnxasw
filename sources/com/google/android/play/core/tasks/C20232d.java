package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
final class C20232d<ResultT> implements C20235g<ResultT> {

    /* renamed from: a */
    private final Executor f56358a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f56359b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnFailureListener f56360c;

    public C20232d(Executor executor, OnFailureListener onFailureListener) {
        this.f56358a = executor;
        this.f56360c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo164548a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f56359b) {
                if (this.f56360c != null) {
                    this.f56358a.execute(new C20231c(this, task));
                }
            }
        }
    }
}
