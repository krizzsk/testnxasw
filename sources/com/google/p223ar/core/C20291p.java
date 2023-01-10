package com.google.p223ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.p209a.p211b.p212a.p213a.p214a.C18666a;
import com.google.p209a.p211b.p212a.p213a.p214a.C18667b;
import com.google.p223ar.core.ArCoreApk;
import com.google.p223ar.core.exceptions.FatalException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.p */
/* compiled from: InstallService */
class C20291p {

    /* renamed from: a */
    private final Queue<Runnable> f56490a;

    /* renamed from: b */
    private Context f56491b;

    /* renamed from: c */
    private volatile int f56492c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C18667b f56493d;

    /* renamed from: e */
    private BroadcastReceiver f56494e;

    /* renamed from: f */
    private Context f56495f;

    /* renamed from: g */
    private final ServiceConnection f56496g;

    /* renamed from: h */
    private final AtomicReference<C20300z> f56497h;

    C20291p() {
    }

    /* renamed from: a */
    public synchronized void mo164857a(Context context) {
        this.f56491b = context;
        if (context.bindService(new Intent("com.google.android.play.core.install.BIND_INSTALL_SERVICE").setPackage("com.android.vending"), this.f56496g, 1)) {
            this.f56492c = C20255aa.f56436b;
            return;
        }
        this.f56492c = C20255aa.f56435a;
        this.f56491b = null;
        SystemUtils.log(5, "ARCore-InstallService", "bindService returned false.", (Throwable) null, "com.google.ar.core.p", 9);
        context.unbindService(this.f56496g);
    }

    /* renamed from: a */
    public synchronized void mo164855a() {
        m42688c();
        int i = this.f56492c - 1;
        if (i == 1 || i == 2) {
            this.f56491b.unbindService(this.f56496g);
            this.f56491b = null;
            this.f56492c = C20255aa.f56435a;
        }
        if (this.f56494e != null) {
            try {
                this.f56495f.unregisterReceiver(this.f56494e);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo164858a(Context context, ArCoreApk.C20243a aVar) {
        try {
            m42683a((Runnable) new C20295u(this, context, aVar));
        } catch (C20256ab unused) {
            SystemUtils.log(6, "ARCore-InstallService", "Play Store install service could not be bound.", (Throwable) null, "com.google.ar.core.p", 24);
            aVar.mo164600a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }

    /* renamed from: a */
    public void mo164856a(Activity activity, C20293s sVar) {
        C20300z zVar = new C20300z(activity, sVar);
        C20300z andSet = this.f56497h.getAndSet(zVar);
        if (andSet != null) {
            andSet.mo164867a();
        }
        zVar.start();
        if (this.f56494e == null) {
            C20297w wVar = new C20297w(this, sVar);
            this.f56494e = wVar;
            this.f56495f = activity;
            try {
                activity.registerReceiver(wVar, new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        try {
            m42683a((Runnable) new C20296v(this, activity, sVar));
        } catch (C20256ab unused) {
            SystemUtils.log(5, "ARCore-InstallService", "requestInstall bind failed, launching fullscreen.", (Throwable) null, "com.google.ar.core.p", 39);
            m42686b(activity, sVar);
        }
    }

    C20291p(byte b) {
        this();
        this.f56490a = new ArrayDeque();
        this.f56492c = C20255aa.f56435a;
        this.f56496g = new C20292q(this);
        this.f56497h = new AtomicReference<>();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m42686b(Activity activity, C20293s sVar) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ar.core")));
        } catch (ActivityNotFoundException e) {
            sVar.mo164862a((Exception) new FatalException("Failed to launch installer.", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m42677a(Activity activity, Bundle bundle, C20293s sVar) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("resolution.intent");
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1234, new Intent(activity, activity.getClass()), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                sVar.mo164862a((Exception) new FatalException("Installation Intent failed", e));
            }
        } else {
            SystemUtils.log(6, "ARCore-InstallService", "Did not get pending intent.", (Throwable) null, "com.google.ar.core.p", 64);
            sVar.mo164862a((Exception) new FatalException("Installation intent failed to unparcel."));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Bundle m42684b() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("package.name", "com.google.ar.core");
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m42688c() {
        C20300z andSet = this.f56497h.getAndSet((Object) null);
        if (andSet != null) {
            andSet.mo164867a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m42678a(IBinder iBinder) {
        C18667b a = C18666a.m40750a(iBinder);
        SystemUtils.log(4, "ARCore-InstallService", "Install service connected", (Throwable) null, "com.google.ar.core.p", 75);
        this.f56493d = a;
        this.f56492c = C20255aa.f56437c;
        for (Runnable run : this.f56490a) {
            run.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m42689d() {
        SystemUtils.log(4, "ARCore-InstallService", "Install service disconnected", (Throwable) null, "com.google.ar.core.p", 82);
        this.f56492c = C20255aa.f56435a;
        this.f56493d = null;
        m42688c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m42683a(java.lang.Runnable r3) throws com.google.p223ar.core.C20256ab {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f56492c     // Catch:{ all -> 0x001f }
            r1 = 1
            int r0 = r0 - r1
            if (r0 == 0) goto L_0x0019
            if (r0 == r1) goto L_0x0012
            r1 = 2
            if (r0 == r1) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            r3.run()     // Catch:{ all -> 0x001f }
        L_0x0010:
            monitor-exit(r2)
            return
        L_0x0012:
            java.util.Queue<java.lang.Runnable> r0 = r2.f56490a     // Catch:{ all -> 0x001f }
            r0.offer(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return
        L_0x0019:
            com.google.ar.core.ab r3 = new com.google.ar.core.ab     // Catch:{ all -> 0x001f }
            r3.<init>()     // Catch:{ all -> 0x001f }
            throw r3     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.p223ar.core.C20291p.m42683a(java.lang.Runnable):void");
    }
}
