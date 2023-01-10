package com.didi.entrega.manager;

import com.didi.entrega.manager.CustomerManagerRegistry;
import com.didi.entrega.manager.base.ICustomerManager;

public final class CustomerManagerLoader {

    /* renamed from: a */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f22675a = new CustomerManagerRegistry<>();

    /* renamed from: b */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f22676b = new CustomerManagerRegistry<>();

    private CustomerManagerLoader() {
    }

    public static void init() {
        CustomerManagerLoaderProxy.initManager();
    }

    public static <T extends ICustomerManager> T loadManager(Class<T> cls) {
        CustomerManagerWrapper customerManagerWrapper = f22675a.get(cls);
        if (customerManagerWrapper == null) {
            return f22676b.get(cls).getInnerManager();
        }
        return customerManagerWrapper.getInnerManager();
    }

    public static void start() {
        f22675a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.start();
            }
        });
    }

    public static void stop() {
        f22675a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.stop();
            }
        });
    }

    public static void destroy() {
        f22675a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.destroy();
            }
        });
        f22675a.clear();
    }

    /* renamed from: a */
    static void m18650a(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f22675a.register(cls, customerManagerWrapper);
        }
    }

    /* renamed from: b */
    static void m18651b(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f22676b.register(cls, customerManagerWrapper);
        }
    }
}
