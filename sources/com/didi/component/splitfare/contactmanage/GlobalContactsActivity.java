package com.didi.component.splitfare.contactmanage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.areacode.AreaCodeMandatoryGuideActivity;
import com.didi.component.splitfare.contactmanage.GlobalContactsAdapter;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.component.splitfare.model.SplitFareManager;
import com.didi.component.splitfare.model.UpdateSplitFarePartner;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.reactive.tracker.Attrs;
import com.didi.safetoolkit.business.contacts.SimpleDividerDecoration;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.google.gson.Gson;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class GlobalContactsActivity extends AbsLoadingAppCompatActivity {

    /* renamed from: a */
    private static final String f17768a = "GlobalContactsActivity";

    /* renamed from: b */
    private static final String f17769b = "threshold";

    /* renamed from: s */
    private static final int f17770s = 4;

    /* renamed from: A */
    private View f17771A;

    /* renamed from: B */
    private GGKDrawer f17772B;

    /* renamed from: c */
    private ViewGroup f17773c;

    /* renamed from: d */
    private ViewGroup f17774d;

    /* renamed from: e */
    private TextView f17775e;

    /* renamed from: f */
    private TextView f17776f;

    /* renamed from: g */
    private RecyclerView f17777g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public EditText f17778h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f17779i;

    /* renamed from: j */
    private SfCommonTitleBar f17780j;

    /* renamed from: k */
    private GlobalContactsCallback f17781k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IGlobalContactsStore f17782l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public GlobalContactsAdapter f17783m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CopyOnWriteArrayList<GlobalContactsModel> f17784n;

    /* renamed from: o */
    private boolean f17785o;

    /* renamed from: p */
    private View f17786p;

    /* renamed from: q */
    private TextView f17787q;

    /* renamed from: r */
    private PermissionToolsCompat f17788r;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f17789t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public GlobalContactsModel f17790u;

    /* renamed from: v */
    private ViewGroup f17791v;

    /* renamed from: w */
    private boolean f17792w = true;

    /* renamed from: x */
    private boolean f17793x;

    /* renamed from: y */
    private ImageView f17794y;

    /* renamed from: z */
    private TextView f17795z;

    public static Intent getIntent(Context context, int i) {
        Intent intent = new Intent(context, GlobalContactsActivity.class);
        intent.putExtra("threshold", i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        this.f17788r = new PermissionToolsCompat(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.g_contacts_activity_layout);
        findViews();
        setListener();
        m15042e();
        m15045f();
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SEARCH_VIEW_SW);
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f17773c = (ViewGroup) findViewById(R.id.no_permission_layout);
        this.f17775e = (TextView) findViewById(R.id.request_per_btn);
        ((TextView) findViewById(R.id.no_permission_main_title)).setText(String.format(getString(R.string.g_splitfare_contacts_cannot_access), new Object[]{ApkUtils.getAppName(this)}));
        this.f17776f = (TextView) findViewById(R.id.no_permission_sub_title);
        this.f17774d = (ViewGroup) findViewById(R.id.list_layout);
        this.f17780j = (SfCommonTitleBar) findViewById(R.id.share_title_bar);
        this.f17778h = (EditText) findViewById(R.id.search_et);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        this.f17777g = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f17777g.addItemDecoration(new SimpleDividerDecoration(this));
        this.f17778h.setHint(R.string.g_splitfare_contacts_search_hint);
        this.f17778h.setCursorVisible(true);
        this.f17786p = findViewById(R.id.share_bottom_layout);
        this.f17787q = (TextView) findViewById(R.id.share_bottom_btn);
        this.f17780j.setTitleText(getString(R.string.g_splitfare));
        this.f17791v = (ViewGroup) findViewById(R.id.g_split_fare_guide_layout);
        this.f17794y = (ImageView) findViewById(R.id.g_split_fare_guide_close);
        this.f17795z = (TextView) findViewById(R.id.g_split_fare_guide_tv);
        this.f17771A = findViewById(R.id.g_split_fare_guide_win_divide_line);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15028a() {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SENTREQUEST_BTN_CK);
        if (!CollectionUtils.isEmpty((Collection) this.f17784n)) {
            new SplitFareManager(this).startSplitFare(m15034b(), new ResponseListener<UpdateSplitFarePartner>() {
                public void onSuccess(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onSuccess(updateSplitFarePartner);
                    DTSDKOrderDetail dTSDKOrderDetail = updateSplitFarePartner.data.orderDetail;
                    if (dTSDKOrderDetail.isAvailable()) {
                        CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE);
                    GlobalContactsActivity.this.finish();
                }

                public void onFail(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onFail(updateSplitFarePartner);
                    final List<UpdateSplitFarePartner.SplitFareFailGroup> list = updateSplitFarePartner.data.data;
                    if (!CollectionUtils.isEmpty((Collection) list)) {
                        int i = 0;
                        if (list.size() != 1 || list.get(0).contactList == null || list.get(0).contactList.size() <= 0) {
                            SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_FAIL_DLG_SW, new Attrs().attr("error_code", Integer.valueOf(updateSplitFarePartner.errno)));
                            StringBuilder sb = new StringBuilder();
                            while (i < list.size() - 1) {
                                sb.append(list.get(i).errmsg);
                                sb.append("\n");
                                i++;
                            }
                            sb.append(list.get(i).errmsg);
                            GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
                            bottomPopModel.title = updateSplitFarePartner.errmsg;
                            bottomPopModel.content = sb.toString();
                            bottomPopModel.positive = GlobalContactsActivity.this.getString(R.string.car_me_known);
                            final GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(GlobalContactsActivity.this, bottomPopModel);
                            globalCommonBottomPop.setCanceledOnTouchOutside(true);
                            globalCommonBottomPop.show();
                            globalCommonBottomPop.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
                                public void onNegativeClick() {
                                }

                                public void onPositiveClick() {
                                    globalCommonBottomPop.dismiss();
                                    GlobalContactsActivity.this.m15031a((List<UpdateSplitFarePartner.SplitFareFailGroup>) list);
                                }
                            });
                            return;
                        }
                        Intent intent = new Intent(GlobalContactsActivity.this, AreaCodeMandatoryGuideActivity.class);
                        intent.putExtra(AreaCodeMandatoryGuideActivity.G_CONSTANT_MANAGER_KEY, list.get(0));
                        GlobalContactsActivity.this.startActivityForResult(intent, 1);
                        return;
                    }
                    ToastHelper.showShortInfo((Context) GlobalContactsActivity.this, updateSplitFarePartner.errmsg);
                }

                public void onError(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onError(updateSplitFarePartner);
                    ToastHelper.showShortInfo((Context) GlobalContactsActivity.this, updateSplitFarePartner.errmsg);
                }

                public void onFinish(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onFinish(updateSplitFarePartner);
                    GlobalContactsActivity.this.hideLoading();
                }
            });
            showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15031a(List<UpdateSplitFarePartner.SplitFareFailGroup> list) {
        for (UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup : list) {
            for (UpdateSplitFarePartner.SplitFareFailUser next : splitFareFailGroup.failUsers) {
                Iterator<GlobalContactsModel> it = this.f17784n.iterator();
                while (it.hasNext()) {
                    GlobalContactsModel next2 = it.next();
                    if (next2.phone.contains(next.originPhone)) {
                        this.f17784n.remove(next2);
                        next2.checked = false;
                        this.f17783m.updateSosContacts(next2);
                        onSelectDateChanged(this.f17784n.size());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private Map<String, Object> m15034b() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().getOid());
        hashMap.put("users", new Gson().toJson((Object) this.f17784n));
        return hashMap;
    }

    public void onBackPressed() {
        m15038c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15038c() {
        if (this.f17778h.getText() != null && TextUtils.isEmpty(this.f17778h.getText().toString())) {
            this.f17789t = false;
        }
        if (this.f17789t) {
            this.f17778h.setText((CharSequence) null);
            this.f17778h.clearFocus();
            Utils.hideInputMethod(this, this.f17778h);
            this.f17783m.showDatas();
            this.f17789t = false;
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        C77182 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.share_bottom_btn) {
                    GlobalContactsActivity.this.m15028a();
                } else if (view.getId() == R.id.request_per_btn) {
                    if (GlobalContactsActivity.this.f17779i) {
                        GlobalContactsActivity.this.gotoSystemPermissionPage();
                    } else {
                        GlobalContactsActivity.this.m15045f();
                    }
                } else if (view.getId() == R.id.search_et) {
                    SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SERCH_ET_CK);
                } else if (view.getId() == R.id.g_split_fare_guide_close) {
                    GlobalContactsActivity.this.m15040d();
                }
            }
        };
        this.f17787q.setOnClickListener(r0);
        this.f17775e.setOnClickListener(r0);
        this.f17780j.setLeftBtnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GlobalContactsActivity.this.m15038c();
            }
        });
        this.f17778h.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                boolean unused = GlobalContactsActivity.this.f17789t = true;
                final String obj = editable.toString();
                if (TextUtils.isEmpty(obj)) {
                    GlobalContactsActivity.this.f17783m.showDatas();
                } else {
                    GlobalContactsActivity.this.f17782l.getMatchList(obj, new GlobalContactsCallback() {
                        public void onFailed(String str) {
                        }

                        public void onSucceed(List<GlobalContactsModel> list) {
                            if (list.size() == 0) {
                                GlobalContactsModel unused = GlobalContactsActivity.this.f17790u = GlobalContactsActivity.this.m15027a(obj, list);
                            } else {
                                boolean z = false;
                                Iterator<GlobalContactsModel> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().phone.equals(obj)) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (!z) {
                                    GlobalContactsModel unused2 = GlobalContactsActivity.this.f17790u = GlobalContactsActivity.this.m15027a(obj, list);
                                }
                            }
                            GlobalContactsActivity.this.m15036b(list);
                            GlobalContactsActivity.this.f17783m.updateSearchData(list);
                        }
                    });
                }
            }
        });
        this.f17778h.setOnClickListener(r0);
        this.f17794y.setOnClickListener(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m15040d() {
        GlobalOmegaUtils.trackEvent("gp_split_search_tipcancel_ck");
        this.f17792w = false;
        this.f17791v.setVisibility(8);
        if (this.f17793x) {
            this.f17771A.setVisibility(8);
        } else {
            this.f17786p.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public GlobalContactsModel m15027a(String str, List<GlobalContactsModel> list) {
        if (!m15033a(str) && ((str.charAt(0) != '+' && str.charAt(0) != '+') || !m15033a(str.substring(1)))) {
            return null;
        }
        GlobalContactsModel globalContactsModel = new GlobalContactsModel();
        globalContactsModel.phone = str;
        list.add(globalContactsModel);
        return globalContactsModel;
    }

    /* renamed from: a */
    private boolean m15033a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void gotoSystemPermissionPage() {
        this.f17788r.launchPermissionSettingPageOnThePhone(this);
        this.f17785o = true;
    }

    /* renamed from: e */
    private void m15042e() {
        if (CarOrderHelper.getOrder() != null) {
            this.f17795z.setText(CarOrderHelper.getOrder().splitFareInfo.split_msg_content);
        }
        this.f17782l = GlobalContactsStore.getInstance();
        GlobalContactsAdapter globalContactsAdapter = new GlobalContactsAdapter(m15046g());
        this.f17783m = globalContactsAdapter;
        this.f17777g.setAdapter(globalContactsAdapter);
        this.f17781k = new GlobalContactsCallback() {
            public void onSucceed(List<GlobalContactsModel> list) {
                GlobalContactsActivity.this.hideLoading();
                if (!CollectionUtils.isEmpty((Collection) list)) {
                    GlobalContactsActivity.this.m15036b(list);
                    GlobalContactsActivity.this.f17783m.addData(list);
                }
            }

            public void onFailed(String str) {
                GlobalContactsActivity.this.hideLoading();
                GLog.m11357e(GlobalContactsActivity.f17768a, "get data list onFailed! msg  = " + str);
            }
        };
        this.f17784n = new CopyOnWriteArrayList<>();
        this.f17783m.setListener(new GlobalContactsAdapter.GlobalCheckedChangedListener() {
            public void onCheckedChanged(GlobalContactsModel globalContactsModel, boolean z) {
                GlobalContactsActivity.this.f17778h.clearFocus();
                GlobalContactsActivity globalContactsActivity = GlobalContactsActivity.this;
                Utils.hideInputMethod(globalContactsActivity, globalContactsActivity.f17778h);
                if (!z) {
                    Iterator it = GlobalContactsActivity.this.f17784n.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            GlobalContactsModel globalContactsModel2 = (GlobalContactsModel) it.next();
                            if (globalContactsModel2 != null && globalContactsModel2.phone != null && globalContactsModel2.phone.equals(globalContactsModel.phone)) {
                                GlobalContactsActivity.this.f17784n.remove(globalContactsModel);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    GlobalContactsActivity.this.f17783m.deleteSplitFareData(globalContactsModel);
                } else if (globalContactsModel.type == 2) {
                    GlobalContactsActivity.this.f17784n.add(globalContactsModel);
                    GlobalContactsActivity.this.f17783m.updateSosContacts(globalContactsModel);
                } else {
                    GlobalContactsActivity.this.f17784n.add(globalContactsModel);
                    GlobalContactsActivity.this.f17783m.addSplitFareData(globalContactsModel);
                }
                GlobalContactsActivity globalContactsActivity2 = GlobalContactsActivity.this;
                globalContactsActivity2.onSelectDateChanged(globalContactsActivity2.f17784n.size());
            }

            public void onSearchContactsClick(boolean z) {
                GlobalContactsActivity.this.f17778h.setText((CharSequence) null);
                GlobalContactsActivity.this.f17778h.clearFocus();
                GlobalContactsActivity globalContactsActivity = GlobalContactsActivity.this;
                Utils.hideInputMethod(globalContactsActivity, globalContactsActivity.f17778h);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15036b(List<GlobalContactsModel> list) {
        DTSDKSplitFareInfo.SplitUser next;
        List<DTSDKSplitFareInfo.SplitUser> h = m15049h();
        if (!CollectionUtils.isEmpty((Collection) h)) {
            for (GlobalContactsModel next2 : list) {
                Iterator<DTSDKSplitFareInfo.SplitUser> it = h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(next2.phone)) {
                        if (next2.phone.contains(next.phone) || next.phone.contains(next2.phone) || (next2.phone.contains("+") && next2.phone.length() >= 3 && next.phone.contains(next2.phone.substring(3)))) {
                            next2.canSelected = false;
                            GlobalContactsModel globalContactsModel = this.f17790u;
                        }
                    }
                }
                next2.canSelected = false;
                GlobalContactsModel globalContactsModel2 = this.f17790u;
                if (globalContactsModel2 != null && globalContactsModel2 == next2 && !globalContactsModel2.phone.equals(next.phone)) {
                    next2.canSelected = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m15045f() {
        this.f17788r.requestPermission(new PermissionCallback() {
            public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
                iPermissionRequest.proceed();
            }

            public void onGranted(List<AuthorizationInfo> list) {
                GlobalContactsActivity.this.showContractList();
            }

            public void onRefuse(List<AuthorizationInfo> list) {
                AuthorizationInfo authorizationInfo;
                if (list != null && list.size() != 0 && (authorizationInfo = list.get(0)) != null) {
                    GlobalContactsActivity.this.showNoPermissionPage(authorizationInfo.isDoNotAskAgain());
                }
            }
        }, Permission.READ_CONTACTS);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f17788r.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* renamed from: g */
    private int m15046g() {
        int i = 0;
        if (getIntent().getIntExtra("threshold", 0) != 0) {
            return getIntent().getIntExtra("threshold", 0);
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return 0;
        }
        if (!(order.splitFareInfo == null || order.splitFareInfo.split_user_list == null)) {
            i = order.splitFareInfo.split_user_list.size();
        }
        if (i != 0) {
            return order.passengerCount > 0 ? order.passengerCount - i : 4 - i;
        }
        if (order.passengerCount > 0) {
            return order.passengerCount - 1;
        }
        return 3;
    }

    /* renamed from: h */
    private List<DTSDKSplitFareInfo.SplitUser> m15049h() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.splitFareInfo == null) {
            return null;
        }
        return CarOrderHelper.getOrder().splitFareInfo.split_user_list;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f17785o) {
            m15045f();
            this.f17785o = false;
        }
    }

    /* access modifiers changed from: protected */
    public void showNoPermissionPage(boolean z) {
        GLog.m11354d("hkc_test", "isRemember  " + z);
        this.f17779i = z;
        this.f17773c.setVisibility(0);
        this.f17774d.setVisibility(8);
        if (this.f17779i) {
            this.f17776f.setText(getString(R.string.g_splitfare_contacts_permissions));
            this.f17775e.setText(getString(R.string.g_splitfare_contacts_setting));
            return;
        }
        this.f17776f.setText(getString(R.string.g_splitfare_contacts_cannot_access_cont));
        this.f17775e.setText(getString(R.string.g_splitfare_contacts_use_phone_contacts));
    }

    /* access modifiers changed from: protected */
    public void showContractList() {
        this.f17773c.setVisibility(8);
        this.f17774d.setVisibility(0);
        showLoading();
        getDataList();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f17782l.clearData();
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.f17782l.getSystemContacts(this.f17781k);
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            this.f17786p.setVisibility(0);
            if (this.f17792w) {
                this.f17771A.setVisibility(0);
            }
            GlobalOmegaUtils.trackEvent("gp_split_search_request_sw");
            this.f17787q.setVisibility(0);
            this.f17787q.setText(String.format(getString(R.string.g_splitfare_contacts_send_btn), new Object[]{Integer.valueOf(i)}));
            this.f17793x = true;
            return;
        }
        if (!this.f17792w) {
            this.f17786p.setVisibility(8);
        }
        this.f17771A.setVisibility(8);
        this.f17787q.setVisibility(8);
    }

    public View getFallbackView() {
        return this.f17780j.getLoadingFallback();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList;
        String str;
        String str2;
        char c;
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 1 && (arrayList = (ArrayList) intent.getSerializableExtra("added_area_code_contacts")) != null && arrayList.size() != 0) {
            Iterator<GlobalContactsModel> it = this.f17784n.iterator();
            while (it.hasNext()) {
                GlobalContactsModel next = it.next();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    str = "";
                    if (!it2.hasNext()) {
                        str2 = str;
                        c = 0;
                        break;
                    }
                    UpdateSplitFarePartner.AreaCodeUserInfo areaCodeUserInfo = (UpdateSplitFarePartner.AreaCodeUserInfo) it2.next();
                    if (!TextUtils.isEmpty(areaCodeUserInfo.phone) && !TextUtils.isEmpty(next.phone) && next.phone.contains(areaCodeUserInfo.originPhone)) {
                        int length = areaCodeUserInfo.phone.length();
                        if (areaCodeUserInfo.phone.contains("+") && length >= areaCodeUserInfo.countryCode.length()) {
                            String substring = areaCodeUserInfo.phone.substring(areaCodeUserInfo.countryCode.length());
                            if (substring.equals(next.phone)) {
                                areaCodeUserInfo.phone = substring;
                            }
                        }
                        if (areaCodeUserInfo.phone.length() > next.phone.length()) {
                            str = areaCodeUserInfo.phone;
                            str2 = areaCodeUserInfo.originPhone;
                            c = 1;
                        } else {
                            str = areaCodeUserInfo.phone;
                            str2 = areaCodeUserInfo.originPhone;
                            c = 2;
                        }
                    }
                }
                if (c == 1) {
                    next.checked = true;
                    next.phone = str;
                    next.originPhone = str2;
                    this.f17783m.updateSosContacts(next);
                } else if (c == 2) {
                    this.f17784n.remove(next);
                    next.checked = false;
                    next.originPhone = str2;
                    onSelectDateChanged(this.f17784n.size());
                    this.f17783m.updateSosContacts(next);
                }
            }
        }
    }
}
