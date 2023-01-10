package com.didi.map.global.component.departure.model;

public class DeparturePickupSpotState {

    /* renamed from: a */
    private boolean f27469a;

    /* renamed from: b */
    private boolean f27470b;

    public boolean isValid() {
        return this.f27469a;
    }

    public void setValid(boolean z) {
        this.f27469a = z;
        if (!z) {
            this.f27470b = false;
        }
    }

    public boolean isChecked() {
        return this.f27470b;
    }

    public void setChecked(boolean z) {
        this.f27470b = z;
    }
}
