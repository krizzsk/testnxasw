package com.didi.map.global.component.trafficreport.view;

import com.didi.sdk.address.address.entity.Address;

public interface IReportDetailView {
    void showReportResultToast(boolean z, String str);

    void updateLocation(Address address);
}
