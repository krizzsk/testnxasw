package com.didi.soda.goodsV2.component.purchase;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.goodsV2.GoodsQuantityListener;
import com.didi.soda.customer.widget.goodsV2.purchase.GoodsPurchaseCounter;
import com.didi.soda.goodsV2.binder.GoodsPurchaseHeaderBinder;
import com.didi.soda.goodsV2.binder.GoodsPurchaseTitleBinder;
import com.didi.soda.goodsV2.component.purchase.Contract;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class GoodsPurchaseView extends Contract.AbsGoodsPurchaseView {

    /* renamed from: a */
    private static final String f44973a = "GoodsPurchaseView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f44974b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f44975c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f44976d;

    /* renamed from: e */
    private ArgbEvaluator f44977e = new ArgbEvaluator();

    /* renamed from: f */
    private ViewTreeObserver.OnGlobalLayoutListener f44978f;
    @BindView(17921)
    TopGunAbnormalView mAbnormalView;
    @BindView(18465)
    ImageView mBackBg;
    @BindView(17941)
    GoodsPurchaseCounter mGoodsPurchaseCounter;

    public void exceedMinAmount() {
    }

    public void exceedMaxAmount(int i) {
        ToastUtil.showCustomerErrorToast(getScopeContext(), getContext().getResources().getQuantityString(R.plurals.customer_business_goods_add_num_restriction, i, new Object[]{Integer.valueOf(i)}));
    }

    public void exceedMaxSaleAmount(int i) {
        ToastUtil.showCustomerErrorToast(getScopeContext(), getContext().getResources().getQuantityString(R.plurals.customer_business_exceed_sale_amount, i, new Object[]{Integer.valueOf(i)}));
    }

    public void hideLoadingView() {
        DialogUtil.hideLoadingDialog();
    }

    public void onCreate() {
        super.onCreate();
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                GoodsPurchaseView.this.m33350a();
            }
        });
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void updateHeadImage(boolean z) {
        this.f44978f = new ViewTreeObserver.OnGlobalLayoutListener(z) {
            public final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void onGlobalLayout() {
                GoodsPurchaseView.this.m33353a(this.f$1);
            }
        };
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f44978f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33353a(boolean z) {
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f44978f);
        this.mSmoothScroller.setOffset(this.mTitleView.getBottom());
        if (z) {
            this.mTitleView.setBackgroundColor(0);
        } else {
            this.mTitleView.setBackgroundColor(-1);
        }
    }

    public void showGoodsContent() {
        this.mBottomButton.setVisibility(0);
        this.mShadowConstrain.setVisibility(0);
        this.mStickyHeaderContainer.setVisibility(0);
    }

    public void hideGoodsContent() {
        this.mStickyHeaderContainer.setVisibility(4);
        this.mBottomButton.setVisibility(4);
        this.mShadowConstrain.setVisibility(4);
    }

    public void bindGoodsPurchaseCounter(GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel, GoodsQuantityListener goodsQuantityListener) {
        this.mGoodsPurchaseCounter.setVisibility(0);
        this.mGoodsPurchaseCounter.bindData(goodsPurchaseCounterRvModel, goodsQuantityListener);
    }

    public void hideAbnormalView() {
        this.mAbnormalView.setVisibility(4);
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(topGunAbnormalViewModel);
    }

    public void hideBottomButton() {
        this.mBottomButton.setVisibility(4);
        this.mShadowConstrain.setVisibility(4);
    }

    public void showBottomButton() {
        this.mBottomButton.setVisibility(0);
        this.mShadowConstrain.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_goods_purchase_v2, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), getView());
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f44978f);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new GoodsPurchaseHeaderBinder() {
            public void onBind(View view, View view2, View view3) {
                View unused = GoodsPurchaseView.this.f44976d = view;
                View unused2 = GoodsPurchaseView.this.f44975c = view2;
                View unused3 = GoodsPurchaseView.this.f44974b = view3;
            }

            public void onPurchaseTagClick(String str, String str2, String str3) {
                RuleDescEntity ruleDescEntity = new RuleDescEntity();
                ruleDescEntity.title = str;
                ruleDescEntity.content = str2;
                ruleDescEntity.btnDesc = str3;
                DiRouter.request().path("priceRuleDescPage").putSerializable("entity", ruleDescEntity).open();
            }
        });
        registerBinder(new GoodsPurchaseTitleBinder());
    }

    /* renamed from: a */
    private void m33352a(String str) {
        LogUtil.m32584d(f44973a, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33350a() {
        if (this.f44975c != null && this.f44974b != null && this.f44976d != null && ViewSafeHelper.safeIndexOfView(this.mRecyclerView, this.f44976d) >= 0) {
            int[] iArr = new int[2];
            this.mTitleView.getLocationInWindow(iArr);
            if (this.f44974b.getVisibility() == 0) {
                int[] iArr2 = new int[2];
                this.f44974b.getLocationInWindow(iArr2);
                this.mTitleView.setBackgroundColor(((Integer) this.f44977e.evaluate(Math.min(1.0f, ((float) Math.max(0, (iArr[1] - iArr2[1]) - (this.f44974b.getHeight() / 2))) / ((float) ((this.f44974b.getHeight() - this.mTitleView.getHeight()) - (this.f44974b.getHeight() / 2)))), Integer.valueOf(Color.argb(0, 255, 255, 255)), Integer.valueOf(Color.argb(255, 255, 255, 255)))).intValue());
                int[] iArr3 = new int[2];
                this.f44975c.getLocationInWindow(iArr3);
                float min = Math.min(1.0f, ((float) Math.max(0, ((this.mTitleView.getHeight() + iArr[1]) - this.f44975c.getHeight()) - iArr3[1])) / ((float) this.f44975c.getHeight()));
                this.mTitleTvView.setAlpha(min);
                float f = 1.0f - min;
                this.mBackBg.setAlpha(f);
                this.f44975c.setAlpha(f);
            }
        }
    }

    /* renamed from: b */
    private Interpolator m33355b() {
        return CustomerInterpolator.newInstance();
    }
}
