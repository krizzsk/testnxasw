package com.didichuxing.security.cardverify.globalpay.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.globalpay.activity.GlobalPayCardVerificationActivity;
import com.didichuxing.security.cardverify.globalpay.activity.GlobalRandomPayConfirmActivity;
import com.didichuxing.security.cardverify.globalpay.utils.GlobalPayToast;
import com.didichuxing.security.cardverify.model.CardModel;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import com.didichuxing.security.cardverify.model.bean.WithdrawPollResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawResult;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.taxis99.R;
import java.io.IOException;

public class GlobalPayVerificationPrePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GlobalRandomPayConfirmActivity f51488a;

    /* renamed from: b */
    private CardModel f51489b;

    /* renamed from: c */
    private DiCardVerifyParam f51490c;

    /* renamed from: d */
    private Handler f51491d = new Handler(Looper.getMainLooper());

    public GlobalPayVerificationPrePresenter(DiCardVerifyParam diCardVerifyParam) {
        this.f51490c = diCardVerifyParam;
    }

    public void startVerification(GlobalRandomPayConfirmActivity globalRandomPayConfirmActivity, DiCardVerifyParam diCardVerifyParam, String str, DiCardVerifyCallback diCardVerifyCallback) {
        if (globalRandomPayConfirmActivity != null && diCardVerifyParam != null) {
            this.f51488a = globalRandomPayConfirmActivity;
            this.f51489b = new CardModel(globalRandomPayConfirmActivity, diCardVerifyParam);
            m38568a(str, diCardVerifyCallback);
        }
    }

    /* renamed from: a */
    private void m38568a(String str, final DiCardVerifyCallback diCardVerifyCallback) {
        this.f51488a.showVerifyConfirmDialog(m38553a(str, this.f51490c.getCardNo()), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayVerificationPrePresenter.this.m38557a(diCardVerifyCallback);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayVerificationPrePresenter.this.f51488a.finish();
                GlobalPayVerificationPrePresenter.this.m38560a(diCardVerifyCallback, 2, "user cancel");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38557a(final DiCardVerifyCallback diCardVerifyCallback) {
        this.f51488a.showLoading();
        this.f51488a.payStart();
        this.f51489b.doWithdraw(new RpcService.Callback<WithdrawResult>() {
            public void onSuccess(WithdrawResult withdrawResult) {
                int i;
                if (withdrawResult == null || withdrawResult.content == null || withdrawResult.content.extend == null) {
                    GlobalPayVerificationPrePresenter.this.m38554a();
                    diCardVerifyCallback.onCallback(8, "random pay fail");
                    return;
                }
                int i2 = withdrawResult.content.code;
                String str = withdrawResult.content.frontMsg;
                int i3 = 0;
                if (withdrawResult.content.extend.size() > 0) {
                    int i4 = withdrawResult.content.extend.get(0).maxPollingTimes;
                    i = withdrawResult.content.extend.get(0).pollingFrequency;
                    i3 = i4;
                } else {
                    i = 0;
                }
                if (i2 == 100002 || i2 == 100003) {
                    GlobalPayVerificationPrePresenter.this.m38555a(i3, i, diCardVerifyCallback);
                } else if (i2 == 100001) {
                    GlobalPayVerificationPrePresenter.this.m38554a();
                    diCardVerifyCallback.onCallback(3, "insufficient balance");
                } else {
                    GlobalPayVerificationPrePresenter.this.m38554a();
                    diCardVerifyCallback.onCallback(8, "random pay fail");
                }
            }

            public void onFailure(IOException iOException) {
                GlobalPayVerificationPrePresenter globalPayVerificationPrePresenter = GlobalPayVerificationPrePresenter.this;
                globalPayVerificationPrePresenter.m38556a((Context) globalPayVerificationPrePresenter.f51488a, GlobalPayVerificationPrePresenter.this.f51488a.getString(R.string.didi_security_card_verify_net_connerror));
                GlobalPayVerificationPrePresenter.this.f51488a.hideLoading();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38555a(int i, int i2, DiCardVerifyCallback diCardVerifyCallback) {
        if (i <= 0 || i2 <= 0) {
            m38554a();
            diCardVerifyCallback.onCallback(9, "polling fail");
            return;
        }
        m38558a(diCardVerifyCallback, i, (long) (i2 * 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38558a(DiCardVerifyCallback diCardVerifyCallback, int i, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int i2 = i;
        final DiCardVerifyCallback diCardVerifyCallback2 = diCardVerifyCallback;
        final long j2 = j;
        this.f51489b.pollingQueryWithdrawStatus(new RpcService.Callback<WithdrawPollResult>() {
            public void onSuccess(WithdrawPollResult withdrawPollResult) {
                if (withdrawPollResult == null || withdrawPollResult.content == null) {
                    int i = i2;
                    if (i - 1 > 0) {
                        GlobalPayVerificationPrePresenter.this.m38559a(diCardVerifyCallback2, i - 1, j2, currentTimeMillis);
                        return;
                    }
                    GlobalPayVerificationPrePresenter.this.m38554a();
                    diCardVerifyCallback2.onCallback(9, "polling fail");
                    return;
                }
                int i2 = withdrawPollResult.content.code;
                String str = withdrawPollResult.content.frontMsg;
                if (i2 != 100001) {
                    int i3 = i2;
                    if (i3 - 1 > 0) {
                        GlobalPayVerificationPrePresenter.this.m38559a(diCardVerifyCallback2, i3 - 1, j2, currentTimeMillis);
                        return;
                    }
                    GlobalPayVerificationPrePresenter.this.m38554a();
                    diCardVerifyCallback2.onCallback(9, "polling fail");
                    return;
                }
                GlobalPayVerificationPrePresenter.this.f51488a.paySuccess();
                GlobalPayVerificationPrePresenter.this.m38569a(str, (withdrawPollResult.content.extendResultList == null || withdrawPollResult.content.extendResultList.size() <= 0) ? null : withdrawPollResult.content.extendResultList.get(0), diCardVerifyCallback2);
            }

            public void onFailure(IOException iOException) {
                int i = i2;
                if (i - 1 > 0) {
                    GlobalPayVerificationPrePresenter.this.m38559a(diCardVerifyCallback2, i - 1, j2, currentTimeMillis);
                    return;
                }
                GlobalPayVerificationPrePresenter globalPayVerificationPrePresenter = GlobalPayVerificationPrePresenter.this;
                globalPayVerificationPrePresenter.m38556a((Context) globalPayVerificationPrePresenter.f51488a, GlobalPayVerificationPrePresenter.this.f51488a.getString(R.string.didi_security_card_verify_net_connerror));
                GlobalPayVerificationPrePresenter.this.f51488a.hideLoading();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38559a(DiCardVerifyCallback diCardVerifyCallback, int i, long j, long j2) {
        long currentTimeMillis = j - (System.currentTimeMillis() - j2);
        if (currentTimeMillis > 200) {
            final DiCardVerifyCallback diCardVerifyCallback2 = diCardVerifyCallback;
            final int i2 = i;
            final long j3 = j;
            this.f51491d.postDelayed(new Runnable() {
                public void run() {
                    GlobalPayVerificationPrePresenter.this.m38558a(diCardVerifyCallback2, i2, j3);
                }
            }, currentTimeMillis);
            return;
        }
        m38558a(diCardVerifyCallback, i, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38569a(String str, WithdrawPageInfo.ExtendContent extendContent, DiCardVerifyCallback diCardVerifyCallback) {
        String a = m38553a(str, this.f51490c.getCardNo());
        CardVerifyInfo cardVerifyInfo = new CardVerifyInfo();
        cardVerifyInfo.pageContent = a;
        if (extendContent != null) {
            cardVerifyInfo.currencyText = extendContent.currency;
            boolean z = false;
            cardVerifyInfo.isShowDecimal = extendContent.isDecimal == 1;
            if (extendContent.isSuffix == 1) {
                z = true;
            }
            cardVerifyInfo.isCurrencySuffix = z;
            cardVerifyInfo.defaultText = extendContent.defaultText;
        }
        DiCardVerifyTracker.trackVerify(1);
        GlobalPayCardVerificationActivity.startActivity(this.f51488a, this.f51490c, cardVerifyInfo, diCardVerifyCallback);
        m38554a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38554a() {
        GlobalRandomPayConfirmActivity globalRandomPayConfirmActivity = this.f51488a;
        if (globalRandomPayConfirmActivity != null) {
            globalRandomPayConfirmActivity.hideLoading();
            this.f51488a.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38556a(Context context, String str) {
        GlobalPayToast.show(context, str);
    }

    /* renamed from: a */
    private String m38553a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 4) ? str : str.replaceAll("[*][*][*][*]", str2.substring(str2.length() - 4, str2.length()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38560a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
