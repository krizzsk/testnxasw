package com.didiglobal.p205sa.biz.tab.p206ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.passenger.C11267R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020$H\u0002J \u0010(\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\tJ\u0010\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J0\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/ui/SaTabContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SHADOW_DEFAULT_BLUR_RADIUS", "", "getSHADOW_DEFAULT_BLUR_RADIUS", "()F", "SHADOW_DEFAULT_RADIUS", "getSHADOW_DEFAULT_RADIUS", "SHADOW_MAX_BLUR", "getSHADOW_MAX_BLUR", "SHADOW_MAX_OFFSET", "getSHADOW_MAX_OFFSET", "bgColor", "blurRadius", "hasEffect", "", "locationPaint", "Landroid/graphics/Paint;", "mHeightMode", "mPaint", "mWidthMode", "shadowColor", "shadowRadius", "shadowType", "xOffset", "yOffset", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawBackground", "init", "attrs", "defStyleAttr", "onDraw", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.ui.SaTabContainer */
/* compiled from: SaTabContainer.kt */
public final class SaTabContainer extends ConstraintLayout {

    /* renamed from: a */
    private final float f53784a = ((float) UiUtils.dip2px(getContext(), 5.0f));

    /* renamed from: b */
    private final float f53785b = ((float) UiUtils.dip2px(getContext(), 20.0f));

    /* renamed from: c */
    private final float f53786c = ((float) UiUtils.dip2px(getContext(), 20.0f));

    /* renamed from: d */
    private final float f53787d = ((float) UiUtils.dip2px(getContext(), 5.0f));

    /* renamed from: e */
    private int f53788e = Color.parseColor("#333333");

    /* renamed from: f */
    private final int f53789f;

    /* renamed from: g */
    private float f53790g;

    /* renamed from: h */
    private float f53791h = this.f53787d;

    /* renamed from: i */
    private float f53792i = ((float) UiUtils.dip2px(getContext(), 10.0f));

    /* renamed from: j */
    private float f53793j = ((float) UiUtils.dip2px(getContext(), 10.0f));

    /* renamed from: k */
    private int f53794k = -1;

    /* renamed from: l */
    private boolean f53795l;

    /* renamed from: m */
    private float f53796m;

    /* renamed from: n */
    private float f53797n;

    /* renamed from: o */
    private final Paint f53798o = new Paint();

    /* renamed from: p */
    private final Paint f53799p = new Paint();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, (AttributeSet) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        init(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaTabContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        init(context, attributeSet, 0);
    }

    public final float getSHADOW_DEFAULT_RADIUS() {
        return this.f53784a;
    }

    public final float getSHADOW_MAX_OFFSET() {
        return this.f53785b;
    }

    public final float getSHADOW_MAX_BLUR() {
        return this.f53786c;
    }

    public final float getSHADOW_DEFAULT_BLUR_RADIUS() {
        return this.f53787d;
    }

    public final void init(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SaTabContainer);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.SaTabContainer)");
        this.f53788e = obtainStyledAttributes.getColor(3, -16776961);
        this.f53791h = obtainStyledAttributes.getDimension(1, this.f53787d);
        this.f53790g = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f53795l = obtainStyledAttributes.getBoolean(2, false);
        this.f53792i = obtainStyledAttributes.getDimension(5, (float) UiUtils.dip2px(context, 10.0f));
        this.f53793j = obtainStyledAttributes.getDimension(6, (float) UiUtils.dip2px(context, 10.0f));
        this.f53794k = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        float f = this.f53790g;
        if (f < 0.0f) {
            this.f53790g = -f;
        }
        float f2 = this.f53791h;
        if (f2 < 0.0f) {
            this.f53791h = -f2;
        }
        this.f53791h = Math.min(this.f53786c, this.f53791h);
        if (Math.abs(this.f53792i) > this.f53785b) {
            float f3 = this.f53792i;
            this.f53792i = (f3 / Math.abs(f3)) * this.f53785b;
        }
        if (Math.abs(this.f53793j) > this.f53785b) {
            float f4 = this.f53793j;
            this.f53793j = (f4 / Math.abs(f4)) * this.f53785b;
        }
        m40132a();
    }

    /* renamed from: a */
    private final void m40132a() {
        float f = this.f53792i;
        boolean z = true;
        if (f > 0.0f) {
            setRight((int) (this.f53791h + Math.abs(f)));
        } else {
            if (f == 0.0f) {
                setLeft(0);
                setRight(0);
            } else {
                setLeft((int) (this.f53791h + Math.abs(this.f53792i)));
            }
        }
        float f2 = this.f53793j;
        if (f2 > 0.0f) {
            setBottom((int) Math.abs(f2));
        } else {
            if (f2 != 0.0f) {
                z = false;
            }
            if (z) {
                setTop((int) this.f53791h);
                setBottom((int) this.f53791h);
            } else {
                setTop((int) Math.abs(this.f53793j));
            }
        }
        setPadding(getLeft(), getTop(), getRight(), getBottom());
        setBackgroundColor(this.f53794k);
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
        m40133a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private final void m40133a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        this.f53796m = (float) getMeasuredWidth();
        this.f53797n = (float) getMeasuredHeight();
        boolean z = false;
        if (this.f53792i == 0.0f) {
            f3 = (float) getRight();
            f2 = this.f53796m;
            f = this.f53791h;
        } else {
            f3 = ((float) getRight()) + this.f53791h;
            f2 = this.f53796m - ((float) getLeft());
            f = this.f53791h;
        }
        float f7 = f2 - f;
        if (this.f53793j == 0.0f) {
            f6 = (float) getBottom();
            f5 = this.f53797n;
            f4 = this.f53791h;
        } else {
            f6 = ((float) getBottom()) + this.f53791h;
            f5 = this.f53797n - ((float) getTop());
            f4 = this.f53791h;
        }
        float f8 = f5 - f4;
        if (this.f53791h > 0.0f) {
            this.f53798o.setMaskFilter(new BlurMaskFilter(this.f53791h, BlurMaskFilter.Blur.NORMAL));
        }
        this.f53798o.setColor(this.f53788e);
        this.f53798o.setAntiAlias(true);
        RectF rectF = new RectF(f3, f6, f7, f8);
        RectF rectF2 = new RectF((float) getLeft(), (float) getTop(), this.f53796m - ((float) getRight()), this.f53797n - ((float) getBottom()));
        if (this.f53790g == 0.0f) {
            canvas.drawRect(rectF, this.f53798o);
        } else {
            float f9 = this.f53790g;
            canvas.drawRoundRect(rectF, f9, f9, this.f53798o);
        }
        this.f53799p.setColor(this.f53794k);
        this.f53799p.setAntiAlias(true);
        if (this.f53790g == 0.0f) {
            z = true;
        }
        if (z) {
            canvas.drawRect(rectF2, this.f53799p);
            return;
        }
        float f10 = this.f53790g;
        canvas.drawRoundRect(rectF2, f10, f10, this.f53799p);
    }
}
