package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.b */
/* compiled from: LocationCoarseTest */
class C8196b implements PermissionTest {

    /* renamed from: a */
    private final Context f19239a;

    C8196b(Context context) {
        this.f19239a = context;
    }

    /* renamed from: a */
    public boolean mo60862a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f19239a.getSystemService("location");
        if (!locationManager.getProviders(true).contains("network") && this.f19239a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !locationManager.isProviderEnabled("network");
        }
        return true;
    }
}
