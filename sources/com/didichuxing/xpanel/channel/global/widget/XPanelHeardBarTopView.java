package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class XPanelHeardBarTopView extends View {

    /* renamed from: a */
    private Rect f51998a = new Rect();

    /* renamed from: b */
    private Paint f51999b = new Paint();

    public XPanelHeardBarTopView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f51999b = paint;
        paint.setAntiAlias(true);
        this.f51999b.setStyle(Paint.Style.FILL);
        this.f51999b.setColor(0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f51998a.left = getPaddingLeft();
        this.f51998a.top = getPaddingTop();
        Rect rect = this.f51998a;
        rect.right = (rect.left + getMeasuredWidth()) - getPaddingRight();
        Rect rect2 = this.f51998a;
        rect2.bottom = (rect2.top + getMeasuredHeight()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f51998a, this.f51999b);
    }

    public void setDrawColor(int i) {
        this.f51999b.setColor(i);
        invalidate();
    }
}
