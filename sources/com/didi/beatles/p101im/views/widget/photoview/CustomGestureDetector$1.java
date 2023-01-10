package com.didi.beatles.p101im.views.widget.photoview;

import android.view.ScaleGestureDetector;

/* renamed from: com.didi.beatles.im.views.widget.photoview.CustomGestureDetector$1 */
class CustomGestureDetector$1 implements ScaleGestureDetector.OnScaleGestureListener {
    final /* synthetic */ C4960b this$0;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    CustomGestureDetector$1(C4960b bVar) {
        this.this$0 = bVar;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.this$0.f12499k.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }
}
