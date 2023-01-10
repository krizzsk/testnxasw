package com.didi.soda.home.page.deleagteimp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogCallBack;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogComponent;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.component.error.ErrorHandleComponent;
import com.didi.soda.customer.component.login.LoginLogicComponent;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.login.LoginOutListenerBridge;
import com.didi.soda.customer.foundation.push.CustomerPushReport;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.home.component.ICustomerComponent;
import com.didi.soda.home.component.abnormal.HomeAddressAbnormalComponent;
import com.didi.soda.home.component.bub.HomeBubComponent;
import com.didi.soda.home.component.noservice.HomeNoServiceComponent;
import com.didi.soda.home.component.noservice.lazy.HomeNoServiceLazyComponent;
import com.didi.soda.home.component.titlebar.HomeTitleBarComponent;
import com.didi.soda.home.component.titlebar.HomeTitleBarManager;
import com.didi.soda.home.component.web.WebHomeComponent;
import com.didi.soda.home.delegate.CustomerApplicationForegroundImpl;
import com.didi.soda.home.manager.CustomerDialogShownManager;
import com.didi.soda.home.manager.CustomerGuideManager;
import com.didi.soda.home.page.CustomerMainPageDelegate;
import com.didi.soda.home.topgun.component.feed.HomeFeedComponent;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class BaseCustomerMainPage extends CustomerMainPageDelegate {

    /* renamed from: c */
    private static final String f45196c = "CustomerMainPage";

    /* renamed from: a */
    HomeFeedComponent f45197a;

    /* renamed from: b */
    ICustomerComponent f45198b;

    /* renamed from: d */
    private PopDialogComponent f45199d;

    /* renamed from: e */
    private PopDialogComponent f45200e;

    /* renamed from: f */
    private Subscription f45201f;

    /* renamed from: g */
    private ApplicationForegroundListener f45202g = new CustomerApplicationForegroundImpl(getScopeContext());
    @BindView(17827)
    FrameLayout mCartContainer;
    @BindView(18159)
    FrameLayout mFeedContainer;
    @BindView(18160)
    FrameLayout mFilterContianer;
    @BindView(18171)
    FrameLayout mHomeNoServiceContainer;
    @BindView(18178)
    ViewGroup mHomeWebContainer;
    @BindView(18182)
    FrameLayout mLoadingViewContain;
    @BindView(18666)
    ViewGroup mMainPageContainer;
    @BindView(18184)
    FrameLayout mNoAddressContianer;
    @BindView(18174)
    ViewGroup mTaskBubContainer;
    @BindView(18215)
    ViewGroup mTitleBarContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public boolean onHandleBack() {
        return true;
    }

    public BaseCustomerMainPage(CustomerMainPageDelegate.CustomerPageCallback customerPageCallback) {
        super(customerPageCallback);
    }

    public void onInitialize() {
        super.onInitialize();
    }

    public void onCreate(View view) {
        super.onCreate(view);
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f45202g);
        m33540d();
        m33541e();
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        m33540d();
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        ICustomerComponent iCustomerComponent = this.f45198b;
        if (iCustomerComponent != null) {
            iCustomerComponent.onPageResult(bundle);
        }
        HomeFeedComponent homeFeedComponent = this.f45197a;
        if (homeFeedComponent != null) {
            homeFeedComponent.onPageResult(bundle);
        }
        if (bundle != null && bundle.getInt(Const.PageParams.SUB_FROM_SKU_CHECK_OUT, -1) == 7) {
            DiRouter.request().path(RoutePath.BILL_PAGE).params(bundle).open();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f45202g);
        m33539c();
        removeComponent(this.f45197a);
        this.f45197a = null;
        Subscription subscription = this.f45201f;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f45201f = null;
        }
        CustomerDialogShownManager.Companion.getInstance().removeAllListener();
        LoginOutListenerBridge.clearAllListeners();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.page_customer_home, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        this.f45201f = PopDialogHelper.addComponent(getScopeContext(), getBaseContext(), this.mMainPageContainer, m33535a(), new PopDialogCallBack() {
            public final void addPopDialogComponent(PopDialogComponent popDialogComponent) {
                BaseCustomerMainPage.this.m33537a(popDialogComponent);
            }
        });
        PopDialogHelper.setPopDialogVisible(getScopeContext(), 8);
        HomeFeedComponent homeFeedComponent = new HomeFeedComponent(this.mFeedContainer, getOwner());
        this.f45197a = homeFeedComponent;
        addComponent(homeFeedComponent);
        if (FallbackController.isOpenLazyComponent()) {
            HomeNoServiceLazyComponent homeNoServiceLazyComponent = new HomeNoServiceLazyComponent(this.mHomeNoServiceContainer);
            addComponent(homeNoServiceLazyComponent);
            this.f45198b = homeNoServiceLazyComponent;
        } else {
            HomeNoServiceComponent homeNoServiceComponent = new HomeNoServiceComponent(this.mHomeNoServiceContainer);
            addComponent(homeNoServiceComponent);
            this.f45198b = homeNoServiceComponent;
        }
        addComponent(new WebHomeComponent(this.mHomeWebContainer));
        addComponent(new LoginLogicComponent(this.mMainPageContainer));
        addComponent(new ErrorHandleComponent(this.mMainPageContainer));
        addComponent(new HomeTitleBarComponent(this.mTitleBarContainer));
        addComponent(new HomeAddressAbnormalComponent(this.mNoAddressContianer));
        addComponent(new HomeBubComponent(this.mTaskBubContainer));
        HomeTitleBarManager.getManager().bindTitleBar(this.mTitleBarContainer);
        m33538b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33537a(PopDialogComponent popDialogComponent) {
        boolean checkHomePopNeedShown = CustomerDialogShownManager.Companion.getInstance().checkHomePopNeedShown();
        LogUtil.m32584d(f45196c, "subscribPoupUpInfo--needShowHomePop=" + checkHomePopNeedShown + "---last=" + this.f45199d + "--new=" + popDialogComponent);
        if (checkHomePopNeedShown) {
            removeComponent(this.f45199d);
            this.f45199d = popDialogComponent;
            addComponent(popDialogComponent);
            return;
        }
        this.f45200e = popDialogComponent;
    }

    /* renamed from: a */
    private NAPopUpParamsEntity m33535a() {
        NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
        nAPopUpParamsEntity.reciveTriggerSet.add(1);
        nAPopUpParamsEntity.reciveTriggerSet.add(3);
        return nAPopUpParamsEntity;
    }

    /* renamed from: b */
    private void m33538b() {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(1);
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).registerGpsReceiver(getScopeContext(), getOwner());
        CustomerPushReport.getInstance().subScribeAddress(getScopeContext());
    }

    /* renamed from: c */
    private void m33539c() {
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).unRegisterGpsReceiver(getOwner());
    }

    /* renamed from: d */
    private void m33540d() {
        GlobalContext.getTitleAndBizBarManager().showTitleBarAndBizBar();
        this.mMainPageContainer.setPadding(0, 0, 0, GlobalContext.getTitleAndBizBarManager().getBizBarHeight());
    }

    /* renamed from: e */
    private void m33541e() {
        CustomerDialogShownManager.Companion.getInstance().addOnDialogShownChangeListener(new CustomerDialogShownManager.OnDialogShownChangeListener() {
            public final void onDialogShownChange(int i, int i2) {
                BaseCustomerMainPage.this.m33536a(i, i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33536a(int i, int i2) {
        LogUtil.m32584d(f45196c, "addDialogShownChangeListener--oldDialogType=" + i + "---newDialogType=" + i2 + "--mPreparedPopDailogComponent=" + this.f45200e);
        if (i != 0 && i2 == 0) {
            if (this.f45200e != null) {
                removeComponent(this.f45199d);
                PopDialogComponent popDialogComponent = this.f45200e;
                this.f45199d = popDialogComponent;
                addComponent(popDialogComponent);
                this.f45200e = null;
                return;
            }
            CustomerGuideManager.Companion.getInstance().triggerCustomerGuideInfoShown();
        }
    }
}
