package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/Rollback;", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;)V", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getEx", "()Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.cart.manager.task.a */
/* compiled from: CartRequestManager.kt */
final class C14333a {

    /* renamed from: a */
    private final CartInfoEntity f42609a;

    /* renamed from: b */
    private final SFRpcException f42610b;

    public C14333a() {
        this((CartInfoEntity) null, (SFRpcException) null, 3, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    public static /* synthetic */ C14333a m32007a(C14333a aVar, CartInfoEntity cartInfoEntity, SFRpcException sFRpcException, int i, Object obj) {
        if ((i & 1) != 0) {
            cartInfoEntity = aVar.f42609a;
        }
        if ((i & 2) != 0) {
            sFRpcException = aVar.f42610b;
        }
        return aVar.mo107691a(cartInfoEntity, sFRpcException);
    }

    /* renamed from: a */
    public final C14333a mo107691a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        return new C14333a(cartInfoEntity, sFRpcException);
    }

    /* renamed from: c */
    public final CartInfoEntity mo107694c() {
        return this.f42609a;
    }

    /* renamed from: d */
    public final SFRpcException mo107695d() {
        return this.f42610b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14333a)) {
            return false;
        }
        C14333a aVar = (C14333a) obj;
        return Intrinsics.areEqual((Object) this.f42609a, (Object) aVar.f42609a) && Intrinsics.areEqual((Object) this.f42610b, (Object) aVar.f42610b);
    }

    public int hashCode() {
        CartInfoEntity cartInfoEntity = this.f42609a;
        int i = 0;
        int hashCode = (cartInfoEntity == null ? 0 : cartInfoEntity.hashCode()) * 31;
        SFRpcException sFRpcException = this.f42610b;
        if (sFRpcException != null) {
            i = sFRpcException.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Rollback(entity=" + this.f42609a + ", ex=" + this.f42610b + VersionRange.RIGHT_OPEN;
    }

    public C14333a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        this.f42609a = cartInfoEntity;
        this.f42610b = sFRpcException;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C14333a(CartInfoEntity cartInfoEntity, SFRpcException sFRpcException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cartInfoEntity, (i & 2) != 0 ? null : sFRpcException);
    }

    /* renamed from: a */
    public final CartInfoEntity mo107692a() {
        return this.f42609a;
    }

    /* renamed from: b */
    public final SFRpcException mo107693b() {
        return this.f42610b;
    }
}
