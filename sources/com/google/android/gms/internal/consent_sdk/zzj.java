package com.google.android.gms.internal.consent_sdk;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.ump.FormError;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzj extends Exception {
    private final int zza;

    public zzj(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final FormError zza() {
        if (getCause() == null) {
            SystemUtils.log(5, "UserMessagingPlatform", getMessage(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzj", 3);
        } else {
            SystemUtils.log(5, "UserMessagingPlatform", getMessage(), getCause(), "com.google.android.gms.internal.consent_sdk.zzj", 5);
        }
        return new FormError(this.zza, getMessage());
    }

    public zzj(int i, String str, Throwable th) {
        super(str, th);
        this.zza = i;
    }
}
