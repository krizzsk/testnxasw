package com.didi.soda.order.component.contact;

import android.text.TextUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/order/component/contact/ShopRole;", "Lcom/didi/soda/order/component/contact/AbstractRole;", "orderInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;)V", "getOrderInfoEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "setOrderInfoEntity", "roleType", "", "getRoleType", "()I", "setRoleType", "(I)V", "virtualCallRoleType", "getVirtualCallRoleType", "setVirtualCallRoleType", "businessDeliveryContract", "", "doCall", "doIM", "platformDeliveryContract", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopRole.kt */
public final class ShopRole extends AbstractRole {

    /* renamed from: a */
    private OrderInfoEntity f45922a;

    /* renamed from: b */
    private int f45923b = 1;

    /* renamed from: c */
    private int f45924c = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopRole(OrderInfoEntity orderInfoEntity) {
        super(orderInfoEntity);
        Intrinsics.checkNotNullParameter(orderInfoEntity, "orderInfoEntity");
        this.f45922a = orderInfoEntity;
    }

    public OrderInfoEntity getOrderInfoEntity() {
        return this.f45922a;
    }

    public void setOrderInfoEntity(OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(orderInfoEntity, "<set-?>");
        this.f45922a = orderInfoEntity;
    }

    public int getRoleType() {
        return this.f45923b;
    }

    public void setRoleType(int i) {
        this.f45923b = i;
    }

    public int getVirtualCallRoleType() {
        return this.f45924c;
    }

    public void setVirtualCallRoleType(int i) {
        this.f45924c = i;
    }

    public void doIM() {
        BusinessInfoEntity businessInfoEntity = getOrderInfoEntity().shopInfo;
        if (businessInfoEntity != null && businessInfoEntity.isOpenIm == 1 && !TextUtils.isEmpty(businessInfoEntity.bUid) && ImMessageHelper.getInstance().shouldUseImMessage(businessInfoEntity.shopImSecret)) {
            ImMessageHelper.getInstance().startChatDetailActivity(GlobalContext.getContext(), businessInfoEntity.bUid, businessInfoEntity.shopImSecret, businessInfoEntity.shopName, businessInfoEntity.logoImg, getOrderInfoEntity().status, getOrderInfoEntity().orderId, "merchant");
        }
    }

    public void doCall() {
        getLogTracker("contactShop").build().info();
        if (getOrderInfoEntity().shopInfo == null) {
            return;
        }
        if (getOrderInfoEntity().deliveryType == 2) {
            m34047a();
        } else if (getOrderInfoEntity().deliveryType == 1) {
            m34048b();
        }
    }

    /* renamed from: a */
    private final void m34047a() {
        BusinessInfoEntity businessInfoEntity = getOrderInfoEntity().shopInfo;
        if (!TextUtils.isEmpty(businessInfoEntity.phone)) {
            CustomerSystemUtil.doCall(GlobalContext.getContext(), businessInfoEntity.phone);
        }
    }

    /* renamed from: b */
    private final void m34048b() {
        BusinessInfoEntity businessInfoEntity = getOrderInfoEntity().shopInfo;
        if (businessInfoEntity.callPhoneProtected == 0) {
            CustomerSystemUtil.doCall(GlobalContext.getContext(), businessInfoEntity.callPhone);
        } else {
            virtualTelCall();
        }
    }
}
