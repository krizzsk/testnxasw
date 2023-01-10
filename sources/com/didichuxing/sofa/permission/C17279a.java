package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

/* renamed from: com.didichuxing.sofa.permission.a */
/* compiled from: ActivityPermissionRequest */
class C17279a extends PermissionRequest<Activity> {
    C17279a(Activity activity, String[] strArr, int i) {
        super(activity, strArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo127673a(Activity activity, String[] strArr) {
        return C17283e.m38883a(activity, strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127672a(Activity activity, String[] strArr, int i) {
        if (C17284f.m38890a(strArr[0])) {
            C17284f.m38887a(activity, strArr[0], i);
        } else {
            ActivityCompat.requestPermissions(activity, strArr, i);
        }
    }
}
