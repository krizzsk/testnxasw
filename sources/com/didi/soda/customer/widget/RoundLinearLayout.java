package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

public class RoundLinearLayout extends LinearLayout {

    /* renamed from: a */
    private final Path f44175a;

    /* renamed from: b */
    private final Paint f44176b;

    /* renamed from: c */
    private final RectF f44177c;

    /* renamed from: d */
    private float f44178d;

    /* renamed from: e */
    private float f44179e;

    /* renamed from: f */
    private float f44180f;

    /* renamed from: g */
    private float f44181g;

    public RoundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44175a = new Path();
        this.f44176b = new Paint(1);
        this.f44177c = new RectF();
        this.f44176b.setAntiAlias(true);
        this.f44176b.setDither(true);
        this.f44176b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f) {
        this.f44181g = f;
        this.f44180f = f;
        this.f44179e = f;
        this.f44178d = f;
        postInvalidate();
    }

    public void setTopLeftRadius(float f) {
        this.f44178d = f;
        postInvalidate();
    }

    public void setTopRightRadius(float f) {
        this.f44179e = f;
        postInvalidate();
    }

    public void setBottomLeftRadius(float f) {
        this.f44180f = f;
        postInvalidate();
    }

    public void setBottomRightRadius(float f) {
        this.f44181g = f;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f44177c.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m32880b(canvas);
        } else {
            m32879a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m32882d(canvas);
        } else {
            m32881c(canvas);
        }
    }

    /* renamed from: a */
    private void m32879a(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f44177c, (Paint) null, 31);
        super.draw(canvas);
        canvas.drawPath(m32878a(), this.f44176b);
        canvas.restore();
    }

    /* renamed from: b */
    private void m32880b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m32878a());
        super.draw(canvas);
        canvas.restore();
    }

    /* renamed from: c */
    private void m32881c(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f44177c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(m32878a(), this.f44176b);
        canvas.restore();
    }

    /* renamed from: d */
    private void m32882d(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m32878a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m32878a() {
        this.f44175a.reset();
        Path path = this.f44175a;
        RectF rectF = this.f44177c;
        float f = this.f44178d;
        float f2 = this.f44179e;
        float f3 = this.f44180f;
        float f4 = this.f44181g;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        return this.f44175a;
    }
}
