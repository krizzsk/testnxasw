package com.didi.global.globalgenerickit.callback;

import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;

public class GGKBtnTextAndCallback {

    /* renamed from: a */
    private String f23963a;

    /* renamed from: b */
    private GGKOnAntiShakeClickListener f23964b;

    public GGKBtnTextAndCallback(String str, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        this.f23963a = str;
        this.f23964b = gGKOnAntiShakeClickListener;
    }

    public String getText() {
        return this.f23963a;
    }

    public GGKOnAntiShakeClickListener getListener() {
        return this.f23964b;
    }
}
