package com.didi.beatles.p101im.protocol.service;

import android.text.TextUtils;
import com.didi.beatles.p101im.utils.IMLog;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.protocol.service.IMSpiServiceProvider */
public final class IMSpiServiceProvider {

    /* renamed from: a */
    private static final String f11416a = IMSpiServiceProvider.class.getSimpleName();

    /* renamed from: b */
    private static final String f11417b = "#";

    /* renamed from: c */
    private static final Map<String, SoftReference<?>> f11418c = new HashMap();

    public static <T extends IIMSpiProvider> T getService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        String canonicalName = cls.getCanonicalName();
        SoftReference softReference = f11418c.get(canonicalName);
        if (softReference == null || softReference.get() == null) {
            return registerService(cls);
        }
        String str = f11416a;
        IMLog.m10020d(str, "getService success: " + canonicalName);
        return (IIMSpiProvider) softReference.get();
    }

    public static <T extends IIMSpiProvider> T getService(Class<T> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a = m9874a(cls, str);
        SoftReference softReference = f11418c.get(a);
        if (softReference == null || softReference.get() == null) {
            return registerService(cls, str);
        }
        String str2 = f11416a;
        IMLog.m10020d(str2, "getService success: " + a);
        return (IIMSpiProvider) softReference.get();
    }

    /* renamed from: a */
    private static String m9874a(Class cls, String str) {
        return cls.getCanonicalName() + "#" + str;
    }

    public static <T extends IIMSpiProvider> T registerService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = (IIMSpiProvider) ServiceLoader.load(cls).get();
        if (t != null) {
            String str = f11416a;
            IMLog.m10020d(str, "registerService success: " + t.getClass().getCanonicalName());
            f11418c.put(cls.getCanonicalName(), new SoftReference(t));
        }
        return t;
    }

    public static <T extends IIMSpiProvider> T registerService(Class<T> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        T t = (IIMSpiProvider) ServiceLoader.load(cls, str).get();
        if (t != null) {
            String a = m9874a(cls, str);
            String str2 = f11416a;
            IMLog.m10020d(str2, "registerService success: " + a);
            f11418c.put(a, new SoftReference(t));
        }
        return t;
    }

    public static <T extends IIMSpiProvider> void unRegisterService(Class<T> cls) {
        if (cls != null) {
            String str = f11416a;
            IMLog.m10020d(str, "unRegisterService: " + cls.getCanonicalName());
            f11418c.remove(cls.getCanonicalName());
        }
    }

    public static <T extends IIMSpiProvider> void unRegisterService(Class<T> cls, String str) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            String a = m9874a(cls, str);
            String str2 = f11416a;
            IMLog.m10020d(str2, "unRegisterService: " + a);
            f11418c.remove(a);
        }
    }
}
