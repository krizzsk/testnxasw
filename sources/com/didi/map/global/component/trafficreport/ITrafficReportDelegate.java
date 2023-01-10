package com.didi.map.global.component.trafficreport;

import com.didi.map.global.component.trafficreport.model.ReportGroup;
import java.util.List;

public interface ITrafficReportDelegate {
    void hideTrafficReportCenter();

    void init();

    void showTrafficReportCenter(TrafficReportParam trafficReportParam);

    void unInit();

    void updateButtonInfoList(List<ReportGroup> list);
}
