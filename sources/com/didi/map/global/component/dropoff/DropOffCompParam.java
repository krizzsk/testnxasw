package com.didi.map.global.component.dropoff;

import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.sdk.poibase.CallFrom;

public class DropOffCompParam {

    /* renamed from: a */
    private CallFrom f27702a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DropOffLocationInfo f27703b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PinStyle f27704c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecPointStyle f27705d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f27706e;

    /* renamed from: f */
    private IDropOffComponentCallback f27707f;

    private DropOffCompParam(CallFrom callFrom, IDropOffComponentCallback iDropOffComponentCallback) {
        this.f27702a = callFrom;
        this.f27707f = iDropOffComponentCallback;
    }

    public CallFrom getReqCallerId() {
        return this.f27702a;
    }

    public DropOffLocationInfo getLocationInfo() {
        return this.f27703b;
    }

    public PinStyle getPinStyle() {
        return this.f27704c;
    }

    public RecPointStyle getRecPointStyle() {
        return this.f27705d;
    }

    public float getZoom() {
        return this.f27706e;
    }

    public IDropOffComponentCallback getComponentCallback() {
        return this.f27707f;
    }

    public static class Builder {
        private DropOffCompParam compParam;

        public Builder(CallFrom callFrom, IDropOffComponentCallback iDropOffComponentCallback) {
            this.compParam = new DropOffCompParam(callFrom, iDropOffComponentCallback);
        }

        public Builder locationInfo(DropOffLocationInfo dropOffLocationInfo) {
            DropOffLocationInfo unused = this.compParam.f27703b = dropOffLocationInfo;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle) {
            PinStyle unused = this.compParam.f27704c = pinStyle;
            return this;
        }

        public Builder recPointStyle(RecPointStyle recPointStyle) {
            RecPointStyle unused = this.compParam.f27705d = recPointStyle;
            return this;
        }

        public Builder zoom(float f) {
            float unused = this.compParam.f27706e = f;
            return this;
        }

        public DropOffCompParam build() {
            return this.compParam;
        }
    }
}
