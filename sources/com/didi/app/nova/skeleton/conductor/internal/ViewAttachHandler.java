package com.didi.app.nova.skeleton.conductor.internal;

import android.view.View;
import android.view.ViewGroup;

public class ViewAttachHandler implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private boolean f10245a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f10246b = false;

    /* renamed from: c */
    private boolean f10247c = false;

    /* renamed from: d */
    private ReportedState f10248d = ReportedState.VIEW_DETACHED;

    /* renamed from: e */
    private ViewAttachListener f10249e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnAttachStateChangeListener f10250f;

    private interface ChildAttachListener {
        void onAttached();
    }

    private enum ReportedState {
        VIEW_DETACHED,
        ACTIVITY_STOPPED,
        ATTACHED
    }

    public interface ViewAttachListener {
        void onAttached();

        void onDetached(boolean z);

        void onViewDetachAfterStop();
    }

    public ViewAttachHandler(ViewAttachListener viewAttachListener) {
        this.f10249e = viewAttachListener;
    }

    public void onViewAttachedToWindow(View view) {
        if (!this.f10245a) {
            this.f10245a = true;
            m8994a(view, (ChildAttachListener) new ChildAttachListener() {
                public void onAttached() {
                    boolean unused = ViewAttachHandler.this.f10246b = true;
                    ViewAttachHandler.this.m8993a();
                }
            });
        }
    }

    public void onViewDetachedFromWindow(View view) {
        this.f10245a = false;
        if (this.f10246b) {
            this.f10246b = false;
            m8996a(false);
        }
    }

    public void listenForAttach(View view) {
        view.addOnAttachStateChangeListener(this);
    }

    public void unregisterAttachListener(View view) {
        view.removeOnAttachStateChangeListener(this);
        if (this.f10250f != null && (view instanceof ViewGroup)) {
            m8992a((ViewGroup) view).removeOnAttachStateChangeListener(this.f10250f);
        }
    }

    public void onActivityStarted() {
        this.f10247c = false;
        m8993a();
    }

    public void onActivityStopped() {
        this.f10247c = true;
        m8996a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8993a() {
        if (this.f10245a && this.f10246b && !this.f10247c && this.f10248d != ReportedState.ATTACHED) {
            this.f10248d = ReportedState.ATTACHED;
            this.f10249e.onAttached();
        }
    }

    /* renamed from: a */
    private void m8996a(boolean z) {
        boolean z2 = this.f10248d == ReportedState.ACTIVITY_STOPPED;
        if (z) {
            this.f10248d = ReportedState.ACTIVITY_STOPPED;
        } else {
            this.f10248d = ReportedState.VIEW_DETACHED;
        }
        if (!z2 || z) {
            this.f10249e.onDetached(z);
        } else {
            this.f10249e.onViewDetachAfterStop();
        }
    }

    /* renamed from: a */
    private void m8994a(View view, final ChildAttachListener childAttachListener) {
        if (!(view instanceof ViewGroup)) {
            childAttachListener.onAttached();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 0) {
            childAttachListener.onAttached();
            return;
        }
        this.f10250f = new View.OnAttachStateChangeListener() {
            boolean attached = false;

            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                if (!this.attached) {
                    this.attached = true;
                    childAttachListener.onAttached();
                    view.removeOnAttachStateChangeListener(this);
                    View.OnAttachStateChangeListener unused = ViewAttachHandler.this.f10250f = null;
                }
            }
        };
        m8992a(viewGroup).addOnAttachStateChangeListener(this.f10250f);
    }

    /* renamed from: a */
    private View m8992a(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return viewGroup;
        }
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        return childAt instanceof ViewGroup ? m8992a((ViewGroup) childAt) : childAt;
    }
}
