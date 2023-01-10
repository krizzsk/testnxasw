package com.didi.payment.base.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class ActivityLauncher {

    /* renamed from: a */
    private static final String f32384a = "ActivityLauncher";

    /* renamed from: b */
    private Context f32385b;

    /* renamed from: c */
    private RouterFragmentV4 f32386c;

    /* renamed from: d */
    private RouterFragment f32387d;

    public interface Callback {
        void onActivityResult(int i, Intent intent);
    }

    public static ActivityLauncher init(Fragment fragment) {
        return init(fragment.getActivity());
    }

    public static ActivityLauncher init(FragmentActivity fragmentActivity) {
        return new ActivityLauncher(fragmentActivity);
    }

    public static ActivityLauncher init(Activity activity) {
        return new ActivityLauncher(activity);
    }

    private ActivityLauncher(FragmentActivity fragmentActivity) {
        this.f32385b = fragmentActivity;
        this.f32386c = m24590a(fragmentActivity);
    }

    private ActivityLauncher(Activity activity) {
        this.f32385b = activity;
        this.f32387d = m24589a(activity);
    }

    /* renamed from: a */
    private RouterFragmentV4 m24590a(FragmentActivity fragmentActivity) {
        RouterFragmentV4 b = m24592b(fragmentActivity);
        if (b != null) {
            return b;
        }
        RouterFragmentV4 newInstance = RouterFragmentV4.newInstance();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add((Fragment) newInstance, f32384a).commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return newInstance;
    }

    /* renamed from: b */
    private RouterFragmentV4 m24592b(FragmentActivity fragmentActivity) {
        return (RouterFragmentV4) fragmentActivity.getSupportFragmentManager().findFragmentByTag(f32384a);
    }

    /* renamed from: a */
    private RouterFragment m24589a(Activity activity) {
        RouterFragment b = m24591b(activity);
        if (b != null) {
            return b;
        }
        RouterFragment newInstance = RouterFragment.newInstance();
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(newInstance, f32384a).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return newInstance;
    }

    /* renamed from: b */
    private RouterFragment m24591b(Activity activity) {
        return (RouterFragment) activity.getFragmentManager().findFragmentByTag(f32384a);
    }

    public void startActivityForResult(Class<?> cls, Callback callback) {
        startActivityForResult(new Intent(this.f32385b, cls), callback);
    }

    public void startActivityForResult(Intent intent, Callback callback) {
        RouterFragmentV4 routerFragmentV4 = this.f32386c;
        if (routerFragmentV4 != null) {
            routerFragmentV4.startActivityForResult(intent, callback);
            return;
        }
        RouterFragment routerFragment = this.f32387d;
        if (routerFragment != null) {
            routerFragment.startActivityForResult(intent, callback);
            return;
        }
        throw new RuntimeException("please do init first!");
    }
}
