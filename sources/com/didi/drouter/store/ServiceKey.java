package com.didi.drouter.store;

import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.service.IFeatureMatcher;

public class ServiceKey<T> {

    /* renamed from: a */
    Class<T> f21135a;

    /* renamed from: b */
    String f21136b = "";

    /* renamed from: c */
    IFeatureMatcher<?> f21137c;

    /* renamed from: d */
    LifecycleOwner f21138d;

    /* renamed from: e */
    RouterMeta f21139e;

    private ServiceKey() {
    }

    public static <T> ServiceKey<T> build(Class<T> cls) {
        ServiceKey<T> serviceKey = new ServiceKey<>();
        serviceKey.f21135a = cls;
        return serviceKey;
    }

    public ServiceKey<T> setAlias(String str) {
        if (str == null) {
            str = "";
        }
        this.f21136b = str;
        return this;
    }

    public ServiceKey<T> setFeature(IFeatureMatcher<?> iFeatureMatcher) {
        this.f21137c = iFeatureMatcher;
        return this;
    }

    public ServiceKey<T> setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f21138d = lifecycleOwner;
        return this;
    }
}
