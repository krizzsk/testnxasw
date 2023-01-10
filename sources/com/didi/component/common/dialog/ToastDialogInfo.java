package com.didi.component.common.dialog;

import android.graphics.drawable.Drawable;

public class ToastDialogInfo extends DialogInfo {

    /* renamed from: a */
    Drawable f13431a;

    /* renamed from: b */
    IconType f13432b;

    /* renamed from: c */
    String f13433c;

    public enum IconType {
        INFO,
        COMPLETE,
        ERROR
    }

    public ToastDialogInfo(int i) {
        super(i);
        setCancelable(false);
    }

    public void setIcon(IconType iconType) {
        this.f13432b = iconType;
    }

    public void setIcon(Drawable drawable) {
        this.f13431a = drawable;
    }

    public void setMessage(String str) {
        this.f13433c = str;
    }
}
