package com.google.android.gms.internal.measurement;

import com.didi.sdk.apm.SystemUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzhr extends zzhy {
    zzhr(zzhv zzhv, String str, Long l, boolean z) {
        super(zzhv, str, l, true, (zzhx) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            SystemUtils.log(6, "PhenotypeFlag", "Invalid long value for " + zzc + ": " + ((String) obj), (Throwable) null, "com.google.android.gms.internal.measurement.zzhr", 2);
            return null;
        }
    }
}
