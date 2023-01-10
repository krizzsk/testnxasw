package com.didi.nova.kyc.jumio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.nova.kyc.jumio.module.DataCacheInfo;
import com.didi.nova.kyc.jumio.module.JumioParams;
import com.didi.nova.kyc.jumio.p129vm.DDCustomVM;
import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.didi.nova.kyc.jumio.view.FaceGuideView;
import com.didi.nova.kyc.jumio.view.JumioConfirmCustomView;
import com.didi.nova.kyc.jumio.view.JumioRejectCustomView;
import com.didi.nova.kyc.jumio.view.JumioRetryCustomView;
import com.didi.nova.kyc.jumio.view.JumioScanCustomView;
import com.didi.nova.kyc.jumio.widget.BackDialogWindow;
import com.didi.payment.commonsdk.p130ui.WBaseActivity;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.spi.DDCustomViewData;
import com.didi.payment.commonsdk.utils.JumioFaceFinishEvent;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.GlobalCountryCode;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioActivityAttacher;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.osgi.framework.AdminPermission;

@Metadata(mo148867d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001qB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010302H\u0002J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000200H\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020\rH\u0002J\n\u0010:\u001a\u0004\u0018\u00010'H\u0014J\b\u0010;\u001a\u000200H\u0002J\b\u0010<\u001a\u000200H\u0002J\b\u0010=\u001a\u000200H\u0002J\u0012\u0010>\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u000103H\u0002J\b\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000200H\u0002J\b\u0010B\u001a\u000200H\u0002J+\u0010C\u001a\u0002002\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0E\"\u00020'2\b\b\u0002\u0010F\u001a\u00020\rH\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000200H\u0014J\b\u0010I\u001a\u000200H\u0002J\u0012\u0010J\u001a\u0002002\b\u0010K\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010L\u001a\u000200H\u0016J\u0012\u0010M\u001a\u0002002\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0010\u0010#\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u0002002\u0006\u0010Q\u001a\u00020RH\u0016J*\u0010S\u001a\u0002002\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020V0Uj\b\u0012\u0004\u0012\u00020V`W2\b\u0010X\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010Y\u001a\u000200H\u0014J\u001a\u0010Z\u001a\u0002002\u0006\u0010[\u001a\u00020\\2\b\u0010?\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020_2\b\u0010?\u001a\u0004\u0018\u000103H\u0016J\b\u0010`\u001a\u000200H\u0002J\u0012\u0010a\u001a\u0002002\b\u0010b\u001a\u0004\u0018\u00010VH\u0002J \u0010c\u001a\u0002002\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020e0Uj\b\u0012\u0004\u0012\u00020e`WH\u0002J\b\u0010f\u001a\u000200H\u0002J\b\u0010g\u001a\u00020\rH\u0002J\u0010\u0010h\u001a\u0002002\u0006\u0010i\u001a\u00020\u0007H\u0002J+\u0010j\u001a\u0002002\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0E\"\u00020'2\b\b\u0002\u0010k\u001a\u00020\rH\u0002¢\u0006\u0002\u0010GJ\b\u0010l\u001a\u000200H\u0002J\u0012\u0010m\u001a\u0002002\b\u0010n\u001a\u0004\u0018\u00010eH\u0002J\u0010\u0010o\u001a\u0002002\u0006\u0010p\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/DDCustomActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/nova/kyc/jumio/vm/DDCustomVM;", "Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "()V", "TAG", "", "backView", "Landroid/widget/ImageView;", "cacheInfo", "Lcom/didi/nova/kyc/jumio/module/DataCacheInfo;", "clickBack", "", "containerView", "Landroid/widget/LinearLayout;", "country", "credential", "Lcom/jumio/sdk/credentials/JumioCredential;", "error", "Lcom/jumio/sdk/error/JumioError;", "errorRetryCustomView", "Lcom/didi/nova/kyc/jumio/view/JumioRetryCustomView;", "faceGuideView", "Lcom/didi/nova/kyc/jumio/view/FaceGuideView;", "jumioConfirmCustomView", "Lcom/didi/nova/kyc/jumio/view/JumioConfirmCustomView;", "jumioController", "Lcom/jumio/sdk/controller/JumioController;", "jumioRejectCustomView", "Lcom/didi/nova/kyc/jumio/view/JumioRejectCustomView;", "jumioScanCustomView", "Lcom/didi/nova/kyc/jumio/view/JumioScanCustomView;", "mBackDialog", "Lcom/didi/nova/kyc/jumio/widget/BackDialogWindow;", "onError", "retryReason", "Lcom/jumio/sdk/retry/JumioRetryReason;", "root", "Landroid/view/View;", "scanPart", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "scanRetryCustomView", "sdk", "Lcom/jumio/sdk/JumioSDK;", "titleBar", "token", "catchAndStop", "", "function", "Lkotlin/Function0;", "", "checkViewMissAndShow", "viewType", "", "finish", "finishPage", "back", "getTitleBarView", "goConfirm", "goGuide", "goNext", "goReject", "data", "goRetry", "goScan", "goScanRetry", "hideView", "views", "", "showLoading", "([Landroid/view/View;Z)V", "initStatusBar", "initView", "log", "string", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFinished", "result", "Lcom/jumio/sdk/result/JumioResult;", "onInitialized", "credentials", "Ljava/util/ArrayList;", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "Lkotlin/collections/ArrayList;", "policyUrl", "onResume", "onScanStep", "jumioScanStep", "Lcom/jumio/sdk/enums/JumioScanStep;", "onUpdate", "jumioScanUpdate", "Lcom/jumio/sdk/enums/JumioScanUpdate;", "resetActionBar", "setupCredential", "credentialInfo", "setupCredentialParts", "credentialParts", "Lcom/jumio/sdk/enums/JumioScanSide;", "setupScanPart", "showBackDialog", "showError", "message", "showView", "hideLoading", "start", "startScanParts", "credentialPart", "subscribeUi", "vm", "Companion", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DDCustomActivity.kt */
public final class DDCustomActivity extends WBaseActivity<DDCustomVM> implements JumioControllerInterface, JumioScanPartInterface {
    public static final int CONFIRM_VIEW = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ERROR_RETRY_VIEW = 5;
    public static final String EXTRA_DATACENTER_TYPE = "datacenter_type";
    public static final String EXTRA_TOKEN = "token";
    public static final int FACE_GUIDE_VIEW = 6;
    public static final int PERMISSION_REQUEST_CODE = 303;
    public static final int REJECT_VIEW = 3;
    public static final int SCAN_RETRY_VIEW = 4;
    public static final int SCAN_VIEW = 1;

    /* renamed from: a */
    private final String f31775a = "jumio-test";

    /* renamed from: b */
    private LinearLayout f31776b;

    /* renamed from: c */
    private ImageView f31777c;

    /* renamed from: d */
    private BackDialogWindow f31778d;

    /* renamed from: e */
    private View f31779e;

    /* renamed from: f */
    private LinearLayout f31780f;

    /* renamed from: g */
    private FaceGuideView f31781g;

    /* renamed from: h */
    private JumioScanCustomView f31782h;

    /* renamed from: i */
    private JumioRejectCustomView f31783i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public JumioConfirmCustomView f31784j;

    /* renamed from: k */
    private JumioRetryCustomView f31785k;

    /* renamed from: l */
    private JumioRetryCustomView f31786l;

    /* renamed from: m */
    private JumioSDK f31787m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public JumioController f31788n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public JumioCredential f31789o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public JumioScanPart f31790p;

    /* renamed from: q */
    private JumioError f31791q;

    /* renamed from: r */
    private JumioRetryReason f31792r;

    /* renamed from: s */
    private String f31793s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final String f31794t = "BRA";

    /* renamed from: u */
    private DataCacheInfo f31795u = new DataCacheInfo();

    /* renamed from: v */
    private boolean f31796v;

    /* renamed from: w */
    private boolean f31797w;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: DDCustomActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[JumioScanStep.values().length];
            iArr[JumioScanStep.PREPARE.ordinal()] = 1;
            iArr[JumioScanStep.STARTED.ordinal()] = 2;
            iArr[JumioScanStep.SCAN_VIEW.ordinal()] = 3;
            iArr[JumioScanStep.IMAGE_TAKEN.ordinal()] = 4;
            iArr[JumioScanStep.PROCESSING.ordinal()] = 5;
            iArr[JumioScanStep.CONFIRMATION_VIEW.ordinal()] = 6;
            iArr[JumioScanStep.REJECT_VIEW.ordinal()] = 7;
            iArr[JumioScanStep.RETRY.ordinal()] = 8;
            iArr[JumioScanStep.CAN_FINISH.ordinal()] = 9;
            iArr[JumioScanStep.ATTACH_ACTIVITY.ordinal()] = 10;
            iArr[JumioScanStep.ADDON_SCAN_PART.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[JumioScanUpdate.values().length];
            iArr2[JumioScanUpdate.LEGAL_HINT.ordinal()] = 1;
            iArr2[JumioScanUpdate.CAMERA_AVAILABLE.ordinal()] = 2;
            iArr2[JumioScanUpdate.FALLBACK.ordinal()] = 3;
            iArr2[JumioScanUpdate.NFC_EXTRACTION_STARTED.ordinal()] = 4;
            iArr2[JumioScanUpdate.NFC_EXTRACTION_PROGRESS.ordinal()] = 5;
            iArr2[JumioScanUpdate.NFC_EXTRACTION_FINISHED.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @JvmStatic
    public static final void startActivity(Activity activity, String str, String str2) {
        Companion.startActivity(activity, str, str2);
    }

    @Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/DDCustomActivity$Companion;", "", "()V", "CONFIRM_VIEW", "", "ERROR_RETRY_VIEW", "EXTRA_DATACENTER_TYPE", "", "EXTRA_TOKEN", "FACE_GUIDE_VIEW", "PERMISSION_REQUEST_CODE", "REJECT_VIEW", "SCAN_RETRY_VIEW", "SCAN_VIEW", "startActivity", "", "activity", "Landroid/app/Activity;", "token", "type", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: DDCustomActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void startActivity(Activity activity, String str, String str2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "token");
            Intent intent = new Intent(activity, DDCustomActivity.class);
            intent.putExtra("token", str);
            intent.putExtra(DDCustomActivity.EXTRA_DATACENTER_TYPE, str2);
            activity.startActivityForResult(intent, 303);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_dd_customui);
        m24284b();
        ViewModel viewModel = new ViewModelProvider(this).get(DDCustomVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…t(DDCustomVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((DDCustomVM) getVm());
        m24289c();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        m24287b("onResume");
        super.onResume();
    }

    public void subscribeUi(DDCustomVM dDCustomVM) {
        Intrinsics.checkNotNullParameter(dDCustomVM, "vm");
        super.subscribeUi(dDCustomVM);
    }

    /* renamed from: a */
    private final void m24271a() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : -1;
        LinearLayout linearLayout = this.f31776b;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, dimensionPixelSize, 0, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* renamed from: b */
    private final void m24284b() {
        this.f31779e = findViewById(R.id.inlineScanContainer);
        this.f31780f = (LinearLayout) findViewById(R.id.jumioContainer);
        View findViewById = findViewById(R.id.toolbarView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.toolbarView)");
        this.f31776b = (LinearLayout) findViewById;
        this.f31777c = (ImageView) findViewById(R.id.toolbar_left_back_iv);
        m24271a();
        ImageView imageView = this.f31777c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    DDCustomActivity.m24273a(DDCustomActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m24273a(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        JumioOmegaUtil.Companion.trackBackAndDialog(1);
        dDCustomActivity.m24301k();
    }

    /* renamed from: c */
    private final void m24289c() {
        String str;
        String stringExtra = getIntent().getStringExtra("token");
        if (stringExtra != null) {
            this.f31793s = stringExtra;
            Context context = this;
            JumioSDK jumioSDK = new JumioSDK(context);
            this.f31787m = jumioSDK;
            JumioSDK jumioSDK2 = null;
            if (jumioSDK == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sdk");
                jumioSDK = null;
            }
            String str2 = this.f31793s;
            if (str2 != null) {
                jumioSDK.setToken(str2);
                JumioSDK jumioSDK3 = this.f31787m;
                if (jumioSDK3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sdk");
                    jumioSDK3 = null;
                }
                String stringExtra2 = getIntent().getStringExtra(EXTRA_DATACENTER_TYPE);
                if (stringExtra2 == null) {
                    str = GlobalCountryCode.AMERICA;
                } else {
                    str = stringExtra2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                }
                jumioSDK3.setDataCenter(JumioDataCenter.valueOf(str));
                ((DDCustomVM) getVm()).isLoading().setValue(true);
                JumioSDK jumioSDK4 = this.f31787m;
                if (jumioSDK4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sdk");
                } else {
                    jumioSDK2 = jumioSDK4;
                }
                this.f31788n = jumioSDK2.start(context, this);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void onInitialized(ArrayList<JumioCredentialInfo> arrayList, String str) {
        Intrinsics.checkNotNullParameter(arrayList, "credentials");
        ((DDCustomVM) getVm()).isLoading().setValue(false);
        if (str != null) {
            m24287b("User consent required");
        }
        if (arrayList.size() == 2) {
            m24287b("两个认证方式，卡+脸");
        }
        if (arrayList.size() == 1) {
            JumioCredentialInfo jumioCredentialInfo = arrayList.get(0);
            if (jumioCredentialInfo != null) {
                m24276a(jumioCredentialInfo);
                return;
            }
            return;
        }
        for (JumioCredentialInfo jumioCredentialInfo2 : arrayList) {
            try {
                if (StringsKt.contains$default((CharSequence) jumioCredentialInfo2.getCategory().name(), (CharSequence) DataCacheInfo.FACE, false, 2, (Object) null)) {
                    this.f31795u.setCredentialInfoFace(jumioCredentialInfo2);
                } else if (StringsKt.contains$default((CharSequence) jumioCredentialInfo2.getCategory().name(), (CharSequence) "ID", false, 2, (Object) null)) {
                    this.f31795u.setCredentialInfoCard(jumioCredentialInfo2);
                }
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                if (message != null) {
                    m24279a(message);
                }
            }
        }
        JumioCredentialInfo credentialInfoCard = this.f31795u.getCredentialInfoCard();
        if (credentialInfoCard != null) {
            m24276a(credentialInfoCard);
        }
    }

    public void onError(JumioError jumioError) {
        Intrinsics.checkNotNullParameter(jumioError, "error");
        ((DDCustomVM) getVm()).isLoading().setValue(false);
        JumioParams.INSTANCE.setERROR_CODE(jumioError.getCode());
        if (jumioError.isRetryable()) {
            m24299i();
        } else {
            m24282a(false);
            this.f31797w = true;
        }
        m24279a(jumioError.getMessage());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = jumioError.getCode();
        objArr[1] = jumioError.getMessage();
        objArr[2] = jumioError.isRetryable() ? "true" : SDKConsts.BOOLEAN_FALSE;
        String format = String.format("onError: %s, %s, %s", Arrays.copyOf(objArr, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        m24287b(format);
        this.f31791q = jumioError;
    }

    public void onFinished(JumioResult jumioResult) {
        Intrinsics.checkNotNullParameter(jumioResult, "result");
        StringBuilder sb = new StringBuilder();
        sb.append("onFinished -");
        sb.append(jumioResult.isSuccess());
        sb.append(" error = ");
        JumioError error = jumioResult.getError();
        String str = null;
        sb.append(error == null ? null : error.getMessage());
        m24287b(sb.toString());
        if (Intrinsics.areEqual((Object) this.f31795u.getCurrentPartName(), (Object) DataCacheInfo.FACE)) {
            ((DDCustomVM) getVm()).isLoading().setValue(false);
        }
        if (jumioResult.isSuccess()) {
            EventBus.getDefault().post(new JumioFaceFinishEvent(false));
            JumioOmegaUtil.Companion.fin_fullkycverification_quit_sw("3", "Pass");
        } else if (this.f31796v) {
            m24287b("no toast");
            JumioOmegaUtil.Companion.fin_fullkycverification_quit_sw("1", "Manual");
        } else {
            if (jumioResult.getError() != null) {
                String string = getResources().getString(R.string.Fintech_Payment_Integration__AtwG);
                Intrinsics.checkNotNullExpressionValue(string, "this.resources.getString…ayment_Integration__AtwG)");
                m24279a(string);
            }
            if (this.f31797w) {
                JumioOmegaUtil.Companion companion = JumioOmegaUtil.Companion;
                JumioError jumioError = this.f31791q;
                String valueOf = String.valueOf(jumioError == null ? null : jumioError.getCode());
                JumioError jumioError2 = this.f31791q;
                if (jumioError2 != null) {
                    str = jumioError2.getMessage();
                }
                companion.fin_fullkycverification_quit_sw(valueOf, String.valueOf(str));
            } else {
                JumioOmegaUtil.Companion companion2 = JumioOmegaUtil.Companion;
                JumioError error2 = jumioResult.getError();
                String valueOf2 = String.valueOf(error2 == null ? null : error2.getCode());
                JumioError error3 = jumioResult.getError();
                if (error3 != null) {
                    str = error3.getMessage();
                }
                companion2.fin_fullkycverification_quit_sw(valueOf2, String.valueOf(str));
            }
        }
        finish();
    }

    public void onScanStep(JumioScanStep jumioScanStep, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanStep, "jumioScanStep");
        m24287b(Intrinsics.stringPlus("onScanStep: ", jumioScanStep.name()));
        switch (WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()]) {
            case 1:
                ((DDCustomVM) getVm()).isLoading().setValue(true);
                Unit unit = Unit.INSTANCE;
                return;
            case 2:
                if (Intrinsics.areEqual((Object) this.f31795u.getCurrentPartName(), (Object) DataCacheInfo.FACE)) {
                    OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_FACECHECK);
                    KycOmega.Companion.trackEvent("fin_jumiofacecheck_sw");
                    m24272a(0);
                }
                Unit unit2 = Unit.INSTANCE;
                return;
            case 3:
                m24295f();
                JumioScanCustomView jumioScanCustomView = this.f31782h;
                if (jumioScanCustomView != null) {
                    Lifecycle lifecycle = getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle, AdminPermission.LIFECYCLE);
                    jumioScanCustomView.stepScanView(lifecycle);
                    Unit unit3 = Unit.INSTANCE;
                    return;
                }
                return;
            case 4:
                ((DDCustomVM) getVm()).isLoading().setValue(true);
                Unit unit4 = Unit.INSTANCE;
                return;
            case 5:
                ((DDCustomVM) getVm()).isLoading().setValue(true);
                Unit unit5 = Unit.INSTANCE;
                return;
            case 6:
                m24297g();
                Unit unit6 = Unit.INSTANCE;
                return;
            case 7:
                if (obj instanceof String) {
                    m24287b(Intrinsics.stringPlus("retry code: ", obj));
                    JumioParams.INSTANCE.setREJECT_REASON(((String) obj).toString());
                }
                m24278a(obj);
                Unit unit7 = Unit.INSTANCE;
                return;
            case 8:
                if (obj instanceof JumioRetryReason) {
                    JumioRetryReason jumioRetryReason = (JumioRetryReason) obj;
                    m24287b(Intrinsics.stringPlus("retry reason: ", Integer.valueOf(jumioRetryReason.getCode())));
                    m24287b(Intrinsics.stringPlus("retry message: ", jumioRetryReason.getMessage()));
                    this.f31792r = jumioRetryReason;
                    JumioParams jumioParams = JumioParams.INSTANCE;
                    JumioRetryReason jumioRetryReason2 = this.f31792r;
                    jumioParams.setRETRY_REASON(String.valueOf(jumioRetryReason2 == null ? null : jumioRetryReason2.getMessage()));
                    if (jumioRetryReason.getCode() != 2 || !Intrinsics.areEqual((Object) this.f31795u.getCurrentPartName(), (Object) DataCacheInfo.FACE)) {
                        m24298h();
                    } else {
                        m24282a(true);
                    }
                } else {
                    m24282a(false);
                }
                Unit unit8 = Unit.INSTANCE;
                return;
            case 9:
                ((DDCustomVM) getVm()).isLoading().setValue(Boolean.valueOf(Intrinsics.areEqual((Object) this.f31795u.getCurrentPartName(), (Object) DataCacheInfo.FACE)));
                JumioScanCustomView jumioScanCustomView2 = this.f31782h;
                if (jumioScanCustomView2 != null) {
                    Lifecycle lifecycle2 = getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle2, AdminPermission.LIFECYCLE);
                    jumioScanCustomView2.canFinish(lifecycle2);
                }
                m24291d();
                Unit unit9 = Unit.INSTANCE;
                return;
            case 10:
                JumioScanPart jumioScanPart = this.f31790p;
                if (jumioScanPart != null) {
                    new JumioActivityAttacher(this).attach(jumioScanPart);
                    Unit unit10 = Unit.INSTANCE;
                    return;
                }
                return;
            case 11:
                m24287b("JumioScanStep.ADDON_SCAN_PART ");
                Unit unit11 = Unit.INSTANCE;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: d */
    private final void m24291d() {
        m24281a((Function0<? extends Object>) new DDCustomActivity$goNext$1(this));
        this.f31790p = null;
        String currentPartName = this.f31795u.getCurrentPartName();
        if (Intrinsics.areEqual((Object) currentPartName, (Object) DataCacheInfo.FRONT)) {
            this.f31795u.setCurrentPartName(DataCacheInfo.BACK);
            m24277a(this.f31795u.getCredentialPartBack());
            JumioParams.INSTANCE.setDOCUMENT_SIDE(2);
        } else if (!Intrinsics.areEqual((Object) currentPartName, (Object) DataCacheInfo.BACK)) {
            m24287b("完成");
            m24282a(false);
        } else if (this.f31795u.getCredentialInfoFace() == null) {
            m24287b("完成");
            m24282a(false);
        } else {
            m24300j();
        }
    }

    public void onUpdate(JumioScanUpdate jumioScanUpdate, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanUpdate, "jumioScanUpdate");
        switch (WhenMappings.$EnumSwitchMapping$1[jumioScanUpdate.ordinal()]) {
            case 1:
                m24287b("LEGAL_HINT");
                m24287b((String) obj);
                return;
            case 2:
                m24287b("CAMERA_AVAILABLE");
                JumioScanCustomView jumioScanCustomView = this.f31782h;
                if (jumioScanCustomView != null) {
                    jumioScanCustomView.cameraAvailable();
                    return;
                }
                return;
            case 3:
                JumioScanCustomView jumioScanCustomView2 = this.f31782h;
                if (jumioScanCustomView2 != null) {
                    jumioScanCustomView2.fallBack();
                    return;
                }
                return;
            case 4:
                m24287b("NFC Extraction started");
                return;
            case 5:
                m24287b(Intrinsics.stringPlus("NFC Extraction progress ", obj));
                return;
            case 6:
                m24287b("NFC Extraction finished");
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m24276a(JumioCredentialInfo jumioCredentialInfo) {
        m24281a((Function0<? extends Object>) new DDCustomActivity$setupCredential$1(this, jumioCredentialInfo));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m24280a(ArrayList<JumioScanSide> arrayList) {
        for (JumioScanSide jumioScanSide : arrayList) {
            String name = jumioScanSide.name();
            int hashCode = name.hashCode();
            if (hashCode != 2030823) {
                if (hashCode != 2149981) {
                    if (hashCode == 67167753 && name.equals(DataCacheInfo.FRONT)) {
                        this.f31795u.setCurrentPartName(DataCacheInfo.FRONT);
                        this.f31795u.setCredentialPartFront(jumioScanSide);
                        m24277a(jumioScanSide);
                        JumioParams.INSTANCE.setDOCUMENT_SIDE(1);
                    }
                } else if (name.equals(DataCacheInfo.FACE)) {
                    this.f31795u.setCurrentPartName(DataCacheInfo.FACE);
                    this.f31795u.setCredentialPartFace(jumioScanSide);
                    m24277a(jumioScanSide);
                }
            } else if (name.equals(DataCacheInfo.BACK)) {
                this.f31795u.setCredentialPartBack(jumioScanSide);
            }
        }
    }

    /* renamed from: a */
    private final void m24277a(JumioScanSide jumioScanSide) {
        JumioCredential jumioCredential;
        JumioScanPart jumioScanPart = null;
        if (!(jumioScanSide == null || (jumioCredential = this.f31789o) == null)) {
            jumioScanPart = jumioCredential.initScanPart(jumioScanSide, this);
        }
        this.f31790p = jumioScanPart;
        m24293e();
    }

    /* renamed from: e */
    private final void m24293e() {
        JumioScanCustomView jumioScanCustomView;
        JumioScanPart jumioScanPart = this.f31790p;
        if (!((jumioScanPart == null ? null : jumioScanPart.getScanMode()) == JumioScanMode.FACE_IPROOV || (jumioScanCustomView = this.f31782h) == null)) {
            jumioScanCustomView.initScanView();
        }
        JumioScanPart jumioScanPart2 = this.f31790p;
        if (jumioScanPart2 != null) {
            jumioScanPart2.start();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24275a(DDCustomActivity dDCustomActivity, View[] viewArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        dDCustomActivity.m24283a(viewArr, z);
    }

    /* renamed from: a */
    private final void m24283a(View[] viewArr, boolean z) {
        ((DDCustomVM) getVm()).isLoading().setValue(false);
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            i++;
            view.setVisibility(0);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m24286b(DDCustomActivity dDCustomActivity, View[] viewArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        dDCustomActivity.m24288b(viewArr, z);
    }

    /* renamed from: b */
    private final void m24288b(View[] viewArr, boolean z) {
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            i++;
            view.setVisibility(8);
        }
        ((DDCustomVM) getVm()).isLoading().setValue(Boolean.valueOf(z));
    }

    /* renamed from: a */
    private final void m24279a(String str) {
        WalletToastNew.showFailedMsg(this, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m24287b(String str) {
        if (str != null) {
            SystemUtils.log(3, this.f31775a, str, (Throwable) null, "com.didi.nova.kyc.jumio.DDCustomActivity", 493);
        }
    }

    public void onBackPressed() {
        m24301k();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        LinearLayout linearLayout = this.f31776b;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            linearLayout = null;
        }
        return linearLayout;
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        super.initStatusBar();
        setTheme(R.style.GlobalActivity50);
    }

    /* renamed from: f */
    private final void m24295f() {
        JumioScanCustomView jumioScanCustomView;
        if (this.f31782h == null) {
            JumioScanCustomView jumioScanCustomView2 = new JumioScanCustomView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31782h = jumioScanCustomView2;
            LinearLayout linearLayout = this.f31780f;
            if (!(linearLayout == null || jumioScanCustomView2 == null)) {
                jumioScanCustomView2.attachView(linearLayout);
            }
        }
        JumioScanPart jumioScanPart = this.f31790p;
        if (!(jumioScanPart == null || (jumioScanCustomView = this.f31782h) == null)) {
            jumioScanCustomView.resetScanPart(jumioScanPart);
        }
        if (this.f31782h != null) {
            if (Intrinsics.areEqual((Object) this.f31795u.getCurrentPartName(), (Object) DataCacheInfo.FACE)) {
                OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_FACECHECK);
                KycOmega.Companion.trackEvent("fin_jumiofacecheck_sw");
            } else {
                OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_DOCUMENT);
                JumioOmegaUtil.Companion.fin_jumiodocument_sw();
            }
        }
        m24272a(1);
    }

    /* renamed from: g */
    private final void m24297g() {
        JumioConfirmCustomView jumioConfirmCustomView;
        if (this.f31784j == null) {
            JumioConfirmCustomView jumioConfirmCustomView2 = new JumioConfirmCustomView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31784j = jumioConfirmCustomView2;
            LinearLayout linearLayout = this.f31780f;
            if (!(linearLayout == null || jumioConfirmCustomView2 == null)) {
                jumioConfirmCustomView2.attachView(linearLayout, new DDCustomActivity$goConfirm$1$1(this), new DDCustomActivity$goConfirm$1$2(this));
            }
        }
        JumioScanPart jumioScanPart = this.f31790p;
        if (!(jumioScanPart == null || (jumioConfirmCustomView = this.f31784j) == null)) {
            jumioConfirmCustomView.resetScanPart(jumioScanPart);
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_CONFIRM);
        JumioOmegaUtil.Companion.fin_jumioconfirm_sw();
        m24272a(2);
    }

    /* renamed from: a */
    private final void m24278a(Object obj) {
        if (this.f31783i == null) {
            JumioRejectCustomView jumioRejectCustomView = new JumioRejectCustomView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31783i = jumioRejectCustomView;
            LinearLayout linearLayout = this.f31780f;
            if (!(linearLayout == null || jumioRejectCustomView == null)) {
                jumioRejectCustomView.attachView(linearLayout);
            }
        }
        JumioScanPart jumioScanPart = this.f31790p;
        if (jumioScanPart != null) {
            JumioRejectCustomView jumioRejectCustomView2 = this.f31783i;
            if (jumioRejectCustomView2 != null) {
                jumioRejectCustomView2.resetScanPart(jumioScanPart);
            }
            JumioRejectCustomView jumioRejectCustomView3 = this.f31783i;
            if (jumioRejectCustomView3 != null) {
                jumioRejectCustomView3.resetTitle(obj);
            }
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_DOCUMENT_REJECT);
        JumioOmegaUtil.Companion.fin_jumiodocumentreject_sw();
        m24272a(3);
    }

    /* renamed from: h */
    private final void m24298h() {
        if (this.f31785k == null) {
            JumioRetryCustomView jumioRetryCustomView = new JumioRetryCustomView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31785k = jumioRetryCustomView;
            LinearLayout linearLayout = this.f31780f;
            if (!(linearLayout == null || jumioRetryCustomView == null)) {
                jumioRetryCustomView.attachView(linearLayout, new View.OnClickListener() {
                    public final void onClick(View view) {
                        DDCustomActivity.m24285b(DDCustomActivity.this, view);
                    }
                }, (View.OnClickListener) null);
            }
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_DOCUMENT_RETRY);
        JumioOmegaUtil.Companion.fin_jumiodocumentretry_sw();
        m24272a(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m24285b(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        JumioOmegaUtil.Companion.fin_jumiodocumentretry_button_ck(1);
        JumioRetryReason jumioRetryReason = dDCustomActivity.f31792r;
        if (jumioRetryReason != null) {
            dDCustomActivity.m24281a((Function0<? extends Object>) new DDCustomActivity$goScanRetry$1$1$1$1(dDCustomActivity, jumioRetryReason));
            ((DDCustomVM) dDCustomActivity.getVm()).isLoading().setValue(true);
        }
    }

    /* renamed from: i */
    private final void m24299i() {
        if (this.f31786l == null) {
            JumioRetryCustomView jumioRetryCustomView = new JumioRetryCustomView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31786l = jumioRetryCustomView;
            LinearLayout linearLayout = this.f31780f;
            if (!(linearLayout == null || jumioRetryCustomView == null)) {
                jumioRetryCustomView.attachView(linearLayout, (View.OnClickListener) null, new View.OnClickListener() {
                    public final void onClick(View view) {
                        DDCustomActivity.m24290c(DDCustomActivity.this, view);
                    }
                });
            }
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_ERROR);
        JumioOmegaUtil.Companion.fin_jumioerror_sw();
        m24272a(5);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m24290c(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        JumioError jumioError = dDCustomActivity.f31791q;
        if (jumioError != null) {
            JumioController jumioController = dDCustomActivity.f31788n;
            if (jumioController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumioController");
                jumioController = null;
            }
            jumioController.retry(jumioError);
            ((DDCustomVM) dDCustomActivity.getVm()).isLoading().setValue(true);
        }
        JumioOmegaUtil.Companion.fin_jumioerror_button_ck(1);
    }

    /* renamed from: j */
    private final void m24300j() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.f31781g == null) {
            T t = null;
            FaceGuideView faceGuideView = new FaceGuideView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            this.f31781g = faceGuideView;
            LinearLayout linearLayout = this.f31780f;
            if (linearLayout != null) {
                if (faceGuideView != null) {
                    t = faceGuideView.getBottomBar();
                }
                objectRef.element = t;
                FaceGuideView faceGuideView2 = this.f31781g;
                if (faceGuideView2 != null) {
                    faceGuideView2.attachView(linearLayout, new View.OnClickListener(objectRef) {
                        public final /* synthetic */ Ref.ObjectRef f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            DDCustomActivity.m24274a(DDCustomActivity.this, this.f$1, view);
                        }
                    });
                }
            }
        }
        TextView textView = (TextView) objectRef.element;
        if (textView != null) {
            textView.setEnabled(true);
        }
        TextView textView2 = (TextView) objectRef.element;
        if (textView2 != null) {
            textView2.setClickable(true);
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.FACE_GUIDE);
        KycOmega.Companion.trackEvent("fin_faceguide_sw");
        m24272a(6);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m24274a(DDCustomActivity dDCustomActivity, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$bottomBtn");
        JumioCredentialInfo credentialInfoFace = dDCustomActivity.f31795u.getCredentialInfoFace();
        if (credentialInfoFace != null) {
            TextView textView = (TextView) objectRef.element;
            if (textView != null) {
                textView.setEnabled(false);
            }
            TextView textView2 = (TextView) objectRef.element;
            if (textView2 != null) {
                textView2.setClickable(false);
            }
            KycOmega.Companion.trackButtonEvent("fin_faceguide_button_ck", 1);
            dDCustomActivity.m24276a(credentialInfoFace);
            ((DDCustomVM) dDCustomActivity.getVm()).isLoading().setValue(true);
        }
    }

    /* renamed from: k */
    private final boolean m24301k() {
        BackDialogWindow backDialogWindow;
        if (DDCustomViewData.INSTANCE.getExitDetail() == null) {
            m24282a(true);
        }
        if (this.f31778d == null) {
            this.f31778d = new BackDialogWindow();
        }
        DDCustomViewData.ExitDetail exitDetail = DDCustomViewData.INSTANCE.getExitDetail();
        if (!(exitDetail == null || (backDialogWindow = this.f31778d) == null)) {
            backDialogWindow.init(this, exitDetail, new View.OnClickListener() {
                public final void onClick(View view) {
                    DDCustomActivity.m24292d(DDCustomActivity.this, view);
                }
            }, new View.OnClickListener() {
                public final void onClick(View view) {
                    DDCustomActivity.m24294e(DDCustomActivity.this, view);
                }
            }, new View.OnClickListener() {
                public final void onClick(View view) {
                    DDCustomActivity.m24296f(DDCustomActivity.this, view);
                }
            });
        }
        View view = this.f31779e;
        if (view != null) {
            BackDialogWindow backDialogWindow2 = this.f31778d;
            if (backDialogWindow2 != null) {
                backDialogWindow2.showWindow(view);
            }
            JumioOmegaUtil.Companion.trackBackAndDialog(2);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m24292d(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        JumioOmegaUtil.Companion.trackBackAndDialog(3);
        BackDialogWindow backDialogWindow = dDCustomActivity.f31778d;
        if (backDialogWindow != null) {
            backDialogWindow.closeWindow();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m24294e(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        JumioOmegaUtil.Companion.trackBackAndDialog(4);
        EventBus.getDefault().post(new JumioFaceFinishEvent(true));
        dDCustomActivity.m24282a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final void m24296f(DDCustomActivity dDCustomActivity, View view) {
        Intrinsics.checkNotNullParameter(dDCustomActivity, "this$0");
        BackDialogWindow backDialogWindow = dDCustomActivity.f31778d;
        if (backDialogWindow != null) {
            backDialogWindow.closeWindow();
        }
        JumioOmegaUtil.Companion.trackBackAndDialog(5);
    }

    /* renamed from: a */
    private final void m24282a(boolean z) {
        this.f31796v = z;
        JumioController jumioController = this.f31788n;
        if (jumioController == null || z) {
            finish();
            return;
        }
        JumioController jumioController2 = null;
        if (jumioController == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("jumioController");
                jumioController = null;
            } catch (Exception e) {
                finish();
                e.printStackTrace();
                return;
            }
        }
        if (jumioController.isComplete()) {
            JumioController jumioController3 = this.f31788n;
            if (jumioController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumioController");
            } else {
                jumioController2 = jumioController3;
            }
            jumioController2.finish();
            m24287b("jumioController.finish()");
            return;
        }
        JumioController jumioController4 = this.f31788n;
        if (jumioController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumioController");
        } else {
            jumioController2 = jumioController4;
        }
        jumioController2.cancel();
        m24287b("jumioController.cancel()");
    }

    public void finish() {
        super.finish();
        m24287b("activity finish()");
        JumioController jumioController = this.f31788n;
        if (jumioController != null) {
            JumioController jumioController2 = null;
            if (jumioController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumioController");
                jumioController = null;
            }
            if (!jumioController.isComplete()) {
                JumioController jumioController3 = this.f31788n;
                if (jumioController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumioController");
                } else {
                    jumioController2 = jumioController3;
                }
                jumioController2.stop();
                m24287b("jumioController.stop()");
            }
        }
    }

    /* renamed from: a */
    private final void m24281a(Function0<? extends Object> function0) {
        try {
            function0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            m24287b("catchAndStop.finishPage()");
            m24282a(false);
            if (e.getMessage() != null) {
                String string = getResources().getString(R.string.Others_APP_exception);
                Intrinsics.checkNotNullExpressionValue(string, "this.resources.getString…ing.Others_APP_exception)");
                m24279a(string);
            }
        }
    }

    /* renamed from: a */
    private final void m24272a(int i) {
        BackDialogWindow backDialogWindow = this.f31778d;
        if (backDialogWindow != null) {
            backDialogWindow.closeWindow();
        }
        JumioScanCustomView jumioScanCustomView = this.f31782h;
        if (jumioScanCustomView != null) {
            jumioScanCustomView.closeTipWindow();
        }
        JumioScanCustomView jumioScanCustomView2 = this.f31782h;
        if (jumioScanCustomView2 != null) {
            m24286b(this, new View[]{jumioScanCustomView2}, false, 2, (Object) null);
        }
        JumioConfirmCustomView jumioConfirmCustomView = this.f31784j;
        if (jumioConfirmCustomView != null) {
            m24286b(this, new View[]{jumioConfirmCustomView}, false, 2, (Object) null);
        }
        JumioRejectCustomView jumioRejectCustomView = this.f31783i;
        if (jumioRejectCustomView != null) {
            m24286b(this, new View[]{jumioRejectCustomView}, false, 2, (Object) null);
        }
        JumioRetryCustomView jumioRetryCustomView = this.f31785k;
        if (jumioRetryCustomView != null) {
            m24286b(this, new View[]{jumioRetryCustomView}, false, 2, (Object) null);
        }
        JumioRetryCustomView jumioRetryCustomView2 = this.f31786l;
        if (jumioRetryCustomView2 != null) {
            m24286b(this, new View[]{jumioRetryCustomView2}, false, 2, (Object) null);
        }
        FaceGuideView faceGuideView = this.f31781g;
        if (faceGuideView != null) {
            m24286b(this, new View[]{faceGuideView}, false, 2, (Object) null);
        }
        switch (i) {
            case 1:
                JumioScanCustomView jumioScanCustomView3 = this.f31782h;
                if (jumioScanCustomView3 != null) {
                    m24275a(this, new View[]{jumioScanCustomView3}, false, 2, (Object) null);
                    return;
                }
                return;
            case 2:
                JumioConfirmCustomView jumioConfirmCustomView2 = this.f31784j;
                if (jumioConfirmCustomView2 != null) {
                    m24275a(this, new View[]{jumioConfirmCustomView2}, false, 2, (Object) null);
                    return;
                }
                return;
            case 3:
                JumioRejectCustomView jumioRejectCustomView2 = this.f31783i;
                if (jumioRejectCustomView2 != null) {
                    m24275a(this, new View[]{jumioRejectCustomView2}, false, 2, (Object) null);
                    return;
                }
                return;
            case 4:
                JumioRetryCustomView jumioRetryCustomView3 = this.f31785k;
                if (jumioRetryCustomView3 != null) {
                    m24275a(this, new View[]{jumioRetryCustomView3}, false, 2, (Object) null);
                    return;
                }
                return;
            case 5:
                JumioRetryCustomView jumioRetryCustomView4 = this.f31786l;
                if (jumioRetryCustomView4 != null) {
                    m24275a(this, new View[]{jumioRetryCustomView4}, false, 2, (Object) null);
                    return;
                }
                return;
            case 6:
                FaceGuideView faceGuideView2 = this.f31781g;
                if (faceGuideView2 != null) {
                    m24275a(this, new View[]{faceGuideView2}, false, 2, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
