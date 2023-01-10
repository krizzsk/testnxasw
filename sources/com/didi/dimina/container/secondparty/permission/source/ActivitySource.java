package com.didi.dimina.container.secondparty.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class ActivitySource extends Source {

    /* renamed from: a */
    private final Activity f19300a;

    public ActivitySource(Activity activity) {
        this.f19300a = activity;
    }

    public Context getContext() {
        return this.f19300a;
    }

    public void startActivity(Intent intent) {
        Activity activity = this.f19300a;
        if (activity != null && !activity.isFinishing()) {
            this.f19300a.startActivity(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Activity activity = this.f19300a;
        if (activity != null && !activity.isFinishing()) {
            this.f19300a.startActivityForResult(intent, i);
        }
    }

    public boolean isShowRationalePermission(String str) {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 23 && (activity = this.f19300a) != null && !activity.isFinishing()) {
            return this.f19300a.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
