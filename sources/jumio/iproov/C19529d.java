package jumio.iproov;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.IProovException;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.Size;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.Controller;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.IproovValidateModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.provider.IproovProvider;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.core.util.DeviceUtil;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import com.taxis99.R;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* renamed from: jumio.iproov.d */
/* compiled from: IproovScanPart.kt */
public final class C19529d extends ScanPart<FaceScanPartModel> implements IProov.Listener, ApiBinding {

    /* renamed from: h */
    public static final String f55474h = C19529d.class.getSimpleName();

    /* renamed from: i */
    public static final C19534e f55475i = new C19534e();

    /* renamed from: a */
    public int f55476a;

    /* renamed from: b */
    public int f55477b;

    /* renamed from: c */
    public IproovProvider f55478c;

    /* renamed from: d */
    public Bitmap f55479d;

    /* renamed from: e */
    public SettingsModel f55480e;

    /* renamed from: f */
    public IproovTokenModel f55481f;

    /* renamed from: g */
    public IproovValidateModel f55482g;

    /* renamed from: jumio.iproov.d$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C19530a {
        public C19530a() {
        }

        public /* synthetic */ C19530a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jumio.iproov.d$b */
    /* compiled from: IproovScanPart.kt */
    public /* synthetic */ class C19531b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55483a;

        static {
            int[] iArr = new int[C19535f.values().length];
            iArr[C19535f.UPFRONT_HELP.ordinal()] = 1;
            iArr[C19535f.TOKEN_REQUEST.ordinal()] = 2;
            iArr[C19535f.RETRY_HELP.ordinal()] = 3;
            iArr[C19535f.VALIDATE.ordinal()] = 4;
            f55483a = iArr;
        }
    }

    /* renamed from: jumio.iproov.d$c */
    /* compiled from: IproovScanPart.kt */
    public static final class C19532c extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        public final /* synthetic */ C19529d f55484a;

        /* renamed from: b */
        public final /* synthetic */ Ref.ObjectRef<File> f55485b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C19532c(C19529d dVar, Ref.ObjectRef<File> objectRef) {
            super(0);
            this.f55484a = dVar;
            this.f55485b = objectRef;
        }

        /* renamed from: a */
        public final void mo148825a() {
            String str;
            Bitmap a = this.f55484a.f55479d;
            if ((a != null && !a.isRecycled()) && this.f55485b.element != null) {
                CameraUtils.saveBitmap(this.f55484a.f55479d, (File) this.f55485b.element, Bitmap.CompressFormat.WEBP, 75, this.f55484a.getController().getAuthorizationModel().getSessionKey());
            }
            ImageData.Image image = ((FaceScanPartModel) this.f55484a.getScanPartModel()).getImageData().getImage();
            File file = (File) this.f55485b.element;
            if (file == null || (str = file.getAbsolutePath()) == null) {
                str = "";
            }
            image.setPath(str);
            LivenessDataModel livenessDataModel = new LivenessDataModel();
            livenessDataModel.setType(ScanMode.FACE_IPROOV);
            livenessDataModel.setPassed(Boolean.valueOf(this.f55484a.mo148801c().getPassed()));
            ((FaceScanPartModel) this.f55484a.getScanPartModel()).setLivenessData(livenessDataModel);
            this.f55484a.setComplete(true);
            ScanPart.sendScanStep$default(this.f55484a, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
        }

        public /* synthetic */ Object invoke() {
            mo148825a();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jumio.iproov.d$d */
    /* compiled from: IproovScanPart.kt */
    public static final class C19533d extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        public final /* synthetic */ C19529d f55486a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C19533d(C19529d dVar) {
            super(0);
            this.f55486a = dVar;
        }

        /* renamed from: a */
        public final void mo148826a() {
            this.f55486a.mo148813i();
        }

        public /* synthetic */ Object invoke() {
            mo148826a();
            return Unit.INSTANCE;
        }
    }

    static {
        new C19530a((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C19529d(com.jumio.core.Controller r7, com.jumio.sdk.credentials.JumioFaceCredential r8, com.jumio.core.models.FaceScanPartModel r9, com.jumio.sdk.interfaces.JumioScanPartInterface r10) {
        /*
            r6 = this;
            java.lang.String r0 = "controller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "credential"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scanPartModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "scanPartInterface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r6.<init>(r7, r8, r9, r10)
            r6.reset()
            com.jumio.core.persistence.DataManager r8 = r7.getDataManager()
            java.lang.Class<com.jumio.core.models.IproovTokenModel> r9 = com.jumio.core.models.IproovTokenModel.class
            java.io.Serializable r8 = r8.get(r9)
            com.jumio.core.models.IproovTokenModel r8 = (com.jumio.core.models.IproovTokenModel) r8
            r6.f55481f = r8
            com.jumio.core.persistence.DataManager r8 = r7.getDataManager()
            java.lang.Class<com.jumio.core.models.SettingsModel> r9 = com.jumio.core.models.SettingsModel.class
            java.io.Serializable r8 = r8.get(r9)
            com.jumio.core.models.SettingsModel r8 = (com.jumio.core.models.SettingsModel) r8
            r6.f55480e = r8
            com.jumio.core.models.IproovTokenModel r8 = r6.f55481f
            java.lang.String r8 = r8.getToken()
            int r8 = r8.length()
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0046
            r8 = 1
            goto L_0x0047
        L_0x0046:
            r8 = 0
        L_0x0047:
            if (r8 != 0) goto L_0x0060
            com.jumio.core.models.IproovTokenModel r8 = r6.f55481f
            java.lang.String r8 = r8.getUrl()
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0057
            r8 = 1
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 == 0) goto L_0x005b
            goto L_0x0060
        L_0x005b:
            com.jumio.core.models.SettingsModel r7 = r6.f55480e
            r6.f55478c = r7
            goto L_0x0071
        L_0x0060:
            com.jumio.core.error.Error r8 = new com.jumio.core.error.Error
            com.jumio.core.enums.ErrorCase r1 = com.jumio.core.enums.ErrorCase.OCR_LOADING_FAILED
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 2
            r1 = 0
            com.jumio.core.Controller.onError$default(r7, r8, r1, r0, r1)
        L_0x0071:
            com.jumio.core.provider.IproovProvider r7 = r6.f55478c
            if (r7 != 0) goto L_0x0077
            r7 = 3
            goto L_0x007b
        L_0x0077:
            int r7 = r7.getIproovMaxAttempts()
        L_0x007b:
            r6.f55476a = r7
            jumio.iproov.e r7 = f55475i
            r7.mo148827a(r6)
            boolean r8 = r6.mo148800b()
            r8 = r8 ^ r9
            com.iproov.sdk.IProov.registerListener(r7, r8)
            r6.mo148799a((boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C19529d.<init>(com.jumio.core.Controller, com.jumio.sdk.credentials.JumioFaceCredential, com.jumio.core.models.FaceScanPartModel, com.jumio.sdk.interfaces.JumioScanPartInterface):void");
    }

    /* renamed from: b */
    public final boolean mo148800b() {
        HashMap<String, Serializable> data = ((FaceScanPartModel) getScanPartModel()).getData();
        Serializable serializable = data.get("firstStart");
        if (serializable == null) {
            serializable = Boolean.TRUE;
            data.put("firstStart", serializable);
        }
        return ((Boolean) serializable).booleanValue();
    }

    /* renamed from: c */
    public final IproovValidateModel mo148801c() {
        IproovValidateModel iproovValidateModel = this.f55482g;
        if (iproovValidateModel != null) {
            return iproovValidateModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iproovValidateModel");
        return null;
    }

    public void cancel() {
        reset();
        if (mo148803d() != C19535f.UPFRONT_HELP) {
            mo148798a(C19535f.RETRY_HELP);
        }
        getController().getBackendManager().cancelCall(true);
        C19534e eVar = f55475i;
        eVar.mo148827a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
        super.cancel();
    }

    /* renamed from: d */
    public final C19535f mo148803d() {
        HashMap<String, Serializable> data = ((FaceScanPartModel) getScanPartModel()).getData();
        Serializable serializable = data.get("state");
        if (serializable == null) {
            serializable = C19535f.UPFRONT_HELP;
            data.put("state", serializable);
        }
        return (C19535f) serializable;
    }

    /* renamed from: e */
    public final boolean mo148804e() {
        return StringsKt.equals(this.f55481f.getProductType(), "iproov_premium", true);
    }

    /* renamed from: f */
    public final void mo148805f() {
        try {
            IProov.launch(getController().getContext(), this.f55481f.getUrl(), this.f55481f.getToken(), mo148793a());
        } catch (Exception e) {
            Log.m43651e(f55474h, "Error on launching Iproov", (Throwable) e);
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo148796a(new JumioRetryReason(1, string));
        }
    }

    public void finish() {
        C19534e eVar = f55475i;
        eVar.mo148827a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
        super.finish();
    }

    /* renamed from: g */
    public final void mo148807g() {
        ((FaceScanPartModel) getScanPartModel()).getImageData().setCameraPosition(ImageData.CameraPosition.FRONT);
        ((FaceScanPartModel) getScanPartModel()).getImageData().setOrientationMode(ScreenAngle.PORTRAIT);
        ((FaceScanPartModel) getScanPartModel()).getImageData().setFlashMode(false);
        Size imageSize = ((FaceScanPartModel) getScanPartModel()).getImageData().getImageSize();
        Bitmap bitmap = this.f55479d;
        imageSize.width = bitmap == null ? 0 : bitmap.getWidth();
        Size imageSize2 = ((FaceScanPartModel) getScanPartModel()).getImageData().getImageSize();
        Bitmap bitmap2 = this.f55479d;
        imageSize2.height = bitmap2 == null ? 0 : bitmap2.getHeight();
        if (Log.isLogEnabledForLevel(Log.LogLevel.DEBUG) && this.f55479d != null) {
            LogUtils.dumpImageInSubfolder(this.f55479d, C19529d.class.getSimpleName(), Bitmap.CompressFormat.JPEG, 80, ((FaceScanPartModel) getScanPartModel()).getSide().toString());
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            File dataDirectory = Environment.getDataDirectory(getController().getContext());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "tmp_%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            objectRef.element = new File(dataDirectory, format);
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        async(new C19532c(this, objectRef));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 3
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.IproovTokenCall> r2 = com.jumio.core.api.calls.IproovTokenCall.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.IproovValidateCall> r2 = com.jumio.core.api.calls.IproovValidateCall.class
            r0[r1] = r2
            r1 = 2
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C19529d.getBindingClasses():java.lang.Class[]");
    }

    public boolean getHasFallback() {
        return false;
    }

    public void getHelpAnimation(JumioAnimationView jumioAnimationView) {
        Intrinsics.checkNotNullParameter(jumioAnimationView, "animationView");
        jumioAnimationView.removeAllViews();
        View inflate = LayoutInflater.from(jumioAnimationView.getContext()).inflate(R.layout.iproov_custom_animation, jumioAnimationView, false);
        if (inflate != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            jumioAnimationView.addView(constraintLayout);
            C19526c cVar = new C19526c(jumioAnimationView.getContext());
            View findViewById = constraintLayout.findViewById(R.id.iproov_help_animation);
            if (findViewById != null) {
                cVar.mo148788a((MotionLayout) findViewById, mo148804e());
                HashMap<Integer, Integer> a = mo148794a(jumioAnimationView.getContext());
                Integer num = a.get(Integer.valueOf(R.attr.iproov_animation_foreground)) != null ? a.get(Integer.valueOf(R.attr.iproov_animation_foreground)) : -16777216;
                Integer num2 = a.get(Integer.valueOf(R.attr.iproov_animation_background)) != null ? a.get(Integer.valueOf(R.attr.iproov_animation_background)) : -1;
                if (num2 != null) {
                    jumioAnimationView.setBackgroundColor(num2.intValue());
                }
                if (!(num == null || num2 == null)) {
                    Resources resources = jumioAnimationView.getContext().getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "animationView.context.resources");
                    cVar.mo148787a(resources, num.intValue(), num2.intValue());
                }
                cVar.mo148786a();
                jumioAnimationView.setTag(cVar);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.motion.widget.MotionLayout");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public JumioScanMode getScanMode() {
        return JumioScanMode.FACE_IPROOV;
    }

    /* renamed from: h */
    public final void mo148812h() {
        mo148798a(C19535f.TOKEN_REQUEST);
        getController().getBackendManager().requestIproovToken();
    }

    /* renamed from: i */
    public final void mo148813i() {
        C19535f d = mo148803d();
        C19535f fVar = C19535f.RETRY_HELP;
        if (d == fVar) {
            mo148812h();
        } else if (mo148803d() != C19535f.UPFRONT_HELP) {
            mo148798a(fVar);
            mo148812h();
        } else if (this.f55481f.getUsed()) {
            mo148812h();
        } else {
            if (this.f55481f.getToken().length() > 0) {
                mo148798a(C19535f.INITIALIZING);
                mo148805f();
                return;
            }
            Controller.onError$default(getController(), new Error(ErrorCase.OCR_LOADING_FAILED, 0, 2301), (Class) null, 2, (Object) null);
        }
    }

    public boolean isCancelable() {
        return (mo148803d() == C19535f.INITIALIZING || mo148803d() == C19535f.f55490c) ? false : true;
    }

    public void onCancelled() {
        if (mo148803d() == C19535f.f55490c || mo148803d() == C19535f.PROGRESS) {
            Log.m43655i(f55474h, "onIproovCancelled: ");
            mo148798a(C19535f.RETRY_HELP);
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo148796a(new JumioRetryReason(2, string));
            return;
        }
        Log.m43655i(f55474h, Intrinsics.stringPlus("onCancelled was triggered in state ", mo148803d()));
    }

    public void onConnected() {
        mo148798a(C19535f.f55490c);
        Log.m43655i(f55474h, Intrinsics.stringPlus("onIproovConnected: ", this.f55481f.getToken()));
        ((IproovTokenModel) getController().getDataManager().get(IproovTokenModel.class)).setUsed(true);
        MetaInfo analyticsScanData = getAnalyticsScanData();
        analyticsScanData.put("additionalData", mo148804e() ? "GPA" : "LA");
        ScanPart.sendScanStep$default(this, JumioScanStep.STARTED, (Object) null, analyticsScanData, 2, (Object) null);
    }

    public void onConnecting() {
        mo148798a(C19535f.INITIALIZING);
        Log.m43655i(f55474h, Intrinsics.stringPlus("onIproovConnecting: ", this.f55481f.getToken()));
    }

    public void onError(IProovException iProovException) {
        Intrinsics.checkNotNullParameter(iProovException, "e");
        C19522a a = C19522a.f55423c.mo148781a(iProovException);
        Log.m43655i(f55474h, Intrinsics.stringPlus("onIproovError: ", iProovException.getReason()));
        int c = a.mo148780c();
        String reason = iProovException.getReason();
        if (reason == null) {
            reason = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(reason, "controller.context.getSt…__error_unexpected_error)");
        }
        mo148796a(new JumioRetryReason(c, reason));
    }

    public void onFailure(IProov.FailureResult failureResult) {
        Intrinsics.checkNotNullParameter(failureResult, "failureResult");
        if (mo148803d() == C19535f.f55490c || mo148803d() == C19535f.PROGRESS) {
            C19524b a = C19524b.f55437d.mo148785a(failureResult.feedbackCode);
            Log.m43655i(f55474h, Intrinsics.stringPlus("onIproovFailure: ", a.mo148782b()));
            Bitmap bitmap = failureResult.frame;
            this.f55479d = bitmap;
            int i = this.f55477b + 1;
            this.f55477b = i;
            if (i < this.f55476a || bitmap == null) {
                int c = a.mo148783c();
                String string = getController().getContext().getString(a.mo148784d());
                Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…g(iproovFailure.stringId)");
                mo148796a(new JumioRetryReason(c, string));
                return;
            }
            mo148797a("");
            return;
        }
        Log.m43655i(f55474h, Intrinsics.stringPlus("failure callback was triggered in state ", mo148803d()));
    }

    public void onProcessing(double d, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (mo148803d() == C19535f.f55490c || mo148803d() == C19535f.PROGRESS) {
            C19535f d2 = mo148803d();
            C19535f fVar = C19535f.PROGRESS;
            if (d2 != fVar) {
                String str2 = f55474h;
                Log.m43655i(str2, "onProgress: " + ((int) (((double) 100) * d)) + " ; " + str);
                MetaInfo analyticsScanData = getAnalyticsScanData();
                analyticsScanData.put("additionalData", mo148804e() ? "GPA" : "LA");
                ScanPart.sendScanStep$default(this, JumioScanStep.IMAGE_TAKEN, (Object) null, analyticsScanData, 2, (Object) null);
            }
            mo148798a(fVar);
            String str3 = f55474h;
            Log.m43655i(str3, "onProgress: " + ((int) (d * ((double) 100))) + " ; " + str);
            return;
        }
        Log.m43655i(f55474h, Intrinsics.stringPlus("processing callback was triggered in state ", mo148803d()));
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        if (Intrinsics.areEqual((Object) call, (Object) IproovTokenCall.class)) {
            IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
            if (iproovTokenModel != null) {
                if ((iproovTokenModel.getToken().length() > 0) && !StringsKt.equals(iproovTokenModel.getToken(), this.f55481f.getToken(), true)) {
                    this.f55481f = iproovTokenModel;
                    mo148798a(C19535f.UPFRONT_HELP);
                    post(new C19533d(this));
                    return;
                }
            }
            Log.m43655i(f55474h, "Invalid token received from server");
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo148796a(new JumioRetryReason(209, string));
        } else if (!Intrinsics.areEqual((Object) call, (Object) IproovValidateCall.class)) {
        } else {
            if (obj != null) {
                mo148795a((IproovValidateModel) obj);
                if (mo148801c().getPassed()) {
                    mo148807g();
                } else if (this.f55477b < this.f55476a || this.f55479d == null) {
                    String string2 = getController().getContext().getString(R.string.iproov__error_unexpected_error);
                    Intrinsics.checkNotNullExpressionValue(string2, "controller.context.getSt…__error_unexpected_error)");
                    mo148796a(new JumioRetryReason(4, string2));
                } else {
                    mo148807g();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.models.IproovValidateModel");
            }
        }
    }

    public void onSuccess(IProov.SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "successResult");
        if (mo148803d() == C19535f.f55490c || mo148803d() == C19535f.PROGRESS) {
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("additionalData", successResult.token);
            Analytics.Companion.add(MobileEvents.misc("iproovSuccess", metaInfo));
            this.f55479d = successResult.frame;
            mo148797a(this.f55481f.getToken());
            return;
        }
        Log.m43655i(f55474h, Intrinsics.stringPlus("success callback was triggered in state ", mo148803d()));
    }

    public void persist() {
        super.persist();
        C19534e eVar = f55475i;
        eVar.mo148827a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        Intrinsics.checkNotNullParameter(jumioRetryReason, "reason");
        super.retry(jumioRetryReason);
        Log.m43655i(f55474h, Intrinsics.stringPlus("retry triggered for state ", mo148803d()));
        int i = C19531b.f55483a[mo148803d().ordinal()];
        if (i == 1) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            mo148813i();
        } else if (i == 2 || i == 3) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            mo148812h();
        } else if (i == 4) {
            mo148797a("");
        }
    }

    public void start() {
        super.start();
        ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
        mo148813i();
    }

    /* renamed from: a */
    public final void mo148798a(C19535f fVar) {
        ((FaceScanPartModel) getScanPartModel()).getData().put("state", fVar);
    }

    /* renamed from: a */
    public final void mo148799a(boolean z) {
        ((FaceScanPartModel) getScanPartModel()).getData().put("firstStart", Boolean.valueOf(z));
    }

    /* renamed from: a */
    public final void mo148795a(IproovValidateModel iproovValidateModel) {
        Intrinsics.checkNotNullParameter(iproovValidateModel, "<set-?>");
        this.f55482g = iproovValidateModel;
    }

    /* renamed from: a */
    public final void mo148796a(JumioRetryReason jumioRetryReason) {
        mo148798a(C19535f.RETRY_HELP);
        ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, jumioRetryReason, (Object) null, 4, (Object) null);
    }

    /* renamed from: a */
    public final void mo148797a(String str) {
        Log.m43655i(f55474h, Intrinsics.stringPlus("onIproovSuccess: ", str));
        mo148798a(C19535f.VALIDATE);
        ScanPart.sendScanStep$default(this, JumioScanStep.PROCESSING, (Object) null, (Object) null, 6, (Object) null);
        getController().getBackendManager().validateIproovToken();
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) call, (Object) UploadCall.class) ? true : Intrinsics.areEqual((Object) call, (Object) IproovTokenCall.class))) {
            z = Intrinsics.areEqual((Object) call, (Object) IproovValidateCall.class);
        }
        if (z) {
            getController().onError(th, apiCallDataModel.getCall());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7 A[LOOP:0: B:26:0x00ad->B:32:0x00c7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[EDGE_INSN: B:36:0x00cf->B:35:0x00cf ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.Integer, java.lang.Integer> mo148794a(android.content.Context r9) {
        /*
            r8 = this;
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            boolean r1 = r9 instanceof com.jumio.core.MobileContext
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r1 = r9
            com.jumio.core.MobileContext r1 = (com.jumio.core.MobileContext) r1
            int r3 = r1.getCustomThemeId()
            if (r3 == 0) goto L_0x0021
            androidx.appcompat.view.ContextThemeWrapper r3 = new androidx.appcompat.view.ContextThemeWrapper
            int r1 = r1.getCustomThemeId()
            r3.<init>((android.content.Context) r9, (int) r1)
            android.content.res.Resources$Theme r1 = r3.getTheme()
            goto L_0x0029
        L_0x0021:
            if (r9 != 0) goto L_0x0025
            r1 = r2
            goto L_0x0029
        L_0x0025:
            android.content.res.Resources$Theme r1 = r9.getTheme()
        L_0x0029:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4 = 2132017569(0x7f1401a1, float:1.967342E38)
            r5 = 0
            r6 = 1
            if (r1 != 0) goto L_0x0036
            goto L_0x0041
        L_0x0036:
            r7 = 2130969461(0x7f040375, float:1.7547605E38)
            boolean r1 = r1.resolveAttribute(r7, r0, r6)     // Catch:{ Exception -> 0x00c9 }
            if (r1 != r6) goto L_0x0041
            r1 = 1
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            if (r1 == 0) goto L_0x0046
            int r4 = r0.data     // Catch:{ Exception -> 0x00c9 }
        L_0x0046:
            r0 = 13
            int[] r0 = new int[r0]     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969459(0x7f040373, float:1.75476E38)
            r0[r5] = r1     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969458(0x7f040372, float:1.7547598E38)
            r0[r6] = r1     // Catch:{ Exception -> 0x00c9 }
            r1 = 2
            r6 = 2130969460(0x7f040374, float:1.7547603E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 3
            r6 = 2130969469(0x7f04037d, float:1.754762E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 4
            r6 = 2130969468(0x7f04037c, float:1.7547619E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 5
            r6 = 2130969467(0x7f04037b, float:1.7547617E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 6
            r6 = 2130969463(0x7f040377, float:1.7547609E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 7
            r6 = 2130969462(0x7f040376, float:1.7547607E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 8
            r6 = 2130969470(0x7f04037e, float:1.7547623E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 9
            r6 = 2130969471(0x7f04037f, float:1.7547625E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 10
            r6 = 2130969465(0x7f040379, float:1.7547613E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 11
            r6 = 2130969464(0x7f040378, float:1.754761E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969466(0x7f04037a, float:1.7547615E38)
            r6 = 12
            r0[r6] = r1     // Catch:{ Exception -> 0x00c9 }
            java.util.Arrays.sort(r0)     // Catch:{ Exception -> 0x00c9 }
            if (r9 != 0) goto L_0x00a1
            goto L_0x00ac
        L_0x00a1:
            android.content.res.Resources$Theme r9 = r9.getTheme()     // Catch:{ Exception -> 0x00c9 }
            if (r9 != 0) goto L_0x00a8
            goto L_0x00ac
        L_0x00a8:
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r4, r0)     // Catch:{ Exception -> 0x00c9 }
        L_0x00ac:
            r9 = 0
        L_0x00ad:
            int r1 = r9 + 1
            r4 = r0[r9]     // Catch:{ Exception -> 0x00c9 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00c9 }
            if (r2 != 0) goto L_0x00b9
            r9 = -1
            goto L_0x00bd
        L_0x00b9:
            int r9 = r2.getColor(r9, r5)     // Catch:{ Exception -> 0x00c9 }
        L_0x00bd:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00c9 }
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00c9 }
            if (r1 <= r6) goto L_0x00c7
            goto L_0x00cf
        L_0x00c7:
            r9 = r1
            goto L_0x00ad
        L_0x00c9:
            r9 = move-exception
            java.lang.String r0 = f55474h
            com.jumio.commons.log.Log.m43652e((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x00cf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C19529d.mo148794a(android.content.Context):java.util.HashMap");
    }

    /* renamed from: a */
    public final IProov.Options mo148793a() {
        IProov.Options options = new IProov.Options();
        IProov.Options.C20735UI ui = options.f56836ui;
        ui.genuinePresenceAssurance.autoStartDisabled = false;
        ui.enableScreenshots = DeviceUtil.isDebug(getController().getContext());
        HashMap<Integer, Integer> a = mo148794a((Context) getController().getContext());
        options.f56836ui.activityCompatibilityRequestCode = 4000;
        IProov.Options.C20735UI ui2 = options.f56836ui;
        ui2.title = "";
        ui2.filter = IProov.Filter.VIBRANT;
        ui2.orientation = Orientation.PORTRAIT;
        Integer num = a.get(Integer.valueOf(R.attr.iproov_footerTextColor));
        int i = -1;
        ui2.footerTextColor = num == null ? -1 : num.intValue();
        IProov.Options.C20735UI ui3 = options.f56836ui;
        Integer num2 = a.get(Integer.valueOf(R.attr.iproov_headerTextColor));
        ui3.headerTextColor = num2 == null ? -1 : num2.intValue();
        IProov.Options.C20735UI.GenuinePresenceAssurance genuinePresenceAssurance = options.f56836ui.genuinePresenceAssurance;
        Integer num3 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_progressBarColor));
        genuinePresenceAssurance.progressBarColor = num3 == null ? Color.parseColor("#FF000000") : num3.intValue();
        IProov.Options.C20735UI ui4 = options.f56836ui;
        Integer num4 = a.get(Integer.valueOf(R.attr.iproov_headerBackgroundColor));
        ui4.headerBackgroundColor = num4 == null ? Color.parseColor("#AA000000") : num4.intValue();
        IProov.Options.C20735UI ui5 = options.f56836ui;
        Integer num5 = a.get(Integer.valueOf(R.attr.iproov_footerBackgroundColor));
        ui5.footerBackgroundColor = num5 == null ? Color.parseColor("#AA000000") : num5.intValue();
        IProov.Options.C20735UI.LivenessAssurance livenessAssurance = options.f56836ui.livenessAssurance;
        Integer num6 = a.get(Integer.valueOf(R.attr.iproov_livenessAssurance_primaryTintColor));
        livenessAssurance.primaryTintColor = num6 == null ? Color.parseColor("#2ABC6D") : num6.intValue();
        IProov.Options.C20735UI.LivenessAssurance livenessAssurance2 = options.f56836ui.livenessAssurance;
        Integer num7 = a.get(Integer.valueOf(R.attr.iproov_livenessAssurance_secondaryTintColor));
        if (num7 != null) {
            i = num7.intValue();
        }
        livenessAssurance2.secondaryTintColor = i;
        IProov.Options.C20735UI ui6 = options.f56836ui;
        Integer num8 = a.get(Integer.valueOf(R.attr.iproov_backgroundColor));
        ui6.backgroundColor = num8 == null ? Color.parseColor("#FAFAFA") : num8.intValue();
        IProov.Options.C20735UI ui7 = options.f56836ui;
        Integer num9 = a.get(Integer.valueOf(R.attr.iproov_lineColor));
        int i2 = -16777216;
        ui7.lineColor = num9 == null ? -16777216 : num9.intValue();
        IProov.Options.C20735UI.GenuinePresenceAssurance genuinePresenceAssurance2 = options.f56836ui.genuinePresenceAssurance;
        Integer num10 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_notReadyTintColor));
        genuinePresenceAssurance2.notReadyTintColor = num10 == null ? -16776961 : num10.intValue();
        IProov.Options.C20735UI.GenuinePresenceAssurance genuinePresenceAssurance3 = options.f56836ui.genuinePresenceAssurance;
        Integer num11 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_readyTintColor));
        if (num11 != null) {
            i2 = num11.intValue();
        }
        genuinePresenceAssurance3.readyTintColor = i2;
        options.capture.faceDetector = IProov.FaceDetector.AUTO;
        return options;
    }
}
