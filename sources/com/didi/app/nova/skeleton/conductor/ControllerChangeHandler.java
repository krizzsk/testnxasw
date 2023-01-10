package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ControllerChangeHandler {

    /* renamed from: a */
    private static final String f10158a = "ControllerChangeHandler.className";

    /* renamed from: b */
    private static final String f10159b = "ControllerChangeHandler.savedState";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, ChangeHandlerData> f10160c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f10161d;

    /* renamed from: e */
    private boolean f10162e;

    public interface ControllerChangeCompletedListener {
        void onChangeCompleted();
    }

    public interface ControllerChangeListener {
        void onChangeCompleted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);

        void onChangeStarted(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);
    }

    public void completeImmediately() {
    }

    public boolean isReusable() {
        return false;
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
    }

    public abstract void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener);

    public boolean removesFromViewOnPush() {
        return true;
    }

    public void restoreFromBundle(Bundle bundle) {
    }

    public void saveToBundle(Bundle bundle) {
    }

    public ControllerChangeHandler() {
        m8892c();
    }

    public ControllerChangeHandler copy() {
        return fromBundle(mo45576a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Bundle mo45576a() {
        Bundle bundle = new Bundle();
        bundle.putString(f10158a, getClass().getName());
        Bundle bundle2 = new Bundle();
        saveToBundle(bundle2);
        bundle.putBundle(f10159b, bundle2);
        return bundle;
    }

    /* renamed from: c */
    private void m8892c() {
        try {
            getClass().getConstructor(new Class[0]);
        } catch (Exception unused) {
            throw new RuntimeException(getClass() + " does not have a default constructor.");
        }
    }

    public static ControllerChangeHandler fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ControllerChangeHandler controllerChangeHandler = (ControllerChangeHandler) ClassUtils.newInstance(bundle.getString(f10158a));
        controllerChangeHandler.restoreFromBundle(bundle.getBundle(f10159b));
        return controllerChangeHandler;
    }

    /* renamed from: a */
    static boolean m8890a(String str) {
        ChangeHandlerData changeHandlerData = f10160c.get(str);
        if (changeHandlerData == null) {
            return false;
        }
        changeHandlerData.changeHandler.completeImmediately();
        f10160c.remove(str);
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#completeHandlerImmediately [changeHandler=" + changeHandlerData.changeHandler + Const.jaRight);
        return true;
    }

    /* renamed from: a */
    static void m8886a(Controller controller, Controller controller2, ControllerChangeHandler controllerChangeHandler) {
        ChangeHandlerData changeHandlerData = f10160c.get(controller.getInstanceId());
        if (changeHandlerData != null) {
            if (changeHandlerData.isPush) {
                changeHandlerData.changeHandler.onAbortPush(controllerChangeHandler, controller2);
            } else {
                changeHandlerData.changeHandler.completeImmediately();
            }
            f10160c.remove(controller.getInstanceId());
        }
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#abortOrComplete [toAbort=" + controller + ", newController=" + controller2 + ", newChangeHandler=" + controllerChangeHandler + ", changeHandlerData=" + changeHandlerData + Const.jaRight);
    }

    /* renamed from: a */
    static void m8888a(ChangeTransaction changeTransaction) {
        m8887a(changeTransaction.f10163to, changeTransaction.from, changeTransaction.isPush, changeTransaction.container, changeTransaction.changeHandler, changeTransaction.listeners);
    }

    /* renamed from: a */
    private static void m8887a(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler, List<ControllerChangeListener> list) {
        View view;
        Controller controller3 = controller;
        Controller controller4 = controller2;
        boolean z2 = z;
        ViewGroup viewGroup2 = viewGroup;
        ControllerChangeHandler controllerChangeHandler2 = controllerChangeHandler;
        TraceUtil.trace("[Conductor]", "ControllerChangeHandler#executeChange [container=" + viewGroup2 + ", from=" + controller4 + ", to=" + controller3 + ", isPush=" + z2 + ", inHandler=" + controllerChangeHandler2 + Const.jaRight);
        if (viewGroup2 != null) {
            if (controllerChangeHandler2 == null) {
                controllerChangeHandler2 = new SimpleSwapChangeHandler();
            } else if (controllerChangeHandler2.f10162e && !controllerChangeHandler.isReusable()) {
                controllerChangeHandler2 = controllerChangeHandler.copy();
            }
            ControllerChangeHandler controllerChangeHandler3 = controllerChangeHandler2;
            controllerChangeHandler3.f10162e = true;
            if (controller4 != null) {
                if (z2) {
                    m8890a(controller2.getInstanceId());
                } else {
                    m8886a(controller4, controller3, controllerChangeHandler3);
                }
            }
            if (controller3 != null) {
                f10160c.put(controller.getInstanceId(), new ChangeHandlerData(controllerChangeHandler3, z2));
            }
            for (ControllerChangeListener onChangeStarted : list) {
                onChangeStarted.onChangeStarted(controller, controller2, z, viewGroup, controllerChangeHandler3);
            }
            final ControllerChangeType controllerChangeType = z2 ? ControllerChangeType.PUSH_ENTER : ControllerChangeType.POP_ENTER;
            final ControllerChangeType controllerChangeType2 = z2 ? ControllerChangeType.PUSH_EXIT : ControllerChangeType.POP_EXIT;
            View view2 = null;
            if (controller3 != null) {
                View a = controller3.mo45464a(viewGroup2);
                controller3.mo45473a(controllerChangeHandler3, controllerChangeType);
                view = a;
            } else {
                view = null;
            }
            if (controller4 != null) {
                view2 = controller2.getView();
                controller4.mo45473a(controllerChangeHandler3, controllerChangeType2);
            }
            View view3 = view2;
            final Controller controller5 = controller2;
            final ControllerChangeHandler controllerChangeHandler4 = controllerChangeHandler3;
            final Controller controller6 = controller;
            final List<ControllerChangeListener> list2 = list;
            final boolean z3 = z;
            final ViewGroup viewGroup3 = viewGroup;
            final View view4 = view3;
            controllerChangeHandler3.performChange(viewGroup, view3, view, z, new ControllerChangeCompletedListener() {
                public void onChangeCompleted() {
                    Controller controller;
                    View view;
                    ViewParent parent;
                    Controller controller2 = controller5;
                    if (controller2 != null) {
                        controller2.mo45480b(controllerChangeHandler4, controllerChangeType2);
                    }
                    if (controller6 != null) {
                        ControllerChangeHandler.f10160c.remove(controller6.getInstanceId());
                        controller6.mo45480b(controllerChangeHandler4, controllerChangeType);
                    }
                    for (ControllerChangeListener onChangeCompleted : list2) {
                        onChangeCompleted.onChangeCompleted(controller6, controller5, z3, viewGroup3, controllerChangeHandler4);
                    }
                    if (controllerChangeHandler4.f10161d && (view = view4) != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(view4);
                    }
                    if (controllerChangeHandler4.removesFromViewOnPush() && (controller = controller5) != null) {
                        controller.mo45476a(false);
                    }
                }
            });
        }
    }

    public void setForceRemoveViewOnPush(boolean z) {
        this.f10161d = z;
    }

    static class ChangeTransaction {
        final ControllerChangeHandler changeHandler;
        final ViewGroup container;
        final Controller from;
        final boolean isPush;
        final List<ControllerChangeListener> listeners;

        /* renamed from: to */
        final Controller f10163to;

        public ChangeTransaction(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler, List<ControllerChangeListener> list) {
            this.f10163to = controller;
            this.from = controller2;
            this.isPush = z;
            this.container = viewGroup;
            this.changeHandler = controllerChangeHandler;
            this.listeners = list;
        }
    }

    private static class ChangeHandlerData {
        public final ControllerChangeHandler changeHandler;
        public final boolean isPush;

        public ChangeHandlerData(ControllerChangeHandler controllerChangeHandler, boolean z) {
            this.changeHandler = controllerChangeHandler;
            this.isPush = z;
        }

        public String toString() {
            return super.toString() + "{changeHandler=" + this.changeHandler + "&isPush=" + this.isPush + "}";
        }
    }
}
