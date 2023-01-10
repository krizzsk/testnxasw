package com.jumio.core.scanpart;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.Controller;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.api.calls.UsabilityCall;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.StaticModel;
import com.jumio.core.model.SubscriberWithUpdate;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.views.ScanView;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import com.jumio.sdk.views.JumioConfirmationView;
import com.jumio.sdk.views.JumioRejectView;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import jumio.core.C19467c0;
import jumio.core.C19476f0;
import jumio.core.C19478g0;
import jumio.core.C19479h;
import jumio.core.C19481i;
import jumio.core.C19483j;
import jumio.core.C19494n0;
import jumio.core.C19496o0;
import jumio.core.C19501r;
import jumio.core.C19505t;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u00020\fB'\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0017J\u001e\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u0017H\u0016J\u001e\u0010\u0012\u001a\u00020\u000e2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006!"}, mo148868d2 = {"Lcom/jumio/core/scanpart/JVisionScanPart;", "Lcom/jumio/core/models/ScanPartModel;", "T", "Lcom/jumio/core/scanpart/ScanPart;", "Ljumio/core/o0;", "Ljumio/core/t$a;", "Ljumio/core/h;", "Ljumio/core/f0;", "Ljumio/core/j;", "Lcom/jumio/core/model/SubscriberWithUpdate;", "Lcom/jumio/core/extraction/ExtractionClient$ExtractionUpdate;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/network/ApiBinding;", "result", "", "onResult", "", "error", "onError", "extractionUpdate", "onUpdate", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "Lcom/jumio/core/Controller;", "controller", "Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "scanPartModel", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "<init>", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioCredential;Lcom/jumio/core/models/ScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JVisionScanPart.kt */
public abstract class JVisionScanPart<T extends ScanPartModel> extends ScanPart<T> implements SubscriberWithUpdate<ExtractionClient.ExtractionUpdate<?>, StaticModel>, ApiBinding, C19476f0, C19479h, C19483j, C19496o0, C19505t.C19506a {

    /* renamed from: h */
    public final int f57815h = 75;

    /* renamed from: i */
    public ExtractionClient f57816i;

    /* renamed from: j */
    public SettingsModel f57817j;

    /* renamed from: k */
    public ExtractionPlugin f57818k;

    /* renamed from: l */
    public Overlay f57819l;

    /* renamed from: m */
    public int f57820m;

    /* renamed from: n */
    public Bitmap f57821n;

    /* renamed from: o */
    public C19481i<?> f57822o;

    /* renamed from: p */
    public ScanView f57823p;

    /* renamed from: com.jumio.core.scanpart.JVisionScanPart$a */
    /* compiled from: JVisionScanPart.kt */
    public /* synthetic */ class C20995a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57824a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f57825b;

        static {
            int[] iArr = new int[ScanMode.values().length];
            iArr[ScanMode.MRP.ordinal()] = 1;
            iArr[ScanMode.MRV.ordinal()] = 2;
            iArr[ScanMode.MRV_A.ordinal()] = 3;
            iArr[ScanMode.MRV_B.ordinal()] = 4;
            iArr[ScanMode.TD1.ordinal()] = 5;
            iArr[ScanMode.TD2.ordinal()] = 6;
            iArr[ScanMode.CNIS.ordinal()] = 7;
            iArr[ScanMode.PDF417.ordinal()] = 8;
            iArr[ScanMode.LINEFINDER.ordinal()] = 9;
            iArr[ScanMode.FACE_MANUAL.ordinal()] = 10;
            iArr[ScanMode.FACE_IPROOV.ordinal()] = 11;
            iArr[ScanMode.MANUAL.ordinal()] = 12;
            iArr[ScanMode.NFC.ordinal()] = 13;
            f57824a = iArr;
            int[] iArr2 = new int[AutomationModel.C20978a.values().length];
            iArr2[AutomationModel.C20978a.REJECT.ordinal()] = 1;
            f57825b = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JVisionScanPart(Controller controller, JumioCredential jumioCredential, T t, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioCredential, t, jumioScanPartInterface);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        Intrinsics.checkNotNullParameter(t, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        Log.m43643d("init called");
        SettingsModel settingsModel = (SettingsModel) controller.getDataManager().get(SettingsModel.class);
        if (settingsModel != null) {
            this.f57817j = settingsModel;
            ExtractionPlugin a = mo172457a(t.getMode());
            this.f57818k = a;
            this.f57819l = a.getOverlay(controller.getContext());
            ExtractionClient extractionClient = this.f57818k.getExtractionClient(controller.getContext());
            extractionClient.subscribe(this);
            extractionClient.configure(controller.getDataManager(), t);
            Unit unit = Unit.INSTANCE;
            this.f57816i = extractionClient;
            return;
        }
        throw new IllegalArgumentException("ServerSettings not found".toString());
    }

    /* renamed from: a */
    public final void mo172462a(ExtractionClient extractionClient) {
        this.f57816i = extractionClient;
    }

    /* renamed from: b */
    public final void mo172465b(boolean z) {
        getScanPartModel().getData().put("previewPaused", Boolean.valueOf(z));
    }

    /* renamed from: c */
    public boolean mo148699c() {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient == null) {
            return false;
        }
        return extractionClient.isDataExtractionActive();
    }

    public void cancel() {
        super.cancel();
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
        getController().getBackendManager().cancelCall(true);
        reset();
        mo172467k();
    }

    /* renamed from: d */
    public boolean mo148700d() {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient == null) {
            return false;
        }
        return extractionClient.takePictureManually();
    }

    /* renamed from: e */
    public void mo148701e() {
        if (mo172471o()) {
            ScanView p = mo172473p();
            if (p != null) {
                p.stopPreview$jumio_core_release(true);
                return;
            }
            return;
        }
        ScanPart.sendScanStep$default(this, JumioScanStep.STARTED, (Object) null, getAnalyticsScanData(), 2, (Object) null);
    }

    /* renamed from: f */
    public void mo148643f() {
        C19481i<?> iVar = this.f57822o;
        if (iVar != null && (iVar instanceof JumioConfirmationView)) {
            setComplete(true);
            ScanPart.sendScanStep$default(this, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
            C19481i<?> iVar2 = this.f57822o;
            if (iVar2 != null) {
                iVar2.detach$jumio_core_release();
            }
            this.f57822o = null;
        }
    }

    public void finish() {
        mo172467k();
        super.finish();
    }

    /* renamed from: g */
    public void mo148702g() {
        ExtractionClient extractionClient;
        ExtractionClient extractionClient2 = this.f57816i;
        boolean z = true;
        if (extractionClient2 == null || !extractionClient2.takePictureManually()) {
            z = false;
        }
        if (z && (extractionClient = this.f57816i) != null) {
            extractionClient.takePicture();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.UsabilityCall> r2 = com.jumio.core.api.calls.UsabilityCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.getBindingClasses():java.lang.Class[]");
    }

    public boolean getHasFallback() {
        return false;
    }

    public void getHelpAnimation(JumioAnimationView jumioAnimationView) {
        Intrinsics.checkNotNullParameter(jumioAnimationView, "animationView");
    }

    public JumioScanMode getScanMode() {
        switch (C20995a.f57824a[getScanPartModel().getMode().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return JumioScanMode.MRZ;
            case 8:
                return JumioScanMode.BARCODE;
            case 9:
                return JumioScanMode.LINEFINDER;
            case 10:
                return JumioScanMode.FACE_MANUAL;
            case 11:
                return JumioScanMode.FACE_IPROOV;
            case 12:
                return JumioScanMode.MANUAL;
            case 13:
                return JumioScanMode.NFC;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: h */
    public boolean mo148703h() {
        return this.f57817j.isBrandingEnabled();
    }

    /* renamed from: i */
    public JumioCameraFacing[] mo148704i() {
        return new JumioCameraFacing[]{JumioCameraFacing.BACK, JumioCameraFacing.FRONT};
    }

    public boolean isCancelable() {
        return true;
    }

    /* renamed from: j */
    public final void mo172466j() {
        ScanPart.sendScanStep$default(this, JumioScanStep.SCAN_VIEW, (Object) null, (Object) null, 6, (Object) null);
        Overlay overlay = this.f57819l;
        if (overlay != null) {
            overlay.setVisible(0);
        }
    }

    /* renamed from: k */
    public final void mo172467k() {
        ScanView p = mo172473p();
        if (p != null) {
            p.detach$jumio_core_release();
        }
        C19481i<?> iVar = this.f57822o;
        if (iVar != null) {
            iVar.detach$jumio_core_release();
        }
        mo172465b(false);
        Bitmap bitmap = this.f57821n;
        if (bitmap != null) {
            bitmap.recycle();
        }
        System.gc();
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.unsubscribe(this);
            extractionClient.destroy();
        }
    }

    /* renamed from: l */
    public final ExtractionClient mo172468l() {
        return this.f57816i;
    }

    /* renamed from: m */
    public final Overlay mo172469m() {
        return this.f57819l;
    }

    /* renamed from: n */
    public final ExtractionPlugin mo172470n() {
        return this.f57818k;
    }

    /* renamed from: o */
    public final boolean mo172471o() {
        HashMap<String, Serializable> data = getScanPartModel().getData();
        Serializable serializable = data.get("previewPaused");
        if (serializable == null) {
            serializable = Boolean.FALSE;
            data.put("previewPaused", serializable);
        }
        return ((Boolean) serializable).booleanValue();
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th) {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
        ScanView p = mo172473p();
        if (p != null) {
            p.stopPreview$jumio_core_release(true);
        }
        mo172465b(true);
        Controller.onError$default(getController(), th, (Class) null, 2, (Object) null);
    }

    /* renamed from: p */
    public ScanView mo172473p() {
        return this.f57823p;
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        Intrinsics.checkNotNullParameter(jumioRetryReason, "reason");
        super.retry(jumioRetryReason);
        getScanPartModel().getImageData().clear();
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.cancel();
            extractionClient.reinit();
            extractionClient.setDataExtractionActive(true);
        }
        mo172466j();
    }

    public void start() {
        super.start();
        mo172466j();
    }

    /* renamed from: a */
    public final void mo172464a(ExtractionPlugin extractionPlugin) {
        Intrinsics.checkNotNullParameter(extractionPlugin, "<set-?>");
        this.f57818k = extractionPlugin;
    }

    /* renamed from: b */
    public Size mo148698b() {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient == null) {
            return null;
        }
        return extractionClient.getPreferredPreviewSize();
    }

    public void onResult(StaticModel staticModel) {
        ScanView p = mo172473p();
        boolean z = true;
        if (p != null) {
            p.stopPreview$jumio_core_release(true);
        }
        mo172465b(true);
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
        ScanPartModel scanPartModel = getScanPartModel();
        if (this.f57820m >= this.f57817j.getAutomationMaxRetries()) {
            z = false;
        }
        scanPartModel.setUsability(z);
        getController().getBackendManager().uploadPart(getCredential(), getScanPartModel());
    }

    public void onUpdate(ExtractionClient.ExtractionUpdate<?> extractionUpdate) {
        Integer valueOf = extractionUpdate == null ? null : Integer.valueOf(extractionUpdate.getState());
        int i = ExtractionUpdateState.shotTaken;
        if (valueOf != null && valueOf.intValue() == i) {
            ScanPart.sendScanStep$default(this, JumioScanStep.IMAGE_TAKEN, (Object) null, getAnalyticsScanData(), 2, (Object) null);
            ImageData imageData = getScanPartModel().getImageData();
            ScanView p = mo172473p();
            if (p != null) {
                p.fillImageData$jumio_core_release(imageData);
            }
            ScanView p2 = mo172473p();
            if (p2 != null) {
                p2.stopPreview$jumio_core_release(true);
            }
            mo172465b(true);
            try {
                Object systemService = getController().getContext().getSystemService("vibrator");
                if (systemService != null) {
                    Vibrator vibrator = (Vibrator) systemService;
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(100, -1));
                    } else {
                        vibrator.vibrate(100);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
                }
            } catch (Exception unused) {
            }
        } else {
            int i2 = ExtractionUpdateState.saveImage;
            if (valueOf != null && valueOf.intValue() == i2) {
                Object data = extractionUpdate.getData();
                if (data != null) {
                    Bitmap bitmap = (Bitmap) data;
                    if (Log.isLogEnabledForLevel(Log.LogLevel.DEBUG)) {
                        ExtractionClient extractionClient = this.f57816i;
                        String simpleName = extractionClient == null ? "null" : extractionClient.getClass().getSimpleName();
                        LogUtils.dumpImageInSubfolder(bitmap, simpleName, Bitmap.CompressFormat.JPEG, 80, getScanPartModel().getSide().name());
                        LogUtils.dumpImageInSubfolder(bitmap, simpleName, Bitmap.CompressFormat.WEBP, 75, getScanPartModel().getSide().name());
                    }
                    File dataDirectory = Environment.getDataDirectory(getController().getContext());
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.ENGLISH, "tmp_%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                    File file = new File(dataDirectory, format);
                    if (!bitmap.isRecycled()) {
                        CameraUtils.saveBitmap(bitmap, file, Bitmap.CompressFormat.WEBP, this.f57815h, getController().getAuthorizationModel().getSessionKey());
                    }
                    ImageData.Image image = getScanPartModel().getImageData().getImage();
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                    image.setPath(absolutePath);
                    getScanPartModel().getImageData().getImage().setType(ImageData.FileType.WEBP);
                    getScanPartModel().getImageData().getImage().getSize().width = bitmap.getWidth();
                    getScanPartModel().getImageData().getImage().getSize().height = bitmap.getHeight();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.Bitmap");
            }
            Overlay overlay = this.f57819l;
            if (overlay != null) {
                overlay.update(extractionUpdate);
                ScanView p3 = mo172473p();
                if (p3 != null) {
                    p3.update$jumio_core_release(false);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo172463a(Overlay overlay) {
        this.f57819l = overlay;
    }

    /* renamed from: a */
    public ExtractionPlugin mo172457a(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "scanMode");
        C19467c0 b = C20991a.m43783b(getScanPluginMode(scanMode));
        Intrinsics.checkNotNullExpressionValue(b, "getPlugin(getScanPluginMode(scanMode))");
        return (ExtractionPlugin) b;
    }

    /* renamed from: a */
    public void mo148738a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootview");
        Overlay overlay = this.f57819l;
        if (overlay != null) {
            overlay.addViews(viewGroup);
        }
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        if (Intrinsics.areEqual((Object) call, (Object) UploadCall.class)) {
            getController().onError(th, apiCallDataModel.getCall());
        } else if (Intrinsics.areEqual((Object) call, (Object) UsabilityCall.class)) {
            onResult(apiCallDataModel, new AutomationModel((AutomationModel.C20978a) null, (C19478g0) null, (String) null, 7, (DefaultConstructorMarker) null));
            getController().getBackendManager().remove(UsabilityCall.class);
        }
    }

    /* renamed from: a */
    public void mo148737a(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Overlay overlay = this.f57819l;
        if (overlay != null) {
            overlay.doDraw(canvas);
        }
    }

    /* renamed from: a */
    public void mo148736a(int i, int i2) {
        ScanView p;
        Overlay overlay = this.f57819l;
        if (overlay != null && (p = mo172473p()) != null) {
            overlay.setScanPart(getScanPartModel());
            boolean z = false;
            overlay.calculate(new Rect(0, 0, i, i2));
            if (p.getCameraFacing() == JumioCameraFacing.FRONT) {
                z = true;
            }
            overlay.prepareDraw(z);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00ab */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(com.jumio.core.models.ApiCallDataModel<?> r11, java.lang.Object r12) {
        /*
            r10 = this;
            java.lang.String r0 = "apiCallDataModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.Class r0 = r11.getCall()
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r1 = com.jumio.core.api.calls.UploadCall.class
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0093
            java.util.HashMap r11 = r11.getData()
            java.lang.String r0 = "DATA_UPLOAD_TYPE"
            java.lang.Object r11 = r11.get(r0)
            java.io.Serializable r11 = (java.io.Serializable) r11
            java.lang.String r0 = "DATA_UPLOAD_TYPE_DEFAULT"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x008d
            if (r12 == 0) goto L_0x0085
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            com.jumio.core.models.ScanPartModel r11 = r10.getScanPartModel()
            com.jumio.commons.camera.ImageData r11 = r11.getImageData()
            com.jumio.commons.camera.ImageData$Image r11 = r11.getImage()
            java.lang.String r11 = r11.getPath()
            r0 = 2
            java.lang.String r1 = "/"
            java.lang.String r11 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r11, (java.lang.String) r1, (java.lang.String) r3, (int) r0, (java.lang.Object) r3)
            java.lang.String r0 = "usabilityResultKeys"
            org.json.JSONObject r12 = r12.optJSONObject(r0)
            if (r12 != 0) goto L_0x004c
            goto L_0x0050
        L_0x004c:
            java.lang.String r3 = r12.optString(r11)
        L_0x0050:
            com.jumio.core.models.SettingsModel r11 = r10.f57817j
            boolean r11 = r11.isInstantFeedbackEnabled()
            if (r11 == 0) goto L_0x007a
            if (r3 == 0) goto L_0x007a
            int r11 = r3.length()
            if (r11 <= 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r2 = 0
        L_0x0062:
            if (r2 == 0) goto L_0x007a
            com.jumio.sdk.enums.JumioScanStep r5 = com.jumio.sdk.enums.JumioScanStep.PROCESSING
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r10
            com.jumio.core.scanpart.ScanPart.sendScanStep$default(r4, r5, r6, r7, r8, r9)
            com.jumio.core.Controller r11 = r10.getController()
            com.jumio.core.api.BackendManager r11 = r11.getBackendManager()
            r11.usability(r3)
            goto L_0x00d9
        L_0x007a:
            com.jumio.sdk.enums.JumioScanStep r5 = com.jumio.sdk.enums.JumioScanStep.CONFIRMATION_VIEW
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r10
            com.jumio.core.scanpart.ScanPart.sendScanStep$default(r4, r5, r6, r7, r8, r9)
            goto L_0x00d9
        L_0x0085:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "null cannot be cast to non-null type org.json.JSONObject"
            r11.<init>(r12)
            throw r11
        L_0x008d:
            java.lang.String r12 = "DATA_UPLOAD_TYPE_LIVENESS"
            kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            goto L_0x00d9
        L_0x0093:
            java.lang.Class<com.jumio.core.api.calls.UsabilityCall> r11 = com.jumio.core.api.calls.UsabilityCall.class
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x00d9
            if (r12 == 0) goto L_0x00d1
            com.jumio.core.models.automation.AutomationModel r12 = (com.jumio.core.models.automation.AutomationModel) r12
            com.jumio.core.models.automation.AutomationModel$a r11 = r12.mo172355a()
            jumio.core.g0 r12 = r12.mo172356b()
            com.jumio.core.network.ErrorMock.onAutomationResultMock()     // Catch:{ z -> 0x00ab }
            goto L_0x00ae
        L_0x00ab:
            throw r3     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            com.jumio.core.models.automation.AutomationModel$a r11 = com.jumio.core.models.automation.AutomationModel.C20978a.NOT_AVAILABLE
        L_0x00ae:
            int[] r0 = com.jumio.core.scanpart.JVisionScanPart.C20995a.f57825b
            int r11 = r11.ordinal()
            r11 = r0[r11]
            if (r11 != r2) goto L_0x00c6
            com.jumio.sdk.enums.JumioScanStep r11 = com.jumio.sdk.enums.JumioScanStep.REJECT_VIEW
            java.lang.String r0 = r12.mo148626a()
            java.lang.String r12 = r12.mo148626a()
            r10.sendScanStep(r11, r0, r12)
            goto L_0x00d9
        L_0x00c6:
            com.jumio.sdk.enums.JumioScanStep r2 = com.jumio.sdk.enums.JumioScanStep.CONFIRMATION_VIEW
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r10
            com.jumio.core.scanpart.ScanPart.sendScanStep$default(r1, r2, r3, r4, r5, r6)
            goto L_0x00d9
        L_0x00d1:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "null cannot be cast to non-null type com.jumio.core.models.automation.AutomationModel"
            r11.<init>(r12)
            throw r11
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.onResult(com.jumio.core.models.ApiCallDataModel, java.lang.Object):void");
    }

    /* renamed from: a */
    public void mo148696a(boolean z) {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.setDataExtractionActive(z);
        }
        if (!z) {
            onUpdate((ExtractionClient.ExtractionUpdate<?>) new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.resetOverlay, null));
        }
    }

    /* renamed from: a */
    public void mo148697a(byte[] bArr) {
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.feed(bArr);
        }
    }

    /* renamed from: a */
    public void mo148694a(ScanView scanView) {
        if (scanView != null) {
            ScanView scanView2 = this.f57823p;
            scanView.setCameraManager$jumio_core_release(scanView2 == null ? null : scanView2.getCameraManager$jumio_core_release());
        }
        this.f57823p = scanView;
    }

    /* renamed from: a */
    public void mo148695a(Throwable th) {
        Log.printStackTrace(th);
        onError(new Error(ErrorCase.NO_CAMERA_CONNECTION, 0, 0, 6, (DefaultConstructorMarker) null));
    }

    /* renamed from: a */
    public void mo148693a(PreviewProperties previewProperties) {
        Intrinsics.checkNotNullParameter(previewProperties, "properties");
        getController().getDataManager().put(PreviewProperties.class, previewProperties);
        Rect rect = null;
        ScanPart.sendUpdate$default(this, JumioScanUpdate.CAMERA_AVAILABLE, (Object) null, 2, (Object) null);
        ExtractionClient extractionClient = this.f57816i;
        if (extractionClient != null) {
            extractionClient.cancel();
            extractionClient.setPreviewProperties(previewProperties);
            ScanView p = mo172473p();
            if (p != null) {
                rect = p.getExtractionArea$jumio_core_release();
            }
            extractionClient.setExtractionArea(rect);
            extractionClient.reinit();
            extractionClient.setDataExtractionActive(true);
        }
    }

    /* renamed from: a */
    public void mo148630a(C19481i<?> iVar) {
        Intrinsics.checkNotNullParameter(iVar, "checkView");
        if ((getScanPartModel().getScanStep() == JumioScanStep.CONFIRMATION_VIEW && (iVar instanceof JumioConfirmationView)) || (getScanPartModel().getScanStep() == JumioScanStep.REJECT_VIEW && (iVar instanceof JumioRejectView))) {
            C19481i<?> iVar2 = this.f57822o;
            if (iVar2 != iVar) {
                if (iVar2 != null) {
                    iVar2.detach$jumio_core_release();
                }
                this.f57822o = iVar;
            }
            iVar.removeAllViews();
            C19494n0 n0Var = new C19494n0(getController().getContext());
            n0Var.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            Bitmap bitmap = this.f57821n;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f57821n = null;
            System.gc();
            Bitmap readBitmap = CameraUtils.readBitmap(getScanPartModel().getImageData().getImage().getPath(), getController().getAuthorizationModel().getSessionKey());
            this.f57821n = readBitmap;
            if (readBitmap != null) {
                n0Var.mo148683a(readBitmap, (float) iVar.getCornerRadius$jumio_core_release());
                iVar.addView(n0Var);
            }
        }
    }

    /* renamed from: a */
    public void mo148623a() {
        if (this.f57822o != null) {
            C19501r.m41217b(getController().getContext(), "Jumio03");
            this.f57820m++;
            getScanPartModel().getImageData().clear();
            ExtractionClient extractionClient = this.f57816i;
            if (extractionClient != null) {
                extractionClient.cancel();
                extractionClient.reinit();
                extractionClient.setDataExtractionActive(true);
            }
            mo172465b(false);
            mo172466j();
            C19481i<?> iVar = this.f57822o;
            if (iVar != null) {
                iVar.detach$jumio_core_release();
            }
            this.f57822o = null;
        }
    }
}
