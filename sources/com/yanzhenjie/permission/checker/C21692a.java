package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract;
import android.text.TextUtils;
import com.datadog.android.log.LogAttributes;

/* renamed from: com.yanzhenjie.permission.checker.a */
/* compiled from: AddVoicemailTest */
class C21692a implements PermissionTest {

    /* renamed from: a */
    private ContentResolver f58943a;

    C21692a(Context context) {
        this.f58943a = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        try {
            Uri uri = VoicemailContract.Voicemails.CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put(LogAttributes.DATE, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("number", "1");
            contentValues.put("duration", 1);
            contentValues.put("source_package", "permission");
            contentValues.put("source_data", "permission");
            contentValues.put("is_read", 0);
            long parseId = ContentUris.parseId(this.f58943a.insert(uri, contentValues));
            if (this.f58943a.delete(uri, "_id=?", new String[]{Long.toString(parseId)}) > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            String message = e.getMessage();
            if (!TextUtils.isEmpty(message)) {
                return !message.toLowerCase().contains("add_voicemail");
            }
            return false;
        }
    }
}
