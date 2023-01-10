package com.google.p223ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.ao */
final /* synthetic */ class C20269ao implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f56449a;

    /* renamed from: b */
    private final CameraDevice f56450b;

    /* renamed from: c */
    private final int f56451c;

    C20269ao(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice, int i) {
        this.f56449a = stateCallback;
        this.f56450b = cameraDevice;
        this.f56451c = i;
    }

    public final void run() {
        this.f56449a.onError(this.f56450b, this.f56451c);
    }
}
