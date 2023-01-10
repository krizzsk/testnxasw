package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.view.RenderTask;

public final class SetTransaction extends RenderTask {

    /* renamed from: a */
    static final /* synthetic */ boolean f26244a = (!SetTransaction.class.desiredAssertionStatus());

    /* renamed from: b */
    private final GLViewParent f26245b;

    /* renamed from: c */
    private SetTransaction f26246c;

    /* renamed from: d */
    private SetTransaction f26247d;

    /* renamed from: e */
    private SetTransaction f26248e = this;

    /* renamed from: f */
    private Runnable f26249f;

    /* renamed from: g */
    private boolean f26250g = false;

    /* renamed from: h */
    private final Thread f26251h;

    SetTransaction(Runnable runnable, GLViewParent gLViewParent) {
        this.f26249f = runnable;
        this.f26245b = gLViewParent;
        this.f26251h = Thread.currentThread();
    }

    public void chain(Runnable runnable) {
        m20741a();
        if (this.f26249f == null) {
            this.f26249f = runnable;
            return;
        }
        this.f26248e.f26246c = new SetTransaction(runnable, this.f26245b);
        SetTransaction setTransaction = this.f26248e.f26246c;
        setTransaction.f26247d = this;
        this.f26248e = setTransaction;
    }

    public boolean commit() {
        m20741a();
        if (this.f26250g) {
            return false;
        }
        this.f26250g = true;
        return this.f26245b.postToRenderThread((RenderTask) this);
    }

    public void run() {
        Runnable runnable = this.f26249f;
        if (runnable != null) {
            runnable.run();
        }
        SetTransaction setTransaction = this.f26246c;
        if (setTransaction != null) {
            setTransaction.run();
        }
    }

    /* renamed from: a */
    private void m20741a() {
        if (Thread.currentThread() != this.f26251h) {
            throw new IllegalStateException("All setTransaction must be in the same thread");
        }
    }

    public String toString() {
        m20741a();
        SetTransaction setTransaction = this;
        while (true) {
            SetTransaction setTransaction2 = setTransaction.f26247d;
            if (setTransaction2 == null) {
                break;
            }
            setTransaction = setTransaction2;
        }
        StringBuilder sb = new StringBuilder();
        while (setTransaction.f26246c != null) {
            sb.append(setTransaction.m20742b());
            sb.append(" -> ");
            setTransaction = setTransaction.f26246c;
            if (!f26244a && setTransaction == null) {
                throw new AssertionError();
            }
        }
        sb.append(setTransaction.m20742b());
        return sb.toString();
    }

    /* renamed from: b */
    private String m20742b() {
        return super.toString();
    }
}
