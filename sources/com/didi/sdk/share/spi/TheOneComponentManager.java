package com.didi.sdk.share.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheOneComponentManager {

    /* renamed from: a */
    private static TheOneComponentManager f39881a = new TheOneComponentManager();

    /* renamed from: b */
    private Map<Class, Object> f39882b = new ConcurrentHashMap();

    private TheOneComponentManager() {
    }

    public static TheOneComponentManager getInstance() {
        return f39881a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f39882b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f39882b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
