package com.didi.raven.utils;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceUtils {
    public static final String IMEI = "imei_";

    /* renamed from: a */
    private static final AtomicBoolean f35876a = new AtomicBoolean(false);

    /* renamed from: b */
    private static Context f35877b;

    /* renamed from: c */
    private static String f35878c;

    /* renamed from: d */
    private static CustomIdSupplier f35879d;

    public interface CustomIdSupplier {
        String getCustomId();
    }

    public static void init(Context context) {
        init(context, true);
    }

    public static void init(Context context, boolean z) {
        if (!f35876a.getAndSet(true)) {
            m27056a(context);
            Context applicationContext = context.getApplicationContext();
            f35877b = applicationContext;
            if (applicationContext != null) {
                context = applicationContext;
            }
            f35877b = context;
        }
    }

    public static synchronized void setCustomIdSupplier(CustomIdSupplier customIdSupplier) {
        synchronized (DeviceUtils.class) {
            f35879d = customIdSupplier;
        }
    }

    public static synchronized String getDeviceId() {
        synchronized (DeviceUtils.class) {
            if (!f35876a.get()) {
                return "";
            }
            return "";
        }
    }

    /* renamed from: a */
    private static <T> T m27056a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
