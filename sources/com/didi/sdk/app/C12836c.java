package com.didi.sdk.app;

import com.didi.sdk.security.SecurityUtil;
import com.didichuxing.swarm.toolkit.DeviceService;

/* renamed from: com.didi.sdk.app.c */
/* compiled from: DeviceServiceImpl */
class C12836c implements DeviceService {
    C12836c() {
    }

    public String getDeviceId() {
        return SecurityUtil.getDeviceId();
    }
}
