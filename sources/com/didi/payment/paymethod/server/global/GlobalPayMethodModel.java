package com.didi.payment.paymethod.server.global;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.paymethod.server.global.request.BalanceQueryReq;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.request.SignReq;
import com.didi.payment.paymethod.server.global.response.BalanceQueryResp;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.server.global.response.SignResultResp;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;

public class GlobalPayMethodModel implements IGlobalPayMethodModel {

    /* renamed from: a */
    private static final String f33500a = "channel_id";

    /* renamed from: b */
    private static final String f33501b = "bind_type";

    /* renamed from: c */
    private static final String f33502c = "polling_times";

    /* renamed from: d */
    private static final String f33503d = "https://pay.didiglobal.com";

    /* renamed from: e */
    private Context f33504e;

    /* renamed from: f */
    private GlobalRpcService f33505f;

    public GlobalPayMethodModel(Context context) {
        this.f33504e = context;
        this.f33505f = (GlobalRpcService) new RpcServiceFactory(context).newRpcService(GlobalRpcService.class, "https://pay.didiglobal.com");
    }

    /* renamed from: a */
    private HashMap<String, Object> m25423a() {
        return PayBaseParamUtil.getHttpBaseParams(this.f33504e);
    }

    public void sign(SignReq signReq, RpcService.Callback<SignResultResp> callback) {
        if (signReq != null && callback != null) {
            HashMap<String, Object> a = m25423a();
            a.put("bind_type", Integer.valueOf(signReq.bindType));
            a.put("channel_id", Integer.valueOf(signReq.channelId));
            this.f33505f.sign(a, callback);
        }
    }

    public void cancelSign(SignCancelReq signCancelReq, RpcService.Callback<SignCancelResp> callback) {
        if (signCancelReq != null && callback != null) {
            HashMap<String, Object> a = m25423a();
            a.put("channel_id", Integer.valueOf(signCancelReq.channelId));
            this.f33505f.cancelSign(a, callback);
        }
    }

    public void pollSignStatus(SignPollingQueryReq signPollingQueryReq, RpcService.Callback<SignPollingQueryResp> callback) {
        if (signPollingQueryReq != null && callback != null) {
            HashMap<String, Object> a = m25423a();
            a.put("channel_id", Integer.valueOf(signPollingQueryReq.channelId));
            a.put("polling_times", Integer.valueOf(signPollingQueryReq.pollingTimes));
            this.f33505f.pollSignStatus(a, callback);
        }
    }

    public void queryBalance(BalanceQueryReq balanceQueryReq, RpcService.Callback<BalanceQueryResp> callback) {
        if (balanceQueryReq != null && callback != null) {
            HashMap<String, Object> a = m25423a();
            a.put("channel_id", Integer.valueOf(balanceQueryReq.channelId));
            this.f33505f.queryBalance(a, callback);
        }
    }
}
