package com.didi.app.nova.skeleton.title;

import android.graphics.drawable.Drawable;
import android.view.View;

public class TitleAttr implements Attr {

    /* renamed from: a */
    String f10361a;

    /* renamed from: b */
    int f10362b;

    /* renamed from: c */
    Drawable f10363c;

    /* renamed from: d */
    View.OnClickListener f10364d;

    TitleAttr(Builder builder) {
        this.f10361a = builder.text;
        this.f10362b = builder.iconRes;
        this.f10363c = builder.icon;
        this.f10364d = builder.listener;
    }

    public String getText() {
        return this.f10361a;
    }

    public int getIconRes() {
        return this.f10362b;
    }

    public Drawable getIcon() {
        return this.f10363c;
    }

    public View.OnClickListener getListener() {
        return this.f10364d;
    }

    public static class Builder {
        Drawable icon;
        int iconRes;
        View.OnClickListener listener;
        String text;

        public Builder(String str) {
            this.text = str;
        }

        public Builder(String str, int i) {
            this.text = str;
            this.iconRes = i;
        }

        public Builder(String str, Drawable drawable) {
            this.text = str;
            this.icon = drawable;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public TitleAttr build() {
            return new TitleAttr(this);
        }
    }
}
