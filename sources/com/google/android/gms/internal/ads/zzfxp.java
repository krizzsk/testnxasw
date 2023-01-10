package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfxp {
    private static final OutputStream zza = new zzfxo();

    public static byte[] zza(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            ArrayDeque arrayDeque = new ArrayDeque(20);
            int highestOneBit = Integer.highestOneBit(0);
            int min = Math.min(8192, Math.max(128, highestOneBit + highestOneBit));
            int i = 0;
            while (i < 2147483639) {
                int min2 = Math.min(min, 2147483639 - i);
                byte[] bArr = new byte[min2];
                arrayDeque.add(bArr);
                int i2 = 0;
                while (i2 < min2) {
                    int read = inputStream.read(bArr, i2, min2 - i2);
                    if (read == -1) {
                        return zzb(arrayDeque, i);
                    }
                    i2 += read;
                    i += read;
                }
                min = zzfxs.zzc(((long) min) * ((long) (min < 4096 ? 4 : 2)));
            }
            if (inputStream.read() == -1) {
                return zzb(arrayDeque, 2147483639);
            }
            throw new OutOfMemoryError("input is too large to fit in a byte array");
        }
        throw null;
    }

    private static byte[] zzb(Queue queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i) {
            return bArr;
        }
        int i2 = i - length;
        byte[] copyOf = Arrays.copyOf(bArr, i);
        while (i2 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(i2, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i - i2, min);
            i2 -= min;
        }
        return copyOf;
    }
}
