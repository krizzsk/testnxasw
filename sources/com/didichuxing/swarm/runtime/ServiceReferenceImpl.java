package com.didichuxing.swarm.runtime;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class ServiceReferenceImpl<S> implements ServiceReference<S> {

    /* renamed from: a */
    private static final AtomicLong f51784a = new AtomicLong();

    /* renamed from: b */
    private final C17307b f51785b;

    /* renamed from: c */
    private final AbstractBundle f51786c;

    /* renamed from: d */
    private final Map<String, Object> f51787d = new HashMap(2);

    /* renamed from: e */
    private final ServiceRegistration<S> f51788e;

    /* renamed from: f */
    private final S f51789f;

    public int compareTo(Object obj) {
        return 0;
    }

    public Bundle[] getUsingBundles() {
        return new Bundle[0];
    }

    public boolean isAssignableTo(Bundle bundle, String str) {
        return false;
    }

    public ServiceReferenceImpl(C17307b bVar, AbstractBundle abstractBundle, S s, Dictionary<String, ?> dictionary, String[] strArr) {
        int i;
        Integer num = null;
        this.f51788e = new ServiceRegistrationImpl();
        this.f51785b = bVar;
        this.f51786c = abstractBundle;
        this.f51789f = s;
        if (dictionary != null) {
            Enumeration<String> keys = dictionary.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                this.f51787d.put(nextElement, dictionary.get(nextElement));
            }
        }
        num = dictionary != null ? (Integer) dictionary.get(Constants.SERVICE_RANKING) : num;
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        this.f51787d.put(Constants.OBJECTCLASS, strArr);
        this.f51787d.put(Constants.SERVICE_ID, Long.valueOf(f51784a.incrementAndGet()));
        this.f51787d.put(Constants.SERVICE_RANKING, Integer.valueOf(i));
    }

    public Object getProperty(String str) {
        return this.f51787d.get(str);
    }

    public String[] getPropertyKeys() {
        return (String[]) this.f51787d.keySet().toArray(new String[this.f51787d.size()]);
    }

    public Bundle getBundle() {
        return this.f51786c;
    }

    public C17307b getFramework() {
        return this.f51785b;
    }

    public S getService() {
        return this.f51789f;
    }

    public ServiceRegistration<?> getServiceRegistration() {
        return this.f51788e;
    }

    private final class ServiceRegistrationImpl implements ServiceRegistration<S> {
        public void setProperties(Dictionary<String, ?> dictionary) {
        }

        public void unregister() {
        }

        private ServiceRegistrationImpl() {
        }

        public ServiceReference<S> getReference() {
            return ServiceReferenceImpl.this;
        }
    }
}
