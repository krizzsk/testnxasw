package com.didi.map.global.component.trafficreport.view.history;

import com.didi.map.global.component.trafficreport.model.ContributionData;
import java.util.List;

public interface IContributionView {
    void showFailView(boolean z);

    void showLoadingView();

    void showSuccessView();

    void updateContributionData(List<ContributionData> list);

    void updateFeedbackCount(int i);

    void updateNotificationSum(int i);

    void updatePageNum(int i);

    void updateReportCount(int i);
}
