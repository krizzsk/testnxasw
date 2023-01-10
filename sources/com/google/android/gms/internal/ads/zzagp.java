package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagp extends zzagn {
    private zzago zza;
    private int zzb;
    private boolean zzc;
    private zzaau zzd;
    private zzaas zze;

    zzagp() {
    }

    /* access modifiers changed from: protected */
    public final long zza(zzef zzef) {
        int i;
        int i2 = 0;
        if ((zzef.zzH()[0] & 1) == 1) {
            return -1;
        }
        byte b = zzef.zzH()[0];
        zzago zzago = this.zza;
        zzdd.zzb(zzago);
        if (!zzago.zzd[(b >> 1) & (255 >>> (8 - zzago.zze))].zza) {
            i = zzago.zza.zze;
        } else {
            i = zzago.zza.zzf;
        }
        if (this.zzc) {
            i2 = (this.zzb + i) / 4;
        }
        long j = (long) i2;
        if (zzef.zzb() < zzef.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzef.zzH(), zzef.zzd() + 4);
            zzef.zzD(copyOf, copyOf.length);
        } else {
            zzef.zzE(zzef.zzd() + 4);
        }
        byte[] zzH = zzef.zzH();
        zzH[zzef.zzd() - 4] = (byte) ((int) (j & 255));
        zzH[zzef.zzd() - 3] = (byte) ((int) ((j >>> 8) & 255));
        zzH[zzef.zzd() - 2] = (byte) ((int) ((j >>> 16) & 255));
        zzH[zzef.zzd() - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* access modifiers changed from: protected */
    public final void zzi(long j) {
        super.zzi(j);
        int i = 0;
        this.zzc = j != 0;
        zzaau zzaau = this.zzd;
        if (zzaau != null) {
            i = zzaau.zze;
        }
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0409 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x040b  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzef r27, long r28, com.google.android.gms.internal.ads.zzagk r30) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r30
            com.google.android.gms.internal.ads.zzago r3 = r0.zza
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzaf r1 = r2.zza
            if (r1 == 0) goto L_0x0011
            return r5
        L_0x0011:
            throw r4
        L_0x0012:
            com.google.android.gms.internal.ads.zzaau r7 = r0.zzd
            r6 = 4
            r12 = 1
            if (r7 != 0) goto L_0x0084
            com.google.android.gms.internal.ads.zzaav.zzd(r12, r1, r5)
            int r14 = r27.zzh()
            int r15 = r27.zzk()
            int r16 = r27.zzh()
            int r7 = r27.zzg()
            if (r7 > 0) goto L_0x0030
            r17 = -1
            goto L_0x0032
        L_0x0030:
            r17 = r7
        L_0x0032:
            int r7 = r27.zzg()
            if (r7 > 0) goto L_0x003b
            r18 = -1
            goto L_0x003d
        L_0x003b:
            r18 = r7
        L_0x003d:
            int r7 = r27.zzg()
            if (r7 > 0) goto L_0x0046
            r19 = -1
            goto L_0x0048
        L_0x0046:
            r19 = r7
        L_0x0048:
            int r3 = r27.zzk()
            r7 = r3 & 15
            double r7 = (double) r7
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = java.lang.Math.pow(r9, r7)
            int r7 = (int) r7
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> r6
            double r4 = (double) r3
            double r3 = java.lang.Math.pow(r9, r4)
            int r3 = (int) r3
            int r4 = r27.zzk()
            byte[] r5 = r27.zzH()
            int r1 = r27.zzd()
            byte[] r23 = java.util.Arrays.copyOf(r5, r1)
            com.google.android.gms.internal.ads.zzaau r1 = new com.google.android.gms.internal.ads.zzaau
            r4 = r4 & r12
            if (r12 == r4) goto L_0x0077
            r22 = 0
            goto L_0x0079
        L_0x0077:
            r22 = 1
        L_0x0079:
            r13 = r1
            r20 = r7
            r21 = r3
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0.zzd = r1
            goto L_0x008e
        L_0x0084:
            com.google.android.gms.internal.ads.zzaas r8 = r0.zze
            if (r8 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaas r1 = com.google.android.gms.internal.ads.zzaav.zzc(r1, r12, r12)
            r0.zze = r1
        L_0x008e:
            r4 = 0
            goto L_0x0405
        L_0x0091:
            int r4 = r27.zzd()
            byte[] r9 = new byte[r4]
            byte[] r4 = r27.zzH()
            int r5 = r27.zzd()
            r10 = 0
            java.lang.System.arraycopy(r4, r10, r9, r10, r5)
            int r4 = r7.zza
            r5 = 5
            com.google.android.gms.internal.ads.zzaav.zzd(r5, r1, r10)
            int r11 = r27.zzk()
            int r11 = r11 + r12
            com.google.android.gms.internal.ads.zzaar r13 = new com.google.android.gms.internal.ads.zzaar
            byte[] r14 = r27.zzH()
            r13.<init>(r14)
            int r1 = r27.zzc()
            r14 = 8
            int r1 = r1 * 8
            r13.zzc(r1)
            r1 = 0
        L_0x00c3:
            r15 = 24
            r3 = 16
            if (r1 >= r11) goto L_0x01e2
            int r14 = r13.zzb(r15)
            r10 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r10) goto L_0x01c6
            int r3 = r13.zzb(r3)
            int r10 = r13.zzb(r15)
            long[] r14 = new long[r10]
            boolean r15 = r13.zzd()
            r18 = 0
            if (r15 != 0) goto L_0x011d
            boolean r15 = r13.zzd()
            r6 = 0
        L_0x00e9:
            if (r6 >= r10) goto L_0x011b
            if (r15 == 0) goto L_0x0108
            boolean r21 = r13.zzd()
            if (r21 == 0) goto L_0x00ff
            int r21 = r13.zzb(r5)
            int r5 = r21 + 1
            r23 = r13
            long r12 = (long) r5
            r14[r6] = r12
            goto L_0x0103
        L_0x00ff:
            r23 = r13
            r14[r6] = r18
        L_0x0103:
            r5 = r23
            r21 = 1
            goto L_0x0115
        L_0x0108:
            r5 = r13
            r12 = 5
            int r13 = r5.zzb(r12)
            r21 = 1
            int r13 = r13 + 1
            long r12 = (long) r13
            r14[r6] = r12
        L_0x0115:
            int r6 = r6 + 1
            r13 = r5
            r5 = 5
            r12 = 1
            goto L_0x00e9
        L_0x011b:
            r5 = r13
            goto L_0x0154
        L_0x011d:
            r5 = r13
            r6 = 5
            r21 = 1
            int r12 = r5.zzb(r6)
            int r12 = r12 + 1
            r6 = 0
        L_0x0128:
            if (r6 >= r10) goto L_0x0154
            int r13 = r10 - r6
            int r13 = com.google.android.gms.internal.ads.zzaav.zza(r13)
            int r13 = r5.zzb(r13)
            r15 = 0
        L_0x0135:
            if (r15 >= r13) goto L_0x0149
            if (r6 >= r10) goto L_0x0149
            r23 = r8
            r24 = r9
            long r8 = (long) r12
            r14[r6] = r8
            int r6 = r6 + 1
            int r15 = r15 + 1
            r8 = r23
            r9 = r24
            goto L_0x0135
        L_0x0149:
            r23 = r8
            r24 = r9
            int r12 = r12 + 1
            r8 = r23
            r9 = r24
            goto L_0x0128
        L_0x0154:
            r23 = r8
            r24 = r9
            r6 = 4
            int r8 = r5.zzb(r6)
            r9 = 2
            if (r8 > r9) goto L_0x01af
            r12 = 1
            if (r8 == r12) goto L_0x0169
            if (r8 != r9) goto L_0x0167
            r8 = 2
            goto L_0x0169
        L_0x0167:
            r6 = r11
            goto L_0x019f
        L_0x0169:
            r9 = 32
            r5.zzc(r9)
            r5.zzc(r9)
            int r9 = r5.zzb(r6)
            int r9 = r9 + r12
            r5.zzc(r12)
            if (r8 != r12) goto L_0x0193
            if (r3 == 0) goto L_0x0191
            long r12 = (long) r10
            double r12 = (double) r12
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6 = r11
            long r10 = (long) r3
            double r10 = (double) r10
            double r14 = r14 / r10
            double r10 = java.lang.Math.pow(r12, r14)
            double r10 = java.lang.Math.floor(r10)
            long r10 = (long) r10
            r18 = r10
            goto L_0x0198
        L_0x0191:
            r6 = r11
            goto L_0x0198
        L_0x0193:
            r6 = r11
            long r10 = (long) r10
            long r12 = (long) r3
            long r18 = r10 * r12
        L_0x0198:
            long r8 = (long) r9
            long r8 = r8 * r18
            int r3 = (int) r8
            r5.zzc(r3)
        L_0x019f:
            int r1 = r1 + 1
            r13 = r5
            r11 = r6
            r8 = r23
            r9 = r24
            r5 = 5
            r6 = 4
            r10 = 0
            r12 = 1
            r14 = 8
            goto L_0x00c3
        L_0x01af:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01c6:
            r5 = r13
            r2 = 0
            int r1 = r5.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x01e2:
            r23 = r8
            r24 = r9
            r5 = r13
            r1 = 6
            int r6 = r5.zzb(r1)
            r8 = 1
            int r6 = r6 + r8
            r8 = 0
        L_0x01ef:
            if (r8 >= r6) goto L_0x0202
            int r9 = r5.zzb(r3)
            if (r9 != 0) goto L_0x01fa
            int r8 = r8 + 1
            goto L_0x01ef
        L_0x01fa:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0202:
            int r6 = r5.zzb(r1)
            r8 = 1
            int r6 = r6 + r8
            r9 = 0
        L_0x0209:
            r10 = 3
            if (r9 >= r6) goto L_0x02c3
            int r11 = r5.zzb(r3)
            if (r11 == 0) goto L_0x0297
            if (r11 != r8) goto L_0x0280
            r8 = 5
            int r11 = r5.zzb(r8)
            int[] r8 = new int[r11]
            r12 = 0
            r13 = -1
        L_0x021d:
            if (r12 >= r11) goto L_0x022e
            r14 = 4
            int r15 = r5.zzb(r14)
            r8[r12] = r15
            if (r15 <= r13) goto L_0x0229
            r13 = r15
        L_0x0229:
            int r12 = r12 + 1
            r15 = 24
            goto L_0x021d
        L_0x022e:
            int r13 = r13 + 1
            int[] r12 = new int[r13]
            r14 = 0
        L_0x0233:
            if (r14 >= r13) goto L_0x0262
            int r15 = r5.zzb(r10)
            r19 = 1
            int r15 = r15 + 1
            r12[r14] = r15
            r15 = 2
            int r25 = r5.zzb(r15)
            if (r25 <= 0) goto L_0x024c
            r15 = 8
            r5.zzc(r15)
            goto L_0x024e
        L_0x024c:
            r15 = 8
        L_0x024e:
            r10 = 0
        L_0x024f:
            int r1 = r19 << r25
            if (r10 >= r1) goto L_0x025d
            r5.zzc(r15)
            int r10 = r10 + 1
            r15 = 8
            r19 = 1
            goto L_0x024f
        L_0x025d:
            int r14 = r14 + 1
            r1 = 6
            r10 = 3
            goto L_0x0233
        L_0x0262:
            r1 = 2
            r5.zzc(r1)
            r1 = 4
            int r10 = r5.zzb(r1)
            r1 = 0
            r13 = 0
            r14 = 0
        L_0x026e:
            if (r1 >= r11) goto L_0x02bb
            r15 = r8[r1]
            r15 = r12[r15]
            int r13 = r13 + r15
        L_0x0275:
            if (r14 >= r13) goto L_0x027d
            r5.zzc(r10)
            int r14 = r14 + 1
            goto L_0x0275
        L_0x027d:
            int r1 = r1 + 1
            goto L_0x026e
        L_0x0280:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0297:
            r1 = 8
            r5.zzc(r1)
            r5.zzc(r3)
            r5.zzc(r3)
            r8 = 6
            r5.zzc(r8)
            r5.zzc(r1)
            r8 = 4
            int r10 = r5.zzb(r8)
            r8 = 1
            int r10 = r10 + r8
            r8 = 0
        L_0x02b1:
            if (r8 >= r10) goto L_0x02bb
            r5.zzc(r1)
            int r8 = r8 + 1
            r1 = 8
            goto L_0x02b1
        L_0x02bb:
            int r9 = r9 + 1
            r1 = 6
            r8 = 1
            r15 = 24
            goto L_0x0209
        L_0x02c3:
            int r6 = r5.zzb(r1)
            r8 = 1
            int r6 = r6 + r8
            r9 = 0
        L_0x02ca:
            if (r9 >= r6) goto L_0x0336
            int r10 = r5.zzb(r3)
            r11 = 2
            if (r10 > r11) goto L_0x032e
            r10 = 24
            r5.zzc(r10)
            r5.zzc(r10)
            r5.zzc(r10)
            int r11 = r5.zzb(r1)
            int r11 = r11 + r8
            r1 = 8
            r5.zzc(r1)
            int[] r8 = new int[r11]
            r12 = 0
        L_0x02eb:
            if (r12 >= r11) goto L_0x030a
            r13 = 3
            int r14 = r5.zzb(r13)
            boolean r15 = r5.zzd()
            if (r15 == 0) goto L_0x02fe
            r15 = 5
            int r18 = r5.zzb(r15)
            goto L_0x0301
        L_0x02fe:
            r15 = 5
            r18 = 0
        L_0x0301:
            int r18 = r18 * 8
            int r18 = r18 + r14
            r8[r12] = r18
            int r12 = r12 + 1
            goto L_0x02eb
        L_0x030a:
            r13 = 3
            r15 = 5
            r12 = 0
        L_0x030d:
            if (r12 >= r11) goto L_0x0329
            r14 = 0
        L_0x0310:
            if (r14 >= r1) goto L_0x0324
            r18 = r8[r12]
            r19 = 1
            int r22 = r19 << r14
            r18 = r18 & r22
            if (r18 == 0) goto L_0x031f
            r5.zzc(r1)
        L_0x031f:
            int r14 = r14 + 1
            r1 = 8
            goto L_0x0310
        L_0x0324:
            int r12 = r12 + 1
            r1 = 8
            goto L_0x030d
        L_0x0329:
            int r9 = r9 + 1
            r1 = 6
            r8 = 1
            goto L_0x02ca
        L_0x032e:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x0336:
            int r6 = r5.zzb(r1)
            r1 = 1
            int r6 = r6 + r1
            r1 = 0
        L_0x033d:
            if (r1 >= r6) goto L_0x03c7
            int r8 = r5.zzb(r3)
            if (r8 == 0) goto L_0x035e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "mapping type other than 0 not supported: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "VorbisUtil"
            com.google.android.gms.internal.ads.zzdw.zzb(r9, r8)
            r9 = 2
            r11 = 4
            goto L_0x03bb
        L_0x035e:
            boolean r8 = r5.zzd()
            if (r8 == 0) goto L_0x036e
            r8 = 4
            int r9 = r5.zzb(r8)
            r21 = 1
            int r8 = r9 + 1
            goto L_0x0371
        L_0x036e:
            r21 = 1
            r8 = 1
        L_0x0371:
            boolean r9 = r5.zzd()
            if (r9 == 0) goto L_0x0395
            r9 = 8
            int r10 = r5.zzb(r9)
            int r10 = r10 + 1
            r9 = 0
        L_0x0380:
            if (r9 >= r10) goto L_0x0395
            int r11 = r4 + -1
            int r12 = com.google.android.gms.internal.ads.zzaav.zza(r11)
            r5.zzc(r12)
            int r11 = com.google.android.gms.internal.ads.zzaav.zza(r11)
            r5.zzc(r11)
            int r9 = r9 + 1
            goto L_0x0380
        L_0x0395:
            r9 = 2
            int r10 = r5.zzb(r9)
            if (r10 != 0) goto L_0x03bf
            r10 = 1
            if (r8 <= r10) goto L_0x03a9
            r10 = 0
        L_0x03a0:
            if (r10 >= r4) goto L_0x03a9
            r11 = 4
            r5.zzc(r11)
            int r10 = r10 + 1
            goto L_0x03a0
        L_0x03a9:
            r11 = 4
            r10 = 0
        L_0x03ab:
            if (r10 >= r8) goto L_0x03bb
            r12 = 8
            r5.zzc(r12)
            r5.zzc(r12)
            r5.zzc(r12)
            int r10 = r10 + 1
            goto L_0x03ab
        L_0x03bb:
            int r1 = r1 + 1
            goto L_0x033d
        L_0x03bf:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x03c7:
            r1 = 6
            int r1 = r5.zzb(r1)
            r4 = 1
            int r1 = r1 + r4
            com.google.android.gms.internal.ads.zzaat[] r10 = new com.google.android.gms.internal.ads.zzaat[r1]
            r4 = 0
        L_0x03d1:
            if (r4 >= r1) goto L_0x03ef
            boolean r6 = r5.zzd()
            int r8 = r5.zzb(r3)
            int r9 = r5.zzb(r3)
            r11 = 8
            int r12 = r5.zzb(r11)
            com.google.android.gms.internal.ads.zzaat r13 = new com.google.android.gms.internal.ads.zzaat
            r13.<init>(r6, r8, r9, r12)
            r10[r4] = r13
            int r4 = r4 + 1
            goto L_0x03d1
        L_0x03ef:
            boolean r3 = r5.zzd()
            if (r3 == 0) goto L_0x0454
            com.google.android.gms.internal.ads.zzago r4 = new com.google.android.gms.internal.ads.zzago
            r3 = -1
            int r1 = r1 + r3
            int r11 = com.google.android.gms.internal.ads.zzaav.zza(r1)
            r6 = r4
            r8 = r23
            r9 = r24
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x0405:
            r0.zza = r4
            if (r4 != 0) goto L_0x040b
            r1 = 1
            return r1
        L_0x040b:
            com.google.android.gms.internal.ads.zzaau r1 = r4.zza
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            byte[] r5 = r1.zzg
            r3.add(r5)
            byte[] r5 = r4.zzc
            r3.add(r5)
            com.google.android.gms.internal.ads.zzaas r4 = r4.zzb
            java.lang.String[] r4 = r4.zzb
            com.google.android.gms.internal.ads.zzfvn r4 = com.google.android.gms.internal.ads.zzfvn.zzn(r4)
            com.google.android.gms.internal.ads.zzbq r4 = com.google.android.gms.internal.ads.zzaav.zzb(r4)
            com.google.android.gms.internal.ads.zzad r5 = new com.google.android.gms.internal.ads.zzad
            r5.<init>()
            java.lang.String r6 = "audio/vorbis"
            r5.zzS(r6)
            int r6 = r1.zzd
            r5.zzv(r6)
            int r6 = r1.zzc
            r5.zzO(r6)
            int r6 = r1.zza
            r5.zzw(r6)
            int r1 = r1.zzb
            r5.zzT(r1)
            r5.zzI(r3)
            r5.zzM(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r5.zzY()
            r2.zza = r1
            r1 = 1
            return r1
        L_0x0454:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagp.zzc(com.google.android.gms.internal.ads.zzef, long, com.google.android.gms.internal.ads.zzagk):boolean");
    }
}
