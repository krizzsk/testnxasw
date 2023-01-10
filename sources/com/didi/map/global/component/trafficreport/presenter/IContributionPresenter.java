package com.didi.map.global.component.trafficreport.presenter;

import com.didi.map.sdk.env.PaxEnvironment;

public interface IContributionPresenter {
    void cancelGetContributionHistory();

    void getContributionHistory(PaxEnvironment paxEnvironment, int i, int i2, boolean z);
}
