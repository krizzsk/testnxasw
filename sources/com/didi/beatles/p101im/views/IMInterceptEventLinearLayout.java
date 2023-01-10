package com.didi.beatles.p101im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout */
public class IMInterceptEventLinearLayout extends LinearLayout {

    /* renamed from: b */
    private static final int f11721b = 8;

    /* renamed from: f */
    private static final int f11722f = 90;

    /* renamed from: g */
    private static final int f11723g = 120;

    /* renamed from: a */
    private float f11724a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SlideListener f11725c;

    /* renamed from: d */
    private GestureDetector f11726d;

    /* renamed from: e */
    private Context f11727e;

    /* renamed from: h */
    private InterceptCallback f11728h;

    /* renamed from: i */
    private long f11729i;

    /* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout$InterceptCallback */
    public interface InterceptCallback {
        boolean shouldIntercept();
    }

    /* renamed from: com.didi.beatles.im.views.IMInterceptEventLinearLayout$SlideListener */
    public interface SlideListener {
        void onSlideDown();

        void onSlideUp();
    }

    public IMInterceptEventLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMInterceptEventLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMInterceptEventLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11727e = context;
        m10075a();
    }

    public void setSlideListener(SlideListener slideListener) {
        this.f11725c = slideListener;
    }

    /* renamed from: a */
    private void m10075a() {
        this.f11726d = new GestureDetector(this.f11727e, new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getY() - motionEvent2.getY() <= 90.0f || Math.abs(f2) <= 120.0f || IMInterceptEventLinearLayout.this.f11725c == null) {
                    return true;
                }
                IMInterceptEventLinearLayout.this.f11725c.onSlideUp();
                return true;
            }
        });
    }

    public void registerInterceptListener(InterceptCallback interceptCallback) {
        this.f11728h = interceptCallback;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11724a = motionEvent.getY();
            this.f11726d.onTouchEvent(motionEvent);
        } else if (action == 2 && motionEvent.getDownTime() != this.f11729i) {
            InterceptCallback interceptCallback = this.f11728h;
            if (interceptCallback != null && !interceptCallback.shouldIntercept()) {
                this.f11729i = motionEvent.getDownTime();
            } else if (this.f11724a - motionEvent.getY() > 8.0f) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11726d.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
