package com.didiglobal.pay.paysecure.net;

import android.os.Build;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.PaySecureNetParamListener;
import com.didiglobal.pay.paysecure.net.pojo.response.GateKeeperResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.SetPwdResponse;
import com.didiglobal.pay.paysecure.net.pojo.response.VerifyPwdResponse;
import com.didiglobal.pay.paysecure.prepaidcard.resp.VerifyCardNoResp;
import com.didiglobal.pay.paysecure.util.DeviceUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\bJJ\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f0\u000bJ2\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\f0\u000bJL\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/net/PaySecureRequest;", "", "()V", "service", "Lcom/didiglobal/pay/paysecure/net/PaySecureNet;", "gatekeeper", "", "scene", "", "paySessionId", "gatekeeperCallback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/GateKeeperResponse;", "getBaseParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "preloadVendor", "lnSessionId", "errMsg", "setPwd", "encryptKey", "keyId", "password", "userVerificationParams", "Lcom/google/gson/JsonObject;", "iv", "setPwdCallback", "Lcom/didiglobal/pay/paysecure/net/pojo/response/SetPwdResponse;", "verifyCardNo", "cardId", "type", "verifyContent", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "verifyPwd", "verifyPwdCallback", "Lcom/didiglobal/pay/paysecure/net/pojo/response/VerifyPwdResponse;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureRequest.kt */
public final class PaySecureRequest {
    public static final PaySecureRequest INSTANCE = new PaySecureRequest();

    /* renamed from: a */
    private static final PaySecureNet f52832a;

    static {
        RpcService newRpcService = new RpcServiceFactory(PaySecure.INSTANCE.getAppContext()).newRpcService(PaySecureNet.class, PaySecureUrl.INSTANCE.getUrl());
        Intrinsics.checkExpressionValueIsNotNull(newRpcService, "RpcServiceFactory(PaySec…ySecureUrl.getUrl()\n    )");
        f52832a = (PaySecureNet) newRpcService;
    }

    private PaySecureRequest() {
    }

    public final void gatekeeper(String str, String str2, RpcService.Callback<PaySecureResponse<GateKeeperResponse>> callback) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(callback, "gatekeeperCallback");
        Map baseParams = getBaseParams(str);
        baseParams.put("pay_session_id", str2);
        f52832a.gatekeeper(baseParams, callback);
    }

    public final void setPwd(String str, String str2, String str3, String str4, JsonObject jsonObject, String str5, RpcService.Callback<PaySecureResponse<SetPwdResponse>> callback) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(str2, "encryptKey");
        Intrinsics.checkParameterIsNotNull(str3, "keyId");
        Intrinsics.checkParameterIsNotNull(str4, CashierAction.ACTION_PASSWORD);
        Intrinsics.checkParameterIsNotNull(jsonObject, "userVerificationParams");
        Intrinsics.checkParameterIsNotNull(str5, "iv");
        Intrinsics.checkParameterIsNotNull(callback, "setPwdCallback");
        Map baseParams = getBaseParams(str);
        baseParams.put("type", "DIGIT_PWD");
        baseParams.put("keyboard_type", "DIGIT");
        baseParams.put(ServerParam.PARAM_DEVICE_NO, DeviceUtils.INSTANCE.getDeviceId(PaySecure.INSTANCE.getAppContext()));
        baseParams.put("length", 4);
        baseParams.put(AudioUploader.REQ_PARAMS.ENCRYPT_KEY, str2);
        baseParams.put("key_id", str3);
        baseParams.put(CashierAction.ACTION_PASSWORD, str4);
        baseParams.put("user_verification_params", jsonObject);
        baseParams.put("iv", str5);
        f52832a.setPwd(baseParams, callback);
    }

    public final void verifyPwd(String str, String str2, String str3, String str4, String str5, String str6, RpcService.Callback<PaySecureResponse<VerifyPwdResponse>> callback) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(str2, "encryptKey");
        Intrinsics.checkParameterIsNotNull(str3, "keyId");
        Intrinsics.checkParameterIsNotNull(str4, CashierAction.ACTION_PASSWORD);
        Intrinsics.checkParameterIsNotNull(str6, "iv");
        Intrinsics.checkParameterIsNotNull(callback, "verifyPwdCallback");
        Map baseParams = getBaseParams(str);
        baseParams.put("type", "DIGIT_PWD");
        baseParams.put("keyboard_type", "DIGIT");
        baseParams.put(ServerParam.PARAM_DEVICE_NO, DeviceUtils.INSTANCE.getDeviceId(PaySecure.INSTANCE.getAppContext()));
        baseParams.put(AudioUploader.REQ_PARAMS.ENCRYPT_KEY, str2);
        baseParams.put("key_id", str3);
        baseParams.put(CashierAction.ACTION_PASSWORD, str4);
        if (!TextUtils.isEmpty(str5)) {
            baseParams.put("pay_session_id", str5);
        }
        baseParams.put("iv", str6);
        f52832a.verifyPwd(baseParams, callback);
    }

    public final void verifyCardNo(String str, String str2, String str3, RpcService.Callback<PaySecureResponse<VerifyCardNoResp>> callback) {
        Intrinsics.checkParameterIsNotNull(str, "cardId");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(str3, "verifyContent");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cardId", str);
        linkedHashMap.put("type", str2);
        linkedHashMap.put("verifyContent", str3);
        f52832a.verifyCardNo(linkedHashMap, callback);
    }

    public final void preloadVendor(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, DMWebSocketListener.KEY_ERR_MSG);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("countryCode", PaySecure.INSTANCE.getConfig().getNetParamListener().getCountry());
        linkedHashMap.put("vendor", "tmx");
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("lnSessionId", str);
        linkedHashMap.put("agentType", "Andriod");
        linkedHashMap.put(DMWebSocketListener.KEY_ERR_MSG, str2);
        f52832a.preloadVendor(linkedHashMap, new PaySecureRequest$preloadVendor$1());
    }

    public final HashMap<String, Object> getBaseParams(String str) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        HashMap<String, Object> hashMap = new HashMap<>();
        PaySecureNetParamListener netParamListener = PaySecure.INSTANCE.getConfig().getNetParamListener();
        Map map = hashMap;
        map.put("scene", str);
        String token = netParamListener.getToken();
        if (token == null) {
            Intrinsics.throwNpe();
        }
        map.put("passport_token", token);
        map.put("terminal_id", PaySecure.INSTANCE.getConfig().getTerminalId());
        map.put("app_version", SystemUtil.getVersionName(PaySecure.INSTANCE.getAppContext()));
        map.put("partner_id", "");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("suuid", SecurityUtil.getUUID());
        jsonObject.addProperty("appid", PaySecure.INSTANCE.getConfig().getAppId());
        jsonObject.addProperty("os", "android");
        jsonObject.addProperty("model", Build.MODEL);
        jsonObject.addProperty("lat", (Number) Double.valueOf(PaySecure.INSTANCE.getConfig().getNetParamListener().getLat()));
        jsonObject.addProperty("lng", (Number) Double.valueOf(PaySecure.INSTANCE.getConfig().getNetParamListener().getLng()));
        map.put("risk_info", jsonObject);
        return hashMap;
    }
}
