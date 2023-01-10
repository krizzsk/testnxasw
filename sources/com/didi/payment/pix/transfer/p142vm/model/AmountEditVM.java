package com.didi.payment.pix.transfer.p142vm.model;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.pix.net.PixNetModel;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020&2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010&J\b\u0010?\u001a\u00020:H\u0016J\b\u0010@\u001a\u00020:H\u0002J\u000e\u0010A\u001a\u00020:2\u0006\u0010%\u001a\u00020&J\u0016\u0010B\u001a\u00020:2\u0006\u0010%\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0013J\u000e\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020&J\u0006\u0010F\u001a\u00020:J\u0016\u0010G\u001a\u00020:2\u0006\u0010E\u001a\u00020&2\u0006\u0010H\u001a\u00020<R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020&0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R \u0010.\u001a\b\u0012\u0004\u0012\u00020/0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u000fR \u00105\u001a\b\u0012\u0004\u0012\u0002060\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011¨\u0006I"}, mo148868d2 = {"Lcom/didi/payment/pix/transfer/vm/model/AmountEditVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TIME_INTERVAL", "", "getTIME_INTERVAL", "()J", "setTIME_INTERVAL", "(J)V", "errCreateOrder", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "getErrCreateOrder", "()Landroidx/lifecycle/MutableLiveData;", "setErrCreateOrder", "(Landroidx/lifecycle/MutableLiveData;)V", "isNewLimitCheck", "", "()Z", "mCountDownTimer", "Landroid/os/CountDownTimer;", "netModel", "Lcom/didi/payment/pix/net/PixNetModel;", "nightlyLimitSettingModel", "Lcom/didi/payment/wallet/global/model/NightlyLimitSettingModel;", "nightlyLimitVo", "Lcom/didi/payment/wallet/global/model/resp/GetNightlyLimitResp$NightlyLimitVo;", "getNightlyLimitVo", "orderDetailLD", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "getOrderDetailLD", "setOrderDetailLD", "orderDetailLooping", "getOrderDetailLooping", "setOrderDetailLooping", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "outTradeIdVo", "getOutTradeIdVo", "setOutTradeIdVo", "pixAccountQueryByQr", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "getPixAccountQueryByQr", "setPixAccountQueryByQr", "pwdData", "Lcom/didi/payment/wallet/password/PasswordDataVo;", "getPwdData", "transferOption", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "getTransferOption", "setTransferOption", "createPixTransferOrder", "", "productId", "", "bizContent", "passwordToken", "loadData", "loadNightlyLimitConfig", "loopQueryOrderDetail", "queryOrderDetail", "isLastCheck", "queryPixKeyDetail", "key", "stopCountTimer", "triggerRealtimePush", "type", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM extends WBaseViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CountDownTimer f33799a;

    /* renamed from: b */
    private PixNetModel f33800b;

    /* renamed from: c */
    private final NightlyLimitSettingModel f33801c;

    /* renamed from: d */
    private final MutableLiveData<GetNightlyLimitResp.NightlyLimitVo> f33802d = new MutableLiveData<>();

    /* renamed from: e */
    private MutableLiveData<WBaseResp> f33803e = new MutableLiveData<>();

    /* renamed from: f */
    private MutableLiveData<Boolean> f33804f = new MutableLiveData<>();

    /* renamed from: g */
    private MutableLiveData<PixOrderDetailResp.OrderDetail> f33805g = new MutableLiveData<>();

    /* renamed from: h */
    private MutableLiveData<PixTransferOption.TransferOptionInfo> f33806h = new MutableLiveData<>();

    /* renamed from: i */
    private MutableLiveData<PixKeyVerifyResp.PixAccount> f33807i = new MutableLiveData<>();

    /* renamed from: j */
    private final MutableLiveData<PasswordDataVo> f33808j = new MutableLiveData<>();

    /* renamed from: k */
    private long f33809k = 1000;

    /* renamed from: l */
    private MutableLiveData<String> f33810l = new MutableLiveData<>();

    /* renamed from: m */
    private String f33811m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmountEditVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Context context = application;
        this.f33800b = new PixNetModel(context);
        this.f33801c = new NightlyLimitSettingModel(context);
    }

    public final MutableLiveData<GetNightlyLimitResp.NightlyLimitVo> getNightlyLimitVo() {
        return this.f33802d;
    }

    public final MutableLiveData<WBaseResp> getErrCreateOrder() {
        return this.f33803e;
    }

    public final void setErrCreateOrder(MutableLiveData<WBaseResp> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33803e = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getOrderDetailLooping() {
        return this.f33804f;
    }

    public final void setOrderDetailLooping(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33804f = mutableLiveData;
    }

    public final MutableLiveData<PixOrderDetailResp.OrderDetail> getOrderDetailLD() {
        return this.f33805g;
    }

    public final void setOrderDetailLD(MutableLiveData<PixOrderDetailResp.OrderDetail> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33805g = mutableLiveData;
    }

    public final MutableLiveData<PixTransferOption.TransferOptionInfo> getTransferOption() {
        return this.f33806h;
    }

    public final void setTransferOption(MutableLiveData<PixTransferOption.TransferOptionInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33806h = mutableLiveData;
    }

    public final MutableLiveData<PixKeyVerifyResp.PixAccount> getPixAccountQueryByQr() {
        return this.f33807i;
    }

    public final void setPixAccountQueryByQr(MutableLiveData<PixKeyVerifyResp.PixAccount> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33807i = mutableLiveData;
    }

    public final MutableLiveData<PasswordDataVo> getPwdData() {
        return this.f33808j;
    }

    public final long getTIME_INTERVAL() {
        return this.f33809k;
    }

    public final void setTIME_INTERVAL(long j) {
        this.f33809k = j;
    }

    public final MutableLiveData<String> getOutTradeIdVo() {
        return this.f33810l;
    }

    public final void setOutTradeIdVo(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f33810l = mutableLiveData;
    }

    public final String getOrderId() {
        return this.f33811m;
    }

    public final void setOrderId(String str) {
        this.f33811m = str;
    }

    public final boolean isNewLimitCheck() {
        return NewCashierApolloUtils.useNewCashier4Pix();
    }

    public void loadData() {
        isLoading().setValue(true);
        this.f33800b.getTransferOptionInfo(new AmountEditVM$loadData$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25678a() {
        isLoading().setValue(true);
        this.f33801c.getNightlyLimit(99996, new AmountEditVM$loadNightlyLimitConfig$1(this));
    }

    public static /* synthetic */ void createPixTransferOrder$default(AmountEditVM amountEditVM, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        amountEditVM.createPixTransferOrder(i, str, str2);
    }

    public final void createPixTransferOrder(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, Const.PayParams.BIZ_CONTENT);
        this.f33804f.setValue(true);
        this.f33800b.createTransferOrder(i, 0, "{\"currency\":\"BRL\", \"sku\":\"pix key transfer\"}", str, str2, new AmountEditVM$createPixTransferOrder$1(this, str));
    }

    public final void queryPixKeyDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        isLoading().setValue(true);
        this.f33800b.verifyPixKey(str, true, new AmountEditVM$queryPixKeyDetail$1(this));
    }

    public final void loopQueryOrderDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        if (this.f33799a == null) {
            this.f33799a = new AmountEditVM$loopQueryOrderDetail$1(this, str, 10000, ((long) 2) * this.f33809k);
        }
        CountDownTimer countDownTimer = this.f33799a;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void stopCountTimer() {
        CountDownTimer countDownTimer = this.f33799a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void queryOrderDetail(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        SystemUtils.log(3, "hgl", "queryOrderDetail...", (Throwable) null, "com.didi.payment.pix.transfer.vm.model.AmountEditVM", 205);
        this.f33804f.setValue(true);
        this.f33800b.getOrderDetail(str, new AmountEditVM$queryOrderDetail$1(this, z, str));
    }

    public final void triggerRealtimePush(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f33800b.notifyTransferPush(str, i, new AmountEditVM$triggerRealtimePush$1());
    }
}
