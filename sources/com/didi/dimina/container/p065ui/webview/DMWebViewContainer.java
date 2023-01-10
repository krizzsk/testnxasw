package com.didi.dimina.container.p065ui.webview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.p065ui.webview.DMWebViewContainer;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.webview.DMWebViewContainer */
public class DMWebViewContainer extends FrameLayout {

    /* renamed from: a */
    private static final String f19721a = "DMWebViewContainer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WebViewEngine f19722b;

    /* renamed from: c */
    private FrameLayout f19723c;

    /* renamed from: d */
    private TouchInterceptFrameLayout f19724d;

    /* renamed from: e */
    private OnTitleChangeListener f19725e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DMMina f19726f;

    /* renamed from: g */
    private DMMinaNavigatorDelegate f19727g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<WebViewEngine.OnWebViewLoadListener> f19728h = new ArrayList();

    /* renamed from: com.didi.dimina.container.ui.webview.DMWebViewContainer$OnTitleChangeListener */
    public interface OnTitleChangeListener {
        void onTitleChanged(String str);
    }

    public DMWebViewContainer(Context context) {
        super(context);
        m16797b();
    }

    public DMWebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16797b();
    }

    public DMWebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16797b();
    }

    public void setChangeTitleListener(OnTitleChangeListener onTitleChangeListener) {
        this.f19725e = onTitleChangeListener;
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            onTitleChangeListener.getClass();
            webViewEngine.setOnTitleReceiveListener(new WebViewEngine.OnTitleReceiveListener() {
                public final void onReceiveTitle(String str) {
                    DMWebViewContainer.OnTitleChangeListener.this.onTitleChanged(str);
                }
            });
        }
    }

    public OnTitleChangeListener getChangeTitleListener() {
        return this.f19725e;
    }

    public void loadUrl(String str) {
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            webViewEngine.loadUrl(str);
        }
    }

    public void syncData(DMPage dMPage, DMMina dMMina, DMMinaNavigatorDelegate dMMinaNavigatorDelegate) {
        this.f19726f = dMMina;
        this.f19727g = dMMinaNavigatorDelegate;
        initWebView();
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            webViewEngine.dmCreate(this, dMPage, this.f19726f, dMMinaNavigatorDelegate);
        }
    }

    public void initBackground(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSAppConfig jSAppConfig = getWebView().getDmMina().getJSAppConfig();
            if (jSAppConfig != null) {
                JSAppConfig.PageConfig pageConfig = jSAppConfig.getPageConfig(str);
                if (pageConfig == null || !TextUtils.equals(pageConfig.type, "map")) {
                    m16795a();
                } else {
                    setWebViewBackgroundTransparent();
                }
            }
        } else {
            m16795a();
        }
    }

    public void setWebViewBackgroundTransparent() {
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            webViewEngine.getWebView().setBackgroundColor(Color.argb(1, 255, 255, 255));
            this.f19722b.setNeedShowProgressBar(false);
            this.f19722b.getWebView().setHorizontalScrollBarEnabled(false);
            this.f19722b.getWebView().setVerticalScrollBarEnabled(false);
        }
    }

    /* renamed from: a */
    private void m16795a() {
        if (this.f19722b != null) {
            this.f19724d.setInterceptEnabled(false);
            this.f19722b.getWebView().setBackgroundColor(getResources().getColor(R.color.dimina_color_FFFFFF));
            this.f19722b.getWebView().setLayerType(2, (Paint) null);
        }
    }

    public void initWebView() {
        WebViewEngine createWebViewEngine = this.f19726f.getConfig().getLaunchConfig().getEngineFactory().createWebViewEngine(this.f19726f.getActivity());
        this.f19722b = createWebViewEngine;
        createWebViewEngine.getWebView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f19724d.addView(this.f19722b.getWebView());
        WebViewEngine webViewEngine = this.f19722b;
        webViewEngine.addJavascriptInterface(new DMWebViewJSInterface(webViewEngine), DMWebViewJSInterface.TAG);
        this.f19722b.setOnLoadStatusListener(new WebViewEngine.OnWebViewLoadListener() {
            public void onPageFinished(WebViewEngine webViewEngine, String str) {
                for (WebViewEngine.OnWebViewLoadListener onPageFinished : DMWebViewContainer.this.f19728h) {
                    onPageFinished.onPageFinished(webViewEngine, str);
                }
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f19726f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener != null) {
                    onWebViewLoadListener.onPageFinished(webViewEngine, str);
                }
            }

            public void onReceivedError(WebViewEngine webViewEngine, String str) {
                for (WebViewEngine.OnWebViewLoadListener onReceivedError : DMWebViewContainer.this.f19728h) {
                    onReceivedError.onReceivedError(webViewEngine, str);
                }
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f19726f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener != null) {
                    onWebViewLoadListener.onReceivedError(webViewEngine, str);
                }
            }

            public Boolean shouldOverrideUrlLoading(WebViewEngine webViewEngine, String str) {
                Boolean shouldOverrideUrlLoading;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f19726f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldOverrideUrlLoading = onWebViewLoadListener.shouldOverrideUrlLoading(webViewEngine, str)) == CONTINUE_OVERRIDE) {
                    return null;
                }
                return shouldOverrideUrlLoading;
            }

            public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2) {
                WebResourceResponse shouldInterceptRequest;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f19726f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldInterceptRequest = onWebViewLoadListener.shouldInterceptRequest(webViewEngine, str, str2)) == null) {
                    return null;
                }
                return shouldInterceptRequest;
            }

            public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str) {
                WebResourceResponse shouldInterceptRequest;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f19726f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldInterceptRequest = onWebViewLoadListener.shouldInterceptRequest(webViewEngine, webResourceRequest, str)) == null) {
                    return null;
                }
                return shouldInterceptRequest;
            }
        });
    }

    /* renamed from: b */
    private void m16797b() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_webview_container, this);
        this.f19724d = (TouchInterceptFrameLayout) findViewById(R.id.touch_intercept_fl);
        ImageView imageView = (ImageView) findViewById(R.id.debug_mark_icon);
        if (Dimina.getConfig().isDebug()) {
            imageView.setVisibility(0);
        }
    }

    public FrameLayout getBottomLayer() {
        if (this.f19723c == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f19723c = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.f19723c, 0);
        }
        return this.f19723c;
    }

    public TouchInterceptFrameLayout getTouchInterceptFrameLayout() {
        return this.f19724d;
    }

    public void release(final int i) {
        if (this.f19722b != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (DMWebViewContainer.this.f19722b != null) {
                        DMWebViewContainer.this.f19726f.getDmWebViewManager().remove(Integer.valueOf(i));
                        ViewParent parent = DMWebViewContainer.this.f19722b.getWebView().getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(DMWebViewContainer.this.f19722b.getWebView());
                        }
                        DMWebViewContainer.this.f19722b.dmDestroy();
                        WebViewEngine unused = DMWebViewContainer.this.f19722b = null;
                    }
                }
            });
        }
    }

    public WebViewEngine getWebView() {
        return this.f19722b;
    }

    public DMMinaNavigatorDelegate getNavigator() {
        return this.f19727g;
    }

    public void setMapInterceptFrameLayout(boolean z) {
        this.f19724d.setInterceptEnabled(z);
    }

    public void addWebViewLoadListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        this.f19728h.add(onWebViewLoadListener);
    }

    public boolean removePageFinishListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        return this.f19728h.remove(onWebViewLoadListener);
    }

    public void onPause() {
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            webViewEngine.dmPause();
        } else {
            LogUtil.iRelease(f19721a, "webview is null,pause");
        }
    }

    public void onResume() {
        WebViewEngine webViewEngine = this.f19722b;
        if (webViewEngine != null) {
            webViewEngine.dmResume();
        } else {
            LogUtil.iRelease(f19721a, "webview is null,resume");
        }
    }
}
