package com.didi.component.common.pininput.dialog;

public class ShowPinDialogInfo {
    public static final int LAYOUT_CUSTOM = 2;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_WITH_CLOSE = 1;

    /* renamed from: a */
    int f13514a;

    /* renamed from: b */
    int f13515b;

    /* renamed from: c */
    private String f13516c;

    /* renamed from: d */
    private String f13517d;

    /* renamed from: e */
    private String f13518e;

    /* renamed from: f */
    private boolean f13519f;

    public ShowPinDialogInfo(int i) {
        this.f13514a = i;
    }

    public int getDialogId() {
        return this.f13514a;
    }

    public void setDialogId(int i) {
        this.f13514a = i;
    }

    public String getPin() {
        return this.f13516c;
    }

    public void setPin(String str) {
        this.f13516c = str;
    }

    public String getTitle() {
        return this.f13517d;
    }

    public void setTitle(String str) {
        this.f13517d = str;
    }

    public String getButton() {
        return this.f13518e;
    }

    public void setButton(String str) {
        this.f13518e = str;
    }

    public ShowPinDialogInfo setCancelable(boolean z) {
        this.f13519f = z;
        return this;
    }

    public boolean isCancelable() {
        return this.f13519f;
    }
}
