package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "biz_content", "sign_type", "sign", "user_select", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "biz_device_info", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getBiz_content", "()Ljava/lang/String;", "setBiz_content", "(Ljava/lang/String;)V", "getBiz_device_info", "setBiz_device_info", "getOut_trade_id", "setOut_trade_id", "getSign", "setSign", "getSign_type", "setSign_type", "getUser_select", "()Ljava/util/List;", "setUser_select", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GetPayInfoRequest.kt */
public final class GetPayInfoRequest extends CashierRequestCommonParams {
    @SerializedName("biz_content")
    private String biz_content;
    @SerializedName("biz_device_info")
    private String biz_device_info;
    @SerializedName("out_trade_id")
    private String out_trade_id;
    @SerializedName("sign")
    private String sign;
    @SerializedName("sign_type")
    private String sign_type;
    @SerializedName("user_select")
    private List<BasicPayment> user_select;

    public GetPayInfoRequest() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetPayInfoRequest copy$default(GetPayInfoRequest getPayInfoRequest, String str, String str2, String str3, String str4, List<BasicPayment> list, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getPayInfoRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            str2 = getPayInfoRequest.biz_content;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = getPayInfoRequest.sign_type;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = getPayInfoRequest.sign;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            list = getPayInfoRequest.user_select;
        }
        List<BasicPayment> list2 = list;
        if ((i & 32) != 0) {
            str5 = getPayInfoRequest.biz_device_info;
        }
        return getPayInfoRequest.copy(str, str6, str7, str8, list2, str5);
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

    public final List<BasicPayment> component5() {
        return this.user_select;
    }

    public final String component6() {
        return this.biz_device_info;
    }

    public final GetPayInfoRequest copy(String str, String str2, String str3, String str4, List<BasicPayment> list, String str5) {
        return new GetPayInfoRequest(str, str2, str3, str4, list, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPayInfoRequest)) {
            return false;
        }
        GetPayInfoRequest getPayInfoRequest = (GetPayInfoRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) getPayInfoRequest.out_trade_id) && Intrinsics.areEqual((Object) this.biz_content, (Object) getPayInfoRequest.biz_content) && Intrinsics.areEqual((Object) this.sign_type, (Object) getPayInfoRequest.sign_type) && Intrinsics.areEqual((Object) this.sign, (Object) getPayInfoRequest.sign) && Intrinsics.areEqual((Object) this.user_select, (Object) getPayInfoRequest.user_select) && Intrinsics.areEqual((Object) this.biz_device_info, (Object) getPayInfoRequest.biz_device_info);
    }

    public int hashCode() {
        String str = this.out_trade_id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.biz_content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sign_type;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sign;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<BasicPayment> list = this.user_select;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.biz_device_info;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "GetPayInfoRequest(out_trade_id=" + this.out_trade_id + ", biz_content=" + this.biz_content + ", sign_type=" + this.sign_type + ", sign=" + this.sign + ", user_select=" + this.user_select + ", biz_device_info=" + this.biz_device_info + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GetPayInfoRequest(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.List r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
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

    public final List<BasicPayment> getUser_select() {
        return this.user_select;
    }

    public final void setUser_select(List<BasicPayment> list) {
        this.user_select = list;
    }

    public final String getBiz_device_info() {
        return this.biz_device_info;
    }

    public final void setBiz_device_info(String str) {
        this.biz_device_info = str;
    }

    public GetPayInfoRequest(String str, String str2, String str3, String str4, List<BasicPayment> list, String str5) {
        this.out_trade_id = str;
        this.biz_content = str2;
        this.sign_type = str3;
        this.sign = str4;
        this.user_select = list;
        this.biz_device_info = str5;
    }
}
