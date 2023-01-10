package com.didi.component.common.dialog;

public class ImageHintDialogInfo extends DialogInfo {
    public static final int IMAGE_HOLDER_99 = 1;
    public static final int IMAGE_HOLDER_DIDI = 0;

    /* renamed from: a */
    String f13400a;

    /* renamed from: b */
    String f13401b;

    /* renamed from: c */
    String f13402c;

    /* renamed from: d */
    String f13403d;

    /* renamed from: e */
    int f13404e = -1;

    public ImageHintDialogInfo(int i) {
        super(i);
    }

    public ImageHintDialogInfo setImageUrl(String str) {
        this.f13400a = str;
        return this;
    }

    public ImageHintDialogInfo setTitle(String str) {
        this.f13401b = str;
        return this;
    }

    public ImageHintDialogInfo setSubtitle(String str) {
        this.f13402c = str;
        return this;
    }

    public ImageHintDialogInfo setButton(String str) {
        this.f13403d = str;
        return this;
    }

    public void setImageHolder(int i) {
        this.f13404e = i;
    }
}
