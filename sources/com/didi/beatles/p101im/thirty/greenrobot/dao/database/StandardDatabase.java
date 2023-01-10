package com.didi.beatles.p101im.thirty.greenrobot.dao.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.StandardDatabase */
public class StandardDatabase implements Database {

    /* renamed from: a */
    private final SQLiteDatabase f11526a;

    public StandardDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f11526a = sQLiteDatabase;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return this.f11526a.rawQuery(str, strArr);
    }

    public void execSQL(String str) throws SQLException {
        this.f11526a.execSQL(str);
    }

    public void beginTransaction() {
        this.f11526a.beginTransaction();
    }

    public void endTransaction() {
        this.f11526a.endTransaction();
    }

    public boolean inTransaction() {
        return this.f11526a.inTransaction();
    }

    public void setTransactionSuccessful() {
        this.f11526a.setTransactionSuccessful();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        this.f11526a.execSQL(str, objArr);
    }

    public DatabaseStatement compileStatement(String str) {
        return new StandardDatabaseStatement(this.f11526a.compileStatement(str));
    }

    public boolean isDbLockedByCurrentThread() {
        return this.f11526a.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.f11526a.isOpen();
    }

    public void close() {
        this.f11526a.close();
    }

    public Object getRawDatabase() {
        return this.f11526a;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.f11526a;
    }

    public String getPath() {
        return this.f11526a.getPath();
    }
}
