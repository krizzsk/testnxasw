package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0017J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/unifiedPay/sdk/model/EventInfoModel;", "Ljava/io/Serializable;", "returnUrl", "", "cancelSecondConfirm", "", "cancelPayTitle", "cancelPaySubtitle", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCancelPaySubtitle", "()Ljava/lang/String;", "getCancelPayTitle", "getCancelSecondConfirm", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReturnUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/unifiedPay/sdk/model/EventInfoModel;", "equals", "", "other", "", "hashCode", "intercept", "toString", "pay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EventInfoModel.kt */
public final class EventInfoModel implements Serializable {
    @SerializedName("cancel_pay_subtitle")
    private final String cancelPaySubtitle;
    @SerializedName("cancel_pay_title")
    private final String cancelPayTitle;
    @SerializedName("cancel_second_confirm")
    private final Integer cancelSecondConfirm;
    @SerializedName("return_url")
    private final String returnUrl;

    public static /* synthetic */ EventInfoModel copy$default(EventInfoModel eventInfoModel, String str, Integer num, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventInfoModel.returnUrl;
        }
        if ((i & 2) != 0) {
            num = eventInfoModel.cancelSecondConfirm;
        }
        if ((i & 4) != 0) {
            str2 = eventInfoModel.cancelPayTitle;
        }
        if ((i & 8) != 0) {
            str3 = eventInfoModel.cancelPaySubtitle;
        }
        return eventInfoModel.copy(str, num, str2, str3);
    }

    public final String component1() {
        return this.returnUrl;
    }

    public final Integer component2() {
        return this.cancelSecondConfirm;
    }

    public final String component3() {
        return this.cancelPayTitle;
    }

    public final String component4() {
        return this.cancelPaySubtitle;
    }

    public final EventInfoModel copy(String str, Integer num, String str2, String str3) {
        return new EventInfoModel(str, num, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventInfoModel)) {
            return false;
        }
        EventInfoModel eventInfoModel = (EventInfoModel) obj;
        return Intrinsics.areEqual((Object) this.returnUrl, (Object) eventInfoModel.returnUrl) && Intrinsics.areEqual((Object) this.cancelSecondConfirm, (Object) eventInfoModel.cancelSecondConfirm) && Intrinsics.areEqual((Object) this.cancelPayTitle, (Object) eventInfoModel.cancelPayTitle) && Intrinsics.areEqual((Object) this.cancelPaySubtitle, (Object) eventInfoModel.cancelPaySubtitle);
    }

    public int hashCode() {
        String str = this.returnUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.cancelSecondConfirm;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.cancelPayTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cancelPaySubtitle;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "EventInfoModel(returnUrl=" + this.returnUrl + ", cancelSecondConfirm=" + this.cancelSecondConfirm + ", cancelPayTitle=" + this.cancelPayTitle + ", cancelPaySubtitle=" + this.cancelPaySubtitle + VersionRange.RIGHT_OPEN;
    }

    public EventInfoModel(String str, Integer num, String str2, String str3) {
        this.returnUrl = str;
        this.cancelSecondConfirm = num;
        this.cancelPayTitle = str2;
        this.cancelPaySubtitle = str3;
    }

    public final String getReturnUrl() {
        return this.returnUrl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventInfoModel(String str, Integer num, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 1 : num, str2, str3);
    }

    public final Integer getCancelSecondConfirm() {
        return this.cancelSecondConfirm;
    }

    public final String getCancelPayTitle() {
        return this.cancelPayTitle;
    }

    public final String getCancelPaySubtitle() {
        return this.cancelPaySubtitle;
    }

    public final boolean intercept() {
        Integer num = this.cancelSecondConfirm;
        return num != null && num.intValue() == 1;
    }
}
