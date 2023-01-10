package com.iproov.sdk.cameray;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.iproov.sdk.cameray.C20755case;
import com.iproov.sdk.cameray.C20776try;
import java.util.ArrayList;
import p235do.C21821case;
import p235do.C21822do;
import p235do.C21825goto;
import p235do.C21826if;
import p235do.C21829try;

/* renamed from: com.iproov.sdk.cameray.goto */
/* compiled from: CameraFactoryImpl */
public class C20765goto implements C20762else {

    /* renamed from: com.iproov.sdk.cameray.goto$do */
    /* compiled from: CameraFactoryImpl */
    static /* synthetic */ class C20766do {

        /* renamed from: do */
        static final /* synthetic */ int[] f56890do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.iproov.sdk.cameray.const[] r0 = com.iproov.sdk.cameray.C20759const.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f56890do = r0
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.C20759const.CAMERA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f56890do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.const r1 = com.iproov.sdk.cameray.C20759const.CAMERA2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.cameray.C20765goto.C20766do.<clinit>():void");
        }
    }

    /* renamed from: a */
    private C20763final m42905a(Context context) throws C20755case {
        ArrayList arrayList = new ArrayList();
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            if (cameraManager != null) {
                for (String str : cameraManager.getCameraIdList()) {
                    Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                    if (num != null) {
                        arrayList.add(new C21826if(arrayList.size(), m42903a(num.intValue()), str));
                    }
                }
            }
            return new C20763final(C20759const.CAMERA2, arrayList);
        } catch (CameraAccessException | RuntimeException e) {
            e.printStackTrace();
            throw new C20755case(C20755case.C20756do.CAMERA_ERROR, e.getLocalizedMessage());
        }
    }

    /* renamed from: do */
    public C20776try mo171316do(Context context, C21821case caseR, C20776try.C20777do doVar, C21829try tryR, C21825goto gotoR) throws C20755case {
        StringBuilder sb = new StringBuilder();
        sb.append("Camera selected: ");
        C21821case caseR2 = caseR;
        sb.append(caseR);
        if (caseR.mo180439if() != C20759const.CAMERA2) {
            return new C20760do(caseR.m48212new(), caseR.mo180437do(), doVar, tryR, gotoR);
        }
        return new C20767if(context, caseR.m48211for(), caseR.mo180437do(), doVar, tryR, gotoR);
    }

    /* renamed from: do */
    public C20757catch mo171314do(Context context) throws C20755case {
        C21821case a = m42905a(context).mo171317a();
        if (a == null) {
            return null;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(a.m48211for()).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue == 0) {
                        return C20757catch.CAMERA2_LIMITED;
                    }
                    if (intValue == 1) {
                        return C20757catch.CAMERA2_FULL;
                    }
                    if (intValue == 2) {
                        return C20757catch.CAMERA2_LEGACY;
                    }
                    if (intValue == 3) {
                        return C20757catch.CAMERA2_LEVEL3;
                    }
                    if (intValue == 4) {
                        return C20757catch.CAMERA2_EXTERNAL;
                    }
                }
            } catch (CameraAccessException | RuntimeException e) {
                e.printStackTrace();
                throw new C20755case(C20755case.C20756do.CAMERA_ERROR, e.getLocalizedMessage());
            }
        }
        return C20757catch.CAMERA1;
    }

    /* renamed from: do */
    public C20763final mo171315do(Context context, C20759const constR) throws C20755case {
        if (constR == null) {
            return null;
        }
        int i = C20766do.f56890do[constR.ordinal()];
        if (i == 1) {
            return m42904a();
        }
        if (i != 2) {
            return null;
        }
        return m42905a(context);
    }

    /* renamed from: a */
    private C20763final m42904a() {
        C20752break breakR;
        ArrayList arrayList = new ArrayList();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                breakR = C20752break.f56850if;
            } else {
                breakR = C20752break.f56849do;
            }
            arrayList.add(new C21822do(i, breakR));
        }
        return new C20763final(C20759const.CAMERA1, arrayList);
    }

    /* renamed from: a */
    private C20752break m42903a(int i) {
        if (i == 0) {
            return C20752break.f56849do;
        }
        if (i != 2) {
            return C20752break.f56850if;
        }
        return C20752break.EXTERNAL;
    }
}
