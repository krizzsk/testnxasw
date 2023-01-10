package com.didi.sdk.sidebar.history;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.sdk.sidebar.history.adapter.InoiceCountListener;
import com.didi.sdk.sidebar.history.manager.HistoryRequestCallBack;
import com.didi.sdk.sidebar.history.manager.IBikeHistoryManager;
import com.didi.sdk.sidebar.history.manager.IFoodHistoryManager;
import com.didi.sdk.sidebar.history.manager.IHistoryManager;
import com.didi.sdk.sidebar.history.manager.IRideHistoryManager;
import com.didi.sdk.sidebar.history.manager.JPInvoiceManager;
import com.didi.sdk.sidebar.history.manager.impl.RideHistoryManagerImpl;
import com.didi.sdk.sidebar.history.manager.soda.FoodHistoryManagerImpl;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.model.BikeHistoryOrder;
import com.didi.sdk.sidebar.history.model.FoodHistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrderCountryModel;
import com.didi.sdk.sidebar.history.model.HistoryOrdersResponse;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.sidebar.history.util.HistoryOmegaUtils;
import com.didi.sdk.sidebar.history.util.HistoryUtils;
import com.didi.sdk.sidebar.history.view.CountrySelectDialogFragment;
import com.didi.sdk.sidebar.history.view.HistoryListViewPager;
import com.didi.sdk.sidebar.sdk.api.model.CommonDispatchMessage;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainConstants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.ride.widget.GlobalTitleBar2;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.android.material.tabs.TabLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class HistoryRecordFragment extends AbsLoadingFragment implements IComponent<BusinessContext>, IStatusBar {
    public static final String COUNTRY_CODE_AR = "AR";
    public static final String COUNTRY_CODE_AU = "AU";
    public static final String COUNTRY_CODE_BR = "BR";
    public static final String COUNTRY_CODE_CL = "CL";
    public static final String COUNTRY_CODE_CO = "CO";
    public static final String COUNTRY_CODE_CR = "CR";
    public static final String COUNTRY_CODE_DO = "DO";
    public static final String COUNTRY_CODE_JP = "JP";
    public static final String COUNTRY_CODE_MX = "MX";
    public static final String COUNTRY_CODE_NZ = "NZ";
    public static final String COUNTRY_CODE_PA = "PA";
    public static final String COUNTRY_CODE_PE = "PE";
    public static final String COUNTRY_CODE_PR = "PR";
    public static final String COUNTRY_CODE_ZA = "ZA";
    public static final String TAG = "HistoryRecordFragment";

    /* renamed from: d */
    private static final String f40016d = "MX";

    /* renamed from: A */
    private boolean f40017A = true;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f40018B = 0;

    /* renamed from: C */
    private View f40019C;

    /* renamed from: D */
    private boolean f40020D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public CountrySelectDialogFragment f40021E;

    /* renamed from: F */
    private Object f40022F;

    /* renamed from: G */
    private String f40023G;

    /* renamed from: H */
    private InoiceCountListener f40024H = new InoiceCountListener() {
        public void onSelectCountChange() {
            if (HistoryRecordFragment.this.m30221v() != null && HistoryRecordFragment.this.m30221v().getFinishedOrderList() != null) {
                int i = 0;
                for (AbsHistoryOrder next : HistoryRecordFragment.this.m30221v().getFinishedOrderList()) {
                    if ((next instanceof HistoryOrder) && ((HistoryOrder) next).isInvoiceSelected()) {
                        i++;
                    }
                }
                if (i > 0) {
                    HistoryRecordFragment.this.m30196f();
                    HistoryRecordFragment.this.m30162a(i);
                    return;
                }
                HistoryRecordFragment.this.m30200g();
            }
        }
    };

    /* renamed from: a */
    private Logger f40025a = LoggerFactory.getLogger(TAG);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f40026b;

    /* renamed from: c */
    private BusinessContext f40027c;

    /* renamed from: e */
    private ViewStub f40028e;

    /* renamed from: f */
    private View f40029f;

    /* renamed from: g */
    private View f40030g;

    /* renamed from: h */
    private TextView f40031h;

    /* renamed from: i */
    private JPInvoiceManager f40032i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f40033j = false;

    /* renamed from: k */
    private boolean f40034k;

    /* renamed from: l */
    private TextView f40035l;

    /* renamed from: m */
    private TextView f40036m;

    /* renamed from: n */
    private View f40037n;

    /* renamed from: o */
    private View f40038o;

    /* renamed from: p */
    private InvoiceFragmentDialog f40039p;

    /* renamed from: q */
    private int f40040q;

    /* renamed from: r */
    private List<InvoiceOrder> f40041r = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public List<HistoryListFragmentModel> f40042s = new ArrayList();

    /* renamed from: t */
    private IFoodHistoryManager f40043t;
    protected GlobalTitleBar2 titleBar;
    protected Button tryAginBtn;

    /* renamed from: u */
    private IRideHistoryManager f40044u;

    /* renamed from: v */
    private IBikeHistoryManager f40045v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public HistoryListViewPager f40046w;

    /* renamed from: x */
    private HistoryListViewPagerAdapter f40047x;

    /* renamed from: y */
    private LinearLayout f40048y;

    /* renamed from: z */
    private TabLayout f40049z;

    /* access modifiers changed from: protected */
    public boolean isAllBusinessNetworkFinish() {
        return true;
    }

    public boolean showStatusBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40026b = getActivity();
        this.f40022F = OmegaSDK.getGlobalAttr("g_PageId");
        OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_MY_TRIP);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f40019C == null) {
            this.f40019C = layoutInflater.inflate(R.layout.f_history_record, viewGroup, false);
            m30161a();
            m30209l();
            this.f40046w = (HistoryListViewPager) this.f40019C.findViewById(R.id.list_fragment_view_page);
            this.f40048y = (LinearLayout) this.f40019C.findViewById(R.id.list_fragment_tab_layout);
            this.f40049z = (TabLayout) this.f40019C.findViewById(R.id.list_fragment_tab);
            this.f40021E = new CountrySelectDialogFragment();
            initTitlebar();
            this.f40028e = (ViewStub) this.f40019C.findViewById(R.id.refresh_stub);
            m30164a(this.f40019C);
            m30208k();
        }
        HistoryRecordStore.getInstance().registerReceiver(this);
        return this.f40019C;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30162a(int i) {
        String str;
        this.f40040q = i;
        if (MultiLocaleStore.getInstance().isJapanese()) {
            str = "<font color=\"#FF7F41\">" + i + "</font>" + getString(R.string.history_fragment_voice_tip_prefix);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.history_fragment_voice_tip_prefix));
            sb.append("<font color=\"#FF7F41\">");
            sb.append(i);
            sb.append("</font>");
            sb.append(getString(i <= 1 ? R.string.history_fragment_voice_tip_suffix_one : R.string.history_fragment_voice_tip_suffix));
            str = sb.toString();
        }
        this.f40036m.setText(Html.fromHtml(str));
    }

    public void onPause() {
        super.onPause();
        m30217r();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f40019C = null;
        OmegaSDK.putGlobalAttr("g_PageId", this.f40022F);
    }

    public void onStart() {
        super.onStart();
        JPInvoiceManager jPInvoiceManager = this.f40032i;
        if (jPInvoiceManager != null) {
            jPInvoiceManager.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        JPInvoiceManager jPInvoiceManager = this.f40032i;
        if (jPInvoiceManager != null) {
            jPInvoiceManager.onStop();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        InvoiceFragmentDialog invoiceFragmentDialog = this.f40039p;
        if (invoiceFragmentDialog != null) {
            invoiceFragmentDialog.dismiss();
        }
        IRideHistoryManager iRideHistoryManager = this.f40044u;
        if (iRideHistoryManager != null) {
            iRideHistoryManager.exitHistory();
        }
        IFoodHistoryManager iFoodHistoryManager = this.f40043t;
        if (iFoodHistoryManager != null) {
            iFoodHistoryManager.exitHistory();
        }
        IBikeHistoryManager iBikeHistoryManager = this.f40045v;
        if (iBikeHistoryManager != null) {
            iBikeHistoryManager.exitHistory();
        }
        View view = this.f40019C;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) this.f40019C.getParent()).removeView(this.f40019C);
        }
        HistoryRecordStore.getInstance().removeReceiver(this);
    }

    /* renamed from: a */
    private void m30161a() {
        this.f40018B = 0;
        this.f40033j = false;
        this.f40047x = null;
        this.f40042s.clear();
    }

    /* renamed from: a */
    private void m30164a(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                HistoryRecordFragment.this.m30203i();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initTitlebar() {
        GlobalTitleBar2 globalTitleBar2 = (GlobalTitleBar2) this.f40019C.findViewById(R.id.history_record_title_bar);
        this.titleBar = globalTitleBar2;
        globalTitleBar2.setTitle(m30222w());
        m30215p();
        this.titleBar.setLeftImage(ContextCompat.getDrawable(this.f40026b, R.drawable.webview_common_title_bar_btn_close_selector), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean unused = HistoryRecordFragment.this.f40033j = true;
                HistoryRecordFragment.this.m30203i();
            }
        });
        m30218s();
        this.titleBar.setRightClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("pas_mytrip_invoice_ck");
                List<AbsHistoryOrder> finishedOrderList = HistoryRecordFragment.this.m30221v().getFinishedOrderList();
                if (!CollectionUtils.isEmpty((Collection<?>) finishedOrderList)) {
                    List a = HistoryRecordFragment.this.m30179b(finishedOrderList);
                    if (!CollectionUtils.isNotEmpty((Collection<?>) a)) {
                        return;
                    }
                    if (a.size() > 1) {
                        HistoryRecordFragment.this.m30172a((List<HistoryOrderCountryModel>) a);
                        return;
                    }
                    HistoryOrderCountryModel historyOrderCountryModel = (HistoryOrderCountryModel) a.get(0);
                    HistoryRecordFragment.this.m30170a(new PopupSelectModel(historyOrderCountryModel.getCountryCode(), historyOrderCountryModel.getCountryName(), historyOrderCountryModel.getInvoiceUrl(), historyOrderCountryModel.getInvoiceType()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30170a(PopupSelectModel popupSelectModel) {
        this.f40023G = popupSelectModel.f40884id;
        if (!popupSelectModel.isNeedGoToH5()) {
            m30184b(popupSelectModel.f40884id);
        } else if (TextUtils.isEmpty(popupSelectModel.invoiceUrl)) {
            OmegaSDK.trackError("enterInvoiceMode", new Throwable("invoiceUrl 为空"));
            m30184b(popupSelectModel.f40884id);
        } else {
            m30188c(popupSelectModel.invoiceUrl);
        }
    }

    /* renamed from: a */
    private void m30173a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("content", "single");
        } else {
            hashMap.put("content", "mutiple");
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m30180b() {
        List<HistoryListFragmentModel> list = this.f40042s;
        if (list == null || list.size() < 2) {
            m30173a(false);
            return;
        }
        m30173a(true);
        int i = 0;
        while (i < this.f40042s.size()) {
            TabLayout.Tab text = this.f40049z.newTab().setCustomView((int) R.layout.history_tab_item_layout).setText((CharSequence) m30159a(this.f40042s.get(i).type));
            this.f40049z.addTab(text);
            m30174a(i == 0, text);
            i++;
        }
        this.f40046w.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.f40049z));
        this.f40049z.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                HistoryOmegaUtils.sendTabClick(HistoryRecordFragment.this.f40018B, tab.getPosition(), HistoryRecordFragment.this.f40042s);
                int unused = HistoryRecordFragment.this.f40018B = tab.getPosition();
                HistoryRecordFragment.this.m30174a(true, tab);
                HistoryRecordFragment.this.f40046w.setCurrentItem(tab.getPosition());
                HistoryRecordFragment.this.m30218s();
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                HistoryRecordFragment.this.m30174a(false, tab);
            }
        });
    }

    /* renamed from: a */
    private String m30159a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("ride".equals(str)) {
                return getString(R.string.history_tab_title_ride);
            }
            if (BusinessConstants.TYPE_BIKE.equals(str)) {
                return getString(R.string.history_tab_title_bike);
            }
            if ("soda".equals(str)) {
                return getString(R.string.history_tab_title_food);
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30174a(boolean z, TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView textView = (TextView) customView.findViewById(R.id.tab_title);
        textView.setText(tab.getText());
        View findViewById = customView.findViewById(R.id.tab_line);
        findViewById.setBackgroundColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.caution_color));
        if (z) {
            textView.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.caution_color));
            findViewById.setVisibility(0);
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.history_tab_item_nor));
        findViewById.setVisibility(8);
    }

    /* renamed from: b */
    private void m30184b(String str) {
        if (!this.f40034k) {
            HistoryListFragment v = m30221v();
            if (v != null) {
                OmegaSDKAdapter.trackEvent("pas_mytrip_invoice_ck");
                this.f40034k = true;
                m30185b(false);
                this.titleBar.setRightText(getResources().getString(R.string.cancel));
                v.openInvoiceMode(str);
                m30194e();
                m30162a(0);
                m30190d();
                if (this.f40048y.getVisibility() == 0) {
                    this.f40020D = true;
                } else {
                    this.f40020D = false;
                }
                this.f40048y.setVisibility(8);
                this.f40046w.setScrollable(false);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_cancel_ck");
        m30186c();
    }

    /* renamed from: c */
    private void m30188c(String str) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.isSupportCache = true;
        webViewModel.url = str;
        webViewModel.title = getString(R.string.history_record_web_title);
        Intent intent = new Intent(this.f40026b, BaseWebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        this.f40026b.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30186c() {
        this.f40034k = false;
        this.titleBar.setRightText(getResources().getString(R.string.history_record_title_bill));
        if (this.f40020D) {
            this.f40020D = false;
            this.f40048y.setVisibility(0);
            this.f40046w.setScrollable(true);
        }
        HistoryListFragment v = m30221v();
        if (v != null) {
            v.closeInvoiceMode();
        }
        m30200g();
        m30190d();
    }

    /* renamed from: d */
    private void m30190d() {
        if (m30221v() != null) {
            m30221v().updatePinnedHeader();
        }
    }

    /* renamed from: b */
    private void m30185b(boolean z) {
        if (m30221v() != null && m30221v().getFinishedOrderList() != null) {
            for (AbsHistoryOrder next : m30221v().getFinishedOrderList()) {
                if (next instanceof HistoryOrder) {
                    ((HistoryOrder) next).setInvoiceSelected(z);
                }
            }
        }
    }

    /* renamed from: e */
    private void m30194e() {
        this.f40037n = this.f40019C.findViewById(R.id.voice_tip);
        this.f40038o = this.f40019C.findViewById(R.id.navi_bar_shadow);
        this.f40035l = (TextView) this.f40037n.findViewById(R.id.send);
        this.f40036m = (TextView) this.f40037n.findViewById(R.id.tip);
        m30200g();
        this.f40035l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("pas_mytrip_email_ck");
                HistoryRecordFragment.this.m30201h();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m30196f() {
        this.f40037n.setVisibility(0);
        this.f40038o.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m30200g() {
        this.f40037n.setVisibility(8);
        this.f40038o.setVisibility(8);
        if (m30221v() != null) {
            m30221v().setMarginBottom(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30172a(List<HistoryOrderCountryModel> list) {
        this.f40021E.setTitle(getContext().getString(R.string.history_country_select_view_title));
        this.f40021E.setContent(getContext().getString(R.string.history_country_select_view_content));
        final ArrayList arrayList = new ArrayList();
        for (HistoryOrderCountryModel next : list) {
            arrayList.add(new PopupSelectModel(next.getCountryCode(), next.getCountryName(), next.getInvoiceUrl(), next.getInvoiceType()));
        }
        this.f40021E.setItems(arrayList);
        this.f40021E.setOnPopupSelectListClickListener(new PopupSelectView.OnPopupSelectListClickListener() {
            public void onItemClick(int i) {
                HistoryRecordFragment.this.m30170a((PopupSelectModel) arrayList.get(i));
                HistoryRecordFragment.this.f40021E.dismissAllowingStateLoss();
            }

            public void onCloseButtonClick() {
                HistoryRecordFragment.this.f40021E.dismissAllowingStateLoss();
            }
        });
        if (this.f40021E != null && getFragmentManager() != null) {
            this.f40021E.show(getFragmentManager(), "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<HistoryOrderCountryModel> m30179b(List<AbsHistoryOrder> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (AbsHistoryOrder next : list) {
                String countryCode = next.getExtraData().getCountryCode();
                if (!TextUtils.isEmpty(countryCode)) {
                    HistoryOrderCountryModel historyOrderCountryModel = new HistoryOrderCountryModel();
                    historyOrderCountryModel.setCountryCode(countryCode);
                    historyOrderCountryModel.setInvoiceUrl(next.getExtraData().getInvoiceUrl());
                    historyOrderCountryModel.setInvoiceType(next.getExtraData().getInvoiceType());
                    String countryName = next.getExtraData().getCountryName();
                    if (TextUtils.isEmpty(countryName)) {
                        historyOrderCountryModel.setCountryName(m30158a(getContext(), countryCode));
                    } else {
                        historyOrderCountryModel.setCountryName(countryName);
                    }
                    if (!arrayList.contains(historyOrderCountryModel) && !(next.getProductId() == 378 && next.getExtraData().getIsOfflinePay() == 1)) {
                        arrayList.add(historyOrderCountryModel);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m30158a(Context context, String str) {
        if (context != null) {
            if ("AU".equals(str)) {
                return context.getResources().getString(R.string.country_name_au);
            }
            if ("BR".equals(str)) {
                return context.getResources().getString(R.string.country_name_br);
            }
            if (COUNTRY_CODE_CL.equals(str)) {
                return context.getResources().getString(R.string.country_name_cl);
            }
            if (COUNTRY_CODE_CO.equals(str)) {
                return context.getResources().getString(R.string.country_name_co);
            }
            if (COUNTRY_CODE_CR.equals(str)) {
                return context.getResources().getString(R.string.country_name_cr);
            }
            if ("JP".equals(str)) {
                return context.getResources().getString(R.string.country_name_jp);
            }
            if ("MX".equals(str)) {
                return context.getResources().getString(R.string.country_name_mx);
            }
            if (COUNTRY_CODE_PA.equals(str)) {
                return context.getResources().getString(R.string.country_name_pa);
            }
            if (COUNTRY_CODE_PE.equals(str)) {
                return context.getResources().getString(R.string.country_name_pe);
            }
            if (COUNTRY_CODE_AR.equals(str)) {
                return context.getResources().getString(R.string.country_name_ar);
            }
            if (COUNTRY_CODE_DO.equals(str)) {
                return context.getResources().getString(R.string.country_name_do);
            }
            if (COUNTRY_CODE_PR.equals(str)) {
                return context.getResources().getString(R.string.country_name_pr);
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m30201h() {
        this.f40041r.clear();
        for (AbsHistoryOrder next : m30221v().getFinishedOrderList()) {
            if (next instanceof HistoryOrder) {
                HistoryOrder historyOrder = (HistoryOrder) next;
                if (historyOrder.isInvoiceSelected()) {
                    InvoiceOrder invoiceOrder = new InvoiceOrder();
                    invoiceOrder.order = historyOrder.getOrder();
                    invoiceOrder.productid = historyOrder.getProductId();
                    invoiceOrder.countryCode = historyOrder.getExtraData().getCountryCode();
                    this.f40041r.add(invoiceOrder);
                }
            }
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("orderid", Integer.valueOf(this.f40041r.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_invoiceconfirm_ck", (Map<String, Object>) hashMap);
        if (this.f40041r.isEmpty()) {
            ToastHelper.showShortInfo(getContext(), getString(R.string.history_no_order));
            return;
        }
        if (this.f40032i == null) {
            this.f40032i = new JPInvoiceManager(this.f40026b, new JPInvoiceManager.ICallback() {
                public void showLoading() {
                    HistoryRecordFragment.this.showMaskLayerLoading();
                }

                public void onSuccess() {
                    ToastHelper.showShortCompleted(HistoryRecordFragment.this.f40026b, HistoryRecordFragment.this.f40026b.getString(R.string.history_email_send_ok));
                    HistoryRecordFragment.this.m30186c();
                }

                public void onFail() {
                    ToastHelper.showShortInfo(HistoryRecordFragment.this.f40026b, HistoryRecordFragment.this.f40026b.getString(R.string.history_email_send_fail));
                }

                public void hideLoading() {
                    HistoryRecordFragment.this.hideLoading();
                }
            }, 0);
        }
        this.f40032i.sendJPInvoice(getFragmentManager(), this.f40041r);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m30203i() {
        m30206j();
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
    }

    /* renamed from: j */
    private void m30206j() {
        getBusinessContext().getNavigation().popBackStack();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m30208k() {
        m30216q();
        getHistoryRecordByPage();
    }

    /* renamed from: l */
    private void m30209l() {
        if (!DomainConstants.DOMAIN_SUFFIX_RU.equalsIgnoreCase(DomainServiceManager.getInstance().getDomainSuffix(getContext()))) {
            this.f40043t = FoodHistoryManagerImpl.getFoodHistoryManager();
        }
        this.f40044u = RideHistoryManagerImpl.getRideHistoryManager();
        RideHistoryManagerImpl.getRideHistoryManager().setInoiceCountListener(this.f40024H);
        if (this.f40044u != null) {
            HistoryListFragmentModel historyListFragmentModel = new HistoryListFragmentModel();
            historyListFragmentModel.type = "ride";
            historyListFragmentModel.historyListFragment = m30189d("ride");
            this.f40042s.add(historyListFragmentModel);
        }
        if (this.f40043t != null) {
            HistoryListFragmentModel historyListFragmentModel2 = new HistoryListFragmentModel();
            historyListFragmentModel2.type = "soda";
            historyListFragmentModel2.historyListFragment = m30189d("soda");
            this.f40042s.add(historyListFragmentModel2);
        }
        if (this.f40045v != null) {
            HistoryListFragmentModel historyListFragmentModel3 = new HistoryListFragmentModel();
            historyListFragmentModel3.type = BusinessConstants.TYPE_BIKE;
            historyListFragmentModel3.historyListFragment = m30189d(BusinessConstants.TYPE_BIKE);
            this.f40042s.add(historyListFragmentModel3);
        }
    }

    /* renamed from: d */
    private HistoryListFragment m30189d(String str) {
        HistoryListFragment historyListFragment = new HistoryListFragment();
        historyListFragment.setHistoryFragment(this);
        historyListFragment.setType(str);
        return historyListFragment;
    }

    /* access modifiers changed from: protected */
    public void getHistoryRecordByPage() {
        if (m30221v() != null) {
            m30221v().showFooterButton(true);
        }
        this.f40017A = true;
        for (HistoryListFragmentModel historyListFragmentModel : this.f40042s) {
            getHistoryRecordByPage(historyListFragmentModel.type);
        }
    }

    /* access modifiers changed from: protected */
    public void getHistoryRecordByPage(String str) {
        if (m30221v() != null) {
            m30221v().showFooterButton(false);
        }
        if ("ride".equals(str)) {
            m30211m();
        } else if ("soda".equals(str)) {
            m30213n();
        } else if (BusinessConstants.TYPE_BIKE.equals(str)) {
            m30214o();
        }
        HistoryListFragmentModel e = m30193e(str);
        if (e != null) {
            e.requesting = true;
        }
    }

    /* renamed from: m */
    private void m30211m() {
        Map<String, Object> map;
        if (isAllBusinessNetworkFinish()) {
            boolean z = true;
            HistoryListFragmentModel e = m30193e("ride");
            if (e == null || e.historyListFragment == null) {
                map = null;
            } else {
                Map<String, Object> map2 = e.historyListFragment.params;
                boolean z2 = e.historyListFragment.mIsMoreHistoryRecords;
                map = map2;
                z = z2;
            }
            if (z) {
                this.f40044u.getHistoryDate(getContext(), map, (HistoryRequestCallBack) null);
            }
        }
    }

    /* renamed from: n */
    private void m30213n() {
        String str;
        HistoryListFragmentModel e = m30193e("soda");
        int i = 0;
        if (e == null || e.historyListFragment == null) {
            str = "";
        } else {
            str = e.historyListFragment.mTimeMode;
            boolean z = true;
            if (e.historyListFragment.mSodaOrder != null && e.historyListFragment.mSodaOrder.getHavenext() == 0) {
                z = false;
            }
            if (!z) {
                e.historyListFragment.mSodaPage = 0;
            }
            i = e.historyListFragment.mSodaPage;
        }
        if (this.f40043t != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timeMode", str);
            hashMap.put("pageNum", Integer.valueOf(i));
            this.f40043t.getHistoryDate(getContext(), hashMap, new HistoryRequestCallBack<FoodHistoryOrder>() {
                public void onSuccess(HistoryOrdersResponse<FoodHistoryOrder> historyOrdersResponse) {
                    if (historyOrdersResponse.errno == 0) {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(historyOrdersResponse));
                    } else {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                    }
                }

                public void onFailure(int i) {
                    HistoryOrdersResponse historyOrdersResponse = new HistoryOrdersResponse();
                    historyOrdersResponse.errno = i;
                    HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                }
            });
        }
    }

    /* renamed from: o */
    private void m30214o() {
        boolean z;
        HistoryListFragmentModel e = m30193e(BusinessConstants.TYPE_BIKE);
        if (e == null || e.historyListFragment == null) {
            z = true;
        } else {
            int i = e.historyListFragment.mPage;
            z = e.historyListFragment.mIsMoreHistoryRecords;
        }
        IBikeHistoryManager iBikeHistoryManager = this.f40045v;
        if (iBikeHistoryManager != null && z) {
            iBikeHistoryManager.getHistoryDate(getContext(), (Map<String, Object>) null, new HistoryRequestCallBack<BikeHistoryOrder>() {
                public void onSuccess(HistoryOrdersResponse<BikeHistoryOrder> historyOrdersResponse) {
                    if (historyOrdersResponse.errno == 0) {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(historyOrdersResponse));
                    } else {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                    }
                }

                public void onFailure(int i) {
                    HistoryOrdersResponse historyOrdersResponse = new HistoryOrdersResponse();
                    historyOrdersResponse.errno = i;
                    HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                }
            });
        }
    }

    /* renamed from: p */
    private void m30215p() {
        this.titleBar.setRightText(getResources().getString(R.string.history_record_title_bill));
        this.titleBar.setRightTextColor(Color.parseColor("#FF8040"));
    }

    /* renamed from: q */
    private void m30216q() {
        showMaskLayerLoading();
    }

    /* renamed from: r */
    private void m30217r() {
        hideLoading();
    }

    /* access modifiers changed from: protected */
    public void setRefreshBtnStyle() {
        this.tryAginBtn.setTextColor(-42211);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m30218s() {
        IHistoryManager g;
        List<AbsHistoryOrder> finishedOrderList;
        boolean z;
        HistoryListFragment v = m30221v();
        int i = 8;
        if (v == null || (g = m30198g(v.getType())) == null || !g.isSupportInvoice() || (finishedOrderList = v.getFinishedOrderList()) == null || finishedOrderList.size() <= 0) {
            this.titleBar.getRightTextView().setVisibility(8);
            return;
        }
        Iterator<AbsHistoryOrder> it = finishedOrderList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (HistoryUtils.canInvoice(it.next())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        TextView rightTextView = this.titleBar.getRightTextView();
        if (z) {
            i = 0;
        }
        rightTextView.setVisibility(i);
    }

    /* renamed from: a */
    private void m30175a(boolean z, boolean z2, HistoryOrdersResponse historyOrdersResponse) {
        if (this.f40029f == null) {
            View inflate = this.f40028e.inflate();
            this.f40029f = inflate;
            this.f40030g = inflate.findViewById(R.id.go_call_car_tv);
            this.f40031h = (TextView) this.f40029f.findViewById(R.id.no_record_text);
            this.tryAginBtn = (Button) this.f40029f.findViewById(R.id.try_agin_btn);
            setRefreshBtnStyle();
        }
        this.f40029f.setVisibility(0);
        if (z2) {
            this.f40031h.setText(R.string.history_record_no_record);
            this.f40030g.setVisibility(0);
            this.f40029f.setOnClickListener((View.OnClickListener) null);
            this.tryAginBtn.setVisibility(8);
        } else {
            if (z) {
                this.f40031h.setText(R.string.history_record_faild);
            } else if (historyOrdersResponse != null) {
                this.f40031h.setText(historyOrdersResponse.errmsg);
            }
            this.f40030g.setVisibility(8);
            this.tryAginBtn.setVisibility(0);
            Button button = this.tryAginBtn;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        HistoryRecordFragment.this.m30208k();
                    }
                });
            }
        }
        if (m30221v() != null) {
            m30221v().showHistoryList(false);
        }
    }

    /* renamed from: a */
    private void m30169a(HistoryOrdersResponse historyOrdersResponse, String str) {
        HistoryListFragmentModel e = m30193e(str);
        if (e != null && e.historyListFragment != null) {
            e.historyListFragment.showHistoryRecords(historyOrdersResponse);
        }
    }

    /* renamed from: a */
    private void m30165a(HistoryListFragment historyListFragment) {
        if (historyListFragment != null) {
            historyListFragment.setAutoLoadOnBottom(false);
            historyListFragment.showFooterButton(true);
        }
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        if (defaultEvent != null) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(identifier);
                SystemUtils.log(6, "page-empty", "statusBarHeight = " + dimensionPixelSize, (Throwable) null, "com.didi.sdk.sidebar.history.HistoryRecordFragment", 1003);
            }
            Message EventToMsg = MsgAndEventUtil.EventToMsg(defaultEvent);
            String type = defaultEvent.getType();
            char c = 65535;
            switch (type.hashCode()) {
                case -2003198504:
                    if (type.equals(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS)) {
                        c = 1;
                        break;
                    }
                    break;
                case -142557728:
                    if (type.equals(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 759799346:
                    if (type.equals(HistoryRecordStore.ACTION_CLOSE_HISTORY_RECORDS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 805353488:
                    if (type.equals(HistoryRecordStore.ACTION_GET_HISTORY_RECORDS)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1769327041:
                    if (type.equals(HistoryRecordStore.ACTION_DELETE_HISTORY_RECORDS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2006598232:
                    if (type.equals(HistoryRecordStore.ACTION_SHOW_LOADING)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                m30171a("ride", EventToMsg);
            } else if (c == 1) {
                m30171a("soda", EventToMsg);
            } else if (c == 2) {
                m30171a(BusinessConstants.TYPE_BIKE, EventToMsg);
            } else if (c != 3) {
                if (c == 4) {
                    m30206j();
                } else if (c == 5) {
                    showLoading();
                }
            } else if (!this.f40033j) {
                m30163a(EventToMsg);
            } else {
                return;
            }
            if (this.f40034k) {
                this.titleBar.setRightText(getResources().getString(R.string.cancel));
            }
            m30218s();
        }
    }

    /* renamed from: t */
    private void m30219t() {
        int i;
        String string = getArguments().getString("groupType", "");
        if (!TextUtils.isEmpty(string)) {
            List<HistoryListFragmentModel> list = this.f40042s;
            if (list != null && list.size() > 0) {
                i = 0;
                while (true) {
                    if (i >= this.f40042s.size()) {
                        break;
                    } else if (string.equals(this.f40042s.get(i).type)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            if (i != -1) {
                this.f40046w.setCurrentItem(i);
            }
        }
    }

    /* renamed from: a */
    private void m30171a(String str, Message message) {
        if (this.f40033j) {
            return;
        }
        if ((message.obj instanceof HistoryOrdersResponse) || message.obj == null) {
            HistoryOrdersResponse historyOrdersResponse = (HistoryOrdersResponse) message.obj;
            if (!m30177a(historyOrdersResponse) || !this.f40017A || "ride".equals(str)) {
                HistoryListFragmentModel e = m30193e(str);
                if (e != null) {
                    e.requesting = false;
                    e.response = (HistoryOrdersResponse) message.obj;
                    e.responseType = message.what;
                }
            } else {
                m30197f(str);
            }
            if (m30220u()) {
                if (this.f40017A) {
                    List<HistoryListFragmentModel> list = this.f40042s;
                    if (list == null || list.size() <= 1) {
                        this.f40048y.setVisibility(8);
                        this.f40046w.setScrollable(false);
                        this.titleBar.setTitleBarLineVisible(0);
                        m30173a(false);
                    } else {
                        this.f40048y.setVisibility(0);
                        this.f40046w.setScrollable(true);
                        m30180b();
                        this.titleBar.setTitleBarLineVisible(8);
                    }
                    HistoryListViewPagerAdapter historyListViewPagerAdapter = new HistoryListViewPagerAdapter(getChildFragmentManager(), this.f40042s);
                    this.f40047x = historyListViewPagerAdapter;
                    this.f40046w.setAdapter(historyListViewPagerAdapter);
                    m30219t();
                }
                for (HistoryListFragmentModel next : this.f40042s) {
                    if (next.responseType == 2) {
                        if (!this.f40017A) {
                            m30165a(next.historyListFragment);
                        }
                        HistoryOmegaUtils.sendTabError(historyOrdersResponse.errno, str);
                    } else if (next.responseType == 3) {
                        if (!this.f40017A) {
                            m30165a(next.historyListFragment);
                        }
                        if (next.historyListFragment == m30221v()) {
                            ToastHelper.showShortError((Context) getActivity(), (int) R.string.history_record_faild);
                        }
                    } else if (next.responseType == 1) {
                        m30169a(next.response, next.type);
                    }
                }
                m30215p();
                m30217r();
                this.f40017A = false;
                List<HistoryListFragmentModel> list2 = this.f40042s;
                if (list2 != null && list2.size() > 0) {
                    HistoryOmegaUtils.sendTabShow(this.f40042s);
                }
            }
        }
    }

    /* renamed from: u */
    private boolean m30220u() {
        for (HistoryListFragmentModel historyListFragmentModel : this.f40042s) {
            if (historyListFragmentModel.requesting) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m30177a(HistoryOrdersResponse historyOrdersResponse) {
        if (historyOrdersResponse == null) {
            return true;
        }
        List waitingOrderList = historyOrdersResponse.getWaitingOrderList();
        List doneOrderList = historyOrdersResponse.getDoneOrderList();
        boolean z = waitingOrderList == null || waitingOrderList.size() == 0;
        boolean z2 = doneOrderList == null || doneOrderList.size() == 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m30163a(Message message) {
        m30215p();
        m30217r();
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                m30181b(message);
                return;
            } else if (i == 3) {
                if (getActivity() != null) {
                    ToastHelper.showShortError((Context) getActivity(), (int) R.string.history_record_faild);
                    return;
                }
                return;
            }
        } else if (getActivity() != null) {
            ToastHelper.showShortCompleted((Context) getActivity(), (int) R.string.history_record_delete_success);
        }
        HistoryListFragment v = m30221v();
        if (v != null) {
            v.removeItem();
            if (v.getOrderCount() <= 0) {
                m30175a(false, true, (HistoryOrdersResponse) null);
            }
        }
    }

    /* renamed from: b */
    private void m30181b(Message message) {
        if (message != null) {
            String str = null;
            if (message.obj instanceof BaseObject) {
                str = ((BaseObject) message.obj).getErrorMsg();
            }
            if (str != null && getActivity() != null) {
                ToastHelper.showShortError((Context) getActivity(), str);
            }
        }
    }

    public BusinessContext getBusinessContext() {
        return this.f40027c;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f40027c = businessContext;
    }

    public void onResume() {
        super.onResume();
        SystemUtils.log(3, TAG, "onResume", (Throwable) null, "com.didi.sdk.sidebar.history.HistoryRecordFragment", 1225);
        List<HistoryListFragmentModel> list = this.f40042s;
        if (list != null && list.size() > 0) {
            HistoryOmegaUtils.sendTabShow(this.f40042s);
        }
    }

    public View getFallbackView() {
        return this.titleBar.getContentView();
    }

    public class HistoryListFragmentModel {
        public HistoryListFragment historyListFragment;
        public boolean requesting;
        public HistoryOrdersResponse response;
        public int responseType;
        public String type;

        public HistoryListFragmentModel() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public HistoryListFragment m30221v() {
        int i;
        List<HistoryListFragmentModel> list = this.f40042s;
        if (list == null || list.size() <= (i = this.f40018B)) {
            return null;
        }
        return this.f40042s.get(i).historyListFragment;
    }

    /* renamed from: e */
    private HistoryListFragmentModel m30193e(String str) {
        List<HistoryListFragmentModel> list;
        if (TextUtils.isEmpty(str) || (list = this.f40042s) == null) {
            return null;
        }
        for (HistoryListFragmentModel next : list) {
            if (str.equals(next.type)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: f */
    private boolean m30197f(String str) {
        List<HistoryListFragmentModel> list;
        if (TextUtils.isEmpty(str) || (list = this.f40042s) == null) {
            return false;
        }
        for (HistoryListFragmentModel next : list) {
            if (str.equals(next.type)) {
                this.f40042s.remove(next);
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private IHistoryManager m30198g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("ride".equals(str)) {
            return this.f40044u;
        }
        if ("soda".equals(str)) {
            return this.f40043t;
        }
        if (BusinessConstants.TYPE_BIKE.equals(str)) {
            return this.f40045v;
        }
        return null;
    }

    /* renamed from: w */
    private String m30222w() {
        return getString(R.string.history_record_title_bar);
    }
}
