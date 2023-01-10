package com.didi.entrega.manager;

import com.didi.entrega.customer.pay.CustomerPayManager;
import com.didi.entrega.home.manager.CustomerHomeManager;
import com.didi.entrega.info.manager.CustomerContactManager;
import com.didi.entrega.manager.base.ICustomerBillManager;
import com.didi.entrega.manager.base.ICustomerBillManagerDefault;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.manager.base.ICustomerHomeManager;
import com.didi.entrega.manager.base.ICustomerHomeManagerDefault;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.manager.base.ICustomerOrderManagerDefault;
import com.didi.entrega.manager.base.ICustomerPayManager;
import com.didi.entrega.manager.base.ICustomerPayManagerDefault;
import com.didi.entrega.order.manager.CustomerOrderManager;

public class CustomerManagerLoaderProxy {
    public static void initManager() {
        CustomerManagerLoader.m18651b(ICustomerOrderManager.class, new ICustomerOrderManagerDefault());
        CustomerManagerLoader.m18651b(ICustomerBillManager.class, new ICustomerBillManagerDefault());
        CustomerManagerLoader.m18651b(ICustomerHomeManager.class, new ICustomerHomeManagerDefault());
        CustomerManagerLoader.m18651b(ICustomerPayManager.class, new ICustomerPayManagerDefault());
        CustomerManagerLoader.m18650a(ICustomerOrderManager.class, new CustomerOrderManager());
        CustomerManagerLoader.m18650a(ICustomerHomeManager.class, new CustomerHomeManager());
        CustomerManagerLoader.m18650a(ICustomerContactManager.class, new CustomerContactManager());
        CustomerManagerLoader.m18650a(ICustomerPayManager.class, new CustomerPayManager());
    }
}
