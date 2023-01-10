package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.bike.utils.SystemUtil;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.camera.CameraSurface;
import com.didi.zxing.barcodescanner.camera.CenterCropStrategy;
import com.didi.zxing.barcodescanner.camera.DisplayConfiguration;
import com.didi.zxing.barcodescanner.camera.FitCenterStrategy;
import com.didi.zxing.barcodescanner.camera.FitXYStrategy;
import com.didi.zxing.barcodescanner.camera.PreviewCallback;
import com.didi.zxing.barcodescanner.camera.PreviewScalingStrategy;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CameraPreview extends ViewGroup {

    /* renamed from: a */
    private static final String f47874a = "CameraPreview";

    /* renamed from: i */
    private static final int f47875i = 250;

    /* renamed from: A */
    private final Handler.Callback f47876A = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == R.id.zxing_prewiew_size_ready) {
                SystemUtils.log(3, CameraPreview.f47874a, "zxing_prewiew_size_ready", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview$3", 213);
                CameraPreview.this.m35974b((Size) message.obj);
                return true;
            } else if (message.what == R.id.zxing_camera_error) {
                Exception exc = (Exception) message.obj;
                if (!CameraPreview.this.isActive()) {
                    return false;
                }
                CameraPreview.this.pause();
                CameraPreview.this.f47878C.cameraError(exc);
                return false;
            } else if (message.what != R.id.zxing_camera_closed) {
                return false;
            } else {
                CameraPreview.this.f47878C.cameraClosed();
                return false;
            }
        }
    };

    /* renamed from: B */
    private RotationCallback f47877B = new RotationCallback() {
        public void onRotationChanged(int i) {
            CameraPreview.this.f47881c.postDelayed(new Runnable() {
                public void run() {
                    CameraPreview.this.m35971b();
                }
            }, 250);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final StateListener f47878C = new StateListener() {
        public void previewSized() {
            for (StateListener previewSized : CameraPreview.this.f47887j) {
                previewSized.previewSized();
            }
        }

        public void previewStarted() {
            for (StateListener previewStarted : CameraPreview.this.f47887j) {
                previewStarted.previewStarted();
            }
        }

        public void previewStopped() {
            for (StateListener previewStopped : CameraPreview.this.f47887j) {
                previewStopped.previewStopped();
            }
        }

        public void cameraError(Exception exc) {
            for (StateListener cameraError : CameraPreview.this.f47887j) {
                cameraError.cameraError(exc);
            }
        }

        public void cameraClosed() {
            for (StateListener cameraClosed : CameraPreview.this.f47887j) {
                cameraClosed.cameraClosed();
            }
        }
    };

    /* renamed from: D */
    private PreviewCallback f47879D = new PreviewCallback() {
        long count;

        public void onPreviewError(Exception exc) {
        }

        public boolean oneShot() {
            return false;
        }

        public void onPreview(SourceData sourceData) {
            if (CameraPreview.this.f47902y != null && this.count % ((long) CameraPreview.this.f47902y.frequency()) == 0) {
                CameraPreview.this.f47902y.onLumChange(sourceData.getAverageLum(64));
            }
            this.count++;
        }
    };

    /* renamed from: b */
    private WindowManager f47880b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f47881c;
    protected CameraInstance cameraInstance;

    /* renamed from: d */
    private boolean f47882d = false;

    /* renamed from: e */
    private SurfaceView f47883e;

    /* renamed from: f */
    private TextureView f47884f;

    /* renamed from: g */
    private RotationListener f47885g;

    /* renamed from: h */
    private int f47886h = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<StateListener> f47887j = new ArrayList();

    /* renamed from: k */
    private DisplayConfiguration f47888k;

    /* renamed from: l */
    private CameraSettings f47889l = new CameraSettings();

    /* renamed from: m */
    private Size f47890m;

    /* renamed from: n */
    private Size f47891n;

    /* renamed from: o */
    private Rect f47892o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Size f47893p;
    protected boolean previewActive = false;

    /* renamed from: q */
    private Rect f47894q = null;

    /* renamed from: r */
    private Rect f47895r = null;

    /* renamed from: s */
    private Size f47896s = null;

    /* renamed from: t */
    private double f47897t = 0.06d;

    /* renamed from: u */
    private PreviewScalingStrategy f47898u = null;

    /* renamed from: v */
    private boolean f47899v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f47900w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f47901x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public LumListener f47902y;

    /* renamed from: z */
    private final SurfaceHolder.Callback f47903z = new SurfaceHolder.Callback() {
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Size unused = CameraPreview.this.f47893p = null;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                SystemUtils.log(6, CameraPreview.f47874a, "*** WARNING *** surfaceChanged() gave us a null surface!", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview$2", 200);
                return;
            }
            Size unused = CameraPreview.this.f47893p = new Size(i2, i3);
            CameraPreview.this.m35981e();
        }
    };

    public interface StateListener {
        void cameraClosed();

        void cameraError(Exception exc);

        void previewSized();

        void previewStarted();

        void previewStopped();
    }

    /* access modifiers changed from: protected */
    public void previewStarted() {
    }

    /* renamed from: a */
    private TextureView.SurfaceTextureListener m35963a() {
        return new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Size unused = CameraPreview.this.f47893p = new Size(i, i2);
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.m35969a(cameraPreview.f47893p);
                CameraPreview.this.m35981e();
            }
        };
    }

    public CameraPreview(Context context) {
        super(context);
        m35966a(context, (AttributeSet) null, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35966a(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35966a(context, attributeSet, i, 0);
    }

    /* renamed from: a */
    private void m35966a(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(0);
        }
        initializeAttributes(attributeSet);
        this.f47880b = (WindowManager) context.getSystemService("window");
        this.f47881c = new Handler(this.f47876A);
        this.f47885g = new RotationListener();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m35976c();
    }

    /* access modifiers changed from: protected */
    public void initializeAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(1, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(0, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f47896s = new Size(dimension, dimension2);
        }
        DecodeConfig config = DecodeConfigUtil.getConfig();
        boolean useSurfaceView = config != null ? config.useSurfaceView() : false;
        String brand = SystemUtil.getBrand();
        if ((brand.toLowerCase().contains(Payload.SOURCE_HUAWEI) || brand.toLowerCase().contains("honor")) && useSurfaceView) {
            this.f47882d = false;
        } else {
            this.f47882d = obtainStyledAttributes.getBoolean(5, !useSurfaceView);
        }
        int integer = obtainStyledAttributes.getInteger(4, -1);
        if (integer == 1) {
            this.f47898u = new CenterCropStrategy();
        } else if (integer == 2) {
            this.f47898u = new FitCenterStrategy();
        } else if (integer == 3) {
            this.f47898u = new FitXYStrategy();
        }
        this.f47900w = (int) obtainStyledAttributes.getDimension(2, 0.0f);
        this.f47901x = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35971b() {
        if (isActive() && getDisplayRotation() != this.f47886h) {
            pause();
            resume();
        }
    }

    /* renamed from: c */
    private void m35976c() {
        if (!this.f47882d || Build.VERSION.SDK_INT < 14) {
            if (this.f47900w > 0) {
                this.f47883e = new RoundSurfaceView(getContext());
            } else {
                this.f47883e = new SurfaceView(getContext());
            }
            this.f47883e.setZOrderMediaOverlay(true);
            if (Build.VERSION.SDK_INT < 11) {
                this.f47883e.getHolder().setType(3);
            }
            this.f47883e.getHolder().addCallback(this.f47903z);
            addView(this.f47883e);
            return;
        }
        if (this.f47900w > 0) {
            this.f47884f = new RoundTextureView(getContext());
        } else {
            this.f47884f = new TextureView(getContext());
        }
        this.f47884f.setSurfaceTextureListener(m35963a());
        addView(this.f47884f);
    }

    public class RoundTextureView extends TextureView {
        private Path roundPath;

        public RoundTextureView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawColor(CameraPreview.this.f47901x);
                if (this.roundPath == null) {
                    this.roundPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                    this.roundPath.addRoundRect(rectF, new float[]{(float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
                CameraPreview.this.m35967a(canvas, this.roundPath, Region.Op.REPLACE);
            }
            super.dispatchDraw(canvas);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35967a(Canvas canvas, Path path, Region.Op op) {
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(path);
        } else {
            canvas.clipPath(path, op);
        }
    }

    public class RoundSurfaceView extends SurfaceView {
        private Path roundPath;

        public RoundSurfaceView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawColor(CameraPreview.this.f47901x);
                if (this.roundPath == null) {
                    this.roundPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                    this.roundPath.addRoundRect(rectF, new float[]{(float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, (float) CameraPreview.this.f47900w, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
                CameraPreview.this.m35967a(canvas, this.roundPath, Region.Op.REPLACE);
            }
            super.dispatchDraw(canvas);
        }
    }

    public void addStateListener(StateListener stateListener) {
        this.f47887j.add(stateListener);
    }

    /* renamed from: d */
    private void m35978d() {
        Size size;
        SystemUtils.log(3, f47874a, "calculateFrames", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 470);
        if (this.f47890m == null || (size = this.f47891n) == null || this.f47888k == null) {
            this.f47895r = null;
            this.f47894q = null;
            this.f47892o = null;
            SystemUtils.log(3, f47874a, "calculateFrames null", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 476);
            return;
        }
        int i = size.width;
        int i2 = this.f47891n.height;
        int i3 = this.f47890m.width;
        int i4 = this.f47890m.height;
        this.f47892o = this.f47888k.scalePreview(this.f47891n);
        SystemUtils.log(3, f47874a, "previewSize =" + this.f47891n.toString() + "  surfaceRect = " + this.f47892o.toString() + " containerSize = " + this.f47890m, (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 488);
        if (this.f47892o.height() == 0) {
            Message obtain = Message.obtain(this.f47881c, R.id.zxing_prewiew_size_ready);
            obtain.obj = this.f47891n;
            this.f47881c.sendMessageDelayed(obtain, 100);
            return;
        }
        new Rect(0, 0, i3, i4);
        this.f47894q = new Rect(this.f47892o);
        Rect rect = new Rect(this.f47894q);
        rect.offset(-this.f47892o.left, -this.f47892o.top);
        this.f47895r = new Rect((rect.left * i) / this.f47892o.width(), (rect.top * i2) / this.f47892o.height(), (rect.right * i) / this.f47892o.width(), (rect.bottom * i2) / this.f47892o.height());
        SystemUtils.log(3, f47874a, "calculateFrames previewFramingRect = " + this.f47895r.toString(), (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 505);
        if (this.f47895r.width() <= 0 || this.f47895r.height() <= 0) {
            this.f47895r = null;
            this.f47894q = null;
            SystemUtils.log(5, f47874a, "Preview frame is too small", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 509);
            return;
        }
        this.f47878C.previewSized();
    }

    public void setTorch(boolean z) {
        this.f47899v = z;
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null) {
            cameraInstance2.setTorch(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35969a(Size size) {
        this.f47890m = size;
        DisplayConfiguration displayConfiguration = this.f47888k;
        if (displayConfiguration != null) {
            displayConfiguration.setViewfinderSize(size);
        }
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null && cameraInstance2.getDisplayConfiguration() == null) {
            DisplayConfiguration displayConfiguration2 = new DisplayConfiguration(getDisplayRotation(), size);
            this.f47888k = displayConfiguration2;
            displayConfiguration2.setPreviewScalingStrategy(getPreviewScalingStrategy());
            this.cameraInstance.setDisplayConfiguration(this.f47888k);
            this.cameraInstance.configureCamera();
            boolean z = this.f47899v;
            if (z) {
                this.cameraInstance.setTorch(z);
            }
        }
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f47898u = previewScalingStrategy;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        PreviewScalingStrategy previewScalingStrategy = this.f47898u;
        if (previewScalingStrategy != null) {
            return previewScalingStrategy;
        }
        if (this.f47884f != null) {
            return new CenterCropStrategy();
        }
        return new FitCenterStrategy();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35974b(Size size) {
        this.f47891n = size;
        SystemUtils.log(3, f47874a, "previewSized", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 575);
        if (this.f47890m != null) {
            m35978d();
            requestLayout();
            m35981e();
        }
    }

    /* access modifiers changed from: protected */
    public Matrix calculateTextureTransform(Size size, Size size2) {
        float f;
        float f2 = ((float) size.width) / ((float) size.height);
        float f3 = ((float) size2.width) / ((float) size2.height);
        float f4 = 1.0f;
        if (f2 < f3) {
            f4 = f3 / f2;
            f = 1.0f;
        } else {
            f = f2 / f3;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f);
        matrix.postTranslate((((float) size.width) - (((float) size.width) * f4)) / 2.0f, (((float) size.height) - (((float) size.height) * f)) / 2.0f);
        return matrix;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m35981e() {
        Rect rect;
        Size size = this.f47893p;
        if (size != null && this.f47891n != null && (rect = this.f47892o) != null) {
            if (this.f47883e != null && size.equals(new Size(rect.width(), this.f47892o.height()))) {
                m35970a(new CameraSurface(this.f47883e.getHolder()));
            } else if (this.f47884f != null && Build.VERSION.SDK_INT >= 14 && this.f47884f.getSurfaceTexture() != null) {
                if (this.f47891n != null) {
                    this.f47884f.setTransform(calculateTextureTransform(new Size(this.f47884f.getWidth(), this.f47884f.getHeight()), this.f47891n));
                }
                m35970a(new CameraSurface(this.f47884f.getSurfaceTexture()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m35969a(new Size(i3 - i, i4 - i2));
        SurfaceView surfaceView = this.f47883e;
        if (surfaceView != null) {
            Rect rect = this.f47892o;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
            } else {
                surfaceView.layout(rect.left, this.f47892o.top, this.f47892o.right, this.f47892o.bottom);
            }
        } else if (this.f47884f != null && Build.VERSION.SDK_INT >= 14) {
            this.f47884f.layout(0, 0, getWidth(), getHeight());
        }
    }

    public Rect getFramingRect() {
        return this.f47894q;
    }

    public Rect getPreviewFramingRect() {
        return this.f47895r;
    }

    public CameraSettings getCameraSettings() {
        return this.f47889l;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f47889l = cameraSettings;
    }

    public void resume() {
        C15738Util.validateMainThread();
        SystemUtils.log(3, f47874a, "resume()", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 712);
        m35983f();
        if (this.f47893p != null) {
            m35981e();
        } else {
            SurfaceView surfaceView = this.f47883e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f47903z);
            } else if (this.f47884f != null && Build.VERSION.SDK_INT >= 14) {
                if (this.f47884f.isAvailable()) {
                    m35963a().onSurfaceTextureAvailable(this.f47884f.getSurfaceTexture(), this.f47884f.getWidth(), this.f47884f.getHeight());
                } else {
                    this.f47884f.setSurfaceTextureListener(m35963a());
                }
            }
        }
        requestLayout();
        this.f47885g.listen(getContext(), this.f47877B);
    }

    public void pause() {
        SurfaceView surfaceView;
        C15738Util.validateMainThread();
        SystemUtils.log(3, f47874a, "pause()", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 746);
        this.f47886h = -1;
        CameraInstance cameraInstance2 = this.cameraInstance;
        if (cameraInstance2 != null) {
            cameraInstance2.close();
            this.cameraInstance = null;
            this.previewActive = false;
        } else {
            this.f47881c.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.f47893p == null && (surfaceView = this.f47883e) != null) {
            surfaceView.getHolder().removeCallback(this.f47903z);
        }
        if (this.f47893p == null && this.f47884f != null && Build.VERSION.SDK_INT >= 14) {
            this.f47884f.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        }
        this.f47890m = null;
        this.f47891n = null;
        this.f47895r = null;
        this.f47885g.stop();
        this.f47878C.previewStopped();
    }

    public void pauseAndWait() {
        CameraInstance cameraInstance2 = getCameraInstance();
        pause();
        long nanoTime = System.nanoTime();
        while (cameraInstance2 != null && !cameraInstance2.isCameraClosed() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public Size getFramingRectSize() {
        return this.f47896s;
    }

    public void setFramingRectSize(Size size) {
        this.f47896s = size;
    }

    public double getMarginFraction() {
        return this.f47897t;
    }

    public void setMarginFraction(double d) {
        if (d < 0.5d) {
            this.f47897t = d;
            return;
        }
        throw new IllegalArgumentException("The margin fraction must be less than 0.5");
    }

    public boolean isUseTextureView() {
        return this.f47882d;
    }

    public void setUseTextureView(boolean z) {
        this.f47882d = z;
    }

    /* access modifiers changed from: protected */
    public boolean isActive() {
        return this.cameraInstance != null;
    }

    private int getDisplayRotation() {
        return this.f47880b.getDefaultDisplay().getRotation();
    }

    /* renamed from: f */
    private void m35983f() {
        int i;
        if (this.cameraInstance != null) {
            SystemUtils.log(5, f47874a, "initCamera called twice", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 854);
            return;
        }
        this.cameraInstance = createCameraInstance();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if (config != null && config.useContinousFocusMode() && (i = Calendar.getInstance().get(11)) >= config.useContinousFocusModeStartTime() && i < config.useContinousFocusModeEndTime()) {
            this.cameraInstance.getCameraSettings().setFocusMode(CameraSettings.FocusMode.CONTINUOUS);
        }
        this.cameraInstance.setReadyHandler(this.f47881c);
        this.cameraInstance.open();
        this.f47886h = getDisplayRotation();
        this.cameraInstance.getCameraManager().addPreviewCallback(this.f47879D);
    }

    /* access modifiers changed from: protected */
    public CameraInstance createCameraInstance() {
        CameraInstance cameraInstance2 = new CameraInstance(getContext());
        cameraInstance2.setCameraSettings(this.f47889l);
        return cameraInstance2;
    }

    /* renamed from: a */
    private void m35970a(CameraSurface cameraSurface) {
        if (!this.previewActive && this.cameraInstance != null) {
            SystemUtils.log(4, f47874a, "Starting preview", (Throwable) null, "com.didi.zxing.barcodescanner.CameraPreview", 892);
            this.cameraInstance.setSurface(cameraSurface);
            this.cameraInstance.startPreview();
            this.previewActive = true;
            previewStarted();
            this.f47878C.previewStarted();
        }
    }

    public CameraInstance getCameraInstance() {
        return this.cameraInstance;
    }

    public boolean isPreviewActive() {
        return this.previewActive;
    }

    /* access modifiers changed from: protected */
    public Rect calculateFramingRect(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f47896s != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f47896s.width) / 2), Math.max(0, (rect3.height() - this.f47896s.height) / 2));
            return rect3;
        }
        int min = (int) Math.min(((double) rect3.width()) * this.f47897t, ((double) rect3.height()) * this.f47897t);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f47899v);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public boolean isCameraClosed() {
        CameraInstance cameraInstance2 = this.cameraInstance;
        return cameraInstance2 == null || cameraInstance2.isCameraClosed();
    }

    public boolean isTorchOn() {
        return this.f47899v;
    }

    public void setLumListener(LumListener lumListener) {
        this.f47902y = lumListener;
    }
}
