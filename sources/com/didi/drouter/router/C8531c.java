package com.didi.drouter.router;

import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.drouter.router.c */
/* compiled from: ResultAgent */
class C8531c {

    /* renamed from: a */
    static final String f21070a = "DRouter_start_activity_request_number";

    /* renamed from: b */
    static final String f21071b = "not_found";

    /* renamed from: c */
    static final String f21072c = "timeout";

    /* renamed from: d */
    static final String f21073d = "error";

    /* renamed from: e */
    static final String f21074e = "stop_by_interceptor";

    /* renamed from: f */
    static final String f21075f = "stop_by_router_target";

    /* renamed from: g */
    static final String f21076g = "complete";

    /* renamed from: h */
    static final String f21077h = "request_cancel";

    /* renamed from: i */
    static final String f21078i = "redirect_by_interceptor";

    /* renamed from: j */
    static final String f21079j = "redirect_by_router_target";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Map<String, Result> f21080l = new ConcurrentHashMap();

    /* renamed from: k */
    Request f21081k;

    /* renamed from: m */
    private final Map<String, Request> f21082m = new ConcurrentHashMap();

    /* renamed from: n */
    private final Map<String, RouterMeta> f21083n = new ConcurrentHashMap();

    /* renamed from: o */
    private final Map<String, String> f21084o = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RouterCallback f21085p;

    C8531c(Request request, Map<Request, RouterMeta> map, Result result, RouterCallback routerCallback) {
        f21080l.put(request.getNumber(), result);
        this.f21081k = request;
        this.f21085p = routerCallback;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Request request2 = (Request) next.getKey();
                f21080l.put(request2.getNumber(), result);
                this.f21082m.put(request2.getNumber(), request2);
                this.f21083n.put(request2.getNumber(), next.getValue());
            }
        }
        if (request.f21051b != null) {
            request.f21051b.getLifecycle().addObserver(new ResultAgent$1(this, request));
        }
    }

    /* renamed from: a */
    static Request m17797a(String str) {
        Result c = m17805c(str);
        if (c != null) {
            return c.f21059a.f21082m.get(str);
        }
        return null;
    }

    /* renamed from: b */
    static RouterMeta m17803b(String str) {
        Result c = m17805c(str);
        if (c != null) {
            return c.f21059a.f21083n.get(str);
        }
        return null;
    }

    /* renamed from: c */
    static Result m17805c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f21080l.get(str);
    }

    /* renamed from: a */
    static void m17800a(Request request, String str) {
        if (request != null && m17805c(request.getNumber()) != null) {
            RouterMeta b = m17803b(request.getNumber());
            m17804b(request.getNumber(), str);
            RouterMonitor.handleRequest(request, b, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m17804b(String str, String str2) {
        synchronized (C8531c.class) {
            Result c = m17805c(str);
            if (c != null) {
                if (c.f21059a.f21081k.getNumber().equals(str)) {
                    if (c.f21059a.f21082m.size() > 1) {
                        RouterLogger.getCoreLogger().mo63952w("be careful, all request \"%s\" will be cleared", str);
                    }
                    for (String next : c.f21059a.f21082m.keySet()) {
                        if (!c.f21059a.f21084o.containsKey(next)) {
                            m17806c(next, str2);
                        }
                    }
                } else {
                    m17806c(str, str2);
                }
                if (c.f21059a.f21084o.size() == c.f21059a.f21082m.size()) {
                    m17801a(c);
                }
            }
        }
    }

    /* renamed from: c */
    private static synchronized void m17806c(String str, String str2) {
        synchronized (C8531c.class) {
            Result result = f21080l.get(str);
            if (result != null) {
                if ("timeout".equals(str2)) {
                    RouterLogger.getCoreLogger().mo63952w("request \"%s\" time out and force-complete", str);
                }
                result.f21059a.f21084o.put(str, str2);
                f21080l.remove(str);
                RouterLogger.getCoreLogger().mo63950d("==== request \"%s\" complete, reason \"%s\" ====", str, str2);
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m17801a(Result result) {
        synchronized (C8531c.class) {
            RouterLogger.getCoreLogger().mo63950d("primary request \"%s\" complete, all reason %s", result.f21059a.f21081k.getNumber(), result.f21059a.f21084o.toString());
            f21080l.remove(result.f21059a.f21081k.getNumber());
            if (result.f21059a.f21085p != null) {
                result.f21059a.f21085p.onResult(result);
            }
            if (!f21080l.containsKey(result.f21059a.f21081k.getNumber())) {
                RouterLogger.getCoreLogger().mo63950d("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", new Object[0]);
            }
        }
    }
}
