package com.didi.app.nova.skeleton.conductor.changehandler;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class SimpleSwapChangeHandler extends ControllerChangeHandler implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static final String f10213a = "SimpleSwapChangeHandler.removesFromViewOnPush";

    /* renamed from: b */
    private boolean f10214b;

    /* renamed from: c */
    private boolean f10215c;

    /* renamed from: d */
    private ViewGroup f10216d;

    /* renamed from: e */
    private ControllerChangeHandler.ControllerChangeCompletedListener f10217e;

    public boolean isReusable() {
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
    }

    public SimpleSwapChangeHandler() {
        this(true);
    }

    public SimpleSwapChangeHandler(boolean z) {
        this.f10214b = z;
    }

    public void saveToBundle(Bundle bundle) {
        super.saveToBundle(bundle);
        bundle.putBoolean(f10213a, this.f10214b);
    }

    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        this.f10214b = bundle.getBoolean(f10213a);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f10215c = true;
    }

    public void completeImmediately() {
        ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener = this.f10217e;
        if (controllerChangeCompletedListener != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            this.f10217e = null;
            this.f10216d.removeOnAttachStateChangeListener(this);
            this.f10216d = null;
        }
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (!this.f10215c) {
            if (view != null && (!z || this.f10214b)) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
        }
        if (viewGroup.getWindowToken() != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            return;
        }
        this.f10217e = controllerChangeCompletedListener;
        this.f10216d = viewGroup;
        viewGroup.addOnAttachStateChangeListener(this);
    }

    public boolean removesFromViewOnPush() {
        return this.f10214b;
    }

    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener = this.f10217e;
        if (controllerChangeCompletedListener != null) {
            controllerChangeCompletedListener.onChangeCompleted();
            this.f10217e = null;
            this.f10216d = null;
        }
    }

    public ControllerChangeHandler copy() {
        return new SimpleSwapChangeHandler(removesFromViewOnPush());
    }
}
