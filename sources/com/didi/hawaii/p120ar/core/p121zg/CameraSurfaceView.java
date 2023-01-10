package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p120ar.utils.PermissionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.hawaii.ar.core.zg.CameraSurfaceView */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: b */
    private static int f25351b = 90;

    /* renamed from: a */
    private Camera f25352a = null;

    /* renamed from: c */
    private int f25353c = -1;

    /* renamed from: d */
    private int f25354d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicBoolean f25355e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AtomicBoolean f25356f = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f25357g = "CameraSurfaceView";

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public CameraSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        getHolder().setType(3);
        m20263a();
    }

    /* renamed from: a */
    private void m20263a() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
            for (int i = 0; i < numberOfCameras; i++) {
                cameraInfoArr[i] = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfoArr[i]);
            }
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                if (this.f25354d == -1 && cameraInfoArr[i2].facing == 0) {
                    this.f25354d = i2;
                } else if (this.f25353c == -1 && cameraInfoArr[i2].facing == 1) {
                    this.f25353c = i2;
                }
            }
        } catch (Throwable th) {
            String str = this.f25357g;
            DLog.m10773d(str, "initCameraInfo" + th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private Camera.Size m20261a(int i, List<Camera.Size> list) {
        int width = getWidth();
        int height = getHeight();
        if (i == 90 || i == 270) {
            int i2 = height;
            height = width;
            width = i2;
        }
        for (Camera.Size next : list) {
            if (next.width == width && next.height == height) {
                return next;
            }
        }
        float f = ((float) width) / ((float) height);
        float f2 = Float.MAX_VALUE;
        Camera.Size size = null;
        for (Camera.Size next2 : list) {
            float abs = Math.abs(f - (((float) next2.width) / ((float) next2.height)));
            if (abs < f2) {
                size = next2;
                f2 = abs;
            }
        }
        return size;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20265b() {
        Camera.Size a;
        AtomicBoolean atomicBoolean = this.f25356f;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            try {
                if (this.f25352a == null && this.f25354d != -1 && getHolder().getSurface() != null) {
                    Camera open = Camera.open(this.f25354d);
                    this.f25352a = open;
                    open.setDisplayOrientation(f25351b);
                    Camera.Parameters parameters = this.f25352a.getParameters();
                    List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                    if (!(supportedPreviewSizes == null || (a = m20261a(f25351b, supportedPreviewSizes)) == null)) {
                        parameters.setPreviewSize(a.width, a.height);
                    }
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.f25352a.setParameters(parameters);
                    this.f25352a.setPreviewDisplay(getHolder());
                    this.f25352a.startPreview();
                }
            } catch (Throwable th) {
                this.f25355e.set(false);
                String str = this.f25357g;
                DLog.m10773d(str, "openCamera2" + th.toString(), new Object[0]);
                th.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m20267c() {
        try {
            if (this.f25352a != null) {
                this.f25355e.set(false);
                this.f25352a.setPreviewCallback((Camera.PreviewCallback) null);
                this.f25352a.stopPreview();
                this.f25352a.release();
                this.f25352a = null;
            }
        } catch (Throwable th) {
            String str = this.f25357g;
            DLog.m10773d(str, "closeCamera" + th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if ((getContext() instanceof AppCompatActivity) && PermissionHelper.hasCameraPermission((AppCompatActivity) getContext())) {
            openCamera();
        }
    }

    public void openCamera() {
        try {
            if (this.f25352a == null && this.f25355e != null && !this.f25355e.get()) {
                this.f25355e.set(true);
                postDelayed(new Runnable() {
                    public void run() {
                        String a = CameraSurfaceView.this.f25357g;
                        DLog.m10773d(a, "openCameraThread  -->2 + isViewDestroy" + CameraSurfaceView.this.f25356f + "isCameraOpen" + CameraSurfaceView.this.f25355e, new Object[0]);
                        if (CameraSurfaceView.this.f25356f == null || !CameraSurfaceView.this.f25356f.get()) {
                            new Thread(new Runnable() {
                                public void run() {
                                    synchronized (CameraSurfaceView.class) {
                                        CameraSurfaceView.this.m20265b();
                                    }
                                }
                            }).start();
                        }
                    }
                }, 200);
            }
        } catch (Exception unused) {
            this.f25355e.set(false);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m20267c();
    }

    public void onDestroy() {
        DLog.m10773d(this.f25357g, "onDestroy  -->5", new Object[0]);
        this.f25356f.set(false);
        this.f25355e.set(false);
    }
}
