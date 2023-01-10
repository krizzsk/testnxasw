package com.didi.rfusion.widget.textfield.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/rfusion/widget/textfield/drawable/RFCutoutDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "cutoutPaint", "Landroid/graphics/Paint;", "cutoutRect", "Landroid/graphics/RectF;", "savedLayer", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "hasCutout", "", "postDraw", "preDraw", "removeCutout", "saveCanvasLayer", "setCutout", "bounds", "left", "", "top", "right", "bottom", "useHardwareLayer", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFCutoutDrawable.kt */
public final class RFCutoutDrawable extends GradientDrawable {

    /* renamed from: a */
    private final RectF f36678a = new RectF();

    /* renamed from: b */
    private int f36679b;

    /* renamed from: c */
    private final Paint f36680c;

    public RFCutoutDrawable() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(RFResUtils.getColor(R.color.rf_color_white_100));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f36680c = paint;
    }

    public final void setCutout(RectF rectF) {
        Intrinsics.checkParameterIsNotNull(rectF, "bounds");
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void setCutout(float f, float f2, float f3, float f4) {
        if (f != this.f36678a.left || f2 != this.f36678a.top || f3 != this.f36678a.right || f4 != this.f36678a.bottom) {
            this.f36678a.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }

    public final boolean hasCutout() {
        return !this.f36678a.isEmpty();
    }

    public final void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        m27659a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f36678a, this.f36680c);
        m27662c(canvas);
    }

    /* renamed from: a */
    private final void m27659a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (m27660a(callback)) {
            View view = (View) callback;
            if (view == null) {
                Intrinsics.throwNpe();
            }
            if (view.getLayerType() != 2) {
                view.setLayerType(2, (Paint) null);
                return;
            }
            return;
        }
        m27661b(canvas);
    }

    /* renamed from: b */
    private final void m27661b(Canvas canvas) {
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            i = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        } else {
            i = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }
        this.f36679b = i;
    }

    /* renamed from: c */
    private final void m27662c(Canvas canvas) {
        if (!m27660a(getCallback())) {
            canvas.restoreToCount(this.f36679b);
        }
    }

    /* renamed from: a */
    private final boolean m27660a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
