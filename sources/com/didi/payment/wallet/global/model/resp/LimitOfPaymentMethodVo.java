package com.didi.payment.wallet.global.model.resp;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/model/resp/LimitOfPaymentMethodVo;", "Ljava/io/Serializable;", "paymentLimitList", "", "Lcom/didi/payment/wallet/global/model/resp/LimitOfPaymentMethodVo$PaymentLimitVo;", "(Ljava/util/List;)V", "getPaymentLimitList", "()Ljava/util/List;", "setPaymentLimitList", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "PaymentLimitVo", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LimitOfPaymentMethodVo.kt */
public final class LimitOfPaymentMethodVo implements Serializable {
    private List<PaymentLimitVo> paymentLimitList;

    public static /* synthetic */ LimitOfPaymentMethodVo copy$default(LimitOfPaymentMethodVo limitOfPaymentMethodVo, List<PaymentLimitVo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = limitOfPaymentMethodVo.paymentLimitList;
        }
        return limitOfPaymentMethodVo.copy(list);
    }

    public final List<PaymentLimitVo> component1() {
        return this.paymentLimitList;
    }

    public final LimitOfPaymentMethodVo copy(List<PaymentLimitVo> list) {
        return new LimitOfPaymentMethodVo(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LimitOfPaymentMethodVo) && Intrinsics.areEqual((Object) this.paymentLimitList, (Object) ((LimitOfPaymentMethodVo) obj).paymentLimitList);
    }

    public int hashCode() {
        List<PaymentLimitVo> list = this.paymentLimitList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "LimitOfPaymentMethodVo(paymentLimitList=" + this.paymentLimitList + VersionRange.RIGHT_OPEN;
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006'"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/model/resp/LimitOfPaymentMethodVo$PaymentLimitVo;", "Ljava/io/Serializable;", "paymentChannel", "", "riskLimitQuota", "", "riskLimitYuan", "description", "link", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getLink", "setLink", "getPaymentChannel", "setPaymentChannel", "getRiskLimitQuota", "()Ljava/lang/Long;", "setRiskLimitQuota", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRiskLimitYuan", "setRiskLimitYuan", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/payment/wallet/global/model/resp/LimitOfPaymentMethodVo$PaymentLimitVo;", "equals", "", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: LimitOfPaymentMethodVo.kt */
    public static final class PaymentLimitVo implements Serializable {
        private String description;
        private String link;
        private String paymentChannel;
        private Long riskLimitQuota;
        private Long riskLimitYuan;

        public static /* synthetic */ PaymentLimitVo copy$default(PaymentLimitVo paymentLimitVo, String str, Long l, Long l2, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentLimitVo.paymentChannel;
            }
            if ((i & 2) != 0) {
                l = paymentLimitVo.riskLimitQuota;
            }
            Long l3 = l;
            if ((i & 4) != 0) {
                l2 = paymentLimitVo.riskLimitYuan;
            }
            Long l4 = l2;
            if ((i & 8) != 0) {
                str2 = paymentLimitVo.description;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                str3 = paymentLimitVo.link;
            }
            return paymentLimitVo.copy(str, l3, l4, str4, str3);
        }

        public final String component1() {
            return this.paymentChannel;
        }

        public final Long component2() {
            return this.riskLimitQuota;
        }

        public final Long component3() {
            return this.riskLimitYuan;
        }

        public final String component4() {
            return this.description;
        }

        public final String component5() {
            return this.link;
        }

        public final PaymentLimitVo copy(String str, Long l, Long l2, String str2, String str3) {
            return new PaymentLimitVo(str, l, l2, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentLimitVo)) {
                return false;
            }
            PaymentLimitVo paymentLimitVo = (PaymentLimitVo) obj;
            return Intrinsics.areEqual((Object) this.paymentChannel, (Object) paymentLimitVo.paymentChannel) && Intrinsics.areEqual((Object) this.riskLimitQuota, (Object) paymentLimitVo.riskLimitQuota) && Intrinsics.areEqual((Object) this.riskLimitYuan, (Object) paymentLimitVo.riskLimitYuan) && Intrinsics.areEqual((Object) this.description, (Object) paymentLimitVo.description) && Intrinsics.areEqual((Object) this.link, (Object) paymentLimitVo.link);
        }

        public int hashCode() {
            String str = this.paymentChannel;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.riskLimitQuota;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.riskLimitYuan;
            int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
            String str2 = this.description;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.link;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "PaymentLimitVo(paymentChannel=" + this.paymentChannel + ", riskLimitQuota=" + this.riskLimitQuota + ", riskLimitYuan=" + this.riskLimitYuan + ", description=" + this.description + ", link=" + this.link + VersionRange.RIGHT_OPEN;
        }

        public PaymentLimitVo(String str, Long l, Long l2, String str2, String str3) {
            this.paymentChannel = str;
            this.riskLimitQuota = l;
            this.riskLimitYuan = l2;
            this.description = str2;
            this.link = str3;
        }

        public final String getPaymentChannel() {
            return this.paymentChannel;
        }

        public final void setPaymentChannel(String str) {
            this.paymentChannel = str;
        }

        public final Long getRiskLimitQuota() {
            return this.riskLimitQuota;
        }

        public final void setRiskLimitQuota(Long l) {
            this.riskLimitQuota = l;
        }

        public final Long getRiskLimitYuan() {
            return this.riskLimitYuan;
        }

        public final void setRiskLimitYuan(Long l) {
            this.riskLimitYuan = l;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            this.link = str;
        }
    }

    public LimitOfPaymentMethodVo(List<PaymentLimitVo> list) {
        this.paymentLimitList = list;
    }

    public final List<PaymentLimitVo> getPaymentLimitList() {
        return this.paymentLimitList;
    }

    public final void setPaymentLimitList(List<PaymentLimitVo> list) {
        this.paymentLimitList = list;
    }
}
