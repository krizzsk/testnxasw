package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaff {
    private static final byte[] zza = zzen.zzaa("OpusHead");

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (r3 != 13) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d8, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzaew r11) {
        /*
            com.google.android.gms.internal.ads.zzef r11 = r11.zza
            r0 = 8
            r11.zzF(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x000a:
            int r4 = r11.zza()
            if (r4 < r0) goto L_0x00df
            int r4 = r11.zzc()
            int r5 = r11.zze()
            int r6 = r11.zze()
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r6 != r7) goto L_0x0075
            r11.zzF(r4)
            int r2 = r4 + r5
            r11.zzG(r0)
            zzd(r11)
        L_0x002c:
            int r6 = r11.zzc()
            if (r6 >= r2) goto L_0x0073
            int r6 = r11.zzc()
            int r7 = r11.zze()
            int r8 = r11.zze()
            r9 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r8 != r9) goto L_0x006e
            r11.zzF(r6)
            int r6 = r6 + r7
            r11.zzG(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x004f:
            int r7 = r11.zzc()
            if (r7 >= r6) goto L_0x005f
            com.google.android.gms.internal.ads.zzbp r7 = com.google.android.gms.internal.ads.zzafm.zza(r11)
            if (r7 == 0) goto L_0x004f
            r2.add(r7)
            goto L_0x004f
        L_0x005f:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x0066
            goto L_0x0073
        L_0x0066:
            com.google.android.gms.internal.ads.zzbq r6 = new com.google.android.gms.internal.ads.zzbq
            r6.<init>((java.util.List) r2)
            r2 = r6
            goto L_0x00d9
        L_0x006e:
            int r6 = r6 + r7
            r11.zzF(r6)
            goto L_0x002c
        L_0x0073:
            r2 = r1
            goto L_0x00d9
        L_0x0075:
            r7 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r6 != r7) goto L_0x00d9
            r11.zzF(r4)
            int r3 = r4 + r5
            r6 = 12
            r11.zzG(r6)
        L_0x0084:
            int r7 = r11.zzc()
            if (r7 >= r3) goto L_0x00d8
            int r7 = r11.zzc()
            int r8 = r11.zze()
            int r9 = r11.zze()
            r10 = 1935766900(0x73617574, float:1.7862687E31)
            if (r9 != r10) goto L_0x00d3
            r3 = 14
            if (r8 >= r3) goto L_0x00a0
            goto L_0x00d8
        L_0x00a0:
            r3 = 5
            r11.zzG(r3)
            int r3 = r11.zzk()
            r7 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r6) goto L_0x00b1
            r6 = 13
            if (r3 == r6) goto L_0x00b5
            goto L_0x00d8
        L_0x00b1:
            if (r3 != r6) goto L_0x00b5
            r7 = 1131413504(0x43700000, float:240.0)
        L_0x00b5:
            r3 = 1
            r11.zzG(r3)
            int r6 = r11.zzk()
            com.google.android.gms.internal.ads.zzbq r8 = new com.google.android.gms.internal.ads.zzbq
            com.google.android.gms.internal.ads.zzbp[] r3 = new com.google.android.gms.internal.ads.zzbp[r3]
            com.google.android.gms.internal.ads.zzadw r9 = new com.google.android.gms.internal.ads.zzadw
            r9.<init>((float) r7, (int) r6)
            r6 = 0
            r3[r6] = r9
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.<init>(r6, r3)
            r3 = r8
            goto L_0x00d9
        L_0x00d3:
            int r7 = r7 + r8
            r11.zzF(r7)
            goto L_0x0084
        L_0x00d8:
            r3 = r1
        L_0x00d9:
            int r4 = r4 + r5
            r11.zzF(r4)
            goto L_0x000a
        L_0x00df:
            android.util.Pair r11 = android.util.Pair.create(r2, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zza(com.google.android.gms.internal.ads.zzaew):android.util.Pair");
    }

    public static zzbq zzb(zzaev zzaev) {
        zzadq zzadq;
        zzaew zzb = zzaev.zzb(1751411826);
        zzaew zzb2 = zzaev.zzb(1801812339);
        zzaew zzb3 = zzaev.zzb(1768715124);
        if (zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937) {
            return null;
        }
        zzef zzef = zzb2.zza;
        zzef.zzF(12);
        int zze = zzef.zze();
        String[] strArr = new String[zze];
        for (int i = 0; i < zze; i++) {
            int zze2 = zzef.zze();
            zzef.zzG(4);
            strArr[i] = zzef.zzx(zze2 - 8, zzfsk.zzc);
        }
        zzef zzef2 = zzb3.zza;
        zzef2.zzF(8);
        ArrayList arrayList = new ArrayList();
        while (zzef2.zza() > 8) {
            int zzc = zzef2.zzc();
            int zze3 = zzef2.zze();
            int zze4 = zzef2.zze() - 1;
            if (zze4 < 0 || zze4 >= zze) {
                zzdw.zze("AtomParsers", "Skipped metadata with unknown key index: " + zze4);
            } else {
                String str = strArr[zze4];
                int i2 = zzc + zze3;
                int i3 = zzafm.zzb;
                while (true) {
                    int zzc2 = zzef2.zzc();
                    if (zzc2 >= i2) {
                        zzadq = null;
                        break;
                    }
                    int zze5 = zzef2.zze();
                    if (zzef2.zze() == 1684108385) {
                        int zze6 = zzef2.zze();
                        int zze7 = zzef2.zze();
                        int i4 = zze5 - 16;
                        byte[] bArr = new byte[i4];
                        zzef2.zzB(bArr, 0, i4);
                        zzadq = new zzadq(str, bArr, zze7, zze6);
                        break;
                    }
                    zzef2.zzF(zzc2 + zze5);
                }
                if (zzadq != null) {
                    arrayList.add(zzadq);
                }
            }
            zzef2.zzF(zzc + zze3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbq((List) arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v43, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v2, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v3, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v4, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v7, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v8, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v9, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v10, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v12, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v14, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v15, resolved type: com.google.android.gms.internal.ads.zzfvn} */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x065b, code lost:
        if (r0 != 3) goto L_0x0664;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b2, code lost:
        if (r14 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0756, code lost:
        if (r24 == null) goto L_0x076d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x06b2  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x06b4  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0820  */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x09ce  */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x0ab1 A[LOOP:12: B:507:0x0ab1->B:511:0x0abb, LOOP_START, PHI: r21 
      PHI: (r21v5 int) = (r21v4 int), (r21v6 int) binds: [B:506:0x0aaf, B:511:0x0abb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x0ac4  */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x0b0f  */
    /* JADX WARNING: Removed duplicated region for block: B:529:0x0b24  */
    /* JADX WARNING: Removed duplicated region for block: B:530:0x0b27  */
    /* JADX WARNING: Removed duplicated region for block: B:535:0x0b81  */
    /* JADX WARNING: Removed duplicated region for block: B:536:0x0b98  */
    /* JADX WARNING: Removed duplicated region for block: B:645:0x0df4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:679:0x0e07 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:706:0x0aaa A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzc(com.google.android.gms.internal.ads.zzaev r58, com.google.android.gms.internal.ads.zzzx r59, long r60, com.google.android.gms.internal.ads.zzx r62, boolean r63, boolean r64, com.google.android.gms.internal.ads.zzfsm r65) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r58
            r1 = r59
            r12 = r62
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r15 = 0
        L_0x000c:
            java.util.List r2 = r0.zzc
            int r2 = r2.size()
            if (r15 >= r2) goto L_0x0e11
            java.util.List r2 = r0.zzc
            java.lang.Object r2 = r2.get(r15)
            r11 = r2
            com.google.android.gms.internal.ads.zzaev r11 = (com.google.android.gms.internal.ads.zzaev) r11
            int r2 = r11.zzd
            r3 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r3) goto L_0x0029
            r0 = r13
            r31 = r15
            goto L_0x0df6
        L_0x0029:
            r2 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzaew r2 = r0.zzb(r2)
            if (r2 == 0) goto L_0x0e0f
            r9 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzaev r3 = r11.zza(r9)
            if (r3 == 0) goto L_0x0e0d
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzaew r4 = r3.zzb(r4)
            if (r4 == 0) goto L_0x0e0b
            com.google.android.gms.internal.ads.zzef r4 = r4.zza
            int r4 = zzg(r4)
            int r8 = zze(r4)
            java.lang.String r5 = "AtomParsers"
            r31 = r15
            r4 = -1
            if (r8 != r4) goto L_0x005e
            r0 = r65
            r2 = r11
            r32 = r13
            r4 = 1
        L_0x005b:
            r10 = 0
            goto L_0x0817
        L_0x005e:
            r9 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzaew r9 = r11.zzb(r9)
            if (r9 == 0) goto L_0x0e09
            com.google.android.gms.internal.ads.zzef r9 = r9.zza
            r10 = 8
            r9.zzF(r10)
            int r20 = r9.zze()
            int r20 = com.google.android.gms.internal.ads.zzaex.zze(r20)
            if (r20 != 0) goto L_0x007b
            r6 = 8
            goto L_0x007d
        L_0x007b:
            r6 = 16
        L_0x007d:
            r9.zzG(r6)
            int r6 = r9.zze()
            r10 = 4
            r9.zzG(r10)
            int r24 = r9.zzc()
            if (r20 != 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r10 = 8
        L_0x0091:
            r7 = 0
        L_0x0092:
            r27 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 >= r10) goto L_0x00b8
            byte[] r29 = r9.zzH()
            int r30 = r24 + r7
            byte r14 = r29[r30]
            if (r14 == r4) goto L_0x00b5
            if (r20 != 0) goto L_0x00aa
            long r14 = r9.zzs()
            goto L_0x00ae
        L_0x00aa:
            long r14 = r9.zzt()
        L_0x00ae:
            r29 = 0
            int r7 = (r14 > r29 ? 1 : (r14 == r29 ? 0 : -1))
            if (r7 != 0) goto L_0x00bd
            goto L_0x00bb
        L_0x00b5:
            int r7 = r7 + 1
            goto L_0x0092
        L_0x00b8:
            r9.zzG(r10)
        L_0x00bb:
            r14 = r27
        L_0x00bd:
            r7 = 16
            r9.zzG(r7)
            int r10 = r9.zze()
            int r4 = r9.zze()
            r7 = 4
            r9.zzG(r7)
            int r7 = r9.zze()
            int r9 = r9.zze()
            r0 = 65536(0x10000, float:9.18355E-41)
            r24 = r5
            r5 = -65536(0xffffffffffff0000, float:NaN)
            if (r10 != 0) goto L_0x00ef
            if (r4 != r0) goto L_0x00ee
            if (r7 != r5) goto L_0x00ec
            if (r9 != 0) goto L_0x00e7
            r0 = 90
            goto L_0x010e
        L_0x00e7:
            r4 = 65536(0x10000, float:9.18355E-41)
            r7 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00ee
        L_0x00ec:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            if (r10 != 0) goto L_0x0101
            if (r4 != r5) goto L_0x00fe
            if (r7 != r0) goto L_0x00fa
            if (r9 != 0) goto L_0x00fb
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x010e
        L_0x00fa:
            r0 = r7
        L_0x00fb:
            r4 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x00ff
        L_0x00fe:
            r0 = r7
        L_0x00ff:
            r10 = 0
            goto L_0x0102
        L_0x0101:
            r0 = r7
        L_0x0102:
            if (r10 != r5) goto L_0x010d
            if (r4 != 0) goto L_0x010d
            if (r0 != 0) goto L_0x010d
            if (r9 != r5) goto L_0x010d
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x010e
        L_0x010d:
            r0 = 0
        L_0x010e:
            com.google.android.gms.internal.ads.zzafe r10 = new com.google.android.gms.internal.ads.zzafe
            r10.<init>(r6, r14, r0)
            int r0 = (r60 > r27 ? 1 : (r60 == r27 ? 0 : -1))
            if (r0 != 0) goto L_0x011e
            long r4 = r10.zzb
            r32 = r4
            goto L_0x0120
        L_0x011e:
            r32 = r60
        L_0x0120:
            com.google.android.gms.internal.ads.zzef r0 = r2.zza
            r2 = 8
            r0.zzF(r2)
            int r4 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzaex.zze(r4)
            if (r4 != 0) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r2 = 16
        L_0x0134:
            r0.zzG(r2)
            long r14 = r0.zzs()
            int r0 = (r32 > r27 ? 1 : (r32 == r27 ? 0 : -1))
            if (r0 != 0) goto L_0x0140
            goto L_0x014b
        L_0x0140:
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r14
            long r4 = com.google.android.gms.internal.ads.zzen.zzw(r32, r34, r36)
            r27 = r4
        L_0x014b:
            r0 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzaev r2 = r3.zza(r0)
            if (r2 == 0) goto L_0x0e07
            r7 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzaev r2 = r2.zza(r7)
            if (r2 == 0) goto L_0x0e05
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzaew r3 = r3.zzb(r4)
            if (r3 == 0) goto L_0x0e03
            com.google.android.gms.internal.ads.zzef r3 = r3.zza
            android.util.Pair r9 = zzi(r3)
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzaew r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0e01
            com.google.android.gms.internal.ads.zzef r6 = r2.zza
            int r5 = r10.zza
            int r4 = r10.zzc
            java.lang.Object r2 = r9.second
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            r2 = 12
            r6.zzF(r2)
            int r0 = r6.zze()
            r32 = r13
            com.google.android.gms.internal.ads.zzafb r13 = new com.google.android.gms.internal.ads.zzafb
            r13.<init>(r0)
            r1 = 0
        L_0x0195:
            if (r1 >= r0) goto L_0x07b2
            r16 = r0
            int r0 = r6.zzc()
            r29 = r14
            int r14 = r6.zze()
            if (r14 <= 0) goto L_0x01a7
            r15 = 1
            goto L_0x01a8
        L_0x01a7:
            r15 = 0
        L_0x01a8:
            java.lang.String r2 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r15, r2)
            int r15 = r6.zze()
            r2 = 1635148593(0x61766331, float:2.840654E20)
            r7 = 1701733238(0x656e6376, float:7.035987E22)
            if (r15 == r2) goto L_0x0399
            r2 = 1635148595(0x61766333, float:2.8406544E20)
            if (r15 == r2) goto L_0x0399
            if (r15 == r7) goto L_0x0399
            r2 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r15 == r2) goto L_0x0399
            r2 = 1836070006(0x6d703476, float:4.646239E27)
            if (r15 == r2) goto L_0x0399
            r2 = 1752589105(0x68766331, float:4.6541277E24)
            if (r15 == r2) goto L_0x0399
            r2 = 1751479857(0x68657631, float:4.3344087E24)
            if (r15 == r2) goto L_0x0399
            r2 = 1932670515(0x73323633, float:1.4119387E31)
            if (r15 == r2) goto L_0x0399
            r2 = 1211250227(0x48323633, float:182488.8)
            if (r15 == r2) goto L_0x0399
            r2 = 1987063864(0x76703038, float:1.21789965E33)
            if (r15 == r2) goto L_0x0399
            r2 = 1987063865(0x76703039, float:1.2178997E33)
            if (r15 == r2) goto L_0x0399
            r2 = 1635135537(0x61763031, float:2.8383572E20)
            if (r15 == r2) goto L_0x0399
            r2 = 1685479798(0x64766176, float:1.8179687E22)
            if (r15 == r2) goto L_0x0399
            r2 = 1685479729(0x64766131, float:1.817961E22)
            if (r15 == r2) goto L_0x0399
            r2 = 1685481573(0x64766865, float:1.8181686E22)
            if (r15 == r2) goto L_0x0399
            r2 = 1685481521(0x64766831, float:1.8181627E22)
            if (r15 != r2) goto L_0x0203
            goto L_0x0399
        L_0x0203:
            r2 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r15 == r2) goto L_0x0359
            r2 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r15 == r2) goto L_0x0359
            r2 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r15 == r2) goto L_0x0359
            r2 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r15 == r2) goto L_0x0359
            r2 = 1685353315(0x64747363, float:1.803728E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1685353317(0x64747365, float:1.8037282E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1685353320(0x64747368, float:1.8037286E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1685353324(0x6474736c, float:1.803729E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1685353336(0x64747378, float:1.8037304E22)
            if (r15 == r2) goto L_0x0359
            r2 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r15 == r2) goto L_0x0359
            r2 = 1935767394(0x73617762, float:1.7863284E31)
            if (r15 == r2) goto L_0x0359
            r2 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r15 == r2) goto L_0x0359
            r2 = 1936684916(0x736f7774, float:1.89725E31)
            if (r15 == r2) goto L_0x0359
            r2 = 1953984371(0x74776f73, float:7.841539E31)
            if (r15 == r2) goto L_0x0359
            r2 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r15 == r2) goto L_0x0359
            r2 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r15 == r2) goto L_0x0359
            r2 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r15 == r2) goto L_0x0359
            r2 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r15 == r2) goto L_0x0359
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r15 == r2) goto L_0x0359
            r2 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r15 == r2) goto L_0x0359
            r2 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r15 == r2) goto L_0x0359
            r2 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r15 == r2) goto L_0x0359
            r2 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r15 != r2) goto L_0x0282
            goto L_0x0359
        L_0x0282:
            r2 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r15 == r2) goto L_0x02d7
            r2 = 1954034535(0x74783367, float:7.865797E31)
            if (r15 == r2) goto L_0x02d7
            r2 = 2004251764(0x77767474, float:4.998699E33)
            if (r15 == r2) goto L_0x02d7
            r2 = 1937010800(0x73747070, float:1.9366469E31)
            if (r15 == r2) goto L_0x02d7
            r2 = 1664495672(0x63363038, float:3.360782E21)
            if (r15 != r2) goto L_0x029c
            goto L_0x02d7
        L_0x029c:
            r2 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r15 != r2) goto L_0x02a8
            r2 = 1835365492(0x6d657474, float:4.4383032E27)
            zzn(r6, r2, r0, r5, r13)
            goto L_0x02c0
        L_0x02a8:
            r2 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r15 != r2) goto L_0x02c0
            com.google.android.gms.internal.ads.zzad r2 = new com.google.android.gms.internal.ads.zzad
            r2.<init>()
            r2.zzG(r5)
            java.lang.String r7 = "application/x-camera-motion"
            r2.zzS(r7)
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzY()
            r13.zzb = r2
        L_0x02c0:
            r36 = r0
            r19 = r1
            r17 = r3
            r2 = r4
            r1 = r5
            r21 = r8
            r40 = r9
            r18 = r10
            r41 = r11
            r3 = r13
            r42 = r14
            r5 = r24
            goto L_0x0355
        L_0x02d7:
            int r2 = r0 + 16
            r6.zzF(r2)
            r2 = 1414810956(0x54544d4c, float:3.64731957E12)
            r33 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r15 != r2) goto L_0x02f0
            java.lang.String r2 = "application/ttml+xml"
        L_0x02e8:
            r21 = r8
            r7 = r33
            r15 = 0
        L_0x02ed:
            r33 = r4
            goto L_0x0327
        L_0x02f0:
            r2 = 1954034535(0x74783367, float:7.865797E31)
            if (r15 != r2) goto L_0x030a
            int r2 = r14 + -16
            byte[] r7 = new byte[r2]
            r15 = 0
            r6.zzB(r7, r15, r2)
            com.google.android.gms.internal.ads.zzfvn r2 = com.google.android.gms.internal.ads.zzfvn.zzp(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r15 = r2
            r2 = r7
            r21 = r8
            r7 = r33
            goto L_0x02ed
        L_0x030a:
            r2 = 2004251764(0x77767474, float:4.998699E33)
            if (r15 != r2) goto L_0x0312
            java.lang.String r2 = "application/x-mp4-vtt"
            goto L_0x02e8
        L_0x0312:
            r2 = 1937010800(0x73747070, float:1.9366469E31)
            if (r15 != r2) goto L_0x0321
            java.lang.String r2 = "application/ttml+xml"
            r33 = r4
            r21 = r8
            r7 = 0
            r15 = 0
            goto L_0x0327
        L_0x0321:
            r7 = 1
            r13.zzd = r7
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x02e8
        L_0x0327:
            com.google.android.gms.internal.ads.zzad r4 = new com.google.android.gms.internal.ads.zzad
            r4.<init>()
            r4.zzG(r5)
            r4.zzS(r2)
            r4.zzK(r3)
            r4.zzW(r7)
            r4.zzI(r15)
            com.google.android.gms.internal.ads.zzaf r2 = r4.zzY()
            r13.zzb = r2
            r36 = r0
            r19 = r1
            r17 = r3
            r1 = r5
            r40 = r9
            r18 = r10
            r41 = r11
            r3 = r13
            r42 = r14
            r5 = r24
            r2 = r33
        L_0x0355:
            r4 = 1
            r10 = r6
            goto L_0x078d
        L_0x0359:
            r33 = r4
            r21 = r8
            r4 = 12
            r2 = r6
            r17 = r3
            r3 = r15
            r8 = r33
            r7 = 12
            r15 = -1
            r4 = r0
            r20 = r5
            r38 = r24
            r5 = r14
            r12 = r6
            r6 = r20
            r22 = r14
            r14 = 16
            r7 = r17
            r39 = r8
            r8 = r64
            r40 = r9
            r9 = r62
            r18 = r10
            r10 = r13
            r41 = r11
            r11 = r1
            zzm(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r36 = r0
            r19 = r1
            r10 = r12
            r3 = r13
            r1 = r20
            r42 = r22
            r5 = r38
            r2 = r39
            r4 = 1
            goto L_0x078d
        L_0x0399:
            r17 = r3
            r39 = r4
            r20 = r5
            r12 = r6
            r21 = r8
            r40 = r9
            r18 = r10
            r41 = r11
            r22 = r14
            r38 = r24
            r2 = -1
            r14 = 16
            int r3 = r0 + 16
            r12.zzF(r3)
            r12.zzG(r14)
            int r3 = r12.zzo()
            int r4 = r12.zzo()
            r5 = 50
            r12.zzG(r5)
            int r5 = r12.zzc()
            if (r15 != r7) goto L_0x0400
            r6 = r22
            android.util.Pair r8 = zzj(r12, r0, r6)
            if (r8 == 0) goto L_0x03f5
            java.lang.Object r7 = r8.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = r62
            r10 = r12
            if (r9 != 0) goto L_0x03e1
            r11 = 0
            goto L_0x03eb
        L_0x03e1:
            java.lang.Object r11 = r8.second
            com.google.android.gms.internal.ads.zzafw r11 = (com.google.android.gms.internal.ads.zzafw) r11
            java.lang.String r11 = r11.zzb
            com.google.android.gms.internal.ads.zzx r11 = r9.zzb(r11)
        L_0x03eb:
            com.google.android.gms.internal.ads.zzafw[] r12 = r13.zza
            java.lang.Object r8 = r8.second
            com.google.android.gms.internal.ads.zzafw r8 = (com.google.android.gms.internal.ads.zzafw) r8
            r12[r1] = r8
            r15 = r7
            goto L_0x03fc
        L_0x03f5:
            r9 = r62
            r10 = r12
            r11 = r9
            r15 = 1701733238(0x656e6376, float:7.035987E22)
        L_0x03fc:
            r10.zzF(r5)
            goto L_0x0406
        L_0x0400:
            r9 = r62
            r10 = r12
            r6 = r22
            r11 = r9
        L_0x0406:
            r7 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r15 != r7) goto L_0x0411
            java.lang.String r7 = "video/mpeg"
            r8 = r7
            r7 = r15
            goto L_0x041c
        L_0x0411:
            r7 = 1211250227(0x48323633, float:182488.8)
            if (r15 != r7) goto L_0x041a
            java.lang.String r8 = "video/3gpp"
            goto L_0x041c
        L_0x041a:
            r7 = r15
            r8 = 0
        L_0x041c:
            r12 = 1065353216(0x3f800000, float:1.0)
            r19 = r1
            r2 = r5
            r9 = r8
            r35 = r11
            r1 = 0
            r5 = -1
            r8 = 0
            r14 = 0
            r15 = 0
            r22 = -1
            r23 = -1
            r24 = 0
            r25 = 0
            r34 = -1
        L_0x0433:
            int r11 = r2 - r0
            if (r11 >= r6) goto L_0x06f6
            r10.zzF(r2)
            int r11 = r10.zzc()
            int r36 = r10.zze()
            if (r36 != 0) goto L_0x0454
            int r36 = r10.zzc()
            r37 = r1
            int r1 = r36 - r0
            if (r1 != r6) goto L_0x0452
            r36 = r0
            goto L_0x06fa
        L_0x0452:
            r1 = 0
            goto L_0x0458
        L_0x0454:
            r37 = r1
            r1 = r36
        L_0x0458:
            if (r1 <= 0) goto L_0x0460
            r36 = r0
            r42 = r6
            r0 = 1
            goto L_0x0465
        L_0x0460:
            r36 = r0
            r42 = r6
            r0 = 0
        L_0x0465:
            java.lang.String r6 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r6)
            int r0 = r10.zze()
            r6 = 1635148611(0x61766343, float:2.8406573E20)
            if (r0 != r6) goto L_0x04a5
            if (r9 != 0) goto L_0x0477
            r0 = 1
            goto L_0x0478
        L_0x0477:
            r0 = 0
        L_0x0478:
            r6 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r6)
            int r11 = r11 + 8
            r10.zzF(r11)
            com.google.android.gms.internal.ads.zzyn r0 = com.google.android.gms.internal.ads.zzyn.zza(r10)
            java.util.List r9 = r0.zza
            int r11 = r0.zzb
            r13.zzc = r11
            if (r8 != 0) goto L_0x048f
            float r12 = r0.zze
        L_0x048f:
            java.lang.String r0 = r0.zzf
            java.lang.String r11 = "video/avc"
            r14 = r0
            r53 = r4
            r46 = r5
            r43 = r7
            r37 = r9
            r9 = r11
        L_0x049e:
            r45 = r13
            r5 = r38
            r4 = 1
            goto L_0x06e3
        L_0x04a5:
            r6 = 1752589123(0x68766343, float:4.6541328E24)
            if (r0 != r6) goto L_0x04d5
            if (r9 != 0) goto L_0x04ae
            r0 = 1
            goto L_0x04af
        L_0x04ae:
            r0 = 0
        L_0x04af:
            r6 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r6)
            int r11 = r11 + 8
            r10.zzF(r11)
            com.google.android.gms.internal.ads.zzzy r0 = com.google.android.gms.internal.ads.zzzy.zza(r10)
            java.util.List r6 = r0.zza
            int r9 = r0.zzb
            r13.zzc = r9
            if (r8 != 0) goto L_0x04c6
            float r12 = r0.zzc
        L_0x04c6:
            java.lang.String r0 = r0.zzd
            java.lang.String r9 = "video/hevc"
            r14 = r0
            r53 = r4
            r46 = r5
            r37 = r6
        L_0x04d2:
            r43 = r7
            goto L_0x049e
        L_0x04d5:
            r6 = 1685480259(0x64766343, float:1.8180206E22)
            if (r0 == r6) goto L_0x06c1
            r6 = 1685485123(0x64767643, float:1.8185683E22)
            if (r0 != r6) goto L_0x04e1
            goto L_0x06c1
        L_0x04e1:
            r6 = 1987076931(0x76706343, float:1.21891066E33)
            if (r0 != r6) goto L_0x04fc
            if (r9 != 0) goto L_0x04ea
            r0 = 1
            goto L_0x04eb
        L_0x04ea:
            r0 = 0
        L_0x04eb:
            r6 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r6)
            r0 = 1987063864(0x76703038, float:1.21789965E33)
            if (r7 != r0) goto L_0x04f8
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x050d
        L_0x04f8:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x050d
        L_0x04fc:
            r6 = 1635135811(0x61763143, float:2.8384055E20)
            if (r0 != r6) goto L_0x0513
            if (r9 != 0) goto L_0x0505
            r0 = 1
            goto L_0x0506
        L_0x0505:
            r0 = 0
        L_0x0506:
            r6 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r6)
            java.lang.String r0 = "video/av01"
        L_0x050d:
            r9 = r0
        L_0x050e:
            r53 = r4
            r46 = r5
            goto L_0x04d2
        L_0x0513:
            r6 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r0 != r6) goto L_0x0536
            if (r24 != 0) goto L_0x051e
            java.nio.ByteBuffer r24 = zzl()
        L_0x051e:
            r0 = r24
            r6 = 21
            r0.position(r6)
            short r6 = r10.zzy()
            r0.putShort(r6)
            short r6 = r10.zzy()
            r0.putShort(r6)
            r24 = r0
            goto L_0x050e
        L_0x0536:
            r6 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r0 != r6) goto L_0x05ad
            if (r24 != 0) goto L_0x0541
            java.nio.ByteBuffer r24 = zzl()
        L_0x0541:
            r0 = r24
            short r6 = r10.zzy()
            short r11 = r10.zzy()
            r43 = r7
            short r7 = r10.zzy()
            r44 = r8
            short r8 = r10.zzy()
            r45 = r13
            short r13 = r10.zzy()
            r46 = r5
            short r5 = r10.zzy()
            r47 = r15
            short r15 = r10.zzy()
            r48 = r12
            short r12 = r10.zzy()
            long r49 = r10.zzs()
            long r51 = r10.zzs()
            r53 = r4
            r4 = 1
            r0.position(r4)
            r0.putShort(r13)
            r0.putShort(r5)
            r0.putShort(r6)
            r0.putShort(r11)
            r0.putShort(r7)
            r0.putShort(r8)
            r0.putShort(r15)
            r0.putShort(r12)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r49 / r5
            int r6 = (int) r5
            short r5 = (short) r6
            r0.putShort(r5)
            r5 = 10000(0x2710, double:4.9407E-320)
            long r5 = r51 / r5
            int r6 = (int) r5
            short r5 = (short) r6
            r0.putShort(r5)
            r24 = r0
        L_0x05a9:
            r5 = r38
            goto L_0x06dd
        L_0x05ad:
            r53 = r4
            r46 = r5
            r43 = r7
            r44 = r8
            r48 = r12
            r45 = r13
            r47 = r15
            r4 = 1
            r5 = 1681012275(0x64323633, float:1.3149704E22)
            if (r0 != r5) goto L_0x05cf
            if (r9 != 0) goto L_0x05c5
            r0 = 1
            goto L_0x05c6
        L_0x05c5:
            r0 = 0
        L_0x05c6:
            r5 = 0
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r5)
            java.lang.String r0 = "video/3gpp"
            r9 = r0
            goto L_0x05a9
        L_0x05cf:
            r5 = 0
            r6 = 1702061171(0x65736473, float:7.183675E22)
            if (r0 != r6) goto L_0x05f5
            if (r9 != 0) goto L_0x05d9
            r0 = 1
            goto L_0x05da
        L_0x05d9:
            r0 = 0
        L_0x05da:
            com.google.android.gms.internal.ads.zzzm.zzb(r0, r5)
            com.google.android.gms.internal.ads.zzaez r0 = zzk(r10, r11)
            java.lang.String r5 = r0.zza
            byte[] r6 = r0.zzb
            if (r6 == 0) goto L_0x05f1
            com.google.android.gms.internal.ads.zzfvn r6 = com.google.android.gms.internal.ads.zzfvn.zzp(r6)
            r37 = r6
        L_0x05f1:
            r25 = r0
            r9 = r5
            goto L_0x05a9
        L_0x05f5:
            r5 = 1885434736(0x70617370, float:2.7909473E29)
            if (r0 != r5) goto L_0x0612
            int r11 = r11 + 8
            r10.zzF(r11)
            int r0 = r10.zzn()
            float r0 = (float) r0
            int r5 = r10.zzn()
            float r5 = (float) r5
            float r0 = r0 / r5
            r12 = r0
            r5 = r38
            r15 = r47
            r8 = 1
            goto L_0x06e3
        L_0x0612:
            r5 = 1937126244(0x73763364, float:1.9506033E31)
            if (r0 != r5) goto L_0x0641
            int r0 = r11 + 8
        L_0x0619:
            int r5 = r0 - r11
            if (r5 >= r1) goto L_0x0639
            r10.zzF(r0)
            int r5 = r10.zze()
            int r6 = r10.zze()
            r7 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r6 != r7) goto L_0x0637
            byte[] r6 = r10.zzH()
            int r5 = r5 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r6, r0, r5)
            goto L_0x063a
        L_0x0637:
            int r0 = r0 + r5
            goto L_0x0619
        L_0x0639:
            r0 = 0
        L_0x063a:
            r15 = r0
            r5 = r38
            r8 = r44
            goto L_0x06e1
        L_0x0641:
            r5 = 1936995172(0x73743364, float:1.9347576E31)
            if (r0 != r5) goto L_0x066a
            int r0 = r10.zzk()
            r5 = 3
            r10.zzG(r5)
            if (r0 != 0) goto L_0x0664
            int r0 = r10.zzk()
            if (r0 == 0) goto L_0x0662
            if (r0 == r4) goto L_0x0660
            r6 = 2
            if (r0 == r6) goto L_0x065e
            if (r0 == r5) goto L_0x0666
            goto L_0x0664
        L_0x065e:
            r5 = 2
            goto L_0x0666
        L_0x0660:
            r5 = 1
            goto L_0x0666
        L_0x0662:
            r5 = 0
            goto L_0x0666
        L_0x0664:
            r5 = r46
        L_0x0666:
            r46 = r5
            goto L_0x05a9
        L_0x066a:
            r5 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r0 != r5) goto L_0x05a9
            int r0 = r10.zze()
            r5 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 == r5) goto L_0x068e
            r5 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r0 != r5) goto L_0x067e
            goto L_0x068e
        L_0x067e:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaex.zzf(r0)
            java.lang.String r5 = "Unsupported color type: "
            java.lang.String r0 = r5.concat(r0)
            r5 = r38
            com.google.android.gms.internal.ads.zzdw.zze(r5, r0)
            goto L_0x06dd
        L_0x068e:
            r5 = r38
            int r0 = r10.zzo()
            int r6 = r10.zzo()
            r7 = 2
            r10.zzG(r7)
            r7 = 19
            if (r1 != r7) goto L_0x06aa
            int r1 = r10.zzk()
            r1 = r1 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x06ab
            r1 = 1
            goto L_0x06ac
        L_0x06aa:
            r7 = r1
        L_0x06ab:
            r1 = 0
        L_0x06ac:
            int r0 = com.google.android.gms.internal.ads.zzq.zza(r0)
            if (r4 == r1) goto L_0x06b4
            r1 = 2
            goto L_0x06b5
        L_0x06b4:
            r1 = 1
        L_0x06b5:
            int r6 = com.google.android.gms.internal.ads.zzq.zzb(r6)
            r34 = r0
            r23 = r1
            r22 = r6
            r1 = r7
            goto L_0x06dd
        L_0x06c1:
            r53 = r4
            r46 = r5
            r43 = r7
            r44 = r8
            r48 = r12
            r45 = r13
            r47 = r15
            r5 = r38
            r4 = 1
            com.google.android.gms.internal.ads.zzze r0 = com.google.android.gms.internal.ads.zzze.zza(r10)
            if (r0 == 0) goto L_0x06dd
            java.lang.String r14 = r0.zza
            java.lang.String r9 = "video/dolby-vision"
        L_0x06dd:
            r8 = r44
            r15 = r47
        L_0x06e1:
            r12 = r48
        L_0x06e3:
            int r2 = r2 + r1
            r38 = r5
            r0 = r36
            r1 = r37
            r6 = r42
            r7 = r43
            r13 = r45
            r5 = r46
            r4 = r53
            goto L_0x0433
        L_0x06f6:
            r36 = r0
            r37 = r1
        L_0x06fa:
            r53 = r4
            r46 = r5
            r42 = r6
            r48 = r12
            r45 = r13
            r47 = r15
            r5 = r38
            r4 = 1
            if (r9 != 0) goto L_0x0713
            r1 = r20
            r2 = r39
            r3 = r45
            goto L_0x078d
        L_0x0713:
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>()
            r1 = r20
            r0.zzG(r1)
            r0.zzS(r9)
            r0.zzx(r14)
            r0.zzX(r3)
            r2 = r53
            r0.zzF(r2)
            r12 = r48
            r0.zzP(r12)
            r2 = r39
            r0.zzR(r2)
            r15 = r47
            r0.zzQ(r15)
            r3 = r46
            r0.zzV(r3)
            r3 = r37
            r0.zzI(r3)
            r9 = r35
            r0.zzB(r9)
            r3 = r34
            r6 = -1
            if (r3 != r6) goto L_0x0759
            r7 = r23
            r8 = r22
            if (r7 != r6) goto L_0x075d
            if (r8 != r6) goto L_0x075d
            if (r24 == 0) goto L_0x076d
            goto L_0x075d
        L_0x0759:
            r8 = r22
            r7 = r23
        L_0x075d:
            com.google.android.gms.internal.ads.zzq r6 = new com.google.android.gms.internal.ads.zzq
            if (r24 == 0) goto L_0x0766
            byte[] r9 = r24.array()
            goto L_0x0767
        L_0x0766:
            r9 = 0
        L_0x0767:
            r6.<init>(r3, r7, r8, r9)
            r0.zzy(r6)
        L_0x076d:
            if (r25 == 0) goto L_0x0785
            long r6 = r25.zzc
            int r3 = com.google.android.gms.internal.ads.zzfxs.zzc(r6)
            r0.zzv(r3)
            long r6 = r25.zzd
            int r3 = com.google.android.gms.internal.ads.zzfxs.zzc(r6)
            r0.zzO(r3)
        L_0x0785:
            com.google.android.gms.internal.ads.zzaf r0 = r0.zzY()
            r3 = r45
            r3.zzb = r0
        L_0x078d:
            int r0 = r36 + r42
            r10.zzF(r0)
            int r0 = r19 + 1
            r12 = r62
            r4 = r2
            r13 = r3
            r24 = r5
            r6 = r10
            r3 = r17
            r10 = r18
            r8 = r21
            r14 = r29
            r9 = r40
            r11 = r41
            r2 = 12
            r7 = 1937007212(0x7374626c, float:1.9362132E31)
            r5 = r1
            r1 = r0
            r0 = r16
            goto L_0x0195
        L_0x07b2:
            r21 = r8
            r40 = r9
            r18 = r10
            r41 = r11
            r3 = r13
            r29 = r14
            r5 = r24
            r4 = 1
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r2 = r41
            com.google.android.gms.internal.ads.zzaev r0 = r2.zza(r0)
            if (r0 == 0) goto L_0x07db
            android.util.Pair r0 = zzh(r0)
            if (r0 == 0) goto L_0x07db
            java.lang.Object r1 = r0.first
            r10 = r1
            long[] r10 = (long[]) r10
            java.lang.Object r0 = r0.second
            long[] r0 = (long[]) r0
            goto L_0x07dd
        L_0x07db:
            r0 = 0
            r10 = 0
        L_0x07dd:
            com.google.android.gms.internal.ads.zzaf r1 = r3.zzb
            if (r1 != 0) goto L_0x07e5
            r0 = r65
            goto L_0x005b
        L_0x07e5:
            com.google.android.gms.internal.ads.zzafv r1 = new com.google.android.gms.internal.ads.zzafv
            int r17 = r18.zza
            r6 = r40
            java.lang.Object r6 = r6.first
            java.lang.Long r6 = (java.lang.Long) r6
            long r19 = r6.longValue()
            com.google.android.gms.internal.ads.zzaf r6 = r3.zzb
            int r7 = r3.zzd
            com.google.android.gms.internal.ads.zzafw[] r8 = r3.zza
            int r3 = r3.zzc
            r16 = r1
            r18 = r21
            r21 = r29
            r23 = r27
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r3
            r29 = r10
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r0 = r65
            r10 = r1
        L_0x0817:
            java.lang.Object r1 = r0.apply(r10)
            r7 = r1
            com.google.android.gms.internal.ads.zzafv r7 = (com.google.android.gms.internal.ads.zzafv) r7
            if (r7 == 0) goto L_0x0df4
            r1 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzaev r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x0df2
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzaev r1 = r1.zza(r2)
            if (r1 == 0) goto L_0x0df0
            r2 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzaev r1 = r1.zza(r2)
            if (r1 == 0) goto L_0x0dee
            r2 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzaew r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x084c
            com.google.android.gms.internal.ads.zzafc r3 = new com.google.android.gms.internal.ads.zzafc
            com.google.android.gms.internal.ads.zzaf r6 = r7.zzf
            r3.<init>(r2, r6)
            goto L_0x085a
        L_0x084c:
            r2 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzaew r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x0de6
            com.google.android.gms.internal.ads.zzafd r3 = new com.google.android.gms.internal.ads.zzafd
            r3.<init>(r2)
        L_0x085a:
            int r2 = r3.zzb()
            if (r2 != 0) goto L_0x0876
            com.google.android.gms.internal.ads.zzafy r1 = new com.google.android.gms.internal.ads.zzafy
            r2 = 0
            long[] r8 = new long[r2]
            int[] r9 = new int[r2]
            r10 = 0
            long[] r11 = new long[r2]
            int[] r12 = new int[r2]
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
        L_0x0872:
            r0 = r32
            goto L_0x0ddc
        L_0x0876:
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzaew r6 = r1.zzb(r6)
            if (r6 != 0) goto L_0x088d
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzaew r6 = r1.zzb(r6)
            if (r6 == 0) goto L_0x088b
            r8 = r6
            r6 = 1
            goto L_0x088f
        L_0x088b:
            r4 = 0
            throw r4
        L_0x088d:
            r8 = r6
            r6 = 0
        L_0x088f:
            com.google.android.gms.internal.ads.zzef r8 = r8.zza
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzaew r9 = r1.zzb(r9)
            if (r9 == 0) goto L_0x0de4
            com.google.android.gms.internal.ads.zzef r9 = r9.zza
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzaew r10 = r1.zzb(r10)
            if (r10 == 0) goto L_0x0de2
            com.google.android.gms.internal.ads.zzef r10 = r10.zza
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzaew r11 = r1.zzb(r11)
            if (r11 == 0) goto L_0x08b3
            com.google.android.gms.internal.ads.zzef r11 = r11.zza
            goto L_0x08b4
        L_0x08b3:
            r11 = 0
        L_0x08b4:
            r12 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzaew r1 = r1.zzb(r12)
            if (r1 == 0) goto L_0x08c0
            com.google.android.gms.internal.ads.zzef r1 = r1.zza
            goto L_0x08c1
        L_0x08c0:
            r1 = 0
        L_0x08c1:
            com.google.android.gms.internal.ads.zzaey r12 = new com.google.android.gms.internal.ads.zzaey
            r12.<init>(r9, r8, r6)
            r6 = 12
            r10.zzF(r6)
            int r8 = r10.zzn()
            r9 = -1
            int r8 = r8 + r9
            int r9 = r10.zzn()
            int r13 = r10.zzn()
            if (r1 == 0) goto L_0x08e3
            r1.zzF(r6)
            int r14 = r1.zzn()
            goto L_0x08e4
        L_0x08e3:
            r14 = 0
        L_0x08e4:
            if (r11 == 0) goto L_0x08f9
            r11.zzF(r6)
            int r6 = r11.zzn()
            if (r6 <= 0) goto L_0x08f6
            int r15 = r11.zzn()
            r4 = -1
            int r15 = r15 + r4
            goto L_0x08fc
        L_0x08f6:
            r4 = -1
            r11 = 0
            goto L_0x08fb
        L_0x08f9:
            r4 = -1
            r6 = 0
        L_0x08fb:
            r15 = -1
        L_0x08fc:
            int r4 = r3.zza()
            com.google.android.gms.internal.ads.zzaf r0 = r7.zzf
            java.lang.String r0 = r0.zzm
            r16 = r9
            r9 = -1
            if (r4 == r9) goto L_0x09ae
            java.lang.String r9 = "audio/raw"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x0921
            java.lang.String r9 = "audio/g711-mlaw"
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x0921
            java.lang.String r9 = "audio/g711-alaw"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x09ae
        L_0x0921:
            if (r8 != 0) goto L_0x09ae
            if (r14 != 0) goto L_0x09ad
            if (r6 != 0) goto L_0x09ad
            int r0 = r12.zza
            long[] r1 = new long[r0]
            int[] r3 = new int[r0]
        L_0x092d:
            boolean r5 = r12.zza()
            if (r5 == 0) goto L_0x093e
            int r5 = r12.zzb
            long r8 = r12.zzd
            r1[r5] = r8
            int r6 = r12.zzc
            r3[r5] = r6
            goto L_0x092d
        L_0x093e:
            long r5 = (long) r13
            r8 = 8192(0x2000, float:1.14794E-41)
            int r8 = r8 / r4
            r9 = 0
            r10 = 0
        L_0x0944:
            if (r9 >= r0) goto L_0x0950
            r11 = r3[r9]
            int r11 = com.google.android.gms.internal.ads.zzen.zze(r11, r8)
            int r10 = r10 + r11
            int r9 = r9 + 1
            goto L_0x0944
        L_0x0950:
            long[] r9 = new long[r10]
            int[] r11 = new int[r10]
            long[] r12 = new long[r10]
            int[] r10 = new int[r10]
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x095d:
            if (r13 >= r0) goto L_0x09a3
            r17 = r3[r13]
            r18 = r1[r13]
            r54 = r17
            r17 = r0
            r0 = r54
        L_0x0969:
            if (r0 <= 0) goto L_0x0997
            int r20 = java.lang.Math.min(r8, r0)
            r9[r16] = r18
            r21 = r1
            int r1 = r4 * r20
            r11[r16] = r1
            int r15 = java.lang.Math.max(r15, r1)
            r1 = r3
            r22 = r4
            long r3 = (long) r14
            long r3 = r3 * r5
            r12[r16] = r3
            r3 = 1
            r10[r16] = r3
            r3 = r11[r16]
            long r3 = (long) r3
            long r18 = r18 + r3
            int r14 = r14 + r20
            int r0 = r0 - r20
            int r16 = r16 + 1
            r3 = r1
            r1 = r21
            r4 = r22
            goto L_0x0969
        L_0x0997:
            r21 = r1
            r1 = r3
            r22 = r4
            int r13 = r13 + 1
            r0 = r17
            r1 = r21
            goto L_0x095d
        L_0x09a3:
            long r0 = (long) r14
            long r5 = r5 * r0
            r0 = r5
            r14 = r10
            r13 = r15
            r15 = r7
            r10 = r9
            goto L_0x0b73
        L_0x09ad:
            r8 = 0
        L_0x09ae:
            long[] r0 = new long[r2]
            int[] r4 = new int[r2]
            long[] r9 = new long[r2]
            r17 = r6
            int[] r6 = new int[r2]
            r20 = r7
            r7 = r13
            r21 = r14
            r18 = r16
            r13 = 0
            r14 = 0
            r19 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r16 = r8
            r8 = 0
        L_0x09cc:
            if (r8 >= r2) goto L_0x0aaa
            r27 = r23
            r23 = 1
        L_0x09d2:
            if (r19 != 0) goto L_0x09f7
            boolean r23 = r12.zza()
            if (r23 == 0) goto L_0x09ef
            r24 = r14
            r29 = r15
            long r14 = r12.zzd
            r30 = r2
            int r2 = r12.zzc
            r19 = r2
            r27 = r14
            r14 = r24
            r15 = r29
            r2 = r30
            goto L_0x09d2
        L_0x09ef:
            r30 = r2
            r24 = r14
            r29 = r15
            r2 = 0
            goto L_0x09ff
        L_0x09f7:
            r30 = r2
            r24 = r14
            r29 = r15
            r2 = r19
        L_0x09ff:
            if (r23 != 0) goto L_0x0a1b
            java.lang.String r2 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzdw.zze(r5, r2)
            long[] r0 = java.util.Arrays.copyOf(r0, r8)
            int[] r4 = java.util.Arrays.copyOf(r4, r8)
            long[] r9 = java.util.Arrays.copyOf(r9, r8)
            int[] r6 = java.util.Arrays.copyOf(r6, r8)
            r2 = r8
            r14 = r24
            goto L_0x0aac
        L_0x0a1b:
            if (r1 == 0) goto L_0x0a36
            r14 = r24
        L_0x0a1f:
            if (r22 != 0) goto L_0x0a32
            if (r21 <= 0) goto L_0x0a2e
            int r22 = r1.zzn()
            int r14 = r1.zze()
            int r21 = r21 + -1
            goto L_0x0a1f
        L_0x0a2e:
            r15 = -1
            r22 = 0
            goto L_0x0a33
        L_0x0a32:
            r15 = -1
        L_0x0a33:
            int r22 = r22 + -1
            goto L_0x0a38
        L_0x0a36:
            r14 = r24
        L_0x0a38:
            r0[r8] = r27
            int r15 = r3.zzc()
            r4[r8] = r15
            if (r15 <= r13) goto L_0x0a46
            r19 = r15
            r15 = r12
            goto L_0x0a49
        L_0x0a46:
            r15 = r12
            r19 = r13
        L_0x0a49:
            long r12 = (long) r14
            long r12 = r25 + r12
            r9[r8] = r12
            if (r11 != 0) goto L_0x0a52
            r12 = 1
            goto L_0x0a53
        L_0x0a52:
            r12 = 0
        L_0x0a53:
            r6[r8] = r12
            r12 = r29
            if (r8 != r12) goto L_0x0a6b
            r13 = 1
            r6[r8] = r13
            int r17 = r17 + -1
            if (r17 <= 0) goto L_0x0a6b
            if (r11 == 0) goto L_0x0a69
            int r12 = r11.zzn()
            r13 = -1
            int r12 = r12 + r13
            goto L_0x0a6b
        L_0x0a69:
            r12 = 0
            throw r12
        L_0x0a6b:
            r23 = r11
            r13 = r12
            long r11 = (long) r7
            long r25 = r25 + r11
            int r11 = r18 + -1
            if (r11 != 0) goto L_0x0a88
            if (r16 <= 0) goto L_0x0a85
            int r7 = r10.zzn()
            int r11 = r10.zze()
            int r16 = r16 + -1
            r18 = r7
            r7 = r11
            goto L_0x0a8a
        L_0x0a85:
            r18 = 0
            goto L_0x0a8a
        L_0x0a88:
            r18 = r11
        L_0x0a8a:
            r11 = r4[r8]
            long r11 = (long) r11
            long r11 = r27 + r11
            r27 = -1
            int r2 = r2 + -1
            int r8 = r8 + 1
            r54 = r19
            r19 = r2
            r2 = r30
            r55 = r15
            r15 = r13
            r13 = r54
            r56 = r11
            r12 = r55
            r11 = r23
            r23 = r56
            goto L_0x09cc
        L_0x0aaa:
            r30 = r2
        L_0x0aac:
            long r7 = (long) r14
            long r7 = r25 + r7
            if (r1 == 0) goto L_0x0ac1
        L_0x0ab1:
            if (r21 <= 0) goto L_0x0ac1
            int r3 = r1.zzn()
            if (r3 == 0) goto L_0x0abb
            r1 = 0
            goto L_0x0ac2
        L_0x0abb:
            r1.zze()
            int r21 = r21 + -1
            goto L_0x0ab1
        L_0x0ac1:
            r1 = 1
        L_0x0ac2:
            if (r17 != 0) goto L_0x0b0f
            if (r18 != 0) goto L_0x0b03
            if (r19 != 0) goto L_0x0af8
            if (r16 != 0) goto L_0x0aee
            if (r22 != 0) goto L_0x0ae3
            if (r1 != 0) goto L_0x0ad9
            r16 = r0
            r15 = r20
            r1 = 0
            r3 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            goto L_0x0b1d
        L_0x0ad9:
            r16 = r0
            r17 = r2
            r18 = r4
            r15 = r20
            goto L_0x0b6a
        L_0x0ae3:
            r16 = r0
            r15 = r20
            r14 = r22
            r3 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            goto L_0x0b1d
        L_0x0aee:
            r12 = r16
            r15 = r20
            r14 = r22
            r3 = 0
            r10 = 0
            r11 = 0
            goto L_0x0b1b
        L_0x0af8:
            r12 = r16
            r11 = r19
            r15 = r20
            r14 = r22
            r3 = 0
            r10 = 0
            goto L_0x0b1b
        L_0x0b03:
            r12 = r16
            r10 = r18
            r11 = r19
            r15 = r20
            r14 = r22
            r3 = 0
            goto L_0x0b1b
        L_0x0b0f:
            r12 = r16
            r3 = r17
            r10 = r18
            r11 = r19
            r15 = r20
            r14 = r22
        L_0x0b1b:
            r16 = r0
        L_0x0b1d:
            int r0 = r15.zza
            r17 = r2
            r2 = 1
            if (r2 == r1) goto L_0x0b27
            java.lang.String r1 = ", ctts invalid"
            goto L_0x0b29
        L_0x0b27:
            java.lang.String r1 = ""
        L_0x0b29:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r18 = r4
            java.lang.String r4 = "Inconsistent stbl box for track "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = ": remainingSynchronizationSamples "
            r2.append(r0)
            r2.append(r3)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r2.append(r0)
            r2.append(r11)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r2.append(r0)
            r2.append(r12)
            java.lang.String r0 = ", remainingSamplesAtTimestampOffset "
            r2.append(r0)
            r2.append(r14)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r5, r0)
        L_0x0b6a:
            r14 = r6
            r0 = r7
            r12 = r9
            r10 = r16
            r2 = r17
            r11 = r18
        L_0x0b73:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r15.zzc
            r3 = r0
            long r3 = com.google.android.gms.internal.ads.zzen.zzw(r3, r5, r7)
            long[] r5 = r15.zzh
            if (r5 != 0) goto L_0x0b98
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r15.zzc
            com.google.android.gms.internal.ads.zzen.zzR(r12, r0, r5)
            com.google.android.gms.internal.ads.zzafy r1 = new com.google.android.gms.internal.ads.zzafy
            r6 = r1
            r7 = r15
            r8 = r10
            r9 = r11
            r10 = r13
            r11 = r12
            r12 = r14
            r13 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0872
        L_0x0b98:
            int r3 = r5.length
            r4 = 1
            if (r3 != r4) goto L_0x0c36
            int r3 = r15.zzb
            if (r3 != r4) goto L_0x0c36
            int r3 = r12.length
            r4 = 2
            if (r3 < r4) goto L_0x0c36
            long[] r3 = r15.zzi
            if (r3 == 0) goto L_0x0c34
            long[] r3 = (long[]) r3
            r4 = 0
            r16 = r3[r4]
            r18 = r5[r4]
            long r3 = r15.zzc
            long r5 = r15.zzd
            r20 = r3
            r22 = r5
            long r3 = com.google.android.gms.internal.ads.zzen.zzw(r18, r20, r22)
            long r18 = r16 + r3
            r3 = r12
            r4 = r0
            r6 = r16
            r8 = r18
            boolean r3 = zzo(r3, r4, r6, r8)
            if (r3 == 0) goto L_0x0c36
            r3 = 0
            r4 = r12[r3]
            long r20 = r16 - r4
            com.google.android.gms.internal.ads.zzaf r3 = r15.zzf
            int r3 = r3.zzA
            long r3 = (long) r3
            long r5 = r15.zzc
            r22 = r3
            r24 = r5
            long r3 = com.google.android.gms.internal.ads.zzen.zzw(r20, r22, r24)
            long r20 = r0 - r18
            com.google.android.gms.internal.ads.zzaf r5 = r15.zzf
            int r5 = r5.zzA
            long r5 = (long) r5
            long r7 = r15.zzc
            r22 = r5
            r24 = r7
            long r5 = com.google.android.gms.internal.ads.zzen.zzw(r20, r22, r24)
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0bfa
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0c36
            r3 = 0
        L_0x0bfa:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0c36
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0c36
            int r0 = (int) r3
            r3 = r59
            r3.zza = r0
            int r0 = (int) r5
            r3.zzb = r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r15.zzc
            com.google.android.gms.internal.ads.zzen.zzR(r12, r0, r4)
            long[] r0 = r15.zzh
            r1 = 0
            r4 = r0[r1]
            long r8 = r15.zzd
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r4, r6, r8)
            com.google.android.gms.internal.ads.zzafy r2 = new com.google.android.gms.internal.ads.zzafy
            r6 = r2
            r7 = r15
            r8 = r10
            r9 = r11
            r10 = r13
            r11 = r12
            r12 = r14
            r13 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0c81
        L_0x0c34:
            r4 = 0
            throw r4
        L_0x0c36:
            r3 = r59
            long[] r4 = r15.zzh
            int r7 = r4.length
            r5 = 1
            if (r7 != r5) goto L_0x0c87
            r5 = 0
            r6 = r4[r5]
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0c86
            long[] r2 = r15.zzi
            if (r2 == 0) goto L_0x0c84
            long[] r2 = (long[]) r2
            r6 = r2[r5]
            r2 = 0
        L_0x0c50:
            int r4 = r12.length
            if (r2 >= r4) goto L_0x0c67
            r4 = r12[r2]
            long r16 = r4 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r15.zzc
            r20 = r4
            long r4 = com.google.android.gms.internal.ads.zzen.zzw(r16, r18, r20)
            r12[r2] = r4
            int r2 = r2 + 1
            goto L_0x0c50
        L_0x0c67:
            long r4 = r15.zzc
            long r16 = r0 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            r20 = r4
            long r0 = com.google.android.gms.internal.ads.zzen.zzw(r16, r18, r20)
            com.google.android.gms.internal.ads.zzafy r2 = new com.google.android.gms.internal.ads.zzafy
            r6 = r2
            r7 = r15
            r8 = r10
            r9 = r11
            r10 = r13
            r11 = r12
            r12 = r14
            r13 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
        L_0x0c81:
            r1 = r2
            goto L_0x0872
        L_0x0c84:
            r0 = 0
            throw r0
        L_0x0c86:
            r7 = 1
        L_0x0c87:
            int r0 = r15.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0c8e
            r0 = 1
            goto L_0x0c8f
        L_0x0c8e:
            r0 = 0
        L_0x0c8f:
            int[] r1 = new int[r7]
            int[] r4 = new int[r7]
            long[] r5 = r15.zzi
            if (r5 == 0) goto L_0x0de0
            long[] r5 = (long[]) r5
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0c9d:
            long[] r3 = r15.zzh
            r16 = r13
            int r13 = r3.length
            if (r6 >= r13) goto L_0x0d01
            r13 = r10
            r17 = r11
            r10 = r5[r6]
            r18 = -1
            int r20 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r20 == 0) goto L_0x0cf2
            r21 = r3[r6]
            r18 = r2
            long r2 = r15.zzc
            r19 = r8
            r20 = r9
            long r8 = r15.zzd
            r23 = r2
            r25 = r8
            long r2 = com.google.android.gms.internal.ads.zzen.zzw(r21, r23, r25)
            r8 = 1
            int r9 = com.google.android.gms.internal.ads.zzen.zzd(r12, r10, r8, r8)
            r1[r6] = r9
            long r10 = r10 + r2
            r2 = 0
            int r3 = com.google.android.gms.internal.ads.zzen.zzb(r12, r10, r0, r2)
            r4[r6] = r3
        L_0x0cd2:
            r3 = r1[r6]
            r9 = r4[r6]
            if (r3 >= r9) goto L_0x0ce3
            r10 = r14[r3]
            r10 = r10 & r8
            if (r10 != 0) goto L_0x0ce3
            int r3 = r3 + 1
            r1[r6] = r3
            r8 = 1
            goto L_0x0cd2
        L_0x0ce3:
            int r8 = r9 - r3
            int r7 = r7 + r8
            r8 = r19
            if (r8 == r3) goto L_0x0cec
            r3 = 1
            goto L_0x0ced
        L_0x0cec:
            r3 = 0
        L_0x0ced:
            r3 = r20 | r3
            r8 = r9
            r9 = r3
            goto L_0x0cf7
        L_0x0cf2:
            r18 = r2
            r20 = r9
            r2 = 0
        L_0x0cf7:
            int r6 = r6 + 1
            r10 = r13
            r13 = r16
            r11 = r17
            r2 = r18
            goto L_0x0c9d
        L_0x0d01:
            r3 = r2
            r20 = r9
            r13 = r10
            r17 = r11
            r2 = 0
            if (r7 == r3) goto L_0x0d0c
            r0 = 1
            goto L_0x0d0d
        L_0x0d0c:
            r0 = 0
        L_0x0d0d:
            r0 = r20 | r0
            if (r0 == 0) goto L_0x0d15
            long[] r3 = new long[r7]
            r8 = r3
            goto L_0x0d16
        L_0x0d15:
            r8 = r13
        L_0x0d16:
            if (r0 == 0) goto L_0x0d1c
            int[] r3 = new int[r7]
            r9 = r3
            goto L_0x0d1e
        L_0x0d1c:
            r9 = r17
        L_0x0d1e:
            r3 = 1
            if (r3 != r0) goto L_0x0d23
            r16 = 0
        L_0x0d23:
            if (r0 == 0) goto L_0x0d28
            int[] r3 = new int[r7]
            goto L_0x0d29
        L_0x0d28:
            r3 = r14
        L_0x0d29:
            long[] r11 = new long[r7]
            r10 = r16
            r5 = 0
            r6 = 0
            r24 = 0
        L_0x0d31:
            long[] r7 = r15.zzh
            int r7 = r7.length
            if (r5 >= r7) goto L_0x0dc2
            long[] r7 = r15.zzi
            r26 = r7[r5]
            r7 = r1[r5]
            r2 = r4[r5]
            if (r0 == 0) goto L_0x0d52
            r16 = r1
            int r1 = r2 - r7
            java.lang.System.arraycopy(r13, r7, r8, r6, r1)
            r28 = r4
            r4 = r17
            java.lang.System.arraycopy(r4, r7, r9, r6, r1)
            java.lang.System.arraycopy(r14, r7, r3, r6, r1)
            goto L_0x0d58
        L_0x0d52:
            r16 = r1
            r28 = r4
            r4 = r17
        L_0x0d58:
            if (r7 >= r2) goto L_0x0da1
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r17 = r2
            long r1 = r15.zzd
            r18 = r24
            r22 = r1
            long r1 = com.google.android.gms.internal.ads.zzen.zzw(r18, r20, r22)
            r18 = r12[r7]
            r20 = r12
            r21 = r13
            long r12 = r18 - r26
            r29 = r3
            r18 = r4
            r3 = 0
            long r33 = java.lang.Math.max(r3, r12)
            r35 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r15.zzc
            r37 = r12
            long r12 = com.google.android.gms.internal.ads.zzen.zzw(r33, r35, r37)
            long r1 = r1 + r12
            r11[r6] = r1
            if (r0 == 0) goto L_0x0d92
            r1 = r9[r6]
            if (r1 <= r10) goto L_0x0d92
            r1 = r18[r7]
            r10 = r1
        L_0x0d92:
            int r6 = r6 + 1
            int r7 = r7 + 1
            r2 = r17
            r4 = r18
            r12 = r20
            r13 = r21
            r3 = r29
            goto L_0x0d58
        L_0x0da1:
            r29 = r3
            r18 = r4
            r20 = r12
            r21 = r13
            r3 = 0
            long[] r1 = r15.zzh
            r12 = r1[r5]
            long r24 = r24 + r12
            int r5 = r5 + 1
            r1 = r16
            r17 = r18
            r12 = r20
            r13 = r21
            r4 = r28
            r3 = r29
            r2 = 0
            goto L_0x0d31
        L_0x0dc2:
            r29 = r3
            long r0 = r15.zzd
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r18 = r24
            r22 = r0
            long r13 = com.google.android.gms.internal.ads.zzen.zzw(r18, r20, r22)
            com.google.android.gms.internal.ads.zzafy r1 = new com.google.android.gms.internal.ads.zzafy
            r6 = r1
            r7 = r15
            r12 = r29
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0872
        L_0x0ddc:
            r0.add(r1)
            goto L_0x0df6
        L_0x0de0:
            r1 = 0
            throw r1
        L_0x0de2:
            r1 = 0
            throw r1
        L_0x0de4:
            r1 = 0
            throw r1
        L_0x0de6:
            r1 = 0
            java.lang.String r0 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x0dee:
            r1 = 0
            throw r1
        L_0x0df0:
            r1 = 0
            throw r1
        L_0x0df2:
            r1 = 0
            throw r1
        L_0x0df4:
            r0 = r32
        L_0x0df6:
            int r15 = r31 + 1
            r1 = r59
            r12 = r62
            r13 = r0
            r0 = r58
            goto L_0x000c
        L_0x0e01:
            r1 = 0
            throw r1
        L_0x0e03:
            r1 = 0
            throw r1
        L_0x0e05:
            r1 = 0
            throw r1
        L_0x0e07:
            r1 = 0
            throw r1
        L_0x0e09:
            r1 = 0
            throw r1
        L_0x0e0b:
            r1 = 0
            throw r1
        L_0x0e0d:
            r1 = 0
            throw r1
        L_0x0e0f:
            r1 = 0
            throw r1
        L_0x0e11:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zzc(com.google.android.gms.internal.ads.zzaev, com.google.android.gms.internal.ads.zzzx, long, com.google.android.gms.internal.ads.zzx, boolean, boolean, com.google.android.gms.internal.ads.zzfsm):java.util.List");
    }

    public static void zzd(zzef zzef) {
        int zzc = zzef.zzc();
        zzef.zzG(4);
        if (zzef.zze() != 1751411826) {
            zzc += 4;
        }
        zzef.zzF(zzc);
    }

    private static int zze(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    private static int zzf(zzef zzef) {
        int zzk = zzef.zzk();
        int i = zzk & 127;
        while ((zzk & 128) == 128) {
            zzk = zzef.zzk();
            i = (i << 7) | (zzk & 127);
        }
        return i;
    }

    private static int zzg(zzef zzef) {
        zzef.zzF(16);
        return zzef.zze();
    }

    private static Pair zzh(zzaev zzaev) {
        zzaew zzb = zzaev.zzb(1701606260);
        if (zzb == null) {
            return null;
        }
        zzef zzef = zzb.zza;
        zzef.zzF(8);
        int zze = zzaex.zze(zzef.zze());
        int zzn = zzef.zzn();
        long[] jArr = new long[zzn];
        long[] jArr2 = new long[zzn];
        int i = 0;
        while (i < zzn) {
            jArr[i] = zze == 1 ? zzef.zzt() : zzef.zzs();
            jArr2[i] = zze == 1 ? zzef.zzr() : (long) zzef.zze();
            if (zzef.zzy() == 1) {
                zzef.zzG(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair zzi(zzef zzef) {
        int i = 8;
        zzef.zzF(8);
        int zze = zzaex.zze(zzef.zze());
        zzef.zzG(zze == 0 ? 8 : 16);
        long zzs = zzef.zzs();
        if (zze == 0) {
            i = 4;
        }
        zzef.zzG(i);
        int zzo = zzef.zzo();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (((zzo >> 10) & 31) + 96));
        sb.append((char) (((zzo >> 5) & 31) + 96));
        sb.append((char) ((zzo & 31) + 96));
        return Pair.create(Long.valueOf(zzs), sb.toString());
    }

    private static Pair zzj(zzef zzef, int i, int i2) throws zzbu {
        Pair pair;
        Integer num;
        zzafw zzafw;
        int i3;
        int i4;
        byte[] bArr;
        zzef zzef2 = zzef;
        int zzc = zzef.zzc();
        while (zzc - i < i2) {
            zzef2.zzF(zzc);
            int zze = zzef.zze();
            boolean z = true;
            zzzm.zzb(zze > 0, "childAtomSize must be positive");
            if (zzef.zze() == 1936289382) {
                int i5 = zzc + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num2 = null;
                while (i5 - zzc < zze) {
                    zzef2.zzF(i5);
                    int zze2 = zzef.zze();
                    int zze3 = zzef.zze();
                    if (zze3 == 1718775137) {
                        num2 = Integer.valueOf(zzef.zze());
                    } else if (zze3 == 1935894637) {
                        zzef2.zzG(4);
                        str = zzef2.zzx(4, zzfsk.zzc);
                    } else if (zze3 == 1935894633) {
                        i6 = i5;
                        i7 = zze2;
                    }
                    i5 += zze2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    zzzm.zzb(num2 != null, "frma atom is mandatory");
                    zzzm.zzb(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = num2;
                            zzafw = null;
                            break;
                        }
                        zzef2.zzF(i8);
                        int zze4 = zzef.zze();
                        if (zzef.zze() == 1952804451) {
                            int zze5 = zzef.zze();
                            zzef2.zzG(1);
                            if (zzaex.zze(zze5) == 0) {
                                zzef2.zzG(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzk = zzef.zzk();
                                i4 = zzk & 15;
                                i3 = (zzk & 240) >> 4;
                            }
                            boolean z2 = zzef.zzk() == 1;
                            int zzk2 = zzef.zzk();
                            byte[] bArr2 = new byte[16];
                            zzef2.zzB(bArr2, 0, 16);
                            if (!z2 || zzk2 != 0) {
                                bArr = null;
                            } else {
                                int zzk3 = zzef.zzk();
                                byte[] bArr3 = new byte[zzk3];
                                zzef2.zzB(bArr3, 0, zzk3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzafw = new zzafw(z2, str, zzk2, bArr2, i3, i4, bArr);
                        } else {
                            Integer num3 = num2;
                            i8 += zze4;
                        }
                    }
                    if (zzafw == null) {
                        z = false;
                    }
                    zzzm.zzb(z, "tenc atom is mandatory");
                    int i9 = zzen.zza;
                    pair = Pair.create(num, zzafw);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzc += zze;
        }
        return null;
    }

    private static zzaez zzk(zzef zzef, int i) {
        zzef.zzF(i + 12);
        zzef.zzG(1);
        zzf(zzef);
        zzef.zzG(2);
        int zzk = zzef.zzk();
        if ((zzk & 128) != 0) {
            zzef.zzG(2);
        }
        if ((zzk & 64) != 0) {
            zzef.zzG(zzef.zzk());
        }
        if ((zzk & 32) != 0) {
            zzef.zzG(2);
        }
        zzef.zzG(1);
        zzf(zzef);
        String zzd = zzbt.zzd(zzef.zzk());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzaez(zzd, (byte[]) null, -1, -1);
        }
        zzef.zzG(4);
        long zzs = zzef.zzs();
        long zzs2 = zzef.zzs();
        zzef.zzG(1);
        int zzf = zzf(zzef);
        byte[] bArr = new byte[zzf];
        zzef.zzB(bArr, 0, zzf);
        return new zzaez(zzd, bArr, zzs2 <= 0 ? -1 : zzs2, zzs > 0 ? zzs : -1);
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:186:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzm(com.google.android.gms.internal.ads.zzef r24, int r25, int r26, int r27, int r28, java.lang.String r29, boolean r30, com.google.android.gms.internal.ads.zzx r31, com.google.android.gms.internal.ads.zzafb r32, int r33) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r31
            r6 = r32
            int r7 = r1 + 16
            r0.zzF(r7)
            r7 = 6
            if (r30 == 0) goto L_0x001e
            int r9 = r24.zzo()
            r0.zzG(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.zzG(r9)
            r9 = 0
        L_0x0024:
            r10 = 20
            r11 = 16
            r12 = 2
            r13 = 1
            if (r9 == 0) goto L_0x004b
            if (r9 != r13) goto L_0x002f
            goto L_0x004b
        L_0x002f:
            if (r9 != r12) goto L_0x004a
            r0.zzG(r11)
            long r14 = r24.zzr()
            double r14 = java.lang.Double.longBitsToDouble(r14)
            long r14 = java.lang.Math.round(r14)
            int r7 = (int) r14
            int r9 = r24.zzn()
            r0.zzG(r10)
            r15 = 0
            goto L_0x0069
        L_0x004a:
            return
        L_0x004b:
            int r14 = r24.zzo()
            r0.zzG(r7)
            int r7 = r24.zzl()
            int r15 = r24.zzc()
            int r15 = r15 + -4
            r0.zzF(r15)
            int r15 = r24.zze()
            if (r9 != r13) goto L_0x0068
            r0.zzG(r11)
        L_0x0068:
            r9 = r14
        L_0x0069:
            int r11 = r24.zzc()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r12 = r25
            if (r12 != r14) goto L_0x009c
            android.util.Pair r12 = zzj(r0, r1, r2)
            if (r12 == 0) goto L_0x0098
            java.lang.Object r14 = r12.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r5 != 0) goto L_0x0086
            r5 = 0
            goto L_0x0090
        L_0x0086:
            java.lang.Object r13 = r12.second
            com.google.android.gms.internal.ads.zzafw r13 = (com.google.android.gms.internal.ads.zzafw) r13
            java.lang.String r13 = r13.zzb
            com.google.android.gms.internal.ads.zzx r5 = r5.zzb(r13)
        L_0x0090:
            com.google.android.gms.internal.ads.zzafw[] r13 = r6.zza
            java.lang.Object r12 = r12.second
            com.google.android.gms.internal.ads.zzafw r12 = (com.google.android.gms.internal.ads.zzafw) r12
            r13[r33] = r12
        L_0x0098:
            r0.zzF(r11)
            r12 = r14
        L_0x009c:
            r13 = 1633889587(0x61632d33, float:2.6191674E20)
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r18 = "audio/raw"
            java.lang.String r10 = "audio/ac4"
            if (r12 != r13) goto L_0x00ad
            java.lang.String r18 = "audio/ac3"
        L_0x00aa:
            r12 = -1
            goto L_0x015f
        L_0x00ad:
            r13 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r12 != r13) goto L_0x00b5
            java.lang.String r18 = "audio/eac3"
            goto L_0x00aa
        L_0x00b5:
            r13 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r12 != r13) goto L_0x00bd
            r18 = r10
            goto L_0x00aa
        L_0x00bd:
            r13 = 1685353315(0x64747363, float:1.803728E22)
            if (r12 != r13) goto L_0x00c5
            java.lang.String r18 = "audio/vnd.dts"
            goto L_0x00aa
        L_0x00c5:
            r13 = 1685353320(0x64747368, float:1.8037286E22)
            if (r12 == r13) goto L_0x015b
            r13 = 1685353324(0x6474736c, float:1.803729E22)
            if (r12 != r13) goto L_0x00d1
            goto L_0x015b
        L_0x00d1:
            r13 = 1685353317(0x64747365, float:1.8037282E22)
            if (r12 != r13) goto L_0x00d9
            java.lang.String r18 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00aa
        L_0x00d9:
            r13 = 1685353336(0x64747378, float:1.8037304E22)
            if (r12 != r13) goto L_0x00e1
            java.lang.String r18 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00aa
        L_0x00e1:
            r13 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r12 != r13) goto L_0x00e9
            java.lang.String r18 = "audio/3gpp"
            goto L_0x00aa
        L_0x00e9:
            r13 = 1935767394(0x73617762, float:1.7863284E31)
            if (r12 != r13) goto L_0x00f1
            java.lang.String r18 = "audio/amr-wb"
            goto L_0x00aa
        L_0x00f1:
            r13 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r12 == r13) goto L_0x0159
            r13 = 1936684916(0x736f7774, float:1.89725E31)
            if (r12 != r13) goto L_0x00fc
            goto L_0x0159
        L_0x00fc:
            r13 = 1953984371(0x74776f73, float:7.841539E31)
            if (r12 != r13) goto L_0x0104
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x015f
        L_0x0104:
            r13 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r12 == r13) goto L_0x0155
            r13 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r12 != r13) goto L_0x010f
            goto L_0x0155
        L_0x010f:
            r13 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r12 != r13) goto L_0x0117
            java.lang.String r18 = "audio/mha1"
            goto L_0x00aa
        L_0x0117:
            r13 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r12 != r13) goto L_0x011f
            java.lang.String r18 = "audio/mhm1"
            goto L_0x00aa
        L_0x011f:
            if (r12 != r14) goto L_0x0124
            java.lang.String r18 = "audio/alac"
            goto L_0x00aa
        L_0x0124:
            r13 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r12 != r13) goto L_0x012d
            java.lang.String r18 = "audio/g711-alaw"
            goto L_0x00aa
        L_0x012d:
            r13 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r12 != r13) goto L_0x0136
            java.lang.String r18 = "audio/g711-mlaw"
            goto L_0x00aa
        L_0x0136:
            r13 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r12 != r13) goto L_0x013f
            java.lang.String r18 = "audio/opus"
            goto L_0x00aa
        L_0x013f:
            r13 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r12 != r13) goto L_0x0148
            java.lang.String r18 = "audio/flac"
            goto L_0x00aa
        L_0x0148:
            r13 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r12 != r13) goto L_0x0151
            java.lang.String r18 = "audio/true-hd"
            goto L_0x00aa
        L_0x0151:
            r12 = -1
            r18 = 0
            goto L_0x015f
        L_0x0155:
            java.lang.String r18 = "audio/mpeg"
            goto L_0x00aa
        L_0x0159:
            r12 = 2
            goto L_0x015f
        L_0x015b:
            java.lang.String r18 = "audio/vnd.dts.hd"
            goto L_0x00aa
        L_0x015f:
            r13 = r18
            r18 = 0
            r20 = 0
            r21 = 0
        L_0x0167:
            int r8 = r11 - r1
            if (r8 >= r2) goto L_0x03a8
            r0.zzF(r11)
            int r8 = r24.zze()
            if (r8 <= 0) goto L_0x0176
            r14 = 1
            goto L_0x0177
        L_0x0176:
            r14 = 0
        L_0x0177:
            java.lang.String r1 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzzm.zzb(r14, r1)
            int r14 = r24.zze()
            r2 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r14 != r2) goto L_0x01a2
            int r1 = r8 + -13
            byte[] r2 = new byte[r1]
            int r14 = r11 + 13
            r0.zzF(r14)
            r14 = 0
            r0.zzB(r2, r14, r1)
            com.google.android.gms.internal.ads.zzfvn r21 = com.google.android.gms.internal.ads.zzfvn.zzp(r2)
            r22 = r12
        L_0x0198:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
        L_0x019b:
            r12 = 0
            r16 = 2
            r17 = 1
            goto L_0x039c
        L_0x01a2:
            r2 = 1702061171(0x65736473, float:7.183675E22)
            if (r14 == r2) goto L_0x0363
            if (r30 == 0) goto L_0x01ff
            r2 = 2002876005(0x77617665, float:4.5729223E33)
            if (r14 != r2) goto L_0x01ff
            int r2 = r24.zzc()
            if (r2 < r11) goto L_0x01b9
            r22 = r2
            r2 = 0
            r14 = 1
            goto L_0x01bd
        L_0x01b9:
            r22 = r2
            r2 = 0
            r14 = 0
        L_0x01bd:
            com.google.android.gms.internal.ads.zzzm.zzb(r14, r2)
            r2 = r22
        L_0x01c2:
            int r14 = r2 - r11
            if (r14 >= r8) goto L_0x01f1
            r0.zzF(r2)
            int r14 = r24.zze()
            if (r14 <= 0) goto L_0x01d3
            r22 = r12
            r12 = 1
            goto L_0x01d6
        L_0x01d3:
            r22 = r12
            r12 = 0
        L_0x01d6:
            com.google.android.gms.internal.ads.zzzm.zzb(r12, r1)
            int r12 = r24.zze()
            r23 = r1
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r12 == r1) goto L_0x01ea
            int r2 = r2 + r14
            r12 = r22
            r1 = r23
            goto L_0x01c2
        L_0x01ea:
            r14 = r2
            r1 = -1
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 0
            goto L_0x01f9
        L_0x01f1:
            r22 = r12
            r1 = -1
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 0
            r14 = -1
        L_0x01f9:
            r16 = 2
            r17 = 1
            goto L_0x036f
        L_0x01ff:
            r22 = r12
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r14 != r1) goto L_0x0218
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r28)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzyj.zzc(r0, r1, r4, r5)
            r6.zzb = r1
        L_0x0215:
            r1 = 20
            goto L_0x0198
        L_0x0218:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r14 != r1) goto L_0x022d
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r28)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzyj.zzd(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x0215
        L_0x022d:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r14 != r1) goto L_0x0271
            int r1 = r11 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r28)
            int r2 = com.google.android.gms.internal.ads.zzym.zza
            r12 = 1
            r0.zzG(r12)
            int r2 = r24.zzk()
            r2 = r2 & 32
            int r2 = r2 >> 5
            if (r12 == r2) goto L_0x024f
            r2 = 44100(0xac44, float:6.1797E-41)
            goto L_0x0252
        L_0x024f:
            r2 = 48000(0xbb80, float:6.7262E-41)
        L_0x0252:
            com.google.android.gms.internal.ads.zzad r12 = new com.google.android.gms.internal.ads.zzad
            r12.<init>()
            r12.zzH(r1)
            r12.zzS(r10)
            r1 = 2
            r12.zzw(r1)
            r12.zzT(r2)
            r12.zzB(r5)
            r12.zzK(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r12.zzY()
            r6.zzb = r1
            goto L_0x0215
        L_0x0271:
            r1 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r14 != r1) goto L_0x0296
            if (r15 <= 0) goto L_0x027f
            r7 = r15
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 2
            goto L_0x019b
        L_0x027f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x0296:
            r1 = 0
            r2 = 1684305011(0x64647473, float:1.6856995E22)
            if (r14 != r2) goto L_0x02bb
            com.google.android.gms.internal.ads.zzad r2 = new com.google.android.gms.internal.ads.zzad
            r2.<init>()
            r2.zzG(r3)
            r2.zzS(r13)
            r2.zzw(r9)
            r2.zzT(r7)
            r2.zzB(r5)
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzY()
            r6.zzb = r2
            goto L_0x0215
        L_0x02bb:
            r2 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r14 != r2) goto L_0x02db
            int r2 = r8 + -8
            byte[] r12 = zza
            int r14 = r12.length
            int r14 = r14 + r2
            byte[] r12 = java.util.Arrays.copyOf(r12, r14)
            int r14 = r11 + 8
            r0.zzF(r14)
            byte[] r14 = zza
            int r14 = r14.length
            r0.zzB(r12, r14, r2)
            java.util.List r21 = com.google.android.gms.internal.ads.zzaag.zza(r12)
            goto L_0x0198
        L_0x02db:
            r2 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r14 != r2) goto L_0x0310
            int r2 = r8 + -12
            int r12 = r2 + 4
            byte[] r12 = new byte[r12]
            r14 = 102(0x66, float:1.43E-43)
            r19 = 0
            r12[r19] = r14
            r14 = 76
            r17 = 1
            r12[r17] = r14
            r14 = 97
            r16 = 2
            r12[r16] = r14
            r14 = 3
            r19 = 67
            r12[r14] = r19
            int r14 = r11 + 12
            r0.zzF(r14)
            r14 = 4
            r0.zzB(r12, r14, r2)
            com.google.android.gms.internal.ads.zzfvn r21 = com.google.android.gms.internal.ads.zzfvn.zzp(r12)
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
        L_0x030d:
            r12 = 0
            goto L_0x039c
        L_0x0310:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r16 = 2
            r17 = 1
            if (r14 != r2) goto L_0x0360
            int r7 = r8 + -12
            byte[] r9 = new byte[r7]
            int r12 = r11 + 12
            r0.zzF(r12)
            r12 = 0
            r0.zzB(r9, r12, r7)
            com.google.android.gms.internal.ads.zzef r7 = new com.google.android.gms.internal.ads.zzef
            r7.<init>((byte[]) r9)
            r14 = 9
            r7.zzF(r14)
            int r14 = r7.zzk()
            r1 = 20
            r7.zzF(r1)
            int r7 = r7.zzn()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            android.util.Pair r7 = android.util.Pair.create(r7, r14)
            java.lang.Object r14 = r7.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            java.lang.Object r7 = r7.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            com.google.android.gms.internal.ads.zzfvn r21 = com.google.android.gms.internal.ads.zzfvn.zzp(r9)
            r9 = r7
            r7 = r14
            goto L_0x039c
        L_0x0360:
            r1 = 20
            goto L_0x030d
        L_0x0363:
            r22 = r12
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 0
            r16 = 2
            r17 = 1
            r14 = r11
            r1 = -1
        L_0x036f:
            if (r14 == r1) goto L_0x039c
            com.google.android.gms.internal.ads.zzaez r13 = zzk(r0, r14)
            java.lang.String r14 = r13.zza
            byte[] r18 = r13.zzb
            if (r18 == 0) goto L_0x0399
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x0393
            com.google.android.gms.internal.ads.zzyf r1 = com.google.android.gms.internal.ads.zzyg.zza(r18)
            int r7 = r1.zza
            int r9 = r1.zzb
            java.lang.String r1 = r1.zzc
            r20 = r1
        L_0x0393:
            com.google.android.gms.internal.ads.zzfvn r1 = com.google.android.gms.internal.ads.zzfvn.zzp(r18)
            r21 = r1
        L_0x0399:
            r18 = r13
            r13 = r14
        L_0x039c:
            int r11 = r11 + r8
            r1 = r26
            r2 = r27
            r12 = r22
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0167
        L_0x03a8:
            r22 = r12
            com.google.android.gms.internal.ads.zzaf r0 = r6.zzb
            if (r0 != 0) goto L_0x03f4
            if (r13 == 0) goto L_0x03f4
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>()
            r0.zzG(r3)
            r0.zzS(r13)
            r1 = r20
            r0.zzx(r1)
            r0.zzw(r9)
            r0.zzT(r7)
            r8 = r22
            r0.zzN(r8)
            r1 = r21
            r0.zzI(r1)
            r0.zzB(r5)
            r0.zzK(r4)
            if (r18 == 0) goto L_0x03ee
            long r1 = r18.zzc
            int r1 = com.google.android.gms.internal.ads.zzfxs.zzc(r1)
            r0.zzv(r1)
            long r1 = r18.zzd
            int r1 = com.google.android.gms.internal.ads.zzfxs.zzc(r1)
            r0.zzO(r1)
        L_0x03ee:
            com.google.android.gms.internal.ads.zzaf r0 = r0.zzY()
            r6.zzb = r0
        L_0x03f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaff.zzm(com.google.android.gms.internal.ads.zzef, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzx, com.google.android.gms.internal.ads.zzafb, int):void");
    }

    private static void zzn(zzef zzef, int i, int i2, int i3, zzafb zzafb) {
        zzef.zzF(i2 + 16);
        zzef.zzv(0);
        String zzv = zzef.zzv(0);
        if (zzv != null) {
            zzad zzad = new zzad();
            zzad.zzG(i3);
            zzad.zzS(zzv);
            zzafb.zzb = zzad.zzY();
        }
    }

    private static boolean zzo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length;
        int i = length - 1;
        int zzf = zzen.zzf(4, 0, i);
        int zzf2 = zzen.zzf(length - 4, 0, i);
        if (jArr[0] > j2 || j2 >= jArr[zzf] || jArr[zzf2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }
}
