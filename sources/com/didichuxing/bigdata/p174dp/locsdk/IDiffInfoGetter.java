package com.didichuxing.bigdata.p174dp.locsdk;

import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.IDiffInfoGetter */
public interface IDiffInfoGetter {
    ETraceSource getInfoSource();

    String getJustStartOmegaKey();

    String getMockExtraKey();

    int getNLPCoordinateType();

    boolean getNTPTimeDiffWTFSwitch();
}
