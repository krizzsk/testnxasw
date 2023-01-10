package com.didi.sdk.logging.upload.persist;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.p008db.SupportSQLiteDatabase;

public abstract class UploadTaskDatabase extends RoomDatabase {

    /* renamed from: a */
    static final Migration f39407a = new Migration(2, 3) {
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE TaskRecord  ADD COLUMN startTimestamp INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE TaskRecord  ADD COLUMN endTimestamp INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* renamed from: b */
    private static UploadTaskDatabase f39408b;

    public abstract SliceRecordDao getFileRecordDao();

    public abstract TaskFileRecordDao getTaskFileRecordDao();

    public abstract TaskRecordDao getTaskRecordDao();

    public static UploadTaskDatabase initDatabase(Context context) {
        if (f39408b == null) {
            f39408b = Room.databaseBuilder(context.getApplicationContext(), UploadTaskDatabase.class, "log.db").addMigrations(f39407a).build();
        }
        return f39408b;
    }

    public static UploadTaskDatabase getDatabase() {
        return f39408b;
    }

    public static void onDestroy() {
        f39408b = null;
    }
}
