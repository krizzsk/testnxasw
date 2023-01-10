package com.didi.sdk.app;

import com.didi.sdk.util.SystemUtil;
import com.didichuxing.swarm.toolkit.DistributionService;

/* renamed from: com.didi.sdk.app.d */
/* compiled from: DistributionServiceImpl */
class C12837d implements DistributionService {
    C12837d() {
    }

    public String getChannelId() {
        return SystemUtil.getChannelId();
    }
}
