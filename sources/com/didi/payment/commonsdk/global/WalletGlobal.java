package com.didi.payment.commonsdk.global;

import android.app.Application;

public class WalletGlobal {

    /* renamed from: a */
    private static Application f32625a;

    public static void init(Application application) {
        f32625a = application;
    }

    @Deprecated
    public static Application getAppContext() {
        return f32625a;
    }
}
