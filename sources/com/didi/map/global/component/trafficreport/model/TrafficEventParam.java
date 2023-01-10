package com.didi.map.global.component.trafficreport.model;

import com.didi.common.map.model.LatLng;

public class TrafficEventParam {

    /* renamed from: a */
    private final Integer f28587a;

    /* renamed from: b */
    private final String f28588b;

    /* renamed from: c */
    private final LatLng f28589c;

    /* renamed from: d */
    private final Integer f28590d;

    /* renamed from: e */
    private final String f28591e;

    /* renamed from: f */
    private final Integer f28592f;

    /* renamed from: g */
    private final String f28593g;

    /* renamed from: h */
    private final Integer f28594h;

    public Integer getEventType() {
        return this.f28587a;
    }

    public String getOrderId() {
        return this.f28588b;
    }

    public LatLng getEventPoint() {
        return this.f28589c;
    }

    public Integer getSourceType() {
        return this.f28590d;
    }

    public String getReportLocName() {
        return this.f28591e;
    }

    public Integer getLocType() {
        return this.f28592f;
    }

    public String getRemark() {
        return this.f28593g;
    }

    public Integer getTrustType() {
        return this.f28594h;
    }

    public TrafficEventParam(Builder builder) {
        this.f28587a = builder.eventType;
        this.f28588b = builder.orderId;
        this.f28589c = builder.eventPoint;
        this.f28590d = builder.sourceType;
        this.f28591e = builder.reportLocName;
        this.f28592f = builder.locType;
        this.f28593g = builder.remark;
        this.f28594h = builder.trustType;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public LatLng eventPoint;
        /* access modifiers changed from: private */
        public Integer eventType;
        /* access modifiers changed from: private */
        public Integer locType;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public String remark;
        /* access modifiers changed from: private */
        public String reportLocName;
        /* access modifiers changed from: private */
        public Integer sourceType;
        /* access modifiers changed from: private */
        public Integer trustType;

        public Builder eventType(int i) {
            this.eventType = Integer.valueOf(i);
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder eventPoint(LatLng latLng) {
            this.eventPoint = latLng;
            return this;
        }

        public Builder sourceType(int i) {
            this.sourceType = Integer.valueOf(i);
            return this;
        }

        public Builder reportLocName(String str) {
            this.reportLocName = str;
            return this;
        }

        public Builder locType(int i) {
            this.locType = Integer.valueOf(i);
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder trustType(Integer num) {
            this.trustType = num;
            return this;
        }

        public TrafficEventParam build() {
            return new TrafficEventParam(this);
        }
    }
}
