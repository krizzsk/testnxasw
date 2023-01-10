package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzggq {
    public static int zza() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b;
    }
}
