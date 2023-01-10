package com.didichuxing.bigdata.p174dp.locsdk.once;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.pre_didi_nlp_t */
/* compiled from: LocDataDef */
class pre_didi_nlp_t implements Serializable {
    double acy;
    double conf;

    /* renamed from: dt */
    long f48803dt;
    long elapse_time;
    double lat;
    double lon;
    int type;

    public pre_didi_nlp_t(double d, double d2, double d3, double d4, long j, int i) {
        this.lon = d;
        this.lat = d2;
        this.acy = d3;
        this.conf = d4;
        this.elapse_time = j;
        this.type = i;
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 3) + "," + Const.js_req_conf + ":" + Const.formatDouble(this.conf, 3) + "," + "\"dt\"" + ":" + this.f48803dt + "," + "\"type\"" + ":" + this.type + "}";
    }
}
