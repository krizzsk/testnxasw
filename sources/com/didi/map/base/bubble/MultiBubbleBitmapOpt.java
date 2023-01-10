package com.didi.map.base.bubble;

public class MultiBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f26843a;

    /* renamed from: b */
    private boolean f26844b;

    /* renamed from: c */
    private boolean f26845c;

    public MultiBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f26843a = str2;
    }

    public String getText() {
        return this.f26843a;
    }

    public boolean isShowIcon() {
        return this.f26844b;
    }

    public void setShowIcon(boolean z) {
        this.f26844b = z;
    }

    public boolean is2Dfullbrowser() {
        return this.f26845c;
    }

    public void set2Dfullbrowser(boolean z) {
        this.f26845c = z;
    }

    public String getResourcePaths() {
        return super.toString() + this.f26843a + "|";
    }
}
