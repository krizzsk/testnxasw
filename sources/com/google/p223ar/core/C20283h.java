package com.google.p223ar.core;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.google.p223ar.core.ArCoreApk;
import com.google.p223ar.core.exceptions.FatalException;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;

/* renamed from: com.google.ar.core.h */
/* compiled from: ArCoreApkImpl */
final class C20283h extends ArCoreApk {

    /* renamed from: b */
    private static final C20283h f56467b = new C20283h();

    /* renamed from: a */
    Exception f56468a;

    /* renamed from: c */
    private boolean f56469c;

    /* renamed from: d */
    private int f56470d;

    /* renamed from: e */
    private long f56471e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArCoreApk.Availability f56472f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f56473g;

    /* renamed from: h */
    private C20291p f56474h;

    /* renamed from: i */
    private boolean f56475i;

    /* renamed from: j */
    private boolean f56476j;

    /* renamed from: k */
    private int f56477k;

    C20283h() {
    }

    /* renamed from: a */
    public static C20283h m42667a() {
        return f56467b;
    }

    public final ArCoreApk.Availability checkAvailability(Context context) {
        if (!m42669c()) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        }
        try {
            if (mo164850b(context)) {
                mo164849b();
                return C20264aj.m42662a(context);
            }
            synchronized (this) {
                if ((this.f56472f == null || this.f56472f.isUnknown()) && !this.f56473g) {
                    this.f56473g = true;
                    C20264aj ajVar = new C20264aj(this);
                    if (mo164850b(context)) {
                        ajVar.mo164600a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                    } else if (m42671d(context) != -1) {
                        ajVar.mo164600a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                    } else if (m42670c(context)) {
                        ajVar.mo164600a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                    } else {
                        mo164848a(context).mo164858a(context, (ArCoreApk.C20243a) ajVar);
                    }
                }
                if (this.f56472f != null) {
                    ArCoreApk.Availability availability = this.f56472f;
                    return availability;
                } else if (this.f56473g) {
                    ArCoreApk.Availability availability2 = ArCoreApk.Availability.UNKNOWN_CHECKING;
                    return availability2;
                } else {
                    SystemUtils.log(6, "ARCore-ArCoreApk", "request not running but result is null?", (Throwable) null, "com.google.ar.core.h", 32);
                    ArCoreApk.Availability availability3 = ArCoreApk.Availability.UNKNOWN_ERROR;
                    return availability3;
                }
            }
        } catch (FatalException e) {
            SystemUtils.log(6, "ARCore-ArCoreApk", "Error while checking app details and ARCore status", e, "com.google.ar.core.h", 10);
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z, ArCoreApk.InstallBehavior installBehavior, ArCoreApk.UserMessageType userMessageType) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        if (!m42669c()) {
            throw new UnavailableDeviceNotCompatibleException();
        } else if (mo164850b(activity)) {
            mo164849b();
            return m42666a(activity);
        } else if (this.f56469c) {
            return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
        } else {
            Exception exc = this.f56468a;
            if (exc != null) {
                if (z) {
                    SystemUtils.log(5, "ARCore-ArCoreApk", "Clearing previous failure: ", exc, "com.google.ar.core.h", 44);
                    this.f56468a = null;
                } else if (exc instanceof UnavailableDeviceNotCompatibleException) {
                    throw ((UnavailableDeviceNotCompatibleException) exc);
                } else if (exc instanceof UnavailableUserDeclinedInstallationException) {
                    throw ((UnavailableUserDeclinedInstallationException) exc);
                } else if (exc instanceof RuntimeException) {
                    throw ((RuntimeException) exc);
                } else {
                    throw new RuntimeException("Unexpected exception type", this.f56468a);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f56471e > 5000) {
                this.f56470d = 0;
            }
            int i = this.f56470d + 1;
            this.f56470d = i;
            this.f56471e = uptimeMillis;
            if (i <= 2) {
                try {
                    activity.startActivity(new Intent(activity, InstallActivity.class).putExtra("message", userMessageType).putExtra("behavior", installBehavior));
                    this.f56469c = true;
                    return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
                } catch (ActivityNotFoundException e) {
                    throw new FatalException("Failed to launch InstallActivity", e);
                }
            } else {
                throw new FatalException("Requesting ARCore installation too rapidly.");
            }
        }
    }

    public final ArCoreApk.InstallStatus requestInstall(Activity activity, boolean z) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        ArCoreApk.UserMessageType userMessageType;
        ArCoreApk.InstallBehavior installBehavior = m42670c(activity) ? ArCoreApk.InstallBehavior.REQUIRED : ArCoreApk.InstallBehavior.OPTIONAL;
        if (m42670c(activity)) {
            userMessageType = ArCoreApk.UserMessageType.APPLICATION;
        } else {
            userMessageType = ArCoreApk.UserMessageType.USER_ALREADY_INFORMED;
        }
        return requestInstall(activity, z, installBehavior, userMessageType);
    }

    /* renamed from: a */
    private static ArCoreApk.InstallStatus m42666a(Activity activity) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        PendingIntent b = C20264aj.m42663b(activity);
        if (b != null) {
            try {
                SystemUtils.log(4, "ARCore-ArCoreApk", "Starting setup activity", (Throwable) null, "com.google.ar.core.h", 77);
                activity.startIntentSender(b.getIntentSender(), (Intent) null, 0, 0, 0);
                return ArCoreApk.InstallStatus.INSTALL_REQUESTED;
            } catch (IntentSender.SendIntentException | RuntimeException e) {
                SystemUtils.log(5, "ARCore-ArCoreApk", "Setup activity launch failed", e, "com.google.ar.core.h", 81);
            }
        }
        return ArCoreApk.InstallStatus.INSTALLED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C20291p mo164848a(Context context) {
        if (this.f56474h == null) {
            C20291p pVar = new C20291p((byte) 0);
            pVar.mo164857a(context.getApplicationContext());
            this.f56474h = pVar;
        }
        return this.f56474h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo164849b() {
        if (this.f56468a == null) {
            this.f56470d = 0;
        }
        this.f56469c = false;
        if (this.f56474h != null) {
            this.f56474h.mo164855a();
            this.f56474h = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo164850b(Context context) {
        m42672e(context);
        return m42671d(context) == 0 || m42671d(context) >= this.f56477k;
    }

    /* renamed from: c */
    private final boolean m42670c(Context context) {
        m42672e(context);
        return this.f56476j;
    }

    /* renamed from: c */
    private static boolean m42669c() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: d */
    private static int m42671d(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), "com.google.ar.core", 4);
            int i = packageInfo.versionCode;
            if (i == 0 && (packageInfo.services == null || packageInfo.services.length == 0)) {
                return -1;
            }
            return i;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* renamed from: e */
    private final synchronized void m42672e(Context context) {
        if (!this.f56475i) {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                Bundle bundle = SystemUtils.getApplicationInfo(packageManager, packageName, 128).metaData;
                if (bundle.containsKey("com.google.ar.core")) {
                    this.f56476j = bundle.getString("com.google.ar.core").equals("required");
                    if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                        this.f56477k = bundle.getInt("com.google.ar.core.min_apk_version");
                        ActivityInfo[] activityInfoArr = SystemUtils.getPackageInfo(packageManager, packageName, 1).activities;
                        String canonicalName = InstallActivity.class.getCanonicalName();
                        int length = activityInfoArr.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            String valueOf = String.valueOf(canonicalName);
                            throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                        } else {
                            this.f56475i = true;
                        }
                    } else {
                        throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                    }
                } else {
                    throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new FatalException("Could not load application package metadata", e);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new FatalException("Could not load application package info", e2);
            }
        }
    }
}
