package com.didi.sdk.apm.instrumentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

class HookApolloHelper {

    /* renamed from: a */
    private static final String f37798a = "HookApolloHelper";

    /* renamed from: b */
    private static final String f37799b = "global_passenger_activity_mgr_hook";

    /* renamed from: c */
    private static final boolean f37800c = false;

    /* renamed from: d */
    private static final String f37801d = "apm_hook_apollo_helper";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Boolean f37802e;

    HookApolloHelper() {
    }

    /* renamed from: a */
    public static boolean m28490a(Context context) {
        Boolean bool = f37802e;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m28493d(context).getBoolean("isOpen", false));
        f37802e = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: b */
    public static void m28491b(Context context) {
        Apollo.addToggleStateChangeListener(new ANROnToggleStateChangeListener(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static SharedPreferences m28493d(Context context) {
        return context.getSharedPreferences(f37801d, 0);
    }

    private static class ANROnToggleStateChangeListener implements OnToggleStateChangeListener {
        private final Context mContext;

        public ANROnToggleStateChangeListener(Context context) {
            this.mContext = context;
        }

        public void onStateChanged() {
            boolean isOpen = RemoteConfiguration.isOpen(HookApolloHelper.f37799b, false);
            if (HookApolloHelper.f37802e == null || HookApolloHelper.f37802e.booleanValue() != isOpen) {
                Log.d(HookApolloHelper.f37798a, "apollo apm hook:" + isOpen);
                HookApolloHelper.m28493d(this.mContext).edit().putBoolean("isOpen", isOpen).commit();
            }
        }
    }
}
