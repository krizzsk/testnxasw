package com.didi.payment.commonsdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.sdk.apm.SystemUtils;

public class RoundedImageView extends ImageView {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_RIGHT_CORNER = 3;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private int f32673a = 0;

    /* renamed from: b */
    private final RectF f32674b = new RectF();

    /* renamed from: c */
    private float f32675c;

    /* renamed from: d */
    private final Paint f32676d = new Paint();

    /* renamed from: e */
    private final Paint f32677e = new Paint();

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24745a();
    }

    public RoundedImageView(Context context) {
        super(context);
        m24745a();
    }

    /* renamed from: a */
    private void m24745a() {
        this.f32676d.setAntiAlias(true);
        this.f32676d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f32677e.setAntiAlias(true);
        this.f32677e.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f32673a = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f32675c = f;
        invalidate();
    }

    public void setRectRedius(float f) {
        this.f32675c = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f32674b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f32674b, this.f32677e, 31);
        RectF rectF = this.f32674b;
        float f = this.f32675c;
        canvas.drawRoundRect(rectF, f, f, this.f32677e);
        int i = this.f32673a;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f32675c, (float) getWidth(), (float) getHeight(), this.f32677e);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f32675c, this.f32677e);
        } else if (i == 3) {
            canvas.drawRect(0.0f, 0.0f, ((float) getWidth()) - this.f32675c, (float) getHeight(), this.f32677e);
        }
        SystemUtils.saveLayer(canvas, this.f32674b, this.f32676d, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
