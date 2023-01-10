package com.didi.addressnew.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.didi.passenger.C11267R;

public class SwipeMenuLayout extends ViewGroup {

    /* renamed from: a */
    private static final String f9526a = "SwipeMenuLayout";

    /* renamed from: i */
    private static SwipeMenuLayout f9527i;

    /* renamed from: b */
    private final Context f9528b;

    /* renamed from: c */
    private int f9529c;

    /* renamed from: d */
    private int f9530d;

    /* renamed from: e */
    private View f9531e;

    /* renamed from: f */
    private int f9532f;

    /* renamed from: g */
    private float f9533g;

    /* renamed from: h */
    private float f9534h;

    /* renamed from: j */
    private int f9535j;

    /* renamed from: k */
    private VelocityTracker f9536k;

    /* renamed from: l */
    private boolean f9537l;

    /* renamed from: m */
    private ValueAnimator f9538m;

    /* renamed from: n */
    private ValueAnimator f9539n;

    /* renamed from: o */
    private int f9540o;

    /* renamed from: p */
    private boolean f9541p;

    /* renamed from: q */
    private boolean f9542q;

    /* renamed from: r */
    private boolean f9543r;

    /* renamed from: s */
    private boolean f9544s;

    /* renamed from: t */
    private boolean f9545t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SwipeMenuStateListener f9546u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f9547v;

    public interface SwipeMenuStateListener {
        void menuIsOpen(boolean z);
    }

    public SwipeMenuLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9533g = 0.0f;
        this.f9534h = 0.0f;
        this.f9537l = false;
        this.f9540o = 300;
        this.f9541p = false;
        this.f9542q = true;
        this.f9543r = true;
        this.f9544s = false;
        this.f9545t = false;
        this.f9547v = false;
        this.f9528b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SwipeMenuLayout, i, 0);
        this.f9543r = obtainStyledAttributes.getBoolean(2, true);
        this.f9544s = obtainStyledAttributes.getBoolean(1, false);
        this.f9542q = obtainStyledAttributes.getBoolean(3, true);
        this.f9545t = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        m8246a();
    }

    /* renamed from: a */
    private void m8246a() {
        this.f9529c = ViewConfiguration.get(this.f9528b).getScaledTouchSlop();
        this.f9530d = ViewConfiguration.get(this.f9528b).getScaledMaximumFlingVelocity();
        setClickable(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.f9532f = 0;
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (i5 == 0) {
                    layoutParams.width = getMeasuredWidth();
                    this.f9531e = childAt;
                }
                measureChild(childAt, i, i2);
                if (mode != 1073741824) {
                    i3 = Math.max(i3, childAt.getMeasuredHeight());
                }
                if (i5 == 0) {
                    i4 = childAt.getMeasuredWidth();
                } else {
                    this.f9532f += childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(i4, Math.max(getMeasuredHeight(), i3));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (i7 == 0) {
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                } else if (this.f9544s) {
                    childAt.layout(i6 - childAt.getMeasuredWidth(), paddingTop, i6, childAt.getMeasuredHeight() + paddingTop);
                    i6 -= childAt.getMeasuredWidth();
                } else {
                    childAt.layout(i5, paddingTop, childAt.getMeasuredWidth() + i5, childAt.getMeasuredHeight() + paddingTop);
                    measuredWidth = childAt.getMeasuredWidth();
                }
                i5 += measuredWidth;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9534h = motionEvent.getRawX();
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f9541p = false;
            SwipeMenuLayout swipeMenuLayout = f9527i;
            if (swipeMenuLayout != null) {
                if (swipeMenuLayout != this) {
                    swipeMenuLayout.closeMenuAnim();
                    this.f9541p = this.f9542q;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 1 || action == 3) {
            this.f9537l = false;
            if (Math.abs(getScrollX()) == Math.abs(this.f9532f)) {
                if ((!this.f9544s || motionEvent.getX() >= ((float) this.f9532f)) && (this.f9544s || motionEvent.getX() <= ((float) (getMeasuredWidth() - this.f9532f)))) {
                    closeMenuAnim();
                } else if (this.f9545t) {
                    closeMenuAnim();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f9543r) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(motionEvent.getRawX() - this.f9534h) >= ((float) this.f9529c)) {
                m8248a(false);
                return true;
            }
        } else if (this.f9537l) {
            return true;
        } else {
            this.f9537l = true;
            this.f9535j = motionEvent.getPointerId(0);
            this.f9533g = motionEvent.getRawX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r0 != 3) goto L_0x013c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f9543r
            if (r0 != 0) goto L_0x0009
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x0009:
            r9.m8247a((android.view.MotionEvent) r10)
            int r0 = r10.getAction()
            r1 = 1
            if (r0 == r1) goto L_0x0084
            r2 = 2
            if (r0 == r2) goto L_0x001b
            r2 = 3
            if (r0 == r2) goto L_0x0084
            goto L_0x013c
        L_0x001b:
            boolean r0 = r9.f9541p
            if (r0 == 0) goto L_0x0021
            goto L_0x013c
        L_0x0021:
            float r0 = r9.f9533g
            float r2 = r10.getRawX()
            float r0 = r0 - r2
            int r2 = (int) r0
            r3 = 0
            r9.scrollBy(r2, r3)
            float r0 = java.lang.Math.abs(r0)
            int r2 = r9.f9529c
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0044
            int r0 = r9.getScrollX()
            int r0 = java.lang.Math.abs(r0)
            int r2 = r9.f9529c
            if (r0 <= r2) goto L_0x004b
        L_0x0044:
            android.view.ViewParent r0 = r9.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x004b:
            boolean r0 = r9.f9544s
            if (r0 == 0) goto L_0x0067
            int r0 = r9.getScrollX()
            int r1 = r9.f9532f
            int r2 = -r1
            if (r0 >= r2) goto L_0x005d
            int r0 = -r1
            r9.scrollTo(r0, r3)
            goto L_0x007c
        L_0x005d:
            int r0 = r9.getScrollX()
            if (r0 <= 0) goto L_0x007c
            r9.scrollTo(r3, r3)
            goto L_0x007c
        L_0x0067:
            int r0 = r9.getScrollX()
            if (r0 >= 0) goto L_0x0071
            r9.scrollTo(r3, r3)
            goto L_0x007c
        L_0x0071:
            int r0 = r9.getScrollX()
            int r1 = r9.f9532f
            if (r0 <= r1) goto L_0x007c
            r9.scrollTo(r1, r3)
        L_0x007c:
            float r0 = r10.getRawX()
            r9.f9533g = r0
            goto L_0x013c
        L_0x0084:
            android.view.VelocityTracker r0 = r9.f9536k
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r9.f9530d
            float r3 = (float) r3
            r0.computeCurrentVelocity(r2, r3)
            android.view.VelocityTracker r0 = r9.f9536k
            int r2 = r9.f9535j
            float r0 = r0.getXVelocity(r2)
            r9.m8250b()
            boolean r2 = r9.f9541p
            if (r2 != 0) goto L_0x013c
            float r2 = r10.getRawX()
            float r3 = r9.f9534h
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.f9529c
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x013c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "onTouchEvent: "
            r10.append(r2)
            r10.append(r0)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 292(0x124, float:4.09E-43)
            java.lang.String r4 = "SwipeMenuLayout"
            java.lang.String r7 = "com.didi.addressnew.widget.SwipeMenuLayout"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            float r10 = java.lang.Math.abs(r0)
            r2 = 1159479296(0x451c4000, float:2500.0)
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x00f5
            r10 = -988004352(0xffffffffc51c4000, float:-2500.0)
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e9
            boolean r10 = r9.f9544s
            if (r10 != 0) goto L_0x00e5
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x00e5:
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x00e9:
            boolean r10 = r9.f9544s
            if (r10 != 0) goto L_0x00f1
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x00f1:
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x00f5:
            int r10 = r9.getScrollX()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "scrollX = "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r5 = r0.toString()
            r3 = 3
            r6 = 0
            r8 = 315(0x13b, float:4.41E-43)
            java.lang.String r4 = "david"
            java.lang.String r7 = "com.didi.addressnew.widget.SwipeMenuLayout"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            int r10 = r9.getScrollX()
            int r10 = java.lang.Math.abs(r10)
            double r2 = (double) r10
            int r10 = r9.f9532f
            double r4 = (double) r10
            r6 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            double r4 = r4 * r6
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0138
            boolean r10 = r9.f9547v
            if (r10 == 0) goto L_0x0134
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x0134:
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x0138:
            r9.closeMenuAnim()
        L_0x013b:
            return r1
        L_0x013c:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.widget.SwipeMenuLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m8247a(MotionEvent motionEvent) {
        if (this.f9536k == null) {
            this.f9536k = VelocityTracker.obtain();
        }
        this.f9536k.addMovement(motionEvent);
    }

    /* renamed from: b */
    private void m8250b() {
        VelocityTracker velocityTracker = this.f9536k;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f9536k.recycle();
            this.f9536k = null;
        }
    }

    public void expandMenuAnim() {
        m8248a(false);
        m8252c();
        f9527i = this;
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.f9544s ? -this.f9532f : this.f9532f;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f9538m = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.f9538m.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = SwipeMenuLayout.this.f9547v = true;
                if (SwipeMenuLayout.this.f9546u != null) {
                    SwipeMenuLayout.this.f9546u.menuIsOpen(true);
                }
            }
        });
        this.f9538m.setInterpolator(new OvershootInterpolator());
        this.f9538m.setDuration((long) this.f9540o).start();
    }

    public void closeMenuAnim() {
        f9527i = null;
        m8252c();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.f9539n = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.f9539n.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = SwipeMenuLayout.this.f9547v = false;
                SwipeMenuLayout.this.m8248a(true);
                if (SwipeMenuLayout.this.f9546u != null) {
                    SwipeMenuLayout.this.f9546u.menuIsOpen(false);
                }
            }
        });
        this.f9539n.setInterpolator(new AccelerateInterpolator());
        this.f9539n.setDuration((long) this.f9540o).start();
    }

    /* renamed from: c */
    private void m8252c() {
        ValueAnimator valueAnimator = this.f9539n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f9539n.cancel();
        }
        ValueAnimator valueAnimator2 = this.f9538m;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f9538m.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (getScrollX() != 0) {
            quickCloseMenu();
            f9527i = null;
        }
        super.onDetachedFromWindow();
    }

    public void quickCloseMenu() {
        if (getScrollX() != 0) {
            m8252c();
            scrollTo(0, 0);
            f9527i = null;
        }
    }

    public void quickExpandMenu() {
        if (getScrollX() == 0) {
            m8252c();
            scrollTo(this.f9544s ? -this.f9532f : this.f9532f, 0);
            f9527i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8248a(boolean z) {
        setLongClickable(z);
    }

    public boolean performLongClick() {
        if (getScrollX() != 0) {
            return true;
        }
        return super.performLongClick();
    }

    public SwipeMenuLayout getCacheView() {
        return f9527i;
    }

    public boolean isExpandMenu() {
        return Math.abs(getScaleX()) >= ((float) this.f9532f);
    }

    public boolean isOpenChoke() {
        return this.f9542q;
    }

    public SwipeMenuLayout setOpenChoke(boolean z) {
        this.f9542q = z;
        return this;
    }

    public boolean isEnableSwipe() {
        return this.f9543r;
    }

    public SwipeMenuLayout setEnableSwipe(boolean z) {
        this.f9543r = z;
        return this;
    }

    public boolean isEnableLeftMenu() {
        return this.f9544s;
    }

    public SwipeMenuLayout setEnableLeftMenu(boolean z) {
        this.f9544s = z;
        return this;
    }

    public boolean isClickMenuAndClose() {
        return this.f9545t;
    }

    public SwipeMenuLayout setClickMenuAndClose(boolean z) {
        this.f9545t = z;
        return this;
    }

    public SwipeMenuLayout setSwipeMenuStateListener(SwipeMenuStateListener swipeMenuStateListener) {
        this.f9546u = swipeMenuStateListener;
        return this;
    }
}
