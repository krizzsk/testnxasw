package com.didi.beatles.p101im.thirty.greenrobot.dao.database;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.database.DatabaseStatement */
public interface DatabaseStatement {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
