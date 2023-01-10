package com.didi.soda.order.flutterpage;

import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/soda/order/flutterpage/OrderPage$orderServicePluginListener$1", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$orderServicePluginListener$1 implements OnCallPluginListener {
    final /* synthetic */ OrderPage this$0;

    OrderPage$orderServicePluginListener$1(OrderPage orderPage) {
        this.this$0 = orderPage;
    }

    public void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus(OrderServicePlugin.THIRD_PAY_SUCCESS, this.this$0.getPageId()))) {
            this.this$0.m34209i();
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("updateOrderInfoById", this.this$0.getPageId()))) {
            this.this$0.m34191a(onPluginResultListener);
        }
    }
}
