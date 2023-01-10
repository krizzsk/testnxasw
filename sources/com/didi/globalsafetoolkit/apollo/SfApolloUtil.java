package com.didi.globalsafetoolkit.apollo;

import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class SfApolloUtil {

    /* renamed from: a */
    private static Boolean f24891a;

    public static boolean isNewCallPoliceUI() {
        return ((Integer) getParam("PAX_EMERGENCY", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isApolloNewShare() {
        return ((Integer) getParam("ab_rider_safety_toolkit_share_via_social", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isAreaCode4StockShow() {
        return getStatus("global_safetoolkit_area_code_4_stock_show", false);
    }

    public static boolean isAddContactOpt() {
        return getStatus("trusted_contact_passenger", false);
    }

    public static boolean isNewSafe() {
        if (f24891a == null) {
            f24891a = Boolean.valueOf(getStatus("Global_safety_shield_new", false));
        }
        return f24891a.booleanValue();
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            e.printStackTrace();
            return t;
        }
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static boolean isNewSyncContactInterface() {
        return getStatus("passenger_contacts_encryption_toggle", false);
    }
}
