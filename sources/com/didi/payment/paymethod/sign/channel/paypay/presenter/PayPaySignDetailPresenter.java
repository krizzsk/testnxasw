package com.didi.payment.paymethod.sign.channel.paypay.presenter;

import android.text.TextUtils;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignDetailContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class PayPaySignDetailPresenter implements PayPaySignDetailContract.Presenter {

    /* renamed from: a */
    private static final int f33545a = 182;

    /* renamed from: b */
    private IGlobalPayMethodModel f33546b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PayPaySignDetailContract.View f33547c;

    public PayPaySignDetailPresenter(PayPaySignDetailContract.View view) {
        this.f33547c = view;
        this.f33546b = new GlobalPayMethodModel(view.getActivity());
    }

    public void requestCancelSign() {
        this.f33547c.showLoadingDialog();
        SignCancelReq signCancelReq = new SignCancelReq();
        signCancelReq.channelId = 182;
        this.f33546b.cancelSign(signCancelReq, new RpcService.Callback<SignCancelResp>() {
            public void onSuccess(SignCancelResp signCancelResp) {
                PayPaySignDetailPresenter.this.f33547c.dismissLoadingDialog();
                if (signCancelResp != null) {
                    if (signCancelResp.errNo == 0) {
                        PayPaySignDetailPresenter.this.f33547c.onCancelSignSuccess(TextUtils.isEmpty(signCancelResp.hingMsg) ? signCancelResp.errMsg : signCancelResp.hingMsg);
                    } else {
                        PayPaySignDetailPresenter.this.f33547c.onCancelSignFailure(signCancelResp.errMsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                PayPaySignDetailPresenter.this.f33547c.dismissLoadingDialog();
                PayPaySignDetailPresenter.this.f33547c.onCancelSignFailure(PayPaySignDetailPresenter.this.f33547c.getActivity().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }
}
