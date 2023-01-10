package com.jumio.core.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleObserver;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.JumioCameraManager;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.MissingPermissionException;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.C19496o0;
import jumio.core.C19505t;
import jumio.core.C19510v;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB0\b\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017J\u000f\u0010\r\u001a\u00020\u0006H\u0011¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\"\u0010%\u001a\u00020\u001e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010E\u001a\u00060>R\u00020\u00008\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010L\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010P\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bM\u0010G\u001a\u0004\bN\u0010I\"\u0004\bO\u0010KR\"\u0010T\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bQ\u0010G\u001a\u0004\bR\u0010I\"\u0004\bS\u0010KR\"\u0010X\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bU\u0010G\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR*\u0010a\u001a\u00020Y2\u0006\u0010Z\u001a\u00020Y8V@VX\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R*\u0010g\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\u000e8V@VX\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010\u0011R$\u0010i\u001a\u0004\u0018\u00010h8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010p\u001a\u0004\u0018\u00010o8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010w\u001a\u0004\u0018\u00010v8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0017\u0010\u0001\u001a\u00020}8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010R \u0010\u0001\u001a\u00020}8&@&X¦\u000e¢\u0006\u000f\u001a\u0005\b\u0001\u0010\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018@@\u0000X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010v8@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010zR\u0018\u0010\u0001\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010eR\u0018\u0010\u0001\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010eR\u0018\u0010\u0001\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010eR'\u0010\u0001\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\u000e8V@VX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010e\"\u0005\b\u0001\u0010\u0011R\u0018\u0010\u0001\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010e¨\u0006\u0001"}, mo148868d2 = {"Lcom/jumio/core/views/ScanView;", "Landroid/widget/RelativeLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "scanPart", "attach", "detach$jumio_core_release", "()V", "detach", "", "request", "update$jumio_core_release", "(Z)V", "update", "pause", "stopPreview$jumio_core_release", "stopPreview", "Lcom/jumio/commons/camera/ImageData;", "data", "fillImageData$jumio_core_release", "(Lcom/jumio/commons/camera/ImageData;)V", "fillImageData", "resume", "switchCamera", "takePicture", "Lcom/jumio/commons/camera/PreviewProperties;", "a", "Lcom/jumio/commons/camera/PreviewProperties;", "getPreviewProperties$jumio_core_release", "()Lcom/jumio/commons/camera/PreviewProperties;", "setPreviewProperties$jumio_core_release", "(Lcom/jumio/commons/camera/PreviewProperties;)V", "previewProperties", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "setUiHandler", "(Landroid/os/Handler;)V", "uiHandler", "Lcom/jumio/commons/camera/JumioCameraManager;", "e", "Lcom/jumio/commons/camera/JumioCameraManager;", "getCameraManager$jumio_core_release", "()Lcom/jumio/commons/camera/JumioCameraManager;", "setCameraManager$jumio_core_release", "(Lcom/jumio/commons/camera/JumioCameraManager;)V", "cameraManager", "Landroid/view/TextureView;", "f", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "textureView", "Lcom/jumio/core/views/ScanView$a;", "h", "Lcom/jumio/core/views/ScanView$a;", "getCameraInterface", "()Lcom/jumio/core/views/ScanView$a;", "setCameraInterface", "(Lcom/jumio/core/views/ScanView$a;)V", "cameraInterface", "i", "I", "getViewWidth", "()I", "setViewWidth", "(I)V", "viewWidth", "j", "getViewHeight", "setViewHeight", "viewHeight", "k", "getOldWidth", "setOldWidth", "oldWidth", "l", "getOldHeight", "setOldHeight", "oldHeight", "Lcom/jumio/sdk/enums/JumioCameraFacing;", "value", "m", "Lcom/jumio/sdk/enums/JumioCameraFacing;", "getCameraFacing", "()Lcom/jumio/sdk/enums/JumioCameraFacing;", "setCameraFacing", "(Lcom/jumio/sdk/enums/JumioCameraFacing;)V", "cameraFacing", "n", "Z", "getFlash", "()Z", "setFlash", "flash", "Ljumio/core/o0;", "scanViewInterface", "Ljumio/core/o0;", "getScanViewInterface", "()Ljumio/core/o0;", "setScanViewInterface", "(Ljumio/core/o0;)V", "Ljumio/core/t$a;", "drawViewInterface", "Ljumio/core/t$a;", "getDrawViewInterface", "()Ljumio/core/t$a;", "setDrawViewInterface", "(Ljumio/core/t$a;)V", "Ljumio/core/t;", "scanOverlayView", "Ljumio/core/t;", "getScanOverlayView", "()Ljumio/core/t;", "setScanOverlayView", "(Ljumio/core/t;)V", "", "getMinRatio", "()F", "minRatio", "getRatio", "setRatio", "(F)V", "ratio", "Landroid/graphics/Rect;", "getExtractionArea$jumio_core_release", "()Landroid/graphics/Rect;", "extractionArea", "getDrawView$jumio_core_release", "drawView", "isAttached", "getHasMultipleCameras", "hasMultipleCameras", "getHasFlash", "hasFlash", "getExtraction", "setExtraction", "extraction", "isShutterEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ScanView.kt */
public abstract class ScanView extends RelativeLayout implements LifecycleObserver {

    /* renamed from: a */
    public PreviewProperties f57835a;

    /* renamed from: b */
    public Handler f57836b;

    /* renamed from: c */
    public C19496o0 f57837c;

    /* renamed from: d */
    public C19505t.C19506a f57838d;

    /* renamed from: e */
    public JumioCameraManager f57839e;

    /* renamed from: f */
    public TextureView f57840f;

    /* renamed from: g */
    public C19505t f57841g;

    /* renamed from: h */
    public C20999a f57842h;

    /* renamed from: i */
    public int f57843i;

    /* renamed from: j */
    public int f57844j;

    /* renamed from: k */
    public int f57845k;

    /* renamed from: l */
    public int f57846l;

    /* renamed from: m */
    public JumioCameraFacing f57847m;

    /* renamed from: n */
    public boolean f57848n;

    /* renamed from: com.jumio.core.views.ScanView$a */
    /* compiled from: ScanView.kt */
    public class C20999a implements C19510v {

        /* renamed from: a */
        public final /* synthetic */ ScanView f57849a;

        public C20999a(ScanView scanView) {
            Intrinsics.checkNotNullParameter(scanView, "this$0");
            this.f57849a = scanView;
        }

        /* renamed from: a */
        public void mo148746a() {
        }

        /* renamed from: a */
        public void mo148749a(boolean z) {
            C19496o0 scanViewInterface = this.f57849a.getScanViewInterface();
            if (scanViewInterface != null) {
                scanViewInterface.mo148701e();
            }
        }

        /* renamed from: a */
        public void mo148748a(Throwable th) {
            C19496o0 scanViewInterface = this.f57849a.getScanViewInterface();
            if (scanViewInterface != null) {
                scanViewInterface.mo148695a(th);
            }
        }

        /* renamed from: a */
        public void mo148747a(PreviewProperties previewProperties) {
            Intrinsics.checkNotNullParameter(previewProperties, "properties");
            this.f57849a.setPreviewProperties$jumio_core_release(previewProperties);
            C19496o0 scanViewInterface = this.f57849a.getScanViewInterface();
            if (scanViewInterface != null) {
                scanViewInterface.mo148693a(previewProperties);
            }
        }

        /* renamed from: a */
        public void mo148750a(byte[] bArr) {
            C19496o0 scanViewInterface;
            JumioCameraManager cameraManager$jumio_core_release = this.f57849a.getCameraManager$jumio_core_release();
            if ((cameraManager$jumio_core_release != null && !cameraManager$jumio_core_release.isFocusing()) && (scanViewInterface = this.f57849a.getScanViewInterface()) != null) {
                scanViewInterface.mo148697a(bArr);
            }
            JumioCameraManager cameraManager$jumio_core_release2 = this.f57849a.getCameraManager$jumio_core_release();
            if (cameraManager$jumio_core_release2 != null) {
                cameraManager$jumio_core_release2.addCallbackBuffer();
            }
        }
    }

    public ScanView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public static final void m43829a(boolean z, ScanView scanView) {
        C19505t scanOverlayView;
        Intrinsics.checkNotNullParameter(scanView, "this$0");
        if (z && (scanOverlayView = scanView.getScanOverlayView()) != null) {
            scanOverlayView.requestLayout();
        }
        C19505t scanOverlayView2 = scanView.getScanOverlayView();
        if (scanOverlayView2 != null) {
            scanOverlayView2.invalidate();
        }
    }

    public void attach(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        detach$jumio_core_release();
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof C19496o0) {
            C19496o0 o0Var = (C19496o0) jumioScanPart.getScanPart$jumio_core_release();
            this.f57837c = o0Var;
            if (o0Var != null) {
                o0Var.mo148694a(this);
            }
        }
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof C19505t.C19506a) {
            this.f57838d = (C19505t.C19506a) jumioScanPart.getScanPart$jumio_core_release();
        }
    }

    public void detach$jumio_core_release() {
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager != null) {
            jumioCameraManager.stopPreview(true);
            jumioCameraManager.destroy();
        }
        this.f57837c = null;
        this.f57838d = null;
    }

    public void fillImageData$jumio_core_release(ImageData imageData) {
        Intrinsics.checkNotNullParameter(imageData, "data");
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager != null) {
            jumioCameraManager.getImageData(imageData);
        }
    }

    public JumioCameraFacing getCameraFacing() {
        JumioCameraFacing jumioCameraFacing;
        JumioCameraFacing[] i;
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager == null) {
            jumioCameraFacing = null;
        } else if (jumioCameraManager.isFrontFacing()) {
            jumioCameraFacing = JumioCameraFacing.FRONT;
        } else {
            jumioCameraFacing = JumioCameraFacing.BACK;
        }
        if (jumioCameraFacing == null) {
            jumioCameraFacing = JumioCameraFacing.BACK;
        }
        this.f57847m = jumioCameraFacing;
        C19496o0 o0Var = this.f57837c;
        if (!(o0Var == null || (i = o0Var.mo148704i()) == null || ArraysKt.contains((T[]) i, this.f57847m))) {
            this.f57847m = i[0];
            JumioCameraManager cameraManager$jumio_core_release = getCameraManager$jumio_core_release();
            if (cameraManager$jumio_core_release != null) {
                cameraManager$jumio_core_release.setCameraFacing(this.f57847m);
            }
        }
        return this.f57847m;
    }

    public final C20999a getCameraInterface() {
        return this.f57842h;
    }

    public final JumioCameraManager getCameraManager$jumio_core_release() {
        return this.f57839e;
    }

    public final C19505t getDrawView$jumio_core_release() {
        return this.f57841g;
    }

    public final C19505t.C19506a getDrawViewInterface() {
        return this.f57838d;
    }

    public boolean getExtraction() {
        C19496o0 o0Var = this.f57837c;
        return o0Var != null && o0Var.mo148699c();
    }

    public final Rect getExtractionArea$jumio_core_release() {
        Size size = this.f57835a.surface;
        if (size.width == 0 || size.height == 0) {
            return new Rect(0, 0, this.f57843i, this.f57844j);
        }
        Size size2 = this.f57835a.surface;
        return new Rect(0, 0, size2.width, size2.height);
    }

    public boolean getFlash() {
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager != null) {
            this.f57848n = jumioCameraManager.isFlashOn();
        }
        return this.f57848n;
    }

    public boolean getHasFlash() {
        JumioCameraManager jumioCameraManager = this.f57839e;
        return jumioCameraManager != null && jumioCameraManager.isFlashSupported();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getHasMultipleCameras() {
        /*
            r3 = this;
            com.jumio.commons.camera.JumioCameraManager r0 = r3.f57839e
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0007
            goto L_0x000f
        L_0x0007:
            boolean r0 = r0.getHasMultipleCameras()
            if (r0 != r2) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x002c
            jumio.core.o0 r0 = r3.f57837c
            if (r0 != 0) goto L_0x0017
            goto L_0x0028
        L_0x0017:
            com.jumio.sdk.enums.JumioCameraFacing[] r0 = r0.mo148704i()
            if (r0 != 0) goto L_0x001e
            goto L_0x0028
        L_0x001e:
            int r0 = r0.length
            if (r0 <= r2) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 != r2) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x002c
            r1 = 1
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.views.ScanView.getHasMultipleCameras():boolean");
    }

    public abstract float getMinRatio();

    public final int getOldHeight() {
        return this.f57846l;
    }

    public final int getOldWidth() {
        return this.f57845k;
    }

    public final PreviewProperties getPreviewProperties$jumio_core_release() {
        return this.f57835a;
    }

    public abstract float getRatio();

    public final C19505t getScanOverlayView() {
        return this.f57841g;
    }

    public final C19496o0 getScanViewInterface() {
        return this.f57837c;
    }

    public final TextureView getTextureView() {
        return this.f57840f;
    }

    public final Handler getUiHandler() {
        return this.f57836b;
    }

    public final int getViewHeight() {
        return this.f57844j;
    }

    public final int getViewWidth() {
        return this.f57843i;
    }

    public boolean isAttached() {
        return this.f57837c != null;
    }

    public boolean isShutterEnabled() {
        C19496o0 o0Var = this.f57837c;
        if (o0Var == null) {
            return false;
        }
        return o0Var.mo148700d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d3, code lost:
        if ((getRatio() != 0.0f) != false) goto L_0x00d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            int r1 = android.view.View.MeasureSpec.getMode(r10)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L_0x0024
            r2 = 1
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r5 = 0
            if (r2 == 0) goto L_0x0044
            float r6 = r8.getRatio()
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 != 0) goto L_0x0032
            r6 = 1
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            if (r6 != 0) goto L_0x0044
            float r6 = r8.getRatio()
            float r7 = r8.getMinRatio()
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r6 = 0
            goto L_0x0045
        L_0x0044:
            r6 = 1
        L_0x0045:
            if (r6 == 0) goto L_0x011a
            if (r2 != 0) goto L_0x0065
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0053
            r2 = 1
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            if (r2 != 0) goto L_0x0065
            float r2 = r8.getRatio()
            float r6 = r8.getMinRatio()
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r2 = 0
            goto L_0x0066
        L_0x0065:
            r2 = 1
        L_0x0066:
            if (r2 == 0) goto L_0x0102
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L_0x0071
            if (r0 != 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r0 = 0
            goto L_0x0072
        L_0x0071:
            r0 = 1
        L_0x0072:
            if (r1 == r2) goto L_0x0079
            if (r1 != 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r1 = 0
            goto L_0x007a
        L_0x0079:
            r1 = 1
        L_0x007a:
            if (r9 == 0) goto L_0x0093
            if (r1 == 0) goto L_0x0093
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            if (r2 != 0) goto L_0x0093
            float r10 = (float) r9
            float r2 = r8.getRatio()
            float r10 = r10 / r2
            int r10 = (int) r10
            goto L_0x00c4
        L_0x0093:
            if (r0 == 0) goto L_0x00ad
            if (r10 == 0) goto L_0x00ad
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00a1
            r2 = 1
            goto L_0x00a2
        L_0x00a1:
            r2 = 0
        L_0x00a2:
            if (r2 != 0) goto L_0x00ad
            float r9 = (float) r10
            float r2 = r8.getRatio()
            float r9 = r9 * r2
            int r9 = (int) r9
            goto L_0x00c4
        L_0x00ad:
            if (r0 == 0) goto L_0x00c1
            if (r1 == 0) goto L_0x00c1
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00bb
            r2 = 1
            goto L_0x00bc
        L_0x00bb:
            r2 = 0
        L_0x00bc:
            if (r2 == 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r2 = 0
            goto L_0x00c2
        L_0x00c1:
            r2 = 1
        L_0x00c2:
            if (r2 == 0) goto L_0x00f6
        L_0x00c4:
            if (r0 != 0) goto L_0x00c8
            if (r1 == 0) goto L_0x00d5
        L_0x00c8:
            float r0 = r8.getRatio()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00d2
            r0 = 1
            goto L_0x00d3
        L_0x00d2:
            r0 = 0
        L_0x00d3:
            if (r0 != 0) goto L_0x00d6
        L_0x00d5:
            r3 = 1
        L_0x00d6:
            if (r3 == 0) goto L_0x00ea
            r8.f57843i = r9
            r8.f57844j = r10
            r0 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r0)
            super.onMeasure(r9, r10)
            return
        L_0x00ea:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "ratio should be set"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00f6:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "layout_width or layout_height should be set to a fixed value when ratio is used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0102:
            float r9 = r8.getMinRatio()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.String r10 = "Landscape ratio must be >= "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L_0x011a:
            float r9 = r8.getMinRatio()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.String r10 = "Portrait ratio must be <= "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.views.ScanView.onMeasure(int, int):void");
    }

    public void pause() {
        JumioCameraManager jumioCameraManager;
        JumioCameraManager jumioCameraManager2 = this.f57839e;
        if ((jumioCameraManager2 != null && !jumioCameraManager2.isPausePreview()) && (jumioCameraManager = this.f57839e) != null) {
            jumioCameraManager.stopPreview(false);
        }
    }

    public void resume() {
        JumioCameraManager jumioCameraManager;
        JumioSDK.Companion companion = JumioSDK.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (companion.hasAllRequiredPermissions(context)) {
            JumioCameraManager jumioCameraManager2 = this.f57839e;
            if ((jumioCameraManager2 != null && !jumioCameraManager2.isPausePreview()) && (jumioCameraManager = this.f57839e) != null) {
                jumioCameraManager.startPreview();
                return;
            }
            return;
        }
        C19496o0 o0Var = this.f57837c;
        if (o0Var != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            o0Var.mo148695a((Throwable) new MissingPermissionException(companion.getMissingPermissions(context2)));
        }
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        JumioCameraFacing[] i;
        Intrinsics.checkNotNullParameter(jumioCameraFacing, "value");
        C19496o0 o0Var = this.f57837c;
        boolean z = true;
        if (o0Var == null || (i = o0Var.mo148704i()) == null || !ArraysKt.contains((T[]) i, jumioCameraFacing)) {
            z = false;
        }
        if (z) {
            this.f57847m = jumioCameraFacing;
            JumioCameraManager jumioCameraManager = this.f57839e;
            if (jumioCameraManager != null) {
                jumioCameraManager.setCameraFacing(jumioCameraFacing);
                Analytics.Companion.add(MobileEvents.userAction$default("camera", (JumioScanStep) null, jumioCameraFacing.name(), 2, (Object) null));
            }
        }
    }

    public final void setCameraInterface(C20999a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.f57842h = aVar;
    }

    public final void setCameraManager$jumio_core_release(JumioCameraManager jumioCameraManager) {
        this.f57839e = jumioCameraManager;
    }

    public final void setDrawViewInterface(C19505t.C19506a aVar) {
        this.f57838d = aVar;
    }

    public void setExtraction(boolean z) {
        C19496o0 o0Var = this.f57837c;
        if (o0Var != null) {
            o0Var.mo148696a(z);
        }
    }

    public void setFlash(boolean z) {
        this.f57848n = z;
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager != null) {
            jumioCameraManager.setFlash(z);
            Analytics.Companion.add(MobileEvents.userAction$default("flash", (JumioScanStep) null, this.f57848n ? "ON" : "OFF", 2, (Object) null));
        }
    }

    public final void setOldHeight(int i) {
        this.f57846l = i;
    }

    public final void setOldWidth(int i) {
        this.f57845k = i;
    }

    public final void setPreviewProperties$jumio_core_release(PreviewProperties previewProperties) {
        Intrinsics.checkNotNullParameter(previewProperties, "<set-?>");
        this.f57835a = previewProperties;
    }

    public abstract void setRatio(float f);

    public final void setScanOverlayView(C19505t tVar) {
        this.f57841g = tVar;
    }

    public final void setScanViewInterface(C19496o0 o0Var) {
        this.f57837c = o0Var;
    }

    public final void setTextureView(TextureView textureView) {
        this.f57840f = textureView;
    }

    public final void setUiHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.f57836b = handler;
    }

    public final void setViewHeight(int i) {
        this.f57844j = i;
    }

    public final void setViewWidth(int i) {
        this.f57843i = i;
    }

    public void stopPreview$jumio_core_release(boolean z) {
        JumioCameraManager jumioCameraManager = this.f57839e;
        if (jumioCameraManager != null) {
            jumioCameraManager.stopPreview(z);
        }
    }

    public void switchCamera() {
        if (getHasMultipleCameras()) {
            JumioCameraManager jumioCameraManager = this.f57839e;
            if (jumioCameraManager != null) {
                jumioCameraManager.changeCamera();
            }
            Analytics.Companion.add(MobileEvents.userAction$default("camera", (JumioScanStep) null, getCameraFacing().name(), 2, (Object) null));
        }
    }

    public void takePicture() {
        C19496o0 o0Var = this.f57837c;
        if (o0Var != null) {
            o0Var.mo148702g();
        }
    }

    public final void update$jumio_core_release(boolean z) {
        this.f57836b.post(new Runnable(z, this) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ ScanView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                ScanView.m43829a(this.f$0, this.f$1);
            }
        });
    }

    public ScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f57835a = new PreviewProperties();
        this.f57836b = new Handler(Looper.getMainLooper());
        this.f57842h = new C20999a(this);
        this.f57847m = JumioCameraFacing.BACK;
    }
}
