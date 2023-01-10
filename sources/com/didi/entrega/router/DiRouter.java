package com.didi.entrega.router;

import com.didi.entrega.router.Request;
import com.didi.entrega.router.annotations.Route;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DiRouter {
    public static final String ROUTER_DEFAULT_WEB_VIEW = "diRouter#webview";

    /* renamed from: b */
    private static final DiRouter f22870b = new DiRouter();

    /* renamed from: a */
    volatile Route f22871a;

    /* renamed from: c */
    private final Map<Route, C8811a> f22872c = new HashMap();

    /* renamed from: d */
    private IRouterCallback f22873d;

    /* renamed from: e */
    private IDowngradeHandler f22874e;

    private DiRouter() {
    }

    public static void init(String str, IRouterCallback iRouterCallback) {
        f22870b.f22871a = Route.parse(str);
        if (f22870b.f22871a.getScheme() != null) {
            f22870b.f22872c.clear();
            DiRouter diRouter = f22870b;
            diRouter.f22872c.put(diRouter.f22871a, new C8811a(f22870b.f22871a, (IHubHandler) null));
            f22870b.f22873d = iRouterCallback;
            return;
        }
        throw new IllegalArgumentException("scheme is illegal.");
    }

    public static void setDowngradeHandler(IDowngradeHandler iDowngradeHandler) {
        f22870b.f22874e = iDowngradeHandler;
    }

    public static void registerIndexHub(String str, Object obj) {
        if (obj != null && (obj instanceof IHubHandler) && !f22870b.f22872c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.equals(f22870b.f22871a)) {
                f22870b.f22872c.put(parse, new C8811a(parse, (IHubHandler) obj));
            }
        }
    }

    public static void registerHub(String str, Object obj) {
        DiRouter diRouter = f22870b;
        diRouter.m18813a(String.format("register hub:%s " + obj, new Object[]{str}), new Object[0]);
        if (obj != null && (obj instanceof IHubHandler) && !f22870b.f22872c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.getScheme() == null) {
                parse.setScheme(f22870b.f22871a.getScheme());
            } else if (!C8813c.m18847a(parse.getScheme(), f22870b.f22871a.getScheme())) {
                return;
            }
            if (parse.getHost() == null) {
                parse.setHost(f22870b.f22871a.getHost());
            } else if (!C8813c.m18847a(parse.getHost(), f22870b.f22871a.getHost())) {
                return;
            }
            DiRouter diRouter2 = f22870b;
            C8811a aVar = diRouter2.f22872c.get(diRouter2.f22871a);
            aVar.mo67684b(parse);
            aVar.mo67682a(new C8811a(parse, (IHubHandler) obj));
        }
    }

    public static Request.Builder request() {
        return new Request.Builder(f22870b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo67624a(Request request) {
        Response response = new Response(request);
        if (this.f22872c.isEmpty()) {
            response.mo67653a(-1);
            response.mo67655a("DiRouter not init.");
            return m18811a(response);
        }
        Route[] parents = request.mo67627a().parents();
        C8811a aVar = this.f22872c.get(this.f22871a);
        if (aVar.mo67683b() == null) {
            return m18810a(request, response, aVar);
        }
        C8811a aVar2 = aVar;
        int i = 0;
        while (i < parents.length) {
            C8811a a = m18812a(aVar2, parents[i], request, response);
            if (a == null) {
                return m18810a(request, response, aVar2);
            }
            i++;
            aVar2 = a;
        }
        if (aVar2.mo67683b() == null) {
            return m18810a(request, response, aVar);
        }
        if (request.getTarget() == null) {
            return m18810a(request, response, aVar2);
        }
        Route route = (Route) request.getTarget().getAnnotation(Route.class);
        if (route.interceptors() != null && route.interceptors().length > 0) {
            Class[] interceptors = route.interceptors();
            int length = interceptors.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    IInterceptor iInterceptor = (IInterceptor) interceptors[i2].newInstance();
                    if (iInterceptor.intercept(request, response)) {
                        response.mo67653a(-5);
                        response.mo67655a("Route is Intercepted by " + iInterceptor);
                        return m18811a(response);
                    }
                    i2++;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        response.mo67653a(0);
        response.mo67655a("ok");
        aVar2.mo67683b().openRoute(request, response);
        m18813a("openRoute request[%s] %s", request.getPath(), response);
        return m18811a(response);
    }

    /* renamed from: a */
    private C8811a m18812a(C8811a aVar, Route route, Request request, Response response) {
        Class<?> a;
        Route route2;
        C8811a a2 = aVar.mo67679a(route);
        if (a2 == null || a2.mo67683b() == null) {
            if (aVar.mo67683b() == null || (a = HubTable.m18816a(route.getPath())) == null || !IHubHandler.class.isAssignableFrom(a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (a == null) {
                route2 = null;
            } else {
                route2 = (Route) a.getAnnotation(Route.class);
            }
            if (!(route2 == null || route2.interceptors() == null)) {
                int i = 0;
                while (i < route2.interceptors().length) {
                    try {
                        IInterceptor iInterceptor = (IInterceptor) route2.interceptors()[i].newInstance();
                        if (iInterceptor.intercept(request, response)) {
                            response.mo67653a(-5);
                            response.mo67655a("Route is intercepted by " + iInterceptor);
                            return null;
                        }
                        arrayList.add(iInterceptor);
                        i++;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
            aVar.mo67683b().openRoute(new Request.Builder(this).path(route.getAbsolutePath()).params(request.getExtras()).setFromPage(request.getFromPage()).build(), response);
            a2 = aVar.mo67679a(route);
            if (a2 != null) {
                a2.mo67681a((List<IInterceptor>) arrayList);
            }
        } else if (a2.mo67685c() != null) {
            for (IInterceptor next : a2.mo67685c()) {
                if (next.intercept(request, response)) {
                    response.mo67653a(-5);
                    response.mo67655a("Route is Intercepted by " + next);
                    return null;
                }
            }
        }
        return a2;
    }

    /* renamed from: a */
    private Response m18810a(Request request, Response response, C8811a aVar) {
        if (response.getCode() == -5) {
            return m18811a(response);
        }
        if (response.getCode() == -6) {
            return m18811a(response);
        }
        if (aVar == null) {
            response.mo67653a(-3);
            response.mo67655a("Not Found Hub for " + request.getPath());
        } else if (aVar.mo67683b() == null) {
            response.mo67653a(-4);
            response.mo67655a("Not Found hubHandler for " + aVar);
        } else {
            response.mo67653a(0);
            if (request.getTarget() != null) {
                aVar.mo67683b().openRoute(request, response);
            } else {
                IDowngradeHandler iDowngradeHandler = this.f22874e;
                if (iDowngradeHandler != null) {
                    Route downgrade = iDowngradeHandler.downgrade(Route.create(request.mo67627a()));
                    if (downgrade == null || downgrade.equals(request.mo67627a())) {
                        response.mo67653a(-6);
                        return m18811a(response);
                    } else if (!"http".equalsIgnoreCase(downgrade.getScheme()) && !"https".equalsIgnoreCase(downgrade.getScheme())) {
                        Request build = request().path(downgrade.getAbsolutePath()).build();
                        if (!request.mo67627a().equals(build.mo67627a())) {
                            return mo67624a(build);
                        }
                        response.mo67653a(-6);
                        return m18811a(response);
                    } else if (request.mo67629b()) {
                        return m18814b(aVar, downgrade, request, response);
                    } else {
                        response.mo67653a(-6);
                        return m18811a(response);
                    }
                } else if (request.mo67629b() && ("http".equalsIgnoreCase(request.mo67627a().getScheme()) || "https".equalsIgnoreCase(request.mo67627a().getScheme()))) {
                    return m18814b(aVar, request.mo67627a(), request, response);
                } else {
                    response.mo67653a(-6);
                    return m18811a(response);
                }
            }
        }
        return m18811a(response);
    }

    /* renamed from: b */
    private Response m18814b(C8811a aVar, Route route, Request request, Response response) {
        Request request2 = new Request(route, request.getExtras(), HubTable.m18816a("diRouter#webview"));
        request2.setFromPage(request.getFromPage());
        request2.mo67628a(request.mo67629b());
        response.mo67654a(request2);
        aVar.mo67683b().openRoute(request2, response);
        return m18811a(response);
    }

    /* renamed from: a */
    private Response m18811a(Response response) {
        m18813a("finish request[%s] result[code:%s, message:%s]", response.getRequestPath(), Response.codeToString(response.getCode()), response.getMessage());
        IRouterCallback iRouterCallback = this.f22873d;
        if (iRouterCallback != null) {
            iRouterCallback.onRoute(response);
        }
        return response;
    }

    /* renamed from: a */
    private void m18813a(String str, Object... objArr) {
        try {
            SystemUtils.log(4, "DiRouter", String.format(str, objArr), (Throwable) null, "com.didi.entrega.router.DiRouter", 318);
        } catch (Exception unused) {
        }
    }

    public static void clear() {
        f22870b.f22872c.clear();
    }
}
