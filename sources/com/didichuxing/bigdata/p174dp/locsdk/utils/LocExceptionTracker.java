package com.didichuxing.bigdata.p174dp.locsdk.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.utils.LocExceptionTracker */
public class LocExceptionTracker {

    /* renamed from: a */
    private boolean f48830a;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.utils.LocExceptionTracker$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final LocExceptionTracker instance = new LocExceptionTracker();

        private Holder() {
        }
    }

    public static LocExceptionTracker getInstance() {
        return Holder.instance;
    }

    private LocExceptionTracker() {
        this.f48830a = false;
        IToggle toggle = Apollo.getToggle("map_global_loc_inner_exc_track_toggle");
        if (toggle == null || !toggle.allow()) {
            this.f48830a = false;
            DLog.m36225d("map_global_loc_inner_exc_track_toggle not allow");
            return;
        }
        this.f48830a = true;
        DLog.m36225d("map_global_loc_inner_exc_track_toggle allow");
    }

    public boolean enable() {
        return this.f48830a;
    }

    public void trackInnerException(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("exception_value", str);
        OmegaSDKAdapter.trackEvent("map_global_loc_inner_excption_bt", (Map<String, Object>) hashMap);
        DLog.m36225d("map_global_loc_inner_excption_bt: type:" + i + ", value:" + str);
    }
}
