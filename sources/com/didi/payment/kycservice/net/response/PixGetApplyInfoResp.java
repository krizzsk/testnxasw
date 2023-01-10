package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "getData", "()Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "setData", "(Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;)V", "AddressDetail", "CPFInfo", "PromotionActivity", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixGetApplyInfoResp.kt */
public final class PixGetApplyInfoResp extends WBaseResp {
    private CPFInfo data;

    public final CPFInfo getData() {
        return this.data;
    }

    public final void setData(CPFInfo cPFInfo) {
        this.data = cPFInfo;
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001c\u0010(\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001c\u0010+\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e¨\u0006."}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "", "()V", "addressDetail", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$AddressDetail;", "getAddressDetail", "()Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$AddressDetail;", "setAddressDetail", "(Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$AddressDetail;)V", "birthdate", "", "getBirthdate", "()Ljava/lang/String;", "setBirthdate", "(Ljava/lang/String;)V", "email", "getEmail", "setEmail", "incomeList", "Ljava/util/LinkedList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "getIncomeList", "()Ljava/util/LinkedList;", "setIncomeList", "(Ljava/util/LinkedList;)V", "incomeType", "getIncomeType", "setIncomeType", "name", "getName", "setName", "promotionRule", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$PromotionActivity;", "getPromotionRule", "()Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$PromotionActivity;", "setPromotionRule", "(Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$PromotionActivity;)V", "subTitle", "getSubTitle", "setSubTitle", "taxId", "getTaxId", "setTaxId", "termsUrl", "getTermsUrl", "setTermsUrl", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixGetApplyInfoResp.kt */
    public static final class CPFInfo {
        private AddressDetail addressDetail;
        private String birthdate;
        private String email;
        @SerializedName("incomeDetailList")
        private LinkedList<GuidesInfoResp.Income> incomeList;
        private String incomeType = "";
        private String name;
        private PromotionActivity promotionRule;
        private String subTitle;
        private String taxId;
        private String termsUrl;

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            this.subTitle = str;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getBirthdate() {
            return this.birthdate;
        }

        public final void setBirthdate(String str) {
            this.birthdate = str;
        }

        public final String getTaxId() {
            return this.taxId;
        }

        public final void setTaxId(String str) {
            this.taxId = str;
        }

        public final String getTermsUrl() {
            return this.termsUrl;
        }

        public final void setTermsUrl(String str) {
            this.termsUrl = str;
        }

        public final PromotionActivity getPromotionRule() {
            return this.promotionRule;
        }

        public final void setPromotionRule(PromotionActivity promotionActivity) {
            this.promotionRule = promotionActivity;
        }

        public final String getEmail() {
            return this.email;
        }

        public final void setEmail(String str) {
            this.email = str;
        }

        public final AddressDetail getAddressDetail() {
            return this.addressDetail;
        }

        public final void setAddressDetail(AddressDetail addressDetail2) {
            this.addressDetail = addressDetail2;
        }

        public final String getIncomeType() {
            return this.incomeType;
        }

        public final void setIncomeType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.incomeType = str;
        }

        public final LinkedList<GuidesInfoResp.Income> getIncomeList() {
            return this.incomeList;
        }

        public final void setIncomeList(LinkedList<GuidesInfoResp.Income> linkedList) {
            this.incomeList = linkedList;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$PromotionActivity;", "", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixGetApplyInfoResp.kt */
    public static final class PromotionActivity {
        private String text;
        private String url;

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, mo148868d2 = {"Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$AddressDetail;", "", "()V", "city", "", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "complement", "getComplement", "setComplement", "needHideNumber", "", "getNeedHideNumber", "()Z", "setNeedHideNumber", "(Z)V", "neighborhood", "getNeighborhood", "setNeighborhood", "number", "getNumber", "setNumber", "state", "getState", "setState", "streetName", "getStreetName", "setStreetName", "zipCode", "getZipCode", "setZipCode", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixGetApplyInfoResp.kt */
    public static final class AddressDetail {
        private String city;
        private String complement;
        private boolean needHideNumber;
        private String neighborhood;
        private String number;
        private String state;
        private String streetName;
        private String zipCode;

        public final String getZipCode() {
            return this.zipCode;
        }

        public final void setZipCode(String str) {
            this.zipCode = str;
        }

        public final String getState() {
            return this.state;
        }

        public final void setState(String str) {
            this.state = str;
        }

        public final String getCity() {
            return this.city;
        }

        public final void setCity(String str) {
            this.city = str;
        }

        public final String getNeighborhood() {
            return this.neighborhood;
        }

        public final void setNeighborhood(String str) {
            this.neighborhood = str;
        }

        public final String getStreetName() {
            return this.streetName;
        }

        public final void setStreetName(String str) {
            this.streetName = str;
        }

        public final String getNumber() {
            return this.number;
        }

        public final void setNumber(String str) {
            this.number = str;
        }

        public final String getComplement() {
            return this.complement;
        }

        public final void setComplement(String str) {
            this.complement = str;
        }

        public final boolean getNeedHideNumber() {
            return this.needHideNumber;
        }

        public final void setNeedHideNumber(boolean z) {
            this.needHideNumber = z;
        }
    }
}
