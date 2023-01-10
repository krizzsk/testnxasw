package com.didi.payment.wallet.global.wallet.view.view.home.p143v2;

import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1 */
/* compiled from: WalletHomeV2Presenter.kt */
final class WalletHomeV2Presenter$onConsumeItemClicked$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Entry $data;
    final /* synthetic */ Entry $item;
    final /* synthetic */ WalletHomeV2Presenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletHomeV2Presenter$onConsumeItemClicked$1$1(WalletHomeV2Presenter walletHomeV2Presenter, Entry entry, Entry entry2) {
        super(1);
        this.this$0 = walletHomeV2Presenter;
        this.$data = entry;
        this.$item = entry2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r13 = r13.getAccountSection();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.Integer r13) {
        /*
            r12 = this;
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r13 = r12.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r13 = r13.f35200e
            r0 = 0
            if (r13 != 0) goto L_0x000b
        L_0x0009:
            r13 = r0
            goto L_0x0016
        L_0x000b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r13 = r13.getAccountSection()
            if (r13 != 0) goto L_0x0012
            goto L_0x0009
        L_0x0012:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r13 = r13.getDisposalSection()
        L_0x0016:
            r1 = 1
            r2 = 0
            if (r13 == 0) goto L_0x005f
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r13 = r12.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r13 = r13.f35200e
            if (r13 != 0) goto L_0x0024
        L_0x0022:
            r13 = 0
            goto L_0x0039
        L_0x0024:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r13 = r13.getAccountSection()
            if (r13 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r13 = r13.getDisposalSection()
            if (r13 != 0) goto L_0x0032
            goto L_0x0022
        L_0x0032:
            boolean r13 = r13.getHasPreBlock()
            if (r13 != r1) goto L_0x0022
            r13 = 1
        L_0x0039:
            if (r13 == 0) goto L_0x005f
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r13 = r12.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r3 = r12.$data
            java.lang.String r4 = r3.getProductLine()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r5 = r12.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r5 = r5.f35200e
            if (r5 != 0) goto L_0x004d
        L_0x004b:
            r5 = r0
            goto L_0x0058
        L_0x004d:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r5 = r5.getAccountSection()
            if (r5 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.DisposalSection r5 = r5.getDisposalSection()
        L_0x0058:
            boolean r13 = r13.m26781a(r3, r4, r5)
            if (r13 == 0) goto L_0x005f
            return
        L_0x005f:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            java.lang.String r13 = r13.getProductLine()
            if (r13 != 0) goto L_0x0069
            r13 = 0
            goto L_0x006d
        L_0x0069:
            int r13 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r13, r2, r1, r0)
        L_0x006d:
            java.lang.Boolean r13 = com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.isBitcoin(r13)
            java.lang.String r3 = "isBitcoin(data.productLine?.toDefaultInt() ?: 0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0094
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r13 = r12.this$0
            android.app.Activity r13 = r13.f35197b
            android.content.Context r13 = (android.content.Context) r13
            java.lang.Boolean r13 = com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.checkBitcoinWelPage(r13)
            java.lang.String r4 = "checkBitcoinWelPage(mContext)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r4)
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0094
            return
        L_0x0094:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            java.lang.String r13 = r13.getProductLine()
            if (r13 != 0) goto L_0x009e
        L_0x009c:
            r13 = 0
            goto L_0x00a7
        L_0x009e:
            int r13 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r13, r2, r1, r0)
            r4 = 606(0x25e, float:8.49E-43)
            if (r13 != r4) goto L_0x009c
            r13 = 1
        L_0x00a7:
            if (r13 == 0) goto L_0x00b6
            boolean r13 = com.didi.payment.base.utils.WalletApolloUtil.isBoletoScanOptEnable()
            if (r13 != 0) goto L_0x00b6
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            java.lang.String r4 = "99pay://one/consume/scan"
            r13.setLinkUrl(r4)
        L_0x00b6:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            java.lang.String r13 = r13.getLinkUrl()
            if (r13 != 0) goto L_0x00c0
        L_0x00be:
            r13 = 0
            goto L_0x00ce
        L_0x00c0:
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            java.lang.String r4 = "/prepayCard_banner"
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 2
            boolean r13 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r13, (java.lang.CharSequence) r4, (boolean) r2, (int) r5, (java.lang.Object) r0)
            if (r13 != r1) goto L_0x00be
            r13 = 1
        L_0x00ce:
            if (r13 == 0) goto L_0x0120
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r4 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r5 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r6 = r12.$data
            java.lang.String r6 = r6.getLinkUrl()
            com.didi.payment.wallet.global.prepaidcard.PrepaidSource r7 = com.didi.payment.wallet.global.prepaidcard.PrepaidSource.HOME_SKU
            java.lang.String r7 = r7.getValue()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r8 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            java.lang.String r9 = r8.getStatus()
            java.lang.String r8 = "home_page"
            java.lang.String r10 = "1"
            java.lang.String r11 = ""
            java.lang.String r5 = r5.buildPrepaidUrl(r6, r7, r8, r9, r10, r11)
            java.lang.String r4 = r4.buildWalletUrl(r5)
            r13.setLinkUrl(r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r5 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r13 = r12.this$0
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r13 = r13.f35200e
            if (r13 != 0) goto L_0x0105
        L_0x0103:
            r6 = r0
            goto L_0x0118
        L_0x0105:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r13 = r13.getAccountSection()
            if (r13 != 0) goto L_0x010c
            goto L_0x0103
        L_0x010c:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.PrepaidStatus r13 = r13.getMarketingArea()
            if (r13 != 0) goto L_0x0113
            goto L_0x0103
        L_0x0113:
            java.lang.Integer r13 = r13.getType()
            r6 = r13
        L_0x0118:
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r7 = "fin_prepaidcard_SKU_ck"
            com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion.trackCardPrepaidApply$default(r5, r6, r7, r8, r9, r10)
        L_0x0120:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r13 = r12.$data
            java.lang.String r13 = r13.getLinkUrl()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r4 = r12.$data
            java.lang.String r4 = r4.getProductLine()
            if (r4 != 0) goto L_0x0130
        L_0x012e:
            r4 = 0
            goto L_0x0139
        L_0x0130:
            int r4 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r4, r2, r1, r0)
            r5 = 665(0x299, float:9.32E-43)
            if (r4 != r5) goto L_0x012e
            r4 = 1
        L_0x0139:
            if (r4 == 0) goto L_0x014d
            boolean r4 = com.didi.payment.base.utils.WalletCommonParamsUtil.isBrazilDriverClient()
            if (r4 != 0) goto L_0x014d
            com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager$Companion r13 = com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r4 = r12.$data
            java.lang.String r4 = r4.getLinkUrl()
            java.lang.String r13 = r13.buildWalletUrl(r4)
        L_0x014d:
            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
            java.lang.String r4 = "build(routerUrl)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r4 = r12.$data
            com.didi.payment.base.view.PayRichInfo r4 = r4.getPromotionText()
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x0161
            goto L_0x0167
        L_0x0161:
            java.lang.String r4 = r4.text
            if (r4 != 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r5 = r4
        L_0x0167:
            java.lang.String r4 = "activity_text"
            r13.putExtra((java.lang.String) r4, (java.lang.String) r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r4 = r12.$item
            java.lang.String r4 = r4.getProductLine()
            if (r4 != 0) goto L_0x0176
            r4 = r0
            goto L_0x017e
        L_0x0176:
            int r4 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r4, r2, r1, r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x017e:
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r5 = "product_line"
            r13.putExtra((java.lang.String) r5, (java.io.Serializable) r4)
            java.lang.String r4 = "page_refer"
            java.lang.String r5 = "wallet_home"
            r13.putExtra((java.lang.String) r4, (java.lang.String) r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r4 = r12.$data
            java.lang.String r4 = r4.getProductLine()
            if (r4 != 0) goto L_0x0195
            goto L_0x0199
        L_0x0195:
            int r2 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r4, r2, r1, r0)
        L_0x0199:
            java.lang.Boolean r0 = com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.isBitcoin(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01a9
            com.didi.payment.wallet.global.wallet.view.widget.BitcoinUtil.putBitcoinExtra(r13)
        L_0x01a9:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry r0 = r12.$data
            java.lang.String r0 = r0.getLinkUrl()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "crashPageTitle"
            java.lang.String r2 = r2.findUrlStrParam(r0, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r3 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam.Companion
            java.lang.String r4 = "crashPageText"
            java.lang.String r3 = r3.findUrlStrParam(r0, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r4 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam.Companion
            java.lang.String r5 = "crashType"
            java.lang.String r4 = r4.findUrlStrParam(r0, r5)
            java.lang.String r5 = "crash_page_title"
            r13.putExtra((java.lang.String) r5, (java.lang.String) r2)
            java.lang.String r2 = "crash_page_subtitle"
            r13.putExtra((java.lang.String) r2, (java.lang.String) r3)
            java.lang.String r2 = "crash_type"
            r13.putExtra((java.lang.String) r2, (java.lang.String) r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "tracker"
            java.lang.String r2 = r2.findUrlStrParam(r0, r3)
            com.didi.payment.base.tracker.PayTracker.trackEvent(r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletUriParam$Companion r2 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam.Companion
            java.lang.String r3 = "refresh"
            int r0 = r2.findUrlIntParam(r0, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1$callback$1
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r3 = r12.this$0
            r2.<init>(r3)
            if (r0 != r1) goto L_0x0204
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r12.this$0
            android.app.Activity r0 = r0.f35197b
            android.content.Context r0 = (android.content.Context) r0
            com.didi.drouter.router.RouterCallback r2 = (com.didi.drouter.router.RouterCallback) r2
            r13.start(r0, r2)
            goto L_0x020f
        L_0x0204:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter r0 = r12.this$0
            android.app.Activity r0 = r0.f35197b
            android.content.Context r0 = (android.content.Context) r0
            r13.start(r0)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeV2Presenter$onConsumeItemClicked$1$1.invoke(java.lang.Integer):void");
    }
}
