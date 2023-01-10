package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.mlcp.drtc.consts.RTCConsts;
import p055case.C1273goto;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaws {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    private final String zze;
    private final MediaCodecInfo.CodecCapabilities zzf;

    private zzaws(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        if (str != null) {
            this.zza = str;
            this.zze = str2;
            this.zzf = codecCapabilities;
            boolean z3 = true;
            this.zzb = !z && codecCapabilities != null && zzbar.zza >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
            this.zzc = codecCapabilities != null && zzbar.zza >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
            if (!z2 && (codecCapabilities == null || zzbar.zza < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
                z3 = false;
            }
            this.zzd = z3;
            return;
        }
        throw null;
    }

    public static zzaws zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzaws(str, str2, codecCapabilities, z, z2);
    }

    public static zzaws zzb(String str) {
        return new zzaws("OMX.google.raw.decoder", (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    private final void zzh(String str) {
        String str2 = this.zza;
        String str3 = this.zze;
        String str4 = zzbar.zze;
        SystemUtils.log(3, "MediaCodecInfo", "NoSupport [" + str + "] [" + str2 + ", " + str3 + "] [" + str4 + Const.jaRight, (Throwable) null, "com.google.android.gms.internal.ads.zzaws", 1);
    }

    public final boolean zzc(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzh("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        } else {
            zzh("channelCount.support, " + i);
            return false;
        }
    }

    public final boolean zzd(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzh("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            zzh("sampleRate.support, " + i);
            return false;
        }
    }

    public final boolean zze(String str) {
        if (str == null || this.zze == null) {
            return true;
        }
        String trim = str.trim();
        String str2 = (trim.startsWith("avc1") || trim.startsWith("avc3")) ? C1273goto.f468do : (trim.startsWith("hev1") || trim.startsWith("hvc1")) ? C1273goto.f469if : trim.startsWith("vp9") ? C1273goto.f62272for : trim.startsWith("vp8") ? C1273goto.f62273new : trim.startsWith("mp4a") ? "audio/mp4a-latm" : (trim.startsWith("ac-3") || trim.startsWith("dac3")) ? "audio/ac3" : (trim.startsWith("ec-3") || trim.startsWith("dec3")) ? "audio/eac3" : (trim.startsWith("dtsc") || trim.startsWith("dtse")) ? "audio/vnd.dts" : (trim.startsWith("dtsh") || trim.startsWith("dtsl")) ? "audio/vnd.dts.hd" : trim.startsWith(RTCConsts.AUDIO_CODEC_OPUS) ? "audio/opus" : trim.startsWith("vorbis") ? "audio/vorbis" : null;
        if (str2 == null) {
            return true;
        }
        if (!this.zze.equals(str2)) {
            zzh("codec.mime " + str + ", " + str2);
            return false;
        }
        Pair zzb2 = zzaxe.zzb(str);
        if (zzb2 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzg()) {
            if (codecProfileLevel.profile == ((Integer) zzb2.first).intValue() && codecProfileLevel.level >= ((Integer) zzb2.second).intValue()) {
                return true;
            }
        }
        zzh("codec.profileLevel, " + str + ", " + str2);
        return false;
    }

    public final boolean zzf(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzh("sizeAndRate.vCaps");
            return false;
        } else if (zzi(videoCapabilities, i, i2, d)) {
            return true;
        } else {
            if (i >= i2 || !zzi(videoCapabilities, i2, i, d)) {
                zzh("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            }
            String str = this.zza;
            String str2 = this.zze;
            String str3 = zzbar.zze;
            StringBuilder sb = new StringBuilder();
            sb.append("AssumedSupport [");
            sb.append("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
            sb.append("] [");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            sb.append("] [");
            sb.append(str3);
            sb.append(Const.jaRight);
            SystemUtils.log(3, "MediaCodecInfo", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzaws", 8);
            return true;
        }
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzg() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.zzf.profileLevels;
    }

    private static boolean zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d == -1.0d || d <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d);
    }
}
