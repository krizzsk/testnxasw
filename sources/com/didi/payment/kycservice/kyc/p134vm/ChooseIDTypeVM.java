package com.didi.payment.kycservice.kyc.p134vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.kycservice.kyc.response.DoorGodResp;
import com.didi.payment.kycservice.kyc.response.FaceInitInfoResp;
import com.didi.payment.kycservice.kyc.response.FaceResultResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010#\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020*J\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u00104\u001a\u00020*R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u001a\u0010&\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u00066"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseIDTypeVM;", "Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "doorGodInitLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/kyc/response/DoorGodResp$Data;", "getDoorGodInitLD", "()Landroidx/lifecycle/MutableLiveData;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "faceInitLD", "Lcom/didi/payment/kycservice/kyc/response/FaceInitInfoResp$Data;", "getFaceInitLD", "faceResultLD", "Lcom/didi/payment/kycservice/kyc/response/FaceResultResp;", "getFaceResultLD", "faceScene", "", "getFaceScene", "()I", "setFaceScene", "(I)V", "pollCount", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "showResultPageLD", "", "getShowResultPageLD", "source", "getSource", "setSource", "verifyFaceType", "getVerifyFaceType", "setVerifyFaceType", "reqDoorGodInitInfo", "", "faceType", "", "fromPrimary", "reqDoorGodResult", "reqFaceInitInfo", "srcFrom", "reqFaceResult", "reqFaceResultImpl", "sessionId", "submitHumanCheck", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM */
/* compiled from: ChooseIDTypeVM.kt */
public final class ChooseIDTypeVM extends ChooseTypeBaseVM {
    public static final String CARD_ARRAY_CNH = "BR_J1,BR_J2";
    public static final String CARD_ARRAY_RG = "BR_S1,BR_S2";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FACE_SCENE_BLOCK = 1;
    public static final int FACE_SCENE_FULL_KYC = 0;
    public static final String TYPE_CNH = "cnh";
    public static final String TYPE_RG = "rg";

    /* renamed from: a */
    private final MutableLiveData<DoorGodResp.Data> f33382a = new MutableLiveData<>();

    /* renamed from: b */
    private final MutableLiveData<FaceInitInfoResp.Data> f33383b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<FaceResultResp> f33384c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<Boolean> f33385d = new MutableLiveData<>();

    /* renamed from: e */
    private int f33386e;

    /* renamed from: f */
    private ResultPageData f33387f;

    /* renamed from: g */
    private int f33388g;

    /* renamed from: h */
    private int f33389h;

    /* renamed from: i */
    private final ScheduledExecutorService f33390i = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f33391j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseIDTypeVM(Application application) {
        super(application, 0);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseIDTypeVM$Companion;", "", "()V", "CARD_ARRAY_CNH", "", "CARD_ARRAY_RG", "FACE_SCENE_BLOCK", "", "FACE_SCENE_FULL_KYC", "TYPE_CNH", "TYPE_RG", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM$Companion */
    /* compiled from: ChooseIDTypeVM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final MutableLiveData<DoorGodResp.Data> getDoorGodInitLD() {
        return this.f33382a;
    }

    public final MutableLiveData<FaceInitInfoResp.Data> getFaceInitLD() {
        return this.f33383b;
    }

    public final MutableLiveData<FaceResultResp> getFaceResultLD() {
        return this.f33384c;
    }

    public final MutableLiveData<Boolean> getShowResultPageLD() {
        return this.f33385d;
    }

    public final int getVerifyFaceType() {
        return this.f33386e;
    }

    public final void setVerifyFaceType(int i) {
        this.f33386e = i;
    }

    public final ResultPageData getResultPageData() {
        return this.f33387f;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f33387f = resultPageData;
    }

    public final int getSource() {
        return this.f33388g;
    }

    public final void setSource(int i) {
        this.f33388g = i;
    }

    public final int getFaceScene() {
        return this.f33389h;
    }

    public final void setFaceScene(int i) {
        this.f33389h = i;
    }

    public final void reqFaceInitInfo(int i) {
        getNetModel().reqFaceInitInfo(i, this.f33388g, this.f33389h, new ChooseIDTypeVM$reqFaceInitInfo$1(this));
    }

    public static /* synthetic */ void reqDoorGodInitInfo$default(ChooseIDTypeVM chooseIDTypeVM, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        chooseIDTypeVM.reqDoorGodInitInfo(i, str, i2);
    }

    public final void reqDoorGodInitInfo(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "source");
        getNetModel().reqDoorGodInitInfo(i, this.f33389h, str, i2, new ChooseIDTypeVM$reqDoorGodInitInfo$1(this));
    }

    public final void reqDoorGodResult() {
        String keeperId;
        DoorGodResp.Data value = this.f33382a.getValue();
        String str = "";
        if (!(value == null || (keeperId = value.getKeeperId()) == null)) {
            str = keeperId;
        }
        if (!(str.length() == 0)) {
            getNetModel().reqDoorGodResult(this.f33386e, str, new ChooseIDTypeVM$reqDoorGodResult$1(this));
        }
    }

    public final void reqFaceResult(int i) {
        String sessionId;
        FaceInitInfoResp.Data value = this.f33383b.getValue();
        String str = "";
        if (!(value == null || (sessionId = value.getSessionId()) == null)) {
            str = sessionId;
        }
        if (!(str.length() == 0)) {
            this.f33391j = 0;
            m25402a(str, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25402a(String str, int i) {
        getNetModel().reqFaceResult(str, this.f33388g, i, new ChooseIDTypeVM$reqFaceResultImpl$1(this, str, i));
    }

    public final void submitHumanCheck() {
        String sessionId;
        FaceInitInfoResp.Data value = this.f33383b.getValue();
        String str = "";
        if (!(value == null || (sessionId = value.getSessionId()) == null)) {
            str = sessionId;
        }
        if (!(str.length() == 0)) {
            getNetModel().submitHumanCheck(str, new ChooseIDTypeVM$submitHumanCheck$1(this));
        }
    }
}
