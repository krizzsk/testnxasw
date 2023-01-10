package com.didi.zxing.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.Size;
import com.didi.zxing.barcodescanner.SourceData;
import com.didi.zxing.client.AmbientLightManager;
import com.didi.zxing.client.camera.CameraConfigurationUtils;
import com.didi.zxing.client.camera.open.OpenCameraInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CameraManager {

    /* renamed from: a */
    private static final String f48014a = "CameraManager";

    /* renamed from: b */
    private Camera f48015b;

    /* renamed from: c */
    private Camera.CameraInfo f48016c;

    /* renamed from: d */
    private AutoFocusManager f48017d;

    /* renamed from: e */
    private AmbientLightManager f48018e;

    /* renamed from: f */
    private boolean f48019f;

    /* renamed from: g */
    private String f48020g;

    /* renamed from: h */
    private CameraSettings f48021h = new CameraSettings();

    /* renamed from: i */
    private DisplayConfiguration f48022i;

    /* renamed from: j */
    private Size f48023j;

    /* renamed from: k */
    private Size f48024k;

    /* renamed from: l */
    private int f48025l = -1;

    /* renamed from: m */
    private Context f48026m;

    /* renamed from: n */
    private TorchListener f48027n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Set<PreviewCallback> f48028o = new HashSet();

    /* renamed from: p */
    private final CameraPreviewCallback f48029p;

    public interface TorchListener {
        void onTorchOff();

        void onTorchOn();
    }

    private final class CameraPreviewCallback implements Camera.PreviewCallback {
        private PreviewCallback callback;
        private Size resolution;

        public CameraPreviewCallback() {
        }

        public void setResolution(Size size) {
            this.resolution = size;
        }

        public void setCallback(PreviewCallback previewCallback) {
            this.callback = previewCallback;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Size size = this.resolution;
            PreviewCallback previewCallback = this.callback;
            if (size == null || previewCallback == null) {
                SystemUtils.log(3, CameraManager.f48014a, "Got preview callback, but no handler or resolution available", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager$CameraPreviewCallback", 131);
                if (previewCallback != null) {
                    previewCallback.onPreviewError(new Exception("No resolution available"));
                }
            } else if (bArr != null) {
                try {
                    byte[] bArr2 = bArr;
                    SourceData sourceData = new SourceData(bArr2, size.width, size.height, camera.getParameters().getPreviewFormat(), CameraManager.this.getCameraRotation());
                    previewCallback.onPreview(sourceData);
                    for (PreviewCallback onPreview : CameraManager.this.f48028o) {
                        onPreview.onPreview(sourceData);
                    }
                } catch (RuntimeException e) {
                    SystemUtils.log(6, CameraManager.f48014a, "Camera preview failed", e, "com.didi.zxing.barcodescanner.camera.CameraManager$CameraPreviewCallback", 127);
                    previewCallback.onPreviewError(e);
                }
            } else {
                throw new NullPointerException("No preview data received");
            }
        }
    }

    public CameraManager(Context context) {
        this.f48026m = context;
        this.f48029p = new CameraPreviewCallback();
    }

    public void open() {
        Camera open = OpenCameraInterface.open(this.f48021h.getRequestedCameraId());
        this.f48015b = open;
        if (open != null) {
            int cameraId = OpenCameraInterface.getCameraId(this.f48021h.getRequestedCameraId());
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            this.f48016c = cameraInfo;
            Camera.getCameraInfo(cameraId, cameraInfo);
            return;
        }
        throw new RuntimeException("Failed to open camera");
    }

    public void configure() {
        if (this.f48015b != null) {
            m36065c();
            return;
        }
        throw new RuntimeException("Camera not open");
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) throws IOException {
        setPreviewDisplay(new CameraSurface(surfaceHolder));
    }

    public void setPreviewDisplay(CameraSurface cameraSurface) throws IOException {
        cameraSurface.setPreview(this.f48015b);
    }

    public void startPreview() {
        Camera camera = this.f48015b;
        if (camera != null && !this.f48019f) {
            camera.startPreview();
            System.out.println("theCamera.startPreview();");
            this.f48019f = true;
            this.f48017d = new AutoFocusManager(this.f48015b, this.f48021h);
            AmbientLightManager ambientLightManager = new AmbientLightManager(this.f48026m, this, this.f48021h);
            this.f48018e = ambientLightManager;
            ambientLightManager.start();
        }
    }

    public void stopPreview() {
        AutoFocusManager autoFocusManager = this.f48017d;
        if (autoFocusManager != null) {
            autoFocusManager.stop();
            this.f48017d = null;
        }
        AmbientLightManager ambientLightManager = this.f48018e;
        if (ambientLightManager != null) {
            ambientLightManager.stop();
            this.f48018e = null;
        }
        Camera camera = this.f48015b;
        if (camera != null && this.f48019f) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
            this.f48015b.stopPreview();
            this.f48029p.setCallback((PreviewCallback) null);
            this.f48019f = false;
        }
    }

    public void close() {
        Camera camera = this.f48015b;
        if (camera != null) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
            this.f48015b.release();
            this.f48015b = null;
        }
    }

    public boolean isCameraRotated() {
        int i = this.f48025l;
        if (i != -1) {
            return i % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public int getCameraRotation() {
        return this.f48025l;
    }

    /* renamed from: a */
    private Camera.Parameters m36059a() {
        Camera.Parameters parameters = this.f48015b.getParameters();
        String str = this.f48020g;
        if (str == null) {
            this.f48020g = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    /* renamed from: a */
    private void m36063a(boolean z) {
        boolean z2 = z;
        Camera.Parameters a = m36059a();
        if (a == null) {
            SystemUtils.log(5, f48014a, "Device error: no camera parameters are available. Proceeding without configuration.", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 275);
            return;
        }
        SystemUtils.log(4, f48014a, "Initial camera parameters: " + a.flatten(), (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 279);
        if (z2) {
            SystemUtils.log(5, f48014a, "In camera config safe mode -- most settings will not be honored", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 282);
        }
        CameraConfigurationUtils.setFocus(a, this.f48021h.getFocusMode(), z2);
        if (!z2) {
            CameraConfigurationUtils.setTorch(a, false);
            if (this.f48021h.isScanInverted()) {
                CameraConfigurationUtils.setInvertColor(a);
            }
            if (this.f48021h.isBarcodeSceneModeEnabled()) {
                CameraConfigurationUtils.setBarcodeSceneMode(a);
            }
            if (this.f48021h.isMeteringEnabled() && Build.VERSION.SDK_INT >= 15) {
                CameraConfigurationUtils.setVideoStabilization(a);
                CameraConfigurationUtils.setFocusArea(a);
                CameraConfigurationUtils.setMetering(a);
            }
        }
        List<Size> a2 = m36060a(a);
        if (a2.size() == 0) {
            this.f48023j = null;
        } else {
            Size bestPreviewSize = this.f48022i.getBestPreviewSize(a2, isCameraRotated());
            this.f48023j = bestPreviewSize;
            a.setPreviewSize(bestPreviewSize.width, this.f48023j.height);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.setBestPreviewFPS(a);
        }
        SystemUtils.log(4, f48014a, "Final camera parameters: " + a.flatten(), (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 332);
        this.f48015b.setParameters(a);
    }

    /* renamed from: a */
    private static List<Size> m36060a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new Size(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size next : supportedPreviewSizes) {
            arrayList.add(new Size(next.width, next.height));
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m36064b() {
        int i;
        int rotation = this.f48022i.getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (this.f48016c.facing == 1) {
            i = (360 - ((this.f48016c.orientation + i2) % 360)) % 360;
        } else {
            i = ((this.f48016c.orientation - i2) + 360) % 360;
        }
        SystemUtils.log(4, f48014a, "Camera Display Orientation: " + i, (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 380);
        return i;
    }

    /* renamed from: a */
    private void m36062a(int i) {
        this.f48015b.setDisplayOrientation(i);
    }

    /* renamed from: c */
    private void m36065c() {
        try {
            int b = m36064b();
            this.f48025l = b;
            m36062a(b);
        } catch (Exception unused) {
            SystemUtils.log(5, f48014a, "Failed to set rotation.", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 393);
        }
        try {
            m36063a(false);
        } catch (Exception unused2) {
            try {
                m36063a(true);
            } catch (Exception unused3) {
                SystemUtils.log(5, f48014a, "Camera rejected even safe-mode parameters! No configuration", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 403);
            }
        }
        Camera.Size previewSize = this.f48015b.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f48024k = this.f48023j;
        } else {
            this.f48024k = new Size(previewSize.width, previewSize.height);
        }
        this.f48029p.setResolution(this.f48024k);
    }

    public boolean isOpen() {
        return this.f48015b != null;
    }

    public Size getNaturalPreviewSize() {
        return this.f48024k;
    }

    public Size getPreviewSize() {
        if (this.f48024k == null) {
            return null;
        }
        if (isCameraRotated()) {
            return this.f48024k.rotate();
        }
        return this.f48024k;
    }

    public void requestPreviewFrame(PreviewCallback previewCallback) {
        Camera camera = this.f48015b;
        if (camera != null && this.f48019f) {
            try {
                this.f48029p.setCallback(previewCallback);
                if (previewCallback == null || !previewCallback.oneShot()) {
                    camera.setPreviewCallback(this.f48029p);
                } else {
                    camera.setOneShotPreviewCallback(this.f48029p);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public CameraSettings getCameraSettings() {
        return this.f48021h;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f48021h = cameraSettings;
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.f48022i;
    }

    public void setDisplayConfiguration(DisplayConfiguration displayConfiguration) {
        this.f48022i = displayConfiguration;
    }

    public void setTorchListener(TorchListener torchListener) {
        this.f48027n = torchListener;
    }

    public void setTorch(boolean z) {
        if (this.f48015b != null) {
            try {
                if (z != isTorchOn()) {
                    if (this.f48027n != null) {
                        if (z) {
                            this.f48027n.onTorchOn();
                        } else {
                            this.f48027n.onTorchOff();
                        }
                    }
                    if (this.f48017d != null) {
                        this.f48017d.stop();
                    }
                    Camera.Parameters parameters = this.f48015b.getParameters();
                    CameraConfigurationUtils.setTorch(parameters, z);
                    if (this.f48021h.isExposureEnabled()) {
                        CameraConfigurationUtils.setBestExposure(parameters, z);
                    }
                    this.f48015b.setParameters(parameters);
                    if (this.f48017d != null) {
                        this.f48017d.start();
                    }
                }
            } catch (RuntimeException e) {
                SystemUtils.log(6, f48014a, "Failed to set torch", e, "com.didi.zxing.barcodescanner.camera.CameraManager", 519);
            }
        }
    }

    public boolean isTorchOn() {
        Camera.Parameters parameters = this.f48015b.getParameters();
        if (parameters == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    public Camera getCamera() {
        return this.f48015b;
    }

    public void removePreviewCallBack() {
        this.f48029p.setCallback((PreviewCallback) null);
    }

    public void addPreviewCallback(PreviewCallback previewCallback) {
        this.f48028o.add(previewCallback);
    }

    public void removePreviewCallback(PreviewCallback previewCallback) {
        this.f48028o.remove(previewCallback);
    }
}
