package com.didi.travel.psnger;

import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

public class TravelSDK {
    public static final String ESTIMATE_SERVICE = "estimate";
    public static final String MATCH_INFO_SERVICE = "match_info";
    public static final String ORDER_SERVICE = "order";

    /* renamed from: a */
    private static boolean f46683a;

    /* renamed from: b */
    private static WeakReference<Context> f46684b;

    /* renamed from: c */
    private static ITravelParam f46685c;

    public static void init(Application application, ITravelParam iTravelParam) {
        if (application != null) {
            f46684b = new WeakReference<>(application.getApplicationContext());
            f46685c = iTravelParam;
            AppLifecycleManager.getInstance().mo116291a(application);
            return;
        }
        throw new IllegalArgumentException("context is null!");
    }

    public static Context appContext() {
        WeakReference<Context> weakReference = f46684b;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public static Object getService(String str) {
        return ServiceRegistry.m34836a(str);
    }

    public static Object getService(String str, String str2) {
        return ServiceRegistry.m34837a(str, str2);
    }

    public static void setDebug(boolean z) {
        f46683a = z;
    }

    public static boolean isDebug() {
        return f46683a;
    }

    public static ITravelParam travelParam() {
        return f46685c;
    }
}
