package com.didi.soda.business.component.dynamic.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.binder.home.BusinessCategoryItemBinder;
import com.didi.soda.business.binder.home.BusinessExpandBinder;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.component.dynamic.home.BusinessView;
import com.didi.soda.business.component.dynamic.home.Contract;
import com.didi.soda.business.component.home.BusinessGoodsItemDecorator;
import com.didi.soda.business.component.home.BusinessScrollManager;
import com.didi.soda.business.component.home.scroll.ScrollerFinishCallback;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessGuideManager;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.business.widget.OnHeaderCollapseListener;
import com.didi.soda.business.widget.OnHeaderStateChangeListener;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.coordshop.CoordShopManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class BusinessView extends Contract.AbsBusinessView {

    /* renamed from: e */
    private static final String f42168e = "BusinessView";

    /* renamed from: a */
    RFIconView f42169a;

    /* renamed from: b */
    RFIconView f42170b;

    /* renamed from: c */
    View f42171c;

    /* renamed from: d */
    IconTextView f42172d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f42173f = -1;

    /* renamed from: g */
    private int f42174g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BusinessScrollManager f42175h;

    /* renamed from: i */
    private boolean f42176i = false;

    /* renamed from: j */
    private boolean f42177j = false;

    /* renamed from: k */
    private OnPlayAddToCartAnimation f42178k;

    /* renamed from: l */
    private View f42179l;

    /* renamed from: m */
    private int[] f42180m = new int[2];
    @BindView(17921)
    TopGunAbnormalView mAbnormalView;
    @BindView(19215)
    BusinessDyHomeHeaderView mBusinessHeaderView;
    @BindView(17856)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(18014)
    NovaRecyclerView mRecyclerView;
    @BindView(17854)
    ConstraintLayout mShimmerTitleBar;
    @BindView(18053)
    ShimmerRecyclerView mShimmerView;

    /* renamed from: n */
    private String f42181n;

    /* renamed from: a */
    static /* synthetic */ int m31662a(BusinessView businessView, int i) {
        int i2 = businessView.f42173f + i;
        businessView.f42173f = i2;
        return i2;
    }

    /* renamed from: a */
    private void m31666a(ViewGroup viewGroup, View view) {
        ViewGroup viewGroup2;
        if (viewGroup == null || viewGroup.getParent() == null || !(viewGroup.getParent() instanceof ViewGroup)) {
            viewGroup2 = (ViewGroup) view.findViewById(R.id.customer_cl_root_view);
        } else {
            viewGroup2 = (ViewGroup) viewGroup.getParent();
        }
        BusinessGuideManager.Companion.getInstance().showBusinessGuideView(viewGroup2, getContext());
    }

    public int getCategoryRvIndex(int i) {
        return ((Contract.AbsBusinessPresenter) getPresenter()).getCategoryRvIndex(i);
    }

    public void selectTab(int i) {
        this.f42176i = true;
        this.mBusinessHeaderView.selectTab(i);
    }

    public void showShimmerView() {
        m31670a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f42169a.setVisibility(8);
        this.f42170b.setVisibility(8);
        this.f42171c.setVisibility(8);
        this.mShimmerView.setVisibility(0);
        this.mShimmerView.startShimmerAnimator(ShimmerViewType.BUSINESS_START);
    }

    public void hideShimmerView() {
        this.mShimmerTitleBar.setVisibility(8);
        m31670a(true);
        this.mShimmerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BusinessView.this.mShimmerView.setVisibility(8);
            }
        });
    }

    public void hideAbnormalView() {
        m31670a(true);
        this.mShimmerTitleBar.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mAbnormalView.setVisibility(8);
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        m31670a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f42169a.setVisibility(8);
        this.f42170b.setVisibility(8);
        this.f42171c.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(topGunAbnormalViewModel);
    }

    public void updateCategoryAmount(Map<String, BusinessCategoryRvModel> map) {
        this.f42175h.updateCategoryMap(map);
    }

    public void updateHeaderView(BusinessHeaderRvModel businessHeaderRvModel, IBlockScope iBlockScope) {
        this.mBusinessHeaderView.updateBusinessHeaderView(businessHeaderRvModel, iBlockScope);
    }

    public void showBusinessHeader(boolean z) {
        this.mBusinessHeaderView.setVisibility(z ? 0 : 8);
    }

    public void anchorView(final int i, final int i2, final BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        this.mRecyclerView.postDelayed(new Runnable() {
            public void run() {
                if (i > 0) {
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            BusinessView.this.mBusinessHeaderView.selectTab(i);
                        }
                    }, 50);
                }
                if (i2 > -1) {
                    BusinessView.this.mBusinessHeaderView.getHeaderAnimator().collapseHeader();
                    BusinessView.this.f42175h.scrollToAnchorView(i, i2, new ScrollerFinishCallback(businessGoodsItemRvModel) {
                        public final /* synthetic */ BusinessGoodsItemRvModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onScrollFinished() {
                            BusinessView.C142602.this.lambda$run$0$BusinessView$2(this.f$1);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$run$0$BusinessView$2(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).updateAnchorData(businessGoodsItemRvModel);
            }
        }, 50);
    }

    public void favorBusiness() {
        this.mBusinessHeaderView.handleFavor(1, true);
    }

    public void onBack(int i) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBack(i);
    }

    public void onCreate() {
        super.onCreate();
        BusinessScrollManager businessScrollManager = new BusinessScrollManager(this.mRecyclerView);
        this.f42175h = businessScrollManager;
        businessScrollManager.setBusinessViewBehaviorImpl(this);
        m31674b();
        m31664a();
        CoordShopManager.Companion.get().findCoordShopPredicate(this.mRecyclerView);
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
    }

    public void onMoreClicked() {
        ((Contract.AbsBusinessPresenter) getPresenter()).goBusinessDetail();
    }

    public void onSearchClicked() {
        ((Contract.AbsBusinessPresenter) getPresenter()).goBusinessSearch();
    }

    public void onFavorClicked(boolean z) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBusinessFavor(z);
    }

    public void onFavorLogin() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onFavorLogin();
    }

    public void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onTabItemExposure(i, businessCategoryRvModel);
    }

    public void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        if (this.f42176i) {
            this.f42176i = false;
            return;
        }
        if (z2) {
            this.mBusinessHeaderView.getHeaderAnimator().expandHeader();
        } else {
            this.mBusinessHeaderView.getHeaderAnimator().collapseHeader();
        }
        this.f42175h.onTabSelected(i);
        ((Contract.AbsBusinessPresenter) getPresenter()).onTabItemSelected(i, businessCategoryRvModel, z, z2);
    }

    public void onMoreTabExposure() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onMoreTabExposure();
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f42178k = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_dy_business_home, viewGroup, true);
        m31666a(viewGroup, inflate);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m31670a(this.f42177j);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m31670a(false);
        ShimmerRecyclerView shimmerRecyclerView = this.mShimmerView;
        if (shimmerRecyclerView != null) {
            shimmerRecyclerView.onDestory();
        }
        BusinessGuideManager.Companion.getInstance().release();
        BusinessDeliveryFeeTipsManager.Companion.getInstance().release();
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new CustomerDividerLineBinder());
        registerBinder(new BusinessGoodsItemBinder(getScopeContext(), BusinessGoodsItemDecorator.newInstance()) {
            public void onGoodsItemShow(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsItemExposure(businessGoodsItemRvModel);
            }

            public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsItemClick(businessGoodsItemRvModel);
            }

            public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsImageClick(view, businessGoodsItemRvModel);
            }

            public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsAddClick(businessGoodsItemRvModel);
            }

            public void playAddCartAnimation(int[] iArr) {
                BusinessView.this.realPlayAddCartAnimation(iArr, (String) null);
            }
        });
        registerBinder(new BusinessCategoryItemBinder());
        registerBinder(new BusinessExpandBinder() {
            public void clickExpandAction(BusinessExpandRvModel businessExpandRvModel, int i) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandOrFoldAction(businessExpandRvModel, i);
            }

            /* access modifiers changed from: protected */
            public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandShow(businessExpandRvModel);
            }

            /* access modifiers changed from: protected */
            public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandClickEvent(businessExpandRvModel);
            }
        });
    }

    public void realPlayAddCartAnimation(int[] iArr, String str) {
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f42178k;
        if (onPlayAddToCartAnimation != null && iArr.length >= 2 && iArr[0] > 0 && iArr[1] > 0) {
            onPlayAddToCartAnimation.playAddToCartAnimation(iArr, str);
        }
    }

    public void setCurrentVirView(View view, String str) {
        if (view != this.f42179l) {
            this.f42179l = view;
        }
        this.f42181n = str;
        View view2 = this.f42179l;
        if (view2 != null) {
            view2.getLocationOnScreen(this.f42180m);
        }
    }

    public void playAdd2CartAnim() {
        IFloatingCartProvider iFloatingCartProvider;
        if (this.f42179l != null && getScopeContext() != null && getScopeContext().getObject("service_floating_cart_key") != null && (iFloatingCartProvider = (IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")) != null) {
            iFloatingCartProvider.playAddToCartAnimation(true);
            realPlayAddCartAnimation(this.f42180m, this.f42181n);
        }
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    public void showDeliveryFeeDescRule(HashMap<String, Object> hashMap, View view) {
        BusinessDyHomeHeaderView businessDyHomeHeaderView = this.mBusinessHeaderView;
        if (businessDyHomeHeaderView != null) {
            businessDyHomeHeaderView.showDeliveryFeeDescRule(hashMap, view);
        }
    }

    /* renamed from: a */
    private void m31664a() {
        this.mBusinessHeaderView.bindScopeContext(getScopeContext());
        this.mBusinessHeaderView.setOnBackListener(this);
        this.mBusinessHeaderView.setOnHeaderClickListener(this);
        this.mBusinessHeaderView.setTabItemListener(this);
        this.mBusinessHeaderView.setCategoryClickListener(new OnMoreCategoryListener() {
            public final void onClickMoreCategoryListener(BusinessSelectedCallback businessSelectedCallback) {
                BusinessView.this.m31667a(businessSelectedCallback);
            }
        });
        this.mBusinessHeaderView.getHeaderAnimator().setOnHeaderStateChangeListener(new OnHeaderStateChangeListener() {
            public final void onHeaderStateChanged(boolean z) {
                BusinessView.this.m31675b(z);
            }
        });
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BusinessView.m31662a(BusinessView.this, i2);
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onRvScrolled(BusinessView.this.f42173f);
                    int unused = BusinessView.this.f42173f = 0;
                }
            }
        });
        this.mBusinessHeaderView.setOnCategoryScrollListener(new CustomerTabLayout.OnScollChangedListener() {
            public final void onScrollChanged(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
                BusinessView.this.m31668a(customerTabLayout, i, i2, i3, i4);
            }
        });
        this.mBusinessHeaderView.setOnCategoryTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BusinessView.this.m31671a(view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31667a(final BusinessSelectedCallback businessSelectedCallback) {
        if (this.mBusinessHeaderView.getHeaderAnimator().isCollapsed()) {
            ((Contract.AbsBusinessPresenter) getPresenter()).showMoreCategory(businessSelectedCallback);
        } else {
            this.mBusinessHeaderView.getHeaderAnimator().collapseHeader(new OnHeaderCollapseListener() {
                public void onCollapseUpdated() {
                }

                public void onCollapseFinished() {
                    ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).showMoreCategory(businessSelectedCallback);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31675b(boolean z) {
        if (getScopeContext().getLiveHandler().isActive() && !((Contract.AbsBusinessPresenter) getPresenter()).hasDynamicNotice()) {
            m31670a(!z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31668a(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
        this.f42174g += i - i3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m31671a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f42174g = 0;
        } else if (action == 1 || action == 3) {
            ((Contract.AbsBusinessPresenter) getPresenter()).onTabScrolled(this.f42174g);
            this.f42174g = 0;
        }
        return false;
    }

    /* renamed from: b */
    private void m31674b() {
        ConstraintLayout constraintLayout = this.mShimmerTitleBar;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + DisplayUtils.dip2px(getContext(), 12.0f), this.mShimmerTitleBar.getPaddingRight(), this.mShimmerTitleBar.getPaddingBottom());
        RFIconView rFIconView = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_close);
        this.f42169a = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_search);
        rFIconView.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        this.f42169a.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        rFIconView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessView.this.m31665a(view);
            }
        });
        RFIconView rFIconView2 = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_favor);
        this.f42170b = rFIconView2;
        rFIconView2.setTextColor(getColor(R.color.rf_color_gery_1_0_000000));
        this.f42170b.setOnClickListener((View.OnClickListener) null);
        IconTextView iconTextView = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_favor_delegate);
        this.f42172d = iconTextView;
        iconTextView.setVisibility(4);
        this.f42171c = this.mShimmerTitleBar.findViewById(R.id.customer_fl_business_favor_container);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31665a(View view) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBack(0);
    }

    /* renamed from: a */
    private void m31670a(boolean z) {
        this.f42177j = z;
        CustomerSystemUtil.setStatusBarBgLightning(z);
    }

    /* renamed from: a */
    private void m31669a(String str) {
        LogUtil.m32584d(f42168e, str);
    }
}
