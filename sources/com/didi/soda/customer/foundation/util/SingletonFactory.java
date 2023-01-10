package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.CreateInstance;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public final class SingletonFactory {

    /* renamed from: a */
    private static final String f43852a = "SingletonFactory";

    /* renamed from: b */
    private static ConcurrentHashMap<Class<?>, Object> f43853b = new ConcurrentHashMap<>();

    private SingletonFactory() {
    }

    public static <T> T get(Class<T> cls) {
        return get(cls, (CreateInstance) null);
    }

    public static <T> T get(Class<T> cls, CreateInstance<T> createInstance) {
        T t;
        T t2 = f43853b.get(cls);
        if (t2 != null) {
            LogUtil.m32584d(f43852a, "SingletonFactory<" + cls.getSimpleName() + "> cache hit.");
            return t2;
        }
        if (createInstance == null) {
            LogUtil.m32584d(f43852a, "Create instance by createInstance()");
            t = m32707a(cls);
        } else {
            LogUtil.m32584d(f43852a, "Create instance by createInstance.create()");
            t = createInstance.create(cls);
        }
        f43853b.put(cls, t);
        return t;
    }

    public static void remove(Class<?> cls) {
        f43853b.remove(cls);
    }

    public static void clear() {
        f43853b.clear();
    }

    /* renamed from: a */
    private static <T> T m32707a(Class<T> cls) {
        T t;
        Constructor constructor;
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            t = null;
            if (i >= length) {
                constructor = null;
                break;
            }
            constructor = declaredConstructors[i];
            if (constructor.getParameterTypes().length == 0 && !constructor.isAccessible()) {
                constructor.setAccessible(true);
                break;
            }
            i++;
        }
        try {
            t = constructor.newInstance(new Object[0]);
            LogUtil.m32584d(f43852a, "Create storage instance: " + cls.getSimpleName());
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return t;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return t;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return t;
        }
    }
}
