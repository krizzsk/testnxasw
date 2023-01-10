package com.didi.app.nova.skeleton.conductor.changehandler;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;

public class TransitionChangeHandlerCompat extends ControllerChangeHandler {

    /* renamed from: a */
    private static final String f10220a = "TransitionChangeHandlerCompat.changeHandler.class";

    /* renamed from: b */
    private static final String f10221b = "TransitionChangeHandlerCompat.changeHandler.state";

    /* renamed from: c */
    private ControllerChangeHandler f10222c;

    public TransitionChangeHandlerCompat() {
    }

    public TransitionChangeHandlerCompat(TransitionChangeHandler transitionChangeHandler, ControllerChangeHandler controllerChangeHandler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10222c = transitionChangeHandler;
        } else {
            this.f10222c = controllerChangeHandler;
        }
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        this.f10222c.performChange(viewGroup, view, view2, z, controllerChangeCompletedListener);
    }

    public void saveToBundle(Bundle bundle) {
        super.saveToBundle(bundle);
        bundle.putString(f10220a, this.f10222c.getClass().getName());
        Bundle bundle2 = new Bundle();
        this.f10222c.saveToBundle(bundle2);
        bundle.putBundle(f10221b, bundle2);
    }

    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        ControllerChangeHandler controllerChangeHandler = (ControllerChangeHandler) ClassUtils.newInstance(bundle.getString(f10220a));
        this.f10222c = controllerChangeHandler;
        controllerChangeHandler.restoreFromBundle(bundle.getBundle(f10221b));
    }

    public boolean removesFromViewOnPush() {
        return this.f10222c.removesFromViewOnPush();
    }

    public ControllerChangeHandler copy() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new TransitionChangeHandlerCompat((TransitionChangeHandler) this.f10222c.copy(), (ControllerChangeHandler) null);
        }
        return new TransitionChangeHandlerCompat((TransitionChangeHandler) null, this.f10222c.copy());
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        this.f10222c.onAbortPush(controllerChangeHandler, controller);
    }

    public void completeImmediately() {
        this.f10222c.completeImmediately();
    }

    public void setForceRemoveViewOnPush(boolean z) {
        this.f10222c.setForceRemoveViewOnPush(z);
    }
}
