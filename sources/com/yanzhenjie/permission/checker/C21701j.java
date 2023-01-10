package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.checker.j */
/* compiled from: LocationFineTest */
class C21701j implements PermissionTest {

    /* renamed from: a */
    private Context f58956a;

    C21701j(Context context) {
        this.f58956a = context;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f58956a.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        boolean contains = providers.contains("gps");
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f58956a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !locationManager.isProviderEnabled("gps");
    }
}
