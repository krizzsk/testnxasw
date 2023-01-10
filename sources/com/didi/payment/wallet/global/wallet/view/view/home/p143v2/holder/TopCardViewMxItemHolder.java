package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.base.widget.WalletBaseViewExtsKt;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder.TopCardVH;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountBalance;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadCardList;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeAmountStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet_ui.UiUtilsKt;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010$\u001a\u00020\u001f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f0\u001eJ\b\u0010%\u001a\u00020\u0013H\u0016J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0013H\u0016J\u0018\u0010-\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0013H\u0002J \u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020\u0013H\u0002J)\u00102\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001bH\u0002J\u0010\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010\u0007J\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0002J\u000e\u0010?\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001bJ\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0002J\u0018\u0010A\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0002J\u0018\u0010B\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006D"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxItemHolder$ItemHolder;", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "getData", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "setData", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;)V", "headCard", "Ljava/util/ArrayList;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList;", "Lkotlin/collections/ArrayList;", "getLister", "()Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "secondView", "Landroid/view/View;", "secondViewIsShow", "", "Ljava/lang/Boolean;", "unit", "Lkotlin/Function1;", "", "getUnit", "()Lkotlin/jvm/functions/Function1;", "setUnit", "(Lkotlin/jvm/functions/Function1;)V", "addLayerOnClick", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemParams", "traceWalletHome", "item", "context", "Landroid/content/Context;", "trackHomeCardCK", "clickArea", "", "cardSum", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadCardList;Ljava/lang/String;Ljava/lang/Integer;)V", "trackHomeCardHomePage", "isShowLayer", "update", "info", "updateAlpha", "float", "", "updateBottomInfo", "updateLayer", "updateMxBalance", "updateMxCardInfo", "updateMxGuideInfo", "ItemHolder", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder */
/* compiled from: TopCardViewMxItemHolder.kt */
public final class TopCardViewMxItemHolder extends RecyclerView.Adapter<ItemHolder> {

    /* renamed from: a */
    private final WalletHomeContract.V2Listener f35288a;

    /* renamed from: b */
    private final ArrayList<HeadCardList> f35289b = new ArrayList<>();

    /* renamed from: c */
    private final Lazy f35290c = LazyKt.lazy(TopCardViewMxItemHolder$screenWidth$2.INSTANCE);

    /* renamed from: d */
    private Function1<? super Boolean, Unit> f35291d;

    /* renamed from: e */
    private View f35292e;

    /* renamed from: f */
    private Data f35293f;

    /* renamed from: g */
    private Boolean f35294g;

    public final WalletHomeContract.V2Listener getLister() {
        return this.f35288a;
    }

    public TopCardViewMxItemHolder(WalletHomeContract.V2Listener v2Listener) {
        this.f35288a = v2Listener;
    }

    /* renamed from: a */
    private final int m26817a() {
        return ((Number) this.f35290c.getValue()).intValue();
    }

    public final Function1<Boolean, Unit> getUnit() {
        return this.f35291d;
    }

    public final void setUnit(Function1<? super Boolean, Unit> function1) {
        this.f35291d = function1;
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_top_card_view_mx_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …  false\n                )");
        return new ItemHolder(inflate);
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        Intrinsics.checkNotNullParameter(itemHolder, "holder");
        if (i < this.f35289b.size()) {
            HeadCardList headCardList = this.f35289b.get(i);
            int cardType = headCardList.getCardType();
            if (cardType == 1) {
                UiUtilsKt.visibilityOrGone$default(itemHolder.getClTopCardMxInclude1(), false, 1, (Object) null);
                Intrinsics.checkNotNullExpressionValue(headCardList, "item");
                m26824b(itemHolder, headCardList);
            } else if (cardType == 2) {
                UiUtilsKt.visibilityOrGone$default(itemHolder.getClTopCardMxInclude2(), false, 1, (Object) null);
                UiUtilsKt.visibilityOrGone$default(itemHolder.getIvTopCardMxAddBank(), false, 1, (Object) null);
                Intrinsics.checkNotNullExpressionValue(headCardList, "item");
                m26826d(itemHolder, headCardList);
                m26819a(itemHolder, headCardList);
            } else if (cardType == 3) {
                UiUtilsKt.visibilityOrGone$default(itemHolder.getClTopCardMxInclude3(), false, 1, (Object) null);
                Intrinsics.checkNotNullExpressionValue(headCardList, "item");
                m26819a(itemHolder, headCardList);
                m26825c(itemHolder, headCardList);
            }
            Intrinsics.checkNotNullExpressionValue(headCardList, "item");
            Context context = itemHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            m26821a(headCardList, context, i);
            m26818a(itemHolder, i);
        }
    }

    /* renamed from: a */
    private final void m26821a(HeadCardList headCardList, Context context, int i) {
        String type;
        HeadCardList.HeadCardData.LogData logData;
        Integer campaign;
        HeadCardList.HeadCardData.LogData logData2;
        Integer cardActivityId;
        HeadCardList.HeadCardData.LogData logData3;
        Integer cardNum;
        AccountBalance accountBalance;
        String balance;
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("pub_target", HeadCardList.HEAD_BALANCE);
        String str = "0";
        map.put("verify_status", str);
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        if (!(headCardData == null || (accountBalance = headCardData.getAccountBalance()) == null || (balance = accountBalance.getBalance()) == null)) {
            map.put("amount", balance);
        }
        if (!WalletHomeAmountStatus.Companion.isShowAmount()) {
            str = "1";
        }
        map.put("balance_show", str);
        HeadCardList.HeadCardData headCardData2 = headCardList.getHeadCardData();
        if (!(headCardData2 == null || (logData3 = headCardData2.getLogData()) == null || (cardNum = logData3.getCardNum()) == null)) {
            map.put("card_num", String.valueOf(cardNum.intValue()));
        }
        HeadCardList.HeadCardData headCardData3 = headCardList.getHeadCardData();
        if (!(headCardData3 == null || (logData2 = headCardData3.getLogData()) == null || (cardActivityId = logData2.getCardActivityId()) == null)) {
            map.put("card_activity_id", String.valueOf(cardActivityId.intValue()));
        }
        HeadCardList.HeadCardData headCardData4 = headCardList.getHeadCardData();
        if (!(headCardData4 == null || (logData = headCardData4.getLogData()) == null || (campaign = logData.getCampaign()) == null)) {
            map.put("campaign", String.valueOf(campaign.intValue()));
        }
        if (i == 0 && (type = headCardList.getType()) != null) {
            map.put("first_card", type);
        }
        Integer couponNum = headCardList.getCouponNum();
        if (couponNum != null) {
            map.put(ParamConst.PARAM_COUPON_NUM, String.valueOf(couponNum.intValue()));
        }
        String isShowBankCardTip = headCardList.isShowBankCardTip(context);
        if (isShowBankCardTip != null) {
            map.put("bankcard_show_tip", isShowBankCardTip);
        }
        String isShowBalanceTip = headCardList.isShowBalanceTip(context);
        if (isShowBalanceTip != null) {
            map.put("coupon_show_tip", isShowBalanceTip);
        }
        WalletHomeTrackerManager.Companion.trackHomeCard(hashMap);
    }

    /* renamed from: a */
    private final void m26823a(boolean z) {
        HeadCardList.HeadCardData.LogData logData;
        Integer campaign;
        if (this.f35289b.size() > 1 && z) {
            HashMap hashMap = new HashMap();
            String type = this.f35289b.get(0).getType();
            if (type != null) {
                hashMap.put("first_card", type);
            }
            HeadCardList.HeadCardData headCardData = this.f35289b.get(0).getHeadCardData();
            if (!(headCardData == null || (logData = headCardData.getLogData()) == null || (campaign = logData.getCampaign()) == null)) {
                hashMap.put("campaign", String.valueOf(campaign.intValue()));
            }
            WalletHomeTrackerManager.Companion.trackHomeCardHomePage(hashMap);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26820a(TopCardViewMxItemHolder topCardViewMxItemHolder, HeadCardList headCardList, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = 0;
        }
        topCardViewMxItemHolder.m26822a(headCardList, str, num);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26822a(HeadCardList headCardList, String str, Integer num) {
        HeadCardList.HeadCardData.LogData logData;
        Integer campaign;
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("click_area", str);
        map.put("card_sum", num);
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        if (!(headCardData == null || (logData = headCardData.getLogData()) == null || (campaign = logData.getCampaign()) == null)) {
            map.put("campaign", String.valueOf(campaign.intValue()));
        }
        WalletHomeTrackerManager.Companion.trackHomeCardCK(hashMap);
    }

    /* renamed from: a */
    private final void m26818a(ItemHolder itemHolder, int i) {
        String tipText;
        ViewGroup.LayoutParams layoutParams = itemHolder.getCkItemHomeTopCardViewMx().getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = null;
            if (getItemCount() == 1) {
                layoutParams.width = (int) (((double) m26817a()) * 0.85d);
                layoutParams.height = (int) (((double) m26817a()) * 0.48d);
                if (layoutParams instanceof RecyclerView.LayoutParams) {
                    layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                }
                if (layoutParams2 != null) {
                    layoutParams2.setMarginStart((int) (((double) m26817a()) * 0.05d));
                }
            } else {
                layoutParams.width = (int) (((double) m26817a()) * 0.773d);
                layoutParams.height = (int) (((double) m26817a()) * 0.44d);
                if (i == 0) {
                    if (layoutParams instanceof RecyclerView.LayoutParams) {
                        layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.setMarginStart((int) (((double) m26817a()) * 0.05d));
                    }
                } else {
                    if (layoutParams instanceof RecyclerView.LayoutParams) {
                        layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2.setMarginStart((int) (((double) m26817a()) * 0.025d));
                        layoutParams2.setMarginEnd((int) (((double) m26817a()) * 0.05d));
                    }
                    WalletBaseViewExtsKt.click(itemHolder.getCkItemHomeTopCardViewMxLayer(), new TopCardViewMxItemHolder$setItemParams$1$4(this, i));
                    HeadCardList.HeadCardData headCardData = this.f35289b.get(i).getHeadCardData();
                    if (!(headCardData == null || (tipText = headCardData.getTipText()) == null)) {
                        CharSequence charSequence = tipText;
                        if (charSequence.length() > 0) {
                            if (this.f35294g == null) {
                                this.f35294g = true;
                            }
                            Boolean bool = this.f35294g;
                            if (bool != null) {
                                UiUtilsKt.visibilityOrGone(itemHolder.getCkItemHomeTopCardViewMxLayer(), bool.booleanValue());
                            }
                            this.f35292e = itemHolder.getCkItemHomeTopCardViewMxLayer();
                            itemHolder.getTvTopCardLayer().setText(charSequence);
                        }
                    }
                }
            }
            itemHolder.getCkItemHomeTopCardViewMx().setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    private final void m26819a(ItemHolder itemHolder, HeadCardList headCardList) {
        HeadCardList.HeadCardData.Menu bottomMenu;
        String text;
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        ConstraintLayout.LayoutParams layoutParams = null;
        if (headCardData == null || (bottomMenu = headCardData.getBottomMenu()) == null) {
            ViewGroup.LayoutParams layoutParams2 = itemHolder.getIvTopCardMxBg().getLayoutParams();
            if (layoutParams2 != null) {
                if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                    layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
                }
                if (layoutParams != null) {
                    layoutParams.bottomMargin = 0;
                }
                itemHolder.getIvTopCardMxBg().setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        String text2 = bottomMenu.getText();
        if (text2 != null) {
            itemHolder.getTvTopCardMxBank().setText(text2);
        }
        itemHolder.getTvTopCardMxBankCount().setText(bottomMenu.getNumber());
        if (bottomMenu.isHasCoupon()) {
            UiUtilsKt.visibilityOrGone$default(itemHolder.getTvTopCardMxBankCoupon(), false, 1, (Object) null);
            HeadCardList.HeadCardData.TipText tipText = bottomMenu.getTipText();
            if (!(tipText == null || (text = tipText.getText()) == null)) {
                itemHolder.getTvTopCardMxBankCoupon().setText(text);
            }
        }
        String linkUrl = bottomMenu.getLinkUrl();
        if (linkUrl != null) {
            WalletBaseViewExtsKt.click(itemHolder.getLlTopCardMxBottom(), new TopCardViewMxItemHolder$updateBottomInfo$1$4$1(linkUrl, bottomMenu, itemHolder, this, headCardList));
        }
        UiUtilsKt.visibilityOrGone$default(itemHolder.getLlTopCardMxBottom(), false, 1, (Object) null);
        View viewCardDot = itemHolder.getViewCardDot();
        Context context = itemHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
        UiUtilsKt.visibilityOrGone(viewCardDot, bottomMenu.isShowRedDot(context));
    }

    /* renamed from: b */
    private final void m26824b(ItemHolder itemHolder, HeadCardList headCardList) {
        HeadCardList.HeadCardData.GuideInfo guideInfo;
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        if (!(headCardData == null || (guideInfo = headCardData.getGuideInfo()) == null)) {
            View view = itemHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            WalletBaseViewExtsKt.click(view, new TopCardViewMxItemHolder$updateMxGuideInfo$1$1(this, guideInfo, headCardList));
            itemHolder.getTvTopCardBinkCardAddBank().setText(guideInfo.getText());
            PayRichInfo promotionText = guideInfo.getPromotionText();
            if (promotionText != null) {
                promotionText.bindTextView(itemHolder.getTvTopCardBinkCardAddBankTips(), new PayRichInfo.DefaultSpannable());
            }
        }
        ViewGroup.LayoutParams layoutParams = itemHolder.getIvTopCardMxBg().getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.bottomMargin = 0;
            }
            itemHolder.getIvTopCardMxBg().setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private final void m26825c(ItemHolder itemHolder, HeadCardList headCardList) {
        HeadCardList.HeadCardData.TopUp topUp;
        AccountBalance accountBalance;
        itemHolder.getIvTopCardMxBg().setImageResource(R.drawable.bg_balance_card);
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        if (!(headCardData == null || (accountBalance = headCardData.getAccountBalance()) == null)) {
            String title = accountBalance.getTitle();
            if (title != null) {
                Context context = itemHolder.itemView.getContext();
                itemHolder.getTvTopCardMxBalanceTitle().setText(title);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = WalletHomeAmountStatus.Companion.isShowAmount();
                TopCardVH.Companion companion = TopCardVH.Companion;
                boolean z = booleanRef.element;
                TextView tvTopCardMxBalanceTitle = itemHolder.getTvTopCardMxBalanceTitle();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.switchAmountStatus(z, tvTopCardMxBalanceTitle, context);
                WalletBaseViewExtsKt.click(itemHolder.getTvTopCardMxBalanceTitle(), new TopCardViewMxItemHolder$updateMxBalance$1$1$1(booleanRef, itemHolder, context, this));
            }
            String localBalance = accountBalance.getLocalBalance();
            if (localBalance != null) {
                itemHolder.getTvTopCardMxBalanceAmount().setText(localBalance);
            }
        }
        itemHolder.getTvTopCardMxBalanceAmount().setTextSize(WalletHomeAmountStatus.Companion.isShowAmount() ? 34.0f : 30.0f);
        WalletBaseViewExtsKt.click(itemHolder.getTvTopCardMxBalanceAmount(), new TopCardViewMxItemHolder$updateMxBalance$2(this));
        HeadCardList.HeadCardData headCardData2 = headCardList.getHeadCardData();
        if (headCardData2 != null && (topUp = headCardData2.getTopUp()) != null) {
            String title2 = topUp.getTitle();
            if (title2 != null) {
                itemHolder.getTvTopCardMxBalanceTopUp().setText(title2);
            }
            String linkUrl = topUp.getLinkUrl();
            if (linkUrl != null) {
                WalletBaseViewExtsKt.click(itemHolder.getTvTopCardMxBalanceTopUp(), new TopCardViewMxItemHolder$updateMxBalance$3$2$1(linkUrl));
            }
        }
    }

    /* renamed from: d */
    private final void m26826d(ItemHolder itemHolder, HeadCardList headCardList) {
        HeadCardList.HeadCardData.CardInfo cardInfo;
        HeadCardList.HeadCardData headCardData = headCardList.getHeadCardData();
        if (headCardData != null && (cardInfo = headCardData.getCardInfo()) != null) {
            Context context = itemHolder.itemView.getContext();
            if (context != null) {
                GlideUtils.with2load2into(context, cardInfo.getIcon(), itemHolder.getIvTopCardBindImg());
            }
            String cardType = cardInfo.getCardType();
            if (cardType != null) {
                itemHolder.getTvTopCardBindTitle().setText(cardType);
            }
            if (WalletHomeAmountStatus.Companion.isShowAmount()) {
                UiUtilsKt.visibilityOrGone(itemHolder.getIvTopCardBindImg4(), false);
                UiUtilsKt.visibilityOrGone$default(itemHolder.getIvTopCardBindAmount(), false, 1, (Object) null);
                String name = cardInfo.getName();
                if (name != null) {
                    itemHolder.getIvTopCardBindAmount().setText(name);
                }
            } else {
                UiUtilsKt.visibilityOrGone$default(itemHolder.getIvTopCardBindImg4(), false, 1, (Object) null);
                UiUtilsKt.visibilityOrGone(itemHolder.getIvTopCardBindAmount(), false);
            }
            View view = itemHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            WalletBaseViewExtsKt.click(view, new TopCardViewMxItemHolder$updateMxCardInfo$1$4(cardInfo, this, headCardList));
        }
    }

    public final Data getData() {
        return this.f35293f;
    }

    public final void setData(Data data) {
        this.f35293f = data;
    }

    public final void update(Data data) {
        if (data != null) {
            this.f35293f = data;
            List<HeadCardList> headCardList = data.getHeadCardList();
            if (headCardList != null) {
                this.f35289b.clear();
                this.f35289b.addAll(headCardList);
                notifyDataSetChanged();
            }
        }
    }

    public final void addLayerOnClick(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "unit");
        this.f35291d = function1;
    }

    public final void updateLayer(boolean z) {
        m26823a(z);
        if (!z) {
            this.f35294g = Boolean.valueOf(z);
            View view = this.f35292e;
            if (view != null) {
                UiUtilsKt.visibilityOrGone(view, z);
            }
        }
        View view2 = this.f35292e;
        if (view2 != null) {
            view2.setAlpha(0.98f);
        }
    }

    public final void updateAlpha(float f) {
        View view;
        if (Intrinsics.areEqual((Object) this.f35294g, (Object) true) && f <= 1.0f && f >= 0.0f && (view = this.f35292e) != null) {
            view.setAlpha(f * 0.98f);
        }
    }

    public int getItemCount() {
        return this.f35289b.size();
    }

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b5\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\u0004R\u001a\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\u0004R\u001a\u0010'\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\u0004R\u001a\u00100\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001a\u00103\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001a\u00106\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR\u001a\u00109\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u0010\u001aR\u001a\u0010<\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0018\"\u0004\b>\u0010\u001aR\u001a\u0010?\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0018\"\u0004\bA\u0010\u001aR\u001a\u0010B\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001aR\u001a\u0010E\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0018\"\u0004\bG\u0010\u001aR\u001a\u0010H\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR\u001a\u0010K\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0018\"\u0004\bM\u0010\u001aR\u001a\u0010N\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\u0004¨\u0006Q"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxItemHolder$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ckItemHomeTopCardViewMx", "getCkItemHomeTopCardViewMx", "()Landroid/view/View;", "setCkItemHomeTopCardViewMx", "ckItemHomeTopCardViewMxLayer", "getCkItemHomeTopCardViewMxLayer", "setCkItemHomeTopCardViewMxLayer", "clTopCardMxInclude1", "getClTopCardMxInclude1", "setClTopCardMxInclude1", "clTopCardMxInclude2", "getClTopCardMxInclude2", "setClTopCardMxInclude2", "clTopCardMxInclude3", "getClTopCardMxInclude3", "setClTopCardMxInclude3", "ivTopCardBindAmount", "Landroid/widget/TextView;", "getIvTopCardBindAmount", "()Landroid/widget/TextView;", "setIvTopCardBindAmount", "(Landroid/widget/TextView;)V", "ivTopCardBindImg", "Landroid/widget/ImageView;", "getIvTopCardBindImg", "()Landroid/widget/ImageView;", "setIvTopCardBindImg", "(Landroid/widget/ImageView;)V", "ivTopCardBindImg4", "getIvTopCardBindImg4", "setIvTopCardBindImg4", "ivTopCardMxAddBank", "getIvTopCardMxAddBank", "setIvTopCardMxAddBank", "ivTopCardMxBg", "getIvTopCardMxBg", "setIvTopCardMxBg", "llTopCardMxBank", "getLlTopCardMxBank", "setLlTopCardMxBank", "llTopCardMxBottom", "getLlTopCardMxBottom", "setLlTopCardMxBottom", "tvTopCardBindTitle", "getTvTopCardBindTitle", "setTvTopCardBindTitle", "tvTopCardBinkCardAddBank", "getTvTopCardBinkCardAddBank", "setTvTopCardBinkCardAddBank", "tvTopCardBinkCardAddBankTips", "getTvTopCardBinkCardAddBankTips", "setTvTopCardBinkCardAddBankTips", "tvTopCardLayer", "getTvTopCardLayer", "setTvTopCardLayer", "tvTopCardMxBalanceAmount", "getTvTopCardMxBalanceAmount", "setTvTopCardMxBalanceAmount", "tvTopCardMxBalanceTitle", "getTvTopCardMxBalanceTitle", "setTvTopCardMxBalanceTitle", "tvTopCardMxBalanceTopUp", "getTvTopCardMxBalanceTopUp", "setTvTopCardMxBalanceTopUp", "tvTopCardMxBank", "getTvTopCardMxBank", "setTvTopCardMxBank", "tvTopCardMxBankCount", "getTvTopCardMxBankCount", "setTvTopCardMxBankCount", "tvTopCardMxBankCoupon", "getTvTopCardMxBankCoupon", "setTvTopCardMxBankCoupon", "viewCardDot", "getViewCardDot", "setViewCardDot", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxItemHolder$ItemHolder */
    /* compiled from: TopCardViewMxItemHolder.kt */
    public static final class ItemHolder extends RecyclerView.ViewHolder {
        private View ckItemHomeTopCardViewMx;
        private View ckItemHomeTopCardViewMxLayer;
        private View clTopCardMxInclude1;
        private View clTopCardMxInclude2;
        private View clTopCardMxInclude3;
        private TextView ivTopCardBindAmount;
        private ImageView ivTopCardBindImg;
        private View ivTopCardBindImg4;
        private View ivTopCardMxAddBank;
        private ImageView ivTopCardMxBg;
        private View llTopCardMxBank;
        private View llTopCardMxBottom;
        private TextView tvTopCardBindTitle;
        private TextView tvTopCardBinkCardAddBank;
        private TextView tvTopCardBinkCardAddBankTips;
        private TextView tvTopCardLayer;
        private TextView tvTopCardMxBalanceAmount;
        private TextView tvTopCardMxBalanceTitle;
        private TextView tvTopCardMxBalanceTopUp;
        private TextView tvTopCardMxBank;
        private TextView tvTopCardMxBankCount;
        private TextView tvTopCardMxBankCoupon;
        private View viewCardDot;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.iv_topCardMxBg);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_topCardMxBg)");
            this.ivTopCardMxBg = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ck_itemHomeTopCardViewMxLayer);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…emHomeTopCardViewMxLayer)");
            this.ckItemHomeTopCardViewMxLayer = findViewById2;
            View findViewById3 = view.findViewById(R.id.iv_topCardMxAddBank);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_topCardMxAddBank)");
            this.ivTopCardMxAddBank = findViewById3;
            View findViewById4 = view.findViewById(R.id.ll_topCardMxBank);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.ll_topCardMxBank)");
            this.llTopCardMxBank = findViewById4;
            View findViewById5 = view.findViewById(R.id.tv_topCardLayer);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_topCardLayer)");
            this.tvTopCardLayer = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.tv_topCardMxBankCoupon);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_topCardMxBankCoupon)");
            this.tvTopCardMxBankCoupon = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.tv_topCardMxBankCount);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.tv_topCardMxBankCount)");
            this.tvTopCardMxBankCount = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.tv_topCardMxBank);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_topCardMxBank)");
            this.tvTopCardMxBank = (TextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.iv_topCardBindAmount);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.iv_topCardBindAmount)");
            this.ivTopCardBindAmount = (TextView) findViewById9;
            View findViewById10 = view.findViewById(R.id.tv_topCardBinkCardAddBank);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…v_topCardBinkCardAddBank)");
            this.tvTopCardBinkCardAddBank = (TextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.tv_topCardBinkCardAddBankTips);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.…pCardBinkCardAddBankTips)");
            this.tvTopCardBinkCardAddBankTips = (TextView) findViewById11;
            View findViewById12 = view.findViewById(R.id.iv_topCardBindImg);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.iv_topCardBindImg)");
            this.ivTopCardBindImg = (ImageView) findViewById12;
            View findViewById13 = view.findViewById(R.id.tv_topCardBindTitle);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(R.id.tv_topCardBindTitle)");
            this.tvTopCardBindTitle = (TextView) findViewById13;
            View findViewById14 = view.findViewById(R.id.cl_topCardMxInclude1);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(R.id.cl_topCardMxInclude1)");
            this.clTopCardMxInclude1 = findViewById14;
            View findViewById15 = view.findViewById(R.id.cl_topCardMxInclude2);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(R.id.cl_topCardMxInclude2)");
            this.clTopCardMxInclude2 = findViewById15;
            View findViewById16 = view.findViewById(R.id.cl_topCardMxInclude3);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(R.id.cl_topCardMxInclude3)");
            this.clTopCardMxInclude3 = findViewById16;
            View findViewById17 = view.findViewById(R.id.ck_itemHomeTopCardViewMx);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "itemView.findViewById(R.…ck_itemHomeTopCardViewMx)");
            this.ckItemHomeTopCardViewMx = findViewById17;
            View findViewById18 = view.findViewById(R.id.ll_topCardMxBottom);
            Intrinsics.checkNotNullExpressionValue(findViewById18, "itemView.findViewById(R.id.ll_topCardMxBottom)");
            this.llTopCardMxBottom = findViewById18;
            View findViewById19 = view.findViewById(R.id.view_card_dot);
            Intrinsics.checkNotNullExpressionValue(findViewById19, "itemView.findViewById(R.id.view_card_dot)");
            this.viewCardDot = findViewById19;
            View findViewById20 = view.findViewById(R.id.iv_topCardBindImg4);
            Intrinsics.checkNotNullExpressionValue(findViewById20, "itemView.findViewById(R.id.iv_topCardBindImg4)");
            this.ivTopCardBindImg4 = findViewById20;
            View findViewById21 = view.findViewById(R.id.tv_topCardMxBalanceTitle);
            Intrinsics.checkNotNullExpressionValue(findViewById21, "itemView.findViewById(R.…tv_topCardMxBalanceTitle)");
            this.tvTopCardMxBalanceTitle = (TextView) findViewById21;
            View findViewById22 = view.findViewById(R.id.tv_topCardMxBalanceAmount);
            Intrinsics.checkNotNullExpressionValue(findViewById22, "itemView.findViewById(R.…v_topCardMxBalanceAmount)");
            this.tvTopCardMxBalanceAmount = (TextView) findViewById22;
            View findViewById23 = view.findViewById(R.id.tv_topCardMxBalanceTopUp);
            Intrinsics.checkNotNullExpressionValue(findViewById23, "itemView.findViewById(R.…tv_topCardMxBalanceTopUp)");
            this.tvTopCardMxBalanceTopUp = (TextView) findViewById23;
        }

        public final View getLlTopCardMxBank() {
            return this.llTopCardMxBank;
        }

        public final void setLlTopCardMxBank(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.llTopCardMxBank = view;
        }

        public final View getCkItemHomeTopCardViewMx() {
            return this.ckItemHomeTopCardViewMx;
        }

        public final void setCkItemHomeTopCardViewMx(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.ckItemHomeTopCardViewMx = view;
        }

        public final View getCkItemHomeTopCardViewMxLayer() {
            return this.ckItemHomeTopCardViewMxLayer;
        }

        public final void setCkItemHomeTopCardViewMxLayer(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.ckItemHomeTopCardViewMxLayer = view;
        }

        public final View getClTopCardMxInclude1() {
            return this.clTopCardMxInclude1;
        }

        public final void setClTopCardMxInclude1(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.clTopCardMxInclude1 = view;
        }

        public final View getClTopCardMxInclude2() {
            return this.clTopCardMxInclude2;
        }

        public final void setClTopCardMxInclude2(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.clTopCardMxInclude2 = view;
        }

        public final View getClTopCardMxInclude3() {
            return this.clTopCardMxInclude3;
        }

        public final void setClTopCardMxInclude3(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.clTopCardMxInclude3 = view;
        }

        public final View getIvTopCardMxAddBank() {
            return this.ivTopCardMxAddBank;
        }

        public final void setIvTopCardMxAddBank(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.ivTopCardMxAddBank = view;
        }

        public final View getLlTopCardMxBottom() {
            return this.llTopCardMxBottom;
        }

        public final void setLlTopCardMxBottom(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.llTopCardMxBottom = view;
        }

        public final TextView getTvTopCardBinkCardAddBank() {
            return this.tvTopCardBinkCardAddBank;
        }

        public final void setTvTopCardBinkCardAddBank(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardBinkCardAddBank = textView;
        }

        public final TextView getTvTopCardBinkCardAddBankTips() {
            return this.tvTopCardBinkCardAddBankTips;
        }

        public final void setTvTopCardBinkCardAddBankTips(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardBinkCardAddBankTips = textView;
        }

        public final ImageView getIvTopCardBindImg() {
            return this.ivTopCardBindImg;
        }

        public final void setIvTopCardBindImg(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivTopCardBindImg = imageView;
        }

        public final TextView getTvTopCardBindTitle() {
            return this.tvTopCardBindTitle;
        }

        public final void setTvTopCardBindTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardBindTitle = textView;
        }

        public final TextView getIvTopCardBindAmount() {
            return this.ivTopCardBindAmount;
        }

        public final void setIvTopCardBindAmount(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.ivTopCardBindAmount = textView;
        }

        public final TextView getTvTopCardMxBank() {
            return this.tvTopCardMxBank;
        }

        public final void setTvTopCardMxBank(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBank = textView;
        }

        public final TextView getTvTopCardMxBankCount() {
            return this.tvTopCardMxBankCount;
        }

        public final void setTvTopCardMxBankCount(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBankCount = textView;
        }

        public final TextView getTvTopCardMxBankCoupon() {
            return this.tvTopCardMxBankCoupon;
        }

        public final void setTvTopCardMxBankCoupon(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBankCoupon = textView;
        }

        public final TextView getTvTopCardLayer() {
            return this.tvTopCardLayer;
        }

        public final void setTvTopCardLayer(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardLayer = textView;
        }

        public final ImageView getIvTopCardMxBg() {
            return this.ivTopCardMxBg;
        }

        public final void setIvTopCardMxBg(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivTopCardMxBg = imageView;
        }

        public final View getViewCardDot() {
            return this.viewCardDot;
        }

        public final void setViewCardDot(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.viewCardDot = view;
        }

        public final View getIvTopCardBindImg4() {
            return this.ivTopCardBindImg4;
        }

        public final void setIvTopCardBindImg4(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.ivTopCardBindImg4 = view;
        }

        public final TextView getTvTopCardMxBalanceTitle() {
            return this.tvTopCardMxBalanceTitle;
        }

        public final void setTvTopCardMxBalanceTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBalanceTitle = textView;
        }

        public final TextView getTvTopCardMxBalanceAmount() {
            return this.tvTopCardMxBalanceAmount;
        }

        public final void setTvTopCardMxBalanceAmount(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBalanceAmount = textView;
        }

        public final TextView getTvTopCardMxBalanceTopUp() {
            return this.tvTopCardMxBalanceTopUp;
        }

        public final void setTvTopCardMxBalanceTopUp(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvTopCardMxBalanceTopUp = textView;
        }
    }
}
