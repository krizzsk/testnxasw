package p093static;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.iproov.sdk.p227ui.views.C20915do;

/* renamed from: static.if */
/* compiled from: ScanlineView */
public class C3640if extends View {

    /* renamed from: a */
    private Paint f8689a = new Paint();

    /* renamed from: b */
    private float f8690b = 0.0f;

    /* renamed from: c */
    private Path f8691c = new Path();

    /* renamed from: d */
    private RectF f8692d;

    /* renamed from: e */
    private boolean f8693e = false;

    /* renamed from: f */
    private C20915do f8694f = C20915do.INSIDE_OVAL_ONLY;

    /* renamed from: g */
    private ValueAnimator f8695g;

    public C3640if(Context context) {
        super(context);
        m7273a();
    }

    /* renamed from: a */
    private void m7273a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f8689a.setStyle(Paint.Style.STROKE);
        this.f8689a.setStrokeWidth(10.0f);
        this.f8689a.setStrokeCap(Paint.Cap.ROUND);
        this.f8689a.setAntiAlias(true);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(800);
        this.f8695g = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C3640if.this.m7274a(valueAnimator);
            }
        });
        this.f8695g.setRepeatCount(-1);
        this.f8695g.setRepeatMode(2);
        this.f8695g.start();
    }

    /* renamed from: b */
    private void m7275b() {
        if (this.f8692d == null) {
            this.f8692d = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
        this.f8691c.reset();
        this.f8691c.addOval(this.f8692d, Path.Direction.CW);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r4.f8692d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.RectF getRect() {
        /*
            r4 = this;
            boolean r0 = r4.f8693e
            if (r0 != 0) goto L_0x0008
            android.graphics.RectF r0 = r4.f8692d
            if (r0 != 0) goto L_0x0018
        L_0x0008:
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r4.getWidth()
            float r1 = (float) r1
            int r2 = r4.getHeight()
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p093static.C3640if.getRect():android.graphics.RectF");
    }

    private void setPosition(float f) {
        this.f8690b = f;
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46651for() {
        this.f8695g.cancel();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C20915do doVar = this.f8694f;
        if (doVar == C20915do.INSIDE_OVAL_ONLY) {
            canvas.clipPath(this.f8691c);
        } else if (doVar == C20915do.OUTSIDE_OVAL_ONLY) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutPath(this.f8691c);
            } else {
                canvas.clipPath(this.f8691c, Region.Op.DIFFERENCE);
            }
        }
        super.onDraw(canvas);
        RectF rect = getRect();
        float height = (float) ((int) (rect.top + (rect.height() * this.f8690b)));
        canvas.drawLine(rect.left, height, rect.right, height, this.f8689a);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m7275b();
    }

    public void setColor(int i) {
        this.f8689a.setColor(i);
        this.f8689a.setAlpha(255);
        invalidate();
    }

    public void setDrawRect(RectF rectF) {
        this.f8692d = new RectF(rectF);
        m7275b();
    }

    public void setScanlineType(C20915do doVar) {
        this.f8694f = doVar;
        this.f8693e = doVar != C20915do.INSIDE_OVAL_ONLY;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7274a(ValueAnimator valueAnimator) {
        setPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
