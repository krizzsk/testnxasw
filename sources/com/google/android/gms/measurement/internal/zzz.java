package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
final class zzz extends zzkw {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzz(zzli zzli) {
        super(zzli);
    }

    private final zzt zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzt) this.zzc.get(num);
        }
        zzt zzt = new zzt(this, this.zza, (zzs) null);
        this.zzc.put(num, zzt);
        return zzt;
    }

    private final boolean zzf(int i, int i2) {
        zzt zzt = (zzt) this.zzc.get(Integer.valueOf(i));
        if (zzt == null) {
            return false;
        }
        return zzt.zze.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02e3, code lost:
        if (r5 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02e5, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ed, code lost:
        if (r5 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0312, code lost:
        if (r5 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0315, code lost:
        r1 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0321, code lost:
        if (r1.hasNext() == false) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0323, code lost:
        r4 = ((java.lang.Integer) r1.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgh) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x033d, code lost:
        if (r7 == null) goto L_0x03cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0343, code lost:
        if (r7.isEmpty() == false) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0347, code lost:
        r17 = r0;
        r0 = r10.zzf.zzu().zzq(r6.zzk(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x035b, code lost:
        if (r0.isEmpty() != false) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x035d, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzgg) r6.zzbB();
        r5.zze();
        r5.zzb(r0);
        r20 = r1;
        r0 = r10.zzf.zzu().zzq(r6.zzn(), r7);
        r5.zzf();
        r5.zzd(r0);
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0384, code lost:
        if (r0 >= r6.zza()) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0396, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zze(r0).zza())) == false) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0398, code lost:
        r5.zzg(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x039b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x039e, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03a3, code lost:
        if (r0 >= r6.zzc()) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b5, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzi(r0).zzb())) == false) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b7, code lost:
        r5.zzh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ba, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03bd, code lost:
        r3.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgh) r5.zzaE());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03cb, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03cf, code lost:
        r17 = r0;
        r20 = r1;
        r3.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03d6, code lost:
        r0 = r17;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x072c, code lost:
        if (r11 != null) goto L_0x072e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x072e, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0742, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0744, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0745, code lost:
        r29 = r2;
        r28 = r4;
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x074e, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0766, code lost:
        if (r11 != null) goto L_0x072e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x08fc, code lost:
        if (r13 != null) goto L_0x08fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x08fe, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0926, code lost:
        if (r13 == null) goto L_0x0929;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0a3a, code lost:
        if (r7.zzj() == false) goto L_0x0a45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0a3c, code lost:
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0a45, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x0a46, code lost:
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0153, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0177, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0742 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:249:0x068b] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0771  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0833  */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0931  */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x0a83  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0b17  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b6 A[Catch:{ SQLiteException -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c6 A[SYNTHETIC, Splitter:B:70:0x01c6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r66, java.util.List r67, java.util.List r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            r65 = this;
            r10 = r65
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r68)
            r0 = r66
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r69
            r10.zzd = r0
            r0 = r70
            r10.zze = r0
            java.util.Iterator r0 = r67.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzfs r1 = (com.google.android.gms.internal.measurement.zzfs) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            com.google.android.gms.internal.measurement.zzoi.zzc()
            com.google.android.gms.measurement.internal.zzgi r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzX
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzoi.zzc()
            com.google.android.gms.measurement.internal.zzgi r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzW
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x0180
            if (r14 == 0) goto L_0x0180
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015d, all -> 0x015b }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015d, all -> 0x015b }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015d, all -> 0x015b }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015d, all -> 0x015b }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 == 0) goto L_0x014d
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.internal.measurement.zzei r13 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzli r0 = com.google.android.gms.measurement.internal.zzlk.zzl(r13, r0)     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzaE()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012b }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0159 }
            if (r13 != 0) goto L_0x010c
            goto L_0x013d
        L_0x010c:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0159 }
            if (r16 != 0) goto L_0x0125
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0159 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0159 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x0127
        L_0x0125:
            r12 = r16
        L_0x0127:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x013d
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r12 = r2.zzs     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzey r12 = r12.zzaz()     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzew r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ SQLiteException -> 0x0159 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0159 }
        L_0x013d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 != 0) goto L_0x014a
            if (r5 == 0) goto L_0x0148
            r5.close()
        L_0x0148:
            r12 = r4
            goto L_0x0181
        L_0x014a:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014d:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0159 }
            if (r5 == 0) goto L_0x0180
        L_0x0153:
            r5.close()
            goto L_0x0180
        L_0x0157:
            r0 = move-exception
            goto L_0x017a
        L_0x0159:
            r0 = move-exception
            goto L_0x0162
        L_0x015b:
            r0 = move-exception
            goto L_0x015f
        L_0x015d:
            r0 = move-exception
            goto L_0x0161
        L_0x015f:
            r5 = 0
            goto L_0x017a
        L_0x0161:
            r5 = 0
        L_0x0162:
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x0157 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0157 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x0180
            goto L_0x0153
        L_0x017a:
            if (r5 == 0) goto L_0x017f
            r5.close()
        L_0x017f:
            throw r0
        L_0x0180:
            r12 = r0
        L_0x0181:
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0232, all -> 0x0230 }
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0232, all -> 0x0230 }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0232, all -> 0x0230 }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0232, all -> 0x0230 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x022a }
            if (r0 != 0) goto L_0x01c6
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x022a }
            if (r4 == 0) goto L_0x01bf
            r4.close()
        L_0x01bf:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0259
        L_0x01c6:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x022a }
            r5.<init>()     // Catch:{ SQLiteException -> 0x022a }
        L_0x01cb:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x022a }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x022a }
            com.google.android.gms.internal.measurement.zzgg r13 = com.google.android.gms.internal.measurement.zzgh.zzf()     // Catch:{ IOException -> 0x01f3 }
            com.google.android.gms.internal.measurement.zzli r0 = com.google.android.gms.measurement.internal.zzlk.zzl(r13, r0)     // Catch:{ IOException -> 0x01f3 }
            com.google.android.gms.internal.measurement.zzgg r0 = (com.google.android.gms.internal.measurement.zzgg) r0     // Catch:{ IOException -> 0x01f3 }
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzaE()     // Catch:{ IOException -> 0x01f3 }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01f3 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x022a }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x022a }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x0211
        L_0x01f3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r13 = r2.zzs     // Catch:{ SQLiteException -> 0x022a }
            com.google.android.gms.measurement.internal.zzey r13 = r13.zzaz()     // Catch:{ SQLiteException -> 0x022a }
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x022a }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ SQLiteException -> 0x0228 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0226 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0226 }
        L_0x0211:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0226 }
            if (r0 != 0) goto L_0x021f
            if (r4 == 0) goto L_0x021c
            r4.close()
        L_0x021c:
            r13 = r17
            goto L_0x0259
        L_0x021f:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01cb
        L_0x0226:
            r0 = move-exception
            goto L_0x023c
        L_0x0228:
            r0 = move-exception
            goto L_0x022d
        L_0x022a:
            r0 = move-exception
            r18 = r6
        L_0x022d:
            r19 = r7
            goto L_0x023c
        L_0x0230:
            r0 = move-exception
            goto L_0x0238
        L_0x0232:
            r0 = move-exception
            r18 = r6
            r19 = r7
            goto L_0x023b
        L_0x0238:
            r5 = 0
            goto L_0x0b15
        L_0x023b:
            r4 = 0
        L_0x023c:
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ all -> 0x0b13 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0b13 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0b13 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x0b13 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b13 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b13 }
            if (r4 == 0) goto L_0x0258
            r4.close()
        L_0x0258:
            r13 = r0
        L_0x0259:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x026a
        L_0x0260:
            r12 = r8
            r30 = r9
            r28 = r18
            r29 = r19
            r13 = 0
            goto L_0x0597
        L_0x026a:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x03e4
            java.lang.String r1 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x028a
            goto L_0x03dc
        L_0x028a:
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r4 = r0.zzi()
            r4.zzW()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r4.zzh()
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02f9, all -> 0x02f5 }
            r16 = 0
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f9, all -> 0x02f5 }
            r16 = 1
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f9, all -> 0x02f5 }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02f9, all -> 0x02f5 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02f3 }
            if (r6 == 0) goto L_0x02e9
        L_0x02b8:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02f3 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02f3 }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02f3 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02f3 }
            if (r7 != 0) goto L_0x02d1
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02f3 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02f3 }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02f3 }
        L_0x02d1:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02f3 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02f3 }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02f3 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02f3 }
            if (r6 != 0) goto L_0x02b8
            if (r5 == 0) goto L_0x0315
        L_0x02e5:
            r5.close()
            goto L_0x0315
        L_0x02e9:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02f3 }
            if (r5 == 0) goto L_0x0315
            goto L_0x02e5
        L_0x02f0:
            r0 = move-exception
            goto L_0x03de
        L_0x02f3:
            r0 = move-exception
            goto L_0x02fb
        L_0x02f5:
            r0 = move-exception
            r5 = 0
            goto L_0x03de
        L_0x02f9:
            r0 = move-exception
            r5 = 0
        L_0x02fb:
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x02f0 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ all -> 0x02f0 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x02f0 }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzey.zzn(r1)     // Catch:{ all -> 0x02f0 }
            r4.zzc(r6, r1, r0)     // Catch:{ all -> 0x02f0 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02f0 }
            if (r5 == 0) goto L_0x0315
            goto L_0x02e5
        L_0x0315:
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x031d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x03dc
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgh r6 = (com.google.android.gms.internal.measurement.zzgh) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x03cf
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0347
            goto L_0x03cf
        L_0x0347:
            com.google.android.gms.measurement.internal.zzli r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlk r5 = r5.zzu()
            r17 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x03cb
            com.google.android.gms.internal.measurement.zzjy r5 = r6.zzbB()
            com.google.android.gms.internal.measurement.zzgg r5 = (com.google.android.gms.internal.measurement.zzgg) r5
            r5.zze()
            r5.zzb(r0)
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzlk r0 = r0.zzu()
            r20 = r1
            java.util.List r1 = r6.zzn()
            java.util.List r0 = r0.zzq(r1, r7)
            r5.zzf()
            r5.zzd(r0)
            r0 = 0
        L_0x0380:
            int r1 = r6.zza()
            if (r0 >= r1) goto L_0x039e
            com.google.android.gms.internal.measurement.zzfq r1 = r6.zze(r0)
            int r1 = r1.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x039b
            r5.zzg(r0)
        L_0x039b:
            int r0 = r0 + 1
            goto L_0x0380
        L_0x039e:
            r0 = 0
        L_0x039f:
            int r1 = r6.zzc()
            if (r0 >= r1) goto L_0x03bd
            com.google.android.gms.internal.measurement.zzgj r1 = r6.zzi(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x03ba
            r5.zzh(r0)
        L_0x03ba:
            int r0 = r0 + 1
            goto L_0x039f
        L_0x03bd:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzkc r1 = r5.zzaE()
            com.google.android.gms.internal.measurement.zzgh r1 = (com.google.android.gms.internal.measurement.zzgh) r1
            r3.put(r0, r1)
            goto L_0x03d6
        L_0x03cb:
            r0 = r17
            goto L_0x031d
        L_0x03cf:
            r17 = r0
            r20 = r1
            r3.put(r5, r6)
        L_0x03d6:
            r0 = r17
            r1 = r20
            goto L_0x031d
        L_0x03dc:
            r0 = r3
            goto L_0x03e5
        L_0x03de:
            if (r5 == 0) goto L_0x03e3
            r5.close()
        L_0x03e3:
            throw r0
        L_0x03e4:
            r0 = r13
        L_0x03e5:
            java.util.Iterator r17 = r2.iterator()
        L_0x03e9:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0260
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r20 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgh r1 = (com.google.android.gms.internal.measurement.zzgh) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0451
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x041b
            goto L_0x0451
        L_0x041b:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x0423:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0451
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfq r3 = (com.google.android.gms.internal.measurement.zzfq) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x0423
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r21 = r3.zzg()
            if (r21 == 0) goto L_0x044c
            long r21 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r21)
            goto L_0x044d
        L_0x044c:
            r3 = 0
        L_0x044d:
            r7.put(r4, r3)
            goto L_0x0423
        L_0x0451:
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            if (r1 == 0) goto L_0x04a1
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x045f
            goto L_0x04a1
        L_0x045f:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x0467:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04a1
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgj r3 = (com.google.android.gms.internal.measurement.zzgj) r3
            boolean r21 = r3.zzi()
            if (r21 == 0) goto L_0x0467
            int r21 = r3.zza()
            if (r21 <= 0) goto L_0x0467
            int r21 = r3.zzb()
            r22 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            int r21 = r3.zza()
            r23 = r2
            int r2 = r21 + -1
            long r2 = r3.zzc(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r0, r2)
            r0 = r22
            r2 = r23
            goto L_0x0467
        L_0x04a1:
            r22 = r0
            if (r1 == 0) goto L_0x04f6
            r0 = 0
        L_0x04a6:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x04f6
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzlk.zzv(r2, r0)
            if (r2 == 0) goto L_0x04e4
            com.google.android.gms.measurement.internal.zzgi r2 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            r21 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r23 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r8)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzlk.zzv(r2, r0)
            if (r2 == 0) goto L_0x04e8
            r5.set(r0)
            goto L_0x04ef
        L_0x04e4:
            r21 = r8
            r23 = r9
        L_0x04e8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x04ef:
            int r0 = r0 + 1
            r8 = r21
            r9 = r23
            goto L_0x04a6
        L_0x04f6:
            r21 = r8
            r23 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r13.get(r0)
            r8 = r1
            com.google.android.gms.internal.measurement.zzgh r8 = (com.google.android.gms.internal.measurement.zzgh) r8
            if (r15 == 0) goto L_0x0565
            if (r14 == 0) goto L_0x0565
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0565
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x0565
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x051a
            goto L_0x0565
        L_0x051a:
            java.util.Iterator r0 = r0.iterator()
        L_0x051e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0565
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzej r1 = (com.google.android.gms.internal.measurement.zzej) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x0546
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x0546:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x0557
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x0557:
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x051e
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r4.put(r1, r2)
            goto L_0x051e
        L_0x0565:
            com.google.android.gms.measurement.internal.zzt r0 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r65
            r24 = r4
            r4 = r8
            r8 = 0
            r28 = r18
            r29 = r19
            r16 = r12
            r66 = r13
            r12 = r21
            r13 = r8
            r8 = r24
            r30 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r1.put(r2, r0)
            r13 = r66
            r8 = r12
            r12 = r16
            r0 = r22
            r9 = r30
            goto L_0x03e9
        L_0x0597:
            boolean r0 = r67.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05a3
        L_0x059f:
            r25 = r11
            goto L_0x0829
        L_0x05a3:
            com.google.android.gms.measurement.internal.zzv r2 = new com.google.android.gms.measurement.internal.zzv
            r2.<init>(r10, r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r67.iterator()
        L_0x05b1:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x059f
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzfs r5 = r2.zza(r5, r0)
            if (r5 == 0) goto L_0x0826
            com.google.android.gms.measurement.internal.zzli r6 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r6 = r6.zzi()
            java.lang.String r7 = r10.zza
            java.lang.String r8 = r5.zzh()
            java.lang.String r9 = r0.zzh()
            com.google.android.gms.measurement.internal.zzar r9 = r6.zzn(r7, r9)
            if (r9 != 0) goto L_0x061a
            com.google.android.gms.measurement.internal.zzgi r9 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzk()
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzey.zzn(r7)
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzj()
            java.lang.String r6 = r6.zzd(r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r9.zzc(r8, r14, r6)
            com.google.android.gms.measurement.internal.zzar r6 = new com.google.android.gms.measurement.internal.zzar
            r31 = r6
            java.lang.String r33 = r0.zzh()
            r34 = 1
            r36 = 1
            r38 = 1
            long r40 = r0.zzd()
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r32 = r7
            r31.<init>(r32, r33, r34, r36, r38, r40, r42, r44, r45, r46, r47)
            goto L_0x064f
        L_0x061a:
            com.google.android.gms.measurement.internal.zzar r6 = new com.google.android.gms.measurement.internal.zzar
            r48 = r6
            java.lang.String r0 = r9.zza
            r49 = r0
            java.lang.String r0 = r9.zzb
            r50 = r0
            long r7 = r9.zzc
            r14 = 1
            long r51 = r7 + r14
            long r7 = r9.zzd
            long r53 = r7 + r14
            long r7 = r9.zze
            long r55 = r7 + r14
            long r7 = r9.zzf
            r57 = r7
            long r7 = r9.zzg
            r59 = r7
            java.lang.Long r0 = r9.zzh
            r61 = r0
            java.lang.Long r0 = r9.zzi
            r62 = r0
            java.lang.Long r0 = r9.zzj
            r63 = r0
            java.lang.Boolean r0 = r9.zzk
            r64 = r0
            r48.<init>(r49, r50, r51, r53, r55, r57, r59, r61, r62, r63, r64)
        L_0x064f:
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r0 = r0.zzi()
            r0.zzE(r6)
            long r7 = r6.zzc
            java.lang.String r9 = r5.zzh()
            java.lang.Object r0 = r3.get(r9)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0775
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r14 = r0.zzi()
            java.lang.String r15 = r10.zza
            r14.zzW()
            r14.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r14.zzh()
            r24 = r2
            r67 = r4
            r4 = r28
            r2 = r29
            java.lang.String[] r18 = new java.lang.String[]{r4, r2}     // Catch:{ SQLiteException -> 0x0744, all -> 0x0742 }
            r25 = r11
            r11 = 2
            java.lang.String[] r0 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x073c, all -> 0x0742 }
            r17 = 0
            r0[r17] = r15     // Catch:{ SQLiteException -> 0x073c, all -> 0x0742 }
            r17 = 1
            r0[r17] = r9     // Catch:{ SQLiteException -> 0x073c, all -> 0x0742 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r11 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x073c, all -> 0x0742 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0734 }
            if (r0 == 0) goto L_0x0722
            r29 = r2
        L_0x06b4:
            r2 = 1
            byte[] r0 = r11.getBlob(r2)     // Catch:{ SQLiteException -> 0x0720 }
            com.google.android.gms.internal.measurement.zzei r2 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x06f1 }
            com.google.android.gms.internal.measurement.zzli r0 = com.google.android.gms.measurement.internal.zzlk.zzl(r2, r0)     // Catch:{ IOException -> 0x06f1 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x06f1 }
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzaE()     // Catch:{ IOException -> 0x06f1 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x06f1 }
            r2 = 0
            int r16 = r11.getInt(r2)     // Catch:{ SQLiteException -> 0x0720 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0720 }
            java.lang.Object r16 = r13.get(r2)     // Catch:{ SQLiteException -> 0x0720 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0720 }
            if (r16 != 0) goto L_0x06e5
            r28 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x071e }
            r4.<init>()     // Catch:{ SQLiteException -> 0x071e }
            r13.put(r2, r4)     // Catch:{ SQLiteException -> 0x071e }
            goto L_0x06e9
        L_0x06e5:
            r28 = r4
            r4 = r16
        L_0x06e9:
            r4.add(r0)     // Catch:{ SQLiteException -> 0x071e }
            r16 = r13
            r13 = r30
            goto L_0x0709
        L_0x06f1:
            r0 = move-exception
            r28 = r4
            com.google.android.gms.measurement.internal.zzgi r2 = r14.zzs     // Catch:{ SQLiteException -> 0x071e }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ SQLiteException -> 0x071e }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x071e }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r15)     // Catch:{ SQLiteException -> 0x071e }
            r16 = r13
            r13 = r30
            r2.zzc(r13, r4, r0)     // Catch:{ SQLiteException -> 0x0732 }
        L_0x0709:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0732 }
            if (r0 != 0) goto L_0x0717
            if (r11 == 0) goto L_0x0714
            r11.close()
        L_0x0714:
            r0 = r16
            goto L_0x0769
        L_0x0717:
            r30 = r13
            r13 = r16
            r4 = r28
            goto L_0x06b4
        L_0x071e:
            r0 = move-exception
            goto L_0x0739
        L_0x0720:
            r0 = move-exception
            goto L_0x0737
        L_0x0722:
            r29 = r2
            r28 = r4
            r13 = r30
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0732 }
            if (r11 == 0) goto L_0x0769
        L_0x072e:
            r11.close()
            goto L_0x0769
        L_0x0732:
            r0 = move-exception
            goto L_0x0751
        L_0x0734:
            r0 = move-exception
            r29 = r2
        L_0x0737:
            r28 = r4
        L_0x0739:
            r13 = r30
            goto L_0x0751
        L_0x073c:
            r0 = move-exception
            r29 = r2
            r28 = r4
            goto L_0x074b
        L_0x0742:
            r0 = move-exception
            goto L_0x074e
        L_0x0744:
            r0 = move-exception
            r29 = r2
            r28 = r4
            r25 = r11
        L_0x074b:
            r13 = r30
            goto L_0x0750
        L_0x074e:
            r5 = 0
            goto L_0x076f
        L_0x0750:
            r11 = 0
        L_0x0751:
            com.google.android.gms.measurement.internal.zzgi r2 = r14.zzs     // Catch:{ all -> 0x076d }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x076d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x076d }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r15)     // Catch:{ all -> 0x076d }
            r2.zzc(r12, r4, r0)     // Catch:{ all -> 0x076d }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x076d }
            if (r11 == 0) goto L_0x0769
            goto L_0x072e
        L_0x0769:
            r3.put(r9, r0)
            goto L_0x077d
        L_0x076d:
            r0 = move-exception
            r5 = r11
        L_0x076f:
            if (r5 == 0) goto L_0x0774
            r5.close()
        L_0x0774:
            throw r0
        L_0x0775:
            r24 = r2
            r67 = r4
            r25 = r11
            r13 = r30
        L_0x077d:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0785:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x081e
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.util.Set r9 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto L_0x07af
            com.google.android.gms.measurement.internal.zzgi r4 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzj()
            r4.zzb(r1, r11)
            goto L_0x0785
        L_0x07af:
            java.lang.Object r9 = r0.get(r11)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
            r11 = 1
        L_0x07ba:
            boolean r14 = r9.hasNext()
            if (r14 == 0) goto L_0x0809
            java.lang.Object r11 = r9.next()
            com.google.android.gms.internal.measurement.zzej r11 = (com.google.android.gms.internal.measurement.zzej) r11
            com.google.android.gms.measurement.internal.zzw r15 = new com.google.android.gms.measurement.internal.zzw
            java.lang.String r14 = r10.zza
            r15.<init>(r10, r14, r4, r11)
            java.lang.Long r14 = r10.zzd
            r22 = r0
            java.lang.Long r0 = r10.zze
            int r11 = r11.zzb()
            boolean r21 = r10.zzf(r4, r11)
            r11 = r14
            r14 = r15
            r23 = r2
            r2 = r15
            r15 = r11
            r16 = r0
            r17 = r5
            r18 = r7
            r20 = r6
            boolean r11 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r11 == 0) goto L_0x07ff
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.measurement.internal.zzt r0 = r10.zzd(r0)
            r0.zzc(r2)
            r0 = r22
            r2 = r23
            goto L_0x07ba
        L_0x07ff:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
            goto L_0x080d
        L_0x0809:
            r22 = r0
            r23 = r2
        L_0x080d:
            if (r11 != 0) goto L_0x0818
            java.util.Set r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
        L_0x0818:
            r0 = r22
            r2 = r23
            goto L_0x0785
        L_0x081e:
            r4 = r67
            r30 = r13
            r2 = r24
            r11 = r25
        L_0x0826:
            r13 = 0
            goto L_0x05b1
        L_0x0829:
            boolean r0 = r68.isEmpty()
            if (r0 == 0) goto L_0x0833
        L_0x082f:
            r11 = r28
            goto L_0x0a69
        L_0x0833:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r68.iterator()
        L_0x083c:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x082f
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgl r4 = (com.google.android.gms.internal.measurement.zzgl) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0935
            com.google.android.gms.measurement.internal.zzli r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x090a, all -> 0x0908 }
            r14 = 2
            java.lang.String[] r0 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x090a, all -> 0x0908 }
            r14 = 0
            r0[r14] = r7     // Catch:{ SQLiteException -> 0x090a, all -> 0x0908 }
            r14 = 1
            r0[r14] = r5     // Catch:{ SQLiteException -> 0x090a, all -> 0x0908 }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x090a, all -> 0x0908 }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0904 }
            if (r0 == 0) goto L_0x08f6
        L_0x0899:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x0904 }
            com.google.android.gms.internal.measurement.zzer r15 = com.google.android.gms.internal.measurement.zzes.zzc()     // Catch:{ IOException -> 0x08d0 }
            com.google.android.gms.internal.measurement.zzli r0 = com.google.android.gms.measurement.internal.zzlk.zzl(r15, r0)     // Catch:{ IOException -> 0x08d0 }
            com.google.android.gms.internal.measurement.zzer r0 = (com.google.android.gms.internal.measurement.zzer) r0     // Catch:{ IOException -> 0x08d0 }
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzaE()     // Catch:{ IOException -> 0x08d0 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x08d0 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x0904 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0904 }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x0904 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0904 }
            if (r16 != 0) goto L_0x08c8
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0904 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x0904 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x0904 }
            goto L_0x08ca
        L_0x08c8:
            r15 = r16
        L_0x08ca:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x0904 }
            r67 = r3
            goto L_0x08e6
        L_0x08d0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r14 = r6.zzs     // Catch:{ SQLiteException -> 0x0904 }
            com.google.android.gms.measurement.internal.zzey r14 = r14.zzaz()     // Catch:{ SQLiteException -> 0x0904 }
            com.google.android.gms.measurement.internal.zzew r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x0904 }
            java.lang.String r15 = "Failed to merge filter"
            r67 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ SQLiteException -> 0x0902 }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x0902 }
        L_0x08e6:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0902 }
            if (r0 != 0) goto L_0x08f3
            if (r13 == 0) goto L_0x08f1
            r13.close()
        L_0x08f1:
            r0 = r8
            goto L_0x0929
        L_0x08f3:
            r3 = r67
            goto L_0x0899
        L_0x08f6:
            r67 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0902 }
            if (r13 == 0) goto L_0x0929
        L_0x08fe:
            r13.close()
            goto L_0x0929
        L_0x0902:
            r0 = move-exception
            goto L_0x0911
        L_0x0904:
            r0 = move-exception
            r67 = r3
            goto L_0x0911
        L_0x0908:
            r0 = move-exception
            goto L_0x090e
        L_0x090a:
            r0 = move-exception
            r67 = r3
            goto L_0x0910
        L_0x090e:
            r5 = 0
            goto L_0x092f
        L_0x0910:
            r13 = 0
        L_0x0911:
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs     // Catch:{ all -> 0x092d }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x092d }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ all -> 0x092d }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ all -> 0x092d }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x092d }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x092d }
            if (r13 == 0) goto L_0x0929
            goto L_0x08fe
        L_0x0929:
            r2.put(r5, r0)
            goto L_0x093b
        L_0x092d:
            r0 = move-exception
            r5 = r13
        L_0x092f:
            if (r5 == 0) goto L_0x0934
            r5.close()
        L_0x0934:
            throw r0
        L_0x0935:
            r67 = r3
            r11 = r28
            r9 = r29
        L_0x093b:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0943:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a61
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x096e
            com.google.android.gms.measurement.internal.zzgi r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0a61
        L_0x096e:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x0979:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a50
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            com.google.android.gms.measurement.internal.zzgi r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()
            java.lang.String r8 = r8.zzq()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x09e3
            com.google.android.gms.measurement.internal.zzgi r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x09b3
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09b4
        L_0x09b3:
            r15 = 0
        L_0x09b4:
            com.google.android.gms.measurement.internal.zzgi r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzj()
            r68 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzgi r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzli r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzlk r8 = r8.zzu()
            java.lang.String r8 = r8.zzp(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x09e5
        L_0x09e3:
            r68 = r0
        L_0x09e5:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a26
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x09f4
            goto L_0x0a26
        L_0x09f4:
            com.google.android.gms.measurement.internal.zzy r0 = new com.google.android.gms.measurement.internal.zzy
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a1c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzt r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r68
            goto L_0x0979
        L_0x0a1c:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a52
        L_0x0a26:
            com.google.android.gms.measurement.internal.zzgi r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a45
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a46
        L_0x0a45:
            r7 = 0
        L_0x0a46:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a54
        L_0x0a50:
            r68 = r0
        L_0x0a52:
            if (r7 != 0) goto L_0x0a5d
        L_0x0a54:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0a5d:
            r0 = r68
            goto L_0x0943
        L_0x0a61:
            r3 = r67
            r29 = r9
            r28 = r11
            goto L_0x083c
        L_0x0a69:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a7d:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b12
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzt r3 = (com.google.android.gms.measurement.internal.zzt) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfo r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzli r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzal r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgh r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzby()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r25
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0af9 }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0af7 }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b0e
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs     // Catch:{ SQLiteException -> 0x0af7 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x0af7 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0af7 }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r5)     // Catch:{ SQLiteException -> 0x0af7 }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0af7 }
            goto L_0x0b0e
        L_0x0af7:
            r0 = move-exception
            goto L_0x0afb
        L_0x0af9:
            r0 = move-exception
            r9 = 0
        L_0x0afb:
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0b0e:
            r25 = r4
            goto L_0x0a7d
        L_0x0b12:
            return r1
        L_0x0b13:
            r0 = move-exception
            r5 = r4
        L_0x0b15:
            if (r5 == 0) goto L_0x0b1a
            r5.close()
        L_0x0b1a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzz.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
