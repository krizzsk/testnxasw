package com.didi.entrega.customer.p114h5;

import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.VerticalChangeHandler;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import java.util.HashMap;

@Route({"verticalWebPage"})
/* renamed from: com.didi.entrega.customer.h5.CustomerVerticalWebPage */
public class CustomerVerticalWebPage extends CustomerWebPage {
    public CustomerVerticalWebPage() {
        DiRouter.registerHub("verticalWebPage", this);
    }

    public static void show(HashMap<String, String> hashMap) {
        DiRouter.request().path("verticalWebPage").putString("url", "https://food-c-h5.99app.com/${locale}/cart/coupon").putSerializable("params", hashMap).open();
    }

    public ControllerChangeHandler getPushHandler() {
        return new VerticalChangeHandler(false);
    }

    public ControllerChangeHandler getPopHandler() {
        return new VerticalChangeHandler(false);
    }
}
