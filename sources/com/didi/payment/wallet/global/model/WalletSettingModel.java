package com.didi.payment.wallet.global.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.model.resp.WalletSettingsResp;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
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

public class WalletSettingModel {

    /* renamed from: a */
    private final Context f34288a;

    /* renamed from: b */
    private final WalletSettingService f34289b;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletSettingService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/setting/list")
        @Deserialization(GsonDeserializer.class)
        void getSettingItems(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletSettingsResp> callback);
    }

    public WalletSettingModel(Context context) {
        this.f34288a = context.getApplicationContext();
        this.f34289b = (WalletSettingService) new RpcServiceFactory(context).newRpcService(WalletSettingService.class, "https://wallet.didiglobal.com");
    }

    /* renamed from: a */
    private HashMap<String, Object> m26194a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void getSettingItems(RpcService.Callback<WalletSettingsResp> callback) {
        this.f34289b.getSettingItems(m26194a(this.f34288a), callback);
    }
}
