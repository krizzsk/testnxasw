package com.didi.sdk.apm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.didi.sdk.apm.utils.BackgroundThread;

/* renamed from: com.didi.sdk.apm.a */
/* compiled from: AppAutoCloser */
class C12701a implements Runnable {

    /* renamed from: a */
    private static final String f37727a = "AppAutoCloser";

    /* renamed from: b */
    private static final String f37728b = "close_delay";

    /* renamed from: c */
    private static final String f37729c = "close_type";

    /* renamed from: d */
    private static C12701a f37730d = null;

    /* renamed from: i */
    private static final int f37731i = 0;

    /* renamed from: j */
    private static final int f37732j = 1;

    /* renamed from: e */
    private Context f37733e;

    /* renamed from: f */
    private boolean f37734f;

    /* renamed from: g */
    private Handler f37735g = BackgroundThread.getHandler();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f37736h = 0;

    private C12701a() {
    }

    /* renamed from: a */
    public static synchronized C12701a m28443a() {
        C12701a aVar;
        synchronized (C12701a.class) {
            if (f37730d == null) {
                f37730d = new C12701a();
            }
            aVar = f37730d;
        }
        return aVar;
    }

    /* renamed from: a */
    public synchronized C12701a mo96709a(Context context) {
        if (this.f37734f) {
            return this;
        }
        this.f37734f = true;
        Context applicationContext = context.getApplicationContext();
        this.f37733e = applicationContext;
        if (applicationContext == null) {
            this.f37733e = context;
        }
        return f37730d;
    }

    /* renamed from: b */
    public void mo96710b() {
        AppStateMonitor.getInstance().registerStateListener(new AppAutoCloser$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m28444a(long j) {
        Log.i(f37727a, "scheduleClose: delay=" + j);
        this.f37735g.removeCallbacks(this);
        this.f37735g.postDelayed(this, j);
    }

    public void run() {
        if (this.f37736h == 0) {
            m28450e();
        }
        if (this.f37736h == 1) {
            m28451f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28448c() {
        this.f37735g.post(new AppAutoCloser$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m28449d() {
        Log.i(f37727a, "removeSchedule ");
        this.f37735g.removeCallbacks(this);
    }

    /* renamed from: e */
    private void m28450e() {
        Log.i(f37727a, "closeNow ");
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    /* renamed from: f */
    private void m28451f() {
        Log.i(f37727a, "restartNow");
        try {
            Intent launchIntentForPackage = this.f37733e.getPackageManager().getLaunchIntentForPackage(this.f37733e.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(View.STATUS_BAR_TRANSIENT);
                launchIntentForPackage.addFlags(268435456);
                this.f37733e.startActivity(launchIntentForPackage);
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th) {
            Log.e(f37727a, "restartNow error: ", th);
        }
    }
}
