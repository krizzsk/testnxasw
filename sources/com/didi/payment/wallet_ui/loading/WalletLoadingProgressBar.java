package com.didi.payment.wallet_ui.loading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010*\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0018\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0014J\u0006\u0010.\u001a\u00020\"J\u0006\u0010/\u001a\u00020\"R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001f\u0010\u0014¨\u00061"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletLoadingProgressBar;", "Landroid/view/View;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "bgShader", "Landroid/graphics/LinearGradient;", "getBgShader", "()Landroid/graphics/LinearGradient;", "bgShader$delegate", "curProgress", "isAnimOnce", "", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "progressShader", "getProgressShader", "progressShader$delegate", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "curWidth", "", "drawProgress", "onAnimationUpdate", "animation", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "start", "stop", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingProgressBar.kt */
public final class WalletLoadingProgressBar extends View implements ValueAnimator.AnimatorUpdateListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f35648g = UiUtils.Companion.getScreenWidth();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final int f35649h = UiUtils.Companion.intSize(4);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f35650i = Color.parseColor("#FF5B1D");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final int f35651j = Color.parseColor("#FF7F41");
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final int f35652k = Color.parseColor("#FF7C3E");
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final int f35653l = Color.parseColor("#FDFF00");
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final float f35654m = UiUtils.Companion.floatSize(125);

    /* renamed from: n */
    private static final long f35655n = 1200;

    /* renamed from: o */
    private static final float f35656o = 0.0f;

    /* renamed from: p */
    private static final float f35657p = ((float) f35648g);
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static final float f35658q = ((float) (f35649h / 2));

    /* renamed from: a */
    private int f35659a;

    /* renamed from: b */
    private final Lazy f35660b;

    /* renamed from: c */
    private boolean f35661c;

    /* renamed from: d */
    private final Lazy f35662d;

    /* renamed from: e */
    private final Lazy f35663e;

    /* renamed from: f */
    private final Lazy f35664f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletLoadingProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletLoadingProgressBar$Companion;", "", "()V", "ANIM_DURATION", "", "bgEndColor", "", "bgEndX", "", "bgStartColor", "bgStartX", "bgStartY", "maxHeight", "getMaxHeight", "()I", "maxWidth", "getMaxWidth", "progressEndColor", "progressStartColor", "progressWidth", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletLoadingProgressBar.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMaxWidth() {
            return WalletLoadingProgressBar.f35648g;
        }

        public final int getMaxHeight() {
            return WalletLoadingProgressBar.f35649h;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletLoadingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35660b = LazyKt.lazy(new WalletLoadingProgressBar$animator$2(this));
        this.f35662d = LazyKt.lazy(WalletLoadingProgressBar$bgShader$2.INSTANCE);
        this.f35663e = LazyKt.lazy(WalletLoadingProgressBar$progressShader$2.INSTANCE);
        this.f35664f = LazyKt.lazy(WalletLoadingProgressBar$paint$2.INSTANCE);
    }

    public final void start() {
        ValueAnimator animator = getAnimator();
        if (animator != null) {
            animator.start();
        }
    }

    public final void stop() {
        ValueAnimator animator = getAnimator();
        if (animator != null) {
            animator.cancel();
        }
    }

    private final ValueAnimator getAnimator() {
        return (ValueAnimator) this.f35660b.getValue();
    }

    private final LinearGradient getBgShader() {
        return (LinearGradient) this.f35662d.getValue();
    }

    private final LinearGradient getProgressShader() {
        return (LinearGradient) this.f35663e.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.f35664f.getValue();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(f35648g, 1073741824), View.MeasureSpec.makeMeasureSpec(f35649h, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        if (getAnimator() == null || getAnimator().isRunning()) {
            float f = (((float) this.f35659a) * f35657p) / ((float) 100);
            m26908a(canvas, f);
            m26909b(canvas, f);
        }
    }

    /* renamed from: a */
    private final void m26908a(Canvas canvas, float f) {
        getPaint().setShader(getBgShader());
        if (this.f35661c) {
            float f2 = f35658q;
            canvas.drawLine(0.0f, f2, f35657p, f2, getPaint());
            return;
        }
        float f3 = f35658q;
        canvas.drawLine(0.0f, f3, f, f3, getPaint());
    }

    /* renamed from: b */
    private final void m26909b(Canvas canvas, float f) {
        getPaint().setShader(getProgressShader());
        canvas.translate(f - f35654m, 0.0f);
        float f2 = f35658q;
        canvas.drawLine(0.0f, f2, f35654m, f2, getPaint());
        canvas.translate(0.0f, 0.0f);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            int intValue = num == null ? 100 : num.intValue();
            this.f35659a = intValue;
            if (!this.f35661c && intValue >= 99) {
                this.f35661c = true;
            }
            invalidate();
        }
    }
}
