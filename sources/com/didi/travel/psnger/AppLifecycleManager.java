package com.didi.travel.psnger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;

public class AppLifecycleManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<Activity> f46668a;

    /* renamed from: b */
    private ArrayList<AppStateListener> f46669b;

    /* renamed from: c */
    private Application.ActivityLifecycleCallbacks f46670c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f46671d;

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    private AppLifecycleManager() {
        this.f46668a = new ArrayList<>();
        this.f46669b = new ArrayList<>();
        this.f46670c = new AbsActivityLifecycleCallbacks() {
            public void onActivityStarted(Activity activity) {
                AppLifecycleManager.this.f46668a.add(activity);
                if (AppLifecycleManager.this.f46668a.size() == 1) {
                    AppLifecycleManager.this.m34832a(1);
                }
                boolean unused = AppLifecycleManager.this.f46671d = true;
            }

            public void onActivityStopped(Activity activity) {
                AppLifecycleManager.this.f46668a.remove(activity);
                if (AppLifecycleManager.this.f46668a.isEmpty()) {
                    AppLifecycleManager.this.m34832a(0);
                }
                boolean unused = AppLifecycleManager.this.f46671d = true;
            }
        };
    }

    public static AppLifecycleManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo116291a(Application application) {
        application.registerActivityLifecycleCallbacks(this.f46670c);
    }

    public boolean isAppFront() {
        if (!this.f46671d) {
            return true;
        }
        return !this.f46668a.isEmpty();
    }

    public void registerAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f46669b) {
            this.f46669b.add(appStateListener);
        }
    }

    public void unregisterAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f46669b) {
            this.f46669b.remove(appStateListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34832a(int i) {
        ArrayList<AppStateListener> arrayList = new ArrayList<>();
        synchronized (this.f46669b) {
            arrayList.addAll(this.f46669b);
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

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static AppLifecycleManager INSTANCE = new AppLifecycleManager();

        private SingletonHolder() {
        }
    }
}
