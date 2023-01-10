package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R7\u0010#\u001a\u001f\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u00064"}, mo148868d2 = {"Lcom/didi/entrega/bill/model/AddressModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "type", "Lcom/didi/entrega/bill/model/AddressType;", "(Lcom/didi/entrega/bill/model/AddressType;)V", "contactInfo", "", "getContactInfo", "()Ljava/lang/String;", "setContactInfo", "(Ljava/lang/String;)V", "displayAddress", "getDisplayAddress", "setDisplayAddress", "displayAddressTextColor", "", "getDisplayAddressTextColor", "()I", "setDisplayAddressTextColor", "(I)V", "displayAddressTextSize", "getDisplayAddressTextSize", "setDisplayAddressTextSize", "floorInfo", "getFloorInfo", "setFloorInfo", "markerBg", "getMarkerBg", "setMarkerBg", "markerLabel", "getMarkerLabel", "setMarkerLabel", "markerLabelColor", "getMarkerLabelColor", "setMarkerLabelColor", "onAddressClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnAddressClick", "()Lkotlin/jvm/functions/Function1;", "setOnAddressClick", "(Lkotlin/jvm/functions/Function1;)V", "phoneInfo", "getPhoneInfo", "setPhoneInfo", "getType", "()Lcom/didi/entrega/bill/model/AddressType;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddressModel.kt */
public final class AddressModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final AddressType f21374a;

    /* renamed from: b */
    private String f21375b = "";

    /* renamed from: c */
    private int f21376c;

    /* renamed from: d */
    private int f21377d;

    /* renamed from: e */
    private String f21378e;

    /* renamed from: f */
    private int f21379f;

    /* renamed from: g */
    private int f21380g;

    /* renamed from: h */
    private String f21381h;

    /* renamed from: i */
    private String f21382i;

    /* renamed from: j */
    private String f21383j;

    /* renamed from: k */
    private Function1<? super View, Unit> f21384k;

    public AddressModel(AddressType addressType) {
        Intrinsics.checkNotNullParameter(addressType, "type");
        this.f21374a = addressType;
    }

    public final AddressType getType() {
        return this.f21374a;
    }

    public final String getMarkerLabel() {
        return this.f21375b;
    }

    public final void setMarkerLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f21375b = str;
    }

    public final int getMarkerBg() {
        return this.f21376c;
    }

    public final void setMarkerBg(int i) {
        this.f21376c = i;
    }

    public final int getMarkerLabelColor() {
        return this.f21377d;
    }

    public final void setMarkerLabelColor(int i) {
        this.f21377d = i;
    }

    public final String getDisplayAddress() {
        return this.f21378e;
    }

    public final void setDisplayAddress(String str) {
        this.f21378e = str;
    }

    public final int getDisplayAddressTextSize() {
        return this.f21379f;
    }

    public final void setDisplayAddressTextSize(int i) {
        this.f21379f = i;
    }

    public final int getDisplayAddressTextColor() {
        return this.f21380g;
    }

    public final void setDisplayAddressTextColor(int i) {
        this.f21380g = i;
    }

    public final String getFloorInfo() {
        return this.f21381h;
    }

    public final void setFloorInfo(String str) {
        this.f21381h = str;
    }

    public final String getContactInfo() {
        return this.f21382i;
    }

    public final void setContactInfo(String str) {
        this.f21382i = str;
    }

    public final String getPhoneInfo() {
        return this.f21383j;
    }

    public final void setPhoneInfo(String str) {
        this.f21383j = str;
    }

    public final Function1<View, Unit> getOnAddressClick() {
        return this.f21384k;
    }

    public final void setOnAddressClick(Function1<? super View, Unit> function1) {
        this.f21384k = function1;
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/entrega/bill/model/AddressModel$Companion;", "", "()V", "convert", "Lcom/didi/entrega/bill/model/AddressModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "type", "Lcom/didi/entrega/bill/model/AddressType;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AddressModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c8  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00d9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.didi.entrega.bill.model.AddressModel convert(com.didi.app.nova.skeleton.ScopeContext r6, com.didi.entrega.bill.model.AddressType r7, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r8) {
            /*
                r5 = this;
                java.lang.String r0 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                if (r8 != 0) goto L_0x000a
                r6 = 0
                return r6
            L_0x000a:
                com.didi.entrega.bill.model.AddressModel r0 = new com.didi.entrega.bill.model.AddressModel
                r0.<init>(r7)
                com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r8.poi
                if (r1 == 0) goto L_0x0036
                com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r8.poi
                java.lang.String r1 = r1.displayName
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0036
                com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r8.poi
                java.lang.String r1 = r1.displayName
                r0.setDisplayAddress(r1)
                r1 = 16
                r0.setDisplayAddressTextSize(r1)
                r1 = 2131101493(0x7f060735, float:1.7815397E38)
                int r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r1)
                r0.setDisplayAddressTextColor(r1)
                goto L_0x005b
            L_0x0036:
                com.didi.entrega.bill.model.AddressType r1 = com.didi.entrega.bill.model.AddressType.SENDER
                if (r7 != r1) goto L_0x0042
                r1 = 2131952026(0x7f13019a, float:1.9540483E38)
                java.lang.String r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getString(r1)
                goto L_0x0049
            L_0x0042:
                r1 = 2131952025(0x7f130199, float:1.9540481E38)
                java.lang.String r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getString(r1)
            L_0x0049:
                r0.setDisplayAddress(r1)
                r1 = 12
                r0.setDisplayAddressTextSize(r1)
                r1 = 2131101495(0x7f060737, float:1.7815401E38)
                int r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r1)
                r0.setDisplayAddressTextColor(r1)
            L_0x005b:
                java.lang.String r1 = r8.houseNumber
                r0.setFloorInfo(r1)
                java.lang.String r1 = r8.firstName
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0071
                int r1 = r1.length()
                if (r1 != 0) goto L_0x006f
                goto L_0x0071
            L_0x006f:
                r1 = 0
                goto L_0x0072
            L_0x0071:
                r1 = 1
            L_0x0072:
                java.lang.String r4 = ""
                if (r1 != 0) goto L_0x00a1
                java.lang.String r1 = r8.lastName
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0085
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0083
                goto L_0x0085
            L_0x0083:
                r1 = 0
                goto L_0x0086
            L_0x0085:
                r1 = 1
            L_0x0086:
                if (r1 != 0) goto L_0x00a1
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = r8.firstName
                r1.append(r2)
                r2 = 32
                r1.append(r2)
                java.lang.String r2 = r8.lastName
                r1.append(r2)
                java.lang.String r4 = r1.toString()
                goto L_0x00ba
            L_0x00a1:
                java.lang.String r1 = r8.firstName
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x00ad
                int r1 = r1.length()
                if (r1 != 0) goto L_0x00ae
            L_0x00ad:
                r2 = 1
            L_0x00ae:
                if (r2 == 0) goto L_0x00b5
                java.lang.String r1 = r8.lastName
                if (r1 == 0) goto L_0x00ba
                goto L_0x00b9
            L_0x00b5:
                java.lang.String r1 = r8.firstName
                if (r1 == 0) goto L_0x00ba
            L_0x00b9:
                r4 = r1
            L_0x00ba:
                r0.setContactInfo(r4)
                java.lang.String r8 = com.didi.entrega.bill.model.AddressModelKt.m18033a(r8)
                r0.setPhoneInfo(r8)
                com.didi.entrega.bill.model.AddressType r8 = com.didi.entrega.bill.model.AddressType.SENDER
                if (r7 != r8) goto L_0x00d9
                r8 = 2131232714(0x7f0807ca, float:1.8081545E38)
                r0.setMarkerBg(r8)
                r8 = 2131101457(0x7f060711, float:1.7815324E38)
                int r8 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r8)
                r0.setMarkerLabelColor(r8)
                goto L_0x00e9
            L_0x00d9:
                r8 = 2131232713(0x7f0807c9, float:1.8081543E38)
                r0.setMarkerBg(r8)
                r8 = 2131101464(0x7f060718, float:1.7815338E38)
                int r8 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r8)
                r0.setMarkerLabelColor(r8)
            L_0x00e9:
                com.didi.entrega.bill.model.AddressModel$Companion$convert$1$1 r8 = new com.didi.entrega.bill.model.AddressModel$Companion$convert$1$1
                r8.<init>(r7, r6)
                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                r0.setOnAddressClick(r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.model.AddressModel.Companion.convert(com.didi.app.nova.skeleton.ScopeContext, com.didi.entrega.bill.model.AddressType, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity):com.didi.entrega.bill.model.AddressModel");
        }
    }
}
