package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.constant.WalletConstants;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoHistoryContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletBoletoHistoryPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.BoletoHistoryAdapter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.DividerItemDecoration;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WalletBoletoHistoryActivity extends WalletBaseActivity implements AdapterView.OnItemClickListener, WalletBoletoHistoryContract.View {

    /* renamed from: a */
    RelativeLayout f34500a;

    /* renamed from: b */
    ImageView f34501b;

    /* renamed from: c */
    TextView f34502c;

    /* renamed from: d */
    private WalletBoletoHistoryContract.Presenter f34503d;

    /* renamed from: e */
    private LinearLayout f34504e;

    /* renamed from: f */
    private RecyclerView f34505f;

    /* renamed from: g */
    private BoletoHistoryAdapter f34506g;

    /* renamed from: h */
    private LinearLayoutManager f34507h;

    public void onNetworkError() {
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, WalletBoletoHistoryActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_history_list);
        m26308a();
        m26309b();
        WalletBoletoHistoryPresenter walletBoletoHistoryPresenter = new WalletBoletoHistoryPresenter(this, this, this);
        this.f34503d = walletBoletoHistoryPresenter;
        walletBoletoHistoryPresenter.requestData();
        GlobalOmegaUtils.trackBillsViewSW();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_boleto_history_list_title_bar);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* renamed from: a */
    private void m26308a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_boleto_history_list_title_bar);
        this.f34500a = relativeLayout;
        this.f34501b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f34502c = (TextView) this.f34500a.findViewById(R.id.tv_title);
        this.f34504e = (LinearLayout) findViewById(R.id.ll_boleto_history_shimmer_view_container);
        this.f34505f = (RecyclerView) findViewById(R.id.rv_boleto_history);
    }

    /* renamed from: b */
    private void m26309b() {
        this.f34501b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoHistoryActivity.this.finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f34507h = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f34505f.setLayoutManager(this.f34507h);
        this.f34505f.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.wallet_boleto_history_rv_divider)));
        this.f34505f.setItemAnimator(new DefaultItemAnimator());
        this.f34506g = new BoletoHistoryAdapter(this.f34505f, this, new ArrayList(), this);
    }

    public void displayBoletoHistory(List<WalletBoletoResp> list) {
        this.f34506g.addItemList(list);
        this.f34505f.setAdapter(this.f34506g);
        this.f34504e.setVisibility(8);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        WalletBoletoResp item = this.f34506g.getItem(i);
        if (item.status.toUpperCase().equalsIgnoreCase(WalletConstants.BOLETO_HISTORY_TYPE_UNPAID)) {
            WalletRouter.gotoBoletoDetailPage(this, item);
        }
    }
}
