package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import com.didi.security.uuid.share.ShareDBHelper;
import com.yanzhenjie.permission.checker.PermissionTest;

/* renamed from: com.yanzhenjie.permission.checker.d */
/* compiled from: CallLogReadTest */
class C21695d implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f58948a;

    C21695d(Context context) {
        this.f58948a = context.getContentResolver();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        Cursor query = this.f58948a.query(CallLog.Calls.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "number", "type"}, (String) null, (String[]) null, (String) null);
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
