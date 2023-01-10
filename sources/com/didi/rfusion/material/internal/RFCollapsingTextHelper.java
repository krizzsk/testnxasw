package com.didi.rfusion.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C11267R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFStaticLayoutBuilderCompat;
import com.didi.sdk.apm.SystemUtils;

public final class RFCollapsingTextHelper {

    /* renamed from: a */
    private static final boolean f35969a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b */
    private static final String f35970b = "RFCollapsingTextHelper";

    /* renamed from: c */
    private static final String f35971c = "…";

    /* renamed from: d */
    private static final float f35972d = 0.5f;

    /* renamed from: e */
    private static final boolean f35973e = false;

    /* renamed from: f */
    private static final Paint f35974f;

    /* renamed from: A */
    private float f35975A;

    /* renamed from: B */
    private float f35976B;

    /* renamed from: C */
    private Typeface f35977C;

    /* renamed from: D */
    private Typeface f35978D;

    /* renamed from: E */
    private Typeface f35979E;

    /* renamed from: F */
    private CharSequence f35980F;

    /* renamed from: G */
    private CharSequence f35981G;

    /* renamed from: H */
    private boolean f35982H;

    /* renamed from: I */
    private boolean f35983I;

    /* renamed from: J */
    private Bitmap f35984J;

    /* renamed from: K */
    private Paint f35985K;

    /* renamed from: L */
    private float f35986L;

    /* renamed from: M */
    private float f35987M;

    /* renamed from: N */
    private int[] f35988N;

    /* renamed from: O */
    private boolean f35989O;

    /* renamed from: P */
    private final TextPaint f35990P;

    /* renamed from: Q */
    private final TextPaint f35991Q;

    /* renamed from: R */
    private TimeInterpolator f35992R;

    /* renamed from: S */
    private TimeInterpolator f35993S;

    /* renamed from: T */
    private float f35994T;

    /* renamed from: U */
    private float f35995U;

    /* renamed from: V */
    private float f35996V;

    /* renamed from: W */
    private ColorStateList f35997W;

    /* renamed from: X */
    private float f35998X;

    /* renamed from: Y */
    private float f35999Y;

    /* renamed from: Z */
    private float f36000Z;

    /* renamed from: aa */
    private ColorStateList f36001aa;

    /* renamed from: ab */
    private float f36002ab;

    /* renamed from: ac */
    private float f36003ac;

    /* renamed from: ad */
    private StaticLayout f36004ad;

    /* renamed from: ae */
    private float f36005ae;

    /* renamed from: af */
    private float f36006af;

    /* renamed from: ag */
    private float f36007ag;

    /* renamed from: ah */
    private CharSequence f36008ah;

    /* renamed from: ai */
    private int f36009ai = 1;

    /* renamed from: aj */
    private Drawable f36010aj;

    /* renamed from: ak */
    private Rect f36011ak = new Rect();

    /* renamed from: g */
    private final View f36012g;

    /* renamed from: h */
    private boolean f36013h;

    /* renamed from: i */
    private float f36014i;

    /* renamed from: j */
    private boolean f36015j;

    /* renamed from: k */
    private float f36016k;

    /* renamed from: l */
    private float f36017l;

    /* renamed from: m */
    private int f36018m;

    /* renamed from: n */
    private final Rect f36019n;

    /* renamed from: o */
    private final Rect f36020o;

    /* renamed from: p */
    private final RectF f36021p;

    /* renamed from: q */
    private int f36022q = 16;

    /* renamed from: r */
    private int f36023r = 16;

    /* renamed from: s */
    private float f36024s = 15.0f;

    /* renamed from: t */
    private float f36025t = 15.0f;

    /* renamed from: u */
    private ColorStateList f36026u;

    /* renamed from: v */
    private ColorStateList f36027v;

    /* renamed from: w */
    private float f36028w;

    /* renamed from: x */
    private float f36029x;

    /* renamed from: y */
    private float f36030y;

    /* renamed from: z */
    private float f36031z;

    static {
        Paint paint = null;
        f35974f = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
            f35974f.setColor(-65281);
        }
    }

    public RFCollapsingTextHelper(View view) {
        this.f36012g = view;
        this.f35990P = new TextPaint(129);
        this.f35991Q = new TextPaint(this.f35990P);
        this.f36020o = new Rect();
        this.f36019n = new Rect();
        this.f36021p = new RectF();
        this.f36017l = m27119b();
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.f35993S = timeInterpolator;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f35992R = timeInterpolator;
        recalculate();
    }

    public void setRightDrawable(Drawable drawable) {
        this.f36010aj = drawable;
        recalculate();
    }

    public Drawable getRightDrawable() {
        return this.f36010aj;
    }

    public void setExpandedTextSize(float f) {
        if (this.f36024s != f) {
            this.f36024s = f;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.f36025t != f) {
            this.f36025t = f;
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.f36027v != colorStateList) {
            this.f36027v = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.f36026u != colorStateList) {
            this.f36026u = colorStateList;
            recalculate();
        }
    }

    public void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!m27117a(this.f36019n, i, i2, i3, i4)) {
            this.f36019n.set(i, i2, i3, i4);
            this.f35989O = true;
            mo93765a();
        }
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!m27117a(this.f36020o, i, i2, i3, i4)) {
            this.f36020o.set(i, i2, i3, i4);
            this.f35989O = true;
            mo93765a();
        }
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void getCollapsedTextActualBounds(RectF rectF, int i, int i2) {
        this.f35982H = m27118a(this.f35980F);
        rectF.left = m27107a(i, i2);
        rectF.top = (float) this.f36020o.top;
        rectF.right = m27108a(rectF, i, i2);
        rectF.bottom = ((float) this.f36020o.top) + getCollapsedTextHeight();
    }

    /* renamed from: a */
    private float m27107a(int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (((float) i) / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & GravityCompat.END) == 8388613 || (i2 & 5) == 5) ? this.f35982H ? (float) this.f36020o.left : ((float) this.f36020o.right) - calculateCollapsedTextWidth() : this.f35982H ? ((float) this.f36020o.right) - calculateCollapsedTextWidth() : (float) this.f36020o.left;
    }

    /* renamed from: a */
    private float m27108a(RectF rectF, int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (((float) i) / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & GravityCompat.END) == 8388613 || (i2 & 5) == 5) ? this.f35982H ? rectF.left + calculateCollapsedTextWidth() : (float) this.f36020o.right : this.f35982H ? (float) this.f36020o.right : rectF.left + calculateCollapsedTextWidth();
    }

    public float calculateCollapsedTextWidth() {
        if (this.f35980F == null) {
            return 0.0f;
        }
        m27121b(this.f35991Q);
        TextPaint textPaint = this.f35991Q;
        CharSequence charSequence = this.f35980F;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float getExpandedTextHeight() {
        m27115a(this.f35991Q);
        return -this.f35991Q.ascent();
    }

    public float getCollapsedTextHeight() {
        m27121b(this.f35991Q);
        return -this.f35991Q.ascent();
    }

    public void setCurrentOffsetY(int i) {
        this.f36018m = i;
    }

    public void setFadeModeStartFraction(float f) {
        this.f36016k = f;
        this.f36017l = m27119b();
    }

    /* renamed from: b */
    private float m27119b() {
        float f = this.f36016k;
        return f + ((1.0f - f) * 0.5f);
    }

    public void setFadeModeEnabled(boolean z) {
        this.f36015j = z;
    }

    /* renamed from: a */
    private void m27115a(TextPaint textPaint) {
        textPaint.setTextSize(this.f36024s);
        textPaint.setTypeface(this.f35978D);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f36003ac);
        }
    }

    /* renamed from: b */
    private void m27121b(TextPaint textPaint) {
        textPaint.setTextSize(this.f36025t);
        textPaint.setTypeface(this.f35977C);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f36002ab);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93765a() {
        this.f36013h = this.f36020o.width() > 0 && this.f36020o.height() > 0 && this.f36019n.width() > 0 && this.f36019n.height() > 0;
    }

    public void setExpandedTextGravity(int i) {
        if (this.f36022q != i) {
            this.f36022q = i;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.f36022q;
    }

    public void setCollapsedTextGravity(int i) {
        if (this.f36023r != i) {
            this.f36023r = i;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.f36023r;
    }

    public void setCollapsedTextAppearance(int i) {
        RFTintTypedArray obtainStyledAttributes = RFTintTypedArray.obtainStyledAttributes(this.f36012g.getContext(), i, C11267R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f36027v = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f36025t = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f36025t);
        }
        recalculate();
    }

    public void setExpandedTextAppearance(int i) {
        RFTintTypedArray obtainStyledAttributes = RFTintTypedArray.obtainStyledAttributes(this.f36012g.getContext(), i, C11267R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f36026u = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f36024s = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f36024s);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f35978D = m27111a(i);
        }
        recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (this.f35977C != typeface) {
            this.f35977C = typeface;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (this.f35978D != typeface) {
            this.f35978D = typeface;
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        this.f35978D = typeface;
        this.f35977C = typeface;
        recalculate();
    }

    /* renamed from: a */
    private Typeface m27111a(int i) {
        TypedArray obtainStyledAttributes = this.f36012g.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.f35977C;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.f35978D;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.f36014i) {
            this.f36014i = clamp;
            m27122c();
        }
    }

    public final boolean setState(int[] iArr) {
        this.f35988N = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f36026u;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f36027v
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f36026u
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.material.internal.RFCollapsingTextHelper.isStateful():boolean");
    }

    public float getFadeModeThresholdFraction() {
        return this.f36017l;
    }

    public float getExpansionFraction() {
        return this.f36014i;
    }

    public float getCollapsedTextSize() {
        return this.f36025t;
    }

    public float getExpandedTextSize() {
        return this.f36024s;
    }

    /* renamed from: c */
    private void m27122c() {
        m27113a(this.f36014i);
    }

    /* renamed from: a */
    private void m27113a(float f) {
        m27123c(f);
        if (!this.f36015j) {
            this.f35975A = m27106a(this.f36030y, this.f36031z, f, this.f35992R);
            this.f35976B = m27106a(this.f36028w, this.f36029x, f, this.f35992R);
            m27128f(m27106a(this.f36024s, this.f36025t, f, this.f35993S));
        } else if (f < this.f36017l) {
            this.f35975A = this.f36030y;
            this.f35976B = m27106a(this.f36028w, this.f36029x, f, this.f35992R);
            m27128f(this.f36024s);
        } else {
            this.f35975A = this.f36031z;
            this.f35976B = this.f36029x - ((float) this.f36018m);
            m27128f(this.f36025t);
        }
        m27125d(1.0f - m27106a(0.0f, 1.0f, 1.0f - f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        m27127e(m27106a(1.0f, 0.0f, f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.f36027v != this.f36026u) {
            this.f35990P.setColor(m27109a(m27124d(), getCurrentCollapsedTextColor(), f));
        } else {
            this.f35990P.setColor(getCurrentCollapsedTextColor());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f2 = this.f36002ab;
            float f3 = this.f36003ac;
            if (f2 != f3) {
                this.f35990P.setLetterSpacing(m27106a(f3, f2, f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            } else {
                this.f35990P.setLetterSpacing(f2);
            }
        }
        if (this.f36015j) {
            this.f35990P.setAlpha((int) (m27120b(f) * 255.0f));
        }
        ViewCompat.postInvalidateOnAnimation(this.f36012g);
    }

    /* renamed from: b */
    private float m27120b(float f) {
        float f2 = this.f36017l;
        if (f <= f2) {
            return RFAnimationUtils.lerp(1.0f, 0.0f, this.f36016k, f2, f);
        }
        return RFAnimationUtils.lerp(0.0f, 1.0f, f2, 1.0f, f);
    }

    /* renamed from: d */
    private int m27124d() {
        return m27110a(this.f36026u);
    }

    public int getCurrentCollapsedTextColor() {
        return m27110a(this.f36027v);
    }

    /* renamed from: a */
    private int m27110a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f35988N;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    /* renamed from: e */
    private void m27126e() {
        StaticLayout staticLayout;
        float f = this.f35987M;
        m27130g(this.f36025t);
        CharSequence charSequence = this.f35981G;
        if (!(charSequence == null || (staticLayout = this.f36004ad) == null)) {
            this.f36008ah = TextUtils.ellipsize(charSequence, this.f35990P, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f36008ah;
        float f2 = 0.0f;
        float measureText = charSequence2 != null ? this.f35990P.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f36023r, this.f35982H ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.f36029x = (float) this.f36020o.top;
        } else if (i != 80) {
            this.f36029x = ((float) this.f36020o.centerY()) - ((this.f35990P.descent() - this.f35990P.ascent()) / 2.0f);
        } else {
            this.f36029x = ((float) this.f36020o.bottom) + this.f35990P.ascent();
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.f36031z = ((float) this.f36020o.centerX()) - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.f36031z = (float) this.f36020o.left;
        } else {
            this.f36031z = ((float) this.f36020o.right) - measureText;
        }
        m27130g(this.f36024s);
        StaticLayout staticLayout2 = this.f36004ad;
        float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.f35981G;
        float measureText2 = charSequence3 != null ? this.f35990P.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.f36004ad;
        if (staticLayout3 != null && this.f36009ai > 1) {
            measureText2 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f36004ad;
        if (staticLayout4 != null) {
            f2 = this.f36009ai > 1 ? (float) staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.f36007ag = f2;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f36022q, this.f35982H ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.f36028w = (float) this.f36019n.top;
        } else if (i3 != 80) {
            this.f36028w = ((float) this.f36019n.centerY()) - (height / 2.0f);
        } else {
            this.f36028w = (((float) this.f36019n.bottom) - height) + this.f35990P.descent();
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.f36030y = ((float) this.f36019n.centerX()) - (measureText2 / 2.0f);
        } else if (i4 != 5) {
            this.f36030y = (float) this.f36019n.left;
        } else {
            this.f36030y = ((float) this.f36019n.right) - measureText2;
        }
        m27135k();
        m27128f(f);
    }

    /* renamed from: c */
    private void m27123c(float f) {
        if (!this.f36015j) {
            this.f36021p.left = m27106a((float) this.f36019n.left, (float) this.f36020o.left, f, this.f35992R);
            this.f36021p.top = m27106a(this.f36028w, this.f36029x, f, this.f35992R);
            this.f36021p.right = m27106a((float) this.f36019n.right, (float) this.f36020o.right, f, this.f35992R);
            this.f36021p.bottom = m27106a((float) this.f36019n.bottom, (float) this.f36020o.bottom, f, this.f35992R);
        } else if (f < this.f36017l) {
            this.f36021p.left = (float) this.f36019n.left;
            this.f36021p.top = m27106a(this.f36028w, this.f36029x, f, this.f35992R);
            this.f36021p.right = (float) this.f36019n.right;
            this.f36021p.bottom = m27106a((float) this.f36019n.bottom, (float) this.f36020o.bottom, f, this.f35992R);
        } else {
            this.f36021p.left = (float) this.f36020o.left;
            this.f36021p.top = (float) this.f36020o.top;
            this.f36021p.right = (float) this.f36020o.right;
            this.f36021p.bottom = (float) this.f36020o.bottom;
        }
    }

    /* renamed from: d */
    private void m27125d(float f) {
        this.f36005ae = f;
        ViewCompat.postInvalidateOnAnimation(this.f36012g);
    }

    /* renamed from: e */
    private void m27127e(float f) {
        this.f36006af = f;
        ViewCompat.postInvalidateOnAnimation(this.f36012g);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.f35981G != null && this.f36013h) {
            float lineLeft = (this.f35975A + this.f36004ad.getLineLeft(0)) - (this.f36007ag * 2.0f);
            this.f35990P.setTextSize(this.f35987M);
            float f = this.f35975A;
            float f2 = this.f35976B;
            float height = ((float) this.f36004ad.getHeight()) * this.f35986L;
            boolean z = this.f35983I && this.f35984J != null;
            float f3 = this.f35986L;
            if (f3 != 1.0f && !this.f36015j) {
                canvas.scale(f3, f3, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.f35984J, f, f2, this.f35985K);
                canvas.restoreToCount(save);
                return;
            }
            if (!m27129f() || (this.f36015j && this.f36014i <= this.f36017l)) {
                canvas.translate(f, f2);
                this.f36004ad.draw(canvas);
            } else {
                m27114a(canvas, lineLeft, f2);
            }
            canvas.restoreToCount(save);
            if (this.f36010aj != null) {
                canvas.save();
                float f4 = 0.0f;
                if (this.f36004ad.getLineCount() > 0) {
                    f4 = this.f36004ad.getLineWidth(0);
                }
                canvas.translate(f + (f4 * this.f35986L), f2 + ((height - ((float) m27133i())) / 2.0f));
                this.f36010aj.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* renamed from: f */
    private boolean m27129f() {
        return this.f36009ai > 1 && (!this.f35982H || this.f36015j) && !this.f35983I;
    }

    /* renamed from: a */
    private void m27114a(Canvas canvas, float f, float f2) {
        int alpha = this.f35990P.getAlpha();
        canvas.translate(f, f2);
        float f3 = (float) alpha;
        this.f35990P.setAlpha((int) (this.f36006af * f3));
        this.f36004ad.draw(canvas);
        this.f35990P.setAlpha((int) (this.f36005ae * f3));
        int lineBaseline = this.f36004ad.getLineBaseline(0);
        CharSequence charSequence = this.f36008ah;
        float f4 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.f35990P);
        if (!this.f36015j) {
            String trim = this.f36008ah.toString().trim();
            if (trim.endsWith(f35971c)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.f35990P.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f36004ad.getLineEnd(0), str.length()), 0.0f, f4, this.f35990P);
        }
    }

    /* renamed from: a */
    private boolean m27118a(CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (m27131g()) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    /* renamed from: g */
    private boolean m27131g() {
        return ViewCompat.getLayoutDirection(this.f36012g) == 1;
    }

    /* renamed from: f */
    private void m27128f(float f) {
        m27130g(f);
        boolean z = f35969a && this.f35986L != 1.0f;
        this.f35983I = z;
        if (z) {
            m27134j();
        }
        ViewCompat.postInvalidateOnAnimation(this.f36012g);
    }

    /* renamed from: g */
    private void m27130g(float f) {
        float f2;
        boolean z;
        boolean z2;
        if (this.f35980F != null) {
            float width = (float) this.f36020o.width();
            float width2 = (float) this.f36019n.width();
            boolean z3 = false;
            int i = 1;
            if (m27116a(f, this.f36025t)) {
                f2 = this.f36025t;
                this.f35986L = 1.0f;
                Typeface typeface = this.f35979E;
                Typeface typeface2 = this.f35977C;
                if (typeface != typeface2) {
                    this.f35979E = typeface2;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                float f3 = this.f36024s;
                Typeface typeface3 = this.f35979E;
                Typeface typeface4 = this.f35978D;
                if (typeface3 != typeface4) {
                    this.f35979E = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m27116a(f, this.f36024s)) {
                    this.f35986L = 1.0f;
                } else {
                    this.f35986L = f / this.f36024s;
                }
                f2 = f3;
                width = width2;
                z = z2;
            }
            if (this.f36010aj != null) {
                width -= (float) m27132h();
            }
            if (width > 0.0f) {
                z = this.f35987M != f2 || this.f35989O || z;
                this.f35987M = f2;
                this.f35989O = false;
            }
            if (this.f35981G == null || z) {
                this.f35990P.setTextSize(this.f35987M);
                this.f35990P.setTypeface(this.f35979E);
                TextPaint textPaint = this.f35990P;
                if (this.f35986L != 1.0f) {
                    z3 = true;
                }
                textPaint.setLinearText(z3);
                this.f35982H = m27118a(this.f35980F);
                if (m27129f()) {
                    i = this.f36009ai;
                }
                StaticLayout a = m27112a(i, width, this.f35982H);
                this.f36004ad = a;
                this.f35981G = a.getText();
            }
        }
    }

    /* renamed from: h */
    private int m27132h() {
        Drawable drawable = this.f36010aj;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.f36011ak);
        return this.f36010aj.getBounds().width() + this.f36011ak.left + this.f36011ak.right;
    }

    /* renamed from: i */
    private int m27133i() {
        Drawable drawable = this.f36010aj;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.f36011ak);
        return this.f36010aj.getBounds().height() + this.f36011ak.top + this.f36011ak.bottom;
    }

    /* renamed from: a */
    private StaticLayout m27112a(int i, float f, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = RFStaticLayoutBuilderCompat.obtain(this.f35980F, this.f35990P, (int) f).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i).build();
        } catch (RFStaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            RFStaticLayoutBuilderCompat.StaticLayoutBuilderCompatException staticLayoutBuilderCompatException = e;
            SystemUtils.log(6, f35970b, staticLayoutBuilderCompatException.getCause().getMessage(), staticLayoutBuilderCompatException, "com.didi.rfusion.material.internal.RFCollapsingTextHelper", 974);
            staticLayout = null;
        }
        return (StaticLayout) RFPreconditions.checkNotNull(staticLayout);
    }

    /* renamed from: j */
    private void m27134j() {
        if (this.f35984J == null && !this.f36019n.isEmpty() && !TextUtils.isEmpty(this.f35981G)) {
            m27113a(0.0f);
            int width = this.f36004ad.getWidth();
            int height = this.f36004ad.getHeight();
            if (width > 0 && height > 0) {
                this.f35984J = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f36004ad.draw(new Canvas(this.f35984J));
                if (this.f35985K == null) {
                    this.f35985K = new Paint(3);
                }
            }
        }
    }

    public void recalculate() {
        if (this.f36012g.getHeight() > 0 && this.f36012g.getWidth() > 0) {
            m27126e();
            m27122c();
        }
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f35980F, charSequence)) {
            this.f35980F = charSequence;
            this.f35981G = null;
            m27135k();
            recalculate();
        }
    }

    public CharSequence getText() {
        return this.f35980F;
    }

    /* renamed from: k */
    private void m27135k() {
        Bitmap bitmap = this.f35984J;
        if (bitmap != null) {
            bitmap.recycle();
            this.f35984J = null;
        }
    }

    public void setMaxLines(int i) {
        if (i != this.f36009ai) {
            this.f36009ai = i;
            m27135k();
            recalculate();
        }
    }

    public int getMaxLines() {
        return this.f36009ai;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f36004ad;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m27116a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public ColorStateList getExpandedTextColor() {
        return this.f36026u;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.f36027v;
    }

    /* renamed from: a */
    private static int m27109a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    /* renamed from: a */
    private static float m27106a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return RFAnimationUtils.lerp(f, f2, f3);
    }

    /* renamed from: a */
    private static boolean m27117a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
