package com.didi.soda.customer.base.pages;

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
import com.didi.soda.customer.app.CustomerPageManager;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.changehandler.CustomerHorizontalChangeHandler;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTracker;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.listener.PageClickableListener;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didi.soda.customer.p165h5.CustomerWebLauncher;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.home.page.CustomerMainPage;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.page.WebPage;
import com.didichuxing.omega.sdk.Omega;
import java.io.Serializable;
import java.util.HashMap;

public class CustomerPageDelegate {
    public static final int PAGE_ANIMATION_DURATION = 200;

    /* renamed from: a */
    private static final String f42935a = "CustomerPageDelegate";

    /* renamed from: b */
    private Page f42936b;

    /* renamed from: c */
    private PageRenderingTracker f42937c;

    /* renamed from: d */
    private PageRenderingTrackerNew f42938d;

    /* renamed from: e */
    private boolean f42939e;

    public CustomerPageDelegate(Page page, boolean z) {
        this.f42936b = page;
        this.f42939e = z;
        PageRenderingTracker pageRenderingTracker = new PageRenderingTracker(page.alias());
        this.f42937c = pageRenderingTracker;
        pageRenderingTracker.trackStart();
    }

    public void onInitialize(Page page) {
        PageRenderingTrackerNew pageRenderingTrackerNew = new PageRenderingTrackerNew(page.alias());
        this.f42938d = pageRenderingTrackerNew;
        pageRenderingTrackerNew.trackStart();
        ScopeContext scopeContext = this.f42936b.getScopeContext();
        if (scopeContext != null) {
            scopeContext.attach("PageRenderingTrackerNew", this.f42938d);
        }
    }

    public void onCreate() {
        CustomerPageManager.getInstance().setCurrentPage(this.f42936b.getClass());
        ScopeContext scopeContext = this.f42936b.getScopeContext();
        if (scopeContext != null) {
            scopeContext.attach("ScopeContextPageGuideParam", OmegaCommonParamHelper.generateCurrentPageGuideParam());
            scopeContext.attach("ScopeContextPageId", this.f42936b.alias());
            scopeContext.attach("ScopeContextPageIdentification", this.f42936b.alias() + "@" + this.f42936b);
            return;
        }
        LogUtil.m32586e(f42935a, "scopeContext == null");
    }

    public void onResume() {
        CustomerPageManager.getInstance().setCurrentPage(this.f42936b.getClass());
        PageRenderingTracker pageRenderingTracker = this.f42937c;
        if (pageRenderingTracker != null) {
            pageRenderingTracker.trackEnd().report();
            this.f42937c = null;
        }
    }

    public void onStart(View view, int i) {
        OmegaTracker.Builder.create("sailing_c_x_page_entry").addEventParam("pageName", CustomerPageManager.getInstance().getPageName(this.f42936b.getClass())).build().track();
        Omega.firePageResumed(this.f42936b);
        if (!this.f42939e) {
            ScopeContext scopeContext = this.f42936b.getScopeContext();
            if (scopeContext != null) {
                OmegaCommonParamHelper.updatePageGuideParam((GuideParam) scopeContext.getObject("ScopeContextPageGuideParam"));
            }
            if (view != null) {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
            }
            m32099a(m32102c());
        }
    }

    public void onStop() {
        Omega.firePagePaused(this.f42936b);
        OmegaTracker.Builder.create("sailing_c_x_page_leave").addEventParam("pageName", CustomerPageManager.getInstance().getPageName(this.f42936b.getClass())).build().track();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ControllerChangeHandler mo108216a() {
        return new CustomerHorizontalChangeHandler(200, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ControllerChangeHandler mo108218b() {
        return new CustomerHorizontalChangeHandler(200, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108217a(Request request) {
        if (request != null) {
            Class<?> target = request.getTarget();
            if (target == null) {
                ErrorTracker.create(ErrorConst.ErrorName.SALING_C_ROUTER_OPEN).addModuleName("router").addErrorType("null").addErrorMsg("openRoute request target is null").addParam("request->path:", String.valueOf(request.getPath())).addParam("extra:", String.valueOf(request.getExtras())).build().trackError();
                return;
            }
            if (this.f42936b.isDestroyed()) {
                ErrorTracker.create(ErrorConst.ErrorName.SALING_C_ROUTER_OPEN).addModuleName("router").addErrorType("destory").addErrorMsg("CustomerMainPage 销毁后收到跳转请求").addParam("request->path:", String.valueOf(request.getPath())).addParam("extra:", String.valueOf(request.getExtras())).build().trackError();
            }
            if (!m32100a(request.getPath())) {
                m32101c(request);
                if (!mo108219b(request)) {
                    if (Page.class.isAssignableFrom(target)) {
                        Bundle extras = request.getExtras();
                        if (WebPage.class.isAssignableFrom(target)) {
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.putString("url", request.getPath());
                        }
                        m32098a(request, target, extras);
                    } else if (Activity.class.isAssignableFrom(target)) {
                        Intent intent = new Intent(this.f42936b, target);
                        if (request.getExtras() != null) {
                            intent.putExtras(request.getExtras());
                        }
                        this.f42936b.startActivityForResult(intent, 0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo108219b(Request request) {
        return m32104e(request) || m32103d(request);
    }

    /* renamed from: a */
    private boolean m32100a(String str) {
        if (LoginUtil.isLogin() || TextUtils.isEmpty(str) || !str.contains("payMethodPage")) {
            return false;
        }
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 8);
        return true;
    }

    /* renamed from: c */
    private void m32101c(Request request) {
        Class<?> target = request.getTarget();
        boolean z = target != null && CustomerMainPage.class.isAssignableFrom(target);
        if (!TextUtils.isEmpty(this.f42936b.alias()) && "homePage".equals(this.f42936b.alias()) && !z) {
            GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        }
    }

    /* renamed from: a */
    private void m32098a(Request request, Class cls, Bundle bundle) {
        Page newInstance = PageFactory.newInstance(cls, bundle);
        if (newInstance != null) {
            PageInstrument instrument = this.f42936b.getInstrument();
            if (!instrument.hasRootPage()) {
                instrument.setRootPage(newInstance);
            } else if (request.getFromPage() instanceof ScopeContext) {
                ((ScopeContext) request.getFromPage()).getNavigator().pushForResult(newInstance);
            } else {
                this.f42936b.pushForResult(newInstance);
            }
        }
    }

    /* renamed from: d */
    private boolean m32103d(Request request) {
        Bundle extras = request.getExtras();
        if (extras != null) {
            String string = extras.getString("schem_from");
            extras.remove("schem_from");
            String string2 = extras.getString("schemeAssistPath");
            extras.remove("schemeAssistPath");
            if (TextUtils.isEmpty(string) || (!string.equals("webPage") && !string.equals("dynamic"))) {
                if (string2 != null) {
                    RecordTracker.Builder.create().setTag(this.f42936b.alias()).setMessage("interceptSchemeOpen").setOtherParam("request->path:", request.getPath()).setOtherParam("extra:", String.valueOf(extras)).build().info();
                    this.f42936b.popToRoot();
                    if (!string2.equals("taxis99OneTravel://soda")) {
                        DiRouter.request().path(string2).params(extras).open();
                    }
                    return true;
                }
            } else if (!"taxis99OneTravel://soda".equals(string2)) {
                return false;
            } else {
                this.f42936b.popToRoot();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m32097a(String str, Bundle bundle) {
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

    /* renamed from: e */
    private boolean m32104e(Request request) {
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
            webConfig.url = m32097a(string, extras);
            webConfig.title = extras.getString("title");
            Serializable serializable = extras.getSerializable("params");
            if (serializable instanceof HashMap) {
                webConfig.mCustomerParameters = (HashMap) serializable;
            }
        }
        if (TextUtils.isEmpty(webConfig.url)) {
            return false;
        }
        RecordTracker.Builder.create().setTag(this.f42936b.alias()).setMessage("interceptWebPage").setOtherParam("request->path:", request.getPath()).setOtherParam("extra:", String.valueOf(extras)).build().info();
        Uri parse = Uri.parse(webConfig.url);
        if (!CustomerWebActivity.matchSingleWebActivity(extras) || "1".equals(parse.getQueryParameter("nativeWebUIType"))) {
            CustomerWebLauncher.launchWebPage(webConfig, true, extras, target);
        } else {
            CustomerWebLauncher.launchWebActivity(this.f42936b.getBaseContext(), webConfig);
        }
        return true;
    }

    /* renamed from: c */
    private boolean m32102c() {
        Page page = this.f42936b;
        if (page instanceof PageClickableListener) {
            return ((PageClickableListener) page).getTouchIntercept();
        }
        return true;
    }

    /* renamed from: a */
    private void m32099a(boolean z) {
        View pageView;
        Page page = this.f42936b;
        if ((page instanceof PageClickableListener) && (pageView = ((PageClickableListener) page).getPageView()) != null) {
            pageView.setClickable(z);
        }
    }
}
