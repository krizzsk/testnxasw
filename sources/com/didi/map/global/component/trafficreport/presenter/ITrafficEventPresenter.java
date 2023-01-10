package com.didi.map.global.component.trafficreport.presenter;

import com.didi.map.global.component.trafficreport.model.TrafficEventParam;
import com.didi.sdk.address.address.entity.Address;

public interface ITrafficEventPresenter {
    void onConfirmReport(TrafficEventParam trafficEventParam);

    void onLoadCurrentAddress(Address address);
}
