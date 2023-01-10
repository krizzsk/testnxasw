package com.didichuxing.dfbasesdk.camera2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.dfbasesdk.thread.DiSafetyThreadManager;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class ICamera2 implements Camera.ErrorCallback {
    public static final int STATE_CLOSE = 0;
    public static final int STATE_FOCUS = 3;
    public static final int STATE_OPEN = 1;
    public static final int STATE_PREVIEW = 2;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static List<Runnable> f49214m = new LinkedList();

    /* renamed from: a */
    private int f49215a = 0;

    /* renamed from: b */
    private int f49216b;

    /* renamed from: c */
    private int f49217c;

    /* renamed from: d */
    private int f49218d = 1;

    /* renamed from: e */
    private volatile boolean f49219e = false;

    /* renamed from: f */
    private RelativeLayout.LayoutParams f49220f;

    /* renamed from: g */
    private Context f49221g;

    /* renamed from: h */
    private int f49222h;

    /* renamed from: i */
    private int f49223i;

    /* renamed from: j */
    private int f49224j;

    /* renamed from: k */
    private ErrorListener f49225k;

    /* renamed from: l */
    private int f49226l = 0;
    public Camera mCamera;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f49227n = false;

    public interface ErrorListener {
        void onCameraError(String str);
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.f49225k = errorListener;
    }

    public ICamera2(int i, int i2) {
        this.f49223i = i;
        this.f49224j = i2;
    }

    public int getState() {
        return this.f49215a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36897a(int i) {
        if (i == 0) {
            if (1 == this.f49215a) {
                this.f49215a = i;
            }
        } else if (1 == i) {
            this.f49215a = i;
        } else if (2 == i) {
            int i2 = this.f49215a;
            if (1 == i2 || 3 == i2) {
                this.f49215a = i;
            }
        } else if (3 == i && 2 == this.f49215a) {
            this.f49215a = i;
        }
    }

    public int getCameraId() {
        return this.f49218d;
    }

    public int getCameraWidth() {
        return this.f49216b;
    }

    public int getCameraHeight() {
        return this.f49217c;
    }

    public void setCameraWidth(int i) {
        this.f49216b = i;
    }

    public void setCameraHeight(int i) {
        this.f49217c = i;
    }

    public synchronized Camera openCamera(Context context, int i) throws Throwable {
        List<String> supportedFocusModes;
        SystemUtils.log(6, "AccessSecurityCamera", "ICamera2.openCamera", (Throwable) null, "com.didichuxing.dfbasesdk.camera2.ICamera2", 111);
        if (this.f49219e) {
            return this.mCamera;
        }
        m36903b();
        this.f49221g = context;
        this.f49218d = i;
        try {
            Camera open = Camera.open(i);
            this.mCamera = open;
            open.setErrorCallback(this);
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setRecordingHint(true);
            parameters.setPreviewSize(this.f49216b, this.f49217c);
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.f49222h = parameters.getPreviewFrameRate();
            if (this.f49226l > 0) {
                m36898a(parameters, this.f49226l);
            }
            this.mCamera.setParameters(parameters);
            m36897a(1);
            this.f49219e = true;
            return this.mCamera;
        } catch (Throwable th) {
            m36901a("mCamera.setParameters():" + th);
            throw th;
        }
    }

    public boolean isOpen() {
        return this.f49219e;
    }

    public int getFps() {
        int i = this.f49222h;
        if (i <= 1) {
            this.f49222h = 30;
        } else if (i > 30) {
            this.f49222h = 30;
        }
        return this.f49222h;
    }

    public void setFrameRate(int i) {
        this.f49226l = i;
    }

    /* renamed from: a */
    private void m36898a(Camera.Parameters parameters, int i) {
        if (this.f49222h != i) {
            List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            if (supportedPreviewFrameRates.size() >= 1) {
                if (supportedPreviewFrameRates.contains(Integer.valueOf(i))) {
                    parameters.setPreviewFrameRate(i);
                    return;
                }
                int i2 = Integer.MAX_VALUE;
                int intValue = supportedPreviewFrameRates.get(0).intValue();
                for (Integer next : supportedPreviewFrameRates) {
                    int abs = Math.abs(next.intValue() - i);
                    if (abs < i2) {
                        intValue = next.intValue();
                        i2 = abs;
                    }
                }
                parameters.setPreviewFrameRate(intValue);
            }
        }
    }

    private class FocusRunnable implements Runnable {
        /* access modifiers changed from: private */
        public Camera.AutoFocusCallback callback;
        /* access modifiers changed from: private */
        public boolean success;

        private FocusRunnable() {
        }

        public void run() {
            if (ICamera2.f49214m.remove(this) && ICamera2.f49214m.isEmpty()) {
                if (ICamera2.this.mCamera != null) {
                    try {
                        ICamera2.this.mCamera.cancelAutoFocus();
                    } catch (Throwable th) {
                        ICamera2 iCamera2 = ICamera2.this;
                        iCamera2.m36901a("mCamera.cancelAutoFocus():" + th);
                    }
                }
                ICamera2.this.m36897a(2);
            }
            Camera.AutoFocusCallback autoFocusCallback = this.callback;
            if (autoFocusCallback != null) {
                autoFocusCallback.onAutoFocus(this.success, ICamera2.this.mCamera);
            }
        }
    }

    public void autoFocus(final Camera.AutoFocusCallback autoFocusCallback) {
        final FocusRunnable focusRunnable = new FocusRunnable();
        Camera.AutoFocusCallback unused = focusRunnable.callback = autoFocusCallback;
        boolean unused2 = focusRunnable.success = false;
        f49214m.add(focusRunnable);
        DiSafetyThreadManager.getUiHandler().postDelayed(focusRunnable, Const.DELAY_TIME4LAST_GPS_TASK);
        try {
            if (this.mCamera != null) {
                m36897a(3);
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                    public void onAutoFocus(boolean z, Camera camera) {
                        DiSafetyThreadManager.getUiHandler().removeCallbacks(focusRunnable);
                        if (ICamera2.f49214m.contains(focusRunnable)) {
                            Camera.AutoFocusCallback unused = focusRunnable.callback = autoFocusCallback;
                            boolean unused2 = focusRunnable.success = z;
                            DiSafetyThreadManager.getUiHandler().post(focusRunnable);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            m36901a("mCamera.autoFocus():" + th);
        }
    }

    public void torchOn() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFlashModes().contains("torch")) {
                    parameters.setFlashMode("torch");
                    this.mCamera.setParameters(parameters);
                }
            } catch (Throwable th) {
                m36901a("torchOn():" + th);
            }
        }
    }

    public void torchOff() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFlashModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    this.mCamera.setParameters(parameters);
                }
            } catch (Throwable th) {
                m36901a("torchOff():" + th);
            }
        }
    }

    public Camera.Size getPreviewSize() {
        Camera.Parameters parameters;
        Camera camera = this.mCamera;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return null;
        }
        return parameters.getPreviewSize();
    }

    public ViewGroup.LayoutParams getLayoutParams(int i) {
        if (i == 1) {
            return getLandScapeLayoutParam();
        }
        return getPortraitLayoutParams();
    }

    public ViewGroup.LayoutParams getLandScapeLayoutParam() {
        boolean z = this.f49221g.getResources().getConfiguration().orientation == 2;
        float min = Math.min((((float) this.f49221g.getResources().getDisplayMetrics().heightPixels) * 1.0f) / ((float) this.f49217c), (((float) this.f49221g.getResources().getDisplayMetrics().widthPixels) * 1.0f) / ((float) this.f49216b));
        int i = (int) (((float) this.f49217c) * min);
        int i2 = (int) (((float) this.f49216b) * min);
        if (PhoneList2.isAdapterPhone()) {
            int i3 = (int) (((double) (((float) this.f49217c) * min)) * 0.85d);
            int i4 = (int) (((double) (((float) this.f49216b) * min)) * 0.85d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            this.f49220f = layoutParams;
            layoutParams.addRule(14);
            this.f49220f.setMargins(0, (int) (((min * ((float) this.f49216b)) - ((float) i4)) / 2.0f), 0, 0);
        } else {
            if (z) {
                this.f49220f = new RelativeLayout.LayoutParams(Math.max(i, i2), Math.min(i, i2));
            } else {
                this.f49220f = new RelativeLayout.LayoutParams(Math.min(i, i2), Math.max(i, i2));
            }
            this.f49220f.addRule(14);
        }
        return this.f49220f;
    }

    public void resumeScrollCamera() {
        this.mCamera.setDisplayOrientation(270);
    }

    public ViewGroup.LayoutParams getPortraitLayoutParams() {
        resumeScrollCamera();
        boolean z = true;
        if (this.f49221g.getResources().getConfiguration().orientation != 1) {
            z = false;
        }
        float min = Math.min((((float) this.f49221g.getResources().getDisplayMetrics().widthPixels) * 1.0f) / ((float) this.f49217c), (((float) this.f49221g.getResources().getDisplayMetrics().heightPixels) * 1.0f) / ((float) this.f49216b));
        int i = (int) (((float) this.f49217c) * min);
        int i2 = (int) (min * ((float) this.f49216b));
        if (z) {
            this.f49220f = new RelativeLayout.LayoutParams(Math.min(i, i2), Math.max(i, i2));
        } else {
            this.f49220f = new RelativeLayout.LayoutParams(Math.max(i, i2), Math.min(i, i2));
        }
        this.f49220f.addRule(10);
        return this.f49220f;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) throws Exception {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
                m36897a(2);
            } catch (Exception e) {
                m36901a("mCamera.setPreviewTexture():" + e);
                throw e;
            }
        }
    }

    public void stopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Throwable th) {
                m36901a("mCamera.stopPreview():" + th);
            }
        }
    }

    public synchronized void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f49219e = false;
                this.mCamera.stopPreview();
                m36897a(1);
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
                m36897a(0);
                m36903b();
            }
        } catch (Exception e) {
            m36901a("closeCamera():" + e);
        }
        return;
    }

    /* renamed from: b */
    private void m36903b() {
        for (Runnable removeCallbacks : f49214m) {
            DiSafetyThreadManager.getUiHandler().removeCallbacks(removeCallbacks);
        }
        f49214m.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.hardware.Camera$Size} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera.Size m36895a(android.hardware.Camera.Parameters r7, final int r8, final int r9) {
        /*
            r6 = this;
            java.util.List r7 = r7.getSupportedPreviewSizes()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
            r1 = 0
        L_0x000e:
            boolean r2 = r7.hasNext()
            java.lang.String r3 = ", h="
            if (r2 == 0) goto L_0x0051
            java.lang.Object r2 = r7.next()
            android.hardware.Camera$Size r2 = (android.hardware.Camera.Size) r2
            int r4 = r2.width
            int r5 = r2.height
            if (r4 <= r5) goto L_0x000e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "support preview w===="
            r4.append(r5)
            int r5 = r2.width
            r4.append(r5)
            r4.append(r3)
            int r3 = r2.height
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.didichuxing.dfbasesdk.utils.LogUtils.m37051d(r3)
            r0.add(r2)
            int r3 = r2.width
            r4 = 1280(0x500, float:1.794E-42)
            if (r3 != r4) goto L_0x000e
            int r3 = r2.height
            r4 = 720(0x2d0, float:1.009E-42)
            if (r3 != r4) goto L_0x000e
            r1 = r2
            goto L_0x000e
        L_0x0051:
            if (r1 != 0) goto L_0x0063
            com.didichuxing.dfbasesdk.camera2.ICamera2$2 r7 = new com.didichuxing.dfbasesdk.camera2.ICamera2$2
            r7.<init>(r8, r9)
            java.util.Collections.sort(r0, r7)
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            r1 = r7
            android.hardware.Camera$Size r1 = (android.hardware.Camera.Size) r1
        L_0x0063:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "use preview size, w===="
            r7.append(r8)
            int r8 = r1.width
            r7.append(r8)
            r7.append(r3)
            int r8 = r1.height
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.didichuxing.dfbasesdk.utils.LogUtils.m37057i(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.camera2.ICamera2.m36895a(android.hardware.Camera$Parameters, int, int):android.hardware.Camera$Size");
    }

    public RelativeLayout.LayoutParams getParams(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = m36895a(parameters, this.f49223i, this.f49224j);
        this.f49216b = a.width;
        int i = a.height;
        this.f49217c = i;
        parameters.setPreviewSize(this.f49216b, i);
        camera.setParameters(parameters);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.width, (int) (((float) a.width) / ((float) (a.width / a.height))));
        layoutParams.addRule(14);
        return layoutParams;
    }

    public Bitmap getBitMap(byte[] bArr, Camera camera, boolean z) {
        int i = camera.getParameters().getPreviewSize().width;
        int i2 = camera.getParameters().getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(bArr, camera.getParameters().getPreviewFormat(), i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        matrix.reset();
        if (z) {
            matrix.setRotate(-90.0f);
        } else {
            matrix.setRotate(90.0f);
        }
        Bitmap copy = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true).copy(Bitmap.Config.ARGB_8888, true);
        float height = ((float) (copy.getHeight() > copy.getWidth() ? copy.getHeight() : copy.getWidth())) / 800.0f;
        return height > 1.0f ? Bitmap.createScaledBitmap(copy, (int) (((float) copy.getWidth()) / height), (int) (((float) copy.getHeight()) / height), false) : copy;
    }

    public int getCameraAngle(Activity activity) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f49218d, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public int getCameraPictureRotation() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f49218d, cameraInfo);
        return cameraInfo.orientation;
    }

    /* renamed from: c */
    private void m36904c() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (Throwable th) {
                m36901a("mCamera.cancelAutoFocus():" + th);
            }
        }
    }

    public void takePicture(final Camera.PictureCallback pictureCallback) {
        if (!this.f49227n) {
            this.f49227n = true;
            try {
                this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        boolean unused = ICamera2.this.f49227n = false;
                        Camera.PictureCallback pictureCallback = pictureCallback;
                        if (pictureCallback != null) {
                            pictureCallback.onPictureTaken(bArr, camera);
                        }
                    }
                });
            } catch (Throwable th) {
                this.f49227n = false;
                m36901a("mCamera.takePicture():" + th);
            }
        }
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public void onError(int i, Camera camera) {
        m36901a("Camera.ErrorCallback.onError:" + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36901a(String str) {
        ErrorListener errorListener = this.f49225k;
        if (errorListener != null && str != null) {
            errorListener.onCameraError(str);
        }
    }
}
