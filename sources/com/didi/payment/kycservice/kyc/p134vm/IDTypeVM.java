package com.didi.payment.kycservice.kyc.p134vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.JumioCreateResultResp;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0016\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006J\b\u0010'\u001a\u00020 H\u0016J\u000e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "delayPushSet", "Landroidx/lifecycle/MutableLiveData;", "", "getDelayPushSet", "()Landroidx/lifecycle/MutableLiveData;", "setDelayPushSet", "(Landroidx/lifecycle/MutableLiveData;)V", "jumioCreateData", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;", "getJumioCreateData", "setJumioCreateData", "jumioGuideData", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "getJumioGuideData", "setJumioGuideData", "needShowReminder", "getNeedShowReminder", "()Z", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "checkJumio", "", "listener", "Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM$CheckListener;", "createToken", "guidanceSource", "", "fromPrimary", "loadData", "setDelayPush", "delayPushTime", "", "CheckListener", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f33413a;

    /* renamed from: b */
    private MutableLiveData<JumioCreateResultResp.Data> f33414b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<JumioGuideResp.Data> f33415c = new MutableLiveData<>();

    /* renamed from: d */
    private MutableLiveData<Boolean> f33416d = new MutableLiveData<>();

    /* renamed from: e */
    private final boolean f33417e = ApolloSignUpUtil.Companion.getKYCReminder();

    /* renamed from: f */
    private int f33418f = 1;

    @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM$CheckListener;", "", "onSuccess", "", "resultEntryFormat", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$CheckListener */
    /* compiled from: IDTypeVM.kt */
    public interface CheckListener {
        void onSuccess(ResultPageData resultPageData);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IDTypeVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f33413a = new PixNetModel(application2);
    }

    public final MutableLiveData<JumioCreateResultResp.Data> getJumioCreateData() {
        return this.f33414b;
    }

    public final void setJumioCreateData(MutableLiveData<JumioCreateResultResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33414b = mutableLiveData;
    }

    public final MutableLiveData<JumioGuideResp.Data> getJumioGuideData() {
        return this.f33415c;
    }

    public final void setJumioGuideData(MutableLiveData<JumioGuideResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33415c = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getDelayPushSet() {
        return this.f33416d;
    }

    public final void setDelayPushSet(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33416d = mutableLiveData;
    }

    public final boolean getNeedShowReminder() {
        return this.f33417e;
    }

    public void loadData() {
        this.f33413a.getJumioGuide(new IDTypeVM$loadData$1$1(this));
    }

    public final void createToken(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "guidanceSource");
        this.f33413a.createJumio(str, i, new IDTypeVM$createToken$1(this));
    }

    public final int getCount() {
        return this.f33418f;
    }

    public final void setCount(int i) {
        this.f33418f = i;
    }

    public final void checkJumio(CheckListener checkListener) {
        PixNetModel pixNetModel = this.f33413a;
        int i = this.f33418f;
        JumioCreateResultResp.Data value = this.f33414b.getValue();
        String workflowId = value == null ? null : value.getWorkflowId();
        if (workflowId != null) {
            pixNetModel.checkJumio(i, workflowId, new IDTypeVM$checkJumio$1(this, checkListener));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final void setDelayPush(long j) {
        this.f33413a.setDelayPush(j, new IDTypeVM$setDelayPush$1(this));
    }
}
