package com.didi.payment.creditcard.global.presenter;

import android.text.TextUtils;
import com.didi.payment.creditcard.global.contract.CreditCardVerifyContract;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.bean.SignCancelResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawVerifyResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class GlobalVerificationPresenter implements CreditCardVerifyContract.IPresenter {

    /* renamed from: a */
    private CreditCardModel f32893a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreditCardVerifyContract.IView f32894b;

    public GlobalVerificationPresenter(CreditCardVerifyContract.IView iView) {
        this.f32894b = iView;
        this.f32893a = new CreditCardModel(iView.getContext());
    }

    public void removeCard(String str) {
        CreditCardVerifyContract.IView iView = this.f32894b;
        iView.showLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_loading));
        this.f32893a.cancelSign(150, str, new RpcService.Callback<SignCancelResult>() {
            public void onSuccess(SignCancelResult signCancelResult) {
                GlobalVerificationPresenter.this.f32894b.dismissLoadingDialog();
                if (signCancelResult != null) {
                    String str = TextUtils.isEmpty(signCancelResult.hingMsg) ? signCancelResult.errMsg : signCancelResult.hingMsg;
                    if (signCancelResult.errNo == 0) {
                        GlobalVerificationPresenter.this.f32894b.showToastCompleted(str);
                        GlobalVerificationPresenter.this.f32894b.onCancelSignSuccess();
                    } else if (signCancelResult.errNo == 10601 || signCancelResult.errNo == 1020 || signCancelResult.errNo == 10403) {
                        GlobalVerificationPresenter.this.f32894b.showToast(str);
                    } else {
                        GlobalVerificationPresenter.this.f32894b.showToast(str);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                GlobalVerificationPresenter.this.f32894b.dismissLoadingDialog();
            }
        });
    }

    public void verifyCard(String str, String str2, String str3) {
        final String string = this.f32894b.getContext().getString(R.string.one_payment_creditcard_global_net_connerror);
        CreditCardVerifyContract.IView iView = this.f32894b;
        iView.showLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_loading));
        this.f32893a.verifyWithdraw(str, str2, str3, new RpcService.Callback<WithdrawVerifyResult>() {
            public void onSuccess(WithdrawVerifyResult withdrawVerifyResult) {
                GlobalVerificationPresenter.this.f32894b.dismissLoadingDialog();
                if (withdrawVerifyResult == null || withdrawVerifyResult.content == null) {
                    GlobalVerificationPresenter.this.f32894b.showToast(string);
                    return;
                }
                int i = withdrawVerifyResult.content.code;
                String str = withdrawVerifyResult.content.frontMsg;
                switch (i) {
                    case 100001:
                        GlobalVerificationPresenter.this.f32894b.showToastCompleted(str);
                        GlobalVerificationPresenter.this.f32894b.onVerifySuccess();
                        return;
                    case 100002:
                    case 100003:
                        GlobalVerificationPresenter.this.f32894b.showToast(str);
                        GlobalVerificationPresenter.this.f32894b.onVerifyFailure();
                        return;
                    case 100004:
                        GlobalVerificationPresenter.this.f32894b.onVerifyMultiFailure(str, withdrawVerifyResult.getContactH5Url());
                        return;
                    default:
                        GlobalVerificationPresenter.this.f32894b.showToast(string);
                        return;
                }
            }

            public void onFailure(IOException iOException) {
                GlobalVerificationPresenter.this.f32894b.dismissLoadingDialog();
                GlobalVerificationPresenter.this.f32894b.showToast(string);
            }
        });
    }
}
