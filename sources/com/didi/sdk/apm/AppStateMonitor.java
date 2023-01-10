package com.didi.sdk.apm;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.didi.sdk.apm.utils.BackgroundThread;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    public static final String TAG = "ApplicationState";

    /* renamed from: b */
    private static final AppStateMonitor f37689b = new AppStateMonitor();

    /* renamed from: a */
    final Logger f37690a = LoggerFactory.getLogger("ApplicationState");

    /* renamed from: c */
    private final ArrayList<StateListener> f37691c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicInteger f37692d = new AtomicInteger(0);

    /* renamed from: e */
    private int f37693e = 0;

    /* renamed from: f */
    private Handler f37694f = BackgroundThread.getHandler();

    /* renamed from: g */
    private boolean f37695g = false;

    /* renamed from: h */
    private Runnable f37696h;

    public interface StateListener {
        void onInBackground();

        void onInForeground();
    }

    public static AppStateMonitor getInstance() {
        return f37689b;
    }

    public int getState() {
        return this.f37693e;
    }

    public void init(Context context) {
        if (!this.f37695g) {
            this.f37695g = true;
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
            C126941 r4 = new Runnable() {
                public void run() {
                    if (AppStateMonitor.this.f37692d.get() == 0) {
                        AppStateMonitor.this.m28422a(0);
                    }
                }
            };
            this.f37696h = r4;
            this.f37694f.postDelayed(r4, 15000);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m28424a("onActivityCreated: " + activity + ", savedInstanceState:" + bundle + ", intent:" + activity.getIntent().clone() + ", callingPackage:" + activity.getCallingPackage() + ", callingActivity:" + activity.getCallingActivity());
    }

    public void onActivityStarted(Activity activity) {
        m28424a("onActivityStarted: " + activity);
        if (this.f37692d.getAndIncrement() == 0) {
            m28422a(1);
        }
        Runnable runnable = this.f37696h;
        if (runnable != null) {
            this.f37694f.removeCallbacks(runnable);
            this.f37696h = null;
        }
    }

    public void onActivityResumed(Activity activity) {
        m28424a("onActivityResumed: " + activity);
    }

    public void onActivityPaused(Activity activity) {
        m28424a("onActivityPaused: " + activity);
    }

    public void onActivityStopped(Activity activity) {
        m28424a("onActivityStopped: " + activity);
        if (this.f37692d.decrementAndGet() == 0) {
            m28422a(0);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m28424a("onActivitySaveInstanceState: " + activity + " outState:" + bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        m28424a("onActivityDestroyed: " + activity);
    }

    public void onTrimMemory(int i) {
        m28424a("onTrimMemory: level:" + i);
    }

    public void onConfigurationChanged(Configuration configuration) {
        m28424a("onConfigurationChanged: " + configuration);
    }

    public void onLowMemory() {
        m28424a("onLowMemory: ");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28422a(int i) {
        this.f37693e = i;
        if (i == 0) {
            m28424a("App into background");
            m28421a();
        }
        if (i == 1) {
            m28424a("App into foreground");
            m28425b();
        }
    }

    /* renamed from: a */
    private void m28421a() {
        Object[] c = m28426c();
        if (c != null) {
            for (Object obj : c) {
                ((StateListener) obj).onInBackground();
            }
        }
    }

    /* renamed from: b */
    private void m28425b() {
        Object[] c = m28426c();
        if (c != null) {
            for (Object obj : c) {
                ((StateListener) obj).onInForeground();
            }
        }
    }

    /* renamed from: c */
    private Object[] m28426c() {
        Object[] array;
        synchronized (this.f37691c) {
            array = this.f37691c.size() > 0 ? this.f37691c.toArray() : null;
        }
        return array;
    }

    public void registerStateListener(StateListener stateListener) {
        if (stateListener != null) {
            synchronized (this.f37691c) {
                this.f37691c.add(stateListener);
            }
        }
    }

    public void unregisterStateListener(StateListener stateListener) {
        if (stateListener != null) {
            synchronized (this.f37691c) {
                this.f37691c.remove(stateListener);
            }
        }
    }

    /* renamed from: a */
    private void m28424a(String str) {
        this.f37690a.info(str, new Object[0]);
        if (!this.f37690a.isDebugEnabled()) {
            Log.i("ApplicationState", str);
        }
    }
}
