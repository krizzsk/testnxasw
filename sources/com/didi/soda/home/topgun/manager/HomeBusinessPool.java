package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import java.util.HashMap;
import java.util.Map;

public class HomeBusinessPool {

    /* renamed from: a */
    private static HomeBusinessPool f45479a = new HomeBusinessPool();

    /* renamed from: b */
    private Map<String, BusinessInfoEntity> f45480b = new HashMap();

    public static HomeBusinessPool getPool() {
        return f45479a;
    }

    public BusinessInfoEntity getBusiness(String str) {
        return this.f45480b.get(str);
    }

    public BusinessInfoEntity putBusiness(String str, BusinessInfoEntity businessInfoEntity) {
        return this.f45480b.put(str, businessInfoEntity);
    }

    public void clearBusiness() {
        this.f45480b.clear();
    }
}
