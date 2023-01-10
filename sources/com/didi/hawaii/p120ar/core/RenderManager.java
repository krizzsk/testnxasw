package com.didi.hawaii.p120ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.hawaii.p120ar.core.modle.ARCoreSession;
import com.didi.hawaii.p120ar.core.render.BackgroundRenderer;
import com.didi.hawaii.p120ar.jni.DARCLocationInScene;
import com.didi.hawaii.p120ar.jni.DARCNAVStatus;
import com.didi.hawaii.p120ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p120ar.utils.DisplayRotationHelper;
import com.didichuxing.hawaii.arsdk.darcore.OSImage;
import com.google.p223ar.core.Camera;
import com.google.p223ar.core.Frame;
import com.google.p223ar.core.TrackingState;
import com.google.p223ar.core.exceptions.CameraNotAvailableException;
import com.google.p223ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p223ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableSdkTooOldException;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.didi.hawaii.ar.core.RenderManager */
public class RenderManager extends BaseDelegate {

    /* renamed from: a */
    private static final String f25283a = RenderManager.class.getSimpleName();

    /* renamed from: i */
    private static final long f25284i = 333;

    /* renamed from: j */
    private static final long f25285j = 24;

    /* renamed from: b */
    private ARCoreSession f25286b = null;

    /* renamed from: c */
    private final BackgroundRenderer f25287c = new BackgroundRenderer();

    /* renamed from: d */
    private DisplayRotationHelper f25288d;

    /* renamed from: e */
    private long f25289e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f25290f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f25291g = false;

    /* renamed from: h */
    private OSImage f25292h = null;

    /* renamed from: k */
    private boolean f25293k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Lock f25294l = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile boolean f25295m = true;

    /* renamed from: n */
    private Context f25296n;

    /* renamed from: o */
    private Handler f25297o = new Handler(Looper.getMainLooper());

    public RenderManager(Context context, DiAREngine diAREngine) {
        this.f25296n = context;
        attachEngine(diAREngine);
        try {
            this.f25286b = new ARCoreSession(context);
        } catch (UnavailableSdkTooOldException e) {
            e.printStackTrace();
        } catch (UnavailableDeviceNotCompatibleException e2) {
            e2.printStackTrace();
        } catch (UnavailableArcoreNotInstalledException e3) {
            e3.printStackTrace();
        } catch (UnavailableApkTooOldException e4) {
            e4.printStackTrace();
        }
        this.f25288d = new DisplayRotationHelper(context);
    }

    public void createRender(Context context) {
        try {
            this.f25287c.createOnGlThread(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSizeChange(int i, int i2) {
        this.f25288d.onSurfaceChanged(i, i2);
    }

    public void start() {
        this.f25293k = true;
    }

    public void drawRender(int[] iArr, DARCNAVStatus dARCNAVStatus) {
        boolean z;
        Lock lock;
        OSImage acquireCameraOSImage;
        ARCoreSession aRCoreSession = this.f25286b;
        if (aRCoreSession != null) {
            try {
                this.f25288d.updateSessionIfNeeded(aRCoreSession);
                this.f25286b.setCameraTextureName(this.f25287c.getTextureId());
                DARCLocationInScene dARCLocationInScene = new DARCLocationInScene();
                m20242a(dARCLocationInScene);
                Frame update = this.f25286b.update(iArr, dARCLocationInScene, dARCNAVStatus);
                Camera camera = update.getCamera();
                this.f25287c.draw(update);
                camera.getTrackingState();
                TrackingState trackingState = TrackingState.TRACKING;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f25289e <= f25284i || (acquireCameraOSImage = this.f25286b.acquireCameraOSImage()) == null) {
                    z = false;
                } else {
                    this.f25292h = acquireCameraOSImage;
                    z = true;
                    this.f25289e = currentTimeMillis;
                }
                if (this.f25294l.tryLock()) {
                    if (this.f25295m && currentTimeMillis - this.f25290f >= f25285j) {
                        final DARCNAVUpdateData updateData = this.f25286b.getUpdateData(this.f25292h, z);
                        this.f25295m = false;
                        this.f25297o.post(new Runnable() {
                            public void run() {
                                RenderManager.this.m20243a(updateData);
                                RenderManager.this.m20248c();
                                long unused = RenderManager.this.f25290f = System.currentTimeMillis();
                                RenderManager.this.f25294l.lock();
                                boolean unused2 = RenderManager.this.f25295m = true;
                                RenderManager.this.f25294l.unlock();
                            }
                        });
                    }
                    lock = this.f25294l;
                    lock.unlock();
                }
            } catch (Exception unused) {
                lock = this.f25294l;
            } catch (CameraNotAvailableException e) {
                e.printStackTrace();
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    private void m20239a() {
        this.f25297o.post(new Runnable() {
            public void run() {
                if (RenderManager.this.mAREngine != null) {
                    boolean unused = RenderManager.this.f25291g = true;
                    RenderManager.this.mAREngine.errorAppear();
                }
            }
        });
    }

    /* renamed from: b */
    private void m20246b() {
        this.f25297o.post(new Runnable() {
            public void run() {
                if (RenderManager.this.mAREngine != null && RenderManager.this.f25291g) {
                    RenderManager.this.mAREngine.errorDisappear();
                    boolean unused = RenderManager.this.f25291g = false;
                }
            }
        });
    }

    public void resume() {
        try {
            if (this.f25286b == null) {
                try {
                    this.f25286b = new ARCoreSession(this.f25296n);
                } catch (UnavailableSdkTooOldException e) {
                    e.printStackTrace();
                } catch (UnavailableDeviceNotCompatibleException e2) {
                    e2.printStackTrace();
                } catch (UnavailableArcoreNotInstalledException e3) {
                    e3.printStackTrace();
                } catch (UnavailableApkTooOldException e4) {
                    e4.printStackTrace();
                }
            }
            if (this.f25286b != null) {
                this.f25286b.resume();
                this.f25288d.onResume();
            }
        } catch (CameraNotAvailableException e5) {
            e5.printStackTrace();
        }
    }

    public void pause() {
        if (this.f25286b != null) {
            this.f25288d.onPause();
            this.f25286b.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20248c() {
        if (this.mAREngine != null) {
            this.mAREngine.renderUpdate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20243a(DARCNAVUpdateData dARCNAVUpdateData) {
        if (this.mAREngine != null) {
            this.mAREngine.update(dARCNAVUpdateData);
        }
    }

    /* renamed from: a */
    private void m20242a(DARCLocationInScene dARCLocationInScene) {
        if (this.mAREngine != null) {
            this.mAREngine.currentLocation(dARCLocationInScene);
        }
    }

    public void updateNavHintData() {
        ARCoreSession aRCoreSession = this.f25286b;
        if (aRCoreSession != null) {
            aRCoreSession.updateNavHintData();
        }
    }

    public void release() {
        this.f25286b = null;
    }
}
