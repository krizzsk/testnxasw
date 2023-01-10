package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
final class C20230b<ResultT> implements C20235g<ResultT> {

    /* renamed from: a */
    private final Executor f56353a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f56354b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f56355c;

    public C20230b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f56353a = executor;
        this.f56355c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo164548a(Task<ResultT> task) {
        synchronized (this.f56354b) {
            if (this.f56355c != null) {
                this.f56353a.execute(new C20229a(this, task));
            }
        }
    }
}
