package com.yanzhenjie.permission.checker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract;
import java.util.TimeZone;

/* renamed from: com.yanzhenjie.permission.checker.c */
/* compiled from: CalendarWriteTest */
class C21694c implements PermissionTest {

    /* renamed from: a */
    private static final String f58945a = "PERMISSION";

    /* renamed from: b */
    private static final String f58946b = "permission@gmail.com";

    /* renamed from: c */
    private ContentResolver f58947c;

    C21694c(Context context) {
        this.f58947c = context.getContentResolver();
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", f58945a);
            contentValues.put("account_name", f58946b);
            contentValues.put("account_type", "LOCAL");
            contentValues.put("calendar_displayName", f58945a);
            boolean z = true;
            contentValues.put("visible", 1);
            contentValues.put("calendar_color", -16776961);
            contentValues.put("calendar_access_level", 700);
            contentValues.put("sync_events", 1);
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("ownerAccount", f58945a);
            contentValues.put("canOrganizerRespond", 0);
            if (ContentUris.parseId(this.f58947c.insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", f58945a).appendQueryParameter("account_type", "LOCAL").build(), contentValues)) <= 0) {
                z = false;
            }
            return z;
        } finally {
            this.f58947c.delete(CalendarContract.Calendars.CONTENT_URI.buildUpon().build(), "account_name=?", new String[]{f58946b});
        }
    }
}
