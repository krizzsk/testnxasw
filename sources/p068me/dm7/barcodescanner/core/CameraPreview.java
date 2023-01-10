package p068me.dm7.barcodescanner.core;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

/* renamed from: me.dm7.barcodescanner.core.CameraPreview */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: b */
    private static final String f6593b = "CameraPreview";

    /* renamed from: a */
    Camera.AutoFocusCallback f6594a = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
            CameraPreview.this.m6422a();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraWrapper f6595c;

    /* renamed from: d */
    private Handler f6596d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6597e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6598f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f6599g = false;

    /* renamed from: h */
    private boolean f6600h = true;

    /* renamed from: i */
    private Camera.PreviewCallback f6601i;

    /* renamed from: j */
    private float f6602j = 0.1f;

    /* renamed from: k */
    private Runnable f6603k = new Runnable() {
        public void run() {
            if (CameraPreview.this.f6595c != null && CameraPreview.this.f6597e && CameraPreview.this.f6598f && CameraPreview.this.f6599g) {
                CameraPreview.this.safeAutoFocus();
            }
        }
    };

    public CameraPreview(Context context, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context);
        init(cameraWrapper, previewCallback);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        super(context, attributeSet);
        init(cameraWrapper, previewCallback);
    }

    public void init(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        setCamera(cameraWrapper, previewCallback);
        this.f6596d = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void setCamera(CameraWrapper cameraWrapper, Camera.PreviewCallback previewCallback) {
        this.f6595c = cameraWrapper;
        this.f6601i = previewCallback;
    }

    public void setShouldScaleToFill(boolean z) {
        this.f6600h = z;
    }

    public void setAspectTolerance(float f) {
        this.f6602j = f;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f6599g = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder.getSurface() != null) {
            stopCameraPreview();
            showCameraPreview();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f6599g = false;
        stopCameraPreview();
    }

    public void showCameraPreview() {
        if (this.f6595c != null) {
            try {
                getHolder().addCallback(this);
                this.f6597e = true;
                setupCameraParameters();
                this.f6595c.mCamera.setPreviewDisplay(getHolder());
                this.f6595c.mCamera.setDisplayOrientation(getDisplayOrientation());
                this.f6595c.mCamera.setOneShotPreviewCallback(this.f6601i);
                this.f6595c.mCamera.startPreview();
                if (!this.f6598f) {
                    return;
                }
                if (this.f6599g) {
                    safeAutoFocus();
                } else {
                    m6422a();
                }
            } catch (Exception e) {
                Exception exc = e;
                SystemUtils.log(6, f6593b, exc.toString(), exc, "me.dm7.barcodescanner.core.CameraPreview", 100);
            }
        }
    }

    public void safeAutoFocus() {
        try {
            this.f6595c.mCamera.autoFocus(this.f6594a);
        } catch (RuntimeException unused) {
            m6422a();
        }
    }

    public void stopCameraPreview() {
        if (this.f6595c != null) {
            try {
                this.f6597e = false;
                getHolder().removeCallback(this);
                this.f6595c.mCamera.cancelAutoFocus();
                this.f6595c.mCamera.setOneShotPreviewCallback((Camera.PreviewCallback) null);
                this.f6595c.mCamera.stopPreview();
            } catch (Exception e) {
                Exception exc = e;
                SystemUtils.log(6, f6593b, exc.toString(), exc, "me.dm7.barcodescanner.core.CameraPreview", 124);
            }
        }
    }

    public void setupCameraParameters() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.f6595c.mCamera.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.f6595c.mCamera.setParameters(parameters);
        m6424a(optimalPreviewSize);
    }

    /* renamed from: a */
    private void m6424a(Camera.Size size) {
        Point a = m6420a(new Point(getWidth(), getHeight()));
        float f = ((float) size.width) / ((float) size.height);
        if (((float) a.x) / ((float) a.y) > f) {
            m6423a((int) (((float) a.y) * f), a.y);
        } else {
            m6423a(a.x, (int) (((float) a.x) / f));
        }
    }

    /* renamed from: a */
    private Point m6420a(Point point) {
        if (getDisplayOrientation() % 180 == 0) {
            return point;
        }
        return new Point(point.y, point.x);
    }

    /* renamed from: a */
    private void m6423a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % 180 != 0) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        if (this.f6600h) {
            float f = (float) i;
            float width = ((float) ((View) getParent()).getWidth()) / f;
            float f2 = (float) i2;
            float height = ((float) ((View) getParent()).getHeight()) / f2;
            if (width <= height) {
                width = height;
            }
            i = Math.round(f * width);
            i2 = Math.round(f2 * width);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.f6595c == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        if (this.f6595c.mCameraId == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(this.f6595c.mCameraId, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
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

    private Camera.Size getOptimalPreviewSize() {
        CameraWrapper cameraWrapper = this.f6595c;
        Camera.Size size = null;
        if (cameraWrapper == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = cameraWrapper.mCamera.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (DisplayUtils.getScreenOrientation(getContext()) == 1) {
            int i = height;
            height = width;
            width = i;
        }
        double d = ((double) width) / ((double) height);
        if (supportedPreviewSizes == null) {
            return null;
        }
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size next : supportedPreviewSizes) {
            if (Math.abs((((double) next.width) / ((double) next.height)) - d) <= ((double) this.f6602j) && ((double) Math.abs(next.height - height)) < d3) {
                d3 = (double) Math.abs(next.height - height);
                size = next;
            }
        }
        if (size == null) {
            for (Camera.Size next2 : supportedPreviewSizes) {
                if (((double) Math.abs(next2.height - height)) < d2) {
                    size = next2;
                    d2 = (double) Math.abs(next2.height - height);
                }
            }
        }
        return size;
    }

    public void setAutoFocus(boolean z) {
        if (this.f6595c != null && this.f6597e && z != this.f6598f) {
            this.f6598f = z;
            if (!z) {
                SystemUtils.log(2, f6593b, "Cancelling autofocus", (Throwable) null, "me.dm7.barcodescanner.core.CameraPreview", 288);
                this.f6595c.mCamera.cancelAutoFocus();
            } else if (this.f6599g) {
                SystemUtils.log(2, f6593b, "Starting autofocus", (Throwable) null, "me.dm7.barcodescanner.core.CameraPreview", 282);
                safeAutoFocus();
            } else {
                m6422a();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6422a() {
        this.f6596d.postDelayed(this.f6603k, 1000);
    }
}
