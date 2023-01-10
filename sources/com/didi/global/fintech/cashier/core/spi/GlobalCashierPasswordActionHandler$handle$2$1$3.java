package com.didi.global.fintech.cashier.core.spi;

import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.GlobalCashierMainActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback;
import com.didi.payment.wallet.password.PasswordScene;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler$handle$2$1$3", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "onBtnClick", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler$handle$2$1$3 implements GlobalCashierDialogCallback {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ OpenCertificationListener $listener;
    final /* synthetic */ GlobalCashierPasswordActionHandler $this_apply;

    GlobalCashierPasswordActionHandler$handle$2$1$3(LifecycleOwner lifecycleOwner, OpenCertificationListener openCertificationListener, GlobalCashierPasswordActionHandler globalCashierPasswordActionHandler) {
        this.$lifecycleOwner = lifecycleOwner;
        this.$listener = openCertificationListener;
        this.$this_apply = globalCashierPasswordActionHandler;
    }

    public void onBtnClick() {
        IGlobalMainCashierPresenter presenter;
        LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        GlobalCashierMainActivity globalCashierMainActivity = lifecycleOwner instanceof GlobalCashierMainActivity ? (GlobalCashierMainActivity) lifecycleOwner : null;
        if (!(globalCashierMainActivity == null || (presenter = globalCashierMainActivity.getPresenter()) == null)) {
            presenter.omegaPasswordPopupYesCk();
        }
        PaySecure.INSTANCE.createPayPassword(PasswordScene.CHECK_OUT_SETTING.name(), this.$listener, new GlobalCashierPasswordActionHandler$handle$2$1$3$onBtnClick$1(this.$this_apply, this.$lifecycleOwner));
    }
}
