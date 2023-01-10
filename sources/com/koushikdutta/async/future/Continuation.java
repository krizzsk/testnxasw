package com.koushikdutta.async.future;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import java.util.LinkedList;

public class Continuation extends SimpleCancellable implements ContinuationCallback, Cancellable, Runnable {

    /* renamed from: a */
    CompletedCallback f58093a;

    /* renamed from: b */
    Runnable f58094b;

    /* renamed from: c */
    LinkedList<ContinuationCallback> f58095c;

    /* renamed from: d */
    boolean f58096d;

    /* renamed from: e */
    private boolean f58097e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f58098f;

    public CompletedCallback getCallback() {
        return this.f58093a;
    }

    public void setCallback(CompletedCallback completedCallback) {
        this.f58093a = completedCallback;
    }

    public Runnable getCancelCallback() {
        return this.f58094b;
    }

    public void setCancelCallback(Runnable runnable) {
        this.f58094b = runnable;
    }

    public void setCancelCallback(final Cancellable cancellable) {
        if (cancellable == null) {
            this.f58094b = null;
        } else {
            this.f58094b = new Runnable() {
                public void run() {
                    cancellable.cancel();
                }
            };
        }
    }

    public Continuation() {
        this((CompletedCallback) null);
    }

    public Continuation(CompletedCallback completedCallback) {
        this(completedCallback, (Runnable) null);
    }

    public Continuation(CompletedCallback completedCallback, Runnable runnable) {
        this.f58095c = new LinkedList<>();
        this.f58094b = runnable;
        this.f58093a = completedCallback;
    }

    /* renamed from: a */
    private CompletedCallback m43982a() {
        return new CompletedCallback() {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            boolean mThisCompleted;

            static {
                Class<Continuation> cls = Continuation.class;
            }

            public void onCompleted(Exception exc) {
                if (!this.mThisCompleted) {
                    this.mThisCompleted = true;
                    boolean unused = Continuation.this.f58098f = false;
                    if (exc == null) {
                        Continuation.this.m43986b();
                    } else {
                        Continuation.this.mo173269a(exc);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173269a(Exception exc) {
        CompletedCallback completedCallback;
        if (setComplete() && (completedCallback = this.f58093a) != null) {
            completedCallback.onCompleted(exc);
        }
    }

    /* renamed from: a */
    private ContinuationCallback m43983a(ContinuationCallback continuationCallback) {
        if (continuationCallback instanceof DependentCancellable) {
            ((DependentCancellable) continuationCallback).setParent(this);
        }
        return continuationCallback;
    }

    public Continuation add(ContinuationCallback continuationCallback) {
        this.f58095c.add(m43983a(continuationCallback));
        return this;
    }

    public Continuation insert(ContinuationCallback continuationCallback) {
        this.f58095c.add(0, m43983a(continuationCallback));
        return this;
    }

    public Continuation add(final DependentFuture dependentFuture) {
        dependentFuture.setParent(this);
        add((ContinuationCallback) new ContinuationCallback() {
            public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
                dependentFuture.get();
                completedCallback.onCompleted((Exception) null);
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m43986b() {
        if (!this.f58097e) {
            while (this.f58095c.size() > 0 && !this.f58098f && !isDone() && !isCancelled()) {
                ContinuationCallback remove = this.f58095c.remove();
                try {
                    this.f58097e = true;
                    this.f58098f = true;
                    remove.onContinue(this, m43982a());
                } catch (Exception e) {
                    mo173269a(e);
                } catch (Throwable th) {
                    this.f58097e = false;
                    throw th;
                }
                this.f58097e = false;
            }
            if (!this.f58098f && !isDone() && !isCancelled()) {
                mo173269a((Exception) null);
            }
        }
    }

    public boolean cancel() {
        if (!super.cancel()) {
            return false;
        }
        Runnable runnable = this.f58094b;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public Continuation start() {
        if (!this.f58096d) {
            this.f58096d = true;
            m43986b();
            return this;
        }
        throw new IllegalStateException("already started");
    }

    public void onContinue(Continuation continuation, CompletedCallback completedCallback) throws Exception {
        setCallback(completedCallback);
        start();
    }

    public void run() {
        start();
    }
}
