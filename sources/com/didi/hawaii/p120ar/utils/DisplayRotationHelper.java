package com.didi.hawaii.p120ar.utils;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.google.p223ar.core.Session;

/* renamed from: com.didi.hawaii.ar.utils.DisplayRotationHelper */
public final class DisplayRotationHelper implements DisplayManager.DisplayListener {

    /* renamed from: a */
    private boolean f25566a;

    /* renamed from: b */
    private int f25567b;

    /* renamed from: c */
    private int f25568c;

    /* renamed from: d */
    private final Display f25569d;

    /* renamed from: e */
    private final DisplayManager f25570e;

    /* renamed from: f */
    private final CameraManager f25571f;

    public void onDisplayAdded(int i) {
    }

    public void onDisplayRemoved(int i) {
    }

    public DisplayRotationHelper(Context context) {
        this.f25570e = (DisplayManager) context.getSystemService("display");
        this.f25571f = (CameraManager) context.getSystemService("camera");
        this.f25569d = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public void onResume() {
        this.f25570e.registerDisplayListener(this, (Handler) null);
    }

    public void onPause() {
        this.f25570e.unregisterDisplayListener(this);
    }

    public void onSurfaceChanged(int i, int i2) {
        this.f25567b = i;
        this.f25568c = i2;
        this.f25566a = true;
    }

    public void updateSessionIfNeeded(Session session) {
        if (this.f25566a) {
            session.setDisplayGeometry(this.f25569d.getRotation(), this.f25567b, this.f25568c);
            this.f25566a = false;
        }
    }

    public float getCameraSensorRelativeViewportAspectRatio(String str) {
        float f;
        int i;
        int cameraSensorToDisplayRotation = getCameraSensorToDisplayRotation(str);
        if (cameraSensorToDisplayRotation != 0) {
            if (cameraSensorToDisplayRotation != 90) {
                if (cameraSensorToDisplayRotation != 180) {
                    if (cameraSensorToDisplayRotation != 270) {
                        throw new RuntimeException("Unhandled rotation: " + cameraSensorToDisplayRotation);
                    }
                }
            }
            f = (float) this.f25568c;
            i = this.f25567b;
            return f / ((float) i);
        }
        f = (float) this.f25567b;
        i = this.f25568c;
        return f / ((float) i);
    }

    public int getCameraSensorToDisplayRotation(String str) {
        try {
            return ((((Integer) this.f25571f.getCameraCharacteristics(str).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - m20383a(this.f25569d.getRotation())) + 360) % 360;
        } catch (CameraAccessException e) {
            throw new RuntimeException("Unable to determine display orientation", e);
        }
    }

    /* renamed from: a */
    private int m20383a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return 180;
        }
        if (i == 3) {
            return 270;
        }
        throw new RuntimeException("Unknown rotation " + i);
    }

    public void onDisplayChanged(int i) {
        this.f25566a = true;
    }
}
