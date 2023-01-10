package com.didi.app.nova.skeleton.conductor.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.conductor.Router;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifecycleHandler extends Fragment implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static final String f10239a = "LifecycleHandler";

    /* renamed from: b */
    private static final Map<Activity, LifecycleHandler> f10240b = new HashMap();

    /* renamed from: c */
    private FragmentLifecycleHandler f10241c = new FragmentLifecycleHandler(this);

    public void onActivityCreated(Activity activity, Bundle bundle) {
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

    /* renamed from: a */
    private static LifecycleHandler m8986a(FragmentActivity fragmentActivity) {
        LifecycleHandler lifecycleHandler = f10240b.get(fragmentActivity);
        if (lifecycleHandler == null) {
            lifecycleHandler = (LifecycleHandler) fragmentActivity.getSupportFragmentManager().findFragmentByTag(f10239a);
        }
        if (lifecycleHandler != null) {
            lifecycleHandler.m8987a((Activity) fragmentActivity);
        }
        return lifecycleHandler;
    }

    public static LifecycleHandler install(FragmentActivity fragmentActivity) {
        LifecycleHandler a = m8986a(fragmentActivity);
        if (a != null) {
            return a;
        }
        LifecycleHandler lifecycleHandler = new LifecycleHandler();
        lifecycleHandler.m8987a((Activity) fragmentActivity);
        fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) lifecycleHandler, f10239a).commitAllowingStateLoss();
        return lifecycleHandler;
    }

    public Router getRouter(ViewGroup viewGroup, Bundle bundle) {
        return this.f10241c.getRouter(viewGroup, bundle);
    }

    public List<Router> getRouters() {
        return this.f10241c.getRouters();
    }

    public Activity getLifecycleActivity() {
        return this.f10241c.getLifecycleActivity();
    }

    /* renamed from: a */
    private void m8987a(Activity activity) {
        FragmentLifecycleHandler fragmentLifecycleHandler = this.f10241c;
        if (fragmentLifecycleHandler != null && fragmentLifecycleHandler.registerActivityListener(activity)) {
            f10240b.put(activity, this);
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10241c.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10241c.onCreate(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f10241c.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        if (getLifecycleActivity() != null) {
            getLifecycleActivity().getApplication().unregisterActivityLifecycleCallbacks(this);
            f10240b.remove(getLifecycleActivity());
        }
        this.f10241c.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        this.f10241c.onDetach();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f10241c.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f10241c.onRequestPermissionsResult(i, strArr, iArr);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.f10241c.shouldShowRequestPermissionRationale(str);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10241c.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10241c.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f10241c.onOptionsItemSelected(menuItem);
    }

    public void onActivityDestroyed(Activity activity) {
        f10240b.remove(activity);
    }
}
