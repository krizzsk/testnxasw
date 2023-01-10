package com.didi.permission;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.ActivityCompat;

public class OnPermissionFragment extends Fragment {

    /* renamed from: a */
    private SparseArray<OnPermissionCallback> f35790a = new SparseArray<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    /* access modifiers changed from: protected */
    public void permissionRequest(int i, String[] strArr, OnPermissionCallback onPermissionCallback) {
        this.f35790a.put(i, onPermissionCallback);
        requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        super.onRequestPermissionsResult(i, strArr, iArr);
        OnPermissionCallback a = m26940a(i);
        if (a != null) {
            boolean z = false;
            int i2 = 0;
            boolean z2 = true;
            while (true) {
                if (i2 >= iArr.length) {
                    str = "";
                    break;
                }
                z2 = iArr[i2] == 0;
                if (!z2) {
                    str = strArr[i2];
                    break;
                }
                i2++;
            }
            if (z2) {
                a.onPermissionGranted(i);
                return;
            }
            if (m26941a(getActivity(), strArr) == null) {
                z = true;
            }
            a.onPermissionDenied(str, i, z);
        }
    }

    /* renamed from: a */
    private static String m26941a(Activity activity, String[] strArr) {
        if (activity == null) {
            return null;
        }
        for (String str : strArr) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    private OnPermissionCallback m26940a(int i) {
        OnPermissionCallback onPermissionCallback = this.f35790a.get(i);
        this.f35790a.remove(i);
        return onPermissionCallback;
    }
}
