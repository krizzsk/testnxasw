package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcle extends zzclb {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcle(zzciy zzciy) {
        super(zzciy);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zze.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            zze.zzj("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        } else if (!this.zzg.setReadable(true, false) || !this.zzg.setExecutable(true, false)) {
            zze.zzj("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        }
    }

    private final File zzi(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    public final void zzb() {
        this.zzh = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a9, code lost:
        r26 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02ad, code lost:
        r23 = r1;
        r25 = r3;
        r26 = r4;
        r20 = r5;
        r27 = r6;
        r28 = r7;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02bd, code lost:
        r2 = r19;
        r5 = r20;
        r15 = r21;
        r1 = r23;
        r14 = r24;
        r3 = r25;
        r4 = r26;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02d1, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02e0, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02e1, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r11 = "Timeout exceeded. Limit: " + java.lang.Long.toString(r10) + " sec";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x030a, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x030b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x030e, code lost:
        r26 = r4;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0312, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0315, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r11 = "File too big for full file cache. Size: " + java.lang.Integer.toString(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0339, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x033a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x033d, code lost:
        r2 = r11;
        r1 = r24;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0344, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0347, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x034b, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r26.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0359, code lost:
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x035b, code lost:
        com.google.android.gms.ads.internal.util.zze.zze("Preloaded " + zzf.format((long) r13) + " bytes from " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x037e, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0387, code lost:
        if (r0.isFile() == false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0389, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        zzd(r9, r12.getAbsolutePath(), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x039d, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03a2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03ab, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03ae, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03b1, code lost:
        r26 = r4;
        r1 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03b6, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03b8, code lost:
        r11 = r26;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03bf, code lost:
        r1 = r14;
        r15 = r15;
        r2 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03c8, code lost:
        if ((r0 instanceof java.lang.RuntimeException) != false) goto L_0x03ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03ca, code lost:
        com.google.android.gms.ads.internal.zzt.zzo().zzt(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03da, code lost:
        if (r8.zzh == false) goto L_0x03f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03dc, code lost:
        com.google.android.gms.ads.internal.util.zze.zzi("Preload aborted for URL \"" + r9 + com.didichuxing.bigdata.p174dp.locsdk.Const.jsQuote);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03f6, code lost:
        com.google.android.gms.ads.internal.util.zze.zzk("Preload failed for URL \"" + r9 + com.didichuxing.bigdata.p174dp.locsdk.Const.jsQuote, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x041b, code lost:
        com.google.android.gms.ads.internal.util.zze.zzj("Could not delete partial cache file at ".concat(java.lang.String.valueOf(r12.getAbsolutePath())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x042c, code lost:
        zzc(r9, r12.getAbsolutePath(), r15, r2);
        zze.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r1 = com.google.android.gms.internal.ads.zzfpu.zza().zzn(new com.google.android.gms.internal.ads.zzcld(r9), 265, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011d, code lost:
        if ((r1 instanceof java.net.HttpURLConnection) == false) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011f, code lost:
        r2 = r1.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0125, code lost:
        if (r2 >= 400) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0128, code lost:
        r15 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015d, code lost:
        throw new java.io.IOException("HTTP status code " + r2 + " at " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0161, code lost:
        r2 = "HTTP request failed. Code: " + java.lang.Integer.toString(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0163, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0166, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0167, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r7 = r1.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016e, code lost:
        if (r7 >= 0) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0170, code lost:
        com.google.android.gms.ads.internal.util.zze.zzj("Stream cache aborted, missing content-length header at " + r9);
        zzc(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0192, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0193, code lost:
        r2 = zzf.format((long) r7);
        r6 = ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzt)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01aa, code lost:
        if (r7 <= r6) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ac, code lost:
        com.google.android.gms.ads.internal.util.zze.zzj("Content length " + r2 + " exceeds limit at " + r9);
        r0 = new java.lang.StringBuilder();
        r0.append("File too big for full file cache. Size: ");
        r0.append(r2);
        zzc(r9, r12.getAbsolutePath(), "sizeExceeded", r0.toString());
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e7, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01e8, code lost:
        com.google.android.gms.ads.internal.util.zze.zze("Caching " + r2 + " bytes from " + r9);
        r5 = java.nio.channels.Channels.newChannel(r1.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r3 = r4.getChannel();
        r2 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzt.zzB();
        r17 = r16.currentTimeMillis();
        r1 = new com.google.android.gms.ads.internal.util.zzbz(((java.lang.Long) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzw)).longValue());
        r10 = ((java.lang.Long) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzv)).longValue();
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0249, code lost:
        r19 = r5.read(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x024d, code lost:
        if (r19 < 0) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x024f, code lost:
        r13 = r13 + r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0251, code lost:
        if (r13 > r6) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r2.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x025a, code lost:
        if (r3.write(r2) > 0) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x025c, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x026b, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r10)) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x026d, code lost:
        r19 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0271, code lost:
        if (r8.zzh != false) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0277, code lost:
        if (r1.zzb() == false) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0279, code lost:
        r20 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x027f, code lost:
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0283, code lost:
        r23 = r1;
        r1 = r1;
        r24 = r14;
        r14 = com.google.android.gms.internal.ads.zzcgi.zza;
        r25 = r3;
        r26 = r4;
        r4 = r20;
        r20 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzckv(r29, r30, r4, r13, r7, false);
        r14.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x0394 */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03a8 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r21 r24 r26 
      PHI: (r21v6 java.lang.String) = (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v16 java.lang.String), (r21v16 java.lang.String) binds: [B:128:0x0351, B:137:0x0394, B:138:?, B:135:0x0391, B:136:?, B:93:0x0281, B:96:0x029f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v10 java.lang.String), (r24v12 java.lang.String) binds: [B:128:0x0351, B:137:0x0394, B:138:?, B:135:0x0391, B:136:?, B:93:0x0281, B:96:0x029f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v7 java.io.FileOutputStream) = (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v15 java.io.FileOutputStream), (r26v18 java.io.FileOutputStream) binds: [B:128:0x0351, B:137:0x0394, B:138:?, B:135:0x0391, B:136:?, B:93:0x0281, B:96:0x029f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:96:0x029f] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(java.lang.String r30) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            java.io.File r0 = r8.zzg
            r10 = 0
            r11 = 0
            if (r0 == 0) goto L_0x043d
        L_0x000a:
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0010
            r3 = 0
            goto L_0x002c
        L_0x0010:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0017:
            if (r2 >= r1) goto L_0x002c
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x0029
            int r3 = r3 + 1
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x002c:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzs
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0090
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0043
            goto L_0x0085
        L_0x0043:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r11
            r4 = 0
        L_0x004f:
            if (r4 >= r1) goto L_0x006c
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0069
            long r12 = r6.lastModified()
            int r7 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0069
            r5 = r6
            r2 = r12
        L_0x0069:
            int r4 = r4 + 1
            goto L_0x004f
        L_0x006c:
            if (r5 == 0) goto L_0x0082
            boolean r0 = r5.delete()
            java.io.File r1 = r8.zzi(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0083
            boolean r1 = r1.delete()
            r0 = r0 & r1
            goto L_0x0083
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 != 0) goto L_0x000a
        L_0x0085:
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            java.lang.String r0 = "expireFailed"
            r8.zzc(r9, r11, r0, r11)
            return r10
        L_0x0090:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzcgi.zze(r30)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.zzg
            r12.<init>(r1, r0)
            java.io.File r0 = r8.zzi(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00c7
            boolean r1 = r0.isFile()
            if (r1 != 0) goto L_0x00ad
            goto L_0x00c7
        L_0x00ad:
            long r0 = r12.length()
            java.lang.String r2 = "Stream cache hit at "
            java.lang.String r3 = java.lang.String.valueOf(r30)
            java.lang.String r2 = r2.concat(r3)
            com.google.android.gms.ads.internal.util.zze.zze(r2)
            java.lang.String r2 = r12.getAbsolutePath()
            int r1 = (int) r0
            r8.zzd(r9, r2, r1)
            return r13
        L_0x00c7:
            java.io.File r1 = r8.zzg
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r30)
            java.lang.String r14 = r1.concat(r2)
            java.util.Set r1 = zze
            monitor-enter(r1)
            java.util.Set r2 = zze     // Catch:{ all -> 0x043a }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x043a }
            if (r2 == 0) goto L_0x0103
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x043a }
            r0.<init>()     // Catch:{ all -> 0x043a }
            java.lang.String r2 = "Stream cache already in progress at "
            r0.append(r2)     // Catch:{ all -> 0x043a }
            r0.append(r9)     // Catch:{ all -> 0x043a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x043a }
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ all -> 0x043a }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x043a }
            java.lang.String r2 = "inProgress"
            r8.zzc(r9, r0, r2, r11)     // Catch:{ all -> 0x043a }
            monitor-exit(r1)     // Catch:{ all -> 0x043a }
            return r10
        L_0x0103:
            java.util.Set r2 = zze     // Catch:{ all -> 0x043a }
            r2.add(r14)     // Catch:{ all -> 0x043a }
            monitor-exit(r1)     // Catch:{ all -> 0x043a }
            java.lang.String r15 = "error"
            com.google.android.gms.internal.ads.zzfpu r1 = com.google.android.gms.internal.ads.zzfpu.zza()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.internal.ads.zzcld r2 = new com.google.android.gms.internal.ads.zzcld     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r2.<init>(r9)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r3 = 265(0x109, float:3.71E-43)
            r4 = -1
            java.net.HttpURLConnection r1 = r1.zzn(r2, r3, r4)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            boolean r2 = r1 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            if (r2 == 0) goto L_0x016a
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r3 = 400(0x190, float:5.6E-43)
            if (r2 >= r3) goto L_0x0128
            goto L_0x016a
        L_0x0128:
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            r1.<init>()     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            java.lang.String r3 = "HTTP request failed. Code: "
            r1.append(r3)     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            r1.append(r0)     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0165, RuntimeException -> 0x0163 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            r3.<init>()     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            java.lang.String r4 = "HTTP status code "
            r3.append(r4)     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            r3.append(r2)     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            java.lang.String r2 = " at "
            r3.append(r2)     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            r3.append(r9)     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
            throw r0     // Catch:{ IOException -> 0x0160, RuntimeException -> 0x015e }
        L_0x015e:
            r0 = move-exception
            goto L_0x0161
        L_0x0160:
            r0 = move-exception
        L_0x0161:
            r2 = r1
            goto L_0x0167
        L_0x0163:
            r0 = move-exception
            goto L_0x0166
        L_0x0165:
            r0 = move-exception
        L_0x0166:
            r2 = r11
        L_0x0167:
            r1 = r14
            goto L_0x03c6
        L_0x016a:
            int r7 = r1.getContentLength()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            if (r7 >= 0) goto L_0x0193
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.<init>()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = "Stream cache aborted, missing content-length header at "
            r0.append(r1)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.append(r9)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = "contentLengthMissing"
            r8.zzc(r9, r0, r1, r11)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.remove(r14)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            return r10
        L_0x0193:
            java.text.DecimalFormat r2 = zzf     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            long r3 = (long) r7     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r2 = r2.format(r3)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzt     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            int r6 = r3.intValue()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            if (r7 <= r6) goto L_0x01e8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.<init>()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = "Content length "
            r0.append(r1)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.append(r2)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = " exceeds limit at "
            r0.append(r1)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.append(r9)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.<init>()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = "File too big for full file cache. Size: "
            r0.append(r1)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.append(r2)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r2 = "sizeExceeded"
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r8.zzc(r9, r1, r2, r0)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r0.remove(r14)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            return r10
        L_0x01e8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r3.<init>()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r4 = "Caching "
            r3.append(r4)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r3.append(r2)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r2 = " bytes from "
            r3.append(r2)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r3.append(r9)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            com.google.android.gms.ads.internal.util.zze.zze(r2)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            r4.<init>(r12)     // Catch:{ IOException -> 0x03be, RuntimeException -> 0x03bc }
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzw     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.internal.ads.zzbja r11 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            java.lang.Object r1 = r11.zzb(r1)     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            long r10 = r1.longValue()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.ads.internal.util.zzbz r1 = new com.google.android.gms.ads.internal.util.zzbz     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            r1.<init>(r10)     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.internal.ads.zzbiu r10 = com.google.android.gms.internal.ads.zzbjc.zzv     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            com.google.android.gms.internal.ads.zzbja r11 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            java.lang.Object r10 = r11.zzb(r10)     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            long r10 = r10.longValue()     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            r13 = 0
        L_0x0249:
            int r19 = r5.read(r2)     // Catch:{ IOException -> 0x03b0, RuntimeException -> 0x03ae }
            if (r19 < 0) goto L_0x034b
            int r13 = r13 + r19
            if (r13 > r6) goto L_0x0315
            r2.flip()     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
        L_0x0256:
            int r19 = r3.write(r2)     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            if (r19 > 0) goto L_0x0256
            r2.clear()     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            long r19 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            long r19 = r19 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r10
            int r23 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r23 > 0) goto L_0x02e1
            r19 = r2
            boolean r2 = r8.zzh     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            if (r2 != 0) goto L_0x02d1
            boolean r2 = r1.zzb()     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            if (r2 == 0) goto L_0x02ad
            java.lang.String r20 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            android.os.Handler r2 = com.google.android.gms.internal.ads.zzcgi.zza     // Catch:{ IOException -> 0x030d, RuntimeException -> 0x030b }
            r21 = r15
            com.google.android.gms.internal.ads.zzckv r15 = new com.google.android.gms.internal.ads.zzckv     // Catch:{ IOException -> 0x02a8, RuntimeException -> 0x02a6 }
            r22 = 0
            r23 = r1
            r1 = r15
            r24 = r14
            r14 = r2
            r2 = r29
            r25 = r3
            r3 = r30
            r26 = r4
            r4 = r20
            r20 = r5
            r5 = r13
            r27 = r6
            r6 = r7
            r28 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r14.post(r15)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            goto L_0x02bd
        L_0x02a6:
            r0 = move-exception
            goto L_0x02a9
        L_0x02a8:
            r0 = move-exception
        L_0x02a9:
            r26 = r4
            goto L_0x0312
        L_0x02ad:
            r23 = r1
            r25 = r3
            r26 = r4
            r20 = r5
            r27 = r6
            r28 = r7
            r24 = r14
            r21 = r15
        L_0x02bd:
            r2 = r19
            r5 = r20
            r15 = r21
            r1 = r23
            r14 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r7 = r28
            goto L_0x0249
        L_0x02d1:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            throw r0     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
        L_0x02e1:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r10)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            r1.<init>()     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r2 = "Timeout exceeded. Limit: "
            r1.append(r2)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            r1.append(r0)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r11 = r1.toString()     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
            throw r0     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
        L_0x030b:
            r0 = move-exception
            goto L_0x030e
        L_0x030d:
            r0 = move-exception
        L_0x030e:
            r26 = r4
            r21 = r15
        L_0x0312:
            r1 = r14
            goto L_0x03b6
        L_0x0315:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = java.lang.Integer.toString(r13)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            r1.<init>()     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r2 = "File too big for full file cache. Size: "
            r1.append(r2)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            r1.append(r0)     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.lang.String r11 = r1.toString()     // Catch:{ IOException -> 0x0346, RuntimeException -> 0x0344 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
            java.lang.String r1 = "stream cache file size limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
            throw r0     // Catch:{ IOException -> 0x033c, RuntimeException -> 0x033a }
        L_0x033a:
            r0 = move-exception
            goto L_0x033d
        L_0x033c:
            r0 = move-exception
        L_0x033d:
            r2 = r11
            r1 = r24
            r11 = r26
            goto L_0x03c6
        L_0x0344:
            r0 = move-exception
            goto L_0x0347
        L_0x0346:
            r0 = move-exception
        L_0x0347:
            r1 = r24
            goto L_0x03b8
        L_0x034b:
            r26 = r4
            r24 = r14
            r21 = r15
            r26.close()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r1 = 3
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzm(r1)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            if (r1 == 0) goto L_0x037e
            java.text.DecimalFormat r1 = zzf     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            long r2 = (long) r13     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r2.<init>()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.lang.String r3 = "Preloaded "
            r2.append(r3)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r2.append(r1)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.lang.String r1 = " bytes from "
            r2.append(r1)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r2.append(r9)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            com.google.android.gms.ads.internal.util.zze.zze(r1)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
        L_0x037e:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            if (r1 == 0) goto L_0x0391
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            goto L_0x0394
        L_0x0391:
            r0.createNewFile()     // Catch:{ IOException -> 0x0394, RuntimeException -> 0x03a8 }
        L_0x0394:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r8.zzd(r9, r0, r13)     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03aa, RuntimeException -> 0x03a8 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x03a6, RuntimeException -> 0x03a4 }
            r0 = 1
            return r0
        L_0x03a4:
            r0 = move-exception
            goto L_0x03b6
        L_0x03a6:
            r0 = move-exception
            goto L_0x03b6
        L_0x03a8:
            r0 = move-exception
            goto L_0x03ab
        L_0x03aa:
            r0 = move-exception
        L_0x03ab:
            r1 = r24
            goto L_0x03b6
        L_0x03ae:
            r0 = move-exception
            goto L_0x03b1
        L_0x03b0:
            r0 = move-exception
        L_0x03b1:
            r26 = r4
            r1 = r14
            r21 = r15
        L_0x03b6:
            r15 = r21
        L_0x03b8:
            r11 = r26
            r2 = 0
            goto L_0x03c6
        L_0x03bc:
            r0 = move-exception
            goto L_0x03bf
        L_0x03be:
            r0 = move-exception
        L_0x03bf:
            r1 = r14
            r21 = r15
            r15 = r21
            r2 = 0
            r11 = 0
        L_0x03c6:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x03d3
            com.google.android.gms.internal.ads.zzcfy r3 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zzt(r0, r4)
        L_0x03d3:
            r11.close()     // Catch:{ IOException | NullPointerException -> 0x03d7 }
            goto L_0x03d8
        L_0x03d7:
        L_0x03d8:
            boolean r3 = r8.zzh
            if (r3 == 0) goto L_0x03f6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Preload aborted for URL \""
            r0.append(r3)
            r0.append(r9)
            java.lang.String r3 = "\""
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            goto L_0x040f
        L_0x03f6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Preload failed for URL \""
            r3.append(r4)
            r3.append(r9)
            java.lang.String r4 = "\""
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.zze.zzk(r3, r0)
        L_0x040f:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x042c
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x042c
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r3 = r12.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = r0.concat(r3)
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
        L_0x042c:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzc(r9, r0, r15, r2)
            java.util.Set r0 = zze
            r0.remove(r1)
        L_0x0438:
            r1 = 0
            return r1
        L_0x043a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x043a }
            throw r0
        L_0x043d:
            java.lang.String r0 = "noCacheDir"
            r1 = 0
            r8.zzc(r9, r1, r0, r1)
            goto L_0x0438
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcle.zzq(java.lang.String):boolean");
    }
}
