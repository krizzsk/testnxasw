package com.didi.payment.creditcard.global.omega;

import android.content.Context;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import java.util.HashMap;

public class GlobalOmegaErrorCounter {

    /* renamed from: a */
    private static int f32862a;

    /* renamed from: b */
    private static int f32863b;

    /* renamed from: c */
    private static int f32864c;

    /* renamed from: d */
    private static int f32865d;

    /* renamed from: e */
    private static int f32866e;

    public static void addInvalidCardNoCount() {
        f32862a++;
    }

    public static void addInvalidDateCount() {
        f32863b++;
    }

    public static void addInvalidCvvCount() {
        f32864c++;
    }

    public static void addInvalidCidCount() {
        f32865d++;
    }

    public static void addInvalidBlackCardCount() {
        f32866e++;
    }

    public static void resetValue() {
        f32862a = 0;
        f32863b = 0;
        f32864c = 0;
        f32866e = 0;
    }

    public static void onSignErrorEvent(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", PayBaseParamUtil.getParam(context, "uid"));
        hashMap.put("city_id", PayBaseParamUtil.getParam(context, "trip_city_id"));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CARD_NO, Integer.valueOf(f32862a));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_VALIDATION_DATE, Integer.valueOf(f32863b));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CVV, Integer.valueOf(f32864c));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_CID, Integer.valueOf(f32865d));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.INVALID_NOT_SUPPORTED, Integer.valueOf(f32866e));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_CREDITCARD_ERROR, hashMap);
    }
}
