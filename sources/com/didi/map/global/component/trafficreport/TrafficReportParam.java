package com.didi.map.global.component.trafficreport;

import android.content.Context;

public class TrafficReportParam {

    /* renamed from: a */
    private final Context f28546a;

    /* renamed from: b */
    private final String f28547b;

    /* renamed from: c */
    private final ITrafficReportCallback f28548c;

    public Context getContext() {
        return this.f28546a;
    }

    public ITrafficReportCallback getTrafficReportCallback() {
        return this.f28548c;
    }

    public String getOrderId() {
        return this.f28547b;
    }

    public TrafficReportParam(Builder builder) {
        this.f28546a = builder.context;
        this.f28547b = builder.orderId;
        this.f28548c = builder.trafficReportCallback;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public ITrafficReportCallback trafficReportCallback;

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder trafficReportCallback(ITrafficReportCallback iTrafficReportCallback) {
            this.trafficReportCallback = iTrafficReportCallback;
            return this;
        }

        public TrafficReportParam build() {
            return new TrafficReportParam(this);
        }
    }
}
