package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.c */
/* compiled from: LocationFineTest */
class C8197c implements PermissionTest {

    /* renamed from: a */
    private final Context f19240a;

    C8197c(Context context) {
        this.f19240a = context;
    }

    /* renamed from: a */
    public boolean mo60862a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f19240a.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        boolean contains = providers.contains("gps");
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f19240a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !locationManager.isProviderEnabled("gps");
    }
}
