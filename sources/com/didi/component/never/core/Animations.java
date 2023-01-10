package com.didi.component.never.core;

import com.taxis99.R;

public class Animations {

    /* renamed from: a */
    private int f16482a;

    /* renamed from: b */
    private int f16483b;

    /* renamed from: c */
    private int f16484c;

    /* renamed from: d */
    private int f16485d;

    public Animations() {
        this.f16482a = R.anim.comp_fragment_enter;
        this.f16483b = R.anim.comp_fragment_exit;
        this.f16484c = R.anim.comp_fragment_pop_enter;
        this.f16485d = R.anim.comp_fragment_pop_exit;
    }

    public Animations(int i, int i2, int i3, int i4) {
        this.f16482a = i;
        this.f16483b = i2;
        this.f16484c = i3;
        this.f16485d = i4;
    }

    public int enterAnim() {
        return this.f16482a;
    }

    public void setEnterAnim(int i) {
        this.f16482a = i;
    }

    public int exitAnim() {
        return this.f16483b;
    }

    public void setExitAnim(int i) {
        this.f16483b = i;
    }

    public int enterPopAnim() {
        return this.f16484c;
    }

    public void setEnterPopAnim(int i) {
        this.f16484c = i;
    }

    public int exitPopAnim() {
        return this.f16485d;
    }

    public void setExitPopAnim(int i) {
        this.f16485d = i;
    }
}
