package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletStatusHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletStatusHistoryPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletStatusHistoryAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletStatusHistoryActivity extends WalletBaseActivity implements View.OnClickListener, WalletStatusHistoryContract.View {
    public static final int UNPAID_BILL_DEFAULT_VALUE = -1;

    /* renamed from: a */
    private View f34729a;

    /* renamed from: b */
    private RecyclerView f34730b;

    /* renamed from: c */
    private View f34731c;

    /* renamed from: d */
    private TextView f34732d;

    /* renamed from: e */
    private WalletStatusHistoryAdapter f34733e;

    /* renamed from: f */
    private int f34734f;

    /* renamed from: g */
    private TextView f34735g;

    /* renamed from: h */
    private TextView f34736h;

    /* renamed from: i */
    private ViewSwitcher f34737i;

    /* renamed from: j */
    private TextView f34738j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public WalletStatusHistoryContract.Presenter f34739k;

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_status_history_list_layout);
        this.f34739k = onCreatePresenter();
        m26531b();
        m26530a();
        int i = this.f34734f;
        if (i == 606) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebillrecord_sw");
        } else if (i == 605) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
        }
        checkAndShowTips();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m26530a();
    }

    /* access modifiers changed from: protected */
    public void checkAndShowTips() {
        if (getIntent().getIntExtra("params_topup_confirm_flag", -1) == 1) {
            WalletToastNew.showSuccessMsg(this, getString(R.string.GRider_Riders_Send_order_wnYI));
        }
    }

    /* access modifiers changed from: protected */
    public WalletStatusHistoryContract.Presenter onCreatePresenter() {
        return new WalletStatusHistoryPresenter(this, this);
    }

    public static void startActivity(Context context, int i) {
        startActivity(context, i, -1);
    }

    public static void startActivity(Context context, int i, int i2) {
        Intent intent = new Intent(context, WalletStatusHistoryActivity.class);
        intent.putExtra("product_line", i);
        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_UNPAID_BILLS, i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WalletStatusHistoryActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
        WalletStatusHistoryContract.Presenter presenter = this.f34739k;
        if (presenter != null) {
            presenter.checkAccountStatus();
        }
    }

    /* renamed from: a */
    private void m26530a() {
        this.f34734f = getIntent().getIntExtra("product_line", 606);
        this.f34739k.loadHistoryData(true, getCurrentCategory());
    }

    /* renamed from: b */
    private void m26531b() {
        View findViewById = findViewById(R.id.iv_wallet_new_balance_title_left);
        this.f34729a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletStatusHistoryActivity.this.f34739k.handleBackClick();
                GlobalOmegaUtils.trackBoletoHistoryExitCK(WalletStatusHistoryActivity.this.getCurrentCategory());
            }
        });
        this.f34730b = (RecyclerView) findViewById(R.id.cs_history_ry);
        this.f34731c = findViewById(R.id.cs_history_empty_layout);
        this.f34732d = (TextView) findViewById(R.id.cs_history_empty_tv);
        this.f34737i = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.f34738j = (TextView) findViewById(R.id.tv_more_history);
        this.f34733e = new WalletStatusHistoryAdapter(this, new WalletStatusHistoryAdapter.CsStatusHistoryListCallback() {
            public void onLastItemShowed() {
                WalletStatusHistoryActivity.this.f34739k.loadHistoryData(false, WalletStatusHistoryActivity.this.getCurrentCategory());
                WalletStatusHistoryActivity.this.f34739k.loadNextPage(WalletStatusHistoryActivity.this.getCurrentCategory());
            }

            public void onListEmpty() {
                WalletStatusHistoryActivity.this.showEmptyView(WalletStatusHistoryActivity.this.getCurrentCategory() == 0 ? R.string.GRider_reminder_You_currently_ZrqL : R.string.cs_history_list_empty_text, WalletCommonParamsUtil.isBrazilDriverClient());
            }
        }, new WalletStatusHistoryAdapter.CsStatusHistoryListItemClickListener() {
            public void onItemClick(CsHistoryItem csHistoryItem, boolean z, int i) {
                if (csHistoryItem != null) {
                    WalletStatusHistoryActivity.this.f34739k.handleItemClick(csHistoryItem, z, i);
                }
            }

            public void onCancelClick(CsHistoryItem csHistoryItem, int i) {
                WalletStatusHistoryActivity.this.f34739k.getCancelReason(csHistoryItem, i);
            }

            public void onPayClick(CsHistoryItem csHistoryItem, int i) {
                WalletStatusHistoryActivity.this.f34739k.prepayOrder(csHistoryItem, i);
            }
        });
        this.f34730b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f34730b.setAdapter(this.f34733e);
        initLoadingDialog(this, R.id.iv_wallet_new_balance_title_left);
        this.f34735g = (TextView) findViewById(R.id.history_unpaid);
        this.f34736h = (TextView) findViewById(R.id.history_completed);
        m26532c();
        this.f34738j.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                DRouter.build(WalletConstant.URL.H5_DRIVER_BOLETO_HISTORY).start(WalletStatusHistoryActivity.this);
            }
        });
    }

    /* renamed from: c */
    private void m26532c() {
        if (getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_UNPAID_BILLS, -1) != 0) {
            this.f34735g.setSelected(true);
            this.f34736h.setSelected(false);
            GlobalOmegaUtils.trackBoletoHistoryUnpaidSW();
        } else {
            this.f34735g.setSelected(false);
            this.f34736h.setSelected(true);
            GlobalOmegaUtils.trackBoletoHistoryCompletedSW();
        }
        this.f34735g.setOnClickListener(this);
        this.f34736h.setOnClickListener(this);
    }

    public void appendHistoryItem(CsHistoryListResp.DataModel dataModel) {
        int i = 0;
        this.f34730b.setVisibility(0);
        this.f34733e.addData(dataModel.orders, this.f34735g.isSelected());
        boolean z = WalletCommonParamsUtil.isBrazilDriverClient() && dataModel.showDriverBoletoHistory;
        if (this.f34736h.isSelected()) {
            TextView textView = this.f34738j;
            if (!z) {
                i = 8;
            }
            textView.setVisibility(i);
            return;
        }
        this.f34738j.setVisibility(8);
    }

    public void clearHistoryItem() {
        this.f34733e.clearData();
    }

    public void removeItem(int i) {
        WalletStatusHistoryAdapter walletStatusHistoryAdapter = this.f34733e;
        if (walletStatusHistoryAdapter != null) {
            walletStatusHistoryAdapter.removeItem(i);
        }
    }

    public void showEmptyView(int i, boolean z) {
        this.f34737i.setDisplayedChild(1);
        this.f34732d.setText(i);
        this.f34738j.setVisibility(z ? 0 : 8);
    }

    public void hideEmptyView() {
        this.f34737i.setDisplayedChild(0);
    }

    /* renamed from: d */
    private void m26533d() {
        if (!this.f34735g.isSelected()) {
            this.f34735g.setSelected(true);
            this.f34736h.setSelected(false);
            this.f34739k.loadHistoryData(true, getCurrentCategory());
            GlobalOmegaUtils.trackBoletoHistoryUnpaidCK();
        }
    }

    /* renamed from: e */
    private void m26534e() {
        if (!this.f34736h.isSelected()) {
            this.f34736h.setSelected(true);
            this.f34735g.setSelected(false);
            this.f34739k.loadHistoryData(true, getCurrentCategory());
            GlobalOmegaUtils.trackBoletoHistoryCompletedCK();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.history_unpaid) {
            m26533d();
        } else if (view.getId() == R.id.history_completed) {
            m26534e();
        }
    }

    public int getCurrentCategory() {
        return this.f34735g.isSelected() ^ true ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f34739k.destroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        WalletStatusHistoryContract.Presenter presenter;
        WalletStatusHistoryContract.Presenter presenter2;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1 && (presenter2 = this.f34739k) != null) {
                presenter2.gotoPayResultPage();
            }
        } else if (i == 200) {
            if (intent.getIntExtra("code", 3) == 1 && (presenter = this.f34739k) != null) {
                presenter.gotoPayResultPage();
            }
        } else if (i == 101) {
            this.f34739k.loadHistoryData(true, getCurrentCategory());
        }
    }
}
