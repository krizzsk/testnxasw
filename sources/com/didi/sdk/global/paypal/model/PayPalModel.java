package com.didi.sdk.global.paypal.model;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.fastframe.entity.RpcBase;
import com.didi.sdk.global.constant.GlobalServer;
import com.didi.sdk.global.paypal.model.bean.PayPalSignCancelResult;
import com.didi.sdk.global.paypal.model.bean.PayPalSignResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.Gson;
import java.util.HashMap;

public class PayPalModel {

    /* renamed from: a */
    private Context f38970a;

    /* renamed from: b */
    private PayPalService f38971b;

    public PayPalModel(Context context) {
        this.f38970a = context;
        GlobalServer.initUrl();
        this.f38971b = (PayPalService) new RpcServiceFactory(context).newRpcService(PayPalService.class, GlobalServer.GLOBAL_HOST);
    }

    /* renamed from: a */
    private HashMap<String, Object> m29303a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void requestPayPalSignInfo(RpcService.Callback<PayPalSignResult> callback) {
        HashMap<String, Object> a = m29303a(this.f38970a);
        a.put("bind_type", 1);
        a.put("channel_id", 152);
        this.f38971b.requestPaypalSignInfo(a, callback);
    }

    public void cancelSign(int i, RpcService.Callback<PayPalSignCancelResult> callback) {
        HashMap<String, Object> a = m29303a(this.f38970a);
        a.put("channel_id", Integer.valueOf(i));
        this.f38971b.cancelSign(a, callback);
    }

    public void verifyPayPal(String str, RpcService.Callback<RpcBase> callback) {
        HashMap<String, Object> a = m29303a(this.f38970a);
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put("channelId", 152);
        a.put("params", new Gson().toJson((Object) hashMap));
        this.f38971b.verifyPaypal(a, callback);
    }
}
