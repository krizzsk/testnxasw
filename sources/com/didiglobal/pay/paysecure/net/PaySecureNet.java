package com.didiglobal.pay.paysecure.net;

import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.SetPwdResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse;
import com.didiglobal.pay.paysecure.prepaidcard.resp.VerifyCardNoResp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH'J6\u0010\f\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tH'J6\u0010\r\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\tH'J6\u0010\u000f\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\tH'J6\u0010\u0011\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\tH'¨\u0006\u0013"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/net/PaySecureNet;", "Lcom/didichuxing/foundation/rpc/RpcService;", "gatekeeper", "", "param", "", "", "", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/GateKeeperResponse;", "preloadVendor", "setPwd", "Lcom/didiglobal/pay/paysecure/net/pojo/response/SetPwdResponse;", "verifyCardNo", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "verifyPwd", "Lcom/didiglobal/pay/paysecure/net/pojo/response/VerifyPwdResponse;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
@Interception({PaySecureNetInterceptor.class})
/* compiled from: PaySecureNet.kt */
public interface PaySecureNet extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/pwdapi/gatekeeper")
    @Post(contentType = "application/json")
    @Deserialization(PaySecureGsonDeserializer.class)
    void gatekeeper(@BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<GateKeeperResponse>> callback);

    @Serialization(GsonSerializer.class)
    @Path("/risk-api/out/vendor/preload")
    @Post(contentType = "application/json")
    @Deserialization(PaySecureGsonDeserializer.class)
    void preloadVendor(@BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<Unit>> callback);

    @Serialization(GsonSerializer.class)
    @Path("/pwdapi/set")
    @Post(contentType = "application/json")
    @Deserialization(PaySecureGsonDeserializer.class)
    void setPwd(@BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<SetPwdResponse>> callback);

    @Serialization(GsonSerializer.class)
    @Path("/api/v0/card/verify")
    @Post(contentType = "application/json")
    @Deserialization(PaySecureGsonDeserializer.class)
    void verifyCardNo(@BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<VerifyCardNoResp>> callback);

    @Serialization(GsonSerializer.class)
    @Path("/pwdapi/verify/correctness")
    @Post(contentType = "application/json")
    @Deserialization(PaySecureGsonDeserializer.class)
    void verifyPwd(@BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<VerifyPwdResponse>> callback);
}
