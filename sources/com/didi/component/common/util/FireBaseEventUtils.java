package com.didi.component.common.util;

import android.os.Bundle;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.type.IMSType;
import com.didi.sdk.p155ms.common.utils.LogUtil;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import java.util.HashMap;
import java.util.Map;

public class FireBaseEventUtils {

    /* renamed from: a */
    private static final String f13592a = FireBaseEventUtils.class.getSimpleName();

    public static void traceEvent(String str, boolean z) {
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS);
        if (iCollector != null) {
            LogUtil.m29855i(f13592a, "traceEvent : gmsCollector is load");
            HashMap hashMap = new HashMap();
            hashMap.put("eventId", str);
            if (z || GlobalApolloUtil.isReportByFireBase()) {
                iCollector.traceEvent(DIDIBaseApplication.getAppContext(), str, (Bundle) null);
                GlobalOmegaUtils.trackEvent("pas_firebase_event_submit", (Map<String, Object>) hashMap);
            }
        }
    }
}
