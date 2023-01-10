package com.didi.beatles.p101im.thirty.greenrobot.dao.database;

import android.database.sqlite.SQLiteStatement;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.StandardDatabaseStatement */
public class StandardDatabaseStatement implements DatabaseStatement {

    /* renamed from: a */
    private final SQLiteStatement f11527a;

    public StandardDatabaseStatement(SQLiteStatement sQLiteStatement) {
        this.f11527a = sQLiteStatement;
    }

    public void execute() {
        this.f11527a.execute();
    }

    public long simpleQueryForLong() {
        return this.f11527a.simpleQueryForLong();
    }

    public void bindNull(int i) {
        this.f11527a.bindNull(i);
    }

    public long executeInsert() {
        return this.f11527a.executeInsert();
    }

    public void bindString(int i, String str) {
        this.f11527a.bindString(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        this.f11527a.bindBlob(i, bArr);
    }

    public void bindLong(int i, long j) {
        this.f11527a.bindLong(i, j);
    }

    public void clearBindings() {
        this.f11527a.clearBindings();
    }

    public void bindDouble(int i, double d) {
        this.f11527a.bindDouble(i, d);
    }

    public void close() {
        this.f11527a.close();
    }

    public Object getRawStatement() {
        return this.f11527a;
    }
}
