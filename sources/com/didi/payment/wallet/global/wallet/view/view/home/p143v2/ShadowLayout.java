package com.didi.payment.wallet.global.wallet.view.view.home.p143v2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.didi.passenger.C11267R;
import com.didi.unifiedPay.util.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001?B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\b\u00103\u001a\u0004\u0018\u00010%J\b\u00104\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J0\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\u0018\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/ShadowLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SHADOW_DEFAULT_BLUR_RADIUS", "", "SHADOW_DEFAULT_RADIUS", "getSHADOW_DEFAULT_RADIUS", "()F", "SHADOW_MAX_BLUR", "SHADOW_MAX_OFFSET", "bgColor", "blurRadius", "bottomS", "getBottomS", "()I", "setBottomS", "(I)V", "hasEffect", "", "leftS", "getLeftS", "setLeftS", "locationPaint", "Landroid/graphics/Paint;", "mHeightMode", "mPaint", "mWidthMode", "rightS", "getRightS", "setRightS", "shadow", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/Shadow;", "shadowColor", "shadowRadius", "shadowType", "topS", "getTopS", "setTopS", "xOffset", "yOffset", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawBackground", "getShadowConfig", "init", "onDraw", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "ShadowConfig", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.ShadowLayout */
/* compiled from: ShadowLayout.kt */
public final class ShadowLayout extends LinearLayout {

    /* renamed from: a */
    private final float f35149a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final float f35150b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final float f35151c;

    /* renamed from: d */
    private final float f35152d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f35153e;

    /* renamed from: f */
    private final int f35154f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f35155g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f35156h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f35157i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f35158j;

    /* renamed from: k */
    private int f35159k;

    /* renamed from: l */
    private boolean f35160l;

    /* renamed from: m */
    private int f35161m;

    /* renamed from: n */
    private int f35162n;

    /* renamed from: o */
    private int f35163o;

    /* renamed from: p */
    private int f35164p;

    /* renamed from: q */
    private final Shadow f35165q;

    /* renamed from: r */
    private float f35166r;

    /* renamed from: s */
    private float f35167s;

    /* renamed from: t */
    private final Paint f35168t;

    /* renamed from: u */
    private final Paint f35169u;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShadowLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35149a = (float) UIUtils.dip2px(context, 5.0f);
        this.f35150b = (float) UIUtils.dip2px(context, 20.0f);
        this.f35151c = (float) UIUtils.dip2px(context, 20.0f);
        this.f35152d = (float) UIUtils.dip2px(context, 5.0f);
        this.f35153e = Color.parseColor("#333333");
        this.f35156h = this.f35152d;
        this.f35157i = (float) UIUtils.dip2px(context, 10.0f);
        this.f35158j = (float) UIUtils.dip2px(context, 10.0f);
        this.f35159k = -1;
        this.f35165q = new ShadowConfig(this);
        this.f35168t = new Paint();
        this.f35169u = new Paint();
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.ShadowLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.ShadowLayout)");
        this.f35153e = obtainStyledAttributes.getColor(43, -16776961);
        this.f35156h = obtainStyledAttributes.getDimension(1, this.f35152d);
        this.f35155g = obtainStyledAttributes.getDimension(52, 0.0f);
        this.f35160l = obtainStyledAttributes.getBoolean(8, false);
        this.f35157i = obtainStyledAttributes.getDimension(58, 10.0f);
        this.f35158j = obtainStyledAttributes.getDimension(59, 10.0f);
        this.f35159k = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        float f = this.f35155g;
        if (f < 0.0f) {
            this.f35155g = -f;
        }
        float f2 = this.f35156h;
        if (f2 < 0.0f) {
            this.f35156h = -f2;
        }
        this.f35156h = Math.min(this.f35151c, this.f35156h);
        if (Math.abs(this.f35157i) > this.f35150b) {
            float f3 = this.f35157i;
            this.f35157i = (f3 / Math.abs(f3)) * this.f35150b;
        }
        if (Math.abs(this.f35158j) > this.f35150b) {
            float f4 = this.f35158j;
            this.f35158j = (f4 / Math.abs(f4)) * this.f35150b;
        }
        setBackgroundColor(Color.parseColor("#00ffffff"));
        m26758a();
    }

    public final float getSHADOW_DEFAULT_RADIUS() {
        return this.f35149a;
    }

    public final int getLeftS() {
        return this.f35161m;
    }

    public final void setLeftS(int i) {
        this.f35161m = i;
    }

    public final int getRightS() {
        return this.f35162n;
    }

    public final void setRightS(int i) {
        this.f35162n = i;
    }

    public final int getTopS() {
        return this.f35163o;
    }

    public final void setTopS(int i) {
        this.f35163o = i;
    }

    public final int getBottomS() {
        return this.f35164p;
    }

    public final void setBottomS(int i) {
        this.f35164p = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26758a() {
        float f = this.f35157i;
        boolean z = true;
        if (f > 0.0f) {
            this.f35162n = (int) (this.f35156h + Math.abs(f));
        } else {
            if (f == 0.0f) {
                float f2 = this.f35156h;
                this.f35161m = (int) f2;
                this.f35162n = (int) f2;
            } else {
                this.f35161m = (int) (this.f35156h + Math.abs(this.f35157i));
            }
        }
        float f3 = this.f35158j;
        if (f3 > 0.0f) {
            this.f35164p = (int) (this.f35156h + Math.abs(f3));
        } else {
            if (f3 != 0.0f) {
                z = false;
            }
            if (z) {
                float f4 = this.f35156h;
                this.f35163o = (int) f4;
                this.f35164p = (int) f4;
            } else {
                this.f35163o = (int) (this.f35156h + Math.abs(this.f35158j));
            }
        }
        setPadding(this.f35161m, this.f35163o, this.f35162n, this.f35164p);
    }

    public final Shadow getShadowConfig() {
        return this.f35165q;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        m26759a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m26759a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        this.f35166r = (float) getMeasuredWidth();
        this.f35167s = (float) getMeasuredHeight();
        boolean z = false;
        if (this.f35157i == 0.0f) {
            f2 = (float) this.f35162n;
            f = this.f35166r - this.f35156h;
        } else {
            float f5 = this.f35156h;
            f2 = ((float) this.f35162n) + f5;
            f = (this.f35166r - ((float) this.f35161m)) - f5;
        }
        if (this.f35158j == 0.0f) {
            f4 = (float) this.f35164p;
            f3 = this.f35167s - this.f35156h;
        } else {
            float f6 = this.f35156h;
            f4 = ((float) this.f35164p) + f6;
            f3 = (this.f35167s - ((float) this.f35163o)) - f6;
        }
        if (this.f35156h > 0.0f) {
            this.f35168t.setMaskFilter(new BlurMaskFilter(this.f35156h, BlurMaskFilter.Blur.NORMAL));
        }
        this.f35168t.setColor(this.f35153e);
        this.f35168t.setAntiAlias(true);
        RectF rectF = new RectF(f2, f4, f, f3);
        RectF rectF2 = new RectF((float) this.f35161m, (float) this.f35163o, this.f35166r - ((float) this.f35162n), this.f35167s - ((float) this.f35164p));
        if (this.f35155g == 0.0f) {
            canvas.drawRect(rectF, this.f35168t);
        } else {
            float f7 = this.f35155g;
            canvas.drawRoundRect(rectF, f7, f7, this.f35168t);
        }
        this.f35169u.setColor(this.f35159k);
        this.f35169u.setAntiAlias(true);
        if (this.f35155g == 0.0f) {
            z = true;
        }
        if (z) {
            canvas.drawRect(rectF2, this.f35169u);
            return;
        }
        float f8 = this.f35155g;
        canvas.drawRoundRect(rectF2, f8, f8, this.f35169u);
    }

    @Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/ShadowLayout$ShadowConfig;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/Shadow;", "shadow", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/ShadowLayout;", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/ShadowLayout;)V", "commit", "", "setBlurRadius", "radius", "", "unit", "", "setShadowColor", "color", "setShadowColorRes", "colorRes", "setShadowRadius", "setXOffset", "offset", "setYOffset", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.ShadowLayout$ShadowConfig */
    /* compiled from: ShadowLayout.kt */
    public static final class ShadowConfig implements Shadow {
        private final ShadowLayout shadow;

        public ShadowConfig(ShadowLayout shadowLayout) {
            Intrinsics.checkNotNullParameter(shadowLayout, "shadow");
            this.shadow = shadowLayout;
        }

        public Shadow setShadowRadius(float f) {
            return setShadowRadius(1, f);
        }

        public Shadow setShadowRadius(int i, float f) {
            Resources resources;
            Context context = this.shadow.getContext();
            if (context == null) {
                resources = Resources.getSystem();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                Resour…getSystem()\n            }");
            } else {
                resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                c.resources\n            }");
            }
            this.shadow.f35155g = Math.abs(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
            return this;
        }

        public Shadow setShadowColor(int i) {
            this.shadow.f35153e = i;
            return this;
        }

        public Shadow setShadowColorRes(int i) {
            ShadowLayout shadowLayout = this.shadow;
            shadowLayout.f35153e = shadowLayout.getResources().getColor(i);
            return this;
        }

        public Shadow setBlurRadius(float f) {
            return setBlurRadius(1, f);
        }

        public Shadow setBlurRadius(int i, float f) {
            Resources resources;
            Context context = this.shadow.getContext();
            if (context == null) {
                resources = Resources.getSystem();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                Resour…getSystem()\n            }");
            } else {
                resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                c.resources\n            }");
            }
            ShadowLayout shadowLayout = this.shadow;
            shadowLayout.f35156h = Math.min(shadowLayout.f35151c, Math.abs(TypedValue.applyDimension(i, f, resources.getDisplayMetrics())));
            return this;
        }

        public Shadow setXOffset(float f) {
            return setXOffset(1, f);
        }

        public Shadow setXOffset(int i, float f) {
            Resources resources;
            Context context = this.shadow.getContext();
            if (context == null) {
                resources = Resources.getSystem();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                Resour…getSystem()\n            }");
            } else {
                resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                c.resources\n            }");
            }
            float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
            if (Math.abs(applyDimension) > this.shadow.f35150b) {
                applyDimension = (applyDimension / Math.abs(applyDimension)) * this.shadow.f35150b;
            }
            this.shadow.f35157i = applyDimension;
            return this;
        }

        public Shadow setYOffset(float f) {
            return setYOffset(1, f);
        }

        public Shadow setYOffset(int i, float f) {
            Resources resources;
            Context context = this.shadow.getContext();
            if (context == null) {
                resources = Resources.getSystem();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                Resour…getSystem()\n            }");
            } else {
                resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "{\n                c.resources\n            }");
            }
            float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
            if (Math.abs(applyDimension) > this.shadow.f35150b) {
                applyDimension = (applyDimension / Math.abs(applyDimension)) * this.shadow.f35150b;
            }
            this.shadow.f35158j = applyDimension;
            return this;
        }

        public void commit() {
            this.shadow.m26758a();
            this.shadow.requestLayout();
            this.shadow.postInvalidate();
        }
    }
}
