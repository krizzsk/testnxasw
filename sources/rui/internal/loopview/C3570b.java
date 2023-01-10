package rui.internal.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: rui.internal.loopview.b */
/* compiled from: LoopViewGestureListener */
final class C3570b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final LoopView f8646a;

    C3570b(LoopView loopView) {
        this.f8646a = loopView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f8646a.scrollBy(f2);
        return true;
    }
}
