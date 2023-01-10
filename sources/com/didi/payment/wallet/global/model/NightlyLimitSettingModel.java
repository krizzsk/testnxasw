package com.didi.payment.wallet.global.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.model.resp.BaseResponse;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
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

public class NightlyLimitSettingModel {

    /* renamed from: a */
    private final Context f34279a;

    /* renamed from: b */
    private final NightlyLimitSettingService f34280b;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface NightlyLimitSettingService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/night/limit/getRemaining")
        @Deserialization(GsonDeserializer.class)
        void getNightlyLimit(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<GetNightlyLimitResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/night/limit/")
        @Deserialization(GsonDeserializer.class)
        void getNightlyLimitSetting(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<QueryNightlyLimitSettingResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/risk/limit")
        @Deserialization(GsonDeserializer.class)
        void getRiskLimit(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseResponse<LimitRiskReminderVo>> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/night/limit/set")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void setNightlyLimit(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<QueryNightlyLimitSettingResp> callback);
    }

    public NightlyLimitSettingModel(Context context) {
        this.f34279a = context.getApplicationContext();
        this.f34280b = (NightlyLimitSettingService) new RpcServiceFactory(context).newRpcService(NightlyLimitSettingService.class, "https://wallet.didiglobal.com");
    }

    public void setNightlyLimit(long j, long j2, RpcService.Callback<QueryNightlyLimitSettingResp> callback) {
        HashMap<String, Object> a = m26191a(this.f34279a);
        HashMap hashMap = new HashMap();
        hashMap.put("oldLimit", Long.valueOf(j));
        hashMap.put("newLimit", Long.valueOf(j2));
        this.f34280b.setNightlyLimit(a, hashMap, callback);
    }

    public void getNightlyLimit(int i, RpcService.Callback<GetNightlyLimitResp> callback) {
        HashMap<String, Object> a = m26191a(this.f34279a);
        a.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        this.f34280b.getNightlyLimit(a, callback);
    }

    public void getNightlyLimitSetting(RpcService.Callback<QueryNightlyLimitSettingResp> callback) {
        this.f34280b.getNightlyLimitSetting(m26191a(this.f34279a), callback);
    }

    public void getRiskLimit(int i, RpcService.Callback<BaseResponse<LimitRiskReminderVo>> callback) {
        HashMap<String, Object> a = m26191a(this.f34279a);
        a.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        this.f34280b.getRiskLimit(a, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m26191a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
