package com.didi.foundation.sdk.swarm;

import com.didichuxing.swarm.toolkit.DeviceService;

/* renamed from: com.didi.foundation.sdk.swarm.b */
/* compiled from: DeviceServiceImpl */
class C8979b implements DeviceService {
    C8979b() {
    }

    public String getDeviceId() {
        return com.didi.foundation.sdk.service.DeviceService.getInstance().getDeviceId();
    }
}
