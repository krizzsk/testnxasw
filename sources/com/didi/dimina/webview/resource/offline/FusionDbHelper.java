package com.didi.dimina.webview.resource.offline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FusionDbHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f20223a = "CREATE TABLE IF NOT EXISTS hybridmodules (_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_name TEXT UNIQUE,origin_url TEXT,download_url TEXT,version TEXT,md5 TEXT,state INTEGER,download_mode INTEGER);";

    /* renamed from: b */
    private static final String f20224b = "DROP TABLE IF EXISTS hybridmodules";

    /* renamed from: c */
    private static final String f20225c = "hybridmodules.db";

    /* renamed from: d */
    private static final int f20226d = 2;

    public FusionDbHelper(Context context) {
        super(context, f20225c, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f20223a);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(f20224b);
        onCreate(sQLiteDatabase);
    }
}
