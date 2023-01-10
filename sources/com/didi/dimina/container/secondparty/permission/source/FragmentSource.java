package com.didi.dimina.container.secondparty.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class FragmentSource extends Source {

    /* renamed from: a */
    private final Fragment f19302a;

    public FragmentSource(Fragment fragment) {
        this.f19302a = fragment;
    }

    public Context getContext() {
        return this.f19302a.getActivity();
    }

    public void startActivity(Intent intent) {
        this.f19302a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f19302a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f19302a.shouldShowRequestPermissionRationale(str);
    }
}
