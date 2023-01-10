package com.didi.beatles.p101im.plugin.robot;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p101im.protocol.view.IMGuideConfig;
import com.didi.beatles.p101im.utils.IMLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotGuideHelper */
public class IMRobotGuideHelper {

    /* renamed from: a */
    private static final String f11320a = "IMRobotGuideHelper";

    /* renamed from: b */
    private static final String f11321b = "IM_Config_Robot_Enter_Show";

    /* renamed from: c */
    private static final String f11322c = "p_robot_pop_guide_1_";

    /* renamed from: d */
    private static final String f11323d = "p_robot_pop_guide_3_";

    /* renamed from: e */
    private static final boolean f11324e;

    /* renamed from: f */
    private static long f11325f = -1;

    static {
        IToggle toggle = Apollo.getToggle(f11321b);
        f11324e = toggle != null && toggle.allow();
        IMLog.m10024i(f11320a, "apollo robot config" + f11324e);
    }

    public static boolean enterShow() {
        return f11324e;
    }

    /* renamed from: a */
    private static String m9827a() {
        return f11324e ? f11322c : f11323d;
    }

    public static boolean canShowPop(Context context, long j, String str, IMBottomGuideConfig iMBottomGuideConfig) {
        String a = m9827a();
        IMPreference instance = IMPreference.getInstance(context);
        Set<String> setValue = instance.getSetValue(a + j, Collections.emptySet());
        if (TextUtils.equals(f11323d, a)) {
            if (setValue.contains(str) || iMBottomGuideConfig == null || setValue.size() >= iMBottomGuideConfig.count) {
                return false;
            }
            return true;
        } else if (setValue.contains(str) || setValue.size() >= 3) {
            return false;
        } else {
            return true;
        }
    }

    public static IMGuideConfig popShowConfig(Context context, IMBottomGuideConfig iMBottomGuideConfig) {
        if (f11324e) {
            return new IMGuideConfig("msg", context.getString(R.string.im_plugin_robot_guide_text_msg));
        }
        if (iMBottomGuideConfig != null) {
            return new IMGuideConfig("more", iMBottomGuideConfig.tip);
        }
        return null;
    }

    public static void onShowPop(Context context, long j, String str) {
        String a = m9827a();
        IMPreference instance = IMPreference.getInstance(context);
        Set setValue = instance.getSetValue(a + j, (Set<String>) null);
        if (setValue == null) {
            setValue = new HashSet();
        }
        setValue.add(str);
        IMPreference instance2 = IMPreference.getInstance(context);
        instance2.setSetValue(a + j, setValue);
    }

    public static boolean canFuncRedDot(Context context, long j, int i) {
        return IMPreference.getInstance(context).getPluginExtendActionRedDotShowedCount(j, i) < 1;
    }

    public static void onClickRedDot(Context context, long j, int i) {
        if (j != f11325f) {
            IMPreference.getInstance(context).savePluginExtendActionRedDotShowedCount(j, i, 1);
            f11325f = j;
        }
    }
}
