package com.didi.universal.pay.sdk.util;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceLoaderUtil {

    /* renamed from: a */
    private Map<Class, Object> f47789a;

    private ServiceLoaderUtil() {
        this.f47789a = new ConcurrentHashMap();
    }

    public static ServiceLoaderUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        /* access modifiers changed from: private */
        public static ServiceLoaderUtil INSTANCE = new ServiceLoaderUtil();

        private SingleHolder() {
        }
    }

    public <S> S getComponent(Class<S> cls, String str) {
        S s = this.f47789a.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls, str).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f47789a.put(cls, next);
        return next;
    }
}
