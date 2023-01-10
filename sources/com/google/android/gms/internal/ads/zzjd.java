package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjd implements Handler.Callback, zzgx, zzjs, zzjv, zzsf, zzvy {
    private boolean zzA;
    private int zzB = 0;
    private boolean zzC = false;
    private boolean zzD;
    /* access modifiers changed from: private */
    public boolean zzE;
    private boolean zzF;
    private int zzG;
    private zzjc zzH;
    private long zzI;
    private int zzJ;
    private boolean zzK;
    private zzha zzL;
    private long zzM;
    private final zzhw zzN;
    private final zzgv zzO;
    private final zzka[] zza;
    private final Set zzb;
    private final zzkb[] zzc;
    private final zzvz zzd;
    private final zzwa zze;
    private final zzjh zzf;
    private final zzwh zzg;
    /* access modifiers changed from: private */
    public final zzdn zzh;
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzcm zzk;
    private final zzck zzl;
    private final long zzm;
    private final zzgy zzn;
    private final ArrayList zzo;
    private final zzde zzp;
    private final zzjm zzq;
    private final zzjt zzr;
    private final long zzs;
    private zzkd zzt;
    private zzju zzu;
    private zzjb zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    public zzjd(zzka[] zzkaArr, zzvz zzvz, zzwa zzwa, zzjh zzjh, zzwh zzwh, int i, boolean z, zzko zzko, zzkd zzkd, zzgv zzgv, long j, boolean z2, Looper looper, zzde zzde, zzhw zzhw, zznb zznb, byte[] bArr) {
        zzka[] zzkaArr2 = zzkaArr;
        zzwh zzwh2 = zzwh;
        zzko zzko2 = zzko;
        zzde zzde2 = zzde;
        zznb zznb2 = zznb;
        this.zzN = zzhw;
        this.zza = zzkaArr2;
        this.zzd = zzvz;
        this.zze = zzwa;
        this.zzf = zzjh;
        this.zzg = zzwh2;
        int i2 = 0;
        this.zzt = zzkd;
        this.zzO = zzgv;
        this.zzs = j;
        this.zzx = false;
        this.zzp = zzde2;
        this.zzM = -9223372036854775807L;
        this.zzm = zzjh.zza();
        zzjh.zzf();
        zzju zzg2 = zzju.zzg(zzwa);
        this.zzu = zzg2;
        this.zzv = new zzjb(zzg2);
        int length = zzkaArr2.length;
        this.zzc = new zzkb[2];
        while (true) {
            int length2 = zzkaArr2.length;
            if (i2 < 2) {
                zzkaArr2[i2].zzq(i2, zznb2);
                this.zzc[i2] = zzkaArr2[i2].zzj();
                i2++;
            } else {
                this.zzn = new zzgy(this, zzde2);
                this.zzo = new ArrayList();
                this.zzb = Collections.newSetFromMap(new IdentityHashMap());
                this.zzk = new zzcm();
                this.zzl = new zzck();
                zzvz.zzq(this, zzwh2);
                this.zzK = true;
                Handler handler = new Handler(looper);
                this.zzq = new zzjm(zzko2, handler);
                this.zzr = new zzjt(this, zzko2, handler, zznb2);
                HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                this.zzi = handlerThread;
                handlerThread.start();
                Looper looper2 = this.zzi.getLooper();
                this.zzj = looper2;
                this.zzh = zzde2.zzb(looper2, this);
                return;
            }
        }
    }

    private final void zzA(zzka zzka) throws zzha {
        if (zzac(zzka)) {
            this.zzn.zzd(zzka);
            zzaj(zzka);
            zzka.zzn();
            this.zzG--;
        }
    }

    private final void zzB() throws zzha {
        int length = this.zza.length;
        zzC(new boolean[2]);
    }

    private final void zzC(boolean[] zArr) throws zzha {
        zzjj zze2 = this.zzq.zze();
        zzwa zzi2 = zze2.zzi();
        int i = 0;
        while (true) {
            int length = this.zza.length;
            if (i >= 2) {
                break;
            }
            if (!zzi2.zzb(i) && this.zzb.remove(this.zza[i])) {
                this.zza[i].zzA();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.zza.length;
            if (i2 < 2) {
                if (zzi2.zzb(i2)) {
                    boolean z = zArr[i2];
                    zzka zzka = this.zza[i2];
                    if (!zzac(zzka)) {
                        zzjj zze3 = this.zzq.zze();
                        boolean z2 = zze3 == this.zzq.zzd();
                        zzwa zzi3 = zze3.zzi();
                        zzkc zzkc = zzi3.zzb[i2];
                        zzaf[] zzah = zzah(zzi3.zzc[i2]);
                        boolean z3 = zzaf() && this.zzu.zze == 3;
                        boolean z4 = !z && z3;
                        this.zzG++;
                        this.zzb.add(zzka);
                        zzka.zzo(zzkc, zzah, zze3.zzc[i2], this.zzI, z4, z2, zze3.zzf(), zze3.zze());
                        zzka.zzp(11, new zziw(this));
                        this.zzn.zze(zzka);
                        if (z3) {
                            zzka.zzE();
                        }
                    }
                }
                i2++;
            } else {
                zze2.zzg = true;
                return;
            }
        }
    }

    private final void zzD(IOException iOException, int i) {
        zzha zzc2 = zzha.zzc(iOException, i);
        zzjj zzd2 = this.zzq.zzd();
        if (zzd2 != null) {
            zzc2 = zzc2.zza(zzd2.zzf.zza);
        }
        zzdw.zzc("ExoPlayerImplInternal", "Playback error", zzc2);
        zzU(false, false);
        this.zzu = this.zzu.zzd(zzc2);
    }

    private final void zzE(boolean z) {
        long j;
        zzjj zzc2 = this.zzq.zzc();
        zzsi zzsi = zzc2 == null ? this.zzu.zzb : zzc2.zzf.zza;
        boolean z2 = !this.zzu.zzk.equals(zzsi);
        if (z2) {
            this.zzu = this.zzu.zza(zzsi);
        }
        zzju zzju = this.zzu;
        if (zzc2 == null) {
            j = zzju.zzr;
        } else {
            j = zzc2.zzc();
        }
        zzju.zzp = j;
        this.zzu.zzq = zzt();
        if ((z2 || z) && zzc2 != null && zzc2.zzd) {
            zzX(zzc2.zzh(), zzc2.zzi());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.android.gms.internal.ads.zzck} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: com.google.android.gms.internal.ads.zzjc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: com.google.android.gms.internal.ads.zzjc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzF(com.google.android.gms.internal.ads.zzcn r29, boolean r30) throws com.google.android.gms.internal.ads.zzha {
        /*
            r28 = this;
            r11 = r28
            r12 = r29
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzjc r8 = r11.zzH
            com.google.android.gms.internal.ads.zzjm r9 = r11.zzq
            int r4 = r11.zzB
            boolean r10 = r11.zzC
            com.google.android.gms.internal.ads.zzcm r13 = r11.zzk
            com.google.android.gms.internal.ads.zzck r14 = r11.zzl
            boolean r1 = r29.zzo()
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3 = 1
            if (r1 == 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzsi r0 = com.google.android.gms.internal.ads.zzju.zzh()
            r8 = r0
            r15 = r11
            r13 = r16
            r2 = 0
            r5 = 1
            r7 = 0
            r9 = -1
            r10 = 0
            goto L_0x01e4
        L_0x002e:
            com.google.android.gms.internal.ads.zzsi r1 = r0.zzb
            java.lang.Object r15 = r1.zza
            boolean r19 = zzae(r0, r14)
            com.google.android.gms.internal.ads.zzsi r2 = r0.zzb
            boolean r2 = r2.zzb()
            if (r2 != 0) goto L_0x0044
            if (r19 == 0) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            long r5 = r0.zzr
            goto L_0x0046
        L_0x0044:
            long r5 = r0.zzc
        L_0x0046:
            r23 = r5
            if (r8 == 0) goto L_0x009f
            r5 = 1
            r6 = r1
            r1 = r29
            r2 = r8
            r11 = 1
            r3 = r5
            r7 = -1
            r5 = r10
            r11 = r6
            r6 = r13
            r21 = r9
            r9 = -1
            r7 = r14
            android.util.Pair r1 = zzy(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != 0) goto L_0x006a
            int r1 = r12.zzg(r10)
            r5 = r1
            r1 = r23
            r3 = 1
            r4 = 0
            r6 = 0
            goto L_0x0092
        L_0x006a:
            long r2 = r8.zzc
            int r4 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r4 != 0) goto L_0x007c
            java.lang.Object r1 = r1.first
            com.google.android.gms.internal.ads.zzck r1 = r12.zzn(r1, r14)
            int r5 = r1.zzd
            r1 = r23
            r3 = 0
            goto L_0x0088
        L_0x007c:
            java.lang.Object r15 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r3 = 1
            r5 = -1
        L_0x0088:
            int r4 = r0.zze
            r6 = 4
            if (r4 != r6) goto L_0x008f
            r4 = 1
            goto L_0x0090
        L_0x008f:
            r4 = 0
        L_0x0090:
            r6 = r3
            r3 = 0
        L_0x0092:
            r10 = r4
            r4 = r5
            r22 = r6
            r7 = 0
        L_0x0098:
            r27 = r15
            r15 = r3
            r3 = r27
            goto L_0x013c
        L_0x009f:
            r11 = r1
            r21 = r9
            r9 = -1
            com.google.android.gms.internal.ads.zzcn r1 = r0.zza
            boolean r1 = r1.zzo()
            if (r1 == 0) goto L_0x00bb
            int r1 = r12.zzg(r10)
        L_0x00af:
            r4 = r1
            r3 = r15
            r1 = r23
            r7 = 0
        L_0x00b5:
            r10 = 0
            r15 = 0
            r22 = 0
            goto L_0x013c
        L_0x00bb:
            int r1 = r12.zza(r15)
            if (r1 != r9) goto L_0x00e6
            com.google.android.gms.internal.ads.zzcn r6 = r0.zza
            r1 = r13
            r2 = r14
            r3 = r4
            r4 = r10
            r5 = r15
            r7 = r29
            java.lang.Object r1 = zze(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != 0) goto L_0x00d6
            int r1 = r12.zzg(r10)
            r3 = 1
            goto L_0x00dd
        L_0x00d6:
            com.google.android.gms.internal.ads.zzck r1 = r12.zzn(r1, r14)
            int r1 = r1.zzd
            r3 = 0
        L_0x00dd:
            r4 = r1
            r1 = r23
            r7 = 0
            r10 = 0
            r22 = 0
            goto L_0x0098
        L_0x00e6:
            int r1 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzck r1 = r12.zzn(r15, r14)
            int r1 = r1.zzd
            goto L_0x00af
        L_0x00f1:
            if (r19 == 0) goto L_0x0134
            com.google.android.gms.internal.ads.zzcn r1 = r0.zza
            java.lang.Object r2 = r11.zza
            r1.zzn(r2, r14)
            com.google.android.gms.internal.ads.zzcn r1 = r0.zza
            int r2 = r14.zzd
            r7 = 0
            com.google.android.gms.internal.ads.zzcm r1 = r1.zze(r2, r13, r7)
            int r1 = r1.zzo
            com.google.android.gms.internal.ads.zzcn r2 = r0.zza
            java.lang.Object r3 = r11.zza
            int r2 = r2.zza(r3)
            if (r1 != r2) goto L_0x012b
            com.google.android.gms.internal.ads.zzck r1 = r12.zzn(r15, r14)
            int r4 = r1.zzd
            r1 = r29
            r2 = r13
            r3 = r14
            r5 = r23
            android.util.Pair r1 = r1.zzl(r2, r3, r4, r5)
            java.lang.Object r15 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            goto L_0x012d
        L_0x012b:
            r1 = r23
        L_0x012d:
            r3 = r15
            r4 = -1
            r10 = 0
            r15 = 0
            r22 = 1
            goto L_0x013c
        L_0x0134:
            r7 = 0
            r3 = r15
            r1 = r23
            r4 = -1
            goto L_0x00b5
        L_0x013c:
            if (r4 == r9) goto L_0x0159
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1 = r29
            r2 = r13
            r3 = r14
            android.util.Pair r1 = r1.zzl(r2, r3, r4, r5)
            java.lang.Object r3 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r4 = r1
            r1 = r16
            goto L_0x015a
        L_0x0159:
            r4 = r1
        L_0x015a:
            r6 = r21
            com.google.android.gms.internal.ads.zzsi r6 = r6.zzh(r12, r3, r4)
            int r13 = r6.zze
            if (r13 == r9) goto L_0x016d
            int r7 = r11.zze
            if (r7 == r9) goto L_0x016b
            if (r13 < r7) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r7 = 0
            goto L_0x016e
        L_0x016d:
            r7 = 1
        L_0x016e:
            java.lang.Object r8 = r11.zza
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0186
            boolean r8 = r11.zzb()
            if (r8 != 0) goto L_0x0186
            boolean r8 = r6.zzb()
            if (r8 != 0) goto L_0x0186
            if (r7 == 0) goto L_0x0186
            r7 = 1
            goto L_0x0187
        L_0x0186:
            r7 = 0
        L_0x0187:
            com.google.android.gms.internal.ads.zzck r3 = r12.zzn(r3, r14)
            if (r19 != 0) goto L_0x01b2
            int r8 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x01b2
            java.lang.Object r8 = r11.zza
            java.lang.Object r13 = r6.zza
            boolean r8 = r8.equals(r13)
            if (r8 != 0) goto L_0x019c
            goto L_0x01b2
        L_0x019c:
            boolean r8 = r11.zzb()
            if (r8 == 0) goto L_0x01a7
            int r8 = r11.zzb
            r3.zzl(r8)
        L_0x01a7:
            boolean r8 = r6.zzb()
            if (r8 == 0) goto L_0x01b2
            int r8 = r6.zzb
            r3.zzl(r8)
        L_0x01b2:
            r3 = 1
            if (r3 == r7) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r6 = r11
        L_0x01b7:
            boolean r7 = r6.zzb()
            if (r7 == 0) goto L_0x01da
            boolean r4 = r6.equals(r11)
            if (r4 == 0) goto L_0x01c6
            long r4 = r0.zzr
            goto L_0x01da
        L_0x01c6:
            java.lang.Object r0 = r6.zza
            r12.zzn(r0, r14)
            int r0 = r6.zzc
            int r4 = r6.zzb
            int r4 = r14.zze(r4)
            if (r0 != r4) goto L_0x01d8
            r14.zzi()
        L_0x01d8:
            r4 = 0
        L_0x01da:
            r13 = r1
            r8 = r6
            r2 = r10
            r3 = r15
            r7 = r22
            r15 = r28
            r10 = r4
            r5 = 1
        L_0x01e4:
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x01fa
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            long r0 = r0.zzr
            int r4 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x01f7
            goto L_0x01fa
        L_0x01f7:
            r19 = 0
            goto L_0x01fc
        L_0x01fa:
            r19 = 1
        L_0x01fc:
            r20 = 3
            if (r3 == 0) goto L_0x0219
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu     // Catch:{ all -> 0x0211 }
            int r0 = r0.zze     // Catch:{ all -> 0x0211 }
            if (r0 == r5) goto L_0x020b
            r3 = 4
            r15.zzS(r3)     // Catch:{ all -> 0x0211 }
            goto L_0x020c
        L_0x020b:
            r3 = 4
        L_0x020c:
            r4 = 0
            r15.zzK(r4, r4, r4, r5)     // Catch:{ all -> 0x0211 }
            goto L_0x021b
        L_0x0211:
            r0 = move-exception
            r25 = r13
        L_0x0214:
            r9 = 1
            r13 = 0
            r14 = 0
            goto L_0x0335
        L_0x0219:
            r3 = 4
            r4 = 0
        L_0x021b:
            if (r19 != 0) goto L_0x0287
            com.google.android.gms.internal.ads.zzjm r1 = r15.zzq     // Catch:{ all -> 0x0211 }
            long r3 = r15.zzI     // Catch:{ all -> 0x0211 }
            com.google.android.gms.internal.ads.zzjj r0 = r1.zze()     // Catch:{ all -> 0x0211 }
            r21 = -9223372036854775808
            if (r0 != 0) goto L_0x022e
            r25 = r13
            r5 = 0
            goto L_0x0275
        L_0x022e:
            long r23 = r0.zze()     // Catch:{ all -> 0x0211 }
            boolean r2 = r0.zzd     // Catch:{ all -> 0x0211 }
            if (r2 != 0) goto L_0x023b
            r25 = r13
            r5 = r23
            goto L_0x0275
        L_0x023b:
            r5 = r23
            r2 = 0
        L_0x023e:
            com.google.android.gms.internal.ads.zzka[] r9 = r15.zza     // Catch:{ all -> 0x0211 }
            r25 = r13
            int r13 = r9.length     // Catch:{ all -> 0x0285 }
            r13 = 2
            if (r2 >= r13) goto L_0x0275
            r9 = r9[r2]     // Catch:{ all -> 0x0285 }
            boolean r9 = zzac(r9)     // Catch:{ all -> 0x0285 }
            if (r9 == 0) goto L_0x0270
            com.google.android.gms.internal.ads.zzka[] r9 = r15.zza     // Catch:{ all -> 0x0285 }
            r9 = r9[r2]     // Catch:{ all -> 0x0285 }
            com.google.android.gms.internal.ads.zztz r9 = r9.zzm()     // Catch:{ all -> 0x0285 }
            com.google.android.gms.internal.ads.zztz[] r13 = r0.zzc     // Catch:{ all -> 0x0285 }
            r13 = r13[r2]     // Catch:{ all -> 0x0285 }
            if (r9 == r13) goto L_0x025d
            goto L_0x0270
        L_0x025d:
            com.google.android.gms.internal.ads.zzka[] r9 = r15.zza     // Catch:{ all -> 0x0285 }
            r9 = r9[r2]     // Catch:{ all -> 0x0285 }
            long r13 = r9.zzf()     // Catch:{ all -> 0x0285 }
            int r9 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x026c
            r5 = r21
            goto L_0x0275
        L_0x026c:
            long r5 = java.lang.Math.max(r13, r5)     // Catch:{ all -> 0x0285 }
        L_0x0270:
            int r2 = r2 + 1
            r13 = r25
            goto L_0x023e
        L_0x0275:
            r2 = r29
            r9 = 4
            r13 = 0
            r9 = 1
            r14 = 0
            boolean r0 = r1.zzo(r2, r3, r5)     // Catch:{ all -> 0x0334 }
            if (r0 != 0) goto L_0x02bb
            r15.zzP(r13)     // Catch:{ all -> 0x0334 }
            goto L_0x02bb
        L_0x0285:
            r0 = move-exception
            goto L_0x0214
        L_0x0287:
            r25 = r13
            r9 = 1
            r13 = 0
            r14 = 0
            boolean r0 = r29.zzo()     // Catch:{ all -> 0x0334 }
            if (r0 != 0) goto L_0x02bb
            com.google.android.gms.internal.ads.zzjm r0 = r15.zzq     // Catch:{ all -> 0x0334 }
            com.google.android.gms.internal.ads.zzjj r0 = r0.zzd()     // Catch:{ all -> 0x0334 }
        L_0x0298:
            if (r0 == 0) goto L_0x02b6
            com.google.android.gms.internal.ads.zzjk r1 = r0.zzf     // Catch:{ all -> 0x0334 }
            com.google.android.gms.internal.ads.zzsi r1 = r1.zza     // Catch:{ all -> 0x0334 }
            boolean r1 = r1.equals(r8)     // Catch:{ all -> 0x0334 }
            if (r1 == 0) goto L_0x02b1
            com.google.android.gms.internal.ads.zzjm r1 = r15.zzq     // Catch:{ all -> 0x0334 }
            com.google.android.gms.internal.ads.zzjk r3 = r0.zzf     // Catch:{ all -> 0x0334 }
            com.google.android.gms.internal.ads.zzjk r1 = r1.zzg(r12, r3)     // Catch:{ all -> 0x0334 }
            r0.zzf = r1     // Catch:{ all -> 0x0334 }
            r0.zzq()     // Catch:{ all -> 0x0334 }
        L_0x02b1:
            com.google.android.gms.internal.ads.zzjj r0 = r0.zzg()     // Catch:{ all -> 0x0334 }
            goto L_0x0298
        L_0x02b6:
            long r0 = r15.zzv(r8, r10, r2)     // Catch:{ all -> 0x0334 }
            r10 = r0
        L_0x02bb:
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            com.google.android.gms.internal.ads.zzcn r4 = r0.zza
            com.google.android.gms.internal.ads.zzsi r5 = r0.zzb
            if (r9 == r7) goto L_0x02c6
            r6 = r16
            goto L_0x02c7
        L_0x02c6:
            r6 = r10
        L_0x02c7:
            r1 = r28
            r2 = r29
            r3 = r8
            r1.zzZ(r2, r3, r4, r5, r6)
            if (r19 != 0) goto L_0x02d9
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            long r0 = r0.zzc
            int r2 = (r25 > r0 ? 1 : (r25 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0316
        L_0x02d9:
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            com.google.android.gms.internal.ads.zzsi r1 = r0.zzb
            java.lang.Object r1 = r1.zza
            com.google.android.gms.internal.ads.zzcn r0 = r0.zza
            if (r19 == 0) goto L_0x02f6
            if (r30 == 0) goto L_0x02f6
            boolean r2 = r0.zzo()
            if (r2 != 0) goto L_0x02f6
            com.google.android.gms.internal.ads.zzck r2 = r15.zzl
            com.google.android.gms.internal.ads.zzck r0 = r0.zzn(r1, r2)
            boolean r0 = r0.zzg
            if (r0 != 0) goto L_0x02f6
            goto L_0x02f7
        L_0x02f6:
            r9 = 0
        L_0x02f7:
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            long r5 = r0.zzd
            int r0 = r12.zza(r1)
            r1 = -1
            if (r0 != r1) goto L_0x0305
            r18 = 4
            goto L_0x0307
        L_0x0305:
            r18 = 3
        L_0x0307:
            r1 = r28
            r2 = r8
            r3 = r10
            r7 = r5
            r5 = r25
            r10 = r18
            com.google.android.gms.internal.ads.zzju r0 = r1.zzz(r2, r3, r5, r7, r9, r10)
            r15.zzu = r0
        L_0x0316:
            r28.zzL()
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            com.google.android.gms.internal.ads.zzcn r0 = r0.zza
            r15.zzN(r12, r0)
            com.google.android.gms.internal.ads.zzju r0 = r15.zzu
            com.google.android.gms.internal.ads.zzju r0 = r0.zzf(r12)
            r15.zzu = r0
            boolean r0 = r29.zzo()
            if (r0 != 0) goto L_0x0330
            r15.zzH = r14
        L_0x0330:
            r15.zzE(r13)
            return
        L_0x0334:
            r0 = move-exception
        L_0x0335:
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            com.google.android.gms.internal.ads.zzcn r4 = r1.zza
            com.google.android.gms.internal.ads.zzsi r5 = r1.zzb
            if (r9 == r7) goto L_0x0340
            r6 = r16
            goto L_0x0341
        L_0x0340:
            r6 = r10
        L_0x0341:
            r1 = r28
            r2 = r29
            r3 = r8
            r1.zzZ(r2, r3, r4, r5, r6)
            if (r19 != 0) goto L_0x0353
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            long r1 = r1.zzc
            int r3 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0390
        L_0x0353:
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            com.google.android.gms.internal.ads.zzsi r2 = r1.zzb
            java.lang.Object r2 = r2.zza
            com.google.android.gms.internal.ads.zzcn r1 = r1.zza
            if (r19 == 0) goto L_0x0370
            if (r30 == 0) goto L_0x0370
            boolean r3 = r1.zzo()
            if (r3 != 0) goto L_0x0370
            com.google.android.gms.internal.ads.zzck r3 = r15.zzl
            com.google.android.gms.internal.ads.zzck r1 = r1.zzn(r2, r3)
            boolean r1 = r1.zzg
            if (r1 != 0) goto L_0x0370
            goto L_0x0371
        L_0x0370:
            r9 = 0
        L_0x0371:
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            long r5 = r1.zzd
            int r1 = r12.zza(r2)
            r2 = -1
            if (r1 != r2) goto L_0x037f
            r18 = 4
            goto L_0x0381
        L_0x037f:
            r18 = 3
        L_0x0381:
            r1 = r28
            r2 = r8
            r3 = r10
            r7 = r5
            r5 = r25
            r10 = r18
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)
            r15.zzu = r1
        L_0x0390:
            r28.zzL()
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            com.google.android.gms.internal.ads.zzcn r1 = r1.zza
            r15.zzN(r12, r1)
            com.google.android.gms.internal.ads.zzju r1 = r15.zzu
            com.google.android.gms.internal.ads.zzju r1 = r1.zzf(r12)
            r15.zzu = r1
            boolean r1 = r29.zzo()
            if (r1 != 0) goto L_0x03aa
            r15.zzH = r14
        L_0x03aa:
            r15.zzE(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjd.zzF(com.google.android.gms.internal.ads.zzcn, boolean):void");
    }

    private final void zzG(zzby zzby, boolean z) throws zzha {
        zzH(zzby, zzby.zzc, true, z);
    }

    private final void zzH(zzby zzby, float f, boolean z, boolean z2) throws zzha {
        int i;
        zzjd zzjd = this;
        zzby zzby2 = zzby;
        if (z) {
            if (z2) {
                zzjd.zzv.zza(1);
            }
            zzju zzju = zzjd.zzu;
            zzcn zzcn = zzju.zza;
            zzsi zzsi = zzju.zzb;
            zzju zzju2 = r1;
            zzju zzju3 = zzju2;
            zzju zzju4 = zzju;
            zzcn zzcn2 = zzcn;
            zzsi zzsi2 = zzsi;
            zzju zzju5 = new zzju(zzcn2, zzsi2, zzju.zzc, zzju.zzd, zzju.zze, zzju.zzf, zzju.zzg, zzju.zzh, zzju.zzi, zzju.zzj, zzju.zzk, zzju4.zzl, zzju4.zzm, zzby, zzju4.zzp, zzju4.zzq, zzju4.zzr, zzju4.zzo);
            zzjd = this;
            zzjd.zzu = zzju2;
        }
        zzby zzby3 = zzby;
        float f2 = zzby3.zzc;
        zzjj zzd2 = zzjd.zzq.zzd();
        while (true) {
            i = 0;
            if (zzd2 == null) {
                break;
            }
            zzvt[] zzvtArr = zzd2.zzi().zzc;
            int length = zzvtArr.length;
            while (i < length) {
                zzvt zzvt = zzvtArr[i];
                i++;
            }
            zzd2 = zzd2.zzg();
        }
        zzka[] zzkaArr = zzjd.zza;
        int length2 = zzkaArr.length;
        while (i < 2) {
            zzka zzka = zzkaArr[i];
            if (zzka != null) {
                zzka.zzD(f, zzby3.zzc);
            } else {
                float f3 = f;
            }
            i++;
        }
    }

    private final void zzI() {
        boolean z;
        long j;
        long j2;
        if (!zzab()) {
            z = false;
        } else {
            zzjj zzc2 = this.zzq.zzc();
            long zzu2 = zzu(zzc2.zzd());
            if (zzc2 == this.zzq.zzd()) {
                j2 = this.zzI;
                j = zzc2.zze();
            } else {
                j2 = this.zzI - zzc2.zze();
                j = zzc2.zzf.zzb;
            }
            z = this.zzf.zzg(j2 - j, zzu2, this.zzn.zzc().zzc);
        }
        this.zzA = z;
        if (z) {
            this.zzq.zzc().zzk(this.zzI);
        }
        zzW();
    }

    private final void zzJ() {
        this.zzv.zzc(this.zzu);
        if (this.zzv.zzg) {
            zzhw zzhw = this.zzN;
            zzhw.zza.zzT(this.zzv);
            this.zzv = new zzjb(this.zzu);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzK(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.gms.internal.ads.zzdn r0 = r1.zzh
            r2 = 2
            r0.zze(r2)
            r3 = 0
            r1.zzL = r3
            r4 = 0
            r1.zzz = r4
            com.google.android.gms.internal.ads.zzgy r0 = r1.zzn
            r0.zzi()
            r5 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.zzI = r5
            com.google.android.gms.internal.ads.zzka[] r5 = r1.zza
            int r0 = r5.length
            r6 = 0
        L_0x001e:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r2) goto L_0x0033
            r0 = r5[r6]
            r1.zzA(r0)     // Catch:{ zzha -> 0x002a, RuntimeException -> 0x0028 }
            goto L_0x0030
        L_0x0028:
            r0 = move-exception
            goto L_0x002b
        L_0x002a:
            r0 = move-exception
        L_0x002b:
            java.lang.String r8 = "Disable failed."
            com.google.android.gms.internal.ads.zzdw.zzc(r7, r8, r0)
        L_0x0030:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x0033:
            if (r30 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzka[] r5 = r1.zza
            int r0 = r5.length
            r6 = 0
        L_0x0039:
            if (r6 >= r2) goto L_0x0053
            r0 = r5[r6]
            java.util.Set r8 = r1.zzb
            boolean r8 = r8.remove(r0)
            if (r8 == 0) goto L_0x0050
            r0.zzA()     // Catch:{ RuntimeException -> 0x0049 }
            goto L_0x0050
        L_0x0049:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.gms.internal.ads.zzdw.zzc(r7, r0, r8)
        L_0x0050:
            int r6 = r6 + 1
            goto L_0x0039
        L_0x0053:
            r1.zzG = r4
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            com.google.android.gms.internal.ads.zzsi r2 = r0.zzb
            long r5 = r0.zzr
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            boolean r0 = r0.zzb()
            if (r0 != 0) goto L_0x0075
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            com.google.android.gms.internal.ads.zzck r7 = r1.zzl
            boolean r0 = zzae(r0, r7)
            if (r0 == 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            long r7 = r0.zzr
            goto L_0x0079
        L_0x0075:
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            long r7 = r0.zzc
        L_0x0079:
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r31 == 0) goto L_0x00ad
            r1.zzH = r3
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            com.google.android.gms.internal.ads.zzcn r0 = r0.zza
            android.util.Pair r0 = r1.zzx(r0)
            java.lang.Object r2 = r0.first
            com.google.android.gms.internal.ads.zzsi r2 = (com.google.android.gms.internal.ads.zzsi) r2
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00a7
            r0 = 1
            r18 = r2
            r26 = r5
            r8 = r9
            goto L_0x00b3
        L_0x00a7:
            r18 = r2
            r26 = r5
            r8 = r9
            goto L_0x00b2
        L_0x00ad:
            r18 = r2
            r26 = r5
            r8 = r7
        L_0x00b2:
            r0 = 0
        L_0x00b3:
            com.google.android.gms.internal.ads.zzjm r2 = r1.zzq
            r2.zzi()
            r1.zzA = r4
            com.google.android.gms.internal.ads.zzju r2 = new com.google.android.gms.internal.ads.zzju
            com.google.android.gms.internal.ads.zzju r4 = r1.zzu
            com.google.android.gms.internal.ads.zzcn r6 = r4.zza
            int r12 = r4.zze
            if (r33 == 0) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            com.google.android.gms.internal.ads.zzha r3 = r4.zzf
        L_0x00c7:
            r13 = r3
            if (r0 == 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzuh r3 = com.google.android.gms.internal.ads.zzuh.zza
            goto L_0x00cf
        L_0x00cd:
            com.google.android.gms.internal.ads.zzuh r3 = r4.zzh
        L_0x00cf:
            r15 = r3
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zzwa r3 = r1.zze
            goto L_0x00d9
        L_0x00d5:
            com.google.android.gms.internal.ads.zzju r3 = r1.zzu
            com.google.android.gms.internal.ads.zzwa r3 = r3.zzi
        L_0x00d9:
            r16 = r3
            if (r0 == 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzfvn r0 = com.google.android.gms.internal.ads.zzfvn.zzo()
            goto L_0x00e6
        L_0x00e2:
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            java.util.List r0 = r0.zzj
        L_0x00e6:
            r17 = r0
            com.google.android.gms.internal.ads.zzju r0 = r1.zzu
            r14 = 0
            boolean r3 = r0.zzl
            r19 = r3
            int r3 = r0.zzm
            r20 = r3
            com.google.android.gms.internal.ads.zzby r0 = r0.zzn
            r21 = r0
            r24 = 0
            r28 = 0
            r5 = r2
            r7 = r18
            r10 = r26
            r22 = r26
            r5.<init>(r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r28)
            r1.zzu = r2
            if (r32 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzjt r0 = r1.zzr
            r0.zzg()
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjd.zzK(boolean, boolean, boolean, boolean):void");
    }

    private final void zzL() {
        zzjj zzd2 = this.zzq.zzd();
        boolean z = false;
        if (zzd2 != null && zzd2.zzf.zzh && this.zzx) {
            z = true;
        }
        this.zzy = z;
    }

    private final void zzM(long j) throws zzha {
        long j2;
        zzjj zzd2 = this.zzq.zzd();
        if (zzd2 == null) {
            j2 = 1000000000000L;
        } else {
            j2 = zzd2.zze();
        }
        long j3 = j + j2;
        this.zzI = j3;
        this.zzn.zzf(j3);
        zzka[] zzkaArr = this.zza;
        int length = zzkaArr.length;
        for (int i = 0; i < 2; i++) {
            zzka zzka = zzkaArr[i];
            if (zzac(zzka)) {
                zzka.zzB(this.zzI);
            }
        }
        for (zzjj zzd3 = this.zzq.zzd(); zzd3 != null; zzd3 = zzd3.zzg()) {
            for (zzvt zzvt : zzd3.zzi().zzc) {
            }
        }
    }

    private final void zzN(zzcn zzcn, zzcn zzcn2) {
        if (!zzcn.zzo() || !zzcn2.zzo()) {
            int size = this.zzo.size() - 1;
            if (size < 0) {
                Collections.sort(this.zzo);
                return;
            }
            zzja zzja = (zzja) this.zzo.get(size);
            Object obj = zzja.zzb;
            zzjx zzjx = zzja.zza;
            int i = zzen.zza;
            zzjx zzjx2 = zzja.zza;
            throw null;
        }
    }

    private final void zzO(long j, long j2) {
        this.zzh.zzi(2, j + j2);
    }

    private final void zzP(boolean z) throws zzha {
        zzsi zzsi = this.zzq.zzd().zzf.zza;
        long zzw2 = zzw(zzsi, this.zzu.zzr, true, false);
        if (zzw2 != this.zzu.zzr) {
            zzju zzju = this.zzu;
            this.zzu = zzz(zzsi, zzw2, zzju.zzc, zzju.zzd, z, 5);
        }
    }

    private final void zzQ(zzjx zzjx) throws zzha {
        if (zzjx.zzb() == this.zzj) {
            zzai(zzjx);
            int i = this.zzu.zze;
            if (i == 3 || i == 2) {
                this.zzh.zzh(2);
                return;
            }
            return;
        }
        this.zzh.zzb(15, zzjx).zza();
    }

    private final void zzR(boolean z, int i, boolean z2, int i2) throws zzha {
        this.zzv.zza(z2 ? 1 : 0);
        this.zzv.zzb(i2);
        this.zzu = this.zzu.zzc(z, i);
        this.zzz = false;
        for (zzjj zzd2 = this.zzq.zzd(); zzd2 != null; zzd2 = zzd2.zzg()) {
            for (zzvt zzvt : zzd2.zzi().zzc) {
            }
        }
        if (!zzaf()) {
            zzV();
            zzY();
            return;
        }
        int i3 = this.zzu.zze;
        if (i3 == 3) {
            zzT();
            this.zzh.zzh(2);
        } else if (i3 == 2) {
            this.zzh.zzh(2);
        }
    }

    private final void zzS(int i) {
        zzju zzju = this.zzu;
        if (zzju.zze != i) {
            if (i != 2) {
                this.zzM = -9223372036854775807L;
            }
            this.zzu = zzju.zze(i);
        }
    }

    private final void zzT() throws zzha {
        this.zzz = false;
        this.zzn.zzh();
        zzka[] zzkaArr = this.zza;
        int length = zzkaArr.length;
        for (int i = 0; i < 2; i++) {
            zzka zzka = zzkaArr[i];
            if (zzac(zzka)) {
                zzka.zzE();
            }
        }
    }

    private final void zzU(boolean z, boolean z2) {
        zzK(z || !this.zzD, false, true, false);
        this.zzv.zza(z2 ? 1 : 0);
        this.zzf.zzd();
        zzS(1);
    }

    private final void zzV() throws zzha {
        this.zzn.zzi();
        zzka[] zzkaArr = this.zza;
        int length = zzkaArr.length;
        for (int i = 0; i < 2; i++) {
            zzka zzka = zzkaArr[i];
            if (zzac(zzka)) {
                zzaj(zzka);
            }
        }
    }

    private final void zzW() {
        zzjj zzc2 = this.zzq.zzc();
        boolean z = this.zzA || (zzc2 != null && zzc2.zza.zzp());
        zzju zzju = this.zzu;
        if (z != zzju.zzg) {
            this.zzu = new zzju(zzju.zza, zzju.zzb, zzju.zzc, zzju.zzd, zzju.zze, zzju.zzf, z, zzju.zzh, zzju.zzi, zzju.zzj, zzju.zzk, zzju.zzl, zzju.zzm, zzju.zzn, zzju.zzp, zzju.zzq, zzju.zzr, zzju.zzo);
        }
    }

    private final void zzX(zzuh zzuh, zzwa zzwa) {
        this.zzf.zze(this.zza, zzuh, zzwa.zzc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzY() throws com.google.android.gms.internal.ads.zzha {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzjm r0 = r11.zzq
            com.google.android.gms.internal.ads.zzjj r0 = r0.zzd()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r1 = r0.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzsg r1 = r0.zza
            long r4 = r1.zzd()
            r6 = r4
            goto L_0x001b
        L_0x001a:
            r6 = r2
        L_0x001b:
            r10 = 0
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x003d
            r11.zzM(r6)
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            long r0 = r0.zzr
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzsi r1 = r0.zzb
            long r4 = r0.zzc
            r8 = 1
            r9 = 5
            r0 = r11
            r2 = r6
            com.google.android.gms.internal.ads.zzju r0 = r0.zzz(r1, r2, r4, r6, r8, r9)
            r11.zzu = r0
            goto L_0x00cd
        L_0x003d:
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq
            com.google.android.gms.internal.ads.zzjj r2 = r2.zze()
            if (r0 == r2) goto L_0x0049
            r2 = 1
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            long r1 = r1.zzb(r2)
            r11.zzI = r1
            long r3 = r0.zze()
            long r1 = r1 - r3
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            long r3 = r0.zzr
            java.util.ArrayList r0 = r11.zzo
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            boolean r0 = r0.zzb()
            if (r0 == 0) goto L_0x006c
            goto L_0x00c9
        L_0x006c:
            boolean r0 = r11.zzK
            if (r0 == 0) goto L_0x0075
            r5 = -1
            long r3 = r3 + r5
            r11.zzK = r10
        L_0x0075:
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzcn r5 = r0.zza
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            java.lang.Object r0 = r0.zza
            int r0 = r5.zza(r0)
            int r5 = r11.zzJ
            java.util.ArrayList r6 = r11.zzo
            int r6 = r6.size()
            int r5 = java.lang.Math.min(r5, r6)
            r6 = 0
            if (r5 <= 0) goto L_0x009b
            java.util.ArrayList r7 = r11.zzo
            int r8 = r5 + -1
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzja r7 = (com.google.android.gms.internal.ads.zzja) r7
            goto L_0x009c
        L_0x009b:
            r7 = r6
        L_0x009c:
            if (r7 == 0) goto L_0x00b7
            if (r0 < 0) goto L_0x00a8
            if (r0 != 0) goto L_0x00b7
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x00b7
        L_0x00a8:
            int r5 = r5 + -1
            if (r5 <= 0) goto L_0x009b
            java.util.ArrayList r7 = r11.zzo
            int r8 = r5 + -1
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzja r7 = (com.google.android.gms.internal.ads.zzja) r7
            goto L_0x009c
        L_0x00b7:
            java.util.ArrayList r0 = r11.zzo
            int r0 = r0.size()
            if (r5 >= r0) goto L_0x00c7
            java.util.ArrayList r0 = r11.zzo
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.ads.zzja r0 = (com.google.android.gms.internal.ads.zzja) r0
        L_0x00c7:
            r11.zzJ = r5
        L_0x00c9:
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            r0.zzr = r1
        L_0x00cd:
            com.google.android.gms.internal.ads.zzjm r0 = r11.zzq
            com.google.android.gms.internal.ads.zzjj r0 = r0.zzc()
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu
            long r2 = r0.zzc()
            r1.zzp = r2
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            long r1 = r11.zzt()
            r0.zzq = r1
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            boolean r1 = r0.zzl
            if (r1 == 0) goto L_0x0145
            int r1 = r0.zze
            r2 = 3
            if (r1 != r2) goto L_0x0145
            com.google.android.gms.internal.ads.zzcn r1 = r0.zza
            com.google.android.gms.internal.ads.zzsi r0 = r0.zzb
            boolean r0 = r11.zzag(r1, r0)
            if (r0 == 0) goto L_0x0145
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzby r1 = r0.zzn
            float r1 = r1.zzc
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0145
            com.google.android.gms.internal.ads.zzgv r1 = r11.zzO
            com.google.android.gms.internal.ads.zzcn r2 = r0.zza
            com.google.android.gms.internal.ads.zzsi r3 = r0.zzb
            java.lang.Object r3 = r3.zza
            long r4 = r0.zzr
            long r2 = r11.zzs(r2, r3, r4)
            long r4 = r11.zzt()
            float r0 = r1.zza(r2, r4)
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn
            com.google.android.gms.internal.ads.zzby r1 = r1.zzc()
            float r1 = r1.zzc
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 == 0) goto L_0x0145
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu
            com.google.android.gms.internal.ads.zzby r2 = r2.zzn
            com.google.android.gms.internal.ads.zzby r3 = new com.google.android.gms.internal.ads.zzby
            float r2 = r2.zzd
            r3.<init>(r0, r2)
            r1.zzg(r3)
            com.google.android.gms.internal.ads.zzju r0 = r11.zzu
            com.google.android.gms.internal.ads.zzby r0 = r0.zzn
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn
            com.google.android.gms.internal.ads.zzby r1 = r1.zzc()
            float r1 = r1.zzc
            r11.zzH(r0, r1, r10, r10)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjd.zzY():void");
    }

    private final void zzZ(zzcn zzcn, zzsi zzsi, zzcn zzcn2, zzsi zzsi2, long j) {
        if (!zzag(zzcn, zzsi)) {
            zzby zzby = zzsi.zzb() ? zzby.zza : this.zzu.zzn;
            if (!this.zzn.zzc().equals(zzby)) {
                this.zzn.zzg(zzby);
                return;
            }
            return;
        }
        zzcn.zze(zzcn.zzn(zzsi.zza, this.zzl).zzd, this.zzk, 0);
        zzgv zzgv = this.zzO;
        zzaw zzaw = this.zzk.zzk;
        int i = zzen.zza;
        zzgv.zzd(zzaw);
        if (j != -9223372036854775807L) {
            this.zzO.zze(zzs(zzcn, zzsi.zza, j));
            return;
        }
        if (!zzen.zzT(!zzcn2.zzo() ? zzcn2.zze(zzcn2.zzn(zzsi2.zza, this.zzl).zzd, this.zzk, 0).zzc : null, this.zzk.zzc)) {
            this.zzO.zze(-9223372036854775807L);
        }
    }

    private final synchronized void zzaa(zzftn zzftn, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (!Boolean.valueOf(((zziu) zzftn).zza.zzw).booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzab() {
        zzjj zzc2 = this.zzq.zzc();
        if (zzc2 == null || zzc2.zzd() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private static boolean zzac(zzka zzka) {
        return zzka.zzbe() != 0;
    }

    private final boolean zzad() {
        zzjj zzd2 = this.zzq.zzd();
        long j = zzd2.zzf.zze;
        if (zzd2.zzd) {
            return j == -9223372036854775807L || this.zzu.zzr < j || !zzaf();
        }
        return false;
    }

    private static boolean zzae(zzju zzju, zzck zzck) {
        zzsi zzsi = zzju.zzb;
        zzcn zzcn = zzju.zza;
        return zzcn.zzo() || zzcn.zzn(zzsi.zza, zzck).zzg;
    }

    private final boolean zzaf() {
        zzju zzju = this.zzu;
        return zzju.zzl && zzju.zzm == 0;
    }

    private final boolean zzag(zzcn zzcn, zzsi zzsi) {
        if (!zzsi.zzb() && !zzcn.zzo()) {
            zzcn.zze(zzcn.zzn(zzsi.zza, this.zzl).zzd, this.zzk, 0);
            if (this.zzk.zzb()) {
                zzcm zzcm = this.zzk;
                if (!zzcm.zzi || zzcm.zzf == -9223372036854775807L) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private static zzaf[] zzah(zzvt zzvt) {
        int zzc2 = zzvt != null ? zzvt.zzc() : 0;
        zzaf[] zzafArr = new zzaf[zzc2];
        for (int i = 0; i < zzc2; i++) {
            zzafArr[i] = zzvt.zzd(i);
        }
        return zzafArr;
    }

    private static final void zzai(zzjx zzjx) throws zzha {
        zzjx.zzj();
        try {
            zzjx.zzc().zzp(zzjx.zza(), zzjx.zzg());
        } finally {
            zzjx.zzh(true);
        }
    }

    private static final void zzaj(zzka zzka) throws zzha {
        if (zzka.zzbe() == 2) {
            zzka.zzF();
        }
    }

    private static final void zzak(zzka zzka, long j) {
        zzka.zzC();
        if (zzka instanceof zzuk) {
            zzuk zzuk = (zzuk) zzka;
            throw null;
        }
    }

    static Object zze(zzcm zzcm, zzck zzck, int i, boolean z, Object obj, zzcn zzcn, zzcn zzcn2) {
        int zza2 = zzcn.zza(obj);
        int zzb2 = zzcn.zzb();
        int i2 = 0;
        int i3 = zza2;
        int i4 = -1;
        while (true) {
            if (i2 >= zzb2 || i4 != -1) {
                break;
            }
            i3 = zzcn.zzi(i3, zzck, zzcm, i, z);
            if (i3 == -1) {
                i4 = -1;
                break;
            }
            i4 = zzcn2.zza(zzcn.zzf(i3));
            i2++;
        }
        if (i4 == -1) {
            return null;
        }
        return zzcn2.zzf(i4);
    }

    static final /* synthetic */ void zzr(zzjx zzjx) {
        try {
            zzai(zzjx);
        } catch (zzha e) {
            zzdw.zzc("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzs(zzcn zzcn, Object obj, long j) {
        zzcn.zze(zzcn.zzn(obj, this.zzl).zzd, this.zzk, 0);
        zzcm zzcm = this.zzk;
        if (zzcm.zzf != -9223372036854775807L && zzcm.zzb()) {
            zzcm zzcm2 = this.zzk;
            if (zzcm2.zzi) {
                return zzen.zzv(zzen.zzt(zzcm2.zzg) - this.zzk.zzf) - j;
            }
        }
        return -9223372036854775807L;
    }

    private final long zzt() {
        return zzu(this.zzu.zzp);
    }

    private final long zzu(long j) {
        zzjj zzc2 = this.zzq.zzc();
        if (zzc2 == null) {
            return 0;
        }
        return Math.max(0, j - (this.zzI - zzc2.zze()));
    }

    private final long zzv(zzsi zzsi, long j, boolean z) throws zzha {
        return zzw(zzsi, j, this.zzq.zzd() != this.zzq.zze(), z);
    }

    private final long zzw(zzsi zzsi, long j, boolean z, boolean z2) throws zzha {
        zzV();
        this.zzz = false;
        if (z2 || this.zzu.zze == 3) {
            zzS(2);
        }
        zzjj zzd2 = this.zzq.zzd();
        zzjj zzjj = zzd2;
        while (zzjj != null && !zzsi.equals(zzjj.zzf.zza)) {
            zzjj = zzjj.zzg();
        }
        if (z || zzd2 != zzjj || (zzjj != null && zzjj.zze() + j < 0)) {
            zzka[] zzkaArr = this.zza;
            int length = zzkaArr.length;
            for (int i = 0; i < 2; i++) {
                zzA(zzkaArr[i]);
            }
            if (zzjj != null) {
                while (this.zzq.zzd() != zzjj) {
                    this.zzq.zza();
                }
                this.zzq.zzm(zzjj);
                zzjj.zzp(1000000000000L);
                zzB();
            }
        }
        if (zzjj != null) {
            this.zzq.zzm(zzjj);
            if (!zzjj.zzd) {
                zzjj.zzf = zzjj.zzf.zzb(j);
            } else if (zzjj.zze) {
                j = zzjj.zza.zze(j);
                zzjj.zza.zzj(j - this.zzm, false);
            }
            zzM(j);
            zzI();
        } else {
            this.zzq.zzi();
            zzM(j);
        }
        zzE(false);
        this.zzh.zzh(2);
        return j;
    }

    private final Pair zzx(zzcn zzcn) {
        long j = 0;
        if (zzcn.zzo()) {
            return Pair.create(zzju.zzh(), 0L);
        }
        zzcn zzcn2 = zzcn;
        Pair zzl2 = zzcn2.zzl(this.zzk, this.zzl, zzcn.zzg(this.zzC), -9223372036854775807L);
        zzsi zzh2 = this.zzq.zzh(zzcn, zzl2.first, 0);
        long longValue = ((Long) zzl2.second).longValue();
        if (zzh2.zzb()) {
            zzcn.zzn(zzh2.zza, this.zzl);
            if (zzh2.zzc == this.zzl.zze(zzh2.zzb)) {
                this.zzl.zzi();
            }
        } else {
            j = longValue;
        }
        return Pair.create(zzh2, Long.valueOf(j));
    }

    private static Pair zzy(zzcn zzcn, zzjc zzjc, boolean z, int i, boolean z2, zzcm zzcm, zzck zzck) {
        zzcn zzcn2 = zzcn;
        zzjc zzjc2 = zzjc;
        zzck zzck2 = zzck;
        zzcn zzcn3 = zzjc2.zza;
        if (zzcn.zzo()) {
            return null;
        }
        zzcn zzcn4 = true == zzcn3.zzo() ? zzcn2 : zzcn3;
        try {
            Pair zzl2 = zzcn4.zzl(zzcm, zzck, zzjc2.zzb, zzjc2.zzc);
            if (zzcn.equals(zzcn4)) {
                return zzl2;
            }
            if (zzcn.zza(zzl2.first) == -1) {
                zzcm zzcm2 = zzcm;
                Object zze2 = zze(zzcm, zzck, i, z2, zzl2.first, zzcn4, zzcn);
                if (zze2 != null) {
                    return zzcn.zzl(zzcm, zzck, zzcn.zzn(zze2, zzck2).zzd, -9223372036854775807L);
                }
                return null;
            } else if (!zzcn4.zzn(zzl2.first, zzck2).zzg || zzcn4.zze(zzck2.zzd, zzcm, 0).zzo != zzcn4.zza(zzl2.first)) {
                return zzl2;
            } else {
                return zzcn.zzl(zzcm, zzck, zzcn.zzn(zzl2.first, zzck2).zzd, zzjc2.zzc);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzju zzz(com.google.android.gms.internal.ads.zzsi r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r5 = r20
            boolean r1 = r0.zzK
            r3 = 0
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzju r1 = r0.zzu
            long r7 = r1.zzr
            int r1 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzju r1 = r0.zzu
            com.google.android.gms.internal.ads.zzsi r1 = r1.zzb
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r1 = 0
            goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            r0.zzK = r1
            r16.zzL()
            com.google.android.gms.internal.ads.zzju r1 = r0.zzu
            com.google.android.gms.internal.ads.zzuh r7 = r1.zzh
            com.google.android.gms.internal.ads.zzwa r8 = r1.zzi
            java.util.List r1 = r1.zzj
            com.google.android.gms.internal.ads.zzjt r9 = r0.zzr
            boolean r9 = r9.zzi()
            if (r9 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzjm r1 = r0.zzq
            com.google.android.gms.internal.ads.zzjj r1 = r1.zzd()
            if (r1 != 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzuh r7 = com.google.android.gms.internal.ads.zzuh.zza
            goto L_0x0045
        L_0x0041:
            com.google.android.gms.internal.ads.zzuh r7 = r1.zzh()
        L_0x0045:
            if (r1 != 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzwa r8 = r0.zze
            goto L_0x004e
        L_0x004a:
            com.google.android.gms.internal.ads.zzwa r8 = r1.zzi()
        L_0x004e:
            com.google.android.gms.internal.ads.zzvt[] r9 = r8.zzc
            com.google.android.gms.internal.ads.zzfvk r10 = new com.google.android.gms.internal.ads.zzfvk
            r10.<init>()
            int r11 = r9.length
            r12 = 0
            r13 = 0
        L_0x0058:
            if (r12 >= r11) goto L_0x007f
            r14 = r9[r12]
            if (r14 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzaf r14 = r14.zzd(r3)
            com.google.android.gms.internal.ads.zzbq r14 = r14.zzk
            if (r14 != 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzbq r14 = new com.google.android.gms.internal.ads.zzbq
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            com.google.android.gms.internal.ads.zzbp[] r15 = new com.google.android.gms.internal.ads.zzbp[r3]
            r14.<init>(r4, r15)
            r10.zze(r14)
            goto L_0x007a
        L_0x0076:
            r10.zze(r14)
            r13 = 1
        L_0x007a:
            int r12 = r12 + 1
            r5 = r20
            goto L_0x0058
        L_0x007f:
            if (r13 == 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzfvn r3 = r10.zzg()
            goto L_0x008a
        L_0x0086:
            com.google.android.gms.internal.ads.zzfvn r3 = com.google.android.gms.internal.ads.zzfvn.zzo()
        L_0x008a:
            if (r1 == 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzjk r4 = r1.zzf
            long r5 = r4.zzc
            r9 = r20
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x009f
            com.google.android.gms.internal.ads.zzjk r4 = r4.zza(r9)
            r1.zzf = r4
            goto L_0x009f
        L_0x009d:
            r9 = r20
        L_0x009f:
            r13 = r3
            goto L_0x00b9
        L_0x00a1:
            r9 = r5
            com.google.android.gms.internal.ads.zzju r3 = r0.zzu
            com.google.android.gms.internal.ads.zzsi r3 = r3.zzb
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzuh r1 = com.google.android.gms.internal.ads.zzuh.zza
            com.google.android.gms.internal.ads.zzwa r3 = r0.zze
            com.google.android.gms.internal.ads.zzfvn r4 = com.google.android.gms.internal.ads.zzfvn.zzo()
            r11 = r1
            r12 = r3
            r13 = r4
            goto L_0x00bb
        L_0x00b8:
            r13 = r1
        L_0x00b9:
            r11 = r7
            r12 = r8
        L_0x00bb:
            if (r24 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzjb r1 = r0.zzv
            r3 = r25
            r1.zzd(r3)
        L_0x00c4:
            com.google.android.gms.internal.ads.zzju r1 = r0.zzu
            long r14 = r16.zzt()
            r2 = r17
            r3 = r18
            r5 = r20
            r7 = r22
            r9 = r14
            com.google.android.gms.internal.ads.zzju r1 = r1.zzb(r2, r3, r5, r7, r9, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjd.zzz(com.google.android.gms.internal.ads.zzsi, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzju");
    }

    /* JADX WARNING: type inference failed for: r2v26, types: [com.google.android.gms.internal.ads.zzfz, com.google.android.gms.internal.ads.zzwh] */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0212, code lost:
        if (r4 == false) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0214, code lost:
        r10 = r11.zzq.zzd();
        r19 = r11.zzq.zzm(r10);
        r1 = r11.zza.length;
        r9 = new boolean[2];
        r5 = r10.zzb(r5, r11.zzu.zzr, r19, r9);
        r1 = r11.zzu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0238, code lost:
        if (r1.zze == 4) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x023e, code lost:
        if (r5 == r1.zzr) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0240, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0242, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0243, code lost:
        r1 = r11.zzu;
        r12 = r5;
        r14 = 2;
        r17 = r9;
        r22 = r10;
        r11.zzu = zzz(r1.zzb, r5, r1.zzc, r1.zzd, r15, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0263, code lost:
        if (r15 == false) goto L_0x0268;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0265, code lost:
        r11.zzM(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0268, code lost:
        r1 = r11.zza.length;
        r1 = new boolean[2];
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x026e, code lost:
        r3 = r11.zza;
        r4 = r3.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0271, code lost:
        if (r2 >= 2) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0273, code lost:
        r3 = r3[r2];
        r4 = zzac(r3);
        r1[r2] = r4;
        r5 = r22;
        r6 = r5.zzc[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0281, code lost:
        if (r4 == false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0287, code lost:
        if (r6 == r3.zzm()) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0289, code lost:
        r11.zzA(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x028f, code lost:
        if (r17[r2] == false) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0291, code lost:
        r3.zzB(r11.zzI);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0296, code lost:
        r2 = r2 + 1;
        r22 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x029b, code lost:
        r11.zzC(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x029f, code lost:
        r14 = 2;
        r11.zzq.zzm(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a7, code lost:
        if (r2.zzd == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02a9, code lost:
        r2.zza(r5, java.lang.Math.max(r2.zzf.zzb, r11.zzI - r2.zze()), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02bc, code lost:
        r11.zzE(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02c5, code lost:
        if (r11.zzu.zze == 4) goto L_0x0b42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c7, code lost:
        zzI();
        zzY();
        r11.zzh.zzh(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x0939, code lost:
        if (r11.zzf.zzh(zzt(), r11.zzn.zzc().zzc, r11.zzz, r29) != false) goto L_0x093b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x095b, code lost:
        if (r2 == false) goto L_0x095d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x07e7 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x0870 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0996 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0a03 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:547:0x0a05 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:557:0x0a19 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:558:0x0a6f A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:564:0x0a83 A[Catch:{ all -> 0x035f, all -> 0x018d, zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:589:0x0aee  */
    /* JADX WARNING: Removed duplicated region for block: B:590:0x0af1  */
    /* JADX WARNING: Removed duplicated region for block: B:601:0x0b2b  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0b35  */
    /* JADX WARNING: Removed duplicated region for block: B:620:0x0b63  */
    /* JADX WARNING: Removed duplicated region for block: B:621:0x0b78  */
    /* JADX WARNING: Removed duplicated region for block: B:684:0x0873 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r54) {
        /*
            r53 = this;
            r11 = r53
            r1 = r54
            r13 = 0
            r14 = 1
            int r2 = r1.what     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r15 = -1
            r9 = 0
            r7 = 4
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 2
            switch(r2) {
                case 0: goto L_0x0ab1;
                case 1: goto L_0x0aa2;
                case 2: goto L_0x04fd;
                case 3: goto L_0x0387;
                case 4: goto L_0x0372;
                case 5: goto L_0x036a;
                case 6: goto L_0x0363;
                case 7: goto L_0x0345;
                case 8: goto L_0x02ec;
                case 9: goto L_0x02d4;
                case 10: goto L_0x01c6;
                case 11: goto L_0x01ae;
                case 12: goto L_0x0191;
                case 13: goto L_0x0152;
                case 14: goto L_0x0149;
                case 15: goto L_0x011b;
                case 16: goto L_0x0112;
                case 17: goto L_0x00d4;
                case 18: goto L_0x00b0;
                case 19: goto L_0x0094;
                case 20: goto L_0x007c;
                case 21: goto L_0x0068;
                case 22: goto L_0x005d;
                case 23: goto L_0x0037;
                case 24: goto L_0x001b;
                case 25: goto L_0x0016;
                default: goto L_0x0014;
            }     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0014:
            r1 = 0
            return r1
        L_0x0016:
            r11.zzP(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x001b:
            int r1 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != r14) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            boolean r2 = r11.zzF     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == r2) goto L_0x0b42
            r11.zzF = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzo     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzdn r1 = r11.zzh     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzh(r8)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0037:
            int r1 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x003d
            r1 = 1
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            r11.zzx = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzL()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r11.zzy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == r2) goto L_0x0b42
            r11.zzP(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzE(r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x005d:
            com.google.android.gms.internal.ads.zzjt r1 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r1.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0068:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r1 = (com.google.android.gms.internal.ads.zzuc) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r2 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zza(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r2 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r2.zzn(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x007c:
            int r2 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r1.arg2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r1 = (com.google.android.gms.internal.ads.zzuc) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r4 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4.zza(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r4 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r4.zzl(r2, r3, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0094:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zziz r1 = (com.google.android.gms.internal.ads.zziz) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r2 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zza(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r2 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r1 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r2.zzk(r13, r13, r13, r9)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x00b0:
            java.lang.Object r2 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zziy r2 = (com.google.android.gms.internal.ads.zziy) r2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r3 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.zza(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r3 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != r15) goto L_0x00c3
            int r1 = r3.zza()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x00c3:
            java.util.List r4 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r2 = r2.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r3.zzj(r1, r4, r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x00d4:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zziy r1 = (com.google.android.gms.internal.ads.zziy) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r2 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zza(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r2 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == r15) goto L_0x00ff
            com.google.android.gms.internal.ads.zzjc r2 = new com.google.android.gms.internal.ads.zzjc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjy r3 = new com.google.android.gms.internal.ads.zzjy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.util.List r4 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r5 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.<init>(r4, r5, r9)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r5 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.<init>(r3, r4, r5)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzH = r2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x00ff:
            com.google.android.gms.internal.ads.zzjt r2 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.util.List r3 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuc r1 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r2.zzm(r3, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzF(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0112:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r1 = (com.google.android.gms.internal.ads.zzby) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzG(r1, r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x011b:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjx r1 = (com.google.android.gms.internal.ads.zzjx) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            android.os.Looper r2 = r1.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Thread r3 = r2.getThread()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r3.isAlive()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != 0) goto L_0x0139
            java.lang.String r2 = "TAG"
            java.lang.String r3 = "Trying to send message on a dead thread."
            com.google.android.gms.internal.ads.zzdw.zze(r2, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzh(r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0139:
            com.google.android.gms.internal.ads.zzde r3 = r11.zzp     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzdn r2 = r3.zzb(r2, r9)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zziv r3 = new com.google.android.gms.internal.ads.zziv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.<init>(r11, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zzg(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0149:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjx r1 = (com.google.android.gms.internal.ads.zzjx) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzQ(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0152:
            int r2 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0158
            r2 = 1
            goto L_0x0159
        L_0x0158:
            r2 = 0
        L_0x0159:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.util.concurrent.atomic.AtomicBoolean r1 = (java.util.concurrent.atomic.AtomicBoolean) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r11.zzD     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == r2) goto L_0x0181
            r11.zzD = r2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzka[] r2 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r2.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 0
        L_0x0169:
            if (r3 >= r8) goto L_0x0181
            r4 = r2[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r5 = zzac(r4)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 != 0) goto L_0x017e
            java.util.Set r5 = r11.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r5 = r5.remove(r4)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 == 0) goto L_0x017e
            r4.zzA()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x017e:
            int r3 = r3 + 1
            goto L_0x0169
        L_0x0181:
            if (r1 == 0) goto L_0x0b42
            monitor-enter(r53)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.set(r14)     // Catch:{ all -> 0x018d }
            r53.notifyAll()     // Catch:{ all -> 0x018d }
            monitor-exit(r53)     // Catch:{ all -> 0x018d }
            goto L_0x0b42
        L_0x018d:
            r0 = move-exception
            r1 = r0
            monitor-exit(r53)     // Catch:{ all -> 0x018d }
            throw r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0191:
            int r1 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0197
            r1 = 1
            goto L_0x0198
        L_0x0197:
            r1 = 0
        L_0x0198:
            r11.zzC = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r2.zzq(r3, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x01a9
            r11.zzP(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x01a9:
            r11.zzE(r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x01ae:
            int r1 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzB = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r2.zzp(r3, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x01c1
            r11.zzP(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x01c1:
            r11.zzE(r13)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x01c6:
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r1 = r1.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            float r1 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r3 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r3 = r3.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = 1
        L_0x01db:
            if (r2 == 0) goto L_0x0b42
            boolean r5 = r2.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 == 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzju r5 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r5 = r5.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r5 = r2.zzj(r1, r5)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r6 = r2.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r6 == 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzvt[] r9 = r6.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r9 = r9.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzvt[] r10 = r5.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r10 = r10.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r9 == r10) goto L_0x01f8
            goto L_0x0212
        L_0x01f8:
            r9 = 0
        L_0x01f9:
            com.google.android.gms.internal.ads.zzvt[] r10 = r5.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r10 = r10.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r9 >= r10) goto L_0x0207
            boolean r10 = r5.zza(r6, r9)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r10 == 0) goto L_0x0212
            int r9 = r9 + 1
            goto L_0x01f9
        L_0x0207:
            if (r2 != r3) goto L_0x020b
            r5 = 0
            goto L_0x020c
        L_0x020b:
            r5 = 1
        L_0x020c:
            r4 = r4 & r5
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x01db
        L_0x0212:
            if (r4 == 0) goto L_0x029f
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r10 = r1.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r19 = r1.zzm(r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzka[] r1 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean[] r9 = new boolean[r8]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r1 = r1.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r15 = r10
            r16 = r5
            r17 = r1
            r20 = r9
            long r5 = r15.zzb(r16, r17, r19, r20)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r2 = r1.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == r7) goto L_0x0242
            long r1 = r1.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0242
            r15 = 1
            goto L_0x0243
        L_0x0242:
            r15 = 0
        L_0x0243:
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r2 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r3 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r18 = 5
            r1 = r53
            r19 = r3
            r3 = r5
            r12 = r5
            r5 = r19
            r14 = 2
            r17 = r9
            r9 = r15
            r22 = r10
            r10 = r18
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzu = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r15 == 0) goto L_0x0268
            r11.zzM(r12)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0268:
            com.google.android.gms.internal.ads.zzka[] r1 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean[] r1 = new boolean[r14]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 0
        L_0x026e:
            com.google.android.gms.internal.ads.zzka[] r3 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 >= r14) goto L_0x029b
            r3 = r3[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = zzac(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1[r2] = r4     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = r22
            com.google.android.gms.internal.ads.zztz[] r6 = r5.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r6 = r6[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x0296
            com.google.android.gms.internal.ads.zztz r4 = r3.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r6 == r4) goto L_0x028d
            r11.zzA(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0296
        L_0x028d:
            boolean r4 = r17[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x0296
            long r6 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.zzB(r6)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0296:
            int r2 = r2 + 1
            r22 = r5
            goto L_0x026e
        L_0x029b:
            r11.zzC(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x02bc
        L_0x029f:
            r14 = 2
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzm(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r2.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x02bc
            com.google.android.gms.internal.ads.zzjk r1 = r2.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r3 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r6 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r8 = r2.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r6 = r6 - r8
            long r3 = java.lang.Math.max(r3, r6)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1 = 0
            r2.zza(r5, r3, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x02bc:
            r1 = 1
            r11.zzE(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r12 = 4
            if (r1 == r12) goto L_0x0b42
            r53.zzI()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzY()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzdn r1 = r11.zzh     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzh(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x02d4:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsg r1 = (com.google.android.gms.internal.ads.zzsg) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r2.zzl(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r2 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzk(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzI()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x02ec:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsg r1 = (com.google.android.gms.internal.ads.zzsg) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r2.zzl(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzgy r2 = r11.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r2 = r2.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            float r2 = r2.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzl(r2, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuh r2 = r1.zzh()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r3 = r1.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzX(r2, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != r2) goto L_0x0340
            com.google.android.gms.internal.ads.zzjk r2 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r2 = r2.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzM(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzB()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r3 = r2.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r1 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r5 = r2.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r9 = 0
            r10 = 5
            r1 = r53
            r2 = r3
            r3 = r7
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzu = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0340:
            r53.zzI()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0345:
            r1 = 0
            r2 = 1
            r11.zzK(r2, r1, r2, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjh r1 = r11.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzS(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            android.os.HandlerThread r1 = r11.zzi     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.quit()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            monitor-enter(r53)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzw = r2     // Catch:{ all -> 0x035f }
            r53.notifyAll()     // Catch:{ all -> 0x035f }
            monitor-exit(r53)     // Catch:{ all -> 0x035f }
            return r2
        L_0x035f:
            r0 = move-exception
            r1 = r0
            monitor-exit(r53)     // Catch:{ all -> 0x035f }
            throw r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0363:
            r1 = 0
            r2 = 1
            r11.zzU(r1, r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x036a:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzkd r1 = (com.google.android.gms.internal.ads.zzkd) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzt = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0372:
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r1 = (com.google.android.gms.internal.ads.zzby) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzgy r2 = r11.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zzg(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzgy r1 = r11.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r1 = r1.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 1
            r11.zzG(r1, r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0387:
            r12 = 4
            r14 = 2
            java.lang.Object r1 = r1.obj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjc r1 = (com.google.android.gms.internal.ads.zzjc) r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjb r2 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 1
            r2.zza(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r2 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r23 = 1
            int r3 = r11.zzB     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = r11.zzC     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcm r7 = r11.zzk     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzck r8 = r11.zzl     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r21 = r2
            r22 = r1
            r24 = r3
            r25 = r4
            r26 = r7
            r27 = r8
            android.util.Pair r2 = zzy(r21, r22, r23, r24, r25, r26, r27)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x03d6
            com.google.android.gms.internal.ads.zzju r7 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r7 = r7.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            android.util.Pair r7 = r11.zzx(r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r8 = r7.first     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r8 = (com.google.android.gms.internal.ads.zzsi) r8     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r7 = r7.second     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r17 = r7.longValue()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r7 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r7 = r7.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r7 = r7.zzo()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r9 = 1
            r7 = r7 ^ r9
            r13 = r5
            r9 = r7
            r3 = r17
            goto L_0x0429
        L_0x03d6:
            java.lang.Object r7 = r2.first     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r8 = r2.second     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r8 = r8.longValue()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r14 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r13 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x03e8
            r13 = r5
            goto L_0x03e9
        L_0x03e8:
            r13 = r8
        L_0x03e9:
            com.google.android.gms.internal.ads.zzjm r15 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r10 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r10 = r10.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r7 = r15.zzh(r10, r7, r8)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r10 = r7.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r10 == 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzju r5 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r5 = r5.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r6 = r7.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzck r8 = r11.zzl     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5.zzn(r6, r8)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzck r5 = r11.zzl     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r6 = r7.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r5 = r5.zze(r6)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r6 = r7.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 != r6) goto L_0x0415
            com.google.android.gms.internal.ads.zzck r5 = r11.zzl     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0415:
            r8 = r7
            r3 = 0
            r9 = 1
            goto L_0x0429
        L_0x041a:
            long r3 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0422
            r3 = 1
            goto L_0x0423
        L_0x0422:
            r3 = 0
        L_0x0423:
            r51 = r8
            r9 = r3
            r8 = r7
            r3 = r51
        L_0x0429:
            com.google.android.gms.internal.ads.zzju r5 = r11.zzu     // Catch:{ all -> 0x04e5 }
            com.google.android.gms.internal.ads.zzcn r5 = r5.zza     // Catch:{ all -> 0x04e5 }
            boolean r5 = r5.zzo()     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x043c
            r11.zzH = r1     // Catch:{ all -> 0x0436 }
            goto L_0x044c
        L_0x0436:
            r0 = move-exception
            r1 = r0
            r19 = r13
            goto L_0x04e9
        L_0x043c:
            if (r2 != 0) goto L_0x0451
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ all -> 0x0436 }
            int r1 = r1.zze     // Catch:{ all -> 0x0436 }
            r2 = 1
            if (r1 == r2) goto L_0x0448
            r11.zzS(r12)     // Catch:{ all -> 0x0436 }
        L_0x0448:
            r1 = 0
            r11.zzK(r1, r2, r1, r2)     // Catch:{ all -> 0x0436 }
        L_0x044c:
            r19 = r13
            r12 = r3
            goto L_0x04cd
        L_0x0451:
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ all -> 0x04e5 }
            com.google.android.gms.internal.ads.zzsi r1 = r1.zzb     // Catch:{ all -> 0x04e5 }
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x04e5 }
            if (r1 == 0) goto L_0x04a5
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ all -> 0x04e5 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zzd()     // Catch:{ all -> 0x04e5 }
            if (r1 == 0) goto L_0x0476
            boolean r2 = r1.zzd     // Catch:{ all -> 0x0436 }
            if (r2 == 0) goto L_0x0476
            r5 = 0
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0476
            com.google.android.gms.internal.ads.zzsg r1 = r1.zza     // Catch:{ all -> 0x0436 }
            com.google.android.gms.internal.ads.zzkd r2 = r11.zzt     // Catch:{ all -> 0x0436 }
            long r1 = r1.zza(r3, r2)     // Catch:{ all -> 0x0436 }
            goto L_0x0477
        L_0x0476:
            r1 = r3
        L_0x0477:
            long r5 = com.google.android.gms.internal.ads.zzen.zzz(r1)     // Catch:{ all -> 0x04e5 }
            com.google.android.gms.internal.ads.zzju r7 = r11.zzu     // Catch:{ all -> 0x04e5 }
            r19 = r13
            long r12 = r7.zzr     // Catch:{ all -> 0x04e3 }
            long r12 = com.google.android.gms.internal.ads.zzen.zzz(r12)     // Catch:{ all -> 0x04e3 }
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x04a8
            com.google.android.gms.internal.ads.zzju r5 = r11.zzu     // Catch:{ all -> 0x04e3 }
            int r6 = r5.zze     // Catch:{ all -> 0x04e3 }
            r7 = 2
            if (r6 == r7) goto L_0x0493
            r10 = 3
            if (r6 != r10) goto L_0x04a8
        L_0x0493:
            long r12 = r5.zzr     // Catch:{ all -> 0x04e3 }
            r10 = 2
            r1 = r53
            r2 = r8
            r3 = r12
            r5 = r19
            r7 = r12
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x04a1:
            r11.zzu = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x04a5:
            r19 = r13
            r1 = r3
        L_0x04a8:
            com.google.android.gms.internal.ads.zzju r5 = r11.zzu     // Catch:{ all -> 0x04e3 }
            int r5 = r5.zze     // Catch:{ all -> 0x04e3 }
            r6 = 4
            if (r5 != r6) goto L_0x04b1
            r5 = 1
            goto L_0x04b2
        L_0x04b1:
            r5 = 0
        L_0x04b2:
            long r12 = r11.zzv(r8, r1, r5)     // Catch:{ all -> 0x04e3 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x04bc
            r1 = 1
            goto L_0x04bd
        L_0x04bc:
            r1 = 0
        L_0x04bd:
            r9 = r9 | r1
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ all -> 0x04da }
            com.google.android.gms.internal.ads.zzcn r4 = r1.zza     // Catch:{ all -> 0x04da }
            com.google.android.gms.internal.ads.zzsi r5 = r1.zzb     // Catch:{ all -> 0x04da }
            r1 = r53
            r2 = r4
            r3 = r8
            r6 = r19
            r1.zzZ(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x04da }
        L_0x04cd:
            r10 = 2
            r1 = r53
            r2 = r8
            r3 = r12
            r5 = r19
            r7 = r12
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x04a1
        L_0x04da:
            r0 = move-exception
            r1 = r0
            r51 = r12
            r12 = r1
            r13 = r9
            r9 = r51
            goto L_0x04ec
        L_0x04e3:
            r0 = move-exception
            goto L_0x04e8
        L_0x04e5:
            r0 = move-exception
            r19 = r13
        L_0x04e8:
            r1 = r0
        L_0x04e9:
            r12 = r1
            r13 = r9
            r9 = r3
        L_0x04ec:
            r14 = 2
            r1 = r53
            r2 = r8
            r3 = r9
            r5 = r19
            r7 = r9
            r9 = r13
            r10 = r14
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzu = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            throw r12     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x04fd:
            r10 = 3
            long r12 = android.os.SystemClock.uptimeMillis()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzdn r1 = r11.zzh     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 2
            r1.zze(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzo()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x07de
            com.google.android.gms.internal.ads.zzjt r1 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x051c
            goto L_0x07de
        L_0x051c:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r2 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzk(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzn()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x056f
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r2 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r4 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r1 = r1.zzf(r2, r4)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x056f
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzkb[] r3 = r11.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzvz r4 = r11.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjh r7 = r11.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwi r25 = r7.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r7 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r8 = r11.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r22 = r2
            r23 = r3
            r24 = r4
            r26 = r7
            r27 = r1
            r28 = r8
            com.google.android.gms.internal.ads.zzjj r2 = r22.zzr(r23, r24, r25, r26, r27, r28)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsg r3 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.zzl(r11, r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r3 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r3 = r3.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != r2) goto L_0x056b
            long r1 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzM(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x056b:
            r1 = 0
            r11.zzE(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x056f:
            boolean r1 = r11.zzA     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x057d
            boolean r1 = r53.zzab()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzA = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzW()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0580
        L_0x057d:
            r53.zzI()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0580:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != 0) goto L_0x058a
            goto L_0x06da
        L_0x058a:
            com.google.android.gms.internal.ads.zzjj r2 = r1.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x069a
            boolean r2 = r11.zzy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0596
            goto L_0x069a
        L_0x0596:
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r2.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x06da
            r3 = 0
        L_0x05a1:
            com.google.android.gms.internal.ads.zzka[] r4 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r7 = r4.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r7 = 2
            if (r3 >= r7) goto L_0x05c7
            r4 = r4[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz[] r7 = r2.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r7 = r7[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz r8 = r4.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r8 != r7) goto L_0x06da
            if (r7 == 0) goto L_0x05c4
            boolean r4 = r4.zzG()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 != 0) goto L_0x05c4
            r2.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r1 = r2.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x06da
        L_0x05c4:
            int r3 = r3 + 1
            goto L_0x05a1
        L_0x05c7:
            com.google.android.gms.internal.ads.zzjj r2 = r1.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r2.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x05dd
            long r2 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r4 = r1.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r4.zzf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 < 0) goto L_0x06da
        L_0x05dd:
            com.google.android.gms.internal.ads.zzwa r8 = r1.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r14 = r2.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r7 = r14.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r4 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r2 = r14.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r3 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r1 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r2 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1 = r53
            r20 = r2
            r2 = r4
            r10 = r5
            r5 = r20
            r9 = r7
            r6 = r18
            r1.zzZ(r2, r3, r4, r5, r6)     // Catch:{ zzha -> 0x0695, zzpi -> 0x0690, zzbu -> 0x068b, zzey -> 0x0686, zzrk -> 0x0681, IOException -> 0x067c, RuntimeException -> 0x0677 }
            boolean r1 = r14.zzd     // Catch:{ zzha -> 0x0695, zzpi -> 0x0690, zzbu -> 0x068b, zzey -> 0x0686, zzrk -> 0x0681, IOException -> 0x067c, RuntimeException -> 0x0677 }
            if (r1 == 0) goto L_0x0634
            com.google.android.gms.internal.ads.zzsg r1 = r14.zza     // Catch:{ zzha -> 0x0695, zzpi -> 0x0690, zzbu -> 0x068b, zzey -> 0x0686, zzrk -> 0x0681, IOException -> 0x067c, RuntimeException -> 0x0677 }
            long r1 = r1.zzd()     // Catch:{ zzha -> 0x0695, zzpi -> 0x0690, zzbu -> 0x068b, zzey -> 0x0686, zzrk -> 0x0681, IOException -> 0x067c, RuntimeException -> 0x0677 }
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0634
            long r1 = r14.zzf()     // Catch:{ zzha -> 0x0695, zzpi -> 0x0690, zzbu -> 0x068b, zzey -> 0x0686, zzrk -> 0x0681, IOException -> 0x067c, RuntimeException -> 0x0677 }
            r5 = r10
            r11 = r53
            com.google.android.gms.internal.ads.zzka[] r3 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = 0
        L_0x0623:
            r7 = 2
            if (r4 >= r7) goto L_0x06da
            r7 = r3[r4]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz r8 = r7.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r8 == 0) goto L_0x0631
            zzak(r7, r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0631:
            int r4 = r4 + 1
            goto L_0x0623
        L_0x0634:
            r5 = r10
            r11 = r53
            r1 = 0
        L_0x0638:
            com.google.android.gms.internal.ads.zzka[] r2 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r2 = r2.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 2
            if (r1 >= r2) goto L_0x06da
            boolean r2 = r8.zzb(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r9.zzb(r1)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0674
            com.google.android.gms.internal.ads.zzka[] r2 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = r2[r1]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r2.zzH()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x0674
            com.google.android.gms.internal.ads.zzkb[] r2 = r11.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = r2[r1]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzkc[] r2 = r8.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = r2[r1]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzkc[] r4 = r9.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = r4[r1]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x0669
            boolean r2 = r4.equals(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x0674
        L_0x0669:
            com.google.android.gms.internal.ads.zzka[] r2 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = r2[r1]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r3 = r14.zzf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            zzak(r2, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0674:
            int r1 = r1 + 1
            goto L_0x0638
        L_0x0677:
            r0 = move-exception
            r11 = r53
            goto L_0x0ae2
        L_0x067c:
            r0 = move-exception
            r11 = r53
            goto L_0x0b0d
        L_0x0681:
            r0 = move-exception
            r11 = r53
            goto L_0x0b15
        L_0x0686:
            r0 = move-exception
            r11 = r53
            goto L_0x0b1d
        L_0x068b:
            r0 = move-exception
            r11 = r53
            goto L_0x0b25
        L_0x0690:
            r0 = move-exception
            r11 = r53
            goto L_0x0b3c
        L_0x0695:
            r0 = move-exception
            r11 = r53
            goto L_0x0b45
        L_0x069a:
            com.google.android.gms.internal.ads.zzjk r2 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r2.zzi     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x06a4
            boolean r2 = r11.zzy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x06da
        L_0x06a4:
            r2 = 0
        L_0x06a5:
            com.google.android.gms.internal.ads.zzka[] r3 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = 2
            if (r2 >= r4) goto L_0x06da
            r3 = r3[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz[] r4 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = r4[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x06d7
            com.google.android.gms.internal.ads.zztz r7 = r3.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r7 != r4) goto L_0x06d7
            boolean r4 = r3.zzG()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x06d7
            com.google.android.gms.internal.ads.zzjk r4 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r4.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x06d3
            r9 = -9223372036854775808
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x06d3
            long r9 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r7 + r9
            goto L_0x06d4
        L_0x06d3:
            r7 = r5
        L_0x06d4:
            zzak(r3, r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x06d7:
            int r2 = r2 + 1
            goto L_0x06a5
        L_0x06da:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x074d
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == r1) goto L_0x074d
            boolean r1 = r1.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x06ef
            goto L_0x074d
        L_0x06ef:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwa r2 = r1.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 0
            r4 = 0
        L_0x06fb:
            com.google.android.gms.internal.ads.zzka[] r7 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r8 = r7.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r8 = 2
            if (r3 >= r8) goto L_0x0748
            r7 = r7[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r8 = zzac(r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r8 == 0) goto L_0x0745
            com.google.android.gms.internal.ads.zztz r8 = r7.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz[] r9 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r9 = r9[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r10 = r2.zzb(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r10 == 0) goto L_0x071a
            if (r8 != r9) goto L_0x071a
            goto L_0x0745
        L_0x071a:
            boolean r8 = r7.zzH()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r8 != 0) goto L_0x073a
            com.google.android.gms.internal.ads.zzvt[] r8 = r2.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r8 = r8[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzaf[] r24 = zzah(r8)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz[] r8 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r25 = r8[r3]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r26 = r1.zzf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r28 = r1.zze()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r23 = r7
            r23.zzz(r24, r25, r26, r28)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0745
        L_0x073a:
            boolean r8 = r7.zzM()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r8 == 0) goto L_0x0744
            r11.zzA(r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0745
        L_0x0744:
            r4 = 1
        L_0x0745:
            int r3 = r3 + 1
            goto L_0x06fb
        L_0x0748:
            if (r4 != 0) goto L_0x074d
            r53.zzB()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x074d:
            r1 = 0
        L_0x074e:
            boolean r2 = r53.zzaf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x07db
            boolean r2 = r11.zzy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x07db
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x07db
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x07db
            long r3 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r2.zzf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x07db
            boolean r2 = r2.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x07db
            if (r1 == 0) goto L_0x0779
            r53.zzJ()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0779:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zza()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x07d9
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r2 = r2.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r2 = r2.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r3 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.Object r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r2.equals(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x07ab
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r2 = r2.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r2.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != r15) goto L_0x07ab
            com.google.android.gms.internal.ads.zzjk r3 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 != r15) goto L_0x07ab
            int r2 = r2.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r3.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == r3) goto L_0x07ab
            r2 = 1
            goto L_0x07ac
        L_0x07ab:
            r2 = 0
        L_0x07ac:
            com.google.android.gms.internal.ads.zzjk r1 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r3 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r1.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r9 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1 = 1
            r14 = r2 ^ 1
            r18 = 0
            r1 = r53
            r2 = r3
            r3 = r7
            r5 = r9
            r10 = 0
            r9 = r14
            r15 = r10
            r14 = 3
            r10 = r18
            com.google.android.gms.internal.ads.zzju r1 = r1.zzz(r2, r3, r5, r7, r9, r10)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzu = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzL()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzY()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -1
            goto L_0x074e
        L_0x07d9:
            r15 = 0
            throw r15     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x07db:
            r14 = 3
            r15 = 0
            goto L_0x07e0
        L_0x07de:
            r15 = r9
            r14 = 3
        L_0x07e0:
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 1
            if (r1 == r2) goto L_0x0b42
            r2 = 4
            if (r1 != r2) goto L_0x07ec
            goto L_0x0b42
        L_0x07ec:
            com.google.android.gms.internal.ads.zzjm r1 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r1 = r1.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 10
            if (r1 != 0) goto L_0x07fb
            r11.zzO(r12, r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x07fb:
            int r4 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.String r4 = "doSomeWork"
            android.os.Trace.beginSection(r4)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzY()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = 1000(0x3e8, double:4.94E-321)
            if (r4 == 0) goto L_0x0878
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r7 * r5
            com.google.android.gms.internal.ads.zzsg r4 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r9 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r9 = r9.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r2 = r11.zzm     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r9 = r9 - r2
            r2 = 0
            r4.zzj(r9, r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 1
            r3 = 1
            r4 = 0
        L_0x0821:
            com.google.android.gms.internal.ads.zzka[] r9 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r10 = r9.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r10 = 2
            if (r4 >= r10) goto L_0x087f
            r9 = r9[r4]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r10 = zzac(r9)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r10 != 0) goto L_0x0830
            goto L_0x0873
        L_0x0830:
            long r5 = r11.zzI     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r9.zzL(r5, r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x083f
            boolean r3 = r9.zzM()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x083f
            r3 = 1
            goto L_0x0840
        L_0x083f:
            r3 = 0
        L_0x0840:
            com.google.android.gms.internal.ads.zztz[] r5 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = r5[r4]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz r6 = r9.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 != r6) goto L_0x0852
            boolean r10 = r9.zzG()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r10 == 0) goto L_0x0852
            r10 = 1
            goto L_0x0853
        L_0x0852:
            r10 = 0
        L_0x0853:
            if (r5 != r6) goto L_0x0866
            if (r10 != 0) goto L_0x0866
            boolean r5 = r9.zzN()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 != 0) goto L_0x0866
            boolean r5 = r9.zzM()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 == 0) goto L_0x0864
            goto L_0x0866
        L_0x0864:
            r5 = 0
            goto L_0x0867
        L_0x0866:
            r5 = 1
        L_0x0867:
            if (r2 == 0) goto L_0x086d
            if (r5 == 0) goto L_0x086d
            r2 = 1
            goto L_0x086e
        L_0x086d:
            r2 = 0
        L_0x086e:
            if (r5 != 0) goto L_0x0873
            r9.zzr()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0873:
            int r4 = r4 + 1
            r5 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0821
        L_0x0878:
            com.google.android.gms.internal.ads.zzsg r2 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zzk()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 1
            r3 = 1
        L_0x087f:
            com.google.android.gms.internal.ads.zzjk r4 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r4 = r4.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x08b8
            boolean r3 = r1.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x08b8
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x089a
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r8 = r3.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x08bd
        L_0x089a:
            boolean r3 = r11.zzy     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x08a9
            r3 = 0
            r11.zzy = r3     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r4 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r4.zzm     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = 5
            r11.zzR(r3, r4, r3, r5)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x08a9:
            com.google.android.gms.internal.ads.zzjk r3 = r1.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r3.zzi     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x08bd
            r3 = 4
            r11.zzS(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r53.zzV()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x098f
        L_0x08b8:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x08bd:
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = 2
            if (r4 != r5) goto L_0x094a
            int r4 = r11.zzG     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 != 0) goto L_0x08d0
            boolean r3 = r53.zzad()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x094a
            goto L_0x093b
        L_0x08d0:
            if (r2 != 0) goto L_0x08d4
            goto L_0x094a
        L_0x08d4:
            boolean r4 = r3.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x093b
            com.google.android.gms.internal.ads.zzcn r3 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjm r4 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r4 = r4.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjk r4 = r4.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r4 = r4.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = r11.zzag(r3, r4)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x08f3
            com.google.android.gms.internal.ads.zzgv r3 = r11.zzO     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r3 = r3.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r29 = r3
            goto L_0x08f5
        L_0x08f3:
            r29 = r6
        L_0x08f5:
            com.google.android.gms.internal.ads.zzjm r3 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r3 = r3.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = r3.zzr()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x0909
            com.google.android.gms.internal.ads.zzjk r4 = r3.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = r4.zzi     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == 0) goto L_0x0909
            r4 = 1
            goto L_0x090a
        L_0x0909:
            r4 = 0
        L_0x090a:
            com.google.android.gms.internal.ads.zzjk r5 = r3.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r5 = r5.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r5 = r5.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r5 == 0) goto L_0x091a
            boolean r3 = r3.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != 0) goto L_0x091a
            r3 = 1
            goto L_0x091b
        L_0x091a:
            r3 = 0
        L_0x091b:
            if (r4 != 0) goto L_0x093b
            if (r3 != 0) goto L_0x093b
            com.google.android.gms.internal.ads.zzjh r3 = r11.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r25 = r53.zzt()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzgy r4 = r11.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzby r4 = r4.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            float r4 = r4.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r5 = r11.zzz     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r24 = r3
            r27 = r4
            r28 = r5
            boolean r3 = r24.zzh(r25, r27, r28, r29)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x094a
        L_0x093b:
            r11.zzS(r14)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzL = r15     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r53.zzaf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x098f
            r53.zzT()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x098f
        L_0x094a:
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = r3.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != r14) goto L_0x098f
            int r3 = r11.zzG     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != 0) goto L_0x095b
            boolean r2 = r53.zzad()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x098f
            goto L_0x095d
        L_0x095b:
            if (r2 != 0) goto L_0x098f
        L_0x095d:
            boolean r2 = r53.zzaf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzz = r2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 2
            r11.zzS(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r11.zzz     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x098c
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzd()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0971:
            if (r2 == 0) goto L_0x0987
            com.google.android.gms.internal.ads.zzwa r3 = r2.zzi()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzvt[] r3 = r3.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r4 = r3.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r5 = 0
        L_0x097b:
            if (r5 >= r4) goto L_0x0982
            r8 = r3[r5]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r5 = r5 + 1
            goto L_0x097b
        L_0x0982:
            com.google.android.gms.internal.ads.zzjj r2 = r2.zzg()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0971
        L_0x0987:
            com.google.android.gms.internal.ads.zzgv r2 = r11.zzO     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2.zzc()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x098c:
            r53.zzV()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x098f:
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r2 = r2.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 2
            if (r2 != r3) goto L_0x09f5
            r2 = 0
        L_0x0997:
            com.google.android.gms.internal.ads.zzka[] r4 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r5 = r4.length     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 >= r3) goto L_0x09bd
            r3 = r4[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r3 = zzac(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 == 0) goto L_0x09b9
            com.google.android.gms.internal.ads.zzka[] r3 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = r3[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz r3 = r3.zzm()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zztz[] r4 = r1.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r4 = r4[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r3 != r4) goto L_0x09b9
            com.google.android.gms.internal.ads.zzka[] r3 = r11.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = r3[r2]     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3.zzr()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x09b9:
            int r2 = r2 + 1
            r3 = 2
            goto L_0x0997
        L_0x09bd:
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r2 = r1.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 != 0) goto L_0x09f5
            long r1 = r1.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 500000(0x7a120, double:2.47033E-318)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x09f5
            boolean r1 = r53.zzab()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x09f5
            long r1 = r11.zzM     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x09df
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzM = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x09f7
        L_0x09df:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r3 = r11.zzM     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r1 = r1 - r3
            r3 = 4000(0xfa0, double:1.9763E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x09ed
            goto L_0x09f7
        L_0x09ed:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            java.lang.String r2 = "Playback stuck buffering and not loading"
            r1.<init>(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            throw r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x09f5:
            r11.zzM = r6     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x09f7:
            boolean r1 = r53.zzaf()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0a05
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 != r14) goto L_0x0a05
            r1 = 1
            goto L_0x0a06
        L_0x0a05:
            r1 = 0
        L_0x0a06:
            boolean r2 = r11.zzF     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0a12
            boolean r2 = r11.zzE     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0a12
            if (r1 == 0) goto L_0x0a12
            r2 = 1
            goto L_0x0a13
        L_0x0a12:
            r2 = 0
        L_0x0a13:
            com.google.android.gms.internal.ads.zzju r3 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r4 = r3.zzo     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r4 == r2) goto L_0x0a6f
            com.google.android.gms.internal.ads.zzju r4 = new com.google.android.gms.internal.ads.zzju     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r5 = r3.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzsi r6 = r3.zzb     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r7 = r3.zzc     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            long r9 = r3.zzd     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r15 = r3.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzha r14 = r3.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r48 = r12
            boolean r12 = r3.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzuh r13 = r3.zzh     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r54 = r1
            com.google.android.gms.internal.ads.zzwa r1 = r3.zzi     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r50 = r2
            java.util.List r2 = r3.zzj     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r36 = r2
            com.google.android.gms.internal.ads.zzsi r2 = r3.zzk     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r37 = r2
            boolean r2 = r3.zzl     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r38 = r2
            int r2 = r3.zzm     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r39 = r2
            com.google.android.gms.internal.ads.zzby r2 = r3.zzn     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r35 = r1
            r40 = r2
            long r1 = r3.zzp     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r41 = r1
            long r1 = r3.zzq     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r43 = r1
            long r1 = r3.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r29 = r9
            r31 = r15
            r32 = r14
            r33 = r12
            r34 = r13
            r45 = r1
            r47 = r50
            r24.<init>(r25, r26, r27, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43, r45, r47)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r11.zzu = r4     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0a75
        L_0x0a6f:
            r54 = r1
            r50 = r2
            r48 = r12
        L_0x0a75:
            r1 = 0
            r11.zzE = r1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r50 != 0) goto L_0x0b42
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            int r1 = r1.zze     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 4
            if (r1 == r2) goto L_0x0b42
            if (r54 != 0) goto L_0x0a96
            r2 = 2
            if (r1 != r2) goto L_0x0a87
            goto L_0x0a96
        L_0x0a87:
            r2 = 3
            if (r1 != r2) goto L_0x0a9d
            int r1 = r11.zzG     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r1 == 0) goto L_0x0a9d
            r1 = r48
            r3 = 1000(0x3e8, double:4.94E-321)
            r11.zzO(r1, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0a9d
        L_0x0a96:
            r1 = r48
            r3 = 10
            r11.zzO(r1, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
        L_0x0a9d:
            android.os.Trace.endSection()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0aa2:
            int r2 = r1.arg1     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            if (r2 == 0) goto L_0x0aa8
            r2 = 1
            goto L_0x0aa9
        L_0x0aa8:
            r2 = 0
        L_0x0aa9:
            int r1 = r1.arg2     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 1
            r11.zzR(r2, r1, r3, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0ab1:
            r2 = 4
            com.google.android.gms.internal.ads.zzjb r1 = r11.zzv     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 1
            r1.zza(r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1 = 0
            r11.zzK(r1, r1, r1, r3)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjh r1 = r11.zzf     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzb()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzju r1 = r11.zzu     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzcn r1 = r1.zza     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            boolean r1 = r1.zzo()     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r3 = 1
            if (r3 == r1) goto L_0x0ace
            r7 = 2
            goto L_0x0acf
        L_0x0ace:
            r7 = 4
        L_0x0acf:
            r11.zzS(r7)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzjt r1 = r11.zzr     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzwh r2 = r11.zzg     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r1.zzf(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            com.google.android.gms.internal.ads.zzdn r1 = r11.zzh     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            r2 = 2
            r1.zzh(r2)     // Catch:{ zzha -> 0x0b44, zzpi -> 0x0b3b, zzbu -> 0x0b24, zzey -> 0x0b1c, zzrk -> 0x0b14, IOException -> 0x0b0c, RuntimeException -> 0x0ae1 }
            goto L_0x0b42
        L_0x0ae1:
            r0 = move-exception
        L_0x0ae2:
            r1 = r0
            boolean r2 = r1 instanceof java.lang.IllegalStateException
            r3 = 1004(0x3ec, float:1.407E-42)
            if (r2 != 0) goto L_0x0af1
            boolean r2 = r1 instanceof java.lang.IllegalArgumentException
            if (r2 == 0) goto L_0x0aee
            goto L_0x0af1
        L_0x0aee:
            r12 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0af3
        L_0x0af1:
            r12 = 1004(0x3ec, float:1.407E-42)
        L_0x0af3:
            com.google.android.gms.internal.ads.zzha r1 = com.google.android.gms.internal.ads.zzha.zzd(r1, r12)
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Playback error"
            com.google.android.gms.internal.ads.zzdw.zzc(r2, r3, r1)
            r2 = 0
            r3 = 1
            r11.zzU(r3, r2)
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu
            com.google.android.gms.internal.ads.zzju r1 = r2.zzd(r1)
            r11.zzu = r1
            goto L_0x0b42
        L_0x0b0c:
            r0 = move-exception
        L_0x0b0d:
            r1 = r0
            r2 = 2000(0x7d0, float:2.803E-42)
            r11.zzD(r1, r2)
            goto L_0x0b42
        L_0x0b14:
            r0 = move-exception
        L_0x0b15:
            r1 = r0
            r2 = 1002(0x3ea, float:1.404E-42)
            r11.zzD(r1, r2)
            goto L_0x0b42
        L_0x0b1c:
            r0 = move-exception
        L_0x0b1d:
            r1 = r0
            int r2 = r1.zza
            r11.zzD(r1, r2)
            goto L_0x0b42
        L_0x0b24:
            r0 = move-exception
        L_0x0b25:
            r1 = r0
            int r2 = r1.zzb
            r3 = 1
            if (r2 != r3) goto L_0x0b35
            boolean r2 = r1.zza
            if (r3 == r2) goto L_0x0b32
            r12 = 3003(0xbbb, float:4.208E-42)
            goto L_0x0b37
        L_0x0b32:
            r12 = 3001(0xbb9, float:4.205E-42)
            goto L_0x0b37
        L_0x0b35:
            r12 = 1000(0x3e8, float:1.401E-42)
        L_0x0b37:
            r11.zzD(r1, r12)
            goto L_0x0b42
        L_0x0b3b:
            r0 = move-exception
        L_0x0b3c:
            r1 = r0
            int r2 = r1.zza
            r11.zzD(r1, r2)
        L_0x0b42:
            r3 = 1
            goto L_0x0baa
        L_0x0b44:
            r0 = move-exception
        L_0x0b45:
            r1 = r0
            int r2 = r1.zze
            r3 = 1
            if (r2 != r3) goto L_0x0b5b
            com.google.android.gms.internal.ads.zzjm r2 = r11.zzq
            com.google.android.gms.internal.ads.zzjj r2 = r2.zze()
            if (r2 == 0) goto L_0x0b5b
            com.google.android.gms.internal.ads.zzjk r2 = r2.zzf
            com.google.android.gms.internal.ads.zzsi r2 = r2.zza
            com.google.android.gms.internal.ads.zzha r1 = r1.zza(r2)
        L_0x0b5b:
            boolean r2 = r1.zzk
            if (r2 == 0) goto L_0x0b78
            com.google.android.gms.internal.ads.zzha r2 = r11.zzL
            if (r2 != 0) goto L_0x0b78
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Recoverable renderer error"
            com.google.android.gms.internal.ads.zzdw.zzf(r2, r3, r1)
            r11.zzL = r1
            com.google.android.gms.internal.ads.zzdn r2 = r11.zzh
            r3 = 25
            com.google.android.gms.internal.ads.zzdm r1 = r2.zzb(r3, r1)
            r2.zzj(r1)
            goto L_0x0b42
        L_0x0b78:
            com.google.android.gms.internal.ads.zzha r2 = r11.zzL
            if (r2 == 0) goto L_0x0b96
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0b94 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x0b94 }
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            java.lang.String r6 = "addSuppressed"
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r6, r4)     // Catch:{ Exception -> 0x0b94 }
            r4 = 1
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0b94 }
            r6[r5] = r1     // Catch:{ Exception -> 0x0b94 }
            r3.invoke(r2, r6)     // Catch:{ Exception -> 0x0b94 }
        L_0x0b94:
            com.google.android.gms.internal.ads.zzha r1 = r11.zzL
        L_0x0b96:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Playback error"
            com.google.android.gms.internal.ads.zzdw.zzc(r2, r3, r1)
            r2 = 0
            r3 = 1
            r11.zzU(r3, r2)
            com.google.android.gms.internal.ads.zzju r2 = r11.zzu
            com.google.android.gms.internal.ads.zzju r1 = r2.zzd(r1)
            r11.zzu = r1
        L_0x0baa:
            r53.zzJ()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjd.handleMessage(android.os.Message):boolean");
    }

    public final void zza(zzby zzby) {
        this.zzh.zzb(16, zzby).zza();
    }

    public final Looper zzb() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() {
        return Boolean.valueOf(this.zzw);
    }

    public final /* synthetic */ void zzg(zzub zzub) {
        this.zzh.zzb(9, (zzsg) zzub).zza();
    }

    public final void zzh() {
        this.zzh.zzh(22);
    }

    public final void zzi(zzsg zzsg) {
        this.zzh.zzb(8, zzsg).zza();
    }

    public final void zzj() {
        this.zzh.zzh(10);
    }

    public final void zzk() {
        this.zzh.zza(0).zza();
    }

    public final void zzl(zzcn zzcn, int i, long j) {
        this.zzh.zzb(3, new zzjc(zzcn, i, j)).zza();
    }

    public final synchronized void zzm(zzjx zzjx) {
        if (!this.zzw) {
            if (this.zzi.isAlive()) {
                this.zzh.zzb(14, zzjx).zza();
                return;
            }
        }
        zzdw.zze("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzjx.zzh(false);
    }

    public final void zzn(boolean z, int i) {
        this.zzh.zzc(1, z ? 1 : 0, i).zza();
    }

    public final void zzo() {
        this.zzh.zza(6).zza();
    }

    public final synchronized boolean zzp() {
        if (!this.zzw) {
            if (this.zzi.isAlive()) {
                this.zzh.zzh(7);
                zzaa(new zziu(this), this.zzs);
                return this.zzw;
            }
        }
        return true;
    }

    public final void zzq(List list, int i, long j, zzuc zzuc) {
        this.zzh.zzb(17, new zziy(list, zzuc, i, j, (zzix) null, (byte[]) null)).zza();
    }
}
