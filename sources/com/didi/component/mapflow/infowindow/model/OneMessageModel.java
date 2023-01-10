package com.didi.component.mapflow.infowindow.model;

import android.text.SpannableString;

public class OneMessageModel extends CommonInfoWindowModel {

    /* renamed from: a */
    private String f16076a;

    /* renamed from: b */
    private SpannableString f16077b;

    /* renamed from: c */
    private boolean f16078c;

    /* renamed from: d */
    private int f16079d;

    public boolean isShowArrow() {
        return this.f16078c;
    }

    public void setShowArrow(boolean z) {
        this.f16078c = z;
    }

    public String getContent() {
        return this.f16076a;
    }

    public void setContent(String str) {
        this.f16076a = str;
    }

    public SpannableString getCustomContent() {
        return this.f16077b;
    }

    public void setCustomContent(SpannableString spannableString) {
        this.f16077b = spannableString;
    }

    public int getBgImageId() {
        return this.f16079d;
    }

    public void setBgImageId(int i) {
        this.f16079d = i;
    }
}
