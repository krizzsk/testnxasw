package com.yanzhenjie.permission.source;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class FragmentSource extends Source {

    /* renamed from: a */
    private Fragment f59023a;

    public FragmentSource(Fragment fragment) {
        this.f59023a = fragment;
    }

    public Context getContext() {
        return this.f59023a.getActivity();
    }

    public void startActivity(Intent intent) {
        this.f59023a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f59023a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f59023a.shouldShowRequestPermissionRationale(str);
    }
}
