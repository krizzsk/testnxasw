package com.didi.map.global.component.trafficreport.model;

import com.didi.map.sdk.proto.driver_gl.event.ButtonModeInfo;

public class ContributionData {

    /* renamed from: a */
    final String f28562a;

    /* renamed from: b */
    final ButtonModeInfo f28563b;

    /* renamed from: c */
    final int f28564c;

    /* renamed from: d */
    final String f28565d;

    /* renamed from: e */
    final EventHandleStatus f28566e;

    /* renamed from: f */
    final int f28567f;

    /* renamed from: g */
    final long f28568g;

    /* renamed from: h */
    final long f28569h;

    /* renamed from: i */
    final String f28570i;

    public String getEventTitle() {
        return this.f28562a;
    }

    public ButtonModeInfo getModeInfo() {
        return this.f28563b;
    }

    public int getEventType() {
        return this.f28564c;
    }

    public String getRouteName() {
        return this.f28565d;
    }

    public EventHandleStatus getStatus() {
        return this.f28566e;
    }

    public int getNotificationCount() {
        return this.f28567f;
    }

    public long getEventId() {
        return this.f28568g;
    }

    public long getTimestamp() {
        return this.f28569h;
    }

    public String getLine() {
        return this.f28570i;
    }

    public ContributionData(Builder builder) {
        this.f28562a = builder.eventTitle;
        this.f28563b = builder.modeInfo;
        this.f28564c = builder.eventType;
        this.f28565d = builder.routeName;
        this.f28566e = builder.status;
        this.f28567f = builder.notificationCount;
        this.f28568g = builder.eventId;
        this.f28569h = builder.timestamp;
        this.f28570i = builder.line;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public long eventId;
        /* access modifiers changed from: private */
        public String eventTitle;
        /* access modifiers changed from: private */
        public int eventType;
        /* access modifiers changed from: private */
        public String line;
        /* access modifiers changed from: private */
        public ButtonModeInfo modeInfo;
        /* access modifiers changed from: private */
        public int notificationCount;
        /* access modifiers changed from: private */
        public String routeName;
        /* access modifiers changed from: private */
        public EventHandleStatus status;
        /* access modifiers changed from: private */
        public long timestamp;

        public Builder eventTitle(String str) {
            this.eventTitle = str;
            return this;
        }

        public Builder modeInfo(ButtonModeInfo buttonModeInfo) {
            this.modeInfo = buttonModeInfo;
            return this;
        }

        public Builder eventType(int i) {
            this.eventType = i;
            return this;
        }

        public Builder routeName(String str) {
            this.routeName = str;
            return this;
        }

        public Builder status(EventHandleStatus eventHandleStatus) {
            this.status = eventHandleStatus;
            return this;
        }

        public Builder notificationCount(int i) {
            this.notificationCount = i;
            return this;
        }

        public Builder eventId(long j) {
            this.eventId = j;
            return this;
        }

        public Builder timestamp(long j) {
            this.timestamp = j;
            return this;
        }

        public Builder line(String str) {
            this.line = str;
            return this;
        }

        public ContributionData build() {
            return new ContributionData(this);
        }
    }
}
