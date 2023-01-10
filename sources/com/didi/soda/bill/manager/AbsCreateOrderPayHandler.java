package com.didi.soda.bill.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/bill/manager/AbsCreateOrderPayHandler;", "", "mScopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getMScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "goPay", "", "outerState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "order", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "startPayTimeout", "state", "timeout", "Lkotlin/Function0;", "stopPayTimeout", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AbsCreateOrderPayHandler.kt */
public abstract class AbsCreateOrderPayHandler {

    /* renamed from: a */
    private final ScopeContext f41719a;

    public abstract void goPay(CreateOrderState createOrderState, OrderInfoEntity orderInfoEntity);

    public void startPayTimeout(CreateOrderState createOrderState, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        Intrinsics.checkNotNullParameter(function0, "timeout");
    }

    public void stopPayTimeout() {
    }

    public AbsCreateOrderPayHandler(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "mScopeContext");
        this.f41719a = scopeContext;
    }

    public final ScopeContext getMScopeContext() {
        return this.f41719a;
    }
}
