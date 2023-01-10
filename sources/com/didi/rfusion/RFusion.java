package com.didi.rfusion;

import android.app.Application;
import android.content.Context;
import com.didi.rfusion.config.RFFontDelegate;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFActivityManager;
import java.util.Locale;

public class RFusion {

    /* renamed from: a */
    private static Application f35947a;

    /* renamed from: b */
    private static RFusionConfig.IRFusionLogger f35948b;

    /* renamed from: c */
    private static RFusionConfig.IRFusionTracker f35949c;

    /* renamed from: d */
    private static Locale f35950d;

    /* renamed from: e */
    private static RFFontDelegate f35951e;

    public static void init(RFusionConfig rFusionConfig) {
        f35947a = rFusionConfig.getApplication();
        f35948b = rFusionConfig.getLogger();
        f35949c = rFusionConfig.getTracker();
        f35950d = rFusionConfig.getLocale();
        f35951e = rFusionConfig.getFontDelegate();
        if (f35947a != null) {
            RFActivityManager.getInstance().init(f35947a);
        }
    }

    public static void updateLocale(Locale locale) {
        f35950d = locale;
    }

    public static Context getContext() {
        return f35947a;
    }

    public static RFusionConfig.IRFusionLogger getLogger() {
        return f35948b;
    }

    public static RFusionConfig.IRFusionTracker getTracker() {
        return f35949c;
    }

    public static Locale getLocale() {
        return f35950d;
    }

    public static String getLanguage() {
        Locale locale = f35950d;
        if (locale != null) {
            return locale.getLanguage();
        }
        return null;
    }

    public static RFFontDelegate getFontDelegate() {
        return f35951e;
    }
}
