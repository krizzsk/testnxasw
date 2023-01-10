package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u00062"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/ChangePayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "biz_content", "sign_type", "sign", "biz_device_info", "from_select", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "to_select", "select_trigger", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBiz_content", "()Ljava/lang/String;", "setBiz_content", "(Ljava/lang/String;)V", "getBiz_device_info", "setBiz_device_info", "getFrom_select", "()Ljava/util/List;", "setFrom_select", "(Ljava/util/List;)V", "getOut_trade_id", "setOut_trade_id", "getSelect_trigger", "setSelect_trigger", "getSign", "setSign", "getSign_type", "setSign_type", "getTo_select", "setTo_select", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ChangePayInfoRequest.kt */
public final class ChangePayInfoRequest extends CashierRequestCommonParams {
    @SerializedName("biz_content")
    private String biz_content;
    @SerializedName("biz_device_info")
    private String biz_device_info;
    private List<BasicPayment> from_select;
    private String out_trade_id;
    private String select_trigger;
    @SerializedName("sign")
    private String sign;
    @SerializedName("sign_type")
    private String sign_type;
    private List<BasicPayment> to_select;

    public ChangePayInfoRequest() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangePayInfoRequest copy$default(ChangePayInfoRequest changePayInfoRequest, String str, String str2, String str3, String str4, String str5, List list, List list2, String str6, int i, Object obj) {
        ChangePayInfoRequest changePayInfoRequest2 = changePayInfoRequest;
        int i2 = i;
        return changePayInfoRequest.copy((i2 & 1) != 0 ? changePayInfoRequest2.out_trade_id : str, (i2 & 2) != 0 ? changePayInfoRequest2.biz_content : str2, (i2 & 4) != 0 ? changePayInfoRequest2.sign_type : str3, (i2 & 8) != 0 ? changePayInfoRequest2.sign : str4, (i2 & 16) != 0 ? changePayInfoRequest2.biz_device_info : str5, (i2 & 32) != 0 ? changePayInfoRequest2.from_select : list, (i2 & 64) != 0 ? changePayInfoRequest2.to_select : list2, (i2 & 128) != 0 ? changePayInfoRequest2.select_trigger : str6);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final String component2() {
        return this.biz_content;
    }

    public final String component3() {
        return this.sign_type;
    }

    public final String component4() {
        return this.sign;
    }

    public final String component5() {
        return this.biz_device_info;
    }

    public final List<BasicPayment> component6() {
        return this.from_select;
    }

    public final List<BasicPayment> component7() {
        return this.to_select;
    }

    public final String component8() {
        return this.select_trigger;
    }

    public final ChangePayInfoRequest copy(String str, String str2, String str3, String str4, String str5, List<BasicPayment> list, List<BasicPayment> list2, String str6) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        List<BasicPayment> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "from_select");
        List<BasicPayment> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "to_select");
        return new ChangePayInfoRequest(str, str2, str3, str4, str5, list3, list4, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePayInfoRequest)) {
            return false;
        }
        ChangePayInfoRequest changePayInfoRequest = (ChangePayInfoRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) changePayInfoRequest.out_trade_id) && Intrinsics.areEqual((Object) this.biz_content, (Object) changePayInfoRequest.biz_content) && Intrinsics.areEqual((Object) this.sign_type, (Object) changePayInfoRequest.sign_type) && Intrinsics.areEqual((Object) this.sign, (Object) changePayInfoRequest.sign) && Intrinsics.areEqual((Object) this.biz_device_info, (Object) changePayInfoRequest.biz_device_info) && Intrinsics.areEqual((Object) this.from_select, (Object) changePayInfoRequest.from_select) && Intrinsics.areEqual((Object) this.to_select, (Object) changePayInfoRequest.to_select) && Intrinsics.areEqual((Object) this.select_trigger, (Object) changePayInfoRequest.select_trigger);
    }

    public int hashCode() {
        int hashCode = this.out_trade_id.hashCode() * 31;
        String str = this.biz_content;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sign_type;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sign;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.biz_device_info;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.from_select.hashCode()) * 31) + this.to_select.hashCode()) * 31;
        String str5 = this.select_trigger;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ChangePayInfoRequest(out_trade_id=" + this.out_trade_id + ", biz_content=" + this.biz_content + ", sign_type=" + this.sign_type + ", sign=" + this.sign + ", biz_device_info=" + this.biz_device_info + ", from_select=" + this.from_select + ", to_select=" + this.to_select + ", select_trigger=" + this.select_trigger + VersionRange.RIGHT_OPEN;
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    public final String getBiz_content() {
        return this.biz_content;
    }

    public final void setBiz_content(String str) {
        this.biz_content = str;
    }

    public final String getSign_type() {
        return this.sign_type;
    }

    public final void setSign_type(String str) {
        this.sign_type = str;
    }

    public final String getSign() {
        return this.sign;
    }

    public final void setSign(String str) {
        this.sign = str;
    }

    public final String getBiz_device_info() {
        return this.biz_device_info;
    }

    public final void setBiz_device_info(String str) {
        this.biz_device_info = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChangePayInfoRequest(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.util.List r15, java.util.List r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r11
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r3
            goto L_0x0027
        L_0x0026:
            r6 = r14
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0033
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            goto L_0x0034
        L_0x0033:
            r7 = r15
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0040
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            goto L_0x0042
        L_0x0040:
            r8 = r16
        L_0x0042:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r3 = r17
        L_0x0049:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<BasicPayment> getFrom_select() {
        return this.from_select;
    }

    public final void setFrom_select(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.from_select = list;
    }

    public final List<BasicPayment> getTo_select() {
        return this.to_select;
    }

    public final void setTo_select(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.to_select = list;
    }

    public final String getSelect_trigger() {
        return this.select_trigger;
    }

    public final void setSelect_trigger(String str) {
        this.select_trigger = str;
    }

    public ChangePayInfoRequest(String str, String str2, String str3, String str4, String str5, List<BasicPayment> list, List<BasicPayment> list2, String str6) {
        Intrinsics.checkNotNullParameter(str, "out_trade_id");
        Intrinsics.checkNotNullParameter(list, "from_select");
        Intrinsics.checkNotNullParameter(list2, "to_select");
        this.out_trade_id = str;
        this.biz_content = str2;
        this.sign_type = str3;
        this.sign = str4;
        this.biz_device_info = str5;
        this.from_select = list;
        this.to_select = list2;
        this.select_trigger = str6;
    }
}
