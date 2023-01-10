package com.threatmetrix.TrustDefender;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.threatmetrix.TrustDefender.yyyyqy;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class jjjkjj implements LocationListener {
    private static final String b006Foo006F006Fo = yyyyqy.b0074t007400740074t(jjjkjj.class);
    private static final int bo006Fo006F006Fo = 120000;
    @Nullable
    private Location b006F006Fo006F006Fo = null;

    private boolean b0073s0073ssss(@Nullable String str, @Nullable String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private boolean bss0073ssss(@Nonnull Location location, @Nullable Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean b0073s0073ssss = b0073s0073ssss(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        return (z3 && !z4) || (z3 && !z6 && b0073s0073ssss);
    }

    @Nullable
    public Location b00730073sssss() {
        if (this.b006F006Fo006F006Fo != null) {
            return new Location(this.b006F006Fo006F006Fo);
        }
        return null;
    }

    public void onLocationChanged(Location location) {
        if (location == null) {
            yyyyqy.bt0074007400740074t(b006Foo006F006Fo, "location is null, possibly provided by a mock location provider");
            return;
        }
        yyyyqy.bt0074007400740074t(b006Foo006F006Fo, "olc");
        String str = b006Foo006F006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str, "onLocationChanged() : " + location.getProvider() + ":" + location.getLatitude() + ":" + location.getLongitude() + ":" + location.getAccuracy());
        if (bss0073ssss(location, this.b006F006Fo006F006Fo)) {
            this.b006F006Fo006F006Fo = location;
        }
    }

    public void onProviderDisabled(String str) {
        String str2 = b006Foo006F006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str2, "onProviderDisabled: " + str);
    }

    public void onProviderEnabled(String str) {
        String str2 = b006Foo006F006Fo;
        yyyyqy.qyyyqy.bt0074tttt(str2, "onProviderEnabled: " + str);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        String str2 = b006Foo006F006Fo;
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged: ");
        sb.append(str);
        sb.append(" status: ");
        sb.append(i == 2 ? "available " : i == 1 ? "temporarily unavailable" : i == 0 ? "Out of Service" : "unknown");
        yyyyqy.qyyyqy.bt0074tttt(str2, sb.toString());
    }
}
