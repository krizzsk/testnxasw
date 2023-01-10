package com.didi.map.base.bubble;

public class DynamicBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f26835a;

    /* renamed from: b */
    private boolean f26836b;

    /* renamed from: c */
    private boolean f26837c;

    public DynamicBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f26835a = str2;
    }

    public String getText() {
        return this.f26835a;
    }

    public boolean isShowIcon() {
        return this.f26836b;
    }

    public void setShowIcon(boolean z) {
        this.f26836b = z;
    }

    public boolean is2Dfullbrowser() {
        return this.f26837c;
    }

    public void set2Dfullbrowser(boolean z) {
        this.f26837c = z;
    }

    public String getResourcePaths() {
        return super.toString() + this.f26835a + "|";
    }
}
