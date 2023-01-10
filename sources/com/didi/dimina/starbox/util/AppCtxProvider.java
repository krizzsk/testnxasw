package com.didi.dimina.starbox.util;

import android.content.Context;

public class AppCtxProvider {

    /* renamed from: a */
    private static Context f20023a;

    public static Context getApp() {
        Context context = f20023a;
        if (context != null) {
            return context;
        }
        try {
            Context context2 = (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, new Object[0]);
            f20023a = context2;
            return context2;
        } catch (Exception unused) {
            throw new IllegalStateException("context 获取失败ˆ");
        }
    }
}
