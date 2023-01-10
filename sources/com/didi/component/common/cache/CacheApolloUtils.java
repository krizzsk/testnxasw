package com.didi.component.common.cache;

import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalApolloUtil;

public class CacheApolloUtils extends GlobalApolloUtil {

    /* renamed from: a */
    private static final String f13314a = "brazil_app_call_experience_imporve";

    /* renamed from: b */
    private static final String f13315b = "pre_rec";

    /* renamed from: c */
    private static final String f13316c = "pre_eta";

    /* renamed from: d */
    private static final String f13317d = "pre_poi";

    /* renamed from: e */
    private static final String f13318e = "post_send";

    /* renamed from: f */
    private static int f13319f = -1;

    /* renamed from: g */
    private static int f13320g = -1;

    public static boolean openConfirmEtaCache() {
        String str = f13314a + f13316c;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f13314a, f13316c, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openRecCache() {
        String str = f13314a + f13315b;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f13314a, f13315b, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openPOICache() {
        String str = f13314a + f13317d;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f13314a, f13317d, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openPostSend() {
        String str = f13314a + f13318e;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f13314a, f13318e, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openWaitRspOptimization() {
        return !FormStore.getInstance().isFromOpenRide();
    }

    public static int isNewCPFBlockingOpen() {
        return f13319f;
    }

    public static void setNewCPUBlockingOpen(int i) {
        f13319f = i;
    }

    public static int getCPFBlockingTypeV2() {
        return f13320g;
    }

    public static boolean isCPFBlockingTypeV2OpenOnHome() {
        return getCPFBlockingTypeV2() >= 2;
    }

    public static boolean isCPFBlockingTypeV2OpenOnRegist() {
        return getCPFBlockingTypeV2() == 1 || getCPFBlockingTypeV2() == 3;
    }

    public static void setCPFBlockingTypeV2(int i) {
        f13320g = i;
    }
}
