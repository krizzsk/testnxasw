package com.didi.zxing.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.C15738Util;
import com.didi.zxing.barcodescanner.Size;
import com.didi.zxing.barcodescanner.camera.CameraManager;
import com.taxis99.R;

public class CameraInstance {

    /* renamed from: a */
    private static final String f48000a = "CameraInstance";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C15763a f48001b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraSurface f48002c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraManager f48003d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f48004e;

    /* renamed from: f */
    private DisplayConfiguration f48005f;

    /* renamed from: g */
    private boolean f48006g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f48007h = true;

    /* renamed from: i */
    private CameraSettings f48008i = new CameraSettings();

    /* renamed from: j */
    private Runnable f48009j = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f48000a, "Opening camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$4", 212);
                CameraInstance.this.f48003d.open();
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m36052a(exc);
                SystemUtils.log(6, CameraInstance.f48000a, "Failed to open camera", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$4", 216);
            }
        }
    };

    /* renamed from: k */
    private Runnable f48010k = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f48000a, "Configuring camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$5", 225);
                CameraInstance.this.f48003d.configure();
                if (CameraInstance.this.f48004e != null) {
                    CameraInstance.this.f48004e.obtainMessage(R.id.zxing_prewiew_size_ready, CameraInstance.this.m36049a()).sendToTarget();
                }
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m36052a(exc);
                SystemUtils.log(6, CameraInstance.f48000a, "Failed to configure camera", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$5", 232);
            }
        }
    };

    /* renamed from: l */
    private Runnable f48011l = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f48000a, "Starting preview", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$6", 241);
                CameraInstance.this.f48003d.setPreviewDisplay(CameraInstance.this.f48002c);
                CameraInstance.this.f48003d.startPreview();
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m36052a(exc);
                exc.printStackTrace();
                SystemUtils.log(6, CameraInstance.f48000a, "Failed to start preview", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$6", 247);
            }
        }
    };

    /* renamed from: m */
    private Runnable f48012m = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f48000a, "Closing camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$7", 256);
                CameraInstance.this.f48003d.stopPreview();
                CameraInstance.this.f48003d.close();
            } catch (Exception e) {
                SystemUtils.log(6, CameraInstance.f48000a, "Failed to close camera", e, "com.didi.zxing.barcodescanner.camera.CameraInstance$7", 260);
            }
            boolean unused = CameraInstance.this.f48007h = true;
            if (CameraInstance.this.f48004e != null) {
                CameraInstance.this.f48004e.sendEmptyMessage(R.id.zxing_camera_closed);
            }
            CameraInstance.this.f48001b.mo120370b();
        }
    };

    /* renamed from: n */
    private Runnable f48013n = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f48000a, "Closing camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$8", 275);
                CameraInstance.this.f48003d.stopPreview();
            } catch (Exception e) {
                SystemUtils.log(6, CameraInstance.f48000a, "Failed to close camera", e, "com.didi.zxing.barcodescanner.camera.CameraInstance$8", 278);
            }
        }
    };

    public CameraInstance(Context context) {
        C15738Util.validateMainThread();
        this.f48001b = C15763a.m36067a();
        CameraManager cameraManager = new CameraManager(context);
        this.f48003d = cameraManager;
        cameraManager.setCameraSettings(this.f48008i);
    }

    public CameraInstance(CameraManager cameraManager) {
        C15738Util.validateMainThread();
        this.f48003d = cameraManager;
    }

    public void setDisplayConfiguration(DisplayConfiguration displayConfiguration) {
        this.f48005f = displayConfiguration;
        this.f48003d.setDisplayConfiguration(displayConfiguration);
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.f48005f;
    }

    public void setReadyHandler(Handler handler) {
        this.f48004e = handler;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        setSurface(new CameraSurface(surfaceHolder));
    }

    public void setSurface(CameraSurface cameraSurface) {
        this.f48002c = cameraSurface;
    }

    public CameraSettings getCameraSettings() {
        return this.f48008i;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        if (!this.f48006g) {
            this.f48008i = cameraSettings;
            this.f48003d.setCameraSettings(cameraSettings);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Size m36049a() {
        return this.f48003d.getPreviewSize();
    }

    public int getCameraRotation() {
        return this.f48003d.getCameraRotation();
    }

    public void open() {
        C15738Util.validateMainThread();
        this.f48006g = true;
        this.f48007h = false;
        this.f48001b.mo120371b(this.f48009j);
    }

    public void configureCamera() {
        C15738Util.validateMainThread();
        m36055b();
        this.f48001b.mo120368a(this.f48010k);
    }

    public void startPreview() {
        C15738Util.validateMainThread();
        m36055b();
        this.f48001b.mo120368a(this.f48011l);
    }

    public void setTorchListener(CameraManager.TorchListener torchListener) {
        this.f48003d.setTorchListener(torchListener);
    }

    public void setTorch(final boolean z) {
        C15738Util.validateMainThread();
        if (this.f48006g) {
            this.f48001b.mo120368a(new Runnable() {
                public void run() {
                    CameraInstance.this.f48003d.setTorch(z);
                }
            });
        }
    }

    public void close() {
        C15738Util.validateMainThread();
        if (this.f48006g) {
            this.f48001b.mo120368a(this.f48012m);
        } else {
            this.f48007h = true;
        }
        this.f48006g = false;
    }

    public void stopPreview() {
        C15738Util.validateMainThread();
        if (this.f48006g) {
            this.f48001b.mo120368a(this.f48013n);
        } else {
            this.f48007h = true;
        }
    }

    public boolean isOpen() {
        return this.f48006g;
    }

    public boolean isCameraClosed() {
        return this.f48007h;
    }

    public void requestPreview(final PreviewCallback previewCallback) {
        m36055b();
        this.f48001b.mo120368a(new Runnable() {
            public void run() {
                CameraInstance.this.f48003d.requestPreviewFrame(previewCallback);
            }
        });
    }

    public void removePreviewCallBack() {
        this.f48001b.mo120368a(new Runnable() {
            public void run() {
                CameraInstance.this.f48003d.removePreviewCallBack();
            }
        });
    }

    /* renamed from: b */
    private void m36055b() {
        if (!this.f48006g) {
            SystemUtils.log(6, f48000a, "camera not open", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance", 203);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36052a(Exception exc) {
        Handler handler = this.f48004e;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public CameraManager getCameraManager() {
        return this.f48003d;
    }

    /* access modifiers changed from: protected */
    public C15763a getCameraThread() {
        return this.f48001b;
    }

    /* access modifiers changed from: protected */
    public CameraSurface getSurface() {
        return this.f48002c;
    }
}
