package com.didi.globalsafetoolkit.business.triprecording.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.didi.passenger.C11267R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u001dR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/view/RecordWaveLine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_invalidateDelay", "", "_waveMinHeightBase", "", "_waveRadius", "<set-?>", "", "isStartAnimation", "()Z", "mMaxHeightBase", "mPaint", "Landroid/graphics/Paint;", "mRectF", "Landroid/graphics/RectF;", "mWaveColor", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "valueAnimatorOffset", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "start", "height", "stop", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: RecordWaveLine.kt */
public final class RecordWaveLine extends View {

    /* renamed from: a */
    private final long f25148a;

    /* renamed from: b */
    private final float f25149b;

    /* renamed from: c */
    private final float f25150c;

    /* renamed from: d */
    private int f25151d;

    /* renamed from: e */
    private float f25152e;

    /* renamed from: f */
    private Paint f25153f;

    /* renamed from: g */
    private final RectF f25154g;

    /* renamed from: h */
    private ValueAnimator f25155h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f25156i;

    /* renamed from: j */
    private volatile boolean f25157j;

    /* renamed from: k */
    private HashMap f25158k;

    public RecordWaveLine(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RecordWaveLine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f25158k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f25158k == null) {
            this.f25158k = new HashMap();
        }
        View view = (View) this.f25158k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f25158k.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordWaveLine(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordWaveLine(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f25148a = 1600;
        this.f25149b = 0.05f;
        this.f25150c = 10.0f;
        this.f25151d = -16776961;
        this.f25153f = new Paint();
        this.f25154g = new RectF();
        this.f25155h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f25156i = 1.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.SfRecordWaveView, 0, 0);
            Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.theme.obtainStyl…eView, 0, 0\n            )");
            this.f25151d = obtainStyledAttributes.getColor(0, -16776961);
        }
        this.f25153f.setColor(this.f25151d);
        this.f25153f.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
    }

    public final boolean isStartAnimation() {
        return this.f25157j;
    }

    public final void start(float f) {
        if (!this.f25157j) {
            this.f25152e = f;
            ValueAnimator valueAnimator = this.f25155h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "valueAnimator");
            valueAnimator.setDuration(300);
            ValueAnimator valueAnimator2 = this.f25155h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "valueAnimator");
            valueAnimator2.setRepeatCount(1);
            ValueAnimator valueAnimator3 = this.f25155h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator3, "valueAnimator");
            valueAnimator3.setRepeatMode(2);
            ValueAnimator valueAnimator4 = this.f25155h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator4, "valueAnimator");
            valueAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f25155h.addUpdateListener(new RecordWaveLine$start$1(this));
            this.f25155h.addListener(new RecordWaveLine$start$2(this));
            this.f25155h.start();
            this.f25157j = true;
        }
    }

    public final void stop() {
        this.f25155h.cancel();
        this.f25157j = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredHeight = this.f25152e * ((float) getMeasuredHeight()) * this.f25156i;
        if (measuredHeight < ((float) getMeasuredHeight()) * this.f25149b) {
            measuredHeight = ((float) getMeasuredHeight()) * this.f25149b;
        }
        float height = ((float) (getHeight() / 2)) - (measuredHeight / ((float) 2));
        this.f25154g.left = 0.0f;
        this.f25154g.top = height;
        this.f25154g.right = (float) getWidth();
        this.f25154g.bottom = measuredHeight + height;
        if (canvas != null) {
            RectF rectF = this.f25154g;
            float f = this.f25150c;
            canvas.drawRoundRect(rectF, f, f, this.f25153f);
        }
        if (this.f25157j) {
            postInvalidateDelayed(this.f25148a);
        }
    }
}
