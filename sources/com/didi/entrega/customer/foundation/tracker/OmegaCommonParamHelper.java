package com.didi.entrega.customer.foundation.tracker;

import com.didi.entrega.customer.foundation.tracker.param.GlobalParam;
import java.util.Map;

public final class OmegaCommonParamHelper {

    /* renamed from: a */
    private static GlobalParam f21891a = new GlobalParam();

    private OmegaCommonParamHelper() {
    }

    public static void setExternalGlobalParam(GlobalParam.ExternalGlobalParam externalGlobalParam) {
        f21891a.setExternalGlobalParam(externalGlobalParam);
    }

    public static String getActivityId() {
        return f21891a.getActivityId();
    }

    public static String getChannelId() {
        return f21891a.getChannelId();
    }

    public static String getFirstActivityId() {
        return f21891a.getFirstActivityId();
    }

    public static String getFirstChannelId() {
        return f21891a.getFirstChannelId();
    }

    /* renamed from: a */
    static Map<String, Object> m18219a(String str) {
        return f21891a.getParams(str);
    }

    public static Map<String, Object> getCommonParam() {
        return f21891a.getParams((String) null);
    }
}
