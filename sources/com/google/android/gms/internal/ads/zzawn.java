package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawn {
    private static final int[] zza = {zzbar.zzg("isom"), zzbar.zzg("iso2"), zzbar.zzg("iso3"), zzbar.zzg("iso4"), zzbar.zzg("iso5"), zzbar.zzg("iso6"), zzbar.zzg("avc1"), zzbar.zzg("hvc1"), zzbar.zzg("hev1"), zzbar.zzg("mp41"), zzbar.zzg("mp42"), zzbar.zzg("3g2a"), zzbar.zzg("3g2b"), zzbar.zzg("3gr6"), zzbar.zzg("3gs6"), zzbar.zzg("3ge6"), zzbar.zzg("3gg6"), zzbar.zzg("M4V "), zzbar.zzg("M4A "), zzbar.zzg("f4v "), zzbar.zzg("kddi"), zzbar.zzg("M4VP"), zzbar.zzg("qt  "), zzbar.zzg("MSNV")};

    public static boolean zza(zzauy zzauy) throws IOException, InterruptedException {
        return zzc(zzauy, true);
    }

    public static boolean zzb(zzauy zzauy) throws IOException, InterruptedException {
        return zzc(zzauy, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzauy r16, boolean r17) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r16
            long r1 = r16.zzc()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0012
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            int r2 = (int) r1
            com.google.android.gms.internal.ads.zzbak r1 = new com.google.android.gms.internal.ads.zzbak
            r3 = 64
            r1.<init>((int) r3)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x001e:
            if (r4 >= r2) goto L_0x00b8
            r7 = 8
            r1.zzs(r7)
            byte[] r8 = r1.zza
            r0.zzg(r8, r3, r7, r3)
            long r8 = r1.zzm()
            int r10 = r1.zze()
            r11 = 1
            r13 = 16
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x0047
            byte[] r8 = r1.zza
            r0.zzg(r8, r7, r7, r3)
            r1.zzu(r13)
            long r8 = r1.zzn()
            goto L_0x0049
        L_0x0047:
            r13 = 8
        L_0x0049:
            long r11 = (long) r13
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 >= 0) goto L_0x004f
            return r3
        L_0x004f:
            int r4 = r4 + r13
            int r13 = com.google.android.gms.internal.ads.zzavw.zzE
            if (r10 == r13) goto L_0x001e
            int r13 = com.google.android.gms.internal.ads.zzavw.zzN
            if (r10 == r13) goto L_0x00b6
            int r13 = com.google.android.gms.internal.ads.zzavw.zzP
            if (r10 != r13) goto L_0x005d
            goto L_0x00b6
        L_0x005d:
            long r13 = (long) r4
            long r13 = r13 + r8
            long r13 = r13 - r11
            long r6 = (long) r2
            int r15 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r15 < 0) goto L_0x0066
            goto L_0x00b8
        L_0x0066:
            long r8 = r8 - r11
            int r6 = (int) r8
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.zzavw.zzd
            if (r10 != r7) goto L_0x00af
            r7 = 8
            if (r6 >= r7) goto L_0x0072
            return r3
        L_0x0072:
            r1.zzs(r6)
            byte[] r7 = r1.zza
            r0.zzg(r7, r3, r6, r3)
            int r6 = r6 >> 2
            r7 = 0
        L_0x007d:
            if (r7 >= r6) goto L_0x00aa
            r8 = 1
            if (r7 != r8) goto L_0x0087
            r8 = 4
            r1.zzw(r8)
            goto L_0x00a7
        L_0x0087:
            int r8 = r1.zze()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzbar.zzg(r10)
            if (r9 != r10) goto L_0x0097
        L_0x0095:
            r5 = 1
            goto L_0x00aa
        L_0x0097:
            int[] r9 = zza
            int r10 = r9.length
            r10 = 0
        L_0x009b:
            r11 = 24
            if (r10 >= r11) goto L_0x00a7
            r11 = r9[r10]
            if (r11 != r8) goto L_0x00a4
            goto L_0x0095
        L_0x00a4:
            int r10 = r10 + 1
            goto L_0x009b
        L_0x00a7:
            int r7 = r7 + 1
            goto L_0x007d
        L_0x00aa:
            if (r5 == 0) goto L_0x00ae
            goto L_0x001e
        L_0x00ae:
            return r3
        L_0x00af:
            if (r6 == 0) goto L_0x001e
            r0.zzf(r6, r3)
            goto L_0x001e
        L_0x00b6:
            r8 = 1
            goto L_0x00b9
        L_0x00b8:
            r8 = 0
        L_0x00b9:
            if (r5 == 0) goto L_0x00c1
            r0 = r17
            if (r0 != r8) goto L_0x00c1
            r0 = 1
            return r0
        L_0x00c1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawn.zzc(com.google.android.gms.internal.ads.zzauy, boolean):boolean");
    }
}
