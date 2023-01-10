package com.didichuxing.gbankcard.ocr.utils;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class ICamera implements Camera.AutoFocusCallback, Camera.ErrorCallback {

    /* renamed from: i */
    private static final int f50280i = 3;

    /* renamed from: a */
    private volatile boolean f50281a = false;

    /* renamed from: b */
    private Handler f50282b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private WeakReference<ICamera> f50283c;
    public int cameraHeight;
    public int cameraId;
    public int cameraWidth;

    /* renamed from: d */
    private final int f50284d = ResUtils.getScreenWidth();

    /* renamed from: e */
    private final int f50285e = ResUtils.getScreenHeight();

    /* renamed from: f */
    private long f50286f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f50287g;

    /* renamed from: h */
    private int f50288h;
    public boolean hasFocus;

    /* renamed from: j */
    private final Runnable f50289j = new Runnable() {
        public void run() {
            LogUtils.m37051d("reset focusing runnable run...");
            boolean unused = ICamera.this.f50287g = false;
            ICamera.this.m37615c();
        }
    };
    public Camera mCamera;

    public ICamera() {
        LogUtils.m37051d("screen W===" + this.f50284d + ", H=" + this.f50285e);
    }

    public synchronized Camera openCamera(int i) {
        List<String> supportedFocusModes;
        if (this.f50281a) {
            return this.mCamera;
        }
        this.f50283c = new WeakReference<>(this);
        try {
            this.cameraId = i;
            this.mCamera = Camera.open(i);
            this.f50281a = true;
            this.mCamera.setErrorCallback(this);
            Camera.Parameters parameters = this.mCamera.getParameters();
            Camera.Size a = m37609a(parameters, this.f50284d, this.f50285e);
            this.cameraWidth = a.width;
            int i2 = a.height;
            this.cameraHeight = i2;
            parameters.setPreviewSize(this.cameraWidth, i2);
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.mCamera.setParameters(parameters);
            return this.mCamera;
        } catch (Exception unused) {
            return null;
        }
    }

    public void refocus() {
        if (this.mCamera != null) {
            this.hasFocus = false;
            autoFocus();
        }
    }

    public void autoFocus() {
        LogUtils.m37051d("request focus begin, focusIng===" + this.f50287g);
        if (!this.f50287g) {
            this.f50287g = true;
            this.f50282b.postDelayed(new Runnable() {
                public void run() {
                    if (ICamera.this.m37613b()) {
                        ICamera.this.m37610a();
                    }
                }
            }, 100);
            this.f50282b.postDelayed(this.f50289j, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37610a() {
        if (this.f50288h >= 3) {
            this.f50287g = false;
            this.hasFocus = true;
            return;
        }
        if (this.f50286f == 0) {
            this.f50286f = System.currentTimeMillis();
        }
        LogUtils.m37051d("camera auto focus begin...");
        try {
            if (this.mCamera != null) {
                this.mCamera.autoFocus(this);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            LogUtils.m37053e("auto focus failed, msg===" + message);
            this.f50287g = false;
            this.f50286f = 0;
            this.f50288h = this.f50288h + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m37613b() {
        if (((ICamera) this.f50283c.get()) != null) {
            return true;
        }
        LogUtils.m37053e("camera is closed or collect by gc!!!");
        return false;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public synchronized void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f50283c.clear();
                this.f50281a = false;
                this.hasFocus = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.hardware.Camera$Size} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera.Size m37609a(android.hardware.Camera.Parameters r7, final int r8, final int r9) {
        /*
            r6 = this;
            java.util.List r7 = r7.getSupportedPreviewSizes()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
            r1 = 0
            r2 = r1
        L_0x000f:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x003f
            java.lang.Object r3 = r7.next()
            android.hardware.Camera$Size r3 = (android.hardware.Camera.Size) r3
            int r4 = r3.width
            int r5 = r3.height
            if (r4 <= r5) goto L_0x000f
            r0.add(r3)
            int r4 = r3.width
            r5 = 1280(0x500, float:1.794E-42)
            if (r4 != r5) goto L_0x0031
            int r4 = r3.height
            r5 = 720(0x2d0, float:1.009E-42)
            if (r4 != r5) goto L_0x0031
            r1 = r3
        L_0x0031:
            int r4 = r3.width
            r5 = 1920(0x780, float:2.69E-42)
            if (r4 != r5) goto L_0x000f
            int r4 = r3.height
            r5 = 1080(0x438, float:1.513E-42)
            if (r4 != r5) goto L_0x000f
            r2 = r3
            goto L_0x000f
        L_0x003f:
            if (r1 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r1 = r2
        L_0x0043:
            if (r1 != 0) goto L_0x0055
            com.didichuxing.gbankcard.ocr.utils.ICamera$3 r7 = new com.didichuxing.gbankcard.ocr.utils.ICamera$3
            r7.<init>(r8, r9)
            java.util.Collections.sort(r0, r7)
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            r1 = r7
            android.hardware.Camera$Size r1 = (android.hardware.Camera.Size) r1
        L_0x0055:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "use preview size, w===="
            r7.append(r8)
            int r8 = r1.width
            r7.append(r8)
            java.lang.String r8 = ", h="
            r7.append(r8)
            int r8 = r1.height
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.didichuxing.dfbasesdk.utils.LogUtils.m37051d(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.gbankcard.ocr.utils.ICamera.m37609a(android.hardware.Camera$Parameters, int, int):android.hardware.Camera$Size");
    }

    public void onAutoFocus(boolean z, Camera camera) {
        LogUtils.m37051d("onAutoFocus callback, focus success = " + z);
        this.f50282b.removeCallbacks(this.f50289j);
        this.f50287g = false;
        if (!z) {
            this.f50288h++;
        }
        m37615c();
        this.f50286f = 0;
        this.hasFocus = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37615c() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public void onError(int i, Camera camera) {
        LogUtils.m37053e("camera error, error code===" + i);
    }
}
