package com.didi.foundation.sdk.swarm;

import com.didichuxing.swarm.toolkit.TraceLogService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

/* renamed from: com.didi.foundation.sdk.swarm.g */
/* compiled from: TraceLogServiceImpl */
class C8984g implements TraceLogService {
    C8984g() {
    }

    public void trackEvent(String str) {
        OmegaSDKAdapter.trackEvent(str);
    }

    public void trackEvent(String str, String str2) {
        OmegaSDKAdapter.trackEvent(str, str2);
    }

    public void trackEvent(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }
}
