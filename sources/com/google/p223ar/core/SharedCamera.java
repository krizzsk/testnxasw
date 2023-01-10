package com.google.p223ar.core;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.ar.core.SharedCamera */
public class SharedCamera {
    private static final String TAG = "ArSdk-SharedCamera";
    private boolean cameraSharedWithAr = false;
    private final Session session;
    private Handler sharedCameraHandler;
    /* access modifiers changed from: private */
    public final C20253a sharedCameraInfo = new C20253a((byte) 0);

    SharedCamera(Session session2) {
        HandlerThread handlerThread = new HandlerThread("SharedCameraHandlerThread");
        handlerThread.start();
        this.sharedCameraHandler = new Handler(handlerThread.getLooper());
        this.session = session2;
    }

    private native void nativeSharedCameraCaptureSessionActive(long j, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionClosed(long j, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionConfigureFailed(long j, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionConfigured(long j, CameraCaptureSession cameraCaptureSession);

    private native void nativeSharedCameraCaptureSessionReady(long j, CameraCaptureSession cameraCaptureSession);

    private native ImageReader nativeSharedCameraGetImageReader(long j, CameraDevice cameraDevice);

    private native ImageReader nativeSharedCameraGetImageReaderMotionTracking(long j, CameraDevice cameraDevice);

    private native Surface nativeSharedCameraGetSurface(long j, CameraDevice cameraDevice);

    private native SurfaceTexture nativeSharedCameraGetSurfaceTexture(long j, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnClosed(long j, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnDisconnected(long j, CameraDevice cameraDevice);

    private native void nativeSharedCameraOnOpened(long j, CameraDevice cameraDevice);

    private native void nativeSharedCameraSetAppSurfaces(long j, String str, List<Surface> list);

    private native void nativeSharedCameraSetCaptureCallback(long j, CameraCaptureSession.CaptureCallback captureCallback, Handler handler);

    /* renamed from: com.google.ar.core.SharedCamera$a */
    static class C20253a {

        /* renamed from: a */
        private CameraDevice f56431a;

        /* renamed from: b */
        private final Map<String, List<Surface>> f56432b;

        /* renamed from: c */
        private SurfaceTexture f56433c;

        /* renamed from: d */
        private Surface f56434d;

        private C20253a() {
            this.f56431a = null;
            this.f56432b = new HashMap();
            this.f56433c = null;
            this.f56434d = null;
        }

        /* renamed from: a */
        public final CameraDevice mo164818a() {
            return this.f56431a;
        }

        /* renamed from: a */
        public final void mo164820a(CameraDevice cameraDevice) {
            this.f56431a = cameraDevice;
        }

        /* renamed from: a */
        public final void mo164822a(String str, List<Surface> list) {
            this.f56432b.put(str, list);
        }

        /* renamed from: b */
        public final SurfaceTexture mo164823b() {
            return this.f56433c;
        }

        /* renamed from: a */
        public final void mo164819a(SurfaceTexture surfaceTexture) {
            this.f56433c = surfaceTexture;
        }

        /* renamed from: c */
        public final Surface mo164824c() {
            return this.f56434d;
        }

        /* renamed from: a */
        public final void mo164821a(Surface surface) {
            this.f56434d = surface;
        }

        /* synthetic */ C20253a(byte b) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void close() {
        this.sharedCameraHandler.removeCallbacksAndMessages((Object) null);
        this.sharedCameraHandler.getLooper().quit();
        this.sharedCameraHandler = null;
    }

    public void setAppSurfaces(String str, List<Surface> list) {
        this.sharedCameraInfo.mo164822a(str, list);
        nativeSharedCameraSetAppSurfaces(this.session.nativeWrapperHandle, str, list);
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.sharedCameraInfo.mo164823b();
    }

    public List<Surface> getArCoreSurfaces() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.sharedCameraInfo.mo164824c());
        ImageReader cpuImageReaderMotionTracking = getCpuImageReaderMotionTracking();
        if (cpuImageReaderMotionTracking != null) {
            arrayList.add(cpuImageReaderMotionTracking.getSurface());
        }
        arrayList.add(getCpuImageReader().getSurface());
        return arrayList;
    }

    public CameraDevice.StateCallback createARDeviceStateCallback(CameraDevice.StateCallback stateCallback, Handler handler) {
        return new C20265ak(this, handler, stateCallback);
    }

    public CameraCaptureSession.StateCallback createARSessionStateCallback(CameraCaptureSession.StateCallback stateCallback, Handler handler) {
        return new C20272ar(this, handler, stateCallback);
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        if (this.sharedCameraInfo.mo164818a() != null) {
            setDummyListenerToAvoidImageBufferStarvation();
        }
    }

    private void setDummyOnImageAvailableListener(ImageReader imageReader) {
        if (imageReader != null) {
            imageReader.setOnImageAvailableListener(C20266al.f56444a, this.sharedCameraHandler);
        }
    }

    /* access modifiers changed from: private */
    public void setDummyListenerToAvoidImageBufferStarvation() {
        setDummyOnImageAvailableListener(getCpuImageReader());
        setDummyOnImageAvailableListener(getCpuImageReaderMotionTracking());
    }

    /* access modifiers changed from: private */
    public void onDeviceOpened(CameraDevice cameraDevice) {
        this.sharedCameraInfo.mo164820a(cameraDevice);
        this.cameraSharedWithAr = true;
        nativeSharedCameraOnOpened(this.session.nativeWrapperHandle, cameraDevice);
    }

    /* access modifiers changed from: private */
    public void onDeviceClosed(CameraDevice cameraDevice) {
        nativeSharedCameraOnClosed(this.session.nativeWrapperHandle, cameraDevice);
        this.cameraSharedWithAr = false;
    }

    /* access modifiers changed from: private */
    public void onDeviceDisconnected(CameraDevice cameraDevice) {
        nativeSharedCameraOnDisconnected(this.session.nativeWrapperHandle, cameraDevice);
        this.cameraSharedWithAr = false;
        this.sharedCameraInfo.mo164820a((CameraDevice) null);
    }

    /* access modifiers changed from: private */
    public void onCaptureSessionActive(CameraCaptureSession cameraCaptureSession) {
        nativeSharedCameraCaptureSessionActive(this.session.nativeWrapperHandle, cameraCaptureSession);
    }

    /* access modifiers changed from: private */
    public void onCaptureSessionClosed(CameraCaptureSession cameraCaptureSession) {
        nativeSharedCameraCaptureSessionClosed(this.session.nativeWrapperHandle, cameraCaptureSession);
    }

    /* access modifiers changed from: private */
    public void onCaptureSessionConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        nativeSharedCameraCaptureSessionConfigureFailed(this.session.nativeWrapperHandle, cameraCaptureSession);
    }

    /* access modifiers changed from: private */
    public void onCaptureSessionConfigured(CameraCaptureSession cameraCaptureSession) {
        nativeSharedCameraCaptureSessionConfigured(this.session.nativeWrapperHandle, cameraCaptureSession);
    }

    /* access modifiers changed from: private */
    public void onCaptureSessionReady(CameraCaptureSession cameraCaptureSession) {
        nativeSharedCameraCaptureSessionReady(this.session.nativeWrapperHandle, cameraCaptureSession);
    }

    private ImageReader getCpuImageReader() {
        return nativeSharedCameraGetImageReader(this.session.nativeWrapperHandle, this.sharedCameraInfo.mo164818a());
    }

    private ImageReader getCpuImageReaderMotionTracking() {
        return nativeSharedCameraGetImageReaderMotionTracking(this.session.nativeWrapperHandle, this.sharedCameraInfo.mo164818a());
    }

    /* access modifiers changed from: private */
    public SurfaceTexture getGpuSurfaceTexture() {
        return nativeSharedCameraGetSurfaceTexture(this.session.nativeWrapperHandle, this.sharedCameraInfo.mo164818a());
    }

    /* access modifiers changed from: private */
    public Surface getGpuSurface() {
        return nativeSharedCameraGetSurface(this.session.nativeWrapperHandle, this.sharedCameraInfo.mo164818a());
    }

    public void setCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        nativeSharedCameraSetCaptureCallback(this.session.nativeWrapperHandle, captureCallback, handler);
    }

    static final /* synthetic */ void lambda$setDummyOnImageAvailableListener$0$SharedCamera(ImageReader imageReader) {
        Image acquireLatestImage = imageReader.acquireLatestImage();
        if (acquireLatestImage != null) {
            acquireLatestImage.close();
        }
    }
}
