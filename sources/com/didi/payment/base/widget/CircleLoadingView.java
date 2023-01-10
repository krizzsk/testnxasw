package com.didi.payment.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.base.utils.UIUtil;

public class CircleLoadingView extends AppCompatTextView {

    /* renamed from: f */
    private static double f32573f = 10.0d;

    /* renamed from: a */
    private Paint f32574a;

    /* renamed from: b */
    private int f32575b = Color.parseColor("#CCCCCC");

    /* renamed from: c */
    private int f32576c = Color.parseColor("#FF6F26");

    /* renamed from: d */
    private int f32577d = 10;

    /* renamed from: e */
    private double f32578e = 4.0d;

    /* renamed from: g */
    private RectF f32579g;

    public CircleLoadingView(Context context) {
        super(context);
        m24704a();
    }

    public CircleLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24704a();
    }

    public CircleLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24704a();
    }

    public void setProgress(double d) {
        this.f32578e = d;
    }

    /* renamed from: a */
    private void m24704a() {
        Paint paint = new Paint();
        this.f32574a = paint;
        paint.setColor(this.f32575b);
        this.f32574a.setStyle(Paint.Style.STROKE);
        this.f32574a.setAntiAlias(true);
        this.f32574a.setStrokeWidth((float) this.f32577d);
        this.f32577d = UIUtil.dip2px(getContext(), 10.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f32574a.setColor(this.f32575b);
        int i = measuredWidth / 2;
        canvas.drawCircle((float) i, (float) (measuredHeight / 2), (float) (i - this.f32577d), this.f32574a);
        int i2 = (int) ((this.f32578e / f32573f) * 360.0d);
        if (this.f32579g == null) {
            int i3 = this.f32577d;
            this.f32579g = new RectF((float) i3, (float) i3, (float) (measuredWidth - i3), (float) (measuredHeight - i3));
        }
        this.f32574a.setColor(this.f32576c);
        canvas.drawArc(this.f32579g, 0.0f, (float) i2, false, this.f32574a);
    }
}
