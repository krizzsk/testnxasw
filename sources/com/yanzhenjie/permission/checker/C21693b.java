package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.b */
/* compiled from: CalendarReadTest */
class C21693b implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f58944a;

    C21693b(Context context) {
        this.f58944a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        Cursor query = this.f58944a.query(CalendarContract.Calendars.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "name"}, (String) null, (String[]) null, (String) null);
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
