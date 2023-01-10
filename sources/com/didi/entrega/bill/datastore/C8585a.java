package com.didi.entrega.bill.datastore;

import com.didi.entrega.bill.datastore.p111op.EntityOperation;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/entrega/bill/datastore/OperationModel;", "T", "", "op", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "data", "(Lcom/didi/entrega/bill/datastore/op/EntityOperation;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getOp", "()Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "exe", "", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "key", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.a */
/* compiled from: BillRepo.kt */
final class C8585a<T> {

    /* renamed from: a */
    private final EntityOperation<T> f21370a;

    /* renamed from: b */
    private T f21371b;

    public C8585a(EntityOperation<T> entityOperation, T t) {
        this.f21370a = entityOperation;
        this.f21371b = t;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C8585a(EntityOperation entityOperation, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(entityOperation, (i & 2) != 0 ? null : obj);
    }

    /* renamed from: a */
    public final EntityOperation<T> mo64269a() {
        return this.f21370a;
    }

    /* renamed from: a */
    public final void mo64271a(T t) {
        this.f21371b = t;
    }

    /* renamed from: b */
    public final T mo64272b() {
        return this.f21371b;
    }

    /* renamed from: a */
    public final void mo64270a(BillRepo billRepo, BillEntity billEntity) {
        Intrinsics.checkNotNullParameter(billRepo, "repo");
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        EntityOperation<T> entityOperation = this.f21370a;
        this.f21371b = entityOperation == null ? null : entityOperation.operate(billRepo, billEntity);
    }

    /* renamed from: c */
    public final int mo64273c() {
        return hashCode();
    }
}
