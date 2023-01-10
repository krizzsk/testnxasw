package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.catch */
/* compiled from: CameraLevel */
public enum C20757catch {
    CAMERA1(C20759const.CAMERA1),
    CAMERA2_LEGACY(r2),
    CAMERA2_EXTERNAL(r2),
    CAMERA2_LIMITED(r2),
    CAMERA2_FULL(r2),
    CAMERA2_LEVEL3(r2);

    private C20757catch(C20759const constR) {
    }

    /* renamed from: do */
    public boolean mo171297do(C20757catch catchR) {
        return compareTo(catchR) >= 0;
    }
}
