package com.didi.dimina.container.secondparty.permission.source;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public class ContextSource extends Source {

    /* renamed from: a */
    private final Context f19301a;

    public ContextSource(Context context) {
        this.f19301a = context;
    }

    public Context getContext() {
        return this.f19301a;
    }

    public void startActivity(Intent intent) {
        intent.addFlags(268435456);
        this.f19301a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        throw new UnsupportedOperationException("Unsupported operation.");
    }

    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        PackageManager packageManager = this.f19301a.getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class});
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, new Object[]{str})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
