package com.didi.global.fintech.cashier.model.net.request;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "first_polling", "", "scene", "", "out_trade_id", "biz_device_info", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBiz_device_info", "()Ljava/lang/String;", "setBiz_device_info", "(Ljava/lang/String;)V", "getFirst_polling", "()Z", "setFirst_polling", "(Z)V", "getOut_trade_id", "setOut_trade_id", "getScene", "setScene", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GetPayStatusRequest.kt */
public final class GetPayStatusRequest extends CashierRequestCommonParams {
    @SerializedName("biz_device_info")
    private String biz_device_info;
    @SerializedName("first_polling")
    private boolean first_polling;
    @SerializedName("out_trade_id")
    private String out_trade_id;
    @SerializedName("scene")
    private String scene;

    public GetPayStatusRequest() {
        this(false, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetPayStatusRequest copy$default(GetPayStatusRequest getPayStatusRequest, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = getPayStatusRequest.first_polling;
        }
        if ((i & 2) != 0) {
            str = getPayStatusRequest.scene;
        }
        if ((i & 4) != 0) {
            str2 = getPayStatusRequest.out_trade_id;
        }
        if ((i & 8) != 0) {
            str3 = getPayStatusRequest.biz_device_info;
        }
        return getPayStatusRequest.copy(z, str, str2, str3);
    }

    public final boolean component1() {
        return this.first_polling;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.out_trade_id;
    }

    public final String component4() {
        return this.biz_device_info;
    }

    public final GetPayStatusRequest copy(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "out_trade_id");
        return new GetPayStatusRequest(z, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetPayStatusRequest)) {
            return false;
        }
        GetPayStatusRequest getPayStatusRequest = (GetPayStatusRequest) obj;
        return this.first_polling == getPayStatusRequest.first_polling && Intrinsics.areEqual((Object) this.scene, (Object) getPayStatusRequest.scene) && Intrinsics.areEqual((Object) this.out_trade_id, (Object) getPayStatusRequest.out_trade_id) && Intrinsics.areEqual((Object) this.biz_device_info, (Object) getPayStatusRequest.biz_device_info);
    }

    public int hashCode() {
        boolean z = this.first_polling;
        if (z) {
            z = true;
        }
        int hashCode = (((((z ? 1 : 0) * true) + this.scene.hashCode()) * 31) + this.out_trade_id.hashCode()) * 31;
        String str = this.biz_device_info;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GetPayStatusRequest(first_polling=" + this.first_polling + ", scene=" + this.scene + ", out_trade_id=" + this.out_trade_id + ", biz_device_info=" + this.biz_device_info + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPayStatusRequest(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "PAY" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : str3);
    }

    public final boolean getFirst_polling() {
        return this.first_polling;
    }

    public final void setFirst_polling(boolean z) {
        this.first_polling = z;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.out_trade_id = str;
    }

    public final String getBiz_device_info() {
        return this.biz_device_info;
    }

    public final void setBiz_device_info(String str) {
        this.biz_device_info = str;
    }

    public GetPayStatusRequest(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "out_trade_id");
        this.first_polling = z;
        this.scene = str;
        this.out_trade_id = str2;
        this.biz_device_info = str3;
    }
}
