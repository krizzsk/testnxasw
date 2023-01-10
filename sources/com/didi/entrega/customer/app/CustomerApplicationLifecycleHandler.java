package com.didi.entrega.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.rpc.Clock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class CustomerApplicationLifecycleHandler {

    /* renamed from: a */
    private static final String f21623a = "CustomerApplicationLifecycleHandler";

    /* renamed from: b */
    private List<ApplicationForegroundListener> f21624b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f21625c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f21626d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f21627e;

    /* renamed from: f */
    private WeakReference<Application> f21628f;

    /* renamed from: g */
    private Application.ActivityLifecycleCallbacks f21629g;

    /* renamed from: h */
    private int f21630h;

    /* renamed from: i */
    private Application.ActivityLifecycleCallbacks f21631i;

    /* renamed from: b */
    static /* synthetic */ int m18083b(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f21625c;
        customerApplicationLifecycleHandler.f21625c = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m18085c(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f21625c;
        customerApplicationLifecycleHandler.f21625c = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m18086d(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f21630h;
        customerApplicationLifecycleHandler.f21630h = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ int m18087e(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f21630h;
        customerApplicationLifecycleHandler.f21630h = i - 1;
        return i;
    }

    private CustomerApplicationLifecycleHandler() {
        this.f21624b = new ArrayList();
        this.f21625c = 0;
        this.f21626d = -1;
        this.f21627e = -1;
        this.f21629g = new Application.ActivityLifecycleCallbacks() {
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
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f21623a).setMessage("ActivityLifecycleCallbacks --> onActivityStarted").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f21625c)).build().info();
                if (CustomerApplicationLifecycleHandler.this.f21625c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f21626d = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m18082a(true);
                }
                CustomerApplicationLifecycleHandler.m18083b(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f21623a).setMessage("ActivityLifecycleCallbacks --> onActivityStopped").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f21625c)).build().info();
                CustomerApplicationLifecycleHandler.m18085c(CustomerApplicationLifecycleHandler.this);
                if (CustomerApplicationLifecycleHandler.this.f21625c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f21627e = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m18082a(false);
                }
            }
        };
        this.f21630h = 0;
        this.f21631i = new Application.ActivityLifecycleCallbacks() {
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
                CustomerApplicationLifecycleHandler.m18086d(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                CustomerApplicationLifecycleHandler.m18087e(CustomerApplicationLifecycleHandler.this);
            }
        };
    }

    public static CustomerApplicationLifecycleHandler getInstance() {
        return Holder.INSTANCE;
    }

    public void clear() {
        synchronized (this.f21624b) {
            this.f21624b.clear();
            this.f21625c = 0;
            this.f21626d = -1;
            this.f21627e = -1;
        }
        WeakReference<Application> weakReference = this.f21628f;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) this.f21628f.get()).unregisterActivityLifecycleCallbacks(this.f21629g);
            this.f21628f.clear();
            this.f21628f = null;
        }
    }

    public void initLifecycle(Application application) {
        this.f21625c = this.f21630h;
        WeakReference<Application> weakReference = new WeakReference<>(application);
        this.f21628f = weakReference;
        ((Application) weakReference.get()).registerActivityLifecycleCallbacks(this.f21629g);
    }

    public void initPreLifecycle(Application application) {
        this.f21630h = 0;
        application.registerActivityLifecycleCallbacks(this.f21631i);
    }

    public void registerForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f21624b) {
            if (applicationForegroundListener != null) {
                if (!this.f21624b.contains(applicationForegroundListener)) {
                    this.f21624b.add(applicationForegroundListener);
                }
            }
        }
    }

    public void unregisterForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f21624b) {
            if (applicationForegroundListener != null) {
                this.f21624b.remove(applicationForegroundListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18082a(boolean z) {
        if (this.f21626d > 0 || this.f21627e > 0) {
            synchronized (this.f21624b) {
                ArrayList<ApplicationForegroundListener> arrayList = new ArrayList<>();
                arrayList.addAll(this.f21624b);
                for (ApplicationForegroundListener applicationForegroundListener : arrayList) {
                    if (applicationForegroundListener != null) {
                        if (z) {
                            applicationForegroundListener.onBecomeForeground(this.f21626d, this.f21627e);
                        } else {
                            applicationForegroundListener.onBecomeBackground(this.f21627e, this.f21626d);
                        }
                    }
                }
            }
        }
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerApplicationLifecycleHandler INSTANCE = new CustomerApplicationLifecycleHandler();

        private Holder() {
        }
    }
}
