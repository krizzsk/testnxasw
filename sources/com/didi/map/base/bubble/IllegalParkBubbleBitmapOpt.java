package com.didi.map.base.bubble;

public class IllegalParkBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f26841a;

    public IllegalParkBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f26841a = str2;
    }

    public String getText() {
        return this.f26841a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f26841a + "|";
    }
}
