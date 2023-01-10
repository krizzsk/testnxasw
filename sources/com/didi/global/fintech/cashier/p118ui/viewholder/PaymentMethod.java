package com.didi.global.fintech.cashier.p118ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/PaymentMethod;", "", "icon", "", "displayName", "price", "installmentName", "installmentAmount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getInstallmentAmount", "setInstallmentAmount", "getInstallmentName", "setInstallmentName", "getPrice", "setPrice", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.PaymentMethod */
/* compiled from: GlobalCashierResultPayViewHolder.kt */
public final class PaymentMethod {

    /* renamed from: a */
    private String f23735a;

    /* renamed from: b */
    private String f23736b;

    /* renamed from: c */
    private String f23737c;

    /* renamed from: d */
    private String f23738d;

    /* renamed from: e */
    private String f23739e;

    public PaymentMethod() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentMethod copy$default(PaymentMethod paymentMethod, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentMethod.f23735a;
        }
        if ((i & 2) != 0) {
            str2 = paymentMethod.f23736b;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = paymentMethod.f23737c;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = paymentMethod.f23738d;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = paymentMethod.f23739e;
        }
        return paymentMethod.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.f23735a;
    }

    public final String component2() {
        return this.f23736b;
    }

    public final String component3() {
        return this.f23737c;
    }

    public final String component4() {
        return this.f23738d;
    }

    public final String component5() {
        return this.f23739e;
    }

    public final PaymentMethod copy(String str, String str2, String str3, String str4, String str5) {
        return new PaymentMethod(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) obj;
        return Intrinsics.areEqual((Object) this.f23735a, (Object) paymentMethod.f23735a) && Intrinsics.areEqual((Object) this.f23736b, (Object) paymentMethod.f23736b) && Intrinsics.areEqual((Object) this.f23737c, (Object) paymentMethod.f23737c) && Intrinsics.areEqual((Object) this.f23738d, (Object) paymentMethod.f23738d) && Intrinsics.areEqual((Object) this.f23739e, (Object) paymentMethod.f23739e);
    }

    public int hashCode() {
        String str = this.f23735a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f23736b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f23737c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f23738d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f23739e;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PaymentMethod(icon=" + this.f23735a + ", displayName=" + this.f23736b + ", price=" + this.f23737c + ", installmentName=" + this.f23738d + ", installmentAmount=" + this.f23739e + VersionRange.RIGHT_OPEN;
    }

    public PaymentMethod(String str, String str2, String str3, String str4, String str5) {
        this.f23735a = str;
        this.f23736b = str2;
        this.f23737c = str3;
        this.f23738d = str4;
        this.f23739e = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentMethod(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.viewholder.PaymentMethod.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getIcon() {
        return this.f23735a;
    }

    public final void setIcon(String str) {
        this.f23735a = str;
    }

    public final String getDisplayName() {
        return this.f23736b;
    }

    public final void setDisplayName(String str) {
        this.f23736b = str;
    }

    public final String getPrice() {
        return this.f23737c;
    }

    public final void setPrice(String str) {
        this.f23737c = str;
    }

    public final String getInstallmentName() {
        return this.f23738d;
    }

    public final void setInstallmentName(String str) {
        this.f23738d = str;
    }

    public final String getInstallmentAmount() {
        return this.f23739e;
    }

    public final void setInstallmentAmount(String str) {
        this.f23739e = str;
    }
}
