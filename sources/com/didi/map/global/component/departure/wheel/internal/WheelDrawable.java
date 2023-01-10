package com.didi.map.global.component.departure.wheel.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.didi.map.global.component.departure.wheel.WheelView;

public class WheelDrawable extends Drawable {

    /* renamed from: a */
    private Paint f27697a;
    protected int mHeight;
    protected WheelView.WheelViewStyle mStyle;
    protected int mWidth;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    WheelDrawable(int i, int i2, WheelView.WheelViewStyle wheelViewStyle) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mStyle = wheelViewStyle;
        m21890a();
    }

    /* renamed from: a */
    private void m21890a() {
        Paint paint = new Paint();
        this.f27697a = paint;
        int i = -1;
        if (this.mStyle.backgroundColor != -1) {
            i = this.mStyle.backgroundColor;
        }
        paint.setColor(i);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.mWidth, (float) this.mHeight, this.f27697a);
    }
}
