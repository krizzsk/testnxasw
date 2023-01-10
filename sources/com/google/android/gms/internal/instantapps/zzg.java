package com.google.android.gms.internal.instantapps;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.instantapps.ActivityCompat;

public final class zzg implements ActivityCompat {
    private final Activity zzac;

    public zzg(Activity activity) {
        this.zzac = activity;
    }

    public final String getCallingPackage() {
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            return callingActivity.getPackageName();
        }
        return null;
    }

    public final ComponentName getCallingActivity() {
        zzah zzb;
        ComponentName callingActivity = this.zzac.getCallingActivity();
        if (!(callingActivity == null || callingActivity.getPackageName() == null || !callingActivity.getPackageName().equals("com.google.android.instantapps.supervisor") || (zzb = zzah.zzb((Context) this.zzac)) == null)) {
            try {
                ComponentName zzc = zzb.zzc(callingActivity.getClassName());
                if (zzc != null) {
                    return zzc;
                }
            } catch (RemoteException e) {
                SystemUtils.log(6, "IAActivityCompat", "Error getting calling activity", e, "com.google.android.gms.internal.instantapps.zzg", 21);
            }
        }
        return callingActivity;
    }
}
