package com.didi.payment.paymethod.sign.channel.paypal.presenter;

import android.os.CountDownTimer;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignWebContract;
import com.didi.sdk.fastframe.model.ResultCallback;
import java.io.IOException;

public class PayPalSignWebPresenter implements PayPalSignWebContract.Presenter {

    /* renamed from: a */
    private static final int f33525a = 183;

    /* renamed from: b */
    private IGlobalPayMethodModel f33526b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CountDownTimer f33527c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPalSignWebContract.View f33528d;

    public PayPalSignWebPresenter(PayPalSignWebContract.View view) {
        this.f33528d = view;
        this.f33526b = new GlobalPayMethodModel(view.getActivity());
    }

    public void pollSignResult(int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f33527c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            final int i3 = i2 * 1000;
            this.f33528d.showLoadingDialog();
            final int i4 = i;
            this.f33527c = new CountDownTimer((long) (i * i3), (long) i3) {
                public void onTick(long j) {
                    PayPalSignWebPresenter.this.m25458a(i4 - ((int) (j / ((long) i3))));
                }

                public void onFinish() {
                    PayPalSignWebPresenter.this.f33528d.dismissLoadingDialog();
                    PayPalSignWebPresenter.this.m25458a(i4);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25458a(int i) {
        SignPollingQueryReq signPollingQueryReq = new SignPollingQueryReq();
        signPollingQueryReq.channelId = 183;
        signPollingQueryReq.pollingTimes = i;
        this.f33526b.pollSignStatus(signPollingQueryReq, new ResultCallback<SignPollingQueryResp>() {
            public void failure(IOException iOException) {
            }

            public void success(SignPollingQueryResp signPollingQueryResp) {
                if (signPollingQueryResp != null && signPollingQueryResp.errNo == 0) {
                    int i = signPollingQueryResp.status;
                    if (i == 1) {
                        PayPalSignWebPresenter.this.f33528d.dismissLoadingDialog();
                        PayPalSignWebPresenter.this.f33528d.onSignSuccess(signPollingQueryResp.hintMsg);
                        PayPalSignWebPresenter.this.f33527c.cancel();
                    } else if (i == 2) {
                        PayPalSignWebPresenter.this.f33528d.dismissLoadingDialog();
                        PayPalSignWebPresenter.this.f33528d.onSignFailure(signPollingQueryResp.hintMsg);
                        PayPalSignWebPresenter.this.f33527c.cancel();
                    }
                }
            }
        });
    }
}
