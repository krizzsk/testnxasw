package com.didi.drouter.store;

import com.didi.drouter.router.IRouterHandler;

public class RouterRegister implements IRegister {

    /* renamed from: a */
    private RouterKey f21123a;

    /* renamed from: b */
    private IRouterHandler f21124b;

    /* renamed from: c */
    private ServiceKey<?> f21125c;

    /* renamed from: d */
    private Object f21126d;

    /* renamed from: e */
    private final boolean f21127e;

    public RouterRegister(RouterKey routerKey, IRouterHandler iRouterHandler, boolean z) {
        this.f21123a = routerKey;
        this.f21124b = iRouterHandler;
        this.f21127e = z;
    }

    public RouterRegister(ServiceKey<?> serviceKey, Object obj, boolean z) {
        this.f21125c = serviceKey;
        this.f21126d = obj;
        this.f21127e = z;
    }

    public void unregister() {
        if (this.f21127e) {
            RouterStore.m17826a(this.f21123a, this.f21124b);
            RouterStore.unregister(this.f21125c, this.f21126d);
        }
    }

    public boolean isSuccess() {
        return this.f21127e;
    }
}
