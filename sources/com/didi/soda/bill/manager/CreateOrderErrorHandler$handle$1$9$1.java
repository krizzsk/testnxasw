package com.didi.soda.bill.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderErrorHandler.kt */
final class CreateOrderErrorHandler$handle$1$9$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CreateOrderErrorHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderErrorHandler$handle$1$9$1(CreateOrderErrorHandler createOrderErrorHandler) {
        super(0);
        this.this$0 = createOrderErrorHandler;
    }

    public final void invoke() {
        CreateOrderDispatcher access$getDispatcher$p = this.this$0.f41723b;
        if (access$getDispatcher$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            access$getDispatcher$p = null;
        }
        access$getDispatcher$p.dispatch(CreateOrderDispatcher.Companion.createOrderValidateCard());
    }
}
