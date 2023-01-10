package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgf {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi = new MediaCodec.CryptoInfo();
    private final zzge zzj;

    public zzgf() {
        this.zzj = zzen.zza >= 24 ? new zzge(this.zzi, (zzgd) null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i) {
        if (i != 0) {
            if (this.zzd == null) {
                int[] iArr = new int[1];
                this.zzd = iArr;
                this.zzi.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.zzd;
            iArr2[0] = iArr2[0] + i;
        }
    }

    public final void zzc(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i2;
        this.zzg = i3;
        this.zzh = i4;
        this.zzi.numSubSamples = i;
        this.zzi.numBytesOfClearData = iArr;
        this.zzi.numBytesOfEncryptedData = iArr2;
        this.zzi.key = bArr;
        this.zzi.iv = bArr2;
        this.zzi.mode = i2;
        if (zzen.zza >= 24) {
            zzge zzge = this.zzj;
            if (zzge != null) {
                zzge.zza(zzge, i3, i4);
                return;
            }
            throw null;
        }
    }
}
