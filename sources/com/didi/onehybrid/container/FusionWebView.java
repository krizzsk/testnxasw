package com.didi.onehybrid.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.Constants;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.devmode.DevHomeActivity;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.log.shake.ShakeUtils;
import com.didi.onehybrid.util.C11212Util;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FusionWebView extends WebView implements HybridableContainer, ShakeUtils.OnShakeListener {

    /* renamed from: a */
    private static final String f31969a = "FusionWebView";

    /* renamed from: b */
    private HashMap<Class, Object> f31970b = new HashMap<>();

    /* renamed from: c */
    private WebViewJavascriptBridge f31971c;

    /* renamed from: d */
    private BusinessAgent f31972d;

    /* renamed from: e */
    private Activity f31973e;

    /* renamed from: f */
    private UpdateUIHandler f31974f;

    /* renamed from: g */
    private boolean f31975g = true;

    /* renamed from: h */
    private ProgressBar f31976h;

    /* renamed from: i */
    private boolean f31977i = false;

    /* renamed from: j */
    private boolean f31978j = false;

    /* renamed from: k */
    private ShakeUtils f31979k = null;

    /* renamed from: l */
    private FusionRuntimeInfo f31980l;

    public FusionWebView getWebView() {
        return this;
    }

    public FusionWebView(Context context) {
        super(context);
        m24391a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24391a(context);
    }

    public FusionWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24391a(context);
    }

    /* renamed from: a */
    private void m24391a(Context context) {
        if (context instanceof Activity) {
            this.f31973e = (Activity) context;
            this.f31980l = new FusionRuntimeInfo();
            this.f31972d = FusionEngine.getBusinessAgent();
            WebSettings settings = getSettings();
            settings.setPluginState(WebSettings.PluginState.ON);
            boolean z = true;
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setDomStorageEnabled(true);
            settings.setCacheMode(-1);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            StringBuilder sb = new StringBuilder(settings.getUserAgentString());
            String businessUA = FusionEngine.getBusinessAgent().getBusinessUA();
            if (!TextUtils.isEmpty(businessUA)) {
                sb.append(" ");
                sb.append(businessUA);
            }
            sb.append(" ");
            sb.append(Constants.FUSION_UA);
            settings.setUserAgentString(sb.toString());
            if (Build.VERSION.SDK_INT < 18) {
                settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            }
            if (Build.VERSION.SDK_INT >= 19 && m24392b(context)) {
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
            setWebViewClient(new FusionWebViewClient(this));
            setWebChromeClient(new FusionWebChromeClient(this));
            if (Build.VERSION.SDK_INT >= 24) {
                FusionEngine.getBusinessAgent().refreshAppLocale(this.f31973e);
            }
            m24390a();
            IToggle toggle = Apollo.getToggle("webview_debug_monitor_enable");
            if (toggle == null || !toggle.allow()) {
                z = false;
            }
            this.f31978j = z;
            if (z) {
                this.f31980l.switchOn();
                return;
            }
            return;
        }
        throw new RuntimeException("FusionWebView only support Activity context");
    }

    /* renamed from: b */
    private boolean m24392b(Context context) {
        IToggle toggle = Apollo.getToggle("webview_contents_debugging_enabled");
        this.f31978j = toggle != null && toggle.allow();
        if (C11212Util.isApkDebug(context) || this.f31978j) {
            return true;
        }
        return false;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof FusionWebViewClient) {
            this.f31971c = ((FusionWebViewClient) webViewClient).getJavascriptBridge();
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new RuntimeException("FusionWebView only support FusionWebViewClient or its subclass");
    }

    public void loadUrl(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("javascript:")) {
            super.loadUrl(str);
            return;
        }
        this.f31977i = this.f31972d.shouldIntercept(getContext(), str);
        String addCommonQuery = this.f31972d.addCommonQuery(str);
        Map<String, String> commonHeaders = this.f31972d.getCommonHeaders();
        if (commonHeaders == null || commonHeaders.isEmpty()) {
            super.loadUrl(addCommonQuery);
        } else {
            super.loadUrl(addCommonQuery, commonHeaders);
        }
        this.f31980l.recordReqUrl(addCommonQuery);
    }

    public void appendUserAgent(String str) {
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + "; " + str);
    }

    public Activity getActivity() {
        return this.f31973e;
    }

    public FusionRuntimeInfo getFusionRuntimeInfo() {
        return this.f31980l;
    }

    public boolean shouldInterceptRequest() {
        return this.f31977i;
    }

    public void setUpdateUIHandler(UpdateUIHandler updateUIHandler) {
        this.f31974f = updateUIHandler;
    }

    public void onStart() {
        if (this.f31978j) {
            if (this.f31979k == null) {
                ShakeUtils shakeUtils = new ShakeUtils(getContext());
                this.f31979k = shakeUtils;
                shakeUtils.setOnShakeListener(this);
            }
            this.f31979k.onStart();
        }
    }

    public void onStop() {
        ShakeUtils shakeUtils = this.f31979k;
        if (shakeUtils != null) {
            shakeUtils.onStop();
        }
    }

    public UpdateUIHandler getUpdateUIHandler() {
        if (this.f31974f == null) {
            Activity activity = this.f31973e;
            if (activity instanceof UpdateUIHandler) {
                this.f31974f = (UpdateUIHandler) activity;
            }
        }
        return this.f31974f;
    }

    public Object getExportModuleInstance(Class cls) {
        Object obj = this.f31970b.get(cls);
        if (obj == null) {
            try {
                obj = cls.getConstructor(new Class[]{HybridableContainer.class}).newInstance(new Object[]{this});
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
                this.f31970b.put(cls, obj);
            }
        }
        return obj;
    }

    /* renamed from: a */
    private void m24390a() {
        try {
            ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
            this.f31976h = progressBar;
            progressBar.setLayoutParams(new ViewGroup.LayoutParams(-1, 6));
            Integer num = (Integer) FusionEngine.getAttr("progressbar_color");
            if (num == null) {
                num = -224941;
            }
            this.f31976h.setProgressDrawable(new ClipDrawable(new ColorDrawable(num.intValue()), 3, 1));
            this.f31976h.setVisibility(8);
            addView(this.f31976h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNeedShowProgressBar(boolean z) {
        ProgressBar progressBar;
        this.f31975g = z;
        if (!z && (progressBar = this.f31976h) != null) {
            removeView(progressBar);
            this.f31976h = null;
        }
    }

    public void showLoadProgress(int i) {
        ProgressBar progressBar;
        if (this.f31975g && (progressBar = this.f31976h) != null) {
            if (progressBar.getVisibility() == 8) {
                this.f31976h.setVisibility(0);
            }
            this.f31976h.setProgress(i);
        }
    }

    public void hiddenLoadProgress() {
        ProgressBar progressBar = this.f31976h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public WebViewJavascriptBridge getJavascriptBridge() {
        return this.f31971c;
    }

    public void onShake() {
        Intent intent = new Intent(getContext(), DevHomeActivity.class);
        intent.putExtra("fusionRuntimeInfo", this.f31980l);
        getContext().startActivity(intent);
    }

    public void onDestory() {
        this.f31970b.clear();
        this.f31977i = false;
        this.f31973e = null;
        destroy();
    }
}
