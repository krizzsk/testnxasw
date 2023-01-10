package com.didi.soda.business.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewConfigurationCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessHeaderDyViewTipHelper;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;
import java.util.HashMap;

public class BusinessDyHomeHeaderView extends ConstraintLayout {

    /* renamed from: a */
    private static final String f42391a = "BusinessHomeHeaderView";

    /* renamed from: b */
    private static final long f42392b = 1000;

    /* renamed from: c */
    private static final long f42393c = 51;

    /* renamed from: d */
    private static final long f42394d = 42;
    public BusinessHeaderDyViewTipHelper businessHeaderViewTipHelper;
    public BusinessCategoryRvModel currentCategoryRvModel;

    /* renamed from: e */
    private long f42395e;

    /* renamed from: f */
    private IBusinessHeaderAnimator f42396f;

    /* renamed from: g */
    private float f42397g;

    /* renamed from: h */
    private float f42398h;

    /* renamed from: i */
    private int f42399i;

    /* renamed from: j */
    private int[] f42400j = new int[2];

    /* renamed from: k */
    private int[] f42401k = new int[2];

    /* renamed from: l */
    private NestedScrollingChildHelper f42402l;
    @BindView(17948)
    ImageView mBusinessLogo;
    @BindView(17762)
    BusinessDyClassifyALayout mClassifyALayout;
    @BindView(17763)
    BusinessDyClassifyBLayout mClassifyBLayout;
    @BindView(18520)
    ConstraintLayout mClassifyTabContainer;
    @BindView(18363)
    RFIconView mCloseIcon;
    @BindView(18141)
    FrameLayout mFavorContainerView;
    @BindView(18364)
    RFIconView mFavorImageIv;
    @BindView(17988)
    LottieLoadingView mFavorLoadingView;
    @BindView(18362)
    ImageView mHeaderBackgroundImg;
    @BindView(18651)
    FrameLayout mHeaderCardContainer;
    @BindView(18243)
    View mHeaderCardShadowView;
    @BindView(18164)
    FrameLayout mLogoContainer;
    @BindView(18365)
    RFIconView mSearchIcon;
    @BindView(18415)
    IconTextView mShimmerTitleFavorDelegate;
    @BindView(18829)
    TextView mStickyNameTv;
    @BindView(18112)
    BusinessDyStickyNavigationView mStickyNavigationView;
    @BindView(17853)
    ConstraintLayout mTitleContainer;

    public interface OnBusinessTabItemListener {
        void onMoreTabExposure();

        void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel);

        void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2);
    }

    public interface OnHeaderClickListener {
        void onFavorClicked(boolean z);

        void onFavorLogin();

        void onMoreClicked();

        void onSearchClicked();
    }

    public BusinessDyHomeHeaderView(Context context) {
        super(context);
        m31892a();
    }

    public BusinessDyHomeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31892a();
    }

    public BusinessDyHomeHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31892a();
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f42396f.bindScopeContext(scopeContext);
    }

    public void setCategoryClickListener(final OnMoreCategoryListener onMoreCategoryListener) {
        this.mClassifyBLayout.setCategoryClickListener(onMoreCategoryListener);
        this.mClassifyALayout.setMenuClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnMoreCategoryListener onMoreCategoryListener = onMoreCategoryListener;
                if (onMoreCategoryListener != null) {
                    onMoreCategoryListener.onClickMoreCategoryListener(new BusinessSelectedCallback() {
                        public void onSelectedCategory(int i) {
                            BusinessDyHomeHeaderView.this.mClassifyBLayout.selectTab(i, false);
                        }
                    });
                }
            }
        });
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnBackListener.this.onBack(0);
            }
        });
        this.mStickyNavigationView.setOnBackListener(onBackListener);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        $$Lambda$BusinessDyHomeHeaderView$v4_h5pi4t1_CxxRwUnqaZz_TA0 r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDyHomeHeaderView.OnHeaderClickListener.this.onSearchClicked();
            }
        };
        $$Lambda$BusinessDyHomeHeaderView$r2eYGHUTgV43CNfiTO6FPaw9is r1 = new View.OnClickListener(onHeaderClickListener) {
            public final /* synthetic */ BusinessDyHomeHeaderView.OnHeaderClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessDyHomeHeaderView.this.m31899b(this.f$1, view);
            }
        };
        $$Lambda$BusinessDyHomeHeaderView$FuOieHg5oO0j_CE4kz0dQNE6rU r2 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDyHomeHeaderView.OnHeaderClickListener.this.onMoreClicked();
            }
        };
        this.mSearchIcon.setOnClickListener(r0);
        this.mFavorContainerView.setOnClickListener(r1);
        this.mBusinessLogo.setOnClickListener(r2);
        this.mHeaderBackgroundImg.setOnClickListener(r2);
        this.mStickyNavigationView.setOnSearchClickListener(r0);
        this.mClassifyALayout.setOnSearchClickListener(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31899b(OnHeaderClickListener onHeaderClickListener, View view) {
        if (!m31900b()) {
            if (!LoginUtil.isLogin()) {
                onHeaderClickListener.onFavorLogin();
                return;
            }
            boolean z = !view.isSelected();
            handleFavor(z ? 1 : 0, true);
            onHeaderClickListener.onFavorClicked(z);
        }
    }

    public void setTabItemListener(OnBusinessTabItemListener onBusinessTabItemListener) {
        this.mClassifyBLayout.setTabItemListener(onBusinessTabItemListener);
    }

    public void setOnCategoryTouchListener(View.OnTouchListener onTouchListener) {
        this.mClassifyBLayout.setOnCategoryTouchListener(onTouchListener);
    }

    public void setOnCategoryScrollListener(CustomerTabLayout.OnScollChangedListener onScollChangedListener) {
        this.mClassifyBLayout.setOnCategoryScrollListener(onScollChangedListener);
    }

    public void updateBusinessHeaderView(BusinessHeaderRvModel businessHeaderRvModel, IBlockScope iBlockScope) {
        String str;
        setVisibility(0);
        getHeaderAnimator().updateRecordState(true);
        this.mStickyNameTv.setText(businessHeaderRvModel.mBusinessName);
        m31898b(businessHeaderRvModel);
        handleFavor(businessHeaderRvModel.isFavor, false);
        m31901c(businessHeaderRvModel);
        m31894a(businessHeaderRvModel);
        setVisibility(0);
        if (businessHeaderRvModel.componentModel == null || businessHeaderRvModel.componentModel.getWidgetNodeModel() == null) {
            this.mHeaderCardContainer.setVisibility(4);
            LogUtil.m32584d(f42391a, "配置化数据解析失败");
            if (businessHeaderRvModel.componentModel == null) {
                str = "componentModel = null";
            } else {
                str = businessHeaderRvModel.componentModel.getWidgetNodeModel() == null ? "getWidgetNodeModel = null" : "";
            }
            ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_M_SHOP_HEADER_DY_ERROR).addModuleName("shop").addErrorType(str);
            addErrorType.addErrorType("updateBusinessHeaderView" + str).addErrorMsg("updateBusinessHeaderView 配置化数据解析失败").build().trackError();
        } else {
            View view = BlocksEngine.Companion.getInstance().renderViewWithData(getContext(), iBlockScope, businessHeaderRvModel.componentModel.getWidgetNodeModel(), (BinderRootConfig<?>) null).getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.mHeaderCardContainer.setVisibility(0);
            this.mHeaderCardContainer.removeAllViews();
            this.mHeaderCardContainer.addView(view);
        }
        m31903d(businessHeaderRvModel);
        m31904e(businessHeaderRvModel);
    }

    public void selectTab(int i) {
        this.mClassifyBLayout.selectTab(i);
    }

    public IBusinessHeaderAnimator getHeaderAnimator() {
        return this.f42396f;
    }

    public BusinessHeaderDyViewTipHelper getBusinessHeaderViewTipHelper() {
        if (this.businessHeaderViewTipHelper == null) {
            this.businessHeaderViewTipHelper = new BusinessHeaderDyViewTipHelper(this);
        }
        return this.businessHeaderViewTipHelper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0 != 3) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 == r2) goto L_0x0032
            if (r0 == r1) goto L_0x0010
            r4 = 3
            if (r0 == r4) goto L_0x0032
            goto L_0x0045
        L_0x0010:
            r4.getX()
            float r0 = r4.getY()
            float r1 = r3.f42398h
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r3.f42399i
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            float r0 = r4.getX()
            r3.f42397g = r0
            float r4 = r4.getY()
            r3.f42398h = r4
            goto L_0x0046
        L_0x0032:
            r3.stopNestedScroll()
            goto L_0x0045
        L_0x0036:
            float r0 = r4.getX()
            r3.f42397g = r0
            float r4 = r4.getY()
            r3.f42398h = r4
            r3.startNestedScroll(r1)
        L_0x0045:
            r2 = 0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.widget.BusinessDyHomeHeaderView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    dispatchNestedPreScroll((int) (this.f42397g - motionEvent.getX()), (int) (this.f42398h - motionEvent.getY()), this.f42401k, this.f42400j);
                    this.f42397g = motionEvent.getX();
                    this.f42398h = motionEvent.getY();
                    return false;
                } else if (action != 3) {
                    return false;
                }
            }
            this.f42397g = 0.0f;
            this.f42398h = 0.0f;
            return false;
        }
        this.f42397g = motionEvent.getX();
        this.f42398h = motionEvent.getY();
        startNestedScroll(2);
        return false;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f42402l.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f42402l.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f42402l.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f42402l.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f42402l.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f42402l.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f42402l.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f42402l.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f42402l.dispatchNestedPreFling(f, f2);
    }

    public void handleFavor(int i, boolean z) {
        if (i == -1) {
            this.mFavorContainerView.setVisibility(8);
            this.mFavorImageIv.setVisibility(8);
            this.mShimmerTitleFavorDelegate.setVisibility(8);
            this.mFavorLoadingView.setVisibility(8);
            this.mFavorContainerView.setSelected(false);
        } else if (i == 0) {
            this.mFavorContainerView.setVisibility(0);
            this.mFavorImageIv.setVisibility(0);
            this.mFavorImageIv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_collection));
            this.mShimmerTitleFavorDelegate.setVisibility(4);
            this.mFavorLoadingView.hide();
            this.mFavorContainerView.setSelected(false);
        } else if (i == 1) {
            this.mFavorContainerView.setVisibility(0);
            this.mFavorContainerView.setSelected(true);
            this.mShimmerTitleFavorDelegate.setVisibility(4);
            if (z) {
                this.mFavorImageIv.setVisibility(8);
                this.mFavorLoadingView.setVisibility(0);
                this.mFavorLoadingView.show();
                ToastUtil.showCustomerSuccessToast((ScopeContext) null, ResourceHelper.getString(R.string.FoodC_collection_Collection_you_Ybgv));
                return;
            }
            this.mFavorLoadingView.setVisibility(8);
            this.mFavorImageIv.setVisibility(0);
            this.mFavorImageIv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_collection));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHeaderAnimator().recordAnimationSpec();
    }

    /* renamed from: a */
    private void m31894a(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout constraintLayout = this.mTitleContainer;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), businessHeaderRvModel.mDynamicPadding + DisplayUtils.dip2px(getContext(), 12.0f), this.mTitleContainer.getPaddingRight(), this.mTitleContainer.getPaddingBottom());
    }

    /* renamed from: b */
    private void m31898b(BusinessHeaderRvModel businessHeaderRvModel) {
        if (!TextUtils.isEmpty(businessHeaderRvModel.mDyHeadImgUrl)) {
            FlyImageLoader.loadImageUnspecified(getContext(), businessHeaderRvModel.mDyHeadImgUrl).placeholder((int) R.drawable.customer_img_dy_business_header).error((int) R.drawable.customer_img_dy_business_header).dontAnimate().into(this.mHeaderBackgroundImg);
            this.mHeaderBackgroundImg.setVisibility(0);
            return;
        }
        this.mHeaderBackgroundImg.setVisibility(8);
    }

    /* renamed from: c */
    private void m31901c(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mLogoContainer.getLayoutParams();
        layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 10.0f) + businessHeaderRvModel.mDynamicPadding;
        this.mLogoContainer.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(businessHeaderRvModel.mDyLogoUrl)) {
            FlyImageLoader.loadImage1x1(getContext(), businessHeaderRvModel.mDyLogoUrl).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).error((int) R.drawable.customer_skin_img_business_goods_item_x11).dontAnimate().into(this.mBusinessLogo);
            this.mBusinessLogo.setVisibility(0);
            this.mLogoContainer.setVisibility(0);
            return;
        }
        this.mBusinessLogo.setVisibility(4);
        this.mLogoContainer.setVisibility(4);
    }

    /* renamed from: a */
    private void m31892a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_home_header, this, true);
        ButterKnife.bind((Object) this, inflate);
        this.f42396f = new BusinessDyHeaderAnimator(inflate);
        this.f42399i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(inflate.getContext()));
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.f42402l = nestedScrollingChildHelper;
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        setClickable(false);
        this.businessHeaderViewTipHelper = new BusinessHeaderDyViewTipHelper(this);
    }

    /* renamed from: a */
    private void m31897a(String str) {
        LogUtil.m32584d(f42391a, str);
    }

    /* renamed from: b */
    private boolean m31900b() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.f42395e < 1000;
        if (!z) {
            this.f42395e = currentTimeMillis;
        }
        return z;
    }

    /* renamed from: d */
    private void m31903d(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mHeaderCardContainer.getLayoutParams();
        layoutParams.height = -2;
        this.mHeaderCardContainer.setLayoutParams(layoutParams);
    }

    public void showDeliveryFeeDescRule(HashMap<String, Object> hashMap, View view) {
        BusinessDeliveryFeeTipsManager.Companion.getInstance().showDeliveryFeeTips(hashMap, this.mHeaderCardContainer, view, getContext());
    }

    /* renamed from: e */
    private void m31904e(BusinessHeaderRvModel businessHeaderRvModel) {
        if (businessHeaderRvModel != null) {
            this.mStickyNavigationView.updateBusinessHeaderView(businessHeaderRvModel);
            this.mStickyNavigationView.setVisibility(4);
            this.mClassifyBLayout.updateBusinessCategoryData(businessHeaderRvModel);
            this.mHeaderCardShadowView.setVisibility(0);
            int dip2px = DisplayUtils.dip2px(getContext(), 17.0f);
            if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
                this.mClassifyALayout.setVisibility(0);
                this.mClassifyBLayout.setVisibility(4);
                this.mSearchIcon.setVisibility(8);
                this.mHeaderCardShadowView.setBackgroundResource(R.color.rf_color_white_100);
            } else {
                this.mClassifyALayout.setVisibility(8);
                this.mClassifyBLayout.setVisibility(0);
                this.mSearchIcon.setVisibility(0);
                this.mHeaderCardShadowView.setBackgroundResource(R.drawable.customer_shape_header_card_shadow);
            }
            this.mClassifyTabContainer.setVisibility(0);
            m31893a(dip2px);
        }
    }

    /* renamed from: a */
    private void m31893a(int i) {
        FrameLayout frameLayout = this.mHeaderCardContainer;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), this.mHeaderCardContainer.getPaddingTop(), this.mHeaderCardContainer.getPaddingRight(), this.mHeaderCardContainer.getPaddingBottom() + i);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mHeaderCardShadowView.getLayoutParams();
        layoutParams.bottomMargin += i;
        this.mHeaderCardShadowView.setLayoutParams(layoutParams);
    }
}
