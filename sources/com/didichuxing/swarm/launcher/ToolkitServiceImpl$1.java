package com.didichuxing.swarm.launcher;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.Map;

class ToolkitServiceImpl$1 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ C17300d this$0;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    ToolkitServiceImpl$1(C17300d dVar) {
        this.this$0 = dVar;
    }

    public void onActivityResumed(Activity activity) {
        Activity unused = this.this$0.f51764a = activity;
        Iterator<Map.Entry<View, ViewGroup.LayoutParams>> it = this.this$0.f51766c.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            activity.addContentView((View) next.getKey(), (ViewGroup.LayoutParams) next.getValue());
        }
    }

    public void onActivityPaused(Activity activity) {
        Iterator<Map.Entry<View, ViewGroup.LayoutParams>> it = this.this$0.f51766c.iterator();
        while (it.hasNext()) {
            View view = (View) it.next().getKey();
            ((ViewGroup) view.getParent()).removeView(view);
        }
        Activity unused = this.this$0.f51764a = null;
    }
}
