package com.didichuxing.security.cardverify;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.security.cardverify.activity.CardVerificationActivity;
import com.didichuxing.security.cardverify.globalpay.presenter.GlobalPayRequestPay24Status;
import com.didichuxing.security.cardverify.presenter.RequestPay24Status;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;

public class DiCardVerify {

    /* renamed from: a */
    private String f51420a;

    /* renamed from: b */
    private String f51421b;

    /* renamed from: c */
    private String f51422c;

    /* renamed from: d */
    private String f51423d;

    /* renamed from: e */
    private String f51424e;

    /* renamed from: f */
    private String f51425f;

    /* renamed from: g */
    private String f51426g;

    /* renamed from: h */
    private String f51427h;

    public static void randomPayVerify(Context context, DiCardVerifyParam diCardVerifyParam, DiCardVerifyCallback diCardVerifyCallback) {
        if (context == null) {
            throw new NullPointerException("context is null");
        } else if (diCardVerifyParam != null) {
            DiCardVerifyTracker.trackEnterSdk();
            RequestPay24Status.requestWithdrawInfo(context, diCardVerifyParam, diCardVerifyCallback);
        } else {
            throw new NullPointerException("param is null");
        }
    }

    public static void notifyCardRemoved() {
        DiCardVerifyTracker.trackRemoveSucceed();
        CardVerificationActivity.onCardRemoved();
    }

    public static void notifyRemoveCardFail(String str) {
        DiCardVerifyTracker.trackRemoveFailed();
        CardVerificationActivity.onRemoveCardFail(str);
    }

    public static void globalPayRandomPayVerify(Context context, DiCardVerifyParam diCardVerifyParam, DiCardVerifyCallback diCardVerifyCallback) {
        if (context == null) {
            throw new NullPointerException("context is null");
        } else if (diCardVerifyParam == null) {
            throw new NullPointerException("param is null");
        } else if (!TextUtils.isEmpty(diCardVerifyParam.getUid()) && !TextUtils.isEmpty(diCardVerifyParam.getCardIndex()) && !TextUtils.isEmpty(diCardVerifyParam.getCountry()) && !TextUtils.isEmpty(diCardVerifyParam.getLanguage()) && !TextUtils.isEmpty(diCardVerifyParam.getToken()) && !TextUtils.isEmpty(diCardVerifyParam.getTerminalId()) && !TextUtils.isEmpty(diCardVerifyParam.getProductId()) && !TextUtils.isEmpty(diCardVerifyParam.getCardNo())) {
            DiCardVerifyTracker.trackEnterSdk();
            GlobalPayRequestPay24Status.requestWithdrawInfo(context, diCardVerifyParam, diCardVerifyCallback);
        } else if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(4, "invalid param");
        }
    }
}
