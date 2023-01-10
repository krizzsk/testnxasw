package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C20237i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.aq */
public final class C20040aq<T extends IInterface> {

    /* renamed from: a */
    private static final Map<String, Handler> f56072a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f56073b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C20030ag f56074c;

    /* renamed from: d */
    private final String f56075d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<C20031ah> f56076e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f56077f;

    /* renamed from: g */
    private final Intent f56078g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C20036am<T> f56079h;

    /* renamed from: i */
    private final WeakReference<C20035al> f56080i;

    /* renamed from: j */
    private final IBinder.DeathRecipient f56081j = new C20032ai(this);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ServiceConnection f56082k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public T f56083l;

    public C20040aq(Context context, C20030ag agVar, String str, Intent intent, C20036am<T> amVar) {
        this.f56073b = context;
        this.f56074c = agVar;
        this.f56075d = str;
        this.f56078g = intent;
        this.f56079h = amVar;
        this.f56080i = new WeakReference<>((Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m42144a(C20040aq aqVar, C20031ah ahVar) {
        if (aqVar.f56083l == null && !aqVar.f56077f) {
            aqVar.f56074c.mo164270c("Initiate binding to the service.", new Object[0]);
            aqVar.f56076e.add(ahVar);
            C20039ap apVar = new C20039ap(aqVar);
            aqVar.f56082k = apVar;
            aqVar.f56077f = true;
            if (!aqVar.f56073b.bindService(aqVar.f56078g, apVar, 1)) {
                aqVar.f56074c.mo164270c("Failed to bind to the service.", new Object[0]);
                aqVar.f56077f = false;
                for (C20031ah b : aqVar.f56076e) {
                    C20237i<?> b2 = b.mo164272b();
                    if (b2 != null) {
                        b2.mo164556b((Exception) new C20041ar());
                    }
                }
                aqVar.f56076e.clear();
            }
        } else if (aqVar.f56077f) {
            aqVar.f56074c.mo164270c("Waiting to bind to the service.", new Object[0]);
            aqVar.f56076e.add(ahVar);
        } else {
            ahVar.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m42146b(C20031ah ahVar) {
        Handler handler;
        synchronized (f56072a) {
            if (!f56072a.containsKey(this.f56075d)) {
                HandlerThread handlerThread = new HandlerThread(this.f56075d, 10);
                handlerThread.start();
                f56072a.put(this.f56075d, new Handler(handlerThread.getLooper()));
            }
            handler = f56072a.get(this.f56075d);
        }
        handler.post(ahVar);
    }

    /* renamed from: f */
    static /* synthetic */ void m42151f(C20040aq aqVar) {
        aqVar.f56074c.mo164270c("linkToDeath", new Object[0]);
        try {
            aqVar.f56083l.asBinder().linkToDeath(aqVar.f56081j, 0);
        } catch (RemoteException e) {
            aqVar.f56074c.mo164268a((Throwable) e, "linkToDeath failed", new Object[0]);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m42153h(C20040aq aqVar) {
        aqVar.f56074c.mo164270c("unlinkToDeath", new Object[0]);
        aqVar.f56083l.asBinder().unlinkToDeath(aqVar.f56081j, 0);
    }

    /* renamed from: a */
    public final void mo164278a() {
        m42146b((C20031ah) new C20034ak(this));
    }

    /* renamed from: a */
    public final void mo164279a(C20031ah ahVar) {
        m42146b((C20031ah) new C20033aj(this, ahVar.mo164272b(), ahVar));
    }

    /* renamed from: b */
    public final T mo164280b() {
        return this.f56083l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo164281c() {
        this.f56074c.mo164270c("reportBinderDeath", new Object[0]);
        C20035al alVar = (C20035al) this.f56080i.get();
        if (alVar == null) {
            this.f56074c.mo164270c("%s : Binder has died.", this.f56075d);
            for (C20031ah b : this.f56076e) {
                C20237i<?> b2 = b.mo164272b();
                if (b2 != null) {
                    b2.mo164556b((Exception) Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.f56075d).concat(" : Binder has died.")));
                }
            }
            this.f56076e.clear();
            return;
        }
        this.f56074c.mo164270c("calling onBinderDied", new Object[0]);
        alVar.mo164275a();
    }
}
