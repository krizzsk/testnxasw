package com.didi.global.fintech.cashier.p118ui;

import com.didi.global.fintech.cashier.p118ui.viewholder.FastPaySettingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H&¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/IFastPaySettingContentViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "updateIconUrl", "", "icon", "", "updateMainTitle", "title", "updateSettingItems", "items", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem;", "updateSubTitle", "subtitle", "updateTermUrl", "termContent", "click", "Lkotlin/Function0;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.IFastPaySettingContentViewHolder */
/* compiled from: IFastPayViewHolders.kt */
public interface IFastPaySettingContentViewHolder extends IGlobalCashierBaseViewHolder {
    void updateIconUrl(String str);

    void updateMainTitle(String str);

    void updateSettingItems(List<FastPaySettingItem> list);

    void updateSubTitle(String str);

    void updateTermUrl(String str, Function0<Unit> function0);
}
