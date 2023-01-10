package com.didi.soda.customer.app;

import android.text.TextUtils;
import com.didi.soda.address.edit.EditAddressInfoPage;
import com.didi.soda.address.page.SelectAddressPage;
import com.didi.soda.bill.page.CustomerBillPage;
import com.didi.soda.bill.page.EditRemarkPage;
import com.didi.soda.business.page.BusinessHomePage;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.goodsV2.page.GoodsPurchasePage;
import com.didi.soda.home.page.CustomerMainPage;
import com.didi.soda.home.page.HomeTopicPage;
import com.didi.soda.order.flutterpage.OrderPage;
import com.didi.soda.order.page.EditTipsPage;
import com.didi.soda.pay.PayMethodPage;
import com.didi.soda.router.HubTable;
import com.didi.soda.search.page.SearchHomePage;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.util.HashMap;
import java.util.Map;

public final class CustomerPageManager {

    /* renamed from: a */
    private static final String f42891a = "TimeMachine";

    /* renamed from: b */
    private Class<?> f42892b;

    /* renamed from: c */
    private Map<Class<?>, String> f42893c;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerPageManager INSTANCE = new CustomerPageManager();

        private Holder() {
        }
    }

    private CustomerPageManager() {
        this.f42893c = new HashMap();
        m32069a();
    }

    public static CustomerPageManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setCurrentPage(Class<?> cls) {
        LogUtil.m32584d(f42891a, "setCurrentPage = " + cls);
        this.f42892b = cls;
    }

    public String getCurrentPageName() {
        return getPageName(this.f42892b);
    }

    public String getPageName(Class<?> cls) {
        String str = this.f42893c.get(cls);
        return TextUtils.isEmpty(str) ? HubTable.getPageId(cls) : str;
    }

    /* renamed from: a */
    private void m32069a() {
        this.f42893c.put(CustomerMainPage.class, "1");
        this.f42893c.put(HomeTopicPage.class, "2");
        this.f42893c.put(SelectAddressPage.class, "3");
        this.f42893c.put(EditAddressInfoPage.class, "4");
        this.f42893c.put(SearchHomePage.class, "5");
        this.f42893c.put(BusinessHomePage.class, "12");
        this.f42893c.put(PayMethodPage.class, DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        this.f42893c.put(EditTipsPage.class, "16");
        this.f42893c.put(EditRemarkPage.class, DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
        this.f42893c.put(OrderPage.class, "20");
        this.f42893c.put(GoodsPurchasePage.class, ScarShareReportModel.CHANNEL_TWITTER);
        this.f42893c.put(CustomerBillPage.class, ScarShareReportModel.CHANNEL_MESSENGER);
    }
}
