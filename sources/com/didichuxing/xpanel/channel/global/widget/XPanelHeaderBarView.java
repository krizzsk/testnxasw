package com.didichuxing.xpanel.channel.global.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.taxis99.R;

public class XPanelHeaderBarView extends FrameLayout {

    /* renamed from: a */
    private static final int f51976a = 40;

    /* renamed from: b */
    private static final int f51977b = 5;

    /* renamed from: c */
    private static final int f51978c = 20;

    /* renamed from: d */
    private Paint f51979d;

    /* renamed from: e */
    private Paint f51980e;

    /* renamed from: f */
    private RectF f51981f;

    /* renamed from: g */
    private float f51982g;

    /* renamed from: h */
    private float f51983h;

    /* renamed from: i */
    private boolean f51984i;

    /* renamed from: j */
    private float f51985j;

    /* renamed from: k */
    private int f51986k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f51987l;

    /* renamed from: m */
    private int f51988m;

    /* renamed from: n */
    private float f51989n;

    /* renamed from: o */
    private boolean f51990o;

    /* renamed from: p */
    private boolean f51991p;

    /* renamed from: q */
    private View f51992q;

    /* renamed from: r */
    private XPanelDragBarView f51993r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public XPanelHeardBarTopView f51994s;

    /* renamed from: t */
    private ValueAnimator f51995t;

    /* renamed from: u */
    private final long f51996u;

    /* renamed from: v */
    private final int f51997v;

    public XPanelHeaderBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51979d = null;
        this.f51980e = null;
        this.f51981f = new RectF();
        this.f51983h = 1.0f;
        this.f51984i = true;
        this.f51986k = 423706956;
        this.f51987l = -1;
        this.f51988m = -1;
        this.f51989n = 0.0f;
        this.f51990o = false;
        this.f51991p = true;
        this.f51992q = null;
        this.f51996u = 30;
        this.f51997v = 255;
        m39129a(context);
    }

    public XPanelHeaderBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f51979d = null;
        this.f51980e = null;
        this.f51981f = new RectF();
        this.f51983h = 1.0f;
        this.f51984i = true;
        this.f51986k = 423706956;
        this.f51987l = -1;
        this.f51988m = -1;
        this.f51989n = 0.0f;
        this.f51990o = false;
        this.f51991p = true;
        this.f51992q = null;
        this.f51996u = 30;
        this.f51997v = 255;
        m39129a(context);
    }

    /* renamed from: a */
    private void m39129a(Context context) {
        setLayerType(1, (Paint) null);
        Paint paint = new Paint();
        this.f51979d = paint;
        paint.setAntiAlias(true);
        this.f51979d.setStyle(Paint.Style.FILL);
        this.f51979d.setColor(-16777216);
        this.f51979d.setDither(true);
        this.f51989n = TypedValue.applyDimension(1, 13.0f, getResources().getDisplayMetrics());
        this.f51982g = TypedValue.applyDimension(1, 17.0f, getResources().getDisplayMetrics());
        this.f51985j = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f51980e = new Paint(this.f51979d);
        XPanelDragBarView xPanelDragBarView = new XPanelDragBarView(context);
        this.f51993r = xPanelDragBarView;
        xPanelDragBarView.setContentDescription(getResources().getString(R.string.oc_x_panel_accessible_drag));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_width), getResources().getDimensionPixelSize(R.dimen.oc_x_panel_drag_bar_height));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (getResources().getDimensionPixelSize(R.dimen.oc_x_panel_header_view_height) - layoutParams.height) / 2;
        addView(this.f51993r, layoutParams);
        setCanDrag(false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f51981f.left = (float) getPaddingLeft();
        this.f51981f.top = ((float) getPaddingTop()) + getShadowHeight();
        RectF rectF = this.f51981f;
        rectF.right = (rectF.left + ((float) getMeasuredWidth())) - ((float) getPaddingRight());
        RectF rectF2 = this.f51981f;
        rectF2.bottom = (rectF2.top + ((float) getMeasuredHeight())) - ((float) getPaddingBottom());
        View view = this.f51992q;
        if (view != null && view.getVisibility() == 0) {
            this.f51992q.layout((int) this.f51981f.left, (int) this.f51981f.top, (int) (((float) this.f51992q.getMeasuredWidth()) + this.f51981f.left), (int) (this.f51981f.top + ((float) this.f51992q.getMeasuredHeight())));
        }
    }

    public float getShadowHeight() {
        return this.f51985j + this.f51989n;
    }

    public float getShadowShowHeight() {
        return this.f51985j;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f51991p) {
            this.f51980e.setShadowLayer(this.f51989n, 0.0f, -this.f51985j, this.f51986k);
        } else {
            this.f51980e.setShadowLayer(0.0f, 0.0f, -this.f51985j, this.f51986k);
        }
        this.f51980e.setColor(this.f51987l);
        this.f51979d.setColor(this.f51987l);
        m39130a(canvas);
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m39130a(Canvas canvas) {
        float roundRadiusRate = this.f51982g * getRoundRadiusRate();
        canvas.drawRoundRect(this.f51981f, roundRadiusRate, roundRadiusRate, this.f51980e);
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, this.f51981f.bottom - roundRadiusRate, roundRadiusRate, this.f51981f.bottom, this.f51979d);
        canvas2.drawRect(this.f51981f.right - roundRadiusRate, this.f51981f.bottom - roundRadiusRate, this.f51981f.right, this.f51981f.bottom, this.f51979d);
    }

    public void bindXPanelHeardBarTopView(XPanelHeardBarTopView xPanelHeardBarTopView) {
        this.f51994s = xPanelHeardBarTopView;
        if (xPanelHeardBarTopView != null) {
            xPanelHeardBarTopView.setDrawColor(this.f51987l);
        }
    }

    public void setRoundRadiusRate(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f51983h = f;
        setDragBarAngle(1.0f - f);
    }

    private void setDragBarAngle(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = 180.0f;
        float f3 = 180.0f - ((f * 20.0f) * 2.0f);
        if (f3 <= 180.0f) {
            f2 = f3 < 90.0f ? 90.0f : f3;
        }
        this.f51993r.setDragAngle(f2);
    }

    public float getDragBarAngle() {
        return this.f51993r.getDragAngle();
    }

    public float getRoundRadiusRate() {
        if (this.f51984i) {
            return this.f51983h;
        }
        return 0.0f;
    }

    public void setShadowHeight(int i) {
        this.f51985j = TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        requestLayout();
    }

    public void setShadowColor(int i) {
        this.f51986k = i;
        invalidate();
    }

    public void setForegroundColor(int i) {
        if (this.f51988m != i) {
            this.f51988m = i;
            m39128a();
        }
        invalidate();
    }

    /* renamed from: a */
    private void m39128a() {
        ValueAnimator valueAnimator = this.f51995t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = this.f51987l;
        int i2 = this.f51988m;
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.f51995t = ofObject;
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = XPanelHeaderBarView.this.f51987l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (XPanelHeaderBarView.this.f51994s != null) {
                    XPanelHeaderBarView.this.f51994s.setDrawColor(XPanelHeaderBarView.this.f51987l);
                }
                XPanelHeaderBarView.this.invalidate();
            }
        });
        this.f51995t.start();
    }

    public void setShadowVisibility(boolean z) {
        this.f51991p = z;
        invalidate();
    }

    public void setCanDrag(boolean z) {
        this.f51990o = z;
        this.f51993r.setVisibility(z ? 0 : 8);
    }

    public void setBarOnClickListener(View.OnClickListener onClickListener) {
        this.f51993r.setOnClickListener(onClickListener);
    }

    public void setRoundEnable(boolean z) {
        if (this.f51984i != z) {
            this.f51984i = z;
            invalidate();
        }
    }

    public void setLoadingView(View view) {
        if (view != null && view.getParent() == null) {
            this.f51992q = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            View view2 = this.f51992q;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            }
            addView(view2, layoutParams);
        }
    }
}
