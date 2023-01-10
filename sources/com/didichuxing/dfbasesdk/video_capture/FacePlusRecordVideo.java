package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;

public class FacePlusRecordVideo implements IRecordVideo {

    /* renamed from: a */
    private final DiFaceVideoCaptureManager f49455a;

    /* renamed from: b */
    private Context f49456b;

    /* renamed from: c */
    private ICameraInterface f49457c;

    public FacePlusRecordVideo(Context context, ICameraInterface iCameraInterface, boolean z, GLSurfaceView gLSurfaceView, float f, int i) {
        this.f49456b = context.getApplicationContext();
        this.f49457c = iCameraInterface;
        this.f49455a = new DiFaceVideoCaptureManager(iCameraInterface.getPreviewWidth(), iCameraInterface.getPreviewHeight(), z, gLSurfaceView, f, i);
    }

    public void start(int i) {
        stop();
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setCameraWidthAndHeight(this.f49457c.getPreviewWidth(), this.f49457c.getPreviewHeight());
            this.f49455a.startRecording(this.f49456b, i);
        }
    }

    public void start(int i, String str) {
        stop();
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setCameraWidthAndHeight(this.f49457c.getPreviewWidth(), this.f49457c.getPreviewHeight());
            this.f49455a.startRecording(this.f49456b, i, str);
        }
    }

    public void stop() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null && diFaceVideoCaptureManager.isRecording()) {
            this.f49455a.stopRecording();
        }
    }

    public String getVideoPath() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        return diFaceVideoCaptureManager != null ? diFaceVideoCaptureManager.getVideoPath() : "";
    }

    public void setErrorListener(IErrorListener iErrorListener) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setListener(iErrorListener);
        }
    }

    public void frameAvailable(float[] fArr) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.frameAvailable(fArr);
        }
    }

    public boolean recording() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f49455a;
        if (diFaceVideoCaptureManager != null) {
            return diFaceVideoCaptureManager.isRecording();
        }
        return false;
    }
}
