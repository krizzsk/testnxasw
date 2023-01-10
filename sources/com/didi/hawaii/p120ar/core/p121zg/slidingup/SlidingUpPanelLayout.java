package com.didi.hawaii.p120ar.core.p121zg.slidingup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p120ar.core.p121zg.slidingup.utils.ScrollableViewHelper;
import com.didi.hawaii.p120ar.core.p121zg.slidingup.utils.ViewDragHelper;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout */
public class SlidingUpPanelLayout extends ViewGroup {
    public static final String SLIDING_STATE = "sliding_state";

    /* renamed from: a */
    private static final String f25469a = SlidingUpPanelLayout.class.getSimpleName();

    /* renamed from: b */
    private static final int f25470b = 68;

    /* renamed from: c */
    private static final float f25471c = 1.0f;

    /* renamed from: d */
    private static PanelState f25472d = PanelState.COLLAPSED;

    /* renamed from: e */
    private static final int f25473e = 4;

    /* renamed from: f */
    private static final int f25474f = -1728053248;

    /* renamed from: g */
    private static final int f25475g = 400;

    /* renamed from: h */
    private static final boolean f25476h = false;

    /* renamed from: i */
    private static final boolean f25477i = true;

    /* renamed from: l */
    private static final int f25478l = 0;

    /* renamed from: A */
    private View f25479A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public PanelState f25480B;

    /* renamed from: C */
    private PanelState f25481C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public float f25482D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f25483E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public float f25484F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f25485G;

    /* renamed from: H */
    private boolean f25486H;

    /* renamed from: I */
    private float f25487I;

    /* renamed from: J */
    private float f25488J;

    /* renamed from: K */
    private float f25489K;

    /* renamed from: L */
    private float f25490L;

    /* renamed from: M */
    private boolean f25491M;

    /* renamed from: N */
    private final List<PanelSlideListener> f25492N;

    /* renamed from: O */
    private View.OnClickListener f25493O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public final ViewDragHelper f25494P;

    /* renamed from: Q */
    private boolean f25495Q;

    /* renamed from: R */
    private final Rect f25496R;

    /* renamed from: j */
    private int f25497j;

    /* renamed from: k */
    private int f25498k;

    /* renamed from: m */
    private final Paint f25499m;

    /* renamed from: n */
    private final Drawable f25500n;

    /* renamed from: o */
    private int f25501o;

    /* renamed from: p */
    private int f25502p;

    /* renamed from: q */
    private int f25503q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f25504r;

    /* renamed from: s */
    private boolean f25505s;

    /* renamed from: t */
    private boolean f25506t;

    /* renamed from: u */
    private View f25507u;

    /* renamed from: v */
    private int f25508v;

    /* renamed from: w */
    private View f25509w;

    /* renamed from: x */
    private int f25510x;

    /* renamed from: y */
    private ScrollableViewHelper f25511y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public View f25512z;

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelSlideListener */
    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState */
    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$SimplePanelSlideListener */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelSlide(View view, float f) {
        }

        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25497j = 400;
        this.f25498k = -1728053248;
        this.f25499m = new Paint();
        this.f25501o = -1;
        this.f25502p = -1;
        this.f25503q = -1;
        this.f25505s = false;
        this.f25506t = true;
        this.f25508v = -1;
        this.f25511y = new ScrollableViewHelper();
        PanelState panelState = f25472d;
        this.f25480B = panelState;
        this.f25481C = panelState;
        this.f25484F = 1.0f;
        this.f25491M = false;
        this.f25492N = new CopyOnWriteArrayList();
        this.f25495Q = true;
        this.f25496R = new Rect();
        if (isInEditMode()) {
            this.f25500n = null;
            this.f25494P = null;
            return;
        }
        Interpolator a = m20330a(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f25501o == -1) {
            this.f25501o = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f25502p == -1) {
            this.f25502p = (int) ((4.0f * f) + 0.5f);
        }
        if (this.f25503q == -1) {
            this.f25503q = (int) (0.0f * f);
        }
        if (this.f25502p <= 0) {
            this.f25500n = null;
        } else if (this.f25504r) {
            this.f25500n = getResources().getDrawable(R.drawable.above_shadow);
        } else {
            this.f25500n = getResources().getDrawable(R.drawable.below_shadow);
        }
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, a, new DragHelperCallback());
        this.f25494P = create;
        create.setMinVelocity(((float) this.f25497j) * f);
        this.f25486H = true;
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f25497j = 400;
        this.f25498k = -1728053248;
        this.f25499m = new Paint();
        this.f25501o = -1;
        this.f25502p = -1;
        this.f25503q = -1;
        this.f25505s = false;
        this.f25506t = true;
        this.f25508v = -1;
        this.f25511y = new ScrollableViewHelper();
        PanelState panelState = f25472d;
        this.f25480B = panelState;
        this.f25481C = panelState;
        this.f25484F = 1.0f;
        this.f25491M = false;
        this.f25492N = new CopyOnWriteArrayList();
        this.f25495Q = true;
        this.f25496R = new Rect();
        if (isInEditMode()) {
            this.f25500n = null;
            this.f25494P = null;
            return;
        }
        Interpolator a = m20330a(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f25501o == -1) {
            this.f25501o = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f25502p == -1) {
            this.f25502p = (int) ((4.0f * f) + 0.5f);
        }
        if (this.f25503q == -1) {
            this.f25503q = (int) (0.0f * f);
        }
        if (this.f25502p <= 0) {
            this.f25500n = null;
        } else if (this.f25504r) {
            this.f25500n = getResources().getDrawable(R.drawable.above_shadow);
        } else {
            this.f25500n = getResources().getDrawable(R.drawable.below_shadow);
        }
        setWillNotDraw(false);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, a, new DragHelperCallback());
        this.f25494P = create;
        create.setMinVelocity(((float) this.f25497j) * f);
        this.f25486H = true;
    }

    /* renamed from: a */
    private Interpolator m20330a(Context context, AttributeSet attributeSet) {
        Interpolator interpolator = null;
        if (attributeSet != null) {
            setGravity(80);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SlidingUpPanelLayout);
            if (obtainStyledAttributes != null) {
                this.f25501o = obtainStyledAttributes.getDimensionPixelSize(7, -1);
                this.f25502p = obtainStyledAttributes.getDimensionPixelSize(11, -1);
                this.f25503q = obtainStyledAttributes.getDimensionPixelSize(8, -1);
                this.f25497j = obtainStyledAttributes.getInt(4, 400);
                this.f25498k = obtainStyledAttributes.getColor(3, -1728053248);
                this.f25508v = obtainStyledAttributes.getResourceId(2, -1);
                this.f25510x = obtainStyledAttributes.getResourceId(10, -1);
                this.f25505s = obtainStyledAttributes.getBoolean(6, false);
                this.f25506t = obtainStyledAttributes.getBoolean(1, true);
                this.f25484F = obtainStyledAttributes.getFloat(0, 1.0f);
                int i = obtainStyledAttributes.getInt(5, 0);
                if (i == 0) {
                    this.f25480B = PanelState.EXPANDED;
                } else if (i == 1) {
                    this.f25480B = PanelState.COLLAPSED;
                } else if (i == 2) {
                    this.f25480B = PanelState.ANCHORED;
                } else if (i == 3) {
                    this.f25480B = PanelState.HIDDEN;
                } else if (i == 4) {
                    this.f25480B = PanelState.DRAGGING;
                }
                int resourceId = obtainStyledAttributes.getResourceId(9, -1);
                if (resourceId != -1) {
                    interpolator = AnimationUtils.loadInterpolator(context, resourceId);
                }
                obtainStyledAttributes.recycle();
            }
        }
        return interpolator;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f25508v;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.f25510x;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    public void setGravity(int i) {
        if (i == 48 || i == 80) {
            this.f25504r = i == 80;
            if (!this.f25495Q) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setCoveredFadeColor(int i) {
        this.f25498k = i;
        requestLayout();
    }

    public int getCoveredFadeColor() {
        return this.f25498k;
    }

    public void setTouchEnabled(boolean z) {
        this.f25486H = z;
    }

    public boolean isTouchEnabled() {
        return (!this.f25486H || this.f25512z == null || this.f25480B == PanelState.HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.f25501o = i;
            if (!this.f25495Q) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void smoothToBottom() {
        mo73611a(0.0f, 0);
    }

    public int getShadowHeight() {
        return this.f25502p;
    }

    public void setShadowHeight(int i) {
        this.f25502p = i;
        if (!this.f25495Q) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.f25501o;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.f25503q) * Math.max(this.f25482D, 0.0f));
        return this.f25504r ? -max : max;
    }

    public void setParallaxOffset(int i) {
        this.f25503q = i;
        if (!this.f25495Q) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.f25497j;
    }

    public void setMinFlingVelocity(int i) {
        this.f25497j = i;
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f25492N) {
            this.f25492N.add(panelSlideListener);
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.f25492N) {
            this.f25492N.remove(panelSlideListener);
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.f25493O = onClickListener;
    }

    public void setDragView(View view) {
        View view2 = this.f25507u;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        this.f25507u = view;
        if (view != null) {
            view.setClickable(true);
            this.f25507u.setFocusable(false);
            this.f25507u.setFocusableInTouchMode(false);
            this.f25507u.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.isTouchEnabled()) {
                        if (SlidingUpPanelLayout.this.f25480B == PanelState.EXPANDED || SlidingUpPanelLayout.this.f25480B == PanelState.ANCHORED) {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.COLLAPSED);
                        } else if (SlidingUpPanelLayout.this.f25484F < 1.0f) {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.ANCHORED);
                        } else {
                            SlidingUpPanelLayout.this.setPanelState(PanelState.EXPANDED);
                        }
                    }
                }
            });
        }
    }

    public void setDragView(int i) {
        this.f25508v = i;
        setDragView(findViewById(i));
    }

    public void setScrollableView(View view) {
        this.f25509w = view;
    }

    public void setScrollableViewHelper(ScrollableViewHelper scrollableViewHelper) {
        this.f25511y = scrollableViewHelper;
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.f25484F = f;
            this.f25495Q = true;
            requestLayout();
        }
    }

    public float getAnchorPoint() {
        return this.f25484F;
    }

    public void setOverlayed(boolean z) {
        this.f25505s = z;
    }

    public boolean isOverlayed() {
        return this.f25505s;
    }

    public void setClipPanel(boolean z) {
        this.f25506t = z;
    }

    public boolean isClipPanel() {
        return this.f25506t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73609a(View view) {
        synchronized (this.f25492N) {
            for (PanelSlideListener onPanelSlide : this.f25492N) {
                onPanelSlide.onPanelSlide(view, this.f25482D);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73610a(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.f25492N) {
            for (PanelSlideListener onPanelStateChanged : this.f25492N) {
                onPanelStateChanged.onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73608a() {
        int i;
        int i2;
        int i3;
        int i4;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.f25512z;
            int i5 = 0;
            if (view == null || !m20338b(view)) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i4 = this.f25512z.getLeft();
                i3 = this.f25512z.getRight();
                i2 = this.f25512z.getTop();
                i = this.f25512z.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo73613b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    private static boolean m20338b(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f25495Q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25495Q = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.f25479A = getChildAt(0);
                View childAt = getChildAt(1);
                this.f25512z = childAt;
                if (this.f25507u == null) {
                    setDragView(childAt);
                }
                if (this.f25512z.getVisibility() != 0) {
                    this.f25480B = PanelState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt2 = getChildAt(i7);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i7 != 0) {
                        if (childAt2 == this.f25479A) {
                            i4 = (this.f25505s || this.f25480B == PanelState.HIDDEN) ? paddingTop : paddingTop - this.f25501o;
                            i3 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                        } else {
                            i4 = childAt2 == this.f25512z ? paddingTop - layoutParams.topMargin : paddingTop;
                            i3 = paddingLeft;
                        }
                        if (layoutParams.width == -2) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                        } else if (layoutParams.width == -1) {
                            i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                        } else {
                            i5 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                        }
                        if (layoutParams.height == -2) {
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                        } else {
                            if (layoutParams.weight > 0.0f && layoutParams.weight < 1.0f) {
                                i4 = (int) (((float) i4) * layoutParams.weight);
                            } else if (layoutParams.height != -1) {
                                i4 = layoutParams.height;
                            }
                            i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                        }
                        childAt2.measure(i5, i6);
                        View view = this.f25512z;
                        if (childAt2 == view) {
                            this.f25483E = view.getMeasuredHeight() - this.f25501o;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f25495Q) {
            int i5 = C96582.f25513xb884d6[this.f25480B.ordinal()];
            if (i5 == 1) {
                this.f25482D = 1.0f;
            } else if (i5 == 2) {
                this.f25482D = this.f25484F;
            } else if (i5 != 3) {
                this.f25482D = 0.0f;
            } else {
                this.f25482D = m20326a(m20329a(0.0f) + (this.f25504r ? this.f25501o : -this.f25501o));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.f25495Q)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int a = childAt == this.f25512z ? m20329a(this.f25482D) : paddingTop;
                if (!this.f25504r && childAt == this.f25479A && !this.f25505s) {
                    a = m20329a(this.f25482D) + this.f25512z.getMeasuredHeight();
                }
                int i7 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i7, a, childAt.getMeasuredWidth() + i7, measuredHeight + a);
            }
        }
        if (this.f25495Q) {
            mo73608a();
        }
        m20339c();
        this.f25495Q = false;
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$2 */
    static /* synthetic */ class C96582 {

        /* renamed from: $SwitchMap$com$didi$hawaii$ar$core$zg$slidingup$SlidingUpPanelLayout$PanelState */
        static final /* synthetic */ int[] f25513xb884d6;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState[] r0 = com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.PanelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25513xb884d6 = r0
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.PanelState.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25513xb884d6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.PanelState.ANCHORED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25513xb884d6     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.PanelState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25513xb884d6     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$PanelState r1 = com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.PanelState.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.C96582.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.f25495Q = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0 != 3) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.f25491M
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r8.isTouchEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x00a4
        L_0x000d:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            float r2 = r9.getX()
            float r3 = r9.getY()
            float r4 = r8.f25489K
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r8.f25490L
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r6 = r8.f25494P
            int r6 = r6.getTouchSlop()
            r7 = 1
            if (r0 == 0) goto L_0x0085
            if (r0 == r7) goto L_0x004c
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r2 = 3
            if (r0 == r2) goto L_0x004c
            goto L_0x009d
        L_0x003b:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f25494P
            r9.cancel()
            r8.f25485G = r7
            return r1
        L_0x004c:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f25494P
            boolean r0 = r0.isDragging()
            if (r0 == 0) goto L_0x005a
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f25494P
            r0.processTouchEvent(r9)
            return r7
        L_0x005a:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x009d
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x009d
            float r0 = r8.f25482D
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009d
            android.view.View r0 = r8.f25512z
            float r2 = r8.f25489K
            int r2 = (int) r2
            float r3 = r8.f25490L
            int r3 = (int) r3
            boolean r0 = r8.m20333a((android.view.View) r0, (int) r2, (int) r3)
            if (r0 != 0) goto L_0x009d
            android.view.View$OnClickListener r0 = r8.f25493O
            if (r0 == 0) goto L_0x009d
            r8.playSoundEffect(r1)
            android.view.View$OnClickListener r9 = r8.f25493O
            r9.onClick(r8)
            return r7
        L_0x0085:
            r8.f25485G = r1
            r8.f25489K = r2
            r8.f25490L = r3
            android.view.View r0 = r8.f25507u
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r8.m20333a((android.view.View) r0, (int) r2, (int) r3)
            if (r0 != 0) goto L_0x009d
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f25494P
            r9.cancel()
            r8.f25485G = r7
            return r1
        L_0x009d:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r0 = r8.f25494P
            boolean r9 = r0.shouldInterceptTouchEvent(r9)
            return r9
        L_0x00a4:
            com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper r9 = r8.f25494P
            r9.abort()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.f25494P.processTouchEvent(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !isTouchEnabled() || (this.f25485G && actionMasked != 0)) {
            this.f25494P.abort();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.f25491M = false;
            this.f25487I = x;
            this.f25488J = y;
        } else if (actionMasked == 2) {
            float f = y - this.f25488J;
            this.f25487I = x;
            this.f25488J = y;
            if (Math.abs(x - this.f25487I) > Math.abs(f)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!m20333a(this.f25509w, (int) this.f25489K, (int) this.f25490L)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int i = -1;
            if (((float) (this.f25504r ? 1 : -1)) * f <= 0.0f) {
                if (this.f25504r) {
                    i = 1;
                }
                if (f * ((float) i) < 0.0f) {
                    if (this.f25482D < 1.0f) {
                        this.f25491M = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.f25491M && this.f25494P.isDragging()) {
                        this.f25494P.cancel();
                        motionEvent.setAction(0);
                    }
                    this.f25491M = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (this.f25511y.getScrollableViewScrollPosition(this.f25509w, this.f25504r) > 0) {
                this.f25491M = true;
                return super.dispatchTouchEvent(motionEvent);
            } else {
                if (this.f25491M) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    motionEvent.setAction(0);
                }
                this.f25491M = false;
                return onTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.f25491M) {
            this.f25494P.setDragState(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m20333a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m20329a(float f) {
        View view = this.f25512z;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i = (int) (f * ((float) this.f25483E));
        if (this.f25504r) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.f25501o) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.f25501o + i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m20326a(int i) {
        int a = m20329a(0.0f);
        return (this.f25504r ? (float) (a - i) : (float) (i - a)) / ((float) this.f25483E);
    }

    public PanelState getPanelState() {
        return this.f25480B;
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        if (this.f25494P.getViewDragState() == 2) {
            SystemUtils.log(3, f25469a, "View is settling. Aborting animation.", (Throwable) null, "com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout", 1158);
            this.f25494P.abort();
        }
        if (panelState == null || panelState == PanelState.DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (!isEnabled()) {
        } else {
            if ((this.f25495Q || this.f25512z != null) && panelState != (panelState2 = this.f25480B) && panelState2 != PanelState.DRAGGING) {
                if (this.f25495Q) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (this.f25480B == PanelState.HIDDEN) {
                    this.f25512z.setVisibility(0);
                    requestLayout();
                }
                int i = C96582.f25513xb884d6[panelState.ordinal()];
                if (i == 1) {
                    mo73611a(1.0f, 0);
                } else if (i == 2) {
                    mo73611a(this.f25484F, 0);
                } else if (i == 3) {
                    mo73611a(m20326a(m20329a(0.0f) + (this.f25504r ? this.f25501o : -this.f25501o)), 0);
                } else if (i == 4) {
                    mo73611a(0.0f, 0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPanelStateInternal(PanelState panelState) {
        PanelState panelState2 = this.f25480B;
        if (panelState2 != panelState) {
            this.f25480B = panelState;
            mo73610a((View) this, panelState2, panelState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20339c() {
        if (this.f25503q > 0) {
            ViewCompat.setTranslationY(this.f25479A, (float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20336b(int i) {
        if (this.f25480B != PanelState.DRAGGING) {
            this.f25481C = this.f25480B;
        }
        setPanelStateInternal(PanelState.DRAGGING);
        this.f25482D = m20326a(i);
        m20339c();
        mo73609a(this.f25512z);
        LayoutParams layoutParams = (LayoutParams) this.f25479A.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.f25501o;
        if (this.f25482D <= 0.0f && !this.f25505s) {
            layoutParams.height = this.f25504r ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.f25512z.getMeasuredHeight()) - i;
            if (layoutParams.height == height) {
                layoutParams.height = -1;
            }
            this.f25479A.requestLayout();
        } else if (layoutParams.height != -1 && !this.f25505s) {
            layoutParams.height = -1;
            this.f25479A.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        int save = canvas.save();
        View view2 = this.f25512z;
        if (view2 == null || view2 == view) {
            z = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.f25496R);
            if (!this.f25505s) {
                if (this.f25504r) {
                    Rect rect = this.f25496R;
                    rect.bottom = Math.min(rect.bottom, this.f25512z.getTop());
                } else {
                    Rect rect2 = this.f25496R;
                    rect2.top = Math.max(rect2.top, this.f25512z.getBottom());
                }
            }
            if (this.f25506t) {
                canvas.clipRect(this.f25496R);
            }
            z = super.drawChild(canvas, view, j);
            int i = this.f25498k;
            if (i != 0) {
                float f = this.f25482D;
                if (f > 0.0f) {
                    this.f25499m.setColor((i & 16777215) | (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24));
                    canvas.drawRect(this.f25496R, this.f25499m);
                }
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo73611a(float f, int i) {
        if (isEnabled() && this.f25512z != null) {
            int a = m20329a(f);
            ViewDragHelper viewDragHelper = this.f25494P;
            View view = this.f25512z;
            if (viewDragHelper.smoothSlideViewTo(view, view.getLeft(), a)) {
                mo73613b();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f25494P;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            if (!isEnabled()) {
                this.f25494P.abort();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public void draw(Canvas canvas) {
        View view;
        int i;
        int i2;
        super.draw(canvas);
        if (this.f25500n != null && (view = this.f25512z) != null) {
            int right = view.getRight();
            if (this.f25504r) {
                i2 = this.f25512z.getTop() - this.f25502p;
                i = this.f25512z.getTop();
            } else {
                i2 = this.f25512z.getBottom();
                i = this.f25512z.getBottom() + this.f25502p;
            }
            this.f25500n.setBounds(this.f25512z.getLeft(), i2, right, i);
            this.f25500n.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || !ViewCompat.canScrollHorizontally(view, -i)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable(SLIDING_STATE, this.f25480B != PanelState.DRAGGING ? this.f25480B : this.f25481C);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.f25480B = panelState;
            if (panelState == null) {
                panelState = f25472d;
            }
            this.f25480B = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$DragHelperCallback */
    private class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        public boolean tryCaptureView(View view, int i) {
            return !SlidingUpPanelLayout.this.f25485G && view == SlidingUpPanelLayout.this.f25512z;
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingUpPanelLayout.this.f25494P != null && SlidingUpPanelLayout.this.f25494P.getViewDragState() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                float unused = slidingUpPanelLayout.f25482D = slidingUpPanelLayout.m20326a(slidingUpPanelLayout.f25512z.getTop());
                SlidingUpPanelLayout.this.m20339c();
                if (SlidingUpPanelLayout.this.f25482D == 1.0f) {
                    SlidingUpPanelLayout.this.mo73608a();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (SlidingUpPanelLayout.this.f25482D == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (SlidingUpPanelLayout.this.f25482D < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.f25512z.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.mo73608a();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.mo73613b();
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.m20336b(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            if (SlidingUpPanelLayout.this.f25504r) {
                f2 = -f2;
            }
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 > 0 && SlidingUpPanelLayout.this.f25482D <= SlidingUpPanelLayout.this.f25484F) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                i = slidingUpPanelLayout.m20329a(slidingUpPanelLayout.f25484F);
            } else if (i2 <= 0 || SlidingUpPanelLayout.this.f25482D <= SlidingUpPanelLayout.this.f25484F) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 < 0 && SlidingUpPanelLayout.this.f25482D >= SlidingUpPanelLayout.this.f25484F) {
                    SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                    i = slidingUpPanelLayout2.m20329a(slidingUpPanelLayout2.f25484F);
                } else if (i3 < 0 && SlidingUpPanelLayout.this.f25482D < SlidingUpPanelLayout.this.f25484F) {
                    i = SlidingUpPanelLayout.this.m20329a(0.0f);
                } else if (SlidingUpPanelLayout.this.f25482D >= (SlidingUpPanelLayout.this.f25484F + 1.0f) / 2.0f) {
                    i = SlidingUpPanelLayout.this.m20329a(1.0f);
                } else if (SlidingUpPanelLayout.this.f25482D >= SlidingUpPanelLayout.this.f25484F / 2.0f) {
                    SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                    i = slidingUpPanelLayout3.m20329a(slidingUpPanelLayout3.f25484F);
                } else {
                    i = SlidingUpPanelLayout.this.m20329a(0.0f);
                }
            } else {
                i = SlidingUpPanelLayout.this.m20329a(1.0f);
            }
            if (SlidingUpPanelLayout.this.f25494P != null) {
                SlidingUpPanelLayout.this.f25494P.settleCapturedViewAt(view.getLeft(), i);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.f25483E;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int b = SlidingUpPanelLayout.this.m20329a(0.0f);
            int b2 = SlidingUpPanelLayout.this.m20329a(1.0f);
            if (SlidingUpPanelLayout.this.f25504r) {
                return Math.min(Math.max(i, b2), b);
            }
            return Math.min(Math.max(i, b), b2);
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.SlidingUpPanelLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }
}
