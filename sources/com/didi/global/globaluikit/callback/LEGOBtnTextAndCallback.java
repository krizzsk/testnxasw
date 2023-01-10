package com.didi.global.globaluikit.callback;

public class LEGOBtnTextAndCallback {

    /* renamed from: a */
    private String f24281a;

    /* renamed from: b */
    private LEGOOnAntiShakeClickListener f24282b;

    public LEGOBtnTextAndCallback(String str, LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener) {
        this.f24281a = str;
        this.f24282b = lEGOOnAntiShakeClickListener;
    }

    public LEGOBtnTextAndCallback() {
    }

    public String getText() {
        return this.f24281a;
    }

    public LEGOOnAntiShakeClickListener getListener() {
        return this.f24282b;
    }
}
