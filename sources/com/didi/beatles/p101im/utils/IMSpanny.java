package com.didi.beatles.p101im.utils;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

/* renamed from: com.didi.beatles.im.utils.IMSpanny */
public class IMSpanny extends SpannableStringBuilder {

    /* renamed from: a */
    private int f11626a = 33;

    /* renamed from: com.didi.beatles.im.utils.IMSpanny$GetSpan */
    public interface GetSpan {
        Object getSpan();
    }

    public IMSpanny() {
        super("");
    }

    public IMSpanny(CharSequence charSequence) {
        super(charSequence);
    }

    public IMSpanny(CharSequence charSequence, Object... objArr) {
        super(charSequence);
        for (Object a : objArr) {
            m10033a(a, 0, length());
        }
    }

    public IMSpanny(CharSequence charSequence, Object obj) {
        super(charSequence);
        m10033a(obj, 0, charSequence.length());
    }

    public IMSpanny append(CharSequence charSequence, Object... objArr) {
        append(charSequence);
        for (Object a : objArr) {
            m10033a(a, length() - charSequence.length(), length());
        }
        return this;
    }

    public IMSpanny append(CharSequence charSequence, Object obj) {
        append(charSequence);
        m10033a(obj, length() - charSequence.length(), length());
        return this;
    }

    public IMSpanny append(CharSequence charSequence, ImageSpan imageSpan) {
        String str = "." + charSequence;
        append((CharSequence) str);
        m10033a(imageSpan, length() - str.length(), (length() - str.length()) + 1);
        return this;
    }

    public IMSpanny append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Deprecated
    public IMSpanny appendText(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    public void setFlag(int i) {
        this.f11626a = i;
    }

    /* renamed from: a */
    private void m10033a(Object obj, int i, int i2) {
        setSpan(obj, i, i2, this.f11626a);
    }

    public IMSpanny findAndSpan(CharSequence charSequence, GetSpan getSpan) {
        int i = 0;
        while (i != -1) {
            i = toString().indexOf(charSequence.toString(), i);
            if (i != -1) {
                m10033a(getSpan.getSpan(), i, charSequence.length() + i);
                i += charSequence.length();
            }
        }
        return this;
    }

    public static SpannableString spanText(CharSequence charSequence, Object... objArr) {
        SpannableString spannableString = new SpannableString(charSequence);
        for (Object span : objArr) {
            spannableString.setSpan(span, 0, charSequence.length(), 33);
        }
        return spannableString;
    }

    public static SpannableString spanText(CharSequence charSequence, Object obj) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(obj, 0, charSequence.length(), 33);
        return spannableString;
    }
}
