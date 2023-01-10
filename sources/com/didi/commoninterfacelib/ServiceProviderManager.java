package com.didi.commoninterfacelib;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceProviderManager {

    /* renamed from: a */
    private static ServiceProviderManager f12796a = new ServiceProviderManager();

    /* renamed from: b */
    private Map<Class, Object> f12797b = new ConcurrentHashMap();

    private ServiceProviderManager() {
    }

    public static ServiceProviderManager getInstance() {
        return f12796a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f12797b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f12797b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
