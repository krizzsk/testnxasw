package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zztg implements zzrx, zzws {
    final /* synthetic */ zztl zza;
    /* access modifiers changed from: private */
    public final long zzb = zzrz.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzfy zzd;
    private final zztb zze;
    private final zzzl zzf;
    private final zzdg zzg;
    private final zzaai zzh = new zzaai();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzfc zzl = zzi(0);
    private zzaap zzm;
    private boolean zzn;

    public zztg(zztl zztl, Uri uri, zzex zzex, zztb zztb, zzzl zzzl, zzdg zzdg) {
        this.zza = zztl;
        this.zzc = uri;
        this.zzd = new zzfy(zzex);
        this.zze = zztb;
        this.zzf = zzzl;
        this.zzg = zzdg;
    }

    static /* bridge */ /* synthetic */ void zzf(zztg zztg, long j, long j2) {
        zztg.zzh.zza = j;
        zztg.zzk = j2;
        zztg.zzj = true;
        zztg.zzn = false;
    }

    private final zzfc zzi(long j) {
        zzfa zzfa = new zzfa();
        zzfa.zzd(this.zzc);
        zzfa.zzc(j);
        zzfa.zza(6);
        zzfa.zzb(zztl.zzb);
        return zzfa.zze();
    }

    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:58|59) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.google.android.gms.internal.ads.zzdw.zze("IcyHeaders", "Invalid metadata interval: ".concat(java.lang.String.valueOf(r3)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0107 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x020c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ca A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0113 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0133 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014f A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016b A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0174 A[Catch:{ all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0187 A[SYNTHETIC, Splitter:B:82:0x0187] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh() throws java.io.IOException {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x020c
            r2 = -1
            r5 = 0
            com.google.android.gms.internal.ads.zzaai r6 = r1.zzh     // Catch:{ all -> 0x01ec }
            long r13 = r6.zza     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzfc r6 = r1.zzi(r13)     // Catch:{ all -> 0x01ec }
            r1.zzl = r6     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzfy r7 = r1.zzd     // Catch:{ all -> 0x01ec }
            long r6 = r7.zzb(r6)     // Catch:{ all -> 0x01ec }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0025
            long r6 = r6 + r13
            com.google.android.gms.internal.ads.zztl r8 = r1.zza     // Catch:{ all -> 0x01ec }
            r8.zzp.post(new com.google.android.gms.internal.ads.zzte(r8))     // Catch:{ all -> 0x01ec }
        L_0x0025:
            r15 = r6
            com.google.android.gms.internal.ads.zztl r6 = r1.zza     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzfy r7 = r1.zzd     // Catch:{ all -> 0x01ec }
            java.util.Map r7 = r7.zze()     // Catch:{ all -> 0x01ec }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x01ec }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x01ec }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0076
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x01ec }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0064 }
            int r11 = r11 * 1000
            if (r11 <= 0) goto L_0x004b
            r2 = 1
            goto L_0x0061
        L_0x004b:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0065 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r2 = "Invalid bitrate: "
            r12.append(r2)     // Catch:{ NumberFormatException -> 0x0065 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x0065 }
            java.lang.String r2 = r12.toString()     // Catch:{ NumberFormatException -> 0x0065 }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r2)     // Catch:{ NumberFormatException -> 0x0065 }
            r2 = 0
            r11 = -1
        L_0x0061:
            r18 = r11
            goto L_0x0079
        L_0x0064:
            r11 = -1
        L_0x0065:
            java.lang.String r2 = "Invalid bitrate header: "
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01ec }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r2)     // Catch:{ all -> 0x01ec }
            r18 = r11
            r2 = 0
            goto L_0x0079
        L_0x0076:
            r2 = 0
            r18 = -1
        L_0x0079:
            java.lang.String r3 = "icy-genre"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ec }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ec }
            r8 = 0
            if (r3 == 0) goto L_0x008e
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ec }
            r19 = r2
            r2 = 1
            goto L_0x0090
        L_0x008e:
            r19 = r8
        L_0x0090:
            java.lang.String r3 = "icy-name"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ec }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ec }
            if (r3 == 0) goto L_0x00a4
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ec }
            r20 = r2
            r2 = 1
            goto L_0x00a6
        L_0x00a4:
            r20 = r8
        L_0x00a6:
            java.lang.String r3 = "icy-url"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ec }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ec }
            if (r3 == 0) goto L_0x00ba
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ec }
            r21 = r2
            r2 = 1
            goto L_0x00bc
        L_0x00ba:
            r21 = r8
        L_0x00bc:
            java.lang.String r3 = "icy-pub"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ec }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ec }
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ec }
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01ec }
            r22 = r2
            r2 = 1
            goto L_0x00d8
        L_0x00d6:
            r22 = 0
        L_0x00d8:
            java.lang.String r3 = "icy-metaint"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ec }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ec }
            if (r3 == 0) goto L_0x0113
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x01ec }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x01ec }
            int r7 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0106 }
            if (r7 <= 0) goto L_0x00f0
            r2 = 1
            goto L_0x0103
        L_0x00f0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0107 }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x0107 }
            r11.append(r0)     // Catch:{ NumberFormatException -> 0x0107 }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x0107 }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x0107 }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r11)     // Catch:{ NumberFormatException -> 0x0107 }
            r7 = -1
        L_0x0103:
            r23 = r7
            goto L_0x0115
        L_0x0106:
            r7 = -1
        L_0x0107:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x01ec }
            java.lang.String r3 = r0.concat(r3)     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r3)     // Catch:{ all -> 0x01ec }
            goto L_0x0103
        L_0x0113:
            r23 = -1
        L_0x0115:
            if (r2 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzacm r8 = new com.google.android.gms.internal.ads.zzacm     // Catch:{ all -> 0x01ec }
            r17 = r8
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x01ec }
        L_0x011e:
            r6.zzr = r8     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zztl r3 = r1.zza     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzacm r6 = r3.zzr     // Catch:{ all -> 0x01ec }
            if (r6 == 0) goto L_0x014f
            com.google.android.gms.internal.ads.zzacm r6 = r3.zzr     // Catch:{ all -> 0x01ec }
            int r6 = r6.zzf     // Catch:{ all -> 0x01ec }
            if (r6 == r10) goto L_0x014f
            com.google.android.gms.internal.ads.zzry r6 = new com.google.android.gms.internal.ads.zzry     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzacm r3 = r3.zzr     // Catch:{ all -> 0x01ec }
            int r3 = r3.zzf     // Catch:{ all -> 0x01ec }
            r6.<init>(r2, r3, r1)     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zztl r2 = r1.zza     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzaap r2 = r2.zzu()     // Catch:{ all -> 0x01ec }
            r1.zzm = r2     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.internal.ads.zztl.zzc     // Catch:{ all -> 0x01ec }
            r2.zzk(r3)     // Catch:{ all -> 0x01ec }
            r8 = r6
            goto L_0x0150
        L_0x014f:
            r8 = r2
        L_0x0150:
            com.google.android.gms.internal.ads.zztb r7 = r1.zze     // Catch:{ all -> 0x01ec }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd     // Catch:{ all -> 0x01ec }
            java.util.Map r10 = r2.zze()     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzzl r2 = r1.zzf     // Catch:{ all -> 0x01ec }
            r11 = r13
            r4 = r13
            r13 = r15
            r15 = r2
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zztl r2 = r1.zza     // Catch:{ all -> 0x01ec }
            com.google.android.gms.internal.ads.zzacm r2 = r2.zzr     // Catch:{ all -> 0x01ec }
            if (r2 == 0) goto L_0x0170
            com.google.android.gms.internal.ads.zztb r2 = r1.zze     // Catch:{ all -> 0x01ec }
            r2.zzc()     // Catch:{ all -> 0x01ec }
        L_0x0170:
            boolean r2 = r1.zzj     // Catch:{ all -> 0x01ec }
            if (r2 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zztb r2 = r1.zze     // Catch:{ all -> 0x01ec }
            long r7 = r1.zzk     // Catch:{ all -> 0x01ec }
            r2.zzf(r4, r7)     // Catch:{ all -> 0x01ec }
            r2 = 0
            r1.zzj = r2     // Catch:{ all -> 0x017f }
            goto L_0x0183
        L_0x017f:
            r0 = move-exception
            goto L_0x01ee
        L_0x0182:
            r2 = 0
        L_0x0183:
            r13 = r4
            r4 = 0
        L_0x0185:
            if (r4 != 0) goto L_0x01ca
            boolean r5 = r1.zzi     // Catch:{ all -> 0x01c6 }
            if (r5 != 0) goto L_0x01c3
            com.google.android.gms.internal.ads.zzdg r5 = r1.zzg     // Catch:{ InterruptedException -> 0x01bd }
            r5.zza()     // Catch:{ InterruptedException -> 0x01bd }
            com.google.android.gms.internal.ads.zztb r5 = r1.zze     // Catch:{ all -> 0x01c6 }
            com.google.android.gms.internal.ads.zzaai r6 = r1.zzh     // Catch:{ all -> 0x01c6 }
            int r4 = r5.zza(r6)     // Catch:{ all -> 0x01c6 }
            com.google.android.gms.internal.ads.zztb r5 = r1.zze     // Catch:{ all -> 0x01c6 }
            long r5 = r5.zzb()     // Catch:{ all -> 0x01c6 }
            com.google.android.gms.internal.ads.zztl r7 = r1.zza     // Catch:{ all -> 0x01c6 }
            long r7 = r7.zzj     // Catch:{ all -> 0x01c6 }
            long r7 = r7 + r13
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0185
            com.google.android.gms.internal.ads.zzdg r7 = r1.zzg     // Catch:{ all -> 0x01c6 }
            r7.zzc()     // Catch:{ all -> 0x01c6 }
            com.google.android.gms.internal.ads.zztl r7 = r1.zza     // Catch:{ all -> 0x01c6 }
            android.os.Handler r8 = r7.zzp     // Catch:{ all -> 0x01c6 }
            java.lang.Runnable r7 = r7.zzo     // Catch:{ all -> 0x01c6 }
            r8.post(r7)     // Catch:{ all -> 0x01c6 }
            r13 = r5
            goto L_0x0185
        L_0x01bd:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01c6 }
            r0.<init>()     // Catch:{ all -> 0x01c6 }
            throw r0     // Catch:{ all -> 0x01c6 }
        L_0x01c3:
            r3 = 1
            r4 = 0
            goto L_0x01cb
        L_0x01c6:
            r0 = move-exception
            r5 = r4
            r2 = 1
            goto L_0x01f0
        L_0x01ca:
            r3 = 1
        L_0x01cb:
            if (r4 != r3) goto L_0x01cf
            r5 = 0
            goto L_0x01e4
        L_0x01cf:
            com.google.android.gms.internal.ads.zztb r2 = r1.zze
            long r5 = r2.zzb()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01e3
            com.google.android.gms.internal.ads.zzaai r3 = r1.zzh
            long r5 = r2.zzb()
            r3.zza = r5
        L_0x01e3:
            r5 = r4
        L_0x01e4:
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd
            com.google.android.gms.internal.ads.zzez.zza(r2)
            if (r5 == 0) goto L_0x0004
            goto L_0x020c
        L_0x01ec:
            r0 = move-exception
            r2 = 0
        L_0x01ee:
            r2 = 1
            r5 = 0
        L_0x01f0:
            if (r5 == r2) goto L_0x0206
            com.google.android.gms.internal.ads.zztb r2 = r1.zze
            long r3 = r2.zzb()
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0206
            com.google.android.gms.internal.ads.zzaai r3 = r1.zzh
            long r4 = r2.zzb()
            r3.zza = r4
        L_0x0206:
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd
            com.google.android.gms.internal.ads.zzez.zza(r2)
            throw r0
        L_0x020c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzh():void");
    }

    public final void zza(zzef zzef) {
        long j;
        if (!this.zzn) {
            j = this.zzk;
        } else {
            j = Math.max(this.zza.zzQ(true), this.zzk);
        }
        long j2 = j;
        int zza2 = zzef.zza();
        zzaap zzaap = this.zzm;
        if (zzaap != null) {
            zzaan.zzb(zzaap, zzef, zza2);
            zzaap.zzs(j2, 1, zza2, 0, (zzaao) null);
            this.zzn = true;
            return;
        }
        throw null;
    }
}
