package xcrash;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

class ActivityMonitor$1 implements Application.ActivityLifecycleCallbacks {
    private int activityReferences = 0;
    private boolean isActivityChangingConfigurations = false;
    final /* synthetic */ C3715a this$0;

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    ActivityMonitor$1(C3715a aVar) {
        this.this$0 = aVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.this$0.f8905b.addFirst(activity);
        if (this.this$0.f8905b.size() > 100) {
            this.this$0.f8905b.removeLast();
        }
    }

    public void onActivityStarted(Activity activity) {
        int i = this.activityReferences + 1;
        this.activityReferences = i;
        if (i == 1 && !this.isActivityChangingConfigurations) {
            boolean unused = this.this$0.f8906c = true;
        }
    }

    public void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.isActivityChangingConfigurations = isChangingConfigurations;
        int i = this.activityReferences - 1;
        this.activityReferences = i;
        if (i == 0 && !isChangingConfigurations) {
            boolean unused = this.this$0.f8906c = false;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.this$0.f8905b.remove(activity);
    }
}
