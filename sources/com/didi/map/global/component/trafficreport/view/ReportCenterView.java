package com.didi.map.global.component.trafficreport.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.trafficreport.TrafficReportParam;
import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.presenter.ITrafficReportPresenter;
import com.didi.map.global.component.trafficreport.util.LocUtils;
import com.didi.map.global.component.trafficreport.util.ReportOmegaUtil;
import com.didi.map.global.component.trafficreport.view.history.ContributionActivity;
import com.didi.map.global.component.trafficreport.view.recycler.GroupItemDecoration;
import com.didi.map.global.component.trafficreport.view.recycler.GroupViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.ItemViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.ReportEventAdapter;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportCenterView extends BaseDialogView implements IReportCenterView {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f28628b = ReportCenterView.class.getSimpleName();

    /* renamed from: a */
    List<ReportGroup> f28629a;

    /* renamed from: c */
    private RecyclerView f28630c;

    /* renamed from: d */
    private ImageView f28631d;

    /* renamed from: e */
    private RelativeLayout f28632e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TrafficReportParam f28633f;
    public ITrafficReportPresenter mPresenter;

    public ReportCenterView(TrafficReportParam trafficReportParam, List<ReportGroup> list) {
        super(trafficReportParam.getContext());
        this.f28629a = new ArrayList(list);
        this.f28633f = trafficReportParam;
    }

    public ReportCenterView(TrafficReportParam trafficReportParam) {
        super(trafficReportParam.getContext());
        this.f28633f = trafficReportParam;
    }

    public void performCreateView(ITrafficReportPresenter iTrafficReportPresenter, List<ReportGroup> list) {
        this.mPresenter = iTrafficReportPresenter;
        final LayoutInflater from = LayoutInflater.from(this.mContext);
        this.mContentView = from.inflate(R.layout.layout_report_center, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) this.mContentView.findViewById(R.id.rv_report);
        this.f28630c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.f28631d = (ImageView) this.mContentView.findViewById(R.id.iv_rp_close);
        this.f28632e = (RelativeLayout) this.mContentView.findViewById(R.id.layout_my_contribution);
        this.f28631d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ReportCenterView.this.mPresenter.onViewClose(0);
            }
        });
        this.f28632e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ReportOmegaUtil.trackPaxContributionCk(PaxEnvironment.getInstance().getUid(), ReportCenterView.this.f28633f.getOrderId(), LocUtils.getCurrentLocation(ReportCenterView.this.mContext));
                ReportCenterView.this.mContext.startActivity(new Intent().setClass(ReportCenterView.this.mContext, ContributionActivity.class));
            }
        });
        C104103 r0 = new ReportEventAdapter<ReportGroup, GroupViewHolder, ItemViewHolder>(list) {
            /* access modifiers changed from: protected */
            public GroupViewHolder onCreateGroupViewHolder(ViewGroup viewGroup) {
                return new GroupViewHolder(from.inflate(R.layout.layout_report_center_group_title, viewGroup, false));
            }

            /* access modifiers changed from: protected */
            public ItemViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
                View inflate = from.inflate(R.layout.layout_report_center_item, (ViewGroup) null);
                if (i == ReportEventAdapter.ItemType.FIRST_CHILD.getValue()) {
                    inflate.setBackground(ReportCenterView.this.mContext.getDrawable(R.drawable.report_item_bg_grey_top));
                } else if (i == ReportEventAdapter.ItemType.ONLY_ONE_CHILD.getValue()) {
                    inflate.setBackground(ReportCenterView.this.mContext.getDrawable(R.drawable.report_item_bg_grey));
                } else if (i == ReportEventAdapter.ItemType.END_CHILD.getValue()) {
                    inflate.setBackground(ReportCenterView.this.mContext.getDrawable(R.drawable.report_item_bg_grey_bottom));
                } else if (i == ReportEventAdapter.ItemType.NOT_FIRST_CHILD.getValue()) {
                    inflate.setBackground(ReportCenterView.this.mContext.getDrawable(R.drawable.report_item_bg_grey_center));
                }
                String a = ReportCenterView.f28628b;
                SystemUtils.log(3, a, "onCreateChildViewHolder:  " + i, (Throwable) null, "com.didi.map.global.component.trafficreport.view.ReportCenterView$3", 107);
                return new ItemViewHolder(inflate);
            }

            /* access modifiers changed from: protected */
            public void onBindGroupViewHolder(GroupViewHolder groupViewHolder, int i) {
                if (getGroup(i) != null) {
                    groupViewHolder.updateTitle(((ReportGroup) getGroup(i)).getTitle());
                }
            }

            /* access modifiers changed from: protected */
            public void onBindChildViewHolder(ItemViewHolder itemViewHolder, int i, int i2) {
                if (getGroup(i) != null && !CollectionUtil.isEmpty((Collection<?>) ((ReportGroup) getGroup(i)).getMembers()) && ((ReportGroup) getGroup(i)).getMembers().size() > i2) {
                    itemViewHolder.update(ReportCenterView.this.mContext, ((ReportGroup) getGroup(i)).getMembers().get(i2));
                }
            }

            /* access modifiers changed from: protected */
            public int getChildCount(ReportGroup reportGroup) {
                if (reportGroup.getMembers() != null) {
                    return reportGroup.getMembers().size();
                }
                return 0;
            }
        };
        r0.setOnChildClickListener(new ReportEventAdapter.OnChildClickListener() {
            public void onChildClick(View view, int i, int i2) {
                ReportCenterView.this.mPresenter.onReportItemClick(i, i2);
            }
        });
        this.f28630c.setAdapter(r0);
        GroupItemDecoration groupItemDecoration = new GroupItemDecoration(r0);
        groupItemDecoration.setFirstDividerEnabled(false);
        groupItemDecoration.setGroupDivider(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.divider_height_30_dp, (Resources.Theme) null));
        groupItemDecoration.setTitleDivider(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.divider_height_10_dp, (Resources.Theme) null));
        groupItemDecoration.setChildDivider(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.event_divider_item_1_dp, (Resources.Theme) null));
        this.f28630c.addItemDecoration(groupItemDecoration);
    }

    public void setCancelListener() {
        if (getDialog() != null) {
            getDialog().setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    ReportOmegaUtil.trackPaxOpenOrCloseReport(PaxEnvironment.getInstance().getUid(), ReportCenterView.this.f28633f.getOrderId(), LocUtils.getCurrentLocation(ReportCenterView.this.mContext), "close");
                }
            });
        }
    }

    public void show() {
        ReportOmegaUtil.trackPaxOpenOrCloseReport(PaxEnvironment.getInstance().getUid(), this.f28633f.getOrderId(), LocUtils.getCurrentLocation(this.mContext), "open");
        super.show();
    }

    public void hide() {
        super.hide();
    }
}
