package com.didi.global.fintech.cashier.user.p119ut;

import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rJ$\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J1\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/ut/CashierUT;", "", "()V", "EVENT_ID_API_NET_ERR_EN", "", "EVENT_ID_GET_PAY_STATUS_RET_EN", "EVENT_ID_SDK_1_EN", "EVENT_ID_SDK_2_EN", "EVENT_ID_SDK_ALL_EN", "trackEvent", "", "eventId", "attrs", "", "trackMerchantsEn", "fromType", "productId", "outTradeId", "trackNetError", "apiName", "errCode", "", "errMsg", "failType", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "trackPayStatusApiResultEn", "payStatus", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.user.ut.CashierUT */
/* compiled from: CashierUT.kt */
public final class CashierUT {
    public static final String EVENT_ID_SDK_1_EN = "ibgfintech_didipay_sdk_1_en";
    public static final String EVENT_ID_SDK_2_EN = "ibgfintech_didipay_sdk_en";
    public static final String EVENT_ID_SDK_ALL_EN = "ibgfintech_didipay_sdk_all_en";
    public static final CashierUT INSTANCE = new CashierUT();

    /* renamed from: a */
    private static final String f23943a = "ibgfintech_didipay_api_err_en";

    /* renamed from: b */
    private static final String f23944b = "ibgfintech_didipay_getpaystatus_ret_en";

    private CashierUT() {
    }

    public final void trackMerchantsEn(String str, String str2, String str3) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CashierParam.PARAM_FROM_TYPE, str);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("product_id", str2);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("out_trade_id", str3);
        OmegaSDKAdapter.trackEvent("ibgfintech_didipay_sdk_merchants_en", (Map<String, Object>) linkedHashMap);
    }

    public static /* synthetic */ void trackEvent$default(CashierUT cashierUT, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        cashierUT.trackEvent(str, map);
    }

    public final void trackEvent(String str, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        CashierOmegaSDK.INSTANCE.trackEvent(str, map);
    }

    public static /* synthetic */ void trackNetError$default(CashierUT cashierUT, String str, Integer num, String str2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        cashierUT.trackNetError(str, num, str2, i);
    }

    public final void trackNetError(String str, Integer num, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "apiName");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("api_name", str);
        if (num == null) {
            num = "";
        }
        linkedHashMap.put("error_code", num);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("error_msg", str2);
        linkedHashMap.put("failed_type", Integer.valueOf(i));
        CashierOmegaSDK.INSTANCE.trackEvent(f23943a, linkedHashMap);
    }

    public final void trackPayStatusApiResultEn(String str, Integer num, String str2) {
        Map linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("pay_status", str);
        if (num == null) {
            num = "";
        }
        linkedHashMap.put("error_code", num);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("error_msg", str2);
        CashierOmegaSDK.INSTANCE.trackEvent(f23944b, linkedHashMap);
    }
}
