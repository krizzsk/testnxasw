package com.didichuxing.dfbasesdk.logupload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.publicservice.p196db.base.BaseModel;
import java.util.ArrayList;
import java.util.List;

class LogDbHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final int f49244a = 1;

    /* renamed from: b */
    private static final String f49245b = "diface.db";

    /* renamed from: c */
    private static final String f49246c = "logs";

    /* renamed from: d */
    private static final String f49247d = "5";

    /* renamed from: e */
    private static final long f49248e = -1;

    /* renamed from: f */
    private static final String f49249f = "CREATE TABLE logs (_id INTEGER PRIMARY KEY,content TEXT NOT NULL,upStatus INTEGER DEFAULT 0,failCount INTEGER DEFAULT 0)";

    public static class LogColumns implements BaseColumns {
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_FAIL_COUNT = "failCount";
        public static final String COLUMN_NAME_UPLOAD_STATUS = "upStatus";
    }

    public LogDbHelper(Context context) {
        super(context, f49245b, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public LogDbHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f49249f);
        LogUtils.m37052d(LogRecord.LOG_TAG, "db onCreate");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        LogUtils.m37052d(LogRecord.LOG_TAG, "db onUpgrade");
    }

    /* renamed from: e */
    private SQLiteDatabase m36925e() {
        return m36923a(false);
    }

    /* renamed from: a */
    private SQLiteDatabase m36923a(boolean z) {
        SQLiteDatabase sQLiteDatabase;
        if (z) {
            try {
                sQLiteDatabase = getWritableDatabase();
            } catch (SQLiteException e) {
                LogUtils.logStackTrace(e);
                sQLiteDatabase = null;
            }
        } else {
            sQLiteDatabase = getReadableDatabase();
        }
        if (sQLiteDatabase == null) {
            LogUtils.m37053e("the diface.db cannot be opened!!!");
        }
        return sQLiteDatabase;
    }

    /* renamed from: a */
    public long mo122252a(String str) {
        SQLiteDatabase a = m36923a(true);
        if (a == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str);
        return a.insert(f49246c, (String) null, contentValues);
    }

    /* renamed from: b */
    public void mo122256b(String str) {
        SQLiteDatabase a = m36923a(true);
        if (a != null) {
            a.delete(f49246c, "_id = ?", new String[]{str});
        }
    }

    /* renamed from: a */
    public void mo122254a(List<String> list) {
        SQLiteDatabase a = m36923a(true);
        if (a != null) {
            a.delete(f49246c, "_id IN (" + TextUtils.join(",", list) + ")", (String[]) null);
        }
    }

    /* renamed from: a */
    public void mo122253a() {
        SQLiteDatabase a = m36923a(true);
        if (a != null) {
            a.execSQL("UPDATE logs SET upStatus = 1 WHERE upStatus = 0");
        }
    }

    /* renamed from: b */
    public void mo122257b(List<Object> list) {
        SQLiteDatabase a = m36923a(true);
        if (a != null) {
            a.execSQL("UPDATE logs SET upStatus = 1 WHERE _id IN (" + TextUtils.join(",", list) + ")");
        }
    }

    /* renamed from: c */
    public void mo122259c(List<String> list) {
        SQLiteDatabase a = m36923a(true);
        if (a != null) {
            a.execSQL("UPDATE logs SET upStatus = 0, failCount = failCount+1 WHERE _id IN (" + TextUtils.join(",", list) + ")");
        }
    }

    /* renamed from: b */
    public List<LogRecord> mo122255b() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase e = m36925e();
        if (e == null) {
            return arrayList;
        }
        Cursor rawQuery = e.rawQuery("select * from logs where upStatus =? order by _id ASC limit 15", new String[]{"0"});
        while (m36924a(rawQuery)) {
            long j = rawQuery.getLong(rawQuery.getColumnIndexOrThrow(ShareDBHelper.ID_NAME));
            String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("content"));
            long j2 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow("upStatus"));
            long j3 = rawQuery.getLong(rawQuery.getColumnIndexOrThrow("failCount"));
            LogUtils.m37052d(LogRecord.LOG_TAG, "fetch records, id=" + j + ", content=" + string + ", status=" + j2 + ", failCount=" + j3);
            arrayList.add(new LogRecord(String.valueOf(j), string, j2, j3));
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: a */
    private boolean m36924a(Cursor cursor) {
        try {
            return cursor.moveToNext();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            return false;
        }
    }

    /* renamed from: c */
    public List<LogRecord> mo122258c() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase e = m36925e();
        if (e == null) {
            return arrayList;
        }
        Cursor query = e.query(f49246c, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, BaseModel.DEFAULT_ORDER_SORT);
        while (m36924a(query)) {
            long j = query.getLong(query.getColumnIndexOrThrow(ShareDBHelper.ID_NAME));
            String string = query.getString(query.getColumnIndexOrThrow("content"));
            long j2 = query.getLong(query.getColumnIndexOrThrow("upStatus"));
            long j3 = query.getLong(query.getColumnIndexOrThrow("failCount"));
            LogUtils.m37052d(LogRecord.LOG_TAG, "fetch all logs, id=" + j + ", content=" + string + ", status=" + j2 + ", failCount=" + j3);
            arrayList.add(new LogRecord(String.valueOf(j), string, j2, j3));
        }
        query.close();
        return arrayList;
    }

    /* renamed from: d */
    public void mo122260d() {
        try {
            close();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }
}
