package com.didi.map.global.flow.scene.order.bluetooth_meet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0006\u0010\u001f\u001a\u00020\u0017J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0006\u0010\"\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMRippleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CIRCLE_COLOR_FROM", "FROM_RADIUS", "", "STROKE_COLOR_FROM", "STROKE_WIDTH", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "curCircleColor", "curRadius", "curStrokeColor", "paint", "Landroid/graphics/Paint;", "cancel", "", "dp2px", "dp", "handleAnimationFraction", "value", "onDraw", "canvas", "Landroid/graphics/Canvas;", "reset", "setVisibility", "visibility", "start", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMRippleView.kt */
public final class BTMRippleView extends View {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final float f29055a;

    /* renamed from: b */
    private final float f29056b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f29057c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f29058d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f29059e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f29060f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f29061g;

    /* renamed from: h */
    private final Paint f29062h;

    /* renamed from: i */
    private final ValueAnimator f29063i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMRippleView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BTMRippleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BTMRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29055a = m22625b(30.0f);
        this.f29056b = m22625b(1.0f);
        this.f29057c = Color.parseColor("#19FFFFFF");
        int parseColor = Color.parseColor("#33FFFFFF");
        this.f29058d = parseColor;
        this.f29059e = this.f29055a;
        this.f29060f = this.f29057c;
        this.f29061g = parseColor;
        this.f29062h = new Paint();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 2.0f}).setDuration(2000);
        duration.setRepeatMode(1);
        duration.setRepeatCount(-1);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BTMRippleView.m22624a(BTMRippleView.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(duration, "");
        duration.addListener(new BTMRippleView$animator$lambda2$$inlined$addListener$default$1(this));
        Unit unit = Unit.INSTANCE;
        this.f29063i = duration;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22624a(BTMRippleView bTMRippleView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(bTMRippleView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            bTMRippleView.m22623a(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: a */
    private final void m22623a(float f) {
        if (0.0f <= f && f <= 1.0f) {
            float f2 = this.f29055a;
            this.f29059e = f2 + ((((float) (Math.min(getWidth(), getHeight()) / 2)) - f2) * f);
        }
        if (0.6f <= f && f <= 1.6f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            float f3 = ((float) 1) - (f - 0.6f);
            String format = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((int) (((double) f3) * 25.5d))}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            this.f29060f = Color.parseColor(format);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("#%02XFFFFFF", Arrays.copyOf(new Object[]{Integer.valueOf((int) (((float) 51) * f3))}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            this.f29061g = Color.parseColor(format2);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f29062h.setStyle(Paint.Style.FILL);
        this.f29062h.setColor(this.f29060f);
        if (canvas != null) {
            float f = (float) 2;
            canvas.drawCircle(((float) getWidth()) / f, ((float) getHeight()) / f, this.f29059e - this.f29056b, this.f29062h);
        }
    }

    public final void start() {
        if (!this.f29063i.isRunning()) {
            this.f29063i.start();
        }
    }

    public final void reset() {
        ValueAnimator valueAnimator = this.f29063i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f29059e = this.f29055a;
        this.f29060f = this.f29057c;
        this.f29061g = this.f29058d;
        invalidate();
    }

    public void setVisibility(int i) {
        if (i == 8 || i == 4) {
            reset();
        }
        super.setVisibility(i);
    }

    public final void cancel() {
        if (this.f29063i.isRunning()) {
            this.f29063i.cancel();
        }
    }

    /* renamed from: b */
    private final float m22625b(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }
}
