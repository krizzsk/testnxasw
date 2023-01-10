package com.didi.component.evaluate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.component.evaluate.util.ViewUtil;

public class EvaluateRootContainer extends LinearLayout {

    /* renamed from: a */
    private boolean f15149a;

    /* renamed from: b */
    private OnTouchWhenInterceptListener f15150b;

    /* renamed from: c */
    private int f15151c;

    public interface OnTouchWhenInterceptListener {
        void onTouchWhenIntercept();
    }

    public EvaluateRootContainer(Context context) {
        super(context);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EvaluateRootContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setOnTouchWhenInterceptListener(OnTouchWhenInterceptListener onTouchWhenInterceptListener) {
        this.f15150b = onTouchWhenInterceptListener;
    }

    public void setInterceptTouchEnable(boolean z) {
        this.f15149a = z;
    }

    public void setCanTouchView(int i) {
        this.f15151c = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f15149a) {
            return super.onTouchEvent(motionEvent);
        }
        OnTouchWhenInterceptListener onTouchWhenInterceptListener = this.f15150b;
        if (onTouchWhenInterceptListener == null) {
            return true;
        }
        onTouchWhenInterceptListener.onTouchWhenIntercept();
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f15149a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        View findViewById = findViewById(this.f15151c);
        if (findViewById == null || ViewUtil.isTouchPointInView(findViewById, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
