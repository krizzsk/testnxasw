package p244in.srain.cube.views.ptr.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;
import p244in.srain.cube.views.ptr.util.PtrLocalDisplay;

/* renamed from: in.srain.cube.views.ptr.header.MaterialProgressDrawable */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1333;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    public static final int DEFAULT = 1;
    private static final Interpolator EASE_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public static final Interpolator END_CURVE_INTERPOLATOR = new EndCurveInterpolator();
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float SHADOW_RADIUS = 3.5f;
    /* access modifiers changed from: private */
    public static final Interpolator START_CURVE_INTERPOLATOR = new StartCurveInterpolator();
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private final int[] COLORS = {-3591113, -13149199, -536002, -13327536};
    /* access modifiers changed from: private */
    public Animation mAnimation;
    private final ArrayList<Animation> mAnimators = new ArrayList<>();
    private int mBackgroundColor;
    private final Drawable.Callback mCallback = new Drawable.Callback() {
        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    };
    private Animation mFinishAnimation;
    private double mHeight;
    /* access modifiers changed from: private */
    public View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    /* access modifiers changed from: private */
    public float mRotationCount;
    private ShapeDrawable mShadow;
    private double mWidth;

    public int getOpacity() {
        return -3;
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.mParent = view;
        this.mResources = context.getResources();
        Ring ring = new Ring(this.mCallback);
        this.mRing = ring;
        ring.setColors(this.COLORS);
        updateSizes(1);
        setupAnimators();
    }

    private void setSizeParameters(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.mRing;
        float f3 = this.mResources.getDisplayMetrics().density;
        double d5 = (double) f3;
        this.mWidth = d * d5;
        this.mHeight = d2 * d5;
        ring.setStrokeWidth(((float) d4) * f3);
        ring.setCenterRadius(d3 * d5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f * f3, f2 * f3);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
        setUp(this.mWidth);
    }

    private void setUp(double d) {
        PtrLocalDisplay.init(this.mParent.getContext());
        int dp2px = PtrLocalDisplay.dp2px(Y_OFFSET);
        int dp2px2 = PtrLocalDisplay.dp2px(0.0f);
        int dp2px3 = PtrLocalDisplay.dp2px(SHADOW_RADIUS);
        this.mShadow = new ShapeDrawable(new OvalShadow(dp2px3, (int) d));
        if (Build.VERSION.SDK_INT >= 11) {
            this.mParent.setLayerType(1, this.mShadow.getPaint());
        }
        this.mShadow.getPaint().setShadowLayer((float) dp2px3, (float) dp2px2, (float) dp2px, KEY_SHADOW_COLOR);
    }

    public void updateSizes(int i) {
        if (i == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void showArrow(boolean z) {
        this.mRing.setShowArrow(z);
    }

    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
    }

    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mRing.setBackgroundColor(i);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    public void draw(Canvas canvas) {
        ShapeDrawable shapeDrawable = this.mShadow;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(this.mBackgroundColor);
            this.mShadow.draw(canvas);
        }
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    private float getRotation() {
        return this.mRotation;
    }

    /* access modifiers changed from: package-private */
    public void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mParent.startAnimation(this.mFinishAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mParent.startAnimation(this.mAnimation);
    }

    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        C220242 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                float floor = (float) (Math.floor((double) (ring.getStartingRotation() / 0.8f)) + 1.0d);
                ring.setStartTrim(ring.getStartingStartTrim() + ((ring.getStartingEndTrim() - ring.getStartingStartTrim()) * f));
                ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f));
                ring.setArrowScale(1.0f - f);
            }
        };
        r1.setInterpolator(EASE_INTERPOLATOR);
        r1.setDuration(666);
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ring.goToNextColor();
                ring.storeOriginals();
                ring.setShowArrow(false);
                MaterialProgressDrawable.this.mParent.startAnimation(MaterialProgressDrawable.this.mAnimation);
            }
        });
        C220264 r2 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                float radians = (float) Math.toRadians(((double) ring.getStrokeWidth()) / (ring.getCenterRadius() * 6.283185307179586d));
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                ring.setEndTrim(startingEndTrim + ((0.8f - radians) * MaterialProgressDrawable.START_CURVE_INTERPOLATOR.getInterpolation(f)));
                ring.setStartTrim(startingStartTrim + (MaterialProgressDrawable.END_CURVE_INTERPOLATOR.getInterpolation(f) * 0.8f));
                ring.setRotation(startingRotation + (0.25f * f));
                MaterialProgressDrawable.this.setRotation((f * 144.0f) + ((MaterialProgressDrawable.this.mRotationCount / 5.0f) * 720.0f));
            }
        };
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        r2.setInterpolator(LINEAR_INTERPOLATOR);
        r2.setDuration(1333);
        r2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                float unused = MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }

            public void onAnimationRepeat(Animation animation) {
                ring.storeOriginals();
                ring.goToNextColor();
                Ring ring = ring;
                ring.setStartTrim(ring.getEndTrim());
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                float unused = materialProgressDrawable.mRotationCount = (materialProgressDrawable.mRotationCount + 1.0f) % 5.0f;
            }
        });
        this.mFinishAnimation = r1;
        this.mAnimation = r2;
    }

    /* renamed from: in.srain.cube.views.ptr.header.MaterialProgressDrawable$Ring */
    private static class Ring {
        private int mAlpha;
        private final Paint mArcPaint = new Paint();
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint = new Paint();
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Paint mCirclePaint = new Paint();
        private int mColorIndex;
        private int[] mColors;
        private float mEndTrim = 0.0f;
        private final Drawable.Callback mRingCallback;
        private double mRingCenterRadius;
        private float mRotation = 0.0f;
        private boolean mShowArrow;
        private float mStartTrim = 0.0f;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
        private float mStrokeWidth = 5.0f;
        private final RectF mTempBounds = new RectF();

        public Ring(Drawable.Callback callback) {
            this.mRingCallback = callback;
            this.mArcPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mArcPaint.setAntiAlias(true);
            this.mArcPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
            this.mCirclePaint.setAntiAlias(true);
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        public void draw(Canvas canvas, Rect rect) {
            this.mCirclePaint.setColor(this.mBackgroundColor);
            this.mCirclePaint.setAlpha(this.mAlpha);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.mCirclePaint);
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f = this.mStrokeInset;
            rectF.inset(f, f);
            float f2 = this.mStartTrim;
            float f3 = this.mRotation;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
            this.mArcPaint.setColor(this.mColors[this.mColorIndex]);
            this.mArcPaint.setAlpha(this.mAlpha);
            canvas.drawArc(rectF, f4, f5, false, this.mArcPaint);
            drawTriangle(canvas, f4, f5, rect);
        }

        private void drawTriangle(Canvas canvas, float f, float f2, Rect rect) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = ((float) (((int) this.mStrokeInset) / 2)) * this.mArrowScale;
                float sin = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(((float) this.mArrowWidth) * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f4 = this.mArrowScale;
                path3.lineTo((((float) this.mArrowWidth) * f4) / 2.0f, ((float) this.mArrowHeight) * f4);
                this.mArrow.offset(((float) ((this.mRingCenterRadius * Math.cos(0.0d)) + ((double) rect.exactCenterX()))) - f3, sin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mColors[this.mColorIndex]);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
        }

        public void goToNextColor() {
            this.mColorIndex = (this.mColorIndex + 1) % this.mColors.length;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mArcPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mArcPaint.setStrokeWidth(f);
            invalidateSelf();
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void setInsets(int i, int i2) {
            double d;
            float min = (float) Math.min(i, i2);
            double d2 = this.mRingCenterRadius;
            if (d2 <= 0.0d || min < 0.0f) {
                d = Math.ceil((double) (this.mStrokeWidth / 2.0f));
            } else {
                d = ((double) (min / 2.0f)) - d2;
            }
            this.mStrokeInset = (float) d;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public void setCenterRadius(double d) {
            this.mRingCenterRadius = d;
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
                invalidateSelf();
            }
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
                invalidateSelf();
            }
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.mRingCallback.invalidateDrawable((Drawable) null);
        }
    }

    /* renamed from: in.srain.cube.views.ptr.header.MaterialProgressDrawable$EndCurveInterpolator */
    private static class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        private EndCurveInterpolator() {
        }

        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    /* renamed from: in.srain.cube.views.ptr.header.MaterialProgressDrawable$StartCurveInterpolator */
    private static class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        private StartCurveInterpolator() {
        }

        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, f * 2.0f));
        }
    }

    /* renamed from: in.srain.cube.views.ptr.header.MaterialProgressDrawable$OvalShadow */
    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(int i, int i2) {
            this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            RadialGradient radialGradient = new RadialGradient((float) (i3 / 2), (float) (i3 / 2), (float) this.mShadowRadius, new int[]{MaterialProgressDrawable.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            float width = (float) (MaterialProgressDrawable.this.getBounds().width() / 2);
            float height = (float) (MaterialProgressDrawable.this.getBounds().height() / 2);
            canvas.drawCircle(width, height, (float) ((this.mCircleDiameter / 2) + this.mShadowRadius), this.mShadowPaint);
            canvas.drawCircle(width, height, (float) (this.mCircleDiameter / 2), paint);
        }
    }
}
