package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.dcrypto.util.ColorUtils;

public class CarPoolTriangleView extends View {

    /* renamed from: a */
    private Paint f27578a;

    /* renamed from: b */
    private Path f27579b;

    public CarPoolTriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21812a();
    }

    /* renamed from: a */
    private void m21812a() {
        Paint paint = new Paint(1);
        this.f27578a = paint;
        paint.setColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        this.f27578a.setStrokeJoin(Paint.Join.ROUND);
        this.f27579b = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.f27579b.reset();
        this.f27579b.moveTo((float) (getWidth() / 2), 0.0f);
        this.f27579b.lineTo((float) getWidth(), (float) getHeight());
        this.f27579b.lineTo(0.0f, (float) getHeight());
        this.f27579b.close();
        canvas.drawPath(this.f27579b, this.f27578a);
    }
}
