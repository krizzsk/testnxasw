package com.didi.sdk.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.app.router.DRouterUrlInterceptor;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.core.IPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.RouterCallback;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BizManager;
import com.didi.sdk.app.TabEventManager;
import com.didi.sdk.app.prehot.PreHotStore;
import com.didi.sdk.common.TaskScheduler;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.home.bizbar.HomeBizNavBarFragment;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.home.view.HomeNewTitleBarFragment;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logtime.DiDiLaunchingLogTimer;
import com.didi.sdk.logtime.DiDiLogLaunchTimer;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.map.MapFragment;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.p147ad.AdUtil;
import com.didi.sdk.publicservice.PublicServiceUtil;
import com.didi.sdk.sidebar.SideBarInitialization;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleHelper;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ApplicationLifeUtils;
import com.didi.sdk.util.ExitUtil;
import com.didi.sdk.util.GSonUtil;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.util.GuideUtil;
import com.didi.sdk.util.LogTimer;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.NetWorkTitleBar;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.Preconditions;
import com.didiglobal.verify.HotPatchVerify;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class MainActivityImplV2 extends BaseMainActivity implements ActivityCompat.OnRequestPermissionsResultCallback, IBusinessContextChangedListener, INavigationListener, IStatusBarDelegate, OnBackResultListener, NetWorkTitleBar.OnViewVisibilityChangeListener {

    /* renamed from: b */
    private static final int f37942b = 1;

    /* renamed from: c */
    private static final int f37943c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f37944d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HomeNewTitleBarFragment f37945e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HomeBizNavBarFragment f37946f;

    /* renamed from: g */
    private HomeNavDrawerFragment f37947g;

    /* renamed from: h */
    private Fragment f37948h;

    /* renamed from: i */
    private BusinessContextHelper f37949i = null;

    /* renamed from: j */
    private MultiLocaleHelper f37950j;

    /* renamed from: k */
    private Set<MainActivityIntentFilter> f37951k = new HashSet();

    /* renamed from: l */
    private FrameLayout f37952l;

    /* renamed from: m */
    private boolean f37953m;

    /* renamed from: n */
    private BizManager f37954n;

    /* renamed from: o */
    private int f37955o = 0;

    /* renamed from: p */
    private int f37956p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f37957q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f37958r;

    /* renamed from: s */
    private HomeBizNavBarFragment.BizSelectListener f37959s = new HomeBizNavBarFragment.BizSelectListener() {
        public void onSelect(CarGrop carGrop, CarGrop carGrop2, boolean z, int i) {
            MainActivityImplV2.this.f37945e.restoreTitleBar();
            if (i == 2) {
                HomeBizNavBarFragment c = MainActivityImplV2.this.f37946f;
                MainActivityImplV2 mainActivityImplV2 = MainActivityImplV2.this;
                c.showExtendBar(mainActivityImplV2, mainActivityImplV2.f37944d);
                MainActivityImplV2.this.m28630q();
                return;
            }
            TabEventManager.INSTANCE.updateLastSelect(carGrop);
            ConfProxy.getInstance().setSelectGroup(carGrop2);
            TabEventManager.TabHandleModel tabHandleModel = new TabEventManager.TabHandleModel();
            tabHandleModel.setActionType(TabEventManager.TYPE.CLICK);
            tabHandleModel.setFromTab(TabEventManager.INSTANCE.getFromTab(false));
            MainActivityImplV2.this.m28602a(carGrop2, false, tabHandleModel);
            MainActivityImplV2.this.reportClick(carGrop, carGrop2, z ? 1 : 0, i == 1 ? GlobalPayOmegaConstant.EventKey.TAB : "more");
        }
    };

    /* renamed from: t */
    private DrawerLayout.DrawerListener f37960t = new DrawerLayout.DrawerListener() {
        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }

        public void onDrawerOpened(View view) {
            MainActivityImplV2.this.m28612d();
        }

        public void onDrawerClosed(View view) {
            MainActivityImplV2.this.m28612d();
        }
    };

    /* renamed from: u */
    private Handler f37961u = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                MainActivityImplV2.this.f37958r.setVisibility(0);
            } else if (message.what == 0) {
                MainActivityImplV2.this.f37958r.setVisibility(8);
            }
            return false;
        }
    });

    /* renamed from: v */
    private ILocation.ILocationChangedListener f37962v = new ILocation.ILocationChangedListener() {
        private int mDistance = GlobalApolloUtils.getConfRefreshDistance();
        private DIDILocation mLastDiDiLocation;
        private DIDILocation mLastDiDiLocationMis;

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation != null && !MainActivityImplV2.this.m28628o() && ActivityLifecycleManager.getInstance().isAppActive()) {
                DIDILocation dIDILocation2 = this.mLastDiDiLocationMis;
                if (dIDILocation2 == null || dIDILocation.distanceTo(dIDILocation2) > ((double) this.mDistance)) {
                    if (this.mLastDiDiLocationMis != null) {
                        MainActivityImplV2.this.m28609b(false);
                    }
                    this.mLastDiDiLocationMis = dIDILocation;
                }
                DIDILocation dIDILocation3 = this.mLastDiDiLocation;
                if (dIDILocation3 == null || dIDILocation.distanceTo(dIDILocation3) > 200.0d) {
                    OneConfStore.getInstance().getOneConf(MainActivityImplV2.this.getApplicationContext(), dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    this.mLastDiDiLocation = dIDILocation;
                }
            }
        }
    };

    public void onBusinessContextChanged(BaseBusinessContext baseBusinessContext, BaseBusinessContext baseBusinessContext2) {
    }

    public void preLeaveHome() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        DiDiLaunchingLogTimer.get().methodStart(DiDiLogLaunchTimer.KEY_TIME_MAINLAUNCH);
        DiDiLaunchingLogTimer.get().stampCreate();
        Application application = getApplication();
        EventBus.getDefault().register(this);
        if (application instanceof DIDIBaseApplication) {
            DiDiLaunchingLogTimer.get().setHotLaunch(((DIDIBaseApplication) application).isHotLaunch());
        }
        super.onCreate(bundle);
        m28625l();
        NationTypeUtil.getNationComponentData();
        DataContainer.getInstance().initData(getApplicationContext(), NationTypeUtil.getNationComponentData().getGLang());
        SideBarInitialization.init();
        m28626m();
        setContentView((int) R.layout.new_ui_a_home);
        m28608b();
        m28623j();
        initPush();
        initNetDetect();
        m28606a(false);
        PublicServiceUtil.initSDK(this);
        m28612d();
        try {
            this.f37953m = getIntent().getBooleanExtra("no_res", false);
        } catch (Throwable unused) {
            this.f37953m = false;
        }
        startAppUpdateCheck();
        String phone = NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
        if (!TextUtils.isEmpty(phone) && phone.startsWith("000")) {
            Logger logger = log;
            logger.info("#######patch phone is " + phone, new Object[0]);
            HotPatchVerify.init(application);
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                FusionUtil.setTopBarHeight(DensityUtil.px2dip(MainActivityImplV2.this, (float) (MainActivityImplV2.this.f37945e.getView() != null ? MainActivityImplV2.this.f37945e.getView().getBottom() - ResourcesHelper.getDimensionPixelSize(MainActivityImplV2.this, R.dimen.new_ui_home_title_bar_shadow_height) : 0)));
            }
        });
        return super.onCreateView(str, context, attributeSet);
    }

    /* renamed from: a */
    private void m28594a() {
        Intent intent = getIntent();
        if (intent != null) {
            String str = null;
            try {
                str = intent.getStringExtra(SchemeDispatcherImpl.PARAM_DROUTER_URL);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                com.didi.sdk.log.Logger.m29536d(" checkDrouterUrl,start with drouter url = " + str, new Object[0]);
                intent.putExtra(SchemeDispatcherImpl.PARAM_DROUTER_URL, "");
                DRouter.build(str).start(this);
            }
        }
    }

    /* renamed from: b */
    private void m28608b() {
        this.f37952l = (FrameLayout) findViewById(R.id.fragment_container);
        this.f37944d = (FrameLayout) findViewById(R.id.home_entrance_view_container);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mMapFragment = (MapFragment) supportFragmentManager.findFragmentById(R.id.home_map_fragment);
        HomeNewTitleBarFragment homeNewTitleBarFragment = (HomeNewTitleBarFragment) supportFragmentManager.findFragmentById(R.id.title_bar_container);
        this.f37945e = homeNewTitleBarFragment;
        if (Preconditions.nonNull(homeNewTitleBarFragment)) {
            this.f37945e.setOnViewVisibilityChangeListener(this);
        }
        HomeBizNavBarFragment homeBizNavBarFragment = (HomeBizNavBarFragment) supportFragmentManager.findFragmentById(R.id.biz_bar_container);
        this.f37946f = homeBizNavBarFragment;
        if (Preconditions.nonNull(homeBizNavBarFragment)) {
            this.f37946f.setNavSelectListener(this.f37959s);
        }
        this.f37947g = (HomeNavDrawerFragment) supportFragmentManager.findFragmentById(R.id.navigation_drawer);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(ContextCompat.getColor(this, R.color.new_ui_sidebar_scim_color));
        drawerLayout.addDrawerListener(this.f37960t);
        this.f37947g.setDrawerLayout(drawerLayout);
        drawerLayout.setDrawerLockMode(1);
        View findViewById = findViewById(R.id.viewVirtualStatus);
        this.f37958r = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = getStatusBarHeight();
        this.f37958r.setLayoutParams(layoutParams);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f37949i.onRequestPermissionsResult(i, strArr, iArr);
    }

    public int getStatusBarHeight() {
        return AppUtils.getStatusBarHeight(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r1.getView();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m28606a(boolean r5) {
        /*
            r4 = this;
            int r0 = com.didi.sdk.util.AppUtils.getStatusBarHeight(r4)
            com.didi.sdk.home.view.HomeNewTitleBarFragment r1 = r4.f37945e
            if (r1 == 0) goto L_0x001e
            android.view.View r1 = r1.getView()
            if (r1 == 0) goto L_0x001e
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            r2.topMargin = r0
            com.didi.sdk.app.MainActivityImplV2$4 r0 = new com.didi.sdk.app.MainActivityImplV2$4
            r0.<init>(r1, r2)
            r1.post(r0)
        L_0x001e:
            android.widget.FrameLayout r0 = r4.f37952l
            if (r0 == 0) goto L_0x0030
            android.os.Handler r0 = r4.f37961u
            r1 = r5 ^ 1
            if (r5 == 0) goto L_0x002b
            r2 = 500(0x1f4, double:2.47E-321)
            goto L_0x002d
        L_0x002b:
            r2 = 0
        L_0x002d:
            r0.sendEmptyMessageDelayed(r1, r2)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.MainActivityImplV2.m28606a(boolean):void");
    }

    /* renamed from: c */
    private boolean m28611c() {
        return (this.f37945e.isHideNetworkTitlteBar() && (this.f37947g.isDrawerOpen() ^ true)) || m28628o();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m28612d() {
        if (m28628o()) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, m28611c(), 0);
        } else if (!this.f37945e.isHideNetworkTitlteBar()) {
            StatusBarLightingCompat.setStatusBarBgLightning(this, m28611c(), getResources().getColor(R.color.common_disabled_network));
        } else {
            StatusBarLightingCompat.setStatusBarBgLightning(this, m28611c(), 0);
        }
    }

    public void onNetWorkStateChanged(View view) {
        m28612d();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0032 A[LOOP:1: B:7:0x0032->B:10:0x0044, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewIntent(android.content.Intent r4) {
        /*
            r3 = this;
            super.onNewIntent(r4)
            java.util.Set<com.didi.sdk.app.MainActivityIntentFilter> r0 = r3.f37951k
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002c
            java.lang.Class<com.didi.sdk.app.MainActivityIntentFilter> r0 = com.didi.sdk.app.MainActivityIntentFilter.class
            com.didichuxing.foundation.spi.ServiceLoader r0 = com.didichuxing.foundation.spi.ServiceLoader.load(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r0.next()
            com.didi.sdk.app.MainActivityIntentFilter r1 = (com.didi.sdk.app.MainActivityIntentFilter) r1
            java.util.Set<com.didi.sdk.app.MainActivityIntentFilter> r2 = r3.f37951k
            r2.add(r1)
            com.didi.sdk.app.BusinessContextHelper r2 = r3.f37949i
            r1.doFilter(r4, r3, r2)
            goto L_0x0015
        L_0x002c:
            java.util.Set<com.didi.sdk.app.MainActivityIntentFilter> r0 = r3.f37951k
            java.util.Iterator r0 = r0.iterator()
        L_0x0032:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r0.next()
            com.didi.sdk.app.MainActivityIntentFilter r1 = (com.didi.sdk.app.MainActivityIntentFilter) r1
            com.didi.sdk.app.BusinessContextHelper r2 = r3.f37949i
            boolean r1 = r1.doFilter(r4, r3, r2)
            if (r1 == 0) goto L_0x0032
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.MainActivityImplV2.onNewIntent(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        DiDiLaunchingLogTimer.get().stampStart();
        m28614e();
    }

    /* renamed from: e */
    private void m28614e() {
        if (this.mMapFragment != null) {
            this.mMapFragment.startInitMap();
        }
    }

    /* renamed from: f */
    private void m28617f() {
        m28603a((Runnable) new Runnable() {
            public void run() {
                MainActivityImplV2.this.m28596a(2, false, true);
            }
        });
    }

    /* renamed from: a */
    private void m28603a(Runnable runnable) {
        if (m28618g()) {
            this.f37949i.safePost(runnable);
        }
    }

    /* renamed from: g */
    private boolean m28618g() {
        return this.mMapFragment != null && this.mMapFragment.isReadyMap();
    }

    public void mapCallBack() {
        AdUtil.INSTANCE.setMapReady(true);
        m28624k();
        m28620h();
        ((BroadcastSender) BroadcastSender.getInstance(this)).mo96969a();
        m28617f();
    }

    /* renamed from: h */
    private void m28620h() {
        if (this.f37954n == null) {
            BizManager bizManager = new BizManager();
            this.f37954n = bizManager;
            bizManager.init(this.f37949i);
            this.f37954n.setBizListener(new BizManager.BizListener() {
                public void onBizSwitched(CarGrop carGrop, String str, BusinessContext businessContext, TabEventManager.TabHandleModel tabHandleModel) {
                    MainActivityImplV2.this.m28601a(carGrop, str, businessContext, tabHandleModel);
                }

                public void onBizDataChanged(int i) {
                    MainActivityImplV2.this.m28596a(i, true, false);
                }
            });
        }
    }

    /* renamed from: i */
    private void m28622i() {
        BizManager bizManager = this.f37954n;
        if (bizManager != null) {
            bizManager.destory();
        }
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        super.onResumeFragments();
        this.f37949i.onResume();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        boolean isApplicationInit = ApplicationLifeUtils.isApplicationInit(this);
        super.onResume();
        MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(this);
        addLaunchingSliceTimeStatistics();
        if (!isApplicationInit) {
            m28627n();
        }
        DiDiLaunchingLogTimer.get().stampResume();
        DiDiLaunchingLogTimer.get().methodStart(DiDiLogLaunchTimer.KEY_TIME_RENDER);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f37949i.onPause();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            getSupportFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.f37949i.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        GuideUtil.cleanFirstLaunchApp(this);
        m28622i();
        this.f37949i.removeStaticReceivers();
        this.f37949i.onPause();
        DiDiLaunchingLogTimer.get().clearData();
        killAppOnDestory();
    }

    /* renamed from: j */
    private void m28623j() {
        this.f37949i = new BusinessContextHelper(this, this.f37945e, this, this.f37946f, BusinessContext.class, R.id.fragment_container, IPresenter.templateMapping);
    }

    /* renamed from: k */
    private void m28624k() {
        this.f37949i.addListeners(this);
        this.f37949i.setNavigationListener(this);
        this.f37949i.setOnBackResultListener(this);
        this.f37949i.registerStaticReceivers(DidiBroadcastReceiverImpl.class);
    }

    public BusinessContext getBusinessContext(String str) {
        return (BusinessContext) this.f37949i.getBusinessContext(str, BusinessContext.class);
    }

    /* renamed from: l */
    private void m28625l() {
        MultiLocaleHelper localeHelper = MultiLocaleStore.getInstance().getLocaleHelper();
        this.f37950j = localeHelper;
        if (localeHelper != null) {
            localeHelper.setMainActivity(this);
            if (Build.VERSION.SDK_INT >= 24) {
                this.f37950j.refreshAppLocale(this);
            }
        }
        LocationPerformer.getInstance().start(getApplicationContext());
        Intent intent = getIntent();
        if (intent != null) {
            try {
                if (intent.getBooleanExtra("switch_locale", false)) {
                    BusinessContextManager.getInstance().mo97018a(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: m */
    private void m28626m() {
        TaskScheduler.getDefault().scheduleUiTask(new Runnable() {
            public void run() {
                if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                    UserCenterFacade.getIns().fetchUserInfo(MainActivityImplV2.this.getApplicationContext(), NationTypeUtil.getNationComponentData().getLoginInfo().getToken(), NationTypeUtil.getNationComponentData().getGLang(), (RpcService.Callback<UserInfo>) null);
                }
            }
        }, 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28602a(CarGrop carGrop, boolean z, TabEventManager.TabHandleModel tabHandleModel) {
        BizManager bizManager = this.f37954n;
        if (bizManager != null && carGrop != null) {
            bizManager.loadBiz(carGrop, z, tabHandleModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28601a(CarGrop carGrop, String str, BusinessContext businessContext, TabEventManager.TabHandleModel tabHandleModel) {
        String schema = carGrop.getSchema();
        if (businessContext != null) {
            String groupType = carGrop.getGroupType();
            this.f37946f.switchToPage(carGrop.getNavTag());
            businessContext.setMapFlowView(this.mMapFragment.getmMapFlowView());
            this.mMapFragment.getmMapFlowView().getPresenter().clear();
            boolean z = true;
            if (TextUtils.isEmpty(schema)) {
                schema = String.format(ENTRANCE_URI, new Object[]{groupType});
            }
            Intent intent = new Intent();
            Uri parse = Uri.parse(schema);
            log.info("match extend uri: %s", parse);
            intent.setData(parse);
            Fragment matchPage = this.f37949i.matchPage(businessContext, intent);
            String h5Link = ConfProxy.getInstance().getH5Link(groupType);
            if (TextUtils.isEmpty(h5Link) && matchPage == null) {
                h5Link = PreHotStore.getPrehotH5Link(groupType);
            }
            if (!TextUtils.isEmpty(h5Link)) {
                matchPage = PreHotStore.buildWebFragmentByUrl(h5Link, str);
            } else {
                z = false;
            }
            if (matchPage == null) {
                log.info("match extend fail...", new Object[0]);
            }
            Fragment fragment = this.f37948h;
            if (matchPage == null) {
                matchPage = new Fragment();
            }
            this.f37948h = matchPage;
            if (fragment != null) {
                fragment.setUserVisibleHint(false);
            }
            if (tabHandleModel != null) {
                Bundle arguments = this.f37948h.getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                TabEventManager.TYPE actionType = tabHandleModel.getActionType();
                if (actionType != null) {
                    arguments.putString("action_type", actionType.getValue());
                }
                arguments.putString("from_tab", tabHandleModel.getFromTab());
                SystemUtils.log(3, "tabParams", GSonUtil.jsonFromObject(arguments.toString()), (Throwable) null, "com.didi.sdk.app.MainActivityImplV2", 608);
                this.f37948h.setArguments(arguments);
            }
            m28605a(groupType, this.f37948h, z);
            if (!TextUtils.isEmpty(schema) && !schema.contains("entrance")) {
                DRouter.build(schema + "?src=tab&" + DRouterUrlInterceptor.TAG_NO_SWITCH_TAP + "=1").start(this, new RouterCallback.ActivityCallback() {
                    public void onActivityResult(int i, Intent intent) {
                        Logger logger = BaseMainActivity.log;
                        logger.info("sub page onActivityResult" + i, new Object[0]);
                        MainActivityImplV2.this.m28602a(ConfProxy.getInstance().getGroupByType(ConfProxy.getInstance().getSelectedType()), false, (TabEventManager.TabHandleModel) null);
                    }
                });
            }
            this.f37947g.setBusinessContext(businessContext);
            m28604a(groupType);
            m28594a();
        }
    }

    /* renamed from: a */
    private void m28605a(String str, Fragment fragment, boolean z) {
        this.f37955o = this.f37956p;
        if (z) {
            this.f37956p = R.id.home_entrance_view_new;
        } else if ("ride".equals(str)) {
            this.f37956p = R.id.home_entrance_view_above;
        } else {
            this.f37956p = R.id.home_entrance_view_below;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = this.f37955o;
        if (i != 0) {
            beginTransaction.replace(i, new Fragment());
        }
        beginTransaction.replace(this.f37956p, fragment);
        beginTransaction.commitAllowingStateLoss();
        try {
            getSupportFragmentManager().executePendingTransactions();
            fragment.setUserVisibleHint(true);
        } catch (Exception e) {
            log.error("executePendingTransactions exception", (Throwable) e);
            e.printStackTrace();
            trackFragmentError(e);
        }
    }

    /* renamed from: a */
    private void m28604a(String str) {
        int groupIdByType;
        if ("ride".equals(str) && (groupIdByType = ConfProxy.getInstance().getGroupIdByType(str)) != 0) {
            PublicServiceUtil.showPopView(this, ConstantUtils.ResourceId.NOTICE_ZHUANCHE, groupIdByType);
        }
    }

    public Fragment getCurrentFragment() {
        Fragment fragment = this.f37948h;
        if (fragment != null && fragment.isAdded() && !this.f37948h.isDetached()) {
            return this.f37948h;
        }
        log.warn("current fragment detached", new Object[0]);
        return getSupportFragmentManager().findFragmentById(this.f37956p);
    }

    public Fragment getTitleBarFragment() {
        return this.f37945e;
    }

    public Fragment getHomeBizNarFragment() {
        return this.f37946f;
    }

    public HomeNavDrawerFragment getDrawerFragment() {
        return this.f37947g;
    }

    public void onEntranceVisible(boolean z) {
        int i = 0;
        findViewById(R.id.home_entrance_view_above).setVisibility(z ? 0 : 8);
        View findViewById = findViewById(R.id.home_entrance_view_below);
        if (!z) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    public void onBackToHome() {
        if (this.f37957q) {
            log.debug("onBackToHome()", new Object[0]);
            this.f37957q = false;
            HomeNewTitleBarFragment homeNewTitleBarFragment = this.f37945e;
            if (homeNewTitleBarFragment != null) {
                homeNewTitleBarFragment.restoreTitleBar();
            }
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment instanceof INavigationListener) {
                ((INavigationListener) currentFragment).onBackToHome();
            }
            log.debug("MainActivity onBackToHome refreshOrderStatus", new Object[0]);
            m28612d();
            m28609b(true);
            onMapLowMemory();
        }
    }

    /* renamed from: n */
    private void m28627n() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                if (ActivityLifecycleManager.getInstance().isAppActive()) {
                    if (!MainActivityImplV2.this.f37957q) {
                        MainActivityImplV2.this.mIsReportTabShow = false;
                    }
                    MainActivityImplV2.this.m28609b(false);
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m28609b(boolean z) {
        BizManager bizManager;
        if (!this.f37957q && (bizManager = this.f37954n) != null) {
            bizManager.refreshMis(z);
        }
    }

    public void changedStatusBar(boolean z) {
        m28606a(z);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Fragment currentFragment = getCurrentFragment();
            if ((currentFragment instanceof KeyEvent.Callback) && ((KeyEvent.Callback) currentFragment).onKeyUp(i, keyEvent)) {
                return true;
            }
            if (this.f37947g.isDrawerOpen()) {
                this.f37947g.close();
                return true;
            } else if (i == 4 && !ExitUtil.isValidExit(this)) {
                return true;
            } else {
                OmegaSDKAdapter.trackEvent("gp_home_common_exit");
                this.killApp = true;
                ExitUtil.doExit();
            }
        } else if (this.f37949i.onKeyUp(i, keyEvent)) {
            return true;
        }
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void onLeaveHome() {
        if (!this.f37957q) {
            log.debug("onLeaveHome()", new Object[0]);
            this.f37957q = true;
            this.f37945e.onLeaveHome();
            this.f37945e.hideTitleBar();
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment instanceof INavigationListener) {
                ((INavigationListener) currentFragment).onLeaveHome();
            }
            if (this.f37947g.isDrawerOpen()) {
                this.f37947g.close();
            }
            m28612d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m28628o() {
        return this.f37957q;
    }

    public void onPopBackToHome(Bundle bundle) {
        Bundle arguments;
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment != null && (arguments = currentFragment.getArguments()) != null && bundle != null) {
            arguments.putAll(bundle);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m28629p();
        } else {
            LocationPerformer.getInstance().removeLocationListener(this.f37962v);
        }
        if (z) {
            DiDiLaunchingLogTimer diDiLaunchingLogTimer = DiDiLaunchingLogTimer.get();
            diDiLaunchingLogTimer.methodEnd(DiDiLogLaunchTimer.KEY_TIME_RENDER);
            IToggle toggle = Apollo.getToggle("launch_time");
            Logger logger = log;
            logger.info("launcher toggle = " + toggle.allow() + " , noRes = " + this.f37953m, new Object[0]);
            diDiLaunchingLogTimer.methodEnd(DiDiLogLaunchTimer.KEY_TIME_MAINLAUNCH);
            diDiLaunchingLogTimer.dump(this.f37953m ^ true, getApplicationContext());
            diDiLaunchingLogTimer.cleanStamp();
            LogTimer.get().dump();
        }
    }

    /* renamed from: p */
    private void m28629p() {
        LocationPerformer.getInstance().addLocationListener(this.f37962v);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        m28595a(i, i2, intent);
    }

    /* renamed from: a */
    private void m28595a(int i, int i2, Intent intent) {
        if (i == 4368) {
            HashMap hashMap = new HashMap();
            if (i2 == 0) {
                hashMap.put("action", 0);
            } else if (i2 == -1) {
                hashMap.put("action", 1);
                DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
                if (lastLocation != null) {
                    double latitude = lastLocation.getLatitude();
                    SecondConfProxy.getInstance().getSecConfigFromNet(lastLocation.getLongitude(), latitude, OneConfStore.getInstance().getCityId());
                }
            }
            GlobalOmegaUtils.trackEvent("map_loc_service_ck", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28596a(int i, boolean z, boolean z2) {
        TabEventManager.TabHandleModel tabHandleModel;
        CarGrop carGrop;
        if (!this.f37957q) {
            TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
            if (z2) {
                tabHandleModel = new TabEventManager.TabHandleModel();
                tabHandleModel.setFromTab(TabEventManager.INSTANCE.getFromTab(false));
                tabHandleModel.setActionType(TabEventManager.TYPE.AUTO);
            } else {
                tabHandleModel = null;
            }
            if (topBarData == null || !topBarData.isShowTopBar() || topBarData.selectedGroup == null) {
                this.f37946f.setConfigInfo((List<TopCarGroupWrapper>) null, this.f37957q);
                if (topBarData == null || topBarData.selectedGroup == null) {
                    carGrop = new CarGrop();
                    carGrop.setGroupType("ride");
                    carGrop.setGroupId(30008);
                } else {
                    carGrop = topBarData.selectedGroup;
                }
                m28602a(carGrop, false, tabHandleModel);
            } else {
                this.f37946f.setConfigInfo(topBarData.dataList, this.f37957q);
                m28602a(topBarData.selectedGroup, z, tabHandleModel);
                reportTabShow(i);
            }
            tryHandleDynamicLinkAgain();
            tryHandleAd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m28630q() {
        HashMap hashMap = new HashMap();
        hashMap.put("business_type", ConfProxy.getInstance().getDefaultSelectedType());
        OmegaSDKAdapter.trackEvent("ibt_gp_changebusiness_more_ck", (Map<String, Object>) hashMap);
    }
}
