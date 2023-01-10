package com.didi.global.fintech.cashier.soda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.global.fintech.cashier.core.consts.CashierConsts;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.utils.CashierLog;
import com.didi.global.fintech.cashier.core.utils.UniqueIdManager;
import com.didi.global.fintech.cashier.soda.contract.ISodaSyncUICallback;
import com.didi.global.fintech.cashier.soda.presenter.SodaPaySyncPresenter;
import com.didi.global.fintech.cashier.soda.utils.SodaConsts;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001#B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0018H\u0007J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u001a\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/SodaPayFragment;", "Lcom/didi/global/fintech/cashier/soda/BaseCashierFragment;", "Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "()V", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "mUniqueId", "", "onActionInterceptJumpThirdPage", "", "action", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "Lcom/didi/payment/base/event/WalletRefreshDataEvent;", "onFinish", "payResult", "Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult;", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "Companion", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPayFragment.kt */
public final class SodaPayFragment extends BaseCashierFragment<SodaPaySyncPresenter> implements IGlobalCashierActionInterceptCallback, ISodaSyncUICallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final String f23532c = "args_param";

    /* renamed from: a */
    private CashierParam f23533a;

    /* renamed from: b */
    private String f23534b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f23533a = (CashierParam) arguments.getSerializable("args_param");
        }
        this.f23534b = UniqueIdManager.INSTANCE.genUniqueId();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        setMPresenter(new SodaPaySyncPresenter(requireContext, this, this.f23534b, this, this));
        SodaPaySyncPresenter sodaPaySyncPresenter = (SodaPaySyncPresenter) getMPresenter();
        if (sodaPaySyncPresenter != null) {
            sodaPaySyncPresenter.init(this.f23533a);
        }
        SodaPaySyncPresenter sodaPaySyncPresenter2 = (SodaPaySyncPresenter) getMPresenter();
        if (sodaPaySyncPresenter2 != null) {
            sodaPaySyncPresenter2.onBind();
        }
        EventBus.getDefault().register(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onViewCreated");
    }

    public void onStart() {
        super.onStart();
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onStart");
    }

    public void onResume() {
        super.onResume();
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onResume");
    }

    public void onPause() {
        super.onPause();
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onPause");
    }

    public void onStop() {
        super.onStop();
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onStop");
    }

    public void onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        SodaPaySyncPresenter sodaPaySyncPresenter = (SodaPaySyncPresenter) getMPresenter();
        if (sodaPaySyncPresenter != null) {
            sodaPaySyncPresenter.unBind();
        }
        super.onDestroy();
        CashierLog.INSTANCE.mo68924d("SodaPayFragment onDestroy");
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/SodaPayFragment$Companion;", "", "()V", "ARG_PARAM", "", "injectIn", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPayFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void injectIn(FragmentActivity fragmentActivity, CashierParam cashierParam) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(cashierParam, "param");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(CashierConsts.PAY_SERVICE_FRAGMENT_TAG);
            SodaPayFragment sodaPayFragment = new SodaPayFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("args_param", cashierParam);
            Unit unit = Unit.INSTANCE;
            sodaPayFragment.setArguments(bundle);
            if (findFragmentByTag == null) {
                supportFragmentManager.beginTransaction().add((Fragment) sodaPayFragment, CashierConsts.PAY_SERVICE_FRAGMENT_TAG).commitAllowingStateLoss();
            } else {
                supportFragmentManager.beginTransaction().remove(findFragmentByTag).add((Fragment) sodaPayFragment, CashierConsts.PAY_SERVICE_FRAGMENT_TAG).commitAllowingStateLoss();
            }
        }
    }

    public void onFinish(SodaPayResult sodaPayResult) {
        CashierLog.INSTANCE.mo68924d(Intrinsics.stringPlus("SodaPayFragment onFinish ", sodaPayResult));
        SodaPaySyncPresenter sodaPaySyncPresenter = (SodaPaySyncPresenter) getMPresenter();
        if (sodaPaySyncPresenter != null) {
            sodaPaySyncPresenter.dismissLoading();
        }
        if (!(sodaPayResult == null || getContext() == null)) {
            CashierLog.INSTANCE.mo68924d("onFinish sendBroadcast");
            Intent intent = new Intent(SodaConsts.ACTION_CASHIER_PAY_RESULT);
            intent.putExtra(SodaConsts.ARG_PAY_RESULT, sodaPayResult);
            LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
        }
        FragmentActivity activity = getActivity();
        Fragment fragment = null;
        FragmentManager supportFragmentManager = activity == null ? null : activity.getSupportFragmentManager();
        if (supportFragmentManager != null) {
            fragment = supportFragmentManager.findFragmentByTag(CashierConsts.PAY_SERVICE_FRAGMENT_TAG);
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    public void onActionInterceptJumpThirdPage(String str) {
        SodaPaySyncPresenter sodaPaySyncPresenter = (SodaPaySyncPresenter) getMPresenter();
        if (sodaPaySyncPresenter != null) {
            sodaPaySyncPresenter.onActionIntercept(str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        String str = null;
        if (i == 2) {
            if (intent != null) {
                str = intent.getStringExtra("card_index");
            }
            onCardVerify(str);
        } else if (i == 6) {
            onCardVerify((String) null);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Subscribe
    public final void onEvent(WalletRefreshDataEvent walletRefreshDataEvent) {
        Intrinsics.checkNotNullParameter(walletRefreshDataEvent, "data");
        onCardVerify((String) null);
    }
}
