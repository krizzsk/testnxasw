package com.didi.soda.customer.base.pages;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.soda.customer.annotation.SupportCart;
import com.didi.soda.customer.annotation.SupportFloatingCart;
import com.didi.soda.customer.annotation.SupportInnerDialog;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.component.floatingcarprovider.FloatingCartProviderProxy;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartComponent;
import com.didi.soda.customer.component.provider.CartProviderProxy;
import com.didi.soda.customer.component.provider.ICartProvider;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.listener.PageClickableListener;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.router.HubTable;
import com.didi.soda.router.IHubHandler;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;

public abstract class CustomerPage extends Page implements PageClickableListener, IHubHandler {
    public static final String PAGE_NAME = "PageName";

    /* renamed from: a */
    private static final String f42930a = "CustomerPage";

    /* renamed from: b */
    private CustomerPageDelegate f42931b = new CustomerPageDelegate(this, false);

    /* renamed from: c */
    private DialogInstrument f42932c;

    /* renamed from: d */
    private boolean f42933d = false;

    /* renamed from: e */
    private Request f42934e = null;

    public boolean getTouchIntercept() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return false;
    }

    public void onInitialize() {
        super.onInitialize();
        this.f42931b.onInitialize(this);
    }

    public String alias() {
        return HubTable.getPageId(getClass());
    }

    public View getPageView() {
        return getView();
    }

    public ControllerChangeHandler getPopHandler() {
        return this.f42931b.mo108218b();
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f42931b.mo108216a();
    }

    public void onCreate(View view) {
        CustomerSystemUtil.setStatusBarBgLightning(isStatusBarLightning());
        this.f42931b.onCreate();
        getScopeContext().attach("PageName", alias());
        getScopeContext().attach("fromPage", alias());
        super.onCreate(view);
        m32094b();
        m32092a();
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", alias()).build().track();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f42931b.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f42931b.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f42931b.onStop();
    }

    public void finish() {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (!PageBackHelper.Companion.popBackStack(this, false)) {
            super.finish(bundle);
        }
    }

    public void setShowPolicyDialog(boolean z) {
        this.f42933d = z;
    }

    public void openPolicyInterruptRoute() {
        Request request;
        if (!this.f42933d && (request = this.f42934e) != null) {
            this.f42931b.mo108217a(request);
            this.f42934e = null;
        }
    }

    public void openRoute(Request request, Response response) {
        if (m32093a(request.getExtras())) {
            this.f42931b.mo108217a(request);
        } else if (this.f42933d) {
            this.f42934e = request;
        } else {
            this.f42931b.mo108217a(request);
        }
    }

    /* renamed from: a */
    private boolean m32093a(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        if (bundle.getBoolean(Const.PageParams.POLICY_DETAIL_PAGE, false)) {
            return true;
        }
        Bundle bundle2 = bundle.getBundle("webpagebundle");
        return bundle2 != null && bundle2.getBoolean(Const.PageParams.POLICY_DETAIL_PAGE, false);
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
        super.setupComponents(view);
        m32096d();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: a */
    private void m32092a() {
        if (((SupportFloatingCart) getClass().getAnnotation(SupportFloatingCart.class)) != null) {
            ViewGroup c = m32095c();
            String string = getScopeContext().getBundle().getString("current_shop_id");
            if (TextUtils.isEmpty(string)) {
                LogUtil.m32588i(f42930a, "must put shopId in scopeContext");
                return;
            }
            IFloatingCartComponent createFloatingCartComponent = ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).createFloatingCartComponent(c, string);
            if (createFloatingCartComponent != null) {
                addComponent(createFloatingCartComponent);
                getScopeContext().attach("service_floating_cart_key", new FloatingCartProviderProxy(createFloatingCartComponent));
            }
        }
    }

    /* renamed from: b */
    private void m32094b() {
        ICartProvider createGlobalMiniCartComponent;
        if (((SupportCart) getClass().getAnnotation(SupportCart.class)) != null && (createGlobalMiniCartComponent = ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).createGlobalMiniCartComponent(m32095c())) != null) {
            if (createGlobalMiniCartComponent instanceof Component) {
                addComponent((Component) createGlobalMiniCartComponent);
            }
            getScopeContext().attach("service_cart_key", new CartProviderProxy(createGlobalMiniCartComponent));
        }
    }

    /* renamed from: c */
    private ViewGroup m32095c() {
        ViewGroup viewGroup = (ViewGroup) getView().findViewWithTag(getResources().getString(R.string.customer_cart_container_tag));
        if (viewGroup != null) {
            return viewGroup;
        }
        FrameLayout frameLayout = new FrameLayout(getBaseContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        ((ViewGroup) getView()).addView(frameLayout);
        return frameLayout;
    }

    /* renamed from: d */
    private void m32096d() {
        if (((SupportInnerDialog) getClass().getAnnotation(SupportInnerDialog.class)) != null) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewWithTag(getResources().getString(R.string.customer_dialog_container_tag));
            if (viewGroup == null) {
                viewGroup = new FrameLayout(getBaseContext());
                viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ((ViewGroup) getView()).addView(viewGroup);
            }
            DialogFrameLayout dialogFrameLayout = new DialogFrameLayout(getBaseContext());
            dialogFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(dialogFrameLayout);
            this.f42932c = new DialogInstrument(dialogFrameLayout);
            if (getScopeContext() != null) {
                getScopeContext().attach("dialog_instrument", this.f42932c);
                getScopeContext().attach("dialog_instrument_frame", dialogFrameLayout);
            }
        }
    }
}
