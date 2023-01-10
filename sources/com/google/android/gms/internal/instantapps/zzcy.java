package com.google.android.gms.internal.instantapps;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzcy {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzapu;
    private static final ByteBuffer zzapv;
    private static final zzcb zzapw;

    public static int zzc(boolean z) {
        return z ? 1231 : 1237;
    }

    static boolean zzf(zzef zzef) {
        return false;
    }

    public static int zzm(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzd(byte[] bArr) {
        return zzfv.zzd(bArr);
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzef) obj).zzcb().zza((zzef) obj2).zzbv();
    }

    static {
        byte[] bArr = new byte[0];
        zzapu = bArr;
        zzapv = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzapu;
        zzapw = zzcb.zza(bArr2, 0, bArr2.length, false);
    }
}
