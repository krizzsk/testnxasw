package com.didiglobal.privacysdk;

import com.taxis99.R;

public class GlobalPrivacyThemeOptions {

    /* renamed from: a */
    private int f53115a = -1;

    /* renamed from: b */
    private int f53116b = -16777216;

    /* renamed from: c */
    private int f53117c = R.drawable.global_privacy_img_back_normal;

    /* renamed from: d */
    private int f53118d = R.drawable.common_title_bar_btn_back_selector;

    /* renamed from: e */
    private boolean f53119e = false;

    /* renamed from: f */
    private boolean f53120f = true;

    /* renamed from: g */
    private boolean f53121g = false;

    /* renamed from: h */
    private int f53122h = -32959;

    public int getTitleBarBgColor() {
        return this.f53115a;
    }

    public GlobalPrivacyThemeOptions setTitleBarBgColor(int i) {
        this.f53115a = i;
        return this;
    }

    public int getTitleBarTitleColor() {
        return this.f53116b;
    }

    public GlobalPrivacyThemeOptions setTitleBarTitleColor(int i) {
        this.f53116b = i;
        return this;
    }

    public int getTitleBarLeftImgRes() {
        return this.f53117c;
    }

    public GlobalPrivacyThemeOptions setTitleBarLeftImgRes(int i) {
        this.f53117c = i;
        return this;
    }

    public int getTitleBarSmallLeftImgRes() {
        return this.f53118d;
    }

    public GlobalPrivacyThemeOptions setTitleBarSmallLeftImgRes(int i) {
        this.f53118d = i;
        return this;
    }

    public boolean isUseTitleBarSmallLeftImg() {
        return this.f53119e;
    }

    public GlobalPrivacyThemeOptions setUseTitleBarSmallLeftImg(boolean z) {
        this.f53119e = z;
        return this;
    }

    public boolean isTitleInCenter() {
        return this.f53120f;
    }

    public GlobalPrivacyThemeOptions setTitleInCenter(boolean z) {
        this.f53120f = z;
        return this;
    }

    public boolean isStatusBarBgLightning() {
        return this.f53121g;
    }

    public GlobalPrivacyThemeOptions setStatusBarBgLightning(boolean z) {
        this.f53121g = z;
        return this;
    }

    public int getSwitchColor() {
        return this.f53122h;
    }

    public GlobalPrivacyThemeOptions setSwitchColor(int i) {
        this.f53122h = i;
        return this;
    }
}
