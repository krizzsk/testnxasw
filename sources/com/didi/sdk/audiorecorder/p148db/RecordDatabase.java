package com.didi.sdk.audiorecorder.p148db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.p008db.SupportSQLiteDatabase;

/* renamed from: com.didi.sdk.audiorecorder.db.RecordDatabase */
public abstract class RecordDatabase extends RoomDatabase {

    /* renamed from: a */
    static final int f38062a = 4;

    /* renamed from: b */
    private static final String f38063b = "audio_record_2";

    /* renamed from: c */
    private static final Migration f38064c = new Migration(1, 2) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE record_result ADD COLUMN signKey TEXT");
        }
    };

    /* renamed from: d */
    private static final Migration f38065d = new Migration(2, 3) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE record_result ADD COLUMN userId TEXT");
        }
    };

    /* renamed from: e */
    private static final Migration f38066e = new Migration(3, 4) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE record_result ADD COLUMN businessAlias TEXT");
        }
    };

    /* renamed from: f */
    private static RecordDatabase f38067f;

    public abstract RecordDao recordDao();

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.didi.sdk.audiorecorder.p148db.RecordDatabase getInstance(android.content.Context r5) {
        /*
            java.lang.Class<com.didi.sdk.audiorecorder.db.RecordDatabase> r0 = com.didi.sdk.audiorecorder.p148db.RecordDatabase.class
            monitor-enter(r0)
            com.didi.sdk.audiorecorder.db.RecordDatabase r1 = f38067f     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x003d
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x003d }
            java.lang.String r1 = "audio_record_2"
            androidx.room.RoomDatabase$Builder r5 = androidx.room.Room.databaseBuilder(r5, r0, r1)     // Catch:{ Exception -> 0x003d }
            r1 = 1
            androidx.room.migration.Migration[] r2 = new androidx.room.migration.Migration[r1]     // Catch:{ Exception -> 0x003d }
            androidx.room.migration.Migration r3 = f38064c     // Catch:{ Exception -> 0x003d }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x003d }
            androidx.room.RoomDatabase$Builder r5 = r5.addMigrations(r2)     // Catch:{ Exception -> 0x003d }
            androidx.room.migration.Migration[] r2 = new androidx.room.migration.Migration[r1]     // Catch:{ Exception -> 0x003d }
            androidx.room.migration.Migration r3 = f38065d     // Catch:{ Exception -> 0x003d }
            r2[r4] = r3     // Catch:{ Exception -> 0x003d }
            androidx.room.RoomDatabase$Builder r5 = r5.addMigrations(r2)     // Catch:{ Exception -> 0x003d }
            androidx.room.migration.Migration[] r1 = new androidx.room.migration.Migration[r1]     // Catch:{ Exception -> 0x003d }
            androidx.room.migration.Migration r2 = f38066e     // Catch:{ Exception -> 0x003d }
            r1[r4] = r2     // Catch:{ Exception -> 0x003d }
            androidx.room.RoomDatabase$Builder r5 = r5.addMigrations(r1)     // Catch:{ Exception -> 0x003d }
            androidx.room.RoomDatabase$Builder r5 = r5.allowMainThreadQueries()     // Catch:{ Exception -> 0x003d }
            androidx.room.RoomDatabase r5 = r5.build()     // Catch:{ Exception -> 0x003d }
            com.didi.sdk.audiorecorder.db.RecordDatabase r5 = (com.didi.sdk.audiorecorder.p148db.RecordDatabase) r5     // Catch:{ Exception -> 0x003d }
            f38067f = r5     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            com.didi.sdk.audiorecorder.db.RecordDatabase r5 = f38067f     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)
            return r5
        L_0x0041:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.p148db.RecordDatabase.getInstance(android.content.Context):com.didi.sdk.audiorecorder.db.RecordDatabase");
    }

    public static void switchToInMemory(Context context) {
        f38067f = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), RecordDatabase.class).build();
    }
}
