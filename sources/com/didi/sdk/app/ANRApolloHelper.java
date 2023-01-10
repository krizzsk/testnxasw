package com.didi.sdk.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class ANRApolloHelper {

    /* renamed from: a */
    private static final String f37841a = "ANRApolloHelper";

    /* renamed from: b */
    private static final String f37842b = "global_passenger_init_anr";

    /* renamed from: c */
    private static final boolean f37843c = false;

    /* renamed from: d */
    private static final String f37844d = "anr_apollo_helper";

    /* renamed from: e */
    private static Boolean f37845e;

    public static boolean isOpen(Context context) {
        Boolean bool = f37845e;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m28505b(context).getBoolean("isOpen", false));
        f37845e = valueOf;
        return valueOf.booleanValue();
    }

    public static void addToggleStateChangeListener(Context context) {
        Apollo.addToggleStateChangeListener(new ANROnToggleStateChangeListener(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SharedPreferences m28505b(Context context) {
        return SystemUtils.getSharedPreferences(context, f37844d, 0);
    }

    private static class ANROnToggleStateChangeListener implements OnToggleStateChangeListener {
        private final Context mContext;

        public ANROnToggleStateChangeListener(Context context) {
            this.mContext = context;
        }

        public void onStateChanged() {
            boolean allow = Apollo.getToggle(ANRApolloHelper.f37842b, false).allow();
            SystemUtils.log(3, ANRApolloHelper.f37841a, "apollo HotPatch:" + allow, (Throwable) null, "com.didi.sdk.app.ANRApolloHelper$ANROnToggleStateChangeListener", 71);
            ANRApolloHelper.m28505b(this.mContext).edit().putBoolean("isOpen", allow).commit();
        }
    }
}
