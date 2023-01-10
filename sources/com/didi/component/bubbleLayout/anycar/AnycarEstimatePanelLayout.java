package com.didi.component.bubbleLayout.anycar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnycarEstimatePanelLayout extends FrameLayout implements NestedScrollingParent {

    /* renamed from: A */
    private List<INestChildScrollChange> f12913A;

    /* renamed from: B */
    private INestChildDispatchTouchEvent f12914B;

    /* renamed from: C */
    private Map<Integer, OnNestOffsetChangedListener> f12915C = new ArrayMap();

    /* renamed from: D */
    private boolean f12916D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f12917E = 0;

    /* renamed from: F */
    private boolean f12918F = false;

    /* renamed from: G */
    private int f12919G = 0;

    /* renamed from: H */
    private boolean f12920H = false;

    /* renamed from: I */
    private final Property<AnycarEstimatePanelLayout, Float> f12921I = new Property<AnycarEstimatePanelLayout, Float>(Float.class, "sheetTranslation") {
        public Float get(AnycarEstimatePanelLayout anycarEstimatePanelLayout) {
            return Float.valueOf(((float) AnycarEstimatePanelLayout.this.f12940s) - anycarEstimatePanelLayout.f12944w);
        }

        public void set(AnycarEstimatePanelLayout anycarEstimatePanelLayout, Float f) {
            anycarEstimatePanelLayout.m10893a(f.floatValue());
        }
    };

    /* renamed from: a */
    int f12922a = 0;

    /* renamed from: b */
    private final Logger f12923b = LoggerFactory.getLogger("AnycarEstimatePanelLayout");

    /* renamed from: c */
    private View f12924c;

    /* renamed from: d */
    private ObjectAnimator f12925d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ObjectAnimator f12926e;

    /* renamed from: f */
    private VelocityTracker f12927f;

    /* renamed from: g */
    private float f12928g;

    /* renamed from: h */
    private float f12929h;

    /* renamed from: i */
    private float f12930i;

    /* renamed from: j */
    private float f12931j;

    /* renamed from: k */
    private float f12932k;

    /* renamed from: l */
    private float f12933l = 0.0f;

    /* renamed from: m */
    private int f12934m = 300;

    /* renamed from: n */
    private int f12935n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f12936o = 3;

    /* renamed from: p */
    private int f12937p = 1;

    /* renamed from: q */
    private float f12938q = 1.0f;

    /* renamed from: r */
    private float f12939r = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f12940s = 0;

    /* renamed from: t */
    private int f12941t;

    /* renamed from: u */
    private boolean f12942u;

    /* renamed from: v */
    private boolean f12943v = true;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public float f12944w;

    /* renamed from: x */
    private boolean f12945x = false;

    /* renamed from: y */
    private boolean f12946y = true;

    /* renamed from: z */
    private boolean f12947z = true;

    public interface INestChildDispatchTouchEvent {
        void dispatchWrapperOrigineTouchEvent(MotionEvent motionEvent);

        void dispatchWrapperTouchEvent(MotionEvent motionEvent);
    }

    public interface INestChildScrollChange {
        void onFingerUp(float f);

        void onNestChildHorizationScroll(MotionEvent motionEvent, float f, float f2);

        void onNestChildScrollChange(float f, float f2);

        void onNestChildScrollRelease(float f, int i);

        void onNestScrollingState(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scrolltate {
        public static final int SCROLL_STATE_DRAGGING = 0;
        public static final int SCROLL_STATE_SETTLING = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SheetDirection {
        public static final int ALL = 0;
        public static final int BOTTOM = 2;
        public static final int TOP = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowState {
        public static final int EXTEND = 2;
        public static final int HIDE = 0;
        public static final int INIT = 3;
        public static final int PEEK = 1;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10901a(String str) {
        Logger logger = this.f12923b;
        logger.info("dongxt-panel---" + str, new Object[0]);
    }

    public AnycarEstimatePanelLayout(Context context) {
        super(context);
        m10892a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10892a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10892a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m10892a();
    }

    /* renamed from: a */
    private void m10892a() {
        this.f12913A = new ArrayList();
        this.f12929h = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        m10901a("init mtouchslop " + this.f12929h);
        post(new Runnable() {
            public void run() {
                AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                int unused = anycarEstimatePanelLayout.f12940s = anycarEstimatePanelLayout.getMeasuredHeight();
                if (AnycarEstimatePanelLayout.this.f12922a != 0) {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout2 = AnycarEstimatePanelLayout.this;
                    int unused2 = anycarEstimatePanelLayout2.f12917E = anycarEstimatePanelLayout2.f12940s - AnycarEstimatePanelLayout.this.f12922a;
                }
                AnycarEstimatePanelLayout anycarEstimatePanelLayout3 = AnycarEstimatePanelLayout.this;
                anycarEstimatePanelLayout3.m10901a("init height " + AnycarEstimatePanelLayout.this.f12940s + "、 mLockTopTranslateY =" + AnycarEstimatePanelLayout.this.f12917E);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() <= 1) {
            this.f12924c = getChildAt(0);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    public void addView(View view) {
        if (getChildCount() < 1) {
            this.f12924c = view;
            super.addView(view);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() < 1) {
            m10898a(view);
            this.f12924c = view;
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    class OnNestOffsetChangedListener implements AppBarLayout.OnOffsetChangedListener {
        int offsetY = 0;

        OnNestOffsetChangedListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.offsetY = i;
        }

        public int getOffsetY() {
            return Math.abs(this.offsetY);
        }
    }

    /* renamed from: a */
    private void m10898a(View view) {
        m10901a("deepSearchView == " + view.getClass());
        if (view instanceof AppBarLayout) {
            OnNestOffsetChangedListener onNestOffsetChangedListener = new OnNestOffsetChangedListener();
            this.f12915C.put(Integer.valueOf(view.hashCode()), onNestOffsetChangedListener);
            ((AppBarLayout) view).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) onNestOffsetChangedListener);
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    m10898a(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12927f = VelocityTracker.obtain();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearNestScrollChildCallback();
        this.f12927f.clear();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12920H) {
            return true;
        }
        if (m10913b()) {
            return false;
        }
        if (!this.f12946y || m10915b(getChildAt(0), motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10904a(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if ((rawX < ((float) iArr[0]) || rawX > ((float) (iArr[0] + view.getMeasuredWidth())) || rawY < ((float) iArr[1]) || rawY > ((float) (iArr[1] + view.getMeasuredHeight()))) && this.f12947z) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m10915b(View view, MotionEvent motionEvent) {
        Class<?> cls = view.getClass();
        int i = 0;
        if (cls.getSimpleName().equals(AnycarEstimatePanelLayout.class.getSimpleName())) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getShowState", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                if ((invoke instanceof Integer) && ((Integer) invoke).intValue() == 0) {
                    return false;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return m10904a(view, motionEvent);
        } else if (!(view instanceof ViewGroup)) {
            return false;
        } else {
            boolean z = false;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return z;
                }
                if (m10915b(viewGroup.getChildAt(i), motionEvent)) {
                    z = true;
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            boolean r0 = r11.f12920H
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r11.m10913b()
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            boolean r0 = r11.f12946y
            if (r0 == 0) goto L_0x01dc
            android.view.View r0 = r11.getChildAt(r1)
            if (r0 == 0) goto L_0x01dc
            android.view.View r0 = r11.getChildAt(r1)
            boolean r0 = r11.m10904a((android.view.View) r0, (android.view.MotionEvent) r12)
            r2 = 2
            if (r0 != 0) goto L_0x002a
            int r0 = r12.getAction()
            if (r0 == r2) goto L_0x002a
            goto L_0x01dc
        L_0x002a:
            r11.m10911b((android.view.MotionEvent) r12)
            int r0 = r12.getAction()
            r3 = 1
            if (r0 != 0) goto L_0x0068
            android.view.View r0 = r11.f12924c
            float r0 = r0.getTranslationY()
            r11.f12933l = r0
            int r0 = r11.getMeasuredHeight()
            r11.f12940s = r0
            r11.f12942u = r1
            float r0 = r12.getY()
            r11.f12930i = r0
            float r0 = r12.getX()
            r11.f12931j = r0
            int r0 = r11.f12940s
            float r0 = (float) r0
            float r4 = r11.f12933l
            float r0 = r0 - r4
            r11.f12944w = r0
            r11.f12932k = r0
            android.view.VelocityTracker r0 = r11.f12927f
            r0.clear()
            r11.f12945x = r3
            android.view.View r0 = r11.getChildAt(r1)
            r11.m10920c((android.view.View) r0, (android.view.MotionEvent) r12)
        L_0x0068:
            android.view.VelocityTracker r0 = r11.f12927f
            r0.addMovement(r12)
            int r0 = r12.getAction()
            r4 = 3
            r5 = 0
            if (r0 == r3) goto L_0x007e
            int r0 = r12.getAction()
            if (r0 != r4) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r0 = 0
            goto L_0x0090
        L_0x007e:
            r11.f12945x = r1
            android.view.VelocityTracker r0 = r11.f12927f
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            android.view.VelocityTracker r0 = r11.f12927f
            float r0 = r0.getYVelocity()
            r11.m10908b((float) r0)
        L_0x0090:
            android.view.ViewParent r6 = r11.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            int r6 = r11.f12940s
            float r7 = (float) r6
            boolean r8 = r11.f12916D
            if (r8 == 0) goto L_0x00a2
            int r7 = r11.f12922a
            int r6 = r6 - r7
            float r7 = (float) r6
        L_0x00a2:
            float r6 = r11.f12930i
            float r8 = r12.getY()
            float r6 = r6 - r8
            float r8 = r11.f12931j
            float r9 = r12.getX()
            float r8 = r8 - r9
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x00b9
            float r9 = r11.f12939r
        L_0x00b6:
            float r6 = r6 * r9
            goto L_0x00c0
        L_0x00b9:
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x00c0
            float r9 = r11.f12938q
            goto L_0x00b6
        L_0x00c0:
            boolean r9 = r11.f12942u
            if (r9 != 0) goto L_0x00f9
            float r9 = java.lang.Math.abs(r6)
            android.content.Context r10 = r11.getContext()
            android.view.ViewConfiguration r10 = android.view.ViewConfiguration.get(r10)
            int r10 = r10.getScaledTouchSlop()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00e7
            float r9 = java.lang.Math.abs(r6)
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e7
            r8 = 1
            goto L_0x00e8
        L_0x00e7:
            r8 = 0
        L_0x00e8:
            r11.f12942u = r8
            if (r8 == 0) goto L_0x00f9
            float r6 = r12.getY()
            r11.f12930i = r6
            float r6 = r12.getX()
            r11.f12931j = r6
            r6 = 0
        L_0x00f9:
            float r8 = r11.f12932k
            float r8 = r8 + r6
            r11.m10896a((android.view.MotionEvent) r12)
            boolean r9 = r11.f12942u
            if (r9 == 0) goto L_0x01cb
            boolean r9 = r11.f12943v
            if (r9 == 0) goto L_0x0131
            boolean r9 = r11.m10902a((android.view.MotionEvent) r12, (float) r6)
            if (r9 != 0) goto L_0x0131
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0131
            float r8 = r12.getY()
            r11.f12930i = r8
            android.view.VelocityTracker r8 = r11.f12927f
            r8.clear()
            r11.f12943v = r1
            float r8 = r11.f12944w
            android.view.MotionEvent r9 = android.view.MotionEvent.obtain(r12)
            r9.setAction(r4)
            android.view.View r10 = r11.getChildAt(r1)
            r10.dispatchTouchEvent(r9)
            r9.recycle()
        L_0x0131:
            boolean r9 = r11.f12943v
            if (r9 != 0) goto L_0x0161
            boolean r9 = r11.m10902a((android.view.MotionEvent) r12, (float) r6)
            if (r9 == 0) goto L_0x0161
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0161
            r11.m10894a((float) r7, (float) r5)
            r11.f12943v = r3
            int r7 = r12.getAction()
            if (r7 != r2) goto L_0x0161
            android.view.MotionEvent r7 = android.view.MotionEvent.obtain(r12)
            r7.setAction(r1)
            android.view.View r9 = r11.getChildAt(r1)
            r9.dispatchTouchEvent(r7)
            r7.recycle()
            r11.m10908b((float) r5)
            r11.m10910b((int) r3)
        L_0x0161:
            boolean r7 = r11.f12943v
            if (r7 == 0) goto L_0x017d
            int r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x017d
            float r0 = r11.f12944w
            int r2 = r11.f12940s
            float r2 = (float) r2
            float r0 = r0 - r2
            r12.offsetLocation(r5, r0)
            android.view.View r0 = r11.getChildAt(r1)
            r0.dispatchTouchEvent(r12)
            r11.m10910b((int) r3)
            goto L_0x01db
        L_0x017d:
            boolean r5 = r11.f12916D
            if (r5 == 0) goto L_0x018e
            int r5 = r11.f12940s
            int r7 = r11.f12922a
            int r5 = r5 - r7
            r11.f12917E = r5
            float r7 = (float) r5
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x018e
            float r8 = (float) r5
        L_0x018e:
            boolean r5 = r11.f12918F
            if (r5 == 0) goto L_0x019a
            int r5 = r11.f12919G
            float r7 = (float) r5
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x019a
            float r8 = (float) r5
        L_0x019a:
            r11.m10894a((float) r8, (float) r6)
            int r5 = r12.getAction()
            if (r5 == r3) goto L_0x01a9
            int r12 = r12.getAction()
            if (r12 != r4) goto L_0x01db
        L_0x01a9:
            r11.f12943v = r3
            android.view.ViewParent r12 = r11.getParent()
            r12.requestDisallowInterceptTouchEvent(r1)
            float r12 = java.lang.Math.abs(r0)
            float r1 = r11.f12928g
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x01c6
            float r12 = r11.f12944w
            int r1 = r11.getHeight()
            int r1 = r1 / r2
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        L_0x01c6:
            int r12 = (int) r0
            r11.m10895a((int) r12)
            goto L_0x01db
        L_0x01cb:
            float r0 = r11.f12944w
            int r2 = r11.f12940s
            float r2 = (float) r2
            float r0 = r0 - r2
            r12.offsetLocation(r5, r0)
            android.view.View r0 = r11.getChildAt(r1)
            r0.dispatchTouchEvent(r12)
        L_0x01db:
            return r3
        L_0x01dc:
            r11.m10911b((android.view.MotionEvent) r12)
            boolean r12 = super.onTouchEvent(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.bubbleLayout.anycar.AnycarEstimatePanelLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private boolean m10902a(MotionEvent motionEvent, float f) {
        boolean z = f - this.f12933l < 0.0f;
        boolean canScrollDown = canScrollDown(getChildAt(0), motionEvent, motionEvent.getX(), motionEvent.getY() + (this.f12944w - ((float) getHeight())), false);
        boolean z2 = f - this.f12933l > 0.0f;
        boolean canScrollUp = canScrollUp(getChildAt(0), motionEvent, motionEvent.getX(), motionEvent.getY() + (this.f12944w - ((float) getHeight())), false);
        if (z && canScrollUp) {
            return true;
        }
        if (!z2 || !canScrollDown) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScrollUp(View view, MotionEvent motionEvent, float f, float f2, boolean z) {
        View view2 = view;
        if (view2 instanceof WebView) {
            return m10905a((WebView) view2);
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                boolean z2 = f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()));
                if (!z || z2) {
                    if (canScrollUp(childAt, motionEvent, f - f3, f2 - ((float) top), z)) {
                        return true;
                    }
                }
            }
        }
        if (view2 instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
            if (coordinatorLayout.getChildCount() > 0 && (coordinatorLayout.getChildAt(0) instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) coordinatorLayout.getChildAt(0);
                OnNestOffsetChangedListener onNestOffsetChangedListener = this.f12915C.get(Integer.valueOf(appBarLayout.hashCode()));
                if (onNestOffsetChangedListener != null && onNestOffsetChangedListener.getOffsetY() < appBarLayout.getMeasuredHeight() && onNestOffsetChangedListener.getOffsetY() > 0) {
                    return true;
                }
            }
        }
        if (!m10904a(view, motionEvent) || !view.canScrollVertically(-1)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScrollDown(View view, MotionEvent motionEvent, float f, float f2, boolean z) {
        View view2 = view;
        if (view2 instanceof WebView) {
            return m10916b((WebView) view2);
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                boolean z2 = f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()));
                if (!z || z2) {
                    if (canScrollDown(childAt, motionEvent, f - f3, f2 - ((float) top), z)) {
                        return true;
                    }
                }
            }
        }
        if (view2 instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
            if (coordinatorLayout.getChildCount() > 0 && (coordinatorLayout.getChildAt(0) instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) coordinatorLayout.getChildAt(0);
                OnNestOffsetChangedListener onNestOffsetChangedListener = this.f12915C.get(Integer.valueOf(appBarLayout.hashCode()));
                if (onNestOffsetChangedListener != null && onNestOffsetChangedListener.getOffsetY() < appBarLayout.getMeasuredHeight() && onNestOffsetChangedListener.getOffsetY() > 0) {
                    return true;
                }
            }
        }
        if (!m10904a(view, motionEvent) || !view.canScrollVertically(1)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10903a(View view, float f, float f2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                if ((f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()))) && m10903a(childAt, f - f3, f2 - ((float) top))) {
                    return true;
                }
            }
        }
        return view.canScrollHorizontally(-1);
    }

    /* renamed from: b */
    private boolean m10914b(View view, float f, float f2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                if ((f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()))) && m10914b(childAt, f - f3, f2 - ((float) top))) {
                    return true;
                }
            }
        }
        return view.canScrollHorizontally(1);
    }

    /* renamed from: a */
    private boolean m10905a(WebView webView) {
        if (this.f12941t == 0) {
            this.f12941t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        }
        return this.f12941t - webView.getHeight() != 0 && webView.getScrollY() > 2;
    }

    /* renamed from: b */
    private boolean m10916b(WebView webView) {
        if (this.f12941t == 0) {
            this.f12941t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        }
        int scrollY = webView.getScrollY();
        int height = this.f12941t - webView.getHeight();
        return height != 0 && scrollY < height + -2;
    }

    /* renamed from: a */
    private void m10896a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f12944w - ((float) this.f12940s));
        INestChildDispatchTouchEvent iNestChildDispatchTouchEvent = this.f12914B;
        if (iNestChildDispatchTouchEvent != null) {
            iNestChildDispatchTouchEvent.dispatchWrapperTouchEvent(obtain);
        }
    }

    /* renamed from: b */
    private void m10911b(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        INestChildDispatchTouchEvent iNestChildDispatchTouchEvent = this.f12914B;
        if (iNestChildDispatchTouchEvent != null) {
            iNestChildDispatchTouchEvent.dispatchWrapperOrigineTouchEvent(obtain);
        }
    }

    /* renamed from: c */
    private void m10920c(View view, MotionEvent motionEvent) {
        if ((view instanceof WebView) && m10904a(view, motionEvent)) {
            WebView webView = (WebView) view;
            this.f12941t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        } else if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    m10920c(viewGroup.getChildAt(i), motionEvent);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m10894a(float f, float f2) {
        this.f12944w = f;
        this.f12927f.computeCurrentVelocity(1000);
        m10909b((float) ((int) (((double) this.f12940s) - Math.ceil((double) f))), this.f12927f.getYVelocity());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10893a(float f) {
        this.f12944w = ((float) this.f12940s) - f;
        m10909b(f, 0.0f);
    }

    /* renamed from: b */
    private void m10909b(float f, float f2) {
        if (this.f12935n == 2 && f < 0.0f) {
            this.f12924c.setTranslationY(0.0f);
            m10918c(0.0f, f2);
        } else if (this.f12935n != 1 || f <= 0.0f) {
            m10918c(f, f2);
            m10910b(0);
            View view = this.f12924c;
            if (view != null) {
                view.setTranslationY(f);
            }
            if (f == 0.0f) {
                this.f12932k = (float) this.f12940s;
                this.f12930i -= this.f12933l;
                this.f12933l = 0.0f;
            }
        } else {
            this.f12924c.setTranslationY(0.0f);
            m10918c(0.0f, f2);
        }
    }

    public void recover(int i) {
        recover(i, (Runnable) null);
    }

    public void recover(int i, Runnable runnable) {
        recover(i, runnable, this.f12934m);
    }

    public void recover(int i, final Runnable runnable, int i2) {
        ObjectAnimator objectAnimator = this.f12926e;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f12921I, new float[]{(float) i});
            this.f12926e = ofFloat;
            ofFloat.setDuration((long) i2);
            this.f12926e.setInterpolator(new DecelerateInterpolator(1.0f));
            this.f12926e.addListener(new CancelDetectionAnimationListener() {
                public void onAnimationEnd(Animator animator) {
                    if (!this.canceled) {
                        ObjectAnimator unused = AnycarEstimatePanelLayout.this.f12926e = null;
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                    AnycarEstimatePanelLayout.this.m10910b(1);
                }
            });
            this.f12926e.start();
        }
    }

    /* renamed from: a */
    private void m10897a(MotionEvent motionEvent, float f, float f2) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            m10912b(motionEvent, f, f2);
        } else if (Math.abs(f) > this.f12929h * 8.0f && Math.abs(f) > Math.abs(f2) && Math.abs(f) > 0.0f) {
            m10912b(motionEvent, f, f2);
        }
    }

    /* renamed from: b */
    private boolean m10913b() {
        ObjectAnimator objectAnimator = this.f12926e;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    private static class CancelDetectionAnimationListener extends AnimatorListenerAdapter {
        protected boolean canceled;

        private CancelDetectionAnimationListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.canceled = true;
        }
    }

    @Deprecated
    /* renamed from: c */
    private void m10919c(MotionEvent motionEvent) {
        this.f12924c.setTranslationY(m10922d(motionEvent));
    }

    @Deprecated
    public void onActionRelease(MotionEvent motionEvent) {
        m10922d(motionEvent);
        ObjectAnimator objectAnimator = this.f12925d;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f12925d.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12924c, View.TRANSLATION_Y, new float[]{this.f12924c.getTranslationY(), 0.0f});
        this.f12925d = ofFloat;
        ofFloat.setDuration(200);
        this.f12925d.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f));
        this.f12925d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
            }
        });
        this.f12925d.start();
    }

    public void registerNestScrollChildCallback(INestChildScrollChange iNestChildScrollChange) {
        if (!this.f12913A.contains(iNestChildScrollChange)) {
            this.f12913A.add(iNestChildScrollChange);
        }
    }

    public void registerWrapperDispatchEvent(INestChildDispatchTouchEvent iNestChildDispatchTouchEvent) {
        this.f12914B = iNestChildDispatchTouchEvent;
    }

    public void removeNestScrollChildCallback(INestChildScrollChange iNestChildScrollChange) {
        if (this.f12913A.contains(iNestChildScrollChange)) {
            this.f12913A.remove(iNestChildScrollChange);
        }
    }

    public void clearNestScrollChildCallback() {
        this.f12913A.clear();
    }

    /* renamed from: c */
    private void m10918c(float f, float f2) {
        for (INestChildScrollChange onNestChildScrollChange : this.f12913A) {
            onNestChildScrollChange.onNestChildScrollChange(f, f2);
        }
    }

    /* renamed from: a */
    private void m10895a(int i) {
        for (INestChildScrollChange onNestChildScrollRelease : this.f12913A) {
            onNestChildScrollRelease.onNestChildScrollRelease(getChildAt(0).getTranslationY(), i);
        }
    }

    /* renamed from: b */
    private void m10912b(MotionEvent motionEvent, float f, float f2) {
        for (INestChildScrollChange onNestChildHorizationScroll : this.f12913A) {
            onNestChildHorizationScroll.onNestChildHorizationScroll(motionEvent, f, f2);
        }
    }

    /* renamed from: b */
    private void m10908b(float f) {
        for (INestChildScrollChange onFingerUp : this.f12913A) {
            onFingerUp.onFingerUp(f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10910b(int i) {
        this.f12937p = i;
        for (INestChildScrollChange onNestScrollingState : this.f12913A) {
            onNestScrollingState.onNestScrollingState(i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    /* renamed from: d */
    private float m10922d(MotionEvent motionEvent) {
        return motionEvent.getRawY();
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        super.onNestedPreScroll(view, i, i2, iArr);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return super.onNestedFling(view, f, f2, z);
    }

    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
    }

    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    public boolean isFingerHolderTouch() {
        return this.f12945x;
    }

    public float getMinFlingVelocity() {
        return this.f12928g;
    }

    public void updateStatus(int i, int i2) {
        if (i == 0) {
            hiden(i2);
        } else if (i == 1) {
            peek(i2);
        } else if (i == 2) {
            expand();
        }
    }

    public void expand() {
        expand((Runnable) null);
    }

    public void peek(int i) {
        peek(i, (Runnable) null);
    }

    public void hiden() {
        hiden((Runnable) null);
    }

    public void expand(Runnable runnable) {
        expand(runnable, this.f12934m);
    }

    public void expand(final Runnable runnable, int i) {
        recover(this.f12922a, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f12936o = 2;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i);
    }

    public void peek(int i, Runnable runnable) {
        peek(i, runnable, this.f12934m);
    }

    public void peek(int i, final Runnable runnable, int i2) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f12936o = 1;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i2);
    }

    public void hiden(Runnable runnable) {
        hiden(runnable, this.f12934m);
    }

    public void hiden(int i) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f12936o = 0;
            }
        }, this.f12934m);
    }

    public void hiden(final Runnable runnable, int i) {
        recover(getMeasuredHeight(), new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f12936o = 0;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i);
    }

    public void hiden(int i, final Runnable runnable, int i2) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f12936o = 0;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i2);
    }

    public void setSheetDirection(int i) {
        this.f12935n = i;
    }

    public void setDampingDown(float f) {
        this.f12939r = f;
    }

    public void setDampingUp(float f) {
        this.f12938q = f;
    }

    public void setParentDispatchTouchEvent(boolean z) {
        this.f12946y = z;
    }

    public boolean isAniming() {
        ObjectAnimator objectAnimator = this.f12926e;
        if (objectAnimator == null) {
            return false;
        }
        return objectAnimator.isRunning();
    }

    public int getShowState() {
        return this.f12936o;
    }

    public int getScrollState() {
        return this.f12937p;
    }

    public void setLockTop(boolean z, int i) {
        this.f12916D = z;
        this.f12917E = i;
    }

    public void setLockTopLimit(boolean z, int i) {
        this.f12916D = z;
        this.f12922a = i;
        if (i != 0) {
            post(new Runnable() {
                public void run() {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                    int unused = anycarEstimatePanelLayout.f12917E = anycarEstimatePanelLayout.f12940s - AnycarEstimatePanelLayout.this.f12922a;
                }
            });
        }
    }

    public void setNormalLockTopLimti(int i) {
        this.f12916D = true;
        this.f12922a = i;
        if (i != 0) {
            post(new Runnable() {
                public void run() {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                    int unused = anycarEstimatePanelLayout.f12917E = anycarEstimatePanelLayout.f12940s - AnycarEstimatePanelLayout.this.f12922a;
                    if (((float) AnycarEstimatePanelLayout.this.f12917E) < AnycarEstimatePanelLayout.this.f12944w) {
                        AnycarEstimatePanelLayout anycarEstimatePanelLayout2 = AnycarEstimatePanelLayout.this;
                        anycarEstimatePanelLayout2.f12922a = (int) (((float) anycarEstimatePanelLayout2.f12940s) - AnycarEstimatePanelLayout.this.f12944w);
                        AnycarEstimatePanelLayout anycarEstimatePanelLayout3 = AnycarEstimatePanelLayout.this;
                        int unused2 = anycarEstimatePanelLayout3.f12917E = (int) anycarEstimatePanelLayout3.f12944w;
                    }
                }
            });
        }
    }

    public int getLockTopLimit() {
        return this.f12922a;
    }

    public void setLockDispatchTouchEvent(boolean z) {
        this.f12920H = z;
    }

    public void setLockBottom(boolean z, int i) {
        this.f12918F = z;
        this.f12919G = i;
    }

    public void setNeedTouchUnderTargetView(boolean z) {
        this.f12947z = z;
    }

    public void setTouchParentViewOriginMeasureHeight(int i) {
        this.f12940s = i;
    }
}
