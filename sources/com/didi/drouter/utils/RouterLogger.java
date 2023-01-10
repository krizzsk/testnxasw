package com.didi.drouter.utils;

import android.util.Log;
import android.widget.Toast;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;

public class RouterLogger {
    public static final String NAME = "DRouterCore";

    /* renamed from: a */
    private static IRouterLogger f21143a = new InnerLogger();

    /* renamed from: b */
    private static final RouterLogger f21144b = new RouterLogger(NAME);

    /* renamed from: c */
    private static final RouterLogger f21145c = new RouterLogger("DRouterApp");

    /* renamed from: d */
    private final String f21146d;

    private RouterLogger(String str) {
        this.f21146d = str;
    }

    public static void setLogger(IRouterLogger iRouterLogger) {
        f21143a = iRouterLogger;
    }

    public static RouterLogger getAppLogger() {
        return f21145c;
    }

    public static RouterLogger getCoreLogger() {
        return f21144b;
    }

    /* renamed from: d */
    public void mo63950d(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f21143a) != null) {
            iRouterLogger.mo63944d(this.f21146d, m17836b(str, objArr));
        }
    }

    /* renamed from: w */
    public void mo63952w(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f21143a) != null) {
            iRouterLogger.mo63946w(this.f21146d, m17836b(str, objArr));
        }
    }

    /* renamed from: e */
    public void mo63951e(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (str != null && (iRouterLogger = f21143a) != null) {
            iRouterLogger.mo63945e(this.f21146d, m17836b(str, objArr));
        }
    }

    public void crash(String str, Object... objArr) {
        IRouterLogger iRouterLogger;
        if (!(str == null || (iRouterLogger = f21143a) == null)) {
            String str2 = this.f21146d;
            iRouterLogger.mo63945e(str2, m17836b(str, objArr) + "\n Exception:" + Log.getStackTraceString(new Throwable()));
        }
        throw new RuntimeException(str);
    }

    public static void toast(final String str, final Object... objArr) {
        RouterExecutor.main(new Runnable() {
            public void run() {
                SystemUtils.showToast(Toast.makeText(DRouter.getContext(), RouterLogger.m17836b(str, objArr), 0));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m17836b(String str, Object... objArr) {
        if (objArr == null) {
            return str;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] instanceof Throwable) {
                objArr[i] = Log.getStackTraceString(objArr[i]);
            }
        }
        return String.format(str, objArr);
    }

    private static class InnerLogger implements IRouterLogger {
        private InnerLogger() {
        }

        /* renamed from: d */
        public void mo63944d(String str, String str2) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 85);
        }

        /* renamed from: w */
        public void mo63946w(String str, String str2) {
            SystemUtils.log(5, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 90);
        }

        /* renamed from: e */
        public void mo63945e(String str, String str2) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.drouter.utils.RouterLogger$InnerLogger", 95);
        }
    }
}
