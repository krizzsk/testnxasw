package com.didi.foundation.sdk.swarm;

import com.didi.foundation.sdk.utils.MarketChannelHelper;
import com.didichuxing.swarm.toolkit.DistributionService;

/* renamed from: com.didi.foundation.sdk.swarm.c */
/* compiled from: DistributionServiceImpl */
class C8980c implements DistributionService {
    C8980c() {
    }

    public String getChannelId() {
        return MarketChannelHelper.getChannelID();
    }
}
