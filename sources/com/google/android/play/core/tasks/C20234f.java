package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
final class C20234f<ResultT> implements C20235g<ResultT> {

    /* renamed from: a */
    private final Executor f56363a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f56364b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f56365c;

    public C20234f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f56363a = executor;
        this.f56365c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo164548a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f56364b) {
                if (this.f56365c != null) {
                    this.f56363a.execute(new C20233e(this, task));
                }
            }
        }
    }
}
