package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.push.ServerParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextViewStyleHelper {

    /* renamed from: a */
    private static final int f49410a = 33;

    /* renamed from: b */
    private String f49411b;

    /* renamed from: c */
    private ArrayList<Range> f49412c = new ArrayList<>();

    /* renamed from: d */
    private Context f49413d;

    /* renamed from: e */
    private SpannableStringBuilder f49414e;

    private TextViewStyleHelper(Context context, String str) {
        this.f49413d = context;
        this.f49411b = str;
        this.f49414e = new SpannableStringBuilder(str);
    }

    public static TextViewStyleHelper with(Context context, String str) {
        return new TextViewStyleHelper(context, str);
    }

    public TextViewStyleHelper first(String str) {
        this.f49412c.clear();
        int indexOf = this.f49411b.indexOf(str);
        Range create = Range.create(indexOf, str.length() + indexOf);
        if (m37066a(ServerParam.PARAM_FIRST, create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper last(String str) {
        this.f49412c.clear();
        int lastIndexOf = this.f49411b.lastIndexOf(str);
        Range create = Range.create(lastIndexOf, str.length() + lastIndexOf);
        if (m37066a("last", create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper every(String str) {
        return every(str, true);
    }

    public TextViewStyleHelper every(String str, boolean z) {
        if (z) {
            this.f49412c.clear();
        }
        int indexOf = this.f49411b.indexOf(str);
        while (indexOf >= 0) {
            Range create = Range.create(indexOf, str.length() + indexOf);
            if (m37066a("every", create)) {
                this.f49412c.add(create);
            }
            indexOf = this.f49411b.indexOf(str, indexOf + 1);
        }
        return this;
    }

    public TextViewStyleHelper append(String str) {
        int length = this.f49411b.length();
        this.f49411b = this.f49411b.concat(str);
        this.f49414e.append(str);
        this.f49412c.clear();
        Range create = Range.create(length, str.length() + length);
        if (m37066a("append", create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper all() {
        this.f49412c.clear();
        Range create = Range.create(0, this.f49411b.length());
        if (m37066a("all", create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper range(int i, int i2) {
        this.f49412c.clear();
        Range create = Range.create(i, i2);
        if (m37066a("range", create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper ranges(List<Range> list) {
        this.f49412c.clear();
        for (Range next : list) {
            if (m37066a("ranges", next)) {
                this.f49412c.add(next);
            }
        }
        return this;
    }

    public TextViewStyleHelper between(String str, String str2) {
        this.f49412c.clear();
        Range create = Range.create(this.f49411b.indexOf(str) + str.length(), this.f49411b.lastIndexOf(str2));
        if (m37066a("between", create)) {
            this.f49412c.add(create);
        }
        return this;
    }

    public TextViewStyleHelper size(int i) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new AbsoluteSizeSpan(i, true), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper scaleSize(int i) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new RelativeSizeSpan((float) i), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper bold() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new StyleSpan(1), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper italic() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new StyleSpan(2), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper font(String str) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new TypefaceSpan(str), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper strikethrough() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new StrikethroughSpan(), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper underline() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new UnderlineSpan(), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper background(int i) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new BackgroundColorSpan(i), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper textColor(int i) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new ForegroundColorSpan(i), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper subscript() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new SubscriptSpan(), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper superscript() {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new SuperscriptSpan(), next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper url(String str) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, next.from, next.f49415to, 33);
        }
        return this;
    }

    public TextViewStyleHelper onClick(final View.OnClickListener onClickListener) {
        Iterator<Range> it = this.f49412c.iterator();
        while (it.hasNext()) {
            Range next = it.next();
            this.f49414e.setSpan(new ClickableSpan() {
                public void updateDrawState(TextPaint textPaint) {
                }

                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    onClickListener.onClick(view);
                }
            }, next.from, next.f49415to, 33);
        }
        return this;
    }

    public void into(TextView textView) {
        if (textView != null) {
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f49414e);
        }
    }

    /* renamed from: a */
    private boolean m37066a(String str, Range range) {
        int length = this.f49411b.length();
        if (range.f49415to <= length) {
            return true;
        }
        CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException(str + " (" + range.from + " ... " + range.f49415to + ") ends beyond length " + length));
        return false;
    }

    public static class Range {
        public final int from;

        /* renamed from: to */
        public final int f49415to;

        private Range(int i, int i2) {
            if (i < 0 || i2 < 0) {
                CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException("(" + i + " ... " + i2 + ") starts before 0"));
                this.f49415to = 0;
                this.from = 0;
            } else if (i2 < i) {
                CheckUtils.throwExceptionIfDebug((RuntimeException) new IndexOutOfBoundsException("(" + i + " ... " + i2 + ") has end before start"));
                this.f49415to = 0;
                this.from = 0;
            } else {
                this.from = i;
                this.f49415to = i2;
            }
        }

        public static Range create(int i, int i2) {
            return new Range(i, i2);
        }
    }
}
