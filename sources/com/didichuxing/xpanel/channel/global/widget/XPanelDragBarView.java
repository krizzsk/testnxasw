package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

public class XPanelDragBarView extends View {

    /* renamed from: d */
    private static final int f51968d = 40;

    /* renamed from: e */
    private static final int f51969e = 5;

    /* renamed from: a */
    private float f51970a;

    /* renamed from: b */
    private float f51971b;

    /* renamed from: c */
    private Paint f51972c;

    /* renamed from: f */
    private RectF f51973f;

    /* renamed from: g */
    private float f51974g;

    /* renamed from: h */
    private float f51975h;

    public XPanelDragBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelDragBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelDragBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51972c = null;
        this.f51973f = new RectF();
        this.f51974g = 0.0f;
        this.f51975h = 0.0f;
        m39124a();
    }

    /* renamed from: a */
    private void m39124a() {
        this.f51970a = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_triangle_width);
        this.f51971b = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_triangle_height);
        this.f51974g = (float) getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_radius);
        Paint paint = new Paint();
        this.f51972c = paint;
        paint.setAntiAlias(true);
        this.f51972c.setStyle(Paint.Style.FILL);
        this.f51972c.setDither(true);
        this.f51972c.setColor(getResources().getColor(R.color.oc_color_1A000000));
    }

    /* access modifiers changed from: protected */
    public final void setDragAngle(float f) {
        this.f51975h = f;
        if (getVisibility() == 0) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public float getDragAngle() {
        return this.f51975h;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f51973f.top = (((float) (i4 - i2)) - this.f51971b) / 2.0f;
        RectF rectF = this.f51973f;
        rectF.left = (((float) (i3 - i)) - this.f51970a) / 2.0f;
        RectF rectF2 = this.f51973f;
        rectF2.bottom = rectF2.top + this.f51971b;
        RectF rectF3 = this.f51973f;
        rectF3.right = rectF3.left + this.f51970a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m39125a(canvas);
    }

    /* renamed from: a */
    private void m39125a(Canvas canvas) {
        Canvas canvas2 = canvas;
        float f = this.f51975h;
        if (f == 180.0f) {
            RectF rectF = this.f51973f;
            float f2 = this.f51974g;
            canvas2.drawRoundRect(rectF, f2, f2, this.f51972c);
            return;
        }
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        RectF rectF2 = new RectF(this.f51973f);
        rectF2.right = ((rectF2.right - rectF2.left) / 2.0f) + rectF2.left;
        float f3 = this.f51974g;
        path.addRoundRect(rectF2, new float[]{f3, f3, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3}, Path.Direction.CCW);
        Path path2 = new Path();
        path2.setFillType(Path.FillType.WINDING);
        RectF rectF3 = new RectF(this.f51973f);
        rectF3.left += (rectF3.right - rectF3.left) / 2.0f;
        float f4 = this.f51974g;
        path2.addRoundRect(rectF3, new float[]{0.0f, 0.0f, f4, f4, f4, f4, 0.0f, 0.0f}, Path.Direction.CCW);
        RectF rectF4 = new RectF();
        float f5 = rectF2.bottom - rectF2.top;
        rectF4.left = rectF2.right - f5;
        rectF4.top = rectF2.top - f5;
        rectF4.right = rectF2.right + f5;
        rectF4.bottom = rectF2.top + f5;
        float f6 = 180.0f - f;
        float f7 = f6 / 2.0f;
        float sin = (float) ((Math.sin(Math.toRadians((double) f7)) * ((double) (rectF2.right - rectF2.left))) / 2.0d);
        canvas2.translate(0.0f, sin);
        float f8 = f6;
        RectF rectF5 = rectF3;
        canvas.drawArc(rectF4, 90.0f - f7, f8, true, this.f51972c);
        canvas.save();
        canvas2.rotate(f7, rectF2.right, rectF2.top);
        canvas2.drawPath(path, this.f51972c);
        canvas.restore();
        canvas.save();
        canvas2.rotate(-f7, rectF5.left, rectF5.top);
        canvas2.drawPath(path2, this.f51972c);
        canvas.restore();
        canvas2.translate(0.0f, -sin);
    }
}
