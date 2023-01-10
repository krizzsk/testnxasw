package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzakz implements zzajn {
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzaky zzc;
    private final int zzd;

    public zzakz(zzaky zzaky, int i) {
        this.zzc = zzaky;
        this.zzd = 5242880;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((255 & ((long) zzn(inputStream))) << 56);
    }

    static String zzh(zzakx zzakx) throws IOException {
        return new String(zzm(zzakx, zzf(zzakx)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzakx zzakx, long j) throws IOException {
        long zza2 = zzakx.zza();
        if (j >= 0 && j <= zza2) {
            int i = (int) j;
            if (((long) i) == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzakx).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + zza2);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzakw zzakw) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzakw.zza;
        } else {
            this.zzb += zzakw.zza - ((zzakw) this.zza.get(str)).zza;
        }
        this.zza.put(str, zzakw);
    }

    private final void zzp(String str) {
        zzakw zzakw = (zzakw) this.zza.remove(str);
        if (zzakw != null) {
            this.zzb -= zzakw.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    public final synchronized zzajm zza(String str) {
        zzakx zzakx;
        zzakw zzakw = (zzakw) this.zza.get(str);
        if (zzakw == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzakx = new zzakx(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            zzakw zza2 = zzakw.zza(zzakx);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzakp.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza2.zzb);
                zzp(str);
                zzakx.close();
                return null;
            }
            byte[] zzm = zzm(zzakx, zzakx.zza());
            zzajm zzajm = new zzajm();
            zzajm.zza = zzm;
            zzajm.zzb = zzakw.zzc;
            zzajm.zzc = zzakw.zzd;
            zzajm.zzd = zzakw.zze;
            zzajm.zze = zzakw.zzf;
            zzajm.zzf = zzakw.zzg;
            List<zzajv> list = zzakw.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzajv zzajv : list) {
                treeMap.put(zzajv.zza(), zzajv.zzb());
            }
            zzajm.zzg = treeMap;
            zzajm.zzh = Collections.unmodifiableList(zzakw.zzh);
            zzakx.close();
            return zzajm;
        } catch (IOException e) {
            zzakp.zza("%s: %s", zzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        } catch (Throwable th) {
            zzakx.close();
            throw th;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzaky r0 = r9.zzc     // Catch:{ all -> 0x0062 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x0062 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0062 }
            r2 = 0
            if (r1 != 0) goto L_0x0026
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0024
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0062 }
            r1[r2] = r0     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = "Unable to create cache dir %s"
            com.google.android.gms.internal.ads.zzakp.zzb(r0, r1)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return
        L_0x0024:
            monitor-exit(r9)
            return
        L_0x0026:
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r9)
            return
        L_0x002e:
            int r1 = r0.length     // Catch:{ all -> 0x0062 }
        L_0x002f:
            if (r2 >= r1) goto L_0x0060
            r3 = r0[r2]     // Catch:{ all -> 0x0062 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzakx r6 = new com.google.android.gms.internal.ads.zzakx     // Catch:{ IOException -> 0x005a }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005a }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005a }
            r8.<init>(r3)     // Catch:{ IOException -> 0x005a }
            r7.<init>(r8)     // Catch:{ IOException -> 0x005a }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.ads.zzakw r7 = com.google.android.gms.internal.ads.zzakw.zza(r6)     // Catch:{ all -> 0x0055 }
            r7.zza = r4     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r7.zzb     // Catch:{ all -> 0x0055 }
            r9.zzo(r4, r7)     // Catch:{ all -> 0x0055 }
            r6.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005d
        L_0x0055:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x005a }
            throw r4     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            r3.delete()     // Catch:{ all -> 0x0062 }
        L_0x005d:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0060:
            monitor-exit(r9)
            return
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakz.zzb():void");
    }

    public final synchronized void zzc(String str, boolean z) {
        zzajm zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzd(str, zza2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x016d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r16, com.google.android.gms.internal.ads.zzajm r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            monitor-enter(r15)
            long r3 = r1.zzb     // Catch:{ all -> 0x01a3 }
            byte[] r5 = r2.zza     // Catch:{ all -> 0x01a3 }
            int r5 = r5.length     // Catch:{ all -> 0x01a3 }
            int r6 = r1.zzd     // Catch:{ all -> 0x01a3 }
            long r7 = (long) r5
            long r3 = r3 + r7
            long r7 = (long) r6
            r9 = 1063675494(0x3f666666, float:0.9)
            int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0022
            float r3 = (float) r5
            float r4 = (float) r6
            float r4 = r4 * r9
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            monitor-exit(r15)
            return
        L_0x0022:
            java.io.File r3 = r15.zzg(r16)     // Catch:{ all -> 0x01a3 }
            r4 = 1
            r5 = 0
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x016d }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x016d }
            r7.<init>(r3)     // Catch:{ IOException -> 0x016d }
            r6.<init>(r7)     // Catch:{ IOException -> 0x016d }
            com.google.android.gms.internal.ads.zzakw r7 = new com.google.android.gms.internal.ads.zzakw     // Catch:{ IOException -> 0x016d }
            r7.<init>(r0, r2)     // Catch:{ IOException -> 0x016d }
            r8 = 538247942(0x20150306, float:1.2621791E-19)
            zzj(r6, r8)     // Catch:{ IOException -> 0x0149 }
            java.lang.String r8 = r7.zzb     // Catch:{ IOException -> 0x0149 }
            zzl(r6, r8)     // Catch:{ IOException -> 0x0149 }
            java.lang.String r8 = r7.zzc     // Catch:{ IOException -> 0x0149 }
            if (r8 != 0) goto L_0x0048
            java.lang.String r8 = ""
        L_0x0048:
            zzl(r6, r8)     // Catch:{ IOException -> 0x0149 }
            long r10 = r7.zzd     // Catch:{ IOException -> 0x0149 }
            zzk(r6, r10)     // Catch:{ IOException -> 0x0149 }
            long r10 = r7.zze     // Catch:{ IOException -> 0x0149 }
            zzk(r6, r10)     // Catch:{ IOException -> 0x0149 }
            long r10 = r7.zzf     // Catch:{ IOException -> 0x0149 }
            zzk(r6, r10)     // Catch:{ IOException -> 0x0149 }
            long r10 = r7.zzg     // Catch:{ IOException -> 0x0149 }
            zzk(r6, r10)     // Catch:{ IOException -> 0x0149 }
            java.util.List r8 = r7.zzh     // Catch:{ IOException -> 0x0149 }
            if (r8 == 0) goto L_0x0089
            int r10 = r8.size()     // Catch:{ IOException -> 0x0149 }
            zzj(r6, r10)     // Catch:{ IOException -> 0x0149 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0149 }
        L_0x006e:
            boolean r10 = r8.hasNext()     // Catch:{ IOException -> 0x0149 }
            if (r10 == 0) goto L_0x008c
            java.lang.Object r10 = r8.next()     // Catch:{ IOException -> 0x0149 }
            com.google.android.gms.internal.ads.zzajv r10 = (com.google.android.gms.internal.ads.zzajv) r10     // Catch:{ IOException -> 0x0149 }
            java.lang.String r11 = r10.zza()     // Catch:{ IOException -> 0x0149 }
            zzl(r6, r11)     // Catch:{ IOException -> 0x0149 }
            java.lang.String r10 = r10.zzb()     // Catch:{ IOException -> 0x0149 }
            zzl(r6, r10)     // Catch:{ IOException -> 0x0149 }
            goto L_0x006e
        L_0x0089:
            zzj(r6, r5)     // Catch:{ IOException -> 0x0149 }
        L_0x008c:
            r6.flush()     // Catch:{ IOException -> 0x0149 }
            byte[] r2 = r2.zza     // Catch:{ IOException -> 0x016d }
            r6.write(r2)     // Catch:{ IOException -> 0x016d }
            r6.close()     // Catch:{ IOException -> 0x016d }
            long r10 = r3.length()     // Catch:{ IOException -> 0x016d }
            r7.zza = r10     // Catch:{ IOException -> 0x016d }
            r15.zzo(r0, r7)     // Catch:{ IOException -> 0x016d }
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016d }
            int r0 = r1.zzd     // Catch:{ IOException -> 0x016d }
            long r10 = (long) r0     // Catch:{ IOException -> 0x016d }
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ab
            goto L_0x01a1
        L_0x00ab:
            boolean r0 = com.google.android.gms.internal.ads.zzakp.zzb     // Catch:{ IOException -> 0x016d }
            if (r0 == 0) goto L_0x00b6
            java.lang.String r0 = "Pruning old cache entries."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x016d }
            com.google.android.gms.internal.ads.zzakp.zzd(r0, r2)     // Catch:{ IOException -> 0x016d }
        L_0x00b6:
            long r6 = r1.zzb     // Catch:{ IOException -> 0x016d }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016d }
            java.util.Map r0 = r1.zza     // Catch:{ IOException -> 0x016d }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x016d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x016d }
            r2 = 0
        L_0x00c7:
            boolean r8 = r0.hasNext()     // Catch:{ IOException -> 0x016d }
            r12 = 2
            if (r8 == 0) goto L_0x011e
            java.lang.Object r8 = r0.next()     // Catch:{ IOException -> 0x016d }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x016d }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x016d }
            com.google.android.gms.internal.ads.zzakw r8 = (com.google.android.gms.internal.ads.zzakw) r8     // Catch:{ IOException -> 0x016d }
            java.lang.String r13 = r8.zzb     // Catch:{ IOException -> 0x016d }
            java.io.File r13 = r15.zzg(r13)     // Catch:{ IOException -> 0x016d }
            boolean r13 = r13.delete()     // Catch:{ IOException -> 0x016d }
            if (r13 == 0) goto L_0x00f0
            long r13 = r1.zzb     // Catch:{ IOException -> 0x016d }
            r16 = r10
            long r9 = r8.zza     // Catch:{ IOException -> 0x016d }
            long r13 = r13 - r9
            r1.zzb = r13     // Catch:{ IOException -> 0x016d }
            goto L_0x0103
        L_0x00f0:
            r16 = r10
            java.lang.String r9 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r10 = new java.lang.Object[r12]     // Catch:{ IOException -> 0x016d }
            java.lang.String r8 = r8.zzb     // Catch:{ IOException -> 0x016d }
            r10[r5] = r8     // Catch:{ IOException -> 0x016d }
            java.lang.String r8 = zzq(r8)     // Catch:{ IOException -> 0x016d }
            r10[r4] = r8     // Catch:{ IOException -> 0x016d }
            com.google.android.gms.internal.ads.zzakp.zza(r9, r10)     // Catch:{ IOException -> 0x016d }
        L_0x0103:
            r0.remove()     // Catch:{ IOException -> 0x016d }
            int r2 = r2 + 1
            long r8 = r1.zzb     // Catch:{ IOException -> 0x016d }
            float r8 = (float) r8     // Catch:{ IOException -> 0x016d }
            int r9 = r1.zzd     // Catch:{ IOException -> 0x016d }
            float r9 = (float) r9     // Catch:{ IOException -> 0x016d }
            r10 = 1063675494(0x3f666666, float:0.9)
            float r9 = r9 * r10
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0118
            goto L_0x0120
        L_0x0118:
            r10 = r16
            r9 = 1063675494(0x3f666666, float:0.9)
            goto L_0x00c7
        L_0x011e:
            r16 = r10
        L_0x0120:
            boolean r0 = com.google.android.gms.internal.ads.zzakp.zzb     // Catch:{ IOException -> 0x016d }
            if (r0 == 0) goto L_0x01a1
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x016d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x016d }
            r0[r5] = r2     // Catch:{ IOException -> 0x016d }
            long r8 = r1.zzb     // Catch:{ IOException -> 0x016d }
            long r8 = r8 - r6
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ IOException -> 0x016d }
            r0[r4] = r2     // Catch:{ IOException -> 0x016d }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x016d }
            long r6 = r6 - r16
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x016d }
            r0[r12] = r2     // Catch:{ IOException -> 0x016d }
            java.lang.String r2 = "pruned %d files, %d bytes, %d ms"
            com.google.android.gms.internal.ads.zzakp.zzd(r2, r0)     // Catch:{ IOException -> 0x016d }
            monitor-exit(r15)
            return
        L_0x0149:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016d }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x016d }
            r2[r5] = r0     // Catch:{ IOException -> 0x016d }
            java.lang.String r0 = "%s"
            com.google.android.gms.internal.ads.zzakp.zza(r0, r2)     // Catch:{ IOException -> 0x016d }
            r6.close()     // Catch:{ IOException -> 0x016d }
            java.lang.String r0 = "Failed to write header for %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x016d }
            java.lang.String r6 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x016d }
            r2[r5] = r6     // Catch:{ IOException -> 0x016d }
            com.google.android.gms.internal.ads.zzakp.zza(r0, r2)     // Catch:{ IOException -> 0x016d }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x016d }
            r0.<init>()     // Catch:{ IOException -> 0x016d }
            throw r0     // Catch:{ IOException -> 0x016d }
        L_0x016d:
            boolean r0 = r3.delete()     // Catch:{ all -> 0x01a3 }
            if (r0 != 0) goto L_0x0180
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01a3 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x01a3 }
            r0[r5] = r2     // Catch:{ all -> 0x01a3 }
            java.lang.String r2 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzakp.zza(r2, r0)     // Catch:{ all -> 0x01a3 }
        L_0x0180:
            com.google.android.gms.internal.ads.zzaky r0 = r1.zzc     // Catch:{ all -> 0x01a3 }
            java.io.File r0 = r0.zza()     // Catch:{ all -> 0x01a3 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x01a3 }
            if (r0 != 0) goto L_0x01a1
            java.lang.String r0 = "Re-initializing cache after external clearing."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x01a3 }
            com.google.android.gms.internal.ads.zzakp.zza(r0, r2)     // Catch:{ all -> 0x01a3 }
            java.util.Map r0 = r1.zza     // Catch:{ all -> 0x01a3 }
            r0.clear()     // Catch:{ all -> 0x01a3 }
            r2 = 0
            r1.zzb = r2     // Catch:{ all -> 0x01a3 }
            r15.zzb()     // Catch:{ all -> 0x01a3 }
            monitor-exit(r15)
            return
        L_0x01a1:
            monitor-exit(r15)
            return
        L_0x01a3:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakz.zzd(java.lang.String, com.google.android.gms.internal.ads.zzajm):void");
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzakp.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzakz(File file, int i) {
        this.zzc = new zzakv(this, file);
        this.zzd = 20971520;
    }
}
