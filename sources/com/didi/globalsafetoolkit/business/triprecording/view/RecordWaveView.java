package com.didi.globalsafetoolkit.business.triprecording.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.didi.passenger.C11267R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0006\u0010&\u001a\u00020\u0018J\u0006\u0010'\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/view/RecordWaveView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_waveCount", "<set-?>", "", "isAnimation", "()Z", "mValueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "mWaveLineList", "Ljava/util/ArrayList;", "Lcom/didi/globalsafetoolkit/business/triprecording/view/RecordWaveLine;", "Lkotlin/collections/ArrayList;", "mWaveSpace", "mWaveWidth", "onLayout", "", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "start", "stop", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: RecordWaveView.kt */
public final class RecordWaveView extends ViewGroup {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f25159a;

    /* renamed from: b */
    private int f25160b;

    /* renamed from: c */
    private int f25161c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ArrayList<RecordWaveLine> f25162d;

    /* renamed from: e */
    private ValueAnimator f25163e;

    /* renamed from: f */
    private volatile boolean f25164f;

    /* renamed from: g */
    private HashMap f25165g;

    public RecordWaveView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RecordWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f25165g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f25165g == null) {
            this.f25165g = new HashMap();
        }
        View view = (View) this.f25165g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f25165g.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordWaveView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f25159a = 30;
        this.f25160b = 30;
        this.f25161c = 20;
        this.f25162d = new ArrayList<>();
        int i2 = 0;
        this.f25163e = ValueAnimator.ofInt(new int[]{1, this.f25159a - 2});
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.SfRecordWaveView, 0, 0);
            Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.theme.obtainStyl…eView, 0, 0\n            )");
            this.f25161c = (int) obtainStyledAttributes.getDimension(1, 20.0f);
        }
        int i3 = this.f25159a;
        if (i3 >= 0) {
            while (true) {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "getContext()");
                RecordWaveLine recordWaveLine = new RecordWaveLine(context2, attributeSet, i);
                recordWaveLine.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
                this.f25162d.add(recordWaveLine);
                addView(recordWaveLine);
                if (i2 != i3) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean isAnimation() {
        return this.f25164f;
    }

    public final void start() {
        if (!this.f25164f) {
            ValueAnimator valueAnimator = this.f25163e;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator, "mValueAnimator");
            valueAnimator.setDuration(100);
            ValueAnimator valueAnimator2 = this.f25163e;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator2, "mValueAnimator");
            valueAnimator2.setRepeatCount(-1);
            ValueAnimator valueAnimator3 = this.f25163e;
            Intrinsics.checkExpressionValueIsNotNull(valueAnimator3, "mValueAnimator");
            valueAnimator3.setInterpolator(new LinearInterpolator());
            this.f25163e.addUpdateListener(new RecordWaveView$start$1(this));
            this.f25163e.start();
            this.f25164f = true;
        }
    }

    public final void stop() {
        this.f25164f = false;
        this.f25163e.cancel();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Iterator<RecordWaveLine> it = this.f25162d.iterator();
        while (it.hasNext()) {
            measureChild(it.next(), i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.f25159a;
        this.f25160b = (i - (this.f25161c * i5)) / (i5 + 2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.f25160b;
        Iterator<RecordWaveLine> it = this.f25162d.iterator();
        while (it.hasNext()) {
            it.next().layout(i5, 0, this.f25161c + i5, getMeasuredHeight());
            i5 += this.f25161c + this.f25160b;
        }
    }
}
