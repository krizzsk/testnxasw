package com.didi.soda.globalcart.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.bill.model.BillDataFactory;
import com.didi.soda.bill.model.SectionModel;
import com.didi.soda.bill.model.datamodel.ShopInfoModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\b¨\u0006-"}, mo148868d2 = {"Lcom/didi/soda/globalcart/model/BillInfoRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "orderDisclaimer", "getOrderDisclaimer", "setOrderDisclaimer", "priceSumOri", "", "getPriceSumOri", "()I", "setPriceSumOri", "(I)V", "priceSumOriDisplay", "getPriceSumOriDisplay", "setPriceSumOriDisplay", "realPayPrice", "getRealPayPrice", "setRealPayPrice", "realPayPriceDisplay", "getRealPayPriceDisplay", "setRealPayPriceDisplay", "sections", "Ljava/util/ArrayList;", "Lcom/didi/soda/bill/model/SectionModel;", "Lkotlin/collections/ArrayList;", "getSections", "()Ljava/util/ArrayList;", "setSections", "(Ljava/util/ArrayList;)V", "shopInfo", "Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "getShopInfo", "()Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "setShopInfo", "(Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;)V", "sn", "getSn", "setSn", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillInfoRvModel.kt */
public final class BillInfoRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f44853a;

    /* renamed from: b */
    private ArrayList<SectionModel> f44854b = new ArrayList<>();

    /* renamed from: c */
    private String f44855c;

    /* renamed from: d */
    private ShopInfoModel f44856d;

    /* renamed from: e */
    private int f44857e;

    /* renamed from: f */
    private String f44858f;

    /* renamed from: g */
    private int f44859g;

    /* renamed from: h */
    private String f44860h;

    /* renamed from: i */
    private String f44861i;

    public final String getCartId() {
        return this.f44853a;
    }

    public final void setCartId(String str) {
        this.f44853a = str;
    }

    public final ArrayList<SectionModel> getSections() {
        return this.f44854b;
    }

    public final void setSections(ArrayList<SectionModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f44854b = arrayList;
    }

    public final String getSn() {
        return this.f44855c;
    }

    public final void setSn(String str) {
        this.f44855c = str;
    }

    public final ShopInfoModel getShopInfo() {
        return this.f44856d;
    }

    public final void setShopInfo(ShopInfoModel shopInfoModel) {
        this.f44856d = shopInfoModel;
    }

    public final int getRealPayPrice() {
        return this.f44857e;
    }

    public final void setRealPayPrice(int i) {
        this.f44857e = i;
    }

    public final String getRealPayPriceDisplay() {
        return this.f44858f;
    }

    public final void setRealPayPriceDisplay(String str) {
        this.f44858f = str;
    }

    public final int getPriceSumOri() {
        return this.f44859g;
    }

    public final void setPriceSumOri(int i) {
        this.f44859g = i;
    }

    public final String getPriceSumOriDisplay() {
        return this.f44860h;
    }

    public final void setPriceSumOriDisplay(String str) {
        this.f44860h = str;
    }

    public final String getOrderDisclaimer() {
        return this.f44861i;
    }

    public final void setOrderDisclaimer(String str) {
        this.f44861i = str;
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/globalcart/model/BillInfoRvModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/globalcart/model/BillInfoRvModel;", "billInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "sourcePage", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillInfoRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillInfoRvModel convert(BillInfoEntity billInfoEntity, int i) {
            Intrinsics.checkNotNullParameter(billInfoEntity, "billInfoEntity");
            BillInfoRvModel billInfoRvModel = new BillInfoRvModel();
            billInfoRvModel.setCartId(billInfoEntity.getCartId());
            billInfoRvModel.setSections(BillDataFactory.createSectionModels$default(BillDataFactory.Companion.getFactory(), billInfoEntity, i, 0, 4, (Object) null));
            billInfoRvModel.setSn(billInfoEntity.getSn());
            billInfoRvModel.setShopInfo(ShopInfoModel.Companion.convert(billInfoEntity.getShopInfo()));
            billInfoRvModel.setRealPayPrice(billInfoEntity.getRealPayPrice());
            billInfoRvModel.setRealPayPriceDisplay(billInfoEntity.getRealPayPriceDisplay());
            billInfoRvModel.setPriceSumOri(billInfoEntity.getPriceSumOri());
            billInfoRvModel.setPriceSumOriDisplay(billInfoEntity.getPriceSumOriDisplay());
            billInfoRvModel.setOrderDisclaimer(billInfoEntity.getOrderDisclaimer());
            return billInfoRvModel;
        }
    }
}
