package com.google.p223ar.core;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Handler;
import com.google.p223ar.core.SharedCamera;

/* renamed from: com.google.ar.core.ar */
/* compiled from: SharedCamera */
final class C20272ar extends CameraCaptureSession.StateCallback {

    /* renamed from: a */
    private final /* synthetic */ Handler f56456a;

    /* renamed from: b */
    private final /* synthetic */ CameraCaptureSession.StateCallback f56457b;

    /* renamed from: c */
    private final /* synthetic */ SharedCamera f56458c;

    C20272ar(SharedCamera sharedCamera, Handler handler, CameraCaptureSession.StateCallback stateCallback) {
        this.f56458c = sharedCamera;
        this.f56456a = handler;
        this.f56457b = stateCallback;
    }

    public final void onClosed(CameraCaptureSession cameraCaptureSession) {
        this.f56456a.post(new C20271aq(this.f56457b, cameraCaptureSession));
        this.f56458c.onCaptureSessionClosed(cameraCaptureSession);
    }

    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        SharedCamera.C20253a unused = this.f56458c.sharedCameraInfo;
        this.f56456a.post(new C20274at(this.f56457b, cameraCaptureSession));
        this.f56458c.onCaptureSessionConfigured(cameraCaptureSession);
        if (this.f56458c.sharedCameraInfo.mo164818a() != null) {
            this.f56458c.setDummyListenerToAvoidImageBufferStarvation();
        }
    }

    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.f56456a.post(new C20273as(this.f56457b, cameraCaptureSession));
        this.f56458c.onCaptureSessionConfigureFailed(cameraCaptureSession);
    }

    public final void onReady(CameraCaptureSession cameraCaptureSession) {
        this.f56456a.post(new C20276av(this.f56457b, cameraCaptureSession));
        this.f56458c.onCaptureSessionReady(cameraCaptureSession);
    }

    public final void onActive(CameraCaptureSession cameraCaptureSession) {
        this.f56456a.post(new C20275au(this.f56457b, cameraCaptureSession));
        this.f56458c.onCaptureSessionActive(cameraCaptureSession);
    }
}
