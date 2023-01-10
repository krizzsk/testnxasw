package com.didichuxing.mlcp.drtc.interfaces;

import java.util.Vector;

/* renamed from: com.didichuxing.mlcp.drtc.interfaces.e */
/* compiled from: ListenerList */
public class C16690e {

    /* renamed from: a */
    private final Vector<C16688c> f50892a = new Vector<>();

    /* renamed from: a */
    public int mo125459a(C16688c cVar) {
        int size;
        synchronized (this.f50892a) {
            if (cVar != null) {
                if (!this.f50892a.contains(cVar)) {
                    this.f50892a.add(cVar);
                }
            }
            size = this.f50892a.size();
        }
        return size;
    }

    /* renamed from: b */
    public int mo125461b(C16688c cVar) {
        int size;
        synchronized (this.f50892a) {
            if (cVar != null) {
                this.f50892a.remove(cVar);
            }
            size = this.f50892a.size();
        }
        return size;
    }

    /* renamed from: c */
    public int mo125463c() {
        int size;
        synchronized (this.f50892a) {
            size = this.f50892a.size();
        }
        return size;
    }

    /* renamed from: a */
    public void mo125460a() {
        synchronized (this.f50892a) {
            this.f50892a.clear();
        }
    }

    /* renamed from: b */
    public C16688c[] mo125462b() {
        C16688c[] cVarArr;
        synchronized (this.f50892a) {
            cVarArr = new C16688c[this.f50892a.size()];
            this.f50892a.toArray(cVarArr);
        }
        return cVarArr;
    }
}
