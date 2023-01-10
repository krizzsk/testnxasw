package com.didichuxing.xpanel.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class XPanelCardLayout extends FrameLayout {

    /* renamed from: a */
    private Drawable f51898a;

    /* renamed from: b */
    private int f51899b;

    /* renamed from: c */
    private int f51900c;

    /* renamed from: d */
    private int f51901d;

    /* renamed from: e */
    private int f51902e;

    public XPanelCardLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBgDrawable(Drawable drawable, int i, int i2, int i3, int i4) {
        this.f51898a = drawable;
        this.f51899b = i2;
        this.f51902e = i4;
        this.f51900c = i;
        this.f51901d = i3;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        if (!(this.f51898a == null || (childAt = getChildAt(0)) == null)) {
            int save = canvas.save();
            canvas.translate((float) (childAt.getLeft() - this.f51900c), (float) (childAt.getTop() - this.f51899b));
            this.f51898a.setBounds(0, 0, childAt.getWidth() + this.f51901d + this.f51900c, childAt.getHeight() + this.f51902e + this.f51899b);
            this.f51898a.draw(canvas);
            canvas.restoreToCount(save);
        }
        super.dispatchDraw(canvas);
    }
}
