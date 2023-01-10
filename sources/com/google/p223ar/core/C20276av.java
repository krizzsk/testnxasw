package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.av */
final /* synthetic */ class C20276av implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f56465a;

    /* renamed from: b */
    private final CameraCaptureSession f56466b;

    C20276av(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f56465a = stateCallback;
        this.f56466b = cameraCaptureSession;
    }

    public final void run() {
        this.f56465a.onReady(this.f56466b);
    }
}
