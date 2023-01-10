package com.didi.entrega.home.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.entrega.customer.CustomerSABusiness;
import com.didi.entrega.customer.annotation.SupportInnerDialog;
import com.didi.entrega.customer.app.ApplicationForegroundListener;
import com.didi.entrega.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.component.error.ErrorHandleComponent;
import com.didi.entrega.customer.component.login.LoginLogicComponent;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.home.component.abnormal.HomeAddressAbnormalComponent;
import com.didi.entrega.home.component.feed.HomeFeedComponent;
import com.didi.entrega.home.component.noservice.HomeNoServiceComponent;
import com.didi.entrega.home.delegate.CustomerApplicationForegroundImpl;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerHomeManager;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.entrega.router.annotations.RouteIndex;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.taxis99.R;
import p218io.flutter.embedding.engine.FlutterEngine;

@SupportInnerDialog
@Route({"taxis99OneTravel://sodaEntrega"})
@RouteIndex(host = {"taxis99OneTravel://sodaEntrega"})
public class CustomerMainPage extends CustomerPage {

    /* renamed from: a */
    private static final String f22563a = "CustomerMainPage";

    /* renamed from: b */
    private ApplicationForegroundListener f22564b;

    /* renamed from: c */
    private FlutterEngine f22565c = null;
    @BindView(16894)
    FrameLayout mFeedContainer;
    @BindView(16895)
    FrameLayout mHomeNoServiceContainer;
    @BindView(16940)
    ViewGroup mMainPageContainer;
    @BindView(16898)
    FrameLayout mNoAddressContianer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public boolean onHandleBack() {
        return true;
    }

    public CustomerMainPage() {
        DiRouter.registerHub("taxis99OneTravel://sodaEntrega", this);
        DiRouter.registerIndexHub("taxis99OneTravel://sodaEntrega", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        LogUtil.m18185i(f22563a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
        m18567b();
        this.f22564b = new CustomerApplicationForegroundImpl(getScopeContext());
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f22564b);
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
        m18567b();
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m18185i(f22563a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f22564b);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new HomeFeedComponent(this.mFeedContainer));
        addComponent(new LoginLogicComponent(this.mMainPageContainer));
        addComponent(new ErrorHandleComponent(this.mMainPageContainer));
        addComponent(new HomeNoServiceComponent(this.mHomeNoServiceContainer));
        addComponent(new HomeAddressAbnormalComponent(this.mNoAddressContianer));
        m18564a();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.page_entrega_home, viewGroup, false);
        m18566a((ViewGroup) (FrameLayout) inflate.findViewById(R.id.customer_custom_main_drawer));
        return inflate;
    }

    public void onResume() {
        super.onResume();
        LogUtil.m18185i(f22563a, "onResume");
    }

    public void onPause() {
        super.onPause();
        LogUtil.m18185i(f22563a, "onPause");
    }

    public void onStop() {
        super.onStop();
        LogUtil.m18185i(f22563a, "onStop");
    }

    /* renamed from: a */
    private void m18566a(ViewGroup viewGroup) {
        if ((getScopeContext() == null || getScopeContext().getBundle() == null) ? false : getScopeContext().getBundle().getBoolean(CustomerSABusiness.KEY_SUPER_APP, false)) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_home_back_view, viewGroup, false);
            viewGroup.addView(inflate);
            inflate.setOnClickListener($$Lambda$CustomerMainPage$0POowh_29ZYDYMwDPGBLvcCG6Y.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18565a(View view) {
        HomeOmegaHelper.Companion.trackHomeBack(1);
        GlobalContext.popBackStack();
    }

    /* renamed from: a */
    private void m18564a() {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(1);
        LogUtil.m18185i(f22563a, "initAddress");
    }

    /* renamed from: b */
    private void m18567b() {
        GlobalContext.getTitleAndBizBarManager().showTitleBarAndBizBar();
    }
}
