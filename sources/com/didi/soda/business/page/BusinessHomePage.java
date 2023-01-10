package com.didi.soda.business.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.business.component.dynamic.home.BusinessDyComponent;
import com.didi.soda.business.component.notice.BusinessDynamicNoticeComponent;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.customer.annotation.SupportFloatingCart;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.pages.changehandler.CustomerHorizontalChangeHandler;
import com.didi.soda.customer.component.businessgoods.AddToCartAnimationComponent;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.coordshop.CoordShopManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.AnchorInfo;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

@Route(interceptors = {BusinessHomePageInterceptor.class}, value = {"businessPage"})
@SupportFloatingCart
public class BusinessHomePage extends CustomerPage implements BusinessCategoryListener, OnPlayAddToCartAnimation {

    /* renamed from: a */
    private static final String f42327a = "BusinessHomePage";

    /* renamed from: b */
    private BusinessDyComponent f42328b;

    /* renamed from: c */
    private BusinessSelectedCallback f42329c;

    /* renamed from: d */
    private boolean f42330d = true;

    /* renamed from: e */
    private AddToCartAnimationComponent f42331e;
    @BindView(17753)
    FrameLayout mAddCartAnimationContainer;
    @BindView(18139)
    FrameLayout mBusinessDetailContainer;
    @BindView(17858)
    ConstraintLayout mBusinessHomeParent;
    @BindView(18142)
    FrameLayout mBusinessMenuContainer;
    @BindView(18148)
    FrameLayout mCartContainer;
    @BindView(18137)
    FrameLayout mCategoryContainer;
    @BindView(18140)
    FrameLayout mDynamicNoticeContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public BusinessHomePage() {
        DiRouter.registerHub(RoutePath.BUSINESS_HOME, this);
    }

    /* renamed from: a */
    private static AnchorInfo m31828a(Bundle bundle) {
        AnchorInfo anchorInfo = null;
        try {
            String string = bundle.getString(Const.PageParams.ACTION_INFO);
            if (TextUtils.isEmpty(string)) {
                string = bundle.getString(Const.PageParams.ACTION_INFO_DICT);
            }
            if (TextUtils.isEmpty(string)) {
                string = bundle.getString(Const.PageParams.ACTION_INFO_DICT2);
            }
            ActionInfoEntity actionInfoEntity = (ActionInfoEntity) GsonUtil.fromJson(string, ActionInfoEntity.class);
            if (actionInfoEntity == null) {
                return null;
            }
            AnchorInfo anchorInfo2 = new AnchorInfo();
            try {
                anchorInfo2.itemId = actionInfoEntity.itemId;
                if (actionInfoEntity.getType() == 2) {
                    anchorInfo2.actionType = 1;
                } else if (actionInfoEntity.getType() == 3) {
                    anchorInfo2.actionType = 2;
                }
                return anchorInfo2;
            } catch (Exception e) {
                e = e;
                anchorInfo = anchorInfo2;
                e.printStackTrace();
                return anchorInfo;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return anchorInfo;
        }
    }

    public static void requestBusinessData(ScopeContext scopeContext) {
        Bundle bundle = scopeContext.getBundle();
        String string = bundle.getString(Const.PageParams.SHOP_ID);
        String string2 = bundle.getString(Const.PageParams.BIDATA);
        String string3 = bundle.getString(Const.PageParams.SHOP_ITEM_SEARCH_INFO);
        AnchorInfo a = m31828a(bundle);
        String string4 = bundle.getString(Const.PageParams.ACT_INFO);
        ICustomerGoodsManager iCustomerGoodsManager = (ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class);
        iCustomerGoodsManager.setActInfoStr(string4);
        BusinessRepo.get(scopeContext).requestBusinessData(scopeContext, string, string2, string3, a, iCustomerGoodsManager.getActInfo());
    }

    public static void refreshBusinessData(ScopeContext scopeContext, Boolean bool) {
        Bundle bundle = scopeContext.getBundle();
        BusinessRepo.get(scopeContext).requestBusinessData(scopeContext, bundle.getString(Const.PageParams.SHOP_ID), bundle.getString(Const.PageParams.BIDATA), (String) null, (AnchorInfo) null, bool.booleanValue() ? ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getActInfo() : null);
    }

    public ControllerChangeHandler getPopHandler() {
        return super.getPopHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        if (getScopeContext().getBundle().getBoolean(Const.FlutterBundleKey.IS_FROM_ORDER_FLUTTER, false)) {
            return new CustomerHorizontalChangeHandler(200, false);
        }
        return super.getPushHandler();
    }

    public void onCreate(View view) {
        String string = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo((ActInfoEntity) null);
        requestBusinessData(getScopeContext());
        m31829a(string);
        super.onCreate(view);
    }

    public boolean onHandleBack() {
        if (this.f42330d) {
            return true;
        }
        IFloatingCartProvider iFloatingCartProvider = (IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key");
        if (iFloatingCartProvider != null && iFloatingCartProvider.isFloatingCartExpand()) {
            return true;
        }
        BusinessDyComponent businessDyComponent = this.f42328b;
        if (businessDyComponent != null) {
            return businessDyComponent.onBack();
        }
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f42330d = false;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new BusinessDynamicNoticeComponent(this.mDynamicNoticeContainer));
        BusinessDyComponent businessDyComponent = new BusinessDyComponent(this.mBusinessMenuContainer);
        this.f42328b = businessDyComponent;
        businessDyComponent.setBusinessCategoryListener(this);
        this.f42328b.setOnPlayAnimationListener(this);
        addComponent(this.f42328b);
        AddToCartAnimationComponent addToCartAnimationComponent = new AddToCartAnimationComponent(this.mAddCartAnimationContainer);
        this.f42331e = addToCartAnimationComponent;
        addComponent(addToCartAnimationComponent);
        CoordShopManager.Companion.get().triggerEnterBusinessEvent(this);
    }

    public void onPause() {
        super.onPause();
        this.f42330d = true;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_business_home, viewGroup, false);
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null) {
            if (BusinessCategoryMenuPage.VALUE_REFRESH_SELECTED_CATEGORY_FLAG != bundle.getInt(BusinessCategoryMenuPage.KEY_REFRESH_SELECTED_CATEGORY, -1)) {
                if (getScopeContext() != null) {
                    OmegaCommonParamHelper.updatePageGuideParam((GuideParam) getScopeContext().getObject("ScopeContextPageGuideParam"));
                }
                BusinessDyComponent businessDyComponent = this.f42328b;
                if (businessDyComponent != null) {
                    businessDyComponent.onPageResult(bundle);
                }
            } else if (this.f42329c != null) {
                this.f42329c.onSelectedCategory(bundle.getInt(BusinessCategoryMenuPage.PARAM_REFRESH_SELECTED_CATEGORY_INDEX, 0));
            }
        }
    }

    public void onDestroy() {
        ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).setActInfo((ActInfoEntity) null);
        super.onDestroy();
    }

    public void showDyCategory(List<BusinessCategoryMenuRvModel> list, BusinessSelectedCallback businessSelectedCallback) {
        if (getScopeContext() == null || getScopeContext().getLiveHandler() == null || getScopeContext().getLiveHandler().isDestroyed()) {
            LogUtil.m32584d(f42327a, "BusinessHomePage showDyCategory ScopeContext is null");
            return;
        }
        this.f42329c = businessSelectedCallback;
        String string = getScopeContext().getBundle() != null ? getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID) : "";
        Bundle bundle = new Bundle();
        bundle.putString(Const.PageParams.SHOP_ID, string);
        bundle.putSerializable(Const.PageParams.SHOP_CATEGORY_LIST, (Serializable) list);
        getScopeContext().getNavigator().pushForResult((BusinessCategoryMenuPage) PageFactory.newInstance(BusinessCategoryMenuPage.class, bundle));
    }

    /* renamed from: a */
    private void m31829a(String str) {
        Pattern compile = Pattern.compile("[0-9]*");
        if (str == null || !compile.matcher(str).matches()) {
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SHOP_ID_ERROR).addModuleName("shop").addErrorType(str).addErrorMsg("shopId should only Numbers").build().trackError();
        }
    }

    public void playAddToCartAnimation(int[] iArr, String str) {
        if (this.mAddCartAnimationContainer != null) {
            this.f42331e.playAddToCartAnimation(iArr, str);
        }
    }
}
