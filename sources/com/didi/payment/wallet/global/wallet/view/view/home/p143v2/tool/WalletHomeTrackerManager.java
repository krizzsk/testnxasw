package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool;

import android.content.Context;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.FinResOmegaUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountBalance;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BankCard;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BannerEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BannerSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BuryInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Coupon;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.FinancialEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.FinancialSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.IconEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.QuickFunctionSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.ResourceStateData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeTrackerManager;", "", "()V", "Companion", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager */
/* compiled from: WalletHomeTrackerManager.kt */
public final class WalletHomeTrackerManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f35337a = "pub_page";

    /* renamed from: b */
    private static final String f35338b = "wallet_account_status";

    /* renamed from: c */
    private static final String f35339c = "pub_source";

    /* renamed from: d */
    private static final String f35340d = "pub_biz";

    /* renamed from: e */
    private static final String f35341e = "pub_biz_line";

    /* renamed from: f */
    private static final String f35342f = "pub_subbiz";

    /* renamed from: g */
    private static final String f35343g = "pub_uid";

    /* renamed from: h */
    private static final String f35344h = "resource_id";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static String f35345i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static String f35346j = "2";
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static String f35347k = "";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static String f35348l = "";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static Integer f35349m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static String f35350n = "";
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static String f35351o = "";

    @JvmStatic
    public static final void trackTransferPageSW() {
        Companion.trackTransferPageSW();
    }

    @Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010(H\u0002J\u0016\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010(H\u0002J \u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0004JM\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u00010\u0004J\u0010\u00103\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000104J)\u00105\u001a\u00020,2\b\u00106\u001a\u0004\u0018\u00010\u00182\u0006\u00107\u001a\u00020\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u00020,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010>J\u0010\u0010?\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010@J\u0010\u0010A\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010BJ.\u0010C\u001a\u00020,2&\u0010D\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`FJ.\u0010G\u001a\u00020,2&\u0010D\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`FJ\"\u0010H\u001a\u00020,2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010/\u001a\u0004\u0018\u00010K2\u0006\u00106\u001a\u00020\u0004J.\u0010L\u001a\u00020,2&\u0010D\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`FJ0\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010(2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010/\u001a\u0004\u0018\u00010K2\u0006\u0010N\u001a\u00020OJ$\u0010P\u001a\u00020,2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u00042\b\u0010R\u001a\u0004\u0018\u00010\u0004J\u001a\u0010S\u001a\u00020,2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0004J\u0010\u0010T\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u00010\u0004J\u0006\u0010U\u001a\u00020,J\u0010\u0010V\u001a\u00020,2\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0006\u0010X\u001a\u00020,J\u0006\u0010Y\u001a\u00020,J\u0006\u0010Z\u001a\u00020,J\u0006\u0010[\u001a\u00020,J\u0010\u0010\\\u001a\u00020,2\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0010\u0010]\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010^J\u0006\u0010_\u001a\u00020,J\u0006\u0010`\u001a\u00020,J\u0006\u0010a\u001a\u00020,J\u0010\u0010b\u001a\u00020,2\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0010\u0010c\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010dJ\u0006\u0010e\u001a\u00020,J\u0010\u0010f\u001a\u00020,2\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0010\u0010g\u001a\u00020,2\b\u0010W\u001a\u0004\u0018\u00010\u0004J\b\u0010h\u001a\u00020,H\u0007J\u0018\u0010i\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u0004J\u0010\u0010j\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u00010\u0004J\u0010\u0010k\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010lR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010¨\u0006m"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletHomeTrackerManager$Companion;", "", "()V", "TRACKER_WALLET_ACCOUNT_STATUS", "", "TRACKER_WALLET_HOME_PAY", "TRACKER_WALLET_HOME_PAY_LINE", "TRACKER_WALLET_HOME_PAY_SUBBIZ", "TRACKER_WALLET_HOME_PAY_UID", "TRACKER_WALLET_HOME_RESOURCE_ID", "TRACKER_WALLET_HOME_SOURCE", "TRACKER_WALLET_HOME_SW", "authenticationStatus", "getAuthenticationStatus", "()Ljava/lang/String;", "setAuthenticationStatus", "(Ljava/lang/String;)V", "balance", "getBalance", "setBalance", "cardNum", "getCardNum", "setCardNum", "prepaidType", "", "getPrepaidType", "()Ljava/lang/Integer;", "setPrepaidType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "resourceId", "getResourceId", "setResourceId", "source", "getSource", "setSource", "status", "getStatus", "setStatus", "getBasePrepaid", "", "map", "getHomeBaseSW", "init", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "trackBankListPageClick", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Entry;", "trackBannerClick", "url", "trackBannerSW", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BannerSection;", "trackCardPrepaidApply", "type", "eventId", "isVisible", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "trackFinBannerCK", "banner", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/ResourceStateData;", "trackFinBannerSW", "", "trackFinancialClick", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/FinancialEntry;", "trackFinancialSW", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/FinancialSection;", "trackHomeCard", "tempMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "trackHomeCardCK", "trackHomeCardClick", "context", "Landroid/content/Context;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "trackHomeCardHomePage", "trackHomeCardSW", "isTrack", "", "trackHomeKycPopupCK", "blockId", "btnName", "trackHomeKycPopupSW", "trackHomeNavigation", "trackHomePrepaidDialog", "trackHomePrepaidDialogClick", "name", "trackHomePublicMsgCK", "trackHomePublicMsgClose", "trackHomePublicMsgSW", "trackHomeSW", "trackPaySKUClick", "trackPaySKUSW", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PaySection;", "trackPrepaidSettingFailed", "trackPrepaidSettingPwdIntroduce", "trackPrepaidSettingPwdIntroduceClick", "trackQuickFunctionClick", "trackQuickFunctionSW", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/QuickFunctionSection;", "trackTopupPrepaidDialog", "trackTopupPrepaidDialogClick", "trackTransferClick", "trackTransferPageSW", "trackWalletHomeDialogClick", "trackWalletHomeDialogSW", "trackerBankListPageSW", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Data;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion */
    /* compiled from: WalletHomeTrackerManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getStatus() {
            return WalletHomeTrackerManager.f35345i;
        }

        public final void setStatus(String str) {
            WalletHomeTrackerManager.f35345i = str;
        }

        public final String getSource() {
            return WalletHomeTrackerManager.f35346j;
        }

        public final void setSource(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletHomeTrackerManager.f35346j = str;
        }

        public final String getAuthenticationStatus() {
            return WalletHomeTrackerManager.f35347k;
        }

        public final void setAuthenticationStatus(String str) {
            WalletHomeTrackerManager.f35347k = str;
        }

        public final String getCardNum() {
            return WalletHomeTrackerManager.f35348l;
        }

        public final void setCardNum(String str) {
            WalletHomeTrackerManager.f35348l = str;
        }

        public final Integer getPrepaidType() {
            return WalletHomeTrackerManager.f35349m;
        }

        public final void setPrepaidType(Integer num) {
            WalletHomeTrackerManager.f35349m = num;
        }

        public final String getBalance() {
            return WalletHomeTrackerManager.f35350n;
        }

        public final void setBalance(String str) {
            WalletHomeTrackerManager.f35350n = str;
        }

        public final String getResourceId() {
            return WalletHomeTrackerManager.f35351o;
        }

        public final void setResourceId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WalletHomeTrackerManager.f35351o = str;
        }

        public final void init(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, InvitationPageActivity.RESOURCE_ID);
            Intrinsics.checkNotNullParameter(str3, "source");
            setResourceId(str);
            setStatus(str2);
            setSource(str3);
        }

        public final void init(String str, String str2, String str3, String str4, String str5, Integer num, String str6) {
            Intrinsics.checkNotNullParameter(str, InvitationPageActivity.RESOURCE_ID);
            Intrinsics.checkNotNullParameter(str3, "source");
            init(str, str2, str3);
            setAuthenticationStatus(str4);
            setCardNum(str5);
            setPrepaidType(num);
            setBalance(str6);
        }

        private final Map<String, Object> getHomeBaseSW() {
            Map<String, Object> linkedHashMap = new LinkedHashMap<>();
            String str = "wallet_home";
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, str);
            linkedHashMap.put(WalletHomeTrackerManager.f35338b, WalletHomeTrackerManager.Companion.getStatus());
            linkedHashMap.put("resource_id", WalletHomeTrackerManager.Companion.getResourceId());
            if (Intrinsics.areEqual((Object) WalletHomeTrackerManager.Companion.getSource(), (Object) "1")) {
                str = "wallet_mainlist";
            }
            linkedHashMap.put("pub_source", str);
            linkedHashMap.put(WalletHomeTrackerManager.f35340d, "fintech");
            linkedHashMap.put("pub_biz_line", Const.PubBizLine.FIN);
            linkedHashMap.put(WalletHomeTrackerManager.f35342f, "payment");
            linkedHashMap.put("pub_uid", PayBaseParamUtil.getStringParam(ApplicationContextProvider.Companion.getContext(), "uid"));
            return linkedHashMap;
        }

        public final void trackHomeSW() {
            FinOmegaSDK.trackEvent("ibt_wallet_home_sw", getHomeBaseSW());
        }

        public final void trackHomeNavigation(String str) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("button_name", "top_entrance");
            homeBaseSW.put("entrance_url", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_ck", homeBaseSW);
        }

        public final void trackHomePublicMsgSW() {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "notice");
            FinOmegaSDK.trackEvent("ibt_wallet_home_notice_sw", homeBaseSW);
        }

        public final void trackHomePublicMsgClose() {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "notice");
            homeBaseSW.put("button_name", "close");
            FinOmegaSDK.trackEvent("ibt_wallet_home_notice_ck", homeBaseSW);
        }

        public final Map<String, Object> trackHomeCardSW(Context context, Data data, boolean z) {
            String str;
            String str2;
            String str3;
            String str4;
            AccountSection accountSection;
            Coupon coupon;
            AccountSection accountSection2;
            Coupon coupon2;
            AccountSection accountSection3;
            BankCard bankCard;
            AccountSection accountSection4;
            AccountStatusMessage accountStatusMessage;
            AccountSection accountSection5;
            AccountBalance accountBalance;
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", HeadCardList.HEAD_BALANCE);
            String str5 = null;
            if (data == null || (accountSection5 = data.getAccountSection()) == null || (accountBalance = accountSection5.getAccountBalance()) == null) {
                str = null;
            } else {
                str = accountBalance.getBalance();
            }
            homeBaseSW.put("amount", str);
            homeBaseSW.put("balance_show", Integer.valueOf(WalletHomeAmountStatus.Companion.isShowAmount() ? 1 : 0));
            if (data == null || (accountSection4 = data.getAccountSection()) == null || (accountStatusMessage = accountSection4.getAccountStatusMessage()) == null) {
                str2 = null;
            } else {
                str2 = accountStatusMessage.getStatus();
            }
            homeBaseSW.put("verify_status", str2);
            homeBaseSW.put("card_activity_id", "");
            if (data == null || (accountSection3 = data.getAccountSection()) == null || (bankCard = accountSection3.getBankCard()) == null) {
                str3 = null;
            } else {
                str3 = bankCard.getCardNum();
            }
            homeBaseSW.put("card_num", str3);
            if (data == null || (accountSection2 = data.getAccountSection()) == null || (coupon2 = accountSection2.getCoupon()) == null) {
                str4 = null;
            } else {
                str4 = coupon2.getCouponNum();
            }
            homeBaseSW.put(ParamConst.PARAM_COUPON_NUM, str4);
            if (context != null) {
                WalletHomeController.Companion companion = WalletHomeController.Companion;
                if (!(data == null || (accountSection = data.getAccountSection()) == null || (coupon = accountSection.getCoupon()) == null)) {
                    str5 = coupon.getLastCouponTime();
                }
                homeBaseSW.put("new_coupon", Boolean.valueOf(companion.isShowCouponRedDot(context, str5)));
            }
            if (z) {
                homeBaseSW.put("pub_from_page", "");
                FinOmegaSDK.trackEvent("ibt_wallet_home_balance_sw", homeBaseSW);
            }
            return homeBaseSW;
        }

        public final void trackHomeCardClick(Context context, Data data, String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            Map<String, Object> trackHomeCardSW = trackHomeCardSW(context, data, false);
            trackHomeCardSW.put("button_name", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_balance_ck", trackHomeCardSW);
        }

        public final void trackQuickFunctionSW(QuickFunctionSection quickFunctionSection) {
            List<Entry> entryList;
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "entrance_fast");
            List list = null;
            if (!(quickFunctionSection == null || (entryList = quickFunctionSection.getEntryList()) == null)) {
                Iterable<Entry> iterable = entryList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Entry name : iterable) {
                    arrayList.add(name.getName());
                }
                list = (List) arrayList;
            }
            homeBaseSW.put("entrance_list", GsonUtils.toJson(list, true));
            FinOmegaSDK.trackEvent("ibt_wallet_home_entrance_fast_sw", homeBaseSW);
        }

        public final void trackQuickFunctionClick(String str) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "entrance_fast");
            homeBaseSW.put("button_name", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_entrance_fast_ck", homeBaseSW);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void trackPaySKUSW(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.PaySection r8) {
            /*
                r7 = this;
                java.util.Map r0 = r7.getHomeBaseSW()
                java.lang.String r1 = "pub_target"
                java.lang.String r2 = "entrance_payment"
                r0.put(r1, r2)
                r1 = 0
                if (r8 != 0) goto L_0x000f
                goto L_0x005b
            L_0x000f:
                java.util.List r8 = r8.getEntryList()
                if (r8 != 0) goto L_0x0016
                goto L_0x005b
            L_0x0016:
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r3)
                r2.<init>(r3)
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r8 = r8.iterator()
            L_0x0029:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L_0x0058
                java.lang.Object r3 = r8.next()
                com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = (com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Entry) r3
                java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                r4.<init>()
                java.util.Map r4 = (java.util.Map) r4
                java.lang.String r5 = r3.getName()
                java.lang.String r6 = "entrance_name"
                r4.put(r6, r5)
                com.didi.payment.base.view.PayRichInfo r3 = r3.getPromotionText()
                if (r3 != 0) goto L_0x004d
                r3 = r1
                goto L_0x004f
            L_0x004d:
                java.lang.String r3 = r3.text
            L_0x004f:
                java.lang.String r5 = "resource_text"
                r4.put(r5, r3)
                r2.add(r4)
                goto L_0x0029
            L_0x0058:
                r1 = r2
                java.util.List r1 = (java.util.List) r1
            L_0x005b:
                r8 = 1
                java.lang.String r8 = com.didichuxing.dfbasesdk.utils.GsonUtils.toJson(r1, r8)
                java.lang.String r1 = "entrance_list"
                r0.put(r1, r8)
                java.lang.String r8 = "ibt_wallet_home_entrance_payment_sw"
                com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r8, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion.trackPaySKUSW(com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.PaySection):void");
        }

        public final void trackPaySKUClick(String str) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "entrance_payment");
            homeBaseSW.put("button_name", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_entrance_payment_ck", homeBaseSW);
        }

        public final void trackFinancialSW(FinancialSection financialSection) {
            List<FinancialEntry> entryList;
            if (financialSection != null && (entryList = financialSection.getEntryList()) != null) {
                Map<String, Object> homeBaseSW = WalletHomeTrackerManager.Companion.getHomeBaseSW();
                homeBaseSW.put("pub_target", "entrance_credit");
                Iterable<FinancialEntry> iterable = entryList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (FinancialEntry financialEntry : iterable) {
                    Map linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("entrance_name", financialEntry.getTitle());
                    IconEntry icon = financialEntry.getIcon();
                    String str = null;
                    linkedHashMap.put("resource_text", icon == null ? null : icon.getText());
                    linkedHashMap.put("status", financialEntry.getStatus());
                    linkedHashMap.put("amount", financialEntry.getAmount());
                    Map linkedHashMap2 = new LinkedHashMap();
                    BuryInfo buryInfo = financialEntry.getBuryInfo();
                    linkedHashMap2.put("campaign_id", buryInfo == null ? null : buryInfo.getCampaignId());
                    BuryInfo buryInfo2 = financialEntry.getBuryInfo();
                    if (buryInfo2 != null) {
                        str = buryInfo2.getChannelId();
                    }
                    linkedHashMap2.put("channel_id", str);
                    linkedHashMap.put("buryInfo", linkedHashMap2);
                    arrayList.add(linkedHashMap);
                }
                homeBaseSW.put("entrance_list", GsonUtils.toJson((List) arrayList, true));
                FinOmegaSDK.trackEvent("ibt_wallet_home_entrance_credit_sw", homeBaseSW);
            }
        }

        public final void trackFinancialClick(FinancialEntry financialEntry) {
            String str;
            String str2;
            BuryInfo buryInfo;
            BuryInfo buryInfo2;
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "entrance_credit");
            String str3 = null;
            if (financialEntry == null) {
                str = null;
            } else {
                str = financialEntry.getTitle();
            }
            homeBaseSW.put("button_name", str);
            Map linkedHashMap = new LinkedHashMap();
            if (financialEntry == null || (buryInfo2 = financialEntry.getBuryInfo()) == null) {
                str2 = null;
            } else {
                str2 = buryInfo2.getCampaignId();
            }
            linkedHashMap.put("campaign_id", str2);
            if (!(financialEntry == null || (buryInfo = financialEntry.getBuryInfo()) == null)) {
                str3 = buryInfo.getChannelId();
            }
            linkedHashMap.put("channel_id", str3);
            homeBaseSW.put("buryInfo", GsonUtils.toJson(linkedHashMap, true));
            FinOmegaSDK.trackEvent("ibt_wallet_home_entrance_credit_ck", homeBaseSW);
        }

        public final void trackBannerSW(BannerSection bannerSection) {
            List<BannerEntry> entryList;
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", Const.ComponentType.BANNER);
            List list = null;
            if (!(bannerSection == null || (entryList = bannerSection.getEntryList()) == null)) {
                Iterable<BannerEntry> iterable = entryList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (BannerEntry link : iterable) {
                    arrayList.add(link.getLink());
                }
                list = (List) arrayList;
            }
            homeBaseSW.put("banner_list", GsonUtils.toJson(list, true));
            FinOmegaSDK.trackEvent("ibt_wallet_home_banner_sw", homeBaseSW);
        }

        public final void trackFinBannerSW(List<ResourceStateData> list) {
            if (list != null) {
                Map linkedHashMap = new LinkedHashMap();
                List arrayList = new ArrayList();
                for (ResourceStateData resourceStateData : list) {
                    Pair[] pairArr = new Pair[3];
                    String activityId = resourceStateData.getActivityId();
                    if (activityId == null) {
                        activityId = "";
                    }
                    pairArr[0] = TuplesKt.m41339to("activity_id", activityId);
                    pairArr[1] = TuplesKt.m41339to("resource_id", resourceStateData.getResourceId());
                    pairArr[2] = TuplesKt.m41339to("plan_id", resourceStateData.getPlanId());
                    arrayList.add(MapsKt.mapOf(pairArr));
                }
                linkedHashMap.put("list", GsonUtils.toJson(MapsKt.mapOf(TuplesKt.m41339to("activity", arrayList), TuplesKt.m41339to("length", Integer.valueOf(arrayList.size()))), true));
                linkedHashMap.put("action_type", "resource_sw");
                linkedHashMap.put(WalletHomeTrackerManager.f35337a, "wallethome");
                new FinResOmegaUtils("fin_wallethome_banner_sw").addParamAll(linkedHashMap).send();
            }
        }

        public final void trackBannerClick(String str) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", Const.ComponentType.BANNER);
            homeBaseSW.put("activity_url", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_banner_ck", homeBaseSW);
        }

        public final void trackFinBannerCK(ResourceStateData resourceStateData) {
            Intrinsics.checkNotNullParameter(resourceStateData, Const.ComponentType.BANNER);
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("activity_id", resourceStateData.getActivityId());
            linkedHashMap.put("resource_id", resourceStateData.getResourceId());
            linkedHashMap.put("plan_id", resourceStateData.getPlanId());
            linkedHashMap.put("action_type", "resource_ck");
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, "wallethome");
            new FinResOmegaUtils("fin_wallethome_banner_ck").addParamAll(linkedHashMap).send();
        }

        public final void trackWalletHomeDialogSW(String str) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", com.didi.global.globalgenerickit.eventtracker.Const.POPUP);
            homeBaseSW.put("activity_url", str);
            FinOmegaSDK.trackEvent("ibt_wallet_home_popup_sw", homeBaseSW);
        }

        public final void trackWalletHomeDialogClick(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "type");
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", com.didi.global.globalgenerickit.eventtracker.Const.POPUP);
            homeBaseSW.put("activity_url", str);
            homeBaseSW.put("button_name", str2);
            FinOmegaSDK.trackEvent("ibt_wallet_home_popup_ck", homeBaseSW);
        }

        @JvmStatic
        public final void trackTransferPageSW() {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, "transfer");
            linkedHashMap.put("pub_source", Intrinsics.areEqual((Object) getSource(), (Object) "1") ? "wallet_mainlist" : "wallet_home");
            linkedHashMap.put(WalletHomeTrackerManager.f35340d, "fintech");
            FinOmegaSDK.trackEvent("ibt_wallet_transfer_sw", linkedHashMap);
        }

        public final void trackTransferClick(String str) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, "transfer");
            linkedHashMap.put("pub_source", Intrinsics.areEqual((Object) getSource(), (Object) "1") ? "wallet_mainlist" : "wallet_home");
            linkedHashMap.put(WalletHomeTrackerManager.f35340d, "fintech");
            linkedHashMap.put("button_name", str);
            FinOmegaSDK.trackEvent("ibt_wallet_transfer_ck", linkedHashMap);
        }

        public final void trackerBankListPageSW(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit.Data data) {
            List<com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit.Entry> entryList;
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, "card");
            linkedHashMap.put("pub_source", Intrinsics.areEqual((Object) getSource(), (Object) "1") ? "wallet_mainlist" : "wallet_home");
            linkedHashMap.put(WalletHomeTrackerManager.f35340d, "fintech");
            List list = null;
            if (!(data == null || (entryList = data.getEntryList()) == null)) {
                Iterable<com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit.Entry> iterable = entryList;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit.Entry entry : iterable) {
                    Map linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("card_text", entry.getName());
                    linkedHashMap2.put("status", entry.getCardStatus());
                    linkedHashMap2.put("expire_status", entry.getExpired());
                    arrayList.add(linkedHashMap2);
                }
                list = (List) arrayList;
            }
            linkedHashMap.put("card_list", GsonUtils.toJson(list, true));
            FinOmegaSDK.trackEvent("ibt_wallet_card_sw", linkedHashMap);
        }

        public final void trackBankListPageClick(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.credit.Entry entry) {
            String str;
            String str2;
            Map linkedHashMap = new LinkedHashMap();
            String str3 = "card";
            linkedHashMap.put(WalletHomeTrackerManager.f35337a, str3);
            linkedHashMap.put("pub_source", Intrinsics.areEqual((Object) getSource(), (Object) "1") ? "wallet_mainlist" : "wallet_home");
            linkedHashMap.put(WalletHomeTrackerManager.f35340d, "fintech");
            if (entry == null) {
                str3 = "add_card";
            }
            linkedHashMap.put("button_name", str3);
            String str4 = null;
            if (entry == null) {
                str = null;
            } else {
                str = entry.getName();
            }
            linkedHashMap.put("card_text", str);
            if (entry == null) {
                str2 = null;
            } else {
                str2 = entry.getCardStatus();
            }
            linkedHashMap.put("status", str2);
            if (entry != null) {
                str4 = entry.getExpired();
            }
            linkedHashMap.put("expire_status", str4);
            FinOmegaSDK.trackEvent("ibt_wallet_card_ck", linkedHashMap);
        }

        private final Map<String, Object> getBasePrepaid(Map<String, Object> map) {
            map.put("pub_biz_line", Const.PubBizLine.FIN);
            map.put(WalletHomeTrackerManager.f35342f, "payment");
            if (DRouter.getContext() != null) {
                map.put("pub_uid", WalletCommonParamsUtil.getUID(DRouter.getContext()));
            }
            return map;
        }

        public static /* synthetic */ void trackCardPrepaidApply$default(Companion companion, Integer num, String str, Integer num2, int i, Object obj) {
            if ((i & 4) != 0) {
                num2 = null;
            }
            companion.trackCardPrepaidApply(num, str, num2);
        }

        public final void trackCardPrepaidApply(Integer num, String str, Integer num2) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Map<String, Object> basePrepaid = getBasePrepaid(new LinkedHashMap());
            basePrepaid.put("fullKyc", getAuthenticationStatus());
            basePrepaid.put("primaryKyc", getStatus());
            basePrepaid.put("bind_card_numbers", getCardNum());
            basePrepaid.put("account_balance", getBalance());
            basePrepaid.put("type", num);
            basePrepaid.put("is_visible", num2);
            FinOmegaSDK.trackEvent(str, basePrepaid);
        }

        public final void trackHomePrepaidDialog() {
            FinOmegaSDK.trackEvent("fin_prepaidcard_apply_topup_sw", getBasePrepaid(new LinkedHashMap()));
        }

        public final void trackHomePrepaidDialogClick(String str) {
            Map<String, Object> basePrepaid = getBasePrepaid(new LinkedHashMap());
            basePrepaid.put("button_name", str);
            FinOmegaSDK.trackEvent("fin_prepaidcard_apply_topup_ck", basePrepaid);
        }

        public final void trackTopupPrepaidDialog() {
            FinOmegaSDK.trackEvent("fin_prepaidcard_topup_apply_sw", getBasePrepaid(new LinkedHashMap()));
        }

        public final void trackTopupPrepaidDialogClick(String str) {
            Map<String, Object> basePrepaid = getBasePrepaid(new LinkedHashMap());
            basePrepaid.put("button_name", str);
            FinOmegaSDK.trackEvent("fin_prepaidcard_topup_apply_ck", basePrepaid);
        }

        public final void trackPrepaidSettingFailed() {
            FinOmegaSDK.trackEvent("fin_prepaidcard_pin_anti_toast_sw", getBasePrepaid(new LinkedHashMap()));
        }

        public final void trackPrepaidSettingPwdIntroduce() {
            FinOmegaSDK.trackEvent("fin_prepaidcard_changepin_desc_sw", getBasePrepaid(new LinkedHashMap()));
        }

        public final void trackPrepaidSettingPwdIntroduceClick() {
            FinOmegaSDK.trackEvent("fin_prepaidcard_changepin_desc_ck", getBasePrepaid(new LinkedHashMap()));
        }

        public final void trackHomePublicMsgCK() {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("pub_target", "notice");
            homeBaseSW.put("pub_biz_line", Const.PubBizLine.FIN);
            FinOmegaSDK.trackEvent("fin_wallet_home_notice_detail_ck", homeBaseSW);
        }

        public final void trackHomeKycPopupSW(String str, String str2) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("source", str);
            homeBaseSW.put("blockid", str2);
            homeBaseSW.put("pub_from_page", "");
            homeBaseSW.put(WalletHomeTrackerManager.f35337a, "wallethome");
            FinOmegaSDK.trackEvent("fin_wallet_home_kyc_popup_sw", homeBaseSW);
        }

        public final void trackHomeKycPopupCK(String str, String str2, String str3) {
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.put("source", str);
            homeBaseSW.put("blockid", str2);
            homeBaseSW.put("btnname", str3);
            homeBaseSW.put("pub_from_page", "");
            homeBaseSW.put(WalletHomeTrackerManager.f35337a, "wallethome");
            FinOmegaSDK.trackEvent("fin_wallet_home_kyc_popup_btn_ck", homeBaseSW);
        }

        public final void trackHomeCard(HashMap<String, Object> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "tempMap");
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.putAll(hashMap);
            FinOmegaSDK.trackEvent("ibt_wallet_home_balance_sw", homeBaseSW);
        }

        public final void trackHomeCardHomePage(HashMap<String, Object> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "tempMap");
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.putAll(hashMap);
            FinOmegaSDK.trackEvent("fin_wallet_homepage_top_change", homeBaseSW);
        }

        public final void trackHomeCardCK(HashMap<String, Object> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "tempMap");
            Map<String, Object> homeBaseSW = getHomeBaseSW();
            homeBaseSW.putAll(hashMap);
            FinOmegaSDK.trackEvent("fin_wallet_homepage_bankcard_ck", homeBaseSW);
        }
    }
}
