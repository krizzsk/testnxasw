package com.didi.drouter.router;

import com.didi.drouter.store.RouterMeta;
import java.util.ArrayList;
import java.util.List;

public class RouterMonitor {

    /* renamed from: a */
    private static final List<IRouterMonitor> f21067a = new ArrayList();

    public static void register(IRouterMonitor iRouterMonitor) {
        f21067a.remove(iRouterMonitor);
        f21067a.add(iRouterMonitor);
    }

    public static void unregister(IRouterMonitor iRouterMonitor) {
        f21067a.remove(iRouterMonitor);
    }

    public static void handleRequest(Request request, RouterMeta routerMeta, String str) {
        for (IRouterMonitor next : f21067a) {
            if (next != null) {
                next.onRequest(request, routerMeta, str);
            }
        }
        if (routerMeta != null) {
            routerMeta.clearInterceptorHandled(request.getNumber());
        }
    }
}
