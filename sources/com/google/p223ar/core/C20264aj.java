package com.google.p223ar.core;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.p223ar.core.ArCoreApk;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.aj */
/* compiled from: SetupContentResolver */
class C20264aj implements ArCoreApk.C20243a {

    /* renamed from: a */
    final /* synthetic */ C20283h f56440a;

    /* renamed from: a */
    static ArCoreApk.Availability m42662a(Context context) {
        try {
            if (m42663b(context) != null) {
                return ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD;
            }
            return ArCoreApk.Availability.SUPPORTED_INSTALLED;
        } catch (UnavailableDeviceNotCompatibleException unused) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        } catch (UnavailableUserDeclinedInstallationException | RuntimeException unused2) {
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    /* renamed from: b */
    static PendingIntent m42663b(Context context) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        RuntimeException runtimeException;
        try {
            Bundle call = context.getContentResolver().call(m42661a(""), "getSetupIntent", context.getPackageName(), (Bundle) null);
            if (call == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) call.getParcelable("intent");
            if (pendingIntent != null) {
                return pendingIntent;
            }
            String string = call.getString("exceptionType", "");
            if (string.isEmpty()) {
                return null;
            }
            if (string.equals(UnavailableDeviceNotCompatibleException.class.getName())) {
                throw new UnavailableDeviceNotCompatibleException();
            } else if (!string.equals(UnavailableUserDeclinedInstallationException.class.getName())) {
                Class<? extends U> asSubclass = Class.forName(string).asSubclass(RuntimeException.class);
                String string2 = call.getString("exceptionText", (String) null);
                if (string2 != null) {
                    runtimeException = (RuntimeException) asSubclass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{string2});
                } else {
                    runtimeException = (RuntimeException) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                throw runtimeException;
            } else {
                throw new UnavailableUserDeclinedInstallationException();
            }
        } catch (ReflectiveOperationException | RuntimeException e) {
            SystemUtils.log(4, "ARCore-SetupContentResolver", "Post-install failed", e, "com.google.ar.core.aj", 36);
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m42661a(String str) {
        return new Uri.Builder().scheme("content").authority("com.google.ar.core.services.arcorecontentprovider").path(str).build();
    }

    C20264aj(C20283h hVar) {
        this.f56440a = hVar;
    }

    /* renamed from: a */
    public void mo164600a(ArCoreApk.Availability availability) {
        synchronized (this.f56440a) {
            ArCoreApk.Availability unused = this.f56440a.f56472f = availability;
            boolean unused2 = this.f56440a.f56473g = false;
        }
    }
}
