package com.didi.hawaii.p120ar.core;

import com.didi.hawaii.p120ar.jni.DARCLocationInScene;
import com.didi.hawaii.p120ar.jni.DARCNAVStatus;
import com.didi.hawaii.p120ar.jni.DARCPointF;

/* renamed from: com.didi.hawaii.ar.core.IScenceDelegate */
public interface IScenceDelegate {
    void currentLocation(DARCLocationInScene dARCLocationInScene);

    double currentTime();

    float distanceOfEnd();

    void getGuidePosInScreen(DARCPointF dARCPointF);

    DARCNAVStatus status();
}
