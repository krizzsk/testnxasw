package com.didi.sdk.sidebar.configer;

import android.content.Context;

public class DidiPassSp {
    public static final String DIDI_PASS_DATA_GET_PROFILE = "didi_pass_data_get_profile";

    /* renamed from: a */
    private static SharedPrefercencesHelper f39937a = null;

    /* renamed from: b */
    private static final String f39938b = "didi_pass_data_sp";

    private DidiPassSp() {
    }

    public static SharedPrefercencesHelper getIns(Context context) {
        if (f39937a == null) {
            synchronized (DidiPassSp.class) {
                if (f39937a == null) {
                    f39937a = new SharedPrefercencesHelper(context, f39938b);
                }
            }
        }
        return f39937a;
    }
}
