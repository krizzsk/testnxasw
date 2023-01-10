package com.didi.soda.router;

import android.util.Log;
import com.didi.soda.router.Request;
import com.didi.soda.router.annotations.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DiRouter {
    public static final String ROUTER_DEFAULT_WEB_VIEW = "diRouter#webview";

    /* renamed from: b */
    private static final DiRouter f46205b = new DiRouter();

    /* renamed from: a */
    volatile Route f46206a;

    /* renamed from: c */
    private final Map<Route, C14945a> f46207c = new HashMap();

    /* renamed from: d */
    private IRouterCallback f46208d;

    /* renamed from: e */
    private IDowngradeHandler f46209e;

    private DiRouter() {
    }

    public static void init(String str, IRouterCallback iRouterCallback) {
        f46205b.f46206a = Route.parse(str);
        if (f46205b.f46206a.getScheme() != null) {
            f46205b.f46207c.clear();
            DiRouter diRouter = f46205b;
            diRouter.f46207c.put(diRouter.f46206a, new C14945a(f46205b.f46206a, (IHubHandler) null));
            f46205b.f46208d = iRouterCallback;
            return;
        }
        throw new IllegalArgumentException("scheme is illegal.");
    }

    public static void setDowngradeHandler(IDowngradeHandler iDowngradeHandler) {
        f46205b.f46209e = iDowngradeHandler;
    }

    public static void registerIndexHub(String str, Object obj) {
        if (obj != null && (obj instanceof IHubHandler) && !f46205b.f46207c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.equals(f46205b.f46206a)) {
                f46205b.f46207c.put(parse, new C14945a(parse, (IHubHandler) obj));
            }
        }
    }

    public static void registerHub(String str, Object obj) {
        DiRouter diRouter = f46205b;
        diRouter.m34347a(String.format("register hub:%s " + obj, new Object[]{str}), new Object[0]);
        if (obj != null && (obj instanceof IHubHandler) && !f46205b.f46207c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.getScheme() == null) {
                parse.setScheme(f46205b.f46206a.getScheme());
            } else if (!C14947c.m34381a(parse.getScheme(), f46205b.f46206a.getScheme())) {
                return;
            }
            if (parse.getHost() == null) {
                parse.setHost(f46205b.f46206a.getHost());
            } else if (!C14947c.m34381a(parse.getHost(), f46205b.f46206a.getHost())) {
                return;
            }
            DiRouter diRouter2 = f46205b;
            C14945a aVar = diRouter2.f46207c.get(diRouter2.f46206a);
            aVar.mo115228b(parse);
            aVar.mo115226a(new C14945a(parse, (IHubHandler) obj));
        }
    }

    public static Request.Builder request() {
        return new Request.Builder(f46205b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo115169a(Request request) {
        Response response = new Response(request);
        if (this.f46207c.isEmpty()) {
            response.mo115197a(-1);
            response.mo115199a("DiRouter not init.");
            return m34345a(response);
        }
        Route[] parents = request.mo115172a().parents();
        C14945a aVar = this.f46207c.get(this.f46206a);
        if (aVar.mo115227b() == null) {
            return m34344a(request, response, aVar);
        }
        C14945a aVar2 = aVar;
        int i = 0;
        while (i < parents.length) {
            C14945a a = m34346a(aVar2, parents[i], request, response);
            if (a == null) {
                return m34344a(request, response, aVar2);
            }
            i++;
            aVar2 = a;
        }
        if (aVar2.mo115227b() == null) {
            return m34344a(request, response, aVar);
        }
        if (request.getTarget() == null) {
            return m34344a(request, response, aVar2);
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
                        response.mo115197a(-5);
                        response.mo115199a("Route is Intercepted by " + iInterceptor);
                        return m34345a(response);
                    }
                    i2++;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        response.mo115197a(0);
        response.mo115199a("ok");
        aVar2.mo115227b().openRoute(request, response);
        m34347a("openRoute request[%s] %s", request.getPath(), response);
        return m34345a(response);
    }

    /* renamed from: a */
    private C14945a m34346a(C14945a aVar, Route route, Request request, Response response) {
        Class<?> a;
        Route route2;
        C14945a a2 = aVar.mo115223a(route);
        if (a2 == null || a2.mo115227b() == null) {
            if (aVar.mo115227b() == null || (a = HubTable.m34350a(route.getPath())) == null || !IHubHandler.class.isAssignableFrom(a)) {
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
                            response.mo115197a(-5);
                            response.mo115199a("Route is intercepted by " + iInterceptor);
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
            aVar.mo115227b().openRoute(new Request.Builder(this).path(route.getAbsolutePath()).params(request.getExtras()).build(), response);
            a2 = aVar.mo115223a(route);
            if (a2 != null) {
                a2.mo115225a((List<IInterceptor>) arrayList);
            }
        } else if (a2.mo115229c() != null) {
            for (IInterceptor next : a2.mo115229c()) {
                if (next.intercept(request, response)) {
                    response.mo115197a(-5);
                    response.mo115199a("Route is Intercepted by " + next);
                    return null;
                }
            }
        }
        return a2;
    }

    /* renamed from: a */
    private Response m34344a(Request request, Response response, C14945a aVar) {
        if (response.getCode() == -5) {
            return m34345a(response);
        }
        if (response.getCode() == -6) {
            return m34345a(response);
        }
        if (aVar == null) {
            response.mo115197a(-3);
            response.mo115199a("Not Found Hub for " + request.getPath());
        } else if (aVar.mo115227b() == null) {
            response.mo115197a(-4);
            response.mo115199a("Not Found hubHandler for " + aVar);
        } else {
            response.mo115197a(0);
            if (request.getTarget() != null) {
                aVar.mo115227b().openRoute(request, response);
            } else {
                IDowngradeHandler iDowngradeHandler = this.f46209e;
                if (iDowngradeHandler != null) {
                    Route downgrade = iDowngradeHandler.downgrade(Route.create(request.mo115172a()));
                    if (downgrade == null || downgrade.equals(request.mo115172a())) {
                        response.mo115197a(-6);
                        return m34345a(response);
                    } else if (!"http".equalsIgnoreCase(downgrade.getScheme()) && !"https".equalsIgnoreCase(downgrade.getScheme())) {
                        Request build = request().path(downgrade.getAbsolutePath()).build();
                        if (!request.mo115172a().equals(build.mo115172a())) {
                            return mo115169a(build);
                        }
                        response.mo115197a(-6);
                        return m34345a(response);
                    } else if (request.mo115174b()) {
                        return m34348b(aVar, downgrade, request, response);
                    } else {
                        response.mo115197a(-6);
                        return m34345a(response);
                    }
                } else if (request.mo115174b() && ("http".equalsIgnoreCase(request.mo115172a().getScheme()) || "https".equalsIgnoreCase(request.mo115172a().getScheme()))) {
                    return m34348b(aVar, request.mo115172a(), request, response);
                } else {
                    response.mo115197a(-6);
                    return m34345a(response);
                }
            }
        }
        return m34345a(response);
    }

    /* renamed from: b */
    private Response m34348b(C14945a aVar, Route route, Request request, Response response) {
        Request request2 = new Request(route, request.getExtras(), HubTable.m34350a("diRouter#webview"));
        request2.mo115173a(request.mo115174b());
        response.mo115198a(request2);
        aVar.mo115227b().openRoute(request2, response);
        return m34345a(response);
    }

    /* renamed from: a */
    private Response m34345a(Response response) {
        m34347a("finish request[%s] result[code:%s, message:%s]", response.getRequestPath(), Response.codeToString(response.getCode()), response.getMessage());
        IRouterCallback iRouterCallback = this.f46208d;
        if (iRouterCallback != null) {
            iRouterCallback.onRoute(response);
        }
        return response;
    }

    /* renamed from: a */
    private void m34347a(String str, Object... objArr) {
        try {
            Log.i("DiRouter", String.format(str, objArr));
        } catch (Exception unused) {
        }
    }

    public static void clear() {
        f46205b.f46207c.clear();
    }
}
