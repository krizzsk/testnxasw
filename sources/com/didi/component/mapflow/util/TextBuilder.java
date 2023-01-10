package com.didi.component.mapflow.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import java.util.ArrayList;
import java.util.List;

public class TextBuilder {

    /* renamed from: a */
    private List<SubString> f16345a = new ArrayList();

    /* renamed from: b */
    private Context f16346b;

    /* renamed from: c */
    private Resources f16347c;

    public TextBuilder(Context context) {
        this.f16346b = context;
        this.f16347c = context.getResources();
    }

    public TextBuilder addText(String str, int i, int i2) {
        return addText(str, i, i2, false);
    }

    public TextBuilder addText(String str, int i, int i2, boolean z) {
        return m13704a(str, this.f16347c.getDimensionPixelSize(i), this.f16347c.getColor(i2), z);
    }

    public TextBuilder addTextWithColor(String str, int i, int i2) {
        return m13704a(str, this.f16347c.getDimensionPixelSize(i), i2, false);
    }

    public TextBuilder addTextWithColor(String str, int i, int i2, boolean z) {
        return m13704a(str, this.f16347c.getDimensionPixelSize(i), i2, z);
    }

    public TextBuilder addText(int i, int i2, int i3) {
        return addText(this.f16346b.getString(i), i2, i3);
    }

    public TextBuilder addText(SubString subString) {
        if (subString != null) {
            this.f16345a.add(subString);
            return this;
        }
        throw new RuntimeException("subString cannot be null.");
    }

    /* renamed from: a */
    private TextBuilder m13703a(CharSequence charSequence, int i, int i2) {
        this.f16345a.add(new SubString(charSequence, i, i2));
        return this;
    }

    /* renamed from: a */
    private TextBuilder m13704a(CharSequence charSequence, int i, int i2, boolean z) {
        this.f16345a.add(new SubString(charSequence, i, i2, z));
        return this;
    }

    public SpannableString build() {
        StringBuilder sb = new StringBuilder();
        for (SubString next : this.f16345a) {
            if (!TextUtils.isEmpty(next.subText)) {
                sb.append(next.subText);
            }
        }
        int i = 0;
        SpannableString spannableString = new SpannableString(sb.toString());
        for (SubString next2 : this.f16345a) {
            if (!TextUtils.isEmpty(next2.subText)) {
                int length = next2.subText.length() + i;
                spannableString.setSpan(new ForegroundColorSpan(next2.subTextColor), i, length, 34);
                spannableString.setSpan(new AbsoluteSizeSpan(next2.subTextSize), i, length, 34);
                if (next2.isBold) {
                    spannableString.setSpan(new StyleSpan(1), i, length, 34);
                }
                i = length;
            }
        }
        return spannableString;
    }

    public void clear() {
        this.f16345a.clear();
    }

    public static final class SubString {
        public boolean isBold;
        public CharSequence subText;
        public int subTextColor;
        public int subTextSize;

        public SubString(CharSequence charSequence, int i, int i2) {
            this.subText = charSequence;
            this.subTextSize = i;
            this.subTextColor = i2;
            this.isBold = true;
        }

        public SubString(CharSequence charSequence, int i, int i2, boolean z) {
            this.subText = charSequence;
            this.subTextSize = i;
            this.subTextColor = i2;
            this.isBold = z;
        }
    }
}
