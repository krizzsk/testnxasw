package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleManager {

    /* renamed from: a */
    private Application f37859a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile AtomicInteger f37860b = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<Activity> f37861c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<AppStateListener> f37862d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HashMap<Activity, ActivityTrace> f37863e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f37864f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f37865g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f37866h;

    /* renamed from: i */
    private HomeKeyEventReceiver f37867i;

    /* renamed from: j */
    private ArrayList<HomeKeyEventListener> f37868j = new ArrayList<>();

    /* renamed from: k */
    private AbsActivityLifecycleCallbacks f37869k = new AbsActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MainActivity) {
                ActivityLifecycleManager.this.f37860b.incrementAndGet();
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MainActivity) {
                ActivityLifecycleManager.this.f37860b.decrementAndGet();
            }
        }
    };

    /* renamed from: l */
    private AbsActivityLifecycleCallbacks f37870l = new AbsActivityLifecycleCallbacks() {
        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleManager.this.f37861c.isEmpty()) {
                boolean unused = ActivityLifecycleManager.this.f37864f = true;
                ActivityLifecycleManager.this.m28511a(1);
            }
            ActivityLifecycleManager.this.f37861c.add(activity);
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f37863e.get(activity);
            if (activityTrace != null) {
                activityTrace.startCnt++;
            }
        }

        public void onActivityStopped(Activity activity) {
            ActivityLifecycleManager.this.f37861c.remove(activity);
            if (ActivityLifecycleManager.this.f37861c.isEmpty()) {
                boolean unused = ActivityLifecycleManager.this.f37864f = false;
                ActivityLifecycleManager.this.m28511a(0);
            }
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f37863e.get(activity);
            if (activityTrace != null) {
                activityTrace.stopCnt++;
            }
        }

        public void onActivityResumed(Activity activity) {
            Activity unused = ActivityLifecycleManager.this.f37866h = activity;
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f37863e.get(activity);
            if (activityTrace != null) {
                activityTrace.resumeCnt++;
            }
        }

        public void onActivityPaused(Activity activity) {
            ActivityTrace activityTrace = (ActivityTrace) ActivityLifecycleManager.this.f37863e.get(activity);
            if (activityTrace != null) {
                activityTrace.pauseCnt++;
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MainActivity) {
                int unused = ActivityLifecycleManager.this.f37865g = activity.getTaskId();
            }
            ActivityLifecycleManager.this.f37863e.put(activity, new ActivityTrace(activity));
        }

        public void onActivityDestroyed(Activity activity) {
            ActivityLifecycleManager.this.f37863e.remove(activity);
            ActivityLeakForHuaWei.doWorkaroundIfNeed(activity);
        }
    };

    public static class AbsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
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

        public void onNewIntent(Intent intent) {
        }
    }

    public interface AppStateListener {
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 0;

        void onStateChanged(int i);
    }

    public interface HomeKeyEventListener {
        void onHomeKeyPressed();
    }

    private ActivityLifecycleManager() {
    }

    public static ActivityLifecycleManager getInstance() {
        return (ActivityLifecycleManager) SingletonHolder.getInstance(ActivityLifecycleManager.class);
    }

    public static void init(Application application) {
        getInstance().f37859a = application;
        getInstance().m28510a();
        getInstance().m28516b();
        getInstance().m28521e();
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.f37859a != null && Build.VERSION.SDK_INT >= 14) {
            this.f37859a.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.f37859a != null && Build.VERSION.SDK_INT >= 14) {
            this.f37859a.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public boolean isMainActivityRunning() {
        return this.f37860b.get() >= 1;
    }

    public boolean isAppActive() {
        return this.f37864f;
    }

    public boolean isMainActivityOnTop() {
        Collection<ActivityTrace> values;
        Activity activity = this.f37866h;
        if ((activity == null || !(activity instanceof MainActivity)) && (values = this.f37863e.values()) != null) {
            for (ActivityTrace next : values) {
                boolean z = next.activity instanceof MainActivity;
                boolean z2 = next.startCnt > 0;
                boolean z3 = next.activity.getTaskId() == this.f37865g;
                if (!z && z2 && z3) {
                    return false;
                }
            }
        }
        return true;
    }

    public Activity getCurrentActivity() {
        return this.f37866h;
    }

    public void addAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f37862d) {
            this.f37862d.add(appStateListener);
        }
    }

    public void removeAppStateListener(AppStateListener appStateListener) {
        synchronized (this.f37862d) {
            this.f37862d.remove(appStateListener);
        }
    }

    public void addHomeKeyEventListener(HomeKeyEventListener homeKeyEventListener) {
        if (homeKeyEventListener != null) {
            synchronized (this.f37868j) {
                this.f37868j.add(homeKeyEventListener);
            }
        }
    }

    public void removeHomeKeyEventListener(HomeKeyEventListener homeKeyEventListener) {
        if (homeKeyEventListener != null) {
            synchronized (this.f37868j) {
                this.f37868j.remove(homeKeyEventListener);
            }
        }
    }

    /* renamed from: a */
    private void m28510a() {
        registerActivityLifecycleCallbacks(this.f37869k);
    }

    /* renamed from: b */
    private void m28516b() {
        registerActivityLifecycleCallbacks(this.f37870l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28511a(int i) {
        Object[] c = m28518c();
        if (c != null) {
            for (int i2 = 0; i2 < c.length; i2++) {
                if (c[i2] != null) {
                    ((AppStateListener) c[i2]).onStateChanged(i);
                }
            }
        }
    }

    /* renamed from: c */
    private Object[] m28518c() {
        Object[] array;
        synchronized (this.f37862d) {
            array = this.f37862d.size() > 0 ? this.f37862d.toArray() : null;
        }
        return array;
    }

    /* renamed from: d */
    private Object[] m28520d() {
        Object[] array;
        synchronized (this.f37868j) {
            array = this.f37868j.size() > 0 ? this.f37868j.toArray() : null;
        }
        return array;
    }

    /* renamed from: e */
    private void m28521e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        HomeKeyEventReceiver homeKeyEventReceiver = new HomeKeyEventReceiver();
        this.f37867i = homeKeyEventReceiver;
        try {
            this.f37859a.registerReceiver(homeKeyEventReceiver, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: f */
    private void m28522f() {
        try {
            this.f37859a.unregisterReceiver(this.f37867i);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m28523g() {
        Object[] d = m28520d();
        if (d != null) {
            for (Object obj : d) {
                ((HomeKeyEventListener) obj).onHomeKeyPressed();
            }
        }
    }

    static class ActivityTrace {
        public Activity activity;
        public int pauseCnt;
        public int resumeCnt;
        public int startCnt;
        public int stopCnt;

        public ActivityTrace(Activity activity2) {
            this.activity = activity2;
        }
    }

    final class HomeKeyEventReceiver extends BroadcastReceiver {
        private final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        private final String SYSTEM_DIALOG_REASON_KEY = "reason";

        HomeKeyEventReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                ActivityLifecycleManager.this.m28523g();
            }
        }
    }
}
