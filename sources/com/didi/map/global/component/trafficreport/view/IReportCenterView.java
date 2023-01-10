package com.didi.map.global.component.trafficreport.view;

import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.presenter.ITrafficReportPresenter;
import java.util.List;

public interface IReportCenterView {
    void hide();

    void performCreateView(ITrafficReportPresenter iTrafficReportPresenter, List<ReportGroup> list);

    void setCancelListener();

    void show();
}
