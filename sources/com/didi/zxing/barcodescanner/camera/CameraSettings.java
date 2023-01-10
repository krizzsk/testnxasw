package com.didi.zxing.barcodescanner.camera;

public class CameraSettings {

    /* renamed from: a */
    private int f48030a = -1;

    /* renamed from: b */
    private boolean f48031b = false;

    /* renamed from: c */
    private boolean f48032c = false;

    /* renamed from: d */
    private boolean f48033d = false;

    /* renamed from: e */
    private boolean f48034e = true;

    /* renamed from: f */
    private boolean f48035f = false;
    public FocusMode focusMode = FocusMode.AUTO;

    /* renamed from: g */
    private boolean f48036g = false;

    /* renamed from: h */
    private boolean f48037h = false;

    /* renamed from: i */
    private float f48038i = 2.0f;

    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public int getRequestedCameraId() {
        return this.f48030a;
    }

    public void setRequestedCameraId(int i) {
        this.f48030a = i;
    }

    public boolean isScanInverted() {
        return this.f48031b;
    }

    public void setScanInverted(boolean z) {
        this.f48031b = z;
    }

    public boolean isBarcodeSceneModeEnabled() {
        return this.f48032c;
    }

    public void setBarcodeSceneModeEnabled(boolean z) {
        this.f48032c = z;
    }

    public boolean isExposureEnabled() {
        return this.f48036g;
    }

    public void setExposureEnabled(boolean z) {
        this.f48036g = z;
    }

    public boolean isMeteringEnabled() {
        return this.f48033d;
    }

    public void setMeteringEnabled(boolean z) {
        this.f48033d = z;
    }

    public boolean isAutoFocusEnabled() {
        return this.f48034e;
    }

    public void setAutoFocusEnabled(boolean z) {
        this.f48034e = z;
        if (z && this.f48035f) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (z) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public boolean isContinuousFocusEnabled() {
        return this.f48035f;
    }

    public void setContinuousFocusEnabled(boolean z) {
        this.f48035f = z;
        if (z) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (this.f48034e) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public FocusMode getFocusMode() {
        return this.focusMode;
    }

    public void setFocusMode(FocusMode focusMode2) {
        this.focusMode = focusMode2;
    }

    public boolean isAutoTorchEnabled() {
        return this.f48037h;
    }

    public void setAutoTorchEnabled(boolean z) {
        this.f48037h = z;
    }

    public void setZoom(float f) {
        this.f48038i = f;
    }

    public float getZoom() {
        return this.f48038i;
    }
}
