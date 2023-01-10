package com.didi.mapbizinterface.track;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

public class TrackPointParams {

    /* renamed from: a */
    DIDILocation f31539a;

    public TrackPointParams(DIDILocation dIDILocation) {
        this.f31539a = dIDILocation;
    }

    public static class Builder {
        private DIDILocation location;

        public Builder location(DIDILocation dIDILocation) {
            this.location = dIDILocation;
            return this;
        }

        public TrackPointParams build() {
            return new TrackPointParams(this.location);
        }
    }
}
