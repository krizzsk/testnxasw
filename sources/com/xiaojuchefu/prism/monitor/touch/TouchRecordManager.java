package com.xiaojuchefu.prism.monitor.touch;

import android.view.MotionEvent;

public class TouchRecordManager {

    /* renamed from: a */
    private static TouchRecordManager f58897a;

    /* renamed from: b */
    private TouchRecord f58898b;

    public static TouchRecordManager getInstance() {
        TouchRecordManager touchRecordManager;
        synchronized (TouchRecordManager.class) {
            if (f58897a == null) {
                f58897a = new TouchRecordManager();
            }
            touchRecordManager = f58897a;
        }
        return touchRecordManager;
    }

    public void touchEvent(MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            TouchRecord touchRecord = new TouchRecord();
            this.f58898b = touchRecord;
            touchRecord.onActionDown(motionEvent);
            return;
        }
        TouchRecord touchRecord2 = this.f58898b;
        if (touchRecord2 != null && touchRecord2.mPointerId == pointerId) {
            if (actionMasked == 2) {
                this.f58898b.onActionMove(motionEvent);
            } else if (actionMasked == 1) {
                this.f58898b.onActionUp(motionEvent);
            } else if (actionMasked == 3) {
                this.f58898b = null;
            }
        }
    }

    public TouchRecord getTouchRecord() {
        return this.f58898b;
    }
}
