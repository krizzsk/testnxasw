package com.didi.safety.god.p145ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.didi.safety.god.ui.HollowEffectView */
public class HollowEffectView extends View {

    /* renamed from: b */
    private static final int f37526b = -16777216;

    /* renamed from: a */
    private Paint f37527a;

    /* renamed from: c */
    private View f37528c;

    /* renamed from: d */
    private Rect f37529d;

    /* renamed from: e */
    private Rect f37530e;

    /* renamed from: f */
    private Rect f37531f;

    /* renamed from: g */
    private Rect f37532g;

    public HollowEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28279a();
    }

    /* renamed from: a */
    private void m28279a() {
        Paint paint = new Paint(1);
        this.f37527a = paint;
        paint.setColor(-16777216);
    }

    public void setTargetView(View view) {
        this.f37528c = view;
        setVisibility(0);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f37528c != null) {
            if (this.f37529d == null) {
                this.f37529d = new Rect(0, 0, this.f37528c.getLeft(), getHeight());
                this.f37530e = new Rect(this.f37528c.getLeft(), 0, this.f37528c.getRight(), this.f37528c.getTop());
                this.f37531f = new Rect(this.f37528c.getRight(), 0, getWidth(), getHeight());
                this.f37532g = new Rect(this.f37528c.getLeft(), this.f37528c.getBottom(), this.f37528c.getRight(), getHeight());
            }
            canvas.drawRect(this.f37529d, this.f37527a);
            canvas.drawRect(this.f37530e, this.f37527a);
            canvas.drawRect(this.f37531f, this.f37527a);
            canvas.drawRect(this.f37532g, this.f37527a);
        }
    }
}
