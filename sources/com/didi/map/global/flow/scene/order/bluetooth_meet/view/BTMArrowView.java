package com.didi.map.global.flow.scene.order.bluetooth_meet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010%\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010&\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010'\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u000e\u0010(\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMArrowView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ARC_COLOR", "ARC_WIDTH", "", "CIRCLE_ARC_PADDING", "FILLED_CIRCLE_COLOR", "FILLED_CIRCLE_RADIUS", "HOLLOW_CIRCLE_COLOR", "HOLLOW_CIRCLE_RADIUS", "HOLLOW_CIRCLE_STOKEN_WIDTH", "degree", "iconBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "isShowArc", "", "paint", "Landroid/graphics/Paint;", "angleToCoordinate", "Lkotlin/Pair;", "radius", "angle", "dp2px", "dp", "drawArc", "", "canvas", "Landroid/graphics/Canvas;", "drawArrow", "drawFillCircle", "drawHollowCircle", "onDraw", "setAngle", "showArch", "show", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMArrowView.kt */
public final class BTMArrowView extends View {

    /* renamed from: a */
    private final Paint f29031a;

    /* renamed from: b */
    private final float f29032b;

    /* renamed from: c */
    private final float f29033c;

    /* renamed from: d */
    private final int f29034d;

    /* renamed from: e */
    private final float f29035e;

    /* renamed from: f */
    private final int f29036f;

    /* renamed from: g */
    private final float f29037g;

    /* renamed from: h */
    private final int f29038h;

    /* renamed from: i */
    private final float f29039i;

    /* renamed from: j */
    private float f29040j;

    /* renamed from: k */
    private final Bitmap f29041k;

    /* renamed from: l */
    private boolean f29042l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMArrowView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BTMArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BTMArrowView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BTMArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29031a = new Paint(1);
        this.f29032b = m22614a(11.0f);
        this.f29033c = m22614a(3.0f);
        this.f29034d = Color.parseColor("#66FFFFFF");
        this.f29035e = m22614a(8.0f);
        this.f29036f = -1;
        this.f29037g = m22614a(25.0f) / ((float) 2);
        this.f29038h = -1;
        this.f29039i = 10.0f;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.btm_arrow);
        if (drawable != null) {
            this.f29041k = ((BitmapDrawable) drawable).getBitmap();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    public final void setAngle(float f) {
        this.f29040j = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m22619d(canvas);
        if (this.f29042l) {
            m22618c(canvas);
        }
        m22617b(canvas);
        m22616a(canvas);
    }

    public final void showArch(boolean z) {
        this.f29042l = z;
        invalidate();
    }

    /* renamed from: a */
    private final void m22616a(Canvas canvas) {
        Rect rect = new Rect(0, 0, this.f29041k.getWidth(), this.f29041k.getHeight());
        Rect rect2 = new Rect((getWidth() / 2) - (this.f29041k.getWidth() / 2), (getHeight() / 2) - (this.f29041k.getHeight() / 2), (getWidth() / 2) + (this.f29041k.getWidth() / 2), (getHeight() / 2) + (this.f29041k.getHeight() / 2));
        if (canvas != null) {
            canvas.save();
        }
        this.f29031a.setStyle(Paint.Style.FILL);
        if (canvas != null) {
            float f = (float) 2;
            canvas.rotate(this.f29040j, ((float) getWidth()) / f, ((float) getHeight()) / f);
        }
        if (canvas != null) {
            canvas.drawBitmap(this.f29041k, rect, rect2, (Paint) null);
        }
        if (canvas != null) {
            canvas.restore();
        }
    }

    /* renamed from: b */
    private final void m22617b(Canvas canvas) {
        float f = this.f29040j % ((float) 360);
        float width = (((float) getWidth()) / ((float) 2)) - this.f29037g;
        this.f29031a.setStyle(Paint.Style.FILL);
        this.f29031a.setColor(this.f29038h);
        double d = (double) width;
        double d2 = (((double) f) * 3.141592653589793d) / ((double) 180);
        double height = ((double) (getHeight() / 2)) - (Math.cos(d2) * d);
        double width2 = ((double) (getWidth() / 2)) + (d * Math.sin(d2));
        if (canvas != null) {
            canvas.drawCircle((float) width2, (float) height, this.f29037g, this.f29031a);
        }
    }

    /* renamed from: c */
    private final void m22618c(Canvas canvas) {
        this.f29031a.setStyle(Paint.Style.STROKE);
        this.f29031a.setStrokeWidth(this.f29035e);
        this.f29031a.setColor(this.f29036f);
        this.f29031a.setStrokeCap(Paint.Cap.ROUND);
        float f = this.f29033c;
        float f2 = (float) 2;
        float f3 = this.f29032b;
        RectF rectF = new RectF((f / f2) + f3, (f / f2) + f3, (((float) getWidth()) - (this.f29033c / f2)) - this.f29032b, (((float) getHeight()) - (this.f29033c / f2)) - this.f29032b);
        float f4 = (float) 360;
        float f5 = this.f29040j % f4;
        if (f5 > 180.0f) {
            float f6 = f4 - f5;
            if (f6 > this.f29039i * f2) {
                Pair<Float, Float> a = m22615a(((((float) getWidth()) - (this.f29032b * f2)) - this.f29033c) / f2, this.f29039i + f5);
                Pair<Float, Float> a2 = m22615a(((((float) getWidth()) - (this.f29032b * f2)) - this.f29033c) / f2, f4 - this.f29039i);
                this.f29031a.setShader(new LinearGradient(a.getFirst().floatValue(), a.getSecond().floatValue(), a2.getFirst().floatValue(), a2.getSecond().floatValue(), Color.parseColor("#99FFFFFF"), Color.parseColor("#66FFFFFF"), Shader.TileMode.CLAMP));
                if (canvas != null) {
                    float f7 = this.f29039i;
                    float f8 = (f5 - ((float) 90)) + f7;
                    canvas.drawArc(rectF, f8, f6 - (f7 * f2), false, this.f29031a);
                }
                this.f29031a.setShader((Shader) null);
            }
        }
        double d = (double) f5;
        boolean z = false;
        if (0.0d <= d && d <= 180.0d) {
            z = true;
        }
        if (z && f5 > this.f29039i * f2) {
            Pair<Float, Float> a3 = m22615a(((((float) getWidth()) - (this.f29032b * f2)) - this.f29033c) / f2, this.f29039i);
            Pair<Float, Float> a4 = m22615a(((((float) getWidth()) - (this.f29032b * f2)) - this.f29033c) / f2, f5 - this.f29039i);
            this.f29031a.setShader(new LinearGradient(a3.getFirst().floatValue(), a3.getSecond().floatValue(), a4.getFirst().floatValue(), a4.getSecond().floatValue(), Color.parseColor("#66FFFFFF"), Color.parseColor("#99FFFFFF"), Shader.TileMode.CLAMP));
            if (canvas != null) {
                float f9 = this.f29039i;
                canvas.drawArc(rectF, -90.0f + f9, f5 - (f9 * f2), false, this.f29031a);
            }
        }
        this.f29031a.setShader((Shader) null);
    }

    /* renamed from: d */
    private final void m22619d(Canvas canvas) {
        this.f29031a.setStyle(Paint.Style.STROKE);
        this.f29031a.setStrokeWidth(this.f29033c);
        this.f29031a.setColor(this.f29034d);
        if (canvas != null) {
            float f = (float) 2;
            float f2 = this.f29032b;
            canvas.drawCircle(((float) getWidth()) / f, (this.f29033c / f) + f2, f2, this.f29031a);
        }
    }

    /* renamed from: a */
    private final float m22614a(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    /* renamed from: a */
    private final Pair<Float, Float> m22615a(float f, float f2) {
        double d = (((double) (((float) 90) - f2)) * 3.141592653589793d) / ((double) 180);
        double d2 = (double) f;
        return new Pair<>(Float.valueOf(((float) (Math.cos(d) * d2)) + f), Float.valueOf(Math.abs(((float) (d2 * Math.sin(d))) - f)));
    }
}
