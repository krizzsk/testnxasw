package com.didi.sdk.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DiPushApolloHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37923a = DiPushApolloHelper.class.getName();

    /* renamed from: b */
    private static final String f37924b = "brazil_push_verify_phone";

    /* renamed from: c */
    private static final boolean f37925c = true;

    /* renamed from: d */
    private static final String f37926d = "dipush_kick_by_phone";

    /* renamed from: e */
    private static final String f37927e = "isDipushOpen";

    /* renamed from: f */
    private static Boolean f37928f;

    public static boolean isNewPhoneFormatOpen(Context context) {
        Boolean bool = f37928f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m28576b(context).getBoolean(f37927e, true));
        f37928f = valueOf;
        return valueOf.booleanValue();
    }

    public static void addToggleStateChangeListener(Context context) {
        Apollo.addToggleStateChangeListener(new PushOnToggleStateChangeListener(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SharedPreferences m28576b(Context context) {
        return SystemUtils.getSharedPreferences(context, f37926d, 0);
    }

    private static class PushOnToggleStateChangeListener implements OnToggleStateChangeListener {
        private final Context mContext;

        public PushOnToggleStateChangeListener(Context context) {
            this.mContext = context;
        }

        public void onStateChanged() {
            boolean allow = Apollo.getToggle(DiPushApolloHelper.f37924b, true).allow();
            String a = DiPushApolloHelper.f37923a;
            SystemUtils.log(3, a, "apollo HotPatch:" + allow, (Throwable) null, "com.didi.sdk.app.DiPushApolloHelper$PushOnToggleStateChangeListener", 73);
            DiPushApolloHelper.m28576b(this.mContext).edit().putBoolean(DiPushApolloHelper.f37927e, allow).commit();
        }
    }
}
