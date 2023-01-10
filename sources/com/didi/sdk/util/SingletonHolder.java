package com.didi.sdk.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonHolder {

    /* renamed from: a */
    private static final Logger f40403a = LoggerFactory.getLogger("SingletonHolder");

    /* renamed from: b */
    private static final ConcurrentHashMap<Class<?>, Object> f40404b = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> cls) {
        T t;
        T t2 = f40404b.get(cls);
        if (t2 != null) {
            return t2;
        }
        synchronized (cls) {
            t = f40404b.get(cls);
            if (t != null) {
                return t;
            }
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                t = declaredConstructor.newInstance(new Object[0]);
                f40404b.put(cls, t);
            } catch (Exception e) {
                Logger logger = f40403a;
                logger.error("Initialize class " + String.valueOf(cls) + " error", (Throwable) e);
            }
        }
        return t;
    }

    public static void destroy() {
        f40404b.clear();
    }
}
