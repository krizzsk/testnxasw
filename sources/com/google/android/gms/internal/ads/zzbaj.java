package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbaj {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzbaj() {
    }

    public zzbaj(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzd = i;
    }

    public final int zza(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        int i4 = i >> 3;
        boolean z = false;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.zzc;
            if (i6 != 0) {
                byte[] bArr = this.zza;
                int i7 = this.zzb;
                b2 = ((bArr[i7 + 1] & 255) >>> (8 - i6)) | ((bArr[i7] & 255) << i6);
            } else {
                b2 = this.zza[this.zzb];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzb++;
        }
        if (i > 0) {
            int i8 = this.zzc + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (i8 > 8) {
                byte[] bArr2 = this.zza;
                int i9 = this.zzb;
                int i10 = i9 + 1;
                b = (b4 & (((255 & bArr2[i10]) >> (16 - i8)) | ((bArr2[i9] & 255) << (i8 - 8)))) | b3;
                this.zzb = i10;
            } else {
                byte[] bArr3 = this.zza;
                int i11 = this.zzb;
                b = (b4 & ((255 & bArr3[i11]) >> (8 - i8))) | b3;
                if (i8 == 8) {
                    this.zzb = i11 + 1;
                }
            }
            b3 = b;
            this.zzc = i8 % 8;
        }
        int i12 = this.zzb;
        if (i12 >= 0 && (i2 = this.zzc) >= 0 && (i12 < (i3 = this.zzd) || (i12 == i3 && i2 == 0))) {
            z = true;
        }
        zzbac.zze(z);
        return b3;
    }
}
