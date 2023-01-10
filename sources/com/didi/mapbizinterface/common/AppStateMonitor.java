package com.didi.mapbizinterface.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppStateMonitor {

    /* renamed from: a */
    private final AppStateCallbacks f31521a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile boolean f31522b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile int f31523c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile String f31524d;

    /* renamed from: e */
    private CopyOnWriteArrayList<OnAppStateChangedListener> f31525e;

    public enum AppState {
        FOREGROUND,
        BACKGROUND,
        UNKNOWN
    }

    public interface OnAppStateChangedListener {
        void onAppStateChanged(AppState appState, String str);
    }

    /* renamed from: a */
    static /* synthetic */ int m24082a(AppStateMonitor appStateMonitor) {
        int i = appStateMonitor.f31523c + 1;
        appStateMonitor.f31523c = i;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m24089c(AppStateMonitor appStateMonitor) {
        int i = appStateMonitor.f31523c - 1;
        appStateMonitor.f31523c = i;
        return i;
    }

    private AppStateMonitor() {
        this.f31521a = new AppStateCallbacks();
        this.f31522b = false;
        this.f31523c = 0;
        this.f31525e = new CopyOnWriteArrayList<>();
    }

    private static class SingletonHolder {
        static AppStateMonitor INSTANCE = new AppStateMonitor();

        private SingletonHolder() {
        }
    }

    public static AppStateMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.f31521a);
        }
    }

    public AppState getAppState() {
        if (this.f31522b) {
            return this.f31523c > 0 ? AppState.FOREGROUND : AppState.BACKGROUND;
        }
        return AppState.UNKNOWN;
    }

    public String getCurrentAppPage() {
        return this.f31524d;
    }

    public void addOnAppStateChangedListener(OnAppStateChangedListener onAppStateChangedListener) {
        if (onAppStateChangedListener != null) {
            this.f31525e.add(onAppStateChangedListener);
        }
    }

    public void removeOnAppStateChangedListener(OnAppStateChangedListener onAppStateChangedListener) {
        if (onAppStateChangedListener != null) {
            this.f31525e.remove(onAppStateChangedListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24085a(AppState appState, String str) {
        Iterator<OnAppStateChangedListener> it = this.f31525e.iterator();
        while (it.hasNext()) {
            it.next().onAppStateChanged(appState, str);
        }
    }

    private class AppStateCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        private AppStateCallbacks() {
        }

        public void onActivityStarted(Activity activity) {
            AppStateMonitor.m24082a(AppStateMonitor.this);
            String unused = AppStateMonitor.this.f31524d = activity.getClass().getSimpleName();
            boolean unused2 = AppStateMonitor.this.f31522b = true;
            AppStateMonitor appStateMonitor = AppStateMonitor.this;
            appStateMonitor.m24085a(appStateMonitor.getAppState(), AppStateMonitor.this.getCurrentAppPage());
        }

        public void onActivityStopped(Activity activity) {
            AppStateMonitor appStateMonitor = AppStateMonitor.this;
            int unused = appStateMonitor.f31523c = appStateMonitor.f31523c > 0 ? AppStateMonitor.m24089c(AppStateMonitor.this) : 0;
            if (TextUtils.equals(activity.getClass().getSimpleName(), AppStateMonitor.this.f31524d)) {
                String unused2 = AppStateMonitor.this.f31524d = null;
            }
            AppStateMonitor appStateMonitor2 = AppStateMonitor.this;
            appStateMonitor2.m24085a(appStateMonitor2.getAppState(), AppStateMonitor.this.getCurrentAppPage());
        }
    }
}
