package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.Serializable;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.sys_nlp_t */
/* compiled from: LocDataDef */
class sys_nlp_t implements Serializable {
    double acy;
    double dir;
    double lat;
    double lon;
    double spd;

    /* renamed from: ts */
    long f48655ts;

    sys_nlp_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"lon\"" + ":" + Const.formatDouble(this.lon, 6) + "," + "\"lat\"" + ":" + Const.formatDouble(this.lat, 6) + "," + "\"spd\"" + ":" + Const.formatDouble(this.spd, 6) + "," + "\"dir\"" + ":" + Const.formatDouble(this.dir, 6) + "," + "\"ts\"" + ":" + this.f48655ts + "," + "\"acy\"" + ":" + Const.formatDouble(this.acy, 6) + "}";
    }
}
