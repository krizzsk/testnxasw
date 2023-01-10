package com.didi.soda.home.component.category.landing;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.GroceryHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.page.DataSource;
import com.didi.soda.datasource.page.PageParams;
import com.didi.soda.datasource.page.dynamic.DynamicDataSource;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.binder.CateLandingComponentLogicUnit;
import com.didi.soda.home.component.category.landing.Contract;
import com.didi.soda.home.manager.RouterCloseRepo;
import com.didi.soda.home.manager.ShopCategoryLandingRepo;
import com.didi.soda.home.page.FilterPageKt;
import com.didi.soda.home.topgun.binder.model.FilterRvModel;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.FilterHelper;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.router.DiRouter;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u001f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\u0019H\u0014J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107J\b\u00108\u001a\u00020\u0019H\u0014J\b\u00109\u001a\u00020\u0019H\u0016J\b\u0010:\u001a\u00020\u0019H\u0014J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u0019H\u0002J\b\u0010>\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020\u0019H\u0002J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u0018\u0010C\u001a\u00020\u00192\u0006\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u0004H\u0002J\b\u0010D\u001a\u00020\u0019H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, mo148868d2 = {"Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter;", "Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingPresenter;", "()V", "TAG", "", "mAbnormalRvModel", "Lcom/didi/soda/customer/binder/abnormal/topgun/TopGunAbnormalRvModel;", "mCategoryId", "mCategoryListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "mComponentLogicUnit", "Lcom/didi/soda/home/binder/CateLandingComponentLogicUnit;", "mFilterHelper", "Lcom/didi/soda/home/topgun/component/filter/FilterHelper;", "mRecId", "subscription", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "createDataSource", "Lcom/didi/soda/datasource/page/dynamic/DynamicDataSource;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "doRefresh", "", "cateId", "refreshType", "Lcom/didi/soda/home/component/category/landing/ShopCategoryLoadingType;", "floatToAnchorState", "isErrorState", "", "getAnchorIndex", "", "go2Search", "initCateGoryAllRepo", "initDataManagers", "initFilterEvent", "initParams", "initShopCateDataSource", "isFilterNone", "isOriginDataNoNet", "loadInit", "isPullDown", "notifyFilterItemClick", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "isFloating", "onCreate", "onDestroy", "onFooterErrorClicked", "onFooterSignInClicked", "onLoadMore", "onPageResult", "data", "Landroid/os/Bundle;", "onPause", "onPullToRefresh", "onResume", "provideComponentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "resetDataManager", "resetFilter", "resetFilterState", "showDefaultError", "errorCode", "errorMsg", "updateErrorState", "updateFilter", "updatePageMoreState", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class ShopCategoryLandingPresenter extends Contract.AbsShopCategoryLandingPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f45041a = "ShopCategoryLandingPresenter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ChildDataListManager<RecyclerModel> f45042b;

    /* renamed from: c */
    private final CateLandingComponentLogicUnit f45043c = new CateLandingComponentLogicUnit(this);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f45044d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f45045e;

    /* renamed from: f */
    private TopGunAbnormalRvModel f45046f;

    /* renamed from: g */
    private final FilterHelper f45047g = new FilterHelper(2);

    /* renamed from: h */
    private Subscription f45048h;

    public final void onPageResult(Bundle bundle) {
        if (bundle != null && bundle.getBoolean(FilterPageKt.KEY_FILTER_CONFIRM)) {
            this.f45047g.doConfirmFromFilterPage(bundle.getBoolean(FilterPageKt.KEY_FILTER_IS_RESET, false));
        }
    }

    public void onCreate() {
        super.onCreate();
        ShopCateLandingOmegaHelper.getInstance().attach(getScopeContext());
        m33386a();
        m33403f();
        m33395b();
        m33393a(false, ShopCategoryLoadingType.SHIMMER);
        m33402e();
        String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
        IBlockScope scope = getScope();
        if (appInstanceID == null) {
            appInstanceID = "";
        }
        scope.attach("googleInstanceId", appInstanceID);
        getScope().attach(BlocksConst.BLOCK_PARAM_ROUTE_PATH, RoutePath.SHOP_CATEGORY_LANDING_PAGE);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f45047g.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f45047g.onPause();
    }

    /* renamed from: a */
    private final void m33386a() {
        String str;
        String string;
        Bundle bundle = getScopeContext().getBundle();
        String str2 = "";
        if (bundle == null || (str = bundle.getString("recid")) == null) {
            str = str2;
        }
        this.f45044d = str;
        Bundle bundle2 = getScopeContext().getBundle();
        if (!(bundle2 == null || (string = bundle2.getString(Const.PageParams.KEY_CATE_ID)) == null)) {
            str2 = string;
        }
        this.f45045e = str2;
    }

    /* renamed from: b */
    private final void m33395b() {
        this.f45047g.setOnFilterEvent(new ShopCategoryLandingPresenter$initFilterEvent$1(this));
    }

    /* renamed from: c */
    private final void m33399c() {
        if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
            ((HomeFeedParam) getDataSource().getPageParams()).setIsFilter(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m33394a(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterRvModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m33401d() {
        getDataSource().update(C14718x296d5f0e.INSTANCE, C14717x5d095009.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33396b(int i, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(recyclerModel, "recyclerModel");
        ((FilterRvModel) recyclerModel).setHasAnim(true);
    }

    /* renamed from: e */
    private final void m33402e() {
        this.f45048h = ((RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class)).subscribeClose(new Action1() {
            public final void call(Object obj) {
                ShopCategoryLandingPresenter.m33389a(ShopCategoryLandingPresenter.this, (RouterCloseRepo.CloseModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33389a(ShopCategoryLandingPresenter shopCategoryLandingPresenter, RouterCloseRepo.CloseModel closeModel) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "this$0");
        if (closeModel != null && (closeModel instanceof RouterCloseRepo.AllCateGoryPageCloseModel)) {
            RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = (RouterCloseRepo.AllCateGoryPageCloseModel) closeModel;
            String from = allCateGoryPageCloseModel.getFrom();
            if (from == null) {
                from = "";
            }
            if (!Intrinsics.areEqual((Object) from, (Object) Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE)) {
                String from2 = allCateGoryPageCloseModel.getFrom();
                boolean z = true;
                if (from2 == null || !StringsKt.contains$default((CharSequence) from2, (CharSequence) RoutePath.SHOP_CATEGORY_LANDING_PAGE, false, 2, (Object) null)) {
                    z = false;
                }
                if (!z) {
                    return;
                }
            }
            UIHandler.post(new Runnable(shopCategoryLandingPresenter) {
                public final /* synthetic */ ShopCategoryLandingPresenter f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ShopCategoryLandingPresenter.m33391a(RouterCloseRepo.CloseModel.this, this.f$1);
                }
            });
            ((RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class)).setValue((RouterCloseRepo.CloseModel) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33391a(RouterCloseRepo.CloseModel closeModel, ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "this$0");
        RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = (RouterCloseRepo.AllCateGoryPageCloseModel) closeModel;
        if (GroceryHelper.Companion.isGrocery(Integer.valueOf(GroceryHelper.Companion.getBusinessType(allCateGoryPageCloseModel.getUrl())))) {
            GroceryHelper.Companion.openGrocery(allCateGoryPageCloseModel.getUrl());
        } else {
            shopCategoryLandingPresenter.doRefresh(allCateGoryPageCloseModel.getCateId(), ShopCategoryLoadingType.SHIMMER);
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager<RecyclerModel>()");
        this.f45042b = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            createChildDataListManager = null;
        }
        addDataManager(createChildDataListManager);
    }

    public void onPullToRefresh() {
        m33399c();
        m33390a(this, true, (ShopCategoryLoadingType) null, 2, (Object) null);
        LogUtil.m32588i(String.valueOf(this.f45041a), "onPullToRefresh");
    }

    public void onFooterErrorClicked() {
        DynamicDataSource dataSource = getDataSource();
        Intrinsics.checkNotNullExpressionValue(dataSource, "dataSource");
        DataSource.loadNextPage$default(dataSource, (Function1) null, 1, (Object) null);
    }

    public void onFooterSignInClicked() {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(getContext(), 1);
        }
    }

    public void onLoadMore() {
        if (((HomeFeedParam) getDataSource().getPageParams()).getHasMore() && !((Contract.AbsShopCategoryLandingView) getLogicView()).needBlockFooterLoading()) {
            ChildDataListManager<RecyclerModel> childDataListManager = this.f45042b;
            if (childDataListManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
                childDataListManager = null;
            }
            if (childDataListManager.indexOf(this.f45046f) < 0) {
                ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterLoadingView();
                DynamicDataSource dataSource = getDataSource();
                Intrinsics.checkNotNullExpressionValue(dataSource, "dataSource");
                DataSource.loadNextPage$default(dataSource, (Function1) null, 1, (Object) null);
                LogUtil.m32588i(String.valueOf(this.f45041a), "onLoadMore");
            }
        }
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        return this.f45043c;
    }

    public void notifyFilterItemClick(FilterModel filterModel, boolean z) {
        if (filterModel != null) {
            FilterHelper filterHelper = this.f45047g;
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            filterHelper.clickItem(filterModel, scopeContext);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((Contract.AbsShopCategoryLandingView) getLogicView()).hideLoadingOrShimmer();
        ((Contract.AbsShopCategoryLandingView) getLogicView()).dismissPullToRefresh();
        ShopCateLandingOmegaHelper.getInstance().detach(getScopeContext());
        RepoFactory.clearRepo(ShopCategoryLandingRepo.class);
        Subscription subscription = this.f45048h;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        clearDataManagers();
        LogUtil.m32588i(String.valueOf(this.f45041a), NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    public DynamicDataSource<HomeFeedParam, HomeEntity> createDataSource(ScopeContext scopeContext) {
        Intrinsics.checkNotNull(scopeContext);
        C14720x2aac12c r1 = new PayloadProvider() {
            public final Object providePayload() {
                return ShopCategoryLandingPresenter.m33385a(ShopCategoryLandingPresenter.this);
            }
        };
        IBlockScope scope = getScope();
        Intrinsics.checkNotNullExpressionValue(scope, "scope");
        return new ShopCategoryLandingDataSource(scopeContext, r1, scope);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final FeedPayload m33385a(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "this$0");
        HomeFeedParam homeFeedParam = new HomeFeedParam();
        if (!(shopCategoryLandingPresenter.getDataSource() == null || shopCategoryLandingPresenter.getDataSource().getPageParams() == null)) {
            PageParams pageParams = shopCategoryLandingPresenter.getDataSource().getPageParams();
            Intrinsics.checkNotNullExpressionValue(pageParams, "dataSource.getPageParams()");
            homeFeedParam = (HomeFeedParam) pageParams;
        }
        shopCategoryLandingPresenter.f45044d = homeFeedParam.getRecId();
        FeedPayload feedPayload = new FeedPayload();
        feedPayload.mPageId = Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE;
        feedPayload.mPageFilter = homeFeedParam.getFilterParam();
        feedPayload.mRecId = homeFeedParam.getRecId();
        feedPayload.mTraceId = homeFeedParam.getTraceId();
        feedPayload.mCateId = shopCategoryLandingPresenter.f45045e;
        return feedPayload;
    }

    /* renamed from: f */
    private final void m33403f() {
        getDataSource().subscribeListChanged(new ShopCategoryLandingPresenter$initShopCateDataSource$1(this));
        getDataSource().subscribeListUpdate(new ShopCategoryLandingPresenter$initShopCateDataSource$2(this));
        getDataSource().setOnDataSourceListener(new C14723x22c39891(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33392a(boolean z) {
        if (!z) {
            boolean z2 = ((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() == 0 && m33406i();
            if (!((HomeFeedParam) getDataSource().getPageParams()).isFilter() && !z2) {
                ((Contract.AbsShopCategoryLandingView) getLogicView()).fillRecyclerViewContentHeight(((HomeFeedParam) getDataSource().getPageParams()).getHasMore());
            } else if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
                ((HomeFeedParam) getDataSource().getPageParams()).setIsFilter(false);
                ((Contract.AbsShopCategoryLandingView) getLogicView()).scrollToFloatingState(m33404g(), z2);
            }
        } else if (((HomeFeedParam) getDataSource().getPageParams()).isFilter()) {
            ((Contract.AbsShopCategoryLandingView) getLogicView()).scrollToFloatingState(-1, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final boolean m33400c(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof FilterRvModel;
    }

    /* renamed from: g */
    private final int m33404g() {
        int find = getDataSource().find(C14715x89143a29.INSTANCE);
        return find < 0 ? find : find + 1;
    }

    /* renamed from: a */
    static /* synthetic */ void m33390a(ShopCategoryLandingPresenter shopCategoryLandingPresenter, boolean z, ShopCategoryLoadingType shopCategoryLoadingType, int i, Object obj) {
        if ((i & 2) != 0) {
            shopCategoryLoadingType = ShopCategoryLoadingType.SHIMMER;
        }
        shopCategoryLandingPresenter.m33393a(z, shopCategoryLoadingType);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33393a(boolean z, ShopCategoryLoadingType shopCategoryLoadingType) {
        if (!z) {
            ((Contract.AbsShopCategoryLandingView) getLogicView()).showLoadingOrShimmer(shopCategoryLoadingType);
        }
        getDataSource().loadInit(new ShopCategoryLandingPresenter$loadInit$1(this));
        ShopCateLandingOmegaHelper.getInstance().reset();
    }

    /* renamed from: h */
    private final void m33405h() {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45042b;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            childDataListManager = null;
        }
        childDataListManager.clear();
    }

    /* renamed from: i */
    private final boolean m33406i() {
        return getDataSource().find(new ShopCategoryLandingPresenter$isFilterNone$1()) >= 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m33387a(int i, String str) {
        if (((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() > 0) {
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterErrorView();
            } else {
                ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterNoNetView();
            }
            LogUtil.m32588i(this.f45041a, "showDefaultError -> showFooterErrorView");
            return;
        }
        m33397b(i, str);
        m33392a(true);
    }

    /* renamed from: b */
    private final void m33397b(int i, String str) {
        if (m33407j()) {
            ((Contract.AbsShopCategoryLandingView) getLogicView()).showNetErrorToast();
            LogUtil.m32588i(this.f45041a, "updateErrorState -> Network error toast");
            return;
        }
        ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterEmptyView();
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        this.f45046f = topGunAbnormalRvModel;
        if (topGunAbnormalRvModel != null) {
            topGunAbnormalRvModel.mHeight = -1;
        }
        m33405h();
        FilterRvModel filterRvModel = new FilterRvModel();
        filterRvModel.setFilterManager(FilterDataManager.Companion.getInstanceByScene(2));
        ChildDataListManager<RecyclerModel> childDataListManager = this.f45042b;
        ChildDataListManager<RecyclerModel> childDataListManager2 = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            childDataListManager = null;
        }
        childDataListManager.add(filterRvModel);
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            LogUtil.m32588i(this.f45041a, "updateErrorState -> No Service");
            TopGunAbnormalViewModel buildHomeNoService = TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    ShopCategoryLandingPresenter.m33388a(ShopCategoryLandingPresenter.this, view);
                }
            });
            LogUtil.m32588i(this.f45041a, "updateErrorState -> No Service");
            TopGunAbnormalRvModel topGunAbnormalRvModel2 = this.f45046f;
            if (topGunAbnormalRvModel2 != null) {
                topGunAbnormalRvModel2.setAbnormalVm(buildHomeNoService);
            }
            ChildDataListManager<RecyclerModel> childDataListManager3 = this.f45042b;
            if (childDataListManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            } else {
                childDataListManager2 = childDataListManager3;
            }
            childDataListManager2.add(this.f45046f);
            return;
        }
        LogUtil.m32588i(this.f45041a, "updateErrorState -> Network error rv binder");
        TopGunAbnormalRvModel topGunAbnormalRvModel3 = this.f45046f;
        if (topGunAbnormalRvModel3 != null) {
            topGunAbnormalRvModel3.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    ShopCategoryLandingPresenter.m33398b(ShopCategoryLandingPresenter.this, view);
                }
            }));
        }
        ChildDataListManager<RecyclerModel> childDataListManager4 = this.f45042b;
        if (childDataListManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
        } else {
            childDataListManager2 = childDataListManager4;
        }
        childDataListManager2.add(this.f45046f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33388a(ShopCategoryLandingPresenter shopCategoryLandingPresenter, View view) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "this$0");
        shopCategoryLandingPresenter.m33393a(false, ShopCategoryLoadingType.DOT_LOADING);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33398b(ShopCategoryLandingPresenter shopCategoryLandingPresenter, View view) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "this$0");
        shopCategoryLandingPresenter.m33393a(false, ShopCategoryLoadingType.DOT_LOADING);
    }

    /* renamed from: j */
    private final boolean m33407j() {
        return !NetWorkUtils.isNetworkConnected(getContext()) && this.f45047g.isOriginalFilter() && ((HomeFeedParam) getDataSource().getPageParams()).getPageIndex() == 0 && !CollectionsUtil.isEmpty(getDataSource().getTargetList()) && !m33406i();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final void m33408k() {
        if (((HomeFeedParam) getDataSource().getPageParams()).getHasMore() || m33406i()) {
            ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterEmptyView();
        } else {
            ((Contract.AbsShopCategoryLandingView) getLogicView()).showFooterNoMoreView();
        }
        LogUtil.m32588i(this.f45041a, "updatePageMoreState");
    }

    public void resetFilter() {
        FilterHelper filterHelper = this.f45047g;
        if (filterHelper != null) {
            filterHelper.reset();
        }
    }

    public void doRefresh(String str, ShopCategoryLoadingType shopCategoryLoadingType) {
        Intrinsics.checkNotNullParameter(shopCategoryLoadingType, "refreshType");
        if (str != null) {
            if (!Intrinsics.areEqual((Object) str, (Object) this.f45045e)) {
                this.f45045e = str;
            } else {
                return;
            }
        }
        m33393a(false, shopCategoryLoadingType);
    }

    public void go2Search() {
        ShopCateLandingOmegaHelper.getInstance().onSearchCk();
        DiRouter.request().path(RoutePath.SEARCH_HOME).putString("fromPage", RoutePath.SHOP_CATEGORY_LANDING_PAGE).open();
    }
}
