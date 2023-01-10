package com.didichuxing.foundation.spi;

import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

public final class ServiceLoader<S> implements Iterable<S> {

    /* renamed from: a */
    private final Class<S> f50206a;

    /* renamed from: b */
    private final String f50207b;

    /* renamed from: c */
    private final Set<S> f50208c;

    public static final <S> ServiceLoader<S> load(Class<S> cls) {
        return new ServiceLoader<>(cls);
    }

    public static final <S> ServiceLoader<S> load(Class<S> cls, String str) {
        return new ServiceLoader<>(cls, str);
    }

    private ServiceLoader(Class<S> cls) {
        this(cls, (String) null);
    }

    public ServiceLoader(Class<S> cls, String str) {
        this.f50208c = new LinkedHashSet();
        this.f50206a = cls;
        this.f50207b = str;
        m37545a();
    }

    public S get() {
        Iterator<S> it = this.f50208c.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Iterator<S> iterator() {
        return Collections.unmodifiableSet(this.f50208c).iterator();
    }

    /* renamed from: a */
    private void m37545a() {
        for (Class cls : m37546b()) {
            try {
                this.f50208c.add(ServiceRegistry.m37547a(cls));
            } catch (Throwable th) {
                throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be initialized", th);
            }
        }
    }

    /* renamed from: b */
    private Set<Class<? extends S>> m37546b() {
        Set<Class<? extends S>> set = ServiceRegistry.get(this.f50206a);
        if (this.f50207b == null) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Class next : set) {
            ServiceProvider serviceProvider = (ServiceProvider) next.getAnnotation(ServiceProvider.class);
            if (serviceProvider != null && this.f50207b.equals(serviceProvider.alias())) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }
}
