package com.didi.hawaii.log;

import android.content.Context;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.hawaii.utils.StorageUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class LoggerInit {

    /* renamed from: a */
    private static final String f25728a = "hawaii_android_log_control";

    /* renamed from: b */
    private static final String f25729b = "nav_log";

    /* renamed from: c */
    private static final String f25730c = "bm_log";

    /* renamed from: d */
    private static final String f25731d = "binary_log";

    /* renamed from: e */
    private static final String f25732e = "jni_log";

    /* renamed from: f */
    private static final String f25733f = "19900000000";

    /* renamed from: g */
    private static final String f25734g = (StorageUtils.getSDRootPath() + "/.WL/");

    /* renamed from: h */
    private static DelOldLogHandler f25735h = new DelOldLogHandler();

    private LoggerInit() {
    }

    public static void initAll(Context context) {
        initAll(context, false);
    }

    public static void initAll(Context context, boolean z) {
        if (context != null) {
            StorageUtils.init(context);
            m20437a();
            if (ApolloHawaii.isDelOldLogFile()) {
                f25735h.startDelOldLog();
            }
            if (z) {
                setPhoneNumber(f25733f);
                setPath(f25734g);
            }
        }
    }

    /* renamed from: a */
    private static void m20437a() {
        int i;
        int i2;
        int i3;
        IToggle toggle = Apollo.getToggle(f25728a);
        int i4 = 4;
        if (toggle.allow()) {
            i4 = ((Integer) toggle.getExperiment().getParam(f25729b, 4)).intValue();
            i2 = ((Integer) toggle.getExperiment().getParam(f25730c, 4)).intValue();
            i = ((Integer) toggle.getExperiment().getParam(f25731d, 4)).intValue();
            i3 = ((Integer) toggle.getExperiment().getParam(f25732e, 4)).intValue();
        } else {
            i3 = 4;
            i2 = 4;
            i = 4;
        }
        HWLog.initControlLevel(i4, i2, i, i3);
    }

    public static void setPhoneNumber(String str) {
        C9701c.m20450a(str);
        C9699a.m20439a(str);
    }

    public static void setPath(String str) {
        C9701c.m20454b(str);
        C9699a.m20443b(str);
    }
}
