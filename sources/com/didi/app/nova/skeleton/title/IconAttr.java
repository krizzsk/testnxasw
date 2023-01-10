package com.didi.app.nova.skeleton.title;

import android.graphics.drawable.Drawable;
import android.view.View;

public class IconAttr implements Attr {

    /* renamed from: a */
    int f10353a;

    /* renamed from: b */
    Drawable f10354b;

    /* renamed from: c */
    View.OnClickListener f10355c;

    IconAttr(Builder builder) {
        this.f10353a = builder.iconRes;
        this.f10354b = builder.icon;
        this.f10355c = builder.listener;
    }

    public int getIconRes() {
        return this.f10353a;
    }

    public Drawable getIcon() {
        return this.f10354b;
    }

    public View.OnClickListener getListener() {
        return this.f10355c;
    }

    public static class Builder {
        Drawable icon;
        int iconRes;
        View.OnClickListener listener;

        public Builder(int i) {
            this.iconRes = i;
        }

        public Builder(Drawable drawable) {
            this.icon = drawable;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public IconAttr build() {
            return new IconAttr(this);
        }
    }
}
