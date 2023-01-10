package com.didi.sdk.webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.container.BaseHybridableActivity;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.DebugUtils;
import com.didi.sdk.fusionbridge.FusionTimeRecorder;
import com.didi.sdk.fusionbridge.FusionUrlRecorder;
import com.didi.sdk.fusionbridge.module.FileModule;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.util.WebViewUtils;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebBackInterceptor;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didi.sdk.webview.tool.WebURLWriter;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventMap;
import com.didichuxing.omega.sdk.feedback.shake.ShakeSdk;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class BaseWebActivity extends BaseHybridableActivity {
    public static final String ACTION_INTENT_BROADCAST_CLOSE = "action_intent_broadcast_close";
    public static final String KEY_COUPON_ID = "getSelectedCouponID";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    public static final String KEY_WEB_VIEW_MODEL = "web_view_model";

    /* renamed from: a */
    private View f41072a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f41073b;

    /* renamed from: c */
    private ImageView f41074c;

    /* renamed from: d */
    private TextView f41075d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiDiWebViewClient f41076e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SHWebViewClient f41077f = null;

    /* renamed from: g */
    private ScreenOrientationMonitor f41078g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OverrideUrlLoaderSet f41079h = new OverrideUrlLoaderSet();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Logger f41080i = LoggerFactory.getLogger("BaseWebActivity");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public FusionTimeRecorder f41081j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public FusionUrlRecorder f41082k;

    /* renamed from: l */
    private WebBackInterceptor.BackClickInterceptor f41083l;

    /* renamed from: m */
    private BroadcastReceiver f41084m = null;
    protected FileChooserManager mFileChooserManager;
    /* access modifiers changed from: protected */
    public WebViewModel mFusionWebModel;
    protected FusionBridgeModule mJsBridge;
    protected boolean mTitleByJs = false;
    protected WebTitleBar mWebTitleBar;
    protected BaseWebView mWebView;

    /* renamed from: n */
    private Intent f41085n;

    /* renamed from: o */
    private View.OnClickListener f41086o = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            BaseWebActivity.this.goBack(true);
        }
    };

    /* renamed from: p */
    private View.OnClickListener f41087p = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            BaseWebActivity.this.finishWithResultCodeOK();
        }
    };

    /* renamed from: q */
    private View.OnClickListener f41088q = new View.OnClickListener() {
        private long mLastClickTime = 0;

        public void onClick(View view) {
            String str;
            AutoTrackHelper.trackViewOnClick(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime >= 3000) {
                String url = BaseWebActivity.this.mWebView.getUrl();
                if (TextUtils.equals(url, "about:blank")) {
                    WebBackForwardList copyBackForwardList = BaseWebActivity.this.mWebView.copyBackForwardList();
                    int i = -1;
                    while (true) {
                        if (!BaseWebActivity.this.mWebView.canGoBackOrForward(i)) {
                            url = "";
                            break;
                        }
                        WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                        if (itemAtIndex == null) {
                            str = null;
                        } else {
                            str = itemAtIndex.getUrl();
                        }
                        if (str != null && !str.equals("about:blank")) {
                            url = str;
                            break;
                        }
                        i--;
                    }
                }
                if (!TextUtils.isEmpty(url)) {
                    BaseWebActivity.this.mWebView.loadUrl(url);
                    BaseWebActivity.this.f41073b.setVisibility(8);
                } else {
                    BaseWebActivity baseWebActivity = BaseWebActivity.this;
                    baseWebActivity.m30782a(baseWebActivity.mFusionWebModel.url);
                    BaseWebActivity.this.f41073b.setVisibility(8);
                }
                this.mLastClickTime = currentTimeMillis;
            }
        }
    };
    protected CallbackFunction viewBackgroundCallbackFunction = null;

    public interface DiDiWebViewClient {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void onReceivedError(WebView webView, int i, String str, String str2);
    }

    public interface SHWebViewClient {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* access modifiers changed from: protected */
    public void appendUserAgent(FusionWebView fusionWebView) {
    }

    /* access modifiers changed from: protected */
    public void onLoadUrl(String str) {
    }

    /* access modifiers changed from: protected */
    public boolean shouldInterceptOpenUrl() {
        return false;
    }

    public void setBackClickInterceptor(WebBackInterceptor.BackClickInterceptor backClickInterceptor) {
        this.f41083l = backClickInterceptor;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_back_out);
        Intent intent = getIntent();
        if (intent == null) {
            mo104420a();
            return;
        }
        if (intent.hasExtra("web_view_model")) {
            WebViewModel webViewModel = (WebViewModel) intent.getSerializableExtra("web_view_model");
            this.mFusionWebModel = webViewModel;
            if (webViewModel.queryParamMap != null && !TextUtils.isEmpty(this.mFusionWebModel.url)) {
                Uri.Builder buildUpon = Uri.parse(this.mFusionWebModel.url).buildUpon();
                for (String next : this.mFusionWebModel.queryParamMap.keySet()) {
                    String valueOf = String.valueOf(this.mFusionWebModel.queryParamMap.get(next));
                    boolean z = !TextUtils.isEmpty(next);
                    boolean z2 = !TextUtils.isEmpty(valueOf);
                    if (z && z2) {
                        buildUpon.appendQueryParameter(next, valueOf);
                    }
                }
                this.mFusionWebModel.url = buildUpon.build().toString();
            }
        } else if (intent.hasExtra("url")) {
            WebViewModel webViewModel2 = new WebViewModel();
            this.mFusionWebModel = webViewModel2;
            webViewModel2.url = intent.getStringExtra("url");
            if (intent.hasExtra("title")) {
                this.mFusionWebModel.title = intent.getStringExtra("title");
                this.mFusionWebModel.canChangeWebViewTitle = false;
            }
        } else {
            this.f41080i.error("BaseWebActivity can not get WebViewModel from extra data, exit.", new Object[0]);
            mo104420a();
            return;
        }
        if (TextUtils.isEmpty(this.mFusionWebModel.url)) {
            mo104420a();
            return;
        }
        FusionTimeRecorder fusionTimeRecorder = new FusionTimeRecorder(this.mFusionWebModel.url, FusionEngine.getBusinessAgent().shouldIntercept(this, this.mFusionWebModel.url));
        this.f41081j = fusionTimeRecorder;
        fusionTimeRecorder.activityStarted();
        this.f41082k = new FusionUrlRecorder(this);
        setContentView((int) R.layout.activity_onehybrid_web);
        m30785b();
        m30783a(this.mFusionWebModel.url, this.mFusionWebModel.isFromOutApp);
        if (!this.mFusionWebModel.isFromOutApp || !new H5InterceptorImpl().intercept(this, this.mFusionWebModel.url)) {
            if (this.mFusionWebModel.isFromOutApp) {
                String a = C14133a.m30853a(this.mFusionWebModel.url, appendQueryParams(this.mFusionWebModel.url));
                if (!TextUtils.isEmpty(a)) {
                    this.mFusionWebModel.url = a;
                }
            }
            SystemUtils.log(3, "hosts_whitelist", "打开的链接是：" + this.mFusionWebModel.url, (Throwable) null, "com.didi.sdk.webview.BaseWebActivity", 193);
            m30787c();
            ScreenOrientationMonitor screenOrientationMonitor = new ScreenOrientationMonitor(this);
            this.f41078g = screenOrientationMonitor;
            screenOrientationMonitor.onCreate();
            ShakeSdk.addJavascriptInterface(this.mWebView);
            if (shouldInterceptOpenUrl()) {
                return;
            }
            if (NetUtil.isAvailable(this)) {
                m30782a(this.mFusionWebModel.url);
            } else {
                m30779a(-6, "无网络", this.mFusionWebModel.url);
            }
        }
    }

    /* renamed from: a */
    private void m30783a(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("isInner", Integer.valueOf(z ? 2 : 1));
        OmegaSDKAdapter.trackEvent("pax_tech_web_url", (Map<String, Object>) hashMap);
        MASSDK.addCustomEvent(CustomEventMap.PUB_BIZ, "url", str, false);
    }

    /* renamed from: b */
    private void m30785b() {
        this.f41072a = findViewById(R.id.root_view);
        this.mWebTitleBar = (WebTitleBar) findViewById(R.id.web_title_bar);
        WebViewModel webViewModel = this.mFusionWebModel;
        if (webViewModel != null && !TextUtils.isEmpty(webViewModel.title)) {
            this.mWebTitleBar.setTitleName(this.mFusionWebModel.title);
        }
        this.mWebTitleBar.setCloseBtnVisibility(8);
        this.mWebTitleBar.setMoreBtnVisibility(8);
        this.mWebTitleBar.setOnBackClickListener(this.f41086o);
        this.mWebTitleBar.setOnCloseClickListener(this.f41087p);
        this.f41073b = findViewById(R.id.web_error_view);
        this.f41074c = (ImageView) findViewById(R.id.web_error_image);
        this.f41075d = (TextView) findViewById(R.id.web_error_text);
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.web_view);
        this.mWebView = baseWebView;
        baseWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    BaseWebActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mWebView.setWebViewClient(new ToneWebViewClient(this.mWebView));
        this.mWebView.setWebViewSetting(this.mFusionWebModel);
        appendUserAgent(this.mWebView);
        FileChooserManager fileChooserManager = new FileChooserManager(this);
        this.mFileChooserManager = fileChooserManager;
        fileChooserManager.setFileChooserListener(this.mWebView);
        addOverrideUrlLoader(new CommonUrlOverrider());
        addOverrideUrlLoader(new TicketUrlOverrider(this));
        this.mJsBridge = getFusionBridge();
    }

    /* renamed from: a */
    private void m30778a(int i) {
        Logger logger = this.f41080i;
        logger.info("changePageStateToWebView:" + i, new Object[0]);
        if (this.viewBackgroundCallbackFunction != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appState", "" + i);
                this.viewBackgroundCallbackFunction.onCallBack(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30782a(String str) {
        this.f41081j.beginLoadUrl();
        String appendQueryParams = appendQueryParams(str);
        onLoadUrl(appendQueryParams);
        if (DebugUtils.isDebuggableApp(this)) {
            SystemUtils.log(3, "BaseWebActivity", appendQueryParams, (Throwable) null, "com.didi.sdk.webview.BaseWebActivity", 292);
        }
        this.mWebView.loadUrl(appendQueryParams);
    }

    /* access modifiers changed from: protected */
    public String appendQueryParams(String str) {
        Uri parse = Uri.parse(str);
        if (WebConfigStore.getInstance().isWhiteUrl(str, this)) {
            if (this.mFusionWebModel.isPostBaseParams || this.mFusionWebModel.isAddCommonParam) {
                parse = WebURLWriter.appendUriQuery(parse, WebURLWriter.combineBaseWebInfoAsPairList(this, WebViewUtils.isUrlStartWithHttps(str)));
            } else if (str.contains("token") && !this.mFusionWebModel.isFromBuiness && !this.mFusionWebModel.isFromPaypal) {
                parse = WebURLWriter.replaceUriParameter(parse, "token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
            }
        }
        return WebURLWriter.appendEncodedUriQuery(parse, this.mFusionWebModel.customparams).toString();
    }

    /* renamed from: c */
    private void m30787c() {
        IntentFilter intentFilter = new IntentFilter(ACTION_INTENT_BROADCAST_CLOSE);
        C141022 r1 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                BaseWebActivity.this.finishWithResultCodeOK();
            }
        };
        this.f41084m = r1;
        try {
            registerReceiver(r1, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public ScreenOrientationMonitor getScreenOrientationMonitor() {
        return this.f41078g;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m30778a(z ^ true ? 1 : 0);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        goBack(true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mWebView != null) {
            ShakeSdk.removeJavascriptInterface();
            if (this.mWebView.getParent() != null) {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            }
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
        }
        BroadcastReceiver broadcastReceiver = this.f41084m;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f41084m = null;
        }
        ScreenOrientationMonitor screenOrientationMonitor = this.f41078g;
        if (screenOrientationMonitor != null) {
            screenOrientationMonitor.onDestroy();
        }
        FusionUrlRecorder fusionUrlRecorder = this.f41082k;
        if (fusionUrlRecorder != null) {
            fusionUrlRecorder.flush();
        }
        MASSDK.removeCustomEvent(CustomEventMap.PUB_BIZ, "url");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        FileModule fileModule;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1000 && (fileModule = (FileModule) this.mWebView.getExportModuleInstance(FileModule.class)) != null) {
            fileModule.handleActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo104420a() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        setResult(-1, this.f41085n);
        finish();
    }

    public void setResultIntent(Intent intent) {
        this.f41085n = intent;
    }

    public void onHandleDialog(boolean z) {
        this.f41078g.updateActivityOrientation(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30779a(int i, String str, String str2) {
        WebTrackUtil.trackError(i, str, str2);
        this.f41073b.setVisibility(0);
        if (i == -14) {
            this.f41074c.setImageResource(R.drawable.icon_webview_error_notfound);
            this.f41075d.setText(R.string.webview_error_notfound);
            this.f41073b.setOnClickListener((View.OnClickListener) null);
        } else if (i == -2 || i == -6 || i == -5) {
            this.f41074c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f41075d.setText(R.string.webview_error_connectfail);
            this.f41073b.setOnClickListener(this.f41088q);
        } else if (i == -8) {
            this.f41074c.setImageResource(R.drawable.icon_webview_error_busy);
            this.f41075d.setText(R.string.webview_error_busy);
            this.f41073b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f41074c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f41075d.setText(R.string.webview_error_connectfail);
            this.f41073b.setOnClickListener(this.f41088q);
        }
    }

    public boolean goBack(boolean z) {
        String str;
        WebBackInterceptor.BackClickInterceptor backClickInterceptor = this.f41083l;
        boolean z2 = true;
        if (backClickInterceptor != null) {
            backClickInterceptor.onInterceptor();
            return true;
        }
        hideEntrance();
        View view = this.f41073b;
        if (view != null) {
            view.setVisibility(8);
        }
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        String url = this.mWebView.getUrl();
        int i = -1;
        while (true) {
            if (this.mWebView.canGoBackOrForward(i)) {
                if (TextUtils.equals(url, "about:blank") && !NetUtil.isAvailable(this)) {
                    finishWithResultCodeOK();
                    break;
                }
                WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                if (itemAtIndex == null) {
                    str = null;
                } else {
                    str = itemAtIndex.getUrl();
                }
                if (str != null && !TextUtils.equals(str, url) && !TextUtils.equals(str, "about:blank")) {
                    this.mWebView.goBackOrForward(i);
                    break;
                }
                i--;
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2 && z) {
            finishWithResultCodeOK();
        }
        return z2;
    }

    public class ToneWebViewClient extends BaseWebView.WebViewClientEx {
        public ToneWebViewClient(HybridableContainer hybridableContainer) {
            super(hybridableContainer);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger a = BaseWebActivity.this.f41080i;
            a.debug("shouldOverrideUrlLoading url = " + str, new Object[0]);
            if (BaseWebActivity.this.f41079h.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            if (BaseWebActivity.this.f41077f == null || !BaseWebActivity.this.f41077f.shouldOverrideUrlLoading(webView, str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            BaseWebActivity.this.f41081j.pageStarted();
            BaseWebActivity.this.hideEntrance();
            BaseWebActivity.this.mWebTitleBar.setTitleName(BaseWebActivity.this.mFusionWebModel.title);
            if (BaseWebActivity.this.f41076e != null) {
                BaseWebActivity.this.f41076e.onPageStarted(webView, str, bitmap);
            }
            BaseWebActivity.this.mTitleByJs = false;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            BaseWebActivity.this.f41081j.pageFinished();
            BaseWebActivity.this.f41081j.flush(BaseWebActivity.this);
            if (BaseWebActivity.this.mWebView.canGoBack()) {
                BaseWebActivity.this.mWebTitleBar.setCloseBtnVisibility(0);
            } else {
                BaseWebActivity.this.mWebTitleBar.setCloseBtnVisibility(8);
            }
            if (BaseWebActivity.this.mFusionWebModel.canChangeWebViewTitle && !BaseWebActivity.this.mTitleByJs) {
                String title = webView.getTitle();
                if (!TextUtils.isEmpty(title) && !URLUtil.isNetworkUrl(title) && BaseWebActivity.this.mFusionWebModel.useHtmlHeadTitle) {
                    BaseWebActivity.this.mWebTitleBar.setTitleName(title);
                }
            }
            if (BaseWebActivity.this.f41076e != null) {
                BaseWebActivity.this.f41076e.onPageFinished(webView, str);
            }
            BaseWebActivity.this.f41082k.recordUrl(str, BaseWebActivity.this.mWebTitleBar.getTitleName());
            BaseWebActivity.this.mWebTitleBar.getMiddleTv().sendAccessibilityEvent(4);
            DIDIFontUtils.Companion.injectCss(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger a = BaseWebActivity.this.f41080i;
            a.debug("BaseWebActivity", "InnerWebViewClient#onReceivedError: " + i + "|" + str + "|" + str2);
            if (Build.VERSION.SDK_INT < 18) {
                webView.clearView();
            } else {
                webView.loadUrl("about:blank");
            }
            if (BaseWebActivity.this.f41076e != null) {
                BaseWebActivity.this.f41076e.onReceivedError(webView, i, str, str2);
            }
            BaseWebActivity.this.m30779a(i, str, str2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
            if (shouldInterceptRequest != null && "cache".equals(shouldInterceptRequest.getResponseHeaders().get("fusion_source"))) {
                BaseWebActivity.this.f41081j.setFromCache(webResourceRequest.getUrl(), true);
            }
            return DIDIFontUtils.Companion.getWebResourceResponse(webView.getContext(), shouldInterceptRequest, webResourceRequest.getUrl().toString());
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return DIDIFontUtils.Companion.getWebResourceResponse(webView.getContext(), super.shouldInterceptRequest(webView, str), str);
        }
    }

    public View getRootView() {
        return this.f41072a;
    }

    public WebTitleBar getWebTitleBar() {
        return this.mWebTitleBar;
    }

    public BaseWebView getWebView() {
        return this.mWebView;
    }

    /* access modifiers changed from: protected */
    public FusionBridgeModule getFusionBridge() {
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView == null) {
            return null;
        }
        return (FusionBridgeModule) baseWebView.getExportModuleInstance(FusionBridgeModule.class);
    }

    /* access modifiers changed from: protected */
    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        this.f41079h.addOverrideUrlLoader(overrideUrlLoader);
    }

    public void reSetWebViewClient(DiDiWebViewClient diDiWebViewClient) {
        this.f41076e = diDiWebViewClient;
    }

    public void shSetWebViewClient(SHWebViewClient sHWebViewClient) {
        this.f41077f = sHWebViewClient;
    }

    public void cancelProgressDialog() {
        this.mWebView.hiddenLoadProgress();
    }

    /* access modifiers changed from: protected */
    public void hideEntrance() {
        this.mWebTitleBar.setMoreBtnVisibility(8);
    }
}
