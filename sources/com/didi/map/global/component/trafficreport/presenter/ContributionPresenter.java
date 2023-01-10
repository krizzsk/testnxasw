package com.didi.map.global.component.trafficreport.presenter;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager;
import com.didi.map.global.component.trafficreport.model.ContributionData;
import com.didi.map.global.component.trafficreport.model.EventHandleStatus;
import com.didi.map.global.component.trafficreport.view.history.IContributionView;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.event.EventHisRes;
import com.didi.map.sdk.proto.driver_gl.event.HisCard;
import com.squareup.wire.Message;
import java.util.ArrayList;

public class ContributionPresenter implements IContributionPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f28595a = ContributionPresenter.class.getSimpleName();

    /* renamed from: b */
    private final TrafficReportFetchManager f28596b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f28597c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f28598d = false;

    /* renamed from: e */
    private final TrafficReportFetchManager.FetcherCallback f28599e = new TrafficReportFetchManager.FetcherCallback() {
        public void onBeginToFetch() {
            if (ContributionPresenter.this.mView != null) {
                ContributionPresenter.this.mView.showLoadingView();
            }
        }

        public void onFinishToFetch(Message message) {
            if (!ContributionPresenter.this.f28597c) {
                if (message instanceof EventHisRes) {
                    EventHisRes eventHisRes = (EventHisRes) message;
                    String a = ContributionPresenter.f28595a;
                    DLog.m10773d(a, "contribution result code = " + eventHisRes.ret + ", msg: " + eventHisRes.msg, new Object[0]);
                    if (eventHisRes.ret.intValue() == 0) {
                        if (ContributionPresenter.this.mView != null) {
                            ContributionPresenter.this.mView.showSuccessView();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (eventHisRes.history != null) {
                            if (eventHisRes.history.hisCard != null) {
                                for (HisCard next : eventHisRes.history.hisCard) {
                                    if (next != null) {
                                        arrayList.add(new ContributionData.Builder().eventTitle(next.eventTitle).routeName(next.routeName).eventType(next.eventType.intValue()).notificationCount(next.notificationCount.intValue()).eventId(next.eventId.longValue()).timestamp(next.timestamp.longValue()).line(next.line).status(EventHandleStatus.getStatus(next.status.intValue())).build());
                                    }
                                }
                            }
                            if (ContributionPresenter.this.mView != null) {
                                ContributionPresenter.this.mView.updateNotificationSum(eventHisRes.history.notificationSum.intValue());
                                ContributionPresenter.this.mView.updateReportCount(eventHisRes.history.reportCount.intValue());
                                ContributionPresenter.this.mView.updateFeedbackCount(eventHisRes.history.feedCount.intValue());
                                ContributionPresenter.this.mView.updateContributionData(arrayList);
                                ContributionPresenter.this.mView.updatePageNum(eventHisRes.history.pageNum.intValue());
                            }
                        } else if (ContributionPresenter.this.mView != null) {
                            ContributionPresenter.this.mView.updateContributionData(arrayList);
                        }
                    } else if (ContributionPresenter.this.mView != null) {
                        ContributionPresenter.this.mView.showFailView(ContributionPresenter.this.f28598d);
                    }
                } else if (ContributionPresenter.this.mView != null) {
                    ContributionPresenter.this.mView.showFailView(ContributionPresenter.this.f28598d);
                }
            }
        }
    };
    protected Context mContext;
    protected IContributionView mView;

    public ContributionPresenter(Context context, IContributionView iContributionView) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mView = iContributionView;
        this.f28596b = TrafficReportFetchManager.getInstance();
    }

    public void getContributionHistory(PaxEnvironment paxEnvironment, int i, int i2, boolean z) {
        this.f28597c = false;
        this.f28598d = z;
        this.f28596b.requestContributionHistory(paxEnvironment, i, i2, this.f28599e);
    }

    public void cancelGetContributionHistory() {
        this.f28597c = true;
    }
}
