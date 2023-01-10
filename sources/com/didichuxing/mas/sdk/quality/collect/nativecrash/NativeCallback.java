package com.didichuxing.mas.sdk.quality.collect.nativecrash;

import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class NativeCallback {

    /* renamed from: a */
    private static boolean f50719a = false;

    public static void nativeCrashed() {
        OLog.m37863i("native crashed!");
        if (!f50719a) {
            f50719a = true;
        }
    }

    public static void makeNativeCrashReport(String str, String str2, int i) {
        OLog.m37863i("receive native crash signal!");
        OmegaSDKAdapter.trackMasEvent("omega_native_signal", (String) null, (Map<String, Object>) null);
    }

    public static void nativeCrashedMakePoint() {
        OLog.m37863i("receiver native crash signal!!");
        OmegaSDKAdapter.trackMasEvent("omg_native_signal", (String) null, (Map<String, Object>) null);
    }
}
