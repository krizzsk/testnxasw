package com.didi.dimina.container.secondparty.permission.checker;

import android.database.Cursor;

interface PermissionTest {
    /* renamed from: a */
    boolean mo60862a() throws Throwable;

    public static class CursorTest {
        public static void read(Cursor cursor) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int type = cursor.getType(0);
                if (type != 0 && type != 4) {
                    cursor.getString(0);
                }
            }
        }
    }
}
