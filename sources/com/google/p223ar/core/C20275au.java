package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.au */
final /* synthetic */ class C20275au implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f56463a;

    /* renamed from: b */
    private final CameraCaptureSession f56464b;

    C20275au(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f56463a = stateCallback;
        this.f56464b = cameraCaptureSession;
    }

    public final void run() {
        this.f56463a.onActive(this.f56464b);
    }
}
