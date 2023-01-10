package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

public class RoundedLinearLayout extends LinearLayout {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_RIGHT_CORNER = 3;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private int f34925a = 0;

    /* renamed from: b */
    private final RectF f34926b = new RectF();

    /* renamed from: c */
    private float f34927c;

    /* renamed from: d */
    private final Paint f34928d = new Paint();

    /* renamed from: e */
    private final Paint f34929e = new Paint();

    public RoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26668a();
    }

    public RoundedLinearLayout(Context context) {
        super(context);
        m26668a();
    }

    /* renamed from: a */
    private void m26668a() {
        this.f34928d.setAntiAlias(true);
        this.f34928d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f34929e.setAntiAlias(true);
        this.f34929e.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f34925a = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f34927c = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f34926b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f34926b, this.f34929e, 31);
        RectF rectF = this.f34926b;
        float f = this.f34927c;
        canvas.drawRoundRect(rectF, f, f, this.f34929e);
        int i = this.f34925a;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f34927c, (float) getWidth(), (float) getHeight(), this.f34929e);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f34927c, this.f34929e);
        } else if (i == 3) {
            canvas.drawRect(0.0f, 0.0f, ((float) getWidth()) - this.f34927c, (float) getHeight(), this.f34929e);
        }
        SystemUtils.saveLayer(canvas, this.f34926b, this.f34928d, 31);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
