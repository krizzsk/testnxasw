package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;

/* renamed from: com.yanzhenjie.permission.checker.h */
/* compiled from: ContactsWriteTest */
class C21699h implements PermissionTest {

    /* renamed from: a */
    private static final String f58953a = "PERMISSION";

    /* renamed from: b */
    private ContentResolver f58954b;

    C21699h(ContentResolver contentResolver) {
        this.f58954b = contentResolver;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        Cursor query = this.f58954b.query(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id"}, "mimetype=? and data1=?", new String[]{"vnd.android.cursor.item/name", f58953a}, (String) null);
        if (query == null) {
            return false;
        }
        if (query.moveToFirst()) {
            long j = query.getLong(0);
            query.close();
            return m44574a(j);
        }
        query.close();
        return m44575b();
    }

    /* renamed from: b */
    private boolean m44575b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id", Long.valueOf(ContentUris.parseId(this.f58954b.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues))));
        contentValues.put("data1", f58953a);
        contentValues.put("data2", f58953a);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        return ContentUris.parseId(this.f58954b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0;
    }

    /* renamed from: a */
    private void m44573a(long j, long j2) {
        this.f58954b.delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{Long.toString(j)});
        this.f58954b.delete(ContactsContract.Data.CONTENT_URI, "_id=?", new String[]{Long.toString(j2)});
    }

    /* renamed from: a */
    private boolean m44574a(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id", Long.valueOf(j));
        contentValues.put("data1", f58953a);
        contentValues.put("data2", f58953a);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        return ContentUris.parseId(this.f58954b.insert(ContactsContract.Data.CONTENT_URI, contentValues)) > 0;
    }
}
