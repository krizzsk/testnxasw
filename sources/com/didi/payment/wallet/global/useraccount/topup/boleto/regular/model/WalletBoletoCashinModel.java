package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.Map;

public class WalletBoletoCashinModel {

    /* renamed from: a */
    private static final String f34469a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private WalletBoletoCashinRpcService f34470b;

    /* renamed from: c */
    private Context f34471c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletBoletoCashinRpcService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/boleto")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object requestTopupBoleto(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBoletoCashinResp> callback);
    }

    public WalletBoletoCashinModel(Context context) {
        this.f34471c = context;
        this.f34470b = (WalletBoletoCashinRpcService) new RpcServiceFactory(context).newRpcService(WalletBoletoCashinRpcService.class, "https://wallet.didiglobal.com");
    }

    public void submitBoleto(Long l, RpcService.Callback<WalletBoletoCashinResp> callback) {
        HashMap<String, Object> a = m26282a(this.f34471c);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", l);
        hashMap.put("displayText", "text");
        hashMap.put("currency", "BRL");
        this.f34470b.requestTopupBoleto(a, hashMap, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m26282a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
