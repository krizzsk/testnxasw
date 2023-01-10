package com.didiglobal.p205sa.biz.component.sapanel.model;

import android.view.View;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.model.AnimationModel */
public class AnimationModel {

    /* renamed from: a */
    private View f53636a;

    /* renamed from: b */
    private int f53637b;

    /* renamed from: c */
    private float f53638c;

    /* renamed from: d */
    private boolean f53639d;

    /* renamed from: e */
    private int f53640e;

    public AnimationModel() {
    }

    public AnimationModel(View view, int i, float f, boolean z, int i2) {
        this.f53636a = view;
        this.f53637b = i;
        this.f53638c = f;
        this.f53639d = z;
        this.f53640e = i2;
    }

    public void setTarget(View view) {
        this.f53636a = view;
    }

    public void setProcess(int i) {
        this.f53637b = i;
    }

    public void setFraction(float f) {
        this.f53638c = f;
    }

    public void setExpand(boolean z) {
        this.f53639d = z;
    }

    public void setType(int i) {
        this.f53640e = i;
    }

    public View getTarget() {
        return this.f53636a;
    }

    public int getProcess() {
        return this.f53637b;
    }

    public float getFraction() {
        return this.f53638c;
    }

    public boolean isExpand() {
        return this.f53639d;
    }

    public int getType() {
        return this.f53640e;
    }
}
