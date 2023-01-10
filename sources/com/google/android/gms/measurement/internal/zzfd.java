package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzfd implements Runnable {
    final /* synthetic */ zzfe zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzfa zzd;
    private final String zze;
    private final Map zzf;

    public zzfd(zzfe zzfe, String str, URL url, byte[] bArr, Map map, zzfa zzfa) {
        this.zza = zzfe;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfa);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzfa;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f7 A[SYNTHETIC, Splitter:B:46:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0127 A[SYNTHETIC, Splitter:B:68:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0167 A[SYNTHETIC, Splitter:B:81:0x0167] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzfe r1 = r14.zza
            r1.zzay()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfe r3 = r14.zza     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            java.net.URL r4 = r14.zzb     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            if (r5 == 0) goto L_0x0118
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r4.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzgi r5 = r3.zzs     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r5.zzf()     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r3.zzf()     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r3 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r3)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r4.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            r3 = 1
            r4.setDoInput(r3)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            java.util.Map r5 = r14.zzf     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            if (r5 == 0) goto L_0x005f
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
        L_0x0043:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r4.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            goto L_0x0043
        L_0x005f:
            byte[] r5 = r14.zzc     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            if (r5 == 0) goto L_0x00ac
            com.google.android.gms.measurement.internal.zzfe r5 = r14.zza     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzli r5 = r5.zzf     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzlk r5 = r5.zzu()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            byte[] r6 = r14.zzc     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            byte[] r5 = r5.zzy(r6)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzfe r6 = r14.zza     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzj()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            int r7 = r5.length     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.String r8 = "Uploading data. size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r6.zzb(r8, r9)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r4.setDoOutput(r3)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r3, r6)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r4.setFixedLengthStreamingMode(r7)     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r4.connect()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.io.OutputStream r3 = r4.getOutputStream()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            r3.write(r5)     // Catch:{ IOException -> 0x00a7, all -> 0x00a2 }
            r3.close()     // Catch:{ IOException -> 0x00a7, all -> 0x00a2 }
            goto L_0x00ac
        L_0x00a2:
            r5 = move-exception
            r12 = r2
            r2 = r3
            goto L_0x0124
        L_0x00a7:
            r5 = move-exception
            r12 = r2
            r2 = r3
            goto L_0x0163
        L_0x00ac:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x0114, all -> 0x0110 }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x010b, all -> 0x0107 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00f3 }
            r3.<init>()     // Catch:{ all -> 0x00f3 }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00f3 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00f1 }
        L_0x00c1:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00f1 }
            if (r7 <= 0) goto L_0x00cb
            r3.write(r6, r1, r7)     // Catch:{ all -> 0x00f1 }
            goto L_0x00c1
        L_0x00cb:
            byte[] r10 = r3.toByteArray()     // Catch:{ all -> 0x00f1 }
            if (r5 == 0) goto L_0x00d4
            r5.close()     // Catch:{ IOException -> 0x0100, all -> 0x00fb }
        L_0x00d4:
            if (r4 == 0) goto L_0x00d9
            r4.disconnect()
        L_0x00d9:
            com.google.android.gms.measurement.internal.zzfe r0 = r14.zza
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzfc r1 = new com.google.android.gms.measurement.internal.zzfc
            java.lang.String r6 = r14.zze
            com.google.android.gms.measurement.internal.zzfa r7 = r14.zzd
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x00ed:
            r0.zzp(r1)
            return
        L_0x00f1:
            r1 = move-exception
            goto L_0x00f5
        L_0x00f3:
            r1 = move-exception
            r5 = r2
        L_0x00f5:
            if (r5 == 0) goto L_0x00fa
            r5.close()     // Catch:{ IOException -> 0x0100, all -> 0x00fb }
        L_0x00fa:
            throw r1     // Catch:{ IOException -> 0x0100, all -> 0x00fb }
        L_0x00fb:
            r1 = move-exception
            r5 = r1
            r9 = r8
            r12 = r11
            goto L_0x0125
        L_0x0100:
            r1 = move-exception
            r5 = r1
            r10 = r5
            r9 = r8
            r12 = r11
            goto L_0x0165
        L_0x0107:
            r5 = move-exception
            r12 = r2
            r9 = r8
            goto L_0x0125
        L_0x010b:
            r5 = move-exception
            r12 = r2
            r10 = r5
            r9 = r8
            goto L_0x0165
        L_0x0110:
            r3 = move-exception
            r12 = r2
            r5 = r3
            goto L_0x0124
        L_0x0114:
            r3 = move-exception
            r12 = r2
            r10 = r3
            goto L_0x0164
        L_0x0118:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
            throw r3     // Catch:{ IOException -> 0x015f, all -> 0x0120 }
        L_0x0120:
            r3 = move-exception
            r5 = r3
            r4 = r2
            r12 = r4
        L_0x0124:
            r9 = 0
        L_0x0125:
            if (r2 == 0) goto L_0x0141
            r2.close()     // Catch:{ IOException -> 0x012b }
            goto L_0x0141
        L_0x012b:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfe r2 = r14.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()
            java.lang.String r3 = r14.zze
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)
            r2.zzc(r0, r3, r1)
        L_0x0141:
            if (r4 == 0) goto L_0x0146
            r4.disconnect()
        L_0x0146:
            com.google.android.gms.measurement.internal.zzfe r0 = r14.zza
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzfc r1 = new com.google.android.gms.measurement.internal.zzfc
            java.lang.String r7 = r14.zze
            com.google.android.gms.measurement.internal.zzfa r8 = r14.zzd
            r10 = 0
            r11 = 0
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r0.zzp(r1)
            throw r5
        L_0x015f:
            r3 = move-exception
            r5 = r3
            r4 = r2
            r12 = r4
        L_0x0163:
            r10 = r5
        L_0x0164:
            r9 = 0
        L_0x0165:
            if (r2 == 0) goto L_0x0181
            r2.close()     // Catch:{ IOException -> 0x016b }
            goto L_0x0181
        L_0x016b:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfe r2 = r14.zza
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()
            java.lang.String r3 = r14.zze
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)
            r2.zzc(r0, r3, r1)
        L_0x0181:
            if (r4 == 0) goto L_0x0186
            r4.disconnect()
        L_0x0186:
            com.google.android.gms.measurement.internal.zzfe r0 = r14.zza
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzfc r1 = new com.google.android.gms.measurement.internal.zzfc
            java.lang.String r7 = r14.zze
            com.google.android.gms.measurement.internal.zzfa r8 = r14.zzd
            r11 = 0
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x00ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfd.run():void");
    }
}
