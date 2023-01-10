package com.didi.soda.business.component.dynamic.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.component.contract.dynamic.DynamicRecycleView;
import com.didi.soda.business.component.dynamic.search.helper.MenuSearchDyView;
import com.didi.soda.business.component.home.BusinessGoodsItemDecorator;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.taxis99.R;

public class BusinessDySearchView extends DynamicRecycleView<BusinessDySearchPresent> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f42216a = false;

    /* renamed from: b */
    private boolean f42217b = false;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f42218c;

    /* renamed from: d */
    private View f42219d;

    /* renamed from: e */
    private String f42220e;

    /* renamed from: f */
    private int[] f42221f = new int[2];
    @BindView(18464)
    View mBackView;
    @BindView(18705)
    SodaLoadingView mLoadingView;
    @BindView(18599)
    NovaRecyclerView mSearchResultRv;
    @BindView(18601)
    MenuSearchDyView mSearchView;
    @BindView(18261)
    View mShadowView;
    @BindView(18053)
    ShimmerRecyclerView mShimmerView;
    @BindView(22967)
    ConstraintLayout search_root;

    public void showSearchLoading() {
        this.mSearchView.showOrHideLoading(true);
    }

    public void hideSearchLoading() {
        this.mSearchView.showOrHideLoading(false);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        if (!this.mLoadingView.isRunning()) {
            this.mLoadingView.start();
        }
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.stop();
    }

    public void hideSearchFocus() {
        this.mSearchView.getEditView().clearFocus();
    }

    public void showShimmerView() {
        this.mShimmerView.setVisibility(0);
        this.mShimmerView.startShimmerAnimator(ShimmerViewType.BUSINESS_SEARCH);
    }

    public void hideShimmerView() {
        this.mShimmerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BusinessDySearchView.this.mShimmerView.setVisibility(8);
            }
        });
    }

    public int calculateAbnormalHeight() {
        return (CustomerSystemUtil.getScreenHeight(getContext()) - CustomerSystemUtil.getImmersiveStatusBarHeight(getContext())) - DisplayUtils.dip2px(getContext(), 190.0f);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public void setRecommendSearchText(String str) {
        this.f42216a = true;
        this.mSearchView.getEditView().setText(str);
        this.mSearchView.getEditView().setSelection(str.length());
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        hideSearchFocus();
    }

    public void setCurrentVirView(View view, String str) {
        if (view != this.f42219d) {
            this.f42219d = view;
        }
        this.f42220e = str;
        View view2 = this.f42219d;
        if (view2 != null) {
            view2.getLocationOnScreen(this.f42221f);
        }
    }

    public void playAdd2CartAnim() {
        IFloatingCartProvider iFloatingCartProvider;
        if (this.f42219d != null && getScopeContext() != null && getScopeContext().getObject("service_floating_cart_key") != null && (iFloatingCartProvider = (IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")) != null) {
            iFloatingCartProvider.playAddToCartAnimation(true);
            realPlayAddCartAnimation(this.f42221f, this.f42220e);
        }
    }

    public void scrollToTop() {
        this.mSearchResultRv.scrollToPosition(0);
    }

    public void realPlayAddCartAnimation(int[] iArr, String str) {
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f42218c;
        if (onPlayAddToCartAnimation != null) {
            onPlayAddToCartAnimation.playAddToCartAnimation(iArr, str);
        }
    }

    public void onCreate() {
        super.onCreate();
        m31731a();
    }

    public void onResume() {
        super.onResume();
        if (!this.f42217b) {
            KeyboardUtils.showSoftInput(getContext(), this.mSearchView.getEditView());
            this.f42217b = true;
        }
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.NONE;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f42218c = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mSearchResultRv;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new CustomerDividerLineBinder());
        registerBinder(new BusinessGoodsItemBinder(getScopeContext(), BusinessGoodsItemDecorator.newInstance()) {
            public void onGoodsItemShow(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onGoodsItemExposure(businessGoodsItemRvModel);
            }

            public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onGoodsItemClick(businessGoodsItemRvModel);
            }

            public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onGoodsImageClick(view, businessGoodsItemRvModel);
            }

            public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onGoodsAddClick(businessGoodsItemRvModel);
            }

            public void playAddCartAnimation(int[] iArr) {
                BusinessDySearchView.this.realPlayAddCartAnimation(iArr, (String) null);
            }
        });
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_business_dy_search_layout, viewGroup, true);
    }

    /* renamed from: a */
    private void m31731a() {
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDySearchView.this.m31736b(view);
            }
        });
        this.mSearchResultRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BusinessDySearchView.this.mShadowView.setVisibility(recyclerView.canScrollVertically(-1) ? 0 : 8);
            }
        });
        m31735b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31736b(View view) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        ((BusinessDySearchPresent) getPresenter()).goBack(0);
    }

    /* renamed from: b */
    private void m31735b() {
        this.mSearchView.getEditView().setHint(R.string.customer_name_business_search_hint);
        this.mSearchView.getEditView().addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() == 0) {
                    ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onSearchWordClear();
                    KeyboardUtils.showSoftInput(BusinessDySearchView.this.getContext(), BusinessDySearchView.this.mSearchView.getEditView());
                } else if (!BusinessDySearchView.this.f42216a) {
                    ((BusinessDySearchPresent) BusinessDySearchView.this.getPresenter()).onSearchWordUpdate(charSequence.toString());
                } else {
                    boolean unused = BusinessDySearchView.this.f42216a = false;
                }
            }
        });
        this.mSearchView.getSearchButton().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDySearchView.this.m31732a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31732a(View view) {
        if (!StringUtils.isEmpty(this.mSearchView.getEditView().getText().toString())) {
            ((BusinessDySearchPresent) getPresenter()).onSearchWordRequest(1);
        }
    }
}
