package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import com.iproov.sdk.cameray.C20755case;
import java.util.ArrayList;
import p235do.C21820break;
import p235do.C21827new;
import p235do.C21829try;

/* renamed from: com.iproov.sdk.cameray.for */
/* compiled from: Camera2Info */
public class C20764for implements C21827new {

    /* renamed from: a */
    private final String f56884a;

    /* renamed from: b */
    private final C20752break f56885b;

    /* renamed from: c */
    private final C21820break f56886c;

    /* renamed from: d */
    private final Float f56887d;

    /* renamed from: e */
    private final Range<Integer> f56888e;

    /* renamed from: f */
    private final Rect f56889f;

    /* renamed from: try  reason: not valid java name */
    protected final Orientation f62352try;

    C20764for(String str, C20752break breakR, CameraCharacteristics cameraCharacteristics, Float f, C21829try tryR) throws C20755case {
        this.f56884a = str;
        this.f56885b = breakR;
        this.f56887d = f;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        this.f56889f = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (streamConfigurationMap == null) {
            throw new C20755case(C20755case.C20756do.CAMERA_ERROR, "StreamConfiguration unavailable");
        } else if (num != null) {
            this.f62352try = Orientation.findByDegrees(num.intValue());
            ArrayList arrayList = new ArrayList();
            for (Size size : streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) {
                arrayList.add(new C21820break(size.getWidth(), size.getHeight()));
            }
            this.f56886c = tryR.mo171472do(C20759const.CAMERA2, arrayList);
            this.f56888e = C20774super.m42944a(cameraCharacteristics, 30);
        } else {
            throw new C20755case(C20755case.C20756do.CAMERA_ERROR, "Camera orientation unavailable");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C21820break mo171321a() {
        return new C21820break(this.f56886c.mo180435if(), this.f56886c.mo180432do());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Range<Integer> mo171322b() {
        return this.f56888e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo171323c() {
        return this.f56884a;
    }

    /* renamed from: do */
    public C20752break mo171310do() {
        return this.f56885b;
    }

    /* renamed from: for  reason: not valid java name */
    public Float m48063for() {
        return this.f56887d;
    }

    /* renamed from: if */
    public C21820break mo171312if() {
        return new C21820break(this.f56886c.mo180435if(), this.f56886c.mo180432do());
    }

    /* renamed from: new  reason: not valid java name */
    public Orientation m48064new() {
        return this.f62352try;
    }

    /* renamed from: try  reason: not valid java name */
    public Rect m48065try() {
        return this.f56889f;
    }
}
