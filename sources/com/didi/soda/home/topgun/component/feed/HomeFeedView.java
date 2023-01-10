package com.didi.soda.home.topgun.component.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.binder.banner.BannerItemBinder;
import com.didi.soda.customer.component.feed.base.FooterViewIPresenter;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.feed.base.HeaderViewIView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.headerview.CustomerHeaderView;
import com.didi.soda.home.bub.HomeBubHelper;
import com.didi.soda.home.bub.TaskBubModel;
import com.didi.soda.home.component.feed.HomeTypeContract;
import com.didi.soda.home.kingkong.HomeKingKongBinder;
import com.didi.soda.home.kingkong.HomeKingKongItemAdapter;
import com.didi.soda.home.kingkong.KingKongItemModel;
import com.didi.soda.home.manager.CustomerGuideManager;
import com.didi.soda.home.manager.HomeRocketLaunchAnimManager;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.didi.soda.home.topgun.binder.FilterBinder;
import com.didi.soda.home.topgun.binder.HomeBusinessDividerBinder;
import com.didi.soda.home.topgun.binder.HomeBusinessItemNewBinder;
import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.binder.HomeNewHeaderBinder;
import com.didi.soda.home.topgun.binder.HomeOrderCardBinder;
import com.didi.soda.home.topgun.binder.HomeRecyclerBinder;
import com.didi.soda.home.topgun.binder.HomeSceneBinder;
import com.didi.soda.home.topgun.binder.HomeTaskCenterBinder;
import com.didi.soda.home.topgun.binder.HomeTopicBinder;
import com.didi.soda.home.topgun.component.feed.Contract;
import com.didi.soda.home.topgun.component.feed.HomeFeedView;
import com.didi.soda.home.topgun.component.feed.helper.HomeCalculateHeightUtil;
import com.didi.soda.home.topgun.component.feed.helper.HomeMiniCartHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.widget.FeedHeaderLayout;
import com.didi.soda.home.topgun.widget.HomeAddressTipView;
import com.didi.soda.home.topgun.widget.HomeComposeItemDecoration;
import com.didi.soda.home.topgun.widget.HomeHeaderShadowDecoration;
import com.didi.soda.home.topgun.widget.floatlayout.FloatLayout;
import com.didi.soda.home.topgun.widget.floatlayout.OnHeaderFloatCallback;
import com.taxis99.R;
import java.util.List;

public class HomeFeedView extends Contract.AbsHomeFeedView {

    /* renamed from: a */
    ShimmerRecyclerView f45321a;

    /* renamed from: b */
    private HomeMiniCartHelper f45322b;

    /* renamed from: c */
    private HomeBubHelper f45323c;

    /* renamed from: d */
    private CustomerHeaderView f45324d;
    @BindView(18169)
    FeedHeaderLayout mFeedHeaderLayout;
    @BindView(18273)
    FloatLayout mFloatLayout;
    @BindView(18175)
    HomeAddressTipView mHomeAddressTipView;
    @BindView(18166)
    FrameLayout mHomeFeedContainer;
    @BindView(18172)
    FrameLayout mHomeShimmerContainer;
    @BindView(18579)
    LinearLayout mHomeShimmerContainerParent;
    @BindView(18690)
    NovaRecyclerView mRecycleView;
    @BindView(18624)
    NovaPullRefreshLayout mRefreshLayout;

    public String footerViewNoMoreTxt() {
        if (LoginUtil.isLogin()) {
            return ResourceHelper.getString(R.string.customer_footer_show_no_more_shop);
        }
        return ResourceHelper.getString(R.string.customer_footer_load_to_login_see_more);
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }

    public NovaPullRefreshLayout generatePullToRefreshView() {
        return (NovaPullRefreshLayout) getView().findViewById(R.id.customer_prl_pull_refresh);
    }

    public HeaderViewIView.Mode headerViewMode() {
        return HeaderViewIView.Mode.ENABLED;
    }

    public IRefreshView generateHeaderView() {
        CustomerHeaderView customerHeaderView = (CustomerHeaderView) super.generateHeaderView();
        this.f45324d = customerHeaderView;
        customerHeaderView.changeStyle(CustomerHeaderView.HeaderStyle.GRAY);
        return this.f45324d;
    }

    public void changeHeaderStyle(boolean z) {
        CustomerHeaderView customerHeaderView;
        if (!z || (customerHeaderView = this.f45324d) == null) {
            this.f45324d.changeStyle(CustomerHeaderView.HeaderStyle.TRANSPARENT_ORANGE_LOADING);
        } else {
            customerHeaderView.changeStyle(CustomerHeaderView.HeaderStyle.TRANSPARENT);
        }
    }

    public void onCreate() {
        super.onCreate();
        LinearLayout linearLayout = this.mHomeShimmerContainerParent;
        linearLayout.setPadding(linearLayout.getPaddingLeft(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40), this.mHomeShimmerContainerParent.getPaddingRight(), this.mHomeShimmerContainerParent.getPaddingBottom());
        this.mFloatLayout.setOnHeaderFloatCallback(new OnHeaderFloatCallback() {
            public final void onFloating(float f) {
                HomeFeedView.this.m33666a(f);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33666a(float f) {
        this.mHomeAddressTipView.setScrollProgress(f, (float) (-getNovaRecyclerView().computeVerticalScrollOffset()));
    }

    public void setStatusBarBgLightning(boolean z) {
        CustomerSystemUtil.setStatusBarBgLightning(z);
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
        getNovaRecyclerView().setPreLoadNumber(10);
        int a = m33665a();
        if (a > -1) {
            getNovaRecyclerView().getRecycledViewPool().setMaxRecycledViews(a, 8);
        }
        this.mFloatLayout.attachRecycleView(this.mRecycleView);
        this.mFeedHeaderLayout.attachRecycleView(this.mRecycleView);
        HomeMiniCartHelper homeMiniCartHelper = new HomeMiniCartHelper();
        this.f45322b = homeMiniCartHelper;
        homeMiniCartHelper.attach(getScopeContext(), getNovaRecyclerView(), (FooterViewIPresenter) getPresenter());
        if (this.f45323c == null) {
            this.f45323c = new HomeBubHelper();
        }
        this.f45323c.attach(getScopeContext(), getNovaRecyclerView());
        CustomerGuideManager.Companion.getInstance().registerScrollListener(getContext(), getNovaRecyclerView());
        HomeRocketLaunchAnimManager.Companion.getInstance().attach(getContext(), getNovaRecyclerView(), this.mFloatLayout, new HomeRocketLaunchAnimManager.OnHomeScrollToTopCallBack() {
            public final void scrollToTop() {
                HomeFeedView.this.m33675e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m33675e() {
        getNovaRecyclerView().smoothScrollToPosition(0);
    }

    public void showShimmer() {
        ShimmerRecyclerView shimmerRecyclerView = this.f45321a;
        if (shimmerRecyclerView != null && this.mHomeShimmerContainer.indexOfChild(shimmerRecyclerView) < 0) {
            this.mHomeShimmerContainerParent.setVisibility(0);
            this.mHomeShimmerContainer.addView(this.f45321a);
            resetHeaderView(false);
            generatePullToRefreshView().setEnabled(false);
            this.f45321a.startShimmerAnimator(ShimmerViewType.HOME_STRAT);
        }
    }

    public void dismissShimmer() {
        ShimmerRecyclerView shimmerRecyclerView = this.f45321a;
        if (shimmerRecyclerView != null) {
            shimmerRecyclerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    HomeFeedView.this.mHomeShimmerContainer.removeView(HomeFeedView.this.f45321a);
                    HomeFeedView.this.mHomeShimmerContainerParent.setVisibility(8);
                }
            });
            generatePullToRefreshView().setEnabled(true);
        }
        this.mFloatLayout.showOrHideShimmer(false);
    }

    public void resetHeaderView(boolean z) {
        if (!z) {
            getNovaRecyclerView().scrollToPosition(0);
            getNovaRecyclerView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    HomeFeedView.this.mFeedHeaderLayout.acceptRefreshAnchor(HomeFeedView.this.mRecycleView);
                    HomeFeedView.this.mFloatLayout.notifyScroll();
                    HomeFeedView.this.getNovaRecyclerView().removeOnLayoutChangeListener(this);
                }
            });
        }
    }

    public void intoFloating() {
        this.mFloatLayout.intoFloating();
        this.mFeedHeaderLayout.acceptRefreshAnchor(this.mRecycleView);
    }

    public void updateAddressTip(AddressTipInfo addressTipInfo) {
        if (addressTipInfo != null && !TextUtils.isEmpty(addressTipInfo.mTip)) {
            resetHeaderView(false);
        }
        this.mHomeAddressTipView.updateAddressTip(getScopeContext(), addressTipInfo);
    }

    public void dismissLoadingDialog() {
        DialogUtil.hideLoadingDialog();
    }

    /* renamed from: com.didi.soda.home.topgun.component.feed.HomeFeedView$6 */
    static /* synthetic */ class C147846 {

        /* renamed from: $SwitchMap$com$didi$soda$home$component$feed$HomeTypeContract$HomeLoadingType */
        static final /* synthetic */ int[] f45325xafa70e8c;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.soda.home.component.feed.HomeTypeContract$HomeLoadingType[] r0 = com.didi.soda.home.component.feed.HomeTypeContract.HomeLoadingType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45325xafa70e8c = r0
                com.didi.soda.home.component.feed.HomeTypeContract$HomeLoadingType r1 = com.didi.soda.home.component.feed.HomeTypeContract.HomeLoadingType.LOADING_DIALOG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f45325xafa70e8c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.home.component.feed.HomeTypeContract$HomeLoadingType r1 = com.didi.soda.home.component.feed.HomeTypeContract.HomeLoadingType.LOADING_DIALOG_WITH_BOX     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f45325xafa70e8c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.home.component.feed.HomeTypeContract$HomeLoadingType r1 = com.didi.soda.home.component.feed.HomeTypeContract.HomeLoadingType.LOADING_SHIMMER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f45325xafa70e8c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.home.component.feed.HomeTypeContract$HomeLoadingType r1 = com.didi.soda.home.component.feed.HomeTypeContract.HomeLoadingType.LOADING_FILTER_SHIMMER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.feed.HomeFeedView.C147846.<clinit>():void");
        }
    }

    public void showLoadingByType(HomeTypeContract.HomeLoadingType homeLoadingType) {
        int i = C147846.f45325xafa70e8c[homeLoadingType.ordinal()];
        if (i == 1) {
            DialogUtil.showLoadingDialog(getScopeContext(), false);
        } else if (i != 2) {
            if (i == 3) {
                showShimmer();
            } else if (i == 4) {
                LogUtil.m32584d("TAG", " >>>> show filter shimmer");
                this.mFloatLayout.showOrHideShimmer(true);
            }
        } else if (this.mHomeShimmerContainerParent.getVisibility() == 8) {
            DialogUtil.showLoadingDialog(getScopeContext(), true);
        }
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public int calculateAbnormalViewHeight(boolean z) {
        LogUtil.m32584d("TAG", " calculateAbnormalViewHeight = " + z);
        int i = GlobalContext.isEmbed() ? 251 : 205;
        if (!z) {
            i -= 62;
        }
        return DisplayUtils.getScreenHeight(getContext()) - DisplayUtils.dip2px(getContext(), (float) i);
    }

    public void fillRecyclerViewContentHeight(final boolean z) {
        ((Contract.AbsHomeFeedPresenter) getPresenter()).hideFooterBottomStubView();
        this.mRecycleView.post(new Runnable() {
            public void run() {
                if (!z) {
                    HomeFeedView.this.m33667a(HomeCalculateHeightUtil.getContentFullScreenOffset(HomeFeedView.this.mRecycleView, HomeFeedView.this.mFloatLayout.getFloatOffset()));
                }
            }
        });
    }

    public void scrollToFloatingState(int i, boolean z) {
        FloatLayout floatLayout = this.mFloatLayout;
        if (floatLayout != null) {
            floatLayout.banAcceptScroll();
            this.mFeedHeaderLayout.banAcceptScroll();
            this.mRecycleView.post(new Runnable(i, z) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    HomeFeedView.this.m33672b(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33672b(final int i, final boolean z) {
        m33668a(i, z);
        this.mRecycleView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (i >= 0 && !z) {
                    int filterDataFullScreenOffset = HomeCalculateHeightUtil.getFilterDataFullScreenOffset(HomeFeedView.this.mRecycleView, i, true);
                    HomeFeedView.this.m33667a(filterDataFullScreenOffset);
                    LogUtil.m32588i("Float", i + "onLayoutChange >>>>> footer" + filterDataFullScreenOffset);
                }
                HomeFeedView.this.mFloatLayout.acceptScroll();
                HomeFeedView.this.mFeedHeaderLayout.acceptScroll();
                HomeFeedView.this.mFloatLayout.post(new Runnable() {
                    public final void run() {
                        HomeFeedView.C147824.this.lambda$onLayoutChange$0$HomeFeedView$4();
                    }
                });
                HomeFeedView.this.mFeedHeaderLayout.acceptRefreshAnchor(HomeFeedView.this.mRecycleView);
                HomeFeedView.this.mRecycleView.removeOnLayoutChangeListener(this);
            }

            public /* synthetic */ void lambda$onLayoutChange$0$HomeFeedView$4() {
                HomeFeedView.this.mFloatLayout.notifyScroll();
            }
        });
    }

    public void setFilterShowOrHide(boolean z) {
        this.f45322b.setFilterShow(z);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecycleView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(m33674d());
        registerBinder(new FilterBinder(getScopeContext(), ((Contract.AbsHomeFeedPresenter) getPresenter()).provideComponentLogicUnit()));
        registerBinder(new HomeBusinessDividerBinder(m33671b()));
        registerBinder(new HomeOrderCardBinder(getScopeContext()));
        registerBinder(new HomeBusinessItemNewBinder(HomeOmegaHelper.getInstance()));
        registerBinder(new BannerItemBinder(0.31778425f));
        registerBinder(new HomeFilterNoResultBinder(((Contract.AbsHomeFeedPresenter) getPresenter()).provideComponentLogicUnit()));
        registerBinder(new TopGunAbnormalViewBinder());
        registerBinder(new HomeTopicBinder(getScopeContext()));
        registerBinder(new HomeRecyclerBinder(((Contract.AbsHomeFeedPresenter) getPresenter()).getScope(), m33673c()));
        registerBinder(new HomeTaskCenterBinder(getScopeContext()));
        HomeKingKongBinder homeKingKongBinder = new HomeKingKongBinder();
        homeKingKongBinder.setOnItemClickListener(new HomeKingKongItemAdapter.OnItemClickListener() {
            public final void onItemClick(KingKongItemModel kingKongItemModel) {
                HomeKingKongBinder.this.accessUrl(kingKongItemModel, "", (ScopeContext) null);
            }
        });
        registerBinder(homeKingKongBinder);
        registerBinder(new HomeSceneBinder());
    }

    /* renamed from: a */
    private int m33665a() {
        List<ItemBinder> registeredBinderList = ((NovaRecyclerAdapter) getNovaRecyclerView().getAdapter()).getRegisteredBinderList();
        for (int i = 0; i < registeredBinderList.size(); i++) {
            if (registeredBinderList.get(i) instanceof HomeBusinessItemNewBinder) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setStatusBarBgLightning(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ShimmerRecyclerView shimmerRecyclerView = this.f45321a;
        if (shimmerRecyclerView != null) {
            shimmerRecyclerView.onDestory();
        }
        HomeRocketLaunchAnimManager.Companion.getInstance().release();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_page_home_feed_top_gun, viewGroup);
        ShimmerRecyclerView shimmerRecyclerView = new ShimmerRecyclerView(getContext());
        this.f45321a = shimmerRecyclerView;
        shimmerRecyclerView.setListDelay(false);
        this.f45321a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        return inflate;
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    public void onMoveTargetView(int i) {
        super.onMoveTargetView(i);
        this.mFeedHeaderLayout.acceptRefreshOffset(i);
    }

    /* renamed from: a */
    private void m33668a(int i, boolean z) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRecycleView.getLayoutManager();
        int i2 = i < 0 ? 1 : i + 1;
        int anchorOffsetDistance = this.mFloatLayout.getAnchorOffsetDistance();
        int childCount = linearLayoutManager.getChildCount();
        if (!z && i >= 0 && childCount - i2 <= 7) {
            m33667a(DisplayUtils.getScreenHeight(getContext()));
        }
        linearLayoutManager.scrollToPositionWithOffset(i2, anchorOffsetDistance);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33667a(int i) {
        if (i > 0) {
            ((Contract.AbsHomeFeedPresenter) getPresenter()).showFooterBottomStubView(i);
        } else {
            ((Contract.AbsHomeFeedPresenter) getPresenter()).hideFooterBottomStubView();
        }
    }

    /* renamed from: b */
    private ItemDecorator m33671b() {
        HomeHeaderShadowDecoration homeHeaderShadowDecoration = new HomeHeaderShadowDecoration(ResourceHelper.getColor(R.color.rf_color_v2_grey2_10_a100), DisplayUtils.dip2px(getContext(), 12.0f));
        homeHeaderShadowDecoration.enablePositionTopDecorator();
        return homeHeaderShadowDecoration;
    }

    /* renamed from: c */
    private ItemDecorator m33673c() {
        HomeComposeItemDecoration homeComposeItemDecoration = new HomeComposeItemDecoration(ResourceHelper.getColor(R.color.rf_color_v2_grey2_10_a100), DisplayUtils.dip2px(getContext(), 12.0f));
        homeComposeItemDecoration.enablePositionTopDecorator();
        return homeComposeItemDecoration;
    }

    /* renamed from: d */
    private HomeNewHeaderBinder m33674d() {
        return new HomeNewHeaderBinder(getScopeContext(), ((Contract.AbsHomeFeedPresenter) getPresenter()).provideComponentLogicUnit(), this.mFeedHeaderLayout);
    }

    public void showBubOrNot(TaskBubModel taskBubModel) {
        HomeBubHelper homeBubHelper = this.f45323c;
        if (homeBubHelper != null) {
            homeBubHelper.homeFeedSetData(taskBubModel);
        }
    }

    public RecyclerView getRecycleView() {
        return this.mRecycleView;
    }
}
