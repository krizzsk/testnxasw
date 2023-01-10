package com.didi.dimina.webview.container;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.dimina.webview.BusinessAgent;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.dmwebview.DMWebView;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import com.didi.dimina.webview.util.C8407Util;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FusionWebView extends WebView {

    /* renamed from: a */
    private final HashMap<Class, Object> f20105a = new HashMap<>();

    /* renamed from: b */
    private WebViewJavascriptBridge f20106b;

    /* renamed from: c */
    private BusinessAgent f20107c;

    /* renamed from: d */
    private Activity f20108d;

    /* renamed from: e */
    private UpdateUIHandler f20109e;

    /* renamed from: f */
    private boolean f20110f = false;

    public FusionWebView getWebView() {
        return this;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean shouldSearchInBundle() {
        return true;
    }

    public FusionWebView(Context context) {
        super(context);
        m17014a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17014a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17014a(context);
    }

    /* renamed from: a */
    private void m17014a(Context context) {
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT < 19) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            this.f20108d = (Activity) context;
            this.f20107c = FusionEngine.getBusinessAgent();
            WebSettings settings = getSettings();
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
            settings.setAppCacheMaxSize(10485760);
            StringBuilder sb = new StringBuilder(settings.getUserAgentString());
            String businessUA = FusionEngine.getBusinessAgent().getBusinessUA();
            if (!TextUtils.isEmpty(businessUA)) {
                sb.append(" ");
                sb.append(businessUA);
            }
            settings.setUserAgentString(sb.toString());
            if (Build.VERSION.SDK_INT < 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (Build.VERSION.SDK_INT >= 19 && C8407Util.isApkDebug(context)) {
                setWebContentsDebuggingEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibilityTraversal");
                removeJavascriptInterface("accessibility");
            }
            setWebViewClient(new FusionWebViewClient(getActivity(), this));
            setWebChromeClient(new FusionWebChromeClient(this));
            if (Build.VERSION.SDK_INT >= 24) {
                FusionEngine.getBusinessAgent().refreshAppLocale(this.f20108d);
                return;
            }
            return;
        }
        throw new RuntimeException("FusionWebView only support Activity context");
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof FusionWebViewClient) {
            this.f20106b = ((FusionWebViewClient) webViewClient).getJavascriptBridge();
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new RuntimeException("FusionWebView only support FusionWebViewClient or its subclass");
    }

    public void loadUrl(String str) {
        if (TextUtils.equals("about:blank", str)) {
            super.loadUrl(str);
        } else if (TextUtils.isEmpty(str) || str.startsWith("javascript:")) {
            super.loadUrl(str);
        } else {
            this.f20110f = this.f20107c.shouldIntercept(getContext(), str);
            String addCommonQuery = this.f20107c.addCommonQuery(str);
            Map<String, String> commonHeaders = this.f20107c.getCommonHeaders();
            if (commonHeaders == null || commonHeaders.isEmpty()) {
                super.loadUrl(addCommonQuery);
            } else {
                super.loadUrl(addCommonQuery, commonHeaders);
            }
        }
    }

    public void appendUserAgent(String str) {
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + "; " + str);
    }

    public Activity getActivity() {
        return this.f20108d;
    }

    public boolean shouldInterceptRequest() {
        return this.f20110f;
    }

    public Object getExportModuleInstance(Class cls) {
        Object obj = this.f20105a.get(cls);
        if (obj == null) {
            try {
                obj = cls.getConstructor(new Class[]{DMWebView.class}).newInstance(new Object[]{this});
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            }
            if (obj != null) {
                this.f20105a.put(cls, obj);
            }
        }
        return obj;
    }

    public WebViewJavascriptBridge getJavascriptBridge() {
        return this.f20106b;
    }

    public void onDestroy() {
        this.f20105a.clear();
        this.f20110f = false;
        this.f20108d = null;
        destroy();
    }
}
