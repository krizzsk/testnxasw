package com.didi.consume.base;

import android.content.Context;
import com.didi.consume.channels.model.CsTopUpChannelResp;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.consume.phone.model.CsCouponOrderBody;
import com.didi.consume.phone.model.CsCreateOrderBody;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.model.CsVoucherResponse;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.fastpay.FastPayUtils;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.constant.Const;
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
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.AdminPermission;

public class CsNetModel {
    public static final String WALLET_URL = "https://wallet.didiglobal.com/api";

    /* renamed from: b */
    private static volatile CsNetModel f18117b;

    /* renamed from: a */
    private ConsumeService f18118a;

    /* renamed from: c */
    private Context f18119c;

    @Interception({RequestMonitorInterceptor.class})
    interface ConsumeService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order/close")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object closeOrder(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsCreateOrderResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createPhoneRefillOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsCreateOrderResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/mobile/carrier/values")
        @Deserialization(GsonDeserializer.class)
        Object getAmountList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsAmountListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/mobile/home")
        @Deserialization(GsonDeserializer.class)
        Object getDefaultPhoneNumber(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsDefaultPhoneNumberResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/mobile/carriers")
        @Deserialization(GsonDeserializer.class)
        Object getOperatorList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsOperatorListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/optimal/coupon")
        @Deserialization(GsonDeserializer.class)
        Object getVoucherDiscount(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsVoucherResponse> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order/channels")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestPhoneTopUpChannels(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsTopUpChannelResp> callback);
    }

    private CsNetModel(Context context) {
        this.f18119c = context;
        this.f18118a = (ConsumeService) new RpcServiceFactory(context.getApplicationContext()).newRpcService(ConsumeService.class, "https://wallet.didiglobal.com/api");
    }

    public static CsNetModel getIns(Context context) {
        if (f18117b == null) {
            synchronized (CsNetModel.class) {
                if (f18117b == null) {
                    f18117b = new CsNetModel(context);
                }
            }
        }
        return f18117b;
    }

    /* renamed from: a */
    private Map<String, Object> m15341a() {
        return PayBaseParamUtil.getHttpBaseParams(this.f18119c);
    }

    public void createUtilitiesOrder(int i, String str, String str2, RpcService.Callback<CsCreateOrderResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        hashMap.put(AdminPermission.METADATA, str);
        hashMap.put(Const.PayParams.BIZ_CONTENT, str2);
        hashMap.put("unpaidReminder", Integer.valueOf(WalletApolloUtil.isBoletoUnpaidBillReminder() ? 1 : 0));
        this.f18118a.createOrder(m15341a(), hashMap, callback);
    }

    public void getDefaultPhoneNumber(int i, RpcService.Callback<CsDefaultPhoneNumberResp> callback) {
        Map<String, Object> a = m15341a();
        a.put("product_line", Integer.valueOf(i));
        this.f18118a.getDefaultPhoneNumber(a, callback);
    }

    public void getOperatorList(int i, String str, String str2, RpcService.Callback<CsOperatorListResp> callback) {
        Map<String, Object> a = m15341a();
        a.put("product_line", Integer.valueOf(i));
        a.put("phone_country_code", str);
        a.put("phone_number", str2);
        this.f18118a.getOperatorList(a, callback);
    }

    public void getAmountList(int i, String str, String str2, String str3, String str4, RpcService.Callback<CsAmountListResp> callback) {
        Map<String, Object> a = m15341a();
        a.put("product_line", Integer.valueOf(i));
        a.put("phone_country_code", str);
        a.put("phone_number", str2);
        a.put("operator_id", str3);
        a.put("extMetadata", str4);
        this.f18118a.getAmountList(a, callback);
    }

    public void getVoucherDiscount(int i, String str, RpcService.Callback<CsVoucherResponse> callback) {
        Map<String, Object> a = m15341a();
        a.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        a.put("amount", str);
        this.f18118a.getVoucherDiscount(a, callback);
    }

    public void requestPhoneTopUpChannel(RpcService.Callback<CsTopUpChannelResp> callback) {
        this.f18118a.requestPhoneTopUpChannels(m15341a(), callback);
    }

    public void createPhoneRefillOrder(int i, String str, CsCreateOrderBody csCreateOrderBody, CsCouponOrderBody csCouponOrderBody, RpcService.Callback<CsCreateOrderResp> callback) {
        Map<String, Object> a = m15341a();
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        hashMap.put(AdminPermission.METADATA, str);
        hashMap.put(Const.PayParams.BIZ_CONTENT, new Gson().toJson((Object) csCreateOrderBody));
        if (csCouponOrderBody.hasCoupons) {
            hashMap.put("couponData", new Gson().toJson((Object) csCouponOrderBody));
        }
        if (csCreateOrderBody.orderType >= 0) {
            hashMap.put("orderType", Integer.valueOf(csCreateOrderBody.orderType));
        }
        if (!TextUtil.isEmpty(csCreateOrderBody.extraData)) {
            hashMap.put("extMetadata", csCreateOrderBody.extraData);
        }
        hashMap.put("useFastPay", csCreateOrderBody.useFastPay);
        hashMap.put("thirdParty", FastPayUtils.INSTANCE.getThreeParty());
        hashMap.put("thirdPartyAbility", FastPayUtils.INSTANCE.getThreePartyAbility());
        this.f18118a.createPhoneRefillOrder(a, hashMap, callback);
    }

    public void closeOrder(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Map<String, Object> a = m15341a();
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f18118a.closeOrder(a, callback);
    }
}
