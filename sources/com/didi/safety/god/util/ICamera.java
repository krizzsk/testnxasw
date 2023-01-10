package com.didi.safety.god.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.event.AutoFocusEvent;
import com.didi.safety.god.event.ReqFocusEvent;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class ICamera implements Camera.AutoFocusCallback, Camera.ErrorCallback {

    /* renamed from: l */
    private static final int f37591l = 3;

    /* renamed from: a */
    private volatile boolean f37592a = false;

    /* renamed from: b */
    private RelativeLayout.LayoutParams f37593b;

    /* renamed from: c */
    private Handler f37594c = new Handler(Looper.getMainLooper());
    public int cameraHeight;
    public int cameraId = 1;
    public int cameraWidth;

    /* renamed from: d */
    private Context f37595d;

    /* renamed from: e */
    private WeakReference<ICamera> f37596e;

    /* renamed from: f */
    private final int f37597f = ResUtils.getScreenWidth();

    /* renamed from: g */
    private final int f37598g = ResUtils.getScreenHeight();

    /* renamed from: h */
    private long f37599h;
    public boolean hasFocus;

    /* renamed from: i */
    private long f37600i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f37601j;

    /* renamed from: k */
    private int f37602k;

    /* renamed from: m */
    private final Runnable f37603m = new Runnable() {
        public void run() {
            LogUtils.m28313i("focus timeout happens, set hasFocus=true!!!");
            boolean unused = ICamera.this.f37601j = false;
            ICamera.this.hasFocus = true;
            ICamera.this.m28300b();
        }
    };
    public Camera mCamera;

    public ICamera() {
        LogUtils.m28307d("screen W===" + this.f37597f + ", H=" + this.f37598g);
    }

    public synchronized Camera openCamera(Context context, int i) {
        List<String> supportedFocusModes;
        if (this.f37592a) {
            return this.mCamera;
        }
        this.f37596e = new WeakReference<>(this);
        this.f37595d = context;
        try {
            this.cameraId = i;
            this.mCamera = Camera.open(i);
            this.f37592a = true;
            this.mCamera.setErrorCallback(this);
            Camera.Parameters parameters = this.mCamera.getParameters();
            Camera.Size a = m28296a(parameters, this.f37597f, this.f37598g);
            this.cameraWidth = a.width;
            this.cameraHeight = a.height;
            parameters.setRecordingHint(true);
            parameters.setPreviewSize(this.cameraWidth, this.cameraHeight);
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.mCamera.setParameters(parameters);
            return this.mCamera;
        } catch (Exception unused) {
            return null;
        }
    }

    public void refocus(int i) {
        if (this.mCamera != null) {
            this.hasFocus = false;
            autoFocus(i);
        }
    }

    public void autoFocus(int i) {
        if (!this.f37601j) {
            this.f37601j = true;
            this.f37600i = (long) Math.max(1000, i);
            this.f37594c.postDelayed(new Runnable() {
                public void run() {
                    if (ICamera.this.m28298a()) {
                        ICamera.this.doAutoFocus();
                    }
                }
            }, this.f37600i);
            BusUtils.post(new ReqFocusEvent());
            this.f37594c.postDelayed(this.f37603m, 5000);
        }
    }

    public void doAutoFocus() {
        if (this.f37602k >= 3) {
            LogUtils.m28313i("focus-broken device model===" + Build.MODEL + ", manually set focus!!!");
            this.f37601j = false;
            this.hasFocus = true;
            return;
        }
        if (this.f37599h == 0) {
            this.f37599h = System.currentTimeMillis();
        }
        LogUtils.m28307d("camera auto focus begin...");
        try {
            if (this.mCamera != null) {
                this.mCamera.autoFocus(this);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            LogUtils.m28309e("auto focus failed, msg===" + message);
            this.f37601j = false;
            this.f37599h = 0;
            HashMap hashMap = new HashMap();
            hashMap.put("cmd", "FOCUSEX");
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, message);
            hashMap.put("code", 2);
            BusUtils.post(new AutoFocusEvent(hashMap));
            this.f37602k++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m28298a() {
        if (((ICamera) this.f37596e.get()) != null) {
            return true;
        }
        LogUtils.m28309e("camera is closed by and collect by gc.....");
        return false;
    }

    public Camera.Size getPreviewSize() {
        return this.mCamera.getParameters().getPreviewSize();
    }

    public RelativeLayout.LayoutParams getLayoutParam() {
        boolean z = this.f37595d.getResources().getConfiguration().orientation == 2;
        float min = Math.min((((float) this.f37595d.getResources().getDisplayMetrics().heightPixels) * 1.0f) / ((float) this.cameraHeight), (((float) this.f37595d.getResources().getDisplayMetrics().widthPixels) * 1.0f) / ((float) this.cameraWidth));
        int i = (int) (((float) this.cameraHeight) * min);
        int i2 = (int) (((float) this.cameraWidth) * min);
        if (PhoneList.isAdapterPhone()) {
            int i3 = (int) (((double) (((float) this.cameraHeight) * min)) * 0.85d);
            int i4 = (int) (((double) (((float) this.cameraWidth) * min)) * 0.85d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            this.f37593b = layoutParams;
            layoutParams.addRule(14);
            this.f37593b.setMargins(0, (int) (((min * ((float) this.cameraWidth)) - ((float) i4)) / 2.0f), 0, 0);
        } else {
            if (z) {
                this.f37593b = new RelativeLayout.LayoutParams(Math.max(i, i2), Math.min(i, i2));
            } else {
                this.f37593b = new RelativeLayout.LayoutParams(Math.min(i, i2), Math.max(i, i2));
            }
            this.f37593b.addRule(14);
        }
        return this.f37593b;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void torchOn() {
        try {
            if (this.mCamera != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                parameters.setFlashMode("torch");
                this.mCamera.setParameters(parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void torchOff() {
        try {
            if (this.mCamera != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                this.mCamera.setParameters(parameters);
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

    public synchronized void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f37596e.clear();
                this.f37592a = false;
                this.hasFocus = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
                LogUtils.m28313i("release camera success.......");
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.hardware.Camera$Size} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera.Size m28296a(android.hardware.Camera.Parameters r7, final int r8, final int r9) {
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
            com.didi.safety.god.util.LogUtils.m28307d(r3)
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
            com.didi.safety.god.util.ICamera$3 r7 = new com.didi.safety.god.util.ICamera$3
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
            com.didi.safety.god.util.LogUtils.m28313i(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.util.ICamera.m28296a(android.hardware.Camera$Parameters, int, int):android.hardware.Camera$Size");
    }

    public Camera getCameraSafely(int i) {
        try {
            return Camera.open(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RelativeLayout.LayoutParams getParams(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = m28296a(parameters, this.f37597f, this.f37598g);
        this.cameraWidth = a.width;
        int i = a.height;
        this.cameraHeight = i;
        parameters.setPreviewSize(this.cameraWidth, i);
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

    public void onAutoFocus(boolean z, Camera camera) {
        LogUtils.m28307d("onAutoFocus callback, focus success = " + z);
        this.f37594c.removeCallbacks(this.f37603m);
        this.f37601j = false;
        int i = 1;
        if (!z) {
            this.f37602k++;
        }
        m28300b();
        HashMap hashMap = new HashMap();
        hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - this.f37599h));
        hashMap.put("cmd", "FOCUS");
        if (!z) {
            i = 2;
        }
        hashMap.put("code", Integer.valueOf(i));
        BusUtils.post(new AutoFocusEvent(hashMap));
        this.f37599h = 0;
        this.hasFocus = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28300b() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public void takePicture(Camera.PictureCallback pictureCallback) {
        this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, pictureCallback);
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public void onError(int i, Camera camera) {
        LogUtils.m28309e("camera error,error code = " + i);
    }
}
