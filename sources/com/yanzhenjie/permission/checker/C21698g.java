package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.g */
/* compiled from: ContactsReadTest */
class C21698g implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f58952a;

    C21698g(Context context) {
        this.f58952a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        Cursor query = this.f58952a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "data1"}, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return false;
        }
        try {
            PermissionTest.CursorTest.read(query);
            query.close();
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
