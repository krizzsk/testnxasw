package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.aq */
final /* synthetic */ class C20271aq implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f56454a;

    /* renamed from: b */
    private final CameraCaptureSession f56455b;

    C20271aq(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f56454a = stateCallback;
        this.f56455b = cameraCaptureSession;
    }

    public final void run() {
        this.f56454a.onClosed(this.f56455b);
    }
}
