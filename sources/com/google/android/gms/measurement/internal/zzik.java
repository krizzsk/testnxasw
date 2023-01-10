package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
final class zzik implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzim zze;

    zzik(zzim zzim, boolean z, Uri uri, String str, String str2) {
        this.zze = zzim;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2 A[SYNTHETIC, Splitter:B:31:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011b A[Catch:{ RuntimeException -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0123 A[Catch:{ RuntimeException -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0125 A[Catch:{ RuntimeException -> 0x01ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzim r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzin r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzin r6 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzlp r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r7 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzf()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzav     // Catch:{ RuntimeException -> 0x01ba }
            r9 = 0
            boolean r7 = r7.zzs(r9, r8)     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r8 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzf()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzaw     // Catch:{ RuntimeException -> 0x01ba }
            boolean r8 = r8.zzs(r9, r10)     // Catch:{ RuntimeException -> 0x01ba }
            boolean r10 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r11 = "Activity created with data 'referrer' without required params"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "_cis"
            java.lang.String r14 = "utm_source"
            java.lang.String r15 = "utm_campaign"
            java.lang.String r9 = "gclid"
            if (r10 == 0) goto L_0x0050
        L_0x004e:
            r1 = 0
            goto L_0x00ae
        L_0x0050:
            boolean r10 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
            boolean r10 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
            boolean r10 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
            boolean r10 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
            if (r7 == 0) goto L_0x007a
            java.lang.String r10 = "utm_id"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
            java.lang.String r10 = "dclid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01ba }
            if (r10 != 0) goto L_0x0095
        L_0x007a:
            if (r8 == 0) goto L_0x0087
            java.lang.String r8 = "srsltid"
            boolean r8 = r5.contains(r8)     // Catch:{ RuntimeException -> 0x01ba }
            if (r8 != 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r8 = 1
            goto L_0x0095
        L_0x0087:
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            r6.zza(r11)     // Catch:{ RuntimeException -> 0x01ba }
            goto L_0x004e
        L_0x0095:
            java.lang.String r10 = "https://google.com/search?"
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r1 = r10.concat(r1)     // Catch:{ RuntimeException -> 0x01ba }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ RuntimeException -> 0x01ba }
            android.os.Bundle r1 = r6.zzs(r1, r7, r8)     // Catch:{ RuntimeException -> 0x01ba }
            if (r1 == 0) goto L_0x00ae
            java.lang.String r6 = "referrer"
            r1.putString(r13, r6)     // Catch:{ RuntimeException -> 0x01ba }
        L_0x00ae:
            java.lang.String r6 = "_cmp"
            if (r0 == 0) goto L_0x011b
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r7 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzf()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzav     // Catch:{ RuntimeException -> 0x01ba }
            r10 = 0
            boolean r7 = r7.zzs(r10, r8)     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.internal.measurement.zznw.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r8 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzf()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzaw     // Catch:{ RuntimeException -> 0x01ba }
            r16 = r11
            r11 = 0
            boolean r8 = r8.zzs(r11, r10)     // Catch:{ RuntimeException -> 0x01ba }
            android.os.Bundle r0 = r0.zzs(r3, r7, r8)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 == 0) goto L_0x011d
            java.lang.String r3 = "intent"
            r0.putString(r13, r3)     // Catch:{ RuntimeException -> 0x01ba }
            boolean r3 = r0.containsKey(r9)     // Catch:{ RuntimeException -> 0x01ba }
            if (r3 != 0) goto L_0x010e
            if (r1 == 0) goto L_0x010e
            boolean r3 = r1.containsKey(r9)     // Catch:{ RuntimeException -> 0x01ba }
            if (r3 == 0) goto L_0x010e
            r3 = 1
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x01ba }
            r3 = 0
            java.lang.String r8 = r1.getString(r9)     // Catch:{ RuntimeException -> 0x01ba }
            r7[r3] = r8     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r3 = "_cer"
            java.lang.String r8 = "gclid=%s"
            java.lang.String r7 = java.lang.String.format(r8, r7)     // Catch:{ RuntimeException -> 0x01ba }
            r0.putString(r3, r7)     // Catch:{ RuntimeException -> 0x01ba }
        L_0x010e:
            com.google.android.gms.measurement.internal.zzin r3 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            r3.zzH(r4, r6, r0)     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r3 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzr r3 = r3.zzb     // Catch:{ RuntimeException -> 0x01ba }
            r3.zza(r4, r0)     // Catch:{ RuntimeException -> 0x01ba }
            goto L_0x011d
        L_0x011b:
            r16 = r11
        L_0x011d:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 == 0) goto L_0x0125
            goto L_0x01a7
        L_0x0125:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzZ     // Catch:{ RuntimeException -> 0x01ba }
            r7 = 0
            boolean r0 = r0.zzs(r7, r3)     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r3 = "_ldl"
            java.lang.String r7 = "auto"
            if (r0 == 0) goto L_0x0173
            if (r1 == 0) goto L_0x015a
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            r0.zzH(r4, r6, r1)     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x01ba }
            r0.zza(r4, r1)     // Catch:{ RuntimeException -> 0x01ba }
            goto L_0x016b
        L_0x015a:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            java.lang.String r1 = "Referrer does not contain valid parameters"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x01ba }
        L_0x016b:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            r1 = 1
            r4 = 0
            r0.zzY(r7, r3, r4, r1)     // Catch:{ RuntimeException -> 0x01ba }
            return
        L_0x0173:
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 == 0) goto L_0x01a8
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 != 0) goto L_0x019b
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 != 0) goto L_0x019b
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 != 0) goto L_0x019b
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 != 0) goto L_0x019b
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 == 0) goto L_0x01a8
        L_0x019b:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01ba }
            if (r0 != 0) goto L_0x01a7
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            r1 = 1
            r0.zzY(r7, r3, r5, r1)     // Catch:{ RuntimeException -> 0x01ba }
        L_0x01a7:
            return
        L_0x01a8:
            com.google.android.gms.measurement.internal.zzin r0 = r2.zza     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ RuntimeException -> 0x01ba }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x01ba }
            r1 = r16
            r0.zza(r1)     // Catch:{ RuntimeException -> 0x01ba }
            return
        L_0x01ba:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzin r1 = r2.zza
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzik.run():void");
    }
}
