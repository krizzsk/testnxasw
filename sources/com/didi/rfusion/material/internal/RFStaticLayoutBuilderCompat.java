package com.didi.rfusion.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

public class RFStaticLayoutBuilderCompat {

    /* renamed from: a */
    private static final String f36037a = "android.text.TextDirectionHeuristic";

    /* renamed from: b */
    private static final String f36038b = "android.text.TextDirectionHeuristics";

    /* renamed from: c */
    private static final String f36039c = "LTR";

    /* renamed from: d */
    private static final String f36040d = "RTL";

    /* renamed from: e */
    private static boolean f36041e;

    /* renamed from: f */
    private static Constructor<StaticLayout> f36042f;

    /* renamed from: g */
    private static Object f36043g;

    /* renamed from: h */
    private CharSequence f36044h;

    /* renamed from: i */
    private final TextPaint f36045i;

    /* renamed from: j */
    private final int f36046j;

    /* renamed from: k */
    private int f36047k = 0;

    /* renamed from: l */
    private int f36048l;

    /* renamed from: m */
    private Layout.Alignment f36049m;

    /* renamed from: n */
    private int f36050n;

    /* renamed from: o */
    private boolean f36051o;

    /* renamed from: p */
    private boolean f36052p;

    /* renamed from: q */
    private TextUtils.TruncateAt f36053q;

    private RFStaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f36044h = charSequence;
        this.f36045i = textPaint;
        this.f36046j = i;
        this.f36048l = charSequence.length();
        this.f36049m = Layout.Alignment.ALIGN_NORMAL;
        this.f36050n = Integer.MAX_VALUE;
        this.f36051o = true;
        this.f36053q = null;
    }

    public static RFStaticLayoutBuilderCompat obtain(CharSequence charSequence, TextPaint textPaint, int i) {
        return new RFStaticLayoutBuilderCompat(charSequence, textPaint, i);
    }

    public RFStaticLayoutBuilderCompat setAlignment(Layout.Alignment alignment) {
        this.f36049m = alignment;
        return this;
    }

    public RFStaticLayoutBuilderCompat setIncludePad(boolean z) {
        this.f36051o = z;
        return this;
    }

    public RFStaticLayoutBuilderCompat setStart(int i) {
        this.f36047k = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setEnd(int i) {
        this.f36048l = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setMaxLines(int i) {
        this.f36050n = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f36053q = truncateAt;
        return this;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f36044h == null) {
            this.f36044h = "";
        }
        int max = Math.max(0, this.f36046j);
        CharSequence charSequence = this.f36044h;
        if (this.f36050n == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f36045i, (float) max, this.f36053q);
        }
        this.f36048l = Math.min(charSequence.length(), this.f36048l);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f36052p && this.f36050n == 1) {
                this.f36049m = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f36047k, this.f36048l, this.f36045i, max);
            obtain.setAlignment(this.f36049m);
            obtain.setIncludePad(this.f36051o);
            if (this.f36052p) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f36053q;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f36050n);
            if (this.f36050n > 1) {
                obtain.setHyphenationFrequency(1);
            }
            return obtain.build();
        }
        m27138a();
        try {
            return (StaticLayout) ((Constructor) RFPreconditions.checkNotNull(f36042f)).newInstance(new Object[]{charSequence, Integer.valueOf(this.f36047k), Integer.valueOf(this.f36048l), this.f36045i, Integer.valueOf(max), this.f36049m, RFPreconditions.checkNotNull(f36043g), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f36051o), null, Integer.valueOf(max), Integer.valueOf(this.f36050n)});
        } catch (Exception e) {
            throw new StaticLayoutBuilderCompatException(e);
        }
    }

    /* renamed from: a */
    private void m27138a() throws StaticLayoutBuilderCompatException {
        Class cls;
        if (!f36041e) {
            try {
                boolean z = this.f36052p && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    f36043g = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = RFStaticLayoutBuilderCompat.class.getClassLoader();
                    String str = this.f36052p ? f36040d : f36039c;
                    Class<?> loadClass = classLoader.loadClass(f36037a);
                    Class<?> loadClass2 = classLoader.loadClass(f36038b);
                    f36043g = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});
                f36042f = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f36041e = true;
            } catch (Exception e) {
                throw new StaticLayoutBuilderCompatException(e);
            }
        }
    }

    public RFStaticLayoutBuilderCompat setIsRtl(boolean z) {
        this.f36052p = z;
        return this;
    }

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }
}
