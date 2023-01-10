package com.didi.rfusion.widget.floating;

import android.view.View;

public class RFFloatingTextAttr implements Cloneable {

    /* renamed from: a */
    String f36328a;

    /* renamed from: b */
    int f36329b;

    /* renamed from: c */
    View.OnClickListener f36330c;

    private RFFloatingTextAttr() {
    }

    public RFFloatingTextAttr(Builder builder) {
        this.f36328a = builder.text;
        this.f36329b = builder.textColor;
        this.f36330c = builder.listener;
    }

    public String getText() {
        return this.f36328a;
    }

    public int getColor() {
        return this.f36329b;
    }

    public View.OnClickListener getListener() {
        return this.f36330c;
    }

    public static class Builder {
        View.OnClickListener listener;
        String text;
        int textColor = -1;

        public Builder(String str) {
            this.text = str;
        }

        public Builder color(int i) {
            this.textColor = i;
            return this;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public RFFloatingTextAttr build() {
            return new RFFloatingTextAttr(this);
        }
    }

    /* access modifiers changed from: protected */
    public RFFloatingTextAttr clone() {
        try {
            RFFloatingTextAttr rFFloatingTextAttr = (RFFloatingTextAttr) super.clone();
            rFFloatingTextAttr.f36330c = this.f36330c;
            return rFFloatingTextAttr;
        } catch (Exception e) {
            RFFloatingTextAttr rFFloatingTextAttr2 = new RFFloatingTextAttr();
            e.printStackTrace();
            return rFFloatingTextAttr2;
        }
    }
}
