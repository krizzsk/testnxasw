package com.didi.permission;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import androidx.core.content.ContextCompat;

public class PermissionManagerByFragment {

    /* renamed from: a */
    private static String f35791a = PermissionManagerByFragment.class.getSimpleName();

    /* renamed from: a */
    private static OnPermissionFragment m26942a(Activity activity) {
        OnPermissionFragment b = m26944b(activity);
        if (b != null) {
            return b;
        }
        OnPermissionFragment onPermissionFragment = new OnPermissionFragment();
        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(onPermissionFragment, f35791a).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return onPermissionFragment;
    }

    /* renamed from: b */
    private static OnPermissionFragment m26944b(Activity activity) {
        return (OnPermissionFragment) activity.getFragmentManager().findFragmentByTag(f35791a);
    }

    /* renamed from: a */
    private static boolean m26943a(Activity activity, String[] strArr) {
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(activity, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    protected static void permissionRequest(Activity activity, int i, OnPermissionCallback onPermissionCallback) {
        permissionRequest(activity, i, (String[]) PermissionSparseArray.getInstance().get(i), onPermissionCallback);
    }

    protected static void permissionRequest(Activity activity, int i, String[] strArr, OnPermissionCallback onPermissionCallback) {
        if (activity != null) {
            if (m26943a(activity, strArr) || Build.VERSION.SDK_INT < 23) {
                onPermissionCallback.onPermissionGranted(i);
            } else {
                m26942a(activity).permissionRequest(i, strArr, onPermissionCallback);
            }
        }
    }
}
