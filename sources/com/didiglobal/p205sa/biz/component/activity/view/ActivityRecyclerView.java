package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.NetUtil;
import com.didiglobal.p205sa.biz.component.activity.ActivityRecAdapter;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.activity.presenter.IActivityPresenter;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.RefreshListenerAdapter;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRecyclerView */
public class ActivityRecyclerView implements IActivityPanelView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f53291a;

    /* renamed from: b */
    private View f53292b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f53293c;

    /* renamed from: d */
    private ActivityRecAdapter f53294d;

    /* renamed from: e */
    private ViewStub f53295e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f53296f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f53297g = 0;

    /* renamed from: h */
    private View f53298h;

    /* renamed from: i */
    private TwinklingRefreshLayout f53299i;

    /* renamed from: j */
    private View f53300j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IActivityPresenter f53301k;

    /* renamed from: l */
    private View f53302l;

    /* renamed from: a */
    static /* synthetic */ int m39873a(ActivityRecyclerView activityRecyclerView, int i) {
        int i2 = activityRecyclerView.f53296f + i;
        activityRecyclerView.f53296f = i2;
        return i2;
    }

    public ActivityRecyclerView(Context context) {
        this.f53291a = context;
        m39874a();
    }

    /* renamed from: a */
    private void m39874a() {
        View inflate = LayoutInflater.from(this.f53291a).inflate(R.layout.activity_component_panel_recyclerview, (ViewGroup) null, false);
        this.f53292b = inflate;
        this.f53295e = (ViewStub) inflate.findViewById(R.id.empty_container);
        this.f53300j = this.f53292b.findViewById(R.id.activity_loading);
        this.f53302l = this.f53292b.findViewById(R.id.subtitle);
        this.f53300j.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) this.f53292b.findViewById(R.id.activity_panel_view);
        this.f53293c = this.f53292b.findViewById(R.id.activity_title_container);
        final TextView textView = (TextView) this.f53292b.findViewById(R.id.title);
        this.f53299i = (TwinklingRefreshLayout) this.f53292b.findViewById(R.id.activity_refresh_layout);
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53293c.getLayoutParams();
        layoutParams.height += AppUtils.getStatusBarHeight(this.f53291a);
        this.f53302l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DRouter.build("GlobalOneTravel://one/history").start();
                ActivityOmegaTracker.OmegaHistoryClick();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ActivityRecAdapter activityRecAdapter = new ActivityRecAdapter(this.f53291a);
        this.f53294d = activityRecAdapter;
        recyclerView.setAdapter(activityRecAdapter);
        final int dip2px = UiUtils.dip2px(this.f53291a, 20.0f);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                ActivityRecyclerView.m39873a(ActivityRecyclerView.this, i2);
                if (ActivityRecyclerView.this.f53296f < dip2px) {
                    if (layoutParams.height != UiUtils.dip2px(ActivityRecyclerView.this.f53291a, 72.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f53291a)) {
                        ActivityRecyclerView.this.f53293c.setBackgroundColor(ActivityRecyclerView.this.f53291a.getResources().getColor(R.color.sa_activity_bgcolor));
                        textView.setTextSize(2, 24.0f);
                        layoutParams.height = UiUtils.dip2px(ActivityRecyclerView.this.f53291a, 72.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f53291a);
                        ActivityRecyclerView.this.f53293c.requestLayout();
                    }
                    View c = ActivityRecyclerView.this.f53293c;
                    float f = 0.0f;
                    if (1.0f - ((((float) ActivityRecyclerView.this.f53296f) * 1.0f) / ((float) dip2px)) >= 0.0f) {
                        f = 1.0f - ((((float) ActivityRecyclerView.this.f53296f) * 1.0f) / ((float) dip2px));
                    }
                    c.setAlpha(f);
                } else if (ActivityRecyclerView.this.f53296f < dip2px * 2) {
                    if (layoutParams.height != UiUtils.dip2px(ActivityRecyclerView.this.f53291a, 52.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f53291a)) {
                        ActivityRecyclerView.this.f53293c.setBackgroundColor(-1);
                        textView.setTextSize(2, 20.0f);
                        layoutParams.height = UiUtils.dip2px(ActivityRecyclerView.this.f53291a, 52.0f) + AppUtils.getStatusBarHeight(ActivityRecyclerView.this.f53291a);
                        ActivityRecyclerView.this.f53293c.requestLayout();
                    }
                    View c2 = ActivityRecyclerView.this.f53293c;
                    int a = ActivityRecyclerView.this.f53296f;
                    int i3 = dip2px;
                    c2.setAlpha((((float) (a - i3)) * 1.0f) / ((float) i3));
                } else if (ActivityRecyclerView.this.f53296f > dip2px * 2) {
                    ActivityRecyclerView.this.f53293c.setAlpha(1.0f);
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    ActivityOmegaTracker.OmegaActivitySlide(ActivityRecyclerView.this.f53296f - ActivityRecyclerView.this.f53297g > 0 ? "up" : "down");
                    ActivityRecyclerView activityRecyclerView = ActivityRecyclerView.this;
                    int unused = activityRecyclerView.f53297g = activityRecyclerView.f53296f;
                }
            }
        });
        this.f53299i.setOnRefreshListener(new RefreshListenerAdapter() {
            public void onRefresh(TwinklingRefreshLayout twinklingRefreshLayout) {
                if (ActivityRecyclerView.this.f53301k != null && ActivityRecyclerView.this.m39878b()) {
                    ActivityRecyclerView.this.f53301k.requestRefresh();
                }
            }

            public void onLoadMore(TwinklingRefreshLayout twinklingRefreshLayout) {
                if (ActivityRecyclerView.this.f53301k != null && ActivityRecyclerView.this.m39878b()) {
                    ActivityRecyclerView.this.f53301k.requestLoadMore();
                }
            }
        });
        this.f53294d.addHeader(new ActivityEmptyHeader(this.f53291a));
        this.f53299i.setBottomView(new ActivityLoadMore(this.f53291a));
        this.f53299i.setHeaderView(new ActivityRefreshView(this.f53291a));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m39878b() {
        boolean isAvailable = NetUtil.isAvailable(this.f53291a);
        if (!isAvailable) {
            Context context = this.f53291a;
            ToastUtils.showToast(context, context.getString(R.string.GRider_batch1__SSTN), R.drawable.activity_toast_icon);
            resetLoading();
        }
        return isAvailable;
    }

    public View getView() {
        return this.f53292b;
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        resetLoading();
        this.f53300j.setVisibility(8);
        TwinklingRefreshLayout twinklingRefreshLayout = this.f53299i;
        if (twinklingRefreshLayout != null && twinklingRefreshLayout.getVisibility() == 8) {
            this.f53299i.setVisibility(0);
            View view = this.f53298h;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        this.f53294d.addAll(list, i);
        m39875a(i2);
    }

    public void resetLoading() {
        if (this.f53299i.isRefreshing()) {
            this.f53299i.finishRefreshing();
        }
        if (this.f53299i.isLoadingMore()) {
            this.f53299i.finishLoadmore();
        }
    }

    public void setPresenter(IActivityPresenter iActivityPresenter) {
        this.f53301k = iActivityPresenter;
    }

    public void showErrorView(int i, String str) {
        resetLoading();
        this.f53300j.setVisibility(8);
        if (this.f53298h == null) {
            this.f53298h = this.f53295e.inflate();
        }
        if (this.f53298h != null) {
            this.f53299i.setVisibility(8);
            this.f53298h.setVisibility(0);
            ImageView imageView = (ImageView) this.f53298h.findViewById(R.id.empty_img);
            TextView textView = (TextView) this.f53298h.findViewById(R.id.empty_tips);
            if (imageView != null) {
                imageView.setImageResource(i);
            }
            if (textView != null) {
                textView.setText(str);
            }
            this.f53298h.findViewById(R.id.empty_retry).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ActivityRecyclerView.this.f53301k.reqeustRetry();
                }
            });
        }
    }

    /* renamed from: a */
    private void m39875a(int i) {
        if (i == 0) {
            this.f53299i.setEnableLoadmore(true);
            this.f53294d.removeFooters();
        } else if (i == 1) {
            if (this.f53294d.getFooters().size() == 0) {
                this.f53294d.addFooter(new ActivityRecAdapter.ItemView() {
                    public View onCreateView(ViewGroup viewGroup) {
                        return LayoutInflater.from(ActivityRecyclerView.this.f53291a).inflate(R.layout.activity_card_no_more_data, viewGroup, false);
                    }

                    public void onBindView(View view) {
                        View findViewById = view.findViewById(R.id.foot_des);
                        if (findViewById != null) {
                            ((TextView) findViewById).setText("- " + ActivityRecyclerView.this.f53291a.getString(R.string.GRider_batch1__PsJO) + " -");
                        }
                    }
                });
                this.f53299i.setEnableLoadmore(false);
            }
        } else if (i == -1) {
            this.f53294d.removeFooters();
            this.f53299i.setEnableLoadmore(false);
        }
    }
}
