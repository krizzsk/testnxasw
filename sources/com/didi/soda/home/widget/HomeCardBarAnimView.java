package com.didi.soda.home.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public class HomeCardBarAnimView extends View {

    /* renamed from: a */
    private static final String f45824a = "HomeCardBarAnimView";

    /* renamed from: b */
    private int f45825b;

    /* renamed from: c */
    private int f45826c;

    /* renamed from: d */
    private float f45827d;

    /* renamed from: e */
    private Paint f45828e;

    /* renamed from: f */
    private Paint f45829f;

    /* renamed from: g */
    private Paint f45830g;

    /* renamed from: h */
    private int f45831h;

    /* renamed from: i */
    private int f45832i;

    /* renamed from: j */
    private int f45833j;

    /* renamed from: k */
    private int f45834k;

    /* renamed from: l */
    private int f45835l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f45836m = 0;

    /* renamed from: n */
    private int f45837n = 0;

    /* renamed from: o */
    private ValueAnimator f45838o;

    /* renamed from: p */
    private ScopeContext f45839p;

    /* renamed from: q */
    private IScopeLifecycle f45840q;

    public HomeCardBarAnimView(Context context) {
        super(context);
        m33979a(context, (AttributeSet) null);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33979a(context, attributeSet);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33979a(context, attributeSet);
    }

    public HomeCardBarAnimView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m33979a(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.m32584d(f45824a, "onAttachedToWindow:" + this.f45836m);
        m33986e();
        m33990i();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.m32584d(f45824a, "onDetachedFromWindow:" + this.f45836m);
        m33987f();
        m33991j();
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f45839p = scopeContext;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f45831h = getMeasuredWidth();
        this.f45832i = getMeasuredHeight();
        int dip2px = DisplayUtils.dip2px(getContext(), 30.0f);
        this.f45833j = dip2px;
        int i5 = this.f45831h;
        this.f45834k = (dip2px * 3) + i5;
        this.f45835l = (i5 + (dip2px * 2)) / 50;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f45831h, (float) this.f45837n);
        int i = this.f45837n;
        path.addRoundRect(rectF, new float[]{(float) i, (float) i, (float) i, (float) i, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawRect(rectF, this.f45830g);
        canvas.save();
        canvas.translate((float) (this.f45835l * this.f45836m), 0.0f);
        m33985d();
        canvas.drawRect(new RectF((float) (-this.f45834k), 0.0f, 0.0f, (float) this.f45832i), this.f45828e);
        canvas.restore();
        canvas.save();
        canvas.skew(-0.75f, 0.0f);
        int i2 = this.f45831h / 4;
        for (int i3 = 1; i3 <= this.f45826c; i3++) {
            float f = ((float) (i2 * i3)) - (this.f45827d / 2.0f);
            canvas.drawRect(new RectF(f, 0.0f, this.f45827d + f, (float) this.f45832i), this.f45829f);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m33979a(Context context, AttributeSet attributeSet) {
        m33981b(context, attributeSet);
        m33978a();
        m33983c();
        m33980b();
        LogUtil.m32584d(f45824a, "init:" + this);
    }

    /* renamed from: b */
    private void m33981b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.HomeCardBarAnimView);
        this.f45825b = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.rf_color_v2_brands_1_100));
        this.f45826c = obtainStyledAttributes.getInt(1, 3);
        this.f45827d = (float) obtainStyledAttributes.getInt(2, DisplayUtils.dip2px(getContext(), 5.0f));
        this.f45837n = obtainStyledAttributes.getInt(3, (int) getResources().getDimension(R.dimen.rf_dimen_28));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m33978a() {
        Paint paint = new Paint();
        this.f45828e = paint;
        paint.setColor(this.f45825b);
        Paint paint2 = new Paint();
        this.f45830g = paint2;
        paint2.setColor(this.f45825b);
        this.f45830g.setAlpha(51);
        Paint paint3 = new Paint();
        this.f45829f = paint3;
        paint3.setColor(-1);
    }

    /* renamed from: b */
    private void m33980b() {
        this.f45840q = new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
            }

            public void onStart(ILive iLive) {
            }

            public void onStop(ILive iLive) {
            }

            public void onResume(ILive iLive) {
                LogUtil.m32584d(HomeCardBarAnimView.f45824a, "resumeScrollAnim:" + HomeCardBarAnimView.this.f45836m);
                HomeCardBarAnimView.this.m33989h();
            }

            public void onPause(ILive iLive) {
                LogUtil.m32584d(HomeCardBarAnimView.f45824a, "pauseScrollAnim:" + HomeCardBarAnimView.this.f45836m);
                HomeCardBarAnimView.this.m33988g();
            }
        };
    }

    /* renamed from: c */
    private void m33983c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
        this.f45838o = ofInt;
        ofInt.setRepeatCount(-1);
        Path path = new Path();
        path.quadTo(0.082f, 0.0f, 0.13f, 0.5f);
        path.lineTo(0.826f, 0.5f);
        path.quadTo(0.88f, 1.0f, 0.95f, 1.0f);
        path.lineTo(1.0f, 1.0f);
        this.f45838o.setInterpolator(PathInterpolatorCompat.create(path));
        this.f45838o.setDuration(4600);
        this.f45838o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = HomeCardBarAnimView.this.f45836m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                HomeCardBarAnimView.this.invalidate();
            }
        });
    }

    /* renamed from: d */
    private void m33985d() {
        if (this.f45836m <= 50) {
            int i = this.f45825b;
            this.f45828e.setShader(new LinearGradient((float) (-this.f45833j), 0.0f, 0.0f, 0.0f, new int[]{-855638017 & i, i & 16777215}, (float[]) null, Shader.TileMode.CLAMP));
            return;
        }
        int i2 = this.f45825b;
        Paint paint = this.f45828e;
        int i3 = this.f45834k;
        paint.setShader(new LinearGradient((float) (-i3), 0.0f, (float) ((-i3) + this.f45833j), 0.0f, new int[]{16777215 & i2, -855638017 & i2}, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: e */
    private void m33986e() {
        ValueAnimator valueAnimator = this.f45838o;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: f */
    private void m33987f() {
        ValueAnimator valueAnimator = this.f45838o;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m33988g() {
        ValueAnimator valueAnimator = this.f45838o;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m33989h() {
        ValueAnimator valueAnimator = this.f45838o;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    /* renamed from: i */
    private void m33990i() {
        if (this.f45839p != null) {
            LogUtil.m32584d(f45824a, "bindScopeContextLife:" + this.f45840q);
            this.f45839p.addObserver(this.f45840q);
        }
    }

    /* renamed from: j */
    private void m33991j() {
        if (this.f45839p != null) {
            LogUtil.m32584d(f45824a, "unbindScopeContextLife:" + this.f45840q);
            this.f45839p.removeObserver(this.f45840q);
        }
    }
}
