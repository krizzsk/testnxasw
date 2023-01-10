package com.didi.map.global.component.trafficreport.view.history;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.trafficreport.model.ContributionData;
import com.didi.map.global.component.trafficreport.presenter.ContributionPresenter;
import com.didi.map.global.component.trafficreport.presenter.IContributionPresenter;
import com.didi.map.global.component.trafficreport.util.DisplayUtil;
import com.didi.map.global.component.trafficreport.view.history.LoadMoreRecyclerView;
import com.didi.map.global.component.trafficreport.view.recycler.GroupItemDecoration;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.taxis99.R;
import java.util.List;

public class ContributionActivity extends FragmentActivity implements IContributionView, LoadMoreRecyclerView.LoadMoreListener {

    /* renamed from: a */
    private static final String f28736a = "ContributionActivity";

    /* renamed from: n */
    private static final int f28737n = 10;

    /* renamed from: b */
    private ContributionCountItemView f28738b;

    /* renamed from: c */
    private ContributionCountItemView f28739c;

    /* renamed from: d */
    private ContributionCountItemView f28740d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IContributionPresenter f28741e;

    /* renamed from: f */
    private ImageView f28742f;

    /* renamed from: g */
    private AppBarLayout f28743g;

    /* renamed from: h */
    private LoadMoreRecyclerView f28744h;

    /* renamed from: i */
    private ReportHistoryAdapter f28745i;

    /* renamed from: j */
    private LinearLayout f28746j;

    /* renamed from: k */
    private LinearLayout f28747k;

    /* renamed from: l */
    private TextView f28748l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f28749m = 0;

    /* renamed from: o */
    private Context f28750o;

    public void showSuccessView() {
    }

    /* renamed from: b */
    static /* synthetic */ int m22378b(ContributionActivity contributionActivity) {
        int i = contributionActivity.f28749m + 1;
        contributionActivity.f28749m = i;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f28750o = this;
        try {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null)) {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(201326592);
                window.getDecorView().setSystemUiVisibility(1280);
                window.setStatusBarColor(0);
                if (Build.VERSION.SDK_INT >= 23) {
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
                }
            }
        } catch (Exception unused) {
            DLog.m10773d(f28736a, "set status bar style exception", new Object[0]);
        }
        m22374a();
        ContributionPresenter contributionPresenter = new ContributionPresenter(getApplicationContext(), this);
        this.f28741e = contributionPresenter;
        PaxEnvironment instance = PaxEnvironment.getInstance();
        int i = this.f28749m + 1;
        this.f28749m = i;
        contributionPresenter.getContributionHistory(instance, i, 10, false);
    }

    /* renamed from: a */
    private void m22374a() {
        setContentView((int) R.layout.layout_report_history);
        this.f28743g = (AppBarLayout) findViewById(R.id.cb_bar_layout);
        this.f28742f = (ImageView) findViewById(R.id.cb_iv_back);
        this.f28744h = (LoadMoreRecyclerView) findViewById(R.id.report_contributions);
        this.f28738b = (ContributionCountItemView) findViewById(R.id.item_view_help_count);
        this.f28739c = (ContributionCountItemView) findViewById(R.id.item_view_event);
        this.f28740d = (ContributionCountItemView) findViewById(R.id.item_view_report);
        this.f28746j = (LinearLayout) findViewById(R.id.layout_no_data);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_retry);
        this.f28747k = linearLayout;
        this.f28748l = (TextView) linearLayout.findViewById(R.id.retry);
        this.f28738b.getCountView().setTextSize(25.0f);
        this.f28738b.getTimeView().setText(getResources().getString(R.string.GRider_PassengerReports_GCJY_BtbW, new Object[]{""}));
        this.f28738b.setDescription(getResources().getString(R.string.GRider_PassengerReports_wgSZ_MiPy));
        this.f28739c.setTimesVisible(false);
        this.f28739c.setDescription(getResources().getString(R.string.GRider_PassengerReports_uFSf_sywv));
        this.f28740d.setTimesVisible(false);
        this.f28740d.setDescription(getResources().getString(R.string.GRider_PassengerReports_CEGQ_rOus));
        this.f28742f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ContributionActivity.this.m22375a(view);
            }
        });
        this.f28748l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int unused = ContributionActivity.this.f28749m = 0;
                if (ContributionActivity.this.f28741e != null) {
                    ContributionActivity.this.f28741e.getContributionHistory(PaxEnvironment.getInstance(), ContributionActivity.m22378b(ContributionActivity.this), 10, false);
                }
            }
        });
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        if (loadMoreRecyclerView != null) {
            loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            ReportHistoryAdapter reportHistoryAdapter = new ReportHistoryAdapter(this);
            this.f28745i = reportHistoryAdapter;
            this.f28744h.setAdapter(reportHistoryAdapter);
            this.f28744h.setLoadMoreListener(this);
            GroupItemDecoration groupItemDecoration = new GroupItemDecoration(this.f28745i);
            groupItemDecoration.setFirstDividerEnabled(false);
            groupItemDecoration.setChildDivider(ResourcesCompat.getDrawable(this.f28750o.getResources(), R.drawable.history_divider_item_1_dp, (Resources.Theme) null));
            this.f28744h.addItemDecoration(groupItemDecoration);
        }
        m22382d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22375a(View view) {
        finish();
    }

    public void showLoadingView() {
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        if (loadMoreRecyclerView != null) {
            loadMoreRecyclerView.setLoadState(11);
        }
    }

    public void showFailView(boolean z) {
        if (z) {
            this.f28749m--;
            LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
            if (loadMoreRecyclerView != null) {
                loadMoreRecyclerView.setLoadState(10);
                return;
            }
            return;
        }
        m22383e();
    }

    public void updateNotificationSum(int i) {
        ContributionCountItemView contributionCountItemView = this.f28738b;
        if (contributionCountItemView != null) {
            contributionCountItemView.setCountNum(DisplayUtil.convertText(i));
        }
    }

    public void updateReportCount(int i) {
        ContributionCountItemView contributionCountItemView = this.f28739c;
        if (contributionCountItemView != null) {
            contributionCountItemView.setCountNum(DisplayUtil.convertText(i));
        }
    }

    public void updateFeedbackCount(int i) {
        ContributionCountItemView contributionCountItemView = this.f28740d;
        if (contributionCountItemView != null) {
            contributionCountItemView.setCountNum(DisplayUtil.convertText(i));
        }
    }

    public void updateContributionData(List<ContributionData> list) {
        if (list != null) {
            DLog.m10773d(f28736a, "updateContributionData data size = " + list.size(), new Object[0]);
            if (list.size() != 0 || m22384f()) {
                m22380c();
                ReportHistoryAdapter reportHistoryAdapter = this.f28745i;
                if (reportHistoryAdapter != null) {
                    reportHistoryAdapter.addContributionData(list);
                }
                if (list.size() < 10) {
                    if (m22384f()) {
                        this.f28744h.setLoadState(12);
                    }
                } else if (m22384f()) {
                    this.f28744h.setLoadState(10);
                }
            }
        }
    }

    public void updatePageNum(int i) {
        this.f28749m = i;
    }

    public void onPointerCaptureChanged(boolean z) {
        super.onPointerCaptureChanged(z);
    }

    public void loadMore() {
        SystemUtils.log(3, f28736a, "loadMore: click!!", (Throwable) null, "com.didi.map.global.component.trafficreport.view.history.ContributionActivity", 226);
        IContributionPresenter iContributionPresenter = this.f28741e;
        if (iContributionPresenter != null) {
            PaxEnvironment instance = PaxEnvironment.getInstance();
            int i = this.f28749m + 1;
            this.f28749m = i;
            iContributionPresenter.getContributionHistory(instance, i, 10, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        IContributionPresenter iContributionPresenter = this.f28741e;
        if (iContributionPresenter != null) {
            iContributionPresenter.cancelGetContributionHistory();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m22379b() {
        if (!m22384f()) {
            return false;
        }
        if (this.f28744h.canScrollVertically(1) || this.f28744h.canScrollVertically(-1)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private void m22380c() {
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        if (loadMoreRecyclerView != null && loadMoreRecyclerView.getVisibility() != 0) {
            DLog.m10773d(f28736a, "showHistoryView", new Object[0]);
            this.f28746j.setVisibility(8);
            this.f28747k.setVisibility(8);
            this.f28744h.setVisibility(0);
            this.f28744h.post(new Runnable() {
                public void run() {
                    ContributionActivity contributionActivity = ContributionActivity.this;
                    contributionActivity.m22377a(contributionActivity.m22379b());
                }
            });
        }
    }

    /* renamed from: d */
    private void m22382d() {
        DLog.m10773d(f28736a, "hideHistoryView", new Object[0]);
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        if (loadMoreRecyclerView != null && loadMoreRecyclerView.getVisibility() == 0) {
            this.f28744h.setVisibility(8);
            m22377a(false);
        }
        this.f28747k.setVisibility(8);
        this.f28746j.setVisibility(0);
    }

    /* renamed from: e */
    private void m22383e() {
        DLog.m10773d(f28736a, "showReportErrorView", new Object[0]);
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        if (loadMoreRecyclerView != null && loadMoreRecyclerView.getVisibility() == 0) {
            this.f28744h.setVisibility(8);
            m22377a(false);
        }
        this.f28747k.setVisibility(0);
        this.f28746j.setVisibility(8);
    }

    /* renamed from: f */
    private boolean m22384f() {
        LoadMoreRecyclerView loadMoreRecyclerView = this.f28744h;
        return loadMoreRecyclerView != null && loadMoreRecyclerView.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22377a(boolean z) {
        AppBarLayout.LayoutParams layoutParams;
        AppBarLayout appBarLayout = this.f28743g;
        if (appBarLayout != null) {
            int i = 0;
            View childAt = appBarLayout.getChildAt(0);
            if (childAt != null && (layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams()) != null) {
                if (z) {
                    i = 3;
                }
                layoutParams.setScrollFlags(i);
                childAt.setLayoutParams(layoutParams);
            }
        }
    }
}
