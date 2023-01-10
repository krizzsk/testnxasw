package com.didi.entrega.bill.datastore;

import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcPath;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001e¨\u0006+"}, mo148868d2 = {"Lcom/didi/entrega/bill/datastore/BillInfoRequest;", "Lcom/didi/entrega/bill/datastore/BillRequest;", "()V", "callback", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "getCallback", "()Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "setCallback", "(Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;)V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getPackageInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setPackageInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;)V", "receiverAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getReceiverAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setReceiverAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "recover", "", "getRecover", "()Z", "setRecover", "(Z)V", "senderAddress", "getSenderAddress", "setSenderAddress", "getRequestName", "send", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillRequestFactory.kt */
public final class BillInfoRequest extends BillRequest {

    /* renamed from: a */
    private String f21342a = "";

    /* renamed from: b */
    private AddressEntity f21343b;

    /* renamed from: c */
    private AddressEntity f21344c;

    /* renamed from: d */
    private ContactStufEntity f21345d;

    /* renamed from: e */
    private String f21346e = "";

    /* renamed from: f */
    private boolean f21347f;

    /* renamed from: g */
    private CustomerRpcCallback<BillEntity> f21348g;

    public String getRequestName() {
        return CustomerRpcPath.BILL_INFO;
    }

    public final String getCartId() {
        return this.f21342a;
    }

    public final void setCartId(String str) {
        this.f21342a = str;
    }

    public final AddressEntity getSenderAddress() {
        return this.f21343b;
    }

    public final void setSenderAddress(AddressEntity addressEntity) {
        this.f21343b = addressEntity;
    }

    public final AddressEntity getReceiverAddress() {
        return this.f21344c;
    }

    public final void setReceiverAddress(AddressEntity addressEntity) {
        this.f21344c = addressEntity;
    }

    public final ContactStufEntity getPackageInfo() {
        return this.f21345d;
    }

    public final void setPackageInfo(ContactStufEntity contactStufEntity) {
        this.f21345d = contactStufEntity;
    }

    public final String getOrderId() {
        return this.f21346e;
    }

    public final void setOrderId(String str) {
        this.f21346e = str;
    }

    public final boolean getRecover() {
        return this.f21347f;
    }

    public final void setRecover(boolean z) {
        this.f21347f = z;
    }

    public final CustomerRpcCallback<BillEntity> getCallback() {
        return this.f21348g;
    }

    public final void setCallback(CustomerRpcCallback<BillEntity> customerRpcCallback) {
        this.f21348g = customerRpcCallback;
    }

    public void send() {
        super.send();
        CustomerRpcManagerProxy.get().billInfo(this.f21342a, this.f21343b, this.f21344c, this.f21345d, this.f21346e, this.f21348g);
        CustomerRpcManagerProxy.get().getCommonInfo(new BillInfoRequest$send$1());
    }
}
