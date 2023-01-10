package com.threatmetrix.TrustDefender;

import android.telephony.TelephonyManager;
import javax.annotation.Nonnull;

public class kkkjjj {
    private kkkjjj() {
    }

    public static String b0073ssssss(@Nonnull TelephonyManager telephonyManager, int i) throws SecurityException, Exception {
        String imei = i < 0 ? telephonyManager.getImei() : telephonyManager.getImei(i);
        return imei == null ? i < 0 ? telephonyManager.getMeid() : telephonyManager.getMeid(i) : imei;
    }

    public static int bs0073sssss(@Nonnull TelephonyManager telephonyManager, int i) throws SecurityException, Exception {
        return telephonyManager.getSimState(i);
    }
}
