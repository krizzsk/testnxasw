package com.didichuxing.dfbasesdk.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.dfbasesdk.act.DFBaseAct;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.webview.bizjscmd.BizJsCmdHandlerFactory;
import com.didichuxing.dfbasesdk.webview.bizjscmd.IBizJsCmdHandler;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import org.json.JSONObject;

public class DFWebviewAct extends DFBaseAct implements C16145c {
    public static int progressDrawable = 2131232474;

    /* renamed from: a */
    private WebView f49591a;

    /* renamed from: b */
    private ProgressBar f49592b;

    /* renamed from: c */
    private C16146d f49593c;

    /* renamed from: d */
    private IBizJsCmdHandler f49594d;

    /* renamed from: e */
    private String f49595e;

    /* renamed from: f */
    private String f49596f;

    /* renamed from: g */
    private int f49597g;

    /* renamed from: h */
    private String f49598h;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.df_webview_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            this.f49595e = data.getQueryParameter("url");
        }
        if (TextUtils.isEmpty(this.f49595e)) {
            this.f49595e = intent.getStringExtra("url");
        }
        this.f49596f = intent.getStringExtra("id");
        this.f49597g = intent.getIntExtra("state", 2);
        this.f49598h = intent.getStringExtra("sceneType");
        if (TextUtils.isEmpty(this.f49595e)) {
            this.f49595e = intent.getStringExtra("webUrl");
        }
        if (TextUtils.isEmpty(this.f49595e)) {
            this.f49595e = "about:blank";
        }
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f49591a = (WebView) findViewById(R.id.webview);
        m37137a();
        this.f49591a.loadUrl(this.f49595e);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.web_progress_bar);
        this.f49592b = progressBar;
        progressBar.setProgressDrawable(getResources().getDrawable(progressDrawable));
    }

    /* renamed from: a */
    private void m37137a() {
        WebSettings settings = this.f49591a.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        String userAgentString = settings.getUserAgentString();
        if (userAgentString == null) {
            userAgentString = "";
        }
        settings.setUserAgentString((userAgentString + " dfbasesdk_v0.5.11.61").trim());
        if (Build.VERSION.SDK_INT < 18) {
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        if (Build.VERSION.SDK_INT >= 19 && DFAppConfig.getInstance().isDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 17) {
            this.f49591a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f49591a.removeJavascriptInterface("accessibilityTraversal");
            this.f49591a.removeJavascriptInterface("accessibility");
        }
        this.f49591a.setWebViewClient(new C16143b());
        this.f49591a.setWebChromeClient(new C16142a());
        C16146d dVar = new C16146d(this);
        this.f49593c = dVar;
        this.f49591a.addJavascriptInterface(dVar, "NativeHandler");
        this.f49594d = BizJsCmdHandlerFactory.newJsCmdHandler(this.f49598h, this.f49596f, this.f49597g, this.f49595e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122552a(int i) {
        if (i <= 100) {
            if (i < 100 && this.f49592b.getVisibility() == 4) {
                this.f49592b.setVisibility(0);
            }
            this.f49592b.setProgress(i);
            if (i == 100) {
                this.f49592b.setVisibility(4);
            }
        }
    }

    @Subscribe
    public void onJsCallbackEvent(JsCallbackEvent jsCallbackEvent) {
        C16146d dVar = this.f49593c;
        if (dVar == null) {
            LogUtils.m37054e("Webview", "mJsBridge==null!!!");
            return;
        }
        WebView webView = this.f49591a;
        if (webView == null) {
            LogUtils.m37054e("Webview", "mWebview==null!!!");
        } else {
            dVar.mo122571a(webView, jsCallbackEvent);
        }
    }

    @Subscribe
    public void onCloseWebviewEvent(CloseWebviewEvent closeWebviewEvent) {
        finish();
    }

    public void handleJsInvoke(String str, JSONObject jSONObject) {
        if (JSCommands.TAKE_PHOTO.equals(str)) {
            m37138b(jSONObject.optInt("photoType"));
        } else if (JSCommands.SHOW_BACK_BUTTON.equals(str)) {
            this.mLeftTitleBtn.setVisibility(jSONObject.optInt("state") == 1 ? 0 : 4);
            onJsCallbackEvent(new JsCallbackEvent(str).build());
        } else if (!this.f49594d.handleJsCmd(str, jSONObject)) {
            onJsCallbackEvent(new JsCallbackEvent(str, 1003, "unknown command: " + str).build());
        }
    }

    /* renamed from: b */
    private void m37138b(int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("difaceh5invoke://takephoto").buildUpon().build());
        intent.setPackage(WsgSecInfo.packageName(this));
        intent.putExtra("fromH5", true);
        intent.putExtra("type", i);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        this.f49594d.onUserCancel();
        super.onLeftTitleBtnClicked();
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        WebView webView = this.f49591a;
        if (webView == null || !webView.canGoBack()) {
            this.f49594d.onUserCancel();
            finish();
            return true;
        }
        this.f49591a.goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.f49591a != null) {
            this.mLayoutBody.removeView(this.f49591a);
            this.f49591a.destroy();
            this.f49591a = null;
        }
        super.onDestroy();
    }
}
