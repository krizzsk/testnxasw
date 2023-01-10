package com.didi.soda.cart.manager.task;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/RollbackInfo;", "", "requestKey", "", "effectiveInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "lastRequest", "Lcom/didi/soda/cart/manager/task/CartRequest;", "(JLcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;Lcom/didi/soda/cart/manager/task/CartRequest;)V", "getEffectiveInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "getLastRequest", "()Lcom/didi/soda/cart/manager/task/CartRequest;", "getRequestKey", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SaveOperation.kt */
public final class RollbackInfo {

    /* renamed from: a */
    private final long f42602a;

    /* renamed from: b */
    private final CartInfoEntity f42603b;

    /* renamed from: c */
    private final CartRequest f42604c;

    public static /* synthetic */ RollbackInfo copy$default(RollbackInfo rollbackInfo, long j, CartInfoEntity cartInfoEntity, CartRequest cartRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            j = rollbackInfo.f42602a;
        }
        if ((i & 2) != 0) {
            cartInfoEntity = rollbackInfo.f42603b;
        }
        if ((i & 4) != 0) {
            cartRequest = rollbackInfo.f42604c;
        }
        return rollbackInfo.copy(j, cartInfoEntity, cartRequest);
    }

    public final long component1() {
        return this.f42602a;
    }

    public final CartInfoEntity component2() {
        return this.f42603b;
    }

    public final CartRequest component3() {
        return this.f42604c;
    }

    public final RollbackInfo copy(long j, CartInfoEntity cartInfoEntity, CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "lastRequest");
        return new RollbackInfo(j, cartInfoEntity, cartRequest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RollbackInfo)) {
            return false;
        }
        RollbackInfo rollbackInfo = (RollbackInfo) obj;
        return this.f42602a == rollbackInfo.f42602a && Intrinsics.areEqual((Object) this.f42603b, (Object) rollbackInfo.f42603b) && Intrinsics.areEqual((Object) this.f42604c, (Object) rollbackInfo.f42604c);
    }

    public int hashCode() {
        int hashCode = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f42602a) * 31;
        CartInfoEntity cartInfoEntity = this.f42603b;
        return ((hashCode + (cartInfoEntity == null ? 0 : cartInfoEntity.hashCode())) * 31) + this.f42604c.hashCode();
    }

    public String toString() {
        return "RollbackInfo(requestKey=" + this.f42602a + ", effectiveInfo=" + this.f42603b + ", lastRequest=" + this.f42604c + VersionRange.RIGHT_OPEN;
    }

    public RollbackInfo(long j, CartInfoEntity cartInfoEntity, CartRequest cartRequest) {
        Intrinsics.checkNotNullParameter(cartRequest, "lastRequest");
        this.f42602a = j;
        this.f42603b = cartInfoEntity;
        this.f42604c = cartRequest;
    }

    public final long getRequestKey() {
        return this.f42602a;
    }

    public final CartInfoEntity getEffectiveInfo() {
        return this.f42603b;
    }

    public final CartRequest getLastRequest() {
        return this.f42604c;
    }
}
