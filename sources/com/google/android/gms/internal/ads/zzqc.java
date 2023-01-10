package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzqc {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf = new AtomicReference();
    private final zzdg zzg;
    private boolean zzh;

    public zzqc(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdg zzdg = new zzdg(zzde.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdg;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    static /* synthetic */ void zza(com.google.android.gms.internal.ads.zzqc r9, android.os.Message r10) {
        /*
            int r0 = r10.what
            r1 = 0
            if (r0 == 0) goto L_0x0045
            r2 = 1
            if (r0 == r2) goto L_0x0022
            r2 = 2
            if (r0 == r2) goto L_0x001c
            java.util.concurrent.atomic.AtomicReference r9 = r9.zzf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            int r10 = r10.what
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.<init>(r10)
            com.google.android.gms.internal.ads.zzpz.zza(r9, r1, r0)
            goto L_0x0061
        L_0x001c:
            com.google.android.gms.internal.ads.zzdg r9 = r9.zzg
            r9.zze()
            goto L_0x0061
        L_0x0022:
            java.lang.Object r10 = r10.obj
            com.google.android.gms.internal.ads.zzqb r10 = (com.google.android.gms.internal.ads.zzqb) r10
            int r3 = r10.zza
            int r0 = r10.zzb
            android.media.MediaCodec$CryptoInfo r5 = r10.zzd
            long r6 = r10.zze
            int r8 = r10.zzf
            java.lang.Object r0 = zzb     // Catch:{ RuntimeException -> 0x003e }
            monitor-enter(r0)     // Catch:{ RuntimeException -> 0x003e }
            android.media.MediaCodec r2 = r9.zzc     // Catch:{ all -> 0x003b }
            r4 = 0
            r2.queueSecureInputBuffer(r3, r4, r5, r6, r8)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            goto L_0x0060
        L_0x003b:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r2     // Catch:{ RuntimeException -> 0x003e }
        L_0x003e:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r9 = r9.zzf
            com.google.android.gms.internal.ads.zzpz.zza(r9, r1, r0)
            goto L_0x0060
        L_0x0045:
            java.lang.Object r10 = r10.obj
            com.google.android.gms.internal.ads.zzqb r10 = (com.google.android.gms.internal.ads.zzqb) r10
            int r3 = r10.zza
            int r0 = r10.zzb
            int r5 = r10.zzc
            long r6 = r10.zze
            int r8 = r10.zzf
            android.media.MediaCodec r2 = r9.zzc     // Catch:{ RuntimeException -> 0x005a }
            r4 = 0
            r2.queueInputBuffer(r3, r4, r5, r6, r8)     // Catch:{ RuntimeException -> 0x005a }
            goto L_0x0060
        L_0x005a:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r9 = r9.zzf
            com.google.android.gms.internal.ads.zzpz.zza(r9, r1, r0)
        L_0x0060:
            r1 = r10
        L_0x0061:
            if (r1 == 0) goto L_0x0070
            java.util.ArrayDeque r9 = zza
            monitor-enter(r9)
            java.util.ArrayDeque r10 = zza     // Catch:{ all -> 0x006d }
            r10.add(r1)     // Catch:{ all -> 0x006d }
            monitor-exit(r9)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x006d }
            throw r10
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqc.zza(com.google.android.gms.internal.ads.zzqc, android.os.Message):void");
    }

    private static zzqb zzg() {
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzqb zzqb = new zzqb();
                return zzqb;
            }
            zzqb zzqb2 = (zzqb) zza.removeFirst();
            return zzqb2;
        }
    }

    private final void zzh() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                    this.zzg.zzc();
                    Handler handler2 = this.zze;
                    if (handler2 != null) {
                        handler2.obtainMessage(2).sendToTarget();
                        this.zzg.zza();
                        return;
                    }
                    throw null;
                }
                throw null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void zzc(int i, int i2, int i3, long j, int i4) {
        zzh();
        zzqb zzg2 = zzg();
        zzg2.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzen.zza;
        handler.obtainMessage(0, zzg2).sendToTarget();
    }

    public final void zzd(int i, int i2, zzgf zzgf, long j, int i3) {
        zzh();
        zzqb zzg2 = zzg();
        zzg2.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzg2.zzd;
        cryptoInfo.numSubSamples = zzgf.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzgf.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzgf.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] zzi = zzi(zzgf.zzb, cryptoInfo.key);
        if (zzi != null) {
            cryptoInfo.key = zzi;
            byte[] zzi2 = zzi(zzgf.zza, cryptoInfo.iv);
            if (zzi2 != null) {
                cryptoInfo.iv = zzi2;
                cryptoInfo.mode = zzgf.zzc;
                if (zzen.zza >= 24) {
                    cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzgf.zzg, zzgf.zzh));
                }
                this.zze.obtainMessage(1, zzg2).sendToTarget();
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void zze() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    public final void zzf() {
        if (!this.zzh) {
            this.zzd.start();
            this.zze = new zzqa(this, this.zzd.getLooper());
            this.zzh = true;
        }
    }

    private static byte[] zzi(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzj(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }
}
