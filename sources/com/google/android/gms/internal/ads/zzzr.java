package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzr {
    public static int zza(zzef zzef, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzef.zzk() + 1;
            case 7:
                return zzef.zzo() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzzj zzzj, zzzv zzzv) throws IOException {
        zzzj.zzj();
        zzyy zzyy = (zzyy) zzzj;
        boolean z = true;
        zzyy.zzl(1, false);
        byte[] bArr = new byte[1];
        zzyy.zzm(bArr, 0, 1, false);
        byte b = bArr[0] & 1;
        zzyy.zzl(2, false);
        int i = 1 != b ? 6 : 7;
        zzef zzef = new zzef(i);
        zzef.zzE(zzzm.zza(zzzj, zzef.zzH(), 0, i));
        zzzj.zzj();
        zzzq zzzq = new zzzq();
        if (1 != b) {
            z = false;
        }
        if (zzd(zzef, zzzv, z, zzzq)) {
            return zzzq.zza;
        }
        throw zzbu.zza((String) null, (Throwable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r7 != r1.zzf) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        if ((r17.zzk() * 1000) == r3) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009b, code lost:
        if (r4 == r3) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzc(com.google.android.gms.internal.ads.zzef r17, com.google.android.gms.internal.ads.zzzv r18, int r19, com.google.android.gms.internal.ads.zzzq r20) {
        /*
            r0 = r17
            r1 = r18
            int r2 = r17.zzc()
            long r3 = r17.zzs()
            r5 = 16
            long r5 = r3 >>> r5
            r7 = r19
            long r7 = (long) r7
            r9 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x0019
            return r9
        L_0x0019:
            r7 = 1
            long r5 = r5 & r7
            r10 = 1
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x0023
            r5 = 1
            goto L_0x0024
        L_0x0023:
            r5 = 0
        L_0x0024:
            r6 = 12
            long r11 = r3 >> r6
            r13 = 15
            long r11 = r11 & r13
            int r12 = (int) r11
            r11 = 8
            long r15 = r3 >> r11
            long r6 = r15 & r13
            int r7 = (int) r6
            r6 = 4
            long r15 = r3 >> r6
            long r13 = r13 & r15
            int r6 = (int) r13
            long r13 = r3 >> r10
            r15 = 7
            long r13 = r13 & r15
            int r8 = (int) r13
            r13 = 1
            long r3 = r3 & r13
            r11 = 7
            r13 = -1
            if (r6 > r11) goto L_0x004b
            int r11 = r1.zzg
            int r11 = r11 + r13
            if (r6 != r11) goto L_0x00b1
            goto L_0x0054
        L_0x004b:
            r11 = 10
            if (r6 > r11) goto L_0x00b1
            int r6 = r1.zzg
            r11 = 2
            if (r6 != r11) goto L_0x00b1
        L_0x0054:
            if (r8 != 0) goto L_0x0059
        L_0x0056:
            r14 = 1
            goto L_0x005e
        L_0x0059:
            int r6 = r1.zzi
            if (r8 != r6) goto L_0x00b1
            goto L_0x0056
        L_0x005e:
            int r6 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x00b1
            r3 = r20
            boolean r3 = zzd(r0, r1, r5, r3)
            if (r3 == 0) goto L_0x00b1
            int r3 = zza(r0, r12)
            if (r3 == r13) goto L_0x00b1
            int r4 = r1.zzb
            if (r3 > r4) goto L_0x00b1
            int r3 = r1.zze
            if (r7 != 0) goto L_0x0079
            goto L_0x009d
        L_0x0079:
            r4 = 11
            if (r7 > r4) goto L_0x0082
            int r1 = r1.zzf
            if (r7 == r1) goto L_0x009d
            goto L_0x00b1
        L_0x0082:
            r1 = 12
            if (r7 != r1) goto L_0x008f
            int r1 = r17.zzk()
            int r1 = r1 * 1000
            if (r1 != r3) goto L_0x00b1
            goto L_0x009d
        L_0x008f:
            r1 = 14
            if (r7 > r1) goto L_0x00b1
            int r4 = r17.zzo()
            if (r7 != r1) goto L_0x009b
            int r4 = r4 * 10
        L_0x009b:
            if (r4 != r3) goto L_0x00b1
        L_0x009d:
            int r1 = r17.zzk()
            int r3 = r17.zzc()
            byte[] r0 = r17.zzH()
            int r3 = r3 + r13
            int r0 = com.google.android.gms.internal.ads.zzen.zzh(r0, r2, r3, r9)
            if (r1 != r0) goto L_0x00b1
            return r10
        L_0x00b1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzr.zzc(com.google.android.gms.internal.ads.zzef, com.google.android.gms.internal.ads.zzzv, int, com.google.android.gms.internal.ads.zzzq):boolean");
    }

    private static boolean zzd(zzef zzef, zzzv zzzv, boolean z, zzzq zzzq) {
        try {
            long zzu = zzef.zzu();
            if (!z) {
                zzu *= (long) zzzv.zzb;
            }
            zzzq.zza = zzu;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
