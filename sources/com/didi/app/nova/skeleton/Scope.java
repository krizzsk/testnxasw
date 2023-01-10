package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public final class Scope {

    /* renamed from: g */
    private static final Object f10091g = new Object();

    /* renamed from: a */
    ServiceRegistry f10092a;

    /* renamed from: b */
    private String f10093b;

    /* renamed from: c */
    private Scope f10094c;

    /* renamed from: d */
    private Map<Class, Object> f10095d = new LinkedHashMap();

    /* renamed from: e */
    private Map<String, Scope> f10096e = new LinkedHashMap();

    /* renamed from: f */
    private boolean f10097f;

    public Scope(String str, Scope scope, ServiceRegistry serviceRegistry, List<Class> list) {
        this.f10093b = str;
        this.f10094c = scope;
        this.f10092a = serviceRegistry;
        if (TraceUtil.ENABLE) {
            TraceUtil.trace("Scope", getName() + " construct ");
        }
        for (Class put : list) {
            this.f10095d.put(put, f10091g);
        }
        if (scope != null) {
            scope.f10096e.put(str, this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45388a(List<Class> list) {
        for (Class next : list) {
            if (!this.f10095d.containsKey(next)) {
                this.f10095d.put(next, f10091g);
            }
        }
    }

    public void destroy() {
        if (TraceUtil.ENABLE) {
            TraceUtil.trace("Scope", getName() + " onDestroy ");
        }
        for (Map.Entry value : new HashSet(this.f10096e.entrySet())) {
            ((Scope) value.getValue()).destroy();
        }
        this.f10097f = true;
        Scope scope = this.f10094c;
        if (scope != null) {
            scope.f10096e.remove(getName());
        }
        for (Map.Entry next : this.f10095d.entrySet()) {
            if (!(next == null || next == f10091g)) {
                this.f10092a.releaseService(next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo45389a() {
        return this.f10097f;
    }

    public <T> T findService(Class cls) {
        return m8812a(this, cls);
    }

    /* renamed from: a */
    private <T> T m8812a(Scope scope, Class cls) {
        Scope scope2;
        T t = scope.f10095d.get(cls);
        if (t == f10091g) {
            T allocService = this.f10092a.allocService(cls);
            scope.f10095d.put(cls, allocService);
            return allocService;
        } else if (t == null && (scope2 = scope.f10094c) != null) {
            return m8812a(scope2, cls);
        } else {
            if (t != null) {
                return t;
            }
            throw new IllegalArgumentException("Service of " + cls.getName() + "  not declarat with annotation in scope");
        }
    }

    public String getName() {
        return this.f10093b;
    }

    public Scope getParent() {
        return this.f10094c;
    }

    public Scope findChild(String str) {
        return this.f10096e.get(str);
    }
}
