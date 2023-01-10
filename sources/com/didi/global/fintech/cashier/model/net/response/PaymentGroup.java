package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 *2\u00020\u0001:\u0001*BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006+"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PaymentGroup;", "Ljava/io/Serializable;", "type", "", "name", "icon", "iconType", "", "payments", "", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getIconType", "()Ljava/lang/Integer;", "setIconType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getPayments", "()Ljava/util/List;", "setPayments", "(Ljava/util/List;)V", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/didi/global/fintech/cashier/model/net/response/PaymentGroup;", "equals", "", "other", "", "hashCode", "toString", "Companion", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class PaymentGroup implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_CARD_CHANNEL = "1";
    public static final String TYPE_THIRD_CHANNEL = "2";
    @SerializedName("icon")
    private String icon;
    @SerializedName("icon_type")
    private Integer iconType;
    @SerializedName("name")
    private String name;
    @SerializedName("payments")
    private List<Payment> payments;
    @SerializedName("type")
    private String type;

    public PaymentGroup() {
        this((String) null, (String) null, (String) null, (Integer) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentGroup copy$default(PaymentGroup paymentGroup, String str, String str2, String str3, Integer num, List<Payment> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentGroup.type;
        }
        if ((i & 2) != 0) {
            str2 = paymentGroup.name;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = paymentGroup.icon;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            num = paymentGroup.iconType;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            list = paymentGroup.payments;
        }
        return paymentGroup.copy(str, str4, str5, num2, list);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final Integer component4() {
        return this.iconType;
    }

    public final List<Payment> component5() {
        return this.payments;
    }

    public final PaymentGroup copy(String str, String str2, String str3, Integer num, List<Payment> list) {
        return new PaymentGroup(str, str2, str3, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentGroup)) {
            return false;
        }
        PaymentGroup paymentGroup = (PaymentGroup) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) paymentGroup.type) && Intrinsics.areEqual((Object) this.name, (Object) paymentGroup.name) && Intrinsics.areEqual((Object) this.icon, (Object) paymentGroup.icon) && Intrinsics.areEqual((Object) this.iconType, (Object) paymentGroup.iconType) && Intrinsics.areEqual((Object) this.payments, (Object) paymentGroup.payments);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.iconType;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        List<Payment> list = this.payments;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PaymentGroup(type=" + this.type + ", name=" + this.name + ", icon=" + this.icon + ", iconType=" + this.iconType + ", payments=" + this.payments + VersionRange.RIGHT_OPEN;
    }

    public PaymentGroup(String str, String str2, String str3, Integer num, List<Payment> list) {
        this.type = str;
        this.name = str2;
        this.icon = str3;
        this.iconType = num;
        this.payments = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentGroup(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.Integer r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.PaymentGroup.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final Integer getIconType() {
        return this.iconType;
    }

    public final void setIconType(Integer num) {
        this.iconType = num;
    }

    public final List<Payment> getPayments() {
        return this.payments;
    }

    public final void setPayments(List<Payment> list) {
        this.payments = list;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PaymentGroup$Companion;", "", "()V", "TYPE_CARD_CHANNEL", "", "TYPE_THIRD_CHANNEL", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
