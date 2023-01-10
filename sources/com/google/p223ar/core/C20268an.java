package com.google.p223ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.an */
final /* synthetic */ class C20268an implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f56447a;

    /* renamed from: b */
    private final CameraDevice f56448b;

    C20268an(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f56447a = stateCallback;
        this.f56448b = cameraDevice;
    }

    public final void run() {
        this.f56447a.onClosed(this.f56448b);
    }
}
