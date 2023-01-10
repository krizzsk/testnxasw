package com.google.p223ar.core;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;

/* renamed from: com.google.ar.core.ak */
/* compiled from: SharedCamera */
final class C20265ak extends CameraDevice.StateCallback {

    /* renamed from: a */
    private final /* synthetic */ Handler f56441a;

    /* renamed from: b */
    private final /* synthetic */ CameraDevice.StateCallback f56442b;

    /* renamed from: c */
    private final /* synthetic */ SharedCamera f56443c;

    C20265ak(SharedCamera sharedCamera, Handler handler, CameraDevice.StateCallback stateCallback) {
        this.f56443c = sharedCamera;
        this.f56441a = handler;
        this.f56442b = stateCallback;
    }

    public final void onClosed(CameraDevice cameraDevice) {
        this.f56441a.post(new C20268an(this.f56442b, cameraDevice));
        this.f56443c.onDeviceClosed(cameraDevice);
    }

    public final void onOpened(CameraDevice cameraDevice) {
        this.f56443c.sharedCameraInfo.mo164820a(cameraDevice);
        this.f56441a.post(new C20267am(this.f56442b, cameraDevice));
        this.f56443c.onDeviceOpened(cameraDevice);
        this.f56443c.sharedCameraInfo.mo164819a(this.f56443c.getGpuSurfaceTexture());
        this.f56443c.sharedCameraInfo.mo164821a(this.f56443c.getGpuSurface());
    }

    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f56441a.post(new C20270ap(this.f56442b, cameraDevice));
        this.f56443c.onDeviceDisconnected(cameraDevice);
    }

    public final void onError(CameraDevice cameraDevice, int i) {
        this.f56441a.post(new C20269ao(this.f56442b, cameraDevice, i));
        this.f56443c.close();
    }
}
