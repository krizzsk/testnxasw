package com.didi.sdk.payment.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.log.Logger;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class SignWebActivity extends WebActivity {
    public static final String BIND_FAIL = "0";
    public static final String BIND_SUCCESS = "1";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebTitleBar f39715a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebView f39716b;

    /* renamed from: c */
    private String f39717c;

    /* renamed from: d */
    private String f39718d;

    /* renamed from: e */
    private String f39719e;

    /* renamed from: f */
    private FusionBridgeModule f39720f;

    /* renamed from: g */
    private Handler f39721g;

    /* renamed from: h */
    private View.OnClickListener f39722h = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SignWebActivity.this.finish();
        }
    };

    /* renamed from: i */
    private View.OnClickListener f39723i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SignWebActivity.this.finish();
        }
    };

    public interface H5Callback {
        void onResult(String str);
    }

    /* renamed from: d */
    private void m29920d() {
    }

    static class MyHandler extends Handler {
        WeakReference<BaseWebView> mWebViewReference;

        MyHandler(BaseWebView baseWebView) {
            this.mWebViewReference = new WeakReference<>(baseWebView);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                Bundle data = message.getData();
                ((BaseWebView) this.mWebViewReference.get()).loadDataWithBaseURL(data.getString("url"), data.getString("result"), "text/html", "UTF-8", (String) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.a_sign_web);
        this.f39715a = (WebTitleBar) findViewById(R.id.web_title_bar);
        this.f39716b = (BaseWebView) findViewById(R.id.web_view);
        this.f39721g = new MyHandler(this.f39716b);
        this.f39717c = getIntent().getStringExtra("title");
        this.f39718d = getIntent().getStringExtra("postData");
        this.f39719e = getIntent().getStringExtra("url");
        m29917b();
        m29919c();
    }

    /* renamed from: b */
    private void m29917b() {
        if (!TextUtils.isEmpty(this.f39717c)) {
            this.f39715a.setTitleName(this.f39717c);
        }
        this.f39715a.setCloseBtnVisibility(8);
        this.f39715a.setMoreBtnVisibility(8);
        this.f39715a.setOnBackClickListener(this.f39722h);
        this.f39715a.setOnCloseClickListener(this.f39723i);
    }

    /* renamed from: c */
    private void m29919c() {
        WebSettings settings = this.f39716b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        new H5Callback() {
            public void onResult(String str) {
                if ("0".equals(str)) {
                    SignWebActivity.this.setResult(1);
                } else if ("1".equals(str)) {
                    SignWebActivity.this.setResult(2);
                }
            }
        };
        this.f39720f = this.f39716b.getFusionBridge();
        this.f39716b.setWebViewClient(new BaseWebView.WebViewClientEx(this.f39716b) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (SignWebActivity.this.f39716b.canGoBack()) {
                    SignWebActivity.this.f39715a.setCloseBtnVisibility(0);
                } else {
                    SignWebActivity.this.f39715a.setCloseBtnVisibility(8);
                }
                String title = webView.getTitle();
                if (SignWebActivity.this.mFusionWebModel.canChangeWebViewTitle) {
                    if (title == null || TextUtils.equals(title, "about:blank")) {
                        title = "";
                    } else if (webView.getUrl() != null) {
                        Uri parse = Uri.parse(webView.getUrl());
                        if (parse.getHost() != null && title.contains(parse.getHost())) {
                            title = SignWebActivity.this.getString(R.string.app_name);
                        }
                    }
                    SignWebActivity.this.f39715a.setTitleName(title);
                }
                SignWebActivity.this.cancelProgressDialog();
                SignWebActivity.this.f39716b.requestFocus();
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Logger.m29537e("shouldOverrideUrlLoading", new Object[0]);
                return false;
            }
        });
        try {
            CookieSyncManager.createInstance(getApplicationContext());
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m29920d();
    }

    /* renamed from: a */
    private void m29915a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", this.f39719e);
        bundle.putString("result", str);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.setData(bundle);
        this.f39721g.sendMessage(obtain);
    }

    public boolean goBack(boolean z) {
        boolean z2;
        String str;
        WebBackForwardList copyBackForwardList = this.f39716b.copyBackForwardList();
        String url = this.f39716b.getUrl();
        int i = -1;
        while (true) {
            if (!this.f39716b.canGoBackOrForward(i)) {
                z2 = false;
                break;
            }
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
            if (itemAtIndex == null) {
                str = null;
            } else {
                str = itemAtIndex.getUrl();
            }
            if (str != null && !TextUtils.equals(str, url) && !TextUtils.equals(str, "about:blank")) {
                this.f39716b.goBackOrForward(i);
                z2 = true;
                break;
            }
            i--;
        }
        if (!z2 && z) {
            finishWithResultCodeOK();
        }
        return z2;
    }

    public void finishWithResultCodeOK() {
        setResult(-1);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        finish();
        return false;
    }
}
