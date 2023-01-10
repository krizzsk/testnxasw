package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzafl implements zzzi {
    public static final zzzp zza = zzafh.zza;
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzaf zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zzzl zzD;
    private zzaap[] zzE;
    private zzaap[] zzF;
    private boolean zzG;
    private final List zzd;
    private final SparseArray zze;
    private final zzef zzf;
    private final zzef zzg;
    private final zzef zzh;
    private final byte[] zzi;
    private final zzef zzj;
    private final zzacg zzk;
    private final zzef zzl;
    private final ArrayDeque zzm;
    private final ArrayDeque zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    private zzef zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private zzafk zzy;
    private int zzz;

    static {
        zzad zzad = new zzad();
        zzad.zzS("application/x-emsg");
        zzc = zzad.zzY();
    }

    public zzafl() {
        this(0, (zzel) null);
    }

    private static int zze(int i) throws zzbu {
        if (i >= 0) {
            return i;
        }
        throw zzbu.zza("Unexpected negative value: " + i, (Throwable) null);
    }

    private static zzx zzf(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzaew zzaew = (zzaew) list.get(i);
            if (zzaew.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] zzH = zzaew.zza.zzH();
                UUID zza2 = zzafs.zza(zzH);
                if (zza2 == null) {
                    zzdw.zze("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzw(zza2, (String) null, "video/mp4", zzH));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzx((List) arrayList);
    }

    private final void zzg() {
        this.zzo = 0;
        this.zzr = 0;
    }

    private static void zzh(zzef zzef, int i, zzafx zzafx) throws zzbu {
        zzef.zzF(i + 8);
        int zze2 = zzef.zze() & 16777215;
        if ((zze2 & 1) == 0) {
            boolean z = (zze2 & 2) != 0;
            int zzn2 = zzef.zzn();
            if (zzn2 == 0) {
                Arrays.fill(zzafx.zzl, 0, zzafx.zze, false);
                return;
            }
            int i2 = zzafx.zze;
            if (zzn2 == i2) {
                Arrays.fill(zzafx.zzl, 0, zzn2, z);
                zzafx.zza(zzef.zza());
                zzef zzef2 = zzafx.zzn;
                zzef.zzB(zzef2.zzH(), 0, zzef2.zzd());
                zzafx.zzn.zzF(0);
                zzafx.zzo = false;
                return;
            }
            throw zzbu.zza("Senc sample count " + zzn2 + " is different from fragment sample count" + i2, (Throwable) null);
        }
        throw zzbu.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.gms.internal.ads.zzafk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v20, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(long r47) throws com.google.android.gms.internal.ads.zzbu {
        /*
            r46 = this;
            r0 = r46
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzm
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06ef
            java.util.ArrayDeque r1 = r0.zzm
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzaev r1 = (com.google.android.gms.internal.ads.zzaev) r1
            long r1 = r1.zza
            int r3 = (r1 > r47 ? 1 : (r1 == r47 ? 0 : -1))
            if (r3 != 0) goto L_0x06ef
            java.util.ArrayDeque r1 = r0.zzm
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzaev r2 = (com.google.android.gms.internal.ads.zzaev) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r7 = 8
            r8 = 0
            if (r1 != r3) goto L_0x013e
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzx r1 = zzf(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzaev r3 = r2.zza(r3)
            if (r3 == 0) goto L_0x013d
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List r8 = r3.zzb
            int r8 = r8.size()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 0
        L_0x004d:
            if (r9 >= r8) goto L_0x00b8
            java.util.List r13 = r3.zzb
            java.lang.Object r13 = r13.get(r9)
            com.google.android.gms.internal.ads.zzaew r13 = (com.google.android.gms.internal.ads.zzaew) r13
            int r14 = r13.zzd
            r15 = 1953654136(0x74726578, float:7.6818474E31)
            if (r14 != r15) goto L_0x0096
            com.google.android.gms.internal.ads.zzef r13 = r13.zza
            r13.zzF(r6)
            int r14 = r13.zze()
            int r15 = r13.zze()
            int r10 = r13.zze()
            int r6 = r13.zze()
            int r13 = r13.zze()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.ads.zzafg r11 = new com.google.android.gms.internal.ads.zzafg
            int r15 = r15 + -1
            r11.<init>(r15, r10, r6, r13)
            android.util.Pair r6 = android.util.Pair.create(r14, r11)
            java.lang.Object r10 = r6.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r6 = r6.second
            com.google.android.gms.internal.ads.zzafg r6 = (com.google.android.gms.internal.ads.zzafg) r6
            r12.put(r10, r6)
            goto L_0x00b3
        L_0x0096:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r14 != r6) goto L_0x00b3
            com.google.android.gms.internal.ads.zzef r4 = r13.zza
            r4.zzF(r7)
            int r5 = r4.zze()
            int r5 = com.google.android.gms.internal.ads.zzaex.zze(r5)
            if (r5 != 0) goto L_0x00af
            long r4 = r4.zzs()
            goto L_0x00b3
        L_0x00af:
            long r4 = r4.zzt()
        L_0x00b3:
            int r9 = r9 + 1
            r6 = 12
            goto L_0x004d
        L_0x00b8:
            com.google.android.gms.internal.ads.zzzx r3 = new com.google.android.gms.internal.ads.zzzx
            r3.<init>()
            com.google.android.gms.internal.ads.zzafi r9 = new com.google.android.gms.internal.ads.zzafi
            r9.<init>(r0)
            r7 = 0
            r8 = 0
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzaff.zzc(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray r3 = r0.zze
            int r3 = r3.size()
            if (r3 != 0) goto L_0x010e
            r10 = 0
        L_0x00d6:
            if (r10 >= r2) goto L_0x0107
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzafy r3 = (com.google.android.gms.internal.ads.zzafy) r3
            com.google.android.gms.internal.ads.zzafv r4 = r3.zza
            com.google.android.gms.internal.ads.zzafk r5 = new com.google.android.gms.internal.ads.zzafk
            com.google.android.gms.internal.ads.zzzl r6 = r0.zzD
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzaap r6 = r6.zzv(r10, r7)
            int r7 = r4.zza
            com.google.android.gms.internal.ads.zzafg r7 = zzj(r12, r7)
            r5.<init>(r6, r3, r7)
            android.util.SparseArray r3 = r0.zze
            int r6 = r4.zza
            r3.put(r6, r5)
            long r5 = r0.zzw
            long r3 = r4.zze
            long r3 = java.lang.Math.max(r5, r3)
            r0.zzw = r3
            int r10 = r10 + 1
            goto L_0x00d6
        L_0x0107:
            com.google.android.gms.internal.ads.zzzl r1 = r0.zzD
            r1.zzC()
            goto L_0x0002
        L_0x010e:
            android.util.SparseArray r3 = r0.zze
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0118
            r11 = 1
            goto L_0x0119
        L_0x0118:
            r11 = 0
        L_0x0119:
            com.google.android.gms.internal.ads.zzdd.zzf(r11)
            r10 = 0
        L_0x011d:
            if (r10 >= r2) goto L_0x0002
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzafy r3 = (com.google.android.gms.internal.ads.zzafy) r3
            com.google.android.gms.internal.ads.zzafv r4 = r3.zza
            android.util.SparseArray r5 = r0.zze
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzafk r5 = (com.google.android.gms.internal.ads.zzafk) r5
            int r4 = r4.zza
            com.google.android.gms.internal.ads.zzafg r4 = zzj(r12, r4)
            r5.zzh(r3, r4)
            int r10 = r10 + 1
            goto L_0x011d
        L_0x013d:
            throw r8
        L_0x013e:
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x06d8
            android.util.SparseArray r1 = r0.zze
            byte[] r3 = r0.zzi
            java.util.List r6 = r2.zzc
            int r6 = r6.size()
            r9 = 0
        L_0x014e:
            if (r9 >= r6) goto L_0x0644
            java.util.List r10 = r2.zzc
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzaev r10 = (com.google.android.gms.internal.ads.zzaev) r10
            int r11 = r10.zzd
            r12 = 1953653094(0x74726166, float:7.6813435E31)
            if (r11 != r12) goto L_0x0624
            r11 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzaew r11 = r10.zzb(r11)
            if (r11 == 0) goto L_0x0622
            com.google.android.gms.internal.ads.zzef r11 = r11.zza
            r11.zzF(r7)
            int r12 = r11.zze()
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            r12 = r12 & r13
            int r14 = r11.zze()
            java.lang.Object r14 = r1.get(r14)
            com.google.android.gms.internal.ads.zzafk r14 = (com.google.android.gms.internal.ads.zzafk) r14
            if (r14 != 0) goto L_0x0183
            r14 = r8
            goto L_0x01cc
        L_0x0183:
            r15 = r12 & 1
            if (r15 == 0) goto L_0x0191
            long r4 = r11.zzt()
            com.google.android.gms.internal.ads.zzafx r15 = r14.zzb
            r15.zzb = r4
            r15.zzc = r4
        L_0x0191:
            com.google.android.gms.internal.ads.zzafg r4 = r14.zze
            r5 = r12 & 2
            if (r5 == 0) goto L_0x019e
            int r5 = r11.zze()
            int r5 = r5 + -1
            goto L_0x01a0
        L_0x019e:
            int r5 = r4.zza
        L_0x01a0:
            r15 = r12 & 8
            if (r15 == 0) goto L_0x01a9
            int r15 = r11.zze()
            goto L_0x01ab
        L_0x01a9:
            int r15 = r4.zzb
        L_0x01ab:
            r16 = r12 & 16
            if (r16 == 0) goto L_0x01b6
            int r16 = r11.zze()
            r8 = r16
            goto L_0x01b8
        L_0x01b6:
            int r8 = r4.zzc
        L_0x01b8:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x01c1
            int r4 = r11.zze()
            goto L_0x01c3
        L_0x01c1:
            int r4 = r4.zzd
        L_0x01c3:
            com.google.android.gms.internal.ads.zzafx r11 = r14.zzb
            com.google.android.gms.internal.ads.zzafg r12 = new com.google.android.gms.internal.ads.zzafg
            r12.<init>(r5, r15, r8, r4)
            r11.zza = r12
        L_0x01cc:
            if (r14 != 0) goto L_0x01db
            r18 = r1
            r24 = r2
            r7 = r3
            r22 = r6
            r27 = r9
            r0 = 1
            r1 = 0
            goto L_0x062f
        L_0x01db:
            com.google.android.gms.internal.ads.zzafx r4 = r14.zzb
            long r11 = r4.zzp
            boolean r5 = r4.zzq
            r14.zzi()
            r8 = 1
            r14.zzl = true
            r15 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzaew r15 = r10.zzb(r15)
            if (r15 == 0) goto L_0x020e
            com.google.android.gms.internal.ads.zzef r5 = r15.zza
            r5.zzF(r7)
            int r11 = r5.zze()
            int r11 = com.google.android.gms.internal.ads.zzaex.zze(r11)
            if (r11 != r8) goto L_0x0205
            long r11 = r5.zzt()
            goto L_0x0209
        L_0x0205:
            long r11 = r5.zzs()
        L_0x0209:
            r4.zzp = r11
            r4.zzq = r8
            goto L_0x0212
        L_0x020e:
            r4.zzp = r11
            r4.zzq = r5
        L_0x0212:
            java.util.List r5 = r10.zzb
            int r8 = r5.size()
            r11 = 0
            r12 = 0
            r15 = 0
        L_0x021b:
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            if (r11 >= r8) goto L_0x0245
            java.lang.Object r18 = r5.get(r11)
            r7 = r18
            com.google.android.gms.internal.ads.zzaew r7 = (com.google.android.gms.internal.ads.zzaew) r7
            r18 = r1
            int r1 = r7.zzd
            if (r1 != r13) goto L_0x023e
            com.google.android.gms.internal.ads.zzef r1 = r7.zza
            r7 = 12
            r1.zzF(r7)
            int r1 = r1.zzn()
            if (r1 <= 0) goto L_0x023e
            int r15 = r15 + r1
            int r12 = r12 + 1
        L_0x023e:
            int r11 = r11 + 1
            r1 = r18
            r7 = 8
            goto L_0x021b
        L_0x0245:
            r18 = r1
            r1 = 0
            r14.zzh = r1
            r14.zzg = r1
            r14.zzf = r1
            com.google.android.gms.internal.ads.zzafx r1 = r14.zzb
            r1.zzd = r12
            r1.zze = r15
            int[] r7 = r1.zzg
            int r7 = r7.length
            if (r7 >= r12) goto L_0x0261
            long[] r7 = new long[r12]
            r1.zzf = r7
            int[] r7 = new int[r12]
            r1.zzg = r7
        L_0x0261:
            int[] r7 = r1.zzh
            int r7 = r7.length
            if (r7 >= r15) goto L_0x027a
            int r15 = r15 * 125
            int r15 = r15 / 100
            int[] r7 = new int[r15]
            r1.zzh = r7
            long[] r7 = new long[r15]
            r1.zzi = r7
            boolean[] r7 = new boolean[r15]
            r1.zzj = r7
            boolean[] r7 = new boolean[r15]
            r1.zzl = r7
        L_0x027a:
            r1 = 0
            r7 = 0
            r11 = 0
        L_0x027d:
            r19 = 0
            if (r1 >= r8) goto L_0x03fa
            java.lang.Object r15 = r5.get(r1)
            com.google.android.gms.internal.ads.zzaew r15 = (com.google.android.gms.internal.ads.zzaew) r15
            int r12 = r15.zzd
            if (r12 != r13) goto L_0x03ca
            int r12 = r11 + 1
            com.google.android.gms.internal.ads.zzef r15 = r15.zza
            r13 = 8
            r15.zzF(r13)
            int r13 = r15.zze()
            r17 = 16777215(0xffffff, float:2.3509886E-38)
            r13 = r13 & r17
            r21 = r5
            com.google.android.gms.internal.ads.zzafy r5 = r14.zzd
            com.google.android.gms.internal.ads.zzafv r5 = r5.zza
            r22 = r6
            com.google.android.gms.internal.ads.zzafx r6 = r14.zzb
            r23 = r8
            com.google.android.gms.internal.ads.zzafg r8 = r6.zza
            int r24 = com.google.android.gms.internal.ads.zzen.zza
            r25 = r12
            int[] r12 = r6.zzg
            int r24 = r15.zzn()
            r12[r11] = r24
            long[] r12 = r6.zzf
            r24 = r2
            r26 = r3
            long r2 = r6.zzb
            r12[r11] = r2
            r27 = r13 & 1
            if (r27 == 0) goto L_0x02d2
            int r0 = r15.zze()
            r27 = r9
            r28 = r10
            long r9 = (long) r0
            long r2 = r2 + r9
            r12[r11] = r2
            goto L_0x02d6
        L_0x02d2:
            r27 = r9
            r28 = r10
        L_0x02d6:
            r0 = r13 & 4
            int r2 = r8.zzd
            if (r0 == 0) goto L_0x02e0
            int r2 = r15.zze()
        L_0x02e0:
            r3 = r13 & 256(0x100, float:3.59E-43)
            r9 = r13 & 512(0x200, float:7.175E-43)
            r10 = r13 & 1024(0x400, float:1.435E-42)
            r12 = r13 & 2048(0x800, float:2.87E-42)
            long[] r13 = r5.zzh
            if (r13 == 0) goto L_0x0306
            r29 = r2
            int r2 = r13.length
            r30 = r4
            r4 = 1
            if (r2 != r4) goto L_0x030a
            r2 = 0
            r31 = r13[r2]
            int r4 = (r31 > r19 ? 1 : (r31 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x030a
            long[] r4 = r5.zzi
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzen.zzH(r4)
            long[] r4 = (long[]) r4
            r19 = r4[r2]
            goto L_0x030a
        L_0x0306:
            r29 = r2
            r30 = r4
        L_0x030a:
            int[] r2 = r6.zzh
            long[] r4 = r6.zzi
            boolean[] r13 = r6.zzj
            r31 = r1
            int[] r1 = r6.zzg
            r1 = r1[r11]
            int r1 = r1 + r7
            r39 = r13
            r38 = r14
            long r13 = r5.zzc
            r40 = r4
            long r4 = r6.zzp
        L_0x0321:
            if (r7 >= r1) goto L_0x03bf
            if (r3 == 0) goto L_0x032a
            int r11 = r15.zze()
            goto L_0x032c
        L_0x032a:
            int r11 = r8.zzb
        L_0x032c:
            zze(r11)
            if (r9 == 0) goto L_0x033a
            int r32 = r15.zze()
            r41 = r1
            r1 = r32
            goto L_0x033e
        L_0x033a:
            r41 = r1
            int r1 = r8.zzc
        L_0x033e:
            zze(r1)
            if (r10 == 0) goto L_0x034c
            int r32 = r15.zze()
            r42 = r0
            r0 = r32
            goto L_0x0359
        L_0x034c:
            r42 = r0
            if (r7 != 0) goto L_0x0357
            if (r0 == 0) goto L_0x0356
            r0 = r29
            r7 = 0
            goto L_0x0359
        L_0x0356:
            r7 = 0
        L_0x0357:
            int r0 = r8.zzd
        L_0x0359:
            if (r12 == 0) goto L_0x0368
            int r32 = r15.zze()
            r43 = r3
            r44 = r8
            r45 = r9
            r3 = r32
            goto L_0x036f
        L_0x0368:
            r43 = r3
            r44 = r8
            r45 = r9
            r3 = 0
        L_0x036f:
            long r8 = (long) r3
            long r8 = r8 + r4
            long r32 = r8 - r19
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r13
            long r8 = com.google.android.gms.internal.ads.zzen.zzw(r32, r34, r36)
            r40[r7] = r8
            boolean r3 = r6.zzq
            r32 = r10
            if (r3 != 0) goto L_0x0392
            r3 = r38
            com.google.android.gms.internal.ads.zzafy r10 = r3.zzd
            r33 = r12
            r34 = r13
            long r12 = r10.zzh
            long r8 = r8 + r12
            r40[r7] = r8
            goto L_0x0398
        L_0x0392:
            r33 = r12
            r34 = r13
            r3 = r38
        L_0x0398:
            r2[r7] = r1
            r1 = 16
            int r0 = r0 >> r1
            r1 = 1
            r0 = r0 & r1
            r0 = r0 ^ r1
            if (r1 == r0) goto L_0x03a4
            r0 = 0
            goto L_0x03a5
        L_0x03a4:
            r0 = 1
        L_0x03a5:
            r39[r7] = r0
            long r0 = (long) r11
            long r4 = r4 + r0
            int r7 = r7 + 1
            r38 = r3
            r10 = r32
            r12 = r33
            r13 = r34
            r1 = r41
            r0 = r42
            r3 = r43
            r8 = r44
            r9 = r45
            goto L_0x0321
        L_0x03bf:
            r41 = r1
            r3 = r38
            r6.zzp = r4
            r11 = r25
            r7 = r41
            goto L_0x03e0
        L_0x03ca:
            r31 = r1
            r24 = r2
            r26 = r3
            r30 = r4
            r21 = r5
            r22 = r6
            r23 = r8
            r27 = r9
            r28 = r10
            r3 = r14
            r17 = 16777215(0xffffff, float:2.3509886E-38)
        L_0x03e0:
            int r1 = r31 + 1
            r0 = r46
            r14 = r3
            r5 = r21
            r6 = r22
            r8 = r23
            r2 = r24
            r3 = r26
            r9 = r27
            r10 = r28
            r4 = r30
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            goto L_0x027d
        L_0x03fa:
            r24 = r2
            r26 = r3
            r30 = r4
            r22 = r6
            r27 = r9
            r28 = r10
            r3 = r14
            com.google.android.gms.internal.ads.zzafy r0 = r3.zzd
            com.google.android.gms.internal.ads.zzafv r0 = r0.zza
            r1 = r30
            com.google.android.gms.internal.ads.zzafg r2 = r1.zza
            if (r2 == 0) goto L_0x0620
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzafw r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r10 = r28
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x0498
            if (r0 == 0) goto L_0x0496
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            int r3 = r0.zzd
            r4 = 8
            r2.zzF(r4)
            int r5 = r2.zze()
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0438
            r2.zzG(r4)
        L_0x0438:
            int r4 = r2.zzk()
            int r5 = r2.zzn()
            int r6 = r1.zze
            if (r5 > r6) goto L_0x0477
            if (r4 != 0) goto L_0x045d
            boolean[] r4 = r1.zzl
            r6 = 0
            r7 = 0
        L_0x044a:
            if (r6 >= r5) goto L_0x045b
            int r8 = r2.zzk()
            int r7 = r7 + r8
            if (r8 <= r3) goto L_0x0455
            r8 = 1
            goto L_0x0456
        L_0x0455:
            r8 = 0
        L_0x0456:
            r4[r6] = r8
            int r6 = r6 + 1
            goto L_0x044a
        L_0x045b:
            r4 = 0
            goto L_0x046a
        L_0x045d:
            if (r4 <= r3) goto L_0x0461
            r2 = 1
            goto L_0x0462
        L_0x0461:
            r2 = 0
        L_0x0462:
            int r7 = r4 * r5
            boolean[] r3 = r1.zzl
            r4 = 0
            java.util.Arrays.fill(r3, r4, r5, r2)
        L_0x046a:
            boolean[] r2 = r1.zzl
            int r3 = r1.zze
            java.util.Arrays.fill(r2, r5, r3, r4)
            if (r7 <= 0) goto L_0x0498
            r1.zza(r7)
            goto L_0x0498
        L_0x0477:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saiz sample count "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " is greater than fragment sample count"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x0496:
            r1 = 0
            throw r1
        L_0x0498:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04e6
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r3 = 8
            r2.zzF(r3)
            int r4 = r2.zze()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04b4
            r2.zzG(r3)
        L_0x04b4:
            int r3 = r2.zzn()
            if (r3 != r6) goto L_0x04cf
            long r5 = r1.zzc
            int r3 = com.google.android.gms.internal.ads.zzaex.zze(r4)
            if (r3 != 0) goto L_0x04c7
            long r2 = r2.zzs()
            goto L_0x04cb
        L_0x04c7:
            long r2 = r2.zzt()
        L_0x04cb:
            long r5 = r5 + r2
            r1.zzc = r5
            goto L_0x04e6
        L_0x04cf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zza(r0, r1)
            throw r0
        L_0x04e6:
            r2 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzaew r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04f5
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r3 = 0
            zzh(r2, r3, r1)
        L_0x04f5:
            if (r0 == 0) goto L_0x04fb
            java.lang.String r0 = r0.zzb
            r4 = r0
            goto L_0x04fc
        L_0x04fb:
            r4 = 0
        L_0x04fc:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x04ff:
            java.util.List r5 = r10.zzb
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x053c
            java.util.List r5 = r10.zzb
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.zzaew r5 = (com.google.android.gms.internal.ads.zzaew) r5
            com.google.android.gms.internal.ads.zzef r6 = r5.zza
            int r5 = r5.zzd
            r7 = 1935828848(0x73626770, float:1.7937577E31)
            r8 = 1936025959(0x73656967, float:1.817587E31)
            if (r5 != r7) goto L_0x0528
            r11 = 12
            r6.zzF(r11)
            int r5 = r6.zze()
            if (r5 != r8) goto L_0x0539
            r0 = r6
            goto L_0x0539
        L_0x0528:
            r11 = 12
            r7 = 1936158820(0x73677064, float:1.8336489E31)
            if (r5 != r7) goto L_0x0539
            r6.zzF(r11)
            int r5 = r6.zze()
            if (r5 != r8) goto L_0x0539
            r2 = r6
        L_0x0539:
            int r3 = r3 + 1
            goto L_0x04ff
        L_0x053c:
            r11 = 12
            if (r0 == 0) goto L_0x05d9
            if (r2 != 0) goto L_0x0544
            goto L_0x05d9
        L_0x0544:
            r3 = 8
            r0.zzF(r3)
            int r5 = r0.zze()
            r6 = 4
            r0.zzG(r6)
            int r5 = com.google.android.gms.internal.ads.zzaex.zze(r5)
            r7 = 1
            if (r5 != r7) goto L_0x055b
            r0.zzG(r6)
        L_0x055b:
            int r0 = r0.zze()
            if (r0 != r7) goto L_0x05d2
            r2.zzF(r3)
            int r0 = r2.zze()
            int r0 = com.google.android.gms.internal.ads.zzaex.zze(r0)
            r2.zzG(r6)
            if (r0 != r7) goto L_0x0581
            long r7 = r2.zzs()
            int r0 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x057a
            goto L_0x0587
        L_0x057a:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x0581:
            r3 = 2
            if (r0 < r3) goto L_0x0587
            r2.zzG(r6)
        L_0x0587:
            long r7 = r2.zzs()
            r12 = 1
            int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x05cb
            r0 = 1
            r2.zzG(r0)
            int r3 = r2.zzk()
            r5 = r3 & 240(0xf0, float:3.36E-43)
            int r7 = r5 >> 4
            r8 = r3 & 15
            int r3 = r2.zzk()
            if (r3 != r0) goto L_0x05da
            int r5 = r2.zzk()
            r3 = 16
            byte[] r6 = new byte[r3]
            r9 = 0
            r2.zzB(r6, r9, r3)
            if (r5 != 0) goto L_0x05be
            int r3 = r2.zzk()
            byte[] r12 = new byte[r3]
            r2.zzB(r12, r9, r3)
            r9 = r12
            goto L_0x05bf
        L_0x05be:
            r9 = 0
        L_0x05bf:
            r1.zzk = r0
            com.google.android.gms.internal.ads.zzafw r12 = new com.google.android.gms.internal.ads.zzafw
            r3 = 1
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r1.zzm = r12
            goto L_0x05da
        L_0x05cb:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x05d2:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r0 = com.google.android.gms.internal.ads.zzbu.zzc(r0)
            throw r0
        L_0x05d9:
            r0 = 1
        L_0x05da:
            java.util.List r2 = r10.zzb
            int r2 = r2.size()
            r3 = 0
        L_0x05e1:
            if (r3 >= r2) goto L_0x0619
            java.util.List r4 = r10.zzb
            java.lang.Object r4 = r4.get(r3)
            com.google.android.gms.internal.ads.zzaew r4 = (com.google.android.gms.internal.ads.zzaew) r4
            int r5 = r4.zzd
            r6 = 1970628964(0x75756964, float:3.1109627E32)
            if (r5 != r6) goto L_0x060d
            com.google.android.gms.internal.ads.zzef r4 = r4.zza
            r5 = 8
            r4.zzF(r5)
            r7 = r26
            r6 = 0
            r8 = 16
            r4.zzB(r7, r6, r8)
            byte[] r9 = zzb
            boolean r9 = java.util.Arrays.equals(r7, r9)
            if (r9 == 0) goto L_0x0614
            zzh(r4, r8, r1)
            goto L_0x0614
        L_0x060d:
            r7 = r26
            r5 = 8
            r6 = 0
            r8 = 16
        L_0x0614:
            int r3 = r3 + 1
            r26 = r7
            goto L_0x05e1
        L_0x0619:
            r7 = r26
            r5 = 8
            r6 = 0
            r1 = 0
            goto L_0x0634
        L_0x0620:
            r1 = 0
            throw r1
        L_0x0622:
            r1 = r8
            throw r1
        L_0x0624:
            r18 = r1
            r24 = r2
            r7 = r3
            r22 = r6
            r1 = r8
            r27 = r9
            r0 = 1
        L_0x062f:
            r5 = 8
            r6 = 0
            r11 = 12
        L_0x0634:
            int r9 = r27 + 1
            r0 = r46
            r8 = r1
            r3 = r7
            r1 = r18
            r6 = r22
            r2 = r24
            r7 = 8
            goto L_0x014e
        L_0x0644:
            r1 = r8
            r6 = 0
            java.util.List r0 = r2.zzb
            com.google.android.gms.internal.ads.zzx r0 = zzf(r0)
            r3 = r46
            if (r0 == 0) goto L_0x0694
            android.util.SparseArray r2 = r3.zze
            int r2 = r2.size()
            r4 = 0
        L_0x0657:
            if (r4 >= r2) goto L_0x0694
            android.util.SparseArray r5 = r3.zze
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzafk r5 = (com.google.android.gms.internal.ads.zzafk) r5
            com.google.android.gms.internal.ads.zzafy r7 = r5.zzd
            com.google.android.gms.internal.ads.zzafv r7 = r7.zza
            com.google.android.gms.internal.ads.zzafx r8 = r5.zzb
            com.google.android.gms.internal.ads.zzafg r8 = r8.zza
            int r9 = com.google.android.gms.internal.ads.zzen.zza
            int r8 = r8.zza
            com.google.android.gms.internal.ads.zzafw r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x0676
            java.lang.String r7 = r7.zzb
            goto L_0x0677
        L_0x0676:
            r7 = r1
        L_0x0677:
            com.google.android.gms.internal.ads.zzx r7 = r0.zzb(r7)
            com.google.android.gms.internal.ads.zzafy r8 = r5.zzd
            com.google.android.gms.internal.ads.zzafv r8 = r8.zza
            com.google.android.gms.internal.ads.zzaf r8 = r8.zzf
            com.google.android.gms.internal.ads.zzad r8 = r8.zzb()
            r8.zzB(r7)
            com.google.android.gms.internal.ads.zzaf r7 = r8.zzY()
            com.google.android.gms.internal.ads.zzaap r5 = r5.zza
            r5.zzk(r7)
            int r4 = r4 + 1
            goto L_0x0657
        L_0x0694:
            long r0 = r3.zzv
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x06ec
            android.util.SparseArray r0 = r3.zze
            int r0 = r0.size()
            r10 = 0
        L_0x06a6:
            if (r10 >= r0) goto L_0x06d0
            android.util.SparseArray r1 = r3.zze
            java.lang.Object r1 = r1.valueAt(r10)
            com.google.android.gms.internal.ads.zzafk r1 = (com.google.android.gms.internal.ads.zzafk) r1
            long r4 = r3.zzv
            int r2 = r1.zzf
        L_0x06b4:
            com.google.android.gms.internal.ads.zzafx r6 = r1.zzb
            int r7 = r6.zze
            if (r2 >= r7) goto L_0x06cd
            long[] r7 = r6.zzi
            r8 = r7[r2]
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x06cd
            boolean[] r6 = r6.zzj
            boolean r6 = r6[r2]
            if (r6 == 0) goto L_0x06ca
            r1.zzi = r2
        L_0x06ca:
            int r2 = r2 + 1
            goto L_0x06b4
        L_0x06cd:
            int r10 = r10 + 1
            goto L_0x06a6
        L_0x06d0:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.zzv = r1
            goto L_0x06ec
        L_0x06d8:
            r3 = r0
            java.util.ArrayDeque r0 = r3.zzm
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06ec
            java.util.ArrayDeque r0 = r3.zzm
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaev r0 = (com.google.android.gms.internal.ads.zzaev) r0
            r0.zzc(r2)
        L_0x06ec:
            r0 = r3
            goto L_0x0002
        L_0x06ef:
            r3 = r0
            r46.zzg()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafl.zzi(long):void");
    }

    private static final zzafg zzj(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzafg) sparseArray.valueAt(0);
        }
        zzafg zzafg = (zzafg) sparseArray.get(i);
        if (zzafg != null) {
            return zzafg;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: com.google.android.gms.internal.ads.zzafk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v73, resolved type: com.google.android.gms.internal.ads.zzafk} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzzj r34, com.google.android.gms.internal.ads.zzaai r35) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
        L_0x0004:
            int r2 = r0.zzo
            r3 = 1701671783(0x656d7367, float:7.0083103E22)
            r4 = 1936286840(0x73696478, float:1.8491255E31)
            r5 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0541
            java.lang.String r10 = "FragmentedMp4Extractor"
            if (r2 == r8) goto L_0x02fd
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 3
            if (r2 == r5) goto L_0x029d
            com.google.android.gms.internal.ads.zzafk r2 = r0.zzy
            if (r2 != 0) goto L_0x0099
            android.util.SparseArray r2 = r0.zze
            int r13 = r2.size()
            r14 = r3
            r3 = r7
            r4 = 0
        L_0x002b:
            if (r4 >= r13) goto L_0x0061
            java.lang.Object r16 = r2.valueAt(r4)
            r5 = r16
            com.google.android.gms.internal.ads.zzafk r5 = (com.google.android.gms.internal.ads.zzafk) r5
            boolean r16 = r5.zzl
            if (r16 != 0) goto L_0x0043
            int r11 = r5.zzf
            com.google.android.gms.internal.ads.zzafy r6 = r5.zzd
            int r6 = r6.zzb
            if (r11 == r6) goto L_0x005d
        L_0x0043:
            boolean r6 = r5.zzl
            if (r6 == 0) goto L_0x0052
            int r6 = r5.zzh
            com.google.android.gms.internal.ads.zzafx r11 = r5.zzb
            int r11 = r11.zzd
            if (r6 != r11) goto L_0x0052
            goto L_0x005d
        L_0x0052:
            long r18 = r5.zzd()
            int r6 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x005d
            r3 = r5
            r14 = r18
        L_0x005d:
            int r4 = r4 + 1
            r5 = 2
            goto L_0x002b
        L_0x0061:
            if (r3 != 0) goto L_0x007e
            long r2 = r0.zzt
            long r4 = r34.zzf()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x0077
            r2 = r1
            com.google.android.gms.internal.ads.zzyy r2 = (com.google.android.gms.internal.ads.zzyy) r2
            r2.zzo(r3, r9)
            r33.zzg()
            goto L_0x0004
        L_0x0077:
            java.lang.String r1 = "Offset to end of mdat was negative."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r7)
            throw r1
        L_0x007e:
            long r4 = r3.zzd()
            long r13 = r34.zzf()
            long r4 = r4 - r13
            int r2 = (int) r4
            if (r2 >= 0) goto L_0x0090
            java.lang.String r2 = "Ignoring negative offset to sample data."
            com.google.android.gms.internal.ads.zzdw.zze(r10, r2)
            r2 = 0
        L_0x0090:
            r4 = r1
            com.google.android.gms.internal.ads.zzyy r4 = (com.google.android.gms.internal.ads.zzyy) r4
            r4.zzo(r2, r9)
            r0.zzy = r3
            r2 = r3
        L_0x0099:
            int r3 = r0.zzo
            r4 = 6
            if (r3 != r12) goto L_0x0134
            int r3 = r2.zzb()
            r0.zzz = r3
            int r5 = r2.zzf
            int r6 = r2.zzi
            if (r5 >= r6) goto L_0x00e1
            com.google.android.gms.internal.ads.zzyy r1 = (com.google.android.gms.internal.ads.zzyy) r1
            r1.zzo(r3, r9)
            com.google.android.gms.internal.ads.zzafw r1 = r2.zzf()
            if (r1 != 0) goto L_0x00b6
            goto L_0x00d4
        L_0x00b6:
            com.google.android.gms.internal.ads.zzafx r3 = r2.zzb
            com.google.android.gms.internal.ads.zzef r3 = r3.zzn
            int r1 = r1.zzd
            if (r1 == 0) goto L_0x00c1
            r3.zzG(r1)
        L_0x00c1:
            com.google.android.gms.internal.ads.zzafx r1 = r2.zzb
            int r5 = r2.zzf
            boolean r1 = r1.zzb(r5)
            if (r1 == 0) goto L_0x00d4
            int r1 = r3.zzo()
            int r1 = r1 * 6
            r3.zzG(r1)
        L_0x00d4:
            boolean r1 = r2.zzk()
            if (r1 != 0) goto L_0x00dc
            r0.zzy = r7
        L_0x00dc:
            r0.zzo = r12
        L_0x00de:
            r1 = 0
            goto L_0x029c
        L_0x00e1:
            com.google.android.gms.internal.ads.zzafy r5 = r2.zzd
            com.google.android.gms.internal.ads.zzafv r5 = r5.zza
            int r5 = r5.zzg
            if (r5 != r8) goto L_0x00f5
            int r3 = r3 + -8
            r0.zzz = r3
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r5 = 8
            r3.zzo(r5, r9)
        L_0x00f5:
            com.google.android.gms.internal.ads.zzafy r3 = r2.zzd
            com.google.android.gms.internal.ads.zzafv r3 = r3.zza
            com.google.android.gms.internal.ads.zzaf r3 = r3.zzf
            java.lang.String r3 = r3.zzm
            java.lang.String r5 = "audio/ac4"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0122
            int r3 = r0.zzz
            r5 = 7
            int r3 = r2.zzc(r3, r5)
            r0.zzA = r3
            int r3 = r0.zzz
            com.google.android.gms.internal.ads.zzef r6 = r0.zzj
            com.google.android.gms.internal.ads.zzym.zzb(r3, r6)
            com.google.android.gms.internal.ads.zzaap r3 = r2.zza
            com.google.android.gms.internal.ads.zzef r6 = r0.zzj
            r3.zzq(r6, r5)
            int r3 = r0.zzA
            int r3 = r3 + r5
            r0.zzA = r3
            goto L_0x012a
        L_0x0122:
            int r3 = r0.zzz
            int r3 = r2.zzc(r3, r9)
            r0.zzA = r3
        L_0x012a:
            int r5 = r0.zzz
            int r5 = r5 + r3
            r0.zzz = r5
            r3 = 4
            r0.zzo = r3
            r0.zzB = r9
        L_0x0134:
            com.google.android.gms.internal.ads.zzafy r3 = r2.zzd
            com.google.android.gms.internal.ads.zzafv r3 = r3.zza
            com.google.android.gms.internal.ads.zzaap r5 = r2.zza
            long r10 = r2.zze()
            int r6 = r3.zzj
            if (r6 != 0) goto L_0x0153
        L_0x0142:
            int r3 = r0.zzA
            int r4 = r0.zzz
            if (r3 >= r4) goto L_0x0239
            int r4 = r4 - r3
            int r3 = r5.zze(r1, r4, r9)
            int r4 = r0.zzA
            int r4 = r4 + r3
            r0.zzA = r4
            goto L_0x0142
        L_0x0153:
            com.google.android.gms.internal.ads.zzef r13 = r0.zzg
            byte[] r13 = r13.zzH()
            r13[r9] = r9
            r13[r8] = r9
            r14 = 2
            r13[r14] = r9
            int r14 = r6 + 1
            r15 = 4
            int r6 = 4 - r6
        L_0x0165:
            int r15 = r0.zzA
            int r12 = r0.zzz
            if (r15 >= r12) goto L_0x0239
            int r12 = r0.zzB
            java.lang.String r15 = "video/hevc"
            if (r12 != 0) goto L_0x01da
            r12 = r1
            com.google.android.gms.internal.ads.zzyy r12 = (com.google.android.gms.internal.ads.zzyy) r12
            r12.zzn(r13, r6, r14, r9)
            com.google.android.gms.internal.ads.zzef r12 = r0.zzg
            r12.zzF(r9)
            com.google.android.gms.internal.ads.zzef r12 = r0.zzg
            int r12 = r12.zze()
            if (r12 <= 0) goto L_0x01d3
            int r12 = r12 + -1
            r0.zzB = r12
            com.google.android.gms.internal.ads.zzef r12 = r0.zzf
            r12.zzF(r9)
            com.google.android.gms.internal.ads.zzef r12 = r0.zzf
            r9 = 4
            r5.zzq(r12, r9)
            com.google.android.gms.internal.ads.zzef r12 = r0.zzg
            r5.zzq(r12, r8)
            com.google.android.gms.internal.ads.zzaap[] r12 = r0.zzF
            int r12 = r12.length
            if (r12 <= 0) goto L_0x01c4
            com.google.android.gms.internal.ads.zzaf r12 = r3.zzf
            java.lang.String r12 = r12.zzm
            byte r17 = r13[r9]
            byte[] r9 = com.google.android.gms.internal.ads.zzaaf.zza
            java.lang.String r9 = "video/avc"
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x01b6
            r9 = r17 & 31
            if (r9 == r4) goto L_0x01b4
            goto L_0x01b6
        L_0x01b4:
            r9 = 1
            goto L_0x01c5
        L_0x01b6:
            boolean r9 = r15.equals(r12)
            if (r9 == 0) goto L_0x01c4
            r9 = r17 & 126(0x7e, float:1.77E-43)
            int r9 = r9 >> r8
            r12 = 39
            if (r9 != r12) goto L_0x01c4
            goto L_0x01b4
        L_0x01c4:
            r9 = 0
        L_0x01c5:
            r0.zzC = r9
            int r9 = r0.zzA
            int r9 = r9 + 5
            r0.zzA = r9
            int r9 = r0.zzz
            int r9 = r9 + r6
            r0.zzz = r9
            goto L_0x0235
        L_0x01d3:
            java.lang.String r1 = "Invalid NAL length"
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r7)
            throw r1
        L_0x01da:
            boolean r9 = r0.zzC
            if (r9 == 0) goto L_0x0223
            com.google.android.gms.internal.ads.zzef r9 = r0.zzh
            r9.zzC(r12)
            com.google.android.gms.internal.ads.zzef r9 = r0.zzh
            byte[] r9 = r9.zzH()
            int r12 = r0.zzB
            r4 = r1
            com.google.android.gms.internal.ads.zzyy r4 = (com.google.android.gms.internal.ads.zzyy) r4
            r8 = 0
            r4.zzn(r9, r8, r12, r8)
            com.google.android.gms.internal.ads.zzef r4 = r0.zzh
            int r8 = r0.zzB
            r5.zzq(r4, r8)
            int r4 = r0.zzB
            com.google.android.gms.internal.ads.zzef r8 = r0.zzh
            byte[] r9 = r8.zzH()
            int r8 = r8.zzd()
            int r8 = com.google.android.gms.internal.ads.zzaaf.zzb(r9, r8)
            com.google.android.gms.internal.ads.zzef r9 = r0.zzh
            com.google.android.gms.internal.ads.zzaf r12 = r3.zzf
            java.lang.String r12 = r12.zzm
            boolean r12 = r15.equals(r12)
            r9.zzF(r12)
            com.google.android.gms.internal.ads.zzef r9 = r0.zzh
            r9.zzE(r8)
            com.google.android.gms.internal.ads.zzef r8 = r0.zzh
            com.google.android.gms.internal.ads.zzaap[] r9 = r0.zzF
            com.google.android.gms.internal.ads.zzyv.zza(r10, r8, r9)
            goto L_0x0229
        L_0x0223:
            r4 = 0
            int r8 = r5.zze(r1, r12, r4)
            r4 = r8
        L_0x0229:
            int r8 = r0.zzA
            int r8 = r8 + r4
            r0.zzA = r8
            int r8 = r0.zzB
            int r8 = r8 - r4
            r0.zzB = r8
            r4 = 6
            r8 = 1
        L_0x0235:
            r9 = 0
            r12 = 3
            goto L_0x0165
        L_0x0239:
            int r20 = r2.zza()
            com.google.android.gms.internal.ads.zzafw r1 = r2.zzf()
            if (r1 == 0) goto L_0x0248
            com.google.android.gms.internal.ads.zzaao r1 = r1.zzc
            r23 = r1
            goto L_0x024a
        L_0x0248:
            r23 = r7
        L_0x024a:
            int r1 = r0.zzz
            r22 = 0
            r17 = r5
            r18 = r10
            r21 = r1
            r17.zzs(r18, r20, r21, r22, r23)
        L_0x0257:
            java.util.ArrayDeque r1 = r0.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x028f
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.removeFirst()
            com.google.android.gms.internal.ads.zzafj r1 = (com.google.android.gms.internal.ads.zzafj) r1
            int r3 = r0.zzu
            int r4 = r1.zzc
            int r3 = r3 - r4
            r0.zzu = r3
            long r3 = r1.zza
            boolean r5 = r1.zzb
            if (r5 == 0) goto L_0x0275
            long r3 = r3 + r10
        L_0x0275:
            com.google.android.gms.internal.ads.zzaap[] r5 = r0.zzE
            int r6 = r5.length
            r8 = 0
        L_0x0279:
            if (r8 >= r6) goto L_0x0257
            r12 = r5[r8]
            r15 = 1
            int r9 = r1.zzc
            int r13 = r0.zzu
            r18 = 0
            r17 = r13
            r13 = r3
            r16 = r9
            r12.zzs(r13, r15, r16, r17, r18)
            int r8 = r8 + 1
            goto L_0x0279
        L_0x028f:
            boolean r1 = r2.zzk()
            if (r1 != 0) goto L_0x0297
            r0.zzy = r7
        L_0x0297:
            r1 = 3
            r0.zzo = r1
            goto L_0x00de
        L_0x029c:
            return r1
        L_0x029d:
            android.util.SparseArray r2 = r0.zze
            int r2 = r2.size()
            r6 = r7
            r5 = 0
        L_0x02a5:
            if (r5 >= r2) goto L_0x02c8
            android.util.SparseArray r8 = r0.zze
            java.lang.Object r8 = r8.valueAt(r5)
            com.google.android.gms.internal.ads.zzafk r8 = (com.google.android.gms.internal.ads.zzafk) r8
            com.google.android.gms.internal.ads.zzafx r8 = r8.zzb
            boolean r9 = r8.zzo
            if (r9 == 0) goto L_0x02c5
            long r8 = r8.zzc
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x02c5
            android.util.SparseArray r3 = r0.zze
            java.lang.Object r3 = r3.valueAt(r5)
            r6 = r3
            com.google.android.gms.internal.ads.zzafk r6 = (com.google.android.gms.internal.ads.zzafk) r6
            r3 = r8
        L_0x02c5:
            int r5 = r5 + 1
            goto L_0x02a5
        L_0x02c8:
            if (r6 != 0) goto L_0x02cf
            r2 = 3
            r0.zzo = r2
            goto L_0x0004
        L_0x02cf:
            long r8 = r34.zzf()
            long r3 = r3 - r8
            int r2 = (int) r3
            if (r2 < 0) goto L_0x02f6
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r4 = 0
            r3.zzo(r2, r4)
            com.google.android.gms.internal.ads.zzafx r2 = r6.zzb
            com.google.android.gms.internal.ads.zzef r5 = r2.zzn
            byte[] r6 = r5.zzH()
            int r5 = r5.zzd()
            r3.zzn(r6, r4, r5, r4)
            com.google.android.gms.internal.ads.zzef r3 = r2.zzn
            r3.zzF(r4)
            r2.zzo = r4
            goto L_0x0004
        L_0x02f6:
            java.lang.String r1 = "Offset to encryption data was negative."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r7)
            throw r1
        L_0x02fd:
            long r5 = r0.zzq
            int r2 = (int) r5
            int r5 = r0.zzr
            int r2 = r2 - r5
            com.google.android.gms.internal.ads.zzef r5 = r0.zzs
            if (r5 == 0) goto L_0x0531
            byte[] r6 = r5.zzH()
            r8 = r1
            com.google.android.gms.internal.ads.zzyy r8 = (com.google.android.gms.internal.ads.zzyy) r8
            r9 = 8
            r11 = 0
            r8.zzn(r6, r9, r2, r11)
            com.google.android.gms.internal.ads.zzaew r2 = new com.google.android.gms.internal.ads.zzaew
            int r6 = r0.zzp
            r2.<init>(r6, r5)
            long r5 = r34.zzf()
            java.util.ArrayDeque r8 = r0.zzm
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0334
            java.util.ArrayDeque r3 = r0.zzm
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzaev r3 = (com.google.android.gms.internal.ads.zzaev) r3
            r3.zzd(r2)
            goto L_0x0538
        L_0x0334:
            int r8 = r2.zzd
            if (r8 != r4) goto L_0x03fe
            com.google.android.gms.internal.ads.zzef r2 = r2.zza
            r3 = 8
            r2.zzF(r3)
            int r3 = r2.zze()
            r4 = 4
            r2.zzG(r4)
            long r14 = r2.zzs()
            int r3 = com.google.android.gms.internal.ads.zzaex.zze(r3)
            if (r3 != 0) goto L_0x035a
            long r3 = r2.zzs()
            long r8 = r2.zzs()
            goto L_0x0362
        L_0x035a:
            long r3 = r2.zzt()
            long r8 = r2.zzt()
        L_0x0362:
            long r5 = r5 + r8
            r10 = 1000000(0xf4240, double:4.940656E-318)
            r8 = r3
            r12 = r14
            long r19 = com.google.android.gms.internal.ads.zzen.zzw(r8, r10, r12)
            r8 = 2
            r2.zzG(r8)
            int r12 = r2.zzo()
            int[] r13 = new int[r12]
            long[] r10 = new long[r12]
            long[] r11 = new long[r12]
            long[] r8 = new long[r12]
            r21 = r19
            r9 = 0
        L_0x037f:
            if (r9 >= r12) goto L_0x03d5
            int r17 = r2.zze()
            r23 = -2147483648(0xffffffff80000000, float:-0.0)
            r23 = r17 & r23
            if (r23 != 0) goto L_0x03cd
            long r23 = r2.zzs()
            r25 = 2147483647(0x7fffffff, float:NaN)
            r17 = r17 & r25
            r13[r9] = r17
            r10[r9] = r5
            r8[r9] = r21
            long r3 = r3 + r23
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r7 = r8
            r24 = r9
            r8 = r3
            r25 = r3
            r3 = r10
            r4 = r11
            r10 = r21
            r17 = r12
            r1 = r13
            r12 = r14
            long r21 = com.google.android.gms.internal.ads.zzen.zzw(r8, r10, r12)
            r8 = r7[r24]
            long r8 = r21 - r8
            r4[r24] = r8
            r8 = 4
            r2.zzG(r8)
            r9 = r1[r24]
            long r9 = (long) r9
            long r5 = r5 + r9
            int r9 = r24 + 1
            r13 = r1
            r10 = r3
            r11 = r4
            r8 = r7
            r12 = r17
            r3 = r25
            r7 = 0
            r1 = r34
            goto L_0x037f
        L_0x03cd:
            java.lang.String r1 = "Unhandled indirect reference"
            r2 = 0
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zza(r1, r2)
            throw r1
        L_0x03d5:
            r7 = r8
            r3 = r10
            r4 = r11
            r1 = r13
            java.lang.Long r2 = java.lang.Long.valueOf(r19)
            com.google.android.gms.internal.ads.zzyw r5 = new com.google.android.gms.internal.ads.zzyw
            r5.<init>(r1, r3, r4, r7)
            android.util.Pair r1 = android.util.Pair.create(r2, r5)
            java.lang.Object r2 = r1.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r0.zzx = r2
            com.google.android.gms.internal.ads.zzzl r2 = r0.zzD
            java.lang.Object r1 = r1.second
            com.google.android.gms.internal.ads.zzaal r1 = (com.google.android.gms.internal.ads.zzaal) r1
            r2.zzN(r1)
            r1 = 1
            r0.zzG = r1
            goto L_0x052e
        L_0x03fe:
            if (r8 != r3) goto L_0x052e
            com.google.android.gms.internal.ads.zzef r1 = r2.zza
            com.google.android.gms.internal.ads.zzaap[] r2 = r0.zzE
            int r2 = r2.length
            if (r2 == 0) goto L_0x052e
            r2 = 8
            r1.zzF(r2)
            int r2 = r1.zze()
            int r2 = com.google.android.gms.internal.ads.zzaex.zze(r2)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x046e
            r5 = 1
            if (r2 == r5) goto L_0x0434
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Skipping unsupported emsg version: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzdw.zze(r10, r1)
            goto L_0x052e
        L_0x0434:
            long r5 = r1.zzs()
            long r11 = r1.zzt()
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r5
            long r7 = com.google.android.gms.internal.ads.zzen.zzw(r11, r13, r15)
            long r11 = r1.zzs()
            r13 = 1000(0x3e8, double:4.94E-321)
            long r5 = com.google.android.gms.internal.ads.zzen.zzw(r11, r13, r15)
            long r9 = r1.zzs()
            r2 = 0
            java.lang.String r11 = r1.zzv(r2)
            if (r11 == 0) goto L_0x046c
            java.lang.String r12 = r1.zzv(r2)
            if (r12 == 0) goto L_0x046a
            r28 = r5
            r30 = r9
            r26 = r11
            r27 = r12
            r5 = r3
            r12 = r7
            goto L_0x04b1
        L_0x046a:
            r3 = 0
            throw r3
        L_0x046c:
            r3 = 0
            throw r3
        L_0x046e:
            r2 = 0
            java.lang.String r11 = r1.zzv(r2)
            if (r11 == 0) goto L_0x052c
            java.lang.String r12 = r1.zzv(r2)
            if (r12 == 0) goto L_0x052a
            long r13 = r1.zzs()
            long r5 = r1.zzs()
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r13
            long r15 = com.google.android.gms.internal.ads.zzen.zzw(r5, r7, r9)
            long r5 = r0.zzx
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0495
            long r5 = r5 + r15
            r19 = r5
            goto L_0x0497
        L_0x0495:
            r19 = r3
        L_0x0497:
            long r5 = r1.zzs()
            r7 = 1000(0x3e8, double:4.94E-321)
            r9 = r13
            long r5 = com.google.android.gms.internal.ads.zzen.zzw(r5, r7, r9)
            long r9 = r1.zzs()
            r28 = r5
            r30 = r9
            r26 = r11
            r27 = r12
            r5 = r15
            r12 = r19
        L_0x04b1:
            int r2 = r1.zza()
            byte[] r2 = new byte[r2]
            int r7 = r1.zza()
            r8 = 0
            r1.zzB(r2, r8, r7)
            com.google.android.gms.internal.ads.zzacf r1 = new com.google.android.gms.internal.ads.zzacf
            r25 = r1
            r32 = r2
            r25.<init>(r26, r27, r28, r30, r32)
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            com.google.android.gms.internal.ads.zzacg r7 = r0.zzk
            byte[] r1 = r7.zza(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.zza()
            com.google.android.gms.internal.ads.zzaap[] r7 = r0.zzE
            int r8 = r7.length
            r9 = 0
        L_0x04db:
            if (r9 >= r8) goto L_0x04e9
            r10 = r7[r9]
            r11 = 0
            r2.zzF(r11)
            r10.zzq(r2, r1)
            int r9 = r9 + 1
            goto L_0x04db
        L_0x04e9:
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x04fe
            java.util.ArrayDeque r2 = r0.zzn
            com.google.android.gms.internal.ads.zzafj r3 = new com.google.android.gms.internal.ads.zzafj
            r4 = 1
            r3.<init>(r5, r4, r1)
            r2.addLast(r3)
            int r2 = r0.zzu
            int r2 = r2 + r1
            r0.zzu = r2
            goto L_0x052e
        L_0x04fe:
            java.util.ArrayDeque r2 = r0.zzn
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0517
            java.util.ArrayDeque r2 = r0.zzn
            com.google.android.gms.internal.ads.zzafj r3 = new com.google.android.gms.internal.ads.zzafj
            r4 = 0
            r3.<init>(r12, r4, r1)
            r2.addLast(r3)
            int r2 = r0.zzu
            int r2 = r2 + r1
            r0.zzu = r2
            goto L_0x052e
        L_0x0517:
            com.google.android.gms.internal.ads.zzaap[] r2 = r0.zzE
            int r3 = r2.length
            r4 = 0
        L_0x051b:
            if (r4 >= r3) goto L_0x052e
            r5 = r2[r4]
            r8 = 1
            r10 = 0
            r11 = 0
            r6 = r12
            r9 = r1
            r5.zzs(r6, r8, r9, r10, r11)
            int r4 = r4 + 1
            goto L_0x051b
        L_0x052a:
            r1 = 0
            throw r1
        L_0x052c:
            r1 = 0
            throw r1
        L_0x052e:
            r1 = r34
            goto L_0x0538
        L_0x0531:
            r3 = r1
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r5 = 0
            r3.zzo(r2, r5)
        L_0x0538:
            long r2 = r34.zzf()
            r0.zzi(r2)
            goto L_0x0004
        L_0x0541:
            r5 = 0
            int r2 = r0.zzr
            if (r2 != 0) goto L_0x056e
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            byte[] r2 = r2.zzH()
            r6 = 8
            r7 = 1
            boolean r2 = r1.zzn(r2, r5, r6, r7)
            if (r2 != 0) goto L_0x0557
            r1 = -1
            return r1
        L_0x0557:
            r0.zzr = r6
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            r2.zzF(r5)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            long r5 = r2.zzs()
            r0.zzq = r5
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            int r2 = r2.zze()
            r0.zzp = r2
        L_0x056e:
            long r5 = r0.zzq
            r7 = 1
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0593
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            byte[] r2 = r2.zzH()
            r5 = r1
            com.google.android.gms.internal.ads.zzyy r5 = (com.google.android.gms.internal.ads.zzyy) r5
            r6 = 8
            r7 = 0
            r5.zzn(r2, r6, r6, r7)
            int r2 = r0.zzr
            int r2 = r2 + r6
            r0.zzr = r2
            com.google.android.gms.internal.ads.zzef r2 = r0.zzl
            long r5 = r2.zzt()
            r0.zzq = r5
            goto L_0x05c6
        L_0x0593:
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x05c6
            long r5 = r34.zzd()
            r7 = -1
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x05b7
            java.util.ArrayDeque r2 = r0.zzm
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x05b6
            java.util.ArrayDeque r2 = r0.zzm
            java.lang.Object r2 = r2.peek()
            com.google.android.gms.internal.ads.zzaev r2 = (com.google.android.gms.internal.ads.zzaev) r2
            long r5 = r2.zza
            goto L_0x05b7
        L_0x05b6:
            r5 = r7
        L_0x05b7:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x05c6
            long r7 = r34.zzf()
            long r5 = r5 - r7
            int r2 = r0.zzr
            long r7 = (long) r2
            long r5 = r5 + r7
            r0.zzq = r5
        L_0x05c6:
            long r5 = r0.zzq
            int r2 = r0.zzr
            long r7 = (long) r2
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0749
            long r5 = r34.zzf()
            long r5 = r5 - r7
            int r2 = r0.zzp
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            r8 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r2 == r8) goto L_0x05e0
            if (r2 != r7) goto L_0x05f3
        L_0x05e0:
            boolean r2 = r0.zzG
            if (r2 != 0) goto L_0x05f3
            com.google.android.gms.internal.ads.zzzl r2 = r0.zzD
            com.google.android.gms.internal.ads.zzaak r9 = new com.google.android.gms.internal.ads.zzaak
            long r10 = r0.zzw
            r9.<init>(r10, r5)
            r2.zzN(r9)
            r2 = 1
            r0.zzG = r2
        L_0x05f3:
            int r2 = r0.zzp
            if (r2 != r8) goto L_0x0611
            android.util.SparseArray r2 = r0.zze
            int r2 = r2.size()
            r9 = 0
        L_0x05fe:
            if (r9 >= r2) goto L_0x0611
            android.util.SparseArray r10 = r0.zze
            java.lang.Object r10 = r10.valueAt(r9)
            com.google.android.gms.internal.ads.zzafk r10 = (com.google.android.gms.internal.ads.zzafk) r10
            com.google.android.gms.internal.ads.zzafx r10 = r10.zzb
            r10.zzc = r5
            r10.zzb = r5
            int r9 = r9 + 1
            goto L_0x05fe
        L_0x0611:
            int r2 = r0.zzp
            if (r2 != r7) goto L_0x0622
            r7 = 0
            r0.zzy = r7
            long r2 = r0.zzq
            long r5 = r5 + r2
            r0.zzt = r5
            r2 = 2
            r0.zzo = r2
            goto L_0x0004
        L_0x0622:
            r5 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r2 == r5) goto L_0x0722
            r5 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r5) goto L_0x0722
            r5 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r2 == r5) goto L_0x0722
            r5 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r2 == r5) goto L_0x0722
            r5 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r2 == r5) goto L_0x0722
            if (r2 == r8) goto L_0x0722
            r5 = 1953653094(0x74726166, float:7.6813435E31)
            if (r2 == r5) goto L_0x0722
            r5 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r2 == r5) goto L_0x0722
            r5 = 1701082227(0x65647473, float:6.742798E22)
            if (r2 != r5) goto L_0x064e
            goto L_0x0722
        L_0x064e:
            r5 = 1751411826(0x68646c72, float:4.3148E24)
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == r5) goto L_0x06ed
            r5 = 1835296868(0x6d646864, float:4.418049E27)
            if (r2 == r5) goto L_0x06ed
            r5 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r2 == r5) goto L_0x06ed
            if (r2 == r4) goto L_0x06ed
            r4 = 1937011556(0x73747364, float:1.9367383E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937011827(0x73747473, float:1.9367711E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1668576371(0x63747473, float:4.5093966E21)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937011555(0x73747363, float:1.9367382E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937011578(0x7374737a, float:1.936741E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r2 == r4) goto L_0x06ed
            r4 = 1937011571(0x73747373, float:1.9367401E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1952867444(0x74666474, float:7.3014264E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1952868452(0x74666864, float:7.301914E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1953196132(0x746b6864, float:7.46037E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1953654136(0x74726578, float:7.6818474E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1953658222(0x7472756e, float:7.683823E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1886614376(0x70737368, float:3.013775E29)
            if (r2 == r4) goto L_0x06ed
            r4 = 1935763834(0x7361697a, float:1.785898E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1935763823(0x7361696f, float:1.7858967E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1936027235(0x73656e63, float:1.8177412E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1970628964(0x75756964, float:3.1109627E32)
            if (r2 == r4) goto L_0x06ed
            r4 = 1935828848(0x73626770, float:1.7937577E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1936158820(0x73677064, float:1.8336489E31)
            if (r2 == r4) goto L_0x06ed
            r4 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r2 == r4) goto L_0x06ed
            r4 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r2 == r4) goto L_0x06ed
            if (r2 != r3) goto L_0x06d8
            goto L_0x06ed
        L_0x06d8:
            long r2 = r0.zzq
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x06e6
            r2 = 0
            r0.zzs = r2
            r2 = 1
            r0.zzo = r2
            goto L_0x0004
        L_0x06e6:
            java.lang.String r1 = "Skipping atom with length > 2147483647 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        L_0x06ed:
            int r2 = r0.zzr
            r3 = 8
            if (r2 != r3) goto L_0x071b
            long r4 = r0.zzq
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0714
            com.google.android.gms.internal.ads.zzef r2 = new com.google.android.gms.internal.ads.zzef
            int r5 = (int) r4
            r2.<init>((int) r5)
            com.google.android.gms.internal.ads.zzef r4 = r0.zzl
            byte[] r4 = r4.zzH()
            byte[] r5 = r2.zzH()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r3)
            r0.zzs = r2
            r2 = 1
            r0.zzo = r2
            goto L_0x0004
        L_0x0714:
            java.lang.String r1 = "Leaf atom with length > 2147483647 (unsupported)."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        L_0x071b:
            java.lang.String r1 = "Leaf atom defines extended atom size (unsupported)."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        L_0x0722:
            long r3 = r34.zzf()
            long r5 = r0.zzq
            long r3 = r3 + r5
            r5 = -8
            long r3 = r3 + r5
            java.util.ArrayDeque r5 = r0.zzm
            com.google.android.gms.internal.ads.zzaev r6 = new com.google.android.gms.internal.ads.zzaev
            r6.<init>(r2, r3)
            r5.push(r6)
            long r5 = r0.zzq
            int r2 = r0.zzr
            long r7 = (long) r2
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0744
            r0.zzi(r3)
            goto L_0x0004
        L_0x0744:
            r33.zzg()
            goto L_0x0004
        L_0x0749:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbu r1 = com.google.android.gms.internal.ads.zzbu.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafl.zza(com.google.android.gms.internal.ads.zzzj, com.google.android.gms.internal.ads.zzaai):int");
    }

    public final void zzb(zzzl zzzl) {
        this.zzD = zzzl;
        zzg();
        zzaap[] zzaapArr = new zzaap[2];
        this.zzE = zzaapArr;
        int i = 0;
        zzaap[] zzaapArr2 = (zzaap[]) zzen.zzae(zzaapArr, 0);
        this.zzE = zzaapArr2;
        for (zzaap zzk2 : zzaapArr2) {
            zzk2.zzk(zzc);
        }
        this.zzF = new zzaap[this.zzd.size()];
        int i2 = 100;
        while (i < this.zzF.length) {
            int i3 = i2 + 1;
            zzaap zzv2 = this.zzD.zzv(i2, 3);
            zzv2.zzk((zzaf) this.zzd.get(i));
            this.zzF[i] = zzv2;
            i++;
            i2 = i3;
        }
    }

    public final void zzc(long j, long j2) {
        int size = this.zze.size();
        for (int i = 0; i < size; i++) {
            ((zzafk) this.zze.valueAt(i)).zzi();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j2;
        this.zzm.clear();
        zzg();
    }

    public final boolean zzd(zzzj zzzj) throws IOException {
        return zzafu.zza(zzzj);
    }

    public zzafl(int i, zzel zzel) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzacg();
        this.zzl = new zzef(16);
        this.zzf = new zzef(zzaaf.zza);
        this.zzg = new zzef(5);
        this.zzh = new zzef();
        byte[] bArr = new byte[16];
        this.zzi = bArr;
        this.zzj = new zzef(bArr);
        this.zzm = new ArrayDeque();
        this.zzn = new ArrayDeque();
        this.zze = new SparseArray();
        this.zzw = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzD = zzzl.zza;
        this.zzE = new zzaap[0];
        this.zzF = new zzaap[0];
    }
}
