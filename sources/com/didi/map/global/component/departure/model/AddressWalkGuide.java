package com.didi.map.global.component.departure.model;

import android.text.TextUtils;

public class AddressWalkGuide {

    /* renamed from: a */
    private String f27443a;

    /* renamed from: b */
    private String f27444b;

    public String getGuidePhoto() {
        return this.f27443a;
    }

    public void setGuidePhoto(String str) {
        this.f27443a = str;
    }

    public String getGuidePhotoH5() {
        return this.f27444b;
    }

    public void setGuidePhotoH5(String str) {
        this.f27444b = str;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f27443a) && !TextUtils.isEmpty(this.f27444b);
    }

    public String toString() {
        return "AddressWalkGuide{guidePhoto='" + this.f27443a + '\'' + ", guidePhotoH5='" + this.f27444b + '\'' + '}';
    }
}
