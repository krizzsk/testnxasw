package com.didi.hawaii.mapsdkv2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.map.common.utils.SystemUtil;

public class ScaleView extends View implements GLBaseMapView.ScaleRulerUpdateCallback {

    /* renamed from: a */
    private static final int f26415a = 5;

    /* renamed from: b */
    private static final int f26416b = 3;

    /* renamed from: c */
    private static final int f26417c = 10;

    /* renamed from: d */
    private static final int f26418d = 200;

    /* renamed from: e */
    private final int[] f26419e = {2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, ApiErrorConst.Code.ERROR_50000, 100000, 200000, 500000, 1000000, 2000000};

    /* renamed from: f */
    private float f26420f;

    /* renamed from: g */
    private float f26421g = 0.0f;

    /* renamed from: h */
    private float f26422h = 0.0f;

    /* renamed from: i */
    private final Paint f26423i;

    /* renamed from: j */
    private final Paint f26424j;

    /* renamed from: k */
    private final Paint f26425k;

    /* renamed from: l */
    private final Paint f26426l;

    /* renamed from: m */
    private final Path f26427m;

    /* renamed from: n */
    private float f26428n;

    /* renamed from: o */
    private String f26429o;

    /* renamed from: p */
    private final GLBaseMapView f26430p;

    /* renamed from: q */
    private final Handler f26431q;

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ScaleView(Context context, GLBaseMapView gLBaseMapView, int i, int i2) {
        super(context);
        this.f26428n = SystemUtil.getDensity(context);
        Paint paint = new Paint();
        this.f26423i = paint;
        paint.setColor(i);
        this.f26423i.setStyle(Paint.Style.STROKE);
        this.f26423i.setStrokeWidth(this.f26428n * 1.0f);
        this.f26423i.setAntiAlias(true);
        Paint paint2 = new Paint(this.f26423i);
        this.f26424j = paint2;
        paint2.setColor(i2);
        this.f26424j.setStrokeWidth(this.f26428n * 2.5f);
        TextPaint textPaint = new TextPaint();
        this.f26425k = textPaint;
        textPaint.setTextSize(this.f26428n * 10.0f);
        this.f26425k.setTypeface(Typeface.DEFAULT);
        this.f26425k.setStyle(Paint.Style.FILL);
        this.f26425k.setAntiAlias(true);
        this.f26425k.setTextAlign(Paint.Align.LEFT);
        this.f26425k.setLinearText(true);
        this.f26425k.setColor(i);
        Paint paint3 = new Paint(this.f26425k);
        this.f26426l = paint3;
        paint3.setStrokeWidth(this.f26428n * 1.5f);
        this.f26426l.setStyle(Paint.Style.STROKE);
        this.f26426l.setColor(i2);
        this.f26430p = gLBaseMapView;
        this.f26431q = gLBaseMapView.getMainHandler();
        this.f26427m = new Path();
        this.f26429o = "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77316a() {
        this.f26430p.setScaleRuler(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo77318b() {
        this.f26430p.setScaleRuler((GLBaseMapView.ScaleRulerUpdateCallback) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77317a(int i, int i2) {
        this.f26423i.setColor(i);
        this.f26424j.setColor(i2);
        this.f26425k.setColor(i);
        this.f26426l.setColor(i2);
        m20920a((int) this.f26420f, this.f26421g, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20920a(int i, float f, boolean z) {
        if (z || this.f26420f != ((float) i) || this.f26421g != f) {
            this.f26420f = (float) i;
            this.f26421g = f;
            int i2 = this.f26419e[Math.min(Math.max(0, 21 - i), this.f26419e.length - 1)];
            float round = (float) Math.round((320.0d / ((double) f)) * ((double) i2));
            this.f26422h = round;
            if (round > 200.0f) {
                this.f26422h = 200.0f;
            }
            if (i2 < 1000) {
                this.f26429o = i2 + "米";
            } else {
                this.f26429o = (i2 / 1000) + "公里";
            }
            this.f26427m.reset();
            this.f26427m.moveTo(5.0f, this.f26428n * 12.0f);
            Path path = this.f26427m;
            float f2 = this.f26428n;
            path.lineTo(5.0f, (f2 * 12.0f) + (f2 * 3.0f));
            float f3 = this.f26428n;
            this.f26427m.lineTo(this.f26422h + 5.0f, (f3 * 12.0f) + (f3 * 3.0f));
            this.f26427m.lineTo(this.f26422h + 5.0f, this.f26428n * 12.0f);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float f = this.f26428n;
        setMeasuredDimension(((int) Math.max(this.f26425k.measureText(this.f26429o), this.f26422h)) + 5 + 1000, ((int) ((10.0f * f) + (f * 2.0f) + (3.0f * f))) + ((int) (f * 2.0f)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        canvas.drawText(this.f26429o, 5.0f, this.f26428n * 10.0f, this.f26426l);
        canvas.drawText(this.f26429o, 5.0f, this.f26428n * 10.0f, this.f26425k);
        canvas.drawPath(this.f26427m, this.f26424j);
        canvas.drawPath(this.f26427m, this.f26423i);
    }

    public void onUpdate(final float f, final float f2) {
        this.f26431q.post(new Runnable() {
            public void run() {
                ScaleView.this.m20920a((int) f, f2, false);
            }
        });
    }
}
