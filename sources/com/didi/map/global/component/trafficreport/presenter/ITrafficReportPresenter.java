package com.didi.map.global.component.trafficreport.presenter;

public interface ITrafficReportPresenter {
    public static final int close_reason_click = 0;
    public static final int close_reason_report = 1;

    void onReportItemClick(int i, int i2);

    void onViewClose(int i);
}
