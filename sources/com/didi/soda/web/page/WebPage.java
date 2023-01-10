package com.didi.soda.web.page;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.support.util.BundleBuilder;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.soda.web.UpdateUIHandlerImp;
import com.didi.soda.web.WebFileProvider;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.p168ui.WebMenuListPopup;
import com.didi.soda.web.page.performance.PagePerformanceDelegate;
import com.didi.soda.web.page.performance.PagePerformanceListener;
import com.didi.soda.web.proxy.WebProxy;
import com.didi.soda.web.scan.QrCodeScanPage;
import com.didi.soda.web.tools.KeyboardTool;
import com.didi.soda.web.tools.LogUtil;
import com.didi.soda.web.tools.ScreenOrientationMonitor;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didi.sofa.utils.ToastUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebPage extends Page implements UpdateUIHandlerImp, SodaWebView.FileChooserListener, SodaWebView.WebPageErrorListener, SodaWebView.WebPageStateListener {

    /* renamed from: a */
    private static final int f46452a = 1005;

    /* renamed from: b */
    private static final int f46453b = 1006;

    /* renamed from: c */
    private static final String f46454c = "web_temp.jpg";

    /* renamed from: d */
    private FrameLayout f46455d;

    /* renamed from: e */
    private ScreenOrientationMonitor f46456e;

    /* renamed from: f */
    private ValueCallback<Uri> f46457f;

    /* renamed from: g */
    private ValueCallback<Uri[]> f46458g;

    /* renamed from: h */
    private File f46459h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebMenuListPopup f46460i;

    /* renamed from: j */
    private int f46461j;

    /* renamed from: k */
    private PagePerformanceDelegate f46462k;

    /* renamed from: l */
    private WebProxy f46463l;

    /* renamed from: m */
    private WebMenuListPopup.MenuListClickListener f46464m;
    protected WebConfig mWebConfig;

    public IErrorLayout getCustomerErrorLayout() {
        return null;
    }

    public void hideEntrance() {
    }

    /* access modifiers changed from: protected */
    public View inflateTitleBar() {
        return null;
    }

    /* access modifiers changed from: protected */
    public SodaWebView inflateWebView() {
        return null;
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    /* access modifiers changed from: protected */
    public boolean remoteDebuggingEnable() {
        return false;
    }

    public WebPage() {
        this.f46464m = new WebMenuListPopup.MenuListClickListener() {
            public void onMenuCancel() {
                WebPage.this.f46460i.dismiss();
                WebPage.this.m34622a();
            }

            public void onStartCamera() {
                WebPage.this.m34628c();
            }

            public void onStartAlbum() {
                WebPage.this.m34625b();
            }
        };
    }

    public WebPage(WebConfig webConfig) {
        this(new BundleBuilder(new Bundle()).putParcelable(WebConstant.WEB_MODEL, webConfig).build());
    }

    public WebPage(Bundle bundle) {
        super(bundle);
        this.f46464m = new WebMenuListPopup.MenuListClickListener() {
            public void onMenuCancel() {
                WebPage.this.f46460i.dismiss();
                WebPage.this.m34622a();
            }

            public void onStartCamera() {
                WebPage.this.m34628c();
            }

            public void onStartAlbum() {
                WebPage.this.m34625b();
            }
        };
    }

    public void onCreate(View view) {
        super.onCreate(view);
        ScreenOrientationMonitor screenOrientationMonitor = new ScreenOrientationMonitor((Activity) getBaseContext());
        this.f46456e = screenOrientationMonitor;
        screenOrientationMonitor.onCreate();
        this.f46463l = new WebProxy(this, inflateWebView(), inflateTitleBar(), this.f46455d, getCustomerErrorLayout(), this.mWebConfig);
        this.f46459h = new File(getExternalCacheDir(), "web_temp.jpg");
        getWebView().setFileChooserListener(this);
        getWebView().setWebPageErrorListener(this);
        WebMenuListPopup webMenuListPopup = new WebMenuListPopup(getBaseContext(), getScopeContext());
        this.f46460i = webMenuListPopup;
        webMenuListPopup.setListener(this.f46464m);
        this.f46462k = new PagePerformanceDelegate();
    }

    public void onInitialize() {
        super.onInitialize();
        if (getArgs().containsKey(WebConstant.WEB_MODEL)) {
            WebConfig webConfig = (WebConfig) getArgs().getParcelable(WebConstant.WEB_MODEL);
            this.mWebConfig = webConfig;
            webConfig.remoteDebuggable = remoteDebuggingEnable();
            if (TextUtils.isEmpty(this.mWebConfig.url)) {
                finish();
                return;
            }
            return;
        }
        finish();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.nova_web_page_hybrid, viewGroup, false);
        this.f46455d = frameLayout;
        return frameLayout;
    }

    public void updateUI(String str, Object... objArr) {
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.updateUI(str, objArr);
        }
    }

    public WebPageTitleBar getWebTitleBar() {
        WebProxy webProxy = this.f46463l;
        if (webProxy == null) {
            return null;
        }
        return webProxy.getWebTitleBar();
    }

    /* access modifiers changed from: protected */
    public SodaWebView getWebView() {
        WebProxy webProxy = this.f46463l;
        if (webProxy == null) {
            return null;
        }
        return webProxy.getWebView();
    }

    public boolean getIsUserNativeTitleBar() {
        return this.mWebConfig.isUseNativeTitltBar;
    }

    public void invokeJSMethod(String str, String str2, Object... objArr) {
        if (getWebView() != null) {
            getWebView().getJavascriptBridge().invokeJSMethod(str, str2, objArr);
        }
    }

    public void cancelProgressDialog() {
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.cancelProgressDialog();
        }
    }

    public boolean onInterceptedToNative(String str) {
        LogUtil.info("InterceptedToNative : " + str);
        return false;
    }

    public void onWebPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtil.info("onWebPageStarted");
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.onWebPageStarted();
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f46462k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageStarted(str);
        }
    }

    public void onWebPageFinished(WebView webView, String str) {
        LogUtil.info("onWebPageFinished : title = " + webView.getTitle());
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.onWebPageFinished(webView, str);
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f46462k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageFinished(str);
        }
    }

    public void onWebPageReceivedError(WebView webView, int i, String str, String str2) {
        LogUtil.info("onWebPageReceivedError");
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.onWebPageReceivedError(i, str2);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        LogUtil.info("openFileChooser");
        this.f46457f = valueCallback;
        this.f46460i.show();
    }

    public void onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        LogUtil.info("onShowFileChooser");
        this.f46458g = valueCallback;
        this.f46460i.show();
    }

    public boolean onHandleBack() {
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            return webProxy.onBack();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34622a() {
        ValueCallback<Uri> valueCallback = this.f46457f;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.f46457f = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.f46458g;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue((Object) null);
            this.f46458g = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34625b() {
        this.f46461j = 2;
        requestPermissions(new String[]{Permission.WRITE_EXTERNAL_STORAGE});
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        finish();
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        m34623a(this.f46461j);
    }

    /* renamed from: a */
    private void m34623a(int i) {
        try {
            Intent intent = new Intent();
            int i2 = 0;
            if (i == 1) {
                i2 = 1006;
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", m34620a(intent, this.f46459h));
            } else if (i == 2) {
                i2 = 1005;
                intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
                intent.setAction("android.intent.action.GET_CONTENT");
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                this.f46460i.dismiss();
                startActivityForResult(intent, i2);
            } else if (Build.VERSION.SDK_INT >= 30) {
                this.f46460i.dismiss();
                startActivityForResult(intent, i2);
            } else {
                ToastUtils.show(getBaseContext(), (CharSequence) "can not find target page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34628c() {
        this.f46461j = 1;
        requestPermissions(new String[]{Permission.CAMERA});
    }

    /* renamed from: a */
    private Uri m34620a(Intent intent, File file) {
        if (Build.VERSION.SDK_INT <= 23) {
            return Uri.fromFile(file);
        }
        Context baseContext = getBaseContext();
        Uri uriForFile = WebFileProvider.getUriForFile(baseContext, getBaseContext().getPackageName() + WebConstant.WEB_FILE_PATH, file);
        for (ResolveInfo resolveInfo : getBaseContext().getPackageManager().queryIntentActivities(intent, 65536)) {
            getBaseContext().grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
        }
        return uriForFile;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1005 && i != 1006) {
            return;
        }
        if (this.f46458g != null) {
            m34626b(i, i2, intent);
        } else {
            m34624a(i, i2, intent);
        }
    }

    public void reLoad(String str) {
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.reLoadUrl(str);
        }
    }

    public void reLoadSelf() {
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.reloadSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r6 = r6.getDataString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m34624a(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            android.webkit.ValueCallback<android.net.Uri> r0 = r3.f46457f
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1005(0x3ed, float:1.408E-42)
            r1 = -1
            r2 = 0
            if (r4 != r0) goto L_0x0018
            if (r5 != r1) goto L_0x0018
            java.lang.String r6 = r6.getDataString()
            if (r6 == 0) goto L_0x0018
            android.net.Uri r6 = android.net.Uri.parse(r6)
            goto L_0x0019
        L_0x0018:
            r6 = r2
        L_0x0019:
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r4 != r0) goto L_0x0027
            if (r5 != r1) goto L_0x0027
            java.io.File r4 = r3.f46459h
            if (r4 == 0) goto L_0x0027
            android.net.Uri r6 = android.net.Uri.fromFile(r4)
        L_0x0027:
            android.webkit.ValueCallback<android.net.Uri> r4 = r3.f46457f
            r4.onReceiveValue(r6)
            r3.f46457f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.page.WebPage.m34624a(int, int, android.content.Intent):void");
    }

    /* renamed from: b */
    private void m34626b(int i, int i2, Intent intent) {
        Uri[] uriArr;
        File file;
        if (this.f46458g != null) {
            if (i == 1005 && i2 == -1 && intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            } else {
                uriArr = null;
            }
            if (i == 1006 && i2 == -1 && (file = this.f46459h) != null) {
                uriArr = new Uri[]{Uri.fromFile(file)};
            }
            this.f46458g.onReceiveValue(uriArr);
            this.f46458g = null;
        }
    }

    public void onDestroy() {
        ScreenOrientationMonitor screenOrientationMonitor = this.f46456e;
        if (screenOrientationMonitor != null) {
            screenOrientationMonitor.onDestroy();
        }
        WebProxy webProxy = this.f46463l;
        if (webProxy != null) {
            webProxy.destory();
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f46462k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onDestroy();
        }
        super.onDestroy();
    }

    public void finishPage() {
        finish();
        KeyboardTool.hideSoftInput(getBaseContext(), (View) null);
    }

    public void launchScan(final CallbackFunction callbackFunction) {
        getScopeContext().getNavigator().push(new QrCodeScanPage() {
            public void provideScanResult(String str) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("message", str);
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(jSONObject)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                    }
                }
            }
        });
    }

    public void showEntrance(CallbackFunction callbackFunction, String str) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        invokeEntrance(list, callbackFunction);
    }

    public void invokeEntrance(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void showSystemEntrance(ShareToolModel shareToolModel, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void setPagePerformanceListener(PagePerformanceListener pagePerformanceListener) {
        LogUtil.info("setPagePerformanceListener");
        PagePerformanceDelegate pagePerformanceDelegate = this.f46462k;
        if (pagePerformanceDelegate == null) {
            LogUtil.info("Delegate null");
        } else {
            pagePerformanceDelegate.setPerformanceListener(pagePerformanceListener);
        }
    }
}
