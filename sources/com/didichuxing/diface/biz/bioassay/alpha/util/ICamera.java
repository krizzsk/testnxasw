package com.didichuxing.diface.biz.bioassay.alpha.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ICamera {

    /* renamed from: a */
    private boolean f49835a = false;

    /* renamed from: b */
    private int f49836b;

    /* renamed from: c */
    private int f49837c;
    public int cameraHeight;
    public int cameraId = 1;
    public int cameraWidth;

    /* renamed from: d */
    private int f49838d;

    /* renamed from: e */
    private int f49839e;

    /* renamed from: f */
    private int f49840f;

    /* renamed from: g */
    private int f49841g;

    /* renamed from: h */
    private List<String> f49842h;
    public Camera mCamera;

    public ICamera(int i, int i2, int i3, int i4) {
        this.f49836b = i;
        this.f49837c = i2;
        this.f49838d = i3;
        this.f49839e = i4;
    }

    public boolean isOpen() {
        return this.f49835a;
    }

    public void addAllFlipCameraType(List<String> list) {
        if (list != null) {
            if (this.f49842h == null) {
                this.f49842h = new ArrayList();
            }
            this.f49842h.clear();
            this.f49842h.addAll(list);
        }
    }

    public boolean isInFlipCameraTypeList(String str) {
        for (String equals : this.f49842h) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int openCamera(Activity activity) {
        return openCamera(activity, false);
    }

    public int openCamera(Activity activity, boolean z) {
        try {
            this.cameraId = 1;
            if (!CameraUtils.hasFacingFrontCamera()) {
                this.cameraId = 0;
            }
            if (DiFaceFacade.getInstance().getConfig().getForceUseBackCamera()) {
                this.cameraId = 0;
            }
            this.mCamera = Camera.open(this.cameraId);
            Camera.getCameraInfo(this.cameraId, new Camera.CameraInfo());
            Camera.Parameters parameters = this.mCamera.getParameters();
            int[] iArr = new int[2];
            parameters.getPreviewFpsRange(iArr);
            this.f49841g = iArr[1] / 1000;
            Camera.Size a = m37322a(this.mCamera.getParameters(), this.f49838d, this.f49839e);
            this.cameraWidth = a.width;
            int i = a.height;
            this.cameraHeight = i;
            parameters.setPreviewSize(this.cameraWidth, i);
            int a2 = m37321a(activity);
            this.f49840f = a2;
            if (!z) {
                this.mCamera.setDisplayOrientation(a2);
            }
            this.mCamera.setParameters(parameters);
            return this.cameraId;
        } catch (Exception e) {
            AFLog.m38441v("open camera failed: " + e.getMessage());
            return -1;
        }
    }

    public int getCameraAngle() {
        return this.f49840f;
    }

    public RelativeLayout.LayoutParams getLayoutParam() {
        Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
        float min = Math.min((((float) this.f49836b) * 1.0f) / ((float) previewSize.height), (((float) this.f49837c) * 1.0f) / ((float) previewSize.width));
        return new RelativeLayout.LayoutParams((int) (((float) previewSize.height) * min), (int) (min * ((float) previewSize.width)));
    }

    public void actionDetect(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
                this.f49835a = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
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
                this.f49835a = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private Camera.Size m37322a(Camera.Parameters parameters, final int i, final int i2) {
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

    public RelativeLayout.LayoutParams getParams(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = m37322a(parameters, this.f49836b, this.f49837c);
        this.cameraWidth = a.width;
        int i = a.height;
        this.cameraHeight = i;
        parameters.setPreviewSize(this.cameraWidth, i);
        camera.setParameters(parameters);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.width, (int) (((float) a.width) / ((float) (a.width / a.height))));
        layoutParams.addRule(14);
        return layoutParams;
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

    /* renamed from: a */
    private int m37321a(Activity activity) {
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
        int i = this.f49841g;
        if (i <= 1) {
            this.f49841g = 30;
        } else if (i > 30) {
            this.f49841g = 30;
        }
        return this.f49841g;
    }
}
