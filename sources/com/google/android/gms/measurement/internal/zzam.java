package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzam {
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 == false) goto L_0x0041;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[Catch:{ all -> 0x00d2, SQLiteException -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[Catch:{ all -> 0x00d2, SQLiteException -> 0x00d7 }, LOOP:1: B:32:0x00a7->B:37:0x00b9, LOOP_START, PHI: r12 
      PHI: (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:31:0x00a5, B:37:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c2 A[Catch:{ all -> 0x00d2, SQLiteException -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(com.google.android.gms.measurement.internal.zzey r14, android.database.sqlite.SQLiteDatabase r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String[] r19) throws android.database.sqlite.SQLiteException {
        /*
            r9 = r15
            r10 = r16
            r11 = r19
            if (r14 == 0) goto L_0x00ea
            r12 = 0
            r13 = 0
            java.lang.String r0 = "name"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0031, all -> 0x002e }
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0031, all -> 0x002e }
            r5[r12] = r10     // Catch:{ SQLiteException -> 0x0031, all -> 0x002e }
            java.lang.String r2 = "SQLITE_MASTER"
            java.lang.String r4 = "name=?"
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r15
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0031, all -> 0x002e }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x002c }
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            if (r0 != 0) goto L_0x0046
            goto L_0x0041
        L_0x002c:
            r0 = move-exception
            goto L_0x0033
        L_0x002e:
            r0 = move-exception
            goto L_0x00e4
        L_0x0031:
            r0 = move-exception
            r1 = r13
        L_0x0033:
            com.google.android.gms.measurement.internal.zzew r2 = r14.zzk()     // Catch:{ all -> 0x00e2 }
            java.lang.String r3 = "Error querying for table"
            r2.zzc(r3, r10, r0)     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            r1 = r17
            r15.execSQL(r1)
        L_0x0046:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00d7 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d7 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r2 = "SELECT * FROM "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d7 }
            r1.append(r10)     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r2 = " LIMIT 0"
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x00d7 }
            android.database.Cursor r1 = r15.rawQuery(r1, r13)     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String[] r2 = r1.getColumnNames()     // Catch:{ all -> 0x00d2 }
            java.util.Collections.addAll(r0, r2)     // Catch:{ all -> 0x00d2 }
            r1.close()     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = r2.split(r1)     // Catch:{ SQLiteException -> 0x00d7 }
            int r2 = r1.length     // Catch:{ SQLiteException -> 0x00d7 }
            r3 = 0
        L_0x0079:
            if (r3 >= r2) goto L_0x00a5
            r4 = r1[r3]     // Catch:{ SQLiteException -> 0x00d7 }
            boolean r5 = r0.remove(r4)     // Catch:{ SQLiteException -> 0x00d7 }
            if (r5 == 0) goto L_0x0086
            int r3 = r3 + 1
            goto L_0x0079
        L_0x0086:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00d7 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r2 = "Table "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d7 }
            r1.append(r10)     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r2 = " is missing required column: "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x00d7 }
            r1.append(r4)     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x00d7 }
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x00d7 }
            throw r0     // Catch:{ SQLiteException -> 0x00d7 }
        L_0x00a5:
            if (r11 == 0) goto L_0x00bc
        L_0x00a7:
            int r1 = r11.length     // Catch:{ SQLiteException -> 0x00d7 }
            if (r12 >= r1) goto L_0x00bc
            r1 = r11[r12]     // Catch:{ SQLiteException -> 0x00d7 }
            boolean r1 = r0.remove(r1)     // Catch:{ SQLiteException -> 0x00d7 }
            if (r1 != 0) goto L_0x00b9
            int r1 = r12 + 1
            r1 = r11[r1]     // Catch:{ SQLiteException -> 0x00d7 }
            r15.execSQL(r1)     // Catch:{ SQLiteException -> 0x00d7 }
        L_0x00b9:
            int r12 = r12 + 2
            goto L_0x00a7
        L_0x00bc:
            boolean r1 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x00d7 }
            if (r1 != 0) goto L_0x00d1
            com.google.android.gms.measurement.internal.zzew r1 = r14.zzk()     // Catch:{ SQLiteException -> 0x00d7 }
            java.lang.String r2 = "Table has extra columns. table, columns"
            java.lang.String r3 = ", "
            java.lang.String r0 = android.text.TextUtils.join(r3, r0)     // Catch:{ SQLiteException -> 0x00d7 }
            r1.zzc(r2, r10, r0)     // Catch:{ SQLiteException -> 0x00d7 }
        L_0x00d1:
            return
        L_0x00d2:
            r0 = move-exception
            r1.close()     // Catch:{ SQLiteException -> 0x00d7 }
            throw r0     // Catch:{ SQLiteException -> 0x00d7 }
        L_0x00d7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzew r1 = r14.zzd()
            java.lang.String r2 = "Failed to verify columns on table that was just created"
            r1.zzb(r2, r10)
            throw r0
        L_0x00e2:
            r0 = move-exception
            r13 = r1
        L_0x00e4:
            if (r13 == 0) goto L_0x00e9
            r13.close()
        L_0x00e9:
            throw r0
        L_0x00ea:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Monitor must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zza(com.google.android.gms.measurement.internal.zzey, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void zzb(zzey zzey, SQLiteDatabase sQLiteDatabase) {
        if (zzey != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzey.zzk().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzey.zzk().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzey.zzk().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzey.zzk().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
