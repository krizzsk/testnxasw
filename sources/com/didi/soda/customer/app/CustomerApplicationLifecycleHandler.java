package com.didi.soda.customer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.Clock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class CustomerApplicationLifecycleHandler {

    /* renamed from: a */
    private static final String f42880a = "CustomerApplicationLifecycleHandler";

    /* renamed from: b */
    private List<ApplicationForegroundListener> f42881b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f42882c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public long f42883d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f42884e;

    /* renamed from: f */
    private WeakReference<Application> f42885f;

    /* renamed from: g */
    private Application.ActivityLifecycleCallbacks f42886g;

    /* renamed from: h */
    private int f42887h;

    /* renamed from: i */
    private Application.ActivityLifecycleCallbacks f42888i;

    /* renamed from: b */
    static /* synthetic */ int m32064b(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f42882c;
        customerApplicationLifecycleHandler.f42882c = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m32066c(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f42882c;
        customerApplicationLifecycleHandler.f42882c = i - 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m32067d(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f42887h;
        customerApplicationLifecycleHandler.f42887h = i + 1;
        return i;
    }

    /* renamed from: e */
    static /* synthetic */ int m32068e(CustomerApplicationLifecycleHandler customerApplicationLifecycleHandler) {
        int i = customerApplicationLifecycleHandler.f42887h;
        customerApplicationLifecycleHandler.f42887h = i - 1;
        return i;
    }

    private CustomerApplicationLifecycleHandler() {
        this.f42881b = new ArrayList();
        this.f42882c = 0;
        this.f42883d = -1;
        this.f42884e = -1;
        this.f42886g = new Application.ActivityLifecycleCallbacks() {
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
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f42880a).setMessage("ActivityLifecycleCallbacks --> onActivityStarted").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f42882c)).build().info();
                if (CustomerApplicationLifecycleHandler.this.f42882c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f42883d = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m32063a(true);
                }
                CustomerApplicationLifecycleHandler.m32064b(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                RecordTracker.Builder.create().setTag(CustomerApplicationLifecycleHandler.f42880a).setMessage("ActivityLifecycleCallbacks --> onActivityStopped").setOtherParam("mActivityName", activity.getClass().getSimpleName()).setOtherParam("mActivity", String.valueOf(activity)).setOtherParam("mForegroundActNum", Integer.valueOf(CustomerApplicationLifecycleHandler.this.f42882c)).build().info();
                CustomerApplicationLifecycleHandler.m32066c(CustomerApplicationLifecycleHandler.this);
                if (CustomerApplicationLifecycleHandler.this.f42882c <= 0) {
                    long unused = CustomerApplicationLifecycleHandler.this.f42884e = Clock.timeAtSeconds();
                    CustomerApplicationLifecycleHandler.this.m32063a(false);
                }
            }
        };
        this.f42887h = 0;
        this.f42888i = new Application.ActivityLifecycleCallbacks() {
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
                CustomerApplicationLifecycleHandler.m32067d(CustomerApplicationLifecycleHandler.this);
            }

            public void onActivityStopped(Activity activity) {
                CustomerApplicationLifecycleHandler.m32068e(CustomerApplicationLifecycleHandler.this);
            }
        };
    }

    public static CustomerApplicationLifecycleHandler getInstance() {
        return Holder.INSTANCE;
    }

    public void clear() {
        synchronized (this.f42881b) {
            this.f42881b.clear();
            this.f42882c = 0;
            this.f42883d = -1;
            this.f42884e = -1;
        }
        WeakReference<Application> weakReference = this.f42885f;
        if (weakReference != null && weakReference.get() != null) {
            ((Application) this.f42885f.get()).unregisterActivityLifecycleCallbacks(this.f42886g);
            this.f42885f.clear();
            this.f42885f = null;
        }
    }

    public void initLifecycle(Application application) {
        this.f42882c = this.f42887h;
        WeakReference<Application> weakReference = new WeakReference<>(application);
        this.f42885f = weakReference;
        ((Application) weakReference.get()).registerActivityLifecycleCallbacks(this.f42886g);
    }

    public void initPreLifecycle(Application application) {
        this.f42887h = 0;
        application.registerActivityLifecycleCallbacks(this.f42888i);
    }

    public void registerForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f42881b) {
            if (applicationForegroundListener != null) {
                if (!this.f42881b.contains(applicationForegroundListener)) {
                    this.f42881b.add(applicationForegroundListener);
                }
            }
        }
    }

    public void unregisterForegroundListener(ApplicationForegroundListener applicationForegroundListener) {
        synchronized (this.f42881b) {
            if (applicationForegroundListener != null) {
                this.f42881b.remove(applicationForegroundListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32063a(boolean z) {
        if (this.f42883d > 0 || this.f42884e > 0) {
            synchronized (this.f42881b) {
                ArrayList<ApplicationForegroundListener> arrayList = new ArrayList<>();
                arrayList.addAll(this.f42881b);
                for (ApplicationForegroundListener applicationForegroundListener : arrayList) {
                    if (applicationForegroundListener != null) {
                        if (z) {
                            applicationForegroundListener.onBecomeForeground(this.f42883d, this.f42884e);
                        } else {
                            applicationForegroundListener.onBecomeBackground(this.f42884e, this.f42883d);
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
