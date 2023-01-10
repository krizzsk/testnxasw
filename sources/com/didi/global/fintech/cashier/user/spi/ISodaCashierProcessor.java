package com.didi.global.fintech.cashier.user.spi;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/spi/ISodaCashierProcessor;", "", "go2PayMethodSelPage", "", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "fragment", "Landroidx/fragment/app/Fragment;", "pay", "Landroidx/fragment/app/FragmentActivity;", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ISodaCashierProcessor.kt */
public interface ISodaCashierProcessor {
    void go2PayMethodSelPage(Activity activity, int i, CashierParam cashierParam);

    void go2PayMethodSelPage(Fragment fragment, int i, CashierParam cashierParam);

    void pay(FragmentActivity fragmentActivity, CashierParam cashierParam);
}
