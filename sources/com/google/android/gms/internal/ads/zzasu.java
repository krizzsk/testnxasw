package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzasu implements Handler.Callback, zzayb, zzayd, zzazg {
    private zzass zzA;
    private long zzB;
    private zzasq zzC;
    private zzasq zzD;
    private zzasq zzE;
    private zzath zzF;
    private boolean zzG;
    private boolean zzH;
    private int zzI;
    private volatile int zzJ;
    private volatile int zzK;
    private final zzcjv zzL;
    private final zzatb[] zza;
    private final zzatc[] zzb;
    private final zzazh zzc;
    private final zzban zzd;
    private final Handler zze;
    private final HandlerThread zzf;
    private final Handler zzg;
    private final zzasm zzh;
    private final zzatg zzi;
    private final zzatf zzj;
    private zzasr zzk;
    private zzata zzl;
    private zzatb zzm;
    private zzbag zzn;
    private zzaye zzo;
    private zzatb[] zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private int zzv = 0;
    private int zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    public zzasu(zzatb[] zzatbArr, zzazh zzazh, zzcjv zzcjv, boolean z, int i, Handler handler, zzasr zzasr, zzasm zzasm, byte[] bArr) {
        this.zza = zzatbArr;
        this.zzc = zzazh;
        this.zzL = zzcjv;
        this.zzr = z;
        this.zzg = handler;
        this.zzu = 1;
        this.zzk = zzasr;
        this.zzh = zzasm;
        this.zzb = new zzatc[2];
        for (int i2 = 0; i2 < 2; i2++) {
            zzatbArr[i2].zzw(i2);
            this.zzb[i2] = zzatbArr[i2].zzf();
        }
        this.zzd = new zzban();
        this.zzp = new zzatb[0];
        this.zzi = new zzatg();
        this.zzj = new zzatf();
        zzazh.zzf(this);
        this.zzl = zzata.zza;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zze = new Handler(this.zzf.getLooper(), this);
    }

    private final void zzA(Object obj, int i) {
        this.zzk = new zzasr(0, 0);
        zzD(obj, i);
        this.zzk = new zzasr(0, -9223372036854775807L);
        zzJ(4);
        zzE(false);
    }

    private final void zzB() {
        long j;
        zzasq zzasq = this.zzC;
        if (!zzasq.zzj) {
            j = 0;
        } else {
            j = zzasq.zza.zza();
        }
        if (j == Long.MIN_VALUE) {
            zzH(false);
            return;
        }
        zzasq zzasq2 = this.zzC;
        long j2 = this.zzB - (zzasq2.zzf - zzasq2.zzh);
        boolean zzj2 = this.zzL.zzj(j - j2);
        zzH(zzj2);
        if (zzj2) {
            this.zzC.zza.zzbj(j2);
        }
    }

    private final void zzC() throws IOException {
        zzasq zzasq = this.zzC;
        if (zzasq != null && !zzasq.zzj) {
            zzasq zzasq2 = this.zzD;
            if (zzasq2 == null || zzasq2.zzl == zzasq) {
                zzatb[] zzatbArr = this.zzp;
                int length = zzatbArr.length;
                int i = 0;
                while (i < length) {
                    if (zzatbArr[i].zzA()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzC.zza.zzs();
            }
        }
    }

    private final void zzD(Object obj, int i) {
        this.zzg.obtainMessage(6, new zzast(this.zzF, obj, this.zzk, i)).sendToTarget();
    }

    private final void zzE(boolean z) {
        this.zze.removeMessages(2);
        this.zzs = false;
        this.zzd.zzc();
        this.zzn = null;
        this.zzm = null;
        this.zzB = 60000000;
        for (zzatb zzatb : this.zzp) {
            try {
                zzQ(zzatb);
                zzatb.zzj();
            } catch (zzasi | RuntimeException e) {
                SystemUtils.log(6, "ExoPlayerImplInternal", "Stop failed.", e, "com.google.android.gms.internal.ads.zzasu", 6);
            }
        }
        this.zzp = new zzatb[0];
        zzasq zzasq = this.zzE;
        if (zzasq == null) {
            zzasq = this.zzC;
        }
        zzR(zzasq);
        this.zzC = null;
        this.zzD = null;
        this.zzE = null;
        zzH(false);
        if (z) {
            zzaye zzaye = this.zzo;
            if (zzaye != null) {
                zzaye.zzd();
                this.zzo = null;
            }
            this.zzF = null;
        }
    }

    private final void zzF(long j) throws zzasi {
        long j2;
        zzasq zzasq = this.zzE;
        if (zzasq == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + (zzasq.zzf - zzasq.zzh);
        }
        this.zzB = j2;
        this.zzd.zza(j2);
        for (zzatb zzu2 : this.zzp) {
            zzu2.zzu(this.zzB);
        }
    }

    private final void zzG(long j, long j2) {
        this.zze.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.zze.sendEmptyMessage(2);
        } else {
            this.zze.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final void zzH(boolean z) {
        if (this.zzt != z) {
            this.zzt = z;
            this.zzg.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzI(zzasq zzasq) throws zzasi {
        if (this.zzE != zzasq) {
            boolean[] zArr = new boolean[2];
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                zzatb zzatb = this.zza[i2];
                zArr[i2] = zzatb.zzb() != 0;
                zzayx zza2 = zzasq.zzm.zzb.zza(i2);
                if (zza2 != null) {
                    i++;
                }
                if (zArr[i2] && (zza2 == null || (zzatb.zzB() && zzatb.zzh() == this.zzE.zzd[i2]))) {
                    if (zzatb == this.zzm) {
                        this.zzd.zzd(this.zzn);
                        this.zzn = null;
                        this.zzm = null;
                    }
                    zzQ(zzatb);
                    zzatb.zzj();
                }
            }
            this.zzE = zzasq;
            this.zzg.obtainMessage(3, zzasq.zzm).sendToTarget();
            zzz(zArr, i);
        }
    }

    private final void zzJ(int i) {
        if (this.zzu != i) {
            this.zzu = i;
            this.zzg.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzK() throws zzasi {
        this.zzs = false;
        this.zzd.zzb();
        for (zzatb zzy2 : this.zzp) {
            zzy2.zzy();
        }
    }

    private final void zzL() {
        zzE(true);
        this.zzL.zzc();
        zzJ(1);
    }

    private final void zzM() throws zzasi {
        this.zzd.zzc();
        for (zzatb zzQ : this.zzp) {
            zzQ(zzQ);
        }
    }

    private final void zzN() throws zzasi {
        long j;
        zzasq zzasq = this.zzE;
        if (zzasq != null) {
            long zzh2 = zzasq.zza.zzh();
            if (zzh2 != -9223372036854775807L) {
                zzF(zzh2);
            } else {
                zzatb zzatb = this.zzm;
                if (zzatb == null || zzatb.zzE()) {
                    this.zzB = this.zzd.zzI();
                } else {
                    long zzI2 = this.zzn.zzI();
                    this.zzB = zzI2;
                    this.zzd.zza(zzI2);
                }
                zzasq zzasq2 = this.zzE;
                zzh2 = this.zzB - (zzasq2.zzf - zzasq2.zzh);
            }
            this.zzk.zzc = zzh2;
            this.zzy = SystemClock.elapsedRealtime() * 1000;
            if (this.zzp.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzE.zza.zzg();
            }
            zzasr zzasr = this.zzk;
            if (j == Long.MIN_VALUE) {
                j = this.zzF.zzd(this.zzE.zzg, this.zzj, false).zzc;
            }
            zzasr.zzd = j;
        }
    }

    private final boolean zzO(int i) {
        this.zzF.zzd(i, this.zzj, false);
        this.zzF.zzg(0, this.zzi, false);
        if (this.zzF.zzf(i, this.zzj, this.zzi, this.zzv) == -1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r6 = r5.zzE.zzl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzP(long r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzasr r2 = r5.zzk
            long r2 = r2.zzc
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzasq r6 = r5.zzE
            com.google.android.gms.internal.ads.zzasq r6 = r6.zzl
            if (r6 == 0) goto L_0x0020
            boolean r6 = r6.zzj
            if (r6 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            return r0
        L_0x001f:
            r0 = 1
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzP(long):boolean");
    }

    private static final void zzQ(zzatb zzatb) throws zzasi {
        if (zzatb.zzb() == 2) {
            zzatb.zzz();
        }
    }

    private static final void zzR(zzasq zzasq) {
        while (zzasq != null) {
            zzasq.zzc();
            zzasq = zzasq.zzl;
        }
    }

    private final int zzt(int i, zzath zzath, zzath zzath2) {
        int zzb2 = zzath.zzb();
        int i2 = -1;
        for (int i3 = 0; i3 < zzb2 && i2 == -1; i3++) {
            i = zzath.zzf(i, this.zzj, this.zzi, this.zzv);
            i2 = zzath2.zza(zzath.zzd(i, this.zzj, true).zzb);
        }
        return i2;
    }

    private final long zzu(int i, long j) throws zzasi {
        zzasq zzasq;
        zzM();
        this.zzs = false;
        zzJ(2);
        zzasq zzasq2 = this.zzE;
        if (zzasq2 == null) {
            zzasq zzasq3 = this.zzC;
            if (zzasq3 != null) {
                zzasq3.zzc();
            }
            zzasq = null;
        } else {
            zzasq = null;
            while (zzasq2 != null) {
                if (zzasq2.zzg != i || !zzasq2.zzj) {
                    zzasq2.zzc();
                } else {
                    zzasq = zzasq2;
                }
                zzasq2 = zzasq2.zzl;
            }
        }
        zzasq zzasq4 = this.zzE;
        if (!(zzasq4 == zzasq && zzasq4 == this.zzD)) {
            for (zzatb zzj2 : this.zzp) {
                zzj2.zzj();
            }
            this.zzp = new zzatb[0];
            this.zzn = null;
            this.zzm = null;
            this.zzE = null;
        }
        if (zzasq != null) {
            zzasq.zzl = null;
            this.zzC = zzasq;
            this.zzD = zzasq;
            zzI(zzasq);
            zzasq zzasq5 = this.zzE;
            if (zzasq5.zzk) {
                j = zzasq5.zza.zzi(j);
            }
            zzF(j);
            zzB();
        } else {
            this.zzC = null;
            this.zzD = null;
            this.zzE = null;
            zzF(j);
        }
        this.zze.sendEmptyMessage(2);
        return j;
    }

    private final Pair zzv(int i, long j) {
        return zzw(this.zzF, 0, -9223372036854775807L);
    }

    private final Pair zzw(zzath zzath, int i, long j) {
        return zzx(zzath, 0, j, 0);
    }

    private final Pair zzx(zzath zzath, int i, long j, long j2) {
        zzbac.zza(0, 0, zzath.zzc());
        zzath.zze(0, this.zzi, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = zzath.zzd(0, this.zzj, false).zzc;
        if (j3 != -9223372036854775807L) {
            int i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j));
    }

    private final Pair zzy(zzass zzass) {
        zzath zzath = zzass.zza;
        if (zzath.zzh()) {
            zzath = this.zzF;
        }
        try {
            int i = zzass.zzb;
            Pair zzw2 = zzw(zzath, 0, zzass.zzc);
            zzath zzath2 = this.zzF;
            if (zzath2 == zzath) {
                return zzw2;
            }
            if (zzath2.zza(zzath.zzd(((Integer) zzw2.first).intValue(), this.zzj, true).zzb) != -1) {
                return Pair.create(0, (Long) zzw2.second);
            }
            if (zzt(((Integer) zzw2.first).intValue(), zzath, this.zzF) == -1) {
                return null;
            }
            this.zzF.zzd(0, this.zzj, false);
            return zzv(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            zzath zzath3 = this.zzF;
            int i2 = zzass.zzb;
            throw new zzasy(zzath3, 0, zzass.zzc);
        }
    }

    private final void zzz(boolean[] zArr, int i) throws zzasi {
        int i2;
        this.zzp = new zzatb[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2) {
            zzatb zzatb = this.zza[i3];
            zzayx zza2 = this.zzE.zzm.zzb.zza(i3);
            if (zza2 != null) {
                int i5 = i4 + 1;
                this.zzp[i4] = zzatb;
                if (zzatb.zzb() == 0) {
                    zzatd zzatd = this.zzE.zzm.zzd[i3];
                    boolean z = this.zzr && this.zzu == 3;
                    boolean z2 = !zArr[i3] && z;
                    zza2.zzb();
                    zzasw[] zzaswArr = new zzasw[1];
                    for (int i6 = 0; i6 <= 0; i6++) {
                        zzaswArr[i6] = zza2.zzc(i6);
                    }
                    zzasq zzasq = this.zzE;
                    i2 = i3;
                    zzatb.zzk(zzatd, zzaswArr, zzasq.zzd[i3], this.zzB, z2, zzasq.zzf - zzasq.zzh);
                    zzbag zzi2 = zzatb.zzi();
                    if (zzi2 != null) {
                        if (this.zzn == null) {
                            this.zzn = zzi2;
                            this.zzm = zzatb;
                            zzi2.zzK(this.zzl);
                        } else {
                            throw zzasi.zzc(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzatb.zzy();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:430:0x079a, code lost:
        if (zzP(r1) != false) goto L_0x079c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x026a A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x026e A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0273 A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04ec A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04f3 A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x050a A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x050d A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0548 A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x055a A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0574 A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }, LOOP:8: B:315:0x0574->B:319:0x0584, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x06c9 A[Catch:{ all -> 0x0418, all -> 0x0366, all -> 0x00c9, all -> 0x00d6, all -> 0x00c5, zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r34) {
        /*
            r33 = this;
            r8 = r33
            r1 = r34
            r10 = 1
            int r2 = r1.what     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x083f;
                case 1: goto L_0x0810;
                case 2: goto L_0x042b;
                case 3: goto L_0x038c;
                case 4: goto L_0x036e;
                case 5: goto L_0x036a;
                case 6: goto L_0x0353;
                case 7: goto L_0x01f6;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b6;
                case 10: goto L_0x00da;
                case 11: goto L_0x009c;
                case 12: goto L_0x001a;
                default: goto L_0x0018;
            }     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0018:
            r1 = 0
            return r1
        L_0x001a:
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzv = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            goto L_0x009b
        L_0x0028:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzasq r4 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != r4) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            com.google.android.gms.internal.ads.zzath r11 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r12 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r11 = r11.zzf(r12, r13, r14, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzasq r12 = r2.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 == 0) goto L_0x0068
            if (r11 == r5) goto L_0x0068
            int r13 = r12.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r13 != r11) goto L_0x0068
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 != r2) goto L_0x0052
            r2 = 1
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            r3 = r3 | r2
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 != r2) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            r4 = r4 | r2
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r11 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r11 = r2.zzf(r13, r11, r14, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = r12
            goto L_0x0042
        L_0x0068:
            if (r12 == 0) goto L_0x006f
            zzR(r12)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzl = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x006f:
            int r5 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r5 = r8.zzO(r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzi = r5     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r4 != 0) goto L_0x007b
            r8.zzC = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x007b:
            if (r3 != 0) goto L_0x0092
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x0092
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r3.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r8.zzu(r2, r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r5 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5.<init>(r2, r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r5     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0092:
            int r2 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != r15) goto L_0x009b
            if (r1 == 0) goto L_0x009b
            r8.zzJ(r7)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x009b:
            return r10
        L_0x009c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasl[] r1 = (com.google.android.gms.internal.ads.zzasl[]) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r1.length     // Catch:{ all -> 0x00c9 }
        L_0x00a1:
            if (r9 >= r2) goto L_0x00b1
            r3 = r1[r9]     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzask r4 = r3.zza     // Catch:{ all -> 0x00c9 }
            int r5 = r3.zzb     // Catch:{ all -> 0x00c9 }
            java.lang.Object r3 = r3.zzc     // Catch:{ all -> 0x00c9 }
            r4.zzl(r5, r3)     // Catch:{ all -> 0x00c9 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ all -> 0x00c9 }
            if (r1 == 0) goto L_0x00ba
            android.os.Handler r1 = r8.zze     // Catch:{ all -> 0x00c9 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c9 }
        L_0x00ba:
            monitor-enter(r33)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r8.zzx     // Catch:{ all -> 0x00c5 }
            int r1 = r1 + r10
            r8.zzx = r1     // Catch:{ all -> 0x00c5 }
            r33.notifyAll()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            return r10
        L_0x00c5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x00c9:
            r0 = move-exception
            r1 = r0
            monitor-enter(r33)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r8.zzx     // Catch:{ all -> 0x00d6 }
            int r2 = r2 + r10
            r8.zzx = r2     // Catch:{ all -> 0x00d6 }
            r33.notifyAll()     // Catch:{ all -> 0x00d6 }
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x00d6:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x00d6 }
            throw r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x00da:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x01b5
            r2 = 1
        L_0x00df:
            if (r1 == 0) goto L_0x01b5
            boolean r3 = r1.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 != 0) goto L_0x00e7
            goto L_0x01b5
        L_0x00e7:
            boolean r3 = r1.zze()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x01a9
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == r3) goto L_0x00f7
            r2 = 1
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            com.google.android.gms.internal.ads.zzasq r3 = r3.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            zzR(r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzl = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzC = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzD = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean[] r4 = new boolean[r7]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r5.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r2 = r3.zzb(r11, r2, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r5.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzasr r5 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5.zzc = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzF(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x011e:
            boolean[] r2 = new boolean[r7]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = 0
            r5 = 0
        L_0x0122:
            if (r3 >= r7) goto L_0x0169
            com.google.android.gms.internal.ads.zzatb[] r11 = r8.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11 = r11[r3]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r12 = r11.zzb()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 == 0) goto L_0x0130
            r12 = 1
            goto L_0x0131
        L_0x0130:
            r12 = 0
        L_0x0131:
            r2[r3] = r12     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r13 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayo[] r13 = r13.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r13 = r13[r3]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r13 == 0) goto L_0x013d
            int r5 = r5 + 1
        L_0x013d:
            if (r12 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzayo r12 = r11.zzh()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r13 == r12) goto L_0x015d
            com.google.android.gms.internal.ads.zzatb r12 = r8.zzm     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r11 != r12) goto L_0x0156
            if (r13 != 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzban r12 = r8.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzbag r13 = r8.zzn     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r12.zzd(r13)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0152:
            r8.zzn = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzm = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0156:
            zzQ(r11)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11.zzj()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0166
        L_0x015d:
            boolean r12 = r4[r3]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 == 0) goto L_0x0166
            long r12 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11.zzu(r12)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0166:
            int r3 = r3 + 1
            goto L_0x0122
        L_0x0169:
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzazi r1 = r1.zzm     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzz(r2, r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x019d
        L_0x0178:
            r8.zzC = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x017c:
            if (r1 == 0) goto L_0x0184
            r1.zzc()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x017c
        L_0x0184:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zzl = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r2 = r1.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x019d
            long r2 = r1.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r4 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r1.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r11 - r2
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zza(r1, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x019d:
            r33.zzB()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzN()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x01b5
        L_0x01a9:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != r3) goto L_0x01af
            r3 = 0
            goto L_0x01b0
        L_0x01af:
            r3 = 1
        L_0x01b0:
            r2 = r2 & r3
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x00df
        L_0x01b5:
            return r10
        L_0x01b6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayc r1 = (com.google.android.gms.internal.ads.zzayc) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x01c5
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != r1) goto L_0x01c5
            r33.zzB()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x01c5:
            return r10
        L_0x01c6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayc r1 = (com.google.android.gms.internal.ads.zzayc) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x01f5
            com.google.android.gms.internal.ads.zzayc r3 = r2.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == r1) goto L_0x01d3
            goto L_0x01f5
        L_0x01d3:
            r2.zzj = r10     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zze()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r2.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r2.zza(r3, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzh = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzD = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r1 = r1.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzF(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzI(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x01f2:
            r33.zzB()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x01f5:
            return r10
        L_0x01f6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r3 = r1.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r3 = (com.google.android.gms.internal.ads.zzath) r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzF = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r1 = r1.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x0265
            int r3 = r8.zzz     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 <= 0) goto L_0x0235
            com.google.android.gms.internal.ads.zzass r3 = r8.zzA     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.util.Pair r3 = r8.zzy(r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r4 = r8.zzz     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzz = r9     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzA = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 != 0) goto L_0x021d
            r8.zzA(r1, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0352
        L_0x021d:
            com.google.android.gms.internal.ads.zzasr r7 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r11 = r3.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r11 = r11.intValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r3 = r3.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r3.longValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r7.<init>(r11, r14)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r7     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0266
        L_0x0235:
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r3.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0265
            com.google.android.gms.internal.ads.zzath r3 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r3 = r3.zzh()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x024a
            r8.zzA(r1, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0352
        L_0x024a:
            android.util.Pair r3 = r8.zzv(r9, r12)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r4 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r7 = r3.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = r7.intValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r3 = r3.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r3.longValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r4.<init>(r7, r14)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r4     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0265:
            r4 = 0
        L_0x0266:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 != 0) goto L_0x026c
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x026c:
            if (r3 != 0) goto L_0x0273
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0352
        L_0x0273:
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r11 = r3.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = r7.zza(r11)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 != r5) goto L_0x02d6
            int r6 = r3.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r8.zzt(r6, r2, r7)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != r5) goto L_0x028c
            r8.zzA(r1, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0352
        L_0x028c:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r6 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzd(r9, r6, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.util.Pair r2 = r8.zzv(r9, r12)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r6 = r2.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r6 = r6.intValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r2 = r2.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r2.longValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzd(r6, r7, r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r2 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r2 = r2.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzg = r5     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x02b4:
            com.google.android.gms.internal.ads.zzasq r3 = r3.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x02c6
            java.lang.Object r7 = r3.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r10 == r7) goto L_0x02c2
            r7 = -1
            goto L_0x02c3
        L_0x02c2:
            r7 = r6
        L_0x02c3:
            r3.zzg = r7     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x02b4
        L_0x02c6:
            long r2 = r8.zzu(r6, r11)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r5 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5.<init>(r6, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r5     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0352
        L_0x02d6:
            boolean r2 = r8.zzO(r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzg = r9     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzi = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 != r2) goto L_0x02e4
            r2 = 1
            goto L_0x02e5
        L_0x02e4:
            r2 = 0
        L_0x02e5:
            com.google.android.gms.internal.ads.zzasr r11 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r12 = r11.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 == 0) goto L_0x02fc
            com.google.android.gms.internal.ads.zzasr r12 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r11.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r12.<init>(r9, r13)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r11.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r12.zzc = r13     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r11.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r12.zzd = r13     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r12     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x02fc:
            com.google.android.gms.internal.ads.zzasq r11 = r3.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r11 == 0) goto L_0x034f
            com.google.android.gms.internal.ads.zzath r12 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r15 = r8.zzv     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = r12.zzf(r7, r13, r14, r15)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 == r5) goto L_0x0332
            java.lang.Object r12 = r11.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r13 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r14 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r13 = r13.zzd(r7, r14, r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r13 = r13.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r12 == 0) goto L_0x0332
            boolean r3 = r8.zzO(r7)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11.zzg = r7     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11.zzi = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r11 != r3) goto L_0x032e
            r3 = 1
            goto L_0x032f
        L_0x032e:
            r3 = 0
        L_0x032f:
            r2 = r2 | r3
            r3 = r11
            goto L_0x02fc
        L_0x0332:
            if (r2 != 0) goto L_0x0348
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r5 = r3.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r5 = r8.zzu(r2, r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r3 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.<init>(r2, r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x034f
        L_0x0348:
            r8.zzC = r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzl = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            zzR(r11)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x034f:
            r8.zzD(r1, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0352:
            return r10
        L_0x0353:
            r8.zzE(r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzcjv r1 = r8.zzL     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zzb()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzJ(r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            monitor-enter(r33)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzq = r10     // Catch:{ all -> 0x0366 }
            r33.notifyAll()     // Catch:{ all -> 0x0366 }
            monitor-exit(r33)     // Catch:{ all -> 0x0366 }
            return r10
        L_0x0366:
            r0 = move-exception
            r1 = r0
            monitor-exit(r33)     // Catch:{ all -> 0x0366 }
            throw r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x036a:
            r33.zzL()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            return r10
        L_0x036e:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzata r1 = (com.google.android.gms.internal.ads.zzata) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzbag r2 = r8.zzn     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x037b
            com.google.android.gms.internal.ads.zzata r1 = r2.zzK(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0380
        L_0x037b:
            com.google.android.gms.internal.ads.zzban r2 = r8.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzK(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0380:
            r8.zzl = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            return r10
        L_0x038c:
            java.lang.Object r1 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzass r1 = (com.google.android.gms.internal.ads.zzass) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x039d
            int r2 = r8.zzz     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2 + r10
            r8.zzz = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzA = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0417
        L_0x039d:
            android.util.Pair r2 = r8.zzy(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x03c1
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.<init>(r9, r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.<init>(r9, r12)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzJ(r15)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzE(r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0417
        L_0x03c1:
            long r3 = r1.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03c9
            r1 = 1
            goto L_0x03ca
        L_0x03c9:
            r1 = 0
        L_0x03ca:
            java.lang.Object r3 = r2.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r3 = r3.intValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r2 = r2.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r4 = r2.longValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r2 = r8.zzk     // Catch:{ all -> 0x0418 }
            int r6 = r2.zza     // Catch:{ all -> 0x0418 }
            if (r3 != r6) goto L_0x03fd
            r16 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r16
            long r11 = r2.zzc     // Catch:{ all -> 0x0418 }
            long r11 = r11 / r16
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x03fd
            com.google.android.gms.internal.ads.zzasr r2 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.<init>(r3, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x03f9:
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0417
        L_0x03fd:
            long r6 = r8.zzu(r3, r4)     // Catch:{ all -> 0x0418 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0407
            r2 = 1
            goto L_0x0408
        L_0x0407:
            r2 = 0
        L_0x0408:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzasr r2 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.<init>(r3, r6)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x03f9
        L_0x0417:
            return r10
        L_0x0418:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzasr r6 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r6.<init>(r3, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r6     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r6)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            throw r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x042b:
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != 0) goto L_0x043d
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zza()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r11 = r5
            goto L_0x0679
        L_0x043d:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != 0) goto L_0x0446
            com.google.android.gms.internal.ads.zzasr r1 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x047b
        L_0x0446:
            int r2 = r1.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r7 = r1.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 != 0) goto L_0x0555
            boolean r1 = r1.zzd()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0555
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r1 = r1.zzd(r2, r7, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r1.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0555
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x046f
            com.google.android.gms.internal.ads.zzasq r7 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = r7.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = r7 - r1
            r1 = 100
            if (r7 == r1) goto L_0x0555
        L_0x046f:
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatg r14 = r8.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r15 = r8.zzv     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.zzf(r2, r7, r14, r15)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x047b:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.zzb()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 < r2) goto L_0x048a
            com.google.android.gms.internal.ads.zzaye r1 = r8.zzo     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zza()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0555
        L_0x048a:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x0495
            com.google.android.gms.internal.ads.zzasr r2 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r2.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0492:
            r11 = r5
            r15 = 2
            goto L_0x04e8
        L_0x0495:
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzd(r1, r7, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatg r7 = r8.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzg(r9, r7, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x04a6
            goto L_0x0492
        L_0x04a6:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r1.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r11 = r1.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r14 - r11
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r7 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r1 = r2.zzd(r1, r7, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r1 = r1.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r14 + r1
            long r1 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r14 = r14 - r1
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r7 = 0
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r13 = java.lang.Math.max(r3, r14)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1 = r33
            r3 = r7
            r6 = r5
            r4 = r11
            r11 = r6
            r15 = 2
            r6 = r13
            android.util.Pair r1 = r1.zzx(r2, r3, r4, r6)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0556
            java.lang.Object r2 = r1.first     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.intValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r1 = r1.second     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r1.longValue()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1 = r2
        L_0x04e8:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x04f3
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x04f0:
            r21 = r5
            goto L_0x0506
        L_0x04f3:
            long r5 = r2.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r2.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r5 = r5 - r13
            com.google.android.gms.internal.ads.zzath r7 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r13 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r2 = r7.zzd(r2, r13, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r2.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r5 = r5 + r13
            goto L_0x04f0
        L_0x0506:
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x050d
            r27 = 0
            goto L_0x0512
        L_0x050d:
            int r2 = r2.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2 + r10
            r27 = r2
        L_0x0512:
            boolean r29 = r8.zzO(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzath r2 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r5 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzd(r1, r5, r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = new com.google.android.gms.internal.ads.zzasq     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatb[] r5 = r8.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatc[] r6 = r8.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzazh r7 = r8.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzcjv r13 = r8.zzL     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzaye r14 = r8.zzo     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r15 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            java.lang.Object r15 = r15.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r32 = 0
            r18 = r2
            r19 = r5
            r20 = r6
            r23 = r7
            r24 = r13
            r25 = r14
            r26 = r15
            r28 = r1
            r30 = r3
            r18.<init>(r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r32)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x054a
            r1.zzl = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x054a:
            r8.zzC = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayc r1 = r2.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zzw(r8, r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzH(r10)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0556
        L_0x0555:
            r11 = r5
        L_0x0556:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x056d
            boolean r1 = r1.zzd()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0561
            goto L_0x056d
        L_0x0561:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0570
            boolean r1 = r8.zzt     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != 0) goto L_0x0570
            r33.zzB()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0570
        L_0x056d:
            r8.zzH(r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0570:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0679
        L_0x0574:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == r2) goto L_0x05ab
            long r3 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r5 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r5 = r5.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x05ab
            r1.zzc()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzI(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r3 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r4 = r2.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.<init>(r3, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzN()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r1 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 5
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0574
        L_0x05ab:
            boolean r1 = r2.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x05d1
            r1 = 0
        L_0x05b0:
            r2 = 2
            if (r1 >= r2) goto L_0x0679
            com.google.android.gms.internal.ads.zzatb[] r2 = r8.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = r2[r1]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayo[] r3 = r3.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = r3[r1]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x05ce
            com.google.android.gms.internal.ads.zzayo r4 = r2.zzh()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r4 != r3) goto L_0x05ce
            boolean r3 = r2.zzA()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x05ce
            r2.zzv()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x05ce:
            int r1 = r1 + 1
            goto L_0x05b0
        L_0x05d1:
            r1 = 0
        L_0x05d2:
            r2 = 2
            if (r1 >= r2) goto L_0x05f0
            com.google.android.gms.internal.ads.zzatb[] r2 = r8.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = r2[r1]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayo[] r3 = r3.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = r3[r1]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayo r4 = r2.zzh()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r4 != r3) goto L_0x0679
            if (r3 == 0) goto L_0x05ed
            boolean r2 = r2.zzA()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x0679
        L_0x05ed:
            int r1 = r1 + 1
            goto L_0x05d2
        L_0x05f0:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r1.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x0679
            boolean r3 = r2.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x0679
            com.google.android.gms.internal.ads.zzazi r1 = r1.zzm     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzD = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzazi r3 = r2.zzm     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r4 = r2.zzh()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 0
            r6 = 2
        L_0x0608:
            if (r2 >= r6) goto L_0x0679
            com.google.android.gms.internal.ads.zzatb[] r6 = r8.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r6 = r6[r2]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzazf r7 = r1.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayx r7 = r7.zza(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 != 0) goto L_0x061b
        L_0x0616:
            r19 = r3
            r20 = r4
            goto L_0x066f
        L_0x061b:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x0628
            r6.zzv()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0616
        L_0x0628:
            boolean r7 = r6.zzB()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 != 0) goto L_0x0616
            com.google.android.gms.internal.ads.zzazf r7 = r3.zzb     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayx r7 = r7.zza(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatd[] r13 = r1.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r13 = r13[r2]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatd[] r14 = r3.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r14 = r14[r2]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r7 == 0) goto L_0x0668
            boolean r13 = r14.equals(r13)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r13 == 0) goto L_0x0668
            r7.zzb()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasw[] r13 = new com.google.android.gms.internal.ads.zzasw[r10]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r14 = 0
        L_0x064a:
            if (r14 > 0) goto L_0x0655
            com.google.android.gms.internal.ads.zzasw r15 = r7.zzc(r14)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r13[r14] = r15     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r14 = r14 + 1
            goto L_0x064a
        L_0x0655:
            com.google.android.gms.internal.ads.zzasq r7 = r8.zzD     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayo[] r14 = r7.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r14 = r14[r2]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r7.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r19 = r3
            r20 = r4
            long r3 = r7.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r9 - r3
            r6.zzt(r13, r14, r9)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x066f
        L_0x0668:
            r19 = r3
            r20 = r4
            r6.zzv()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x066f:
            int r2 = r2 + 1
            r3 = r19
            r4 = r20
            r6 = 2
            r9 = 0
            r10 = 1
            goto L_0x0608
        L_0x0679:
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 10
            if (r1 != 0) goto L_0x0688
            r33.zzC()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzG(r11, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0685:
            r1 = 1
            goto L_0x080f
        L_0x0688:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzbap.zza(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzN()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r1 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzayc r1 = r1.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r4 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r4 = r4.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.zzq(r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r4 = r1.length     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5 = 1
            r6 = 1
            r7 = 0
        L_0x06a1:
            if (r7 >= r4) goto L_0x06d8
            r9 = r1[r7]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r2 = r8.zzy     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r9.zzD(r13, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r6 == 0) goto L_0x06b6
            boolean r2 = r9.zzE()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x06b6
            r6 = 1
            goto L_0x06b7
        L_0x06b6:
            r6 = 0
        L_0x06b7:
            boolean r2 = r9.zzF()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x06c6
            boolean r2 = r9.zzE()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 == 0) goto L_0x06c4
            goto L_0x06c6
        L_0x06c4:
            r2 = 0
            goto L_0x06c7
        L_0x06c6:
            r2 = 1
        L_0x06c7:
            if (r2 != 0) goto L_0x06cc
            r9.zzm()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x06cc:
            if (r5 == 0) goto L_0x06d2
            if (r2 == 0) goto L_0x06d2
            r5 = 1
            goto L_0x06d3
        L_0x06d2:
            r5 = 0
        L_0x06d3:
            int r7 = r7 + 1
            r2 = 10
            goto L_0x06a1
        L_0x06d8:
            if (r5 != 0) goto L_0x06dd
            r33.zzC()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x06dd:
            com.google.android.gms.internal.ads.zzbag r1 = r8.zzn     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0700
            com.google.android.gms.internal.ads.zzata r1 = r1.zzJ()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzata r2 = r8.zzl     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r2 != 0) goto L_0x0700
            r8.zzl = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzban r2 = r8.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzbag r3 = r8.zzn     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.zzd(r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r2 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendToTarget()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0700:
            com.google.android.gms.internal.ads.zzath r1 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r3 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r4 = 0
            com.google.android.gms.internal.ads.zzatf r1 = r1.zzd(r2, r3, r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r1 = r1.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r6 == 0) goto L_0x0731
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0722
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r3.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0731
        L_0x0722:
            com.google.android.gms.internal.ads.zzasq r3 = r8.zzE     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r3 = r3.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x0731
            r3 = 4
            r8.zzJ(r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzM()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x07c2
        L_0x0731:
            int r3 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r4 = 2
            if (r3 != r4) goto L_0x07a8
            com.google.android.gms.internal.ads.zzatb[] r3 = r8.zzp     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r3 = r3.length     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 <= 0) goto L_0x0796
            if (r5 == 0) goto L_0x07c2
            boolean r1 = r8.zzs     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r3 = r2.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 != 0) goto L_0x0748
            long r2 = r2.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x074e
        L_0x0748:
            com.google.android.gms.internal.ads.zzayc r2 = r2.zza     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r2 = r2.zzg()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x074e:
            r4 = -9223372036854775808
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0768
            com.google.android.gms.internal.ads.zzasq r2 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r3 = r2.zzi     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 == 0) goto L_0x075b
            goto L_0x079c
        L_0x075b:
            com.google.android.gms.internal.ads.zzath r3 = r8.zzF     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r2.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzatf r4 = r8.zzj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5 = 0
            com.google.android.gms.internal.ads.zzatf r2 = r3.zzd(r2, r4, r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r2 = r2.zzc     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0768:
            boolean r4 = r8.zzG     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r4 == 0) goto L_0x0782
            com.google.android.gms.internal.ads.zzcjv r2 = r8.zzL     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasr r3 = r8.zzk     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r3 = r3.zzd     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r5 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r6 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r5.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r5.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r3 = r3 - r6
            boolean r1 = r2.zzk(r3, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0793
        L_0x0782:
            com.google.android.gms.internal.ads.zzcjv r4 = r8.zzL     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasq r5 = r8.zzC     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r6 = r8.zzB     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r5.zzf     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r13 = r5.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r9 = r9 - r13
            long r6 = r6 - r9
            long r2 = r2 - r6
            boolean r1 = r4.zzk(r2, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0793:
            if (r1 == 0) goto L_0x07c2
            goto L_0x079c
        L_0x0796:
            boolean r1 = r8.zzP(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x07c2
        L_0x079c:
            r1 = 3
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x07c2
            r33.zzK()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x07c2
        L_0x07a8:
            r4 = 3
            if (r3 != r4) goto L_0x07c2
            com.google.android.gms.internal.ads.zzatb[] r3 = r8.zzp     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r3 = r3.length     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r3 <= 0) goto L_0x07b1
            goto L_0x07b5
        L_0x07b1:
            boolean r5 = r8.zzP(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x07b5:
            if (r5 != 0) goto L_0x07c2
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzs = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1 = 2
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzM()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x07c2:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 2
            if (r1 != r2) goto L_0x07d5
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r2 = r1.length     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r9 = 0
        L_0x07cb:
            if (r9 >= r2) goto L_0x07d5
            r3 = r1[r9]     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zzm()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r9 = r9 + 1
            goto L_0x07cb
        L_0x07d5:
            boolean r1 = r8.zzr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x07de
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 3
            if (r1 == r2) goto L_0x07e3
        L_0x07de:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 2
            if (r1 != r2) goto L_0x07f1
        L_0x07e3:
            int r1 = r8.zzJ     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 <= 0) goto L_0x07eb
            int r1 = r8.zzJ     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r2 = (long) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x07ed
        L_0x07eb:
            r2 = 10
        L_0x07ed:
            r8.zzG(r11, r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x080a
        L_0x07f1:
            com.google.android.gms.internal.ads.zzatb[] r1 = r8.zzp     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.length     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0804
            int r1 = r8.zzK     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 <= 0) goto L_0x07fe
            int r1 = r8.zzK     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            long r1 = (long) r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0800
        L_0x07fe:
            r1 = r16
        L_0x0800:
            r8.zzG(r11, r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x080a
        L_0x0804:
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 2
            r1.removeMessages(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x080a:
            com.google.android.gms.internal.ads.zzbap.zzb()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0685
        L_0x080f:
            return r1
        L_0x0810:
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0816
            r1 = 1
            goto L_0x0817
        L_0x0816:
            r1 = 0
        L_0x0817:
            r2 = 0
            r8.zzs = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzr = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 != 0) goto L_0x0826
            r33.zzM()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r33.zzN()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0824:
            r1 = 1
            goto L_0x083e
        L_0x0826:
            int r1 = r8.zzu     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 3
            if (r1 != r2) goto L_0x0835
            r33.zzK()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2 = 2
            r1.sendEmptyMessage(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0824
        L_0x0835:
            r2 = 2
            if (r1 != r2) goto L_0x0824
            android.os.Handler r1 = r8.zze     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1.sendEmptyMessage(r2)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            goto L_0x0824
        L_0x083e:
            return r1
        L_0x083f:
            java.lang.Object r2 = r1.obj     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzaye r2 = (com.google.android.gms.internal.ads.zzaye) r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            int r1 = r1.arg1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r3 = r8.zzg     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r4 = 0
            r3.sendEmptyMessage(r4)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = 1
            r8.zzE(r3)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzcjv r3 = r8.zzL     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3.zza()     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            if (r1 == 0) goto L_0x0862
            com.google.android.gms.internal.ads.zzasr r1 = new com.google.android.gms.internal.ads.zzasr     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r4, r5)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r8.zzk = r1     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
        L_0x0862:
            r8.zzo = r2     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            com.google.android.gms.internal.ads.zzasm r1 = r8.zzh     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r3 = 1
            r2.zzb(r1, r3, r8)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r1 = 2
            r8.zzJ(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            android.os.Handler r2 = r8.zze     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            r2.sendEmptyMessage(r1)     // Catch:{ zzasi -> 0x08b9, IOException -> 0x0897, RuntimeException -> 0x0874 }
            return r3
        L_0x0874:
            r0 = move-exception
            r1 = r0
            java.lang.String r3 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Internal runtime error."
            r2 = 6
            java.lang.String r6 = "com.google.android.gms.internal.ads.zzasu"
            r7 = 232(0xe8, float:3.25E-43)
            r5 = r1
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            android.os.Handler r2 = r8.zzg
            com.google.android.gms.internal.ads.zzasi r1 = com.google.android.gms.internal.ads.zzasi.zzc(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzL()
        L_0x0895:
            r1 = 1
            return r1
        L_0x0897:
            r0 = move-exception
            r1 = r0
            java.lang.String r3 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            r2 = 6
            java.lang.String r6 = "com.google.android.gms.internal.ads.zzasu"
            r7 = 236(0xec, float:3.31E-43)
            r5 = r1
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            android.os.Handler r2 = r8.zzg
            com.google.android.gms.internal.ads.zzasi r1 = com.google.android.gms.internal.ads.zzasi.zzb(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzL()
            goto L_0x0895
        L_0x08b9:
            r0 = move-exception
            r1 = r0
            java.lang.String r3 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            r2 = 6
            java.lang.String r6 = "com.google.android.gms.internal.ads.zzasu"
            r7 = 239(0xef, float:3.35E-43)
            r5 = r1
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            android.os.Handler r2 = r8.zzg
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r33.zzL()
            goto L_0x0895
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0024, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzasl... r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzq     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0013
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Ignoring messages sent after release."
            r1 = 5
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.internal.ads.zzasu"
            r6 = 1
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0036 }
            monitor-exit(r7)
            return
        L_0x0013:
            int r0 = r7.zzw     // Catch:{ all -> 0x0036 }
            int r1 = r0 + 1
            r7.zzw = r1     // Catch:{ all -> 0x0036 }
            android.os.Handler r1 = r7.zze     // Catch:{ all -> 0x0036 }
            r2 = 11
            android.os.Message r8 = r1.obtainMessage(r2, r8)     // Catch:{ all -> 0x0036 }
            r8.sendToTarget()     // Catch:{ all -> 0x0036 }
        L_0x0024:
            int r8 = r7.zzx     // Catch:{ all -> 0x0036 }
            if (r8 > r0) goto L_0x0034
            r7.wait()     // Catch:{ InterruptedException -> 0x002c }
            goto L_0x0024
        L_0x002c:
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0036 }
            r8.interrupt()     // Catch:{ all -> 0x0036 }
            goto L_0x0024
        L_0x0034:
            monitor-exit(r7)
            return
        L_0x0036:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zza(com.google.android.gms.internal.ads.zzasl[]):void");
    }

    public final void zzb() {
        this.zzG = true;
    }

    public final void zzc(int i) {
        this.zzI = i;
    }

    public final void zzd() {
        this.zzH = true;
    }

    public final /* synthetic */ void zze(zzayq zzayq) {
        this.zze.obtainMessage(9, (zzayc) zzayq).sendToTarget();
    }

    public final void zzf(zzayc zzayc) {
        this.zze.obtainMessage(8, zzayc).sendToTarget();
    }

    public final void zzg(zzath zzath, Object obj) {
        this.zze.obtainMessage(7, Pair.create(zzath, (Object) null)).sendToTarget();
    }

    public final void zzh() {
        this.zze.sendEmptyMessage(10);
    }

    public final void zzi(zzaye zzaye, boolean z) {
        this.zze.obtainMessage(0, 1, 0, zzaye).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzj() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.zze     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzq     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzf     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzj():void");
    }

    public final void zzk(zzath zzath, int i, long j) {
        this.zze.obtainMessage(3, new zzass(zzath, 0, j)).sendToTarget();
    }

    public final void zzl(zzasl... zzaslArr) {
        if (this.zzq) {
            SystemUtils.log(5, "ExoPlayerImplInternal", "Ignoring messages sent after release.", (Throwable) null, "com.google.android.gms.internal.ads.zzasu", 1);
            return;
        }
        this.zzw++;
        this.zze.obtainMessage(11, zzaslArr).sendToTarget();
    }

    public final void zzm(int i) {
        this.zzK = i;
    }

    public final void zzn(int i) {
        this.zzJ = i;
    }

    public final void zzo(boolean z) {
        this.zze.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zzp() {
        this.zze.sendEmptyMessage(5);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(com.google.android.gms.internal.ads.zzasl... r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.zzq     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r9)
            return r1
        L_0x0008:
            int r0 = r9.zzw     // Catch:{ all -> 0x0044 }
            int r2 = r0 + 1
            r9.zzw = r2     // Catch:{ all -> 0x0044 }
            android.os.Handler r2 = r9.zze     // Catch:{ all -> 0x0044 }
            r3 = 11
            android.os.Message r10 = r2.obtainMessage(r3, r10)     // Catch:{ all -> 0x0044 }
            r10.sendToTarget()     // Catch:{ all -> 0x0044 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            int r10 = r9.zzI     // Catch:{ all -> 0x0044 }
            long r4 = (long) r10     // Catch:{ all -> 0x0044 }
            long r2 = r2 + r4
        L_0x0021:
            int r10 = r9.zzx     // Catch:{ all -> 0x0044 }
            if (r10 > r0) goto L_0x003d
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x003d
            r9.wait(r4)     // Catch:{ InterruptedException -> 0x002f }
            goto L_0x0036
        L_0x002f:
            java.lang.Thread r10 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
            r10.interrupt()     // Catch:{ all -> 0x0044 }
        L_0x0036:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0044 }
            long r4 = r2 - r4
            goto L_0x0021
        L_0x003d:
            if (r0 >= r10) goto L_0x0041
            monitor-exit(r9)
            return r1
        L_0x0041:
            r10 = 0
            monitor-exit(r9)
            return r10
        L_0x0044:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzq(com.google.android.gms.internal.ads.zzasl[]):boolean");
    }

    public final boolean zzr() {
        return this.zzH && this.zzI > 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|27|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002b, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzs() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzq     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0008
            r0 = 1
            monitor-exit(r7)
            return r0
        L_0x0008:
            android.os.Handler r0 = r7.zze     // Catch:{ all -> 0x003b }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x003b }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x003b }
            int r2 = r7.zzI     // Catch:{ all -> 0x003b }
            long r2 = (long) r2     // Catch:{ all -> 0x003b }
            long r0 = r0 + r2
        L_0x0016:
            boolean r4 = r7.zzq     // Catch:{ all -> 0x003b }
            if (r4 != 0) goto L_0x0032
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0037
            r7.wait(r2)     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003b }
            r2.interrupt()     // Catch:{ all -> 0x003b }
        L_0x002b:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x003b }
            long r2 = r0 - r2
            goto L_0x0016
        L_0x0032:
            android.os.HandlerThread r0 = r7.zzf     // Catch:{ all -> 0x003b }
            r0.quit()     // Catch:{ all -> 0x003b }
        L_0x0037:
            boolean r0 = r7.zzq     // Catch:{ all -> 0x003b }
            monitor-exit(r7)
            return r0
        L_0x003b:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasu.zzs():boolean");
    }
}
