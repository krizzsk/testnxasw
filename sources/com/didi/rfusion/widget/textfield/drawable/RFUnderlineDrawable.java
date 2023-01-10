package com.didi.rfusion.widget.textfield.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u0006J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/rfusion/widget/textfield/drawable/RFUnderlineDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "streamPaint", "Landroid/graphics/Paint;", "streamProgress", "", "streamRect", "Landroid/graphics/Rect;", "underlinePaint", "underlineRect", "underlineWidth", "", "completeStream", "", "draw", "canvas", "Landroid/graphics/Canvas;", "drawStream", "drawUnderline", "hasStream", "", "setStreamColor", "color", "setStreamProgress", "progress", "setStroke", "width", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFUnderlineDrawable.kt */
public final class RFUnderlineDrawable extends GradientDrawable {

    /* renamed from: a */
    private final Paint f36681a = new Paint();

    /* renamed from: b */
    private final Paint f36682b = new Paint();

    /* renamed from: c */
    private final Rect f36683c = new Rect();

    /* renamed from: d */
    private final Rect f36684d = new Rect();

    /* renamed from: e */
    private int f36685e = 1;

    /* renamed from: f */
    private float f36686f;

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.draw(canvas);
        m27663a(canvas);
        m27665b(canvas);
    }

    /* renamed from: a */
    private final void m27663a(Canvas canvas) {
        this.f36683c.set(getBounds());
        Rect rect = this.f36683c;
        rect.top = rect.bottom - this.f36685e;
        canvas.drawRect(this.f36683c, this.f36681a);
    }

    /* renamed from: b */
    private final void m27665b(Canvas canvas) {
        if (m27664a()) {
            this.f36684d.set(this.f36683c);
            int width = (int) (((float) this.f36683c.width()) * this.f36686f);
            this.f36684d.left = (this.f36683c.width() - width) / 2;
            Rect rect = this.f36684d;
            rect.right = rect.left + width;
            canvas.drawRect(this.f36684d, this.f36682b);
        }
    }

    /* renamed from: a */
    private final boolean m27664a() {
        return this.f36686f > 0.0f;
    }

    public void setStroke(int i, int i2) {
        this.f36685e = i;
        this.f36681a.setColor(i2);
        invalidateSelf();
    }

    public final void setStreamColor(int i) {
        this.f36682b.setColor(i);
        invalidateSelf();
    }

    public final void setStreamProgress(float f) {
        this.f36686f = f;
        invalidateSelf();
    }

    public final void completeStream() {
        this.f36686f = 0.0f;
        this.f36681a.setColor(this.f36682b.getColor());
    }
}
