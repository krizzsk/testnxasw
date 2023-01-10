package com.didi.global.fintech.cashier.fastpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySyncPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySyncView;
import com.didi.global.fintech.cashier.fastpay.presenter.FastPaySyncPresenter;
import com.didi.global.fintech.cashier.fastpay.view.FastPaySyncView;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didiglobal.pay.paysecure.tmx.ITMXHost;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/FastPaySyncActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySyncView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "Lcom/didiglobal/pay/paysecure/tmx/ITMXHost;", "()V", "getPresenter", "getView", "initTheme", "", "layoutRes", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCallStartActivity", "intent", "onCallStartActivityForResult", "onClose", "payResult", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPaySyncActivity.kt */
public final class FastPaySyncActivity extends BaseCashierActivity<IFastPaySyncPresenter, IFastPaySyncView> implements IGlobalCashierCallback, ITMXHost {
    public int layoutRes() {
        return R.layout.activity_fast_pay_sync;
    }

    public void onBackPressed() {
    }

    public void onCallStartActivity(Intent intent) {
    }

    public void onCallStartActivityForResult(Intent intent, int i) {
    }

    public void initTheme() {
        if (CashierFacade.Companion.getInstance().getTheme().global()) {
            setTheme(R.style.GlobalCashierActivityTheme_for_global_transparent);
        } else if (CashierFacade.Companion.getInstance().getTheme().brazil()) {
            setTheme(R.style.GlobalCashierActivityTheme_for_99_transparent);
        } else {
            setTheme(R.style.GlobalCashierActivityTheme_for_99_transparent);
        }
    }

    public IFastPaySyncPresenter getPresenter() {
        return new FastPaySyncPresenter(this, this, this);
    }

    public IFastPaySyncView getView() {
        View findViewById = findViewById(R.id.activity_fast_pay_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_fast_pay_root_view)");
        return new FastPaySyncView(this, (ViewGroup) findViewById);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i == 69) {
            int i3 = 3;
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                i3 = extras.getInt("code");
            }
            onClose(i3);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onClose(int i) {
        IFastPaySyncPresenter iFastPaySyncPresenter = (IFastPaySyncPresenter) getMPresenter();
        if (iFastPaySyncPresenter != null) {
            iFastPaySyncPresenter.unBind();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
