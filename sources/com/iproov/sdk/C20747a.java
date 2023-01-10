package com.iproov.sdk;

import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import p071new.C2974case;
import p071new.C2975do;
import p071new.C2976else;
import p071new.C2977for;
import p071new.C2978goto;
import p071new.C2979if;
import p071new.C2980new;
import p071new.C2981try;
import p095switch.C3679throw;

/* renamed from: com.iproov.sdk.a */
/* compiled from: ListenerDelegate */
class C20747a implements IProov.Listener {

    /* renamed from: a */
    private C2974case f56840a;

    /* renamed from: b */
    private Set<IProov.Listener> f56841b = Collections.newSetFromMap(new WeakHashMap());

    C20747a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo171267a(IProov.Listener listener) {
        this.f56841b.remove(listener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo171270a() {
        return !this.f56841b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo171271b() {
        this.f56840a = null;
    }

    public void onCancelled() {
        m42839b((C2974case) new C2975do());
    }

    public void onConnected() {
        m42839b((C2974case) new C2979if());
    }

    public void onConnecting() {
        m42839b((C2974case) new C2977for());
    }

    public void onError(IProovException iProovException) {
        m42839b((C2974case) new C2980new(iProovException));
    }

    public void onFailure(IProov.FailureResult failureResult) {
        m42839b((C2974case) new C2981try(failureResult));
    }

    public void onProcessing(double d, String str) {
        m42839b((C2974case) new C2976else(d, str));
    }

    public void onSuccess(IProov.SuccessResult successResult) {
        m42839b((C2974case) new C2978goto(successResult));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo171268a(IProov.Listener listener, boolean z) {
        this.f56841b.add(listener);
        if (z) {
            mo171272b(listener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo171272b(IProov.Listener listener) {
        if (listener != null) {
            C3679throw.m7442do((Runnable) new Runnable(listener) {
                public final /* synthetic */ IProov.Listener f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20747a.this.m42840c(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo171269a(C2974case caseR) {
        this.f56840a = caseR;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m42840c(IProov.Listener listener) {
        synchronized (this) {
            C2974case caseR = this.f56840a;
            if (caseR != null) {
                caseR.mo29847do(listener);
            }
        }
    }

    /* renamed from: b */
    private void m42839b(C2974case caseR) {
        mo171269a(caseR);
        synchronized (this) {
            for (IProov.Listener r1 : this.f56841b) {
                C3679throw.m7442do((Runnable) new Runnable(r1) {
                    public final /* synthetic */ IProov.Listener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        C2974case.this.mo29847do(this.f$1);
                    }
                });
            }
        }
        if (caseR.mo29848do()) {
            IProov.f56831a.set(false);
            IProov.f56832b = null;
        }
    }
}
