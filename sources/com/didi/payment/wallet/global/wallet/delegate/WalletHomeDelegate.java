package com.didi.payment.wallet.global.wallet.delegate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomePage;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeV2Presenter;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.popmgr.WHomePopChain;
import com.didiglobal.pay.paysecure.tmx.TMXProfilingMgr;

public class WalletHomeDelegate implements IWalletHomeDelegate {

    /* renamed from: a */
    private WalletHomeContract.Presenter f34548a;

    /* renamed from: b */
    private WalletCommonContract.View f34549b;

    /* renamed from: c */
    private Activity f34550c;

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public WalletHomeDelegate(Activity activity) {
        this.f34550c = activity;
    }

    public View onCreateView(Bundle bundle) {
        PayTracker.getTracker().putGlobal("pix_transfer_source_page", "wallet_home_page");
        this.f34549b = new WalletHomePage(this.f34550c);
        m26342a();
        return (View) this.f34549b;
    }

    /* renamed from: a */
    private void m26342a() {
        WalletHomeV2Presenter walletHomeV2Presenter = new WalletHomeV2Presenter(this.f34550c, (WalletHomeContract.V2View) this.f34549b, "2");
        this.f34548a = walletHomeV2Presenter;
        walletHomeV2Presenter.init();
        TMXProfilingMgr.INSTANCE.doWork(this.f34550c.getApplicationContext(), "FROM_HOME");
    }

    public void onStart() {
        WHomePopChain.INSTANCE.addTask(300).start(this.f34550c, 300);
        m26343b();
    }

    public void onResume() {
        this.f34548a.onResume();
        WHomePopChain.INSTANCE.setHomeVisible(true);
        requestData();
        this.f34548a.checkQRCode("");
    }

    /* renamed from: b */
    private void m26343b() {
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home_v2");
        } else {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home");
        }
    }

    public void onStop() {
        WHomePopChain.INSTANCE.setHomeVisible(false);
    }

    public void requestData() {
        this.f34548a.requestData();
    }

    public void onDestroy() {
        this.f34548a.onDestroy();
    }
}
