package com.didichuxing.dfbasesdk;

import android.content.Context;

public class AppContextHolder {

    /* renamed from: a */
    private static Context f49127a;

    public static void init(Context context) {
        f49127a = context.getApplicationContext();
    }

    public static Context getAppContext() {
        return f49127a;
    }
}
