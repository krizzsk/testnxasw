package com.google.android.gms.internal.ads;

import org.apache.commons.p074io.IOUtils;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzfsg extends zzfsf {
    private final char zza;

    zzfsg(char c) {
        this.zza = c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.is('");
        int i = this.zza;
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = C2948a.f6666a.charAt(i & 15);
            i >>= 4;
        }
        sb.append(String.copyValueOf(cArr));
        sb.append("')");
        return sb.toString();
    }

    public final boolean zzb(char c) {
        return c == this.zza;
    }
}
