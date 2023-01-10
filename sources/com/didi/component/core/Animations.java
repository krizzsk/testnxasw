package com.didi.component.core;

import com.taxis99.R;

public class Animations {

    /* renamed from: a */
    private int f14572a;

    /* renamed from: b */
    private int f14573b;

    /* renamed from: c */
    private int f14574c;

    /* renamed from: d */
    private int f14575d;

    public Animations() {
        this.f14572a = R.anim.comp_fragment_enter;
        this.f14573b = R.anim.comp_fragment_exit;
        this.f14574c = R.anim.comp_fragment_pop_enter;
        this.f14575d = R.anim.comp_fragment_pop_exit;
    }

    public Animations(int i, int i2, int i3, int i4) {
        this.f14572a = i;
        this.f14573b = i2;
        this.f14574c = i3;
        this.f14575d = i4;
    }

    public int enterAnim() {
        return this.f14572a;
    }

    public void setEnterAnim(int i) {
        this.f14572a = i;
    }

    public int exitAnim() {
        return this.f14573b;
    }

    public void setExitAnim(int i) {
        this.f14573b = i;
    }

    public int enterPopAnim() {
        return this.f14574c;
    }

    public void setEnterPopAnim(int i) {
        this.f14574c = i;
    }

    public int exitPopAnim() {
        return this.f14575d;
    }

    public void setExitPopAnim(int i) {
        this.f14575d = i;
    }
}
