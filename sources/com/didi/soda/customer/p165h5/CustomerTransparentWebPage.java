package com.didi.soda.customer.p165h5;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.resource.FusionCacheClient;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.pages.changehandler.CustomerResetChangeHandler;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridModule;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebViewClient;
import com.didi.soda.customer.p165h5.hybird.WebViewModelCallback;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.web.widgets.SodaWebView;
import com.taxis99.R;

@Route({"transferWebPage"})
/* renamed from: com.didi.soda.customer.h5.CustomerTransparentWebPage */
public class CustomerTransparentWebPage extends CustomerWebPage {

    /* renamed from: a */
    private static final String f43872a = "CustomerTransparentWebPage";

    /* renamed from: b */
    private SodaWebView f43873b;

    /* renamed from: c */
    private boolean f43874c = true;

    /* renamed from: d */
    private CustomerHybridModule f43875d;

    /* renamed from: e */
    private FinishLoadCallBack f43876e;

    /* renamed from: f */
    private long f43877f;

    /* renamed from: g */
    private String f43878g;

    /* renamed from: com.didi.soda.customer.h5.CustomerTransparentWebPage$FinishLoadCallBack */
    public interface FinishLoadCallBack {
        void onFinishLoadCallBack();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public CustomerTransparentWebPage() {
        DiRouter.registerHub(RoutePath.TRANSPARENT_WEB_PAGE, this);
    }

    public void creatWebView(String str) {
        this.f43878g = str;
        try {
            SodaWebView sodaWebView = new SodaWebView(GlobalContext.getContext());
            this.f43873b = sodaWebView;
            sodaWebView.setUpdateUIHandler(this);
            CustomerHybridWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(this.f43873b, this);
            WebHelper.attachOmegaJS(this.f43873b, customerHybridWebViewClient);
            this.f43873b.setWebViewClient(customerHybridWebViewClient);
            CustomerHybridModule customerHybridModule = (CustomerHybridModule) this.f43873b.getExportModuleInstance(CustomerHybridModule.class);
            this.f43875d = customerHybridModule;
            customerHybridModule.setWebViewCallback(this);
            m32723a(this.f43873b);
            this.f43873b.loadUrl(str);
            m32722a("webview_creat", "").build().track();
        } catch (Exception unused) {
            finish();
        }
    }

    public void onCreate(View view) {
        super.onCreate(view);
        findViewById(R.id.cl_hybrid_root).setBackgroundColor(0);
        m32723a(getWebView());
        m32722a(NachoLifecycleManager.LIFECYCLE_ON_CREATE, "").build().track();
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerHybridModule customerHybridModule = this.f43875d;
        if (customerHybridModule != null) {
            customerHybridModule.setWebViewCallback((WebViewModelCallback) null);
        }
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        data.mLoadUrl = this.f43878g;
        appConfigStorage.setData(data);
        m32722a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, "").build().track();
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null && consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            m32722a("onConsoleMessage", consoleMessage.message()).build().track();
            if (this.f43874c) {
                String message = consoleMessage.message();
                LogUtil.m32588i(f43872a, "consoleMessage: " + message);
                finish();
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f43874c) {
            this.f43874c = false;
        }
    }

    public void onProgressChanged(WebView webView, int i) {
        if (getWebView() != null) {
            getWebView().hiddenLoadProgress();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        LogUtil.m32588i(f43872a, "onReceivedError, errorCode = " + i + ", description: " + str + ", failingUrl: " + str2);
        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HOME_REDENVELOPE_NOTLOAD).addModuleName("home");
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        addModuleName.addErrorType(sb.toString()).build().trackError();
        finish();
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int statusCode = webResourceResponse.getStatusCode();
        LogUtil.m32586e(f43872a, "onReceivedHttpError statusCode = " + statusCode);
        finish();
    }

    public void shouldInterceptRequest(WebView webView, String str) {
        FusionCacheClient fusionCacheClient;
        String str2;
        if (!TextUtils.isEmpty(str) && (fusionCacheClient = FusionCacheClient.sInstance) != null && fusionCacheClient.isValid()) {
            AppConfig data = ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData();
            boolean z = fusionCacheClient.isCacheExist(str) && data.mPreloadList.contains(str);
            if (z) {
                m32722a("isCacheExist", str).build().track();
            }
            if (z && (str2 = this.f43878g) != null && !str2.equals(data.mLoadUrl)) {
                m32722a("isPreLoadCacheExist", str).build().track();
            }
        }
    }

    public ControllerChangeHandler getPopHandler() {
        return new CustomerResetChangeHandler(false);
    }

    public ControllerChangeHandler getPushHandler() {
        return new CustomerResetChangeHandler(false);
    }

    public void finishedLoadHtml() {
        m32722a("finishedLoadHtml", "").build().track();
        FinishLoadCallBack finishLoadCallBack = this.f43876e;
        if (finishLoadCallBack != null) {
            finishLoadCallBack.onFinishLoadCallBack();
        }
    }

    public void setFinishedLoadCallBack(FinishLoadCallBack finishLoadCallBack) {
        this.f43876e = finishLoadCallBack;
    }

    /* access modifiers changed from: protected */
    public SodaWebView inflateWebView() {
        return this.f43873b;
    }

    /* renamed from: a */
    private void m32723a(FusionWebView fusionWebView) {
        if (fusionWebView != null) {
            fusionWebView.setHorizontalScrollBarEnabled(false);
            fusionWebView.setVerticalScrollBarEnabled(false);
            fusionWebView.setBackgroundColor(0);
            fusionWebView.hiddenLoadProgress();
        }
    }

    /* renamed from: a */
    private OmegaTracker.Builder m32722a(String str, String str2) {
        if (this.f43877f <= 0) {
            this.f43877f = System.currentTimeMillis();
        }
        LogUtil.m32588i("transparent_web_page", str + "," + str2 + ",time=" + (System.currentTimeMillis() - this.f43877f));
        return OmegaTracker.Builder.create("transparent_web_page").addEventParam("status", str).addEventParam("msg", str2).addEventParam("time", Long.valueOf(System.currentTimeMillis() - this.f43877f));
    }
}
