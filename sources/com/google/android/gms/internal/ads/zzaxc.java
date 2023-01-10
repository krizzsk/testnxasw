package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import p055case.C1273goto;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxc implements zzaxa {
    private zzaxc() {
    }

    /* synthetic */ zzaxc(zzaxb zzaxb) {
    }

    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo zzb(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean zzc(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C1273goto.f468do.equals(str);
    }

    public final boolean zzd() {
        return false;
    }
}
