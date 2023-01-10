package utils;

import android.content.Context;

public final class ContextUtil {

    /* renamed from: a */
    private static Context f8833a;

    public static void initApplicationContext(Context context) {
        f8833a = context.getApplicationContext();
    }

    public static Context getApplicationContext() {
        return f8833a;
    }
}
