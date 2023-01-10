package com.didi.sdk.lawpop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.global.loading.app.LoadingDelegate;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.webview.WebTitleBar;
import com.taxis99.R;

public class SimpleWebActivity extends FragmentActivity implements ILoadingHolder, ILoadingable {
    public static final String INTENT_URL = "intent_url";

    /* renamed from: a */
    private View f39199a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f39200b;

    /* renamed from: c */
    private ImageView f39201c;

    /* renamed from: d */
    private TextView f39202d;

    /* renamed from: e */
    private LoadingDelegate f39203e;

    /* renamed from: f */
    private View.OnClickListener f39204f = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimpleWebActivity.this.goBack(true);
        }
    };

    /* renamed from: g */
    private View.OnClickListener f39205g = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SimpleWebActivity.this.finish();
        }
    };

    /* renamed from: h */
    private View.OnClickListener f39206h = new View.OnClickListener() {
        private long mLastClickTime = 0;

        public void onClick(View view) {
            String str;
            AutoTrackHelper.trackViewOnClick(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime >= 3000) {
                String url = SimpleWebActivity.this.mWebView.getUrl();
                if (TextUtils.equals(url, "about:blank")) {
                    WebBackForwardList copyBackForwardList = SimpleWebActivity.this.mWebView.copyBackForwardList();
                    int i = -1;
                    while (true) {
                        if (!SimpleWebActivity.this.mWebView.canGoBackOrForward(i)) {
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
                    SimpleWebActivity.this.mWebView.loadUrl(url);
                    SimpleWebActivity.this.f39200b.setVisibility(8);
                } else {
                    SimpleWebActivity.this.mWebView.loadUrl(SimpleWebActivity.this.urlFromIntent);
                    SimpleWebActivity.this.f39200b.setVisibility(8);
                }
                this.mLastClickTime = currentTimeMillis;
            }
        }
    };
    protected WebTitleBar mWebTitleBar;
    protected WebView mWebView;
    protected String urlFromIntent;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.common_status_background));
        setContentView((int) R.layout.activity_law_web_activity);
        m29532a();
        this.urlFromIntent = getIntent().getStringExtra(INTENT_URL);
        this.mWebView.setWebViewClient(new SimpleWebViewClient());
        this.f39203e = new LoadingDelegate(this, this);
        this.mWebView.loadUrl(this.urlFromIntent);
    }

    /* renamed from: a */
    private void m29532a() {
        this.f39199a = findViewById(R.id.root_view);
        WebTitleBar webTitleBar = (WebTitleBar) findViewById(R.id.web_title_bar);
        this.mWebTitleBar = webTitleBar;
        webTitleBar.setCloseBtnVisibility(8);
        this.mWebTitleBar.setMoreBtnVisibility(8);
        this.mWebTitleBar.setOnBackClickListener(this.f39204f);
        this.mWebTitleBar.setOnCloseClickListener(this.f39205g);
        this.mWebTitleBar.getMiddleTv().setTypeface(Typeface.DEFAULT_BOLD);
        this.mWebTitleBar.getMiddleTv().performClick();
        this.mWebTitleBar.getLeftImgView().setContentDescription(getResources().getString(R.string.description_title_back));
        this.mWebTitleBar.setTitleBarLineVisible(0);
        this.f39200b = findViewById(R.id.web_error_view);
        this.f39201c = (ImageView) findViewById(R.id.web_error_image);
        this.f39202d = (TextView) findViewById(R.id.web_error_text);
        this.mWebView = (WebView) findViewById(R.id.web_view);
        m29535b();
    }

    /* renamed from: b */
    private void m29535b() {
        this.mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    SimpleWebActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        WebSettings settings = this.mWebView.getSettings();
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
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            this.mWebView.removeJavascriptInterface("accessibility");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
        WebView webView = this.mWebView;
        if (webView != null) {
            ((ViewGroup) webView.getParent()).removeView(this.mWebView);
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        goBack(true);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29533a(int i, String str, String str2) {
        this.f39200b.setVisibility(0);
        if (i == -14) {
            this.f39201c.setImageResource(R.drawable.icon_webview_error_notfound);
            this.f39202d.setText(R.string.webview_error_notfound);
            this.f39200b.setOnClickListener((View.OnClickListener) null);
        } else if (i == -2 || i == -6 || i == -5) {
            this.f39201c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f39202d.setText(R.string.webview_error_connectfail);
            this.f39200b.setOnClickListener(this.f39206h);
        } else if (i == -8) {
            this.f39201c.setImageResource(R.drawable.icon_webview_error_busy);
            this.f39202d.setText(R.string.webview_error_busy);
            this.f39200b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f39201c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f39202d.setText(R.string.webview_error_connectfail);
            this.f39200b.setOnClickListener(this.f39206h);
        }
    }

    public boolean goBack(boolean z) {
        String str;
        hideEntrance();
        View view = this.f39200b;
        if (view != null) {
            view.setVisibility(8);
        }
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        boolean z2 = false;
        String url = this.mWebView.getUrl();
        int i = -1;
        while (true) {
            if (this.mWebView.canGoBackOrForward(i)) {
                if (TextUtils.equals(url, "about:blank") && !NetUtil.isAvailable(this)) {
                    finish();
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
                break;
            }
        }
        z2 = true;
        if (!z2 && z) {
            finish();
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void hideEntrance() {
        this.mWebTitleBar.setMoreBtnVisibility(8);
    }

    public View getFallbackView() {
        return this.mWebTitleBar;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void showLoading() {
        LoadingDelegate loadingDelegate = this.f39203e;
        if (loadingDelegate != null) {
            loadingDelegate.showLoading();
        }
    }

    public void showLoading(LoadingConfig loadingConfig) {
        LoadingDelegate loadingDelegate = this.f39203e;
        if (loadingDelegate != null) {
            loadingDelegate.showLoading(loadingConfig);
        }
    }

    public void hideLoading() {
        LoadingDelegate loadingDelegate = this.f39203e;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
    }

    public boolean isLoading() {
        LoadingDelegate loadingDelegate = this.f39203e;
        if (loadingDelegate != null) {
            return loadingDelegate.isLoading();
        }
        return false;
    }

    private class SimpleWebViewClient extends WebViewClient {
        private SimpleWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SystemUtils.log(3, "LawWebActivity", "shouldOverrideUrlLoading url=" + str, (Throwable) null, "com.didi.sdk.lawpop.SimpleWebActivity$SimpleWebViewClient", 346);
            webView.loadUrl(str);
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SimpleWebActivity.this.showLoading();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (SimpleWebActivity.this.mWebView.canGoBack()) {
                SimpleWebActivity.this.mWebTitleBar.setCloseBtnVisibility(0);
            } else {
                SimpleWebActivity.this.mWebTitleBar.setCloseBtnVisibility(8);
            }
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title) && !URLUtil.isNetworkUrl(title)) {
                SimpleWebActivity.this.mWebTitleBar.setTitleName(title);
            }
            SimpleWebActivity.this.mWebTitleBar.getMiddleTv().sendAccessibilityEvent(4);
            SimpleWebActivity.this.hideLoading();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            SystemUtils.log(3, "SimpleWebActivity", "SimpleWebViewClient#onReceivedError: " + i + "|" + str + "|" + str2, (Throwable) null, "com.didi.sdk.lawpop.SimpleWebActivity$SimpleWebViewClient", 385);
            if (Build.VERSION.SDK_INT < 18) {
                webView.clearView();
            } else {
                webView.loadUrl("about:blank");
            }
            SimpleWebActivity.this.m29533a(i, str, str2);
            SimpleWebActivity.this.hideLoading();
        }
    }
}
