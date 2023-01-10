package com.didi.entrega.router;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.entrega.router.a */
/* compiled from: HubNode */
class C8811a {

    /* renamed from: a */
    private Route f22893a;

    /* renamed from: b */
    private WeakReference<IHubHandler> f22894b;

    /* renamed from: c */
    private List<IInterceptor> f22895c;

    /* renamed from: d */
    private List<C8811a> f22896d = new ArrayList();

    /* renamed from: e */
    private C8811a f22897e;

    C8811a(Route route, IHubHandler iHubHandler) {
        this.f22893a = Route.create(route);
        this.f22894b = new WeakReference<>(iHubHandler);
    }

    /* renamed from: a */
    public C8811a mo67679a(Route route) {
        if (this.f22893a.equals(route)) {
            return this;
        }
        for (C8811a next : this.f22896d) {
            if (route.equals(next.f22893a)) {
                return next;
            }
            if (route.isChild(next.f22893a)) {
                return next.mo67679a(route);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo67682a(C8811a aVar) {
        if (this.f22893a.equals(aVar.f22893a) || this.f22896d.contains(aVar)) {
            return false;
        }
        if (aVar.f22893a.isDirectChild(this.f22893a)) {
            aVar.f22897e = this;
            return this.f22896d.add(aVar);
        }
        for (int i = 0; i < this.f22896d.size(); i++) {
            if (aVar.f22893a.isChild(this.f22896d.get(i).f22893a)) {
                return this.f22896d.get(i).mo67682a(aVar);
            }
        }
        return false;
    }

    /* renamed from: b */
    public C8811a mo67684b(Route route) {
        C8811a aVar;
        C8811a a = mo67679a(route);
        if (a == null || (aVar = a.f22897e) == null) {
            return null;
        }
        aVar.f22896d.remove(a);
        a.f22897e = null;
        return a;
    }

    /* renamed from: a */
    public List<C8811a> mo67680a() {
        return this.f22896d;
    }

    /* renamed from: b */
    public IHubHandler mo67683b() {
        WeakReference<IHubHandler> weakReference = this.f22894b;
        if (weakReference != null) {
            return (IHubHandler) weakReference.get();
        }
        return null;
    }

    /* renamed from: c */
    public List<IInterceptor> mo67685c() {
        return this.f22895c;
    }

    /* renamed from: a */
    public void mo67681a(List<IInterceptor> list) {
        this.f22895c = list;
    }

    public int hashCode() {
        Route route = this.f22893a;
        return ((route == null ? 0 : route.hashCode()) * 17) + 31;
    }

    public boolean equals(Object obj) {
        Route route;
        if (obj instanceof C8811a) {
            C8811a aVar = (C8811a) obj;
            Route route2 = this.f22893a;
            if (!(route2 == null || (route = aVar.f22893a) == null)) {
                return route2.equals(route);
            }
        }
        return false;
    }

    public String toString() {
        return "HubNode[route:" + this.f22893a + ", hubHandler:" + mo67683b() + ", interceptors:" + this.f22895c + Const.jaRight;
    }
}
