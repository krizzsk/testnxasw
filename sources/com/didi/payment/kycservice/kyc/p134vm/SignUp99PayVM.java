package com.didi.payment.kycservice.kyc.p134vm;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.datadog.android.log.LogAttributes;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.LocationProxyHolder;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.fragment.KycFormStep;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.sdk.util.UiThreadHandler;
import com.yanzhenjie.permission.runtime.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00104\u001a\u00020\u0007H\u0002J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020,J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206J\u0010\u0010:\u001a\u0004\u0018\u00010\u000f2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u000206H\u0016J\b\u0010>\u001a\u000206H\u0002J\u000e\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020#J\u000e\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010C\u001a\u000206J&\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\rR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\rR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\rR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\"\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\rR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\t\"\u0004\b3\u0010\r¨\u0006I"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bFinishCreateAccount", "Landroidx/lifecycle/MutableLiveData;", "", "getBFinishCreateAccount", "()Landroidx/lifecycle/MutableLiveData;", "bShowHomelandCityErrorPage", "getBShowHomelandCityErrorPage", "setBShowHomelandCityErrorPage", "(Landroidx/lifecycle/MutableLiveData;)V", "bizCode", "", "getBizCode", "setBizCode", "cpfinfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "getCpfinfo", "setCpfinfo", "errorMsg", "getErrorMsg", "setErrorMsg", "externalId", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "isInfoComplete", "()Z", "model", "Lcom/didi/payment/kycservice/net/PixNetModel;", "nextStepData", "Lcom/didi/payment/kycservice/kyc/fragment/KycFormStep;", "getNextStepData", "permissionData", "Lcom/didi/payment/kycservice/kyc/vm/PermissionData;", "getPermissionData", "setPermissionData", "preStepData", "getPreStepData", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "sessionId", "getSessionId", "setSessionId", "checkLocationIfNeeded", "finishCreate", "", "resultData", "getFaceResult", "getFaceSession", "getShowTime", "date", "Ljava/util/Date;", "loadData", "loadKYCInfo", "onNextClick", "step", "onPreClick", "back", "requestLocationOnce", "submitKycInfoV1", "name", "birthDate", "cpf", "source", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.SignUp99PayVM */
/* compiled from: SignUp99PayVM.kt */
public final class SignUp99PayVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f33422a;

    /* renamed from: b */
    private MutableLiveData<Boolean> f33423b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<PermissionData> f33424c = new MutableLiveData<>(null);

    /* renamed from: d */
    private MutableLiveData<PixGetApplyInfoResp.CPFInfo> f33425d = new MutableLiveData<>();

    /* renamed from: e */
    private final MutableLiveData<Boolean> f33426e = new MutableLiveData<>();

    /* renamed from: f */
    private ResultPageData f33427f;

    /* renamed from: g */
    private MutableLiveData<String> f33428g = new MutableLiveData<>();

    /* renamed from: h */
    private MutableLiveData<String> f33429h = new MutableLiveData<>();

    /* renamed from: i */
    private String f33430i;

    /* renamed from: j */
    private MutableLiveData<String> f33431j = new MutableLiveData<>();

    /* renamed from: k */
    private final MutableLiveData<KycFormStep> f33432k = new MutableLiveData<>();

    /* renamed from: l */
    private final MutableLiveData<Boolean> f33433l = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignUp99PayVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f33422a = new PixNetModel(application2);
        loadData();
    }

    public final MutableLiveData<Boolean> getBShowHomelandCityErrorPage() {
        return this.f33423b;
    }

    public final void setBShowHomelandCityErrorPage(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33423b = mutableLiveData;
    }

    public final MutableLiveData<PermissionData> getPermissionData() {
        return this.f33424c;
    }

    public final void setPermissionData(MutableLiveData<PermissionData> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33424c = mutableLiveData;
    }

    public final MutableLiveData<PixGetApplyInfoResp.CPFInfo> getCpfinfo() {
        return this.f33425d;
    }

    public final void setCpfinfo(MutableLiveData<PixGetApplyInfoResp.CPFInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33425d = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getBFinishCreateAccount() {
        return this.f33426e;
    }

    public final ResultPageData getResultPageData() {
        return this.f33427f;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f33427f = resultPageData;
    }

    public final MutableLiveData<String> getErrorMsg() {
        return this.f33428g;
    }

    public final void setErrorMsg(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33428g = mutableLiveData;
    }

    public final MutableLiveData<String> getBizCode() {
        return this.f33429h;
    }

    public final void setBizCode(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33429h = mutableLiveData;
    }

    public final String getExternalId() {
        return this.f33430i;
    }

    public final void setExternalId(String str) {
        this.f33430i = str;
    }

    public final MutableLiveData<String> getSessionId() {
        return this.f33431j;
    }

    public final void setSessionId(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33431j = mutableLiveData;
    }

    public final boolean isInfoComplete() {
        PixGetApplyInfoResp.CPFInfo value = this.f33425d.getValue();
        String str = null;
        if (!TextUtils.isEmpty(value == null ? null : value.getName())) {
            PixGetApplyInfoResp.CPFInfo value2 = this.f33425d.getValue();
            if (!TextUtils.isEmpty(value2 == null ? null : value2.getBirthdate())) {
                PixGetApplyInfoResp.CPFInfo value3 = this.f33425d.getValue();
                if (value3 != null) {
                    str = value3.getTaxId();
                }
                return TextUtils.isEmpty(str);
            }
        }
    }

    public final MutableLiveData<KycFormStep> getNextStepData() {
        return this.f33432k;
    }

    public final MutableLiveData<Boolean> getPreStepData() {
        return this.f33433l;
    }

    public final String getShowTime(Date date) {
        Intrinsics.checkNotNullParameter(date, LogAttributes.DATE);
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    /* renamed from: a */
    private final void m25406a() {
        this.f33422a.getApplyInfo(new SignUp99PayVM$loadKYCInfo$1(this));
    }

    public void loadData() {
        if (!m25408b()) {
            m25406a();
        }
    }

    /* renamed from: b */
    private final boolean m25408b() {
        if (!WalletApolloUtil.getStatus("ibt_wallet_account_loc_intercept_toggle")) {
            return false;
        }
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        boolean access$isLocServiceEnable = SignUp99PayVMKt.m25409a(application);
        boolean checkPermissionAllGranted = PermissionUtil.checkPermissionAllGranted((Context) getApplication(), Permission.ACCESS_FINE_LOCATION);
        if (!access$isLocServiceEnable || !checkPermissionAllGranted) {
            this.f33424c.setValue(new PermissionData(access$isLocServiceEnable, checkPermissionAllGranted, true));
            return true;
        }
        Object obj = PayBaseParamUtil.getHttpBaseParams(getApplication()).get("city_id");
        if (obj != null) {
            String obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2) && !Intrinsics.areEqual((Object) "-1", (Object) obj2) && !Intrinsics.areEqual((Object) "0", (Object) obj2)) {
                return false;
            }
        }
        this.f33424c.setValue(new PermissionData(access$isLocServiceEnable, checkPermissionAllGranted, false));
        return true;
    }

    public final void requestLocationOnce() {
        isLoading().setValue(true);
        if (LocationProxyHolder.getProxy() != null) {
            LocationProxyHolder.getProxy().requestLocationAndCityId();
        }
        UiThreadHandler.postOnceDelayed(new Runnable() {
            public final void run() {
                SignUp99PayVM.m25407a(SignUp99PayVM.this);
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25407a(SignUp99PayVM signUp99PayVM) {
        Intrinsics.checkNotNullParameter(signUp99PayVM, "this$0");
        signUp99PayVM.isLoading().setValue(false);
        if (!signUp99PayVM.m25408b()) {
            signUp99PayVM.getPermissionData().setValue(null);
            signUp99PayVM.m25406a();
        }
    }

    public final void submitKycInfoV1(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "birthDate");
        Intrinsics.checkNotNullParameter(str3, "cpf");
        Intrinsics.checkNotNullParameter(str4, "source");
        this.f33422a.submitKycInfoV1(str, str2, str3, str4, new SignUp99PayVM$submitKycInfoV1$1(this));
    }

    public final void getFaceSession() {
        String str = this.f33430i;
        if (str != null) {
            PixNetModel pixNetModel = this.f33422a;
            String value = getBizCode().getValue();
            if (value != null) {
                pixNetModel.getFaceSession(value, str, new SignUp99PayVM$getFaceSession$1$1(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final void getFaceResult() {
        String str = this.f33430i;
        if (str != null) {
            this.f33422a.getFaceResult(String.valueOf(getSessionId().getValue()), str, new SignUp99PayVM$getFaceResult$1$1(this));
        }
    }

    public final void finishCreate(ResultPageData resultPageData) {
        Intrinsics.checkNotNullParameter(resultPageData, "resultData");
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        this.f33427f = resultPageData;
        this.f33426e.setValue(true);
    }

    public final void onNextClick(KycFormStep kycFormStep) {
        Intrinsics.checkNotNullParameter(kycFormStep, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
        this.f33432k.setValue(kycFormStep);
    }

    public final void onPreClick(boolean z) {
        this.f33433l.setValue(Boolean.valueOf(z));
    }
}
