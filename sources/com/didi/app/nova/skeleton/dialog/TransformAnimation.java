package com.didi.app.nova.skeleton.dialog;

import android.view.View;
import android.view.ViewGroup;

public abstract class TransformAnimation {

    /* renamed from: a */
    boolean f10272a;

    /* renamed from: b */
    private boolean f10273b;

    public interface TransformAnimationListener {
        void onAnimationCompleted();
    }

    public abstract void completeAnimationImmediately();

    public abstract TransformAnimation copy();

    public abstract void onAbortPush();

    public abstract void performChange(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimationListener transformAnimationListener);

    public TransformAnimation() {
        this(true);
    }

    public TransformAnimation(boolean z) {
        this.f10273b = true;
        this.f10272a = false;
        this.f10273b = z;
    }

    public boolean removeFromViewOnEnter() {
        return this.f10273b;
    }
}
