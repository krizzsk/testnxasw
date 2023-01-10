package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog;
import com.datadog.android.log.LogAttributes;

/* renamed from: com.yanzhenjie.permission.checker.e */
/* compiled from: CallLogWriteTest */
class C21696e implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f58949a;

    C21696e(Context context) {
        this.f58949a = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        try {
            ContentValues contentValues = new ContentValues();
            boolean z = true;
            contentValues.put("type", 1);
            contentValues.put("number", "1");
            contentValues.put(LogAttributes.DATE, 20080808);
            contentValues.put("new", "0");
            if (ContentUris.parseId(this.f58949a.insert(CallLog.Calls.CONTENT_URI, contentValues)) <= 0) {
                z = false;
            }
            return z;
        } finally {
            this.f58949a.delete(CallLog.Calls.CONTENT_URI, "number=?", new String[]{"1"});
        }
    }
}
