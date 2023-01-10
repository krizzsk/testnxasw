package com.didi.global.fintech.cashier.soda;

import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierRandomVerifyActionCallBack;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u001a\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u0013H\u0016J\u001a\u0010'\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u000eH\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006)"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/BaseCashierFragment;", "P", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "Landroidx/fragment/app/Fragment;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierRandomVerifyActionCallBack;", "()V", "mPresenter", "getMPresenter", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "setMPresenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;)V", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "onAdyenThreeDSSuccess", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onCardBind", "cardIndex", "", "onCardVerify", "onCashierClose", "payResult", "", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onRandomVerifyResult", "code", "msg", "onThreeDSCancel", "error", "type", "onThreeDSFailed", "onTopUp", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BaseCashierFragment.kt */
public abstract class BaseCashierFragment<P extends IGlobalBizCashierPresenter> extends Fragment implements IGlobalCashierActionHandleCallback, IGlobalCashierRandomVerifyActionCallBack {

    /* renamed from: a */
    private P f23531a;

    public void onCashierClose(int i) {
    }

    /* access modifiers changed from: protected */
    public final P getMPresenter() {
        return this.f23531a;
    }

    /* access modifiers changed from: protected */
    public final void setMPresenter(P p) {
        this.f23531a = p;
    }

    public void onPixPaid() {
        SystemUtils.log(4, "Arirus", "onPixPaid: ", (Throwable) null, "com.didi.global.fintech.cashier.soda.BaseCashierFragment", 20);
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPixPaid();
        }
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        SystemUtils.log(4, "Arirus", "onThreedsSuccess: ", (Throwable) null, "com.didi.global.fintech.cashier.soda.BaseCashierFragment", 25);
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onAdyenThreeDSSuccess(globalCashierAdyen3DSModel);
        }
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCybsThreeDSSuccess(threeDSV2, str);
        }
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        SystemUtils.log(4, "Arirus", "onThreeDSFailed: ", (Throwable) null, "com.didi.global.fintech.cashier.soda.BaseCashierFragment", 34);
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onThreeDSFailed(str, str2);
        }
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        SystemUtils.log(4, "Arirus", "onThreeDSCancel: ", (Throwable) null, "com.didi.global.fintech.cashier.soda.BaseCashierFragment", 39);
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onThreeDSCancel(str, str2);
        }
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordSuccess(str);
        }
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordFailed(str, str2);
        }
    }

    public void onCardBind(String str) {
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCardBind(str);
        }
    }

    public void onCardVerify(String str) {
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCardVerify(str);
        }
    }

    public void onTopUp() {
        P p = this.f23531a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = p instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) p : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onTopUp();
        }
    }

    public void onRandomVerifyResult(int i, String str) {
        P p = this.f23531a;
        IGlobalCashierRandomVerifyActionCallBack iGlobalCashierRandomVerifyActionCallBack = p instanceof IGlobalCashierRandomVerifyActionCallBack ? (IGlobalCashierRandomVerifyActionCallBack) p : null;
        if (iGlobalCashierRandomVerifyActionCallBack != null) {
            iGlobalCashierRandomVerifyActionCallBack.onRandomVerifyResult(i, str);
        }
    }
}
