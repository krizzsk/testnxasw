package com.didi.soda.cart.model;

import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00105\u001a\u0004\u0018\u000106R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\u001a\u00102\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000e¨\u00067"}, mo148868d2 = {"Lcom/didi/soda/cart/model/CartTyingItemModel;", "Lcom/didi/soda/cart/model/CartItemBaseModel;", "()V", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "deliveryPriceAct", "", "getDeliveryPriceAct", "()I", "setDeliveryPriceAct", "(I)V", "deliveryPriceOri", "getDeliveryPriceOri", "setDeliveryPriceOri", "deliveryTime", "", "getDeliveryTime", "()J", "setDeliveryTime", "(J)V", "delivery_fee", "getDelivery_fee", "setDelivery_fee", "isMultiContent", "", "()Z", "setMultiContent", "(Z)V", "limited_time", "getLimited_time", "setLimited_time", "mduType", "getMduType", "setMduType", "node", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "getNode", "()Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "setNode", "(Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;)V", "position", "getPosition", "setPosition", "soldStatus", "getSoldStatus", "setSoldStatus", "status", "getStatus", "setStatus", "convertModel", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartTyingItemModel.kt */
public final class CartTyingItemModel extends CartItemBaseModel {

    /* renamed from: a */
    private int f42642a = 1;

    /* renamed from: b */
    private ItemNodeEntity f42643b;

    /* renamed from: c */
    private int f42644c = 1;

    /* renamed from: d */
    private int f42645d = 1;

    /* renamed from: e */
    private String f42646e = "";

    /* renamed from: f */
    private String f42647f = "";

    /* renamed from: g */
    private String f42648g;

    /* renamed from: h */
    private int f42649h;

    /* renamed from: i */
    private int f42650i;

    /* renamed from: j */
    private long f42651j;

    /* renamed from: k */
    private int f42652k;

    /* renamed from: l */
    private boolean f42653l;

    public int getMduType() {
        return this.f42642a;
    }

    public void setMduType(int i) {
        this.f42642a = i;
    }

    public final ItemNodeEntity getNode() {
        return this.f42643b;
    }

    public final void setNode(ItemNodeEntity itemNodeEntity) {
        this.f42643b = itemNodeEntity;
    }

    public final int getStatus() {
        return this.f42644c;
    }

    public final void setStatus(int i) {
        this.f42644c = i;
    }

    public final int getSoldStatus() {
        return this.f42645d;
    }

    public final void setSoldStatus(int i) {
        this.f42645d = i;
    }

    public final String getLimited_time() {
        return this.f42646e;
    }

    public final void setLimited_time(String str) {
        this.f42646e = str;
    }

    public final String getDelivery_fee() {
        return this.f42647f;
    }

    public final void setDelivery_fee(String str) {
        this.f42647f = str;
    }

    public final String getCurrency() {
        return this.f42648g;
    }

    public final void setCurrency(String str) {
        this.f42648g = str;
    }

    public final int getDeliveryPriceOri() {
        return this.f42649h;
    }

    public final void setDeliveryPriceOri(int i) {
        this.f42649h = i;
    }

    public final int getDeliveryPriceAct() {
        return this.f42650i;
    }

    public final void setDeliveryPriceAct(int i) {
        this.f42650i = i;
    }

    public final long getDeliveryTime() {
        return this.f42651j;
    }

    public final void setDeliveryTime(long j) {
        this.f42651j = j;
    }

    public final int getPosition() {
        return this.f42652k;
    }

    public final void setPosition(int i) {
        this.f42652k = i;
    }

    public final boolean isMultiContent() {
        return this.f42653l;
    }

    public final void setMultiContent(boolean z) {
        this.f42653l = z;
    }

    public final CartItemEntity convertModel() {
        CartTyingItemModel cartTyingItemModel = this;
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setItemId(cartTyingItemModel.getItemId());
        cartItemEntity.setItemName(cartTyingItemModel.getItemName());
        setShopId(cartTyingItemModel.getShopId());
        cartItemEntity.setMduId(cartTyingItemModel.getMduId());
        cartItemEntity.setAmount(cartTyingItemModel.getAmount());
        cartItemEntity.setHeadImg(cartTyingItemModel.getHeadImg());
        cartItemEntity.setSubItemDesc(cartTyingItemModel.getSubItemDesc());
        cartItemEntity.setPrice(cartTyingItemModel.getPrice());
        cartItemEntity.setPriceDisplay(cartTyingItemModel.getPriceDisplay());
        cartItemEntity.setSpecialPrice(cartTyingItemModel.getSpecialPrice());
        cartItemEntity.setSpecialPriceDisplay(cartTyingItemModel.getSpecialPriceDisplay());
        cartItemEntity.setItemFeature(cartTyingItemModel.getItemFeature());
        cartItemEntity.setActTag(cartTyingItemModel.getMActTagList());
        return cartItemEntity;
    }
}
