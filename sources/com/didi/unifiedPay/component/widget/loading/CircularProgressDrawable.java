package com.didi.unifiedPay.component.widget.loading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.PowerManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_ROUNDED = 1;

    /* renamed from: a */
    private final RectF f47143a;

    /* renamed from: b */
    private C15294d f47144b;

    /* renamed from: c */
    private Paint f47145c;

    /* renamed from: d */
    private boolean f47146d;

    /* renamed from: e */
    private C15295e f47147e;

    /* renamed from: f */
    private Context f47148f;

    public interface OnEndListener {
        void onEnd(CircularProgressDrawable circularProgressDrawable);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public int getOpacity() {
        return -3;
    }

    private CircularProgressDrawable(Context context, PowerManager powerManager, C15294d dVar) {
        this.f47143a = new RectF();
        this.f47148f = context;
        this.f47144b = dVar;
        initPaint(dVar);
        m35082a();
    }

    public Paint initPaint(C15294d dVar) {
        if (this.f47145c == null) {
            this.f47145c = new Paint();
        }
        this.f47145c.setAntiAlias(true);
        this.f47145c.setStyle(Paint.Style.STROKE);
        this.f47145c.setStrokeWidth(dVar.f47194c);
        this.f47145c.setStrokeCap(dVar.f47201j == 1 ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        this.f47145c.setColor(dVar.f47195d[0]);
        return this.f47145c;
    }

    public void draw(Canvas canvas) {
        if (isRunning()) {
            this.f47147e.mo118211a(canvas, this.f47145c);
        }
    }

    public void changeToSuccess(Bitmap bitmap) {
        C15295e eVar = this.f47147e;
        if (eVar != null) {
            eVar.mo118210a(bitmap);
        }
    }

    public void changeToLoading() {
        C15295e eVar = this.f47147e;
        if (eVar != null) {
            eVar.mo118208a();
        }
    }

    public void setAlpha(int i) {
        this.f47145c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f47145c.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float f = this.f47144b.f47194c;
        this.f47143a.left = ((float) rect.left) + f;
        this.f47143a.right = ((float) rect.right) - f;
        this.f47143a.top = ((float) rect.top) + f;
        this.f47143a.bottom = ((float) rect.bottom) - f;
    }

    public void start() {
        m35082a();
        this.f47147e.mo118213b();
        this.f47146d = true;
        invalidateSelf();
    }

    /* renamed from: a */
    private void m35082a() {
        if (this.f47147e == null) {
            this.f47147e = new C15291a(this.f47148f, this, this.f47144b);
        }
    }

    public void stop() {
        this.f47146d = false;
        this.f47147e.mo118215c();
        invalidateSelf();
    }

    public void invalidate() {
        if (getCallback() == null) {
            stop();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidateSelf();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    CircularProgressDrawable.this.invalidateSelf();
                }
            });
        }
    }

    public boolean isRunning() {
        return this.f47146d;
    }

    public Paint getCurrentPaint() {
        return this.f47145c;
    }

    public RectF getDrawableBounds() {
        return this.f47143a;
    }

    public void progressiveStop(OnEndListener onEndListener) {
        this.f47147e.mo118212a(onEndListener);
    }

    public void progressiveStop() {
        progressiveStop((OnEndListener) null);
    }

    public static class Builder {
        private static final Interpolator DEFAULT_ROTATION_INTERPOLATOR = new LinearInterpolator();
        private static final Interpolator DEFAULT_SWEEP_INTERPOLATOR = new C15292b();
        private int bgColor;
        private Interpolator mAngleInterpolator;
        private float mBorderWidth;
        private int[] mColors;
        private Context mContext;
        private int mMaxSweepAngle;
        private int mMinSweepAngle;
        private PowerManager mPowerManager;
        private float mRotationSpeed;
        int mStyle;
        private Interpolator mSweepInterpolator;
        private float mSweepSpeed;

        public Builder(Context context) {
            this(context, false);
        }

        public Builder(Context context, boolean z) {
            this.mSweepInterpolator = DEFAULT_SWEEP_INTERPOLATOR;
            this.mAngleInterpolator = DEFAULT_ROTATION_INTERPOLATOR;
            initValues(context, z);
        }

        private void initValues(Context context, boolean z) {
            this.mContext = context;
            this.mBorderWidth = context.getResources().getDimension(R.dimen.cpb_default_stroke_width);
            this.mSweepSpeed = 1.0f;
            this.mRotationSpeed = 1.0f;
            if (z) {
                this.mColors = new int[]{-16776961};
                this.mMinSweepAngle = 20;
                this.mMaxSweepAngle = 300;
            } else {
                this.mColors = new int[]{context.getResources().getColor(R.color.cpb_default_color)};
                this.mMinSweepAngle = context.getResources().getInteger(R.integer.cpb_default_min_sweep_angle);
                this.mMaxSweepAngle = context.getResources().getInteger(R.integer.cpb_default_max_sweep_angle);
            }
            this.mStyle = 1;
            this.mPowerManager = C15297g.m35133a(context);
        }

        public Builder color(int i) {
            this.mColors = new int[]{i};
            return this;
        }

        public Builder colors(int[] iArr) {
            C15297g.m35139a(iArr);
            this.mColors = iArr;
            return this;
        }

        public Builder backGroundColor(int i) {
            this.bgColor = i;
            return this;
        }

        public Builder sweepSpeed(float f) {
            C15297g.m35134a(f);
            this.mSweepSpeed = f;
            return this;
        }

        public Builder rotationSpeed(float f) {
            C15297g.m35134a(f);
            this.mRotationSpeed = f;
            return this;
        }

        public Builder minSweepAngle(int i) {
            C15297g.m35136a(i);
            this.mMinSweepAngle = i;
            return this;
        }

        public Builder maxSweepAngle(int i) {
            C15297g.m35136a(i);
            this.mMaxSweepAngle = i;
            return this;
        }

        public Builder strokeWidth(float f) {
            C15297g.m35135a(f, "StrokeWidth");
            this.mBorderWidth = f;
            return this;
        }

        public Builder style(int i) {
            this.mStyle = i;
            return this;
        }

        public Builder sweepInterpolator(Interpolator interpolator) {
            C15297g.m35138a((Object) interpolator, "Sweep interpolator");
            this.mSweepInterpolator = interpolator;
            return this;
        }

        public Builder angleInterpolator(Interpolator interpolator) {
            C15297g.m35138a((Object) interpolator, "Angle interpolator");
            this.mAngleInterpolator = interpolator;
            return this;
        }

        public CircularProgressDrawable build() {
            return new CircularProgressDrawable(this.mContext, this.mPowerManager, new C15294d(this.mAngleInterpolator, this.mSweepInterpolator, this.mBorderWidth, this.mColors, this.mSweepSpeed, this.mRotationSpeed, this.mMinSweepAngle, this.mMaxSweepAngle, this.mStyle, this.bgColor));
        }
    }
}
