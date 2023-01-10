package com.didichuxing.cardscan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.didichuxing.cardscan.view.a */
public class C16004a extends ViewGroup {

    /* renamed from: b */
    static final /* synthetic */ boolean f48881b = (!C16004a.class.desiredAssertionStatus());

    /* renamed from: a */
    SurfaceView f48882a;

    public C16004a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48882a = new SurfaceView(context);
        addView(this.f48882a, new ViewGroup.LayoutParams(-1, -1));
    }

    public SurfaceHolder getSurfaceHolder() {
        SurfaceHolder holder = getSurfaceView().getHolder();
        if (f48881b || holder != null) {
            return holder;
        }
        throw new AssertionError();
    }

    public SurfaceView getSurfaceView() {
        if (f48881b || this.f48882a != null) {
            return this.f48882a;
        }
        throw new AssertionError();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255, 255, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && getChildCount() > 0) {
            if (f48881b || this.f48882a != null) {
                this.f48882a.layout(0, 0, i3 - i, i4 - i2);
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = resolveSize(getSuggestedMinimumHeight(), i2);
        this.f48882a.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize2, 1073741824));
        setMeasuredDimension(resolveSize, resolveSize2);
    }
}
