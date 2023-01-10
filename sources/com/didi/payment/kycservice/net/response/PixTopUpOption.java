package com.didi.payment.kycservice.net.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006%"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixTopUpOption;", "", "sku", "", "maxValue", "", "minValue", "currency", "metadata", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getMaxValue", "()Ljava/lang/Integer;", "setMaxValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMetadata", "setMetadata", "getMinValue", "setMinValue", "getSku", "setSku", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/payment/kycservice/net/response/PixTopUpOption;", "equals", "", "other", "hashCode", "toString", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixTopUpOption.kt */
public final class PixTopUpOption {

    /* renamed from: a */
    private String f33449a;

    /* renamed from: b */
    private Integer f33450b;

    /* renamed from: c */
    private Integer f33451c;

    /* renamed from: d */
    private String f33452d;

    /* renamed from: e */
    private String f33453e;

    public PixTopUpOption() {
        this((String) null, (Integer) null, (Integer) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PixTopUpOption copy$default(PixTopUpOption pixTopUpOption, String str, Integer num, Integer num2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pixTopUpOption.f33449a;
        }
        if ((i & 2) != 0) {
            num = pixTopUpOption.f33450b;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = pixTopUpOption.f33451c;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            str2 = pixTopUpOption.f33452d;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = pixTopUpOption.f33453e;
        }
        return pixTopUpOption.copy(str, num3, num4, str4, str3);
    }

    public final String component1() {
        return this.f33449a;
    }

    public final Integer component2() {
        return this.f33450b;
    }

    public final Integer component3() {
        return this.f33451c;
    }

    public final String component4() {
        return this.f33452d;
    }

    public final String component5() {
        return this.f33453e;
    }

    public final PixTopUpOption copy(String str, Integer num, Integer num2, String str2, String str3) {
        return new PixTopUpOption(str, num, num2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PixTopUpOption)) {
            return false;
        }
        PixTopUpOption pixTopUpOption = (PixTopUpOption) obj;
        return Intrinsics.areEqual((Object) this.f33449a, (Object) pixTopUpOption.f33449a) && Intrinsics.areEqual((Object) this.f33450b, (Object) pixTopUpOption.f33450b) && Intrinsics.areEqual((Object) this.f33451c, (Object) pixTopUpOption.f33451c) && Intrinsics.areEqual((Object) this.f33452d, (Object) pixTopUpOption.f33452d) && Intrinsics.areEqual((Object) this.f33453e, (Object) pixTopUpOption.f33453e);
    }

    public int hashCode() {
        String str = this.f33449a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f33450b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f33451c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.f33452d;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f33453e;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PixTopUpOption(sku=" + this.f33449a + ", maxValue=" + this.f33450b + ", minValue=" + this.f33451c + ", currency=" + this.f33452d + ", metadata=" + this.f33453e + VersionRange.RIGHT_OPEN;
    }

    public PixTopUpOption(String str, Integer num, Integer num2, String str2, String str3) {
        this.f33449a = str;
        this.f33450b = num;
        this.f33451c = num2;
        this.f33452d = str2;
        this.f33453e = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PixTopUpOption(java.lang.String r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.net.response.PixTopUpOption.<init>(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSku() {
        return this.f33449a;
    }

    public final void setSku(String str) {
        this.f33449a = str;
    }

    public final Integer getMaxValue() {
        return this.f33450b;
    }

    public final void setMaxValue(Integer num) {
        this.f33450b = num;
    }

    public final Integer getMinValue() {
        return this.f33451c;
    }

    public final void setMinValue(Integer num) {
        this.f33451c = num;
    }

    public final String getCurrency() {
        return this.f33452d;
    }

    public final void setCurrency(String str) {
        this.f33452d = str;
    }

    public final String getMetadata() {
        return this.f33453e;
    }

    public final void setMetadata(String str) {
        this.f33453e = str;
    }
}
