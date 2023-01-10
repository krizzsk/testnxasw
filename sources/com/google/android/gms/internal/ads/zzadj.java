package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzadj extends zzadd {
    public static final Parcelable.Creator<zzadj> CREATOR = new zzadi();
    public final String zza;
    public final byte[] zzb;

    zzadj(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i = zzen.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzen.zzH(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadj zzadj = (zzadj) obj;
            return zzen.zzT(this.zza, zzadj.zza) && Arrays.equals(this.zzb, zzadj.zzb);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.zzb);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        return str + ": owner=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzadj(String str, byte[] bArr) {
        super("PRIV");
        this.zza = str;
        this.zzb = bArr;
    }
}
