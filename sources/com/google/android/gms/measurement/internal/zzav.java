package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    public final String zza;
    public final zzat zzb;
    public final String zzc;
    public final long zzd;

    zzav(zzav zzav, long j) {
        Preconditions.checkNotNull(zzav);
        this.zza = zzav.zza;
        this.zzb = zzav.zzb;
        this.zzc = zzav.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    public zzav(String str, zzat zzat, String str2, long j) {
        this.zza = str;
        this.zzb = zzat;
        this.zzc = str2;
        this.zzd = j;
    }
}
