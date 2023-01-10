package com.google.p223ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.ap */
final /* synthetic */ class C20270ap implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f56452a;

    /* renamed from: b */
    private final CameraDevice f56453b;

    C20270ap(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f56452a = stateCallback;
        this.f56453b = cameraDevice;
    }

    public final void run() {
        this.f56452a.onDisconnected(this.f56453b);
    }
}
