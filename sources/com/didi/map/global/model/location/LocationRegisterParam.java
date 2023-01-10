package com.didi.map.global.model.location;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;

public class LocationRegisterParam {

    /* renamed from: a */
    private DIDILocationUpdateOption.IntervalMode f29852a;

    /* renamed from: b */
    private LocType f29853b;

    /* renamed from: c */
    private NLPRegisterParam f29854c;

    public enum LocType {
        NLP,
        FLP
    }

    public LocationRegisterParam(DIDILocationUpdateOption.IntervalMode intervalMode, LocType locType) {
        this.f29852a = intervalMode;
        this.f29853b = locType;
    }

    public NLPRegisterParam getNlpRegisterParam() {
        return this.f29854c;
    }

    public void setNlpRegisterParam(NLPRegisterParam nLPRegisterParam) {
        this.f29854c = nLPRegisterParam;
    }

    public LocType getLocType() {
        return this.f29853b;
    }

    public DIDILocationUpdateOption.IntervalMode getMode() {
        return this.f29852a;
    }

    public String toString() {
        return "LocationRegisterParam{mode=" + this.f29852a + ", locType=" + this.f29853b + ", nlpRegisterParam=" + this.f29854c + '}';
    }
}
