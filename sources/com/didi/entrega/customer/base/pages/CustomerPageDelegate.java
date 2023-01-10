package com.didi.entrega.customer.base.pages;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.customer.app.CustomerPageManager;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.base.pages.changehandler.CustomerHorizontalChangeHandler;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.listener.PageClickableListener;
import com.didi.entrega.customer.p114h5.CustomerWebLauncher;
import com.didi.entrega.customer.p114h5.CustomerWebPage;
import com.didi.entrega.home.page.CustomerMainPage;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.page.WebPage;
import com.didichuxing.omega.sdk.Omega;
import java.io.Serializable;
import java.util.HashMap;

public class CustomerPageDelegate {
    public static final int PAGE_ANIMATION_DURATION = 200;

    /* renamed from: a */
    private static final String f21664a = "CustomerPageDelegate";

    /* renamed from: b */
    private Page f21665b;

    /* renamed from: c */
    private boolean f21666c;

    public void onInitialize(Page page) {
    }

    public CustomerPageDelegate(Page page, boolean z) {
        this.f21665b = page;
        this.f21666c = z;
    }

    public void onCreate() {
        CustomerPageManager.getInstance().setCurrentPage(this.f21665b.getClass());
        ScopeContext scopeContext = this.f21665b.getScopeContext();
        if (scopeContext != null) {
            scopeContext.attach("ScopeContextPageId", this.f21665b.alias());
            scopeContext.attach("ScopeContextPageIdentification", this.f21665b.alias() + "@" + this.f21665b);
            return;
        }
        LogUtil.m18183e(f21664a, "scopeContext == null");
    }

    public void onResume() {
        CustomerPageManager.getInstance().setCurrentPage(this.f21665b.getClass());
    }

    public void onStart(View view, int i) {
        OmegaTracker.Builder.create("sailing_c_x_page_entry").addEventParam("pageName", CustomerPageManager.getInstance().getPageName(this.f21665b.getClass())).build().track();
        Omega.firePageResumed(this.f21665b);
        if (!this.f21666c) {
            if (view != null) {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
            }
            m18102a(m18105c());
        }
    }

    public void onStop() {
        Omega.firePagePaused(this.f21665b);
        OmegaTracker.Builder.create("sailing_c_x_page_leave").addEventParam("pageName", CustomerPageManager.getInstance().getPageName(this.f21665b.getClass())).build().track();
    }

    public void finish() {
        if (PageBackHelper.Companion.popBackStack(this.f21665b)) {
            GlobalContext.popBackStack();
        } else {
            this.f21665b.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (PageBackHelper.Companion.popBackStack(this.f21665b)) {
            GlobalContext.popBackStack();
        } else {
            this.f21665b.finish(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ControllerChangeHandler mo64603a() {
        return new CustomerHorizontalChangeHandler(200, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ControllerChangeHandler mo64605b() {
        return new CustomerHorizontalChangeHandler(200, true);
    }

    public void openRoute(Request request) {
        if (request != null) {
            Class<?> target = request.getTarget();
            if (target == null) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_ROUTER_OPEN).addModuleName("router").addErrorType("null").addErrorMsg("openRoute request target is null").addParam("request_path", String.valueOf(request.getPath())).addParam("extra", String.valueOf(request.getExtras())).build().trackError();
                return;
            }
            if (this.f21665b.isDestroyed()) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_ROUTER_OPEN).addModuleName("router").addErrorType("destory").addErrorMsg("CustomerMainPage 销毁后收到跳转请求").addParam("request_path", String.valueOf(request.getPath())).addParam("extra", String.valueOf(request.getExtras())).build().trackError();
            }
            if (!m18103a(request.getPath())) {
                m18104b(request);
                if (!mo64604a(request)) {
                    if (Page.class.isAssignableFrom(target)) {
                        Bundle extras = request.getExtras();
                        if (WebPage.class.isAssignableFrom(target)) {
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.putString("url", request.getPath());
                        }
                        m18101a(request, target, extras);
                    } else if (Activity.class.isAssignableFrom(target)) {
                        Intent intent = new Intent(this.f21665b, target);
                        if (request.getExtras() != null) {
                            intent.putExtras(request.getExtras());
                        }
                        this.f21665b.startActivityForResult(intent, 0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo64604a(Request request) {
        return m18107d(request) || m18106c(request);
    }

    /* renamed from: a */
    private boolean m18103a(String str) {
        if (LoginUtil.isLogin() || TextUtils.isEmpty(str) || !str.contains("payMethodPage")) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m18104b(Request request) {
        Class<?> target = request.getTarget();
        boolean z = target != null && CustomerMainPage.class.isAssignableFrom(target);
        if (!TextUtils.isEmpty(this.f21665b.alias()) && "homePage".equals(this.f21665b.alias()) && !z) {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
    }

    /* renamed from: a */
    private void m18101a(Request request, Class cls, Bundle bundle) {
        Page newInstance = PageFactory.newInstance(cls, bundle);
        if (newInstance != null) {
            PageInstrument instrument = this.f21665b.getInstrument();
            if (!instrument.hasRootPage()) {
                instrument.setRootPage(newInstance);
            } else if (request.getFromPage() instanceof ScopeContext) {
                ((ScopeContext) request.getFromPage()).getNavigator().pushForResult(newInstance);
            } else {
                this.f21665b.pushForResult(newInstance);
            }
        }
    }

    /* renamed from: c */
    private boolean m18106c(Request request) {
        Bundle extras = request.getExtras();
        if (extras != null) {
            String string = extras.getString("schem_from");
            extras.remove("schem_from");
            String string2 = extras.getString("schemeAssistPath");
            extras.remove("schemeAssistPath");
            if (TextUtils.isEmpty(string) || !string.equals("webPage")) {
                if (string2 != null) {
                    RecordTracker.Builder.create().setTag(this.f21665b.alias()).setMessage("interceptSchemeOpen").setOtherParam("request_path", request.getPath()).setOtherParam("extra", String.valueOf(extras)).build().info();
                    this.f21665b.popToRoot();
                    if (!string2.equals("taxis99OneTravel://sodaEntrega")) {
                        DiRouter.request().path(string2).params(extras).open();
                    }
                    return true;
                }
            } else if (!"taxis99OneTravel://sodaEntrega".equals(string2)) {
                return false;
            } else {
                this.f21665b.popToRoot();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m18100a(String str, Bundle bundle) {
        String str2;
        if (!CustomerApolloUtil.isOpenWebAppendParam()) {
            return str;
        }
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str3 : bundle.keySet()) {
                if (!TextUtils.equals("url", str3)) {
                    if (!TextUtils.equals("urlstr", str3)) {
                        Object obj = bundle.get(str3);
                        if (obj != null) {
                            buildUpon.appendQueryParameter(str3, Uri.encode(obj.toString()));
                        }
                    }
                }
            }
            str2 = buildUpon.toString();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = str;
        }
        OmegaTracker.Builder.create(EventConst.Conversion.WEB_APPEND_PARAM).addEventParam("originurl", str).addEventParam("url", str2).build().track();
        return str2;
    }

    /* renamed from: d */
    private boolean m18107d(Request request) {
        Class<?> target = request.getTarget();
        if (target == null || !CustomerWebPage.class.isAssignableFrom(target)) {
            return false;
        }
        Bundle extras = request.getExtras();
        WebConfig webConfig = new WebConfig();
        if (extras != null) {
            String string = extras.getString("url");
            if (TextUtils.isEmpty(string)) {
                string = extras.getString("urlstr");
            }
            webConfig.url = m18100a(string, extras);
            webConfig.title = extras.getString("title");
            Serializable serializable = extras.getSerializable("params");
            if (serializable instanceof HashMap) {
                webConfig.mCustomerParameters = (HashMap) serializable;
            }
        }
        if (TextUtils.isEmpty(webConfig.url)) {
            return false;
        }
        RecordTracker.Builder.create().setTag(this.f21665b.alias()).setMessage("interceptWebPage").setOtherParam("request_path", request.getPath()).setOtherParam("extra", String.valueOf(extras)).build().info();
        CustomerWebLauncher.launchWebPage(request, webConfig, true, extras, target);
        return true;
    }

    /* renamed from: c */
    private boolean m18105c() {
        Page page = this.f21665b;
        if (page instanceof PageClickableListener) {
            return ((PageClickableListener) page).getTouchIntercept();
        }
        return true;
    }

    /* renamed from: a */
    private void m18102a(boolean z) {
        View pageView;
        Page page = this.f21665b;
        if ((page instanceof PageClickableListener) && (pageView = ((PageClickableListener) page).getPageView()) != null) {
            pageView.setClickable(z);
        }
    }
}
