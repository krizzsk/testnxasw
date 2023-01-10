package com.didi.entrega.bill.model;

import com.didi.entrega.bill.datastore.BillRequest;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/entrega/bill/model/RequestFlowModel;", "", "request", "Lcom/didi/entrega/bill/datastore/BillRequest;", "status", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "(Lcom/didi/entrega/bill/datastore/BillRequest;ILcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;)V", "getEx", "()Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "getRequest", "()Lcom/didi/entrega/bill/datastore/BillRequest;", "requestName", "", "getRequestName", "()Ljava/lang/String;", "getStatus", "()I", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RequestFlowModel.kt */
public final class RequestFlowModel {

    /* renamed from: a */
    private final BillRequest f21420a;

    /* renamed from: b */
    private final int f21421b;

    /* renamed from: c */
    private final SFRpcException f21422c;

    /* renamed from: d */
    private final String f21423d;

    public RequestFlowModel(BillRequest billRequest, int i, SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(billRequest, "request");
        this.f21420a = billRequest;
        this.f21421b = i;
        this.f21422c = sFRpcException;
        this.f21423d = billRequest.getRequestName();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestFlowModel(BillRequest billRequest, int i, SFRpcException sFRpcException, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(billRequest, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? null : sFRpcException);
    }

    public final BillRequest getRequest() {
        return this.f21420a;
    }

    public final int getStatus() {
        return this.f21421b;
    }

    public final SFRpcException getEx() {
        return this.f21422c;
    }

    public final String getRequestName() {
        return this.f21423d;
    }
}
