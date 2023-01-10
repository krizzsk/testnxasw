package com.didi.travel.psnger.core.matchinfo;

import com.didi.travel.psnger.core.model.request.BaseMatchInfoParams;

public abstract class AbsMatchInfoService implements MatchInfoService {

    /* renamed from: a */
    private MatchInfoPollingManager f46729a;

    public void startMatchInfo(boolean z, BaseMatchInfoParams baseMatchInfoParams) {
        if (this.f46729a == null) {
            this.f46729a = new MatchInfoPollingManager(this);
        }
        this.f46729a.startMatchInfo(z, baseMatchInfoParams);
    }

    public void stopMatchInfo() {
        MatchInfoPollingManager matchInfoPollingManager = this.f46729a;
        if (matchInfoPollingManager != null) {
            matchInfoPollingManager.stopOrderMatchInfoPoll();
        }
    }
}
