package com.didi.soda.customer.service;

import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CustomerServiceManager {

    /* renamed from: a */
    private static final String f43997a = "CustomerServiceManager";

    /* renamed from: b */
    private static final ConcurrentHashMap<Class, Class> f43998b = new ConcurrentHashMap<>();

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
        synchronized (f43998b) {
            f43998b.put(cls, cls2);
        }
        LogUtil.m32588i(f43997a, "Register service: " + cls2.getSimpleName());
    }

    public static <T extends IService> T getService(Class<T> cls) {
        Class cls2 = f43998b.get(cls);
        if (cls2 == null) {
            cls2 = CustomerServiceHelper.getRegisterService().get(cls);
            if (CustomerToolBoxUtil.DEBUG) {
                throw new IllegalStateException("You should register " + cls.getSimpleName() + " before call getService().");
            }
        }
        return (IService) SingletonFactory.get(cls2);
    }

    public static void clear() {
        synchronized (f43998b) {
            for (Class remove : f43998b.keySet()) {
                SingletonFactory.remove(remove);
            }
        }
    }
}
