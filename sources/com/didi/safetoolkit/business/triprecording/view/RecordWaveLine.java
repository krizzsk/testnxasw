package com.didi.safetoolkit.business.triprecording.view;

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

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u001dR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/safetoolkit/business/triprecording/view/RecordWaveLine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_invalidateDelay", "", "_waveMinHeightBase", "", "_waveRadius", "<set-?>", "", "isStartAnimation", "()Z", "mMaxHeightBase", "mPaint", "Landroid/graphics/Paint;", "mRectF", "Landroid/graphics/RectF;", "mWaveColor", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "valueAnimatorOffset", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "start", "height", "stop", "safe-toolkit_passengerRelease"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: RecordWaveLine.kt */
public final class RecordWaveLine extends View {

    /* renamed from: a */
    private final long f37258a;

    /* renamed from: b */
    private final float f37259b;

    /* renamed from: c */
    private final float f37260c;

    /* renamed from: d */
    private int f37261d;

    /* renamed from: e */
    private float f37262e;

    /* renamed from: f */
    private Paint f37263f;

    /* renamed from: g */
    private final RectF f37264g;

    /* renamed from: h */
    private ValueAnimator f37265h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f37266i;

    /* renamed from: j */
    private volatile boolean f37267j;

    /* renamed from: k */
    private HashMap f37268k;

    public RecordWaveLine(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RecordWaveLine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f37268k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f37268k == null) {
            this.f37268k = new HashMap();
        }
        View view = (View) this.f37268k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f37268k.put(Integer.valueOf(i), findViewById);
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
        this.f37258a = 1600;
        this.f37259b = 0.05f;
        this.f37260c = 10.0f;
        this.f37261d = -16776961;
        this.f37263f = new Paint();
        this.f37264g = new RectF();
        this.f37265h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f37266i = 1.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.SfRecordWaveView, 0, 0);
            Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.theme.obtainStyl…eView, 0, 0\n            )");
            this.f37261d = obtainStyledAttributes.getColor(0, -16776961);
        }
        this.f37263f.setColor(this.f37261d);
        this.f37263f.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
    }

    public final boolean isStartAnimation() {
        return this.f37267j;
    }

    public final void start(float f) {
        if (!this.f37267j) {
            this.f37262e = f;
            ValueAnimator valueAnimator = this.f37265h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "valueAnimator");
            valueAnimator.setDuration(300);
            ValueAnimator valueAnimator2 = this.f37265h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "valueAnimator");
            valueAnimator2.setRepeatCount(1);
            ValueAnimator valueAnimator3 = this.f37265h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator3, "valueAnimator");
            valueAnimator3.setRepeatMode(2);
            ValueAnimator valueAnimator4 = this.f37265h;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator4, "valueAnimator");
            valueAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f37265h.addUpdateListener(new RecordWaveLine$start$1(this));
            this.f37265h.addListener(new RecordWaveLine$start$2(this));
            this.f37265h.start();
            this.f37267j = true;
        }
    }

    public final void stop() {
        this.f37265h.cancel();
        this.f37267j = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredHeight = this.f37262e * ((float) getMeasuredHeight()) * this.f37266i;
        if (measuredHeight < ((float) getMeasuredHeight()) * this.f37259b) {
            measuredHeight = ((float) getMeasuredHeight()) * this.f37259b;
        }
        float height = ((float) (getHeight() / 2)) - (measuredHeight / ((float) 2));
        this.f37264g.left = 0.0f;
        this.f37264g.top = height;
        this.f37264g.right = (float) getWidth();
        this.f37264g.bottom = measuredHeight + height;
        if (canvas != null) {
            RectF rectF = this.f37264g;
            float f = this.f37260c;
            canvas.drawRoundRect(rectF, f, f, this.f37263f);
        }
        if (this.f37267j) {
            postInvalidateDelayed(this.f37258a);
        }
    }
}
