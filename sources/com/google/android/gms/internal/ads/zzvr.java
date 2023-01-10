package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzvr extends zzvw {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final zzfwv zzc = zzfwv.zzb(zzux.zza);
    /* access modifiers changed from: private */
    public static final zzfwv zzd = zzfwv.zzb(zzuy.zza);
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    private zzvf zzg;
    private zzvk zzh;
    private zzk zzi;
    private final zzum zzj;

    @Deprecated
    public zzvr() {
        zzvf zzvf = zzvf.zzD;
        throw null;
    }

    protected static int zza(zzaf zzaf, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzaf.zzd)) {
            return 4;
        }
        String zzf2 = zzf(str);
        String zzf3 = zzf(zzaf.zzd);
        if (zzf3 == null || zzf2 == null) {
            if (!z || zzf3 != null) {
                return 0;
            }
            return 1;
        } else if (zzf3.startsWith(zzf2) || zzf2.startsWith(zzf3)) {
            return 3;
        } else {
            if (zzen.zzah(zzf3, "-")[0].equals(zzen.zzah(zzf2, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    protected static String zzf(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0089, code lost:
        if (r8.zzh.zzd(r8.zzi, r9) != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzk(com.google.android.gms.internal.ads.zzvr r8, com.google.android.gms.internal.ads.zzaf r9) {
        /*
            java.lang.Object r0 = r8.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzvf r1 = r8.zzg     // Catch:{ all -> 0x008e }
            boolean r1 = r1.zzP     // Catch:{ all -> 0x008e }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x008b
            boolean r1 = r8.zzf     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x008b
            int r1 = r9.zzz     // Catch:{ all -> 0x008e }
            r4 = 2
            if (r1 <= r4) goto L_0x008b
            java.lang.String r1 = r9.zzm     // Catch:{ all -> 0x008e }
            r5 = 32
            if (r1 != 0) goto L_0x001b
            goto L_0x0065
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008e }
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0042;
                case 187078296: goto L_0x0038;
                case 187078297: goto L_0x002e;
                case 1504578661: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x004c
        L_0x0024:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x002e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 3
            goto L_0x004d
        L_0x0038:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 0
            goto L_0x004d
        L_0x0042:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = 2
            goto L_0x004d
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 == 0) goto L_0x0056
            if (r1 == r3) goto L_0x0056
            if (r1 == r4) goto L_0x0056
            if (r1 == r7) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008e }
            if (r1 < r5) goto L_0x008b
            com.google.android.gms.internal.ads.zzvk r1 = r8.zzh     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008b
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008e }
            if (r1 < r5) goto L_0x008c
            com.google.android.gms.internal.ads.zzvk r1 = r8.zzh     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008c
            boolean r4 = r1.zzg()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x008c
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzvk r1 = r8.zzh     // Catch:{ all -> 0x008e }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzvk r1 = r8.zzh     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzk r8 = r8.zzi     // Catch:{ all -> 0x008e }
            boolean r8 = r1.zzd(r8, r9)     // Catch:{ all -> 0x008e }
            if (r8 == 0) goto L_0x008c
        L_0x008b:
            r2 = 1
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return r2
        L_0x008e:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvr.zzk(com.google.android.gms.internal.ads.zzvr, com.google.android.gms.internal.ads.zzaf):boolean");
    }

    protected static boolean zzm(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static void zzs(zzuh zzuh, zzcu zzcu, Map map) {
        int i = 0;
        while (i < zzuh.zzc) {
            if (((zzcr) zzcu.zzB.get(zzuh.zzb(i))) == null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzt() {
        boolean z;
        zzvk zzvk;
        synchronized (this.zze) {
            z = false;
            if (this.zzg.zzP && !this.zzf && zzen.zza >= 32 && (zzvk = this.zzh) != null && zzvk.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzr();
        }
    }

    private static final Pair zzu(int i, zzvv zzvv, int[][][] iArr, zzvm zzvm, Comparator comparator) {
        Object obj;
        zzvv zzvv2 = zzvv;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzvv2.zzc(i2)) {
                zzuh zzd2 = zzvv2.zzd(i2);
                int i3 = 0;
                while (i3 < zzd2.zzc) {
                    zzcp zzb2 = zzd2.zzb(i3);
                    List zza2 = zzvm.zza(i2, zzb2, iArr[i2][i3]);
                    int i4 = zzb2.zzb;
                    int i5 = 1;
                    boolean[] zArr = new boolean[1];
                    int i6 = 0;
                    while (true) {
                        int i7 = zzb2.zzb;
                        if (i6 > 0) {
                            break;
                        }
                        zzvn zzvn = (zzvn) zza2.get(i6);
                        int zzb3 = zzvn.zzb();
                        if (!zArr[i6] && zzb3 != 0) {
                            if (zzb3 == i5) {
                                obj = zzfvn.zzp(zzvn);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzvn);
                                int i8 = i6 + 1;
                                while (true) {
                                    int i9 = zzb2.zzb;
                                    if (i8 > 0) {
                                        break;
                                    }
                                    zzvn zzvn2 = (zzvn) zza2.get(i8);
                                    if (zzvn2.zzb() == 2 && zzvn.zzc(zzvn2)) {
                                        arrayList2.add(zzvn2);
                                        zArr[i8] = true;
                                    }
                                    i8++;
                                    zzvv zzvv3 = zzvv;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i6++;
                        zzvv zzvv4 = zzvv;
                        i5 = 1;
                    }
                    i3++;
                    zzvv zzvv5 = zzvv;
                }
            }
            zzvm zzvm2 = zzvm;
            i2++;
            zzvv2 = zzvv;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((zzvn) list.get(i10)).zzc;
        }
        zzvn zzvn3 = (zzvn) list.get(0);
        return Pair.create(new zzvs(zzvn3.zzb, iArr2, 0), Integer.valueOf(zzvn3.zza));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.android.gms.internal.ads.zzvt[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: com.google.android.gms.internal.ads.zzun} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: com.google.android.gms.internal.ads.zzvu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: com.google.android.gms.internal.ads.zzvu} */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzvv r24, int[][][] r25, int[] r26, com.google.android.gms.internal.ads.zzsi r27, com.google.android.gms.internal.ads.zzcn r28) throws com.google.android.gms.internal.ads.zzha {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            java.lang.Object r3 = r1.zze
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzvf r4 = r1.zzg     // Catch:{ all -> 0x0232 }
            boolean r5 = r4.zzP     // Catch:{ all -> 0x0232 }
            if (r5 == 0) goto L_0x0023
            int r5 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x0232 }
            r6 = 32
            if (r5 < r6) goto L_0x0023
            com.google.android.gms.internal.ads.zzvk r5 = r1.zzh     // Catch:{ all -> 0x0232 }
            if (r5 == 0) goto L_0x0023
            android.os.Looper r6 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0232 }
            com.google.android.gms.internal.ads.zzdd.zzb(r6)     // Catch:{ all -> 0x0232 }
            r5.zzb(r1, r6)     // Catch:{ all -> 0x0232 }
        L_0x0023:
            monitor-exit(r3)     // Catch:{ all -> 0x0232 }
            r3 = 2
            com.google.android.gms.internal.ads.zzvs[] r5 = new com.google.android.gms.internal.ads.zzvs[r3]
            com.google.android.gms.internal.ads.zzut r6 = new com.google.android.gms.internal.ads.zzut
            r7 = r26
            r6.<init>(r4, r7)
            com.google.android.gms.internal.ads.zzuu r7 = com.google.android.gms.internal.ads.zzuu.zza
            android.util.Pair r6 = zzu(r3, r0, r2, r6, r7)
            if (r6 == 0) goto L_0x0044
            java.lang.Object r7 = r6.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.first
            com.google.android.gms.internal.ads.zzvs r6 = (com.google.android.gms.internal.ads.zzvs) r6
            r5[r7] = r6
        L_0x0044:
            r6 = 0
            r7 = 0
        L_0x0046:
            r8 = 1
            if (r7 >= r3) goto L_0x005c
            int r9 = r0.zzc(r7)
            if (r9 != r3) goto L_0x0059
            com.google.android.gms.internal.ads.zzuh r9 = r0.zzd(r7)
            int r9 = r9.zzc
            if (r9 <= 0) goto L_0x0059
            r7 = 1
            goto L_0x005d
        L_0x0059:
            int r7 = r7 + 1
            goto L_0x0046
        L_0x005c:
            r7 = 0
        L_0x005d:
            com.google.android.gms.internal.ads.zzur r9 = new com.google.android.gms.internal.ads.zzur
            r9.<init>(r1, r4, r7)
            com.google.android.gms.internal.ads.zzus r7 = com.google.android.gms.internal.ads.zzus.zza
            android.util.Pair r7 = zzu(r8, r0, r2, r9, r7)
            if (r7 == 0) goto L_0x0078
            java.lang.Object r9 = r7.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r10 = r7.first
            com.google.android.gms.internal.ads.zzvs r10 = (com.google.android.gms.internal.ads.zzvs) r10
            r5[r9] = r10
        L_0x0078:
            if (r7 != 0) goto L_0x007c
            r7 = 0
            goto L_0x0090
        L_0x007c:
            java.lang.Object r10 = r7.first
            com.google.android.gms.internal.ads.zzvs r10 = (com.google.android.gms.internal.ads.zzvs) r10
            com.google.android.gms.internal.ads.zzcp r10 = r10.zza
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzvs r7 = (com.google.android.gms.internal.ads.zzvs) r7
            int[] r7 = r7.zzb
            r7 = r7[r6]
            com.google.android.gms.internal.ads.zzaf r7 = r10.zzb(r7)
            java.lang.String r7 = r7.zzd
        L_0x0090:
            com.google.android.gms.internal.ads.zzuv r10 = new com.google.android.gms.internal.ads.zzuv
            r10.<init>(r4, r7)
            com.google.android.gms.internal.ads.zzuw r7 = com.google.android.gms.internal.ads.zzuw.zza
            r11 = 3
            android.util.Pair r7 = zzu(r11, r0, r2, r10, r7)
            if (r7 == 0) goto L_0x00ac
            java.lang.Object r10 = r7.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzvs r7 = (com.google.android.gms.internal.ads.zzvs) r7
            r5[r10] = r7
        L_0x00ac:
            r7 = 0
        L_0x00ad:
            if (r7 >= r3) goto L_0x011f
            int r10 = r0.zzc(r7)
            if (r10 == r3) goto L_0x0116
            if (r10 == r8) goto L_0x0116
            if (r10 == r11) goto L_0x0116
            com.google.android.gms.internal.ads.zzuh r10 = r0.zzd(r7)
            r12 = r2[r7]
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x00c4:
            int r11 = r10.zzc
            if (r13 >= r11) goto L_0x0105
            com.google.android.gms.internal.ads.zzcp r11 = r10.zzb(r13)
            r17 = r12[r13]
            r9 = r16
            r3 = 0
        L_0x00d1:
            int r6 = r11.zzb
            if (r3 > 0) goto L_0x00fb
            r6 = r17[r3]
            boolean r8 = r4.zzQ
            boolean r6 = zzm(r6, r8)
            if (r6 == 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzaf r6 = r11.zzb(r3)
            com.google.android.gms.internal.ads.zzva r8 = new com.google.android.gms.internal.ads.zzva
            r2 = r17[r3]
            r8.<init>(r6, r2)
            if (r9 == 0) goto L_0x00f2
            int r2 = r8.compareTo(r9)
            if (r2 <= 0) goto L_0x00f5
        L_0x00f2:
            r15 = r3
            r9 = r8
            r14 = r11
        L_0x00f5:
            int r3 = r3 + 1
            r2 = r25
            r8 = 1
            goto L_0x00d1
        L_0x00fb:
            int r13 = r13 + 1
            r2 = r25
            r16 = r9
            r3 = 2
            r6 = 0
            r8 = 1
            goto L_0x00c4
        L_0x0105:
            if (r14 != 0) goto L_0x0109
            r2 = 0
            goto L_0x0114
        L_0x0109:
            com.google.android.gms.internal.ads.zzvs r2 = new com.google.android.gms.internal.ads.zzvs
            r3 = 1
            int[] r6 = new int[r3]
            r3 = 0
            r6[r3] = r15
            r2.<init>(r14, r6, r3)
        L_0x0114:
            r5[r7] = r2
        L_0x0116:
            int r7 = r7 + 1
            r2 = r25
            r3 = 2
            r6 = 0
            r8 = 1
            r11 = 3
            goto L_0x00ad
        L_0x011f:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            r6 = 2
        L_0x0126:
            if (r3 >= r6) goto L_0x0132
            com.google.android.gms.internal.ads.zzuh r7 = r0.zzd(r3)
            zzs(r7, r4, r2)
            int r3 = r3 + 1
            goto L_0x0126
        L_0x0132:
            com.google.android.gms.internal.ads.zzuh r3 = r24.zze()
            zzs(r3, r4, r2)
            r3 = 0
        L_0x013a:
            if (r3 >= r6) goto L_0x0151
            int r7 = r0.zzc(r3)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r7 = r2.get(r7)
            com.google.android.gms.internal.ads.zzcr r7 = (com.google.android.gms.internal.ads.zzcr) r7
            if (r7 != 0) goto L_0x014f
            int r3 = r3 + 1
            goto L_0x013a
        L_0x014f:
            r3 = 0
            throw r3
        L_0x0151:
            r3 = 0
            r2 = 0
        L_0x0153:
            if (r2 >= r6) goto L_0x017d
            com.google.android.gms.internal.ads.zzuh r6 = r0.zzd(r2)
            boolean r7 = r4.zzg(r2, r6)
            if (r7 != 0) goto L_0x0160
            goto L_0x0178
        L_0x0160:
            com.google.android.gms.internal.ads.zzvh r7 = r4.zze(r2, r6)
            if (r7 == 0) goto L_0x0175
            int r7 = r3.length
            if (r7 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzvs r7 = new com.google.android.gms.internal.ads.zzvs
            r8 = 0
            com.google.android.gms.internal.ads.zzcp r6 = r6.zzb(r8)
            r7.<init>(r6, r3, r8)
            r3 = r7
            goto L_0x0176
        L_0x0175:
            r3 = 0
        L_0x0176:
            r5[r2] = r3
        L_0x0178:
            int r2 = r2 + 1
            r3 = 0
            r6 = 2
            goto L_0x0153
        L_0x017d:
            r2 = 2
            r3 = 0
        L_0x017f:
            if (r3 >= r2) goto L_0x01a1
            int r2 = r0.zzc(r3)
            boolean r6 = r4.zzf(r3)
            if (r6 != 0) goto L_0x019a
            com.google.android.gms.internal.ads.zzfvs r6 = r4.zzC
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x0198
            goto L_0x019a
        L_0x0198:
            r2 = 0
            goto L_0x019d
        L_0x019a:
            r2 = 0
            r5[r3] = r2
        L_0x019d:
            int r3 = r3 + 1
            r2 = 2
            goto L_0x017f
        L_0x01a1:
            r2 = 0
            com.google.android.gms.internal.ads.zzum r3 = r1.zzj
            com.google.android.gms.internal.ads.zzwh r12 = r23.zzp()
            com.google.android.gms.internal.ads.zzfvn r13 = com.google.android.gms.internal.ads.zzun.zzf(r5)
            r6 = 2
            com.google.android.gms.internal.ads.zzvt[] r14 = new com.google.android.gms.internal.ads.zzvt[r6]
            r15 = 0
        L_0x01b0:
            if (r15 >= r6) goto L_0x01f9
            r6 = r5[r15]
            if (r6 == 0) goto L_0x01f1
            int[] r8 = r6.zzb
            int r7 = r8.length
            if (r7 != 0) goto L_0x01bc
            goto L_0x01f1
        L_0x01bc:
            r11 = 1
            if (r7 != r11) goto L_0x01d7
            com.google.android.gms.internal.ads.zzvu r7 = new com.google.android.gms.internal.ads.zzvu
            com.google.android.gms.internal.ads.zzcp r6 = r6.zza
            r16 = 0
            r19 = r8[r16]
            r20 = 0
            r21 = 0
            r22 = 0
            r17 = r7
            r18 = r6
            r17.<init>(r18, r19, r20, r21, r22)
            r18 = 1
            goto L_0x01ee
        L_0x01d7:
            r16 = 0
            com.google.android.gms.internal.ads.zzcp r7 = r6.zza
            r9 = 0
            java.lang.Object r6 = r13.get(r15)
            r17 = r6
            com.google.android.gms.internal.ads.zzfvn r17 = (com.google.android.gms.internal.ads.zzfvn) r17
            r6 = r3
            r10 = r12
            r18 = 1
            r11 = r17
            com.google.android.gms.internal.ads.zzun r7 = r6.zza(r7, r8, r9, r10, r11)
        L_0x01ee:
            r14[r15] = r7
            goto L_0x01f5
        L_0x01f1:
            r16 = 0
            r18 = 1
        L_0x01f5:
            int r15 = r15 + 1
            r6 = 2
            goto L_0x01b0
        L_0x01f9:
            r16 = 0
            com.google.android.gms.internal.ads.zzkc[] r3 = new com.google.android.gms.internal.ads.zzkc[r6]
            r5 = 0
        L_0x01fe:
            if (r5 >= r6) goto L_0x022b
            int r7 = r0.zzc(r5)
            boolean r8 = r4.zzf(r5)
            if (r8 != 0) goto L_0x0225
            com.google.android.gms.internal.ads.zzfvs r8 = r4.zzC
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0217
            goto L_0x0225
        L_0x0217:
            int r7 = r0.zzc(r5)
            r8 = -2
            if (r7 == r8) goto L_0x0222
            r7 = r14[r5]
            if (r7 == 0) goto L_0x0225
        L_0x0222:
            com.google.android.gms.internal.ads.zzkc r7 = com.google.android.gms.internal.ads.zzkc.zza
            goto L_0x0226
        L_0x0225:
            r7 = r2
        L_0x0226:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x01fe
        L_0x022b:
            boolean r0 = r4.zzR
            android.util.Pair r0 = android.util.Pair.create(r3, r14)
            return r0
        L_0x0232:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0232 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvr.zzb(com.google.android.gms.internal.ads.zzvv, int[][][], int[], com.google.android.gms.internal.ads.zzsi, com.google.android.gms.internal.ads.zzcn):android.util.Pair");
    }

    public final zzvf zzc() {
        zzvf zzvf;
        synchronized (this.zze) {
            zzvf = this.zzg;
        }
        return zzvf;
    }

    public final void zzh() {
        zzvk zzvk;
        synchronized (this.zze) {
            if (zzen.zza >= 32 && (zzvk = this.zzh) != null) {
                zzvk.zzc();
            }
        }
        super.zzh();
    }

    public final void zzi(zzk zzk) {
        boolean z;
        synchronized (this.zze) {
            z = !this.zzi.equals(zzk);
            this.zzi = zzk;
        }
        if (z) {
            zzt();
        }
    }

    public final void zzj(zzvd zzvd) {
        boolean z;
        zzvf zzvf = new zzvf(zzvd);
        synchronized (this.zze) {
            z = !this.zzg.equals(zzvf);
            this.zzg = zzvf;
        }
        if (z) {
            if (zzvf.zzP && this.zza == null) {
                zzdw.zze("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzr();
        }
    }

    public final boolean zzl() {
        return true;
    }

    public zzvr(Context context) {
        zzum zzum = new zzum();
        zzvf zzd2 = zzvf.zzd(context);
        this.zze = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzum;
        this.zzg = zzd2;
        this.zzi = zzk.zza;
        boolean z = false;
        if (context != null && zzen.zzX(context)) {
            z = true;
        }
        this.zzf = z;
        if (!z && context != null && zzen.zza >= 32) {
            this.zzh = zzvk.zza(context);
        }
        if (this.zzg.zzP && context == null) {
            zzdw.zze("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
