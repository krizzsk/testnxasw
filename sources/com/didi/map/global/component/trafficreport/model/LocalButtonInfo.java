package com.didi.map.global.component.trafficreport.model;

import android.util.SparseArray;
import java.util.List;

public class LocalButtonInfo {

    /* renamed from: a */
    final String f28573a;

    /* renamed from: b */
    final SparseArray<String> f28574b;

    /* renamed from: c */
    final Integer f28575c;

    /* renamed from: d */
    final Integer f28576d;

    /* renamed from: e */
    final Integer f28577e;

    /* renamed from: f */
    final List<LocalButtonInfo> f28578f;

    public String getButtonTitle() {
        return this.f28573a;
    }

    public SparseArray<String> getModeInfo() {
        return this.f28574b;
    }

    public Integer getButtonValue() {
        return this.f28575c;
    }

    public Integer getButtonIndex() {
        return this.f28576d;
    }

    public Integer getCateCode() {
        return this.f28577e;
    }

    public List<LocalButtonInfo> getSecondary() {
        return this.f28578f;
    }

    public LocalButtonInfo(Builder builder) {
        this.f28573a = builder.buttonTitle;
        this.f28574b = builder.modeInfo;
        this.f28575c = builder.buttonValue;
        this.f28576d = builder.buttonIndex;
        this.f28577e = builder.cateCode;
        this.f28578f = builder.secondary;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Integer buttonIndex;
        /* access modifiers changed from: private */
        public String buttonTitle;
        /* access modifiers changed from: private */
        public Integer buttonValue;
        /* access modifiers changed from: private */
        public Integer cateCode;
        /* access modifiers changed from: private */
        public SparseArray<String> modeInfo;
        /* access modifiers changed from: private */
        public List<LocalButtonInfo> secondary;

        public Builder buttonTitle(String str) {
            this.buttonTitle = str;
            return this;
        }

        public Builder modeInfo(SparseArray<String> sparseArray) {
            this.modeInfo = sparseArray;
            return this;
        }

        public Builder buttonValue(int i) {
            this.buttonValue = Integer.valueOf(i);
            return this;
        }

        public Builder buttonIndex(int i) {
            this.buttonIndex = Integer.valueOf(i);
            return this;
        }

        public Builder cateCode(int i) {
            this.cateCode = Integer.valueOf(i);
            return this;
        }

        public Builder secondary(List<LocalButtonInfo> list) {
            this.secondary = list;
            return this;
        }

        public LocalButtonInfo build() {
            return new LocalButtonInfo(this);
        }
    }
}
