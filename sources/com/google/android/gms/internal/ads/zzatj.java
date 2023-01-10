package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzatj {
    public static final zzatj zza = new zzatj(new int[]{2}, 2);
    private final int[] zzb;
    private final int zzc = 2;

    zzatj(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, 1);
        this.zzb = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzatj)) {
            return false;
        }
        zzatj zzatj = (zzatj) obj;
        if (!Arrays.equals(this.zzb, zzatj.zzb)) {
            return false;
        }
        int i = zzatj.zzc;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzb) * 31) + 2;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzb);
        return "AudioCapabilities[maxChannelCount=2, supportedEncodings=" + arrays + Const.jaRight;
    }
}
