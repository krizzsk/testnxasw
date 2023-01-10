package com.didi.sdk.envsetbase;

import android.app.Application;
import android.content.Context;
import com.didi.sdk.envsetbase.toolbase.IEnvAppDelegate;
import com.didi.sdk.envsetbase.util.EnvSpiUtil;
import java.util.List;

public class EnvApi {

    /* renamed from: a */
    private static List<IEnvAppDelegate> f38596a;

    /* renamed from: b */
    private static String f38597b;
    public static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }

    public static boolean isDebug() {
        Dev dev = (Dev) EnvSpiUtil.getComponent(Dev.class);
        if (dev != null) {
            return dev.isDebug();
        }
        return false;
    }

    public static void setOriginId(String str) {
        f38597b = str;
    }

    public static String getOriginId() {
        return f38597b;
    }

    public static void onApplicationCreate(Application application) {
        if (isDebug()) {
            for (IEnvAppDelegate onApplicationCreate : m29102a()) {
                onApplicationCreate.onApplicationCreate(application);
            }
        }
    }

    /* renamed from: a */
    private static List<IEnvAppDelegate> m29102a() {
        if (f38596a == null) {
            f38596a = EnvSpiUtil.getComponents(IEnvAppDelegate.class);
        }
        return f38596a;
    }
}
