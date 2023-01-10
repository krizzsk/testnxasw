package com.didi.app.nova.skeleton.title;

import android.graphics.Typeface;
import android.view.View;

public class TextAttr implements Attr {

    /* renamed from: a */
    String f10356a;

    /* renamed from: b */
    int f10357b;

    /* renamed from: c */
    int f10358c;

    /* renamed from: d */
    Typeface f10359d;

    /* renamed from: e */
    View.OnClickListener f10360e;

    TextAttr(Builder builder) {
        this.f10356a = builder.text;
        this.f10357b = builder.textSize;
        this.f10358c = builder.textColor;
        this.f10359d = builder.textType;
        this.f10360e = builder.listener;
    }

    public String getText() {
        return this.f10356a;
    }

    public int getTextSize() {
        return this.f10357b;
    }

    public int getTextColor() {
        return this.f10358c;
    }

    public Typeface getTextType() {
        return this.f10359d;
    }

    public View.OnClickListener getListener() {
        return this.f10360e;
    }

    public static class Builder {
        View.OnClickListener listener;
        String text;
        int textColor;
        int textSize;
        Typeface textType;

        public Builder(String str) {
            this.text = str;
        }

        public Builder size(int i) {
            this.textSize = i;
            return this;
        }

        public Builder color(int i) {
            this.textColor = i;
            return this;
        }

        public Builder type(Typeface typeface) {
            this.textType = typeface;
            return this;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public TextAttr build() {
            return new TextAttr(this);
        }
    }
}
