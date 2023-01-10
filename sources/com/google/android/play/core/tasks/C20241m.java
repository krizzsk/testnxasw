package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C20046aw;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.m */
final class C20241m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    private final Object f56371a = new Object();

    /* renamed from: b */
    private final C20236h<ResultT> f56372b = new C20236h<>();

    /* renamed from: c */
    private boolean f56373c;

    /* renamed from: d */
    private ResultT f56374d;

    /* renamed from: e */
    private Exception f56375e;

    C20241m() {
    }

    /* renamed from: a */
    private final void m42616a() {
        C20046aw.m42173a(this.f56373c, (Object) "Task is not yet complete");
    }

    /* renamed from: b */
    private final void m42617b() {
        C20046aw.m42173a(!this.f56373c, (Object) "Task is already complete");
    }

    /* renamed from: c */
    private final void m42618c() {
        synchronized (this.f56371a) {
            if (this.f56373c) {
                this.f56372b.mo164551a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo164560a(Exception exc) {
        synchronized (this.f56371a) {
            m42617b();
            this.f56373c = true;
            this.f56375e = exc;
        }
        this.f56372b.mo164551a(this);
    }

    /* renamed from: a */
    public final void mo164561a(ResultT resultt) {
        synchronized (this.f56371a) {
            m42617b();
            this.f56373c = true;
            this.f56374d = resultt;
        }
        this.f56372b.mo164551a(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f56372b.mo164552a(new C20230b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m42618c();
        return this;
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f56372b.mo164552a(new C20230b(executor, onCompleteListener));
        m42618c();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f56372b.mo164552a(new C20232d(executor, onFailureListener));
        m42618c();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f56372b.mo164552a(new C20234f(executor, onSuccessListener));
        m42618c();
        return this;
    }

    /* renamed from: b */
    public final boolean mo164562b(Exception exc) {
        synchronized (this.f56371a) {
            if (this.f56373c) {
                return false;
            }
            this.f56373c = true;
            this.f56375e = exc;
            this.f56372b.mo164551a(this);
            return true;
        }
    }

    /* renamed from: b */
    public final boolean mo164563b(ResultT resultt) {
        synchronized (this.f56371a) {
            if (this.f56373c) {
                return false;
            }
            this.f56373c = true;
            this.f56374d = resultt;
            this.f56372b.mo164551a(this);
            return true;
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f56371a) {
            exc = this.f56375e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f56371a) {
            m42616a();
            Exception exc = this.f56375e;
            if (exc == null) {
                resultt = this.f56374d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.f56371a) {
            m42616a();
            if (!cls.isInstance(this.f56375e)) {
                Exception exc = this.f56375e;
                if (exc == null) {
                    resultt = this.f56374d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.f56375e));
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f56371a) {
            z = this.f56373c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f56371a) {
            z = false;
            if (this.f56373c && this.f56375e == null) {
                z = true;
            }
        }
        return z;
    }
}
