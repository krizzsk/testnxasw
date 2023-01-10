package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayz extends zzazd {
    private final AtomicReference zza;

    public zzayz() {
        this((zzaze) null);
    }

    protected static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    private static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public final zzayx[] zzb(zzatc[] zzatcArr, zzayt[] zzaytArr, int[][][] iArr) throws zzasi {
        zzaza zzaza;
        zzaza zzaza2;
        int[] iArr2;
        ArrayList arrayList;
        zzays zzays;
        boolean z;
        int i;
        int i2;
        int i3 = 2;
        zzayx[] zzayxArr = new zzayx[2];
        zzayy zzayy = (zzayy) this.zza.get();
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            int i5 = 1;
            if (i4 >= i3) {
                break;
            }
            if (zzatcArr[i4].zzc() == i3) {
                if (!z2) {
                    zzatc zzatc = zzatcArr[i4];
                    zzayt zzayt = zzaytArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i6 = zzayy.zzd;
                    int i7 = zzayy.zze;
                    int i8 = zzayy.zzf;
                    boolean z3 = zzayy.zzc;
                    boolean z4 = zzayy.zzb;
                    int i9 = zzayy.zzi;
                    int i10 = zzayy.zzj;
                    boolean z5 = zzayy.zzk;
                    boolean z6 = zzayy.zzg;
                    boolean z7 = zzayy.zzh;
                    int i11 = 0;
                    zzays zzays2 = null;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = -1;
                    int i15 = -1;
                    while (i11 < zzayt.zzb) {
                        zzays zzb = zzayt.zzb(i11);
                        int i16 = zzb.zza;
                        ArrayList arrayList2 = new ArrayList(i5);
                        int i17 = 0;
                        while (true) {
                            int i18 = zzb.zza;
                            if (i17 > 0) {
                                break;
                            }
                            arrayList2.add(Integer.valueOf(i17));
                            i17++;
                        }
                        int[] iArr4 = iArr3[i11];
                        int i19 = i15;
                        int i20 = 0;
                        while (true) {
                            int i21 = zzb.zza;
                            if (i20 > 0) {
                                break;
                            }
                            zzayt zzayt2 = zzayt;
                            if (zza(iArr4[i20], true)) {
                                zzasw zzb2 = zzb.zzb(i20);
                                if (arrayList2.contains(Integer.valueOf(i20))) {
                                    int i22 = zzb2.zzj;
                                    int i23 = zzb2.zzk;
                                    int i24 = zzb2.zzb;
                                    zzays = zzb;
                                    z = true;
                                } else {
                                    zzays = zzb;
                                    z = false;
                                }
                                if (true != z) {
                                    arrayList = arrayList2;
                                    i = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza2 = zza(iArr4[i20], false);
                                if (zza2) {
                                    i += 1000;
                                }
                                boolean z8 = i > i13;
                                if (i == i13) {
                                    if (zzb2.zza() != i19) {
                                        i2 = zzh(zzb2.zza(), i19);
                                    } else {
                                        i2 = zzh(zzb2.zzb, i14);
                                    }
                                    z8 = !zza2 || !z ? i2 < 0 : i2 > 0;
                                }
                                if (z8) {
                                    i14 = zzb2.zzb;
                                    i19 = zzb2.zza();
                                    i13 = i;
                                    i12 = i20;
                                    zzays2 = zzays;
                                }
                            } else {
                                zzays = zzb;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i20++;
                            zzayt = zzayt2;
                            zzb = zzays;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzayt zzayt3 = zzayt;
                        i11++;
                        i15 = i19;
                        i5 = 1;
                    }
                    if (zzays2 == null) {
                        zzaza2 = null;
                    } else {
                        zzaza2 = new zzaza(zzays2, i12, 0, (Object) null);
                    }
                    zzayxArr[i4] = zzaza2;
                    z2 = zzaza2 != null;
                }
                int i25 = zzaytArr[i4].zzb;
            }
            i4++;
            i3 = 2;
        }
        int i26 = 0;
        boolean z9 = false;
        while (i26 < i3) {
            if (zzatcArr[i26].zzc() == 1 && !z9) {
                zzayt zzayt4 = zzaytArr[i26];
                int[][] iArr5 = iArr[i26];
                String str = zzayy.zza;
                boolean z10 = zzayy.zzh;
                boolean z11 = zzayy.zzb;
                int i27 = -1;
                int i28 = -1;
                int i29 = 0;
                int i30 = 0;
                while (i29 < zzayt4.zzb) {
                    zzays zzb3 = zzayt4.zzb(i29);
                    int[] iArr6 = iArr5[i29];
                    int i31 = i30;
                    int i32 = i28;
                    int i33 = i27;
                    int i34 = 0;
                    while (true) {
                        int i35 = zzb3.zza;
                        if (i34 > 0) {
                            break;
                        }
                        if (zza(iArr6[i34], true)) {
                            zzasw zzb4 = zzb3.zzb(i34);
                            int i36 = iArr6[i34];
                            int i37 = 1 != (zzb4.zzx & 1) ? 1 : 2;
                            if (zza(i36, false)) {
                                i37 += 1000;
                            }
                            if (i37 > i31) {
                                i32 = i34;
                                i33 = i29;
                                i31 = i37;
                            }
                        }
                        i34++;
                    }
                    i29++;
                    i27 = i33;
                    i28 = i32;
                    i30 = i31;
                }
                if (i27 == -1) {
                    zzaza = null;
                } else {
                    zzaza = new zzaza(zzayt4.zzb(i27), i28, 0, (Object) null);
                }
                zzayxArr[i26] = zzaza;
                z9 = zzaza != null;
            }
            i26++;
            i3 = 2;
        }
        return zzayxArr;
    }

    public zzayz(zzaze zzaze) {
        this.zza = new AtomicReference(new zzayy());
    }
}
