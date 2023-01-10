package com.didi.component.common.widget.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.didi.component.common.widget.divider.IMovePublisher;
import com.didi.passenger.C11267R;
import java.util.LinkedHashMap;
import java.util.Map;

public class DividerLinearLayout extends LinearLayout {

    /* renamed from: a */
    private static final boolean f13876a = false;

    /* renamed from: b */
    private Paint f13877b;

    /* renamed from: c */
    private Map<View, View> f13878c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<View, View> f13879d;

    /* renamed from: e */
    private int f13880e;

    /* renamed from: f */
    private int f13881f;

    /* renamed from: g */
    private int f13882g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f13883h;

    /* renamed from: i */
    private int f13884i;

    /* renamed from: j */
    private boolean f13885j;

    /* renamed from: k */
    private Drawable f13886k;

    /* renamed from: l */
    private int f13887l;

    /* renamed from: m */
    private boolean f13888m;

    /* renamed from: n */
    private IMovePublisher f13889n;

    /* renamed from: o */
    private OnSizeChangeListener f13890o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ViewGroup.OnHierarchyChangeListener f13891p;

    /* renamed from: q */
    private ViewGroup.OnHierarchyChangeListener f13892q;

    public interface OnSizeChangeListener {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    /* renamed from: b */
    private void m11509b(Canvas canvas) {
    }

    public DividerLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DividerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DividerLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13878c = new LinkedHashMap();
        this.f13879d = new LinkedHashMap();
        this.f13883h = -1;
        this.f13884i = -1;
        this.f13885j = true;
        this.f13886k = null;
        this.f13888m = false;
        this.f13892q = new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewAdded(View view, View view2) {
                ViewGroup.OnHierarchyChangeListener a = DividerLinearLayout.this.f13891p;
                if (a != null) {
                    a.onChildViewAdded(view, view2);
                }
                DividerLinearLayout.this.m11506a(view2);
            }

            public void onChildViewRemoved(View view, View view2) {
                ViewGroup.OnHierarchyChangeListener a = DividerLinearLayout.this.f13891p;
                if (a != null) {
                    a.onChildViewRemoved(view, view2);
                }
                DividerLinearLayout.this.m11510b(view2);
            }
        };
        m11504a(context, attributeSet);
    }

    /* renamed from: a */
    private void m11504a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.DividerLinearLayout);
            this.f13880e = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
            this.f13881f = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
            this.f13882g = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f13883h = obtainStyledAttributes.getColor(4, -1);
            this.f13884i = obtainStyledAttributes.getColor(3, -1);
            this.f13886k = obtainStyledAttributes.getDrawable(0);
            this.f13885j = obtainStyledAttributes.getBoolean(2, true);
            this.f13887l = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f13889n = obtainStyledAttributes.getBoolean(8, false) ? new MovePublisher(context) : null;
            obtainStyledAttributes.recycle();
        }
    }

    public void setOnMoveListener(IMovePublisher.OnMoveListener onMoveListener) {
        IMovePublisher iMovePublisher = this.f13889n;
        if (iMovePublisher != null) {
            iMovePublisher.setOnMoveListener(onMoveListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        super.setOnHierarchyChangeListener(this.f13892q);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f13891p = onHierarchyChangeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11506a(View view) {
        if (getChildCount() != 1 && !this.f13878c.containsValue(view)) {
            final DividerView dividerView = new DividerView(getContext());
            dividerView.setBackgroundColor(this.f13884i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f13882g);
            layoutParams.leftMargin = this.f13880e;
            layoutParams.rightMargin = this.f13881f;
            int indexOfChild = indexOfChild(view);
            if (indexOfChild == 0) {
                view = getChildAt(1);
            }
            this.f13878c.put(view, dividerView);
            this.f13879d.put(dividerView, view);
            if (indexOfChild == 0) {
                indexOfChild++;
            }
            super.addView(dividerView, indexOfChild, layoutParams);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    dividerView.invalidate();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11510b(View view) {
        View remove = this.f13878c.remove(view);
        if (remove != null) {
            this.f13879d.remove(remove);
            super.removeView(remove);
        }
    }

    public View getDivider(View view) {
        return this.f13878c.get(view);
    }

    public int getHeightWithDivider(View view) {
        View view2 = this.f13878c.get(view);
        return view.getHeight() + (view2 != null ? view2.getHeight() : 0);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f13888m = ((motionEvent.getX() > 0.0f ? 1 : (motionEvent.getX() == 0.0f ? 0 : -1)) >= 0 && (motionEvent.getX() > ((float) getWidth()) ? 1 : (motionEvent.getX() == ((float) getWidth()) ? 0 : -1)) < 0) && ((motionEvent.getY() > 0.0f ? 1 : (motionEvent.getY() == 0.0f ? 0 : -1)) >= 0 && (motionEvent.getY() > ((float) (getHeight() - getAdjustHeight())) ? 1 : (motionEvent.getY() == ((float) (getHeight() - getAdjustHeight())) ? 0 : -1)) < 0);
        }
        if (this.f13888m) {
            return false;
        }
        IMovePublisher iMovePublisher = this.f13889n;
        if (iMovePublisher == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        boolean dispatchTouchEvent = iMovePublisher.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent) {
            return dispatchTouchEvent;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IMovePublisher iMovePublisher = this.f13889n;
        if (iMovePublisher == null) {
            return true;
        }
        return iMovePublisher.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IMovePublisher iMovePublisher = this.f13889n;
        if (iMovePublisher == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return iMovePublisher.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m11505a(canvas);
        super.dispatchDraw(canvas);
        m11509b(canvas);
    }

    /* renamed from: a */
    private void m11505a(Canvas canvas) {
        if (this.f13886k != null) {
            int adjustHeight = getAdjustHeight();
            int save = canvas.save();
            if (this.f13885j) {
                canvas.translate((float) this.f13887l, (float) ((getHeight() - adjustHeight) + this.f13887l));
            } else {
                int i = this.f13887l;
                canvas.translate((float) i, (float) i);
            }
            int width = getWidth();
            int i2 = this.f13887l;
            int i3 = adjustHeight - (i2 * 2);
            this.f13886k.setBounds(0, 0, width - (i2 * 2), i3);
            this.f13886k.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public int getAdjustHeight() {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                paddingTop = (int) (((float) paddingTop) + (((float) childAt.getHeight()) * childAt.getScaleY()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null) {
                    paddingTop = paddingTop + layoutParams.topMargin + layoutParams.bottomMargin;
                }
            }
        }
        return paddingTop;
    }

    private class DividerView extends View {
        private DividerView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            View view = (View) DividerLinearLayout.this.f13879d.get(this);
            if (view != null && view.getVisibility() == 0 && ((float) view.getHeight()) * getScaleY() > 0.0f && ((float) view.getWidth()) * view.getScaleX() > 0.0f) {
                canvas.drawColor(DividerLinearLayout.this.f13883h);
            }
        }
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.f13890o = onSizeChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        OnSizeChangeListener onSizeChangeListener = this.f13890o;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onSizeChanged(i, i2, i3, i4);
        }
    }
}
