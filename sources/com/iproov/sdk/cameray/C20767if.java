package com.iproov.sdk.cameray;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.iproov.sdk.cameray.C20755case;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.core.C20882import;
import com.iproov.sdk.core.C20893while;
import com.iproov.sdk.logging.IPLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import p235do.C21823else;
import p235do.C21824for;
import p235do.C21825goto;
import p235do.C21827new;
import p235do.C21828this;
import p235do.C21829try;

/* renamed from: com.iproov.sdk.cameray.if */
/* compiled from: Camera2 */
public class C20767if implements C20776try {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f56891b = ("🎥2 " + C20767if.class.getSimpleName());

    /* renamed from: c */
    private static final RectF f56892c = new RectF(0.4f, 0.4f, 0.6f, 0.6f);

    /* renamed from: a */
    List<Surface> f56893a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Semaphore f56894d = new Semaphore(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C21825goto f56895e;

    /* renamed from: else  reason: not valid java name */
    protected final Surface f62353else;

    /* renamed from: f */
    private final ImageReader f56896f;

    /* renamed from: for  reason: not valid java name */
    protected final CameraManager f62354for;

    /* renamed from: g */
    private HandlerThread f56897g;

    /* renamed from: goto  reason: not valid java name */
    protected Surface f62355goto;

    /* renamed from: h */
    private HandlerThread f56898h;

    /* renamed from: i */
    private Handler f56899i;

    /* renamed from: if */
    protected final C20776try.C20777do f56900if;

    /* renamed from: j */
    private Handler f56901j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CameraDevice f56902k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f56903l = new Object();

    /* renamed from: m */
    private C20751b f56904m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CameraCaptureSession f56905n;

    /* renamed from: new  reason: not valid java name */
    protected final C20764for f62356new;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RectF f56906o = f56892c;

    /* renamed from: p */
    private final CameraDevice.StateCallback f56907p = new C20769for();

    /* renamed from: q */
    private CameraCaptureSession.CaptureCallback f56908q = new C20768do();

    /* renamed from: com.iproov.sdk.cameray.if$do */
    /* compiled from: Camera2 */
    class C20768do extends CameraCaptureSession.CaptureCallback {
        C20768do() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            C20767if.this.f56900if.mo171347do(new C21828this(totalCaptureResult));
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$for */
    /* compiled from: Camera2 */
    public class C20769for extends CameraDevice.StateCallback {
        public C20769for() {
        }

        public void onClosed(CameraDevice cameraDevice) {
            C20767if.this.f56894d.release();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            C20767if.this.m42922b();
            C20767if.this.f56900if.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "error camera disconnected"));
        }

        public void onError(CameraDevice cameraDevice, int i) {
            C20767if.this.m42922b();
            C20776try.C20777do doVar = C20767if.this.f56900if;
            C20755case.C20756do doVar2 = C20755case.C20756do.CAMERA_ERROR;
            doVar.mo171348do((Exception) new C20755case(doVar2, "error in camera: " + i));
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = C20767if.this.f56902k = cameraDevice;
            C20767if.this.f56894d.release();
            C20893while.m43453do(C20882import.AND2);
            try {
                C20767if ifVar = C20767if.this;
                C20767if ifVar2 = C20767if.this;
                ifVar.m42915a(new C20751b(cameraDevice, (C20764for) C20767if.this.m48071new(), ifVar2.f56893a, ifVar2.f56895e, C20767if.this.f56906o));
                C20767if ifVar3 = C20767if.this;
                ifVar3.f56900if.mo171346do(ifVar3.m48071new());
                C20767if.this.m48072this();
            } catch (Exception e) {
                C20767if.this.f56900if.mo171348do(e);
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$if */
    /* compiled from: Camera2 */
    class C20770if extends CameraCaptureSession.StateCallback {
        C20770if() {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            IPLog.m43494w(C20767if.f56891b, "CAMERA: onConfigureFailed");
            C20767if.this.f56900if.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "onConfigureFailed"));
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            synchronized (C20767if.this.f56903l) {
                if (C20767if.this.f56902k != null) {
                    CameraCaptureSession unused = C20767if.this.f56905n = cameraCaptureSession;
                    try {
                        C20767if.this.m42924c();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$new */
    /* compiled from: Camera2 */
    public class C20771new implements ImageReader.OnImageAvailableListener {
        public C20771new() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                synchronized (C20767if.this.f56903l) {
                    image = imageReader.acquireLatestImage();
                    if (image != null) {
                        C20893while.m43453do(C20882import.AND3);
                        if (image.getHeight() == C20767if.this.f62356new.mo171321a().mo180432do() || image.getWidth() == C20767if.this.f62356new.mo171321a().mo180435if()) {
                            C20893while.m43453do(C20882import.AND14);
                        }
                        C20779while whileR = new C20779while(image);
                        image.close();
                        C20767if.this.mo171325do((C21824for) whileR);
                    }
                }
            } catch (RuntimeException e) {
                if (C20767if.this.m42920a(e)) {
                    image = null;
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                String a = C20767if.f56891b;
                IPLog.m43490e(a, "Corrupt frame? " + e2.toString());
                e2.printStackTrace();
                C20767if.this.f56900if.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "Frame not available, perhaps corrupt", e2));
            } catch (Throwable th) {
                image.close();
                throw th;
            }
        }
    }

    public C20767if(Context context, String str, C20752break breakR, C20776try.C20777do doVar, C21829try tryR, C21825goto gotoR) throws C20755case {
        this.f56900if = doVar;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        this.f62354for = cameraManager;
        if (cameraManager != null) {
            HandlerThread handlerThread = new HandlerThread("Camera2 Capture");
            this.f56897g = handlerThread;
            handlerThread.start();
            this.f56901j = new Handler(this.f56897g.getLooper());
            HandlerThread handlerThread2 = new HandlerThread("Camera2");
            this.f56898h = handlerThread2;
            handlerThread2.start();
            this.f56899i = new Handler(this.f56898h.getLooper());
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Float f = C21823else.m45134do(cameraCharacteristics);
                this.f56895e = gotoR;
                C20764for forR = new C20764for(str, breakR, cameraCharacteristics, f, tryR);
                this.f62356new = forR;
                ImageReader newInstance = ImageReader.newInstance(forR.mo171321a().mo180435if(), forR.mo171321a().mo180432do(), 35, 2);
                this.f56896f = newInstance;
                newInstance.setOnImageAvailableListener(new C20771new(), this.f56901j);
                this.f62353else = newInstance.getSurface();
            } catch (CameraAccessException e) {
                throw new C20755case(C20755case.C20756do.CAMERA_PERMISSION_DENIED, (Throwable) e);
            }
        } else {
            throw new C20755case(C20755case.C20756do.CAMERA_ERROR, "Cannot open camera service");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m42922b() {
        Semaphore semaphore;
        synchronized (this.f56903l) {
            try {
                this.f56904m.mo171294a(this.f62353else);
                this.f56904m.mo171294a(this.f62355goto);
                m48070goto();
                boolean z = m48068else();
                this.f56904m = null;
                if (!z) {
                    semaphore = this.f56894d;
                    semaphore.release();
                }
            } catch (RuntimeException e) {
                try {
                    this.f56900if.mo171344do(C20776try.C20778if.FAILED_TO_STOP_GRACEFULLY, e);
                    this.f56904m = null;
                    semaphore = this.f56894d;
                } catch (Throwable th) {
                    this.f56904m = null;
                    this.f56894d.release();
                    throw th;
                }
            }
        }
    }

    /* renamed from: do */
    public void mo171299do() {
    }

    /* renamed from: for  reason: not valid java name */
    public void m48069for() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: goto  reason: not valid java name */
    public void m48070goto() {
        synchronized (this.f56903l) {
            CameraCaptureSession cameraCaptureSession = this.f56905n;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.f56905n = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: this  reason: not valid java name */
    public void m48072this() throws CameraAccessException {
        if (this.f56902k != null && this.f56901j != null) {
            m48070goto();
            this.f56902k.createCaptureSession(this.f56893a, new C20770if(), this.f56901j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42914a(SurfaceTexture surfaceTexture) {
        try {
            if (!this.f56894d.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f56900if.mo171348do((Exception) new RuntimeException("Time out waiting to lock camera opening."));
                return;
            }
            mo171328if(surfaceTexture);
            this.f62354for.openCamera(this.f62356new.mo171323c(), this.f56907p, (Handler) null);
        } catch (CameraAccessException | InterruptedException e) {
            this.f56900if.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "Failed to open camera", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m42924c() throws CameraAccessException {
        CameraCaptureSession cameraCaptureSession;
        synchronized (this.f56903l) {
            C20751b bVar = this.f56904m;
            if (!(bVar == null || (cameraCaptureSession = this.f56905n) == null)) {
                cameraCaptureSession.setRepeatingRequest(bVar.mo171292a(), this.f56908q, this.f56899i);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: else  reason: not valid java name */
    public boolean m48068else() {
        CameraDevice cameraDevice = this.f56902k;
        boolean z = cameraDevice != null;
        if (z) {
            cameraDevice.close();
            this.f56902k = null;
        }
        this.f56896f.close();
        this.f56897g.quit();
        this.f56897g = null;
        this.f56898h.quit();
        this.f56898h = null;
        this.f56899i = null;
        this.f56901j = null;
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: if */
    public void mo171328if(SurfaceTexture surfaceTexture) {
        surfaceTexture.setDefaultBufferSize(this.f62356new.mo171312if().mo180435if(), this.f62356new.mo171312if().mo180432do());
        Surface surface = new Surface(surfaceTexture);
        this.f62355goto = surface;
        this.f56893a = Collections.unmodifiableList(Arrays.asList(new Surface[]{this.f62353else, surface}));
    }

    /* renamed from: new  reason: not valid java name */
    public C21827new m48071new() {
        return this.f62356new;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42917a(Runnable runnable) {
        try {
            if (!this.f56894d.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f56900if.mo171348do((Exception) new RuntimeException("Time out waiting to lock camera closing."));
                return;
            }
            m42922b();
            runnable.run();
        } catch (InterruptedException e) {
            this.f56900if.mo171348do((Exception) new C20755case(C20755case.C20756do.CAMERA_ERROR, "Failed to close camera", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m42920a(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42915a(C20751b bVar) {
        synchronized (this.f56903l) {
            this.f56904m = bVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public void mo171325do(C21824for forR) {
        this.f56900if.mo171345do(forR);
    }

    /* renamed from: do */
    public void mo171301do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f56899i;
        if (handler != null) {
            handler.post(new Runnable(surfaceTexture) {
                public final /* synthetic */ SurfaceTexture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20767if.this.m42914a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo171303do(Runnable runnable) {
        Handler handler = this.f56899i;
        if (handler != null) {
            handler.post(new Runnable(runnable) {
                public final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20767if.this.m42917a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42918a(boolean z) {
        synchronized (this.f56903l) {
            C20751b bVar = this.f56904m;
            if (bVar != null) {
                bVar.mo171295a(z);
                try {
                    m42924c();
                } catch (CameraAccessException | IllegalStateException e) {
                    this.f56900if.mo171344do(C20776try.C20778if.FAILED_TO_LOCK_EXPOSURE, e);
                }
            } else {
                return;
            }
        }
        this.f56900if.mo171349do(z);
    }

    /* renamed from: do */
    public void mo171304do(boolean z) {
        Handler handler = this.f56899i;
        if (handler != null) {
            handler.post(new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20767if.this.m42918a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo171300do(RectF rectF) {
        Handler handler = this.f56899i;
        if (handler != null) {
            handler.post(new Runnable(rectF) {
                public final /* synthetic */ RectF f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20767if.this.m42913a(this.f$1);
                }
            });
        }
    }

    /* renamed from: if */
    public C20759const mo171306if() {
        return C20759const.CAMERA2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m42913a(RectF rectF) {
        synchronized (this.f56903l) {
            this.f56906o = rectF;
            C20751b bVar = this.f56904m;
            if (bVar != null) {
                bVar.mo171293a(C20751b.m42855a(rectF, this.f62356new.m48065try(), 1000));
                try {
                    m42924c();
                } catch (CameraAccessException | IllegalStateException e) {
                    this.f56900if.mo171344do(C20776try.C20778if.FAILED_TO_LOCK_EXPOSURE, e);
                }
            }
        }
    }
}
