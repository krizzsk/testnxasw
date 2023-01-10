package com.didi.map.base.bubble;

public class BlockBubbleBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private final String f26829a;

    /* renamed from: b */
    private int f26830b = 0;
    public String thumbUrl;

    public BlockBubbleBitmapOpt(String str, long j, String str2) {
        super(str, j);
        this.f26829a = str2;
    }

    public String getText() {
        return this.f26829a;
    }

    public String getResourcePaths() {
        return super.toString() + this.f26829a + "|";
    }

    public int getBlockBubbleType() {
        return this.f26830b;
    }

    public void setBlockBubbleType(int i) {
        this.f26830b = i;
    }
}
