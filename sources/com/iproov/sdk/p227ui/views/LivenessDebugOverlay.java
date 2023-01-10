package com.iproov.sdk.p227ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.iproov.sdk.ui.views.LivenessDebugOverlay */
public class LivenessDebugOverlay extends View {

    /* renamed from: a */
    private Rect f57263a;

    /* renamed from: b */
    private Rect f57264b;

    /* renamed from: c */
    private Rect f57265c;

    /* renamed from: d */
    private Rect f57266d;

    /* renamed from: e */
    private Paint f57267e;

    /* renamed from: f */
    private Paint f57268f;

    /* renamed from: g */
    private Paint f57269g;

    /* renamed from: h */
    private Paint f57270h;

    public LivenessDebugOverlay(Context context) {
        super(context);
        m43550a();
    }

    /* renamed from: a */
    private void m43550a() {
        Paint b = m43551b();
        this.f57267e = b;
        b.setColor(-16711936);
        Paint b2 = m43551b();
        this.f57268f = b2;
        b2.setColor(-65536);
        Paint b3 = m43551b();
        this.f57270h = b3;
        b3.setColor(-65281);
        Paint b4 = m43551b();
        this.f57269g = b4;
        b4.setColor(-16776961);
    }

    /* renamed from: do */
    public void mo171593do(Rect rect) {
        this.f57265c = rect;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: if */
    public void mo171596if(Rect rect) {
        this.f57263a = rect;
    }

    /* renamed from: new  reason: not valid java name */
    public void m48153new(Rect rect) {
        this.f57266d = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.f57263a;
        if (rect != null) {
            canvas.drawRect(rect, this.f57267e);
            canvas.drawCircle(this.f57263a.exactCenterX(), this.f57263a.exactCenterY(), 4.0f, this.f57267e);
        }
        Rect rect2 = this.f57264b;
        if (rect2 != null) {
            canvas.drawRect(rect2, this.f57268f);
            canvas.drawCircle(this.f57264b.exactCenterX(), this.f57264b.exactCenterY(), 4.0f, this.f57268f);
        }
        Rect rect3 = this.f57265c;
        if (rect3 != null) {
            canvas.drawRect(rect3, this.f57269g);
            canvas.drawCircle(this.f57265c.exactCenterX(), this.f57265c.exactCenterY(), 4.0f, this.f57269g);
        }
        Rect rect4 = this.f57266d;
        if (rect4 != null) {
            canvas.drawRect(rect4, this.f57270h);
        }
    }

    /* renamed from: b */
    private static Paint m43551b() {
        Paint paint = new Paint();
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    /* renamed from: if */
    public void mo171595if() {
        invalidate();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43550a();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m43550a();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m43550a();
    }

    /* renamed from: for  reason: not valid java name */
    public void m48152for(Rect rect) {
        this.f57264b = rect;
    }
}
