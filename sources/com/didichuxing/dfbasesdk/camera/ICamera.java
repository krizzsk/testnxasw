package com.didichuxing.dfbasesdk.camera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

@Deprecated
public class ICamera implements ICameraInterface {

    /* renamed from: a */
    private boolean f49196a;

    /* renamed from: b */
    private int f49197b;

    /* renamed from: c */
    private int f49198c;
    public int cameraHeight;
    public int cameraId;
    public int cameraWidth;

    /* renamed from: d */
    private int f49199d;

    /* renamed from: e */
    private int f49200e;

    /* renamed from: f */
    private int f49201f;

    /* renamed from: g */
    private int f49202g;

    /* renamed from: h */
    private List<String> f49203h;
    public volatile Camera mCamera;

    public ICamera() {
        this.cameraId = 1;
        this.f49196a = false;
        this.f49199d = 640;
        this.f49200e = 480;
    }

    public ICamera(int i, int i2, int i3, int i4) {
        this.cameraId = 1;
        this.f49196a = false;
        this.f49197b = i;
        this.f49198c = i2;
        this.f49199d = i3;
        this.f49200e = i4;
    }

    public boolean isOpen() {
        return this.f49196a;
    }

    public void addAllFlipCameraType(List<String> list) {
        if (list != null) {
            if (this.f49203h == null) {
                this.f49203h = new ArrayList();
            }
            this.f49203h.clear();
            this.f49203h.addAll(list);
        }
    }

    public boolean isInFlipCameraTypeList(String str) {
        for (String equals : this.f49203h) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public int getPreviewWidth() {
        return this.cameraWidth;
    }

    public int getPreviewHeight() {
        return this.cameraHeight;
    }

    public int openCamera(Activity activity) {
        return openCamera(activity, false);
    }

    public int openCamera(Activity activity, boolean z) {
        try {
            this.cameraId = 0;
            if (!CameraUtils.hasFacingFrontCamera()) {
                this.cameraId = 0;
            }
            this.mCamera = Camera.open(this.cameraId);
            Camera.getCameraInfo(this.cameraId, new Camera.CameraInfo());
            Camera.Parameters parameters = this.mCamera.getParameters();
            m36872a(parameters, 30);
            this.f49202g = parameters.getPreviewFrameRate();
            Camera.Size a = m36871a(parameters, this.f49199d, this.f49200e);
            this.cameraWidth = a.width;
            int i = a.height;
            this.cameraHeight = i;
            parameters.setPreviewSize(this.cameraWidth, i);
            this.f49201f = getCameraAngle(activity);
            if (!z) {
                this.mCamera.setDisplayOrientation(this.f49201f);
            }
            this.mCamera.setParameters(parameters);
            Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
            this.cameraWidth = previewSize.width;
            this.cameraHeight = previewSize.height;
            return this.cameraId;
        } catch (Exception e) {
            LogUtils.m37051d("camera open failed: " + e.getMessage());
            return -1;
        }
    }

    /* renamed from: a */
    private void m36872a(Camera.Parameters parameters, int i) {
        try {
            if (parameters.getPreviewFrameRate() != i) {
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
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public int getCameraAngle() {
        return this.f49201f;
    }

    public void flashLight(boolean z) {
        try {
            if (this.mCamera != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                if (z) {
                    if (supportedFlashModes.contains("torch")) {
                        parameters.setFlashMode("torch");
                        this.mCamera.setParameters(parameters);
                    }
                } else if (supportedFlashModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    this.mCamera.setParameters(parameters);
                }
            }
        } catch (Throwable th) {
            LogUtils.m37056e("flashLight", th);
        }
    }

    public void actionDetect(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
                this.f49196a = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
        LogUtils.m37051d("ICamera#startPreview=====");
        try {
            if (this.mCamera != null) {
                try {
                    this.mCamera.setPreviewTexture(surfaceTexture);
                    this.mCamera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void startPreview(SurfaceHolder surfaceHolder) {
        try {
            if (this.mCamera != null) {
                try {
                    this.mCamera.setPreviewDisplay(surfaceHolder);
                    this.mCamera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f49196a = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoFocus() {
        try {
            if (this.mCamera != null) {
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                    public void onAutoFocus(boolean z, Camera camera) {
                        ICamera.this.mCamera.cancelAutoFocus();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoFocus(final Camera.AutoFocusCallback autoFocusCallback) {
        try {
            if (this.mCamera != null) {
                System.currentTimeMillis();
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                    public void onAutoFocus(boolean z, Camera camera) {
                        Camera.AutoFocusCallback autoFocusCallback = autoFocusCallback;
                        if (autoFocusCallback != null) {
                            autoFocusCallback.onAutoFocus(z, camera);
                        }
                        ICamera.this.mCamera.cancelAutoFocus();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private Camera.Size m36871a(Camera.Parameters parameters, final int i, final int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : supportedPreviewSizes) {
            if (next.width > next.height) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size size, Camera.Size size2) {
                return Math.abs((size.width * size.height) - (i * i2)) - Math.abs((size2.width * size2.height) - (i * i2));
            }
        });
        return (Camera.Size) arrayList.get(0);
    }

    public Camera getCameraSafely(int i) {
        try {
            return Camera.open(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public Bitmap getBitmap(byte[] bArr, Camera camera, boolean z) {
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
        Camera.getCameraInfo(this.cameraId, cameraInfo);
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

    public boolean isUsingFrontCamera() {
        return this.cameraId == 1;
    }

    public int getFps() {
        int i = this.f49202g;
        if (i <= 1) {
            this.f49202g = 30;
        } else if (i > 30) {
            this.f49202g = 30;
        }
        return this.f49202g;
    }
}
