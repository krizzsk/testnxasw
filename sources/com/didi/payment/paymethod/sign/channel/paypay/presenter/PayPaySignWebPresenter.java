package com.didi.payment.paymethod.sign.channel.paypay.presenter;

import android.os.CountDownTimer;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignWebContract;
import com.didi.sdk.fastframe.model.ResultCallback;
import java.io.IOException;

public class PayPaySignWebPresenter implements PayPaySignWebContract.Presenter {

    /* renamed from: a */
    private static final int f33548a = 182;

    /* renamed from: b */
    private IGlobalPayMethodModel f33549b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CountDownTimer f33550c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPaySignWebContract.View f33551d;

    public PayPaySignWebPresenter(PayPaySignWebContract.View view) {
        this.f33551d = view;
        this.f33549b = new GlobalPayMethodModel(view.getActivity());
    }

    public void pollSignResult(int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f33550c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f33551d.showLoadingDialog();
            final int i3 = i2 * 1000;
            final int i4 = i;
            this.f33550c = new CountDownTimer((long) (i * i3), (long) i3) {
                public void onTick(long j) {
                    PayPaySignWebPresenter.this.m25477a(i4 - ((int) (j / ((long) i3))));
                }

                public void onFinish() {
                    PayPaySignWebPresenter.this.f33551d.dismissLoadingDialog();
                    PayPaySignWebPresenter.this.m25477a(i4);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25477a(int i) {
        SignPollingQueryReq signPollingQueryReq = new SignPollingQueryReq();
        signPollingQueryReq.channelId = 182;
        signPollingQueryReq.pollingTimes = i;
        this.f33549b.pollSignStatus(signPollingQueryReq, new ResultCallback<SignPollingQueryResp>() {
            public void failure(IOException iOException) {
            }

            public void success(SignPollingQueryResp signPollingQueryResp) {
                if (signPollingQueryResp != null && signPollingQueryResp.errNo == 0) {
                    int i = signPollingQueryResp.status;
                    if (i == 1) {
                        PayPaySignWebPresenter.this.f33551d.dismissLoadingDialog();
                        PayPaySignWebPresenter.this.f33551d.onSignSuccess(signPollingQueryResp.hintMsg);
                        PayPaySignWebPresenter.this.f33550c.cancel();
                    } else if (i == 2) {
                        PayPaySignWebPresenter.this.f33551d.dismissLoadingDialog();
                        PayPaySignWebPresenter.this.f33551d.onSignFailure(signPollingQueryResp.hintMsg);
                        PayPaySignWebPresenter.this.f33550c.cancel();
                    }
                }
            }
        });
    }
}
