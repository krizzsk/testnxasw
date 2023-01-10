package com.didi.sdk.apm;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.didi.sdk.apm.c */
/* compiled from: MainThreadWatcher */
class C12711c implements Runnable {

    /* renamed from: a */
    public static final String f37738a = "WATCHER_LOG";

    /* renamed from: b */
    public static final int f37739b = 3000;

    /* renamed from: c */
    public static final int f37740c = 5500;

    /* renamed from: d */
    private static C12711c f37741d;

    /* renamed from: e */
    private Handler f37742e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AtomicBoolean f37743f = new AtomicBoolean(false);

    /* renamed from: g */
    private AtomicBoolean f37744g = new AtomicBoolean(false);

    /* renamed from: h */
    private AtomicBoolean f37745h = new AtomicBoolean(false);

    /* renamed from: i */
    private AtomicBoolean f37746i = new AtomicBoolean(false);

    /* renamed from: j */
    private int f37747j = 3000;

    /* renamed from: k */
    private Thread f37748k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f37749l;

    /* renamed from: m */
    private Runnable f37750m = new MainThreadWatcher$2(this);

    private C12711c() {
    }

    /* renamed from: a */
    public static C12711c m28467a() {
        if (f37741d == null) {
            synchronized (C12711c.class) {
                if (f37741d == null) {
                    f37741d = new C12711c();
                }
            }
        }
        return f37741d;
    }

    /* renamed from: a */
    public C12711c mo96718a(int i) {
        this.f37747j = i;
        return this;
    }

    /* renamed from: b */
    public C12711c mo96719b() {
        if (Debug.isDebuggerConnected() || this.f37746i.get()) {
            return this;
        }
        this.f37746i.set(true);
        Thread thread = new Thread(this, "MainThreadWatcher");
        this.f37748k = thread;
        thread.start();
        this.f37742e.postAtFrontOfQueue(new MainThreadWatcher$1(this));
        return this;
    }

    public final void run() {
        if (this.f37746i.get()) {
            Process.setThreadPriority(10);
            while (!this.f37744g.get()) {
                if (!this.f37745h.get()) {
                    this.f37743f.set(false);
                    this.f37749l = SystemClock.uptimeMillis();
                    this.f37742e.post(this.f37750m);
                }
                try {
                    Thread.sleep(this.f37745h.get() ? Long.MAX_VALUE : (long) this.f37747j);
                    if (this.f37744g.get()) {
                        break;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f37749l;
                    AtomicReference atomicReference = new AtomicReference();
                    AtomicLong atomicLong = new AtomicLong();
                    if (!this.f37743f.get()) {
                        Log.e(f37738a, ">>> Blocked in Main Thread for " + uptimeMillis + "ms <<< ");
                        try {
                            Looper.getMainLooper().dump(new MainThreadWatcher$3(this, atomicLong, atomicReference), "");
                        } catch (Exception unused) {
                        }
                        Log.e(f37738a, "Ignore the remaining message...  ");
                        Log.e(f37738a, (String) atomicReference.get());
                        this.f37742e.removeCallbacks(this.f37750m);
                    }
                } catch (InterruptedException unused2) {
                }
            }
            this.f37742e.removeCallbacksAndMessages((Object) null);
        }
    }

    /* renamed from: c */
    public C12711c mo96720c() {
        Log.i(f37738a, "pause: ");
        if (!this.f37746i.get()) {
            return this;
        }
        this.f37745h.set(true);
        return this;
    }

    /* renamed from: d */
    public C12711c mo96721d() {
        Log.i(f37738a, "resume: ");
        if (!this.f37746i.get()) {
            return this;
        }
        this.f37745h.set(false);
        this.f37748k.interrupt();
        return this;
    }

    /* renamed from: e */
    public C12711c mo96722e() {
        Log.i(f37738a, "stop: ");
        if (!this.f37746i.get()) {
            return this;
        }
        this.f37744g.set(true);
        this.f37748k.interrupt();
        this.f37746i.set(false);
        return this;
    }
}
