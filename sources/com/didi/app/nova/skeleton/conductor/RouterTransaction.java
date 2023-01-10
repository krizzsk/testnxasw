package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import com.didi.app.nova.skeleton.conductor.internal.TransactionIndexer;

public class RouterTransaction {

    /* renamed from: c */
    private static int f10175c = -1;

    /* renamed from: d */
    private static final String f10176d = "RouterTransaction.controller.bundle";

    /* renamed from: e */
    private static final String f10177e = "RouterTransaction.pushControllerChangeHandler";

    /* renamed from: f */
    private static final String f10178f = "RouterTransaction.popControllerChangeHandler";

    /* renamed from: g */
    private static final String f10179g = "RouterTransaction.tag";

    /* renamed from: h */
    private static final String f10180h = "RouterTransaction.transactionIndex";

    /* renamed from: i */
    private static final String f10181i = "RouterTransaction.attachedToRouter";

    /* renamed from: a */
    final Controller f10182a;

    /* renamed from: b */
    int f10183b = f10175c;

    /* renamed from: j */
    private String f10184j;

    /* renamed from: k */
    private String f10185k;

    /* renamed from: l */
    private ControllerChangeHandler f10186l;

    /* renamed from: m */
    private ControllerChangeHandler f10187m;

    /* renamed from: n */
    private boolean f10188n;

    public static RouterTransaction with(Controller controller) {
        return new RouterTransaction(controller);
    }

    private RouterTransaction(Controller controller) {
        this.f10182a = controller;
    }

    RouterTransaction(Bundle bundle) {
        this.f10182a = Controller.m8841a(bundle.getBundle(f10176d));
        this.f10186l = ControllerChangeHandler.fromBundle(bundle.getBundle(f10177e));
        this.f10187m = ControllerChangeHandler.fromBundle(bundle.getBundle(f10178f));
        this.f10184j = bundle.getString(f10179g);
        this.f10183b = bundle.getInt(f10180h);
        this.f10188n = bundle.getBoolean(f10181i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45636a() {
        this.f10188n = true;
    }

    public Controller controller() {
        return this.f10182a;
    }

    public String tag() {
        return this.f10184j;
    }

    public RouterTransaction tag(String str) {
        if (!this.f10188n) {
            this.f10184j = str;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public String pageName() {
        return this.f10185k;
    }

    public RouterTransaction pageName(String str) {
        if (!this.f10188n) {
            this.f10185k = str;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public ControllerChangeHandler pushChangeHandler() {
        ControllerChangeHandler overriddenPushHandler = this.f10182a.getOverriddenPushHandler();
        return overriddenPushHandler == null ? this.f10186l : overriddenPushHandler;
    }

    public RouterTransaction pushChangeHandler(ControllerChangeHandler controllerChangeHandler) {
        if (!this.f10188n) {
            this.f10186l = controllerChangeHandler;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    public ControllerChangeHandler popChangeHandler() {
        ControllerChangeHandler overriddenPopHandler = this.f10182a.getOverriddenPopHandler();
        return overriddenPopHandler == null ? this.f10187m : overriddenPopHandler;
    }

    public RouterTransaction popChangeHandler(ControllerChangeHandler controllerChangeHandler) {
        if (!this.f10188n) {
            this.f10187m = controllerChangeHandler;
            return this;
        }
        throw new RuntimeException(getClass().getSimpleName() + "s can not be modified after being added to a Router.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45637a(TransactionIndexer transactionIndexer) {
        if (transactionIndexer == null) {
            throw new RuntimeException();
        } else if (this.f10183b == f10175c && transactionIndexer != null) {
            this.f10183b = transactionIndexer.nextIndex();
        }
    }

    public Bundle saveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f10176d, this.f10182a.mo45488e());
        ControllerChangeHandler controllerChangeHandler = this.f10186l;
        if (controllerChangeHandler != null) {
            bundle.putBundle(f10177e, controllerChangeHandler.mo45576a());
        }
        ControllerChangeHandler controllerChangeHandler2 = this.f10187m;
        if (controllerChangeHandler2 != null) {
            bundle.putBundle(f10178f, controllerChangeHandler2.mo45576a());
        }
        bundle.putString(f10179g, this.f10184j);
        bundle.putInt(f10180h, this.f10183b);
        bundle.putBoolean(f10181i, this.f10188n);
        return bundle;
    }
}
