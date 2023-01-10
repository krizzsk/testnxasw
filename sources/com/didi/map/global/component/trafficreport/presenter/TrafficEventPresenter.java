package com.didi.map.global.component.trafficreport.presenter;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager;
import com.didi.map.global.component.trafficreport.map.ReportLocOpCallback;
import com.didi.map.global.component.trafficreport.model.ReportLocParam;
import com.didi.map.global.component.trafficreport.model.TrafficEventParam;
import com.didi.map.global.component.trafficreport.view.IReportDetailView;
import com.didi.map.global.component.trafficreport.view.ReportLocComponent;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.event.EventReportRes;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.RpcPoi;
import com.squareup.wire.Message;
import com.taxis99.R;

public class TrafficEventPresenter implements ITrafficEventPresenter {

    /* renamed from: a */
    private static final String f28600a = TrafficEventPresenter.class.getSimpleName();

    /* renamed from: b */
    private final TrafficReportFetchManager f28601b;

    /* renamed from: c */
    private PaxEnvironment f28602c;

    /* renamed from: d */
    private ReportLocParam f28603d;

    /* renamed from: e */
    private final TrafficReportFetchManager.FetcherCallback f28604e = new TrafficReportFetchManager.FetcherCallback() {
        public void onBeginToFetch() {
        }

        public void onFinishToFetch(Message message) {
            if (message instanceof EventReportRes) {
                EventReportRes eventReportRes = (EventReportRes) message;
                if (eventReportRes.ret.intValue() == 0) {
                    if (TrafficEventPresenter.this.mView != null) {
                        TrafficEventPresenter.this.mView.showReportResultToast(true, TrafficEventPresenter.this.mContext.getResources().getString(R.string.GRider_PassengerReports__oUxJ));
                    }
                } else if (TrafficEventPresenter.this.mView != null) {
                    TrafficEventPresenter.this.mView.showReportResultToast(false, eventReportRes.msg);
                }
            }
        }
    };
    protected Context mContext;
    protected IReportDetailView mView;

    public TrafficEventPresenter(Context context, IReportDetailView iReportDetailView, PaxEnvironment paxEnvironment) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        this.mView = iReportDetailView;
        this.f28602c = paxEnvironment;
        this.f28601b = TrafficReportFetchManager.getInstance();
    }

    /* renamed from: a */
    private void m22297a() {
        if (this.f28603d == null) {
            this.f28603d = new ReportLocParam.Builder().ReportLocOpCallback(new ReportLocOpCallback() {
                public void onRevertAddress(RpcPoi rpcPoi) {
                    TrafficEventPresenter.this.mView.updateLocation(ModelConverter.convertToAddress(rpcPoi));
                }

                public void onDateLoading() {
                    TrafficEventPresenter.this.mView.updateLocation((Address) null);
                }
            }).build();
        }
        ReportLocComponent reportLocComponent = new ReportLocComponent();
        reportLocComponent.create(this.mContext, (Map) null);
        reportLocComponent.setConfigParam(this.f28603d);
        reportLocComponent.startRevertGeo();
    }

    public void onConfirmReport(TrafficEventParam trafficEventParam) {
        TrafficReportFetchManager trafficReportFetchManager = this.f28601b;
        if (trafficReportFetchManager != null) {
            trafficReportFetchManager.reportTrafficEvent(this.mContext, this.f28602c, trafficEventParam, this.f28604e);
        }
    }

    public void onLoadCurrentAddress(Address address) {
        if (address == null) {
            m22297a();
        } else {
            this.mView.updateLocation(address);
        }
    }
}
