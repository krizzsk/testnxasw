package com.didi.beatles.p101im.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didi.beatles.im.utils.IMApolloConfigUtil */
public final class IMApolloConfigUtil {

    /* renamed from: a */
    private static final String f11582a = IMApolloConfigUtil.class.getSimpleName();

    /* renamed from: a */
    private static String m9982a() {
        return "IM_Global_Android_Config";
    }

    public static int getImageBaseCompressQuality() {
        int intValue = ((Integer) m9981a("compress_base_quality", 60)).intValue();
        IMLog.m10020d(f11582a, C4786I.m9980t("[getImageBaseCompressQuality] baseCompressQuality=", Integer.valueOf(intValue)));
        return intValue;
    }

    /* renamed from: a */
    private static <T> T m9981a(String str, T t) {
        IToggle toggle = Apollo.getToggle(m9982a());
        return toggle.allow() ? toggle.getExperiment().getParam(str, t) : t;
    }
}
