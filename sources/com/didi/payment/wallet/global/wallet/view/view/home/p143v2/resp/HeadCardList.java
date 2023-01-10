package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp;

import android.content.Context;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006 "}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList;", "Ljava/io/Serializable;", "headCardData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData;", "type", "", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData;Ljava/lang/String;)V", "getHeadCardData", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "getCardType", "", "getCouponNum", "()Ljava/lang/Integer;", "hashCode", "isBalance", "isBankType", "isShowBalanceTip", "context", "Landroid/content/Context;", "isShowBankCardTip", "toString", "Companion", "HeadCardData", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList */
/* compiled from: WalletHomeModelTopCardMX.kt */
public final class HeadCardList implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEAD_BALANCE = "balance";
    public static final String HEAD_CARD_BANK = "bankCard";
    public static final int HEAD_CARD_TYPE_BALANCE = 3;
    public static final int HEAD_CARD_TYPE_BANK = 2;
    public static final int HEAD_CARD_TYPE_GUIDE = 1;
    @SerializedName("data")
    private final HeadCardData headCardData;
    @SerializedName("type")
    private final String type;

    public HeadCardList() {
        this((HeadCardData) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeadCardList copy$default(HeadCardList headCardList, HeadCardData headCardData2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            headCardData2 = headCardList.headCardData;
        }
        if ((i & 2) != 0) {
            str = headCardList.type;
        }
        return headCardList.copy(headCardData2, str);
    }

    public final HeadCardData component1() {
        return this.headCardData;
    }

    public final String component2() {
        return this.type;
    }

    public final HeadCardList copy(HeadCardData headCardData2, String str) {
        return new HeadCardList(headCardData2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeadCardList)) {
            return false;
        }
        HeadCardList headCardList = (HeadCardList) obj;
        return Intrinsics.areEqual((Object) this.headCardData, (Object) headCardList.headCardData) && Intrinsics.areEqual((Object) this.type, (Object) headCardList.type);
    }

    public int hashCode() {
        HeadCardData headCardData2 = this.headCardData;
        int i = 0;
        int hashCode = (headCardData2 == null ? 0 : headCardData2.hashCode()) * 31;
        String str = this.type;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "HeadCardList(headCardData=" + this.headCardData + ", type=" + this.type + VersionRange.RIGHT_OPEN;
    }

    public HeadCardList(HeadCardData headCardData2, String str) {
        this.headCardData = headCardData2;
        this.type = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadCardList(HeadCardData headCardData2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : headCardData2, (i & 2) != 0 ? null : str);
    }

    public final HeadCardData getHeadCardData() {
        return this.headCardData;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$Companion;", "", "()V", "HEAD_BALANCE", "", "HEAD_CARD_BANK", "HEAD_CARD_TYPE_BALANCE", "", "HEAD_CARD_TYPE_BANK", "HEAD_CARD_TYPE_GUIDE", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$Companion */
    /* compiled from: WalletHomeModelTopCardMX.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Integer getCouponNum() {
        HeadCardData headCardData2;
        List<HeadCardData.Menu> menuList;
        Integer number;
        if (!Intrinsics.areEqual((Object) this.type, (Object) HEAD_BALANCE) || (headCardData2 = this.headCardData) == null || (menuList = headCardData2.getMenuList()) == null || !(!menuList.isEmpty()) || (number = menuList.get(0).getNumber()) == null) {
            return null;
        }
        return Integer.valueOf(number.intValue());
    }

    private final boolean isBankType() {
        return Intrinsics.areEqual((Object) this.type, (Object) HEAD_CARD_BANK);
    }

    private final boolean isBalance() {
        return Intrinsics.areEqual((Object) this.type, (Object) HEAD_BALANCE);
    }

    public final String isShowBankCardTip(Context context) {
        HeadCardData headCardData2;
        HeadCardData.Menu bottomMenu;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isBankType() || (headCardData2 = this.headCardData) == null || (bottomMenu = headCardData2.getBottomMenu()) == null) {
            return null;
        }
        return bottomMenu.isShowRedDot(context) ? "1" : "0";
    }

    public final String isShowBalanceTip(Context context) {
        HeadCardData headCardData2;
        HeadCardData.Menu bottomMenu;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isBalance() || (headCardData2 = this.headCardData) == null || (bottomMenu = headCardData2.getBottomMenu()) == null) {
            return null;
        }
        return bottomMenu.isShowRedDot(context) ? "1" : "0";
    }

    public final int getCardType() {
        HeadCardData.GuideInfo guideInfo;
        boolean z = false;
        if (!Intrinsics.areEqual((Object) this.type, (Object) HEAD_CARD_BANK)) {
            return Intrinsics.areEqual((Object) this.type, (Object) HEAD_BALANCE) ? 3 : 0;
        }
        HeadCardData headCardData2 = this.headCardData;
        String str = null;
        if (!(headCardData2 == null || (guideInfo = headCardData2.getGuideInfo()) == null)) {
            str = guideInfo.getText();
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            return 2;
        }
        return 1;
    }

    @Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0006012345B_\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jc\u0010'\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\b\u0010,\u001a\u0004\u0018\u00010\u0004J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00066"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData;", "Ljava/io/Serializable;", "menuList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$Menu;", "accountBalance", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;", "cardInfo", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$CardInfo;", "guideInfo", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$GuideInfo;", "tipText", "", "topUp", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TopUp;", "logData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$LogData;", "(Ljava/util/List;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$CardInfo;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$GuideInfo;Ljava/lang/String;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TopUp;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$LogData;)V", "getAccountBalance", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountBalance;", "getCardInfo", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$CardInfo;", "getGuideInfo", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$GuideInfo;", "getLogData", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$LogData;", "getMenuList", "()Ljava/util/List;", "getTipText", "()Ljava/lang/String;", "getTopUp", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TopUp;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getBottomMenu", "hashCode", "", "toString", "CardInfo", "GuideInfo", "LogData", "Menu", "TipText", "TopUp", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData */
    /* compiled from: WalletHomeModelTopCardMX.kt */
    public static final class HeadCardData implements Serializable {
        @SerializedName("accountBalance")
        private final AccountBalance accountBalance;
        @SerializedName("cardInfo")
        private final CardInfo cardInfo;
        @SerializedName("guideInfo")
        private final GuideInfo guideInfo;
        @SerializedName("logData")
        private final LogData logData;
        @SerializedName("menuList")
        private final List<Menu> menuList;
        @SerializedName("tipText")
        private final String tipText;
        @SerializedName("topUp")
        private final TopUp topUp;

        public HeadCardData() {
            this((List) null, (AccountBalance) null, (CardInfo) null, (GuideInfo) null, (String) null, (TopUp) null, (LogData) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ HeadCardData copy$default(HeadCardData headCardData, List<Menu> list, AccountBalance accountBalance2, CardInfo cardInfo2, GuideInfo guideInfo2, String str, TopUp topUp2, LogData logData2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = headCardData.menuList;
            }
            if ((i & 2) != 0) {
                accountBalance2 = headCardData.accountBalance;
            }
            AccountBalance accountBalance3 = accountBalance2;
            if ((i & 4) != 0) {
                cardInfo2 = headCardData.cardInfo;
            }
            CardInfo cardInfo3 = cardInfo2;
            if ((i & 8) != 0) {
                guideInfo2 = headCardData.guideInfo;
            }
            GuideInfo guideInfo3 = guideInfo2;
            if ((i & 16) != 0) {
                str = headCardData.tipText;
            }
            String str2 = str;
            if ((i & 32) != 0) {
                topUp2 = headCardData.topUp;
            }
            TopUp topUp3 = topUp2;
            if ((i & 64) != 0) {
                logData2 = headCardData.logData;
            }
            return headCardData.copy(list, accountBalance3, cardInfo3, guideInfo3, str2, topUp3, logData2);
        }

        public final List<Menu> component1() {
            return this.menuList;
        }

        public final AccountBalance component2() {
            return this.accountBalance;
        }

        public final CardInfo component3() {
            return this.cardInfo;
        }

        public final GuideInfo component4() {
            return this.guideInfo;
        }

        public final String component5() {
            return this.tipText;
        }

        public final TopUp component6() {
            return this.topUp;
        }

        public final LogData component7() {
            return this.logData;
        }

        public final HeadCardData copy(List<Menu> list, AccountBalance accountBalance2, CardInfo cardInfo2, GuideInfo guideInfo2, String str, TopUp topUp2, LogData logData2) {
            return new HeadCardData(list, accountBalance2, cardInfo2, guideInfo2, str, topUp2, logData2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HeadCardData)) {
                return false;
            }
            HeadCardData headCardData = (HeadCardData) obj;
            return Intrinsics.areEqual((Object) this.menuList, (Object) headCardData.menuList) && Intrinsics.areEqual((Object) this.accountBalance, (Object) headCardData.accountBalance) && Intrinsics.areEqual((Object) this.cardInfo, (Object) headCardData.cardInfo) && Intrinsics.areEqual((Object) this.guideInfo, (Object) headCardData.guideInfo) && Intrinsics.areEqual((Object) this.tipText, (Object) headCardData.tipText) && Intrinsics.areEqual((Object) this.topUp, (Object) headCardData.topUp) && Intrinsics.areEqual((Object) this.logData, (Object) headCardData.logData);
        }

        public int hashCode() {
            List<Menu> list = this.menuList;
            int i = 0;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            AccountBalance accountBalance2 = this.accountBalance;
            int hashCode2 = (hashCode + (accountBalance2 == null ? 0 : accountBalance2.hashCode())) * 31;
            CardInfo cardInfo2 = this.cardInfo;
            int hashCode3 = (hashCode2 + (cardInfo2 == null ? 0 : cardInfo2.hashCode())) * 31;
            GuideInfo guideInfo2 = this.guideInfo;
            int hashCode4 = (hashCode3 + (guideInfo2 == null ? 0 : guideInfo2.hashCode())) * 31;
            String str = this.tipText;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            TopUp topUp2 = this.topUp;
            int hashCode6 = (hashCode5 + (topUp2 == null ? 0 : topUp2.hashCode())) * 31;
            LogData logData2 = this.logData;
            if (logData2 != null) {
                i = logData2.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            return "HeadCardData(menuList=" + this.menuList + ", accountBalance=" + this.accountBalance + ", cardInfo=" + this.cardInfo + ", guideInfo=" + this.guideInfo + ", tipText=" + this.tipText + ", topUp=" + this.topUp + ", logData=" + this.logData + VersionRange.RIGHT_OPEN;
        }

        public HeadCardData(List<Menu> list, AccountBalance accountBalance2, CardInfo cardInfo2, GuideInfo guideInfo2, String str, TopUp topUp2, LogData logData2) {
            this.menuList = list;
            this.accountBalance = accountBalance2;
            this.cardInfo = cardInfo2;
            this.guideInfo = guideInfo2;
            this.tipText = str;
            this.topUp = topUp2;
            this.logData = logData2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ HeadCardData(java.util.List r7, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountBalance r8, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.CardInfo r9, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.GuideInfo r10, java.lang.String r11, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.TopUp r12, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.LogData r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r6 = this;
                r15 = r14 & 1
                r0 = 0
                if (r15 == 0) goto L_0x0007
                r15 = r0
                goto L_0x0008
            L_0x0007:
                r15 = r7
            L_0x0008:
                r7 = r14 & 2
                if (r7 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r8
            L_0x000f:
                r7 = r14 & 4
                if (r7 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r9
            L_0x0016:
                r7 = r14 & 8
                if (r7 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r10
            L_0x001d:
                r7 = r14 & 16
                if (r7 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r11
            L_0x0024:
                r7 = r14 & 32
                if (r7 == 0) goto L_0x002a
                r5 = r0
                goto L_0x002b
            L_0x002a:
                r5 = r12
            L_0x002b:
                r7 = r14 & 64
                if (r7 == 0) goto L_0x0031
                r14 = r0
                goto L_0x0032
            L_0x0031:
                r14 = r13
            L_0x0032:
                r7 = r6
                r8 = r15
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.<init>(java.util.List, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountBalance, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$CardInfo, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$GuideInfo, java.lang.String, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$TopUp, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$LogData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final List<Menu> getMenuList() {
            return this.menuList;
        }

        public final AccountBalance getAccountBalance() {
            return this.accountBalance;
        }

        public final CardInfo getCardInfo() {
            return this.cardInfo;
        }

        public final GuideInfo getGuideInfo() {
            return this.guideInfo;
        }

        public final String getTipText() {
            return this.tipText;
        }

        public final TopUp getTopUp() {
            return this.topUp;
        }

        public final LogData getLogData() {
            return this.logData;
        }

        public final Menu getBottomMenu() {
            Collection collection = this.menuList;
            if (!(collection == null || collection.isEmpty())) {
                return this.menuList.get(0);
            }
            return null;
        }

        @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$LogData;", "", "campaign", "", "cardActivityId", "cardNum", "amount", "", "coupon_num", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/String;", "getCampaign", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardActivityId", "getCardNum", "getCoupon_num", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$LogData;", "equals", "", "other", "hashCode", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$LogData */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class LogData {
            @SerializedName("amount")
            private final String amount;
            @SerializedName("campaign")
            private final Integer campaign;
            @SerializedName("card_activity_id")
            private final Integer cardActivityId;
            @SerializedName("card_num")
            private final Integer cardNum;
            @SerializedName("coupon_num")
            private final Integer coupon_num;

            public LogData() {
                this((Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ LogData copy$default(LogData logData, Integer num, Integer num2, Integer num3, String str, Integer num4, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = logData.campaign;
                }
                if ((i & 2) != 0) {
                    num2 = logData.cardActivityId;
                }
                Integer num5 = num2;
                if ((i & 4) != 0) {
                    num3 = logData.cardNum;
                }
                Integer num6 = num3;
                if ((i & 8) != 0) {
                    str = logData.amount;
                }
                String str2 = str;
                if ((i & 16) != 0) {
                    num4 = logData.coupon_num;
                }
                return logData.copy(num, num5, num6, str2, num4);
            }

            public final Integer component1() {
                return this.campaign;
            }

            public final Integer component2() {
                return this.cardActivityId;
            }

            public final Integer component3() {
                return this.cardNum;
            }

            public final String component4() {
                return this.amount;
            }

            public final Integer component5() {
                return this.coupon_num;
            }

            public final LogData copy(Integer num, Integer num2, Integer num3, String str, Integer num4) {
                return new LogData(num, num2, num3, str, num4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LogData)) {
                    return false;
                }
                LogData logData = (LogData) obj;
                return Intrinsics.areEqual((Object) this.campaign, (Object) logData.campaign) && Intrinsics.areEqual((Object) this.cardActivityId, (Object) logData.cardActivityId) && Intrinsics.areEqual((Object) this.cardNum, (Object) logData.cardNum) && Intrinsics.areEqual((Object) this.amount, (Object) logData.amount) && Intrinsics.areEqual((Object) this.coupon_num, (Object) logData.coupon_num);
            }

            public int hashCode() {
                Integer num = this.campaign;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.cardActivityId;
                int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.cardNum;
                int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
                String str = this.amount;
                int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                Integer num4 = this.coupon_num;
                if (num4 != null) {
                    i = num4.hashCode();
                }
                return hashCode4 + i;
            }

            public String toString() {
                return "LogData(campaign=" + this.campaign + ", cardActivityId=" + this.cardActivityId + ", cardNum=" + this.cardNum + ", amount=" + this.amount + ", coupon_num=" + this.coupon_num + VersionRange.RIGHT_OPEN;
            }

            public LogData(Integer num, Integer num2, Integer num3, String str, Integer num4) {
                this.campaign = num;
                this.cardActivityId = num2;
                this.cardNum = num3;
                this.amount = str;
                this.coupon_num = num4;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ LogData(java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.String r8, java.lang.Integer r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
                throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.LogData.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Integer getCampaign() {
                return this.campaign;
            }

            public final Integer getCardActivityId() {
                return this.cardActivityId;
            }

            public final Integer getCardNum() {
                return this.cardNum;
            }

            public final String getAmount() {
                return this.amount;
            }

            public final Integer getCoupon_num() {
                return this.coupon_num;
            }
        }

        @Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0001\u0010*\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0004J\t\u00100\u001a\u00020\rHÖ\u0001J\u0006\u00101\u001a\u00020-J\u000e\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u0002062\u0006\u00103\u001a\u000204J\t\u00107\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u00068"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$Menu;", "Ljava/io/Serializable;", "info", "", "", "lastTipTime", "leftIcon", "linkUrl", "text", "type", "tipOperator", "tipVersion", "number", "", "tipText", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TipText;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TipText;)V", "getInfo", "()Ljava/util/List;", "getLastTipTime", "()Ljava/lang/String;", "getLeftIcon", "getLinkUrl", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "getTipOperator", "getTipText", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TipText;", "getTipVersion", "getType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TipText;)Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$Menu;", "equals", "", "other", "", "hashCode", "isHasCoupon", "isShowRedDot", "context", "Landroid/content/Context;", "saveRedDot", "", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$Menu */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class Menu implements Serializable {
            @SerializedName("info")
            private final List<String> info;
            @SerializedName("lastTipTime")
            private final String lastTipTime;
            @SerializedName("left_icon")
            private final String leftIcon;
            @SerializedName("linkUrl")
            private final String linkUrl;
            @SerializedName("number")
            private final Integer number;
            @SerializedName("text")
            private final String text;
            @SerializedName("tipOperator")
            private final String tipOperator;
            @SerializedName("tipText")
            private final TipText tipText;
            @SerializedName("tipVersion")
            private final String tipVersion;
            @SerializedName("type")
            private final String type;

            public Menu() {
                this((List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (TipText) null, 1023, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Menu copy$default(Menu menu, List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, TipText tipText2, int i, Object obj) {
                Menu menu2 = menu;
                int i2 = i;
                return menu.copy((i2 & 1) != 0 ? menu2.info : list, (i2 & 2) != 0 ? menu2.lastTipTime : str, (i2 & 4) != 0 ? menu2.leftIcon : str2, (i2 & 8) != 0 ? menu2.linkUrl : str3, (i2 & 16) != 0 ? menu2.text : str4, (i2 & 32) != 0 ? menu2.type : str5, (i2 & 64) != 0 ? menu2.tipOperator : str6, (i2 & 128) != 0 ? menu2.tipVersion : str7, (i2 & 256) != 0 ? menu2.number : num, (i2 & 512) != 0 ? menu2.tipText : tipText2);
            }

            public final List<String> component1() {
                return this.info;
            }

            public final TipText component10() {
                return this.tipText;
            }

            public final String component2() {
                return this.lastTipTime;
            }

            public final String component3() {
                return this.leftIcon;
            }

            public final String component4() {
                return this.linkUrl;
            }

            public final String component5() {
                return this.text;
            }

            public final String component6() {
                return this.type;
            }

            public final String component7() {
                return this.tipOperator;
            }

            public final String component8() {
                return this.tipVersion;
            }

            public final Integer component9() {
                return this.number;
            }

            public final Menu copy(List<String> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, TipText tipText2) {
                return new Menu(list, str, str2, str3, str4, str5, str6, str7, num, tipText2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Menu)) {
                    return false;
                }
                Menu menu = (Menu) obj;
                return Intrinsics.areEqual((Object) this.info, (Object) menu.info) && Intrinsics.areEqual((Object) this.lastTipTime, (Object) menu.lastTipTime) && Intrinsics.areEqual((Object) this.leftIcon, (Object) menu.leftIcon) && Intrinsics.areEqual((Object) this.linkUrl, (Object) menu.linkUrl) && Intrinsics.areEqual((Object) this.text, (Object) menu.text) && Intrinsics.areEqual((Object) this.type, (Object) menu.type) && Intrinsics.areEqual((Object) this.tipOperator, (Object) menu.tipOperator) && Intrinsics.areEqual((Object) this.tipVersion, (Object) menu.tipVersion) && Intrinsics.areEqual((Object) this.number, (Object) menu.number) && Intrinsics.areEqual((Object) this.tipText, (Object) menu.tipText);
            }

            public int hashCode() {
                List<String> list = this.info;
                int i = 0;
                int hashCode = (list == null ? 0 : list.hashCode()) * 31;
                String str = this.lastTipTime;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.leftIcon;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.linkUrl;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.text;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.type;
                int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.tipOperator;
                int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.tipVersion;
                int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
                Integer num = this.number;
                int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
                TipText tipText2 = this.tipText;
                if (tipText2 != null) {
                    i = tipText2.hashCode();
                }
                return hashCode9 + i;
            }

            public String toString() {
                return "Menu(info=" + this.info + ", lastTipTime=" + this.lastTipTime + ", leftIcon=" + this.leftIcon + ", linkUrl=" + this.linkUrl + ", text=" + this.text + ", type=" + this.type + ", tipOperator=" + this.tipOperator + ", tipVersion=" + this.tipVersion + ", number=" + this.number + ", tipText=" + this.tipText + VersionRange.RIGHT_OPEN;
            }

            public Menu(List<String> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, TipText tipText2) {
                this.info = list;
                this.lastTipTime = str;
                this.leftIcon = str2;
                this.linkUrl = str3;
                this.text = str4;
                this.type = str5;
                this.tipOperator = str6;
                this.tipVersion = str7;
                this.number = num;
                this.tipText = tipText2;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Menu(java.util.List r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Integer r20, com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.TipText r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
                /*
                    r11 = this;
                    r0 = r22
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r12
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r13
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r14
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r15
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0027
                L_0x0025:
                    r6 = r16
                L_0x0027:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002d
                    r7 = r2
                    goto L_0x002f
                L_0x002d:
                    r7 = r17
                L_0x002f:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0035
                    r8 = r2
                    goto L_0x0037
                L_0x0035:
                    r8 = r18
                L_0x0037:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003d
                    r9 = r2
                    goto L_0x003f
                L_0x003d:
                    r9 = r19
                L_0x003f:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x0045
                    r10 = r2
                    goto L_0x0047
                L_0x0045:
                    r10 = r20
                L_0x0047:
                    r0 = r0 & 512(0x200, float:7.175E-43)
                    if (r0 == 0) goto L_0x004c
                    goto L_0x004e
                L_0x004c:
                    r2 = r21
                L_0x004e:
                    r12 = r11
                    r13 = r1
                    r14 = r3
                    r15 = r4
                    r16 = r5
                    r17 = r6
                    r18 = r7
                    r19 = r8
                    r20 = r9
                    r21 = r10
                    r22 = r2
                    r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.Menu.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$TipText, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final List<String> getInfo() {
                return this.info;
            }

            public final String getLastTipTime() {
                return this.lastTipTime;
            }

            public final String getLeftIcon() {
                return this.leftIcon;
            }

            public final String getLinkUrl() {
                return this.linkUrl;
            }

            public final String getText() {
                return this.text;
            }

            public final String getType() {
                return this.type;
            }

            public final String getTipOperator() {
                return this.tipOperator;
            }

            public final String getTipVersion() {
                return this.tipVersion;
            }

            public final Integer getNumber() {
                return this.number;
            }

            public final TipText getTipText() {
                return this.tipText;
            }

            public final boolean isHasCoupon() {
                TipText tipText2 = this.tipText;
                if (tipText2 != null) {
                    CharSequence text2 = tipText2.getText();
                    if (!(text2 == null || text2.length() == 0)) {
                        return true;
                    }
                }
                return false;
            }

            /* renamed from: getNumber  reason: collision with other method in class */
            public final String m47106getNumber() {
                if (WalletHomeAmountStatus.Companion.isShowAmount()) {
                    return String.valueOf(this.number);
                }
                return WalletHomeAmountStatus.Companion.getEncryptionStr(1);
            }

            public final void saveRedDot(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                CharSequence charSequence = this.tipVersion;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    WalletSPUtils.setSPString(context, Intrinsics.stringPlus(this.type, "Dot"), this.tipVersion);
                }
            }

            public final boolean isShowRedDot(Context context) {
                String sPString;
                Intrinsics.checkNotNullParameter(context, "context");
                if (Intrinsics.areEqual((Object) this.tipOperator, (Object) IMTextUtils.STREET_IMAGE_TAG_START)) {
                    String str = this.tipVersion;
                    long j = 0;
                    long parseLong = str == null ? 0 : Long.parseLong(str);
                    try {
                        String sPString2 = WalletSPUtils.getSPString(context, Intrinsics.stringPlus(this.type, "Dot"));
                        if (sPString2 != null) {
                            if (sPString2.length() > 0) {
                                j = Long.parseLong(sPString2);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (j < parseLong) {
                        return true;
                    }
                    return false;
                }
                if (Intrinsics.areEqual((Object) this.tipOperator, (Object) "!=")) {
                    CharSequence charSequence = this.tipVersion;
                    if (!(charSequence == null || charSequence.length() == 0) && (sPString = WalletSPUtils.getSPString(context, Intrinsics.stringPlus(this.type, "Dot"))) != null) {
                        return !Intrinsics.areEqual((Object) sPString, (Object) getTipVersion());
                    }
                }
                return false;
            }
        }

        @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TipText;", "Ljava/io/Serializable;", "text", "", "info", "(Ljava/lang/String;Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$TipText */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class TipText implements Serializable {
            @SerializedName("info")
            private final String info;
            @SerializedName("text")
            private final String text;

            public TipText() {
                this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ TipText copy$default(TipText tipText, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = tipText.text;
                }
                if ((i & 2) != 0) {
                    str2 = tipText.info;
                }
                return tipText.copy(str, str2);
            }

            public final String component1() {
                return this.text;
            }

            public final String component2() {
                return this.info;
            }

            public final TipText copy(String str, String str2) {
                return new TipText(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TipText)) {
                    return false;
                }
                TipText tipText = (TipText) obj;
                return Intrinsics.areEqual((Object) this.text, (Object) tipText.text) && Intrinsics.areEqual((Object) this.info, (Object) tipText.info);
            }

            public int hashCode() {
                String str = this.text;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.info;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                return "TipText(text=" + this.text + ", info=" + this.info + VersionRange.RIGHT_OPEN;
            }

            public TipText(String str, String str2) {
                this.text = str;
                this.info = str2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ TipText(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getText() {
                return this.text;
            }

            public final String getInfo() {
                return this.info;
            }
        }

        @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$GuideInfo;", "Ljava/io/Serializable;", "linkUrl", "", "promotionText", "Lcom/didi/payment/base/view/PayRichInfo;", "text", "(Ljava/lang/String;Lcom/didi/payment/base/view/PayRichInfo;Ljava/lang/String;)V", "getLinkUrl", "()Ljava/lang/String;", "getPromotionText", "()Lcom/didi/payment/base/view/PayRichInfo;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$GuideInfo */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class GuideInfo implements Serializable {
            @SerializedName("linkUrl")
            private final String linkUrl;
            @SerializedName("promotionText")
            private final PayRichInfo promotionText;
            @SerializedName("text")
            private final String text;

            public GuideInfo() {
                this((String) null, (PayRichInfo) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ GuideInfo copy$default(GuideInfo guideInfo, String str, PayRichInfo payRichInfo, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = guideInfo.linkUrl;
                }
                if ((i & 2) != 0) {
                    payRichInfo = guideInfo.promotionText;
                }
                if ((i & 4) != 0) {
                    str2 = guideInfo.text;
                }
                return guideInfo.copy(str, payRichInfo, str2);
            }

            public final String component1() {
                return this.linkUrl;
            }

            public final PayRichInfo component2() {
                return this.promotionText;
            }

            public final String component3() {
                return this.text;
            }

            public final GuideInfo copy(String str, PayRichInfo payRichInfo, String str2) {
                return new GuideInfo(str, payRichInfo, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GuideInfo)) {
                    return false;
                }
                GuideInfo guideInfo = (GuideInfo) obj;
                return Intrinsics.areEqual((Object) this.linkUrl, (Object) guideInfo.linkUrl) && Intrinsics.areEqual((Object) this.promotionText, (Object) guideInfo.promotionText) && Intrinsics.areEqual((Object) this.text, (Object) guideInfo.text);
            }

            public int hashCode() {
                String str = this.linkUrl;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                PayRichInfo payRichInfo = this.promotionText;
                int hashCode2 = (hashCode + (payRichInfo == null ? 0 : payRichInfo.hashCode())) * 31;
                String str2 = this.text;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "GuideInfo(linkUrl=" + this.linkUrl + ", promotionText=" + this.promotionText + ", text=" + this.text + VersionRange.RIGHT_OPEN;
            }

            public GuideInfo(String str, PayRichInfo payRichInfo, String str2) {
                this.linkUrl = str;
                this.promotionText = payRichInfo;
                this.text = str2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ GuideInfo(String str, PayRichInfo payRichInfo, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : payRichInfo, (i & 4) != 0 ? null : str2);
            }

            public final String getLinkUrl() {
                return this.linkUrl;
            }

            public final PayRichInfo getPromotionText() {
                return this.promotionText;
            }

            public final String getText() {
                return this.text;
            }
        }

        @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\u0006\u0010\u0013\u001a\u00020%J\t\u0010&\u001a\u00020%HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006("}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$CardInfo;", "Ljava/io/Serializable;", "cardIndex", "", "channelId", "detailUrl", "expired", "icon", "cardType", "name", "expireDate", "profileIdentifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardIndex", "()Ljava/lang/String;", "getCardType", "getChannelId", "getDetailUrl", "getExpireDate", "getExpired", "getIcon", "getName", "getProfileIdentifier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "", "hashCode", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$CardInfo */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class CardInfo implements Serializable {
            @SerializedName("cardIndex")
            private final String cardIndex;
            @SerializedName("cardType")
            private final String cardType;
            @SerializedName("channelId")
            private final String channelId;
            @SerializedName("detailUrl")
            private final String detailUrl;
            @SerializedName("expireDate")
            private final String expireDate;
            @SerializedName("expired")
            private final String expired;
            @SerializedName("iconUrl")
            private final String icon;
            @SerializedName("name")
            private final String name;
            @SerializedName("profileIdentifier")
            private final String profileIdentifier;

            public CardInfo() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ CardInfo copy$default(CardInfo cardInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
                CardInfo cardInfo2 = cardInfo;
                int i2 = i;
                return cardInfo.copy((i2 & 1) != 0 ? cardInfo2.cardIndex : str, (i2 & 2) != 0 ? cardInfo2.channelId : str2, (i2 & 4) != 0 ? cardInfo2.detailUrl : str3, (i2 & 8) != 0 ? cardInfo2.expired : str4, (i2 & 16) != 0 ? cardInfo2.icon : str5, (i2 & 32) != 0 ? cardInfo2.cardType : str6, (i2 & 64) != 0 ? cardInfo2.name : str7, (i2 & 128) != 0 ? cardInfo2.expireDate : str8, (i2 & 256) != 0 ? cardInfo2.profileIdentifier : str9);
            }

            public final String component1() {
                return this.cardIndex;
            }

            public final String component2() {
                return this.channelId;
            }

            public final String component3() {
                return this.detailUrl;
            }

            public final String component4() {
                return this.expired;
            }

            public final String component5() {
                return this.icon;
            }

            public final String component6() {
                return this.cardType;
            }

            public final String component7() {
                return this.name;
            }

            public final String component8() {
                return this.expireDate;
            }

            public final String component9() {
                return this.profileIdentifier;
            }

            public final CardInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
                return new CardInfo(str, str2, str3, str4, str5, str6, str7, str8, str9);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CardInfo)) {
                    return false;
                }
                CardInfo cardInfo = (CardInfo) obj;
                return Intrinsics.areEqual((Object) this.cardIndex, (Object) cardInfo.cardIndex) && Intrinsics.areEqual((Object) this.channelId, (Object) cardInfo.channelId) && Intrinsics.areEqual((Object) this.detailUrl, (Object) cardInfo.detailUrl) && Intrinsics.areEqual((Object) this.expired, (Object) cardInfo.expired) && Intrinsics.areEqual((Object) this.icon, (Object) cardInfo.icon) && Intrinsics.areEqual((Object) this.cardType, (Object) cardInfo.cardType) && Intrinsics.areEqual((Object) this.name, (Object) cardInfo.name) && Intrinsics.areEqual((Object) this.expireDate, (Object) cardInfo.expireDate) && Intrinsics.areEqual((Object) this.profileIdentifier, (Object) cardInfo.profileIdentifier);
            }

            public int hashCode() {
                String str = this.cardIndex;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.channelId;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.detailUrl;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.expired;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.icon;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.cardType;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.name;
                int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.expireDate;
                int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
                String str9 = this.profileIdentifier;
                if (str9 != null) {
                    i = str9.hashCode();
                }
                return hashCode8 + i;
            }

            public String toString() {
                return "CardInfo(cardIndex=" + this.cardIndex + ", channelId=" + this.channelId + ", detailUrl=" + this.detailUrl + ", expired=" + this.expired + ", icon=" + this.icon + ", cardType=" + this.cardType + ", name=" + this.name + ", expireDate=" + this.expireDate + ", profileIdentifier=" + this.profileIdentifier + VersionRange.RIGHT_OPEN;
            }

            public CardInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
                this.cardIndex = str;
                this.channelId = str2;
                this.detailUrl = str3;
                this.expired = str4;
                this.icon = str5;
                this.cardType = str6;
                this.name = str7;
                this.expireDate = str8;
                this.profileIdentifier = str9;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ CardInfo(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
                /*
                    r10 = this;
                    r0 = r20
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r11
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r12
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r13
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r14
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0026
                L_0x0025:
                    r6 = r15
                L_0x0026:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002c
                    r7 = r2
                    goto L_0x002e
                L_0x002c:
                    r7 = r16
                L_0x002e:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0034
                    r8 = r2
                    goto L_0x0036
                L_0x0034:
                    r8 = r17
                L_0x0036:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003c
                    r9 = r2
                    goto L_0x003e
                L_0x003c:
                    r9 = r18
                L_0x003e:
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x0043
                    goto L_0x0045
                L_0x0043:
                    r2 = r19
                L_0x0045:
                    r11 = r10
                    r12 = r1
                    r13 = r3
                    r14 = r4
                    r15 = r5
                    r16 = r6
                    r17 = r7
                    r18 = r8
                    r19 = r9
                    r20 = r2
                    r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList.HeadCardData.CardInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final String getCardIndex() {
                return this.cardIndex;
            }

            public final String getChannelId() {
                return this.channelId;
            }

            public final String getDetailUrl() {
                return this.detailUrl;
            }

            /* renamed from: getExpired  reason: collision with other method in class */
            public final String m47105getExpired() {
                return this.expired;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getCardType() {
                return this.cardType;
            }

            public final String getName() {
                return this.name;
            }

            public final String getExpireDate() {
                return this.expireDate;
            }

            public final String getProfileIdentifier() {
                return this.profileIdentifier;
            }

            public final int getExpired() {
                String str = this.expired;
                if (str == null) {
                    return -1;
                }
                return Integer.parseInt(str);
            }
        }

        @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TopUp;", "Ljava/io/Serializable;", "linkUrl", "", "showCoin", "", "title", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getLinkUrl", "()Ljava/lang/String;", "getShowCoin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList$HeadCardData$TopUp;", "equals", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadCardList$HeadCardData$TopUp */
        /* compiled from: WalletHomeModelTopCardMX.kt */
        public static final class TopUp implements Serializable {
            @SerializedName("linkUrl")
            private final String linkUrl;
            @SerializedName("showCoin")
            private final Boolean showCoin;
            @SerializedName("title")
            private final String title;

            public TopUp() {
                this((String) null, (Boolean) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ TopUp copy$default(TopUp topUp, String str, Boolean bool, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = topUp.linkUrl;
                }
                if ((i & 2) != 0) {
                    bool = topUp.showCoin;
                }
                if ((i & 4) != 0) {
                    str2 = topUp.title;
                }
                return topUp.copy(str, bool, str2);
            }

            public final String component1() {
                return this.linkUrl;
            }

            public final Boolean component2() {
                return this.showCoin;
            }

            public final String component3() {
                return this.title;
            }

            public final TopUp copy(String str, Boolean bool, String str2) {
                return new TopUp(str, bool, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TopUp)) {
                    return false;
                }
                TopUp topUp = (TopUp) obj;
                return Intrinsics.areEqual((Object) this.linkUrl, (Object) topUp.linkUrl) && Intrinsics.areEqual((Object) this.showCoin, (Object) topUp.showCoin) && Intrinsics.areEqual((Object) this.title, (Object) topUp.title);
            }

            public int hashCode() {
                String str = this.linkUrl;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Boolean bool = this.showCoin;
                int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                String str2 = this.title;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "TopUp(linkUrl=" + this.linkUrl + ", showCoin=" + this.showCoin + ", title=" + this.title + VersionRange.RIGHT_OPEN;
            }

            public TopUp(String str, Boolean bool, String str2) {
                this.linkUrl = str;
                this.showCoin = bool;
                this.title = str2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ TopUp(String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2);
            }

            public final String getLinkUrl() {
                return this.linkUrl;
            }

            public final Boolean getShowCoin() {
                return this.showCoin;
            }

            public final String getTitle() {
                return this.title;
            }
        }
    }
}
