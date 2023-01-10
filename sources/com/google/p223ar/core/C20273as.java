package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.as */
final /* synthetic */ class C20273as implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f56459a;

    /* renamed from: b */
    private final CameraCaptureSession f56460b;

    C20273as(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f56459a = stateCallback;
        this.f56460b = cameraCaptureSession;
    }

    public final void run() {
        this.f56459a.onConfigureFailed(this.f56460b);
    }
}
