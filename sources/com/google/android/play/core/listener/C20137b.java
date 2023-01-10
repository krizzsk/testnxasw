package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20046aw;
import com.google.android.play.core.splitcompat.C20164p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.play.core.listener.b */
public abstract class C20137b<StateT> {

    /* renamed from: a */
    protected final C20030ag f56129a;

    /* renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f56130b = new HashSet();

    /* renamed from: c */
    private final IntentFilter f56131c;

    /* renamed from: d */
    private final Context f56132d;

    /* renamed from: e */
    private C20136a f56133e = null;

    /* renamed from: f */
    private volatile boolean f56134f = false;

    protected C20137b(C20030ag agVar, IntentFilter intentFilter, Context context) {
        this.f56129a = agVar;
        this.f56131c = intentFilter;
        this.f56132d = C20164p.m42450a(context);
    }

    /* renamed from: c */
    private final void m42375c() {
        C20136a aVar;
        if ((this.f56134f || !this.f56130b.isEmpty()) && this.f56133e == null) {
            C20136a aVar2 = new C20136a(this);
            this.f56133e = aVar2;
            try {
                this.f56132d.registerReceiver(aVar2, this.f56131c);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        if (!this.f56134f && this.f56130b.isEmpty() && (aVar = this.f56133e) != null) {
            try {
                this.f56132d.unregisterReceiver(aVar);
            } catch (Exception e2) {
                Log.d("Context", "unregisterReceiver", e2);
            }
            this.f56133e = null;
        }
    }

    /* renamed from: a */
    public final synchronized void mo164403a() {
        this.f56129a.mo164270c("clearListeners", new Object[0]);
        this.f56130b.clear();
        m42375c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo163986a(Context context, Intent intent);

    /* renamed from: a */
    public final synchronized void mo164404a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f56129a.mo164270c("registerListener", new Object[0]);
        C20046aw.m42172a(stateUpdatedListener, (Object) "Registered Play Core listener should not be null.");
        this.f56130b.add(stateUpdatedListener);
        m42375c();
    }

    /* renamed from: a */
    public final synchronized void mo164405a(StateT statet) {
        Iterator it = new HashSet(this.f56130b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* renamed from: a */
    public final synchronized void mo164406a(boolean z) {
        this.f56134f = z;
        m42375c();
    }

    /* renamed from: b */
    public final synchronized void mo164407b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f56129a.mo164270c("unregisterListener", new Object[0]);
        C20046aw.m42172a(stateUpdatedListener, (Object) "Unregistered Play Core listener should not be null.");
        this.f56130b.remove(stateUpdatedListener);
        m42375c();
    }

    /* renamed from: b */
    public final synchronized boolean mo164408b() {
        return this.f56133e != null;
    }
}
