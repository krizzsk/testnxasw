package com.didi.mapbizinterface.track;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

public class TrackMessageParams {

    /* renamed from: a */
    String f31535a;

    /* renamed from: b */
    String f31536b;

    /* renamed from: c */
    DIDILocation f31537c;

    /* renamed from: d */
    Integer f31538d;

    public TrackMessageParams(String str, String str2, DIDILocation dIDILocation) {
        this.f31535a = str;
        this.f31536b = str2;
        this.f31537c = dIDILocation;
    }

    private TrackMessageParams(String str, String str2, DIDILocation dIDILocation, Integer num) {
        this.f31535a = str;
        this.f31536b = str2;
        this.f31537c = dIDILocation;
        this.f31538d = num;
    }

    public static class Builder {
        private DIDILocation location;
        private String orderId;
        private String phone;
        private Integer trackSdkFlag;

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder location(DIDILocation dIDILocation) {
            this.location = dIDILocation;
            return this;
        }

        public Builder trackSdkFlag(Integer num) {
            this.trackSdkFlag = num;
            return this;
        }

        public TrackMessageParams build() {
            return new TrackMessageParams(this.phone, this.orderId, this.location, this.trackSdkFlag);
        }
    }
}
