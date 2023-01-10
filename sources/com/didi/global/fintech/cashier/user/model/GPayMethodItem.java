package com.didi.global.fintech.cashier.user.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "Ljava/io/Serializable;", "channelId", "", "extraInfo", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;", "(Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;)V", "getChannelId", "()Ljava/lang/Integer;", "setChannelId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtraInfo", "()Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;", "setExtraInfo", "(Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;)Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "equals", "", "other", "", "hashCode", "toString", "", "ExtraInfo", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GPayMethodItem.kt */
public final class GPayMethodItem implements Serializable {
    private Integer channelId;
    private ExtraInfo extraInfo;

    public GPayMethodItem() {
        this((Integer) null, (ExtraInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GPayMethodItem copy$default(GPayMethodItem gPayMethodItem, Integer num, ExtraInfo extraInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gPayMethodItem.channelId;
        }
        if ((i & 2) != 0) {
            extraInfo2 = gPayMethodItem.extraInfo;
        }
        return gPayMethodItem.copy(num, extraInfo2);
    }

    public final Integer component1() {
        return this.channelId;
    }

    public final ExtraInfo component2() {
        return this.extraInfo;
    }

    public final GPayMethodItem copy(Integer num, ExtraInfo extraInfo2) {
        return new GPayMethodItem(num, extraInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GPayMethodItem)) {
            return false;
        }
        GPayMethodItem gPayMethodItem = (GPayMethodItem) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) gPayMethodItem.channelId) && Intrinsics.areEqual((Object) this.extraInfo, (Object) gPayMethodItem.extraInfo);
    }

    public int hashCode() {
        Integer num = this.channelId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        ExtraInfo extraInfo2 = this.extraInfo;
        if (extraInfo2 != null) {
            i = extraInfo2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GPayMethodItem(channelId=" + this.channelId + ", extraInfo=" + this.extraInfo + VersionRange.RIGHT_OPEN;
    }

    public GPayMethodItem(Integer num, ExtraInfo extraInfo2) {
        this.channelId = num;
        this.extraInfo = extraInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GPayMethodItem(Integer num, ExtraInfo extraInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : extraInfo2);
    }

    public final Integer getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(Integer num) {
        this.channelId = num;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final void setExtraInfo(ExtraInfo extraInfo2) {
        this.extraInfo = extraInfo2;
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;", "Ljava/io/Serializable;", "cardIndex", "", "installmentNumber", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCardIndex", "()Ljava/lang/String;", "setCardIndex", "(Ljava/lang/String;)V", "getInstallmentNumber", "()Ljava/lang/Integer;", "setInstallmentNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem$ExtraInfo;", "equals", "", "other", "", "hashCode", "toString", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: GPayMethodItem.kt */
    public static final class ExtraInfo implements Serializable {
        private String cardIndex;
        private Integer installmentNumber;

        public ExtraInfo() {
            this((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ExtraInfo copy$default(ExtraInfo extraInfo, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = extraInfo.cardIndex;
            }
            if ((i & 2) != 0) {
                num = extraInfo.installmentNumber;
            }
            return extraInfo.copy(str, num);
        }

        public final String component1() {
            return this.cardIndex;
        }

        public final Integer component2() {
            return this.installmentNumber;
        }

        public final ExtraInfo copy(String str, Integer num) {
            return new ExtraInfo(str, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExtraInfo)) {
                return false;
            }
            ExtraInfo extraInfo = (ExtraInfo) obj;
            return Intrinsics.areEqual((Object) this.cardIndex, (Object) extraInfo.cardIndex) && Intrinsics.areEqual((Object) this.installmentNumber, (Object) extraInfo.installmentNumber);
        }

        public int hashCode() {
            String str = this.cardIndex;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.installmentNumber;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ExtraInfo(cardIndex=" + this.cardIndex + ", installmentNumber=" + this.installmentNumber + VersionRange.RIGHT_OPEN;
        }

        public ExtraInfo(String str, Integer num) {
            this.cardIndex = str;
            this.installmentNumber = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExtraInfo(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        public final String getCardIndex() {
            return this.cardIndex;
        }

        public final void setCardIndex(String str) {
            this.cardIndex = str;
        }

        public final Integer getInstallmentNumber() {
            return this.installmentNumber;
        }

        public final void setInstallmentNumber(Integer num) {
            this.installmentNumber = num;
        }
    }
}
