package com.didichuxing.diface.appeal;

import android.text.TextUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public class AppealCanceledEvent {

    /* renamed from: a */
    private String f49627a;

    public AppealCanceledEvent() {
    }

    public AppealCanceledEvent(String str) {
        this.f49627a = str;
    }

    public String getMsg() {
        if (TextUtils.isEmpty(this.f49627a)) {
            this.f49627a = ResUtils.getString(R.string.df_bi_failed_act_compare_failed_title);
        }
        return this.f49627a;
    }
}
