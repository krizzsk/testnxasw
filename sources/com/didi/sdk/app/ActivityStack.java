package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.didi.app.router.PageRouter;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class ActivityStack {

    /* renamed from: a */
    private static boolean f37871a = false;

    /* renamed from: b */
    private static boolean f37872b = false;

    /* renamed from: c */
    private static final List<Activity> f37873c = new ArrayList();

    /* renamed from: d */
    private static final List<Activity> f37874d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final List<OnStackChangedListener> f37875e = new ArrayList();

    /* renamed from: f */
    private static final Application.ActivityLifecycleCallbacks f37876f = new Application.ActivityLifecycleCallbacks() {
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            ActivityStack.m28538g(activity);
        }

        public void onActivityStarted(Activity activity) {
            ActivityStack.m28539h(activity);
        }

        public void onActivityStopped(Activity activity) {
            ActivityStack.m28540i(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            Activity unused = ActivityStack.m28529b(ActivityStack.lastIndexOf(activity), false);
        }
    };

    public static abstract class OnStackChangedAdapter implements OnStackChangedListener {
        public void onAppPause() {
        }

        public void onAppResume() {
        }

        public void onPop(Activity activity) {
        }

        public void onPush(Activity activity) {
        }

        public void onStackGonnaEmpty(Activity activity) {
        }
    }

    public interface OnStackChangedListener {
        void onAppPause();

        void onAppResume();

        void onPop(Activity activity);

        void onPush(Activity activity);

        void onStackGonnaEmpty(Activity activity);
    }

    private ActivityStack() {
    }

    public static void init(Application application) {
        init(application, false);
    }

    public static void init(Application application, boolean z) {
        f37871a = z;
        application.registerActivityLifecycleCallbacks(f37876f);
    }

    public static void addStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (f37875e) {
            f37875e.add(onStackChangedListener);
        }
    }

    public static void removeStackChangedListener(OnStackChangedListener onStackChangedListener) {
        synchronized (f37875e) {
            f37875e.remove(onStackChangedListener);
        }
    }

    public static void removeAllStackChangedListener() {
        synchronized (f37875e) {
            f37875e.clear();
        }
    }

    /* renamed from: d */
    private static void m28535d(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPush : ActivityStack.f37875e) {
                    try {
                        onPush.onPush(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private static void m28536e(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onPop : ActivityStack.f37875e) {
                    try {
                        onPop.onPop(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: f */
    private static void m28537f(final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onStackGonnaEmpty : ActivityStack.f37875e) {
                    try {
                        onStackGonnaEmpty.onStackGonnaEmpty(activity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private static void m28530b() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppPause : ActivityStack.f37875e) {
                    try {
                        onAppPause.onAppPause();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private static void m28532c() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                for (OnStackChangedListener onAppResume : ActivityStack.f37875e) {
                    try {
                        onAppResume.onAppResume();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static String logStack() {
        StringBuilder sb = new StringBuilder("stack_bottom");
        for (Activity activity : f37873c) {
            sb.append("->" + activity.getClass().getSimpleName());
        }
        sb.append("->stack_head");
        m28528a("ActivityStack", sb.toString());
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m28538g(Activity activity) {
        synchronized (f37873c) {
            f37873c.add(activity);
            m28528a("ActivityStack", "pushInstance:" + activity.getClass().getSimpleName());
            logStack();
            m28535d(activity);
        }
    }

    /* renamed from: d */
    private static Activity m28534d() {
        return m28529b(f37873c.size() - 1, false);
    }

    public static Activity takeInstance(int i) {
        return f37873c.get(i);
    }

    public static Activity takeInstance() {
        if (f37873c.size() == 0) {
            return null;
        }
        return takeInstance(f37873c.size() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Activity m28529b(int i, boolean z) {
        Activity remove;
        if (i == -1) {
            return null;
        }
        synchronized (f37873c) {
            try {
                remove = f37873c.remove(i);
                if (z) {
                    m28526a(i - 1);
                }
                m28528a("ActivityStack", "popInstance:" + remove.getClass().getSimpleName());
                logStack();
                m28536e(remove);
                if (size() == 0) {
                    m28537f(remove);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return remove;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m28526a(int r3) {
        /*
            java.util.List<android.app.Activity> r0 = f37873c
            monitor-enter(r0)
            if (r3 >= 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0007:
            java.util.List<android.app.Activity> r1 = f37873c     // Catch:{ all -> 0x003c }
            int r1 = r1.size()     // Catch:{ all -> 0x003c }
            if (r3 < r1) goto L_0x0017
            java.util.List<android.app.Activity> r3 = f37873c     // Catch:{ all -> 0x003c }
            int r3 = r3.size()     // Catch:{ all -> 0x003c }
            int r3 = r3 + -1
        L_0x0017:
            r1 = r3
        L_0x0018:
            if (r1 < 0) goto L_0x0028
            java.util.List<android.app.Activity> r2 = f37873c     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003c }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x003c }
            r2.finish()     // Catch:{ all -> 0x003c }
            int r1 = r1 + -1
            goto L_0x0018
        L_0x0028:
            if (r3 == 0) goto L_0x0035
            java.util.List<android.app.Activity> r1 = f37873c     // Catch:{ all -> 0x003c }
            r2 = 0
            java.util.List r3 = r1.subList(r2, r3)     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
            goto L_0x003a
        L_0x0035:
            java.util.List<android.app.Activity> r3 = f37873c     // Catch:{ all -> 0x003c }
            r3.clear()     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.ActivityStack.m28526a(int):void");
    }

    public static void pop2MainActivity() {
        ActivityLifecycleManager instance = ActivityLifecycleManager.getInstance();
        if (!instance.isMainActivityOnTop()) {
            Activity currentActivity = instance.getCurrentActivity();
            Intent intent = new Intent();
            intent.addFlags(View.STATUS_BAR_TRANSIENT);
            PageRouter.getInstance().startMainActivity(currentActivity, intent);
            currentActivity.overridePendingTransition(0, 0);
        }
    }

    public static void exitApplication(boolean z) {
        synchronized (f37873c) {
            if (z) {
                try {
                    for (int size = f37873c.size() - 1; size >= 0; size--) {
                        f37873c.get(size).finish();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                for (int i = 0; i < f37873c.size(); i++) {
                    f37873c.get(i).finish();
                }
            }
            f37873c.clear();
        }
    }

    public static void exitApplication() {
        exitApplication(true);
    }

    public static int size() {
        return f37873c.size();
    }

    public static int indexOf(Activity activity) {
        return f37873c.indexOf(activity);
    }

    public static int lastIndexOf(Activity activity) {
        return f37873c.lastIndexOf(activity);
    }

    public static int indexOf(Class<? extends Activity> cls) {
        for (int i = 0; i < f37873c.size(); i++) {
            if (f37873c.get(i).getClass().equals(cls)) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Class<? extends Activity> cls) {
        for (int size = f37873c.size() - 1; size >= 0; size--) {
            if (f37873c.get(size).getClass().equals(cls)) {
                return size;
            }
        }
        return -1;
    }

    public static int sizeOf(Class<? extends Activity> cls) {
        int i = 0;
        for (int i2 = 0; i2 < f37873c.size(); i2++) {
            if (f37873c.get(i2).getLocalClassName().equals(cls.getSimpleName())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static void m28539h(Activity activity) {
        synchronized (f37874d) {
            boolean isEmpty = f37874d.isEmpty();
            f37874d.add(activity);
            if (isEmpty) {
                m28528a("ActivityStack", "App resume");
                f37872b = false;
                m28532c();
            } else {
                m28528a("ActivityStack", "saveResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m28540i(Activity activity) {
        synchronized (f37874d) {
            f37874d.remove(activity);
            if (f37874d.isEmpty()) {
                m28528a("ActivityStack", "App pause");
                f37872b = true;
                m28530b();
            } else {
                m28528a("ActivityStack", "removeResume:" + activity.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    private static void m28528a(String str, String str2) {
        if (f37871a) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.sdk.app.ActivityStack", 516);
        }
    }

    public static boolean isBackground() {
        return f37872b;
    }
}
