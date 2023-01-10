package com.didi.share.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComponentManager {

    /* renamed from: a */
    private static ComponentManager f41336a = new ComponentManager();

    /* renamed from: b */
    private Map<Class, Object> f41337b = new ConcurrentHashMap();

    private ComponentManager() {
    }

    public static ComponentManager getInstance() {
        return f41336a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f41337b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f41337b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
