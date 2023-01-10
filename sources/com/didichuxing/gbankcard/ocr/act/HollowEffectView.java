package com.didichuxing.gbankcard.ocr.act;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;

public class HollowEffectView extends View {

    /* renamed from: d */
    private static final int f50250d = Integer.MIN_VALUE;

    /* renamed from: a */
    private Paint f50251a;

    /* renamed from: b */
    private PorterDuffXfermode f50252b;

    /* renamed from: c */
    private PorterDuffXfermode f50253c;

    /* renamed from: e */
    private Rect f50254e;

    /* renamed from: f */
    private Rect f50255f;

    /* renamed from: g */
    private Bitmap f50256g;

    /* renamed from: h */
    private Bitmap f50257h;

    /* renamed from: i */
    private Path f50258i;

    /* renamed from: j */
    private int f50259j;

    public HollowEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m37596a();
    }

    /* renamed from: a */
    private void m37596a() {
        setWillNotDraw(false);
        setLayerType(1, (Paint) null);
        Paint paint = new Paint(1);
        this.f50251a = paint;
        paint.setColor(Integer.MIN_VALUE);
        this.f50252b = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f50253c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f50259j = ResUtils.dp2px(5.0f);
    }

    public void setHollowArea(View view) {
        this.f50254e = new Rect(view.getLeft() + this.f50259j, view.getTop() + this.f50259j, view.getRight() - this.f50259j, view.getBottom() - this.f50259j);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo124249a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-65536);
        canvas.drawRect(this.f50254e, paint);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo124250b(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(Integer.MIN_VALUE);
        canvas.drawRect(this.f50255f, paint);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f50254e != null) {
            int width = getWidth();
            int height = getHeight();
            if (width == 0 || height == 0) {
                LogUtils.m37051d("onDraw invalid w or h!!!");
                return;
            }
            LogUtils.m37051d("onDraw w===" + width + ", h=" + height);
            if (this.f50255f == null) {
                this.f50255f = new Rect(0, 0, width, height);
            }
            canvas.drawPaint(this.f50251a);
            this.f50251a.setXfermode(this.f50253c);
            canvas.drawRect(this.f50254e, this.f50251a);
            this.f50251a.setXfermode((Xfermode) null);
        }
    }
}
