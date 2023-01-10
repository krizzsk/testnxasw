package com.didi.soda.business.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.business.component.dynamic.search.BusinessDyHotWordComponent;
import com.didi.soda.business.component.dynamic.search.BusinessDySearchComponent;
import com.didi.soda.business.component.search.AbBusinessHotWordComponent;
import com.didi.soda.business.component.search.AbBusinessSearchComponent;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.customer.annotation.SupportFloatingCart;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.component.businessgoods.AddToCartAnimationComponent;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route(interceptors = {BusinessSearchPageInterceptor.class}, value = {"businessSearchPage"})
@SupportFloatingCart
public class BusinessSearchPage extends CustomerPage implements BusinessSearchChangeListener, OnPlayAddToCartAnimation {

    /* renamed from: a */
    AbBusinessHotWordComponent f42336a;

    /* renamed from: b */
    AbBusinessSearchComponent f42337b;

    /* renamed from: c */
    AddToCartAnimationComponent f42338c;
    @BindView(17753)
    ViewGroup mAddAnimationContainer;
    @BindView(18136)
    FrameLayout mBusinessCartContainer;
    @BindView(18146)
    FrameLayout mBusinessHotWordContainer;
    @BindView(18144)
    FrameLayout mBusinessSearchContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public BusinessSearchPage() {
        DiRouter.registerHub(RoutePath.BUSINESS_SEARCH_HOME, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        String string = getScopeContext().getBundle().getString(Const.PageParams.CART_REVISION);
        int i = getScopeContext().getBundle().getInt(Const.PageParams.SHOP_STATUS);
        String string2 = getScopeContext().getBundle().getString(Const.PageParams.BIDATA);
        if (!TextUtils.isEmpty(string)) {
            ((IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")).showFloatingCart(string, i, string2, false);
        }
    }

    public ControllerChangeHandler getPopHandler() {
        return new BusinessSearchChangeHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        return new BusinessSearchChangeHandler();
    }

    public void showRecommendWord() {
        if (this.f42336a == null) {
            int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_124);
            this.f42336a = new BusinessDyHotWordComponent(this.mBusinessHotWordContainer);
            m31830a(dimensionPixelSize);
            this.f42336a.setRecommendWordListener(this.f42337b);
            addComponent(this.f42336a);
        }
    }

    public void hideRecommendWord() {
        AbBusinessHotWordComponent abBusinessHotWordComponent = this.f42336a;
        if (abBusinessHotWordComponent != null) {
            removeComponent(abBusinessHotWordComponent);
            this.f42336a = null;
        }
    }

    public void showFloatingCart() {
        this.mBusinessCartContainer.setVisibility(0);
    }

    public void hideFloatingCart() {
        this.mBusinessCartContainer.setVisibility(4);
    }

    public boolean onHandleBack() {
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key");
        if (iFloatingCartProvider != null && iFloatingCartProvider.isFloatingCartExpand()) {
            return true;
        }
        AbBusinessSearchComponent abBusinessSearchComponent = this.f42337b;
        if (abBusinessSearchComponent != null) {
            abBusinessSearchComponent.goBack();
        }
        return super.onHandleBack();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_business_search_home, viewGroup, false);
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        AbBusinessSearchComponent abBusinessSearchComponent = this.f42337b;
        if (abBusinessSearchComponent != null && bundle != null) {
            abBusinessSearchComponent.onPageResult(bundle);
        }
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        this.f42337b = new BusinessDySearchComponent(this.mBusinessSearchContainer);
        this.f42336a = new BusinessDyHotWordComponent(this.mBusinessHotWordContainer);
        m31830a(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_124));
        this.f42337b.setBusinessSearchChangeListener(this);
        this.f42337b.setOnPlayAddToCartAnimation(this);
        addComponent(this.f42337b);
        this.f42336a.setRecommendWordListener(this.f42337b);
        addComponent(this.f42336a);
        AddToCartAnimationComponent addToCartAnimationComponent = new AddToCartAnimationComponent(this.mAddAnimationContainer);
        this.f42338c = addToCartAnimationComponent;
        addComponent(addToCartAnimationComponent);
    }

    /* renamed from: a */
    private void m31830a(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBusinessHotWordContainer.getLayoutParams();
        layoutParams.topMargin = i;
        this.mBusinessHotWordContainer.setLayoutParams(layoutParams);
    }

    public void playAddToCartAnimation(int[] iArr, String str) {
        AddToCartAnimationComponent addToCartAnimationComponent = this.f42338c;
        if (addToCartAnimationComponent != null) {
            addToCartAnimationComponent.playAddToCartAnimation(iArr, str);
        }
    }
}
