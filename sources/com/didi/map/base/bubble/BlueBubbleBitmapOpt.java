package com.didi.map.base.bubble;

public class BlueBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f26832a;

    public BlueBubbleBitmapOpt(long j, String str, String str2) {
        super(str, j);
        this.f26832a = str2;
    }

    public String getText() {
        return this.f26832a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f26832a + "|";
    }
}
