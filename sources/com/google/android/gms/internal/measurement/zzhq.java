package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhq implements zzif {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzhq(Context context) {
        this.zza = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:63|64) */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        throw r6;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0163 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza() {
        /*
            r17 = this;
            r1 = r17
            android.content.Context r0 = r1.zza
            int r2 = com.google.android.gms.internal.measurement.zzhy.zzc
            java.lang.String r2 = android.os.Build.TYPE
            java.lang.String r3 = android.os.Build.TAGS
            java.lang.String r4 = "eng"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x001b
            java.lang.String r4 = "userdebug"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x001b
            goto L_0x002c
        L_0x001b:
            java.lang.String r2 = "dev-keys"
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L_0x0032
            java.lang.String r2 = "test-keys"
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x002c
            goto L_0x0032
        L_0x002c:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()
            goto L_0x0172
        L_0x0032:
            boolean r2 = com.google.android.gms.internal.measurement.zzha.zza()
            if (r2 == 0) goto L_0x0042
            boolean r2 = r0.isDeviceProtectedStorage()
            if (r2 != 0) goto L_0x0042
            android.content.Context r0 = r0.createDeviceProtectedStorageContext()
        L_0x0042:
            android.os.StrictMode$ThreadPolicy r2 = android.os.StrictMode.allowThreadDiskReads()
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0173 }
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ RuntimeException -> 0x0067 }
            java.lang.String r5 = "phenotype_hermetic"
            java.io.File r0 = r0.getDir(r5, r3)     // Catch:{ RuntimeException -> 0x0067 }
            java.lang.String r5 = "overrides.txt"
            r4.<init>(r0, r5)     // Catch:{ RuntimeException -> 0x0067 }
            boolean r0 = r4.exists()     // Catch:{ all -> 0x0173 }
            if (r0 == 0) goto L_0x0062
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzd(r4)     // Catch:{ all -> 0x0173 }
            goto L_0x0079
        L_0x0062:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0173 }
            goto L_0x0079
        L_0x0067:
            r0 = move-exception
            r7 = r0
            java.lang.String r5 = "HermeticFileOverrides"
            java.lang.String r6 = "no data dir"
            r4 = 6
            java.lang.String r8 = "com.google.android.gms.internal.measurement.zzhq"
            r9 = 9
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0173 }
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0173 }
        L_0x0079:
            boolean r4 = r0.zzb()     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x016b
            java.lang.Object r0 = r0.zza()     // Catch:{ all -> 0x0173 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0173 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0164 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0164 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0164 }
            r6.<init>(r0)     // Catch:{ IOException -> 0x0164 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0164 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0164 }
            r5 = 1
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0146 }
            r6.<init>()     // Catch:{ all -> 0x0146 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0146 }
            r7.<init>()     // Catch:{ all -> 0x0146 }
        L_0x009f:
            java.lang.String r8 = r4.readLine()     // Catch:{ all -> 0x0146 }
            if (r8 == 0) goto L_0x0119
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x0146 }
            int r11 = r9.length     // Catch:{ all -> 0x0146 }
            if (r11 == r10) goto L_0x00cc
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r9.<init>()     // Catch:{ all -> 0x0146 }
            java.lang.String r10 = "Invalid: "
            r9.append(r10)     // Catch:{ all -> 0x0146 }
            r9.append(r8)     // Catch:{ all -> 0x0146 }
            java.lang.String r12 = "HermeticFileOverrides"
            java.lang.String r13 = r9.toString()     // Catch:{ all -> 0x0146 }
            r11 = 6
            r14 = 0
            java.lang.String r15 = "com.google.android.gms.internal.measurement.zzhq"
            r16 = 18
            com.didi.sdk.apm.SystemUtils.log(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0146 }
            goto L_0x009f
        L_0x00cc:
            r8 = r9[r3]     // Catch:{ all -> 0x0146 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r10.<init>(r8)     // Catch:{ all -> 0x0146 }
            r8 = r9[r5]     // Catch:{ all -> 0x0146 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r11.<init>(r8)     // Catch:{ all -> 0x0146 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0146 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x0146 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0146 }
            if (r12 != 0) goto L_0x0101
            r9 = r9[r11]     // Catch:{ all -> 0x0146 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0146 }
            r11.<init>(r9)     // Catch:{ all -> 0x0146 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0146 }
            int r9 = r12.length()     // Catch:{ all -> 0x0146 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00fe
            if (r12 != r11) goto L_0x0101
        L_0x00fe:
            r7.put(r11, r12)     // Catch:{ all -> 0x0146 }
        L_0x0101:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x0146 }
            if (r9 != 0) goto L_0x010f
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x0146 }
            r9.<init>()     // Catch:{ all -> 0x0146 }
            r6.put(r10, r9)     // Catch:{ all -> 0x0146 }
        L_0x010f:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x0146 }
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ all -> 0x0146 }
            r9.put(r8, r12)     // Catch:{ all -> 0x0146 }
            goto L_0x009f
        L_0x0119:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0146 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r7.<init>()     // Catch:{ all -> 0x0146 }
            java.lang.String r8 = "Parsed "
            r7.append(r8)     // Catch:{ all -> 0x0146 }
            r7.append(r0)     // Catch:{ all -> 0x0146 }
            java.lang.String r10 = "HermeticFileOverrides"
            java.lang.String r11 = r7.toString()     // Catch:{ all -> 0x0146 }
            r9 = 4
            r12 = 0
            java.lang.String r13 = "com.google.android.gms.internal.measurement.zzhq"
            r14 = 29
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.measurement.zzhg r0 = new com.google.android.gms.internal.measurement.zzhg     // Catch:{ all -> 0x0146 }
            r0.<init>(r6)     // Catch:{ all -> 0x0146 }
            r4.close()     // Catch:{ IOException -> 0x0164 }
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzd(r0)     // Catch:{ all -> 0x0173 }
            goto L_0x016f
        L_0x0146:
            r0 = move-exception
            r6 = r0
            r4.close()     // Catch:{ all -> 0x014c }
            goto L_0x0163
        L_0x014c:
            r0 = move-exception
            r4 = r0
            java.lang.Class[] r0 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0163 }
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            r0[r3] = r7     // Catch:{ Exception -> 0x0163 }
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            java.lang.String r8 = "addSuppressed"
            java.lang.reflect.Method r0 = r7.getDeclaredMethod(r8, r0)     // Catch:{ Exception -> 0x0163 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0163 }
            r5[r3] = r4     // Catch:{ Exception -> 0x0163 }
            r0.invoke(r6, r5)     // Catch:{ Exception -> 0x0163 }
        L_0x0163:
            throw r6     // Catch:{ IOException -> 0x0164 }
        L_0x0164:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0173 }
            r3.<init>(r0)     // Catch:{ all -> 0x0173 }
            throw r3     // Catch:{ all -> 0x0173 }
        L_0x016b:
            com.google.android.gms.internal.measurement.zzid r0 = com.google.android.gms.internal.measurement.zzid.zzc()     // Catch:{ all -> 0x0173 }
        L_0x016f:
            android.os.StrictMode.setThreadPolicy(r2)
        L_0x0172:
            return r0
        L_0x0173:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhq.zza():java.lang.Object");
    }
}
