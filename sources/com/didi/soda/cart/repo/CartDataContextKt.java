package com.didi.soda.cart.repo;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, mo148868d2 = {"log", "", "Lcom/didi/soda/cart/repo/CartDataContext;", "msg", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartDataContext.kt */
public final class CartDataContextKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32014a(CartDataContext cartDataContext, String str) {
        LogUtil.m32588i("CartDataContext", "reversion: " + cartDataContext.getReversion() + " msg: " + str);
    }
}
