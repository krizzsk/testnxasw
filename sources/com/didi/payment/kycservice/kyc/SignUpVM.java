package com.didi.payment.kycservice.kyc;

import android.app.Application;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.kycservice.guide.rule.GuidsRuleManager;
import com.didi.payment.kycservice.guide.rule.IKycGuidesRule;
import com.didi.payment.kycservice.kyc.fragment.KycFormStep;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import com.didi.payment.kycservice.utils.KycStore;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010O\u001a\u00020PH\u0016J\u000e\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u000209J\u0010\u0010S\u001a\u00020P2\b\u0010T\u001a\u0004\u0018\u000103J\b\u0010U\u001a\u00020PH\u0002J\u0006\u0010V\u001a\u00020\u0006J\u000e\u0010W\u001a\u00020P2\u0006\u0010R\u001a\u000209R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090+¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010\nR0\u0010D\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`G0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010.\"\u0004\bI\u0010JR \u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010.\"\u0004\bM\u0010JR\u000e\u0010N\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "canBackStack", "", "getCanBackStack", "()Z", "setCanBackStack", "(Z)V", "exitDetail", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "getExitDetail", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "setExitDetail", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;)V", "fromPrimary", "", "getFromPrimary", "()I", "setFromPrimary", "(I)V", "idTitlePrefix", "", "getIdTitlePrefix", "()Ljava/lang/String;", "setIdTitlePrefix", "(Ljava/lang/String;)V", "incomeDetailList", "Ljava/util/LinkedList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "getIncomeDetailList", "()Ljava/util/LinkedList;", "setIncomeDetailList", "(Ljava/util/LinkedList;)V", "isNewStep", "keyTitlePrefix", "getKeyTitlePrefix", "setKeyTitlePrefix", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "pageSceneLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/kyc/SignUpPageScene;", "getPageSceneLD", "()Landroidx/lifecycle/MutableLiveData;", "pageSource", "getPageSource", "setPageSource", "pixSignUpInfoData", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "getPixSignUpInfoData", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "setPixSignUpInfoData", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;)V", "preStepData", "Lcom/didi/payment/kycservice/kyc/fragment/KycFormStep;", "getPreStepData", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "srcFromResultPage", "getSrcFromResultPage", "setSrcFromResultPage", "stepListData", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$StepInfo;", "Lkotlin/collections/ArrayList;", "getStepListData", "setStepListData", "(Landroidx/lifecycle/MutableLiveData;)V", "stepProgress", "getStepProgress", "setStepProgress", "stepSize", "loadData", "", "onPreClick", "step", "saveStatus", "response", "switchPage", "updatePageSceneByStepList", "updateStepProgress", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUpVM.kt */
public final class SignUpVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f33204a;

    /* renamed from: b */
    private final MutableLiveData<SignUpPageScene> f33205b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> f33206c = new MutableLiveData<>();

    /* renamed from: d */
    private GuidesInfoResp.Data f33207d;

    /* renamed from: e */
    private ResultPageData f33208e;

    /* renamed from: f */
    private String f33209f = "";

    /* renamed from: g */
    private String f33210g = "";

    /* renamed from: h */
    private boolean f33211h;

    /* renamed from: i */
    private LinkedList<GuidesInfoResp.Income> f33212i;

    /* renamed from: j */
    private int f33213j;

    /* renamed from: k */
    private String f33214k = "2";

    /* renamed from: l */
    private int f33215l;

    /* renamed from: m */
    private GuidesInfoResp.ExitDetail f33216m;

    /* renamed from: n */
    private final boolean f33217n = ApolloSignUpUtil.Companion.getKYCFromOpt();

    /* renamed from: o */
    private final MutableLiveData<KycFormStep> f33218o = new MutableLiveData<>();

    /* renamed from: p */
    private MutableLiveData<Integer> f33219p = new MutableLiveData<>();

    /* renamed from: q */
    private boolean f33220q;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SignUpVM.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KycFormStep.values().length];
            iArr[KycFormStep.STEP_INCOME.ordinal()] = 1;
            iArr[KycFormStep.STEP_ID_TYPE.ordinal()] = 2;
            iArr[KycFormStep.STEP_NAME.ordinal()] = 3;
            iArr[KycFormStep.STEP_DATE.ordinal()] = 4;
            iArr[KycFormStep.STEP_CPF.ordinal()] = 5;
            iArr[KycFormStep.STEP_ADDRESS.ordinal()] = 6;
            iArr[KycFormStep.STEP_PRIMARY_FACE.ordinal()] = 7;
            iArr[KycFormStep.STEP_OTHER_ALL.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignUpVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f33204a = new PixNetModel(application2);
    }

    public final MutableLiveData<SignUpPageScene> getPageSceneLD() {
        return this.f33205b;
    }

    public final MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> getStepListData() {
        return this.f33206c;
    }

    public final void setStepListData(MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33206c = mutableLiveData;
    }

    public final GuidesInfoResp.Data getPixSignUpInfoData() {
        return this.f33207d;
    }

    public final void setPixSignUpInfoData(GuidesInfoResp.Data data) {
        this.f33207d = data;
    }

    public final ResultPageData getResultPageData() {
        return this.f33208e;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f33208e = resultPageData;
    }

    public final String getIdTitlePrefix() {
        return this.f33209f;
    }

    public final void setIdTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f33209f = str;
    }

    public final String getKeyTitlePrefix() {
        return this.f33210g;
    }

    public final void setKeyTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f33210g = str;
    }

    public final boolean getSrcFromResultPage() {
        return this.f33211h;
    }

    public final void setSrcFromResultPage(boolean z) {
        this.f33211h = z;
    }

    public final LinkedList<GuidesInfoResp.Income> getIncomeDetailList() {
        return this.f33212i;
    }

    public final void setIncomeDetailList(LinkedList<GuidesInfoResp.Income> linkedList) {
        this.f33212i = linkedList;
    }

    public final String getPageSource() {
        return this.f33214k;
    }

    public final void setPageSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f33214k = str;
    }

    public final int getFromPrimary() {
        return this.f33215l;
    }

    public final void setFromPrimary(int i) {
        this.f33215l = i;
    }

    public final GuidesInfoResp.ExitDetail getExitDetail() {
        return this.f33216m;
    }

    public final void setExitDetail(GuidesInfoResp.ExitDetail exitDetail) {
        this.f33216m = exitDetail;
    }

    public final boolean isNewStep() {
        return this.f33217n;
    }

    public final MutableLiveData<KycFormStep> getPreStepData() {
        return this.f33218o;
    }

    public final MutableLiveData<Integer> getStepProgress() {
        return this.f33219p;
    }

    public final void setStepProgress(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33219p = mutableLiveData;
    }

    public final boolean getCanBackStack() {
        return this.f33220q;
    }

    public final void setCanBackStack(boolean z) {
        this.f33220q = z;
    }

    public void loadData() {
        this.f33213j = 0;
        this.f33204a.getGuidesInfo(new SignUpVM$loadData$1(this), this.f33214k);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25225a() {
        SparseArray<IKycGuidesRule> guidesRules = GuidsRuleManager.Companion.getGuidesRules();
        IKycGuidesRule iKycGuidesRule = guidesRules == null ? null : guidesRules.get(Integer.parseInt(this.f33214k));
        if (this.f33208e == null || this.f33211h) {
            boolean z = false;
            if (iKycGuidesRule != null && iKycGuidesRule.showGuideRule()) {
                z = true;
            }
            if (z) {
                this.f33205b.setValue(SignUpPageScene.GUIDE);
            } else {
                updatePageSceneByStepList();
            }
        } else {
            this.f33205b.setValue(SignUpPageScene.RESULT);
        }
    }

    public final boolean updatePageSceneByStepList() {
        ArrayList<GuidesInfoResp.StepInfo> stepList;
        ArrayList<GuidesInfoResp.StepInfo> stepList2;
        GuidesInfoResp.Data data = this.f33207d;
        if ((data == null ? null : data.getStepList()) != null) {
            GuidesInfoResp.Data data2 = this.f33207d;
            if (!((data2 == null || (stepList2 = data2.getStepList()) == null || stepList2.size() != 0) ? false : true)) {
                GuidesInfoResp.Data data3 = this.f33207d;
                if (data3 == null || (stepList = data3.getStepList()) == null) {
                    return true;
                }
                this.f33213j++;
                Iterator<GuidesInfoResp.StepInfo> it = stepList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GuidesInfoResp.StepInfo next = it.next();
                    if (next.getStatus() == 1) {
                        int stepType = next.getStepType();
                        if (stepType == 1) {
                            next.setStatus(2);
                        } else if (stepType == 2) {
                            next.setStatus(2);
                        } else if (stepType == 3) {
                            next.setStatus(2);
                        } else if (stepType == 4) {
                            next.setStatus(2);
                        } else if (stepType == 5) {
                            next.setStatus(2);
                        }
                    }
                    if (next.getStatus() == 0) {
                        int stepType2 = next.getStepType();
                        if (stepType2 == 1) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.SIGN_UP_99PAY);
                        } else if (stepType2 == 2) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.FULL_KYC_EXTRA);
                        } else if (stepType2 == 3) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_ID_TYPE);
                        } else if (stepType2 == 4) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_KEY_TYPE);
                        } else if (stepType2 == 5) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_ID_TYPE_JUMIO);
                        }
                    }
                }
                SystemUtils.log(3, "kyc_test", "FinishStepSize= " + this.f33213j + "  ;ResultStepSize= " + stepList.size(), (Throwable) null, "com.didi.payment.kycservice.kyc.SignUpVM", 165);
                getStepListData().setValue(stepList);
                if (this.f33213j > stepList.size()) {
                    return true;
                }
                return false;
            }
        }
        this.f33205b.setValue(SignUpPageScene.FULL_KYC_FINISH);
        return true;
    }

    public final void saveStatus(GuidesInfoResp.Data data) {
        if (data != null) {
            KycStore.INSTANCE.setPrimaryKycStatus(data.getKycStatus());
            KycStore.INSTANCE.setFullKycStatus(data.getFullKycStatus());
            KycStore.INSTANCE.setFaceStatus(data.getFaceStatus());
            if (data.getPixStatus() != null) {
                KycStore.INSTANCE.setPixStatus(data.getPixStatus());
            }
            KycStore.INSTANCE.setLatourKycStatus(data.getLatourKycStatus());
            if (WalletCommonParamsUtil.is99PayClient() && data.getLatourKycStatus() == 1 && !Intrinsics.areEqual((Object) this.f33214k, (Object) "4") && !Intrinsics.areEqual((Object) this.f33214k, (Object) "6")) {
                this.f33205b.setValue(SignUpPageScene.FULL_KYC_FINISH);
            }
        }
    }

    public final void onPreClick(KycFormStep kycFormStep) {
        ArrayList<GuidesInfoResp.StepInfo> stepList;
        ArrayList<GuidesInfoResp.StepInfo> stepList2;
        Intrinsics.checkNotNullParameter(kycFormStep, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
        int i = WhenMappings.$EnumSwitchMapping$0[kycFormStep.ordinal()];
        if (i == 1) {
            this.f33213j--;
            GuidesInfoResp.Data data = this.f33207d;
            if (!(data == null || (stepList = data.getStepList()) == null)) {
                for (GuidesInfoResp.StepInfo stepInfo : stepList) {
                    if (stepInfo.getStepType() == 2) {
                        stepInfo.setStatus(0);
                    }
                }
            }
        } else if (i == 2) {
            this.f33213j--;
            GuidesInfoResp.Data data2 = this.f33207d;
            if (!(data2 == null || (stepList2 = data2.getStepList()) == null)) {
                for (GuidesInfoResp.StepInfo stepInfo2 : stepList2) {
                    if (stepInfo2.getStepType() == 5) {
                        stepInfo2.setStatus(0);
                    }
                }
            }
        }
        this.f33218o.setValue(kycFormStep);
    }

    public final void updateStepProgress(KycFormStep kycFormStep) {
        int i;
        Intrinsics.checkNotNullParameter(kycFormStep, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
        MutableLiveData<Integer> mutableLiveData = this.f33219p;
        switch (WhenMappings.$EnumSwitchMapping$0[kycFormStep.ordinal()]) {
            case 1:
                i = 4;
                break;
            case 2:
            case 7:
                i = 6;
                break;
            case 3:
                i = 1;
                break;
            case 4:
                i = 2;
                break;
            case 5:
                i = 3;
                break;
            case 6:
                i = 5;
                break;
            case 8:
                i = 7;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        mutableLiveData.setValue(i);
    }
}
