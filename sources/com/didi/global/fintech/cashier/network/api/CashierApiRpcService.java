package com.didi.global.fintech.cashier.network.api;

import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.CanChangeNewVersionResponse;
import com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.network.CashierInterceptor;
import com.didichuxing.foundation.gson.GsonDeserializer;
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
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H'J(\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0007H'J(\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007H'J(\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007H'J(\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00122\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u0007H'J(\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00152\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007H'J(\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00152\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007H'J(\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00182\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u0007H'J(\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u001b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\b0\u0007H'J(\u0010\u001d\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u001e2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\b0\u0007H'J(\u0010 \u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020!2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u0007H'¨\u0006#"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/network/api/CashierApiRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "agreePolicy", "", "payInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/global/fintech/cashier/model/net/response/CashierBaseResponse;", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "canChangeNewVersion", "Lcom/didi/global/fintech/cashier/model/net/request/CanChangeNewVersionRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CanChangeNewVersionResponse;", "changePayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "changePayMethodInfo", "getCVVInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "getPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "getPayMethodInfo", "getPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "getSuccessInfo", "Lcom/didi/global/fintech/cashier/model/net/request/GetSuccessInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "paymentThreeDSDetails", "Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "prepay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "cashier_network_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierApiRpcService.kt */
public interface CashierApiRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/agreePolicy")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void agreePolicy(@BodyParameter("") AgreePolicyRequest agreePolicyRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<AgreePolicyResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/control/canChangeNewVersion")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void canChangeNewVersion(@BodyParameter("") CanChangeNewVersionRequest canChangeNewVersionRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<CanChangeNewVersionResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/changePayInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void changePayInfo(@BodyParameter("") ChangePayInfoRequest changePayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PayInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/changePayMethodInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void changePayMethodInfo(@BodyParameter("") ChangePayInfoRequest changePayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PayInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/getCvvInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getCVVInfo(@BodyParameter("") GetCVVInfoRequest getCVVInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<CVVInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/getPayInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getPayInfo(@BodyParameter("") GetPayInfoRequest getPayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PayInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/getPayMethodInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getPayMethodInfo(@BodyParameter("") GetPayInfoRequest getPayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PayInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/getPayStatus")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getPayStatus(@BodyParameter("") GetPayStatusRequest getPayStatusRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PayStatusResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/getSuccessInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getSuccessInfo(@BodyParameter("") GetSuccessInfoRequest getSuccessInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<SuccessInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/paymentThreeDSDetails")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void paymentThreeDSDetails(@BodyParameter("") PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PaymentThreeDSDetailsResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/cashier/prePay")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void prepay(@BodyParameter("") PrepayRequest prepayRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<PrepayResponse>> callbackV2);
}
