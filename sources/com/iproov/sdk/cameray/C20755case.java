package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.case */
/* compiled from: CameraException */
public class C20755case extends Exception {

    /* renamed from: com.iproov.sdk.cameray.case$do */
    /* compiled from: CameraException */
    public enum C20756do {
        CAMERA_PERMISSION_DENIED,
        CAMERA_ERROR
    }

    public C20755case(C20756do doVar, String str) {
        super(str);
    }

    public C20755case(C20756do doVar, String str, Throwable th) {
        super(str, th);
    }

    public C20755case(C20756do doVar, Throwable th) {
        super(th);
    }
}
