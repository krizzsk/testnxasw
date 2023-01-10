package com.google.p223ar.core;

import android.app.Activity;
import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.p223ar.core.ArCoreApk;
import com.google.p223ar.core.Session;
import com.google.p223ar.core.exceptions.ResourceExhaustedException;
import com.google.p223ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p223ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ar.core.ArCoreApkJniAdapter */
class ArCoreApkJniAdapter {

    /* renamed from: a */
    private static final Map<Class<? extends Throwable>, Integer> f56377a;

    ArCoreApkJniAdapter() {
    }

    static int checkAvailability(Context context) {
        try {
            return ArCoreApk.getInstance().checkAvailability(context).nativeCode;
        } catch (Throwable th) {
            m42626a(th);
            return ArCoreApk.Availability.UNKNOWN_ERROR.nativeCode;
        }
    }

    static int requestInstall(Activity activity, boolean z, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z).nativeCode;
            return Session.C20250a.SUCCESS.f56416j;
        } catch (Throwable th) {
            return m42626a(th);
        }
    }

    static int requestInstallCustom(Activity activity, boolean z, int i, int i2, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z, ArCoreApk.InstallBehavior.forNumber(i), ArCoreApk.UserMessageType.forNumber(i2)).nativeCode;
            return Session.C20250a.SUCCESS.f56416j;
        } catch (Throwable th) {
            return m42626a(th);
        }
    }

    /* renamed from: a */
    private static int m42626a(Throwable th) {
        SystemUtils.log(6, "ARCore-ArCoreApkJniAdapter", "Exception details:", th, "com.google.ar.core.ArCoreApkJniAdapter", 20);
        Class<?> cls = th.getClass();
        if (f56377a.containsKey(cls)) {
            return f56377a.get(cls).intValue();
        }
        return Session.C20250a.ERROR_FATAL.f56416j;
    }

    static {
        HashMap hashMap = new HashMap();
        f56377a = hashMap;
        hashMap.put(IllegalArgumentException.class, Integer.valueOf(Session.C20250a.ERROR_INVALID_ARGUMENT.f56416j));
        f56377a.put(ResourceExhaustedException.class, Integer.valueOf(Session.C20250a.ERROR_RESOURCE_EXHAUSTED.f56416j));
        f56377a.put(UnavailableArcoreNotInstalledException.class, Integer.valueOf(Session.C20250a.UNAVAILABLE_ARCORE_NOT_INSTALLED.f56416j));
        f56377a.put(UnavailableDeviceNotCompatibleException.class, Integer.valueOf(Session.C20250a.UNAVAILABLE_DEVICE_NOT_COMPATIBLE.f56416j));
        f56377a.put(UnavailableApkTooOldException.class, Integer.valueOf(Session.C20250a.UNAVAILABLE_APK_TOO_OLD.f56416j));
        f56377a.put(UnavailableSdkTooOldException.class, Integer.valueOf(Session.C20250a.UNAVAILABLE_SDK_TOO_OLD.f56416j));
        f56377a.put(UnavailableUserDeclinedInstallationException.class, Integer.valueOf(Session.C20250a.UNAVAILABLE_USER_DECLINED_INSTALLATION.f56416j));
    }
}
