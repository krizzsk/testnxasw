package com.didi.map.global.component.trafficreport.model;

public class LocalCategory {

    /* renamed from: a */
    final Integer f28579a;

    /* renamed from: b */
    final String f28580b;

    public Integer getCateCode() {
        return this.f28579a;
    }

    public String getCateName() {
        return this.f28580b;
    }

    public LocalCategory(Builder builder) {
        this.f28579a = builder.cateCode;
        this.f28580b = builder.cateName;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Integer cateCode;
        /* access modifiers changed from: private */
        public String cateName;

        public Builder cateCode(int i) {
            this.cateCode = Integer.valueOf(i);
            return this;
        }

        public Builder cateName(String str) {
            this.cateName = str;
            return this;
        }

        public LocalCategory build() {
            return new LocalCategory(this);
        }
    }
}
