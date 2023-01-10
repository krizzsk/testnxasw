package com.didi.map.global.component.trafficreport.model;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.trafficreport.map.ReportLocOpCallback;

public class ReportLocParam {

    /* renamed from: a */
    private LatLng f28581a;

    /* renamed from: b */
    private ReportLocOpCallback f28582b;

    public LatLng getmLoc() {
        return this.f28581a;
    }

    public ReportLocOpCallback getCallback() {
        return this.f28582b;
    }

    public ReportLocParam(Builder builder) {
        this.f28581a = builder.mLoc;
        this.f28582b = builder.callback;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ReportLocOpCallback callback;
        /* access modifiers changed from: private */
        public LatLng mLoc;

        public Builder mLoc(LatLng latLng) {
            this.mLoc = latLng;
            return this;
        }

        public Builder ReportLocOpCallback(ReportLocOpCallback reportLocOpCallback) {
            this.callback = reportLocOpCallback;
            return this;
        }

        public ReportLocParam build() {
            return new ReportLocParam(this);
        }
    }
}
