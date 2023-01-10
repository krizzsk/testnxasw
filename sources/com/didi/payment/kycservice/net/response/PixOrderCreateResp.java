package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.IValidator;
import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import com.didi.sdk.util.TextUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp;", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$OrderMetaData;", "()V", "NoticeInfo", "OrderMetaData", "PaymentPasswordInfo", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixOrderCreateResp.kt */
public final class PixOrderCreateResp extends WBaseRespTemplate<OrderMetaData> {

    @Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$OrderMetaData;", "Ljava/io/Serializable;", "Lcom/didi/payment/commonsdk/net/IValidator;", "()V", "noticeInfo", "Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$NoticeInfo;", "getNoticeInfo", "()Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$NoticeInfo;", "setNoticeInfo", "(Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$NoticeInfo;)V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "outTradeId", "getOutTradeId", "setOutTradeId", "paymentPasswordInfo", "Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$PaymentPasswordInfo;", "getPaymentPasswordInfo", "()Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$PaymentPasswordInfo;", "setPaymentPasswordInfo", "(Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$PaymentPasswordInfo;)V", "valid", "", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixOrderCreateResp.kt */
    public static final class OrderMetaData implements IValidator, Serializable {
        @SerializedName("noticePanelInfo")
        private NoticeInfo noticeInfo;
        @SerializedName("orderId")
        private String orderId;
        @SerializedName("outTradeId")
        private String outTradeId;
        @SerializedName("paymentPasswordInfo")
        private PaymentPasswordInfo paymentPasswordInfo;

        public final String getOutTradeId() {
            return this.outTradeId;
        }

        public final void setOutTradeId(String str) {
            this.outTradeId = str;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final void setOrderId(String str) {
            this.orderId = str;
        }

        public final NoticeInfo getNoticeInfo() {
            return this.noticeInfo;
        }

        public final void setNoticeInfo(NoticeInfo noticeInfo2) {
            this.noticeInfo = noticeInfo2;
        }

        public final PaymentPasswordInfo getPaymentPasswordInfo() {
            return this.paymentPasswordInfo;
        }

        public final void setPaymentPasswordInfo(PaymentPasswordInfo paymentPasswordInfo2) {
            this.paymentPasswordInfo = paymentPasswordInfo2;
        }

        public boolean valid() {
            return !TextUtil.isEmpty(this.orderId);
        }
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$NoticeInfo;", "Ljava/io/Serializable;", "title", "", "content", "confirmButton", "cancelButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "getConfirmButton", "getContent", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixOrderCreateResp.kt */
    public static final class NoticeInfo implements Serializable {
        @SerializedName("cancelButton")
        private final String cancelButton;
        @SerializedName("confirmButton")
        private final String confirmButton;
        @SerializedName("content")
        private final String content;
        @SerializedName("title")
        private final String title;

        public NoticeInfo() {
            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ NoticeInfo copy$default(NoticeInfo noticeInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noticeInfo.title;
            }
            if ((i & 2) != 0) {
                str2 = noticeInfo.content;
            }
            if ((i & 4) != 0) {
                str3 = noticeInfo.confirmButton;
            }
            if ((i & 8) != 0) {
                str4 = noticeInfo.cancelButton;
            }
            return noticeInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.content;
        }

        public final String component3() {
            return this.confirmButton;
        }

        public final String component4() {
            return this.cancelButton;
        }

        public final NoticeInfo copy(String str, String str2, String str3, String str4) {
            return new NoticeInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoticeInfo)) {
                return false;
            }
            NoticeInfo noticeInfo = (NoticeInfo) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) noticeInfo.title) && Intrinsics.areEqual((Object) this.content, (Object) noticeInfo.content) && Intrinsics.areEqual((Object) this.confirmButton, (Object) noticeInfo.confirmButton) && Intrinsics.areEqual((Object) this.cancelButton, (Object) noticeInfo.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.content;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.confirmButton;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cancelButton;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "NoticeInfo(title=" + this.title + ", content=" + this.content + ", confirmButton=" + this.confirmButton + ", cancelButton=" + this.cancelButton + VersionRange.RIGHT_OPEN;
        }

        public NoticeInfo(String str, String str2, String str3, String str4) {
            this.title = str;
            this.content = str2;
            this.confirmButton = str3;
            this.cancelButton = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NoticeInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getConfirmButton() {
            return this.confirmButton;
        }

        public final String getCancelButton() {
            return this.cancelButton;
        }
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixOrderCreateResp$PaymentPasswordInfo;", "Ljava/io/Serializable;", "paySessionId", "", "(Ljava/lang/String;)V", "getPaySessionId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixOrderCreateResp.kt */
    public static final class PaymentPasswordInfo implements Serializable {
        @SerializedName("paySessionId")
        private final String paySessionId;

        public PaymentPasswordInfo() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentPasswordInfo copy$default(PaymentPasswordInfo paymentPasswordInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentPasswordInfo.paySessionId;
            }
            return paymentPasswordInfo.copy(str);
        }

        public final String component1() {
            return this.paySessionId;
        }

        public final PaymentPasswordInfo copy(String str) {
            return new PaymentPasswordInfo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaymentPasswordInfo) && Intrinsics.areEqual((Object) this.paySessionId, (Object) ((PaymentPasswordInfo) obj).paySessionId);
        }

        public int hashCode() {
            String str = this.paySessionId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PaymentPasswordInfo(paySessionId=" + this.paySessionId + VersionRange.RIGHT_OPEN;
        }

        public PaymentPasswordInfo(String str) {
            this.paySessionId = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaymentPasswordInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getPaySessionId() {
            return this.paySessionId;
        }
    }
}
