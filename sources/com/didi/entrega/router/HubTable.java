package com.didi.entrega.router;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.address.list.SelectAddressPage;
import com.didi.entrega.bill.page.BillTipPage;
import com.didi.entrega.bill.page.CustomerBillPage;
import com.didi.entrega.bill.page.CustomerRulePage;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import com.didi.entrega.customer.p114h5.CustomerPhotoTransferPage;
import com.didi.entrega.customer.p114h5.CustomerVerticalWebPage;
import com.didi.entrega.customer.p114h5.CustomerWebPage;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.home.page.HomeCityListPage;
import com.didi.entrega.home.page.ServiceNotifyPage;
import com.didi.entrega.info.page.EditReceivePage;
import com.didi.entrega.info.page.EditSendPage;
import com.didi.entrega.info.page.EditStuffPage;
import com.didi.entrega.order.debt.DebtOrderPayPage;
import com.didi.entrega.order.page.OrderPage;
import com.didi.entrega.orderlist.page.OrderListPage;
import com.didi.entrega.pay.PayMethodPage;
import com.didi.entrega.security.SecurityPage;
import java.util.HashMap;
import java.util.Map;

public final class HubTable {

    /* renamed from: a */
    private static HashMap<String, Class<?>> f22875a = new HashMap<>();

    /* renamed from: b */
    private static Map<Class<?>, String> f22876b = new HashMap();

    static {
        m18817a("taxis99OneTravel://sodaEntrega", CustomerMainPage.class);
        m18817a("citySelectPage", HomeCityListPage.class);
        m18817a("flutterCommonPage", CustomerFlutterPage.class);
        m18817a(RoutePath.BILL_PAGE, CustomerBillPage.class);
        m18817a("addressListPage", SelectAddressPage.class);
        m18817a("payMethodPage", PayMethodPage.class);
        m18817a(RoutePath.EDIT_SEND_PAGE, EditSendPage.class);
        m18817a(RoutePath.EDIT_RECEIVE_PAGE, EditReceivePage.class);
        m18817a(RoutePath.EDIT_STUFF_PAGE, EditStuffPage.class);
        m18817a(RoutePath.SERVICE_NOTIFY_PAGE, ServiceNotifyPage.class);
        m18817a("debtOrderPayPage", DebtOrderPayPage.class);
        m18817a("orderPage", OrderPage.class);
        m18817a("securityPage", SecurityPage.class);
        m18817a("orderListPage", OrderListPage.class);
        m18817a("priceRuleDescPage", CustomerRulePage.class);
        m18817a("verticalWebPage", CustomerVerticalWebPage.class);
        m18817a("billTipPage", BillTipPage.class);
        m18817a("webPage", CustomerWebPage.class);
        m18817a("WebPage/Transfer_Page", CustomerPhotoTransferPage.class);
    }

    private HubTable() {
    }

    public static String getPageId(Class<?> cls) {
        return f22876b.get(cls);
    }

    public static String getPageId(ScopeContext scopeContext) {
        return (String) scopeContext.getObject("ScopeContextPageId");
    }

    public static void registerExternalScheme(String str, Class<?> cls) {
        f22875a.put(str, cls);
    }

    /* renamed from: a */
    static Class<?> m18816a(String str) {
        return f22875a.get(str);
    }

    /* renamed from: a */
    private static void m18817a(String str, Class<?> cls) {
        f22875a.put(str, cls);
        if ("taxis99OneTravel://sodaEntrega".equals(str)) {
            f22876b.put(cls, "homePage");
        } else {
            f22876b.put(cls, str);
        }
    }
}
