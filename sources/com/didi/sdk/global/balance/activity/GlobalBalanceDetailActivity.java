package com.didi.sdk.global.balance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.adapter.GlobalBalanceCardAdapter;
import com.didi.sdk.global.balance.adapter.SnapPageScrollListener;
import com.didi.sdk.global.balance.contract.GlobalBalanceAccountContract;
import com.didi.sdk.global.balance.model.bean.BalanceDetail;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter;
import com.didi.sdk.global.balance.widget.BalanceTopUpView;
import com.didi.sdk.global.paypal.activity.GlobalBaseActivity;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

@Deprecated
public class GlobalBalanceDetailActivity extends GlobalBaseActivity implements GlobalBalanceAccountContract.View {

    /* renamed from: a */
    private static final String f38776a = "Balance";

    /* renamed from: b */
    private TextView f38777b;

    /* renamed from: c */
    private ImageView f38778c;

    /* renamed from: d */
    private LinearLayout f38779d;

    /* renamed from: e */
    private LinearLayout f38780e;

    /* renamed from: f */
    private GlobalBalanceCardAdapter f38781f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GlobalBalanceAccountContract.Presenter f38782g;

    /* renamed from: h */
    private RecyclerView f38783h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BalanceTopUpView f38784i;

    public static void launch(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GlobalBalanceDetailActivity.class), i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_activity_global_balance_main);
        m29204a();
        m29207b();
        GlobalOmegaUtils.trackBalanceDetailPageSW(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SystemUtils.log(4, "Balance", "onResume called, will load balance info", (Throwable) null, "com.didi.sdk.global.balance.activity.GlobalBalanceDetailActivity", 83);
        m29208c();
    }

    /* renamed from: a */
    private void m29204a() {
        this.f38782g = new GlobalBalanceAccountPresenter(this);
        GlobalBalanceCardAdapter globalBalanceCardAdapter = new GlobalBalanceCardAdapter(this);
        this.f38781f = globalBalanceCardAdapter;
        globalBalanceCardAdapter.setOnItemClickListener(new GlobalBalanceCardAdapter.OnItemClickListener() {
            public void onDetailClick(BalanceDetail balanceDetail, int i) {
                if (GlobalBalanceDetailActivity.this.f38782g != null) {
                    GlobalBalanceDetailActivity.this.f38782g.jumpToBalanceTransDetailsActivity(balanceDetail.transDetailUrl, balanceDetail.currency);
                }
                GlobalOmegaUtils.trackBalanceDetailTransDetailCK(GlobalBalanceDetailActivity.this.getContext());
            }
        });
    }

    /* renamed from: b */
    private void m29207b() {
        this.f38777b = (TextView) findViewById(R.id.tv_title);
        this.f38778c = (ImageView) findViewById(R.id.iv_left);
        this.f38777b.setText(getString(R.string.one_payment_balance_account__title));
        this.f38778c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalBalanceDetailActivity.this.onBackPressed();
                GlobalOmegaUtils.trackPayPalDetailPageReturnCK(GlobalBalanceDetailActivity.this);
            }
        });
        this.f38779d = (LinearLayout) findViewById(R.id.ll_content);
        this.f38780e = (LinearLayout) findViewById(R.id.ll_empty);
        this.f38779d.setVisibility(8);
        this.f38780e.setVisibility(8);
        BalanceTopUpView balanceTopUpView = (BalanceTopUpView) findViewById(R.id.ll_topup_view);
        this.f38784i = balanceTopUpView;
        balanceTopUpView.setPresenter(this.f38782g);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.f38783h = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        new PagerSnapHelper().attachToRecyclerView(this.f38783h);
        this.f38783h.setAdapter(this.f38781f);
        this.f38783h.addOnScrollListener(new SnapPageScrollListener() {
            public void onPageSelected(int i) {
                GlobalBalanceDetailActivity.this.f38784i.onPageSelected(i);
            }
        });
    }

    /* renamed from: c */
    private void m29208c() {
        m29210d();
        this.f38782g.loadBalanceAccounts();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29210d() {
        showLoadingDialog(getResources().getString(R.string.one_payment_waiting));
    }

    /* renamed from: a */
    private boolean m29205a(BalancePageResponse balancePageResponse) {
        return (balancePageResponse == null || balancePageResponse.errno != 0 || balancePageResponse.data == null || balancePageResponse.data.allEntries == null || balancePageResponse.data.allEntries.isEmpty()) ? false : true;
    }

    public void refreshView(BalancePageResponse balancePageResponse) {
        dismissLoadingDialog();
        if (!m29205a(balancePageResponse)) {
            this.f38779d.setVisibility(8);
            this.f38780e.setVisibility(0);
            this.f38780e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalBalanceDetailActivity.this.m29210d();
                    GlobalBalanceDetailActivity.this.f38782g.loadBalanceAccounts();
                }
            });
            return;
        }
        this.f38780e.setVisibility(8);
        this.f38779d.setVisibility(0);
        this.f38777b.setText(balancePageResponse.data.title);
        this.f38781f.refreshData(balancePageResponse);
        this.f38784i.refreshData(balancePageResponse);
    }
}
