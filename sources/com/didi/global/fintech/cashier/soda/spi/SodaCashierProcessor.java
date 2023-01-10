package com.didi.global.fintech.cashier.soda.spi;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.utils.UniqueIdManager;
import com.didi.global.fintech.cashier.soda.SodaPayFragment;
import com.didi.global.fintech.cashier.soda.SodaPaymentsActivity;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.spi.ISodaCashierProcessor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {ISodaCashierProcessor.class})
@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/spi/SodaCashierProcessor;", "Lcom/didi/global/fintech/cashier/user/spi/ISodaCashierProcessor;", "()V", "go2PayMethodSelPage", "", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "fragment", "Landroidx/fragment/app/Fragment;", "pay", "Landroidx/fragment/app/FragmentActivity;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaCashierProcessor.kt */
public final class SodaCashierProcessor implements ISodaCashierProcessor {
    public void go2PayMethodSelPage(Activity activity, int i, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intent intent = new Intent(activity, SodaPaymentsActivity.class);
        intent.putExtra("args_param", cashierParam);
        intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
        activity.startActivityForResult(intent, i);
    }

    public void go2PayMethodSelPage(Fragment fragment, int i, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intent intent = new Intent(fragment.getContext(), SodaPaymentsActivity.class);
        intent.putExtra("args_param", cashierParam);
        intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
        fragment.startActivityForResult(intent, i);
    }

    public void pay(FragmentActivity fragmentActivity, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        SodaPayFragment.Companion.injectIn(fragmentActivity, cashierParam);
    }
}
