package com.didi.nova.assembly.components.bigimage.photoview;

import android.view.ScaleGestureDetector;

class CustomGestureDetector$1 implements ScaleGestureDetector.OnScaleGestureListener {
    final /* synthetic */ C11080b this$0;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    CustomGestureDetector$1(C11080b bVar) {
        this.this$0 = bVar;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.this$0.f31605k.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }
}
