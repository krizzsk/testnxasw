package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import com.didi.sdk.util.SidConverter;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzqq extends zzgr {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.f55148SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.f55139CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.f55142FS, 49, -61, 39, 93, 120};
    private float zzA;
    private ArrayDeque zzB;
    private zzqp zzC;
    private zzqn zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private zzqg zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private ByteBuffer zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private int zzZ;
    protected zzgs zza;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private long zzaf;
    private long zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private long zzak;
    private long zzal;
    private int zzam;
    private zzpr zzan;
    private zzpr zzao;
    private final zzqk zzc;
    private final zzqs zzd;
    private final float zze;
    private final zzgi zzf;
    private final zzgi zzg;
    private final zzgi zzh;
    private final zzqf zzi;
    private final zzek zzj;
    private final ArrayList zzk;
    private final MediaCodec.BufferInfo zzl;
    private final long[] zzm;
    private final long[] zzn;
    private final long[] zzo;
    private zzaf zzp;
    private zzaf zzq;
    private MediaCrypto zzr;
    private boolean zzs;
    private long zzt;
    private float zzu;
    private float zzv;
    private zzql zzw;
    private zzaf zzx;
    private MediaFormat zzy;
    private boolean zzz;

    public zzqq(int i, zzqk zzqk, zzqs zzqs, boolean z, float f) {
        super(i);
        this.zzc = zzqk;
        if (zzqs != null) {
            this.zzd = zzqs;
            this.zze = f;
            this.zzf = new zzgi(0, 0);
            this.zzg = new zzgi(0, 0);
            this.zzh = new zzgi(2, 0);
            this.zzi = new zzqf();
            this.zzj = new zzek(10);
            this.zzk = new ArrayList();
            this.zzl = new MediaCodec.BufferInfo();
            this.zzu = 1.0f;
            this.zzv = 1.0f;
            this.zzt = -9223372036854775807L;
            this.zzm = new long[10];
            this.zzn = new long[10];
            this.zzo = new long[10];
            this.zzak = -9223372036854775807L;
            this.zzal = -9223372036854775807L;
            this.zzi.zzi(0);
            this.zzi.zzb.order(ByteOrder.nativeOrder());
            this.zzA = -1.0f;
            this.zzE = 0;
            this.zzZ = 0;
            this.zzQ = -1;
            this.zzR = -1;
            this.zzP = -9223372036854775807L;
            this.zzaf = -9223372036854775807L;
            this.zzag = -9223372036854775807L;
            this.zzaa = 0;
            this.zzab = 0;
            return;
        }
        throw null;
    }

    private final void zzT() {
        this.zzX = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzW = false;
        this.zzV = false;
    }

    private final void zzU() throws zzha {
        if (this.zzac) {
            this.zzaa = 1;
            this.zzab = 3;
            return;
        }
        zzap();
        zzan();
    }

    private final void zzaA() throws zzha {
        try {
            throw null;
        } catch (MediaCryptoException e) {
            throw zzbg(e, this.zzp, false, 6006);
        }
    }

    private final boolean zzaB() throws zzha {
        if (this.zzac) {
            this.zzaa = 1;
            if (this.zzG || this.zzI) {
                this.zzab = 3;
                return false;
            }
            this.zzab = 2;
        } else {
            zzaA();
        }
        return true;
    }

    private final boolean zzaC() throws zzha {
        zzql zzql = this.zzw;
        if (zzql == null || this.zzaa == 2 || this.zzah) {
            return false;
        }
        if (this.zzQ < 0) {
            int zza2 = zzql.zza();
            this.zzQ = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzw.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzaa == 1) {
            if (!this.zzN) {
                this.zzad = true;
                this.zzw.zzj(this.zzQ, 0, 0, 0, 4);
                zzay();
            }
            this.zzaa = 2;
            return false;
        } else if (this.zzL) {
            this.zzL = false;
            this.zzg.zzb.put(zzb);
            this.zzw.zzj(this.zzQ, 0, 38, 0, 0);
            zzay();
            this.zzac = true;
            return true;
        } else {
            if (this.zzZ == 1) {
                for (int i = 0; i < this.zzx.zzo.size(); i++) {
                    this.zzg.zzb.put((byte[]) this.zzx.zzo.get(i));
                }
                this.zzZ = 2;
            }
            int position = this.zzg.zzb.position();
            zzjg zzh2 = zzh();
            try {
                int zzbf = zzbf(zzh2, this.zzg, 0);
                if (zzG()) {
                    this.zzag = this.zzaf;
                }
                if (zzbf == -3) {
                    return false;
                }
                if (zzbf == -5) {
                    if (this.zzZ == 2) {
                        this.zzg.zzb();
                        this.zzZ = 1;
                    }
                    zzS(zzh2);
                    return true;
                }
                zzgi zzgi = this.zzg;
                if (zzgi.zzg()) {
                    if (this.zzZ == 2) {
                        zzgi.zzb();
                        this.zzZ = 1;
                    }
                    this.zzah = true;
                    if (!this.zzac) {
                        zzax();
                        return false;
                    }
                    try {
                        if (!this.zzN) {
                            this.zzad = true;
                            this.zzw.zzj(this.zzQ, 0, 0, 0, 4);
                            zzay();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw zzbg(e, this.zzp, false, zzen.zzl(e.getErrorCode()));
                    }
                } else if (this.zzac || zzgi.zzh()) {
                    boolean zzk2 = zzgi.zzk();
                    if (zzk2) {
                        zzgi.zza.zzb(position);
                    }
                    if (this.zzF && !zzk2) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzaaf.zza;
                        int position2 = byteBuffer.position();
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = i2 + 1;
                            if (i4 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b = byteBuffer.get(i2) & 255;
                            if (i3 == 3) {
                                if (b == 1) {
                                    if ((byteBuffer.get(i4) & Ascii.f55151US) == 7) {
                                        ByteBuffer duplicate = byteBuffer.duplicate();
                                        duplicate.position(i2 - 3);
                                        duplicate.limit(position2);
                                        byteBuffer.position(0);
                                        byteBuffer.put(duplicate);
                                        break;
                                    }
                                    b = 1;
                                }
                            } else if (b == 0) {
                                i3++;
                            }
                            if (b != 0) {
                                i3 = 0;
                            }
                            i2 = i4;
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzF = false;
                    }
                    zzgi zzgi2 = this.zzg;
                    long j = zzgi2.zzd;
                    zzqg zzqg = this.zzO;
                    if (zzqg != null) {
                        j = zzqg.zzb(this.zzp, zzgi2);
                        this.zzaf = Math.max(this.zzaf, this.zzO.zza(this.zzp));
                    }
                    long j2 = j;
                    if (this.zzg.zzf()) {
                        this.zzk.add(Long.valueOf(j2));
                    }
                    if (this.zzaj) {
                        this.zzj.zzd(j2, this.zzp);
                        this.zzaj = false;
                    }
                    this.zzaf = Math.max(this.zzaf, j2);
                    this.zzg.zzj();
                    zzgi zzgi3 = this.zzg;
                    if (zzgi3.zze()) {
                        zzam(zzgi3);
                    }
                    zzad(this.zzg);
                    if (zzk2) {
                        try {
                            this.zzw.zzk(this.zzQ, 0, this.zzg.zza, j2, 0);
                        } catch (MediaCodec.CryptoException e2) {
                            throw zzbg(e2, this.zzp, false, zzen.zzl(e2.getErrorCode()));
                        }
                    } else {
                        this.zzw.zzj(this.zzQ, 0, this.zzg.zzb.limit(), j2, 0);
                    }
                    zzay();
                    this.zzac = true;
                    this.zzZ = 0;
                    this.zza.zzc++;
                    return true;
                } else {
                    zzgi.zzb();
                    if (this.zzZ == 2) {
                        this.zzZ = 1;
                    }
                    return true;
                }
            } catch (zzgh e3) {
                zzX(e3);
                zzaE(0);
                zzab();
                return true;
            }
        }
    }

    private final boolean zzaD() {
        return this.zzR >= 0;
    }

    private final boolean zzaE(int i) throws zzha {
        zzjg zzh2 = zzh();
        this.zzf.zzb();
        int zzbf = zzbf(zzh2, this.zzf, i | 4);
        if (zzbf == -5) {
            zzS(zzh2);
            return true;
        } else if (zzbf != -4 || !this.zzf.zzg()) {
            return false;
        } else {
            this.zzah = true;
            zzax();
            return false;
        }
    }

    private final boolean zzaF(long j) {
        return this.zzt == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.zzt;
    }

    private final boolean zzaG(zzaf zzaf2) throws zzha {
        if (!(zzen.zza < 23 || this.zzw == null || this.zzab == 3 || zzbe() == 0)) {
            float zzP2 = zzP(this.zzv, zzaf2, zzJ());
            float f = this.zzA;
            if (f == zzP2) {
                return true;
            }
            if (zzP2 == -1.0f) {
                zzU();
                return false;
            } else if (f == -1.0f && zzP2 <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzP2);
                this.zzw.zzp(bundle);
                this.zzA = zzP2;
            }
        }
        return true;
    }

    private final void zzab() {
        try {
            this.zzw.zzi();
        } finally {
            zzaq();
        }
    }

    protected static boolean zzav(zzaf zzaf2) {
        return zzaf2.zzF == 0;
    }

    /* JADX INFO: finally extract failed */
    private final void zzaw(zzqn zzqn, MediaCrypto mediaCrypto) throws Exception {
        float f;
        zzql zzql;
        int i;
        boolean z;
        boolean z2;
        zzqn zzqn2 = zzqn;
        String str = zzqn2.zza;
        float f2 = -1.0f;
        if (zzen.zza < 23) {
            f = -1.0f;
        } else {
            f = zzP(this.zzv, this.zzp, zzJ());
        }
        if (f > this.zze) {
            f2 = f;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        MediaCodec mediaCodec = null;
        zzqj zzV2 = zzV(zzqn2, this.zzp, (MediaCrypto) null, f2);
        if (zzen.zza >= 31) {
            zzqo.zza(zzV2, zzl());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            if (zzen.zza < 23 || zzen.zza < 31) {
                try {
                    zzqn zzqn3 = zzV2.zza;
                    if (zzqn3 != null) {
                        String str2 = zzqn3.zza;
                        Trace.beginSection("createCodec:".concat(String.valueOf(str2)));
                        MediaCodec createByCodecName = MediaCodec.createByCodecName(str2);
                        Trace.endSection();
                        try {
                            Trace.beginSection("configureCodec");
                            createByCodecName.configure(zzV2.zzb, zzV2.zzd, (MediaCrypto) null, 0);
                            Trace.endSection();
                            Trace.beginSection("startCodec");
                            createByCodecName.start();
                            Trace.endSection();
                            zzql = new zzrh(createByCodecName, (zzrg) null);
                        } catch (IOException | RuntimeException e) {
                            e = e;
                            mediaCodec = createByCodecName;
                            if (mediaCodec != null) {
                                mediaCodec.release();
                            }
                            throw e;
                        }
                    } else {
                        throw null;
                    }
                } catch (IOException | RuntimeException e2) {
                    e = e2;
                }
            } else {
                int zzb2 = zzbt.zzb(zzV2.zzc.zzm);
                zzdw.zzd("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzen.zzO(zzb2)));
                zzql = new zzpw(zzb2, false).zzc(zzV2);
            }
            this.zzw = zzql;
            Trace.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.zzD = zzqn2;
            this.zzA = f2;
            this.zzx = this.zzp;
            if (zzen.zza > 25 || !"OMX.Exynos.avc.dec.secure".equals(str) || (!zzen.zzd.startsWith("SM-T585") && !zzen.zzd.startsWith("SM-A510") && !zzen.zzd.startsWith("SM-A520") && !zzen.zzd.startsWith("SM-J700"))) {
                i = (zzen.zza >= 24 || (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) || (!"flounder".equals(zzen.zzb) && !"flounder_lte".equals(zzen.zzb) && !"grouper".equals(zzen.zzb) && !"tilapia".equals(zzen.zzb))) ? 0 : 1;
            } else {
                i = 2;
            }
            this.zzE = i;
            this.zzF = zzen.zza < 21 && this.zzx.zzo.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
            this.zzG = zzen.zza == 19 && zzen.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str));
            this.zzH = zzen.zza == 29 && "c2.android.aac.decoder".equals(str);
            if ((zzen.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) && (zzen.zza > 19 || ((!"hb2000".equals(zzen.zzb) && !"stvm8".equals(zzen.zzb)) || (!"OMX.amlogic.avc.decoder.awesome".equals(str) && !"OMX.amlogic.avc.decoder.awesome.secure".equals(str))))) {
                z = false;
            } else {
                z = true;
            }
            this.zzI = z;
            this.zzJ = zzen.zza == 21 && "OMX.google.aac.decoder".equals(str);
            this.zzK = zzen.zza < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(zzen.zzc) && (zzen.zzb.startsWith("baffin") || zzen.zzb.startsWith(SidConverter.GRAND_STR) || zzen.zzb.startsWith("fortuna") || zzen.zzb.startsWith("gprimelte") || zzen.zzb.startsWith("j2y18lte") || zzen.zzb.startsWith("ms01"));
            String str3 = zzqn2.zza;
            if ((zzen.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str3)) && ((zzen.zza > 29 || (!"OMX.broadcom.video_decoder.tunnel".equals(str3) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str3))) && (!"Amazon".equals(zzen.zzc) || !"AFTS".equals(zzen.zzd) || !zzqn2.zzf))) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.zzN = z2;
            this.zzw.zzr();
            if ("c2.android.mp3.decoder".equals(zzqn2.zza)) {
                this.zzO = new zzqg();
            }
            if (zzbe() == 2) {
                this.zzP = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzY(str, zzV2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    private final void zzay() {
        this.zzQ = -1;
        this.zzg.zzb = null;
    }

    private final void zzaz() {
        this.zzR = -1;
        this.zzS = null;
    }

    public void zzD(float f, float f2) throws zzha {
        this.zzu = f;
        this.zzv = f2;
        zzaG(this.zzx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: com.google.android.gms.internal.ads.zzql} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v26, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v27, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v31, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v37, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v38, resolved type: com.google.android.gms.internal.ads.zzqq} */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:84|85|(1:87)(0)|88|261|(1:195)|199|210|211) */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x026c, code lost:
        if (r15.zzq != null) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02ba, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        zzax();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02bd, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02bf, code lost:
        r1 = r1;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02c1, code lost:
        if (r15.zzai != false) goto L_0x02c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02c3, code lost:
        zzap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02c6, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02ca, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x033f, code lost:
        r0 = e;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0151, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        zzax();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0156, code lost:
        if (r15.zzai != false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0158, code lost:
        zzap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015b, code lost:
        r2 = r9;
        r1 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x02ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0151 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a4 A[Catch:{ IllegalStateException -> 0x0364 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0320 A[Catch:{ IllegalStateException -> 0x0361 }, LOOP:2: B:75:0x013a->B:193:0x0320, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x032a A[Catch:{ IllegalStateException -> 0x0361 }, LOOP:4: B:195:0x032a->B:198:0x0334, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x031f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0327 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016b A[Catch:{ IllegalStateException -> 0x0364 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(long r24, long r26) throws com.google.android.gms.internal.ads.zzha {
        /*
            r23 = this;
            r15 = r23
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x000c
            r23.zzae()     // Catch:{ IllegalStateException -> 0x0364 }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzp     // Catch:{ IllegalStateException -> 0x0364 }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaE(r11)     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r23.zzan()     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x012b
            java.lang.String r0 = "bypassRender"
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IllegalStateException -> 0x0364 }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0027:
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0364 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x007b
            java.nio.ByteBuffer r7 = r0.zzb     // Catch:{ IllegalStateException -> 0x0364 }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x0364 }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x0364 }
            long r11 = r0.zzd     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r16 = r0.zzf()     // Catch:{ IllegalStateException -> 0x0364 }
            r6 = 0
            r9 = 0
            boolean r0 = r0.zzg()     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzaf r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x0364 }
            r1 = r23
            r2 = r24
            r17 = r4
            r4 = r26
            r13 = r16
            r14 = r0
            r15 = r17
            boolean r0 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0075 }
            if (r0 == 0) goto L_0x006f
            r15 = r23
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzao(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x007b
        L_0x006f:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x0122
        L_0x0075:
            r0 = move-exception
            r2 = 1
            r19 = 0
            goto L_0x02cc
        L_0x007b:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0085
            r14 = 1
            r15.zzai = r14     // Catch:{ IllegalStateException -> 0x0364 }
            r13 = 0
            goto L_0x0122
        L_0x0085:
            r14 = 1
            boolean r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r0.zzo(r1)     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            r13 = 0
            r15.zzW = r13     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x009a
        L_0x0099:
            r13 = 0
        L_0x009a:
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != 0) goto L_0x0027
            r23.zzT()     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzX = r13     // Catch:{ IllegalStateException -> 0x0364 }
            r23.zzan()     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0122
        L_0x00b2:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0364 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdd.zzf(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzjg r0 = r23.zzh()     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x00c1:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r15.zzbf(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x0364 }
            r2 = -5
            if (r1 == r2) goto L_0x0102
            r2 = -4
            if (r1 == r2) goto L_0x00d3
            goto L_0x0105
        L_0x00d3:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r1 = r1.zzg()     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x00de
            r15.zzah = r14     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x0105
        L_0x00de:
            boolean r1 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x00f0
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzp     // Catch:{ IllegalStateException -> 0x0364 }
            r2 = 0
            if (r1 == 0) goto L_0x00ef
            r15.zzq = r1     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzaa(r1, r2)     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzaj = r13     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x00f0
        L_0x00ef:
            throw r2     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x00f0:
            com.google.android.gms.internal.ads.zzgi r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            r1.zzj()     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzqf r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzgi r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 != 0) goto L_0x00c1
            r15.zzW = r14     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x0105
        L_0x0102:
            r15.zzS(r0)     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0105:
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x0110
            r0.zzj()     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0110:
            com.google.android.gms.internal.ads.zzqf r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0122
            goto L_0x0027
        L_0x0122:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x0364 }
            r1 = r15
            r2 = 1
            r19 = 0
            goto L_0x0359
        L_0x012b:
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0347
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x0342 }
            java.lang.String r0 = "drainAndFeed"
            int r1 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IllegalStateException -> 0x0342 }
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x0342 }
        L_0x013a:
            boolean r0 = r23.zzaD()     // Catch:{ IllegalStateException -> 0x0342 }
            if (r0 != 0) goto L_0x0277
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0161
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0161
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0151 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0151 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0151 }
            goto L_0x0169
        L_0x0151:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0364 }
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x015b
            r23.zzap()     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x015b:
            r2 = r9
            r1 = r15
            r19 = 0
            goto L_0x032a
        L_0x0161:
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0169:
            if (r0 >= 0) goto L_0x01a4
            r1 = -2
            if (r0 != r1) goto L_0x0194
            r15.zzae = r14     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzql r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r15.zzE     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x018f
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0364 }
            r2 = 32
            if (r1 != r2) goto L_0x018f
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 != r2) goto L_0x018f
            r15.zzM = r14     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x01af
        L_0x018f:
            r15.zzy = r0     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzz = r14     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x01af
        L_0x0194:
            boolean r0 = r15.zzN     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x015b
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != 0) goto L_0x01a0
            int r0 = r15.zzaa     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != r11) goto L_0x015b
        L_0x01a0:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x015b
        L_0x01a4:
            boolean r1 = r15.zzM     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x01b6
            r15.zzM = r13     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzql r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0364 }
            r1.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x01af:
            r2 = r9
            r1 = r15
            r0 = 2
            r19 = 0
            goto L_0x0319
        L_0x01b6:
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 != 0) goto L_0x01c8
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x0364 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x01c8
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x015b
        L_0x01c8:
            r15.zzR = r0     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzql r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0364 }
            java.nio.ByteBuffer r0 = r1.zzg(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzS = r0     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x01e9
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0364 }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x0364 }
            java.nio.ByteBuffer r0 = r15.zzS     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r2 = r2.size     // Catch:{ IllegalStateException -> 0x0364 }
            int r1 = r1 + r2
            r0.limit(r1)     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x01e9:
            boolean r0 = r15.zzK     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x020e
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0364 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x020e
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x0364 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x020e
            long r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x0364 }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x020e
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            r2.presentationTimeUs = r0     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x020e:
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0364 }
            java.util.ArrayList r2 = r15.zzk     // Catch:{ IllegalStateException -> 0x0364 }
            int r2 = r2.size()     // Catch:{ IllegalStateException -> 0x0364 }
            r3 = 0
        L_0x0219:
            if (r3 >= r2) goto L_0x0235
            java.util.ArrayList r4 = r15.zzk     // Catch:{ IllegalStateException -> 0x0364 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalStateException -> 0x0364 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IllegalStateException -> 0x0364 }
            long r4 = r4.longValue()     // Catch:{ IllegalStateException -> 0x0364 }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x0232
            java.util.ArrayList r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x0364 }
            r0.remove(r3)     // Catch:{ IllegalStateException -> 0x0364 }
            r0 = 1
            goto L_0x0236
        L_0x0232:
            int r3 = r3 + 1
            goto L_0x0219
        L_0x0235:
            r0 = 0
        L_0x0236:
            r15.zzT = r0     // Catch:{ IllegalStateException -> 0x0364 }
            long r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0364 }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0244
            r0 = 1
            goto L_0x0245
        L_0x0244:
            r0 = 0
        L_0x0245:
            r15.zzU = r0     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0364 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzek r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x0364 }
            java.lang.Object r0 = r2.zzc(r0)     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 != 0) goto L_0x0261
            boolean r1 = r15.zzz     // Catch:{ IllegalStateException -> 0x0364 }
            if (r1 == 0) goto L_0x0261
            com.google.android.gms.internal.ads.zzek r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0364 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x0364 }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0261:
            if (r0 == 0) goto L_0x0266
            r15.zzq = r0     // Catch:{ IllegalStateException -> 0x0364 }
            goto L_0x026e
        L_0x0266:
            boolean r0 = r15.zzz     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0277
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0364 }
            if (r0 == 0) goto L_0x0277
        L_0x026e:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0364 }
            android.media.MediaFormat r1 = r15.zzy     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzaa(r0, r1)     // Catch:{ IllegalStateException -> 0x0364 }
            r15.zzz = r13     // Catch:{ IllegalStateException -> 0x0364 }
        L_0x0277:
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0342 }
            if (r0 == 0) goto L_0x02d5
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x02d0 }
            if (r0 == 0) goto L_0x02d5
            com.google.android.gms.internal.ads.zzql r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x02b6 }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x02b6 }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x02b6 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x02b6 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x02b6 }
            r12 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x02b6 }
            long r4 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x02b6 }
            boolean r2 = r15.zzT     // Catch:{ IllegalStateException -> 0x02b6 }
            boolean r3 = r15.zzU     // Catch:{ IllegalStateException -> 0x02b6 }
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x02b6 }
            r16 = r1
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r9
            r9 = r0
            r10 = r12
            r0 = 2
            r11 = r19
            r19 = 0
            r13 = r17
            r14 = r18
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x02ba }
            goto L_0x02fd
        L_0x02b6:
            r21 = r9
            r19 = 0
        L_0x02ba:
            r23.zzax()     // Catch:{ IllegalStateException -> 0x02ca }
            r15 = r23
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x033f }
            if (r0 == 0) goto L_0x02c6
            r23.zzap()     // Catch:{ IllegalStateException -> 0x033f }
        L_0x02c6:
            r1 = r15
        L_0x02c7:
            r2 = r21
            goto L_0x032a
        L_0x02ca:
            r0 = move-exception
            r2 = 1
        L_0x02cc:
            r1 = r23
            goto L_0x0369
        L_0x02d0:
            r0 = move-exception
            r19 = 0
            goto L_0x0340
        L_0x02d5:
            r21 = r9
            r0 = 2
            r19 = 0
            com.google.android.gms.internal.ads.zzql r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x033f }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x033f }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x033f }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x033f }
            int r9 = r1.flags     // Catch:{ IllegalStateException -> 0x033f }
            r10 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x033f }
            long r11 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x033f }
            boolean r13 = r15.zzT     // Catch:{ IllegalStateException -> 0x033f }
            boolean r14 = r15.zzU     // Catch:{ IllegalStateException -> 0x033f }
            com.google.android.gms.internal.ads.zzaf r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x033f }
            r1 = r23
            r2 = r24
            r16 = r4
            r4 = r26
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x033b }
        L_0x02fd:
            if (r1 == 0) goto L_0x0327
            r1 = r23
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x0361 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0361 }
            r1.zzao(r2)     // Catch:{ IllegalStateException -> 0x0361 }
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x0361 }
            int r2 = r2.flags     // Catch:{ IllegalStateException -> 0x0361 }
            r23.zzaz()     // Catch:{ IllegalStateException -> 0x0361 }
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0317
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0361 }
            goto L_0x02c7
        L_0x0317:
            r2 = r21
        L_0x0319:
            boolean r4 = r1.zzaF(r2)     // Catch:{ IllegalStateException -> 0x0361 }
            if (r4 != 0) goto L_0x0320
            goto L_0x032a
        L_0x0320:
            r15 = r1
            r9 = r2
            r11 = 2
            r13 = 0
            r14 = 1
            goto L_0x013a
        L_0x0327:
            r1 = r23
            goto L_0x02c7
        L_0x032a:
            boolean r0 = r23.zzaC()     // Catch:{ IllegalStateException -> 0x0361 }
            if (r0 == 0) goto L_0x0336
            boolean r0 = r1.zzaF(r2)     // Catch:{ IllegalStateException -> 0x0361 }
            if (r0 != 0) goto L_0x032a
        L_0x0336:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x0361 }
            r2 = 1
            goto L_0x0359
        L_0x033b:
            r0 = move-exception
            r1 = r23
            goto L_0x0362
        L_0x033f:
            r0 = move-exception
        L_0x0340:
            r1 = r15
            goto L_0x0362
        L_0x0342:
            r0 = move-exception
            r1 = r15
            r19 = 0
            goto L_0x0362
        L_0x0347:
            r1 = r15
            r19 = 0
            com.google.android.gms.internal.ads.zzgs r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0361 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x0361 }
            int r3 = r23.zzd(r24)     // Catch:{ IllegalStateException -> 0x0361 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x0361 }
            r2 = 1
            r1.zzaE(r2)     // Catch:{ IllegalStateException -> 0x035f }
        L_0x0359:
            com.google.android.gms.internal.ads.zzgs r0 = r1.zza     // Catch:{ IllegalStateException -> 0x035f }
            r0.zza()     // Catch:{ IllegalStateException -> 0x035f }
            return
        L_0x035f:
            r0 = move-exception
            goto L_0x0369
        L_0x0361:
            r0 = move-exception
        L_0x0362:
            r2 = 1
            goto L_0x0369
        L_0x0364:
            r0 = move-exception
            r1 = r15
            r2 = 1
            r19 = 0
        L_0x0369:
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            r4 = 21
            if (r3 < r4) goto L_0x0374
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x0374
            goto L_0x0389
        L_0x0374:
            java.lang.StackTraceElement[] r3 = r0.getStackTrace()
            int r5 = r3.length
            if (r5 <= 0) goto L_0x03b4
            r3 = r3[r19]
            java.lang.String r3 = r3.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x03b4
        L_0x0389:
            r1.zzX(r0)
            int r3 = com.google.android.gms.internal.ads.zzen.zza
            if (r3 < r4) goto L_0x039f
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x039f
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x039f
            r14 = 1
            goto L_0x03a0
        L_0x039f:
            r14 = 0
        L_0x03a0:
            if (r14 == 0) goto L_0x03a5
            r23.zzap()
        L_0x03a5:
            com.google.android.gms.internal.ads.zzqn r2 = r1.zzD
            com.google.android.gms.internal.ads.zzqm r0 = r1.zzak(r0, r2)
            com.google.android.gms.internal.ads.zzaf r2 = r1.zzp
            r3 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zzha r0 = r1.zzbg(r0, r2, r14, r3)
            throw r0
        L_0x03b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.zzL(long, long):void");
    }

    public boolean zzM() {
        return this.zzai;
    }

    public boolean zzN() {
        if (this.zzp != null) {
            if (zzI() || zzaD()) {
                return true;
            }
            if (this.zzP == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzP) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int zzO(zzaf zzaf2) throws zzha {
        try {
            return zzQ(this.zzd, zzaf2);
        } catch (zzqz e) {
            throw zzbg(e, zzaf2, false, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public float zzP(float f, zzaf zzaf2, zzaf[] zzafArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract int zzQ(zzqs zzqs, zzaf zzaf2) throws zzqz;

    /* access modifiers changed from: protected */
    public zzgt zzR(zzqn zzqn, zzaf zzaf2, zzaf zzaf3) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (zzaB() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        if (zzaB() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009a, code lost:
        if (zzaB() == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzgt zzS(com.google.android.gms.internal.ads.zzjg r13) throws com.google.android.gms.internal.ads.zzha {
        /*
            r12 = this;
            r0 = 1
            r12.zzaj = r0
            com.google.android.gms.internal.ads.zzaf r4 = r13.zza
            r1 = 0
            if (r4 == 0) goto L_0x0107
            java.lang.String r2 = r4.zzm
            r3 = 0
            if (r2 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzpr r13 = r13.zzb
            r12.zzao = r13
            r12.zzp = r4
            boolean r2 = r12.zzV
            if (r2 == 0) goto L_0x001a
            r12.zzX = r0
            return r1
        L_0x001a:
            com.google.android.gms.internal.ads.zzql r2 = r12.zzw
            if (r2 != 0) goto L_0x0024
            r12.zzB = r1
            r12.zzan()
            return r1
        L_0x0024:
            com.google.android.gms.internal.ads.zzqn r1 = r12.zzD
            com.google.android.gms.internal.ads.zzaf r5 = r12.zzx
            com.google.android.gms.internal.ads.zzpr r6 = r12.zzan
            r7 = 23
            if (r6 != r13) goto L_0x00d0
            if (r13 == r6) goto L_0x0037
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 < r7) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r7 = 0
            goto L_0x0038
        L_0x0037:
            r7 = 1
        L_0x0038:
            com.google.android.gms.internal.ads.zzdd.zzf(r7)
            com.google.android.gms.internal.ads.zzgt r7 = r12.zzR(r1, r5, r4)
            int r8 = r7.zzd
            r9 = 3
            r10 = 16
            r11 = 2
            if (r8 == 0) goto L_0x00b3
            if (r8 == r0) goto L_0x0089
            if (r8 == r11) goto L_0x005d
            boolean r0 = r12.zzaG(r4)
            if (r0 != 0) goto L_0x0052
            goto L_0x008f
        L_0x0052:
            r12.zzx = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaB()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x005d:
            boolean r8 = r12.zzaG(r4)
            if (r8 != 0) goto L_0x0064
            goto L_0x008f
        L_0x0064:
            r12.zzY = r0
            r12.zzZ = r0
            int r8 = r12.zzE
            if (r8 == r11) goto L_0x007c
            if (r8 != r0) goto L_0x007b
            int r8 = r4.zzr
            int r10 = r5.zzr
            if (r8 != r10) goto L_0x007b
            int r8 = r4.zzs
            int r10 = r5.zzs
            if (r8 != r10) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            r12.zzL = r0
            r12.zzx = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaB()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x0089:
            boolean r8 = r12.zzaG(r4)
            if (r8 != 0) goto L_0x0092
        L_0x008f:
            r6 = 16
            goto L_0x00b7
        L_0x0092:
            r12.zzx = r4
            if (r13 == r6) goto L_0x009e
            boolean r13 = r12.zzaB()
            if (r13 != 0) goto L_0x00b6
        L_0x009c:
            r6 = 2
            goto L_0x00b7
        L_0x009e:
            boolean r13 = r12.zzac
            if (r13 == 0) goto L_0x00b6
            r12.zzaa = r0
            boolean r13 = r12.zzG
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r12.zzI
            if (r13 == 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r12.zzab = r0
            goto L_0x00b6
        L_0x00b0:
            r12.zzab = r9
            goto L_0x009c
        L_0x00b3:
            r12.zzU()
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            int r13 = r7.zzd
            if (r13 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzql r13 = r12.zzw
            if (r13 != r2) goto L_0x00c3
            int r13 = r12.zzab
            if (r13 != r9) goto L_0x00cf
        L_0x00c3:
            com.google.android.gms.internal.ads.zzgt r13 = new com.google.android.gms.internal.ads.zzgt
            java.lang.String r2 = r1.zza
            r0 = 0
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00cf:
            return r7
        L_0x00d0:
            if (r13 == 0) goto L_0x00ea
            if (r6 != 0) goto L_0x00d5
            goto L_0x00ea
        L_0x00d5:
            int r13 = com.google.android.gms.internal.ads.zzen.zza
            if (r13 < r7) goto L_0x00ea
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzo.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzo.zza
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ea
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzo.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzo.zza
            r13.equals(r0)
        L_0x00ea:
            r12.zzU()
            com.google.android.gms.internal.ads.zzgt r13 = new com.google.android.gms.internal.ads.zzgt
            java.lang.String r2 = r1.zza
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00fb:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzha r13 = r12.zzbg(r13, r4, r3, r0)
            throw r13
        L_0x0107:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.zzS(com.google.android.gms.internal.ads.zzjg):com.google.android.gms.internal.ads.zzgt");
    }

    /* access modifiers changed from: protected */
    public abstract zzqj zzV(zzqn zzqn, zzaf zzaf2, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List zzW(zzqs zzqs, zzaf zzaf2, boolean z) throws zzqz;

    /* access modifiers changed from: protected */
    public void zzX(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzY(String str, zzqj zzqj, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzZ(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzaa(zzaf zzaf2, MediaFormat mediaFormat) throws zzha {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzac() {
    }

    /* access modifiers changed from: protected */
    public void zzad(zzgi zzgi) throws zzha {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzae() throws zzha {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaf(long j, long j2, zzql zzql, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf2) throws zzha;

    /* access modifiers changed from: protected */
    public boolean zzag(zzaf zzaf2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final float zzah() {
        return this.zzu;
    }

    /* access modifiers changed from: protected */
    public final long zzai() {
        return this.zzal;
    }

    /* access modifiers changed from: protected */
    public final zzql zzaj() {
        return this.zzw;
    }

    /* access modifiers changed from: protected */
    public zzqm zzak(Throwable th, zzqn zzqn) {
        return new zzqm(th, zzqn);
    }

    /* access modifiers changed from: protected */
    public final zzqn zzal() {
        return this.zzD;
    }

    /* access modifiers changed from: protected */
    public void zzam(zzgi zzgi) throws zzha {
    }

    /* access modifiers changed from: protected */
    public final void zzan() throws zzha {
        zzaf zzaf2;
        if (this.zzw == null && !this.zzV && (zzaf2 = this.zzp) != null) {
            if (this.zzao != null || !zzag(zzaf2)) {
                this.zzan = this.zzao;
                String str = this.zzp.zzm;
                if (this.zzan == null || !zzps.zza) {
                    try {
                        if (this.zzB == null) {
                            List zzW2 = zzW(this.zzd, this.zzp, false);
                            zzW2.isEmpty();
                            this.zzB = new ArrayDeque();
                            if (!zzW2.isEmpty()) {
                                this.zzB.add((zzqn) zzW2.get(0));
                            }
                            this.zzC = null;
                        }
                        if (!this.zzB.isEmpty()) {
                            zzqn zzqn = (zzqn) this.zzB.peekFirst();
                            while (this.zzw == null) {
                                zzqn zzqn2 = (zzqn) this.zzB.peekFirst();
                                if (zzau(zzqn2)) {
                                    try {
                                        zzaw(zzqn2, (MediaCrypto) null);
                                    } catch (Exception e) {
                                        if (zzqn2 == zzqn) {
                                            zzdw.zze("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                            Thread.sleep(50);
                                            zzaw(zzqn2, (MediaCrypto) null);
                                        } else {
                                            throw e;
                                        }
                                    } catch (Exception e2) {
                                        zzdw.zzf("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(String.valueOf(zzqn2))), e2);
                                        this.zzB.removeFirst();
                                        zzqp zzqp = new zzqp(this.zzp, (Throwable) e2, false, zzqn2);
                                        zzX(zzqp);
                                        zzqp zzqp2 = this.zzC;
                                        if (zzqp2 == null) {
                                            this.zzC = zzqp;
                                        } else {
                                            this.zzC = zzqp.zza(zzqp2, zzqp);
                                        }
                                        if (this.zzB.isEmpty()) {
                                            throw this.zzC;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            }
                            this.zzB = null;
                            return;
                        }
                        throw new zzqp(this.zzp, (Throwable) null, false, -49999);
                    } catch (zzqz e3) {
                        throw new zzqp(this.zzp, (Throwable) e3, false, -49998);
                    } catch (zzqp e4) {
                        throw zzbg(e4, this.zzp, false, 4001);
                    }
                } else {
                    zzpi zza2 = this.zzan.zza();
                    throw zzbg(zza2, this.zzp, false, zza2.zza);
                }
            } else {
                zzaf zzaf3 = this.zzp;
                zzT();
                String str2 = zzaf3.zzm;
                if ("audio/mp4a-latm".equals(str2) || "audio/mpeg".equals(str2) || "audio/opus".equals(str2)) {
                    this.zzi.zzn(32);
                } else {
                    this.zzi.zzn(1);
                }
                this.zzV = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzao(long j) {
        while (true) {
            int i = this.zzam;
            if (i != 0 && j >= this.zzo[0]) {
                long[] jArr = this.zzm;
                this.zzak = jArr[0];
                this.zzal = this.zzn[0];
                int i2 = i - 1;
                this.zzam = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.zzn;
                System.arraycopy(jArr2, 1, jArr2, 0, this.zzam);
                long[] jArr3 = this.zzo;
                System.arraycopy(jArr3, 1, jArr3, 0, this.zzam);
                zzac();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        try {
            zzql zzql = this.zzw;
            if (zzql != null) {
                zzql.zzl();
                this.zza.zzb++;
                zzZ(this.zzD.zza);
            }
        } finally {
            this.zzw = null;
            this.zzr = null;
            this.zzan = null;
            zzar();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaq() {
        zzay();
        zzaz();
        this.zzP = -9223372036854775807L;
        this.zzad = false;
        this.zzac = false;
        this.zzL = false;
        this.zzM = false;
        this.zzT = false;
        this.zzU = false;
        this.zzk.clear();
        this.zzaf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        zzqg zzqg = this.zzO;
        if (zzqg != null) {
            zzqg.zzc();
        }
        this.zzaa = 0;
        this.zzab = 0;
        this.zzZ = this.zzY ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzar() {
        zzaq();
        this.zzO = null;
        this.zzB = null;
        this.zzD = null;
        this.zzx = null;
        this.zzy = null;
        this.zzz = false;
        this.zzae = false;
        this.zzA = -1.0f;
        this.zzE = 0;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzN = false;
        this.zzY = false;
        this.zzZ = 0;
        this.zzs = false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzas() throws zzha {
        boolean zzat = zzat();
        if (zzat) {
            zzan();
        }
        return zzat;
    }

    /* access modifiers changed from: protected */
    public final boolean zzat() {
        if (this.zzw == null) {
            return false;
        }
        int i = this.zzab;
        if (i == 3 || this.zzG || ((this.zzH && !this.zzae) || (this.zzI && this.zzad))) {
            zzap();
            return true;
        }
        if (i == 2) {
            zzdd.zzf(zzen.zza >= 23);
            if (zzen.zza >= 23) {
                try {
                    zzaA();
                } catch (zzha e) {
                    zzdw.zzf("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzap();
                    return true;
                }
            }
        }
        zzab();
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzau(zzqn zzqn) {
        return true;
    }

    public final int zze() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void zzs() {
        this.zzp = null;
        this.zzak = -9223372036854775807L;
        this.zzal = -9223372036854775807L;
        this.zzam = 0;
        zzat();
    }

    /* access modifiers changed from: protected */
    public void zzt(boolean z, boolean z2) throws zzha {
        this.zza = new zzgs();
    }

    /* access modifiers changed from: protected */
    public void zzu(long j, boolean z) throws zzha {
        this.zzah = false;
        this.zzai = false;
        if (this.zzV) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzW = false;
        } else {
            zzas();
        }
        zzek zzek = this.zzj;
        if (zzek.zza() > 0) {
            this.zzaj = true;
        }
        zzek.zze();
        int i = this.zzam;
        if (i != 0) {
            int i2 = i - 1;
            this.zzal = this.zzn[i2];
            this.zzak = this.zzm[i2];
            this.zzam = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void zzv() {
        try {
            zzT();
            zzap();
        } finally {
            this.zzao = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzy(zzaf[] zzafArr, long j, long j2) throws zzha {
        boolean z = true;
        if (this.zzal == -9223372036854775807L) {
            if (this.zzak != -9223372036854775807L) {
                z = false;
            }
            zzdd.zzf(z);
            this.zzak = j;
            this.zzal = j2;
            return;
        }
        int i = this.zzam;
        if (i == 10) {
            zzdw.zze("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.zzn[9]);
        } else {
            this.zzam = i + 1;
        }
        long[] jArr = this.zzm;
        int i2 = this.zzam - 1;
        jArr[i2] = j;
        this.zzn[i2] = j2;
        this.zzo[i2] = this.zzaf;
    }

    private final void zzax() throws zzha {
        int i = this.zzab;
        if (i == 1) {
            zzab();
        } else if (i == 2) {
            zzab();
            zzaA();
        } else if (i != 3) {
            this.zzai = true;
            zzae();
        } else {
            zzap();
            zzan();
        }
    }
}
