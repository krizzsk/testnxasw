package com.didi.global.fintech.cashier.p118ui;

import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J+\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJ,\u0010\u0010\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00112\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H&¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "appendSpreadItem", "", "groupName", "", "click", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "removeSpreadItem", "updateHeader", "name", "icon", "iconType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "updateItems", "", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IGlobalCashierCardChannelViewHolder */
/* compiled from: IGlobalCashierViewHolders.kt */
public interface IGlobalCashierCardChannelViewHolder extends IGlobalCashierBaseViewHolder {
    void appendSpreadItem(String str, Function1<? super ChannelItemViewHolderData, Unit> function1);

    void removeSpreadItem();

    void updateHeader(String str, String str2, Integer num);

    void updateItems(List<ChannelItemViewHolderData> list, Function1<? super ChannelItemViewHolderData, Unit> function1);
}
