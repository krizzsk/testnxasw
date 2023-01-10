package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.trafficreport.model.MapEntryItem;
import com.didi.map.global.component.trafficreport.model.RemarkItem;
import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import com.didi.map.global.component.trafficreport.model.ReportViewModel;
import com.didi.map.global.component.trafficreport.model.TrafficEventParam;
import com.didi.map.global.component.trafficreport.presenter.ITrafficEventPresenter;
import com.didi.map.global.component.trafficreport.presenter.TrafficEventPresenter;
import com.didi.map.global.component.trafficreport.util.DisplayUtil;
import com.didi.map.global.component.trafficreport.util.LocUtils;
import com.didi.map.global.component.trafficreport.util.ReportOmegaUtil;
import com.didi.map.global.component.trafficreport.view.recycler.DetailItemViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.GroupItemDecoration;
import com.didi.map.global.component.trafficreport.view.recycler.GroupViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.MapEntryViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.RemarkViewHolder;
import com.didi.map.global.component.trafficreport.view.recycler.ReportDetailAdapter;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class ReportDetailFragment extends BaseFragment implements IReportDetailView {

    /* renamed from: a */
    private static final String f28634a = "ReportDetailFragment";

    /* renamed from: b */
    private ReportDetailTitle f28635b;

    /* renamed from: c */
    private RecyclerView f28636c;

    /* renamed from: d */
    private TextView f28637d;

    /* renamed from: e */
    private FrameLayout f28638e;

    /* renamed from: f */
    private MapEntryItem f28639f;

    /* renamed from: g */
    private ReportItem f28640g;

    /* renamed from: h */
    private String f28641h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<ReportGroup> f28642i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TrafficEventParam.Builder f28643j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TrafficEventParam f28644k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ITrafficEventPresenter f28645l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ReportViewModel f28646m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Address f28647n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f28648o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f28649p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f28650q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f28651r = "";

    /* renamed from: s */
    private MyReportDetailAdapter f28652s;

    public interface OnItemSelectListener {
        void OnItemSelected(int i, int i2, boolean z);
    }

    public interface OnRemarkTextListener {
        void OnRemarkText(String str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f28640g = (ReportItem) getArguments().get("request_data");
            this.f28641h = getArguments().getString("request_orderId");
            this.f28642i = this.f28640g.getSecondaryList();
        }
        this.f28645l = new TrafficEventPresenter(getContext(), this, PaxEnvironment.getInstance());
        TrafficEventParam.Builder builder = new TrafficEventParam.Builder();
        this.f28643j = builder;
        builder.eventType(this.f28640g.getItemValue().intValue()).orderId(this.f28641h).sourceType(2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_report_detail_fragment, (ViewGroup) null);
        this.f28635b = (ReportDetailTitle) inflate.findViewById(R.id.report_detail_title);
        this.f28636c = (RecyclerView) inflate.findViewById(R.id.report_detail_recycleView);
        this.f28637d = (TextView) inflate.findViewById(R.id.confirm_report);
        this.f28636c.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f28638e = this.f28635b.getBackView();
        ReportDetailTitle reportDetailTitle = this.f28635b;
        ReportItem reportItem = this.f28640g;
        reportDetailTitle.setTitle(reportItem != null ? reportItem.getItemTitle() : "");
        this.f28637d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ReportDetailFragment.this.f28647n != null) {
                    ReportDetailFragment.this.f28643j.eventPoint(new LatLng(ReportDetailFragment.this.f28647n.latitude, ReportDetailFragment.this.f28647n.longitude)).reportLocName(ReportDetailFragment.this.f28647n.displayName).remark(ReportDetailFragment.this.f28651r).locType(ReportDetailFragment.this.f28648o).trustType(Integer.valueOf(ReportDetailFragment.this.f28650q));
                    if (ReportDetailFragment.this.f28648o != 0) {
                        ReportDetailFragment.this.f28643j.locType(ReportDetailFragment.this.f28648o);
                    }
                    if (ReportDetailFragment.this.f28649p != 0) {
                        ReportDetailFragment.this.f28643j.eventType(ReportDetailFragment.this.f28649p);
                    }
                    ReportDetailFragment reportDetailFragment = ReportDetailFragment.this;
                    TrafficEventParam unused = reportDetailFragment.f28644k = reportDetailFragment.f28643j.build();
                    SystemUtils.log(3, ReportDetailFragment.f28634a, "onClick: " + ReportDetailFragment.this.f28649p + ", " + ReportDetailFragment.this.f28648o, (Throwable) null, "com.didi.map.global.component.trafficreport.view.ReportDetailFragment$1", 121);
                    ReportDetailFragment.this.f28645l.onConfirmReport(ReportDetailFragment.this.f28644k);
                    return;
                }
                DisplayUtil.toastShow(ReportDetailFragment.this.getContext(), ReportDetailFragment.this.getResources().getString(R.string.GRider_PassengerReports_TNRJ_PQYR), R.drawable.icon_toast_failure);
            }
        });
        this.f28638e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ReportDetailFragment.this.getActivity().onBackPressed();
            }
        });
        MyReportDetailAdapter myReportDetailAdapter = new MyReportDetailAdapter(getContext(), this.f28642i, this.f28639f, new RemarkItem(""));
        this.f28652s = myReportDetailAdapter;
        myReportDetailAdapter.setOnMapEntryClickListener(new ReportDetailAdapter.OnMapEntryClickListener() {
            public void onMapEntryClick() {
                if (ReportDetailFragment.this.f28646m != null) {
                    ReportDetailFragment.this.f28646m.setAddress(ReportDetailFragment.this.f28647n);
                }
                ReportSpotFragment reportSpotFragment = new ReportSpotFragment();
                FragmentTransaction beginTransaction = ReportDetailFragment.this.getFragmentManager().beginTransaction();
                beginTransaction.replace(R.id.fragment, reportSpotFragment);
                beginTransaction.addToBackStack((String) null);
                beginTransaction.commit();
                SystemUtils.log(3, ReportDetailFragment.f28634a, "onMapEntryClick: " + ReportDetailFragment.this.getFragmentManager().getBackStackEntryCount(), (Throwable) null, "com.didi.map.global.component.trafficreport.view.ReportDetailFragment$3", 153);
            }
        });
        this.f28652s.setOnItemSelectListener(new OnItemSelectListener() {
            public void OnItemSelected(int i, int i2, boolean z) {
                int intValue = (ReportDetailFragment.this.f28642i == null || ReportDetailFragment.this.f28642i.size() <= i || ReportDetailFragment.this.f28642i.get(i) == null || ((ReportGroup) ReportDetailFragment.this.f28642i.get(i)).getMembers().size() <= i2) ? 0 : ((ReportGroup) ReportDetailFragment.this.f28642i.get(i)).getMembers().get(i2).getItemValue().intValue();
                if (ReportDetailFragment.this.f28642i == null || ReportDetailFragment.this.f28642i.size() <= i || ((ReportGroup) ReportDetailFragment.this.f28642i.get(i)).getCateCode() != 4) {
                    if (!z && ReportDetailFragment.this.f28649p == intValue) {
                        int unused = ReportDetailFragment.this.f28649p = 0;
                    }
                    if (z) {
                        int unused2 = ReportDetailFragment.this.f28649p = intValue;
                        return;
                    }
                    return;
                }
                if (!z && ReportDetailFragment.this.f28648o == intValue) {
                    int unused3 = ReportDetailFragment.this.f28648o = 0;
                }
                if (z) {
                    int unused4 = ReportDetailFragment.this.f28648o = intValue;
                }
            }
        });
        setConfirmBtnState(false);
        this.f28652s.setOnRemarkTextListener(new OnRemarkTextListener() {
            public void OnRemarkText(String str) {
                String unused = ReportDetailFragment.this.f28651r = str;
            }
        });
        this.f28636c.setAdapter(this.f28652s);
        this.f28652s.setDefaultSelection();
        GroupItemDecoration groupItemDecoration = new GroupItemDecoration(this.f28652s);
        groupItemDecoration.setFirstDividerEnabled(false);
        groupItemDecoration.setGroupDivider(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.divider_height_30_dp, (Resources.Theme) null));
        groupItemDecoration.setRemarkDivider(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.divider_height_10_dp, (Resources.Theme) null));
        groupItemDecoration.setChildDivider(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.divider_detail_item_1_dp, (Resources.Theme) null));
        this.f28636c.addItemDecoration(groupItemDecoration);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ReportViewModel reportViewModel = (ReportViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity(), (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(ReportViewModel.class);
        this.f28646m = reportViewModel;
        reportViewModel.getAddress().observe(getActivity(), new Observer() {
            public final void onChanged(Object obj) {
                ReportDetailFragment.this.m22317a((Address) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22317a(Address address) {
        this.f28647n = address;
        this.f28650q = 1;
        this.f28652s.setAddress(address);
    }

    public void onResume() {
        super.onResume();
        ReportOmegaUtil.trackPaxReportDetailShow(PaxEnvironment.getInstance().getUid(), this.f28641h, LocUtils.getCurrentLocation(getContext()));
        this.f28645l.onLoadCurrentAddress(this.f28647n);
    }

    public void showReportResultToast(boolean z, String str) {
        if (z) {
            if (this.f28644k != null) {
                ReportOmegaUtil.trackPaxReportDetailCk(PaxEnvironment.getInstance().getUid(), this.f28644k.getOrderId(), LocUtils.getCurrentLocation(getContext()), TextUtils.isEmpty(this.f28644k.getRemark()) ^ true ? 1 : 0, this.f28649p == 0 ? 0 : 1, "report");
            }
            DisplayUtil.toastShow(getContext(), str, R.drawable.icon_toast_success);
            if (this.mBackHandledInterface != null) {
                this.mBackHandledInterface.onConfirmPressed();
                return;
            }
            return;
        }
        DisplayUtil.toastShow(getContext(), str, R.drawable.icon_toast_failure);
    }

    public void updateLocation(Address address) {
        if (address != null) {
            this.f28647n = address;
            this.f28652s.setAddress(address);
            this.f28652s.notifyItemChanged(0);
            setConfirmBtnState(true);
        }
    }

    public boolean onBackPressed() {
        ReportOmegaUtil.trackPaxReportDetailCk(PaxEnvironment.getInstance().getUid(), this.f28641h, LocUtils.getCurrentLocation(getContext()), TextUtils.isEmpty(this.f28651r) ^ true ? 1 : 0, this.f28649p == 0 ? 0 : 1, "close");
        return false;
    }

    static class MyReportDetailAdapter extends ReportDetailAdapter<ReportGroup, GroupViewHolder, DetailItemViewHolder, MapEntryViewHolder, RemarkViewHolder> {
        /* access modifiers changed from: private */
        public boolean checkedState = false;
        private Address headerAddress;
        private LayoutInflater inflater;
        /* access modifiers changed from: private */
        public int layoutPosition;
        /* access modifiers changed from: private */
        public Context mContext;
        private int mDefaultSelectGroup = -1;
        private OnItemSelectListener mOnItemSelectListener;
        /* access modifiers changed from: private */
        public OnRemarkTextListener mRemarkTextListener;

        public MyReportDetailAdapter(Context context, List<ReportGroup> list, MapEntryItem mapEntryItem, RemarkItem remarkItem) {
            super(list, mapEntryItem, remarkItem);
            this.inflater = LayoutInflater.from(context);
            this.mContext = context;
        }

        public void setAddress(Address address) {
            this.headerAddress = address;
        }

        public void setDefaultSelection() {
            for (int i = 0; i < this.mGroups.size(); i++) {
                if (((ReportGroup) this.mGroups.get(i)).getCateCode() == 4) {
                    this.mDefaultSelectGroup = i;
                    return;
                }
            }
        }

        public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
            this.mOnItemSelectListener = onItemSelectListener;
        }

        public void setOnRemarkTextListener(OnRemarkTextListener onRemarkTextListener) {
            this.mRemarkTextListener = onRemarkTextListener;
        }

        /* access modifiers changed from: protected */
        public GroupViewHolder onCreateGroupViewHolder(ViewGroup viewGroup) {
            return new GroupViewHolder(this.inflater.inflate(R.layout.layout_report_detail_group_title, viewGroup, false));
        }

        /* access modifiers changed from: protected */
        public DetailItemViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
            return new DetailItemViewHolder(this.inflater.inflate(R.layout.layout_report_detail_item, (ViewGroup) null));
        }

        /* access modifiers changed from: protected */
        public MapEntryViewHolder onCreateMapEntryViewHolder(ViewGroup viewGroup) {
            return new MapEntryViewHolder(this.inflater.inflate(R.layout.layout_report_detail_mapentry, (ViewGroup) null));
        }

        /* access modifiers changed from: protected */
        public RemarkViewHolder onCreateRemarkViewHolder(ViewGroup viewGroup) {
            return new RemarkViewHolder(this.inflater.inflate(R.layout.layout_report_detail_remark, (ViewGroup) null));
        }

        /* access modifiers changed from: protected */
        public void onBindGroupViewHolder(GroupViewHolder groupViewHolder, int i) {
            if (getGroup(i) != null) {
                groupViewHolder.updateTitle(((ReportGroup) getGroup(i)).getTitle());
            }
        }

        /* access modifiers changed from: protected */
        public void onBindChildViewHolder(final DetailItemViewHolder detailItemViewHolder, final int i, int i2) {
            if (getGroup(i) != null && !CollectionUtil.isEmpty((Collection<?>) ((ReportGroup) getGroup(i)).getMembers())) {
                detailItemViewHolder.update(((ReportGroup) getGroup(i)).getMembers().get(i2));
                if (i == this.mDefaultSelectGroup && i2 == 0) {
                    this.layoutPosition = ((i + 1) * 2) + i;
                }
                detailItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        int unused = MyReportDetailAdapter.this.layoutPosition = detailItemViewHolder.getLayoutPosition();
                        boolean unused2 = MyReportDetailAdapter.this.checkedState = detailItemViewHolder.getRadioButton().isChecked();
                        MyReportDetailAdapter myReportDetailAdapter = MyReportDetailAdapter.this;
                        myReportDetailAdapter.notifyItemRangeChanged(myReportDetailAdapter.getPositionStart(i), ((ReportGroup) MyReportDetailAdapter.this.getGroup(i)).getMembers().size());
                    }
                });
                if (this.layoutPosition == ((i + 1) * 2) + i2 + i) {
                    boolean isChecked = detailItemViewHolder.getRadioButton().isChecked();
                    if (this.checkedState != isChecked) {
                        this.mOnItemSelectListener.OnItemSelected(i, i2, isChecked);
                    } else {
                        detailItemViewHolder.getRadioButton().setChecked(!isChecked);
                        this.mOnItemSelectListener.OnItemSelected(i, i2, !isChecked);
                    }
                } else {
                    detailItemViewHolder.getRadioButton().setChecked(false);
                }
                this.mDefaultSelectGroup = -1;
            }
        }

        /* access modifiers changed from: protected */
        public void onBindMapEntryViewHolder(MapEntryViewHolder mapEntryViewHolder, Address address) {
            mapEntryViewHolder.update(new MapEntryItem(this.headerAddress), this.mContext);
        }

        /* access modifiers changed from: protected */
        public void onBindRemarkViewHolder(final RemarkViewHolder remarkViewHolder, int i) {
            remarkViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    remarkViewHolder.getRemarkView().requestFocus();
                    DisplayUtil.showSoftInput(MyReportDetailAdapter.this.mContext, remarkViewHolder.getRemarkView());
                }
            });
            remarkViewHolder.getRemarkView().addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (MyReportDetailAdapter.this.mRemarkTextListener != null) {
                        MyReportDetailAdapter.this.mRemarkTextListener.OnRemarkText(editable.toString());
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        public int getChildCount(ReportGroup reportGroup) {
            return reportGroup.getMembers().size();
        }

        public long getItemId(int i) {
            return super.getItemId(i);
        }

        /* access modifiers changed from: private */
        public int getPositionStart(int i) {
            int i2 = 2;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = i2 + ((getGroup(i3) == null || ((ReportGroup) getGroup(i3)).getMembers() == null) ? 0 : ((ReportGroup) getGroup(i3)).getMembers().size()) + 1;
            }
            return i2;
        }
    }

    public void setConfirmBtnState(boolean z) {
        TextView textView = this.f28637d;
        if (textView == null) {
            return;
        }
        if (z) {
            try {
                this.f28637d.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
                this.f28637d.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            textView.setBackground(getResources().getDrawable(R.drawable.report_detail_cancel_button_bg));
            this.f28637d.setTextColor(getResources().getColor(R.color.light_gray));
        }
    }
}
