package com.didi.soda.home.topgun.component.feed;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.foundation.sdk.service.LocalizationService;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.biz.popdialog.PromoCodeRepo;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.coordshop.CoordShopManager;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.didi.soda.customer.foundation.rpc.entity.BannerEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.NoMoreLoginEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.splash.SplashEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.extra.CustomerBrokerRpcManager;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.SplashResourceStorage;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.map.MapLazyLoader;
import com.didi.soda.customer.p165h5.PreloadWebResource;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.RepoHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.datasource.page.PageResult;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.datasource.page.dynamic.DynamicDataSource;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.globalcart.entity.BillListInfoEntity;
import com.didi.soda.globalcart.repo.GlobalCartListRepo;
import com.didi.soda.home.bub.TaskBubModel;
import com.didi.soda.home.component.feed.HomeTypeContract;
import com.didi.soda.home.component.policy.PolicyUpdatePresenter;
import com.didi.soda.home.component.titlebar.HomeTitleBarManager;
import com.didi.soda.home.manager.CustomerDialogShownManager;
import com.didi.soda.home.manager.RouterCloseRepo;
import com.didi.soda.home.page.AllScenePage;
import com.didi.soda.home.page.FilterPageKt;
import com.didi.soda.home.page.PolicyUpdatePage;
import com.didi.soda.home.policy.HomePolicyHelper;
import com.didi.soda.home.topgun.binder.HomeComponentLogicUnit;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;
import com.didi.soda.home.topgun.binder.model.HomeHeaderRvModel;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import com.didi.soda.home.topgun.binder.model.HomeOrderCardRvModel;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import com.didi.soda.home.topgun.component.feed.Contract;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.FilterHelper;
import com.didi.soda.home.topgun.component.filter.OnFilterEvent;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.manager.HomeFeedRefreshRepo;
import com.didi.soda.home.topgun.manager.HomeFeedRepo;
import com.didi.soda.home.topgun.manager.HomeFeedbackConfigHelper;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.manager.HomePolicyUpdateRepo;
import com.didi.soda.home.topgun.manager.RpcLazyLoader;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.router.DiRouter;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class HomeFeedPresenter extends Contract.AbsHomeFeedPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f45309a = "HomeFeedPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ChildDataListManager<RecyclerModel> f45310b;

    /* renamed from: c */
    private ChildDataItemManager<HomeHeaderRvModel> f45311c;

    /* renamed from: d */
    private HomeComponentLogicUnit f45312d = new HomeComponentLogicUnit(this);

    /* renamed from: e */
    private DialogInstrument f45313e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HomePolicyHelper f45314f;

    /* renamed from: g */
    private TopGunAbnormalRvModel f45315g;

    /* renamed from: h */
    private Subscription f45316h = null;

    /* renamed from: i */
    private long f45317i = System.currentTimeMillis();

    /* renamed from: j */
    private boolean f45318j = true;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CustomerPage f45319k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public FilterHelper f45320l = new FilterHelper(1);

    public HomeFeedPresenter(CustomerPage customerPage) {
        this.f45319k = customerPage;
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(FilterPageKt.KEY_FILTER_CONFIRM)) {
                this.f45320l.doConfirmFromFilterPage(bundle.getBoolean(FilterPageKt.KEY_FILTER_IS_RESET, false));
            } else if (bundle.getBoolean(PolicyUpdatePresenter.PRIVACY_UPDATE_CONFIRM, false)) {
                this.f45319k.setShowPolicyDialog(false);
                this.f45319k.openPolicyInterruptRoute();
            } else if (bundle.getBoolean(AllScenePage.KEY_DISMISS_WITH_CONFIRM, false)) {
                String string = bundle.getString(AllScenePage.KEY_TARGET_URL, "");
                int i = bundle.getInt(AllScenePage.KEY_TARGET_TYPE, 0);
                SceneComponentModel.Companion.performClickFromScene(string, Integer.valueOf(i), bundle.getString(AllScenePage.KEY_TARGET_TITLE, ""), bundle.getString(AllScenePage.KEY_TARGET_RECID, ""), (Function2<? super Integer, ? super UrlBuilder, Unit>) null);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        m33636c();
        m33659q();
        m33663u();
        m33658p();
        m33661s();
        ((Contract.AbsHomeFeedView) getLogicView()).showShimmer();
        m33660r();
        HomeOmegaHelper.getInstance().attach(getScopeContext());
        m33664v();
        HomeLogTrackerHelper.setLogTracker(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|");
        m33662t();
        m33625b();
        getScope().attach("showFeedBack", Boolean.valueOf(HomeFeedbackConfigHelper.Companion.getInstance().isShowFeedBack()));
        String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
        IBlockScope scope = getScope();
        if (appInstanceID == null) {
            appInstanceID = "";
        }
        scope.attach("googleInstanceId", appInstanceID);
        getScope().attach("apmEnable", Boolean.valueOf(FallbackController.getFallbackInfo().isOpen));
        getScope().attach(BlocksConst.BLOCK_PARAM_ROUTE_PATH, "homePage");
        CoordShopManager.Companion.get().attachToHost(this, new Function2<Integer, RecyclerModel, Unit>() {
            public Unit invoke(Integer num, RecyclerModel recyclerModel) {
                HomeFeedPresenter.this.getDataSource().insert(num.intValue(), recyclerModel);
                return Unit.INSTANCE;
            }
        }, ((Contract.AbsHomeFeedView) getLogicView()).getRecycleView());
    }

    public void onStart() {
        super.onStart();
        OmegaCommonParamHelper.refreshLv1GuideParam();
        HomeLogTrackerHelper.setLogTracker("onStart", "c-state|");
    }

    public void onStop() {
        super.onStop();
        HomeLogTrackerHelper.setLogTracker("onStop", "c-state|");
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f45311c == null) {
            ChildDataItemManager<HomeHeaderRvModel> createChildDataItemManager = createChildDataItemManager();
            this.f45311c = createChildDataItemManager;
            addDataManager(createChildDataItemManager);
        }
        this.f45311c.setItem(new HomeHeaderRvModel());
        if (this.f45310b == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f45310b = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    public void onPullToRefresh() {
        HomeTypeContract.HomeLoadingType homeLoadingType;
        super.onPullToRefresh();
        this.f45318j = true;
        if (GlobalContext.isEmbed()) {
            ((Contract.AbsHomeFeedView) getLogicView()).dismissPullToRefresh();
            homeLoadingType = HomeTypeContract.HomeLoadingType.LOADING_DIALOG_WITH_BOX;
        } else {
            homeLoadingType = HomeTypeContract.HomeLoadingType.LOADING_PULL;
        }
        m33620a(true);
        m33604a(((HomeFeedParam) getDataSource().getPageParams()).getScene(), false, homeLoadingType);
        HomeOmegaHelper.getInstance().trackPullRefresh();
        HomeLogTrackerHelper.setLogTracker("onPullToRefresh", "c-act|");
    }

    public void onFooterErrorClicked() {
        getDataSource().loadNextPage();
    }

    public void onFooterSignInClicked() {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(getContext(), 1);
        }
    }

    public void onLoadMore() {
        if (((HomeFeedParam) getDataSource().getPageParams()).getHasMore() && !((Contract.AbsHomeFeedView) getLogicView()).needBlockFooterLoading() && this.f45310b.indexOf(this.f45315g) < 0) {
            ((Contract.AbsHomeFeedView) getLogicView()).showFooterLoadingView();
            getDataSource().loadNextPage();
            HomeLogTrackerHelper.setLogTracker("onLoadMore", "c-act|");
            HomeOmegaHelper.getInstance().trackLoadMore(((HomeFeedParam) getDataSource().getPageParams()).getPageIndex());
            HomeOmegaHelper.getInstance().trackBeginRequest(((HomeFeedParam) getDataSource().getPageParams()).getScene(), CustomerSystemUtil.isGpsEnabled(getContext()));
        }
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        return this.f45312d;
    }

    public void notifyFilterItemClick(FilterModel filterModel, boolean z) {
        this.f45320l.clickItem(filterModel, getScopeContext());
    }

    public void resetFilter() {
        FilterHelper filterHelper = this.f45320l;
        if (filterHelper != null) {
            filterHelper.reset();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m33655m();
        CustomerDialogShownManager.Companion.getInstance().onResumeCheckLocationSettingService(getContext());
        ScopeContext scopeContext = getScopeContext();
        if (scopeContext != null) {
            OmegaCommonParamHelper.updatePageGuideParam((GuideParam) scopeContext.getObject("ScopeContextPageGuideParam"));
        }
        this.f45320l.onResume();
        if (((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).needRefreshGlobalCartList()) {
            ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchGlobalCartList((CustomerRpcCallback<BillListInfoEntity>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f45320l.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((Contract.AbsHomeFeedView) getLogicView()).dismissShimmer();
        ((Contract.AbsHomeFeedView) getLogicView()).dismissLoadingDialog();
        ((Contract.AbsHomeFeedView) getLogicView()).dismissPullToRefresh();
        HomeOmegaHelper.getInstance().detach(getScopeContext());
        HomeLogTrackerHelper.setLogTracker(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|");
        HomeBusinessPool.getPool().clearBusiness();
        RepoFactory.clearRepo(HomeFeedRepo.class);
        RepoFactory.clearRepo(HomeFeedRefreshRepo.class);
        RepoFactory.clearRepo(HomePolicyUpdateRepo.class);
        RepoFactory.clearRepo(GlobalCartListRepo.class);
        RpcLazyLoader.getLoader().mIsInit = false;
        HomePolicyHelper homePolicyHelper = this.f45314f;
        if (homePolicyHelper != null) {
            homePolicyHelper.resetPolicyConfig();
        }
        clearDataManagers();
        CoordShopManager.Companion.get().detachFromHost();
    }

    public DynamicDataSource<HomeFeedParam, HomeEntity> createDataSource(ScopeContext scopeContext) {
        return new HomeFeedDataSource(scopeContext, new PayloadProvider<FeedPayload>() {
            public FeedPayload providePayload() {
                FeedPayload feedPayload = new FeedPayload();
                HomeFeedParam homeFeedParam = new HomeFeedParam();
                if (!(HomeFeedPresenter.this.getDataSource() == null || HomeFeedPresenter.this.getDataSource().getPageParams() == null)) {
                    homeFeedParam = (HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams();
                }
                feedPayload.mPageId = "homePage";
                feedPayload.mPageFilter = homeFeedParam.getFilterParam();
                feedPayload.mRecId = homeFeedParam.getRecId();
                feedPayload.mTraceId = homeFeedParam.getTraceId();
                return feedPayload;
            }
        }, getScope());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33609a(HomeEntity homeEntity) {
        HomeHeaderRvModel homeHeaderRvModel;
        if (((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() == 0) {
            if (this.f45311c.getCount() > 0) {
                homeHeaderRvModel = this.f45311c.get(0);
            } else {
                homeHeaderRvModel = new HomeHeaderRvModel();
            }
            if (homeEntity != null) {
                homeHeaderRvModel.update(HomeExtKt.getSpecialBanner(homeEntity), homeEntity.getMAmbientImg(), homeEntity.getMRecId());
            } else {
                homeHeaderRvModel.update((BannerEntity) null, (String) null, "");
            }
            if (!(homeEntity == null || homeEntity.getSearchEntity() == null)) {
                homeHeaderRvModel.update(homeEntity.getSearchEntity().mSearchHotWordsList);
            }
            ((Contract.AbsHomeFeedView) getLogicView()).changeHeaderStyle(homeHeaderRvModel.mIsShowSpecial);
            this.f45311c.setItem(homeHeaderRvModel);
        }
    }

    /* renamed from: b */
    private void m33625b() {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).subscribe(getScopeContext(), new Action1<CustomerResource<BillListInfoEntity>>() {
            public void call(CustomerResource<BillListInfoEntity> customerResource) {
                HomeFeedPresenter.this.m33610a(customerResource);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33610a(CustomerResource<BillListInfoEntity> customerResource) {
        if (customerResource != null && customerResource.status == Resource.Status.SUCCESS && customerResource.data != null && ((BillListInfoEntity) customerResource.data).getBills() != null) {
            int size = ((BillListInfoEntity) customerResource.data).getBills().size();
            HomeHeaderRvModel homeHeaderRvModel = null;
            if (this.f45311c.getCount() > 0) {
                homeHeaderRvModel = this.f45311c.get(0);
            }
            if (homeHeaderRvModel != null) {
                homeHeaderRvModel.cartShopNum = size;
                this.f45311c.setItem(homeHeaderRvModel);
                HomeOmegaHelper.getInstance().trackGlobalCartSW();
            }
        }
    }

    /* renamed from: c */
    private void m33636c() {
        getDataSource().setOnDataSourceListener(new DataSource.SimpleDataSourceListener<JsonObject, HomeEntity>() {
            public void onEndRequest(CustomerResource<HomeEntity> customerResource) {
                String str;
                ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).dismissLoadingDialog();
                ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).dismissPullToRefresh();
                ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).dismissShimmer();
                PreloadWebResource.Companion.beginPreloadWebResource(GlobalContext.getContext());
                if (HomeFeedPresenter.this.m33622a((HomeEntity) customerResource.data, customerResource.status, customerResource.code)) {
                    LaunchAppTracker.Companion.clear();
                    PerformanceOmegaHelper.getInstance().reset();
                    return;
                }
                if (!GlobalContext.isEmbed()) {
                    HomeFeedPresenter.this.m33639d();
                }
                HomeFeedPresenter.this.m33628b((HomeEntity) customerResource.data);
                HomeFeedPresenter.this.m33609a((HomeEntity) customerResource.data);
                PopDialogHelper.setPopDialogVisible(HomeFeedPresenter.this.getScopeContext(), 0);
                if (customerResource.status == Resource.Status.SUCCESS) {
                    if (customerResource.data == null) {
                        HomeFeedPresenter homeFeedPresenter = HomeFeedPresenter.this;
                        homeFeedPresenter.m33603a(-1, homeFeedPresenter.getContext().getResources().getString(R.string.customer_service_not_connected));
                        HomeLogTrackerHelper.setLogTracker("data action call -> data is null", "c-data|");
                        HomeOmegaHelper.getInstance().trackHomeError(-1, "data is null");
                    } else {
                        HomeLogTrackerHelper.setLogTracker("data action call -> data is normal", "c-data|");
                        HomeOmegaHelper.getInstance().trackHomeFeedShow((HomeEntity) customerResource.data, ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress(), ((HomeEntity) customerResource.data).getMRecId(), AddressUtil.hasLocationPermission(), CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext()));
                        HomeFeedPresenter.this.m33607a(((HomeEntity) customerResource.data).getMFooterLoginEntity());
                    }
                    if (((HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams()).getPageIndex() == 0) {
                        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchGlobalCartList((CustomerRpcCallback<BillListInfoEntity>) null);
                    }
                    LogUtil.m32588i(HomeFeedPresenter.f45309a, "fetchGlobalCartList");
                } else if (customerResource.status == Resource.Status.ERROR) {
                    if (ApiErrorConst.isAccountAbnormal(customerResource.code)) {
                        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(customerResource.code));
                        LoginUtil.trackLogOut(customerResource.code);
                        ConversionOmegaHelper.track(EventConst.Conversion.GOTO_LOGIN);
                        LoginUtil.loginActivityAndTrack(HomeFeedPresenter.this.getContext(), 12);
                    }
                    ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HOME_FEED_NOTLOAD).addModuleName("home");
                    ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
                    addModuleName.addErrorType(companion.getErrorType(customerResource.code + "")).build().trackError();
                    String string = customerResource.mExtension.getString("url");
                    if (customerResource.code <= 0 || TextUtils.isEmpty(string)) {
                        HomeOmegaHelper.getInstance().trackHomeError(customerResource.code, customerResource.message);
                        HomeFeedPresenter homeFeedPresenter2 = HomeFeedPresenter.this;
                        int i = customerResource.code;
                        if (TextUtils.isEmpty(customerResource.message) || customerResource.message.contains(StringConst.JAVA)) {
                            str = HomeFeedPresenter.this.getContext().getResources().getString(R.string.customer_service_not_connected);
                        } else {
                            str = customerResource.message;
                        }
                        homeFeedPresenter2.m33603a(i, str);
                    } else {
                        HomeLogTrackerHelper.setLogTracker("data action call -> show web url " + string, "c-data|");
                    }
                    ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).showBubOrNot((TaskBubModel) null);
                }
                MapLazyLoader.getLoader().loadMapNextIdle();
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).lazyInitOnce(HomeFeedPresenter.this.getContext());
                RpcLazyLoader.getLoader().lazyRpc();
                if (!GlobalContext.isEmbed()) {
                    HomeFeedPresenter.this.m33642e();
                }
            }

            public void onAfterPageResult(CustomerResource<HomeEntity> customerResource, PageResult<JsonObject> pageResult) {
                if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
                    HomeFeedPresenter.this.m33633b(false);
                }
                if (customerResource.data == null || ((HomeEntity) customerResource.data).getMSuspendBall() == null) {
                    ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).showBubOrNot((TaskBubModel) null);
                } else {
                    ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).showBubOrNot(TaskBubModel.newInstance(((HomeEntity) customerResource.data).getMSuspendBall()));
                }
                if (((HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams()).getPageIndex() == 0 && pageResult != null && !pageResult.isEmpty()) {
                    ((HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams()).setScene(5);
                }
                CoordShopManager.Companion.get().updateFilterStatus(HomeFeedPresenter.this.f45320l.isOriginalFilter());
            }
        });
        getDataSource().subscribeListChanged(new Action1<List<RecyclerModel>>() {
            public void call(List<RecyclerModel> list) {
                HomeFeedPresenter.this.f45310b.set(list);
            }
        });
        getDataSource().subscribeListUpdate(new Action1<List<RecyclerModel>>() {
            public void call(List<RecyclerModel> list) {
                for (int i = 0; i < list.size(); i++) {
                    RecyclerModel recyclerModel = list.get(i);
                    int indexOf = HomeFeedPresenter.this.f45310b.indexOf(recyclerModel);
                    if (indexOf >= 0) {
                        HomeFeedPresenter.this.f45310b.set(indexOf, recyclerModel);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33639d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("C_Open_Window_Client_1_0");
        CustomerBrokerRpcManager.getInstance().batchGetActivityResource(arrayList, "10", "2", new CustomerRpcCallback<SplashEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
            }

            public void onRpcSuccess(SplashEntity splashEntity, long j) {
                if (splashEntity != null && !CollectionsUtil.isEmpty(splashEntity.getPointList()) && splashEntity.getPointList().get(0) != null && !CollectionsUtil.isEmpty(splashEntity.getPointList().get(0).getResourceList()) && splashEntity.getPointList().get(0).getResourceList().get(0) != null && !CollectionsUtil.isEmpty(splashEntity.getPointList().get(0).getResourceList().get(0).getMaterialList()) && splashEntity.getPointList().get(0).getResourceList().get(0).getMaterialList().get(0) != null && !TextUtils.isEmpty(splashEntity.getPointList().get(0).getResourceList().get(0).getMaterialList().get(0).getMaterialValue().getImageUrl())) {
                    new SplashResourceStorage().setData(splashEntity);
                    FlyImageLoader.loadImageUnspecified(HomeFeedPresenter.this.getScopeContext(), splashEntity.getPointList().get(0).getResourceList().get(0).getMaterialList().get(0).getMaterialValue().getImageUrl()).diskCacheStrategy(FlyImageLoader.DATA).downloadOnly((ImageDownloadListener) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33642e() {
        String str;
        try {
            String[] split = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag().split("-");
            if (split.length > 0) {
                str = split[1];
            } else {
                str = "";
            }
            LocalizationService instance = LocalizationService.getInstance();
            Context context = GlobalContext.getContext();
            String currentLocaleTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag();
            instance.init(context, currentLocaleTag, str, LocationUtil.getCityId() + "");
        } catch (Exception e) {
            RecordTracker.Builder.create().setTag(getScopeContext() != null ? getScopeContext().alias() : "homePage").setLogModule("m-home|").setMessage(e.getMessage()).setLogCategory("c-app|").build().info();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33604a(final int i, boolean z, HomeTypeContract.HomeLoadingType homeLoadingType) {
        if (z) {
            ((HomeFeedParam) getDataSource().getPageParams()).reset();
        }
        ((Contract.AbsHomeFeedView) getLogicView()).showLoadingByType(homeLoadingType);
        getDataSource().loadInit(new Function1<HomeFeedParam, Unit>() {
            public Unit invoke(HomeFeedParam homeFeedParam) {
                homeFeedParam.setScene(i);
                return Unit.INSTANCE;
            }
        });
        HomeOmegaHelper.getInstance().reset();
        HomeOmegaHelper.getInstance().trackBeginRequest(i, CustomerSystemUtil.isGpsEnabled(getContext()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33620a(boolean z) {
        ((Contract.AbsHomeFeedView) getLogicView()).resetHeaderView(z);
        if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
            ((HomeFeedParam) getDataSource().getPageParams()).setIsFilter(false);
        }
    }

    /* renamed from: f */
    private void m33645f() {
        this.f45310b.clear();
    }

    /* renamed from: g */
    private int m33647g() {
        int find = getDataSource().find($$Lambda$HomeFeedPresenter$ueqjUMdVQpZmQmuiFjJ1pPQcBM.INSTANCE);
        return find < 0 ? find : find + 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ boolean m33646f(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterRvModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ boolean m33643e(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterRvModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public int m33649h() {
        return getDataSource().find($$Lambda$HomeFeedPresenter$yfi29DM6HdULKPpN08U9AEoWi8.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ boolean m33640d(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof HomeNoResultRvModel;
    }

    /* renamed from: i */
    private boolean m33651i() {
        return getDataSource().find($$Lambda$HomeFeedPresenter$u7Fb1ArhWPRFnD4FeFKS23hTs.INSTANCE) >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33633b(boolean z) {
        if (z) {
            if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
                ((Contract.AbsHomeFeedView) getLogicView()).scrollToFloatingState(-1, false);
            }
            if (this.f45310b.indexOf(this.f45315g) >= 0) {
                showFooterBottomStubView(1);
                return;
            }
            return;
        }
        boolean z2 = ((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() == 0 && m33651i();
        if (((HomeFeedParam) getDataSource().getPageParams()).isFilter() || z2) {
            if (z2) {
                ((Contract.AbsHomeFeedView) getLogicView()).showFooterEmptyView();
                showFooterBottomStubView(1);
            }
            if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
                ((HomeFeedParam) getDataSource().getPageParams()).setIsFilter(false);
                ((Contract.AbsHomeFeedView) getLogicView()).scrollToFloatingState(m33647g(), z2);
                return;
            }
            return;
        }
        ((Contract.AbsHomeFeedView) getLogicView()).fillRecyclerViewContentHeight(((HomeFeedParam) getDataSource().getPageParams()).getHasMore());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33603a(int i, String str) {
        if (((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() > 0) {
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                ((Contract.AbsHomeFeedView) getLogicView()).showFooterErrorView();
            } else {
                ((Contract.AbsHomeFeedView) getLogicView()).showFooterNoNetView();
            }
            HomeLogTrackerHelper.setLogTracker("showDefaultError -> showFooterErrorView", "c-data|");
            return;
        }
        m33626b(i, str);
        m33633b(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ boolean m33637c(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterModel;
    }

    /* renamed from: j */
    private Boolean m33652j() {
        return Boolean.valueOf(getDataSource().contains($$Lambda$HomeFeedPresenter$FfiaO71tTjCfGyNwQvfMtE9AEnk.INSTANCE));
    }

    /* renamed from: b */
    private void m33626b(int i, String str) {
        if (m33653k()) {
            ((Contract.AbsHomeFeedView) getLogicView()).showNetErrorToast();
            HomeLogTrackerHelper.setLogTracker("updateErrorState -> Network error toast", "c-data|");
            return;
        }
        ((Contract.AbsHomeFeedView) getLogicView()).showFooterEmptyView();
        m33645f();
        FilterRvModel filterRvModel = new FilterRvModel();
        filterRvModel.setFilterManager(FilterDataManager.Companion.getInstanceByScene(1));
        this.f45310b.add(filterRvModel);
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        this.f45315g = topGunAbnormalRvModel;
        topGunAbnormalRvModel.mHeight = Math.max(((Contract.AbsHomeFeedView) getLogicView()).calculateAbnormalViewHeight(m33652j().booleanValue()), DisplayUtils.dip2px(getContext(), 260.0f));
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            TopGunAbnormalViewModel buildHomeNoService = TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeFeedPresenter.this.m33627b(view);
                }
            });
            HomeLogTrackerHelper.setLogTracker("updateErrorState -> No Service", "c-data|");
            this.f45315g.setAbnormalVm(buildHomeNoService);
            this.f45310b.add(this.f45315g);
            return;
        }
        this.f45315g.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeFeedPresenter.this.m33605a(view);
            }
        }));
        this.f45310b.add(this.f45315g);
        HomeLogTrackerHelper.setLogTracker("updateErrorState -> Network error rv binder", "c-data|");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33627b(View view) {
        m33604a(((HomeFeedParam) getDataSource().getPageParams()).getScene(), false, HomeTypeContract.HomeLoadingType.LOADING_SHIMMER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33605a(View view) {
        m33604a(((HomeFeedParam) getDataSource().getPageParams()).getScene(), false, HomeTypeContract.HomeLoadingType.LOADING_SHIMMER);
    }

    /* renamed from: k */
    private boolean m33653k() {
        return !NetWorkUtils.isNetworkConnected(getContext()) && this.f45320l.isOriginalFilter() && ((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() == 0 && !CollectionsUtil.isEmpty(getDataSource().getTargetList()) && !m33651i();
    }

    /* renamed from: l */
    private void m33654l() {
        if (this.f45318j) {
            ((PromoCodeRepo) RepoFactory.getRepo(PromoCodeRepo.class)).fetchHomePopInfo();
            HomeLogTrackerHelper.setLogTracker("fetchHomePopInfo", "c-data|");
        }
    }

    /* renamed from: m */
    private void m33655m() {
        this.f45318j = true;
        if (System.currentTimeMillis() - this.f45317i >= ((long) (CustomerApolloUtil.naPopDialogInterval() * 60000))) {
            this.f45317i = System.currentTimeMillis();
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 1;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
            m33656n();
        }
    }

    /* renamed from: n */
    private void m33656n() {
        if (!TextUtils.isEmpty(LocationUtil.getPoiId())) {
            this.f45318j = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ boolean m33634b(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterRvModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m33657o() {
        getDataSource().update($$Lambda$HomeFeedPresenter$aACgrE6vUaKIhwYfMSjzsKLa1Ww.INSTANCE, $$Lambda$HomeFeedPresenter$XmPINIyHgz1tRlegEy80zFpu0X4.INSTANCE);
    }

    /* renamed from: p */
    private void m33658p() {
        this.f45316h = ((HomePolicyUpdateRepo) RepoFactory.getRepo(HomePolicyUpdateRepo.class)).subscribePolicyUpdateConfirmTime(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HomeFeedPresenter.this.m33619a((Long) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33619a(Long l) {
        CustomerDialogShownManager.Companion.getInstance().checkLocationSettingDialog(getContext(), getScopeContext());
        HomePolicyHelper homePolicyHelper = this.f45314f;
        if (homePolicyHelper != null) {
            homePolicyHelper.savePolicyUpdateState();
        }
        Subscription subscription = this.f45316h;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    /* renamed from: q */
    private void m33659q() {
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).subscribe(getScopeContext(), new Action1<Integer>() {
            public void call(Integer num) {
                String a = HomeFeedPresenter.f45309a;
                LogUtil.m32584d(a, "refreshHomeing:" + num);
                if (2 == num.intValue() && HomeFeedPresenter.this.f45314f != null) {
                    HomeFeedPresenter.this.f45314f.savePolicyAcceptedState();
                }
                if (HomeFeedPresenter.this.m33621a(((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getCacheAddress())) {
                    LaunchAppTracker.Companion.clear();
                    PerformanceOmegaHelper.getInstance().reset();
                    return;
                }
                boolean z = false;
                HomeFeedPresenter.this.m33620a(false);
                if (num.intValue() != 2) {
                    z = true;
                }
                if (HomeTitleBarManager.getManager().isShow()) {
                    HomeFeedPresenter.this.m33604a(num.intValue(), z, HomeTypeContract.HomeLoadingType.LOADING_DIALOG);
                } else {
                    HomeFeedPresenter.this.m33604a(num.intValue(), z, HomeTypeContract.HomeLoadingType.LOADING_SHIMMER);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m33622a(HomeEntity homeEntity, Resource.Status status, int i) {
        if (ApiErrorConst.isAddressAbnormal(i)) {
            String str = f45309a;
            LogUtil.m32584d(str, "showAddressAbnormal:" + i);
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).showAddressAbnormal();
            getScopeContext().attach(Const.BundleKey.NO_ADDRESS_FROM_SERVICE, true);
            HomeOmegaHelper.getInstance().homeAddressNoneSW(true, AddressUtil.hasLocationPermission(), CustomerSystemUtil.isGpsEnabled(getContext()));
            return true;
        }
        if (!(homeEntity == null || homeEntity.getMAddrEntity() == null || homeEntity.getMAddrEntity().getMAddressInfo() == null || AddressUtil.checkAddressValid(homeEntity.getMAddrEntity().getMAddressInfo().address))) {
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_ADDRESS_POI_NOT_VALID).addModuleName("address").addErrorType("invalid").build().trackError();
        }
        if (homeEntity == null || homeEntity.getMAddrEntity() == null || homeEntity.getMAddrEntity().getMAddressInfo() == null || !AddressUtil.checkAddressValid(homeEntity.getMAddrEntity().getMAddressInfo().address)) {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress((AddressEntity) null, false, 0);
            return false;
        }
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).hideAddressAbnormal();
        m33608a(homeEntity.getMAddrEntity().getMAddressInfo());
        if (status == Resource.Status.SUCCESS) {
            m33606a(homeEntity.getMAddrEntity().getMAddressInfo().tipInfo);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33628b(HomeEntity homeEntity) {
        if (homeEntity != null && homeEntity.getMAddrEntity() != null && homeEntity.getMAddrEntity().getMAddressListInfo() != null && homeEntity.getMAddrEntity().getMAddressListInfo().deliveryAddress != null) {
            DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 5).putSerializable("entity", homeEntity.getMAddrEntity().getMAddressListInfo()).open();
        }
    }

    /* renamed from: a */
    private void m33608a(HomeAddressEntity homeAddressEntity) {
        String str = f45309a;
        LogUtil.m32584d(str, "updateAddress:" + homeAddressEntity.address);
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(homeAddressEntity.address, false, 0);
        HashMap hashMap = new HashMap();
        hashMap.put(Const.H5Params.POIID, homeAddressEntity.address.poi.poiId);
        HomeLogTrackerHelper.setLogTracker("updateAddress", "c-data|", hashMap);
        m33654l();
    }

    /* renamed from: a */
    private void m33606a(AddressTipInfo addressTipInfo) {
        if (((HomeFeedParam) getDataSource().getPageParams()).getScene() != 5 || (addressTipInfo != null && !TextUtils.isEmpty(addressTipInfo.mTip))) {
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setAddressTip(addressTipInfo);
        }
    }

    /* renamed from: r */
    private void m33660r() {
        LogUtil.m32588i(f45309a, "AddressTipRepo subscribe");
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressTip(getScopeContext(), new Action1<AddressTipInfo>() {
            public void call(AddressTipInfo addressTipInfo) {
                LogUtil.m32588i(HomeFeedPresenter.f45309a, "AddressTipRepo call");
                ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).updateAddressTip(addressTipInfo);
            }
        });
    }

    /* renamed from: s */
    private void m33661s() {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).subscribe(getScopeContext(), new Action1<CustomerResource<List<OrderInfoEntity>>>() {
            public void call(CustomerResource<List<OrderInfoEntity>> customerResource) {
                if (!RepoHelper.checkDataValid(customerResource)) {
                    LogUtil.m32588i(HomeFeedPresenter.f45309a, "OrderStatusRepo call:null");
                    return;
                }
                HomeOrderCardRvModel convertHomeOrderStatus = HomeOrderCardRvModel.convertHomeOrderStatus((List) customerResource.data, ((List) customerResource.data).size());
                $$Lambda$HomeFeedPresenter$11$BKH5eIuXiGkIwJhUjHOYyUoF6Yo r0 = $$Lambda$HomeFeedPresenter$11$BKH5eIuXiGkIwJhUjHOYyUoF6Yo.INSTANCE;
                if (convertHomeOrderStatus == null) {
                    LogUtil.m32588i(HomeFeedPresenter.f45309a, "OrderStatusRepo call: remove");
                    HomeFeedPresenter.this.getDataSource().remove(r0);
                } else if (!CollectionsUtil.isEmpty(HomeFeedPresenter.this.getDataSource().getTargetList())) {
                    String a = HomeFeedPresenter.f45309a;
                    LogUtil.m32588i(a, "initOrderStatusRepo call:" + convertHomeOrderStatus.mTotalNum);
                    if (HomeFeedPresenter.this.getDataSource().contains(r0)) {
                        HomeFeedPresenter.this.getDataSource().update(r0, new UpdateUtils.UpdateCallback() {
                            public final void doUpdate(int i, Object obj) {
                                ((HomeOrderCardRvModel) ((RecyclerModel) obj)).setValue(HomeOrderCardRvModel.this);
                            }
                        });
                        return;
                    }
                    int f = HomeFeedPresenter.this.m33649h();
                    if (f >= 0) {
                        HomeFeedPresenter.this.getDataSource().insert(f + 1, (RecyclerModel) convertHomeOrderStatus);
                    }
                }
            }

            static /* synthetic */ boolean lambda$call$0(int i, RecyclerModel recyclerModel) {
                return recyclerModel instanceof HomeOrderCardRvModel;
            }
        });
    }

    /* renamed from: t */
    private void m33662t() {
        ((RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class)).subscribeClose($$Lambda$HomeFeedPresenter$qdNfVkU1yMlgd5oHaGvNr9nru4.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m33611a(RouterCloseRepo.CloseModel closeModel) {
        if (closeModel != null && (closeModel instanceof RouterCloseRepo.AllCateGoryPageCloseModel)) {
            RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = (RouterCloseRepo.AllCateGoryPageCloseModel) closeModel;
            if (!TextUtils.isEmpty(allCateGoryPageCloseModel.getFrom()) && allCateGoryPageCloseModel.getFrom().equals("homepage")) {
                UIHandler.post(new Runnable() {
                    public final void run() {
                        HomeFeedPresenter.m33629b(RouterCloseRepo.CloseModel.this);
                    }
                });
                ((RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class)).setValue((RouterCloseRepo.CloseModel) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m33629b(RouterCloseRepo.CloseModel closeModel) {
        Uri uri;
        try {
            uri = Uri.parse(((RouterCloseRepo.AllCateGoryPageCloseModel) closeModel).getUrl()).buildUpon().appendQueryParameter("recid", ((RouterCloseRepo.AllCateGoryPageCloseModel) closeModel).getRecId()).appendQueryParameter(Const.PageParams.KEY_CATE_ID, ((RouterCloseRepo.AllCateGoryPageCloseModel) closeModel).getCateId()).build();
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        if (uri != null) {
            SchemeHelper.dispatchMsg(uri, "dynamic", "", false);
            return;
        }
        RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = (RouterCloseRepo.AllCateGoryPageCloseModel) closeModel;
        DiRouter.request().path(RoutePath.SHOP_CATEGORY_LANDING_PAGE).putString("recid", allCateGoryPageCloseModel.getRecId()).putString(Const.PageParams.KEY_CATE_ID, allCateGoryPageCloseModel.getCateId()).open();
    }

    /* renamed from: u */
    private void m33663u() {
        this.f45320l.setOnFilterEvent(new OnFilterEvent() {
            public void onConfirm(FilterDataManager filterDataManager) {
                HomeFeedPresenter.this.m33657o();
                ((Contract.AbsHomeFeedView) HomeFeedPresenter.this.getLogicView()).intoFloating();
                ((HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams()).updateFilterParam(GsonUtil.toJson(filterDataManager.generateOutParams()));
                ((HomeFeedParam) HomeFeedPresenter.this.getDataSource().getPageParams()).setIsFilter(true);
                HomeFeedPresenter.this.m33604a(5, false, HomeTypeContract.HomeLoadingType.LOADING_FILTER_SHIMMER);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m33621a(AddressEntity addressEntity) {
        if ((!AddressUtil.hasLocationPermission() || !LocationUtil.hasValidLocation()) && !AddressUtil.checkAddressValid(addressEntity)) {
            LogUtil.m32588i(f45309a, "no locate no cache showAddressAbnormal");
            ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).showAddressAbnormal();
            getScopeContext().attach(Const.BundleKey.NO_ADDRESS_FROM_SERVICE, false);
            HomeOmegaHelper.getInstance().homeAddressNoneSW(false, AddressUtil.hasLocationPermission(), CustomerSystemUtil.isGpsEnabled(getContext()));
            return true;
        }
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).hideAddressAbnormal();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33607a(NoMoreLoginEntity noMoreLoginEntity) {
        boolean hasMore = ((HomeFeedParam) getDataSource().getPageParams()).getHasMore();
        getLoadMoreModel().loginEntity = noMoreLoginEntity;
        if (hasMore) {
            ((Contract.AbsHomeFeedView) getLogicView()).showFooterEmptyView();
        } else if (!LoginUtil.isLogin()) {
            ((Contract.AbsHomeFeedView) getLogicView()).showFooteSignInView();
        } else {
            ((Contract.AbsHomeFeedView) getLogicView()).showFooterNoMoreView();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("hasMore", hasMore ? "1" : "0");
        HomeLogTrackerHelper.setLogTracker("updatePageMoreState", "c-data|", hashMap);
    }

    /* renamed from: v */
    private void m33664v() {
        this.f45313e = DialogUtil.getScopeDialogInstrument(getScopeContext());
        HomePolicyHelper updatePolicyConfig = HomePolicyHelper.getInstance().updatePolicyConfig(this.f45313e, GlobalContext.isSuperApp() ? 2 : 1);
        this.f45314f = updatePolicyConfig;
        updatePolicyConfig.setOnPolicyDialogClickListener(new HomePolicyHelper.OnPolicyDialogClickListener() {
            public void confirmListener() {
                CustomerDialogShownManager.Companion.getInstance().checkLocationSettingDialog(HomeFeedPresenter.this.getContext(), HomeFeedPresenter.this.getScopeContext());
                HomeFeedPresenter.this.f45319k.setShowPolicyDialog(false);
                HomeFeedPresenter.this.f45319k.openPolicyInterruptRoute();
            }
        });
        this.f45314f.setOnShowPolicyUpdateDialogListener(new HomePolicyHelper.OnShowPolicyUpdateDialogListener() {
            public void onAction() {
                HomeFeedPresenter.this.getScopeContext().getNavigator().pushForResult((PolicyUpdatePage) PageFactory.newInstance(PolicyUpdatePage.class, (Bundle) null));
            }
        });
        boolean needShowPolicyDialog = this.f45314f.needShowPolicyDialog();
        this.f45319k.setShowPolicyDialog(needShowPolicyDialog);
        if (!needShowPolicyDialog) {
            CustomerDialogShownManager.Companion.getInstance().checkLocationSettingDialog(getContext(), getScopeContext());
        } else {
            CustomerDialogShownManager.Companion.getInstance().setCurrentShowDialogType(1);
        }
    }
}
