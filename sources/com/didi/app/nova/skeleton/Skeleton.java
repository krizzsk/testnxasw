package com.didi.app.nova.skeleton;

import com.didi.app.nova.skeleton.internal.Const;
import com.didi.app.nova.skeleton.tools.TraceUtil;

public class Skeleton {

    /* renamed from: a */
    private static boolean f10101a = false;

    /* renamed from: b */
    private static boolean f10102b = false;

    /* renamed from: c */
    private static boolean f10103c = false;

    /* renamed from: d */
    private static ReferenceWatcher f10104d;

    /* renamed from: e */
    private static ServiceRegistry f10105e;

    public interface ReferenceWatcher {
        void logBreadcrumb(String str, String str2, String str3);

        void watch(Object obj);
    }

    public interface Tracer {
        void trace(String str, String str2);
    }

    public static ReferenceWatcher getReferenceWatcher() {
        return f10104d;
    }

    public static void setReferenceWatcher(ReferenceWatcher referenceWatcher) {
        f10104d = referenceWatcher;
    }

    public static void watchDeletedObject(Object obj) {
        if (obj != null && f10104d != null) {
            if (f10101a || f10102b) {
                f10104d.watch(obj);
            }
        }
    }

    public static void logBreadcrumb(String str, String str2, String str3) {
        ReferenceWatcher referenceWatcher = f10104d;
        if (referenceWatcher != null && f10103c) {
            if (str2 == null || str3 == null) {
                f10104d.logBreadcrumb(str, str, str);
            } else {
                referenceWatcher.logBreadcrumb(str, str2, str3);
            }
        }
    }

    public static void enableBreadcrumbLogging() {
        f10103c = true;
    }

    public static void enableLeakCanary() {
        f10101a = true;
    }

    public static void disableLeakCanary() {
        f10101a = false;
    }

    public static boolean isLeakCanaryEnabled() {
        return f10101a;
    }

    public static void enableULeakLifecycleTracking() {
        f10102b = true;
    }

    public static void disableULeakLifecycleTracking() {
        f10102b = false;
    }

    public static void setServiceRegistry(ServiceRegistry serviceRegistry) {
        f10105e = serviceRegistry;
    }

    public static ServiceRegistry getServiceRegistry() {
        return f10105e;
    }

    public static void enableRevealComponent(boolean z) {
        Const.ENABLE_REVEAL = z;
    }

    public static void enableAnnotationDsl(boolean z) {
        Const.ENABLE_ANNOTATION = z;
    }

    public static void enableAnnotationDslDebug(boolean z) {
        Const.ENABLE_ANNOTATION_DEBUG = z;
    }

    public static void setLifeTracer(Tracer tracer) {
        TraceUtil.ENABLE = tracer != null;
        TraceUtil.tracer = tracer;
    }
}
