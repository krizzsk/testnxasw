package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.BankCard;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Button;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Coupon;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.PrepaidStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeFreeze;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardVH;", "itemView", "Landroid/view/View;", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Landroid/view/View;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "(Landroid/view/View;)V", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder */
/* compiled from: TopCardViewHolder.kt */
public final class TopCardViewHolder extends TopCardVH {
    public int getViewType() {
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopCardViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopCardViewHolder(View view, WalletHomeContract.V2Listener v2Listener) {
        this(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        setLister(v2Listener);
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        getViewTopCard().setVisibility(0);
        WalletHomeFreeze.Companion.initFreezeStatus(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:240:0x043a, code lost:
        if (r0.intValue() != 7) goto L_0x03ea;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeHolderData<com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            super.onBindViewHolder(r14)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.IData r14 = r14.getContentObj()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data r14 = (com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data) r14
            if (r14 != 0) goto L_0x0012
            goto L_0x05ec
        L_0x0012:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeFreeze.Companion
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r1 = r14.getNewFreezeSection()
            r2 = 0
            if (r1 != 0) goto L_0x001d
            r1 = r2
            goto L_0x0023
        L_0x001d:
            int r1 = r1.freezeStatus
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0023:
            android.view.View r3 = r13.itemView
            android.content.Context r3 = r3.getContext()
            java.lang.String r4 = "itemView.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r0.switchFreezeUIByStatus(r1, r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.FreezeInterceptor r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.FreezeInterceptor.INSTANCE
            android.view.View r1 = r13.itemView
            android.content.Context r1 = r1.getContext()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$1 r3 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$1
            r3.<init>(r13, r14)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r5 = 1
            r6 = 0
            r0.onInterceptor(r1, r5, r6, r3)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r13.getClFreeze()
            android.view.View r0 = (android.view.View) r0
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r1 = r14.getNewFreezeSection()
            if (r1 != 0) goto L_0x0053
            r1 = r2
            goto L_0x0055
        L_0x0053:
            java.lang.String r1 = r1.title
        L_0x0055:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0062
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r1 = 0
            goto L_0x0063
        L_0x0062:
            r1 = 1
        L_0x0063:
            r1 = r1 ^ r5
            r3 = 8
            if (r1 == 0) goto L_0x006a
            r1 = 0
            goto L_0x006c
        L_0x006a:
            r1 = 8
        L_0x006c:
            r0.setVisibility(r1)
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r0 = r14.getNewFreezeSection()
            if (r0 != 0) goto L_0x0076
            goto L_0x00ba
        L_0x0076:
            android.widget.TextView r1 = r13.getTvFreezeTitle()
            java.lang.String r7 = r0.title
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            android.widget.TextView r1 = r13.getTvFreezeDesc()
            java.lang.String r7 = r0.subTitle
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            android.widget.ImageView r1 = r13.getIvFreeze()
            android.view.View r1 = (android.view.View) r1
            java.lang.String r7 = r0.link
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00a1
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r7 = 0
            goto L_0x00a2
        L_0x00a1:
            r7 = 1
        L_0x00a2:
            r7 = r7 ^ r5
            if (r7 == 0) goto L_0x00a7
            r7 = 0
            goto L_0x00a9
        L_0x00a7:
            r7 = 8
        L_0x00a9:
            r1.setVisibility(r7)
            androidx.constraintlayout.widget.ConstraintLayout r1 = r13.getClFreeze()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$vYvnc6CfygdgADkj6FHYb_pIejM r7 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$vYvnc6CfygdgADkj6FHYb_pIejM
            r7.<init>(r13)
            r1.setOnClickListener(r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00ba:
            android.widget.TextView r0 = r13.getTvTitle()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r14.getAccountSection()
            if (r1 != 0) goto L_0x00c6
            r1 = r2
            goto L_0x00ca
        L_0x00c6:
            java.lang.String r1 = r1.getAccountSectionName()
        L_0x00ca:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus.Companion
            boolean r1 = r1.isShowAmount()
            r0.element = r1
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardVH$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardVH.Companion
            boolean r7 = r0.element
            android.widget.TextView r8 = r13.getTvTitle()
            android.view.View r9 = r13.itemView
            android.content.Context r9 = r9.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            r1.switchAmountStatus(r7, r8, r9)
            android.widget.TextView r1 = r13.getTvTitle()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ftHYpbYTWwHEaJTYuje5M08YJTA r7 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ftHYpbYTWwHEaJTYuje5M08YJTA
            r7.<init>(r13, r14, r14)
            r1.setOnClickListener(r7)
            android.widget.TextView r0 = r13.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r14.getAccountSection()
            if (r1 != 0) goto L_0x0108
        L_0x0106:
            r1 = r2
            goto L_0x0113
        L_0x0108:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountBalance r1 = r1.getAccountBalance()
            if (r1 != 0) goto L_0x010f
            goto L_0x0106
        L_0x010f:
            java.lang.String r1 = r1.getLocalBalance()
        L_0x0113:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r13.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeAmountStatus$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus.Companion
            boolean r1 = r1.isShowAmount()
            if (r1 == 0) goto L_0x0127
            r1 = 1107820544(0x42080000, float:34.0)
            goto L_0x0129
        L_0x0127:
            r1 = 1106247680(0x41f00000, float:30.0)
        L_0x0129:
            r0.setTextSize(r1)
            android.widget.TextView r0 = r13.getTvBalance()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$rAcPjKtl8Tnv6SrbjAabRYkSaUk r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$rAcPjKtl8Tnv6SrbjAabRYkSaUk
            r1.<init>(r14)
            r0.setOnClickListener(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x0140
        L_0x013e:
            r0 = r2
            goto L_0x014b
        L_0x0140:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Button r0 = r0.getButton()
            if (r0 != 0) goto L_0x0147
            goto L_0x013e
        L_0x0147:
            java.lang.String r0 = r0.getTitle()
        L_0x014b:
            android.widget.TextView r1 = r13.getTvTopUp()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            boolean r1 = com.didi.payment.base.utils.WalletApolloUtil.enableTopUp()
            r7 = 3
            if (r1 != 0) goto L_0x0175
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r1 = r14.getNewFreezeSection()
            if (r1 != 0) goto L_0x0163
        L_0x0161:
            r1 = 0
            goto L_0x0168
        L_0x0163:
            int r1 = r1.freezeStatus
            if (r1 != r7) goto L_0x0161
            r1 = 1
        L_0x0168:
            if (r1 == 0) goto L_0x016b
            goto L_0x0175
        L_0x016b:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r13.getClTopUp$wallet_globalRelease()
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r3)
            goto L_0x0191
        L_0x0175:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r13.getClTopUp$wallet_globalRelease()
            android.view.View r1 = (android.view.View) r1
            if (r0 == 0) goto L_0x0186
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0184
            goto L_0x0186
        L_0x0184:
            r0 = 0
            goto L_0x0187
        L_0x0186:
            r0 = 1
        L_0x0187:
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x018c
            r0 = 0
            goto L_0x018e
        L_0x018c:
            r0 = 8
        L_0x018e:
            r1.setVisibility(r0)
        L_0x0191:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x019a
            goto L_0x01bd
        L_0x019a:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Button r0 = r0.getButton()
            if (r0 != 0) goto L_0x01a1
            goto L_0x01bd
        L_0x01a1:
            java.lang.Boolean r0 = r0.getShowCoin()
            if (r0 != 0) goto L_0x01a8
            goto L_0x01bd
        L_0x01a8:
            boolean r0 = r0.booleanValue()
            android.widget.ImageView r1 = r13.getIvTopUp()
            if (r0 == 0) goto L_0x01b4
            r0 = 0
            goto L_0x01b6
        L_0x01b4:
            r0 = 8
        L_0x01b6:
            r1.setVisibility(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x01bd:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r13.getClTopUp$wallet_globalRelease()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$F0zgkNQXu7EgyO4mSDOp3fUxu6c r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$F0zgkNQXu7EgyO4mSDOp3fUxu6c
            r1.<init>(r13, r14)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.getTvEarnings()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r14.getAccountSection()
            if (r1 != 0) goto L_0x01d5
        L_0x01d3:
            r1 = r2
            goto L_0x01de
        L_0x01d5:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getAwardMessage()
            if (r1 != 0) goto L_0x01dc
            goto L_0x01d3
        L_0x01dc:
            java.lang.String r1 = r1.text
        L_0x01de:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01e8
            r1 = 0
            goto L_0x01ea
        L_0x01e8:
            r1 = 8
        L_0x01ea:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r13.getTvCashback()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r14.getAccountSection()
            if (r1 != 0) goto L_0x01f9
        L_0x01f7:
            r1 = r2
            goto L_0x0202
        L_0x01f9:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getCashBackMessage()
            if (r1 != 0) goto L_0x0200
            goto L_0x01f7
        L_0x0200:
            java.lang.String r1 = r1.text
        L_0x0202:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x020c
            r1 = 0
            goto L_0x020e
        L_0x020c:
            r1 = 8
        L_0x020e:
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r13.getLlTag()
            android.widget.TextView r1 = r13.getTvEarnings()
            int r1 = r1.getVisibility()
            if (r1 != r3) goto L_0x022c
            android.widget.TextView r1 = r13.getTvCashback()
            int r1 = r1.getVisibility()
            if (r1 != r3) goto L_0x022c
            r1 = 8
            goto L_0x022d
        L_0x022c:
            r1 = 0
        L_0x022d:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r13.getTvDesc()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r14.getAccountSection()
            if (r1 != 0) goto L_0x023c
        L_0x023a:
            r1 = r2
            goto L_0x0245
        L_0x023c:
            com.didi.payment.base.view.PayRichInfo r1 = r1.getLocalDetailMessage()
            if (r1 != 0) goto L_0x0243
            goto L_0x023a
        L_0x0243:
            java.lang.String r1 = r1.text
        L_0x0245:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x024f
            r1 = 0
            goto L_0x0251
        L_0x024f:
            r1 = 8
        L_0x0251:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r13.getTvDesc()
            android.widget.TextView r1 = r13.getTvDesc()
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x026f
            android.widget.LinearLayout r1 = r13.getLlTag()
            int r1 = r1.getVisibility()
            if (r1 != r3) goto L_0x026f
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT_BOLD
            goto L_0x0271
        L_0x026f:
            android.graphics.Typeface r1 = android.graphics.Typeface.DEFAULT
        L_0x0271:
            r0.setTypeface(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x027b
            goto L_0x02c2
        L_0x027b:
            com.didi.payment.base.view.PayRichInfo r1 = r0.getLocalDetailMessage()
            if (r1 != 0) goto L_0x0282
            goto L_0x0292
        L_0x0282:
            android.widget.TextView r8 = r13.getTvDesc()
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r9 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r9.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r9 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r9
            r1.bindTextView(r8, r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0292:
            com.didi.payment.base.view.PayRichInfo r1 = r0.getAwardMessage()
            if (r1 != 0) goto L_0x0299
            goto L_0x02a9
        L_0x0299:
            android.widget.TextView r8 = r13.getTvEarnings()
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r9 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r9.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r9 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r9
            r1.bindTextView(r8, r9)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x02a9:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getCashBackMessage()
            if (r0 != 0) goto L_0x02b0
            goto L_0x02c0
        L_0x02b0:
            android.widget.TextView r1 = r13.getTvCashback()
            com.didi.payment.base.view.PayRichInfo$DefaultSpannable r8 = new com.didi.payment.base.view.PayRichInfo$DefaultSpannable
            r8.<init>()
            com.didi.payment.base.view.PayRichInfo$ISpannableString r8 = (com.didi.payment.base.view.PayRichInfo.ISpannableString) r8
            r0.bindTextView(r1, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02c0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02c2:
            android.widget.TextView r0 = r13.getTvDesc()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$GacnbqPCbZ9SLwaCpqdF6EBfzu8 r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$GacnbqPCbZ9SLwaCpqdF6EBfzu8
            r1.<init>(r14)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.getTvEarnings()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bUCsW7jkYt2BXzOJllmPPsEF-HA r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$bUCsW7jkYt2BXzOJllmPPsEF-HA
            r1.<init>(r14)
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r13.getTvCashback()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ORx_4mAjNxqnHeZrqEs3z-1eCRg r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ORx_4mAjNxqnHeZrqEs3z-1eCRg
            r1.<init>(r14)
            r0.setOnClickListener(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x02ee
        L_0x02ec:
            r0 = r2
            goto L_0x02fe
        L_0x02ee:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x02f5
            goto L_0x02ec
        L_0x02f5:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getStatusMessage()
            if (r0 != 0) goto L_0x02fc
            goto L_0x02ec
        L_0x02fc:
            java.lang.String r0 = r0.text
        L_0x02fe:
            android.widget.TextView r1 = r13.getTvStatus()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r8 = 6
            if (r0 != 0) goto L_0x032d
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x0313
        L_0x0311:
            r0 = 0
            goto L_0x0328
        L_0x0313:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x031a
            goto L_0x0311
        L_0x031a:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x0321
            goto L_0x0311
        L_0x0321:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            if (r0 != r8) goto L_0x0311
            r0 = 1
        L_0x0328:
            if (r0 == 0) goto L_0x032b
            goto L_0x032d
        L_0x032b:
            r0 = 0
            goto L_0x032f
        L_0x032d:
            r0 = 8
        L_0x032f:
            r1.setVisibility(r0)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x033a
        L_0x0338:
            r0 = 0
            goto L_0x034f
        L_0x033a:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x0341
            goto L_0x0338
        L_0x0341:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x0348
            goto L_0x0338
        L_0x0348:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            if (r0 != r8) goto L_0x0338
            r0 = 1
        L_0x034f:
            r1 = 2
            if (r0 != 0) goto L_0x0395
            android.widget.TextView r0 = r13.getTvStatus()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r9 = r14.getAccountSection()
            if (r9 != 0) goto L_0x035d
            goto L_0x038c
        L_0x035d:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r9 = r9.getAccountStatusMessage()
            if (r9 != 0) goto L_0x0364
            goto L_0x038c
        L_0x0364:
            com.didi.payment.base.view.PayRichInfo r9 = r9.getStatusMessage()
            if (r9 != 0) goto L_0x036b
            goto L_0x038c
        L_0x036b:
            java.lang.String r10 = r9.text
            java.lang.String r11 = " "
            if (r10 != 0) goto L_0x0373
        L_0x0371:
            r10 = 0
            goto L_0x037a
        L_0x0373:
            boolean r10 = kotlin.text.StringsKt.endsWith$default(r10, r11, r6, r1, r2)
            if (r10 != 0) goto L_0x0371
            r10 = 1
        L_0x037a:
            if (r10 == 0) goto L_0x0388
            java.lang.String r10 = r9.text
            if (r10 != 0) goto L_0x0382
            r10 = r2
            goto L_0x0386
        L_0x0382:
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r11)
        L_0x0386:
            r9.text = r10
        L_0x0388:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L_0x038c:
            r9 = 2131233769(0x7f080be9, float:1.8083685E38)
            r0.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r9, r6)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x039c
        L_0x0395:
            android.widget.TextView r0 = r13.getTvStatus()
            r0.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r6, r6)
        L_0x039c:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x03a3
            goto L_0x03ba
        L_0x03a3:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x03aa
            goto L_0x03ba
        L_0x03aa:
            com.didi.payment.base.view.PayRichInfo r0 = r0.getStatusMessage()
            if (r0 != 0) goto L_0x03b1
            goto L_0x03ba
        L_0x03b1:
            android.widget.TextView r9 = r13.getTvStatus()
            r0.bindTextView(r9, r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03ba:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x03c2
        L_0x03c0:
            r0 = r2
            goto L_0x03d8
        L_0x03c2:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage r0 = r0.getAccountStatusMessage()
            if (r0 != 0) goto L_0x03c9
            goto L_0x03c0
        L_0x03c9:
            java.lang.String r0 = r0.getStatus()
            if (r0 != 0) goto L_0x03d0
            goto L_0x03c0
        L_0x03d0:
            int r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r0, r6, r5, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x03d8:
            r9 = 2131233718(0x7f080bb6, float:1.8083581E38)
            r10 = 2131233719(0x7f080bb7, float:1.8083583E38)
            r11 = 2131233717(0x7f080bb5, float:1.808358E38)
            if (r0 != 0) goto L_0x03e4
            goto L_0x03ee
        L_0x03e4:
            int r12 = r0.intValue()
            if (r12 != 0) goto L_0x03ee
        L_0x03ea:
            r9 = 2131233717(0x7f080bb5, float:1.808358E38)
            goto L_0x043d
        L_0x03ee:
            if (r0 != 0) goto L_0x03f1
            goto L_0x03f8
        L_0x03f1:
            int r12 = r0.intValue()
            if (r12 != r5) goto L_0x03f8
            goto L_0x043d
        L_0x03f8:
            if (r0 != 0) goto L_0x03fb
            goto L_0x0405
        L_0x03fb:
            int r12 = r0.intValue()
            if (r12 != r1) goto L_0x0405
        L_0x0401:
            r9 = 2131233719(0x7f080bb7, float:1.8083583E38)
            goto L_0x043d
        L_0x0405:
            if (r0 != 0) goto L_0x0408
            goto L_0x040f
        L_0x0408:
            int r1 = r0.intValue()
            if (r1 != r7) goto L_0x040f
            goto L_0x03ea
        L_0x040f:
            r1 = 4
            if (r0 != 0) goto L_0x0413
            goto L_0x041a
        L_0x0413:
            int r7 = r0.intValue()
            if (r7 != r1) goto L_0x041a
            goto L_0x043d
        L_0x041a:
            r1 = 5
            if (r0 != 0) goto L_0x041e
            goto L_0x0425
        L_0x041e:
            int r7 = r0.intValue()
            if (r7 != r1) goto L_0x0425
            goto L_0x0401
        L_0x0425:
            if (r0 != 0) goto L_0x0428
            goto L_0x0432
        L_0x0428:
            int r1 = r0.intValue()
            if (r1 != r8) goto L_0x0432
            r9 = 2131233716(0x7f080bb4, float:1.8083577E38)
            goto L_0x043d
        L_0x0432:
            r1 = 7
            if (r0 != 0) goto L_0x0436
            goto L_0x03ea
        L_0x0436:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x03ea
            goto L_0x0401
        L_0x043d:
            android.widget.TextView r0 = r13.getTvStatus()
            r0.setBackgroundResource(r9)
            android.widget.TextView r0 = r13.getTvStatus()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$K5G5iJNNd1IaxnEdIfOGiHcLziE r1 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$K5G5iJNNd1IaxnEdIfOGiHcLziE
            r1.<init>(r13, r14)
            r0.setOnClickListener(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x0458
            goto L_0x0539
        L_0x0458:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BankCard r0 = r0.getBankCard()
            if (r0 != 0) goto L_0x0460
            goto L_0x0539
        L_0x0460:
            java.lang.String r1 = r0.getCardNum()
            if (r1 != 0) goto L_0x0468
            r1 = 0
            goto L_0x046c
        L_0x0468:
            int r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r1, r6, r5, r2)
        L_0x046c:
            if (r1 <= 0) goto L_0x04e6
            android.widget.LinearLayout r1 = r13.getLlBank()
            r1.setVisibility(r6)
            android.widget.FrameLayout r1 = r13.getFlAddCard()
            r1.setVisibility(r3)
            android.widget.TextView r1 = r13.getTvBank()
            java.lang.String r7 = r0.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            android.widget.TextView r1 = r13.getTvBankCount()
            java.lang.String r7 = r0.getLocalCardNum()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController.Companion
            android.view.View r7 = r13.itemView
            android.content.Context r7 = r7.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$14$gifResult$1 r8 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardViewHolder$onBindViewHolder$1$14$gifResult$1.INSTANCE
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$14$gifResult$2 r9 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardViewHolder$onBindViewHolder$1$14$gifResult$2.INSTANCE
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            java.lang.String r10 = "0"
            java.lang.String r1 = r1.getGifApollo(r7, r8, r9, r10)
            android.view.View r7 = r13.itemView
            android.content.Context r7 = r7.getContext()
            java.lang.String r8 = "card_red_bot"
            java.lang.String r7 = com.didi.payment.wallet.global.utils.WalletSPUtils.getHomeCardRedBot(r7, r8)
            android.view.View r8 = r13.getViewCardDot()
            java.lang.String r9 = "1"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x04e0
            java.lang.String r1 = r0.getRedDot()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04e0
            java.lang.String r1 = r0.getRedDot()
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x04de
            goto L_0x04e0
        L_0x04de:
            r1 = 0
            goto L_0x04e2
        L_0x04e0:
            r1 = 8
        L_0x04e2:
            r8.setVisibility(r1)
            goto L_0x051f
        L_0x04e6:
            android.widget.LinearLayout r1 = r13.getLlBank()
            r1.setVisibility(r3)
            android.widget.FrameLayout r1 = r13.getFlAddCard()
            r1.setVisibility(r6)
            android.widget.TextView r1 = r13.getTvAddCard()
            java.lang.String r7 = r0.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            android.widget.TextView r1 = r13.getTvDiscount()
            r1.setVisibility(r3)
            com.didi.payment.base.view.PayRichInfo r1 = r0.getPromotionText()
            if (r1 != 0) goto L_0x050f
            goto L_0x051f
        L_0x050f:
            android.widget.TextView r7 = r13.getTvDiscount()
            r7.setVisibility(r6)
            android.widget.TextView r7 = r13.getTvDiscount()
            r1.bindTextView(r7)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x051f:
            android.widget.LinearLayout r1 = r13.getLlBank()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$CkSTfCM_FnxiQXDDBN1bPukuOCk r7 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$CkSTfCM_FnxiQXDDBN1bPukuOCk
            r7.<init>(r0, r14)
            r1.setOnClickListener(r7)
            android.widget.FrameLayout r1 = r13.getFlAddCard()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$b2wByS3C3jm9wWx0Q_AsJ6VC5j4 r7 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$b2wByS3C3jm9wWx0Q_AsJ6VC5j4
            r7.<init>(r0, r14)
            r1.setOnClickListener(r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0539:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r14.getAccountSection()
            if (r0 != 0) goto L_0x0540
            goto L_0x05a1
        L_0x0540:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Coupon r0 = r0.getCoupon()
            if (r0 != 0) goto L_0x0547
            goto L_0x05a1
        L_0x0547:
            android.widget.TextView r1 = r13.getTvCoupon()
            java.lang.String r7 = r0.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            android.widget.TextView r1 = r13.getTvCouponCount()
            java.lang.String r7 = r0.getLocalCouponNum()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r7)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController.Companion
            android.view.View r7 = r13.itemView
            android.content.Context r7 = r7.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            java.lang.String r8 = r0.getLastCouponTime()
            boolean r1 = r1.isShowCouponRedDot(r7, r8)
            if (r1 == 0) goto L_0x058c
            java.lang.String r1 = r0.getCouponNum()
            if (r1 != 0) goto L_0x057e
            r1 = 0
            goto L_0x0582
        L_0x057e:
            int r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r1, r6, r5, r2)
        L_0x0582:
            if (r1 <= 0) goto L_0x058c
            android.view.View r1 = r13.getViewDot()
            r1.setVisibility(r6)
            goto L_0x0593
        L_0x058c:
            android.view.View r1 = r13.getViewDot()
            r1.setVisibility(r3)
        L_0x0593:
            android.widget.LinearLayout r1 = r13.getLlCoupon()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ZwbqmY2X8i6EUONk915Du1NYeP0 r7 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.-$$Lambda$TopCardViewHolder$ZwbqmY2X8i6EUONk915Du1NYeP0
            r7.<init>(r0, r14)
            r1.setOnClickListener(r7)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x05a1:
            android.widget.ImageView r0 = r13.getIvAddGifBank()
            r0.setVisibility(r3)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeController$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController.Companion
            android.view.View r1 = r13.itemView
            android.content.Context r1 = r1.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r3 = r14.getAccountSection()
            if (r3 != 0) goto L_0x05ba
            goto L_0x05cc
        L_0x05ba:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BankCard r3 = r3.getBankCard()
            if (r3 != 0) goto L_0x05c1
            goto L_0x05cc
        L_0x05c1:
            java.lang.String r3 = r3.getCardNum()
            if (r3 != 0) goto L_0x05c8
            goto L_0x05cc
        L_0x05c8:
            int r6 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt.toDefaultInt$default(r3, r6, r5, r2)
        L_0x05cc:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$16 r2 = new com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$16
            r2.<init>(r13)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.executeAddCardGif(r1, r6, r2)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            android.view.View r1 = r13.itemView
            android.content.Context r1 = r1.getContext()
            r0.trackHomeCardSW(r1, r14, r5)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.QuickFunctionSection r14 = r14.getQuickFunctionSection()
            r0.trackQuickFunctionSW(r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
        L_0x05ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardViewHolder.onBindViewHolder(com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeHolderData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26805a(AccountFreezeData accountFreezeData, TopCardViewHolder topCardViewHolder, View view) {
        Intrinsics.checkNotNullParameter(accountFreezeData, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Request build = DRouter.build(accountFreezeData.link);
        Context context = topCardViewHolder.itemView.getContext();
        if (context != null) {
            build.start(((ContextThemeWrapper) context).getBaseContext());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26810a(Ref.BooleanRef booleanRef, TopCardViewHolder topCardViewHolder, Data data, Data data2, View view) {
        PrepaidStatus marketingArea;
        Intrinsics.checkNotNullParameter(booleanRef, "$amountStatus");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data2, "$this_apply");
        TextView tvTitle = topCardViewHolder.getTvTitle();
        Context context = topCardViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        TopCardVH.Companion.switchAmountStatus(!booleanRef.element, tvTitle, context);
        WalletHomeAmountStatus.Companion.saveAmountStatus(!booleanRef.element);
        booleanRef.element = !booleanRef.element;
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onRefreshUI(true);
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "balance_eye");
        WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
        AccountSection accountSection = data2.getAccountSection();
        Integer num = null;
        if (!(accountSection == null || (marketingArea = accountSection.getMarketingArea()) == null)) {
            num = marketingArea.getType();
        }
        companion.trackCardPrepaidApply(num, "fin_prepaidcard_cardvisible_ck", Integer.valueOf(booleanRef.element ? 1 : 0));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26808a(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26809a(Data data, TopCardViewHolder topCardViewHolder, Data data2, View view) {
        Button button;
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        AccountSection accountSection = data.getAccountSection();
        if (accountSection != null && (button = accountSection.getButton()) != null) {
            FreezeInterceptor.dispatchClickEvent$default(FreezeInterceptor.INSTANCE, new TopCardViewHolder$onBindViewHolder$1$7$1$1(topCardViewHolder, button, data, data2), new TopCardViewHolder$onBindViewHolder$1$7$1$2(topCardViewHolder, button), (Function0) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26812b(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m26814c(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m26815d(TopCardViewHolder topCardViewHolder, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onStatusMsgClicked(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26813b(Data data, TopCardViewHolder topCardViewHolder, Data data2, View view) {
        AccountStatusMessage accountStatusMessage;
        Intrinsics.checkNotNullParameter(data, "$this_apply");
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        AccountSection accountSection = data.getAccountSection();
        if (accountSection != null && (accountStatusMessage = accountSection.getAccountStatusMessage()) != null) {
            Request request = (Request) DRouter.build(accountStatusMessage.getLinkUrl()).putExtra("accountSection", (Serializable) data.getAccountSection());
            Context context = topCardViewHolder.itemView.getContext();
            if (context != null) {
                request.start(((ContextThemeWrapper) context).getBaseContext());
                EventBus.getDefault().post(new WalletRefreshDataEvent());
                WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data2, LoginOmegaUtil.NEED_VERIFY_EMAIL);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26806a(TopCardViewHolder topCardViewHolder, BankCard bankCard, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(bankCard, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onBankListClick(bankCard.getLinkUrl());
        }
        WalletSPUtils.setHomeCardRedBot(topCardViewHolder.itemView.getContext(), "card_red_bot", bankCard.getRedDot());
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "cardbind");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26811b(TopCardViewHolder topCardViewHolder, BankCard bankCard, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(bankCard, "$this_apply");
        WalletHomeContract.V2Listener lister = topCardViewHolder.getLister();
        if (lister != null) {
            lister.onBankListClick(bankCard.getLinkUrl());
        }
        if (topCardViewHolder.getIvAddGifBank().getVisibility() == 0) {
            Drawable drawable = topCardViewHolder.getIvAddGifBank().getDrawable();
            GifDrawable gifDrawable = drawable instanceof GifDrawable ? (GifDrawable) drawable : null;
            boolean z = true;
            if (gifDrawable == null || !gifDrawable.isRunning()) {
                z = false;
            }
            if (z) {
                gifDrawable.stop();
            }
            topCardViewHolder.getIvAddGifBank().setVisibility(8);
            topCardViewHolder.getIvAddBank().setVisibility(0);
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(topCardViewHolder.itemView.getContext(), data, "cardbind");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26807a(TopCardViewHolder topCardViewHolder, Coupon coupon, Data data, View view) {
        Intrinsics.checkNotNullParameter(topCardViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(coupon, "$this_apply");
        FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, topCardViewHolder.itemView.getContext(), 2, false, new TopCardViewHolder$onBindViewHolder$1$15$1$1(coupon, topCardViewHolder, data), 4, (Object) null);
    }
}
