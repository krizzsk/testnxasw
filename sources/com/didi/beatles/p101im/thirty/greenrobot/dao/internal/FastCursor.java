package com.didi.beatles.p101im.thirty.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.FastCursor */
public final class FastCursor implements Cursor {

    /* renamed from: a */
    private final CursorWindow f11534a;

    /* renamed from: b */
    private int f11535b;

    /* renamed from: c */
    private final int f11536c;

    public Uri getNotificationUri() {
        return null;
    }

    public void setExtras(Bundle bundle) {
    }

    public FastCursor(CursorWindow cursorWindow) {
        this.f11534a = cursorWindow;
        this.f11536c = cursorWindow.getNumRows();
    }

    public int getCount() {
        return this.f11534a.getNumRows();
    }

    public int getPosition() {
        return this.f11535b;
    }

    public boolean move(int i) {
        return moveToPosition(this.f11535b + i);
    }

    public boolean moveToPosition(int i) {
        if (i < 0 || i >= this.f11536c) {
            return false;
        }
        this.f11535b = i;
        return true;
    }

    public boolean moveToFirst() {
        this.f11535b = 0;
        if (this.f11536c > 0) {
            return true;
        }
        return false;
    }

    public boolean moveToLast() {
        int i = this.f11536c;
        if (i <= 0) {
            return false;
        }
        this.f11535b = i - 1;
        return true;
    }

    public boolean moveToNext() {
        int i = this.f11535b;
        if (i >= this.f11536c - 1) {
            return false;
        }
        this.f11535b = i + 1;
        return true;
    }

    public boolean moveToPrevious() {
        int i = this.f11535b;
        if (i <= 0) {
            return false;
        }
        this.f11535b = i - 1;
        return true;
    }

    public boolean isFirst() {
        return this.f11535b == 0;
    }

    public boolean isLast() {
        return this.f11535b == this.f11536c - 1;
    }

    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public String getColumnName(int i) {
        throw new UnsupportedOperationException();
    }

    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    public byte[] getBlob(int i) {
        return this.f11534a.getBlob(this.f11535b, i);
    }

    public String getString(int i) {
        return this.f11534a.getString(this.f11535b, i);
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public short getShort(int i) {
        return this.f11534a.getShort(this.f11535b, i);
    }

    public int getInt(int i) {
        return this.f11534a.getInt(this.f11535b, i);
    }

    public long getLong(int i) {
        return this.f11534a.getLong(this.f11535b, i);
    }

    public float getFloat(int i) {
        return this.f11534a.getFloat(this.f11535b, i);
    }

    public double getDouble(int i) {
        return this.f11534a.getDouble(this.f11535b, i);
    }

    public boolean isNull(int i) {
        return this.f11534a.isNull(this.f11535b, i);
    }

    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public int getType(int i) {
        throw new UnsupportedOperationException();
    }
}
