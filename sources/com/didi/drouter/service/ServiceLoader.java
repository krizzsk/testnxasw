package com.didi.drouter.service;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

public class ServiceLoader<T> {

    /* renamed from: a */
    private final ServiceAgent<T> f21096a;

    private ServiceLoader(Class<T> cls) {
        this.f21096a = new ServiceAgent<>(cls);
    }

    public static <T> ServiceLoader<T> build(Class<T> cls) {
        if (cls != null) {
            return new ServiceLoader<>(cls);
        }
        throw new RuntimeException("DRouter function class can't be null");
    }

    public ServiceLoader<T> setFilter(String str) {
        this.f21096a.mo63872a(str);
        return this;
    }

    public ServiceLoader<T> setAlias(String str) {
        this.f21096a.mo63872a(str);
        return this;
    }

    public ServiceLoader<T> setFeature(Object obj) {
        this.f21096a.mo63871a(obj);
        return this;
    }

    public ServiceLoader<T> setRemoteAuthority(String str) {
        this.f21096a.mo63876b(str);
        return this;
    }

    public ServiceLoader<T> setRemoteDeadResend(int i) {
        this.f21096a.mo63869a(i);
        return this;
    }

    public ServiceLoader<T> setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f21096a.mo63870a(lifecycleOwner);
        return this;
    }

    public ServiceLoader<T> setDefaultIfEmpty(T t) {
        this.f21096a.mo63875b(t);
        return this;
    }

    public T getService(Object... objArr) {
        return this.f21096a.mo63874b(objArr);
    }

    public List<T> getAllService(Object... objArr) {
        return this.f21096a.mo63868a(objArr);
    }

    public Class<? extends T> getServiceClass() {
        return this.f21096a.mo63873b();
    }

    public List<Class<? extends T>> getAllServiceClass() {
        return this.f21096a.mo63867a();
    }
}
