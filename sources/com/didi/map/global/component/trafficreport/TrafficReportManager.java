package com.didi.map.global.component.trafficreport;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.presenter.TrafficReportPresenter;
import com.didi.map.global.component.trafficreport.view.ReportCenterView;
import com.didi.map.sdk.env.PaxEnvironment;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.List;

public class TrafficReportManager implements ITrafficReportDelegate {

    /* renamed from: a */
    private static final String f28540a = "TrafficReportManager";

    /* renamed from: e */
    private static TrafficReportManager f28541e;

    /* renamed from: b */
    private Context f28542b;

    /* renamed from: c */
    private List<ReportGroup> f28543c = new ArrayList();

    /* renamed from: d */
    private volatile boolean f28544d = false;

    /* renamed from: f */
    private ReportCenterView f28545f;

    public TrafficReportManager(Context context) {
        this.f28542b = context;
        init();
    }

    public static TrafficReportManager create(Context context) {
        if (f28541e == null) {
            f28541e = new TrafficReportManager(context);
        }
        return f28541e;
    }

    public void init() {
        DLog.m10773d(f28540a, IPixView.PAGE_STATUS_INIT, new Object[0]);
        if (this.f28543c.size() > 0) {
            DLog.m10773d(f28540a, "Already initialized.", new Object[0]);
        } else {
            this.f28544d = true;
        }
    }

    public void unInit() {
        this.f28544d = false;
        hideTrafficReportCenter();
        this.f28543c.clear();
    }

    public void updateButtonInfoList(List<ReportGroup> list) {
        this.f28543c = list;
    }

    public void showTrafficReportCenter(TrafficReportParam trafficReportParam) {
        ReportCenterView reportCenterView = new ReportCenterView(trafficReportParam);
        this.f28545f = reportCenterView;
        if (reportCenterView == null || !reportCenterView.isShowing()) {
            TrafficReportPresenter trafficReportPresenter = new TrafficReportPresenter(this.f28542b, this.f28545f, this, trafficReportParam, PaxEnvironment.getInstance());
            List<ReportGroup> list = this.f28543c;
            if (list == null || list.size() <= 0) {
                trafficReportPresenter.requestData();
                return;
            }
            trafficReportPresenter.setData(this.f28542b, trafficReportParam, this.f28545f, this.f28543c);
            this.f28545f.performCreateView(trafficReportPresenter, this.f28543c);
            this.f28545f.show();
            this.f28545f.setCancelListener();
        }
    }

    public void hideTrafficReportCenter() {
        ReportCenterView reportCenterView = this.f28545f;
        if (reportCenterView != null) {
            reportCenterView.hide();
            this.f28545f = null;
        }
    }
}
