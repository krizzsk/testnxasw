package com.didichuxing.apollo.sdk;

public class ToggleResult {

    /* renamed from: a */
    private int f48259a = 0;

    /* renamed from: b */
    private IToggle f48260b;

    public ToggleResult(int i, IToggle iToggle) {
        this.f48259a = i;
        this.f48260b = iToggle;
    }

    public int getErrorNo() {
        return this.f48259a;
    }

    public void setErrorNo(int i) {
        this.f48259a = i;
    }

    public IToggle getToggle() {
        return this.f48260b;
    }

    public void setToggle(IToggle iToggle) {
        this.f48260b = iToggle;
    }
}
