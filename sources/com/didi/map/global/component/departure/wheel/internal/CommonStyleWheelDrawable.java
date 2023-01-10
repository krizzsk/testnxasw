package com.didi.map.global.component.departure.wheel.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.didi.map.global.component.departure.wheel.WheelView;

public class CommonStyleWheelDrawable extends WheelDrawable {

    /* renamed from: a */
    private Paint f27691a;

    /* renamed from: b */
    private Paint f27692b;

    /* renamed from: c */
    private int f27693c;

    /* renamed from: d */
    private int f27694d;

    public CommonStyleWheelDrawable(int i, int i2, WheelView.WheelViewStyle wheelViewStyle, int i3, int i4) {
        super(i, i2, wheelViewStyle);
        this.f27693c = i3;
        this.f27694d = i4;
        m21888a();
    }

    /* renamed from: a */
    private void m21888a() {
        Paint paint = new Paint();
        this.f27691a = paint;
        paint.setColor(this.mStyle.backgroundColor != -1 ? this.mStyle.backgroundColor : -1);
        Paint paint2 = new Paint();
        this.f27692b = paint2;
        paint2.setStrokeWidth(this.mStyle.holoBorderWidth != -1 ? (float) this.mStyle.holoBorderWidth : 3.0f);
        this.f27692b.setColor(this.mStyle.holoBorderColor != -1 ? this.mStyle.holoBorderColor : WheelConstants.WHEEL_SKIN_HOLO_BORDER_COLOR);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.mWidth, (float) this.mHeight, this.f27691a);
        int i = this.f27694d;
        if (i != 0) {
            int i2 = this.f27693c >> 1;
            canvas.drawLine(0.0f, (float) (i * i2), (float) this.mWidth, (float) (this.f27694d * i2), this.f27692b);
            int i3 = i2 + 1;
            canvas.drawLine(0.0f, (float) (this.f27694d * i3), (float) this.mWidth, (float) (this.f27694d * i3), this.f27692b);
        }
    }
}
