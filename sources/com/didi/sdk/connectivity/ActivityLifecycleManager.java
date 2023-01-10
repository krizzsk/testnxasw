package com.didi.sdk.connectivity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;

class ActivityLifecycleManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<Activity> f38475a;

    /* renamed from: b */
    private ArrayList<AppStateListener> f38476b;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f38477c;

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    private ActivityLifecycleManager() {
        this.f38475a = new ArrayList<>();
        this.f38476b = new ArrayList<>();
        this.f38477c = new AbsActivityLifecycleCallbacks() {
            public void onActivityStarted(Activity activity) {
                if (ActivityLifecycleManager.this.f38475a.isEmpty()) {
                    ActivityLifecycleManager.this.m29017a(1);
                }
                ActivityLifecycleManager.this.f38475a.add(activity);
            }

            public void onActivityStopped(Activity activity) {
                ActivityLifecycleManager.this.f38475a.remove(activity);
                if (ActivityLifecycleManager.this.f38475a.isEmpty()) {
                    ActivityLifecycleManager.this.m29017a(0);
                }
            }
        };
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static ActivityLifecycleManager INSTANCE = new ActivityLifecycleManager();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    public static ActivityLifecycleManager m29015a() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97841a(Application application) {
        application.registerActivityLifecycleCallbacks(this.f38477c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97842a(AppStateListener appStateListener) {
        synchronized (this.f38476b) {
            this.f38476b.add(appStateListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97843b(AppStateListener appStateListener) {
        synchronized (this.f38476b) {
            this.f38476b.remove(appStateListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29017a(int i) {
        ArrayList<AppStateListener> arrayList = new ArrayList<>();
        synchronized (this.f38476b) {
            arrayList.addAll(this.f38476b);
        }
        for (AppStateListener onStateChanged : arrayList) {
            onStateChanged.onStateChanged(i);
        }
    }

    static class AbsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
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

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        AbsActivityLifecycleCallbacks() {
        }
    }
}
