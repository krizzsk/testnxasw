package com.didichuxing.security.cardverify.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.activity.CardVerificationActivity;
import com.didichuxing.security.cardverify.activity.RandomPayTransActivity;
import com.didichuxing.security.cardverify.model.CardModel;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import com.didichuxing.security.cardverify.model.bean.WithdrawPollResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawResult;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.taxis99.R;
import java.io.IOException;

public class VerificationPrePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RandomPayTransActivity f51507a;

    /* renamed from: b */
    private CardModel f51508b;

    /* renamed from: c */
    private DiCardVerifyParam f51509c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f51510d;

    public VerificationPrePresenter(DiCardVerifyParam diCardVerifyParam) {
        this.f51509c = diCardVerifyParam;
    }

    public void startVerification(RandomPayTransActivity randomPayTransActivity, DiCardVerifyParam diCardVerifyParam, final String str, final DiCardVerifyCallback diCardVerifyCallback) {
        if (randomPayTransActivity != null && diCardVerifyParam != null) {
            this.f51507a = randomPayTransActivity;
            this.f51508b = new CardModel(randomPayTransActivity, diCardVerifyParam);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    VerificationPrePresenter.this.m38601a(str, diCardVerifyCallback);
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38601a(String str, final DiCardVerifyCallback diCardVerifyCallback) {
        this.f51507a.showVerifyConfirmDialog(m38586a(str, this.f51509c.getCardNo()), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                VerificationPrePresenter.this.f51507a.showDrawerLoading();
                VerificationPrePresenter.this.m38589a(diCardVerifyCallback);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                VerificationPrePresenter.this.m38592a(diCardVerifyCallback, 2, "cancel pay");
                VerificationPrePresenter.this.f51507a.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38589a(final DiCardVerifyCallback diCardVerifyCallback) {
        this.f51507a.payStart();
        this.f51508b.doWithdraw(new RpcService.Callback<WithdrawResult>() {
            public void onSuccess(WithdrawResult withdrawResult) {
                int i;
                if (withdrawResult == null || withdrawResult.content == null || withdrawResult.content.extend == null) {
                    VerificationPrePresenter verificationPrePresenter = VerificationPrePresenter.this;
                    verificationPrePresenter.m38588a((Context) verificationPrePresenter.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_serverbusy));
                    VerificationPrePresenter.this.f51507a.finish();
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
                    VerificationPrePresenter.this.m38587a(i3, i, diCardVerifyCallback);
                } else if (i2 == 100001) {
                    VerificationPrePresenter verificationPrePresenter2 = VerificationPrePresenter.this;
                    verificationPrePresenter2.m38588a((Context) verificationPrePresenter2.f51507a, str);
                    VerificationPrePresenter.this.f51507a.finish();
                } else {
                    VerificationPrePresenter verificationPrePresenter3 = VerificationPrePresenter.this;
                    verificationPrePresenter3.m38588a((Context) verificationPrePresenter3.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_serverbusy));
                    VerificationPrePresenter.this.f51507a.finish();
                }
            }

            public void onFailure(IOException iOException) {
                VerificationPrePresenter verificationPrePresenter = VerificationPrePresenter.this;
                verificationPrePresenter.m38588a((Context) verificationPrePresenter.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_connerror));
                VerificationPrePresenter.this.f51507a.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38587a(int i, int i2, DiCardVerifyCallback diCardVerifyCallback) {
        if (i <= 0 || i2 <= 0) {
            RandomPayTransActivity randomPayTransActivity = this.f51507a;
            m38588a((Context) randomPayTransActivity, randomPayTransActivity.getString(R.string.didi_security_card_verify_net_serverbusy));
            this.f51507a.finish();
            return;
        }
        m38590a(diCardVerifyCallback, i, (long) (i2 * 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38590a(DiCardVerifyCallback diCardVerifyCallback, int i, long j) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int i2 = i;
        final DiCardVerifyCallback diCardVerifyCallback2 = diCardVerifyCallback;
        final long j2 = j;
        this.f51508b.pollingQueryWithdrawStatus(new RpcService.Callback<WithdrawPollResult>() {
            public void onSuccess(WithdrawPollResult withdrawPollResult) {
                if (withdrawPollResult == null || withdrawPollResult.content == null) {
                    int i = i2;
                    if (i - 1 > 0) {
                        VerificationPrePresenter.this.m38591a(diCardVerifyCallback2, i - 1, j2, currentTimeMillis);
                        return;
                    }
                    VerificationPrePresenter verificationPrePresenter = VerificationPrePresenter.this;
                    verificationPrePresenter.m38588a((Context) verificationPrePresenter.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_serverbusy));
                    VerificationPrePresenter.this.f51507a.finish();
                    return;
                }
                int i2 = withdrawPollResult.content.code;
                String str = withdrawPollResult.content.frontMsg;
                WithdrawPageInfo.ExtendContent extendContent = null;
                if (i2 != 100001) {
                    int i3 = i2;
                    if (i3 - 1 > 0) {
                        VerificationPrePresenter.this.m38591a(diCardVerifyCallback2, i3 - 1, j2, currentTimeMillis);
                        return;
                    }
                    Handler unused = VerificationPrePresenter.this.f51510d = null;
                    VerificationPrePresenter verificationPrePresenter2 = VerificationPrePresenter.this;
                    verificationPrePresenter2.m38588a((Context) verificationPrePresenter2.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_serverbusy));
                    VerificationPrePresenter.this.f51507a.finish();
                    return;
                }
                VerificationPrePresenter.this.f51507a.paySuccess();
                VerificationPrePresenter verificationPrePresenter3 = VerificationPrePresenter.this;
                if (withdrawPollResult.content.extendResultList != null && withdrawPollResult.content.extendResultList.size() > 0) {
                    extendContent = withdrawPollResult.content.extendResultList.get(0);
                }
                verificationPrePresenter3.m38602a(str, extendContent, diCardVerifyCallback2);
            }

            public void onFailure(IOException iOException) {
                int i = i2;
                if (i - 1 > 0) {
                    VerificationPrePresenter.this.m38591a(diCardVerifyCallback2, i - 1, j2, currentTimeMillis);
                    return;
                }
                Handler unused = VerificationPrePresenter.this.f51510d = null;
                VerificationPrePresenter verificationPrePresenter = VerificationPrePresenter.this;
                verificationPrePresenter.m38588a((Context) verificationPrePresenter.f51507a, VerificationPrePresenter.this.f51507a.getString(R.string.didi_security_card_verify_net_connerror));
                VerificationPrePresenter.this.f51507a.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38591a(DiCardVerifyCallback diCardVerifyCallback, int i, long j, long j2) {
        if (this.f51510d == null) {
            this.f51510d = new Handler(Looper.getMainLooper());
        }
        long currentTimeMillis = j - (System.currentTimeMillis() - j2);
        if (currentTimeMillis > 200) {
            final DiCardVerifyCallback diCardVerifyCallback2 = diCardVerifyCallback;
            final int i2 = i;
            final long j3 = j;
            this.f51510d.postDelayed(new Runnable() {
                public void run() {
                    VerificationPrePresenter.this.m38590a(diCardVerifyCallback2, i2, j3);
                }
            }, currentTimeMillis);
            return;
        }
        m38590a(diCardVerifyCallback, i, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38602a(String str, WithdrawPageInfo.ExtendContent extendContent, DiCardVerifyCallback diCardVerifyCallback) {
        String a = m38586a(str, this.f51509c.getCardNo());
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
        CardVerificationActivity.startActivity(this.f51507a, this.f51509c, cardVerifyInfo, diCardVerifyCallback);
        RandomPayTransActivity randomPayTransActivity = this.f51507a;
        if (randomPayTransActivity != null) {
            randomPayTransActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38588a(Context context, String str) {
        LEGOToastHelper.showShortNagToast(context, str);
    }

    /* renamed from: a */
    private String m38586a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 4) ? str : str.replaceAll("[*][*][*][*]", str2.substring(str2.length() - 4, str2.length()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38592a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
