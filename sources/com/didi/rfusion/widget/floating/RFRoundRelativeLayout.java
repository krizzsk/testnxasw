package com.didi.rfusion.widget.floating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;

class RFRoundRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private final Path f36331a;

    /* renamed from: b */
    private final Paint f36332b;

    /* renamed from: c */
    private final RectF f36333c;

    /* renamed from: d */
    private float f36334d;

    /* renamed from: e */
    private float f36335e;

    /* renamed from: f */
    private float f36336f;

    /* renamed from: g */
    private float f36337g;

    public RFRoundRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFRoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFRoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RFRoundRelativeLayout);
        this.f36334d = obtainStyledAttributes.getDimension(3, 0.0f);
        this.f36335e = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f36336f = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f36337g = obtainStyledAttributes.getDimension(1, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(2, -1.0f);
        if (dimension >= 0.0f) {
            setRadius(dimension);
        }
        obtainStyledAttributes.recycle();
        this.f36331a = new Path();
        this.f36332b = new Paint(1);
        this.f36333c = new RectF();
        this.f36332b.setAntiAlias(true);
        this.f36332b.setDither(true);
        this.f36332b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f) {
        this.f36337g = f;
        this.f36336f = f;
        this.f36335e = f;
        this.f36334d = f;
        postInvalidate();
    }

    public void setTopLeftRadius(float f) {
        this.f36334d = f;
        postInvalidate();
    }

    public void setTopRightRadius(float f) {
        this.f36335e = f;
        postInvalidate();
    }

    public void setBottomLeftRadius(float f) {
        this.f36336f = f;
        postInvalidate();
    }

    public void setBottomRightRadius(float f) {
        this.f36337g = f;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f36333c.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m27384b(canvas);
        } else {
            m27383a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m27386d(canvas);
        } else {
            m27385c(canvas);
        }
    }

    /* renamed from: a */
    private void m27383a(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f36333c, (Paint) null, 31);
        super.draw(canvas);
        canvas.drawPath(m27382a(), this.f36332b);
        canvas.restore();
    }

    /* renamed from: b */
    private void m27384b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m27382a());
        super.draw(canvas);
        canvas.restore();
    }

    /* renamed from: c */
    private void m27385c(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f36333c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(m27382a(), this.f36332b);
        canvas.restore();
    }

    /* renamed from: d */
    private void m27386d(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m27382a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m27382a() {
        this.f36331a.reset();
        Path path = this.f36331a;
        RectF rectF = this.f36333c;
        float f = this.f36334d;
        float f2 = this.f36335e;
        float f3 = this.f36336f;
        float f4 = this.f36337g;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        return this.f36331a;
    }
}
