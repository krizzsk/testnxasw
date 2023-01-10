package com.google.android.gms.internal.measurement;

import com.didi.sdk.apm.SystemUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzht extends zzhy {
    zzht(zzhv zzhv, String str, Double d, boolean z) {
        super(zzhv, "measurement.test.double_flag", d, true, (zzhx) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            SystemUtils.log(6, "PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj), (Throwable) null, "com.google.android.gms.internal.measurement.zzht", 2);
            return null;
        }
    }
}
