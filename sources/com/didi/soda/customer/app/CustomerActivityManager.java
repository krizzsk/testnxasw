package com.didi.soda.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import java.util.Stack;

public class CustomerActivityManager {

    /* renamed from: a */
    private static final String f42876a = "CustomerActivityManager";

    /* renamed from: b */
    private static CustomerActivityManager f42877b;

    /* renamed from: c */
    private Stack<Activity> f42878c = new Stack<>();

    /* renamed from: d */
    private ActivityTraceInfo f42879d = new ActivityTraceInfo();

    public static CustomerActivityManager getInstance() {
        if (f42877b == null) {
            synchronized (CustomerActivityManager.class) {
                if (f42877b == null) {
                    f42877b = new CustomerActivityManager();
                }
            }
        }
        return f42877b;
    }

    public ActivityTraceInfo getActivityTraceInfo() {
        return this.f42879d;
    }

    public boolean findActivityAlive(Class cls) {
        Stack<Activity> stack = this.f42878c;
        if (stack == null || stack.empty()) {
            LogUtil.m32588i(f42876a, "mActivityStacks isEmpty");
            return false;
        }
        for (int i = 0; i < this.f42878c.size(); i++) {
            LogUtil.m32588i(f42876a, "mActivityStacks name =" + ((Activity) this.f42878c.get(i)).getClass().getSimpleName());
            if (((Activity) this.f42878c.get(i)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findActivityTop(Class cls) {
        Stack<Activity> stack = this.f42878c;
        if (stack != null && !stack.empty()) {
            Stack<Activity> stack2 = this.f42878c;
            if (((Activity) stack2.get(stack2.size() - 1)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public void init(Application application) {
        m32056a(application);
    }

    public boolean isEmpty() {
        Stack<Activity> stack = this.f42878c;
        return stack == null || stack.empty();
    }

    public void popToRoot() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popToRootActivity();
    }

    /* renamed from: a */
    private void m32056a(Application application) {
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
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

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    CustomerActivityManager.this.m32055a(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    CustomerActivityManager.this.m32058b(activity);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32055a(Activity activity) {
        if (activity != null) {
            this.f42879d.append(activity, true);
            this.f42878c.add(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32058b(Activity activity) {
        if (activity != null) {
            this.f42879d.append(activity, false);
            this.f42878c.remove(activity);
        }
    }
}
