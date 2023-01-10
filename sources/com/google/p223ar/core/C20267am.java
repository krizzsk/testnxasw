package com.google.p223ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.am */
final /* synthetic */ class C20267am implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f56445a;

    /* renamed from: b */
    private final CameraDevice f56446b;

    C20267am(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f56445a = stateCallback;
        this.f56446b = cameraDevice;
    }

    public final void run() {
        this.f56445a.onOpened(this.f56446b);
    }
}
