package com.didi.soda.cart.manager.task;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/SaveInfo;", "", "request", "Lcom/didi/soda/cart/manager/task/CartRequest;", "response", "Lcom/didi/soda/cart/manager/task/CartResponse;", "serverVersion", "", "(Lcom/didi/soda/cart/manager/task/CartRequest;Lcom/didi/soda/cart/manager/task/CartResponse;J)V", "getRequest", "()Lcom/didi/soda/cart/manager/task/CartRequest;", "getResponse", "()Lcom/didi/soda/cart/manager/task/CartResponse;", "setResponse", "(Lcom/didi/soda/cart/manager/task/CartResponse;)V", "getServerVersion", "()J", "setServerVersion", "(J)V", "toString", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SaveOperation.kt */
public final class SaveInfo {

    /* renamed from: a */
    private final CartRequest f42605a;

    /* renamed from: b */
    private CartResponse f42606b;

    /* renamed from: c */
    private long f42607c;

    public SaveInfo(CartRequest cartRequest, CartResponse cartResponse, long j) {
        Intrinsics.checkNotNullParameter(cartRequest, "request");
        this.f42605a = cartRequest;
        this.f42606b = cartResponse;
        this.f42607c = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveInfo(CartRequest cartRequest, CartResponse cartResponse, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cartRequest, (i & 2) != 0 ? null : cartResponse, (i & 4) != 0 ? -1 : j);
    }

    public final CartRequest getRequest() {
        return this.f42605a;
    }

    public final CartResponse getResponse() {
        return this.f42606b;
    }

    public final void setResponse(CartResponse cartResponse) {
        this.f42606b = cartResponse;
    }

    public final long getServerVersion() {
        return this.f42607c;
    }

    public final void setServerVersion(long j) {
        this.f42607c = j;
    }

    public String toString() {
        return "requestKey = " + this.f42605a.getRequestKey() + " serverVersion = " + this.f42607c;
    }
}
