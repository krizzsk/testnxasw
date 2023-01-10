package com.didi.app.nova.skeleton.title;

public class TitleBarAttr {

    /* renamed from: a */
    private int f10365a;

    /* renamed from: b */
    private int f10366b;

    /* renamed from: c */
    private int f10367c;

    /* renamed from: d */
    private int f10368d;

    private TitleBarAttr(int i, int i2, int i3, int i4) {
        this.f10365a = i;
        this.f10366b = i2;
        this.f10367c = i3;
        this.f10368d = i4;
    }

    public int backIcon() {
        return this.f10365a;
    }

    public int backgroundColor() {
        return this.f10366b;
    }

    public int backgroundDrawable() {
        return this.f10367c;
    }

    public int height() {
        return this.f10368d;
    }

    public static class Builder {
        private int backIcon;
        private int backgroundColor;
        private int backgroundDrawable;
        private int height = -1;

        public Builder backIconRes(int i) {
            this.backIcon = i;
            return this;
        }

        public Builder backgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder backgroundDrawable(int i) {
            this.backgroundDrawable = i;
            return this;
        }

        public Builder height(int i) {
            this.height = i;
            return this;
        }

        public TitleBarAttr build() {
            return new TitleBarAttr(this.backIcon, this.backgroundColor, this.backgroundDrawable, this.height);
        }
    }
}
