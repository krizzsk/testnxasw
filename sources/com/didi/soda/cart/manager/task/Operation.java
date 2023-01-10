package com.didi.soda.cart.manager.task;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/Operation;", "", "execute", "Lcom/didi/soda/cart/manager/task/CartRequest;", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartResponse;", "cartResponse", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Operation.kt */
public interface Operation {
    CartRequest execute(CartRequest cartRequest);

    CartResponse execute(CartResponse cartResponse);
}
