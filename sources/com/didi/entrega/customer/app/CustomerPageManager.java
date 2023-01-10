package com.didi.entrega.customer.app;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.router.HubTable;
import java.util.HashMap;
import java.util.Map;

public final class CustomerPageManager {

    /* renamed from: a */
    private static final String f21634a = "TimeMachine";

    /* renamed from: b */
    private Class<?> f21635b;

    /* renamed from: c */
    private Map<Class<?>, String> f21636c;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerPageManager INSTANCE = new CustomerPageManager();

        private Holder() {
        }
    }

    private CustomerPageManager() {
        this.f21636c = new HashMap();
        m18088a();
    }

    public static CustomerPageManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setCurrentPage(Class<?> cls) {
        LogUtil.m18181d(f21634a, "setCurrentPage = " + cls);
        this.f21635b = cls;
    }

    public String getCurrentPageName() {
        return getPageName(this.f21635b);
    }

    public String getPageName(Class<?> cls) {
        String str = this.f21636c.get(cls);
        return TextUtils.isEmpty(str) ? HubTable.getPageId(cls) : str;
    }

    /* renamed from: a */
    private void m18088a() {
        this.f21636c.put(CustomerMainPage.class, "1");
    }
}
