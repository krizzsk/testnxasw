package com.didi.payment.wallet.global.model;

import android.content.Context;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInfoResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOptionResp;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WalletBalanceModel {

    /* renamed from: a */
    private static final String f34281a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private WalletBalanceRpcService f34282b;

    /* renamed from: c */
    private Context f34283c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletBalanceRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/cashBack/info")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceCashbackInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceInterestResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/statements")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceHistoryInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceHistoryResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/balance/info")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceInfoResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/interest/query")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceInterestInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceInterestResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v1/statements/options")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceOptions(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceOptionResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v1/statements/list")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object getBalanceStatements(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBalanceHistoryResp> callback);
    }

    public WalletBalanceModel(Context context) {
        this.f34283c = context;
        this.f34282b = (WalletBalanceRpcService) new RpcServiceFactory(context).newRpcService(WalletBalanceRpcService.class, "https://wallet.didiglobal.com");
    }

    public void getBalanceInfo(RpcService.Callback<WalletBalanceInfoResp> callback) {
        this.f34282b.getBalanceInfo(m26192a(this.f34283c), callback);
    }

    public void getBalanceHistoryInfo(long j, int i, RpcService.Callback<WalletBalanceHistoryResp> callback) {
        HashMap<String, Object> a = m26192a(this.f34283c);
        a.put("start_index", Long.valueOf(j));
        a.put("page_size", 10);
        a.put("channel_id", Integer.valueOf(i));
        this.f34282b.getBalanceHistoryInfo(a, callback);
    }

    public void getBalanceStatements(int i, long j, int i2, RpcService.Callback<WalletBalanceHistoryResp> callback) {
        HashMap<String, Object> a = m26192a(this.f34283c);
        a.put("startIndex", Integer.valueOf(i));
        a.put("page_size", 10);
        if (j > 0) {
            a.put("endTs", Long.valueOf(j));
        }
        if (i2 >= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            a.put("types", arrayList);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", WalletCommonParamsUtil.getToken(ApplicationContextProvider.Companion.getContext()));
        this.f34282b.getBalanceStatements(hashMap, a, callback);
    }

    public void getBalanceOptions(RpcService.Callback<WalletBalanceOptionResp> callback) {
        this.f34282b.getBalanceOptions(m26192a(this.f34283c), callback);
    }

    public void getBalanceInterestInfo(RpcService.Callback<WalletBalanceInterestResp> callback) {
        this.f34282b.getBalanceInterestInfo(m26192a(this.f34283c), callback);
    }

    public void getBalanceCashbackInfo(RpcService.Callback<WalletBalanceInterestResp> callback) {
        this.f34282b.getBalanceCashbackInfo(m26192a(this.f34283c), callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m26192a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
