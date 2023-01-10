package com.didi.soda.home.topgun.component.topic;

import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.topgun.component.topic.Contract;
import com.didi.soda.home.topgun.component.topic.data.HomeTopicDataSource;
import com.didi.soda.home.topgun.component.topic.data.HomeTopicOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.taxis99.R;
import java.util.List;

public class HomeTopicFeedPresenter extends Contract.AbsHomeTopicFeedPresenter {

    /* renamed from: a */
    private static final String f45381a = "HomeTopicFeedPresenter";

    /* renamed from: b */
    private Contract.AbsHomeTopicFeedView f45382b;

    /* renamed from: c */
    private HomeTopicDataSource f45383c;

    /* renamed from: d */
    private ChildDataListManager<RecyclerModel> f45384d;

    public void initDataManagers() {
        super.initDataManagers();
        m33727d();
    }

    public void onCreate() {
        super.onCreate();
        this.f45382b = (Contract.AbsHomeTopicFeedView) getLogicView();
        m33719a();
        HomeTopicOmegaHelper.getInstance().attach(getScopeContext());
        m33718a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "c-state|").build().info();
    }

    public void onDestroy() {
        super.onDestroy();
        HomeTopicOmegaHelper.getInstance().detach(getScopeContext());
        m33718a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "c-state|").build().info();
    }

    public void onFooterErrorClicked() {
        this.f45383c.loadNextPage();
    }

    public void onFooterSignInClicked() {
        if (!LoginUtil.isLogin()) {
            LoginUtil.loginActivityAndTrack(getContext(), 1);
        }
    }

    public void onLoadMore() {
        if (this.f45383c.hasMore() && !((Contract.AbsHomeTopicFeedView) getLogicView()).needBlockFooterLoading()) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterLoadingView();
            this.f45383c.loadNextPage();
            m33718a("onLoadMore", "c-act|").build().info();
        }
    }

    public void onStart() {
        super.onStart();
        OmegaCommonParamHelper.refreshLv1GuideParam();
        m33718a("onStart", "c-state|").build().info();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        m33718a("onStop", "c-state|").build().info();
    }

    /* access modifiers changed from: package-private */
    public void onClickBack() {
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName")).build().track();
    }

    /* renamed from: a */
    private void m33719a() {
        this.f45382b.updateTitle(getScopeContext().getBundle().getString(Const.PageParams.HOME_COMPONENT_TITLE, ""));
        m33724b();
    }

    /* renamed from: b */
    private void m33724b() {
        HomeTopicDataSource homeTopicDataSource = new HomeTopicDataSource(getScopeContext(), getScopeContext().getBundle().getString(Const.PageParams.HOME_COMPONENT_ID));
        this.f45383c = homeTopicDataSource;
        homeTopicDataSource.subscribeListChanged(new Action1() {
            public final void call(Object obj) {
                HomeTopicFeedPresenter.this.m33723a((List) obj);
            }
        });
        this.f45383c.subscribePageResult(new Action1() {
            public final void call(Object obj) {
                HomeTopicFeedPresenter.this.m33721a((CustomerResource) obj);
            }
        });
        m33726c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33723a(List list) {
        if (CollectionsUtil.isEmpty(list)) {
            m33722a(getContext().getResources().getString(R.string.customer_service_not_connected));
            return;
        }
        this.f45384d.set(list);
        m33729f();
        if (this.f45383c.getPageIndex() == 0) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).scrollToTop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33721a(CustomerResource customerResource) {
        this.f45382b.dismissLoadingDialog();
        this.f45382b.dismissPullToRefresh();
        if (customerResource == null || customerResource.status == Resource.Status.ERROR || customerResource.data == null) {
            HomeTopicOmegaHelper.getInstance().trackHomeTopicFeedShow((HomeFeedEntity) null, ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress(), "");
            String string = getContext().getResources().getString(R.string.customer_service_not_connected);
            if (customerResource != null && !TextUtils.isEmpty(customerResource.message) && !customerResource.message.contains(StringConst.JAVA)) {
                string = customerResource.message;
            }
            m33722a(string);
            return;
        }
        HomeTopicOmegaHelper.getInstance().trackHomeTopicFeedShow((HomeFeedEntity) customerResource.data, ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress(), ((HomeFeedEntity) customerResource.data).mRecId);
    }

    /* renamed from: a */
    private void m33722a(String str) {
        ((Contract.AbsHomeTopicFeedView) getLogicView()).dismissLoadingDialog();
        this.f45382b.showFooterEmptyView();
        if (this.f45383c.getPageIndex() > 0) {
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterErrorView();
            } else {
                ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterNoNetView();
            }
            m33718a("updateErrorState -> Footer Error", "c-data|").build().error();
        } else if (NetWorkUtils.isNetworkConnected(getContext())) {
            m33728e();
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = ((Contract.AbsHomeTopicFeedView) getLogicView()).calculateAbnormalHeight();
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeTopicFeedPresenter.this.m33725b(view);
                }
            }));
            this.f45384d.add(topGunAbnormalRvModel);
            m33718a("updateErrorState -> Network", "c-data|").build().error();
        } else if (CollectionsUtil.isEmpty(this.f45383c.getTargetList())) {
            m33728e();
            TopGunAbnormalRvModel topGunAbnormalRvModel2 = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel2.mHeight = ((Contract.AbsHomeTopicFeedView) getLogicView()).calculateAbnormalHeight();
            topGunAbnormalRvModel2.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeTopicFeedPresenter.this.m33720a(view);
                }
            }));
            this.f45384d.add(topGunAbnormalRvModel2);
            m33718a("updateErrorState -> Service No Cache", "c-data|").build().error();
        } else {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showNetErrorToast();
            m33718a("updateErrorState -> Service Use Cache", "c-data|").build().error();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33725b(View view) {
        m33726c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33720a(View view) {
        m33726c();
    }

    /* renamed from: c */
    private void m33726c() {
        ((Contract.AbsHomeTopicFeedView) getLogicView()).showLoadingView();
        this.f45383c.loadInit();
    }

    /* renamed from: d */
    private void m33727d() {
        if (this.f45384d == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f45384d = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* renamed from: e */
    private void m33728e() {
        this.f45384d.clear();
    }

    /* renamed from: f */
    private void m33729f() {
        if (this.f45383c.hasMore()) {
            this.f45382b.showFooterEmptyView();
        } else if (!LoginUtil.isLogin()) {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooteSignInView();
        } else {
            ((Contract.AbsHomeTopicFeedView) getLogicView()).showFooterNoMoreView();
        }
        m33718a("updatePageMoreState", "c-data|").setOtherParam("hasMore", this.f45383c.hasMore() ? "1" : "0").build().info();
    }

    /* renamed from: a */
    private RecordTracker.Builder m33718a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f45381a).setLogModule("m-home|").setMessage(str).setLogCategory(str2);
    }
}
