package com.didi.payment.wallet.global.useraccount.balance.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.balance.contract.WalletBalanceContract;
import com.didi.payment.wallet.global.useraccount.balance.model.BalanceResp;
import com.didi.payment.wallet.global.useraccount.balance.model.recyclerview.BankBalanceItem;
import com.didi.payment.wallet.global.useraccount.balance.presenter.WalletBalancePresenter;
import com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class WalletBalanceActivity extends WalletBaseActivity implements WalletBalanceContract.View {

    /* renamed from: a */
    private static final String f34354a = "amountRichText";

    /* renamed from: b */
    private static final String f34355b = "channelId";

    /* renamed from: c */
    private static final String f34356c = "currency";

    /* renamed from: d */
    private RecyclerView f34357d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BalanceItemAdapter f34358e;

    /* renamed from: f */
    private LinearLayoutManager f34359f;

    /* renamed from: g */
    private LoadMoreImpl f34360g;

    /* renamed from: h */
    private NetworkErrorRetryImpl f34361h;

    /* renamed from: i */
    private RelativeLayout f34362i;

    /* renamed from: j */
    private ImageView f34363j;

    /* renamed from: k */
    private TextView f34364k;

    /* renamed from: l */
    private TextView f34365l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public WalletBalanceContract.Presenter f34366m;

    public static void launch(Context context, PayRichInfo payRichInfo, int i, String str) {
        Intent intent = new Intent(context, WalletBalanceActivity.class);
        intent.putExtra("amountRichText", payRichInfo);
        intent.putExtra("channelId", i);
        intent.putExtra("currency", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        PayRichInfo payRichInfo;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_balance);
        GlobalOmegaUtils.trackBankBalanceViewSW();
        StatusBarLightingCompat.setStatusBarBgLightning(this, false, getResources().getColor(R.color.wallet_balance_remaining));
        if (Build.VERSION.SDK_INT >= 23) {
            setSystemBarTheme(this, true);
        }
        initLoadingDialog(this, R.id.tb_balance);
        Bundle extras = getIntent().getExtras();
        if (extras != null && (i = extras.getInt("channelId")) != 0) {
            String string = extras.getString("currency");
            if (!"".equals(string) && (payRichInfo = (PayRichInfo) extras.getSerializable("amountRichText")) != null) {
                m26229a();
                m26230a(payRichInfo);
                WalletBalancePresenter walletBalancePresenter = new WalletBalancePresenter(this, this, i, string);
                this.f34366m = walletBalancePresenter;
                walletBalancePresenter.requestData();
            }
        }
    }

    public static final void setSystemBarTheme(Activity activity, boolean z) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility & -8193 : systemUiVisibility | 8192);
    }

    /* renamed from: a */
    private void m26229a() {
        this.f34357d = (RecyclerView) findViewById(R.id.rv_balance_activities);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.tb_balance);
        this.f34362i = relativeLayout;
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.wallet_balance_remaining));
        this.f34364k = (TextView) this.f34362i.findViewById(R.id.tv_title);
        ImageView imageView = (ImageView) this.f34362i.findViewById(R.id.iv_left);
        this.f34363j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBalanceActivity.this.finish();
            }
        });
        this.f34365l = (TextView) findViewById(R.id.tv_balance_remaining);
    }

    /* renamed from: a */
    private void m26230a(PayRichInfo payRichInfo) {
        this.f34363j.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.wallet_balance_nav_back_btn, getTheme()));
        this.f34364k.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
        payRichInfo.bindTextView(this.f34365l);
        this.f34365l.setTypeface((Typeface) null, 1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f34359f = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f34357d.setLayoutManager(this.f34359f);
        this.f34357d.setItemAnimator(new DefaultItemAnimator());
        this.f34360g = new LoadMoreImpl();
        this.f34361h = new NetworkErrorRetryImpl();
        BalanceItemAdapter balanceItemAdapter = new BalanceItemAdapter(this.f34357d, this, new ArrayList());
        this.f34358e = balanceItemAdapter;
        balanceItemAdapter.setLoadMore(this.f34360g);
        this.f34358e.setRetryCallback(this.f34361h);
    }

    public void showLoadingFirstTime() {
        this.f34358e.clearAllItems();
        this.f34357d.setAdapter(this.f34358e);
        showLoadingDialog();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r3.f34358e.getBankBalanceItems().size() - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dismissLoadingFirstTime() {
        /*
            r3 = this;
            com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter r0 = r3.f34358e
            java.util.List r0 = r0.getBankBalanceItems()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0030
            com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter r0 = r3.f34358e
            java.util.List r0 = r0.getBankBalanceItems()
            int r0 = r0.size()
            int r0 = r0 + -1
            com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter r1 = r3.f34358e
            java.util.List r1 = r1.getBankBalanceItems()
            java.lang.Object r1 = r1.get(r0)
            com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter$MyWalletItem r1 = (com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter.MyWalletItem) r1
            if (r1 == 0) goto L_0x0030
            int r1 = r1.mItemViewType
            r2 = 6
            if (r1 != r2) goto L_0x0030
            com.didi.payment.wallet.global.useraccount.balance.view.adapter.BalanceItemAdapter r1 = r3.f34358e
            r1.removeAtIndex(r0)
        L_0x0030:
            r3.dismissLoadingDialog()
            android.widget.TextView r0 = r3.f34365l
            r1 = 0
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.useraccount.balance.view.WalletBalanceActivity.dismissLoadingFirstTime():void");
    }

    public void onBalanceDataSuccessful(List<BalanceResp.StatementBean> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list.size() == 0) {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(6, (BankBalanceItem) null));
            this.f34358e.addItemList(arrayList);
            return;
        }
        arrayList.add(new BalanceItemAdapter.MyWalletItem(0, (BankBalanceItem) null));
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(2, new BankBalanceItem(list.get(i).title, list.get(i).amountText, list.get(i).transDate, list.get(i).transId)));
        }
        if (z) {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(3, (BankBalanceItem) null));
        } else {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(5, (BankBalanceItem) null));
        }
        this.f34358e.addItemList(arrayList);
    }

    public void onBalanceMoreDataSuccessful(List<BalanceResp.StatementBean> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(2, new BankBalanceItem(list.get(i).title, list.get(i).amountText, list.get(i).transDate, list.get(i).transId)));
        }
        BalanceItemAdapter balanceItemAdapter = this.f34358e;
        balanceItemAdapter.removeAtIndex(balanceItemAdapter.getBankBalanceItems().size() - 1);
        if (z) {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(3, (BankBalanceItem) null));
        } else {
            arrayList.add(new BalanceItemAdapter.MyWalletItem(5, (BankBalanceItem) null));
        }
        this.f34358e.addItemList(arrayList);
    }

    public void onNetworkError() {
        ArrayList arrayList = new ArrayList();
        this.f34358e.clearAllItems();
        arrayList.add(new BalanceItemAdapter.MyWalletItem(7, (BankBalanceItem) null));
        this.f34358e.addItemList(arrayList);
    }

    public class LoadMoreImpl implements BalanceItemAdapter.ILoadMore {
        public LoadMoreImpl() {
        }

        public void onLoadMore() {
            WalletBalanceActivity.this.f34358e.removeAtIndex(WalletBalanceActivity.this.f34358e.getBankBalanceItems().size() - 1);
            WalletBalanceActivity.this.f34358e.addItem((BalanceItemAdapter.MyWalletItem) null);
            WalletBalanceActivity.this.f34366m.requestMoreData();
        }
    }

    public class NetworkErrorRetryImpl implements BalanceItemAdapter.INetworkErrorRetry {
        public NetworkErrorRetryImpl() {
        }

        public void onRetry() {
            WalletBalanceActivity.this.f34366m.retryRequestData();
        }
    }
}
