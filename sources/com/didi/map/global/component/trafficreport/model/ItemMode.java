package com.didi.map.global.component.trafficreport.model;

public class ItemMode {

    /* renamed from: a */
    final String f28571a;

    /* renamed from: b */
    final int f28572b;

    public String getButtonPicUrl() {
        return this.f28571a;
    }

    public int getButtonMode() {
        return this.f28572b;
    }

    public ItemMode(Builder builder) {
        this.f28572b = builder.buttonMode;
        this.f28571a = builder.buttonPicUrl;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int buttonMode;
        /* access modifiers changed from: private */
        public String buttonPicUrl;

        public Builder buttonPicUrl(String str) {
            this.buttonPicUrl = str;
            return this;
        }

        public Builder buttonMode(int i) {
            this.buttonMode = i;
            return this;
        }

        public ItemMode build() {
            return new ItemMode(this);
        }
    }
}
