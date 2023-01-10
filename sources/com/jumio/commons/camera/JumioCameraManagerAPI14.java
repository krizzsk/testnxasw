package com.jumio.commons.camera;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.TextureView;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.network.ErrorMock;
import com.jumio.sdk.enums.JumioCameraFacing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import jumio.core.C19510v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000501234B\u001f\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005R\u0016\u0010'\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(¨\u00065"}, mo148868d2 = {"Lcom/jumio/commons/camera/JumioCameraManagerAPI14;", "Lcom/jumio/commons/camera/JumioCameraManager;", "Landroid/hardware/Camera$PreviewCallback;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "frontFacing", "setCameraFacing", "Lcom/jumio/sdk/enums/JumioCameraFacing;", "facing", "x", "y", "requestFocus", "turnFlashOn", "setFlash", "startPreview", "reinitCamera", "", "data", "Landroid/hardware/Camera;", "camera", "onPreviewFrame", "addCallbackBuffer", "pause", "stopPreview", "destroy", "changeCamera", "Landroid/hardware/Camera$CameraInfo;", "info", "displayRotation", "calculateCameraRotation", "isFlashSupported", "()Z", "getHasMultipleCameras", "hasMultipleCameras", "Lcom/jumio/commons/utils/DeviceRotationManager;", "rotationManager", "enableFlashOnStartUp", "<init>", "(Lcom/jumio/commons/utils/DeviceRotationManager;ZZ)V", "Companion", "a", "b", "c", "d", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioCameraManagerAPI14.kt */
public final class JumioCameraManagerAPI14 extends JumioCameraManager implements Camera.PreviewCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    public Camera f57396j;

    /* renamed from: k */
    public int f57397k;

    /* renamed from: l */
    public byte[] f57398l;

    /* renamed from: m */
    public final Object f57399m = new Object();

    /* renamed from: n */
    public final Camera.AutoFocusCallback f57400n = new Camera.AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            JumioCameraManagerAPI14.m43623a(JumioCameraManagerAPI14.this, z, camera);
        }
    };

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo148868d2 = {"Lcom/jumio/commons/camera/JumioCameraManagerAPI14$Companion;", "", "", "CAMERA_OPEN_TIMEOUT", "I", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: JumioCameraManagerAPI14.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.jumio.commons.camera.JumioCameraManagerAPI14$a */
    /* compiled from: JumioCameraManagerAPI14.kt */
    public final class C20925a implements Runnable {

        /* renamed from: a */
        public SurfaceTexture f57401a;

        /* renamed from: b */
        public int f57402b;

        /* renamed from: c */
        public int f57403c;

        /* renamed from: d */
        public boolean f57404d;

        /* renamed from: e */
        public int f57405e;

        /* renamed from: f */
        public final /* synthetic */ JumioCameraManagerAPI14 f57406f;

        public C20925a(JumioCameraManagerAPI14 jumioCameraManagerAPI14, SurfaceTexture surfaceTexture, int i, int i2, boolean z, int i3) {
            Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
            this.f57406f = jumioCameraManagerAPI14;
            this.f57401a = surfaceTexture;
            this.f57402b = i;
            this.f57403c = i2;
            this.f57404d = z;
            this.f57405e = i3;
        }

        /* renamed from: a */
        public final int mo171826a() {
            return this.f57405e;
        }

        /* renamed from: b */
        public final int mo171827b() {
            return this.f57403c;
        }

        /* renamed from: c */
        public final SurfaceTexture mo171828c() {
            return this.f57401a;
        }

        /* renamed from: d */
        public final int mo171829d() {
            return this.f57402b;
        }

        /* renamed from: e */
        public final boolean mo171830e() {
            return this.f57404d;
        }

        public void run() {
            Object access$getCameraAccessLock$p = this.f57406f.f57399m;
            JumioCameraManagerAPI14 jumioCameraManagerAPI14 = this.f57406f;
            synchronized (access$getCameraAccessLock$p) {
                jumioCameraManagerAPI14.mo171822b();
                jumioCameraManagerAPI14.mo171818a(mo171828c(), mo171829d(), mo171827b(), mo171830e(), mo171826a());
                if (!jumioCameraManagerAPI14.isPausePreview()) {
                    jumioCameraManagerAPI14.startPreview();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: com.jumio.commons.camera.JumioCameraManagerAPI14$b */
    /* compiled from: JumioCameraManagerAPI14.kt */
    public final class C20926b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ JumioCameraManagerAPI14 f57407a;

        public C20926b(JumioCameraManagerAPI14 jumioCameraManagerAPI14) {
            Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
            this.f57407a = jumioCameraManagerAPI14;
        }

        public void run() {
            Object access$getCameraAccessLock$p = this.f57407a.f57399m;
            JumioCameraManagerAPI14 jumioCameraManagerAPI14 = this.f57407a;
            synchronized (access$getCameraAccessLock$p) {
                Camera access$getCamera$p = jumioCameraManagerAPI14.f57396j;
                if (access$getCamera$p != null) {
                    access$getCamera$p.release();
                }
                jumioCameraManagerAPI14.f57396j = null;
                jumioCameraManagerAPI14.f57398l = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: com.jumio.commons.camera.JumioCameraManagerAPI14$c */
    /* compiled from: JumioCameraManagerAPI14.kt */
    public final class C20927c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ JumioCameraManagerAPI14 f57408a;

        public C20927c(JumioCameraManagerAPI14 jumioCameraManagerAPI14) {
            Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
            this.f57408a = jumioCameraManagerAPI14;
        }

        public void run() {
            this.f57408a.setFlash(false);
            Object access$getCameraAccessLock$p = this.f57408a.f57399m;
            JumioCameraManagerAPI14 jumioCameraManagerAPI14 = this.f57408a;
            synchronized (access$getCameraAccessLock$p) {
                if (jumioCameraManagerAPI14.inPreview) {
                    Camera access$getCamera$p = jumioCameraManagerAPI14.f57396j;
                    if (access$getCamera$p != null) {
                        access$getCamera$p.stopPreview();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            this.f57408a.inPreview = false;
        }
    }

    /* renamed from: com.jumio.commons.camera.JumioCameraManagerAPI14$d */
    /* compiled from: JumioCameraManagerAPI14.kt */
    public final class C20928d implements Runnable {

        /* renamed from: a */
        public SurfaceTexture f57409a;

        /* renamed from: b */
        public int f57410b;

        /* renamed from: c */
        public int f57411c;

        /* renamed from: d */
        public boolean f57412d;

        /* renamed from: e */
        public int f57413e;

        /* renamed from: f */
        public final /* synthetic */ JumioCameraManagerAPI14 f57414f;

        public C20928d(JumioCameraManagerAPI14 jumioCameraManagerAPI14, SurfaceTexture surfaceTexture, int i, int i2, boolean z, int i3) {
            Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
            this.f57414f = jumioCameraManagerAPI14;
            this.f57409a = surfaceTexture;
            this.f57410b = i;
            this.f57411c = i2;
            this.f57412d = z;
            this.f57413e = i3;
        }

        /* renamed from: a */
        public final int mo171834a() {
            return this.f57413e;
        }

        /* renamed from: b */
        public final int mo171835b() {
            return this.f57411c;
        }

        /* renamed from: c */
        public final SurfaceTexture mo171836c() {
            return this.f57409a;
        }

        /* renamed from: d */
        public final int mo171837d() {
            return this.f57410b;
        }

        /* renamed from: e */
        public final boolean mo171838e() {
            return this.f57412d;
        }

        public void run() {
            Object access$getCameraAccessLock$p = this.f57414f.f57399m;
            JumioCameraManagerAPI14 jumioCameraManagerAPI14 = this.f57414f;
            synchronized (access$getCameraAccessLock$p) {
                Camera unused = jumioCameraManagerAPI14.f57396j;
                C19510v cameraCallback = jumioCameraManagerAPI14.getCameraCallback();
                if (cameraCallback != null) {
                    cameraCallback.mo148746a();
                }
                jumioCameraManagerAPI14.mo171818a(mo171836c(), mo171837d(), mo171835b(), mo171838e(), mo171834a());
                if (!jumioCameraManagerAPI14.isPausePreview()) {
                    jumioCameraManagerAPI14.startPreview();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioCameraManagerAPI14(DeviceRotationManager deviceRotationManager, boolean z, boolean z2) {
        super(deviceRotationManager, z, z2);
        Intrinsics.checkNotNullParameter(deviceRotationManager, "rotationManager");
    }

    /* renamed from: a */
    public static final void m43623a(JumioCameraManagerAPI14 jumioCameraManagerAPI14, boolean z, Camera camera) {
        Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
        jumioCameraManagerAPI14.focusing = false;
    }

    public void addCallbackBuffer() {
        synchronized (this.f57399m) {
            byte[] bArr = this.f57398l;
            if (bArr != null) {
                Camera camera = this.f57396j;
                if (camera != null) {
                    camera.addCallbackBuffer(bArr);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* renamed from: b */
    public final Size mo171821b(Camera.Parameters parameters) {
        Camera.Size size = parameters.getSupportedPreviewSizes().get(0);
        Size size2 = this.requestedSize;
        if (size2 != null) {
            for (Camera.Size next : parameters.getSupportedPreviewSizes()) {
                int i = next.width;
                if (i < size2.width || next.height < size2.height) {
                    Camera.Size size3 = size;
                    if (i >= size3.width) {
                        if (next.height < size3.height) {
                        }
                    }
                }
                size = next;
            }
        }
        Camera.Size size4 = size;
        return new Size(size4.width, size4.height);
    }

    public final int calculateCameraRotation(Camera.CameraInfo cameraInfo, int i) {
        Intrinsics.checkNotNullParameter(cameraInfo, "info");
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 90;
            } else if (i == 2) {
                i2 = 180;
            } else if (i == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public void changeCamera() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras > 0) {
                int i = this.f57397k + 1;
                this.f57397k = i;
                if (i >= numberOfCameras) {
                    this.f57397k = 0;
                }
                stopPreview(false);
                destroy();
                reinitCamera();
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
    }

    public void destroy() {
        this.executorService.submit(new C20926b(this));
    }

    public boolean getHasMultipleCameras() {
        return Camera.getNumberOfCameras() > 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isFlashSupported() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f57399m
            monitor-enter(r0)
            android.hardware.Camera r1 = r3.f57396j     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0008
            goto L_0x002b
        L_0x0008:
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0025 }
            java.util.List r1 = r1.getSupportedFlashModes()     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x0029
            java.lang.String r2 = "torch"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x0025 }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "on"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0025 }
            if (r1 == 0) goto L_0x0029
        L_0x0022:
            monitor-exit(r0)
            r0 = 1
            return r0
        L_0x0025:
            r1 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r1)     // Catch:{ all -> 0x002e }
        L_0x0029:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002e }
        L_0x002b:
            monitor-exit(r0)
            r0 = 0
            return r0
        L_0x002e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI14.isFlashSupported():boolean");
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(camera, "camera");
        C19510v cameraCallback = getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.mo148750a(bArr);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
        this.executorService.submit(new C20925a(this, surfaceTexture, i, i2, getRotationManager().isScreenPortrait(), getRotationManager().getDisplayRotation()));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
        stopPreview(isPausePreview());
        destroy();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
        this.executorService.submit(new C20928d(this, surfaceTexture, i, i2, getRotationManager().isScreenPortrait(), getRotationManager().getDisplayRotation()));
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
    }

    public void reinitCamera() {
        ExecutorService executorService = this.executorService;
        TextureView textureView = getTextureView();
        SurfaceTexture surfaceTexture = textureView == null ? null : textureView.getSurfaceTexture();
        TextureView textureView2 = getTextureView();
        int width = textureView2 == null ? 0 : textureView2.getWidth();
        TextureView textureView3 = getTextureView();
        executorService.submit(new C20925a(this, surfaceTexture, width, textureView3 == null ? 0 : textureView3.getHeight(), getRotationManager().isScreenPortrait(), getRotationManager().getDisplayRotation()));
    }

    public void requestFocus(int i, int i2) {
        TextureView textureView = getTextureView();
        int i3 = 0;
        int width = textureView == null ? 0 : textureView.getWidth();
        TextureView textureView2 = getTextureView();
        if (textureView2 != null) {
            i3 = textureView2.getHeight();
        }
        float f = (float) 2000;
        float f2 = (float) width;
        float f3 = (float) 1000;
        int i4 = (int) (((((float) (i - 50)) / f2) * f) - f3);
        int i5 = (int) (((((float) (i + 50)) / f2) * f) - f3);
        float f4 = (float) i3;
        int i6 = (int) (((((float) (i2 - 50)) / f4) * f) - f3);
        int i7 = (int) ((f * (((float) (i2 + 50)) / f4)) - f3);
        synchronized (this.f57399m) {
            try {
                Camera camera = this.f57396j;
                if (camera != null) {
                    if (!this.focusing) {
                        if (this.manualFocusEnabled) {
                            this.focusing = true;
                            camera.autoFocus(this.f57400n);
                        } else {
                            Camera.Parameters parameters = camera.getParameters();
                            Intrinsics.checkNotNullExpressionValue(parameters, "it.parameters");
                            mo171819a(parameters, new Rect(i4, i6, i5, i7));
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return;
    }

    public void setCameraFacing(boolean z) {
        this.f57397k = 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    Camera.getCameraInfo(i, cameraInfo);
                    setFrontFacing(cameraInfo.facing == 1);
                    if ((z && cameraInfo.facing == 1) || (!z && cameraInfo.facing == 0)) {
                        this.f57397k = i;
                    }
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
                if (i2 >= numberOfCameras) {
                    break;
                }
                i = i2;
            }
        }
        if (!isPausePreview() && this.f57396j != null) {
            try {
                stopPreview(false);
                destroy();
                reinitCamera();
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFlash(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f57399m
            monitor-enter(r0)
            android.hardware.Camera r1 = r4.f57396j     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            boolean r2 = r4.isFlashSupported()     // Catch:{ all -> 0x002b }
            if (r2 != 0) goto L_0x0010
            monitor-exit(r0)
            return
        L_0x0010:
            r4.setFlashOn(r5)     // Catch:{ all -> 0x002b }
            android.hardware.Camera$Parameters r2 = r1.getParameters()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r3 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0023 }
            r4.mo171820a((android.hardware.Camera.Parameters) r2, (boolean) r5)     // Catch:{ Exception -> 0x0023 }
            r1.setParameters(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r5 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r5)     // Catch:{ all -> 0x002b }
        L_0x0027:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)
            return
        L_0x002b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI14.setFlash(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        r2 = r4.previewSize;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startPreview() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f57399m
            monitor-enter(r0)
            android.hardware.Camera r1 = r4.f57396j     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0008
            goto L_0x003c
        L_0x0008:
            byte[] r2 = r4.f57398l     // Catch:{ Exception -> 0x0035 }
            if (r2 != 0) goto L_0x0026
            com.jumio.commons.camera.Size r2 = r4.previewSize     // Catch:{ Exception -> 0x0035 }
            int r3 = r2.width     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x0026
            int r2 = r2.height     // Catch:{ Exception -> 0x0035 }
            if (r2 == 0) goto L_0x0026
            int r3 = r3 * r2
            r2 = 17
            int r2 = android.graphics.ImageFormat.getBitsPerPixel(r2)     // Catch:{ Exception -> 0x0035 }
            int r3 = r3 * r2
            int r3 = r3 / 8
            byte[] r2 = new byte[r3]     // Catch:{ Exception -> 0x0035 }
            r4.f57398l = r2     // Catch:{ Exception -> 0x0035 }
        L_0x0026:
            byte[] r2 = r4.f57398l     // Catch:{ Exception -> 0x0035 }
            r1.addCallbackBuffer(r2)     // Catch:{ Exception -> 0x0035 }
            r1.setPreviewCallbackWithBuffer(r4)     // Catch:{ Exception -> 0x0035 }
            r1.startPreview()     // Catch:{ Exception -> 0x0035 }
            r1 = 1
            r4.inPreview = r1     // Catch:{ Exception -> 0x0035 }
            goto L_0x003c
        L_0x0035:
            r1 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r1)     // Catch:{ all -> 0x0044 }
            r4.reinitCamera()     // Catch:{ all -> 0x0044 }
        L_0x003c:
            r1 = 0
            r4.setPausePreview(r1)     // Catch:{ all -> 0x0044 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)
            return
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.JumioCameraManagerAPI14.startPreview():void");
    }

    public void stopPreview(boolean z) {
        this.executorService.submit(new C20927c(this));
        setPausePreview(z);
    }

    /* renamed from: a */
    public final void mo171819a(Camera.Parameters parameters, Rect rect) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(rect, 1));
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
    }

    /* renamed from: a */
    public final void mo171820a(Camera.Parameters parameters, boolean z) {
        if (parameters.getSupportedFlashModes() == null || z) {
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            boolean z2 = false;
            if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                parameters.setFlashMode("torch");
                return;
            }
            List<String> supportedFlashModes2 = parameters.getSupportedFlashModes();
            if (supportedFlashModes2 != null && supportedFlashModes2.contains("on")) {
                z2 = true;
            }
            if (z2) {
                parameters.setFlashMode("on");
                return;
            }
            return;
        }
        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    /* renamed from: b */
    public final void mo171822b() {
        TextureView textureView;
        synchronized (this.f57399m) {
            this.f57396j = mo171816a(this.f57397k);
            Unit unit = Unit.INSTANCE;
        }
        boolean isFlashSupported = isFlashSupported();
        if (isFlashSupported && getEnableFlashOnStart()) {
            setFlash(true);
        }
        if (this.f57396j != null && (textureView = getTextureView()) != null) {
            textureView.post(new Runnable(isFlashSupported) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    JumioCameraManagerAPI14.m43622a(JumioCameraManagerAPI14.this, this.f$1);
                }
            });
        }
    }

    /* renamed from: a */
    public final Camera mo171816a(int i) {
        Camera camera;
        TextureView textureView;
        int numberOfCameras = Camera.getNumberOfCameras();
        boolean z = false;
        this.f57397k = (numberOfCameras <= 0 || i >= numberOfCameras) ? 0 : i;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        if (cameraInfo.facing == 1) {
            z = true;
        }
        setFrontFacing(z);
        long currentTimeMillis = System.currentTimeMillis();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        loop0:
        while (true) {
            camera = null;
            while (camera == null && System.currentTimeMillis() - currentTimeMillis <= 2000) {
                try {
                    ErrorMock.onCameraConnectionMock();
                    camera = Camera.open(i);
                } catch (Throwable th) {
                    objectRef.element = th;
                }
            }
        }
        if (!(camera != null || objectRef.element == null || (textureView = getTextureView()) == null)) {
            textureView.post(new Runnable(objectRef) {
                public final /* synthetic */ Ref.ObjectRef f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    JumioCameraManagerAPI14.m43621a(JumioCameraManagerAPI14.this, this.f$1);
                }
            });
        }
        return camera;
    }

    /* renamed from: b */
    public final void mo171823b(Camera.Parameters parameters, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z && supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
            this.manualFocusEnabled = false;
        } else if (!z && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            this.manualFocusEnabled = false;
        } else if (supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            this.manualFocusEnabled = true;
        } else if (supportedFocusModes.contains("macro")) {
            parameters.setFocusMode("macro");
            this.manualFocusEnabled = true;
        }
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        Intrinsics.checkNotNullParameter(jumioCameraFacing, "facing");
        this.f57397k = 0;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    Camera.getCameraInfo(i, cameraInfo);
                    setFrontFacing(cameraInfo.facing == 1);
                    if (!((jumioCameraFacing == JumioCameraFacing.FRONT && cameraInfo.facing == 1) || (jumioCameraFacing == JumioCameraFacing.BACK && cameraInfo.facing == 0))) {
                        if (i2 < numberOfCameras) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    Log.printStackTrace(e);
                    return;
                }
            }
            this.f57397k = i;
        }
    }

    /* renamed from: a */
    public static final void m43621a(JumioCameraManagerAPI14 jumioCameraManagerAPI14, Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$tt");
        C19510v cameraCallback = jumioCameraManagerAPI14.getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.mo148748a((Throwable) objectRef.element);
        }
    }

    /* renamed from: a */
    public final Size mo171817a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Camera.Size size = supportedPreviewSizes.get(0);
        String[] strArr = JumioCameraManager.FALLBACK_PREVIEW_FORMAT_LIST;
        if (CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)).contains(Build.MODEL) && size.width == 1920 && size.height == 1080) {
            supportedPreviewSizes.remove(0);
            size = supportedPreviewSizes.get(0);
        }
        for (Camera.Size next : supportedPreviewSizes) {
            if (next.width >= size.width && next.height >= size.height) {
                size = next;
            }
        }
        return new Size(size.width, size.height);
    }

    /* renamed from: a */
    public static final void m43622a(JumioCameraManagerAPI14 jumioCameraManagerAPI14, boolean z) {
        Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
        C19510v cameraCallback = jumioCameraManagerAPI14.getCameraCallback();
        if (cameraCallback != null) {
            cameraCallback.mo148749a(z);
        }
    }

    /* renamed from: a */
    public final void mo171818a(SurfaceTexture surfaceTexture, int i, int i2, boolean z, int i3) {
        synchronized (this.f57399m) {
            Camera camera = this.f57396j;
            if (camera != null) {
                try {
                    camera.setPreviewTexture(surfaceTexture);
                } catch (Throwable th) {
                    Log.m43651e(JumioCameraManager.getTAG(), "Exception in setPreviewTexture()", th);
                }
                Camera.Parameters parameters = camera.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
                mo171823b(parameters, JumioCameraManager.FALLBACK_AUTO_FOCUS_LIST.contains(Build.MODEL));
                Matrix a = mo171815a(parameters, i, i2, z);
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                try {
                    Camera.getCameraInfo(this.f57397k, cameraInfo);
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
                this.previewProperties.orientation = calculateCameraRotation(cameraInfo, i3);
                Camera camera2 = this.f57396j;
                if (camera2 != null) {
                    camera2.setDisplayOrientation(this.previewProperties.orientation);
                }
                Camera camera3 = this.f57396j;
                if (camera3 != null) {
                    camera3.setParameters(parameters);
                }
                PreviewProperties previewProperties = this.previewProperties;
                previewProperties.sensorRotation = cameraInfo.orientation;
                previewProperties.surface = new Size(i, i2);
                PreviewProperties previewProperties2 = this.previewProperties;
                Size size = this.previewSize;
                previewProperties2.camera = new Size(size.width, size.height);
                this.previewProperties.frontFacing = isFrontFacing();
                this.previewProperties.previewFormat = parameters.getPreviewFormat();
                this.previewProperties.isPortrait = z;
                C19510v cameraCallback = getCameraCallback();
                if (cameraCallback != null) {
                    cameraCallback.mo148747a(this.previewProperties);
                }
                TextureView textureView = getTextureView();
                if (textureView != null) {
                    textureView.post(new Runnable(a) {
                        public final /* synthetic */ Matrix f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            JumioCameraManagerAPI14.m43620a(JumioCameraManagerAPI14.this, this.f$1);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public static final void m43620a(JumioCameraManagerAPI14 jumioCameraManagerAPI14, Matrix matrix) {
        Intrinsics.checkNotNullParameter(jumioCameraManagerAPI14, "this$0");
        Intrinsics.checkNotNullParameter(matrix, "$matrix");
        TextureView textureView = jumioCameraManagerAPI14.getTextureView();
        if (textureView != null) {
            textureView.setTransform(matrix);
        }
    }

    /* renamed from: a */
    public final Matrix mo171815a(Camera.Parameters parameters, int i, int i2, boolean z) {
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        int i5;
        this.previewSize = this.requestedSize == null ? mo171817a(parameters) : mo171821b(parameters);
        if (i > i2) {
            f2 = (float) i;
            f = (float) i2;
        } else {
            f2 = (float) i2;
            f = (float) i;
        }
        float f4 = f2 / f;
        try {
            parameters.set("metering", "center");
        } catch (Exception unused) {
        }
        Size size = this.previewSize;
        int i6 = size.width;
        int i7 = size.height;
        float f5 = ((float) i6) / ((float) i7);
        parameters.setPreviewSize(i6, i7);
        int i8 = 0;
        float f6 = 1.0f;
        if (f5 == 1.0f) {
            PreviewProperties previewProperties = this.previewProperties;
            Size size2 = this.previewSize;
            previewProperties.preview = new Size(size2.width, size2.height);
            i8 = i > i2 ? i : i2;
            float f7 = (float) i8;
            f6 = f7 / ((float) i);
            f3 = f7 / ((float) i2);
            i3 = i8;
        } else {
            if (z) {
                PreviewProperties previewProperties2 = this.previewProperties;
                Size size3 = this.previewSize;
                previewProperties2.preview = new Size(size3.height, size3.width);
                if (f5 >= f4) {
                    i4 = (int) (f5 * ((float) i));
                } else {
                    if (f5 < f4) {
                        i5 = (int) (((float) i2) / f5);
                        f6 = ((float) i8) / ((float) i);
                        f3 = 1.0f;
                        i3 = i2;
                    }
                    i3 = 0;
                    f3 = 1.0f;
                }
            } else {
                PreviewProperties previewProperties3 = this.previewProperties;
                Size size4 = this.previewSize;
                previewProperties3.preview = new Size(size4.width, size4.height);
                if (f5 <= f4) {
                    i4 = (int) (((float) i) / f5);
                } else {
                    if (f5 > f4) {
                        i5 = (int) (f5 * ((float) i2));
                        f6 = ((float) i8) / ((float) i);
                        f3 = 1.0f;
                        i3 = i2;
                    }
                    i3 = 0;
                    f3 = 1.0f;
                }
            }
            f3 = ((float) i4) / ((float) i2);
            i3 = i4;
            i8 = i;
        }
        this.previewProperties.scaledPreview = new Size(i8, i3);
        Matrix matrix = new Matrix();
        float f8 = (float) 2;
        matrix.setScale(f6, f3, ((float) i) / f8, ((float) i2) / f8);
        return matrix;
    }
}
