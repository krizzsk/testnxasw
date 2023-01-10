package com.didichuxing.security.cardverify.model;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.constant.Server;
import com.didichuxing.security.cardverify.model.bean.WithdrawPollResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawVerifyResult;
import com.didichuxing.security.cardverify.utils.ParamUtils;
import java.util.HashMap;

public class CardModel {

    /* renamed from: a */
    private Context f51504a;

    /* renamed from: b */
    private CardSecService f51505b;

    /* renamed from: c */
    private DiCardVerifyParam f51506c;

    public CardModel(Context context, DiCardVerifyParam diCardVerifyParam) {
        this.f51504a = context;
        this.f51506c = diCardVerifyParam;
        this.f51505b = (CardSecService) new RpcServiceFactory(context).newRpcService(CardSecService.class, Server.GLOBAL_SEC_HOST);
    }

    public void doWithdraw(RpcService.Callback<WithdrawResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f51506c, hashMap);
        this.f51505b.doWithdraw(hashMap, callback);
    }

    public void pollingQueryWithdrawStatus(RpcService.Callback<WithdrawPollResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f51506c, hashMap);
        this.f51505b.pollingQueryWithdrawStatus(hashMap, callback);
    }

    public void verifyWithdraw(String str, String str2, RpcService.Callback<WithdrawVerifyResult> callback) {
        HashMap hashMap = new HashMap();
        ParamUtils.addCommonParam(this.f51506c, hashMap);
        hashMap.put("amountString", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("phone", str2);
        }
        this.f51505b.verifyWithdraw(hashMap, callback);
    }
}
