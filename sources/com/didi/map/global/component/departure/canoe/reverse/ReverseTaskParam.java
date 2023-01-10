package com.didi.map.global.component.departure.canoe.reverse;

import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.sdk.poibase.CallFrom;

public class ReverseTaskParam {

    /* renamed from: a */
    private int f27252a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CallFrom f27253b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureLocationInfo f27254c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f27255d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f27256e;

    /* renamed from: f */
    private ReverseTaskCallback f27257f;

    private ReverseTaskParam(int i, ReverseTaskCallback reverseTaskCallback) {
        this.f27252a = i;
        this.f27257f = reverseTaskCallback;
    }

    public int getId() {
        return this.f27252a;
    }

    public CallFrom getReqCallerId() {
        return this.f27253b;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f27254c;
    }

    public String getMapType() {
        return this.f27255d;
    }

    public String getUserOperationType() {
        return this.f27256e;
    }

    public ReverseTaskCallback getTaskCallback() {
        return this.f27257f;
    }

    public static class Builder {
        private ReverseTaskParam dataTaskParam;

        public Builder(int i, ReverseTaskCallback reverseTaskCallback) {
            this.dataTaskParam = new ReverseTaskParam(i, reverseTaskCallback);
        }

        public Builder reqCallerId(CallFrom callFrom) {
            CallFrom unused = this.dataTaskParam.f27253b = callFrom;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            DepartureLocationInfo unused = this.dataTaskParam.f27254c = departureLocationInfo;
            return this;
        }

        public Builder mapType(String str) {
            String unused = this.dataTaskParam.f27255d = str;
            return this;
        }

        public Builder userOperationType(String str) {
            String unused = this.dataTaskParam.f27256e = str;
            return this;
        }

        public ReverseTaskParam build() {
            return this.dataTaskParam;
        }
    }
}
