package com.didi.map.setting.common;

import android.graphics.drawable.Drawable;

public class MapSettingAppInfo {

    /* renamed from: a */
    private int f31377a = -1;
    public String activityName;
    public Drawable appIcon;
    public String appLabel;
    public boolean isInstalled = true;
    public String navType;
    public String pkgName;

    public void setWeight(int i) {
        this.f31377a = i;
    }

    public int getWeight() {
        int i = this.f31377a;
        if (i == -1) {
            return this.isInstalled ^ true ? 1 : 0;
        }
        return i;
    }
}
