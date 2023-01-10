package com.didi.soda.router;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.soda.router.a */
/* compiled from: HubNode */
class C14945a {

    /* renamed from: a */
    private Route f46228a;

    /* renamed from: b */
    private WeakReference<IHubHandler> f46229b;

    /* renamed from: c */
    private List<IInterceptor> f46230c;

    /* renamed from: d */
    private List<C14945a> f46231d = new ArrayList();

    /* renamed from: e */
    private C14945a f46232e;

    C14945a(Route route, IHubHandler iHubHandler) {
        this.f46228a = Route.create(route);
        this.f46229b = new WeakReference<>(iHubHandler);
    }

    /* renamed from: a */
    public C14945a mo115223a(Route route) {
        if (this.f46228a.equals(route)) {
            return this;
        }
        for (C14945a next : this.f46231d) {
            if (route.equals(next.f46228a)) {
                return next;
            }
            if (route.isChild(next.f46228a)) {
                return next.mo115223a(route);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo115226a(C14945a aVar) {
        if (this.f46228a.equals(aVar.f46228a) || this.f46231d.contains(aVar)) {
            return false;
        }
        if (aVar.f46228a.isDirectChild(this.f46228a)) {
            aVar.f46232e = this;
            return this.f46231d.add(aVar);
        }
        for (int i = 0; i < this.f46231d.size(); i++) {
            if (aVar.f46228a.isChild(this.f46231d.get(i).f46228a)) {
                return this.f46231d.get(i).mo115226a(aVar);
            }
        }
        return false;
    }

    /* renamed from: b */
    public C14945a mo115228b(Route route) {
        C14945a aVar;
        C14945a a = mo115223a(route);
        if (a == null || (aVar = a.f46232e) == null) {
            return null;
        }
        aVar.f46231d.remove(a);
        a.f46232e = null;
        return a;
    }

    /* renamed from: a */
    public List<C14945a> mo115224a() {
        return this.f46231d;
    }

    /* renamed from: b */
    public IHubHandler mo115227b() {
        WeakReference<IHubHandler> weakReference = this.f46229b;
        if (weakReference != null) {
            return (IHubHandler) weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public List<IInterceptor> mo115229c() {
        return this.f46230c;
    }

    /* renamed from: a */
    public void mo115225a(List<IInterceptor> list) {
        this.f46230c = list;
    }

    public int hashCode() {
        Route route = this.f46228a;
        return ((route == null ? 0 : route.hashCode()) * 17) + 31;
    }

    public boolean equals(Object obj) {
        Route route;
        if (obj instanceof C14945a) {
            C14945a aVar = (C14945a) obj;
            Route route2 = this.f46228a;
            if (!(route2 == null || (route = aVar.f46228a) == null)) {
                return route2.equals(route);
            }
        }
        return false;
    }

    public String toString() {
        return "HubNode[route:" + this.f46228a + ", hubHandler:" + mo115227b() + ", interceptors:" + this.f46230c + Const.jaRight;
    }
}
