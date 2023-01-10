package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzaq {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final zzat zzf;

    zzaq(zzgi zzgi, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzat zzat;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzgi.zzaz().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzey.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzat = new zzat(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzgi.zzaz().zzd().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzgi.zzv().zzA(str4, bundle2.get(str4));
                    if (zzA == null) {
                        zzgi.zzaz().zzk().zzb("Param value can't be null", zzgi.zzj().zze(str4));
                        it.remove();
                    } else {
                        zzgi.zzv().zzO(bundle2, str4, zzA);
                    }
                }
            }
            zzat = new zzat(bundle2);
        }
        this.zzf = zzat;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String obj = this.zzf.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    /* access modifiers changed from: package-private */
    public final zzaq zza(zzgi zzgi, long j) {
        return new zzaq(zzgi, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    private zzaq(zzgi zzgi, String str, String str2, String str3, long j, long j2, zzat zzat) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzat);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzgi.zzaz().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzey.zzn(str2), zzey.zzn(str3));
        }
        this.zzf = zzat;
    }
}
