package p068me.dm7.barcodescanner.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import kotlinx.coroutines.DebugKt;

/* renamed from: me.dm7.barcodescanner.core.BarcodeScannerView */
public abstract class BarcodeScannerView extends FrameLayout implements Camera.PreviewCallback {

    /* renamed from: a */
    private CameraWrapper f6571a;

    /* renamed from: b */
    private CameraPreview f6572b;

    /* renamed from: c */
    private IViewFinder f6573c;

    /* renamed from: d */
    private Rect f6574d;

    /* renamed from: e */
    private CameraHandlerThread f6575e;

    /* renamed from: f */
    private Boolean f6576f;

    /* renamed from: g */
    private boolean f6577g = true;

    /* renamed from: h */
    private boolean f6578h = true;

    /* renamed from: i */
    private boolean f6579i = true;

    /* renamed from: j */
    private int f6580j = getResources().getColor(R.color.viewfinder_laser);

    /* renamed from: k */
    private int f6581k = getResources().getColor(R.color.viewfinder_border);

    /* renamed from: l */
    private int f6582l = getResources().getColor(R.color.viewfinder_mask);

    /* renamed from: m */
    private int f6583m = getResources().getInteger(R.integer.viewfinder_border_width);

    /* renamed from: n */
    private int f6584n = getResources().getInteger(R.integer.viewfinder_border_length);

    /* renamed from: o */
    private boolean f6585o = false;

    /* renamed from: p */
    private int f6586p = 0;

    /* renamed from: q */
    private boolean f6587q = false;

    /* renamed from: r */
    private float f6588r = 1.0f;

    /* renamed from: s */
    private int f6589s = 0;

    /* renamed from: t */
    private float f6590t = 0.1f;

    public BarcodeScannerView(Context context) {
        super(context);
        m6418a();
    }

    /* JADX INFO: finally extract failed */
    public BarcodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.BarcodeScannerView, 0, 0);
        try {
            setShouldScaleToFill(obtainStyledAttributes.getBoolean(10, true));
            this.f6579i = obtainStyledAttributes.getBoolean(7, this.f6579i);
            this.f6580j = obtainStyledAttributes.getColor(6, this.f6580j);
            this.f6581k = obtainStyledAttributes.getColor(1, this.f6581k);
            this.f6582l = obtainStyledAttributes.getColor(8, this.f6582l);
            this.f6583m = obtainStyledAttributes.getDimensionPixelSize(3, this.f6583m);
            this.f6584n = obtainStyledAttributes.getDimensionPixelSize(2, this.f6584n);
            this.f6585o = obtainStyledAttributes.getBoolean(9, this.f6585o);
            this.f6586p = obtainStyledAttributes.getDimensionPixelSize(4, this.f6586p);
            this.f6587q = obtainStyledAttributes.getBoolean(11, this.f6587q);
            this.f6588r = obtainStyledAttributes.getFloat(0, this.f6588r);
            this.f6589s = obtainStyledAttributes.getDimensionPixelSize(5, this.f6589s);
            obtainStyledAttributes.recycle();
            m6418a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private void m6418a() {
        this.f6573c = createViewFinderView(getContext());
    }

    public final void setupLayout(CameraWrapper cameraWrapper) {
        removeAllViews();
        CameraPreview cameraPreview = new CameraPreview(getContext(), cameraWrapper, this);
        this.f6572b = cameraPreview;
        cameraPreview.setAspectTolerance(this.f6590t);
        this.f6572b.setShouldScaleToFill(this.f6578h);
        if (!this.f6578h) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setGravity(17);
            relativeLayout.setBackgroundColor(-16777216);
            relativeLayout.addView(this.f6572b);
            addView(relativeLayout);
        } else {
            addView(this.f6572b);
        }
        IViewFinder iViewFinder = this.f6573c;
        if (iViewFinder instanceof View) {
            addView((View) iViewFinder);
            return;
        }
        throw new IllegalArgumentException("IViewFinder object returned by 'createViewFinderView()' should be instance of android.view.View");
    }

    /* access modifiers changed from: protected */
    public IViewFinder createViewFinderView(Context context) {
        ViewFinderView viewFinderView = new ViewFinderView(context);
        viewFinderView.setBorderColor(this.f6581k);
        viewFinderView.setLaserColor(this.f6580j);
        viewFinderView.setLaserEnabled(this.f6579i);
        viewFinderView.setBorderStrokeWidth(this.f6583m);
        viewFinderView.setBorderLineLength(this.f6584n);
        viewFinderView.setMaskColor(this.f6582l);
        viewFinderView.setBorderCornerRounded(this.f6585o);
        viewFinderView.setBorderCornerRadius(this.f6586p);
        viewFinderView.setSquareViewFinder(this.f6587q);
        viewFinderView.setViewFinderOffset(this.f6589s);
        return viewFinderView;
    }

    public void setLaserColor(int i) {
        this.f6580j = i;
        this.f6573c.setLaserColor(i);
        this.f6573c.setupViewFinder();
    }

    public void setMaskColor(int i) {
        this.f6582l = i;
        this.f6573c.setMaskColor(i);
        this.f6573c.setupViewFinder();
    }

    public void setBorderColor(int i) {
        this.f6581k = i;
        this.f6573c.setBorderColor(i);
        this.f6573c.setupViewFinder();
    }

    public void setBorderStrokeWidth(int i) {
        this.f6583m = i;
        this.f6573c.setBorderStrokeWidth(i);
        this.f6573c.setupViewFinder();
    }

    public void setBorderLineLength(int i) {
        this.f6584n = i;
        this.f6573c.setBorderLineLength(i);
        this.f6573c.setupViewFinder();
    }

    public void setLaserEnabled(boolean z) {
        this.f6579i = z;
        this.f6573c.setLaserEnabled(z);
        this.f6573c.setupViewFinder();
    }

    public void setIsBorderCornerRounded(boolean z) {
        this.f6585o = z;
        this.f6573c.setBorderCornerRounded(z);
        this.f6573c.setupViewFinder();
    }

    public void setBorderCornerRadius(int i) {
        this.f6586p = i;
        this.f6573c.setBorderCornerRadius(i);
        this.f6573c.setupViewFinder();
    }

    public void setSquareViewFinder(boolean z) {
        this.f6587q = z;
        this.f6573c.setSquareViewFinder(z);
        this.f6573c.setupViewFinder();
    }

    public void setBorderAlpha(float f) {
        this.f6588r = f;
        this.f6573c.setBorderAlpha(f);
        this.f6573c.setupViewFinder();
    }

    public void startCamera(int i) {
        if (this.f6575e == null) {
            this.f6575e = new CameraHandlerThread(this);
        }
        this.f6575e.startCamera(i);
    }

    public void setupCameraPreview(CameraWrapper cameraWrapper) {
        this.f6571a = cameraWrapper;
        if (cameraWrapper != null) {
            setupLayout(cameraWrapper);
            this.f6573c.setupViewFinder();
            Boolean bool = this.f6576f;
            if (bool != null) {
                setFlash(bool.booleanValue());
            }
            setAutoFocus(this.f6577g);
        }
    }

    public void startCamera() {
        startCamera(CameraUtils.getDefaultCameraId());
    }

    public void stopCamera() {
        if (this.f6571a != null) {
            this.f6572b.stopCameraPreview();
            this.f6572b.setCamera((CameraWrapper) null, (Camera.PreviewCallback) null);
            this.f6571a.mCamera.release();
            this.f6571a = null;
        }
        CameraHandlerThread cameraHandlerThread = this.f6575e;
        if (cameraHandlerThread != null) {
            cameraHandlerThread.quit();
            this.f6575e = null;
        }
    }

    public void stopCameraPreview() {
        CameraPreview cameraPreview = this.f6572b;
        if (cameraPreview != null) {
            cameraPreview.stopCameraPreview();
        }
    }

    /* access modifiers changed from: protected */
    public void resumeCameraPreview() {
        CameraPreview cameraPreview = this.f6572b;
        if (cameraPreview != null) {
            cameraPreview.showCameraPreview();
        }
    }

    public synchronized Rect getFramingRectInPreview(int i, int i2) {
        if (this.f6574d == null) {
            Rect framingRect = this.f6573c.getFramingRect();
            int width = this.f6573c.getWidth();
            int height = this.f6573c.getHeight();
            if (!(framingRect == null || width == 0)) {
                if (height != 0) {
                    Rect rect = new Rect(framingRect);
                    if (i < width) {
                        rect.left = (rect.left * i) / width;
                        rect.right = (rect.right * i) / width;
                    }
                    if (i2 < height) {
                        rect.top = (rect.top * i2) / height;
                        rect.bottom = (rect.bottom * i2) / height;
                    }
                    this.f6574d = rect;
                }
            }
            return null;
        }
        return this.f6574d;
    }

    public void setFlash(boolean z) {
        this.f6576f = Boolean.valueOf(z);
        CameraWrapper cameraWrapper = this.f6571a;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.f6571a.mCamera.getParameters();
            if (z) {
                if (!parameters.getFlashMode().equals("torch")) {
                    parameters.setFlashMode("torch");
                } else {
                    return;
                }
            } else if (!parameters.getFlashMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                return;
            }
            this.f6571a.mCamera.setParameters(parameters);
        }
    }

    public boolean getFlash() {
        CameraWrapper cameraWrapper = this.f6571a;
        if (cameraWrapper == null || !CameraUtils.isFlashSupported(cameraWrapper.mCamera) || !this.f6571a.mCamera.getParameters().getFlashMode().equals("torch")) {
            return false;
        }
        return true;
    }

    public void toggleFlash() {
        CameraWrapper cameraWrapper = this.f6571a;
        if (cameraWrapper != null && CameraUtils.isFlashSupported(cameraWrapper.mCamera)) {
            Camera.Parameters parameters = this.f6571a.mCamera.getParameters();
            if (parameters.getFlashMode().equals("torch")) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else {
                parameters.setFlashMode("torch");
            }
            this.f6571a.mCamera.setParameters(parameters);
        }
    }

    public void setAutoFocus(boolean z) {
        this.f6577g = z;
        CameraPreview cameraPreview = this.f6572b;
        if (cameraPreview != null) {
            cameraPreview.setAutoFocus(z);
        }
    }

    public void setShouldScaleToFill(boolean z) {
        this.f6578h = z;
    }

    public void setAspectTolerance(float f) {
        this.f6590t = f;
    }

    public byte[] getRotatedData(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        int i = previewSize.width;
        int i2 = previewSize.height;
        int rotationCount = getRotationCount();
        if (rotationCount == 1 || rotationCount == 3) {
            int i3 = 0;
            while (i3 < rotationCount) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i4 = 0; i4 < i2; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                    }
                }
                i3++;
                bArr = bArr2;
                int i6 = i;
                i = i2;
                i2 = i6;
            }
        }
        return bArr;
    }

    public int getRotationCount() {
        return this.f6572b.getDisplayOrientation() / 90;
    }
}
