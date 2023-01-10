package com.didi.soda.manager;

import com.didi.soda.address.manager.CustomerAddressManager;
import com.didi.soda.bill.CustomerBillManager;
import com.didi.soda.business.manager.CustomerBusinessManager;
import com.didi.soda.cart.CustomerCartManager;
import com.didi.soda.goodsV2.manager.CustomerGoodsManager;
import com.didi.soda.home.topgun.manager.CustomerHomeManager;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerAddressManagerDefault;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerBillManagerDefault;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import com.didi.soda.manager.base.ICustomerBusinessManagerDefault;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerCartManagerDefault;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.didi.soda.manager.base.ICustomerGoodsManagerDefault;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerHomeManagerDefault;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerOrderManagerDefault;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.manager.CustomerOrderManager;
import com.didi.soda.pay.CustomerPayManager;

public class CustomerManagerLoaderProxy {
    public static void initManager() {
        CustomerManagerLoader.m34046b(ICustomerBusinessManager.class, new ICustomerBusinessManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerBillManager.class, new ICustomerBillManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerHomeManager.class, new ICustomerHomeManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerOrderManager.class, new ICustomerOrderManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerGoodsManager.class, new ICustomerGoodsManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerAddressManager.class, new ICustomerAddressManagerDefault());
        CustomerManagerLoader.m34046b(ICustomerCartManager.class, new ICustomerCartManagerDefault());
        CustomerManagerLoader.m34045a(ICustomerBusinessManager.class, new CustomerBusinessManager());
        CustomerManagerLoader.m34045a(ICustomerPayManager.class, new CustomerPayManager());
        CustomerManagerLoader.m34045a(ICustomerBillManager.class, new CustomerBillManager());
        CustomerManagerLoader.m34045a(ICustomerHomeManager.class, new CustomerHomeManager());
        CustomerManagerLoader.m34045a(ICustomerOrderManager.class, new CustomerOrderManager());
        CustomerManagerLoader.m34045a(ICustomerGoodsManager.class, new CustomerGoodsManager());
        CustomerManagerLoader.m34045a(ICustomerAddressManager.class, new CustomerAddressManager());
        CustomerManagerLoader.m34045a(ICustomerCartManager.class, new CustomerCartManager());
    }
}
