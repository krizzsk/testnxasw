package com.didi.safetoolkit.util;

import android.content.Context;

public class SfContextHelper {

    /* renamed from: a */
    private static Context f37297a;

    public static void setContext(Context context) {
        f37297a = context.getApplicationContext();
    }

    public static Context getContext() {
        return f37297a;
    }
}
