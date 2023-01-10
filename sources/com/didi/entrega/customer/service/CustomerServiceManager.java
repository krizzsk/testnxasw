package com.didi.entrega.customer.service;

import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CustomerServiceManager {

    /* renamed from: a */
    private static final String f22085a = "CustomerServiceManager";

    /* renamed from: b */
    private static final ConcurrentHashMap<Class, Class> f22086b = new ConcurrentHashMap<>();

    private CustomerServiceManager() {
    }

    public static void init(CustomerServiceIRegister customerServiceIRegister) {
        if (customerServiceIRegister != null && customerServiceIRegister.getRegisterService() != null && customerServiceIRegister.getRegisterService().size() > 0) {
            for (Map.Entry next : customerServiceIRegister.getRegisterService().entrySet()) {
                register((Class) next.getKey(), (Class) next.getValue());
            }
        }
    }

    public static <T extends IService> void register(Class<T> cls, Class cls2) {
        synchronized (f22086b) {
            f22086b.put(cls, cls2);
        }
        LogUtil.m18185i(f22085a, "Register service: " + cls2.getSimpleName());
    }

    public static <T extends IService> T getService(Class<T> cls) {
        Class cls2 = f22086b.get(cls);
        if (cls2 == null) {
            cls2 = CustomerServiceHelper.getRegisterService().get(cls);
            if (CustomerToolBoxUtil.DEBUG) {
                throw new IllegalStateException("You should register " + cls.getSimpleName() + " before call getService().");
            }
        }
        return (IService) SingletonFactory.get(cls2);
    }

    public static void clear() {
        synchronized (f22086b) {
            for (Class remove : f22086b.keySet()) {
                SingletonFactory.remove(remove);
            }
        }
    }
}
