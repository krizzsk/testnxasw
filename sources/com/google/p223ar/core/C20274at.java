package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.at */
final /* synthetic */ class C20274at implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f56461a;

    /* renamed from: b */
    private final CameraCaptureSession f56462b;

    C20274at(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f56461a = stateCallback;
        this.f56462b = cameraCaptureSession;
    }

    public final void run() {
        this.f56461a.onConfigured(this.f56462b);
    }
}
