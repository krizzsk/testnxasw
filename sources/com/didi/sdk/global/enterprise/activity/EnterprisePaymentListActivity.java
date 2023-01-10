package com.didi.sdk.global.enterprise.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.enterprise.adapter.EnterprisePaymentListAdapter;
import com.didi.sdk.global.enterprise.contract.EnterprisePaymentListContract;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import com.didi.sdk.global.enterprise.presenter.EnterprisePaymentListPresenter;
import com.didi.sdk.global.indexbar.Decoration.DividerItemDecoration;
import com.didi.sdk.global.indexbar.Decoration.GroupItemDecoration;
import com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener;
import com.didi.sdk.global.indexbar.utils.SortUtil;
import com.didi.sdk.global.indexbar.widget.SearchView;
import com.didi.sdk.global.indexbar.widget.SideBar;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class EnterprisePaymentListActivity extends FragmentActivity implements EnterprisePaymentListContract.View {
    public static final String EXTRA_LAUNCH_TYPE = "LAUNCH_TYPE";
    public static final String EXTRA_RESULT = "RESULT";
    public static final int LAUNCH_TYPE_COMPANY_LIST = 1;
    public static final int LAUNCH_TYPE_COST_CENTER_LIST = 2;
    public static final int LAUNCH_TYPE_PROJECT_LIST = 3;

    /* renamed from: a */
    private static final String f38889a = "PHONE_NUMBER";

    /* renamed from: b */
    private static final String f38890b = "CAR_LEVEL";

    /* renamed from: c */
    private static final String f38891c = "MEMBER_ID";

    /* renamed from: d */
    private static final String f38892d = "COMPANY_ID";

    /* renamed from: e */
    private static final String f38893e = "COST_CENTER_ID";

    /* renamed from: f */
    private static final String f38894f = "COST_CHECKED_ID";

    /* renamed from: A */
    private String f38895A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public List<EnterpriseItem> f38896B;

    /* renamed from: g */
    private TextView f38897g;

    /* renamed from: h */
    private ImageView f38898h;

    /* renamed from: i */
    private RecyclerView f38899i;

    /* renamed from: j */
    private SideBar f38900j;

    /* renamed from: k */
    private SearchView f38901k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f38902l;

    /* renamed from: m */
    private TextView f38903m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f38904n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f38905o;

    /* renamed from: p */
    private RecyclerView.ItemDecoration f38906p;

    /* renamed from: q */
    private RecyclerView.ItemDecoration f38907q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public LinearLayoutManager f38908r;

    /* renamed from: s */
    private EnterprisePaymentListAdapter f38909s;

    /* renamed from: t */
    private EnterprisePaymentListContract.Presenter f38910t;

    /* renamed from: u */
    private int f38911u = 1;

    /* renamed from: v */
    private String f38912v;

    /* renamed from: w */
    private String f38913w;

    /* renamed from: x */
    private String f38914x;

    /* renamed from: y */
    private String f38915y;

    /* renamed from: z */
    private String f38916z;

    public static class LaunchInfo {
        public String carLevel;
        public String checkedId;
        public String companyId;
        public String costCenterId;
        public int launchType;
        public String memberId;
        public String phoneNumber;
        public int requestCode;
    }

    /* renamed from: a */
    private int m29252a(int i) {
        return i != 2 ? i != 3 ? R.string.one_payment_global_enterprise_company_list_title : R.string.one_payment_global_enterprise_project_list_title : R.string.one_payment_global_enterprise_cost_center_list_title;
    }

    public Context getContext() {
        return this;
    }

    public static void launch(Activity activity, LaunchInfo launchInfo) {
        Intent intent = new Intent(activity, EnterprisePaymentListActivity.class);
        intent.putExtra(EXTRA_LAUNCH_TYPE, launchInfo.launchType);
        intent.putExtra(f38889a, launchInfo.phoneNumber);
        intent.putExtra(f38890b, launchInfo.carLevel);
        intent.putExtra(f38891c, launchInfo.memberId);
        intent.putExtra(f38892d, launchInfo.companyId);
        intent.putExtra(f38893e, launchInfo.costCenterId);
        intent.putExtra(f38894f, launchInfo.checkedId);
        activity.startActivityForResult(intent, launchInfo.requestCode);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m29256a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_in_from_right, R.anim.one_payment_out_to_left);
        setContentView((int) R.layout.one_payment_activity_enterprise_payment_list);
        m29259b();
        LoggerFactory.getLogger("Enterprise").info(">> onCreate, %d", Integer.valueOf(this.f38911u));
        m29262c();
        m29266e();
        m29267f();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.one_payment_in_from_left, R.anim.one_payment_out_to_right);
    }

    /* renamed from: a */
    private void m29256a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: b */
    private void m29259b() {
        this.f38911u = getIntent().getIntExtra(EXTRA_LAUNCH_TYPE, 1);
        this.f38912v = getIntent().getStringExtra(f38889a);
        this.f38913w = getIntent().getStringExtra(f38890b);
        this.f38914x = getIntent().getStringExtra(f38891c);
        this.f38915y = getIntent().getStringExtra(f38892d);
        this.f38916z = getIntent().getStringExtra(f38893e);
        this.f38895A = getIntent().getStringExtra(f38894f);
        this.f38910t = new EnterprisePaymentListPresenter(this);
    }

    /* renamed from: c */
    private void m29262c() {
        m29264d();
        EnterprisePaymentListAdapter enterprisePaymentListAdapter = new EnterprisePaymentListAdapter();
        this.f38909s = enterprisePaymentListAdapter;
        enterprisePaymentListAdapter.setItemSelectListener(new EnterprisePaymentListAdapter.OnItemSelectListener() {
            public void onItemSelect(int i, EnterpriseItem enterpriseItem, boolean z) {
                if (!z) {
                    Intent intent = new Intent();
                    intent.putExtra(EnterprisePaymentListActivity.EXTRA_RESULT, (Serializable) enterpriseItem.getBean());
                    EnterprisePaymentListActivity.this.setResult(-1, intent);
                }
                EnterprisePaymentListActivity.this.finish();
            }
        });
        this.f38908r = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.f38899i = recyclerView;
        recyclerView.setLayoutManager(this.f38908r);
        this.f38899i.setAdapter(this.f38909s);
        this.f38902l = findViewById(R.id.layout_retry);
        TextView textView = (TextView) findViewById(R.id.tv_retry);
        this.f38903m = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.this.f38902l.setVisibility(8);
                EnterprisePaymentListActivity.this.m29266e();
            }
        });
        this.f38904n = findViewById(R.id.layout_search_no_result);
        this.f38905o = (TextView) findViewById(R.id.tv_search_no_result);
        this.f38900j = (SideBar) findViewById(R.id.side_bar);
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        this.f38901k = searchView;
        searchView.setOnSearchListener(new SearchView.OnSearchListener() {
            public void onSearch(String str) {
                if (TextUtils.isEmpty(str)) {
                    EnterprisePaymentListActivity.this.f38904n.setVisibility(8);
                    EnterprisePaymentListActivity enterprisePaymentListActivity = EnterprisePaymentListActivity.this;
                    enterprisePaymentListActivity.m29258a((List<EnterpriseItem>) enterprisePaymentListActivity.f38896B, true);
                    return;
                }
                EnterprisePaymentListActivity enterprisePaymentListActivity2 = EnterprisePaymentListActivity.this;
                List a = enterprisePaymentListActivity2.m29255a((List<EnterpriseItem>) enterprisePaymentListActivity2.f38896B, str);
                EnterprisePaymentListActivity.this.m29258a((List<EnterpriseItem>) a, false);
                if (a == null || a.isEmpty()) {
                    EnterprisePaymentListActivity.this.f38904n.setVisibility(0);
                    EnterprisePaymentListActivity.this.f38905o.setText(EnterprisePaymentListActivity.this.getString(R.string.one_payment_global_enterprise_list_no_result, new Object[]{str}));
                    return;
                }
                EnterprisePaymentListActivity.this.f38904n.setVisibility(8);
            }
        });
    }

    /* renamed from: d */
    private void m29264d() {
        this.f38897g = (TextView) findViewById(R.id.tv_title);
        this.f38898h = (ImageView) findViewById(R.id.iv_left);
        this.f38897g.setText(m29252a(this.f38911u));
        this.f38898h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.this.m29270g();
                EnterprisePaymentListActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29266e() {
        showLoadingDialog(getString(R.string.one_payment_global_net_toast_loading));
        int i = this.f38911u;
        if (i == 2) {
            this.f38910t.requestCostCenterList(this.f38914x, this.f38915y);
        } else if (i != 3) {
            this.f38910t.requestCompanyList(this.f38912v, this.f38913w);
        } else {
            this.f38910t.requestProjectList(this.f38914x, this.f38915y, this.f38916z);
        }
    }

    public void showToast(String str) {
        if (str.length() > 20) {
            ToastHelper.showLongInfo((Context) this, str);
        } else {
            ToastHelper.showShortInfo((Context) this, str);
        }
    }

    public void showLoadingDialog(String str) {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void refreshList(List<EnterpriseItem> list) {
        dismissLoadingDialog();
        this.f38896B = list;
        if (list == null) {
            LoggerFactory.getLogger("Enterprise").info("refreshList, network error", new Object[0]);
            this.f38903m.setText(R.string.one_payment_global_net_toast_connectionerror);
            this.f38902l.setVisibility(0);
            this.f38901k.setVisibility(8);
            this.f38900j.setVisibility(8);
        } else if (list.isEmpty()) {
            LoggerFactory.getLogger("Enterprise").info("refreshList, list empty", new Object[0]);
            this.f38903m.setText(R.string.one_payment_global_enterprise_list_empty);
            this.f38902l.setVisibility(0);
            this.f38901k.setVisibility(8);
            this.f38900j.setVisibility(8);
        } else {
            SortUtil.sort(list);
            m29258a(list, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29258a(List<EnterpriseItem> list, boolean z) {
        if (list != null) {
            this.f38901k.setVisibility(0);
            this.f38899i.removeItemDecoration(this.f38906p);
            this.f38899i.removeItemDecoration(this.f38907q);
            if (z) {
                List<String> groups = SortUtil.getGroups(list);
                this.f38906p = new GroupItemDecoration(this, groups);
                this.f38907q = new DividerItemDecoration(this, groups);
                this.f38899i.addItemDecoration(this.f38906p);
                this.f38899i.addItemDecoration(this.f38907q);
                this.f38900j.setVisibility(0);
                this.f38900j.setOnSideBarTouchListener(groups, new OnSideBarTouchListener() {
                    public void onTouchEnd() {
                    }

                    public void onTouch(String str, int i) {
                        if (i != -1) {
                            EnterprisePaymentListActivity.this.f38908r.scrollToPositionWithOffset(i, 0);
                        }
                    }
                });
            } else {
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this);
                this.f38907q = dividerItemDecoration;
                this.f38899i.addItemDecoration(dividerItemDecoration);
                this.f38900j.setVisibility(8);
                this.f38900j.setOnSideBarTouchListener((List<String>) null, (OnSideBarTouchListener) null);
            }
            this.f38909s.refresh(list, this.f38895A);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<EnterpriseItem> m29255a(List<EnterpriseItem> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (EnterpriseItem next : list) {
            if (next.getName() != null && next.getName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m29267f() {
        int i = this.f38911u;
        if (i == 1) {
            GlobalOmegaUtils.trackEnterpriseCompanyListSW(this);
        } else if (i == 2) {
            GlobalOmegaUtils.trackEnterpriseCostcenterListSW(this);
        } else if (i == 3) {
            GlobalOmegaUtils.trackEnterpriseProjectListSW(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m29270g() {
        int i = this.f38911u;
        if (i == 1) {
            GlobalOmegaUtils.trackEnterpriseCompanyListBackCK(this);
        } else if (i == 2) {
            GlobalOmegaUtils.trackEnterpriseCostcenterListBackCK(this);
        } else if (i == 3) {
            GlobalOmegaUtils.trackEnterpriseProjectListBackCK(this);
        }
    }
}
