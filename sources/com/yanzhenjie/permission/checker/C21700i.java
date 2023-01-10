package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: com.yanzhenjie.permission.checker.i */
/* compiled from: LocationCoarseTest */
class C21700i implements PermissionTest {

    /* renamed from: a */
    private Context f58955a;

    C21700i(Context context) {
        this.f58955a = context;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f58955a.getSystemService("location");
        if (!locationManager.getProviders(true).contains("network") && this.f58955a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !locationManager.isProviderEnabled("network");
        }
        return true;
    }
}
