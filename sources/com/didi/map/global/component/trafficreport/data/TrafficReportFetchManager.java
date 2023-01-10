package com.didi.map.global.component.trafficreport.data;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.trafficreport.model.TrafficEventParam;
import com.didi.map.global.component.trafficreport.util.ReportUrls;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.event.EventElementReq;
import com.didi.map.sdk.proto.driver_gl.event.EventHisReq;
import com.didi.map.sdk.proto.driver_gl.event.EventReportReq;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.squareup.wire.Message;

public class TrafficReportFetchManager {
    public static final int ELEMENT = 0;
    public static final int HISTORY = 2;
    public static final int NET_SUCCESS = 0;
    public static final int REPORT = 1;

    /* renamed from: a */
    private static final String f28549a = "TrafficReportFetch";

    /* renamed from: b */
    private static final int f28550b = 1;

    /* renamed from: c */
    private static final int f28551c = 2;

    /* renamed from: d */
    private TrafficReportFetchTask f28552d;

    public interface FetcherCallback {

        /* renamed from: com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager$FetcherCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onBeginToFetch(FetcherCallback fetcherCallback) {
            }
        }

        void onBeginToFetch();

        void onFinishToFetch(Message message);
    }

    private TrafficReportFetchManager() {
    }

    public static TrafficReportFetchManager getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        /* access modifiers changed from: private */
        public static final TrafficReportFetchManager INSTANCE = new TrafficReportFetchManager();

        private Singleton() {
        }
    }

    public void requestEventElements(Context context, PaxEnvironment paxEnvironment, FetcherCallback fetcherCallback) {
        DLog.m10773d(f28549a, "requestEventElements !!!", new Object[0]);
        TrafficReportFetchTask trafficReportFetchTask = this.f28552d;
        if (trafficReportFetchTask == null || trafficReportFetchTask.getStatus() == AsyncTask.Status.FINISHED) {
            TrafficReportFetchTask trafficReportFetchTask2 = new TrafficReportFetchTask(m22288a(context, paxEnvironment), 0, fetcherCallback);
            this.f28552d = trafficReportFetchTask2;
            trafficReportFetchTask2.execute(new String[]{ReportUrls.getEventUrl()});
            return;
        }
        DLog.m10773d(f28549a, "require event elements req busy", new Object[0]);
    }

    public void reportTrafficEvent(Context context, PaxEnvironment paxEnvironment, TrafficEventParam trafficEventParam, FetcherCallback fetcherCallback) {
        DLog.m10773d(f28549a, "reportTrafficEvent !!!", new Object[0]);
        TrafficReportFetchTask trafficReportFetchTask = this.f28552d;
        if (trafficReportFetchTask == null || trafficReportFetchTask.getStatus() == AsyncTask.Status.FINISHED) {
            TrafficReportFetchTask trafficReportFetchTask2 = new TrafficReportFetchTask(m22290a(context, paxEnvironment, trafficEventParam), 1, fetcherCallback);
            this.f28552d = trafficReportFetchTask2;
            trafficReportFetchTask2.execute(new String[]{ReportUrls.getReportUrl()});
            return;
        }
        DLog.m10773d(f28549a, "report traffic event req busy", new Object[0]);
    }

    public void requestContributionHistory(PaxEnvironment paxEnvironment, int i, int i2, FetcherCallback fetcherCallback) {
        DLog.m10773d(f28549a, "requestContributionHistory !!!", new Object[0]);
        TrafficReportFetchTask trafficReportFetchTask = this.f28552d;
        if (trafficReportFetchTask == null || trafficReportFetchTask.getStatus() == AsyncTask.Status.FINISHED) {
            TrafficReportFetchTask trafficReportFetchTask2 = new TrafficReportFetchTask(m22289a(i, i2, paxEnvironment), 2, fetcherCallback);
            this.f28552d = trafficReportFetchTask2;
            trafficReportFetchTask2.execute(new String[]{ReportUrls.getHistoryUrl()});
            return;
        }
        DLog.m10773d(f28549a, "require contribution history req busy", new Object[0]);
    }

    /* renamed from: a */
    private EventElementReq m22288a(Context context, PaxEnvironment paxEnvironment) {
        if (paxEnvironment == null) {
            return null;
        }
        EventElementReq.Builder builder = new EventElementReq.Builder();
        builder.timestamp(Long.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000)).source(Integer.valueOf(paxEnvironment.getRoleType() == RoleType.PASSENGER ? 1 : 2)).userId(Long.valueOf(paxEnvironment.getUid())).didiVersion(paxEnvironment.getAppVersion()).token(paxEnvironment.getToken()).lang(LocaleCodeHolder.getInstance().getCurrentLang());
        EventElementReq build = builder.build();
        DLog.m10773d(f28549a, "getEventElementReq %s", build.toString());
        return build;
    }

    /* renamed from: a */
    private EventReportReq m22290a(Context context, PaxEnvironment paxEnvironment, TrafficEventParam trafficEventParam) {
        if (paxEnvironment == null || trafficEventParam == null) {
            return null;
        }
        EventReportReq.Builder builder = new EventReportReq.Builder();
        builder.timestamp(Long.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000)).source(Integer.valueOf(paxEnvironment.getRoleType() == RoleType.PASSENGER ? 1 : 2)).userId(Long.valueOf(paxEnvironment.getUid())).didiVersion(paxEnvironment.getAppVersion()).token(paxEnvironment.getToken()).lang(LocaleCodeHolder.getInstance().getCurrentLang()).cityId(Integer.valueOf(paxEnvironment.getCityId())).countryId(paxEnvironment.getCountryCode()).eventType(trafficEventParam.getEventType()).orderId(trafficEventParam.getOrderId()).eventPoint(m22287a(trafficEventParam.getEventPoint())).locType(trafficEventParam.getLocType()).reportLocName(trafficEventParam.getReportLocName()).sourceType(trafficEventParam.getSourceType()).remark(trafficEventParam.getRemark()).trustType(trafficEventParam.getTrustType());
        SystemUtils.log(3, f28549a, " getEventReportReq: " + trafficEventParam.getEventType() + ", " + trafficEventParam.getRemark() + ", " + trafficEventParam.getReportLocName() + ", " + trafficEventParam.getEventPoint() + ", " + trafficEventParam.getLocType() + "," + trafficEventParam.getTrustType(), (Throwable) null, "com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager", 115);
        EventReportReq build = builder.build();
        DLog.m10773d(f28549a, "getEventReportReq %s", build.toString());
        return build;
    }

    /* renamed from: a */
    private EventHisReq m22289a(int i, int i2, PaxEnvironment paxEnvironment) {
        if (paxEnvironment == null) {
            return null;
        }
        EventHisReq.Builder builder = new EventHisReq.Builder();
        builder.timestamp(Long.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis() / 1000)).source(Integer.valueOf(paxEnvironment.getRoleType() == RoleType.PASSENGER ? 1 : 2)).userId(Long.valueOf(paxEnvironment.getUid())).didiVersion(paxEnvironment.getAppVersion()).token(paxEnvironment.getToken()).lang(LocaleCodeHolder.getInstance().getCurrentLang()).pageNum(Integer.valueOf(i)).pageCap(Integer.valueOf(i2));
        EventHisReq build = builder.build();
        DLog.m10773d(f28549a, "getEventHisReq %s ", build.toString());
        return build;
    }

    /* renamed from: a */
    private DoublePoint m22287a(LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng)) {
            return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).dlat(Double.valueOf(latLng.latitude)).dlng(Double.valueOf(latLng.longitude)).build();
        }
        return null;
    }
}
