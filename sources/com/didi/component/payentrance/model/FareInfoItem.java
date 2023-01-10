package com.didi.component.payentrance.model;

import com.didi.travel.psnger.model.response.CarOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0011R\u001a\u0010;\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001a\u0010>\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R\u001a\u0010A\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R\u001a\u0010D\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000f\"\u0004\bF\u0010\u0011R\u001a\u0010G\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u001a\u0010J\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011R\u001a\u0010M\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)¨\u0006Q"}, mo148868d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem;", "", "()V", "<set-?>", "Lcom/didi/travel/psnger/model/response/CarOrder;", "carOrder", "getCarOrder", "()Lcom/didi/travel/psnger/model/response/CarOrder;", "setCarOrder", "(Lcom/didi/travel/psnger/model/response/CarOrder;)V", "carOrder$delegate", "Lkotlin/properties/ReadWriteProperty;", "carPoolSubTitle", "", "getCarPoolSubTitle", "()Ljava/lang/String;", "setCarPoolSubTitle", "(Ljava/lang/String;)V", "carPoolTitle", "getCarPoolTitle", "setCarPoolTitle", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "feeCardSuffix", "getFeeCardSuffix", "setFeeCardSuffix", "feeIcon", "getFeeIcon", "setFeeIcon", "feeLabel", "getFeeLabel", "setFeeLabel", "feeType", "", "getFeeType", "()I", "setFeeType", "(I)V", "feeValue", "getFeeValue", "setFeeValue", "feeValueRGB", "getFeeValueRGB", "setFeeValueRGB", "footerMsg", "getFooterMsg", "setFooterMsg", "isHighlight", "", "()Z", "setHighlight", "(Z)V", "pickupFee", "getPickupFee", "setPickupFee", "priceMsg", "getPriceMsg", "setPriceMsg", "showCouponTip", "getShowCouponTip", "setShowCouponTip", "showPoi", "getShowPoi", "setShowPoi", "showTips", "getShowTips", "setShowTips", "symbol", "getSymbol", "setSymbol", "title", "getTitle", "setTitle", "type", "getType", "setType", "ItemType", "comp-payentrance_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FeeInfoItem.kt */
public final class FareInfoItem {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f16725a = {C2404Reflection.mutableProperty1(new MutablePropertyReference1Impl(FareInfoItem.class, "carOrder", "getCarOrder()Lcom/didi/travel/psnger/model/response/CarOrder;", 0))};

    /* renamed from: b */
    private int f16726b;

    /* renamed from: c */
    private String f16727c = "";

    /* renamed from: d */
    private int f16728d = -1;

    /* renamed from: e */
    private String f16729e = "";

    /* renamed from: f */
    private String f16730f = "";

    /* renamed from: g */
    private int f16731g;

    /* renamed from: h */
    private String f16732h = "";

    /* renamed from: i */
    private String f16733i = "";

    /* renamed from: j */
    private String f16734j = "";

    /* renamed from: k */
    private List<FareInfoItem> f16735k = new ArrayList();

    /* renamed from: l */
    private String f16736l = "";

    /* renamed from: m */
    private boolean f16737m;

    /* renamed from: n */
    private String f16738n = "";

    /* renamed from: o */
    private String f16739o = "";

    /* renamed from: p */
    private String f16740p = "";

    /* renamed from: q */
    private String f16741q = "";

    /* renamed from: r */
    private String f16742r = "";

    /* renamed from: s */
    private String f16743s = "";

    /* renamed from: t */
    private String f16744t = "";

    /* renamed from: u */
    private final ReadWriteProperty f16745u = Delegates.INSTANCE.notNull();

    public final int getType() {
        return this.f16726b;
    }

    public final void setType(int i) {
        this.f16726b = i;
    }

    public final String getSymbol() {
        return this.f16727c;
    }

    public final void setSymbol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16727c = str;
    }

    public final int getShowPoi() {
        return this.f16728d;
    }

    public final void setShowPoi(int i) {
        this.f16728d = i;
    }

    public final String getFeeLabel() {
        return this.f16729e;
    }

    public final void setFeeLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16729e = str;
    }

    public final String getFeeValue() {
        return this.f16730f;
    }

    public final void setFeeValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16730f = str;
    }

    public final int getFeeType() {
        return this.f16731g;
    }

    public final void setFeeType(int i) {
        this.f16731g = i;
    }

    public final String getFeeIcon() {
        return this.f16732h;
    }

    public final void setFeeIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16732h = str;
    }

    public final String getFeeCardSuffix() {
        return this.f16733i;
    }

    public final void setFeeCardSuffix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16733i = str;
    }

    public final String getFeeValueRGB() {
        return this.f16734j;
    }

    public final void setFeeValueRGB(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16734j = str;
    }

    public final List<FareInfoItem> getChildren() {
        return this.f16735k;
    }

    public final void setChildren(List<FareInfoItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f16735k = list;
    }

    public final String getPriceMsg() {
        return this.f16736l;
    }

    public final void setPriceMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16736l = str;
    }

    public final boolean isHighlight() {
        return this.f16737m;
    }

    public final void setHighlight(boolean z) {
        this.f16737m = z;
    }

    public final String getPickupFee() {
        return this.f16738n;
    }

    public final void setPickupFee(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16738n = str;
    }

    public final String getShowTips() {
        return this.f16739o;
    }

    public final void setShowTips(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16739o = str;
    }

    public final String getShowCouponTip() {
        return this.f16740p;
    }

    public final void setShowCouponTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16740p = str;
    }

    public final String getFooterMsg() {
        return this.f16741q;
    }

    public final void setFooterMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16741q = str;
    }

    public final String getCarPoolTitle() {
        return this.f16742r;
    }

    public final void setCarPoolTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16742r = str;
    }

    public final String getCarPoolSubTitle() {
        return this.f16743s;
    }

    public final void setCarPoolSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16743s = str;
    }

    public final String getTitle() {
        return this.f16744t;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f16744t = str;
    }

    public final CarOrder getCarOrder() {
        return (CarOrder) this.f16745u.getValue(this, f16725a[0]);
    }

    public final void setCarOrder(CarOrder carOrder) {
        Intrinsics.checkNotNullParameter(carOrder, "<set-?>");
        this.f16745u.setValue(this, f16725a[0], carOrder);
    }

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem$ItemType;", "", "()V", "Companion", "comp-payentrance_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FeeInfoItem.kt */
    public static final class ItemType {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int TYPE_BASIC_FEE = 3;
        public static final int TYPE_BASIC_FEE_BUTTON = 6;
        public static final int TYPE_BASIC_FEE_CHILD = 4;
        public static final int TYPE_CAR_POOL = 9;
        public static final int TYPE_DECORATION = 2;
        public static final int TYPE_DECORATION_FAQ = 7;
        public static final int TYPE_FOOTER_MSG = 8;
        public static final int TYPE_PAYMENT = 11;
        public static final int TYPE_PRICE_MSG = 1;
        public static final int TYPE_RULES = 12;
        public static final int TYPE_TITLE = 10;
        public static final int TYPE_TITLE_FEE = 0;

        @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/component/payentrance/model/FareInfoItem$ItemType$Companion;", "", "()V", "TYPE_BASIC_FEE", "", "TYPE_BASIC_FEE_BUTTON", "TYPE_BASIC_FEE_CHILD", "TYPE_CAR_POOL", "TYPE_DECORATION", "TYPE_DECORATION_FAQ", "TYPE_FOOTER_MSG", "TYPE_PAYMENT", "TYPE_PRICE_MSG", "TYPE_RULES", "TYPE_TITLE", "TYPE_TITLE_FEE", "comp-payentrance_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: FeeInfoItem.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
