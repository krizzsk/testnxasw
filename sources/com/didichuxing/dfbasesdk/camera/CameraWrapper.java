package com.didichuxing.dfbasesdk.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class CameraWrapper implements ICameraInterface {
    public static final int PIC_HEIGHT_DEFAULT = 480;
    public static final int PIC_WIDTH_DEFAULT = 640;

    /* renamed from: l */
    private static final int f49166l = 1;

    /* renamed from: m */
    private static final int f49167m = 2;

    /* renamed from: n */
    private static final int f49168n = 3;

    /* renamed from: a */
    private boolean f49169a;

    /* renamed from: b */
    private int f49170b;

    /* renamed from: c */
    private int f49171c;

    /* renamed from: d */
    private int f49172d;

    /* renamed from: e */
    private int f49173e;

    /* renamed from: f */
    private int f49174f;

    /* renamed from: g */
    private int f49175g;

    /* renamed from: h */
    private Camera f49176h;

    /* renamed from: i */
    private int f49177i;

    /* renamed from: j */
    private final int f49178j;

    /* renamed from: k */
    private int f49179k;

    public static class CropData {
        public float heightRatio;
        public float widthRatio;
        public float xRatio;
        public float yRatio;
    }

    public static boolean isFlashSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public CameraWrapper(boolean z, int i, int i2) {
        this(z, i, i2, -1, -1, -1, -1);
    }

    public CameraWrapper(boolean z, int i, int i2, int i3, int i4) {
        this(z, i, i2, i3, i4, -1, -1);
    }

    public CameraWrapper(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f49172d = 1280;
        this.f49173e = 720;
        this.f49174f = 640;
        this.f49175g = 480;
        this.f49177i = 1;
        this.f49179k = -1;
        this.f49169a = z;
        this.f49170b = i;
        this.f49171c = i2;
        if (i3 != -1) {
            this.f49172d = i3;
        }
        if (i4 != -1) {
            this.f49173e = i4;
        }
        if (i5 != -1) {
            this.f49174f = i5;
        }
        if (i6 != -1) {
            this.f49175g = i6;
        }
        this.f49178j = Camera.getNumberOfCameras();
    }

    public Camera openCamera() {
        return openCamera(this.f49177i);
    }

    public Camera openCamera(int i) {
        Camera camera = this.f49176h;
        if (camera != null) {
            return camera;
        }
        try {
            this.f49176h = Camera.open(i);
            this.f49177i = i;
            m36866a(false);
            return this.f49176h;
        } catch (Exception e) {
            LogUtils.m37051d("open camera failed as: " + e.getMessage());
            return null;
        }
    }

    public void updateRotation(int i) {
        Camera camera = this.f49176h;
        if (camera != null && i != this.f49179k) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setRotation(i);
            this.f49176h.setParameters(parameters);
            this.f49179k = i;
        }
    }

    /* renamed from: a */
    private void m36866a(boolean z) {
        Camera.Size size;
        try {
            Camera.Parameters parameters = this.f49176h.getParameters();
            if (z) {
                size = m36863a(parameters, this.f49172d, this.f49173e);
            } else {
                size = m36864a(parameters, 1, this.f49172d, this.f49173e);
            }
            Camera.Size a = m36864a(parameters, 2, this.f49174f, this.f49175g);
            parameters.setPreviewSize(size.width, size.height);
            parameters.setPictureSize(a.width, a.height);
            LogUtils.m37051d("pre size, w====" + size.width + ", h=" + size.height);
            LogUtils.m37051d("pic size, w====" + a.width + ", h=" + a.height);
            LogUtils.m37051d("support focus modes====" + parameters.getSupportedFocusModes() + ", original focus mode=" + parameters.getFocusMode());
            if (this.f49177i == 0 && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.f49176h.setParameters(parameters);
            Camera.Size previewSize = this.f49176h.getParameters().getPreviewSize();
            this.f49172d = previewSize.width;
            this.f49173e = previewSize.height;
        } catch (Exception e) {
            LogUtils.m37051d("init camera params exception: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private Camera.Size m36863a(Camera.Parameters parameters, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList<Camera.Size> arrayList = new ArrayList<>();
        if (this.f49169a) {
            for (Camera.Size next : supportedPreviewSizes) {
                if (next.width == i) {
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                for (Camera.Size next2 : supportedPreviewSizes) {
                    if (next2.height == i2) {
                        arrayList.add(next2);
                    }
                }
            }
        } else {
            for (Camera.Size next3 : supportedPreviewSizes) {
                if (next3.height == i2) {
                    arrayList.add(next3);
                }
            }
            if (arrayList.isEmpty()) {
                for (Camera.Size next4 : supportedPreviewSizes) {
                    if (next4.width == i) {
                        arrayList.add(next4);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return m36864a(parameters, 1, i, i2);
        }
        Camera.Size size = (Camera.Size) arrayList.get(0);
        int i3 = Integer.MAX_VALUE;
        for (Camera.Size size2 : arrayList) {
            int abs = Math.abs((i * i2) - (size2.width * size2.height));
            if (abs < i3) {
                size = size2;
                i3 = abs;
            }
        }
        return size;
    }

    /* renamed from: a */
    private Camera.Size m36864a(Camera.Parameters parameters, int i, final int i2, final int i3) {
        List<Camera.Size> list;
        if (i == 1) {
            list = parameters.getSupportedPreviewSizes();
        } else if (i == 2) {
            list = parameters.getSupportedPictureSizes();
        } else {
            list = i == 3 ? parameters.getSupportedVideoSizes() : null;
        }
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : list) {
            if (next.width > next.height) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size size, Camera.Size size2) {
                return Math.abs((size.width * size.height) - (i2 * i3)) - Math.abs((size2.width * size2.height) - (i2 * i3));
            }
        });
        return (Camera.Size) arrayList.get(0);
    }

    @Deprecated
    /* renamed from: a */
    private Camera.Size m36865a(List<Camera.Size> list, boolean z) {
        int i;
        float f;
        float f2 = ((float) this.f49170b) / ((float) this.f49171c);
        LogUtils.m37051d("ratio is: " + f2);
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (this.f49169a) {
                f = (float) next.height;
                i = next.width;
            } else {
                f = (float) next.width;
                i = next.height;
            }
            float f3 = f / ((float) i);
            LogUtils.m37051d("sizeRatio is: " + f3);
            if (((double) Math.abs(f3 - f2)) < 0.1d) {
                if (size != null) {
                    if (z) {
                        if (this.f49169a) {
                            if (next.height <= size.height) {
                            }
                        } else if (next.width <= size.width) {
                        }
                    } else if (this.f49169a) {
                        if (next.height >= size.height) {
                        }
                    } else if (next.width >= size.width) {
                    }
                }
                size = next;
            }
        }
        if (size == null) {
            LogUtils.m37051d("can't find best size, use default");
            size = list.get(0);
        }
        LogUtils.m37051d("best size is: " + size.width + " X " + size.height);
        return size;
    }

    public void closeCamera() {
        this.f49179k = -1;
        Camera camera = this.f49176h;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.f49176h.setPreviewCallback((Camera.PreviewCallback) null);
            } catch (Exception e) {
                LogUtils.m37051d("close camera exception: " + e.getMessage());
            } catch (Throwable th) {
                this.f49176h.release();
                this.f49176h = null;
                throw th;
            }
            this.f49176h.release();
            this.f49176h = null;
        }
    }

    public void autoFocus() {
        Camera camera = this.f49176h;
        if (camera != null) {
            try {
                camera.autoFocus((Camera.AutoFocusCallback) null);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public boolean switchFlashLight() {
        Camera camera = this.f49176h;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode("torch");
                this.f49176h.setParameters(parameters);
                return true;
            }
            parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            this.f49176h.setParameters(parameters);
        }
        return false;
    }

    public boolean startPreview(SurfaceHolder surfaceHolder) {
        Camera camera = this.f49176h;
        if (camera != null) {
            try {
                camera.setPreviewDisplay(surfaceHolder);
                this.f49176h.startPreview();
                autoFocus();
                return true;
            } catch (IOException | RuntimeException unused) {
            }
        }
        return false;
    }

    public boolean startPreview(SurfaceTexture surfaceTexture) {
        Camera camera = this.f49176h;
        if (camera != null) {
            try {
                camera.setPreviewTexture(surfaceTexture);
                this.f49176h.startPreview();
                autoFocus();
                return true;
            } catch (IOException | RuntimeException unused) {
            }
        }
        return false;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        try {
            if (this.f49176h != null) {
                this.f49176h.setPreviewCallback(previewCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Camera getCamera() {
        return this.f49176h;
    }

    public int getPreviewWidth() {
        return this.f49172d;
    }

    public int getPreviewHeight() {
        return this.f49173e;
    }

    public int getCurrentCameraId() {
        return this.f49177i;
    }

    public void takePhoto(Camera.PictureCallback pictureCallback) {
        try {
            this.f49176h.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, pictureCallback);
        } catch (Exception e) {
            LogUtils.m37051d("take photo exception: " + e.getMessage());
        }
    }

    public int getMediaPlayerRotation() {
        return this.f49169a ? this.f49177i == 1 ? 270 : 90 : this.f49177i == 1 ? 180 : 0;
    }

    public void switchCamera(SurfaceHolder surfaceHolder) {
        if (this.f49178j != 1) {
            int i = this.f49177i;
            if (i == 1) {
                this.f49177i = 0;
                closeCamera();
            } else if (i == 0) {
                this.f49177i = 1;
                closeCamera();
            }
            openCamera(this.f49177i);
            startPreview(surfaceHolder);
        }
    }

    public void switchCamera(SurfaceTexture surfaceTexture) {
        if (this.f49178j != 1) {
            int i = this.f49177i;
            if (i == 1) {
                this.f49177i = 0;
                closeCamera();
            } else if (i == 0) {
                this.f49177i = 1;
                closeCamera();
            }
            openCamera(this.f49177i);
            startPreview(surfaceTexture);
        }
    }
}
