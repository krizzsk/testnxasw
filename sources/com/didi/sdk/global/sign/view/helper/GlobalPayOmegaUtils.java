package com.didi.sdk.global.sign.view.helper;

import android.content.Context;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.paymethod.omega.GlobalOmegaConstant;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.util.GlobalOmegaConstant;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import java.util.HashMap;

public class GlobalPayOmegaUtils {
    public static void trackPayMethodSelectPIXCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", m29447a(context));
        hashMap.put("payment_method", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("ibt_gp_changepaymentmethod_pix_ck", hashMap);
    }

    public static void trackPayMethodSelectPaypayCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_paypay_ck", hashMap);
    }

    public static void trackPayMethodSelectPaypalV2CK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("gp_payment_paypalv2_ck", hashMap);
    }

    public static void trackPayMethodSettingPageSW(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("payment", "");
        FinOmegaSDK.trackEvent("global_pas_payment_sw", hashMap);
    }

    public static void trackPayMethodSettingPageCloseCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent("global_pas_payment_methods_close_ck", hashMap);
    }

    public static void trackPayMethodSettingPageCashCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_cash_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePosCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_pos_ck", hashMap);
    }

    public static void trackPayMethodSettingPageCreditCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_credit_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePaypalCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_paypal_ck", hashMap);
    }

    public static void trackPayMethodSettingPageDiscountsCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_methods_discounts_ck", hashMap);
    }

    public static void trackPayMethodSettingPageBalanceCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("gp_wallet_balance_ck", hashMap);
    }

    public static void trackPayMethodSelectPageSW(Context context, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("payment", str);
        FinOmegaSDK.trackEvent("global_pas_payment_sw", hashMap);
    }

    public static void trackPayMethodSelectPageReturnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent("global_pas_payment_return_ck", hashMap);
    }

    public static void trackPayMethodSelectPageCashCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_cash_ck", hashMap);
    }

    public static void trackPayMethodSelectPagePosCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_pos_ck", hashMap);
    }

    public static void trackPayMethodSelectPageCreditCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_credit_ck", hashMap);
    }

    public static void trackPayMethodSelectPagePaypalCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_paypal_ck", hashMap);
    }

    public static void trackPayMethodSelectPageEnterpriseCK(Context context, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("card_count", Integer.valueOf(i3));
        FinOmegaSDK.trackEvent("global_pas_payment_enterprise_ck", hashMap);
    }

    public static void trackPayMethodSelectPageBalanceSwitched(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", 1);
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSelectPage.EventId.GP_PAYMENT_BALANCE_CK, hashMap);
    }

    public static void trackPayMethodSelectPageSwitchPayMethod(Context context, DidiGlobalPayMethodListData.Entrance entrance) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(m29446a(entrance)));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSelectPage.EventId.GLOBAL_PAS_PAYMENT_SWITCH_PAYMETHOD, hashMap);
    }

    public static void trackPayMethodSelectPageSwitchBankCard(Context context, DidiGlobalPayMethodListData.Entrance entrance) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(m29446a(entrance)));
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSelectPage.EventId.GLOBAL_PAS_PAYMENT_SWITCH_BANKCARD, hashMap);
    }

    public static void trackPayPalDetailPageSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayPalDetailPage.EventId.GLOBAL_PAS_PAYPAL_SW, hashMap);
    }

    public static void trackPayPalDetailPageReturnCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayPalDetailPage.EventId.GLOBAL_PAS_PAYPAL_RETURN_CK, hashMap);
    }

    public static void trackPayPalDetailPageRemoveCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayPalDetailPage.EventId.GLOBAL_PAS_PAYPAL_REMOVE_CK, hashMap);
    }

    public static void trackPayPalDetailPageRemoveCancelCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayPalDetailPage.EventId.GLOBAL_PAS_PAYPAL_REMOVE_CANCEL_CK, hashMap);
    }

    public static void trackPayPalDetailPageRemoveOkCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayPalDetailPage.EventId.GLOBAL_PAS_PAYPAL_REMOVE_OK_CK, hashMap);
    }

    public static void trackEnterpriseAddCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put(GlobalOmegaConstant.EnterprisePage.EventKey.PAYMENT_MOTHOD, "corporate voucher");
        hashMap.put("country_code", "BR");
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_PAYMENT_ADD_CORPORATE_CK, hashMap);
    }

    public static void trackEnterpriseEditCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        hashMap.put(GlobalOmegaConstant.EnterprisePage.EventKey.PAYMENT_MOTHOD, "corporate voucher");
        hashMap.put("country_code", "BR");
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_PAYMENT_EDIT_CORPORATE_CK, hashMap);
    }

    public static void trackEnterpriseCompanyBtnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COMPANY_BTN_CK, hashMap);
    }

    public static void trackEnterpriseCostcenterBtnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COSTCENTER_BTN_CK, hashMap);
    }

    public static void trackEnterpriseProjectBtnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_PROJECT_BTN_CK, hashMap);
    }

    public static void trackEnterpriseContinueBtnCK(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        hashMap.put("source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_CONTINUE_BTN_CK, hashMap);
    }

    public static void trackEnterpriseCompanyListSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COMPANY_SW, hashMap);
    }

    public static void trackEnterpriseCompanyListBackCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COMPANY_RETURN_CK, hashMap);
    }

    public static void trackEnterpriseCostcenterListSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COSTCENTER_SW, hashMap);
    }

    public static void trackEnterpriseCostcenterListBackCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_COSTCENTER_RETURN_CK, hashMap);
    }

    public static void trackEnterpriseProjectListSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_PROJECT_SW, hashMap);
    }

    public static void trackEnterpriseProjectListBackCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.EnterprisePage.EventId.GP_CORPORATE_PROJECT_RETURN_CK, hashMap);
    }

    public static void trackBalanceDetailPageSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.GlobalBalanceDetailPage.EventId.GLOBAL_PAS_BALANCE_SW, hashMap);
    }

    public static void trackBalanceDetailPageTopUpCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent("gp_balance_topup_ck", hashMap);
    }

    public static void trackBalanceDetailTransDetailCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m29447a(context));
        hashMap.put("city_id", m29448b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.GlobalBalanceDetailPage.EventId.GLOBAL_PAS_BALANCE_DETAIL_CK, hashMap);
    }

    public static void trackPayMethodBindPaypalV2Success() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodPayPalPage.EventId.GP_ADD_PAYPALV2_SUCESS);
    }

    /* renamed from: com.didi.sdk.global.sign.view.helper.GlobalPayOmegaUtils$1 */
    static /* synthetic */ class C131371 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f39115x8a3a0836;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance[] r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39115x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f39115x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f39115x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f39115x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f39115x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_BIKE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.view.helper.GlobalPayOmegaUtils.C131371.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static int m29446a(DidiGlobalPayMethodListData.Entrance entrance) {
        int i = C131371.f39115x8a3a0836[entrance.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i != 4) {
                return i != 5 ? 1 : 5;
            }
            return 2;
        }
    }

    /* renamed from: a */
    private static String m29447a(Context context) {
        return context == null ? "" : PayCommonParamsUtil.getInstance().getUid(context);
    }

    /* renamed from: b */
    private static String m29448b(Context context) {
        HashMap<String, Object> commonParam;
        if (context == null || (commonParam = PayCommonParamsUtil.getInstance().getCommonParam(context)) == null) {
            return "";
        }
        return String.valueOf(commonParam.get("location_cityid"));
    }
}
