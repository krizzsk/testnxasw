package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.exifinterface.media.ExifInterface;
import com.iproov.sdk.cameray.C20755case;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.core.C20882import;
import com.iproov.sdk.core.C20893while;
import com.iproov.sdk.logging.IPLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p235do.C21820break;
import p235do.C21823else;
import p235do.C21824for;
import p235do.C21825goto;
import p235do.C21827new;
import p235do.C21828this;
import p235do.C21829try;

/* renamed from: com.iproov.sdk.cameray.do */
/* compiled from: Camera1 */
public class C20760do implements C20776try {

    /* renamed from: a */
    private static final String f56863a = ("🎥1 " + C20760do.class.getSimpleName());

    /* renamed from: b */
    private static final Rect f56864b = new Rect(-200, -200, 200, 200);

    /* renamed from: c */
    private final int f56865c;

    /* renamed from: class  reason: not valid java name */
    protected SurfaceTexture f62349class;

    /* renamed from: const  reason: not valid java name */
    protected C21820break f62350const;

    /* renamed from: d */
    private final C20776try.C20777do f56866d;

    /* renamed from: e */
    private final Camera.PreviewCallback f56867e;

    /* renamed from: f */
    private final C20761do f56868f;

    /* renamed from: g */
    private final C21829try f56869g;

    /* renamed from: h */
    private final C21825goto f56870h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C20752break f56871i;

    /* renamed from: j */
    private final AtomicBoolean f56872j = new AtomicBoolean(false);

    /* renamed from: k */
    private volatile boolean f56873k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Camera f56874l;

    /* renamed from: m */
    private boolean f56875m;

    /* renamed from: n */
    private HandlerThread f56876n;

    /* renamed from: o */
    private Handler f56877o;

    /* renamed from: p */
    private Rect f56878p = f56864b;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public volatile Float f56879q;

    /* renamed from: throw  reason: not valid java name */
    protected final Camera.CameraInfo f62351throw;

    /* renamed from: com.iproov.sdk.cameray.do$do */
    /* compiled from: Camera1 */
    public class C20761do implements C21827new {

        /* renamed from: do */
        protected final Orientation f56880do;

        protected C20761do(Orientation orientation) {
            this.f56880do = orientation;
        }

        /* renamed from: do */
        public C20752break mo171310do() {
            return C20760do.this.f56871i;
        }

        /* renamed from: for  reason: not valid java name */
        public Float m48061for() {
            if (C20760do.this.f56874l == null) {
                return null;
            }
            return C20760do.this.f56879q;
        }

        /* renamed from: if */
        public C21820break mo171312if() {
            return new C21820break(C20760do.this.f62350const.mo180435if(), C20760do.this.f62350const.mo180432do());
        }

        /* renamed from: new  reason: not valid java name */
        public Orientation m48062new() {
            return this.f56880do;
        }
    }

    public C20760do(int i, C20752break breakR, C20776try.C20777do doVar, C21829try tryR, C21825goto gotoR) {
        this.f56865c = i;
        this.f56871i = breakR;
        this.f56866d = doVar;
        this.f56869g = tryR;
        this.f56870h = gotoR;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f62351throw = cameraInfo;
        Camera.getCameraInfo(i, cameraInfo);
        this.f56868f = new C20761do(Orientation.findByDegrees(cameraInfo.orientation));
        HandlerThread handlerThread = new HandlerThread("Camera1", -8);
        this.f56876n = handlerThread;
        handlerThread.start();
        this.f56877o = new Handler(this.f56876n.getLooper());
        this.f56867e = new Camera.PreviewCallback(doVar) {
            public final /* synthetic */ C20776try.C20777do f$1;

            {
                this.f$1 = r2;
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                C20760do.this.m42872a(this.f$1, bArr, camera);
            }
        };
    }

    /* renamed from: a */
    private List<C21820break> m42869a() {
        ArrayList arrayList = new ArrayList();
        Camera camera = this.f56874l;
        if (camera != null) {
            for (Camera.Size next : camera.getParameters().getSupportedPreviewSizes()) {
                arrayList.add(new C21820break(next.width, next.height));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int[] m42879b() {
        Camera camera = this.f56874l;
        if (camera == null) {
            return null;
        }
        try {
            for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
                if (next[1] >= 30000) {
                    return next;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m42881c() {
        if (this.f56874l == null || this.f56873k) {
            this.f56872j.set(false);
            this.f56873k = false;
            return;
        }
        try {
            this.f56866d.mo171343do();
            this.f56874l.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public final void onPictureTaken(byte[] bArr, Camera camera) {
                    C20760do.this.m42875a(bArr, camera);
                }
            });
        } catch (RuntimeException e) {
            try {
                this.f56866d.mo171344do(C20776try.C20778if.FAILED_TO_TAKE_PICTURE, e);
                m42878b(false);
                this.f56872j.set(false);
            } catch (RuntimeException e2) {
                this.f56866d.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "Failed to restart review after take picture failed", e2));
            }
        }
    }

    /* renamed from: new  reason: not valid java name */
    public C21827new m48058new() {
        return this.f56868f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: this  reason: not valid java name */
    public void m48059this() {
        Camera camera = this.f56874l;
        if (camera != null) {
            try {
                if (this.f56875m) {
                    camera.stopPreview();
                }
                this.f56874l.setPreviewTexture((SurfaceTexture) null);
                this.f56874l.setPreviewCallback((Camera.PreviewCallback) null);
            } catch (IOException | RuntimeException e) {
                this.f56866d.mo171344do(C20776try.C20778if.FAILED_TO_STOP_GRACEFULLY, e);
            } finally {
                this.f56874l.release();
                this.f56874l = null;
                this.f56876n.quit();
                this.f56876n = null;
                this.f56877o = null;
            }
        }
        this.f56875m = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: try  reason: not valid java name */
    public void m48060try() throws IOException {
        int i;
        Camera camera = this.f56874l;
        if (camera != null) {
            if (this.f62351throw.canDisableShutterSound) {
                camera.enableShutterSound(false);
            }
            Camera.Parameters parameters = this.f56874l.getParameters();
            this.f56879q = Float.valueOf(parameters.getFocalLength());
            parameters.setPreviewFormat(17);
            StringBuilder sb = new StringBuilder();
            sb.append("Zoom supported");
            sb.append(parameters.isZoomSupported());
            if (parameters.isZoomSupported() && (i = this.f56870h.mo171493do(C20759const.CAMERA1, Float.valueOf(this.f56874l.getParameters().getFocalLength()), parameters.getZoomRatios())) != -1) {
                parameters.setZoom(i);
            }
            this.f56874l.setParameters(parameters);
            C21820break breakR = this.f56869g.mo171472do(C20759const.CAMERA1, m42869a());
            this.f62350const = breakR;
            if (breakR != null) {
                parameters.setPreviewSize(breakR.mo180435if(), this.f62350const.mo180432do());
                this.f56874l.setPreviewTexture(this.f62349class);
                int[] b = m42879b();
                if (b != null) {
                    parameters.setPreviewFpsRange(b[0], b[1]);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Applying Preview Size: ");
                    sb2.append(this.f62350const.mo180435if());
                    sb2.append("x");
                    sb2.append(this.f62350const.mo180432do());
                    sb2.append(" @ ");
                    sb2.append(b[1] / 1000);
                    sb2.append("fps");
                }
                m42876a(parameters);
                this.f56874l.setParameters(parameters);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42871a(SurfaceTexture surfaceTexture) {
        this.f62349class = surfaceTexture;
        if (this.f56874l == null) {
            try {
                this.f56874l = Camera.open(this.f56865c);
                m48060try();
                if (this.f62350const == null) {
                    m48059this();
                    this.f56866d.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "No preview size available!"));
                    return;
                }
                C20893while.m43453do(C20882import.AND2);
                this.f56874l.setPreviewCallback(this.f56867e);
                m42878b(true);
            } catch (IOException | RuntimeException e) {
                m48059this();
                this.f56866d.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "Failed to open camera", e));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42872a(C20776try.C20777do doVar, byte[] bArr, Camera camera) {
        if (camera != null && bArr != null && bArr.length != 0) {
            try {
                C20775throw throwR = new C20775throw(this.f62350const.mo180435if(), this.f62350const.mo180432do(), bArr);
                C20893while.m43453do(C20882import.AND3);
                C20893while.m43453do(C20882import.AND14);
                mo171302do((C21824for) throwR);
            } catch (Exception e) {
                String str = f56863a;
                IPLog.m43490e(str, "Corrupt frame? " + e.toString());
                e.printStackTrace();
                doVar.mo171345do((C21824for) null);
            }
        }
    }

    /* renamed from: b */
    private void m42878b(boolean z) {
        Camera camera = this.f56874l;
        if (camera != null) {
            try {
                camera.setPreviewTexture(this.f62349class);
                this.f56874l.setPreviewCallback(this.f56867e);
                this.f56874l.startPreview();
                this.f56875m = true;
                if (z) {
                    this.f56866d.mo171346do(m48058new());
                }
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m48057for() {
        this.f56873k = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42882c(boolean z) {
        Camera camera = this.f56874l;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setAutoExposureLock(z);
                parameters.setAutoWhiteBalanceLock(z);
                this.f56874l.setParameters(parameters);
                this.f56866d.mo171349do(z);
            } catch (IllegalStateException e) {
                this.f56866d.mo171344do(C20776try.C20778if.FAILED_TO_LOCK_EXPOSURE, e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public void mo171302do(C21824for forR) {
        this.f56866d.mo171345do(forR);
    }

    /* renamed from: do */
    public void mo171301do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f56877o;
        if (handler != null) {
            handler.post(new Runnable(surfaceTexture) {
                public final /* synthetic */ SurfaceTexture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20760do.this.m42871a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo171303do(Runnable runnable) {
        Handler handler = this.f56877o;
        if (handler != null) {
            handler.post(new Runnable(runnable) {
                public final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20760do.this.m42873a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo171304do(boolean z) {
        Handler handler = this.f56877o;
        if (handler != null) {
            handler.post(new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20760do.this.m42882c(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo171299do() {
        Handler handler;
        if (this.f56872j.compareAndSet(false, true) && this.f56874l != null && (handler = this.f56877o) != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    C20760do.this.m42881c();
                }
            }, 480);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42873a(Runnable runnable) {
        m48059this();
        runnable.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42875a(byte[] bArr, Camera camera) {
        try {
            this.f56866d.mo171347do(new C21828this(new ExifInterface((InputStream) new ByteArrayInputStream(bArr))));
            m42882c(true);
        } catch (IOException e) {
            this.f56866d.mo171344do(C20776try.C20778if.FAILED_TO_READ_EXIF_DATA, e);
        } finally {
            m42878b(false);
            this.f56872j.set(false);
        }
    }

    /* renamed from: if */
    public C20759const mo171306if() {
        return C20759const.CAMERA1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42870a(RectF rectF) {
        this.f56878p = C21823else.m45130do(rectF);
        Camera camera = this.f56874l;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (m42876a(parameters)) {
                this.f56874l.setParameters(parameters);
            }
        }
    }

    /* renamed from: do */
    public void mo171300do(RectF rectF) {
        Handler handler = this.f56877o;
        if (handler != null) {
            handler.post(new Runnable(rectF) {
                public final /* synthetic */ RectF f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20760do.this.m42870a(this.f$1);
                }
            });
        }
    }

    /* renamed from: a */
    private boolean m42876a(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(this.f56878p, 1000));
        parameters.setMeteringAreas(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("Set metering area (");
        sb.append(this.f56878p);
        sb.append(") OK");
        return true;
    }
}
