package com.didi.soda.web.proxy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.title.IconAttr;
import com.didi.app.nova.skeleton.title.TitleAttr;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.util.C11212Util;
import com.didi.soda.web.BizAgent;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.UpdateUIHandlerImp;
import com.didi.soda.web.WebInitializer;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.overriders.IUrlOverriders;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.tools.UrlWriter;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didi.sofa.utils.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class WebProxy {

    /* renamed from: a */
    FrameLayout f46467a;

    /* renamed from: b */
    SodaWebView f46468b;

    /* renamed from: c */
    LinearLayout f46469c;

    /* renamed from: d */
    FrameLayout f46470d;

    /* renamed from: e */
    TextView f46471e;

    /* renamed from: f */
    ImageView f46472f;

    /* renamed from: g */
    TextView f46473g;

    /* renamed from: h */
    WebPageTitleBar f46474h;

    /* renamed from: i */
    View f46475i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WebConfig f46476j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Context f46477k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<ShareToolModel> f46478l;

    /* renamed from: m */
    private FrameLayout f46479m;

    /* renamed from: n */
    private IErrorLayout f46480n;

    /* renamed from: o */
    private View.OnClickListener f46481o = new View.OnClickListener() {
        public void onClick(View view) {
            if (!WebProxy.this.m34641b()) {
                boolean unused = WebProxy.this.m34643c();
            }
        }
    };

    /* renamed from: p */
    private View.OnClickListener f46482p = new View.OnClickListener() {
        public void onClick(View view) {
            if (WebProxy.this.f46477k != null) {
                ((UpdateUIHandlerImp) WebProxy.this.f46477k).finishPage();
            }
        }
    };

    /* renamed from: q */
    private View.OnClickListener f46483q = new View.OnClickListener() {
        public void onClick(View view) {
            WebProxy webProxy = WebProxy.this;
            webProxy.reLoadUrl(webProxy.f46476j.url);
        }
    };

    public WebProxy(Context context, SodaWebView sodaWebView, View view, View view2, IErrorLayout iErrorLayout, WebConfig webConfig) {
        this.f46477k = context;
        this.f46480n = iErrorLayout;
        m34637a(sodaWebView, view, view2);
        m34635a(webConfig);
    }

    /* renamed from: a */
    private void m34637a(SodaWebView sodaWebView, View view, View view2) {
        this.f46468b = sodaWebView;
        if (sodaWebView == null) {
            this.f46468b = new SodaWebView(view2.getContext());
        }
        this.f46468b.setBackgroundColor(0);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.web_page_fl_container);
        this.f46467a = frameLayout;
        frameLayout.addView(this.f46468b);
        if (view != null) {
            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.web_page_title_container);
            this.f46479m = frameLayout2;
            frameLayout2.addView(view);
            this.f46479m.setVisibility(0);
        }
        this.f46469c = (LinearLayout) view2.findViewById(R.id.web_page_ll_error);
        this.f46471e = (TextView) view2.findViewById(R.id.web_page_tv_error);
        this.f46472f = (ImageView) view2.findViewById(R.id.soda_web_page_error);
        this.f46473g = (TextView) view2.findViewById(R.id.web_page_tv_error_msg);
        this.f46474h = (WebPageTitleBar) view2.findViewById(R.id.web_title_bar);
        this.f46475i = view2.findViewById(R.id.common_title_bar_line);
        this.f46470d = (FrameLayout) view2.findViewById(R.id.soda_web_customer_error_layout);
        m34633a();
    }

    /* renamed from: a */
    private void m34633a() {
        if (this.f46480n != null) {
            this.f46470d.setVisibility(0);
            this.f46480n.inflateErrorLayout(this.f46477k, this.f46470d);
            return;
        }
        this.f46470d.setVisibility(8);
    }

    public void reloadSelf() {
        reLoadUrl(this.f46476j.url);
    }

    /* renamed from: a */
    private void m34635a(WebConfig webConfig) {
        if (webConfig != null) {
            this.f46476j = webConfig;
            if (!webConfig.needPreload) {
                m34638a(this.f46476j.url);
            }
            if (this.f46476j.isUseNativeTitltBar) {
                this.f46474h.setVisibility(0);
                if (!TextUtils.isEmpty(this.f46476j.title) && this.f46476j.isUseNativeTitltBar) {
                    this.f46474h.setTitleName(this.f46476j.title);
                }
            }
            this.f46469c.setOnClickListener(this.f46483q);
            if (this.f46476j.isUseNativeTitltBar) {
                this.f46474h.setOnBackClickListener(this.f46481o);
            }
            this.f46468b.setWebViewSetting(this.f46476j);
            this.f46468b.setUpdateUIHandler((UpdateUIHandler) this.f46477k);
            Iterator<S> it = ServiceLoader.load(IUrlOverriders.class).iterator();
            while (it.hasNext()) {
                this.f46468b.addUrlOverriders((IUrlOverriders) it.next());
            }
            this.f46468b.setWebPageStateListener((SodaWebView.WebPageStateListener) this.f46477k);
        }
    }

    public void updateUI(final String str, final Object... objArr) {
        SodaWebView sodaWebView;
        if (!TextUtils.isEmpty(str) && (sodaWebView = this.f46468b) != null) {
            sodaWebView.post(new Runnable() {
                public void run() {
                    Object[] objArr;
                    Object[] objArr2;
                    if (!WebConstant.UI_TARGET_WEB_TITLE.equals(str) || (objArr2 = objArr) == null || !(objArr2[0] instanceof String)) {
                        if (WebConstant.UI_TARGET_INIT_ENTRANCE.equals(str) && (objArr = objArr) != null && (objArr[0] instanceof List)) {
                            List unused = WebProxy.this.f46478l = (List) objArr[0];
                        } else if (WebConstant.UI_TARGET_SHOW_ENTRANCE.equals(str)) {
                            Object[] objArr3 = objArr;
                            WebProxy.this.m34634a((CallbackFunction) objArr3[0], (String) objArr3[1]);
                        } else if (WebConstant.UI_TARGET_INVOKE_ENTRANCE.equals(str)) {
                            CallbackFunction callbackFunction = (CallbackFunction) objArr[0];
                            if (WebProxy.this.f46477k instanceof UpdateUIHandlerImp) {
                                ((UpdateUIHandlerImp) WebProxy.this.f46477k).invokeEntrance(WebProxy.this.f46478l, callbackFunction);
                            }
                        } else if (WebConstant.UI_TARGET_HIDE_ENTRANCE.equals(str)) {
                            WebProxy.this.m34644d();
                        } else if (WebConstant.UI_TARGET_SHOW_SYSTEM_ENTRANCE.equals(str)) {
                            if (WebProxy.this.f46477k instanceof UpdateUIHandlerImp) {
                                Object[] objArr4 = objArr;
                                ((UpdateUIHandlerImp) WebProxy.this.f46477k).showSystemEntrance((ShareToolModel) objArr4[0], (CallbackFunction) objArr4[1]);
                            }
                        } else if (WebConstant.UI_TARGET_UPDATA_NAV.equals(str) && (WebProxy.this.f46477k instanceof UpdateUIHandlerImp)) {
                            Object[] objArr5 = objArr;
                            ((UpdateUIHandlerImp) WebProxy.this.f46477k).updateNav((JSONObject) objArr5[0], (CallbackFunction) objArr5[1]);
                        }
                    } else if (!WebProxy.this.f46476j.canChangeTitle && !TextUtils.isEmpty(WebProxy.this.f46476j.title)) {
                    } else {
                        if (WebProxy.this.f46476j.isUseNativeTitltBar) {
                            if (WebProxy.this.f46474h != null) {
                                WebProxy.this.f46474h.setTitleName((String) objArr[0]);
                            }
                        } else if (WebProxy.this.f46477k != null && (WebProxy.this.f46477k instanceof Page)) {
                            ((Page) WebProxy.this.f46477k).getTitleBar().setTitle(new TitleAttr.Builder((String) objArr[0]).build());
                        }
                    }
                }
            });
        }
    }

    public WebPageTitleBar getWebTitleBar() {
        return this.f46474h;
    }

    public SodaWebView getWebView() {
        return this.f46468b;
    }

    public void reLoadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46476j.url = str;
            m34638a(this.f46476j.url);
        }
    }

    /* renamed from: a */
    private void m34638a(String str) {
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if ((businessAgent instanceof BizAgent) && !C11212Util.isApkDebug(WebInitializer.getInitializer().mApplication) && UrlWriter.isInHostList(str, ((BizAgent) businessAgent).getBlackList())) {
            m34639a(true, -12);
        } else if (SystemUtils.isNetWorkAvailable(this.f46477k)) {
            try {
                m34639a(false, 0);
                String builder = UrlWriter.executeAppend(Uri.parse(str), this.f46476j.mCustomerParameters).toString();
                if (this.f46468b != null) {
                    this.f46468b.loadUrl(builder);
                }
            } catch (Exception unused) {
                m34639a(true, -12);
            }
        } else {
            m34639a(true, -6);
        }
    }

    public void cancelProgressDialog() {
        SodaWebView sodaWebView = this.f46468b;
        if (sodaWebView != null) {
            sodaWebView.hiddenLoadProgress();
        }
    }

    /* renamed from: a */
    private void m34639a(boolean z, int i) {
        LinearLayout linearLayout = this.f46469c;
        if (linearLayout != null && this.f46468b != null && this.f46471e != null) {
            if (z) {
                linearLayout.setVisibility(0);
                this.f46468b.setVisibility(8);
                if (this.f46480n != null) {
                    this.f46472f.setVisibility(8);
                    this.f46471e.setVisibility(8);
                    this.f46473g.setVisibility(8);
                    this.f46469c.setOnClickListener((View.OnClickListener) null);
                    this.f46480n.showCustomerErrorView(i, this.f46476j.isUseNativeTitltBar, this.f46474h, this.f46475i);
                    return;
                }
                if (this.f46476j.isUseNativeTitltBar) {
                    this.f46474h.setTitleName(this.f46477k.getResources().getString(R.string.soda_web_page_load_fail));
                }
                this.f46472f.setVisibility(0);
                this.f46471e.setVisibility(0);
                this.f46473g.setVisibility(0);
                if (i == -12) {
                    this.f46472f.setImageResource(R.drawable.soda_web_page_load_fail);
                    this.f46471e.setText(R.string.nova_web_error_badurl);
                } else if (i == -8) {
                    this.f46472f.setImageResource(R.drawable.soda_web_page_load_fail);
                    this.f46471e.setText(R.string.nova_web_error_timeout);
                } else if (i == -2 || i == -6 || i == -5) {
                    this.f46472f.setImageResource(R.drawable.soda_web_page_net_error);
                    this.f46471e.setText(R.string.nova_web_error_connectfail);
                }
            } else {
                IErrorLayout iErrorLayout = this.f46480n;
                if (iErrorLayout != null) {
                    iErrorLayout.onHideEvent(this.f46476j.isUseNativeTitltBar, this.f46474h, this.f46475i);
                }
                this.f46469c.setVisibility(8);
                this.f46468b.setVisibility(0);
            }
        }
    }

    public void onWebPageStarted() {
        if (TextUtils.isEmpty(this.f46476j.title)) {
            return;
        }
        if (this.f46476j.isUseNativeTitltBar) {
            this.f46474h.setTitleName(this.f46476j.title);
            return;
        }
        Context context = this.f46477k;
        if (context != null && (context instanceof Page)) {
            ((Page) context).getTitleBar().setTitle(new TitleAttr.Builder(this.f46476j.title).build());
        }
    }

    public void onWebPageFinished(WebView webView, String str) {
        SodaWebView sodaWebView = this.f46468b;
        if (sodaWebView == null || !sodaWebView.canGoBack()) {
            this.f46474h.setCloseBtnVisibility(8);
            this.f46474h.setCloseBtnListener((View.OnClickListener) null);
        } else {
            IconAttr build = new IconAttr.Builder((int) R.drawable.nova_assembly_web_close).click(this.f46482p).build();
            if (this.f46476j.isUseNativeTitltBar) {
                this.f46474h.setCloseBtnVisibility(0);
                this.f46474h.setCloseBtnListener(this.f46482p);
            } else {
                Context context = this.f46477k;
                if (context != null && (context instanceof Page)) {
                    ((Page) context).getTitleBar().setLeft(build);
                }
            }
        }
        if (this.f46476j.canChangeTitle) {
            String title = webView.getTitle();
            if (TextUtils.isEmpty(title) || title.contains("http") || title.contains("https") || title.contains(".com") || title.contains("/") || !str.contains("http")) {
                if (this.f46476j.isUseNativeTitltBar) {
                    this.f46474h.setTitleName("");
                    return;
                }
                Context context2 = this.f46477k;
                if (context2 != null && (context2 instanceof Page)) {
                    ((Page) context2).getTitleBar().setTitle(new TitleAttr.Builder("").build());
                }
            } else if (this.f46476j.isUseNativeTitltBar) {
                this.f46474h.setTitleName(title);
            } else {
                Context context3 = this.f46477k;
                if (context3 != null && (context3 instanceof Page)) {
                    ((Page) context3).getTitleBar().setTitle(new TitleAttr.Builder(title).build());
                }
            }
        }
    }

    public void onWebPageReceivedError(int i, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("http")) {
            m34639a(true, i);
        }
    }

    public boolean onBack() {
        if (m34641b()) {
            return true;
        }
        return m34643c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m34641b() {
        if (this.f46468b == null) {
            return false;
        }
        GlobalJsBridge globalJsBridge = (GlobalJsBridge) this.f46468b.getExportModuleInstance(SodaFusionEngine.getGlobalJsBridge());
        if (globalJsBridge == null) {
            Log.d("WebTitleModule", "set  webTitleModule is null");
            return false;
        } else if (globalJsBridge.getCallbackFunction() == null) {
            Log.d("WebTitleModule", "getCallbackFunction is null");
            return false;
        } else {
            globalJsBridge.getCallbackFunction().onCallBack(WebJsBridgeTool.buildResponse(0));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m34643c() {
        Context context;
        IErrorLayout iErrorLayout = this.f46480n;
        boolean z = false;
        if (iErrorLayout == null) {
            m34639a(false, 0);
        } else if (iErrorLayout.backNeedHideIt()) {
            m34639a(false, 0);
        }
        SodaWebView sodaWebView = this.f46468b;
        if (sodaWebView != null && sodaWebView.doBack()) {
            z = true;
        }
        if (!z && (context = this.f46477k) != null) {
            ((UpdateUIHandlerImp) context).finishPage();
        }
        return z;
    }

    public void destory() {
        SodaWebView sodaWebView = this.f46468b;
        if (sodaWebView != null) {
            if (sodaWebView.getParent() != null) {
                ((ViewGroup) this.f46468b.getParent()).removeView(this.f46468b);
            }
            this.f46468b.destroy();
            this.f46468b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34634a(final CallbackFunction callbackFunction, String str) {
        List<ShareToolModel> list = this.f46478l;
        if (list == null || list.isEmpty()) {
            if (callbackFunction != null) {
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, "param[buttons] is Empty", (JSONObject) null)));
            }
        } else if (this.f46476j.isUseNativeTitltBar) {
            this.f46474h.setMoreBtnVisibility(0);
            this.f46474h.setOnMoreClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (WebProxy.this.f46477k instanceof UpdateUIHandlerImp) {
                        ((UpdateUIHandlerImp) WebProxy.this.f46477k).onEntranceClick(WebProxy.this.f46478l, callbackFunction);
                    }
                }
            });
        } else {
            Context context = this.f46477k;
            if (context instanceof UpdateUIHandlerImp) {
                ((UpdateUIHandlerImp) context).showEntrance(callbackFunction, str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34644d() {
        if (this.f46476j.isUseNativeTitltBar) {
            this.f46474h.setMoreBtnVisibility(8);
            return;
        }
        Context context = this.f46477k;
        if (context instanceof UpdateUIHandlerImp) {
            ((UpdateUIHandlerImp) context).hideEntrance();
        }
    }
}
