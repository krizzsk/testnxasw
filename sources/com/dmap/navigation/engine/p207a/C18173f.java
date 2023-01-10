package com.dmap.navigation.engine.p207a;

import com.dmap.navigation.api.core.INaviPlannerInner;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.swig.NaviResponse;
import com.dmap.navigation.jni.swig.NaviRouteList;
import com.dmap.navigation.jni.swig.NaviToastInfoList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.f */
/* compiled from: SimpleNaviResponse */
public final class C18173f implements INaviPlannerInner.INaviResponse {

    /* renamed from: a */
    private final List<IRoute> f54313a;

    /* renamed from: b */
    private final int f54314b;

    /* renamed from: c */
    private final boolean f54315c;

    /* renamed from: d */
    private final byte[] f54316d;

    /* renamed from: e */
    private final byte[] f54317e;

    /* renamed from: f */
    private final Object f54318f;

    /* renamed from: g */
    private final int f54319g;

    public C18173f(Object obj, NaviResponse naviResponse) {
        this.f54318f = obj;
        this.f54314b = naviResponse.getErrorCode();
        this.f54315c = naviResponse.getMandatory();
        this.f54319g = naviResponse.getIsMultiRoute();
        this.f54316d = C18180m.m40466a(naviResponse.getTrafficEvent(), naviResponse.getTrafficEventSize());
        this.f54317e = C18180m.m40466a(naviResponse.getExtendData(), naviResponse.getExtendDataSize());
        NaviToastInfoList toastList = naviResponse.getToastList();
        ArrayList arrayList = new ArrayList((int) toastList.size());
        for (int i = 0; ((long) i) < toastList.size(); i++) {
            arrayList.add(new C18176i(toastList.get(i)));
        }
        NaviRouteList routes = naviResponse.getRoutes();
        int size = (int) routes.size();
        if (size > 0) {
            this.f54313a = new ArrayList(size);
            for (int i2 = 0; ((long) i2) < routes.size(); i2++) {
                this.f54313a.add(new C18174g(this, routes.get(i2), this.f54316d, this.f54317e, arrayList, this.f54315c ? 1 : 0));
            }
            return;
        }
        this.f54313a = null;
    }

    public final String toString() {
        return "SimpleNaviResponse{routeList=" + this.f54313a + ", errorCode=" + this.f54314b + ", mandatory=" + this.f54315c + ", trafficEventData=" + Arrays.toString(this.f54316d) + '}';
    }

    public final int getErrorCode() {
        return this.f54314b;
    }

    public final boolean isMandatory() {
        return this.f54315c;
    }

    public final int getIsMultiRoute() {
        return this.f54319g;
    }

    public final byte[] getTrafficEventData() {
        return this.f54316d;
    }

    public final List<IRoute> getRoutesList() {
        return this.f54313a;
    }
}
