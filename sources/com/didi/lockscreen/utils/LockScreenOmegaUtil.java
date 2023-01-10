package com.didi.lockscreen.utils;

import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.GLog;
import com.didi.travel.psnger.model.response.CarOrder;
import java.util.HashMap;
import java.util.Map;

public class LockScreenOmegaUtil {

    /* renamed from: a */
    private static final String f26655a = "map_clock_sctx_sw";

    /* renamed from: b */
    private static final String f26656b = "map_clock_sctx_close_ck";

    /* renamed from: c */
    private static final String f26657c = "order_id";

    /* renamed from: d */
    private static final String f26658d = "timestamp";

    /* renamed from: e */
    private static final String f26659e = "passenger_id";

    /* renamed from: f */
    private static final String f26660f = "trip_step";

    /* renamed from: g */
    private static final String f26661g = "not_show";

    /* renamed from: h */
    private static final String f26662h = "xpanel";

    public static void sendLockScreenShow(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("order_id", order.oid);
            hashMap.put("passenger_id", NationComponentDataUtil.getLoginInfo().getUid());
            hashMap.put("xpanel", Integer.valueOf(i));
            hashMap.put("trip_step", Integer.valueOf(m21139a()));
            GlobalOmegaUtils.trackEvent(f26655a, (Map<String, Object>) hashMap);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendLockScreenShow ");
        sb.append(order != null);
        GLog.m11354d("LockScreenOmegaUtil", sb.toString());
    }

    public static void sendLockScreenCloseClick(boolean z) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("order_id", order.oid);
            hashMap.put("passenger_id", NationComponentDataUtil.getLoginInfo().getUid());
            hashMap.put(f26661g, Integer.valueOf(z ? 1 : 0));
            hashMap.put("trip_step", Integer.valueOf(m21139a()));
            GlobalOmegaUtils.trackEvent(f26656b, (Map<String, Object>) hashMap);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendLockScreenCloseClick ");
        sb.append(order != null);
        GLog.m11354d("LockScreenOmegaUtil", sb.toString());
    }

    /* renamed from: a */
    private static int m21139a() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return -1;
        }
        int i = order.substatus;
        if (i == 4001 || i == 4000 || i == 4002) {
            return 0;
        }
        return (i == 4002 || i == 4003 || i == 4004 || i == 4005) ? 1 : -1;
    }
}
