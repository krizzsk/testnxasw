package com.didi.global.fintech.cashier.p118ui.viewholder.item;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.InstallmentVo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 R2\u00020\u0001:\u0002RSB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010O\u001a\u00020\u0014J\u0006\u0010P\u001a\u00020\u0014J\u0006\u00106\u001a\u00020\u0014J\b\u0010Q\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020%\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001a\u00106\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR \u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000eR\u001a\u0010I\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006T"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "", "()V", "cardIndex", "", "getCardIndex", "()Ljava/lang/String;", "setCardIndex", "(Ljava/lang/String;)V", "channelId", "", "getChannelId", "()Ljava/lang/Integer;", "setChannelId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "content", "getContent", "setContent", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "icon", "getIcon", "setIcon", "installment", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "getInstallment", "()Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "setInstallment", "(Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;)V", "onInstallmentClick", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;", "", "getOnInstallmentClick", "()Lkotlin/jvm/functions/Function1;", "setOnInstallmentClick", "(Lkotlin/jvm/functions/Function1;)V", "onPlansClick", "getOnPlansClick", "setOnPlansClick", "operatorType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData$Operation;", "getOperatorType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData$Operation;", "setOperatorType", "(Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData$Operation;)V", "selected", "getSelected", "setSelected", "signed", "getSigned", "setSigned", "subContent", "getSubContent", "setSubContent", "tags", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/PaymentLabel;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "type", "getType", "setType", "uniqueId", "getUniqueId", "setUniqueId", "viewType", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "getViewType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;", "setViewType", "(Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder$ViewType;)V", "checked", "enabled", "toString", "Companion", "Operation", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData */
/* compiled from: GlobalCashierBaseItemViewHolder.kt */
public final class ChannelItemViewHolderData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static final ChannelItemViewHolderData f23746q;

    /* renamed from: a */
    private String f23747a;

    /* renamed from: b */
    private String f23748b;

    /* renamed from: c */
    private String f23749c;

    /* renamed from: d */
    private String f23750d;

    /* renamed from: e */
    private Operation f23751e;

    /* renamed from: f */
    private List<PaymentLabel> f23752f = new ArrayList();

    /* renamed from: g */
    private String f23753g;

    /* renamed from: h */
    private Integer f23754h;

    /* renamed from: i */
    private boolean f23755i;

    /* renamed from: j */
    private boolean f23756j;

    /* renamed from: k */
    private boolean f23757k;

    /* renamed from: l */
    private Integer f23758l;

    /* renamed from: m */
    private GlobalCashierBaseItemViewHolder.ViewType f23759m = GlobalCashierBaseItemViewHolder.ViewType.Default;

    /* renamed from: n */
    private InstallmentVo f23760n;

    /* renamed from: o */
    private Function1<? super InstallmentVo, Unit> f23761o;

    /* renamed from: p */
    private Function1<? super InstallmentVo.PlansVo, Unit> f23762p;

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData$Operation;", "", "(Ljava/lang/String;I)V", "OPERATION_CHECK", "OPERATION_SWITCH", "OPERATION_TOP_UP", "OPERATION_ARROW", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public enum Operation {
        OPERATION_CHECK,
        OPERATION_SWITCH,
        OPERATION_TOP_UP,
        OPERATION_ARROW
    }

    public static final ChannelItemViewHolderData getALL_METHOD() {
        return Companion.getALL_METHOD();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData$Companion;", "", "()V", "ALL_METHOD", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "getALL_METHOD$annotations", "getALL_METHOD", "()Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Companion */
    /* compiled from: GlobalCashierBaseItemViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getALL_METHOD$annotations() {
        }

        private Companion() {
        }

        public final ChannelItemViewHolderData getALL_METHOD() {
            return ChannelItemViewHolderData.f23746q;
        }
    }

    static {
        ChannelItemViewHolderData channelItemViewHolderData = new ChannelItemViewHolderData();
        channelItemViewHolderData.setViewType(GlobalCashierBaseItemViewHolder.ViewType.AllMethod);
        channelItemViewHolderData.setDisabled(false);
        f23746q = channelItemViewHolderData;
    }

    public final String getIcon() {
        return this.f23747a;
    }

    public final void setIcon(String str) {
        this.f23747a = str;
    }

    public final String getContent() {
        return this.f23748b;
    }

    public final void setContent(String str) {
        this.f23748b = str;
    }

    public final String getSubContent() {
        return this.f23749c;
    }

    public final void setSubContent(String str) {
        this.f23749c = str;
    }

    public final String getCardIndex() {
        return this.f23750d;
    }

    public final void setCardIndex(String str) {
        this.f23750d = str;
    }

    public final Operation getOperatorType() {
        return this.f23751e;
    }

    public final void setOperatorType(Operation operation) {
        this.f23751e = operation;
    }

    public final List<PaymentLabel> getTags() {
        return this.f23752f;
    }

    public final void setTags(List<PaymentLabel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f23752f = list;
    }

    public final String getType() {
        return this.f23753g;
    }

    public final void setType(String str) {
        this.f23753g = str;
    }

    public final Integer getChannelId() {
        return this.f23754h;
    }

    public final void setChannelId(Integer num) {
        this.f23754h = num;
    }

    public final boolean getSelected() {
        return this.f23755i;
    }

    public final void setSelected(boolean z) {
        this.f23755i = z;
    }

    public final boolean getDisabled() {
        return this.f23756j;
    }

    public final void setDisabled(boolean z) {
        this.f23756j = z;
    }

    public final boolean getSigned() {
        return this.f23757k;
    }

    public final void setSigned(boolean z) {
        this.f23757k = z;
    }

    public final Integer getUniqueId() {
        return this.f23758l;
    }

    public final void setUniqueId(Integer num) {
        this.f23758l = num;
    }

    public final GlobalCashierBaseItemViewHolder.ViewType getViewType() {
        return this.f23759m;
    }

    public final void setViewType(GlobalCashierBaseItemViewHolder.ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, "<set-?>");
        this.f23759m = viewType;
    }

    public final InstallmentVo getInstallment() {
        return this.f23760n;
    }

    public final void setInstallment(InstallmentVo installmentVo) {
        this.f23760n = installmentVo;
    }

    public final Function1<InstallmentVo, Unit> getOnPlansClick() {
        return this.f23761o;
    }

    public final void setOnPlansClick(Function1<? super InstallmentVo, Unit> function1) {
        this.f23761o = function1;
    }

    public final Function1<InstallmentVo.PlansVo, Unit> getOnInstallmentClick() {
        return this.f23762p;
    }

    public final void setOnInstallmentClick(Function1<? super InstallmentVo.PlansVo, Unit> function1) {
        this.f23762p = function1;
    }

    public final boolean checked() {
        return this.f23755i;
    }

    public final boolean signed() {
        return this.f23757k;
    }

    public final boolean enabled() {
        return !this.f23756j;
    }

    public String toString() {
        return "type:" + this.f23753g + ", channelId:" + this.f23754h + ", selected:" + this.f23755i + ", disabled:" + this.f23756j;
    }
}
