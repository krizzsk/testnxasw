package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.common.util.GLog;
import com.didi.sdk.util.TextUtil;

public class RichTextView extends TextView {

    /* renamed from: a */
    private static final String f13704a = "RichTextView";

    /* renamed from: b */
    private static String f13705b = "red";

    /* renamed from: c */
    private static final String f13706c = "#FC9153";

    /* renamed from: d */
    private String f13707d;

    /* renamed from: e */
    private SpannableString f13708e;

    public RichTextView(Context context) {
        super(context);
    }

    public RichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                super.setText(HighlightUtil.highlight(getRichColor(), charSequence), bufferType);
            } catch (Throwable th) {
                GLog.m11358e("", "", th);
                super.setText(charSequence, bufferType);
            }
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    private int getRichColor() {
        String str;
        if (TextUtil.isEmpty(this.f13707d)) {
            str = f13706c;
        } else {
            str = this.f13707d;
        }
        if (f13705b.equals(getTag())) {
            str = "#dd170c";
        }
        return Color.parseColor(str);
    }

    public void setRichColor(String str) {
        this.f13707d = str;
    }
}
