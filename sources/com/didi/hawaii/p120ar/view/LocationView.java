package com.didi.hawaii.p120ar.view;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.hawaii.p120ar.utils.DisplayUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.LocationView */
public class LocationView extends View {

    /* renamed from: a */
    Path f25673a;

    /* renamed from: b */
    float f25674b;

    /* renamed from: c */
    boolean f25675c = false;

    /* renamed from: d */
    private Paint f25676d = new Paint();

    /* renamed from: e */
    private Paint f25677e = new Paint();

    /* renamed from: f */
    private Paint f25678f = new Paint();

    /* renamed from: g */
    private ValueAnimator f25679g = null;

    /* renamed from: h */
    private double f25680h = Math.sin(0.5235987755982988d);

    /* renamed from: i */
    private double f25681i = Math.cos(0.5235987755982988d);

    /* renamed from: j */
    private double f25682j = Math.tan(1.0471975511965976d);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f25683k;

    /* renamed from: l */
    private Path f25684l;

    /* renamed from: m */
    private int f25685m = 50;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f25686n = (-this.f25683k);

    /* renamed from: o */
    private int f25687o;

    /* renamed from: p */
    private int f25688p;

    /* renamed from: q */
    private int f25689q;

    /* renamed from: r */
    private int f25690r;

    /* renamed from: s */
    private float f25691s;

    /* renamed from: t */
    private boolean f25692t = false;

    /* renamed from: u */
    private Bitmap f25693u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f25694v = new Handler(Looper.getMainLooper());

    /* renamed from: w */
    private int f25695w = 35;

    public LocationView(Context context) {
        super(context);
        m20411a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20411a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20411a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20411a(context);
    }

    /* renamed from: a */
    private void m20411a(Context context) {
        this.f25676d.setColor(-16776961);
        this.f25676d.setAntiAlias(true);
        this.f25676d.setStyle(Paint.Style.STROKE);
        this.f25676d.setStrokeWidth(8.0f);
        this.f25677e.setColor(getResources().getColor(R.color.line_center));
        this.f25677e.setAntiAlias(true);
        this.f25677e.setStyle(Paint.Style.STROKE);
        this.f25677e.setStrokeWidth(4.0f);
        this.f25678f.setAntiAlias(true);
        this.f25678f.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f25677e.setStrokeWidth(4.0f);
        this.f25687o = getScreenWidth();
        int screenHeight = getScreenHeight();
        this.f25688p = screenHeight;
        int i = this.f25687o / 2;
        this.f25689q = i;
        this.f25690r = screenHeight / 2;
        float f = (float) (i - 20);
        this.f25683k = f;
        this.f25674b = f;
        this.f25691s = f;
        TextView textView = new TextView(context);
        textView.setText(getResources().getString(R.string.location_success_toast));
        textView.setBackground(getResources().getDrawable(R.mipmap.alert_bg));
        textView.setDrawingCacheEnabled(true);
        textView.setGravity(17);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor("#4BDAFF"));
        textView.setPadding(120, 0, 120, 0);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        this.f25693u = Bitmap.createBitmap(textView.getDrawingCache());
        textView.destroyDrawingCache();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f25687o = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.f25688p = size;
        int i3 = this.f25687o / 2;
        this.f25689q = i3;
        this.f25690r = size / 2;
        float f = (float) (i3 - 15);
        this.f25683k = f;
        this.f25674b = f;
        this.f25691s = f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f25675c) {
            Paint paint = new Paint();
            Bitmap bitmap = this.f25693u;
            canvas.drawBitmap(bitmap, (float) ((this.f25687o / 2) - (bitmap.getWidth() / 2)), (float) (((this.f25688p / 2) - (this.f25693u.getHeight() / 2)) + this.f25695w), paint);
            return;
        }
        if (!this.f25692t) {
            canvas.translate((float) this.f25689q, (float) this.f25690r);
            canvas.drawColor(getResources().getColor(R.color.black_effective));
        } else {
            canvas.translate((float) this.f25689q, (float) (this.f25690r + this.f25695w));
        }
        canvas.save();
        m20412a(canvas);
        canvas.restore();
        canvas.save();
        this.f25676d.setStrokeWidth(6.0f);
        this.f25676d.setColor(getResources().getColor(R.color.waikuang));
        this.f25676d.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f25673a, this.f25676d);
        if (!this.f25692t) {
            float f = this.f25683k;
            double d = this.f25681i;
            canvas.drawLine((float) (((double) (-f)) * d), 0.0f, (float) (((double) f) * d), 0.0f, this.f25677e);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m20412a(Canvas canvas) {
        Path path = new Path();
        this.f25673a = path;
        path.moveTo(0.0f, this.f25674b);
        float f = this.f25674b;
        float f2 = this.f25683k;
        double d = this.f25680h;
        if (((double) f) < ((double) f2) * d) {
            this.f25673a.lineTo((float) (((double) f2) * this.f25681i), f);
            this.f25673a.lineTo((float) (((double) this.f25683k) * this.f25681i), -this.f25674b);
        } else {
            this.f25673a.lineTo((float) (((double) f2) * this.f25681i), (float) (((double) f2) * d));
            Path path2 = this.f25673a;
            float f3 = this.f25683k;
            path2.lineTo((float) (((double) f3) * this.f25681i), (float) (((double) (-f3)) * this.f25680h));
        }
        this.f25673a.lineTo(0.0f, -this.f25674b);
        float f4 = this.f25674b;
        float f5 = this.f25683k;
        double d2 = this.f25680h;
        if (((double) f4) < ((double) f5) * d2) {
            this.f25673a.lineTo((float) (((double) (-f5)) * this.f25681i), -f4);
            this.f25673a.lineTo((float) (((double) (-this.f25683k)) * this.f25681i), this.f25674b);
        } else {
            this.f25673a.lineTo((float) (((double) (-f5)) * this.f25681i), (float) (((double) (-f5)) * d2));
            Path path3 = this.f25673a;
            float f6 = this.f25683k;
            path3.lineTo((float) (((double) (-f6)) * this.f25681i), (float) (((double) f6) * this.f25680h));
        }
        this.f25673a.lineTo(0.0f, this.f25674b);
        if (!this.f25692t) {
            canvas.clipPath(this.f25673a);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            int argb = Color.argb(Math.round(153.0f), 75, 218, 255);
            int argb2 = Color.argb(Math.round(0.0f), 75, 218, 255);
            float f7 = this.f25686n;
            this.f25678f.setShader(new LinearGradient(f7 - this.f25683k, 0.0f, f7, 0.0f, argb2, argb, Shader.TileMode.CLAMP));
            float f8 = this.f25686n;
            float f9 = this.f25683k;
            canvas.drawRect(f8 - f9, f9, f8, -f9, this.f25678f);
            m20414b(canvas);
        }
    }

    /* renamed from: b */
    private void m20414b(Canvas canvas) {
        this.f25676d.setColor(getResources().getColor(R.color.gray_slate));
        this.f25676d.setStrokeWidth(4.0f);
        float f = this.f25683k;
        Rect rect = new Rect((int) (-f), (int) (-f), (int) f, (int) f);
        if (this.f25684l == null) {
            this.f25684l = new Path();
            float width = ((float) rect.width()) / (((float) this.f25685m) + 1.0E-5f);
            float height = ((float) rect.height()) / (((float) this.f25685m) + 1.0E-5f);
            for (int i = 0; i <= this.f25685m; i++) {
                float f2 = ((float) i) * width;
                this.f25684l.moveTo(((float) rect.left) + f2, (float) rect.top);
                this.f25684l.lineTo(((float) rect.left) + f2, (float) rect.bottom);
            }
            for (int i2 = 0; i2 <= this.f25685m; i2++) {
                float f3 = ((float) i2) * height;
                this.f25684l.moveTo((float) rect.left, ((float) rect.top) + f3);
                this.f25684l.lineTo((float) rect.right, ((float) rect.top) + f3);
            }
        }
        this.f25676d.setStrokeWidth(1.0f);
        this.f25676d.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f25684l, this.f25676d);
    }

    public void startScan() {
        this.f25694v.removeCallbacksAndMessages((Object) null);
        this.f25675c = false;
        ValueAnimator valueAnimator = this.f25679g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f25679g.cancel();
        }
        this.f25692t = false;
        float f = this.f25691s;
        double d = this.f25681i;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (((double) (-f)) * d), (float) (((double) f) * d)});
        this.f25679g = ofFloat;
        ofFloat.setDuration(Const.DELAY_TIME4LAST_GPS_TASK);
        this.f25679g.setRepeatCount(-1);
        this.f25679g.setRepeatMode(1);
        this.f25679g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LocationView.this.f25686n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LocationView.this.invalidate();
            }
        });
        this.f25679g.start();
    }

    public void stopScan() {
        this.f25694v.removeCallbacksAndMessages((Object) null);
        ValueAnimator valueAnimator = this.f25679g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f25679g.cancel();
        }
    }

    public void exeDisAppearAnimator() {
        this.f25692t = true;
        float f = this.f25691s;
        int width = (this.f25693u.getWidth() / 2) - DisplayUtils.px2dip(getContext(), 30.0f);
        int height = (this.f25693u.getHeight() / 2) - DisplayUtils.px2dip(getContext(), 30.0f);
        float sqrt = (float) Math.sqrt((double) ((width * width) + (height * height)));
        PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("r", new FloatEvaluator(), new Object[]{Float.valueOf(f), Float.valueOf(sqrt)});
        PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("rAnimate", new FloatEvaluator(), new Object[]{Float.valueOf(f), Float.valueOf((float) height)});
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f25679g = valueAnimator;
        valueAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2});
        this.f25679g.setDuration(300);
        this.f25679g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LocationView.this.f25683k = ((Float) valueAnimator.getAnimatedValue("r")).floatValue();
                LocationView.this.f25674b = ((Float) valueAnimator.getAnimatedValue("rAnimate")).floatValue();
                LocationView.this.invalidate();
            }
        });
        this.f25679g.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LocationView.this.f25675c = true;
                LocationView.this.f25694v.postDelayed(new Runnable() {
                    public void run() {
                        LocationView.this.setVisibility(8);
                    }
                }, 2000);
            }
        });
        this.f25679g.start();
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
