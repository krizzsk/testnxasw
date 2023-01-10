package com.didi.drouter.router;

import android.os.Handler;
import android.os.HandlerThread;
import com.didi.drouter.utils.RouterLogger;

/* renamed from: com.didi.drouter.router.b */
/* compiled from: Monitor */
class C8530b {

    /* renamed from: a */
    private static Handler f21069a;

    C8530b() {
    }

    /* renamed from: a */
    static void m17796a(Request request, Result result) {
        long j = request.f21055f;
        if (j > 0) {
            m17795a();
            RouterLogger.getCoreLogger().mo63950d("monitor for request \"%s\" start, count down \"%sms\"", request.getNumber(), Long.valueOf(j));
            f21069a.postDelayed(new Monitor$1(request), j);
        }
    }

    /* renamed from: a */
    private static void m17795a() {
        if (f21069a == null) {
            synchronized (C8530b.class) {
                if (f21069a == null) {
                    HandlerThread handlerThread = new HandlerThread("timeout-monitor-thread");
                    handlerThread.start();
                    f21069a = new Handler(handlerThread.getLooper());
                }
            }
        }
    }
}
