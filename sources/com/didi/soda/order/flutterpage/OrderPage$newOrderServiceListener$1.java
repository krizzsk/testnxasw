package com.didi.soda.order.flutterpage;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogCallBack;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogComponent;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.order.component.contact.OrderContactUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"com/didi/soda/order/flutterpage/OrderPage$newOrderServiceListener$1", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$newOrderServiceListener$1 implements OnCallPluginListener {
    final /* synthetic */ OrderPage this$0;

    OrderPage$newOrderServiceListener$1(OrderPage orderPage) {
        this.this$0 = orderPage;
    }

    public void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus(NewOrderServicePlugin.GO_APP_STORE_RATE, this.this$0.getPageId()))) {
            this.this$0.goAppStoreRate();
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("contactIM", this.this$0.getPageId()))) {
            if (map != null) {
                OrderContactUtil.Companion companion = OrderContactUtil.Companion;
                ScopeContext scopeContext = this.this$0.getScopeContext();
                Object obj = map.get("orderid");
                if (obj != null) {
                    String str2 = (String) obj;
                    Object obj2 = map.get(Const.PageParams.CONTACT_TYPE);
                    if (obj2 != null) {
                        int intValue = ((Integer) obj2).intValue();
                        Object obj3 = map.get(Const.PageParams.CONTACT_ROLE);
                        if (obj3 != null) {
                            companion.doPageContact(scopeContext, str2, (OrderInfoEntity) null, intValue, (int) ((Long) obj3).longValue());
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus(NewOrderServicePlugin.REFRESH_IM_UNREAD_COUNT, this.this$0.getPageId()))) {
            this.this$0.m34199b();
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus(NewOrderServicePlugin.SHOW_OPERATION_POP_DIALOG, this.this$0.getPageId()))) {
            OrderPage orderPage = this.this$0;
            orderPage.f46041h = PopDialogHelper.addComponent(orderPage.getScopeContext(), this.this$0.getBaseContext(), this.this$0.f46037d, this.this$0.m34206f(), new PopDialogCallBack() {
                public final void addPopDialogComponent(PopDialogComponent popDialogComponent) {
                    OrderPage$newOrderServiceListener$1.m47514callPlugin$lambda0(OrderPage.this, popDialogComponent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: callPlugin$lambda-0  reason: not valid java name */
    public static final void m47514callPlugin$lambda0(OrderPage orderPage, PopDialogComponent popDialogComponent) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        if (orderPage.f46042i != null) {
            PopDialogComponent access$getPopDialogComponent$p = orderPage.f46042i;
            Intrinsics.checkNotNull(access$getPopDialogComponent$p);
            boolean unused = orderPage.removeComponent(access$getPopDialogComponent$p);
        }
        orderPage.f46042i = popDialogComponent;
        boolean unused2 = orderPage.addComponent(popDialogComponent);
    }
}
