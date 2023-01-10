package com.didi.soda.home.topgun.binder.model;

import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/TopicItemModel;", "", "goodsItem", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "isNewType", "", "(Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;Z)V", "shopItem", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "(Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;Z)V", "viewMoreItem", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;Z)V", "getGoodsItem", "()Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "setGoodsItem", "(Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;)V", "getShopItem", "()Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "setShopItem", "(Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;)V", "type", "", "getType", "()I", "setType", "(I)V", "getViewMoreItem", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;", "setViewMoreItem", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TopicItemModel.kt */
public final class TopicItemModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_GOODS = 0;
    public static final int TYPE_MORE = 2;
    public static final int TYPE_NEW_GOODS = 10;
    public static final int TYPE_NEW_MORE = 12;
    public static final int TYPE_NEW_SHOPS = 11;
    public static final int TYPE_SHOPS = 1;

    /* renamed from: a */
    private BusinessGoodsItemRvModel f45299a;

    /* renamed from: b */
    private ViewMoreEntity f45300b;

    /* renamed from: c */
    private HomeBusinessInfoRvModel f45301c;

    /* renamed from: d */
    private int f45302d;

    public final BusinessGoodsItemRvModel getGoodsItem() {
        return this.f45299a;
    }

    public final void setGoodsItem(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        this.f45299a = businessGoodsItemRvModel;
    }

    public final ViewMoreEntity getViewMoreItem() {
        return this.f45300b;
    }

    public final void setViewMoreItem(ViewMoreEntity viewMoreEntity) {
        this.f45300b = viewMoreEntity;
    }

    public final HomeBusinessInfoRvModel getShopItem() {
        return this.f45301c;
    }

    public final void setShopItem(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        this.f45301c = homeBusinessInfoRvModel;
    }

    public final int getType() {
        return this.f45302d;
    }

    public final void setType(int i) {
        this.f45302d = i;
    }

    public TopicItemModel(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "goodsItem");
        this.f45302d = z ? 10 : 0;
        this.f45299a = businessGoodsItemRvModel;
    }

    public TopicItemModel(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "shopItem");
        this.f45302d = z ? 11 : 1;
        this.f45301c = homeBusinessInfoRvModel;
    }

    public TopicItemModel(ViewMoreEntity viewMoreEntity, boolean z) {
        Intrinsics.checkNotNullParameter(viewMoreEntity, "viewMoreItem");
        this.f45302d = z ? 12 : 2;
        this.f45300b = viewMoreEntity;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/TopicItemModel$Companion;", "", "()V", "TYPE_GOODS", "", "TYPE_MORE", "TYPE_NEW_GOODS", "TYPE_NEW_MORE", "TYPE_NEW_SHOPS", "TYPE_SHOPS", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TopicItemModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
