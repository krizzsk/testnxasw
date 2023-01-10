package com.google.android.gms.internal.ads;

import android.view.View;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsr<T> implements zzgth<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgui.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgso zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzgsc zzn;
    private final zzgty zzo;
    private final zzgqr zzp;
    private final zzgst zzq;
    private final zzgsj zzr;

    private zzgsr(int[] iArr, Object[] objArr, int i, int i2, zzgso zzgso, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgst zzgst, zzgsc zzgsc, zzgty zzgty, zzgqr zzgqr, zzgsj zzgsj, byte[] bArr) {
        zzgso zzgso2 = zzgso;
        zzgqr zzgqr2 = zzgqr;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgso2 instanceof zzgre;
        this.zzj = z;
        boolean z3 = false;
        if (zzgqr2 != null && zzgqr2.zzh(zzgso)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzq = zzgst;
        this.zzn = zzgsc;
        this.zzo = zzgty;
        this.zzp = zzgqr2;
        this.zzg = zzgso2;
        this.zzr = zzgsj;
    }

    private final int zzA(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzC(int i) {
        return this.zzc[i + 1];
    }

    private static long zzD(Object obj, long j) {
        return ((Long) zzgui.zzh(obj, j)).longValue();
    }

    private final zzgri zzE(int i) {
        int i2 = i / 3;
        return (zzgri) this.zzd[i2 + i2 + 1];
    }

    private final zzgth zzF(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgth zzgth = (zzgth) this.zzd[i3];
        if (zzgth != null) {
            return zzgth;
        }
        zzgth zzb2 = zzgsw.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzG(Object obj, int i, Object obj2, zzgty zzgty) {
        int i2 = this.zzc[i];
        Object zzh2 = zzgui.zzh(obj, (long) (zzC(i) & 1048575));
        if (zzh2 == null || zzE(i) == null) {
            return obj2;
        }
        zzgsi zzgsi = (zzgsi) zzh2;
        zzgsh zzgsh = (zzgsh) zzH(i);
        throw null;
    }

    private final Object zzH(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzI(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i) {
        long zzC = (long) (zzC(i) & 1048575);
        if (zzQ(obj2, i)) {
            Object zzh2 = zzgui.zzh(obj, zzC);
            Object zzh3 = zzgui.zzh(obj2, zzC);
            if (zzh2 != null && zzh3 != null) {
                zzgui.zzv(obj, zzC, zzgro.zzg(zzh2, zzh3));
                zzM(obj, i);
            } else if (zzh3 != null) {
                zzgui.zzv(obj, zzC, zzh3);
                zzM(obj, i);
            }
        }
    }

    private final void zzK(Object obj, Object obj2, int i) {
        int zzC = zzC(i);
        int i2 = this.zzc[i];
        long j = (long) (zzC & 1048575);
        if (zzT(obj2, i2, i)) {
            Object zzh2 = zzT(obj, i2, i) ? zzgui.zzh(obj, j) : null;
            Object zzh3 = zzgui.zzh(obj2, j);
            if (zzh2 != null && zzh3 != null) {
                zzgui.zzv(obj, j, zzgro.zzg(zzh2, zzh3));
                zzN(obj, i2, i);
            } else if (zzh3 != null) {
                zzgui.zzv(obj, j, zzh3);
                zzN(obj, i2, i);
            }
        }
    }

    private final void zzL(Object obj, int i, zzgsz zzgsz) throws IOException {
        if (zzP(i)) {
            zzgui.zzv(obj, (long) (i & 1048575), zzgsz.zzu());
        } else if (this.zzi) {
            zzgui.zzv(obj, (long) (i & 1048575), zzgsz.zzt());
        } else {
            zzgui.zzv(obj, (long) (i & 1048575), zzgsz.zzp());
        }
    }

    private final void zzM(Object obj, int i) {
        int zzz = zzz(i);
        long j = (long) (1048575 & zzz);
        if (j != 1048575) {
            zzgui.zzt(obj, j, (1 << (zzz >>> 20)) | zzgui.zzd(obj, j));
        }
    }

    private final void zzN(Object obj, int i, int i2) {
        zzgui.zzt(obj, (long) (zzz(i2) & 1048575), i);
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzQ(obj, i) == zzQ(obj2, i);
    }

    private static boolean zzP(int i) {
        return (i & View.NAVIGATION_BAR_UNHIDE) != 0;
    }

    private final boolean zzQ(Object obj, int i) {
        int zzz = zzz(i);
        long j = (long) (zzz & 1048575);
        if (j != 1048575) {
            return (zzgui.zzd(obj, j) & (1 << (zzz >>> 20))) != 0;
        }
        int zzC = zzC(i);
        long j2 = (long) (zzC & 1048575);
        switch (zzB(zzC)) {
            case 0:
                return Double.doubleToRawLongBits(zzgui.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgui.zzc(obj, j2)) != 0;
            case 2:
                return zzgui.zzf(obj, j2) != 0;
            case 3:
                return zzgui.zzf(obj, j2) != 0;
            case 4:
                return zzgui.zzd(obj, j2) != 0;
            case 5:
                return zzgui.zzf(obj, j2) != 0;
            case 6:
                return zzgui.zzd(obj, j2) != 0;
            case 7:
                return zzgui.zzz(obj, j2);
            case 8:
                Object zzh2 = zzgui.zzh(obj, j2);
                if (zzh2 instanceof String) {
                    return !((String) zzh2).isEmpty();
                }
                if (zzh2 instanceof zzgpw) {
                    return !zzgpw.zzb.equals(zzh2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgui.zzh(obj, j2) != null;
            case 10:
                return !zzgpw.zzb.equals(zzgui.zzh(obj, j2));
            case 11:
                return zzgui.zzd(obj, j2) != 0;
            case 12:
                return zzgui.zzd(obj, j2) != 0;
            case 13:
                return zzgui.zzd(obj, j2) != 0;
            case 14:
                return zzgui.zzf(obj, j2) != 0;
            case 15:
                return zzgui.zzd(obj, j2) != 0;
            case 16:
                return zzgui.zzf(obj, j2) != 0;
            case 17:
                return zzgui.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzR(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzQ(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzS(Object obj, int i, zzgth zzgth) {
        return zzgth.zzk(zzgui.zzh(obj, (long) (i & 1048575)));
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zzgui.zzd(obj, (long) (zzz(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zzgui.zzh(obj, j)).booleanValue();
    }

    private final void zzV(Object obj, zzgqm zzgqm) throws IOException {
        int i;
        Object obj2 = obj;
        zzgqm zzgqm2 = zzgqm;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i2 = 1048575;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1048575;
            while (i3 < length) {
                int zzC = zzC(i3);
                int[] iArr = this.zzc;
                int i6 = iArr[i3];
                int zzB = zzB(zzC);
                if (zzB <= 17) {
                    int i7 = iArr[i3 + 2];
                    int i8 = i7 & i2;
                    if (i8 != i5) {
                        i4 = unsafe.getInt(obj2, (long) i8);
                        i5 = i8;
                    }
                    i = 1 << (i7 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzC & i2);
                switch (zzB) {
                    case 0:
                        if ((i4 & i) == 0) {
                            break;
                        } else {
                            zzgqm2.zzf(i6, zzgui.zzb(obj2, j));
                            continue;
                        }
                    case 1:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzo(i6, zzgui.zzc(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzt(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzJ(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzr(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzm(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzk(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzb(i6, zzgui.zzz(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i4 & i) != 0) {
                            zzX(i6, unsafe.getObject(obj2, j), zzgqm2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzv(i6, unsafe.getObject(obj2, j), zzF(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzd(i6, (zzgpw) unsafe.getObject(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzH(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzi(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzw(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzy(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzA(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzC(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i4 & i) != 0) {
                            zzgqm2.zzq(i6, unsafe.getObject(obj2, j), zzF(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzgtj.zzL(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 19:
                        zzgtj.zzP(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 20:
                        zzgtj.zzS(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 21:
                        zzgtj.zzaa(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 22:
                        zzgtj.zzR(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 23:
                        zzgtj.zzO(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 24:
                        zzgtj.zzN(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 25:
                        zzgtj.zzJ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        continue;
                    case 26:
                        zzgtj.zzY(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2);
                        break;
                    case 27:
                        zzgtj.zzT(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, zzF(i3));
                        break;
                    case 28:
                        zzgtj.zzK(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2);
                        break;
                    case 29:
                        zzgtj.zzZ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 30:
                        zzgtj.zzM(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 31:
                        zzgtj.zzU(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 32:
                        zzgtj.zzV(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 33:
                        zzgtj.zzW(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 34:
                        zzgtj.zzX(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, false);
                        break;
                    case 35:
                        zzgtj.zzL(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 36:
                        zzgtj.zzP(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 37:
                        zzgtj.zzS(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 38:
                        zzgtj.zzaa(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 39:
                        zzgtj.zzR(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 40:
                        zzgtj.zzO(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 41:
                        zzgtj.zzN(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 42:
                        zzgtj.zzJ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 43:
                        zzgtj.zzZ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 44:
                        zzgtj.zzM(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 45:
                        zzgtj.zzU(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 46:
                        zzgtj.zzV(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 47:
                        zzgtj.zzW(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 48:
                        zzgtj.zzX(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, true);
                        break;
                    case 49:
                        zzgtj.zzQ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zzgqm2, zzF(i3));
                        break;
                    case 50:
                        zzW(zzgqm2, i6, unsafe.getObject(obj2, j), i3);
                        break;
                    case 51:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzf(i6, zzo(obj2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzo(i6, zzp(obj2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzt(i6, zzD(obj2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzJ(i6, zzD(obj2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzr(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzm(i6, zzD(obj2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzk(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzb(i6, zzU(obj2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzT(obj2, i6, i3)) {
                            zzX(i6, unsafe.getObject(obj2, j), zzgqm2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzv(i6, unsafe.getObject(obj2, j), zzF(i3));
                            break;
                        }
                        break;
                    case 61:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzd(i6, (zzgpw) unsafe.getObject(obj2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzH(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzi(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzw(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzy(i6, zzD(obj2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzA(i6, zzs(obj2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzC(i6, zzD(obj2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzT(obj2, i6, i3)) {
                            zzgqm2.zzq(i6, unsafe.getObject(obj2, j), zzF(i3));
                            break;
                        }
                        break;
                }
                i3 += 3;
                i2 = 1048575;
            }
            zzgty zzgty = this.zzo;
            zzgty.zzr(zzgty.zzd(obj2), zzgqm2);
            return;
        }
        this.zzp.zza(obj2);
        throw null;
    }

    private final void zzW(zzgqm zzgqm, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzgsh zzgsh = (zzgsh) zzH(i2);
            throw null;
        }
    }

    private static final void zzX(int i, Object obj, zzgqm zzgqm) throws IOException {
        if (obj instanceof String) {
            zzgqm.zzF(i, (String) obj);
        } else {
            zzgqm.zzd(i, (zzgpw) obj);
        }
    }

    static zzgtz zzd(Object obj) {
        zzgre zzgre = (zzgre) obj;
        zzgtz zzgtz = zzgre.zzc;
        if (zzgtz != zzgtz.zzc()) {
            return zzgtz;
        }
        zzgtz zze2 = zzgtz.zze();
        zzgre.zzc = zze2;
        return zze2;
    }

    static zzgsr zzl(Class cls, zzgsl zzgsl, zzgst zzgst, zzgsc zzgsc, zzgty zzgty, zzgqr zzgqr, zzgsj zzgsj) {
        if (zzgsl instanceof zzgsy) {
            return zzm((zzgsy) zzgsl, zzgst, zzgsc, zzgty, zzgqr, zzgsj);
        }
        zzgtv zzgtv = (zzgtv) zzgsl;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzgsr zzm(com.google.android.gms.internal.ads.zzgsy r34, com.google.android.gms.internal.ads.zzgst r35, com.google.android.gms.internal.ads.zzgsc r36, com.google.android.gms.internal.ads.zzgty r37, com.google.android.gms.internal.ads.zzgqr r38, com.google.android.gms.internal.ads.zzgsj r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.ads.zzgso r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzI(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzI(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r7 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzI(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzI(r1, r11)
            r17[r7] = r11
        L_0x036f:
            r7 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r7 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r31[r9] = r4
            int r4 = r0 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r31[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r7
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.ads.zzgsr r0 = new com.google.android.gms.internal.ads.zzgsr
            r4 = r0
            com.google.android.gms.internal.ads.zzgso r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzm(com.google.android.gms.internal.ads.zzgsy, com.google.android.gms.internal.ads.zzgst, com.google.android.gms.internal.ads.zzgsc, com.google.android.gms.internal.ads.zzgty, com.google.android.gms.internal.ads.zzgqr, com.google.android.gms.internal.ads.zzgsj):com.google.android.gms.internal.ads.zzgsr");
    }

    private static double zzo(Object obj, long j) {
        return ((Double) zzgui.zzh(obj, j)).doubleValue();
    }

    private static float zzp(Object obj, long j) {
        return ((Float) zzgui.zzh(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030c, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030d, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030e, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x037d, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0488, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0503, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0504, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x052d, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x053b, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x054a, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054e, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f1, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019e, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ae, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01be, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = zzb
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000f:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0555
            int r9 = r0.zzC(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzB(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0038
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0039
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0039
        L_0x0038:
            r10 = 0
        L_0x0039:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x053f;
                case 1: goto L_0x0530;
                case 2: goto L_0x051a;
                case 3: goto L_0x0506;
                case 4: goto L_0x04f0;
                case 5: goto L_0x04e4;
                case 6: goto L_0x04d8;
                case 7: goto L_0x04ca;
                case 8: goto L_0x049f;
                case 9: goto L_0x048c;
                case 10: goto L_0x046f;
                case 11: goto L_0x045a;
                case 12: goto L_0x0445;
                case 13: goto L_0x0438;
                case 14: goto L_0x042b;
                case 15: goto L_0x0411;
                case 16: goto L_0x03f7;
                case 17: goto L_0x03e3;
                case 18: goto L_0x03d5;
                case 19: goto L_0x03c9;
                case 20: goto L_0x03bd;
                case 21: goto L_0x03b1;
                case 22: goto L_0x03a5;
                case 23: goto L_0x0399;
                case 24: goto L_0x038d;
                case 25: goto L_0x0381;
                case 26: goto L_0x0373;
                case 27: goto L_0x0364;
                case 28: goto L_0x0359;
                case 29: goto L_0x034d;
                case 30: goto L_0x0341;
                case 31: goto L_0x0335;
                case 32: goto L_0x0329;
                case 33: goto L_0x031d;
                case 34: goto L_0x0311;
                case 35: goto L_0x02f8;
                case 36: goto L_0x02e3;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b9;
                case 39: goto L_0x02a4;
                case 40: goto L_0x028f;
                case 41: goto L_0x0279;
                case 42: goto L_0x0263;
                case 43: goto L_0x024d;
                case 44: goto L_0x0237;
                case 45: goto L_0x0221;
                case 46: goto L_0x020b;
                case 47: goto L_0x01f5;
                case 48: goto L_0x01df;
                case 49: goto L_0x01cf;
                case 50: goto L_0x01c2;
                case 51: goto L_0x01b2;
                case 52: goto L_0x01a2;
                case 53: goto L_0x018a;
                case 54: goto L_0x0175;
                case 55: goto L_0x015f;
                case 56: goto L_0x0152;
                case 57: goto L_0x0145;
                case 58: goto L_0x0136;
                case 59: goto L_0x0109;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00d7;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00ab;
                case 64: goto L_0x009d;
                case 65: goto L_0x008f;
                case 66: goto L_0x0074;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x037e
        L_0x0042:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgso r3 = (com.google.android.gms.internal.ads.zzgso) r3
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzx(r11, r3, r4)
            goto L_0x037d
        L_0x0058:
            boolean r10 = r0.zzT(r1, r11, r5)
            if (r10 == 0) goto L_0x037e
            long r3 = zzD(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.ads.zzgql.zzE(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037e
        L_0x0074:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzs(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030d
        L_0x008f:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x01be
        L_0x009d:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x01ae
        L_0x00ab:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzs(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzy(r3)
            goto L_0x030d
        L_0x00c1:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzs(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030d
        L_0x00d7:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgpw r3 = (com.google.android.gms.internal.ads.zzgpw) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x00f1:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030e
        L_0x00f5:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzo(r11, r3, r4)
            goto L_0x037d
        L_0x0109:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzgpw
            if (r4 == 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzgpw r3 = (com.google.android.gms.internal.ads.zzgpw) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x00f1
        L_0x0128:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzC(r3)
            goto L_0x030d
        L_0x0136:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            int r3 = r3 + r14
            goto L_0x037d
        L_0x0145:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x01ae
        L_0x0152:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x01be
        L_0x015f:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            int r3 = zzs(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzy(r3)
            goto L_0x030d
        L_0x0175:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzD(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r9)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
            goto L_0x019e
        L_0x018a:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x037e
            long r3 = zzD(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r9)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
        L_0x019e:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037e
        L_0x01a2:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x01ae:
            int r3 = r3 + 4
            goto L_0x037d
        L_0x01b2:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x037e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x01be:
            int r3 = r3 + 8
            goto L_0x037d
        L_0x01c2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzH(r5)
            com.google.android.gms.internal.ads.zzgsj.zza(r11, r3, r4)
            goto L_0x037e
        L_0x01cf:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzj(r11, r3, r4)
            goto L_0x037d
        L_0x01df:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzt(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x01f5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzr(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x020b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x0221:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x0237:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zze(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x024d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzw(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x0263:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzb(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x0279:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x028f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x02a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzl(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x02b9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzy(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x02ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzn(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x02e3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzg(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x030c
        L_0x02f8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzi(r3)
            if (r3 <= 0) goto L_0x037e
            int r4 = com.google.android.gms.internal.ads.zzgql.zzD(r11)
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x030c:
            int r4 = r4 + r9
        L_0x030d:
            int r4 = r4 + r3
        L_0x030e:
            int r6 = r6 + r4
            goto L_0x037e
        L_0x0311:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzs(r11, r3, r9)
            goto L_0x037d
        L_0x031d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzq(r11, r3, r9)
            goto L_0x037d
        L_0x0329:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzh(r11, r3, r9)
            goto L_0x037d
        L_0x0335:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzf(r11, r3, r9)
            goto L_0x037d
        L_0x0341:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzd(r11, r3, r9)
            goto L_0x037d
        L_0x034d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzv(r11, r3, r9)
            goto L_0x037d
        L_0x0359:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzc(r11, r3)
            goto L_0x037d
        L_0x0364:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzp(r11, r3, r4)
            goto L_0x037d
        L_0x0373:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzu(r11, r3)
        L_0x037d:
            int r6 = r6 + r3
        L_0x037e:
            r12 = 0
            goto L_0x054e
        L_0x0381:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.ads.zzgtj.zza(r11, r3, r12)
            goto L_0x03e0
        L_0x038d:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x0399:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzh(r11, r3, r12)
            goto L_0x03e0
        L_0x03a5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzk(r11, r3, r12)
            goto L_0x03e0
        L_0x03b1:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzx(r11, r3, r12)
            goto L_0x03e0
        L_0x03bd:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzm(r11, r3, r12)
            goto L_0x03e0
        L_0x03c9:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzf(r11, r3, r12)
            goto L_0x03e0
        L_0x03d5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzh(r11, r3, r12)
        L_0x03e0:
            int r6 = r6 + r3
            goto L_0x054e
        L_0x03e3:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgso r3 = (com.google.android.gms.internal.ads.zzgso) r3
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzx(r11, r3, r4)
            goto L_0x03e0
        L_0x03f7:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.ads.zzgql.zzE(r10)
            long r14 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054e
        L_0x0411:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x0503
        L_0x042b:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x054a
        L_0x0438:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x053b
        L_0x0445:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzy(r3)
            goto L_0x0503
        L_0x045a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x0503
        L_0x046f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgpw r3 = (com.google.android.gms.internal.ads.zzgpw) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x0488:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0504
        L_0x048c:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.ads.zzgth r4 = r0.zzF(r5)
            int r3 = com.google.android.gms.internal.ads.zzgtj.zzo(r11, r3, r4)
            goto L_0x03e0
        L_0x049f:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzgpw
            if (r4 == 0) goto L_0x04bd
            com.google.android.gms.internal.ads.zzgpw r3 = (com.google.android.gms.internal.ads.zzgpw) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x0488
        L_0x04bd:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzC(r3)
            goto L_0x0503
        L_0x04ca:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            int r3 = r3 + r14
            goto L_0x03e0
        L_0x04d8:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x053b
        L_0x04e4:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
            goto L_0x054a
        L_0x04f0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzy(r3)
        L_0x0503:
            int r4 = r4 + r3
        L_0x0504:
            int r6 = r6 + r4
            goto L_0x054e
        L_0x0506:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r9)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
            goto L_0x052d
        L_0x051a:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054e
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.ads.zzgql.zzE(r9)
            int r3 = com.google.android.gms.internal.ads.zzgql.zzF(r3)
        L_0x052d:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054e
        L_0x0530:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x053b:
            int r3 = r3 + 4
            goto L_0x03e0
        L_0x053f:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054e
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.ads.zzgql.zzE(r3)
        L_0x054a:
            int r3 = r3 + 8
            goto L_0x03e0
        L_0x054e:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000f
        L_0x0555:
            com.google.android.gms.internal.ads.zzgty r2 = r0.zzo
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0565
            return r6
        L_0x0565:
            com.google.android.gms.internal.ads.zzgqr r2 = r0.zzp
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzC(r2)
            int r5 = zzB(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.ads.zzgqw r4 = com.google.android.gms.internal.ads.zzgqw.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.ads.zzgqw r4 = com.google.android.gms.internal.ads.zzgqw.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgso r4 = (com.google.android.gms.internal.ads.zzgso) r4
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzD(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzy(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgpw r4 = (com.google.android.gms.internal.ads.zzgpw) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgpw
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzgpw r4 = (com.google.android.gms.internal.ads.zzgpw) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzC(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzy(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r6)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r6)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.lang.Object r5 = r11.zzH(r2)
            com.google.android.gms.internal.ads.zzgsj.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgql.zzD(r6)
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgso r4 = (com.google.android.gms.internal.ads.zzgso) r4
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzx(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzQ(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.ads.zzgui.zzf(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgui.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgui.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzy(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgui.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgpw r4 = (com.google.android.gms.internal.ads.zzgpw) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgth r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgtj.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgui.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgpw
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.ads.zzgpw r4 = (com.google.android.gms.internal.ads.zzgpw) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzC(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgui.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgql.zzE(r5)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzy(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzgui.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r6)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzgui.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgql.zzE(r6)
            int r4 = com.google.android.gms.internal.ads.zzgql.zzF(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgql.zzE(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.ads.zzgty r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzr(java.lang.Object):int");
    }

    private static int zzs(Object obj, long j) {
        return ((Integer) zzgui.zzh(obj, j)).intValue();
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzgpi zzgpi) throws IOException {
        Unsafe unsafe = zzb;
        Object zzH = zzH(i3);
        Object object = unsafe.getObject(obj, j);
        if (zzgsj.zzb(object)) {
            zzgsi zzb2 = zzgsi.zza().zzb();
            zzgsj.zzc(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzgsh zzgsh = (zzgsh) zzH;
        throw null;
    }

    private final int zzu(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgpi zzgpi) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzgpi zzgpi2 = zzgpi;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzgpj.zzn(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzgpj.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzgpj.zzm(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzgpi2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzgpj.zzj(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzgpi2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzgpj.zzn(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzgpj.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzgpj.zzm(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzgpi2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzgpj.zzj(bArr2, i9, zzgpi2);
                    int i14 = zzgpi2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & View.NAVIGATION_BAR_UNHIDE) == 0 || zzgun.zzj(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzgro.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzgrq.zzd();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzgpj.zzd(zzF(i13), bArr2, i9, i2, zzgpi2);
                    Object object = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j2, zzgpi2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzgro.zzg(object, zzgpi2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzgpj.zza(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, zzgpi2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzgpj.zzj(bArr2, i9, zzgpi2);
                    int i15 = zzgpi2.zza;
                    zzgri zzE = zzE(i13);
                    if (zzE == null || zzE.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzgpj.zzj(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzgqe.zzF(zzgpi2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzgpj.zzm(bArr2, i9, zzgpi2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzgqe.zzG(zzgpi2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzgpj.zzc(zzF(i13), bArr, i, i2, (i10 & -8) | 4, zzgpi);
                    Object object2 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j2, zzgpi2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzgro.zzg(object2, zzgpi2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02fd, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x032e, code lost:
        if (r0 != r15) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0351, code lost:
        if (r0 != r15) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01c5, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0237, code lost:
        r6 = r6 | r23;
        r9 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x023b, code lost:
        r7 = r19;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0241, code lost:
        r2 = r5;
        r28 = r7;
        r23 = r10;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e7, code lost:
        if (r0 != r15) goto L_0x02e9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzv(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzgpi r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x037a
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzy(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzx(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r19 = -1
            r23 = 0
            goto L_0x0354
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r10 = zzB(r1)
            r33 = r5
            r5 = r1 & r8
            r19 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x024c
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x008b
            r20 = r2
            if (r7 == r5) goto L_0x007f
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0081
        L_0x007f:
            r7 = r19
        L_0x0081:
            if (r0 == r5) goto L_0x0088
            long r1 = (long) r0
            int r6 = r7.getInt(r14, r1)
        L_0x0088:
            r2 = r7
            r7 = r0
            goto L_0x008f
        L_0x008b:
            r20 = r2
            r2 = r19
        L_0x008f:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x021c;
                case 1: goto L_0x0201;
                case 2: goto L_0x01e0;
                case 3: goto L_0x01e0;
                case 4: goto L_0x01c8;
                case 5: goto L_0x01a6;
                case 6: goto L_0x018f;
                case 7: goto L_0x016f;
                case 8: goto L_0x014c;
                case 9: goto L_0x011f;
                case 10: goto L_0x0107;
                case 11: goto L_0x01c8;
                case 12: goto L_0x00f0;
                case 13: goto L_0x018f;
                case 14: goto L_0x01a6;
                case 15: goto L_0x00d5;
                case 16: goto L_0x00a0;
                default: goto L_0x0093;
            }
        L_0x0093:
            r5 = r4
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            goto L_0x0241
        L_0x00a0:
            if (r3 != 0) goto L_0x00c7
            int r10 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.ads.zzgqe.zzG(r0)
            r0 = r2
            r1 = r31
            r19 = r7
            r4 = r20
            r7 = r2
            r2 = r8
            r20 = r33
            r8 = r4
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x023b
        L_0x00c7:
            r19 = r7
            r8 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x0241
        L_0x00d5:
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != 0) goto L_0x01c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.ads.zzgqe.zzF(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0237
        L_0x00f0:
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != 0) goto L_0x01c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0237
        L_0x0107:
            r19 = r7
            r10 = r20
            r0 = 2
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x01c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0237
        L_0x011f:
            r19 = r7
            r10 = r20
            r0 = 2
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x01c5
            com.google.android.gms.internal.ads.zzgth r0 = r15.zzF(r10)
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzd(r0, r12, r4, r13, r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0141
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0237
        L_0x0141:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgro.zzg(r1, r2)
            r7.putObject(r14, r8, r1)
            goto L_0x0237
        L_0x014c:
            r19 = r7
            r10 = r20
            r0 = 2
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x01c5
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0164
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzg(r12, r4, r11)
            goto L_0x0168
        L_0x0164:
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzh(r12, r4, r11)
        L_0x0168:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0237
        L_0x016f:
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != 0) goto L_0x01c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0189
            r1 = 1
            goto L_0x018a
        L_0x0189:
            r1 = 0
        L_0x018a:
            com.google.android.gms.internal.ads.zzgui.zzp(r14, r8, r1)
            goto L_0x0237
        L_0x018f:
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x01c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzb(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0237
        L_0x01a6:
            r19 = r7
            r10 = r20
            r0 = 1
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x01c5
            long r21 = com.google.android.gms.internal.ads.zzgpj.zzn(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0237
        L_0x01c5:
            r5 = r4
            goto L_0x0241
        L_0x01c8:
            r5 = r4
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r5, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0237
        L_0x01e0:
            r5 = r4
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != 0) goto L_0x0241
            int r17 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x023b
        L_0x0201:
            r5 = r4
            r19 = r7
            r10 = r20
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x0241
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzb(r12, r5)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgui.zzs(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x0237
        L_0x021c:
            r5 = r4
            r19 = r7
            r10 = r20
            r0 = 1
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            r7 = r2
            if (r3 != r0) goto L_0x0241
            long r0 = com.google.android.gms.internal.ads.zzgpj.zzn(r12, r5)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgui.zzr(r14, r8, r0)
            int r0 = r5 + 8
        L_0x0237:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
        L_0x023b:
            r7 = r19
            r1 = r20
            goto L_0x0374
        L_0x0241:
            r2 = r5
            r28 = r7
            r23 = r10
            r7 = r19
            r19 = -1
            goto L_0x0354
        L_0x024c:
            r20 = r33
            r5 = r4
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r29 = r19
            r19 = r7
            r7 = r29
            r0 = 27
            if (r10 != r0) goto L_0x02aa
            r0 = 2
            if (r3 != r0) goto L_0x029d
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.ads.zzgrn r0 = (com.google.android.gms.internal.ads.zzgrn) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x027d
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0275
            r1 = 10
            goto L_0x0276
        L_0x0275:
            int r1 = r1 + r1
        L_0x0276:
            com.google.android.gms.internal.ads.zzgrn r0 = r0.zzd(r1)
            r7.putObject(r14, r8, r0)
        L_0x027d:
            r8 = r0
            com.google.android.gms.internal.ads.zzgth r0 = r15.zzF(r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r23 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzgpj.zze(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r7 = r19
            r1 = r20
            r2 = r23
            goto L_0x0374
        L_0x029d:
            r23 = r4
            r15 = r5
            r26 = r6
            r28 = r7
            r27 = r19
            r19 = -1
            goto L_0x0331
        L_0x02aa:
            r23 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02ff
            r1 = r21
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r26 = r6
            r6 = r20
            r27 = r19
            r19 = r7
            r7 = r33
            r24 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r23
            r18 = r10
            r28 = r19
            r19 = -1
            r9 = r21
            r11 = r18
            r12 = r24
            r14 = r35
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02fd
        L_0x02e9:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r1 = r20
            r2 = r23
            r6 = r26
            r7 = r27
            goto L_0x0372
        L_0x02fd:
            r2 = r0
            goto L_0x0332
        L_0x02ff:
            r33 = r3
            r15 = r5
            r26 = r6
            r28 = r7
            r24 = r8
            r18 = r10
            r27 = r19
            r1 = r21
            r19 = -1
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x0337
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x0331
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r23
            r6 = r24
            r8 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02fd
            goto L_0x02e9
        L_0x0331:
            r2 = r15
        L_0x0332:
            r6 = r26
            r7 = r27
            goto L_0x0354
        L_0x0337:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r24
            r12 = r23
            r13 = r35
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02fd
            goto L_0x02e9
        L_0x0354:
            com.google.android.gms.internal.ads.zzgtz r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r1 = r20
            r2 = r23
        L_0x0372:
            r9 = r28
        L_0x0374:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001a
        L_0x037a:
            r26 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x038d
            long r1 = (long) r7
            r3 = r31
            r6 = r26
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x038d:
            r1 = r34
            if (r0 != r1) goto L_0x0392
            return r0
        L_0x0392:
            com.google.android.gms.internal.ads.zzgrq r0 = com.google.android.gms.internal.ads.zzgrq.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzgpi):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d1  */
    private final int zzw(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzgpi r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzgrn r11 = (com.google.android.gms.internal.ads.zzgrn) r11
            boolean r12 = r11.zzc()
            if (r12 != 0) goto L_0x0034
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002a
            r12 = 10
            goto L_0x002b
        L_0x002a:
            int r12 = r12 + r12
        L_0x002b:
            com.google.android.gms.internal.ads.zzgrn r11 = r11.zzd(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0034:
            r9 = 5
            r12 = 0
            r10 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e3;
                case 19: goto L_0x0396;
                case 20: goto L_0x0353;
                case 21: goto L_0x0353;
                case 22: goto L_0x0338;
                case 23: goto L_0x02f7;
                case 24: goto L_0x02b6;
                case 25: goto L_0x025c;
                case 26: goto L_0x01a9;
                case 27: goto L_0x018e;
                case 28: goto L_0x0134;
                case 29: goto L_0x0338;
                case 30: goto L_0x00fc;
                case 31: goto L_0x02b6;
                case 32: goto L_0x02f7;
                case 33: goto L_0x00ad;
                case 34: goto L_0x005e;
                case 35: goto L_0x03e3;
                case 36: goto L_0x0396;
                case 37: goto L_0x0353;
                case 38: goto L_0x0353;
                case 39: goto L_0x0338;
                case 40: goto L_0x02f7;
                case 41: goto L_0x02b6;
                case 42: goto L_0x025c;
                case 43: goto L_0x0338;
                case 44: goto L_0x00fc;
                case 45: goto L_0x02b6;
                case 46: goto L_0x02f7;
                case 47: goto L_0x00ad;
                case 48: goto L_0x005e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x0451
            com.google.android.gms.internal.ads.zzgth r1 = r15.zzF(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x005e:
            if (r6 != r14) goto L_0x0082
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0069:
            if (r1 >= r2) goto L_0x0079
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.ads.zzgqe.zzG(r4)
            r11.zzg(r4)
            goto L_0x0069
        L_0x0079:
            if (r1 != r2) goto L_0x007d
            goto L_0x0452
        L_0x007d:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0082:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgqe.zzG(r8)
            r11.zzg(r8)
        L_0x0093:
            if (r1 >= r5) goto L_0x00ac
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009e
            goto L_0x00ac
        L_0x009e:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgqe.zzG(r8)
            r11.zzg(r8)
            goto L_0x0093
        L_0x00ac:
            return r1
        L_0x00ad:
            if (r6 != r14) goto L_0x00d1
            com.google.android.gms.internal.ads.zzgrf r11 = (com.google.android.gms.internal.ads.zzgrf) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b8:
            if (r1 >= r2) goto L_0x00c8
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgqe.zzF(r4)
            r11.zzh(r4)
            goto L_0x00b8
        L_0x00c8:
            if (r1 != r2) goto L_0x00cc
            goto L_0x0452
        L_0x00cc:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x00d1:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgrf r11 = (com.google.android.gms.internal.ads.zzgrf) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgqe.zzF(r4)
            r11.zzh(r4)
        L_0x00e2:
            if (r1 >= r5) goto L_0x00fb
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ed
            goto L_0x00fb
        L_0x00ed:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgqe.zzF(r4)
            r11.zzh(r4)
            goto L_0x00e2
        L_0x00fb:
            return r1
        L_0x00fc:
            if (r6 != r14) goto L_0x0103
            int r2 = com.google.android.gms.internal.ads.zzgpj.zzf(r3, r4, r11, r7)
            goto L_0x0114
        L_0x0103:
            if (r6 != 0) goto L_0x0451
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r11
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzgpj.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0114:
            com.google.android.gms.internal.ads.zzgre r1 = (com.google.android.gms.internal.ads.zzgre) r1
            com.google.android.gms.internal.ads.zzgtz r3 = r1.zzc
            com.google.android.gms.internal.ads.zzgtz r4 = com.google.android.gms.internal.ads.zzgtz.zzc()
            if (r3 != r4) goto L_0x011f
            r3 = 0
        L_0x011f:
            com.google.android.gms.internal.ads.zzgri r4 = r15.zzE(r8)
            com.google.android.gms.internal.ads.zzgty r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgtj.zzC(r6, r11, r4, r3, r5)
            if (r3 != 0) goto L_0x012f
            goto L_0x027d
        L_0x012f:
            com.google.android.gms.internal.ads.zzgtz r3 = (com.google.android.gms.internal.ads.zzgtz) r3
            r1.zzc = r3
            return r2
        L_0x0134:
            if (r6 != r14) goto L_0x0451
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0189
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0184
            if (r4 != 0) goto L_0x014a
            com.google.android.gms.internal.ads.zzgpw r4 = com.google.android.gms.internal.ads.zzgpw.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x014a:
            com.google.android.gms.internal.ads.zzgpw r6 = com.google.android.gms.internal.ads.zzgpw.zzw(r3, r1, r4)
            r11.add(r6)
        L_0x0151:
            int r1 = r1 + r4
        L_0x0152:
            if (r1 >= r5) goto L_0x0183
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015d
            goto L_0x0183
        L_0x015d:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0179
            if (r4 != 0) goto L_0x0171
            com.google.android.gms.internal.ads.zzgpw r4 = com.google.android.gms.internal.ads.zzgpw.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x0171:
            com.google.android.gms.internal.ads.zzgpw r6 = com.google.android.gms.internal.ads.zzgpw.zzw(r3, r1, r4)
            r11.add(r6)
            goto L_0x0151
        L_0x0179:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x017e:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x0183:
            return r1
        L_0x0184:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0189:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x018e:
            if (r6 == r14) goto L_0x0192
            goto L_0x0451
        L_0x0192:
            com.google.android.gms.internal.ads.zzgth r1 = r15.zzF(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r11
            r27 = r29
            int r1 = com.google.android.gms.internal.ads.zzgpj.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a9:
            if (r6 != r14) goto L_0x0451
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x01fc
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f7
            if (r6 != 0) goto L_0x01c4
            r11.add(r1)
            goto L_0x01cf
        L_0x01c4:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgro.zzb
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01ce:
            int r4 = r4 + r6
        L_0x01cf:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f2
            if (r6 != 0) goto L_0x01e7
            r11.add(r1)
            goto L_0x01cf
        L_0x01e7:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgro.zzb
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01ce
        L_0x01f2:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x01f7:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x01fc:
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0257
            if (r6 != 0) goto L_0x020a
            r11.add(r1)
            goto L_0x021d
        L_0x020a:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzgun.zzj(r3, r4, r8)
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgro.zzb
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x021c:
            r4 = r8
        L_0x021d:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024d
            if (r6 != 0) goto L_0x0235
            r11.add(r1)
            goto L_0x021d
        L_0x0235:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzgun.zzj(r3, r4, r8)
            if (r9 == 0) goto L_0x0248
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgro.zzb
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x021c
        L_0x0248:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzd()
            throw r1
        L_0x024d:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x0252:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzd()
            throw r1
        L_0x0257:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzf()
            throw r1
        L_0x025c:
            r1 = 0
            if (r6 != r14) goto L_0x0285
            com.google.android.gms.internal.ads.zzgpk r11 = (com.google.android.gms.internal.ads.zzgpk) r11
            int r2 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0268:
            if (r2 >= r4) goto L_0x027b
            int r2 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0276
            r5 = 1
            goto L_0x0277
        L_0x0276:
            r5 = 0
        L_0x0277:
            r11.zze(r5)
            goto L_0x0268
        L_0x027b:
            if (r2 != r4) goto L_0x0280
        L_0x027d:
            r1 = r2
            goto L_0x0452
        L_0x0280:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0285:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgpk r11 = (com.google.android.gms.internal.ads.zzgpk) r11
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0295
            r6 = 1
            goto L_0x0296
        L_0x0295:
            r6 = 0
        L_0x0296:
            r11.zze(r6)
        L_0x0299:
            if (r4 >= r5) goto L_0x02b5
            int r6 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a4
            goto L_0x02b5
        L_0x02a4:
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x02b0
            r6 = 1
            goto L_0x02b1
        L_0x02b0:
            r6 = 0
        L_0x02b1:
            r11.zze(r6)
            goto L_0x0299
        L_0x02b5:
            return r4
        L_0x02b6:
            if (r6 != r14) goto L_0x02d6
            com.google.android.gms.internal.ads.zzgrf r11 = (com.google.android.gms.internal.ads.zzgrf) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02c1:
            if (r1 >= r2) goto L_0x02cd
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzb(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02c1
        L_0x02cd:
            if (r1 != r2) goto L_0x02d1
            goto L_0x0452
        L_0x02d1:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x02d6:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.ads.zzgrf r11 = (com.google.android.gms.internal.ads.zzgrf) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzb(r17, r18)
            r11.zzh(r1)
        L_0x02e1:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f6
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ee
            goto L_0x02f6
        L_0x02ee:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzb(r3, r4)
            r11.zzh(r1)
            goto L_0x02e1
        L_0x02f6:
            return r1
        L_0x02f7:
            if (r6 != r14) goto L_0x0317
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0302:
            if (r1 >= r2) goto L_0x030e
            long r4 = com.google.android.gms.internal.ads.zzgpj.zzn(r3, r1)
            r11.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0302
        L_0x030e:
            if (r1 != r2) goto L_0x0312
            goto L_0x0452
        L_0x0312:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0317:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            long r8 = com.google.android.gms.internal.ads.zzgpj.zzn(r17, r18)
            r11.zzg(r8)
        L_0x0322:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0337
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032f
            goto L_0x0337
        L_0x032f:
            long r8 = com.google.android.gms.internal.ads.zzgpj.zzn(r3, r4)
            r11.zzg(r8)
            goto L_0x0322
        L_0x0337:
            return r1
        L_0x0338:
            if (r6 != r14) goto L_0x0340
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzf(r3, r4, r11, r7)
            goto L_0x0452
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            goto L_0x0451
        L_0x0344:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r11
            r25 = r29
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0353:
            if (r6 != r14) goto L_0x0373
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035e:
            if (r1 >= r2) goto L_0x036a
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r11.zzg(r4)
            goto L_0x035e
        L_0x036a:
            if (r1 != r2) goto L_0x036e
            goto L_0x0452
        L_0x036e:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0373:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzgsd r11 = (com.google.android.gms.internal.ads.zzgsd) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
        L_0x0380:
            if (r1 >= r5) goto L_0x0395
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x038b
            goto L_0x0395
        L_0x038b:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
            goto L_0x0380
        L_0x0395:
            return r1
        L_0x0396:
            if (r6 != r14) goto L_0x03ba
            com.google.android.gms.internal.ads.zzgqx r11 = (com.google.android.gms.internal.ads.zzgqx) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a1:
            if (r1 >= r2) goto L_0x03b1
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r11.zze(r4)
            int r1 = r1 + 4
            goto L_0x03a1
        L_0x03b1:
            if (r1 != r2) goto L_0x03b5
            goto L_0x0452
        L_0x03b5:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x03ba:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.ads.zzgqx r11 = (com.google.android.gms.internal.ads.zzgqx) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
        L_0x03c9:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e2
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d6
            goto L_0x03e2
        L_0x03d6:
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
            goto L_0x03c9
        L_0x03e2:
            return r1
        L_0x03e3:
            if (r6 != r14) goto L_0x0406
            com.google.android.gms.internal.ads.zzgqn r11 = (com.google.android.gms.internal.ads.zzgqn) r11
            int r1 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ee:
            if (r1 >= r2) goto L_0x03fe
            long r4 = com.google.android.gms.internal.ads.zzgpj.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r11.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ee
        L_0x03fe:
            if (r1 != r2) goto L_0x0401
            goto L_0x0452
        L_0x0401:
            com.google.android.gms.internal.ads.zzgrq r1 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r1
        L_0x0406:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.ads.zzgqn r11 = (com.google.android.gms.internal.ads.zzgqn) r11
            long r8 = com.google.android.gms.internal.ads.zzgpj.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
        L_0x0415:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042e
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0422
            goto L_0x042e
        L_0x0422:
            long r8 = com.google.android.gms.internal.ads.zzgpj.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
            goto L_0x0415
        L_0x042e:
            return r1
        L_0x042f:
            if (r4 >= r5) goto L_0x0450
            int r8 = com.google.android.gms.internal.ads.zzgpj.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x043a
            goto L_0x0450
        L_0x043a:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgpj.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x0450:
            return r4
        L_0x0451:
            r1 = r4
        L_0x0452:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzw(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzgpi):int");
    }

    private final int zzx(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, 0);
    }

    private final int zzy(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, i2);
    }

    private final int zzz(int i) {
        return this.zzc[i + 2];
    }

    public final int zza(Object obj) {
        return this.zzj ? zzr(obj) : zzq(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzC(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzB(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzU(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzp(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgui.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgui.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgui.zzh(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzgui.zzz(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgui.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgui.zzd(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgui.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgui.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzgui.zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzgui.zzb(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgro.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzgty r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.ads.zzgqr r0 = r8.zzp
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzb(java.lang.Object):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x036b, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0387, code lost:
        r8 = r31;
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03af, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d4, code lost:
        if (r0 != r15) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x022a, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0266, code lost:
        r5 = r6 | r24;
        r3 = r7;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02a9, code lost:
        r5 = r6 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02ab, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02ac, code lost:
        r1 = r11;
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c5, code lost:
        r2 = r4;
        r20 = r6;
        r18 = r7;
        r26 = r10;
        r8 = r11;
        r23 = r19;
        r6 = r25;
        r7 = r33;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.ads.zzgpi r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x0448
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002d
        L_0x0028:
            r27 = r1
            r1 = r0
            r0 = r27
        L_0x002d:
            int r7 = r1 >>> 3
            r8 = r1 & 7
            r4 = 3
            if (r7 <= r2) goto L_0x003a
            int r3 = r3 / r4
            int r2 = r15.zzy(r7, r3)
            goto L_0x003e
        L_0x003a:
            int r2 = r15.zzx(r7)
        L_0x003e:
            r3 = -1
            if (r2 != r3) goto L_0x0050
            r2 = r0
            r8 = r1
            r20 = r5
            r23 = r7
            r26 = r10
            r7 = r11
            r17 = -1
            r18 = 0
            goto L_0x03d7
        L_0x0050:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r4 = r3[r19]
            int r11 = zzB(r4)
            r19 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r4 & r17
            r21 = r0
            long r0 = (long) r1
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02d5
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x0089
            r17 = r2
            if (r6 == r3) goto L_0x0081
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0081:
            long r1 = (long) r0
            int r5 = r10.getInt(r14, r1)
            r25 = r0
            goto L_0x008d
        L_0x0089:
            r17 = r2
            r25 = r6
        L_0x008d:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x028a;
                case 1: goto L_0x026b;
                case 2: goto L_0x0249;
                case 3: goto L_0x0249;
                case 4: goto L_0x022d;
                case 5: goto L_0x0209;
                case 6: goto L_0x01ed;
                case 7: goto L_0x01c8;
                case 8: goto L_0x01a1;
                case 9: goto L_0x016d;
                case 10: goto L_0x0150;
                case 11: goto L_0x022d;
                case 12: goto L_0x0118;
                case 13: goto L_0x01ed;
                case 14: goto L_0x0209;
                case 15: goto L_0x00f8;
                case 16: goto L_0x00c4;
                default: goto L_0x0092;
            }
        L_0x0092:
            r11 = r19
            r4 = r21
            r2 = r22
            r0 = 3
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x02c5
            com.google.android.gms.internal.ads.zzgth r0 = r15.zzF(r7)
            int r1 = r19 << 3
            r5 = r1 | 4
            r1 = r30
            r12 = r2
            r2 = r4
            r3 = r32
            r4 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x02b1
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x02be
        L_0x00c4:
            if (r8 != 0) goto L_0x00e9
            r1 = r21
            int r8 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.ads.zzgqe.zzG(r0)
            r1 = r22
            r0 = r10
            r11 = r19
            r1 = r29
            r19 = r7
            r7 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r22
            r0.putLong(r1, r2, r4)
            goto L_0x0266
        L_0x00e9:
            r11 = r19
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            r4 = r21
            goto L_0x02c5
        L_0x00f8:
            r11 = r19
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.ads.zzgqe.zzF(r1)
            r2 = r22
            r10.putInt(r14, r2, r1)
            goto L_0x02a9
        L_0x0118:
            r11 = r19
            r1 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.ads.zzgri r4 = r15.zzE(r7)
            if (r4 == 0) goto L_0x014b
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x013c
            goto L_0x014b
        L_0x013c:
            com.google.android.gms.internal.ads.zzgtz r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x02ab
        L_0x014b:
            r10.putInt(r14, r2, r1)
            goto L_0x02a9
        L_0x0150:
            r11 = r19
            r1 = r21
            r2 = r22
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.zzgpj.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x02a9
        L_0x016d:
            r11 = r19
            r1 = r21
            r2 = r22
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x022a
            com.google.android.gms.internal.ads.zzgth r0 = r15.zzF(r7)
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzd(r0, r12, r1, r13, r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x0192
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x02a9
        L_0x0192:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgro.zzg(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x02a9
        L_0x01a1:
            r11 = r19
            r1 = r21
            r2 = r22
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x022a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x01bd
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzg(r12, r1, r9)
            goto L_0x01c1
        L_0x01bd:
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzh(r12, r1, r9)
        L_0x01c1:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x02a9
        L_0x01c8:
            r11 = r19
            r1 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r1, r9)
            long r4 = r9.zzb
            r20 = 0
            int r1 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x01e7
            r1 = 1
            goto L_0x01e8
        L_0x01e7:
            r1 = 0
        L_0x01e8:
            com.google.android.gms.internal.ads.zzgui.zzp(r14, r2, r1)
            goto L_0x02a9
        L_0x01ed:
            r11 = r19
            r1 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x022a
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzb(r12, r1)
            r10.putInt(r14, r2, r0)
            int r0 = r1 + 4
            goto L_0x02a9
        L_0x0209:
            r11 = r19
            r1 = r21
            r2 = r22
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x022a
            long r4 = com.google.android.gms.internal.ads.zzgpj.zzn(r12, r1)
            r8 = r1
            r0 = r10
            r1 = r29
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x02a9
        L_0x022a:
            r4 = r1
            goto L_0x02c5
        L_0x022d:
            r11 = r19
            r4 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x02c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzj(r12, r4, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            goto L_0x02a9
        L_0x0249:
            r11 = r19
            r4 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != 0) goto L_0x02c5
            int r8 = com.google.android.gms.internal.ads.zzgpj.zzm(r12, r4, r9)
            long r4 = r9.zzb
            r0 = r10
            r1 = r29
            r0.putLong(r1, r2, r4)
        L_0x0266:
            r5 = r6 | r24
            r3 = r7
            r0 = r8
            goto L_0x02ac
        L_0x026b:
            r11 = r19
            r4 = r21
            r2 = r22
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x02c5
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgui.zzs(r14, r2, r0)
            int r0 = r4 + 4
            goto L_0x02a9
        L_0x028a:
            r11 = r19
            r4 = r21
            r2 = r22
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r17
            r17 = -1
            if (r8 != r0) goto L_0x02c5
            long r0 = com.google.android.gms.internal.ads.zzgpj.zzn(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgui.zzr(r14, r2, r0)
            int r0 = r4 + 8
        L_0x02a9:
            r5 = r6 | r24
        L_0x02ab:
            r3 = r7
        L_0x02ac:
            r1 = r11
            r2 = r19
            goto L_0x0329
        L_0x02b1:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgro.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x02be:
            r5 = r6 | r24
            r12 = r30
            r13 = r32
            goto L_0x02ab
        L_0x02c5:
            r2 = r4
            r20 = r6
            r18 = r7
            r26 = r10
            r8 = r11
            r23 = r19
            r6 = r25
            r7 = r33
            goto L_0x03d7
        L_0x02d5:
            r3 = r19
            r12 = r22
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r2
            r2 = r21
            r0 = 27
            if (r11 != r0) goto L_0x033e
            r0 = 2
            if (r8 != r0) goto L_0x032f
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.ads.zzgrn r0 = (com.google.android.gms.internal.ads.zzgrn) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0307
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02ff
            r1 = 10
            goto L_0x0300
        L_0x02ff:
            int r1 = r1 + r1
        L_0x0300:
            com.google.android.gms.internal.ads.zzgrn r0 = r0.zzd(r1)
            r10.putObject(r14, r12, r0)
        L_0x0307:
            r8 = r0
            com.google.android.gms.internal.ads.zzgth r0 = r15.zzF(r7)
            r1 = r3
            r4 = r2
            r2 = r30
            r11 = r3
            r3 = r4
            r4 = r32
            r20 = r5
            r5 = r8
            r25 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.ads.zzgpj.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r7
            r1 = r11
            r2 = r19
            r5 = r20
        L_0x0329:
            r6 = r25
            r11 = r33
            goto L_0x0019
        L_0x032f:
            r20 = r5
            r25 = r6
            r15 = r2
            r31 = r3
            r18 = r7
            r26 = r10
            r23 = r19
            goto L_0x03b2
        L_0x033e:
            r20 = r5
            r25 = r6
            r5 = r2
            r6 = r3
            r0 = 49
            if (r11 > r0) goto L_0x038d
            long r3 = (long) r4
            r0 = r28
            r1 = r29
            r2 = r30
            r21 = r3
            r3 = r5
            r4 = r32
            r15 = r5
            r5 = r6
            r31 = r6
            r6 = r19
            r18 = r7
            r23 = r19
            r7 = r8
            r8 = r18
            r26 = r10
            r9 = r21
            r14 = r34
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0387
        L_0x036d:
            r15 = r28
            r14 = r29
            r12 = r30
            r1 = r31
            r13 = r32
            r11 = r33
            r9 = r34
            r3 = r18
            r5 = r20
            r2 = r23
            r6 = r25
            r10 = r26
            goto L_0x0019
        L_0x0387:
            r8 = r31
            r7 = r33
            r2 = r0
            goto L_0x03b7
        L_0x038d:
            r15 = r5
            r31 = r6
            r18 = r7
            r26 = r10
            r23 = r19
            r0 = 50
            if (r11 != r0) goto L_0x03ba
            r0 = 2
            if (r8 != r0) goto L_0x03b2
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r18
            r6 = r12
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0387
            goto L_0x036d
        L_0x03b2:
            r8 = r31
            r7 = r33
            r2 = r15
        L_0x03b7:
            r6 = r25
            goto L_0x03d7
        L_0x03ba:
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r9 = r4
            r4 = r32
            r5 = r31
            r6 = r23
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r12
            r12 = r18
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0387
            goto L_0x036d
        L_0x03d7:
            if (r8 != r7) goto L_0x03e9
            if (r7 == 0) goto L_0x03e9
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r5 = r20
            r2 = 0
            goto L_0x0455
        L_0x03e9:
            r9 = r28
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x0421
            r10 = r34
            com.google.android.gms.internal.ads.zzgqq r0 = r10.zzd
            com.google.android.gms.internal.ads.zzgqq r1 = com.google.android.gms.internal.ads.zzgqq.zza()
            if (r0 == r1) goto L_0x041e
            com.google.android.gms.internal.ads.zzgso r0 = r9.zzg
            com.google.android.gms.internal.ads.zzgqq r1 = r10.zzd
            r11 = r23
            com.google.android.gms.internal.ads.zzgrc r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x0417
            com.google.android.gms.internal.ads.zzgtz r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x0436
        L_0x0417:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.ads.zzgrb r0 = (com.google.android.gms.internal.ads.zzgrb) r0
            r2 = 0
            throw r2
        L_0x041e:
            r12 = r29
            goto L_0x0425
        L_0x0421:
            r12 = r29
            r10 = r34
        L_0x0425:
            r11 = r23
            com.google.android.gms.internal.ads.zzgtz r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgpj.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0436:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r18
            r5 = r20
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x0019
        L_0x0448:
            r20 = r5
            r25 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r2 = 0
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0455:
            if (r6 == r3) goto L_0x045d
            long r3 = (long) r6
            r6 = r26
            r6.putInt(r12, r3, r5)
        L_0x045d:
            int r3 = r9.zzl
        L_0x045f:
            int r4 = r9.zzm
            if (r3 >= r4) goto L_0x046f
            int[] r4 = r9.zzk
            r4 = r4[r3]
            com.google.android.gms.internal.ads.zzgty r5 = r9.zzo
            r9.zzG(r12, r4, r2, r5)
            int r3 = r3 + 1
            goto L_0x045f
        L_0x046f:
            if (r7 != 0) goto L_0x047b
            r2 = r32
            if (r0 != r2) goto L_0x0476
            goto L_0x0481
        L_0x0476:
            com.google.android.gms.internal.ads.zzgrq r0 = com.google.android.gms.internal.ads.zzgrq.zzg()
            throw r0
        L_0x047b:
            r2 = r32
            if (r0 > r2) goto L_0x0482
            if (r1 != r7) goto L_0x0482
        L_0x0481:
            return r0
        L_0x0482:
            com.google.android.gms.internal.ads.zzgrq r0 = com.google.android.gms.internal.ads.zzgrq.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgpi):int");
    }

    public final Object zze() {
        return ((zzgre) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long zzC = (long) (zzC(this.zzk[i2]) & 1048575);
            Object zzh2 = zzgui.zzh(obj, zzC);
            if (zzh2 != null) {
                ((zzgsi) zzh2).zzc();
                zzgui.zzv(obj, zzC, zzh2);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(obj, (long) this.zzk[i]);
            i++;
        }
        this.zzo.zzm(obj);
        if (this.zzh) {
            this.zzp.zze(obj);
        }
    }

    public final void zzg(Object obj, Object obj2) {
        if (obj2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzC = zzC(i);
                long j = (long) (1048575 & zzC);
                int i2 = this.zzc[i];
                switch (zzB(zzC)) {
                    case 0:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzr(obj, j, zzgui.zzb(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzs(obj, j, zzgui.zzc(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzu(obj, j, zzgui.zzf(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzu(obj, j, zzgui.zzf(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzu(obj, j, zzgui.zzf(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzp(obj, j, zzgui.zzz(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzv(obj, j, zzgui.zzh(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 9:
                        zzJ(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzv(obj, j, zzgui.zzh(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzu(obj, j, zzgui.zzf(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzt(obj, j, zzgui.zzd(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzQ(obj2, i)) {
                            break;
                        } else {
                            zzgui.zzu(obj, j, zzgui.zzf(obj2, j));
                            zzM(obj, i);
                            break;
                        }
                    case 17:
                        zzJ(obj, obj2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzn.zzc(obj, obj2, j);
                        break;
                    case 50:
                        zzgtj.zzI(this.zzr, obj, obj2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzT(obj2, i2, i)) {
                            break;
                        } else {
                            zzgui.zzv(obj, j, zzgui.zzh(obj2, j));
                            zzN(obj, i2, i);
                            break;
                        }
                    case 60:
                        zzK(obj, obj2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzT(obj2, i2, i)) {
                            break;
                        } else {
                            zzgui.zzv(obj, j, zzgui.zzh(obj2, j));
                            zzN(obj, i2, i);
                            break;
                        }
                    case 68:
                        zzK(obj, obj2, i);
                        break;
                }
            }
            zzgtj.zzF(this.zzo, obj, obj2);
            if (this.zzh) {
                zzgtj.zzE(this.zzp, obj, obj2);
                return;
            }
            return;
        }
        throw null;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzh(java.lang.Object r13, com.google.android.gms.internal.ads.zzgsz r14, com.google.android.gms.internal.ads.zzgqq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05d9
            com.google.android.gms.internal.ads.zzgty r8 = r12.zzo
            com.google.android.gms.internal.ads.zzgqr r9 = r12.zzp
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzc()     // Catch:{ all -> 0x0077 }
            int r3 = r12.zzx(r2)     // Catch:{ all -> 0x0077 }
            if (r3 >= 0) goto L_0x007a
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzl
        L_0x001a:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x05c1
            r8.zzn(r13, r10)
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x0077 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzgso r3 = r12.zzg     // Catch:{ all -> 0x0077 }
            java.lang.Object r2 = r9.zzc(r15, r3, r2)     // Catch:{ all -> 0x0077 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzgqv r1 = r9.zzb(r13)     // Catch:{ all -> 0x0077 }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zzd(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0077 }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zzq(r14)     // Catch:{ all -> 0x0077 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r8.zzc(r13)     // Catch:{ all -> 0x0077 }
        L_0x005a:
            boolean r2 = r8.zzp(r10, r14)     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x0062:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x05c1
            r8.zzn(r13, r10)
            return
        L_0x0077:
            r14 = move-exception
            goto L_0x05c2
        L_0x007a:
            int r4 = r12.zzC(r3)     // Catch:{ all -> 0x0077 }
            int r5 = zzB(r4)     // Catch:{ zzgrp -> 0x059b }
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x056f;
                case 1: goto L_0x0560;
                case 2: goto L_0x0551;
                case 3: goto L_0x0542;
                case 4: goto L_0x0533;
                case 5: goto L_0x0524;
                case 6: goto L_0x0515;
                case 7: goto L_0x0506;
                case 8: goto L_0x04fe;
                case 9: goto L_0x04cd;
                case 10: goto L_0x04be;
                case 11: goto L_0x04af;
                case 12: goto L_0x048d;
                case 13: goto L_0x047e;
                case 14: goto L_0x046f;
                case 15: goto L_0x0460;
                case 16: goto L_0x0451;
                case 17: goto L_0x0420;
                case 18: goto L_0x0412;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f6;
                case 21: goto L_0x03e8;
                case 22: goto L_0x03da;
                case 23: goto L_0x03cc;
                case 24: goto L_0x03be;
                case 25: goto L_0x03b0;
                case 26: goto L_0x0386;
                case 27: goto L_0x0374;
                case 28: goto L_0x0366;
                case 29: goto L_0x0358;
                case 30: goto L_0x0343;
                case 31: goto L_0x0335;
                case 32: goto L_0x0327;
                case 33: goto L_0x0319;
                case 34: goto L_0x030b;
                case 35: goto L_0x02fd;
                case 36: goto L_0x02ef;
                case 37: goto L_0x02e1;
                case 38: goto L_0x02d3;
                case 39: goto L_0x02c5;
                case 40: goto L_0x02b7;
                case 41: goto L_0x02a9;
                case 42: goto L_0x029b;
                case 43: goto L_0x028d;
                case 44: goto L_0x0278;
                case 45: goto L_0x026a;
                case 46: goto L_0x025c;
                case 47: goto L_0x024e;
                case 48: goto L_0x0240;
                case 49: goto L_0x022e;
                case 50: goto L_0x01f8;
                case 51: goto L_0x01e6;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01c2;
                case 54: goto L_0x01b0;
                case 55: goto L_0x019e;
                case 56: goto L_0x018c;
                case 57: goto L_0x017a;
                case 58: goto L_0x0168;
                case 59: goto L_0x0160;
                case 60: goto L_0x012f;
                case 61: goto L_0x0121;
                case 62: goto L_0x010f;
                case 63: goto L_0x00ea;
                case 64: goto L_0x00d8;
                case 65: goto L_0x00c6;
                case 66: goto L_0x00b4;
                case 67: goto L_0x00a2;
                case 68: goto L_0x0090;
                default: goto L_0x0088;
            }     // Catch:{ zzgrp -> 0x059b }
        L_0x0088:
            if (r10 != 0) goto L_0x057e
            java.lang.Object r10 = r8.zzf()     // Catch:{ zzgrp -> 0x059b }
            goto L_0x057e
        L_0x0090:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r6 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r6 = r14.zzr(r6, r15)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x00a2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzn()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x00b4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            int r6 = r14.zzi()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x00c6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzm()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x00d8:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            int r6 = r14.zzh()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x00ea:
            int r5 = r14.zze()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgri r7 = r12.zzE(r3)     // Catch:{ zzgrp -> 0x059b }
            if (r7 == 0) goto L_0x0101
            boolean r7 = r7.zza(r5)     // Catch:{ zzgrp -> 0x059b }
            if (r7 == 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgtj.zzD(r2, r5, r10, r8)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0101:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r6, r4)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x010f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            int r6 = r14.zzj()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0121:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgpw r6 = r14.zzp()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x012f:
            boolean r5 = r12.zzT(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            if (r5 == 0) goto L_0x014b
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzgui.zzh(r13, r4)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r7 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r7 = r14.zzs(r7, r15)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzgro.zzg(r6, r7)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x015b
        L_0x014b:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r6 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r6 = r14.zzs(r6, r15)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
        L_0x015b:
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0160:
            r12.zzL(r13, r4, r14)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0168:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            boolean r6 = r14.zzN()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x017a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            int r6 = r14.zzf()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x018c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzk()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x019e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            int r6 = r14.zzg()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x01b0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzo()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x01c2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzl()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x01d4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            float r6 = r14.zzb()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x01e6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            double r6 = r14.zza()     // Catch:{ zzgrp -> 0x059b }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzN(r13, r2, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x01f8:
            java.lang.Object r2 = r12.zzH(r3)     // Catch:{ zzgrp -> 0x059b }
            int r3 = r12.zzC(r3)     // Catch:{ zzgrp -> 0x059b }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzgui.zzh(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            if (r5 == 0) goto L_0x021e
            boolean r6 = com.google.android.gms.internal.ads.zzgsj.zzb(r5)     // Catch:{ zzgrp -> 0x059b }
            if (r6 == 0) goto L_0x0229
            com.google.android.gms.internal.ads.zzgsi r6 = com.google.android.gms.internal.ads.zzgsi.zza()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsi r6 = r6.zzb()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsj.zzc(r6, r5)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r3, r6)     // Catch:{ zzgrp -> 0x059b }
            r5 = r6
            goto L_0x0229
        L_0x021e:
            com.google.android.gms.internal.ads.zzgsi r5 = com.google.android.gms.internal.ads.zzgsi.zza()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsi r5 = r5.zzb()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r3, r5)     // Catch:{ zzgrp -> 0x059b }
        L_0x0229:
            com.google.android.gms.internal.ads.zzgsi r5 = (com.google.android.gms.internal.ads.zzgsi) r5     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsh r2 = (com.google.android.gms.internal.ads.zzgsh) r2     // Catch:{ zzgrp -> 0x059b }
            throw r0     // Catch:{ zzgrp -> 0x059b }
        L_0x022e:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r2 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsc r3 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzgrp -> 0x059b }
            r14.zzC(r3, r2, r15)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0240:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzJ(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x024e:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzI(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x025c:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzH(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x026a:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzG(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0278:
            com.google.android.gms.internal.ads.zzgsc r5 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzgrp -> 0x059b }
            r14.zzy(r4)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgri r3 = r12.zzE(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgtj.zzC(r2, r4, r3, r10, r8)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x028d:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzL(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x029b:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzv(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02a9:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzz(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02b7:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzA(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02c5:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzD(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02d3:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzM(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02e1:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzE(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02ef:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzB(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x02fd:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzx(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x030b:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzJ(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0319:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzI(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0327:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzH(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0335:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzG(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0343:
            com.google.android.gms.internal.ads.zzgsc r5 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzgrp -> 0x059b }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzgrp -> 0x059b }
            r14.zzy(r4)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgri r3 = r12.zzE(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgtj.zzC(r2, r4, r3, r10, r8)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0358:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzL(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0366:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzw(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0374:
            com.google.android.gms.internal.ads.zzgth r2 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgsc r5 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzF(r3, r2, r15)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0386:
            boolean r2 = zzP(r4)     // Catch:{ zzgrp -> 0x059b }
            if (r2 == 0) goto L_0x039e
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r3 = r14
            com.google.android.gms.internal.ads.zzgqf r3 = (com.google.android.gms.internal.ads.zzgqf) r3     // Catch:{ zzgrp -> 0x059b }
            r4 = 1
            r3.zzK(r2, r4)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x039e:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r3 = r14
            com.google.android.gms.internal.ads.zzgqf r3 = (com.google.android.gms.internal.ads.zzgqf) r3     // Catch:{ zzgrp -> 0x059b }
            r4 = 0
            r3.zzK(r2, r4)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03b0:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzv(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03be:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzz(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03cc:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzA(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03da:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzD(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03e8:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzM(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x03f6:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzE(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0404:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzB(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0412:
            com.google.android.gms.internal.ads.zzgsc r2 = r12.zzn     // Catch:{ zzgrp -> 0x059b }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzgrp -> 0x059b }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            r14.zzx(r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0420:
            boolean r2 = r12.zzQ(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            if (r2 == 0) goto L_0x043e
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgui.zzh(r13, r4)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r3 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r3 = r14.zzr(r3, r15)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgro.zzg(r2, r3)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x043e:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r2 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = r14.zzr(r2, r15)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0451:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzn()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzu(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0460:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            int r2 = r14.zzi()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x046f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzm()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzu(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x047e:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            int r2 = r14.zzh()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x048d:
            int r5 = r14.zze()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgri r7 = r12.zzE(r3)     // Catch:{ zzgrp -> 0x059b }
            if (r7 == 0) goto L_0x04a4
            boolean r7 = r7.zza(r5)     // Catch:{ zzgrp -> 0x059b }
            if (r7 == 0) goto L_0x049e
            goto L_0x04a4
        L_0x049e:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgtj.zzD(r2, r5, r10, r8)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04a4:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r6, r5)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04af:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            int r2 = r14.zzj()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04be:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgpw r2 = r14.zzp()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04cd:
            boolean r2 = r12.zzQ(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            if (r2 == 0) goto L_0x04eb
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgui.zzh(r13, r4)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r3 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r3 = r14.zzs(r3, r15)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzgro.zzg(r2, r3)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04eb:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgth r2 = r12.zzF(r3)     // Catch:{ zzgrp -> 0x059b }
            java.lang.Object r2 = r14.zzs(r2, r15)     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzv(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x04fe:
            r12.zzL(r13, r4, r14)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0506:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            boolean r2 = r14.zzN()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzp(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0515:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            int r2 = r14.zzf()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0524:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzk()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzu(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0533:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            int r2 = r14.zzg()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzt(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0542:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzo()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzu(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0551:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            long r6 = r14.zzl()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzu(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x0560:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            float r2 = r14.zzb()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzs(r13, r4, r2)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x056f:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzgrp -> 0x059b }
            double r6 = r14.zza()     // Catch:{ zzgrp -> 0x059b }
            com.google.android.gms.internal.ads.zzgui.zzr(r13, r4, r6)     // Catch:{ zzgrp -> 0x059b }
            r12.zzM(r13, r3)     // Catch:{ zzgrp -> 0x059b }
            goto L_0x0009
        L_0x057e:
            boolean r2 = r8.zzp(r10, r14)     // Catch:{ zzgrp -> 0x059b }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x0586:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0595
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0586
        L_0x0595:
            if (r10 == 0) goto L_0x05c1
            r8.zzn(r13, r10)
            return
        L_0x059b:
            r8.zzq(r14)     // Catch:{ all -> 0x0077 }
            if (r10 != 0) goto L_0x05a5
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x0077 }
            r10 = r2
        L_0x05a5:
            boolean r2 = r8.zzp(r10, r14)     // Catch:{ all -> 0x0077 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzl
        L_0x05ad:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05bc
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05ad
        L_0x05bc:
            if (r10 == 0) goto L_0x05c1
            r8.zzn(r13, r10)
        L_0x05c1:
            return
        L_0x05c2:
            int r15 = r12.zzl
        L_0x05c4:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05d3
            int[] r0 = r12.zzk
            r0 = r0[r15]
            java.lang.Object r10 = r12.zzG(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c4
        L_0x05d3:
            if (r10 == 0) goto L_0x05d8
            r8.zzn(r13, r10)
        L_0x05d8:
            throw r14
        L_0x05d9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsr.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgsz, com.google.android.gms.internal.ads.zzgqq):void");
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgpi zzgpi) throws IOException {
        if (this.zzj) {
            zzv(obj, bArr, i, i2, zzgpi);
        } else {
            zzc(obj, bArr, i, i2, 0, zzgpi);
        }
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzC = zzC(i);
            long j = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (zzO(obj, obj2, i) && Double.doubleToLongBits(zzgui.zzb(obj, j)) == Double.doubleToLongBits(zzgui.zzb(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzO(obj, obj2, i) && Float.floatToIntBits(zzgui.zzc(obj, j)) == Float.floatToIntBits(zzgui.zzc(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzO(obj, obj2, i) && zzgui.zzf(obj, j) == zzgui.zzf(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzO(obj, obj2, i) && zzgui.zzf(obj, j) == zzgui.zzf(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzO(obj, obj2, i) && zzgui.zzf(obj, j) == zzgui.zzf(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzO(obj, obj2, i) && zzgui.zzz(obj, j) == zzgui.zzz(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzO(obj, obj2, i) && zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzO(obj, obj2, i) && zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzO(obj, obj2, i) && zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzO(obj, obj2, i) && zzgui.zzf(obj, j) == zzgui.zzf(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzO(obj, obj2, i) && zzgui.zzd(obj, j) == zzgui.zzd(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzO(obj, obj2, i) && zzgui.zzf(obj, j) == zzgui.zzf(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzO(obj, obj2, i) && zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j));
                    break;
                case 50:
                    z = zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzz = (long) (zzz(i) & 1048575);
                    if (zzgui.zzd(obj, zzz) == zzgui.zzd(obj2, zzz) && zzgtj.zzH(zzgui.zzh(obj, j), zzgui.zzh(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj);
        this.zzp.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzl) {
            int i6 = this.zzk[i5];
            int i7 = this.zzc[i6];
            int zzC = zzC(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzC) != 0 && !zzR(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzB = zzB(zzC);
            if (zzB != 9 && zzB != 17) {
                if (zzB != 27) {
                    if (zzB == 60 || zzB == 68) {
                        if (zzT(obj2, i7, i6) && !zzS(obj2, zzC, zzF(i6))) {
                            return false;
                        }
                    } else if (zzB != 49) {
                        if (zzB == 50 && !((zzgsi) zzgui.zzh(obj2, (long) (zzC & 1048575))).isEmpty()) {
                            zzgsh zzgsh = (zzgsh) zzH(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzgui.zzh(obj2, (long) (zzC & 1048575));
                if (!list.isEmpty()) {
                    zzgth zzF = zzF(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzF.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzR(obj, i6, i2, i, i10) && !zzS(obj2, zzC, zzF(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(obj2);
        throw null;
    }

    public final void zzn(Object obj, zzgqm zzgqm) throws IOException {
        if (!this.zzj) {
            zzV(obj, zzgqm);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzC = zzC(i);
                int i2 = this.zzc[i];
                switch (zzB(zzC)) {
                    case 0:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzf(i2, zzgui.zzb(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzo(i2, zzgui.zzc(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzt(i2, zzgui.zzf(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzJ(i2, zzgui.zzf(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzr(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzm(i2, zzgui.zzf(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzk(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzb(i2, zzgui.zzz(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzX(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm);
                            break;
                        }
                    case 9:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzv(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 10:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzd(i2, (zzgpw) zzgui.zzh(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzH(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzi(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzw(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzy(i2, zzgui.zzf(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzA(i2, zzgui.zzd(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzC(i2, zzgui.zzf(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzQ(obj, i)) {
                            break;
                        } else {
                            zzgqm.zzq(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 18:
                        zzgtj.zzL(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 19:
                        zzgtj.zzP(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 20:
                        zzgtj.zzS(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 21:
                        zzgtj.zzaa(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 22:
                        zzgtj.zzR(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 23:
                        zzgtj.zzO(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 24:
                        zzgtj.zzN(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 25:
                        zzgtj.zzJ(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 26:
                        zzgtj.zzY(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm);
                        break;
                    case 27:
                        zzgtj.zzT(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, zzF(i));
                        break;
                    case 28:
                        zzgtj.zzK(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm);
                        break;
                    case 29:
                        zzgtj.zzZ(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 30:
                        zzgtj.zzM(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 31:
                        zzgtj.zzU(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 32:
                        zzgtj.zzV(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 33:
                        zzgtj.zzW(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 34:
                        zzgtj.zzX(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, false);
                        break;
                    case 35:
                        zzgtj.zzL(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 36:
                        zzgtj.zzP(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 37:
                        zzgtj.zzS(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 38:
                        zzgtj.zzaa(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 39:
                        zzgtj.zzR(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 40:
                        zzgtj.zzO(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 41:
                        zzgtj.zzN(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 42:
                        zzgtj.zzJ(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 43:
                        zzgtj.zzZ(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 44:
                        zzgtj.zzM(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 45:
                        zzgtj.zzU(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 46:
                        zzgtj.zzV(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 47:
                        zzgtj.zzW(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 48:
                        zzgtj.zzX(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, true);
                        break;
                    case 49:
                        zzgtj.zzQ(i2, (List) zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm, zzF(i));
                        break;
                    case 50:
                        zzW(zzgqm, i2, zzgui.zzh(obj, (long) (zzC & 1048575)), i);
                        break;
                    case 51:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzf(i2, zzo(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzo(i2, zzp(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzt(i2, zzD(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzJ(i2, zzD(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzr(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzm(i2, zzD(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzk(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzb(i2, zzU(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzX(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzgqm);
                            break;
                        }
                    case 60:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzv(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                    case 61:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzd(i2, (zzgpw) zzgui.zzh(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzH(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzi(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzw(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzy(i2, zzD(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzA(i2, zzs(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzC(i2, zzD(obj, (long) (zzC & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzT(obj, i2, i)) {
                            break;
                        } else {
                            zzgqm.zzq(i2, zzgui.zzh(obj, (long) (zzC & 1048575)), zzF(i));
                            break;
                        }
                }
            }
            zzgty zzgty = this.zzo;
            zzgty.zzr(zzgty.zzd(obj), zzgqm);
        } else {
            this.zzp.zza(obj);
            throw null;
        }
    }
}
