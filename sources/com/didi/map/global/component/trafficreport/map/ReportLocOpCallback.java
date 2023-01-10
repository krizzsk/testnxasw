package com.didi.map.global.component.trafficreport.map;

import com.sdk.poibase.model.RpcPoi;

public interface ReportLocOpCallback {
    void onDateLoading();

    void onRevertAddress(RpcPoi rpcPoi);
}
