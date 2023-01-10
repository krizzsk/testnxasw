package com.didi.beatles.p101im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* renamed from: com.didi.beatles.im.views.IMCheckableLinearLayout */
public class IMCheckableLinearLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    private static final int[] f11699a = {16842912};

    /* renamed from: b */
    private boolean f11700b = false;

    public IMCheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isChecked() {
        return this.f11700b;
    }

    public void setChecked(boolean z) {
        if (z != this.f11700b) {
            this.f11700b = z;
            refreshDrawableState();
        }
    }

    public void toggle() {
        setChecked(!this.f11700b);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f11699a);
        }
        return onCreateDrawableState;
    }
}
