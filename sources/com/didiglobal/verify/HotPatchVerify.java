package com.didiglobal.verify;

import android.app.Application;
import android.content.Context;

public class HotPatchVerify {

    /* renamed from: a */
    private static Context f54005a;

    public static void init(Application application) {
        if (application != null) {
            f54005a = application.getApplicationContext();
        }
    }
}
