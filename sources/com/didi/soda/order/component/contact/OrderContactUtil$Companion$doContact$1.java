package com.didi.soda.order.component.contact;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.order.component.contact.OrderContactUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "orderInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderContactUtil.kt */
final class OrderContactUtil$Companion$doContact$1 extends Lambda implements Function1<OrderInfoEntity, Unit> {
    final /* synthetic */ int $contactRole;
    final /* synthetic */ int $contactType;
    final /* synthetic */ Context $context;
    final /* synthetic */ ScopeContext $scopeContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderContactUtil$Companion$doContact$1(int i, Context context, ScopeContext scopeContext, int i2) {
        super(1);
        this.$contactRole = i;
        this.$context = context;
        this.$scopeContext = scopeContext;
        this.$contactType = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OrderInfoEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(OrderInfoEntity orderInfoEntity) {
        OrderContactUtil.Companion companion = OrderContactUtil.Companion;
        int i = this.$contactRole;
        Context context = this.$context;
        ScopeContext scopeContext = this.$scopeContext;
        int i2 = this.$contactType;
        LogUtil.m32584d("OrderContactUtil", "requestOrderInfoById  end！");
        if (orderInfoEntity != null) {
            IRole access$getRole = companion.getRole(i, orderInfoEntity);
            if (access$getRole != null) {
                access$getRole.doRealContact(context, scopeContext, i2);
            }
            companion.trackDoContact(i, i2, orderInfoEntity);
            return;
        }
        LogUtil.m32586e("OrderContactUtil", "callContact but orderInfoEntity is empty!!! ");
    }
}
