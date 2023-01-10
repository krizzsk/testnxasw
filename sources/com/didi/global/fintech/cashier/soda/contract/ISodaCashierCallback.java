package com.didi.global.fintech.cashier.soda.contract;

import android.content.Intent;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J4\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H&¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/contract/ISodaCashierCallback;", "", "onCallStartActivity", "", "intent", "Landroid/content/Intent;", "onCallStartActivityForResult", "requestCode", "", "onCashierClose", "isClickConfirmBtn", "", "isChanged", "selectedItems", "Ljava/util/ArrayList;", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "Lkotlin/collections/ArrayList;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ISodaCashierCallback.kt */
public interface ISodaCashierCallback {
    void onCallStartActivity(Intent intent);

    void onCallStartActivityForResult(Intent intent, int i);

    void onCashierClose(boolean z, boolean z2, ArrayList<GPayMethodItem> arrayList);
}
