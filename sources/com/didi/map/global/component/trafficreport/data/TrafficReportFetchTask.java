package com.didi.map.global.component.trafficreport.data;

import android.os.AsyncTask;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.NetUtils;
import com.didi.map.global.component.trafficreport.data.TrafficReportFetchManager;
import com.didi.map.sdk.proto.driver_gl.event.EventElementRes;
import com.didi.map.sdk.proto.driver_gl.event.EventHisRes;
import com.didi.map.sdk.proto.driver_gl.event.EventReportRes;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;

public class TrafficReportFetchTask extends AsyncTask<String, Integer, Message> {

    /* renamed from: a */
    private static final String f28553a = "TrafficReportFetchTask";

    /* renamed from: b */
    private final Message f28554b;

    /* renamed from: c */
    private final int f28555c;

    /* renamed from: d */
    private final TrafficReportFetchManager.FetcherCallback f28556d;

    public TrafficReportFetchTask(Message message, int i, TrafficReportFetchManager.FetcherCallback fetcherCallback) {
        this.f28554b = message;
        this.f28555c = i;
        this.f28556d = fetcherCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        TrafficReportFetchManager.FetcherCallback fetcherCallback = this.f28556d;
        if (fetcherCallback != null) {
            fetcherCallback.onBeginToFetch();
        }
    }

    /* access modifiers changed from: protected */
    public Message doInBackground(String... strArr) {
        if (this.f28554b == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        try {
            DLog.m10773d(f28553a, "Current task url is " + strArr[0] + ", " + this.f28555c, new Object[0]);
            byte[] doPost = NetUtils.doPost(strArr[0], this.f28554b.toByteArray());
            Wire wire = new Wire((Class<?>[]) new Class[0]);
            int i = this.f28555c;
            if (i == 0) {
                return wire.parseFrom(doPost, EventElementRes.class);
            }
            if (i == 1) {
                return wire.parseFrom(doPost, EventReportRes.class);
            }
            if (i != 2) {
                return null;
            }
            return wire.parseFrom(doPost, EventHisRes.class);
        } catch (Exception e) {
            DLog.m10773d(f28553a, "Exception in TrafficReportFetchTask.doInBackground(...): ", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append("Current task: ");
        sb.append(this.f28555c);
        sb.append(" onPostExecute Message: ");
        sb.append(message == null ? "null" : message.toString());
        DLog.m10773d(f28553a, sb.toString(), new Object[0]);
        TrafficReportFetchManager.FetcherCallback fetcherCallback = this.f28556d;
        if (fetcherCallback != null) {
            fetcherCallback.onFinishToFetch(message);
        }
    }
}
