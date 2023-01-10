package com.didichuxing.dfbasesdk.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didi.passenger.C11267R;
import java.lang.reflect.Field;

public class DFCaptureButton extends View {

    /* renamed from: a */
    private Paint f49541a;

    /* renamed from: b */
    private StaticLayout f49542b;

    /* renamed from: c */
    private StaticLayout f49543c;

    /* renamed from: d */
    private int f49544d;

    /* renamed from: e */
    private int f49545e;

    /* renamed from: f */
    private int f49546f;

    /* renamed from: g */
    private int f49547g;

    /* renamed from: h */
    private int f49548h;

    /* renamed from: i */
    private int f49549i;

    /* renamed from: j */
    private int f49550j;

    /* renamed from: k */
    private int f49551k;

    /* renamed from: l */
    private String f49552l;

    /* renamed from: m */
    private int f49553m;

    /* renamed from: n */
    private int f49554n;

    /* renamed from: o */
    private int f49555o;

    /* renamed from: p */
    private int f49556p;

    /* renamed from: q */
    private int f49557q;

    /* renamed from: r */
    private ValueAnimator f49558r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public float f49559s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ICaptureCallback f49560t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f49561u;

    /* renamed from: v */
    private RectF f49562v;

    public DFCaptureButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public DFCaptureButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DFCaptureButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49544d = 872382003;
        this.f49545e = -33229;
        this.f49562v = new RectF();
        m37119a(attributeSet);
        m37122b();
    }

    /* renamed from: a */
    private void m37117a() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (declaredField.getFloat((Object) null) == 0.0f) {
                    declaredField.setFloat((Object) null, 1.0f);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private void m37122b() {
        Paint paint = new Paint();
        this.f49541a = paint;
        paint.setAntiAlias(true);
        this.f49541a.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.f49546f);
        textPaint.setTextSize((float) this.f49553m);
        this.f49542b = new StaticLayout(this.f49552l, textPaint, this.f49549i * 2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setAntiAlias(true);
        textPaint2.setColor(this.f49546f);
        textPaint2.setTextSize((float) this.f49554n);
        this.f49543c = new StaticLayout(this.f49552l, textPaint2, this.f49550j * 2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        m37117a();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f49555o}).setDuration((long) (this.f49555o * 1000));
        this.f49558r = duration;
        duration.setInterpolator(new LinearInterpolator());
        this.f49558r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DFCaptureButton.this.f49559s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DFCaptureButton.this.f49560t.onProgress((int) DFCaptureButton.this.f49559s);
                DFCaptureButton.this.invalidate();
            }
        });
        this.f49558r.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = DFCaptureButton.this.f49561u = false;
                DFCaptureButton.this.invalidate();
                if (DFCaptureButton.this.f49560t != null) {
                    DFCaptureButton.this.f49560t.onUp((int) DFCaptureButton.this.f49559s);
                }
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = DFCaptureButton.this.f49561u = true;
                if (DFCaptureButton.this.f49560t != null) {
                    DFCaptureButton.this.f49560t.onDown();
                }
            }
        });
    }

    /* renamed from: a */
    private void m37119a(AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.DFCaptureButton);
            this.f49544d = obtainStyledAttributes.getColor(0, 0);
            this.f49545e = obtainStyledAttributes.getColor(8, 0);
            this.f49549i = obtainStyledAttributes.getDimensionPixelSize(9, 0);
            this.f49550j = obtainStyledAttributes.getDimensionPixelSize(10, 0);
            this.f49552l = obtainStyledAttributes.getString(5);
            this.f49546f = obtainStyledAttributes.getColor(6, 0);
            this.f49553m = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.f49554n = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f49555o = obtainStyledAttributes.getInt(1, 0);
            this.f49547g = obtainStyledAttributes.getColor(2, 0);
            this.f49551k = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f49548h = (int) (((float) Math.min(measuredWidth, measuredHeight)) * 0.5f);
        float f = (float) measuredWidth;
        this.f49556p = (int) (f * 0.5f);
        float f2 = (float) measuredHeight;
        this.f49557q = (int) (f2 * 0.5f);
        float f3 = ((float) this.f49551k) * 0.5f;
        this.f49562v.set(f3, f3, f - f3, f2 - f3);
    }

    public void draw(Canvas canvas) {
        StaticLayout staticLayout;
        int i;
        int i2;
        super.draw(canvas);
        this.f49541a.setStyle(Paint.Style.FILL);
        this.f49541a.setColor(this.f49544d);
        canvas.drawCircle((float) this.f49556p, (float) this.f49557q, (float) this.f49548h, this.f49541a);
        this.f49541a.setColor(this.f49545e);
        if (this.f49561u) {
            i2 = this.f49550j;
            i = this.f49554n;
            staticLayout = this.f49543c;
            m37118a(canvas);
        } else {
            i2 = this.f49549i;
            i = this.f49553m;
            staticLayout = this.f49542b;
        }
        this.f49541a.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) this.f49556p, (float) this.f49557q, (float) i2, this.f49541a);
        this.f49541a.setColor(this.f49546f);
        this.f49541a.setTextSize((float) i);
        canvas.save();
        canvas.translate((float) (this.f49556p - i2), ((float) this.f49557q) - (((float) this.f49549i) * 0.5f));
        staticLayout.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m37118a(Canvas canvas) {
        this.f49541a.setStyle(Paint.Style.STROKE);
        this.f49541a.setStrokeWidth((float) this.f49551k);
        this.f49541a.setColor(this.f49547g);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f49562v, -90.0f, ((this.f49559s * 1.0f) / ((float) this.f49555o)) * 360.0f, false, this.f49541a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            m37124d();
        } else if (action == 1) {
            m37123c();
        }
        return true;
    }

    public void setCaptureCallback(ICaptureCallback iCaptureCallback) {
        this.f49560t = iCaptureCallback;
    }

    public void setMaxTime(int i) {
        if (i <= 0) {
            i = 20;
        }
        this.f49555o = i;
        this.f49558r.setFloatValues(new float[]{0.0f, (float) i});
        this.f49558r.setDuration((long) (i * 1000));
    }

    /* renamed from: c */
    private void m37123c() {
        this.f49558r.cancel();
    }

    /* renamed from: d */
    private void m37124d() {
        this.f49558r.start();
    }
}
