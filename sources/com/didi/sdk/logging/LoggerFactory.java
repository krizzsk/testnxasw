package com.didi.sdk.logging;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import com.didi.sdk.logging.upload.UploadTaskManager;
import com.didi.sdk.logging.util.Objects;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class LoggerFactory {

    /* renamed from: a */
    static Map<String, WeakReference<Logger>> f39278a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final String f39279b = "global_app_logcat_filter";

    /* renamed from: c */
    private static LoggerConfig f39280c = LoggerConfig.newBuilder().build();

    /* renamed from: d */
    private static boolean f39281d;

    /* renamed from: e */
    private static boolean f39282e = false;

    /* renamed from: f */
    private static int f39283f = 99;

    /* renamed from: g */
    private static String f39284g = "";

    public static synchronized void init(Context context, LoggerConfig loggerConfig) {
        synchronized (LoggerFactory.class) {
            if (!f39281d) {
                f39281d = true;
                Objects.requireNonNull(context);
                Objects.requireNonNull(loggerConfig);
                f39280c = loggerConfig;
                LoggerContext.getDefault().init(context instanceof Application ? context : context.getApplicationContext());
                LoggerContext.getDefault().update(loggerConfig);
                IToggle toggle = Apollo.getToggle(f39279b, false);
                if (toggle.allow()) {
                    f39282e = true;
                    f39283f = ((Integer) toggle.getExperiment().getParam("level", 99)).intValue();
                    String str = (String) toggle.getExperiment().getParam("tag", "");
                    f39284g = str;
                    if (f39283f == 0 && TextUtils.isEmpty(str)) {
                        f39282e = false;
                    }
                }
                UploadTaskManager.getInstance().init(context);
            }
        }
    }

    public static boolean isInitial() {
        return f39281d;
    }

    public static LoggerConfig getConfig() {
        return f39280c;
    }

    public static Logger getLogger(Class<?> cls) {
        Objects.requireNonNull(cls);
        return getLogger(cls.getName(), NachoConstants.NACHO_ENTRYPOINT_NAME);
    }

    public static Logger getLogger(String str) {
        Objects.requireNonNull(str);
        return getLogger(str, NachoConstants.NACHO_ENTRYPOINT_NAME);
    }

    public static Logger getLogger(Class<?> cls, String str) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(str);
        return m29604a(cls.getName(), str, cls);
    }

    public static Logger getLogger(String str, String str2) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        return m29604a(str, str2, (Class<?>) null);
    }

    /* renamed from: a */
    private static Logger m29604a(String str, String str2, Class<?> cls) {
        Logger logger;
        String str3 = str + "-" + str2;
        WeakReference weakReference = f39278a.get(str3);
        if (weakReference != null && (logger = (Logger) weakReference.get()) != null) {
            return logger;
        }
        for (Map.Entry next : f39278a.entrySet()) {
            WeakReference weakReference2 = (WeakReference) next.getValue();
            if (weakReference2 == null || weakReference2.get() == null) {
                f39278a.remove(next.getKey());
            }
        }
        C13222c cVar = new C13222c(str, str2, f39280c);
        f39278a.put(str3, new WeakReference(cVar));
        return cVar;
    }

    public static int getFilterLevel() {
        return f39283f;
    }

    public static String getFilterTag() {
        return f39284g;
    }

    private LoggerFactory() {
    }
}
