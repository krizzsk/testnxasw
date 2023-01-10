package com.yanzhenjie.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class ActivitySource extends Source {

    /* renamed from: a */
    private Activity f59021a;

    public ActivitySource(Activity activity) {
        this.f59021a = activity;
    }

    public Context getContext() {
        return this.f59021a;
    }

    public void startActivity(Intent intent) {
        this.f59021a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f59021a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return this.f59021a.shouldShowRequestPermissionRationale(str);
    }
}
