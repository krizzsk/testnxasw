package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclh extends zzclb implements zzbab {
    private String zzd;
    private final zzcix zze;
    private boolean zzf;
    private final zzclg zzg = new zzclg();
    private final zzckm zzh = new zzckm();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzclh(zzciy zzciy, zzcix zzcix) {
        super(zzciy);
        this.zze = zzcix;
        this.zzl = zzciy != null ? zzciy.zzt() : "";
        this.zzm = zzciy != null ? zzciy.zzh() : 0;
    }

    protected static final String zzt(String str) {
        return "cache:".concat(String.valueOf(zzcgi.zze(str)));
    }

    private final void zzu() {
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(((float) zza2) * (((float) position) / ((float) zza)));
        boolean z = round > 0;
        int zzs = zzcip.zzs();
        int zzu = zzcip.zzu();
        String str = this.zzd;
        zzf(str, zzt(str), position, zza, (long) round, (long) zza2, z, zzs, zzu);
    }

    public final void zzb() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i) {
    }

    public final /* synthetic */ void zzk(Object obj, zzazo zzazo) {
        this.zzg.zzb((zzazq) obj);
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzm() {
        return this.zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.google.android.gms.internal.ads.zzcju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d1, code lost:
        if (r9.zzi.remaining() > 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d3, code lost:
        zzu();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
        if (r9.zzf != false) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dc, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e4, code lost:
        if ((r12 - r15) < r4) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e6, code lost:
        zzu();
        r15 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f1, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0117, code lost:
        throw new java.io.IOException("Timeout exceeded. Limit: " + r6 + " sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0118, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011a, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013d, code lost:
        throw new java.io.IOException("Precache abort at " + r9.zzi.limit() + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(java.lang.String r26) {
        /*
            r25 = this;
            r9 = r25
            r10 = r26
            r9.zzd = r10
            java.lang.String r11 = zzt(r26)
            java.lang.String r12 = "error"
            com.google.android.gms.internal.ads.zzazq r0 = new com.google.android.gms.internal.ads.zzazq     // Catch:{ Exception -> 0x0147 }
            java.lang.String r2 = r9.zzb     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzcix r1 = r9.zze     // Catch:{ Exception -> 0x0147 }
            int r5 = r1.zzd     // Catch:{ Exception -> 0x0147 }
            r3 = 0
            int r6 = r1.zzf     // Catch:{ Exception -> 0x0147 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzcix r1 = r9.zze     // Catch:{ Exception -> 0x0147 }
            boolean r1 = r1.zzj     // Catch:{ Exception -> 0x0147 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzcju r14 = new com.google.android.gms.internal.ads.zzcju     // Catch:{ Exception -> 0x0147 }
            android.content.Context r2 = r9.zza     // Catch:{ Exception -> 0x0147 }
            java.lang.String r4 = r9.zzl     // Catch:{ Exception -> 0x0147 }
            int r5 = r9.zzm     // Catch:{ Exception -> 0x0147 }
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r14
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0147 }
            r0 = r14
        L_0x0036:
            android.net.Uri r15 = android.net.Uri.parse(r26)     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzazo r1 = new com.google.android.gms.internal.ads.zzazo     // Catch:{ Exception -> 0x0147 }
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = -1
            r23 = 0
            r24 = 0
            r14 = r1
            r14.<init>(r15, r16, r17, r19, r21, r23, r24)     // Catch:{ Exception -> 0x0147 }
            r0.zzb(r1)     // Catch:{ Exception -> 0x0147 }
            java.lang.ref.WeakReference r1 = r9.zzc     // Catch:{ Exception -> 0x0147 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzciy r1 = (com.google.android.gms.internal.ads.zzciy) r1     // Catch:{ Exception -> 0x0147 }
            if (r1 == 0) goto L_0x005c
            r1.zzv(r11, r9)     // Catch:{ Exception -> 0x0147 }
        L_0x005c:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ Exception -> 0x0147 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzbiu r4 = com.google.android.gms.internal.ads.zzbjc.zzw     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x0147 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ Exception -> 0x0147 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0147 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzbiu r6 = com.google.android.gms.internal.ads.zzbjc.zzv     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzbja r7 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x0147 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ Exception -> 0x0147 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0147 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzcix r8 = r9.zze     // Catch:{ Exception -> 0x0147 }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x0147 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0147 }
            r9.zzi = r8     // Catch:{ Exception -> 0x0147 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r8]     // Catch:{ Exception -> 0x0147 }
            r15 = r2
        L_0x0093:
            java.nio.ByteBuffer r13 = r9.zzi     // Catch:{ Exception -> 0x0147 }
            int r13 = r13.remaining()     // Catch:{ Exception -> 0x0147 }
            int r13 = java.lang.Math.min(r13, r8)     // Catch:{ Exception -> 0x0147 }
            r8 = 0
            int r13 = r0.zza(r14, r8, r13)     // Catch:{ Exception -> 0x0147 }
            r8 = -1
            r19 = r0
            r0 = 1
            if (r13 != r8) goto L_0x00b8
            r9.zzn = r0     // Catch:{ Exception -> 0x0147 }
            com.google.android.gms.internal.ads.zzckm r1 = r9.zzh     // Catch:{ Exception -> 0x0147 }
            java.nio.ByteBuffer r2 = r9.zzi     // Catch:{ Exception -> 0x0147 }
            long r1 = r1.zza(r2)     // Catch:{ Exception -> 0x0147 }
            int r2 = (int) r1     // Catch:{ Exception -> 0x0147 }
            long r1 = (long) r2     // Catch:{ Exception -> 0x0147 }
            r9.zze(r10, r11, r1)     // Catch:{ Exception -> 0x0147 }
            goto L_0x00d7
        L_0x00b8:
            java.lang.Object r8 = r9.zzk     // Catch:{ Exception -> 0x0147 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0147 }
            boolean r0 = r9.zzf     // Catch:{ all -> 0x0142 }
            if (r0 != 0) goto L_0x00c8
            java.nio.ByteBuffer r0 = r9.zzi     // Catch:{ all -> 0x0142 }
            r21 = r12
            r12 = 0
            r0.put(r14, r12, r13)     // Catch:{ all -> 0x0140 }
            goto L_0x00ca
        L_0x00c8:
            r21 = r12
        L_0x00ca:
            monitor-exit(r8)     // Catch:{ all -> 0x0140 }
            java.nio.ByteBuffer r0 = r9.zzi     // Catch:{ Exception -> 0x013e }
            int r0 = r0.remaining()     // Catch:{ Exception -> 0x013e }
            if (r0 > 0) goto L_0x00d8
            r25.zzu()     // Catch:{ Exception -> 0x013e }
            r0 = 1
        L_0x00d7:
            return r0
        L_0x00d8:
            boolean r0 = r9.zzf     // Catch:{ Exception -> 0x013e }
            if (r0 != 0) goto L_0x011a
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013e }
            long r22 = r12 - r15
            int r0 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00ea
            r25.zzu()     // Catch:{ Exception -> 0x013e }
            r15 = r12
        L_0x00ea:
            long r12 = r12 - r2
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r6
            int r0 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r0 > 0) goto L_0x00fa
            r0 = r19
            r12 = r21
            r8 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0093
        L_0x00fa:
            java.lang.String r12 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0118 }
            r0.<init>()     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r0.append(r1)     // Catch:{ Exception -> 0x0118 }
            r0.append(r6)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = " sec"
            r0.append(r1)     // Catch:{ Exception -> 0x0118 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0118 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0118 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0118 }
            throw r1     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            r0 = move-exception
            goto L_0x014c
        L_0x011a:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0118 }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x0118 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0118 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0118 }
            r2.<init>()     // Catch:{ Exception -> 0x0118 }
            java.lang.String r3 = "Precache abort at "
            r2.append(r3)     // Catch:{ Exception -> 0x0118 }
            r2.append(r1)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = " bytes"
            r2.append(r1)     // Catch:{ Exception -> 0x0118 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0118 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0118 }
            throw r0     // Catch:{ Exception -> 0x0118 }
        L_0x013e:
            r0 = move-exception
            goto L_0x014a
        L_0x0140:
            r0 = move-exception
            goto L_0x0145
        L_0x0142:
            r0 = move-exception
            r21 = r12
        L_0x0145:
            monitor-exit(r8)     // Catch:{ all -> 0x0140 }
            throw r0     // Catch:{ Exception -> 0x013e }
        L_0x0147:
            r0 = move-exception
            r21 = r12
        L_0x014a:
            r12 = r21
        L_0x014c:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = ":"
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to preload url "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = " Exception: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.ads.internal.util.zze.zzj(r1)
            r9.zzc(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzq(java.lang.String):boolean");
    }
}
