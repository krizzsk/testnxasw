package com.didichuxing.security.cardverify.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MoneyEditTextContainer extends LinearLayout {

    /* renamed from: a */
    private OnTouchEventListener f51515a;

    public interface OnTouchEventListener {
        void onDown();
    }

    public MoneyEditTextContainer(Context context) {
        super(context);
    }

    public MoneyEditTextContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MoneyEditTextContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MoneyEditTextContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f51515a != null && motionEvent.getAction() == 0) {
            this.f51515a.onDown();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setTouchEventListener(OnTouchEventListener onTouchEventListener) {
        this.f51515a = onTouchEventListener;
    }
}
