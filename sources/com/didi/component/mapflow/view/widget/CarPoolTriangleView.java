package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CarPoolTriangleView extends View {

    /* renamed from: a */
    private Paint f16357a;

    /* renamed from: b */
    private Path f16358b;

    public CarPoolTriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13709a();
    }

    /* renamed from: a */
    private void m13709a() {
        Paint paint = new Paint(1);
        this.f16357a = paint;
        paint.setColor(Color.parseColor("#27A5FF"));
        this.f16357a.setStrokeJoin(Paint.Join.ROUND);
        this.f16358b = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.f16358b.reset();
        this.f16358b.moveTo((float) (getWidth() / 2), 0.0f);
        this.f16358b.lineTo((float) getWidth(), (float) getHeight());
        this.f16358b.lineTo(0.0f, (float) getHeight());
        this.f16358b.close();
        canvas.drawPath(this.f16358b, this.f16357a);
    }
}
