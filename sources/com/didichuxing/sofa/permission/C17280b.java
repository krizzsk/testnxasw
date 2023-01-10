package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* renamed from: com.didichuxing.sofa.permission.b */
/* compiled from: FragmentPermissionRequest */
class C17280b extends PermissionRequest<Fragment> {
    C17280b(Fragment fragment, String[] strArr, int i) {
        super(fragment, strArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo127673a(Fragment fragment, String[] strArr) {
        return C17283e.m38883a((Activity) fragment.getActivity(), strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127672a(Fragment fragment, String[] strArr, int i) {
        if (C17284f.m38890a(strArr[0])) {
            C17284f.m38888a(fragment, strArr[0], i);
        } else {
            fragment.requestPermissions(strArr, i);
        }
    }
}
