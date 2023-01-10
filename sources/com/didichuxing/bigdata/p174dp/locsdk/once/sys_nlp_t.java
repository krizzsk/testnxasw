package com.didichuxing.bigdata.p174dp.locsdk.once;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.sys_nlp_t */
/* compiled from: LocDataDef */
class sys_nlp_t implements Serializable {
    double acy;
    double dir;
    double lat;
    double lon;
    double spd;

    /* renamed from: ts */
    long f48806ts;

    sys_nlp_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 6) + "," + "\"dir\"" + ":" + Const.formatDouble(this.dir, 6) + "," + "\"ts\"" + ":" + this.f48806ts + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 6) + "}";
    }
}
