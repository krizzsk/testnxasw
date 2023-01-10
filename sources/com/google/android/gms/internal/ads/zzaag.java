package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaag {
    public static List zza(byte[] bArr) {
        byte b = bArr[11];
        byte b2 = bArr[10];
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzc(zzb((long) (((b & 255) << 8) | (b2 & 255)))));
        arrayList.add(zzc(zzb(3840)));
        return arrayList;
    }

    private static long zzb(long j) {
        return (j * 1000000000) / 48000;
    }

    private static byte[] zzc(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }
}
