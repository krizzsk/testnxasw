package com.didi.soda.manager;

import com.didi.soda.manager.CustomerManagerRegistry;
import com.didi.soda.manager.base.ICustomerManager;

public final class CustomerManagerLoader {

    /* renamed from: a */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f45908a = new CustomerManagerRegistry<>();

    /* renamed from: b */
    private static CustomerManagerRegistry<Class, CustomerManagerWrapper> f45909b = new CustomerManagerRegistry<>();

    private CustomerManagerLoader() {
    }

    public static void init() {
        CustomerManagerLoaderProxy.initManager();
    }

    public static <T extends ICustomerManager> T loadManager(Class<T> cls) {
        CustomerManagerWrapper customerManagerWrapper = f45908a.get(cls);
        if (customerManagerWrapper == null) {
            return f45909b.get(cls).getInnerManager();
        }
        return customerManagerWrapper.getInnerManager();
    }

    public static void start() {
        f45908a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.start();
            }
        });
    }

    public static void stop() {
        f45908a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.stop();
            }
        });
    }

    public static void destroy() {
        f45908a.iterator(new CustomerManagerRegistry.Iterator<Class, CustomerManagerWrapper>() {
            public void entry(Class cls, CustomerManagerWrapper customerManagerWrapper) {
                customerManagerWrapper.destroy();
            }
        });
        f45908a.clear();
    }

    /* renamed from: a */
    static void m34045a(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f45908a.register(cls, customerManagerWrapper);
        }
    }

    /* renamed from: b */
    static void m34046b(Class<? extends ICustomerManager> cls, ICustomerManager iCustomerManager) {
        if (iCustomerManager != null) {
            CustomerManagerWrapper customerManagerWrapper = new CustomerManagerWrapper(iCustomerManager);
            customerManagerWrapper.create();
            f45909b.register(cls, customerManagerWrapper);
        }
    }
}
