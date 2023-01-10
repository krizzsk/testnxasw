package com.didi.payment.wallet.global.wallet.view.view.home.p143v2;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.popmgr.WHomePopChain;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.pay.paysecure.tmx.ITMXHost;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletSideBarActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/didiglobal/pay/paysecure/tmx/ITMXHost;", "()V", "isNewIntent", "", "mPresenter", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$Presenter;", "mView", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2View;", "forbidScreenShot", "", "initStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStart", "onStop", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletSideBarActivity */
/* compiled from: WalletSideBarActivity.kt */
public final class WalletSideBarActivity extends FragmentActivity implements ITMXHost {

    /* renamed from: a */
    private WalletHomeContract.Presenter f35204a;

    /* renamed from: b */
    private WalletHomeContract.V2View f35205b;

    /* renamed from: c */
    private boolean f35206c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m26789b();
        super.onCreate(bundle);
        WalletHomeContract.V2View walletHomePage = new WalletHomePage(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.f35205b = walletHomePage;
        if (walletHomePage != null) {
            setContentView((View) (WalletHomePage) walletHomePage);
            m26787a();
            WalletHomeContract.Presenter walletHomeV2Presenter = new WalletHomeV2Presenter(this, this.f35205b, "1");
            this.f35204a = walletHomeV2Presenter;
            if (walletHomeV2Presenter != null) {
                walletHomeV2Presenter.init();
            }
            WalletHomeContract.V2View v2View = this.f35205b;
            if (v2View != null) {
                WalletHomePage walletHomePage2 = (WalletHomePage) v2View;
                WalletHomePage.setPagePaddingBottom$default(walletHomePage2, 0.0f, 1, (Object) null);
                walletHomePage2.showBackButton(true, new View.OnClickListener() {
                    public final void onClick(View view) {
                        WalletSideBarActivity.m26788a(WalletSideBarActivity.this, view);
                    }
                });
                if (WalletCommonParamsUtil.isBrazilDriverClient()) {
                    walletHomePage2.showTitle(getString(R.string.GDriver_wallet_Accounts_eSep));
                } else {
                    walletHomePage2.showTitle((String) null);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26788a(WalletSideBarActivity walletSideBarActivity, View view) {
        Intrinsics.checkNotNullParameter(walletSideBarActivity, "this$0");
        walletSideBarActivity.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WHomePopChain.INSTANCE.addTask(300).start(this, 300);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WalletHomeContract.Presenter presenter = this.f35204a;
        if (presenter != null) {
            presenter.onResume();
        }
        WalletHomeContract.Presenter presenter2 = this.f35204a;
        if (presenter2 != null) {
            presenter2.requestData();
        }
        WalletHomeContract.Presenter presenter3 = this.f35204a;
        if (presenter3 != null) {
            presenter3.checkQRCode("");
        }
        WHomePopChain.INSTANCE.setHomeVisible(true);
        this.f35206c = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WalletHomeContract.Presenter presenter = this.f35204a;
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        WHomePopChain.INSTANCE.setHomeVisible(false);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f35206c = true;
        WalletHomeContract.Presenter presenter = this.f35204a;
        if (presenter != null) {
            presenter.requestDataIfNeeded();
        }
    }

    /* renamed from: a */
    private final void m26787a() {
        if (!PayBaseConfigUtil.isDebugMode()) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* renamed from: b */
    private final void m26789b() {
        setTheme(R.style.GlobalActivity50);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, ContextCompat.getColor(this, R.color.transparent));
    }
}
