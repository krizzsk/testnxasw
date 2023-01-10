package com.didi.dimina.container.p065ui.wheelview.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.didi.dimina.container.p065ui.wheelview.view.WheelView;

/* renamed from: com.didi.dimina.container.ui.wheelview.listener.LoopViewGestureListener */
public final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    private final WheelView f19743a;

    public LoopViewGestureListener(WheelView wheelView) {
        this.f19743a = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f19743a.scrollBy(f2);
        return true;
    }
}
