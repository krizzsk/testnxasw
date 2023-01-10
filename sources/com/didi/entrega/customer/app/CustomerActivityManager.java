package com.didi.entrega.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import java.util.Stack;

public class CustomerActivityManager {

    /* renamed from: a */
    private static final String f21620a = "CustomerActivityManager";

    /* renamed from: b */
    private static CustomerActivityManager f21621b;

    /* renamed from: c */
    private Stack<Activity> f21622c = new Stack<>();

    public static CustomerActivityManager getInstance() {
        if (f21621b == null) {
            synchronized (CustomerActivityManager.class) {
                if (f21621b == null) {
                    f21621b = new CustomerActivityManager();
                }
            }
        }
        return f21621b;
    }

    public boolean findActivityAlive(Class cls) {
        Stack<Activity> stack = this.f21622c;
        if (stack == null || stack.empty()) {
            LogUtil.m18185i(f21620a, "mActivityStacks isEmpty");
            return false;
        }
        for (int i = 0; i < this.f21622c.size(); i++) {
            LogUtil.m18185i(f21620a, "mActivityStacks name =" + ((Activity) this.f21622c.get(i)).getClass().getSimpleName());
            if (((Activity) this.f21622c.get(i)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public boolean findActivityTop(Class cls) {
        Stack<Activity> stack = this.f21622c;
        if (stack != null && !stack.empty()) {
            Stack<Activity> stack2 = this.f21622c;
            if (((Activity) stack2.get(stack2.size() - 1)).getClass().getSimpleName().equals(cls.getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public void init(Application application) {
        m18075a(application);
    }

    public boolean isEmpty() {
        Stack<Activity> stack = this.f21622c;
        return stack == null || stack.empty();
    }

    public void popToRoot() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).popToRootActivity();
    }

    /* renamed from: a */
    private void m18075a(Application application) {
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
                    CustomerActivityManager.this.m18074a(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    CustomerActivityManager.this.m18077b(activity);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18074a(Activity activity) {
        if (activity != null) {
            this.f21622c.add(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18077b(Activity activity) {
        if (activity != null) {
            this.f21622c.remove(activity);
        }
    }
}
