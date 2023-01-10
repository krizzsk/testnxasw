package com.didichuxing.bigdata.p174dp.locsdk;

import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.FLPDiffInfoGetter */
public class FLPDiffInfoGetter implements IDiffInfoGetter {

    /* renamed from: a */
    private static final String f48365a = "FLPDiffInfoGetter";

    /* renamed from: b */
    private IDiffInfoGetter f48366b;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.FLPDiffInfoGetter$SingletonHolder */
    private static class SingletonHolder {
        static final FLPDiffInfoGetter sInstance = new FLPDiffInfoGetter();

        private SingletonHolder() {
        }
    }

    public static FLPDiffInfoGetter getInstance() {
        return SingletonHolder.sInstance;
    }

    private FLPDiffInfoGetter() {
        try {
            this.f48366b = (IDiffInfoGetter) ServiceLoader.load(IDiffInfoGetter.class).get();
        } catch (Exception e) {
            DLog.m36225d("FLPDiffInfoGetterinit exception: " + e.getMessage() + "," + e.getClass());
        }
    }

    public int getNLPCoordinateType() {
        IDiffInfoGetter iDiffInfoGetter = this.f48366b;
        if (iDiffInfoGetter != null) {
            return iDiffInfoGetter.getNLPCoordinateType();
        }
        return 0;
    }

    public String getJustStartOmegaKey() {
        IDiffInfoGetter iDiffInfoGetter = this.f48366b;
        if (iDiffInfoGetter != null) {
            return iDiffInfoGetter.getJustStartOmegaKey();
        }
        return null;
    }

    public String getMockExtraKey() {
        IDiffInfoGetter iDiffInfoGetter = this.f48366b;
        return iDiffInfoGetter != null ? iDiffInfoGetter.getMockExtraKey() : "";
    }

    public boolean getNTPTimeDiffWTFSwitch() {
        IDiffInfoGetter iDiffInfoGetter = this.f48366b;
        if (iDiffInfoGetter != null) {
            return iDiffInfoGetter.getNTPTimeDiffWTFSwitch();
        }
        return false;
    }

    public ETraceSource getInfoSource() {
        IDiffInfoGetter iDiffInfoGetter = this.f48366b;
        if (iDiffInfoGetter != null) {
            return iDiffInfoGetter.getInfoSource();
        }
        return ETraceSource.flp;
    }
}
