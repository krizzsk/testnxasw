package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.Surface;
import java.util.List;
import p235do.C21823else;
import p235do.C21825goto;

/* renamed from: com.iproov.sdk.cameray.b */
/* compiled from: Camera2Request */
class C20751b {

    /* renamed from: a */
    private static final String f56847a = ("🎥2 " + C20751b.class.getSimpleName());

    /* renamed from: b */
    private CaptureRequest.Builder f56848b;

    C20751b(CameraDevice cameraDevice, C20764for forR, List<Surface> list, C21825goto gotoR, RectF rectF) throws CameraAccessException {
        this.f56848b = cameraDevice.createCaptureRequest(1);
        for (Surface addTarget : list) {
            this.f56848b.addTarget(addTarget);
        }
        this.f56848b.set(CaptureRequest.CONTROL_AF_MODE, 4);
        this.f56848b.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, forR.mo171322b());
        double d = gotoR.mo171492do(C20759const.CAMERA2, forR.m48063for());
        if (d > 1.0d) {
            this.f56848b.set(CaptureRequest.SCALER_CROP_REGION, C21823else.m45129do(forR.m48065try(), Double.valueOf(d)));
        }
        mo171295a(false);
        mo171293a(m42855a(rectF, forR.m48065try(), 1000));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171295a(boolean z) {
        this.f56848b.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z));
        this.f56848b.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(z));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171293a(MeteringRectangle meteringRectangle) {
        this.f56848b.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        StringBuilder sb = new StringBuilder();
        sb.append("Set metering area (");
        sb.append(meteringRectangle);
        sb.append(") OK");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171294a(Surface surface) {
        this.f56848b.removeTarget(surface);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CaptureRequest mo171292a() {
        return this.f56848b.build();
    }

    /* renamed from: a */
    public static MeteringRectangle m42855a(RectF rectF, Rect rect, int i) {
        return new MeteringRectangle(Math.max(0, (int) (rectF.left * ((float) rect.width()))), Math.max(0, (int) (rectF.top * ((float) rect.height()))), Math.min(rect.width(), (int) (rectF.width() * ((float) rect.width()))), Math.min(rect.height(), (int) (rectF.height() * ((float) rect.height()))), i);
    }
}
