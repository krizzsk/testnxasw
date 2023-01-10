package com.didichuxing.security.cardverify.presenter;

import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.model.CardModel;
import com.didichuxing.security.cardverify.model.bean.WithdrawVerifyResult;
import com.taxis99.R;
import java.io.IOException;

public class VerificationPresenter implements CreditCardVerifyContract.IPresenter {

    /* renamed from: a */
    private CardModel f51511a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreditCardVerifyContract.IView f51512b;

    public VerificationPresenter(CreditCardVerifyContract.IView iView, DiCardVerifyParam diCardVerifyParam) {
        this.f51512b = iView;
        this.f51511a = new CardModel(iView.getContext(), diCardVerifyParam);
    }

    public void verifyCard(String str, String str2) {
        CreditCardVerifyContract.IView iView = this.f51512b;
        iView.showLoadingDialog(iView.getContext().getString(R.string.didi_security_card_verify_net_loading));
        this.f51511a.verifyWithdraw(str, str2, new RpcService.Callback<WithdrawVerifyResult>() {
            public void onSuccess(WithdrawVerifyResult withdrawVerifyResult) {
                VerificationPresenter.this.f51512b.dismissLoadingDialog();
                if (withdrawVerifyResult == null || withdrawVerifyResult.content == null) {
                    VerificationPresenter.this.f51512b.onVerifyException();
                    VerificationPresenter.this.f51512b.showToast(VerificationPresenter.this.f51512b.getContext().getString(R.string.didi_security_card_verify_net_serverbusy));
                    return;
                }
                int i = withdrawVerifyResult.content.code;
                String str = withdrawVerifyResult.content.frontMsg;
                switch (i) {
                    case 100001:
                        VerificationPresenter.this.f51512b.showToastCompleted(str);
                        VerificationPresenter.this.f51512b.onVerifySuccess();
                        return;
                    case 100002:
                    case 100003:
                        VerificationPresenter.this.f51512b.showToast(str);
                        VerificationPresenter.this.f51512b.onVerifyFailure();
                        return;
                    case 100004:
                        VerificationPresenter.this.f51512b.onVerifyMultiFailure(str, withdrawVerifyResult.getContactH5Url());
                        return;
                    default:
                        VerificationPresenter.this.f51512b.onVerifyException();
                        VerificationPresenter.this.f51512b.showToast(VerificationPresenter.this.f51512b.getContext().getString(R.string.didi_security_card_verify_net_serverbusy));
                        return;
                }
            }

            public void onFailure(IOException iOException) {
                VerificationPresenter.this.f51512b.onVerifyException();
                VerificationPresenter.this.f51512b.dismissLoadingDialog();
                VerificationPresenter.this.f51512b.showToast(VerificationPresenter.this.f51512b.getContext().getString(R.string.didi_security_card_verify_net_connerror));
            }
        });
    }
}
