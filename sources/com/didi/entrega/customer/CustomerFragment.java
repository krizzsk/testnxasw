package com.didi.entrega.customer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.PageInstrumentFactory;
import com.didi.app.nova.skeleton.Skeleton;
import com.didi.app.nova.skeleton.conductor.ChangeHandlerFrameLayout;
import com.didi.app.nova.skeleton.conductor.embed.FragmentLifecycle;
import com.didi.app.nova.skeleton.image.Fly;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.entrega.customer.app.FlyInitializer;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.flutter.FlutterInitialisation;
import com.didi.entrega.customer.foundation.fusion.CustomerRFusionManager;
import com.didi.entrega.customer.foundation.log.lifecycle.SkeletonTracer;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.map.location.LocationRepo;
import com.didi.entrega.customer.foundation.p113im.ImMessageHelper;
import com.didi.entrega.customer.foundation.skin.SkinUtil;
import com.didi.entrega.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.entrega.customer.foundation.util.AndroidBug5497Workaround;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.OnceActionUtil;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.mlocale.LocaleServiceEmb;
import com.didi.entrega.customer.p114h5.WebHelper;
import com.didi.entrega.customer.repo.CustomerActivityResultRepo;
import com.didi.entrega.customer.repo.CustomerFragmentInitRepo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.customer.widget.dialog.CustomerDialogFrameLayout;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.entrega.home.manager.HomeOmegaHelper;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.order.pool.OrderMixService;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.IRouterCallback;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.taxis99.R;

public class CustomerFragment extends BizEntranceFragment implements KeyEvent.Callback {

    /* renamed from: a */
    private static final String f21483a = "CustomerFragment";

    /* renamed from: b */
    private FragmentLifecycle f21484b;

    /* renamed from: c */
    private PageInstrument f21485c;

    /* renamed from: d */
    private CustomerDialogFrameLayout f21486d;

    /* renamed from: e */
    private boolean f21487e;

    /* renamed from: f */
    private View f21488f;

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public void onAttach(final Context context) {
        super.onAttach(context);
        LogUtil.m18185i(f21483a, getClass().getName() + "onAttach");
        SkinUtil.initSkinConfig();
        WebHelper.init((Application) context.getApplicationContext());
        ImMessageHelper.getInstance().setRiderCommonWords(context);
        CustomerRFusionManager.initRFusion((Application) context.getApplicationContext());
        DiRouter.init("taxis99OneTravel://sodaEntrega", (IRouterCallback) null);
        this.f21484b = PageInstrumentFactory.install(this);
        CustomerApplicationLifecycleHandler.getInstance().initLifecycle(getActivity().getApplication());
        FlyInitializer.init(getContext().getApplicationContext());
        Skeleton.setLifeTracer(new SkeletonTracer());
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
            }

            public void onLocationSuccess(LatLng latLng) {
                ((LocationRepo) RepoFactory.getRepo(LocationRepo.class)).reverseLocation(context, LocationUtil.getCurrentLatLng());
            }
        });
        if (getContext() != null) {
            String locale = MultiLocaleUtil.getLanguageModel().getLocale();
            if (TextUtils.isEmpty(locale)) {
                locale = "en-US";
            }
            LocaleServiceEmb.getInstance().initEmb(getContext(), locale);
            ConversionOmegaHelper.trackLocaleEmb(locale, MultiLocaleUtil.getLanguageModel().getLang(), LocaleUtils.getSysLocaleTag(), ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!m18070b()) {
            return m18068a(layoutInflater, viewGroup, bundle);
        }
        if (this.f21488f == null) {
            this.f21488f = m18068a(layoutInflater, viewGroup, bundle);
        }
        return this.f21488f;
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m18185i(f21483a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
        SchemeHelper.recycle();
        this.f21487e = false;
        if (!GlobalContext.isFragmentInited()) {
            OrderMixService.getInstance().stop();
        }
        Fly.clearMemory();
    }

    public void onDetach() {
        super.onDetach();
        m18071c();
        if (!GlobalContext.isSuperApp()) {
            HomeOmegaHelper.Companion.trackHomeBack(2);
        }
        LogUtil.m18185i(f21483a, "onDetach");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f21484b.onActivityResult(i, i2, intent);
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).dispatchResult(i, i2, intent);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f21484b.onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        PageInstrument pageInstrument = this.f21485c;
        boolean z = true;
        if (pageInstrument == null) {
            return true;
        }
        if (pageInstrument.getBackstackSize() != 1) {
            z = false;
        }
        boolean handleBack = this.f21485c.handleBack();
        if (z) {
            return false;
        }
        return handleBack;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f21484b.onOptionsItemSelected(menuItem);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f21484b.onPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f21484b.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onStart() {
        super.onStart();
        AndroidBug5497Workaround.getInstance(getActivity()).assistGlobalDialog(this.f21486d);
    }

    public void onStop() {
        super.onStop();
        AndroidBug5497Workaround.getInstance(getActivity()).destroyGlobal();
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.f21484b.shouldShowRequestPermissionRationale(str);
    }

    public void onLeaveHome() {
        super.onLeaveHome();
        LogUtil.m18185i(f21483a, "onLeaveHome");
        GlobalContext.setInHome(false);
    }

    public void onBackToHome() {
        super.onBackToHome();
        LogUtil.m18185i(f21483a, "onBackToHome");
        GlobalContext.setInHome(true);
        if (GlobalContext.isInRoot()) {
            GlobalContext.getTitleAndBizBarManager().showTitleBarAndBizBar();
        } else {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
    }

    public boolean isFragmentInited() {
        return this.f21487e;
    }

    /* renamed from: a */
    private View m18068a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        GlobalContext.setBusinessContext(getBusinessContext());
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.fragment_entrega_customer, viewGroup, false);
        ChangeHandlerFrameLayout changeHandlerFrameLayout = (ChangeHandlerFrameLayout) frameLayout.findViewById(R.id.entrega_conductor_root_layout);
        changeHandlerFrameLayout.setPadding(0, 0, 0, 0);
        this.f21485c = PageInstrumentFactory.create(this, changeHandlerFrameLayout, bundle);
        FlutterInitialisation.initFlutter(getActivity().getApplicationContext(), this.f21485c);
        GlobalContext.setPageInstrument(this.f21485c);
        LogUtil.m18185i(f21483a, getClass().getName() + "innerCreateView = " + this);
        GlobalContext.setFragment(this);
        if (!this.f21485c.hasRootPage()) {
            this.f21485c.setRootPage(m18069a());
        }
        CustomerDialogFrameLayout customerDialogFrameLayout = (CustomerDialogFrameLayout) frameLayout.findViewById(R.id.entrega_loading_root_layout);
        this.f21486d = customerDialogFrameLayout;
        this.f21485c.attachDialogFrame(customerDialogFrameLayout);
        this.f21487e = true;
        OrderMixService.getInstance().start();
        SchemeHelper.delayOpenPage();
        ToastUtil.bindToastContainer(frameLayout);
        CustomerFragmentInitRepo.getInstance().setValue(true);
        return frameLayout;
    }

    /* renamed from: a */
    private CustomerMainPage m18069a() {
        CustomerMainPage customerMainPage = new CustomerMainPage();
        customerMainPage.setArgs(getArguments());
        return customerMainPage;
    }

    /* renamed from: b */
    private boolean m18070b() {
        if (getArguments() != null) {
            return getArguments().getBoolean(CustomerSABusiness.KEY_SUPER_APP, false);
        }
        return false;
    }

    /* renamed from: c */
    private void m18071c() {
        SingletonFactory.clear();
        RepoFactory.clearAll();
        CustomerFragmentInitRepo.getInstance().clear();
        CustomerApplicationLifecycleHandler.getInstance().clear();
        OnceActionUtil.resetGlobalActions();
        SodaWindowFactory.clearLoadingDialog();
        Fly.clearMemory();
        this.f21488f = null;
    }
}
