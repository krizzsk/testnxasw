package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.LocationPerformer;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IAsyncToggleCallback;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.ToggleResult;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.dmap.navigation.base.ctx.INaviOptionExt;
import java.util.HashMap;

public class GuideUtil {

    /* renamed from: a */
    private static final String f40337a = "didiguide";

    /* renamed from: b */
    private static final String f40338b = "NEED_GUIDE";

    /* renamed from: c */
    private static final String f40339c = "STARTED";

    /* renamed from: d */
    private static final String f40340d = "UPGRADE_USER";
    public static boolean deubg = false;

    /* renamed from: e */
    private static final String f40341e = "first_launched";

    /* renamed from: f */
    private static final String f40342f = "first_launch_time";

    /* renamed from: g */
    private static SharedPreferences f40343g;

    /* renamed from: h */
    private static SharedPreferences.Editor f40344h;
    public static boolean isGuideShowed;

    public interface ApolloFinishListener {
        void onFinish(boolean z);
    }

    public static String getMapType(int i) {
        if (i == 0) {
            return "wgs84";
        }
        if (i == 1) {
        }
        return "soso";
    }

    /* renamed from: a */
    private static void m30365a(Context context) {
        if (f40343g == null || f40344h == null) {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), f40337a, 0);
            f40343g = sharedPreferences;
            f40344h = sharedPreferences.edit();
        }
    }

    public static void getApolloSwitch(final ApolloFinishListener apolloFinishListener) {
        Apollo.getAsyncToggle("passenger_newuser", (HashMap<String, String>) null, 700, 300, new IAsyncToggleCallback() {
            public void onSuccess(ToggleResult toggleResult) {
                if (toggleResult.getErrorNo() == 1) {
                    SystemUtils.log(6, INaviOptionExt.KEY_GUIDE, "guide apollo timeout", (Throwable) null, "com.didi.sdk.util.GuideUtil$1", 60);
                    apolloFinishListener.onFinish(false);
                    return;
                }
                IToggle toggle = toggleResult.getToggle();
                if (!(toggle == null || !toggle.allow() || toggle.getExperiment() == null || toggle.getExperiment() == null)) {
                    int intValue = ((Integer) toggle.getExperiment().getParam("type", 0)).intValue();
                    SystemUtils.log(4, INaviOptionExt.KEY_GUIDE, "guide apollo type:" + intValue, (Throwable) null, "com.didi.sdk.util.GuideUtil$1", 72);
                    if (intValue == 1) {
                        apolloFinishListener.onFinish(true);
                        return;
                    }
                }
                apolloFinishListener.onFinish(false);
            }
        });
    }

    public static void init(Context context) {
        m30365a(context);
        if (!f40343g.getBoolean(f40339c, false)) {
            f40344h.putBoolean(f40340d, SystemUtils.getSharedPreferences(context, "business_id", 0).contains("id")).apply();
            f40344h.putBoolean(f40339c, true).apply();
        }
    }

    /* renamed from: b */
    private static boolean m30366b(Context context) {
        m30365a(context);
        return f40343g.getBoolean(f40340d, false);
    }

    public static boolean needGuide(Context context) {
        m30365a(context);
        if (!m30366b(context)) {
            return f40343g.getBoolean(f40338b, true);
        }
        setNeedGuide(context, false);
        return false;
    }

    public static void setNeedGuide(Context context, boolean z) {
        m30365a(context);
        f40344h.putBoolean(f40338b, z).apply();
    }

    public static boolean isFirstLaunchedApp(Context context) {
        m30365a(context);
        return f40343g.getBoolean(f40341e, true);
    }

    public static void setAppLaunchFirstTime(Context context, long j) {
        m30365a(context);
        f40344h.putLong(f40342f, j).apply();
    }

    public static long getAppLaunchFirstTime(Context context) {
        m30365a(context);
        return f40343g.getLong(f40342f, 0);
    }

    public static void cleanFirstLaunchApp(Context context) {
        m30365a(context);
        f40344h.putBoolean(f40341e, false).apply();
    }

    public static void startLocate(Context context) {
        LocationPerformer.getInstance().start(context.getApplicationContext());
    }

    public static DIDILocation getLocation() {
        return LocationPerformer.getInstance().getLastLocation();
    }
}
