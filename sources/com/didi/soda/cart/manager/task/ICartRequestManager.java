package com.didi.soda.cart.manager.task;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/ICartRequestManager;", "", "release", "", "requestSetAmount", "cartRequest", "Lcom/didi/soda/cart/manager/task/CartRequest;", "requestSetItem", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartRequestManagerImp.kt */
public interface ICartRequestManager {
    void release();

    void requestSetAmount(CartRequest cartRequest);

    void requestSetItem(CartRequest cartRequest);
}
