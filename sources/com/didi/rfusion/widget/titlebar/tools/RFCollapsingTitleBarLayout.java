package com.didi.rfusion.widget.titlebar.tools;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.didi.passenger.C11267R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCollapsingTextHelper;
import com.didi.rfusion.material.internal.RFDescendantOffsetUtils;
import com.didi.rfusion.material.internal.RFThemeEnforcement;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.titlebar.RFStandardTitleBar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RFCollapsingTitleBarLayout extends FrameLayout {
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    /* renamed from: e */
    private static final int f36728e = 2132018204;

    /* renamed from: f */
    private static final int f36729f = 600;

    /* renamed from: a */
    final RFCollapsingTextHelper f36730a;

    /* renamed from: b */
    Drawable f36731b;

    /* renamed from: c */
    int f36732c;

    /* renamed from: d */
    WindowInsetsCompat f36733d;

    /* renamed from: g */
    private boolean f36734g;

    /* renamed from: h */
    private int f36735h;

    /* renamed from: i */
    private ViewGroup f36736i;

    /* renamed from: j */
    private View f36737j;

    /* renamed from: k */
    private View f36738k;

    /* renamed from: l */
    private int f36739l;

    /* renamed from: m */
    private int f36740m;

    /* renamed from: n */
    private int f36741n;

    /* renamed from: o */
    private int f36742o;

    /* renamed from: p */
    private final Rect f36743p;

    /* renamed from: q */
    private boolean f36744q;

    /* renamed from: r */
    private boolean f36745r;

    /* renamed from: s */
    private Drawable f36746s;

    /* renamed from: t */
    private int f36747t;

    /* renamed from: u */
    private boolean f36748u;

    /* renamed from: v */
    private ValueAnimator f36749v;

    /* renamed from: w */
    private long f36750w;

    /* renamed from: x */
    private int f36751x;

    /* renamed from: y */
    private AppBarLayout.OnOffsetChangedListener f36752y;

    /* renamed from: z */
    private int f36753z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public RFCollapsingTitleBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFCollapsingTitleBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFCollapsingTitleBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36734g = true;
        this.f36743p = new Rect();
        this.f36751x = -1;
        Context context2 = getContext();
        RFCollapsingTextHelper rFCollapsingTextHelper = new RFCollapsingTextHelper(this);
        this.f36730a = rFCollapsingTextHelper;
        rFCollapsingTextHelper.setTextSizeInterpolator(RFAnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray obtainStyledAttributes = RFThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C11267R.styleable.CollapsingToolbarLayout, i, f36728e, new int[0]);
        this.f36730a.setExpandedTextGravity(obtainStyledAttributes.getInt(3, BadgeDrawable.BOTTOM_START));
        this.f36730a.setCollapsedTextGravity(obtainStyledAttributes.getInt(0, 8388627));
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dimen_36);
        this.f36742o = dimens;
        this.f36741n = dimens;
        this.f36740m = dimens;
        this.f36739l = dimens;
        if (obtainStyledAttributes.hasValue(7)) {
            this.f36739l = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f36741n = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        if (obtainStyledAttributes.hasValue(8)) {
            this.f36740m = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.f36742o = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        }
        this.f36744q = obtainStyledAttributes.getBoolean(18, true);
        setTitle(obtainStyledAttributes.getText(16));
        this.f36730a.setExpandedTextAppearance(2132017890);
        this.f36730a.setCollapsedTextAppearance(2132017864);
        if (obtainStyledAttributes.hasValue(9)) {
            this.f36730a.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(9, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f36730a.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(1, 0));
        }
        this.f36751x = obtainStyledAttributes.getDimensionPixelSize(14, -1);
        this.f36730a.setMaxLines(3);
        this.f36750w = (long) obtainStyledAttributes.getInt(13, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(2));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(15));
        setTitleCollapseMode(0);
        this.f36735h = obtainStyledAttributes.getResourceId(19, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            m27705a(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f36752y == null) {
                this.f36752y = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.f36752y);
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.f36752y;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsetsCompat mo94930a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f36733d, windowInsetsCompat2)) {
            this.f36733d = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        m27708c();
        if (this.f36736i == null && (drawable = this.f36746s) != null && this.f36747t > 0) {
            drawable.mutate().setAlpha(this.f36747t);
            this.f36746s.draw(canvas);
        }
        if (this.f36744q && this.f36745r) {
            if (this.f36736i == null || this.f36746s == null || this.f36747t <= 0 || !m27707b() || this.f36730a.getExpansionFraction() >= this.f36730a.getFadeModeThresholdFraction()) {
                this.f36730a.draw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f36746s.getBounds(), Region.Op.DIFFERENCE);
                this.f36730a.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f36731b != null && this.f36747t > 0) {
            WindowInsetsCompat windowInsetsCompat = this.f36733d;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f36731b.setBounds(0, -this.f36732c, getWidth(), systemWindowInsetTop - this.f36732c);
                this.f36731b.mutate().setAlpha(this.f36747t);
                this.f36731b.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.f36746s == null || this.f36747t <= 0 || !m27711d(view)) {
            z = false;
        } else {
            m27704a(this.f36746s, view, getWidth(), getHeight());
            this.f36746s.mutate().setAlpha(this.f36747t);
            this.f36746s.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j) || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.f36746s;
        if (drawable != null) {
            m27703a(drawable, i, i2);
        }
    }

    /* renamed from: b */
    private boolean m27707b() {
        return this.f36753z == 1;
    }

    /* renamed from: a */
    private void m27705a(AppBarLayout appBarLayout) {
        if (m27707b()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* renamed from: a */
    private void m27703a(Drawable drawable, int i, int i2) {
        m27704a(drawable, this.f36736i, i, i2);
    }

    /* renamed from: a */
    private void m27704a(Drawable drawable, View view, int i, int i2) {
        if (m27707b() && view != null && this.f36744q) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m27708c() {
        /*
            r6 = this;
            boolean r0 = r6.f36734g
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f36736i = r0
            r6.f36737j = r0
            int r1 = r6.f36735h
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.f36736i = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.m27712e(r1)
            r6.f36737j = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.f36736i
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = m27709c(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.f36736i = r0
        L_0x003e:
            r6.m27710d()
            r6.f36734g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.titlebar.tools.RFCollapsingTitleBarLayout.m27708c():void");
    }

    /* renamed from: c */
    private static boolean m27709c(View view) {
        return view instanceof RFStandardTitleBar;
    }

    /* renamed from: d */
    private boolean m27711d(View view) {
        View view2 = this.f36737j;
        if (view2 == null || view2 == this) {
            if (view == this.f36736i) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private View m27712e(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    /* renamed from: d */
    private void m27710d() {
        View view;
        if (!this.f36744q && (view = this.f36738k) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f36738k);
            }
        }
        if (this.f36744q && this.f36736i != null) {
            if (this.f36738k == null) {
                this.f36738k = new View(getContext());
            }
            if (this.f36738k.getParent() == null) {
                ViewGroup viewGroup = this.f36736i;
                if (viewGroup instanceof RFStandardTitleBar) {
                    ((RFStandardTitleBar) viewGroup).addTitleView(this.f36738k, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m27708c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        WindowInsetsCompat windowInsetsCompat = this.f36733d;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.f36736i != null) {
            View view = this.f36737j;
            if (view == null || view == this) {
                setMinimumHeight(m27715g(this.f36736i));
            } else {
                setMinimumHeight(m27715g(view));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        WindowInsetsCompat windowInsetsCompat = this.f36733d;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            m27701a(getChildAt(i6)).mo95002a();
        }
        if (this.f36744q && (view = this.f36738k) != null) {
            boolean z2 = true;
            boolean z3 = ViewCompat.isAttachedToWindow(view) && this.f36738k.getVisibility() == 0;
            this.f36745r = z3;
            if (z3) {
                if (ViewCompat.getLayoutDirection(this) != 1) {
                    z2 = false;
                }
                m27706a(z2);
                this.f36730a.setExpandedBounds(z2 ? this.f36741n : this.f36739l, this.f36743p.top + this.f36740m, (i3 - i) - (z2 ? this.f36739l : this.f36741n), (i4 - i2) - this.f36742o);
                this.f36730a.recalculate();
            }
        }
        if (this.f36736i != null && this.f36744q && TextUtils.isEmpty(this.f36730a.getText())) {
            setTitle(m27714f(this.f36736i));
        }
        mo94931a();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            m27701a(getChildAt(i7)).mo95005b();
        }
    }

    /* renamed from: a */
    private void m27706a(boolean z) {
        View view = this.f36737j;
        if (view == null) {
            view = this.f36736i;
        }
        int b = mo94932b(view);
        RFDescendantOffsetUtils.getDescendantRect(this, this.f36738k, this.f36743p);
        this.f36730a.setCollapsedBounds(this.f36743p.left + 0, this.f36743p.top + b + 0, this.f36743p.right + 0, this.f36743p.bottom + b + 0);
    }

    /* renamed from: f */
    private static CharSequence m27714f(View view) {
        if (view instanceof RFStandardTitleBar) {
            return ((RFStandardTitleBar) view).getTitle();
        }
        return null;
    }

    /* renamed from: g */
    private static int m27715g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    static C12412a m27701a(View view) {
        C12412a aVar = (C12412a) view.getTag(R.id.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        C12412a aVar2 = new C12412a(view);
        view.setTag(R.id.view_offset_helper, aVar2);
        return aVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.f36730a.setText(charSequence);
        m27713e();
    }

    public CharSequence getTitle() {
        if (this.f36744q) {
            return this.f36730a.getText();
        }
        return null;
    }

    public void setTitleCollapseMode(int i) {
        this.f36753z = i;
        boolean b = m27707b();
        this.f36730a.setFadeModeEnabled(b);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            m27705a((AppBarLayout) parent);
        }
        if (b && this.f36746s == null) {
            getResources().getDimension(R.dimen.design_appbar_elevation);
        }
    }

    public int getTitleCollapseMode() {
        return this.f36753z;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f36744q) {
            this.f36744q = z;
            m27713e();
            m27710d();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.f36744q;
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.f36748u != z) {
            int i = 255;
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m27702a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f36748u = z;
        }
    }

    /* renamed from: a */
    private void m27702a(int i) {
        TimeInterpolator timeInterpolator;
        m27708c();
        ValueAnimator valueAnimator = this.f36749v;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f36749v = valueAnimator2;
            valueAnimator2.setDuration(this.f36750w);
            ValueAnimator valueAnimator3 = this.f36749v;
            if (i > this.f36747t) {
                timeInterpolator = RFAnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else {
                timeInterpolator = RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            valueAnimator3.setInterpolator(timeInterpolator);
            this.f36749v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFCollapsingTitleBarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f36749v.cancel();
        }
        this.f36749v.setIntValues(new int[]{this.f36747t, i});
        this.f36749v.start();
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.f36747t) {
            if (!(this.f36746s == null || (viewGroup = this.f36736i) == null)) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f36747t = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f36747t;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f36746s;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f36746s = drawable3;
            if (drawable3 != null) {
                m27703a(drawable3, getWidth(), getHeight());
                this.f36746s.setCallback(this);
                this.f36746s.setAlpha(this.f36747t);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f36746s;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f36731b;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f36731b = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f36731b.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f36731b, ViewCompat.getLayoutDirection(this));
                this.f36731b.setVisible(getVisibility() == 0, false);
                this.f36731b.setCallback(this);
                this.f36731b.setAlpha(this.f36747t);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f36731b;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f36746s;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        RFCollapsingTextHelper rFCollapsingTextHelper = this.f36730a;
        if (rFCollapsingTextHelper != null) {
            z |= rFCollapsingTextHelper.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f36746s || drawable == this.f36731b;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f36731b;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.f36731b.setVisible(z, false);
        }
        Drawable drawable2 = this.f36746s;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.f36746s.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f36731b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f36730a.setCollapsedTextAppearance(i);
    }

    public void setCollapsingTextSize(float f) {
        this.f36730a.setCollapsedTextSize(f);
    }

    public void setExpandedTextSize(float f) {
        this.f36730a.setExpandedTextSize(f);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f36730a.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f36730a.setCollapsedTextGravity(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f36730a.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f36730a.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f36730a.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f36730a.setExpandedTextGravity(i);
    }

    public int getExpandedTitleGravity() {
        return this.f36730a.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f36730a.setCollapsedTypeface(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f36730a.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f36730a.setExpandedTypeface(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f36730a.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.f36739l = i;
        this.f36740m = i2;
        this.f36741n = i3;
        this.f36742o = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.f36739l;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f36739l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f36740m;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f36740m = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f36741n;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f36741n = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f36742o;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f36742o = i;
        requestLayout();
    }

    public void setMaxLines(int i) {
        this.f36730a.setMaxLines(i);
    }

    public int getMaxLines() {
        return this.f36730a.getMaxLines();
    }

    public int getLineCount() {
        return this.f36730a.getLineCount();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f36751x != i) {
            this.f36751x = i;
            mo94931a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.f36751x;
        if (i >= 0) {
            return i;
        }
        WindowInsetsCompat windowInsetsCompat = this.f36733d;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f36750w = j;
    }

    public long getScrimAnimationDuration() {
        return this.f36750w;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode = 0;
        float parallaxMult = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(0, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(1, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setCollapseMode(int i) {
            this.collapseMode = i;
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public void setParallaxMultiplier(float f) {
            this.parallaxMult = f;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo94931a() {
        if (this.f36746s != null || this.f36731b != null) {
            setScrimsShown(getHeight() + this.f36732c < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo94932b(View view) {
        return ((getHeight() - m27701a(view).mo95010e()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* renamed from: e */
    private void m27713e() {
        setContentDescription(getTitle());
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            RFCollapsingTitleBarLayout.this.f36732c = i;
            int systemWindowInsetTop = RFCollapsingTitleBarLayout.this.f36733d != null ? RFCollapsingTitleBarLayout.this.f36733d.getSystemWindowInsetTop() : 0;
            int childCount = RFCollapsingTitleBarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = RFCollapsingTitleBarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                C12412a a = RFCollapsingTitleBarLayout.m27701a(childAt);
                int i3 = layoutParams.collapseMode;
                if (i3 == 1) {
                    a.mo95004a(MathUtils.clamp(-i, 0, RFCollapsingTitleBarLayout.this.mo94932b(childAt)));
                } else if (i3 == 2) {
                    a.mo95004a(Math.round(((float) (-i)) * layoutParams.parallaxMult));
                }
            }
            RFCollapsingTitleBarLayout.this.mo94931a();
            if (RFCollapsingTitleBarLayout.this.f36731b != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(RFCollapsingTitleBarLayout.this);
            }
            int height = RFCollapsingTitleBarLayout.this.getHeight();
            int minimumHeight = (height - ViewCompat.getMinimumHeight(RFCollapsingTitleBarLayout.this)) - systemWindowInsetTop;
            float f = (float) minimumHeight;
            RFCollapsingTitleBarLayout.this.f36730a.setFadeModeStartFraction(Math.min(1.0f, ((float) (height - RFCollapsingTitleBarLayout.this.getScrimVisibleHeightTrigger())) / f));
            RFCollapsingTitleBarLayout.this.f36730a.setCurrentOffsetY(RFCollapsingTitleBarLayout.this.f36732c + minimumHeight);
            RFCollapsingTitleBarLayout.this.f36730a.setExpansionFraction(((float) Math.abs(i)) / f);
        }
    }
}
