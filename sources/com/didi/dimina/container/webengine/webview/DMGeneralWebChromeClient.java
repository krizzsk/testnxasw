package com.didi.dimina.container.webengine.webview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.p065ui.webview.FileChooser;
import com.didi.dimina.container.p065ui.webview.FileChooserOpener;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.dimina.container.util.ToastUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import org.json.JSONObject;

public class DMGeneralWebChromeClient extends WebChromeClient {

    /* renamed from: a */
    private boolean f19847a = false;

    /* renamed from: b */
    private final DMGeneralWebView f19848b;

    /* renamed from: c */
    private FileChooser f19849c;

    /* renamed from: d */
    private WebViewEngine.OnTitleReceiveListener f19850d;

    public DMGeneralWebChromeClient(DMGeneralWebView dMGeneralWebView) {
        this.f19848b = dMGeneralWebView;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            String optString = new JSONObject(str2).optString("fusion");
            if (!TextUtils.isEmpty(optString) && optString.equals("loadJSModules")) {
                jsPromptResult.confirm("");
                return true;
            }
        } catch (Exception unused) {
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.f19847a) {
                this.f19847a = false;
            }
        } else if (!this.f19847a) {
            this.f19847a = true;
        }
    }

    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        final Context context = webView.getContext();
        PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(context, Permission.CAMERA, DiminaPermissionDescDialog.createCameraDescInfo(this.f19848b.getDmMina()), new SinglePermissionCallBack() {
            public void onDenied(String str) {
                Context context = context;
                ToastUtil.show(context, context.getString(R.string.dimina_permission_camera_grant_failed));
                valueCallback.onReceiveValue((Object) null);
            }

            public void onGranted(String str) {
                DMGeneralWebChromeClient.this.getFileChooser().showFileChooser(valueCallback, fileChooserParams);
            }
        });
        return true;
    }

    public FileChooser getFileChooser() {
        if (this.f19849c == null) {
            DMGeneralWebView dMGeneralWebView = this.f19848b;
            this.f19849c = new FileChooser(dMGeneralWebView, (FileChooserOpener) dMGeneralWebView.getDmPage().getHost());
        }
        return this.f19849c;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            if (Dimina.getConfig() == null || !Dimina.getConfig().isDebug()) {
                LogUtil.eRelease("webview_log", "[error] " + consoleMessage.message());
                LogUtil.eRelease("webview_log", "[error] sourceId = " + consoleMessage.sourceId());
                LogUtil.eRelease("webview_log", "[error] lineNumber = " + consoleMessage.lineNumber());
            } else {
                LogUtil.m16839e("tag_web_view | " + consoleMessage.message());
            }
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.TIP) {
            LogUtil.m16841i("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.LOG) {
            LogUtil.m16841i("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
            LogUtil.m16843w("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.DEBUG) {
            return true;
        }
        LogUtil.m16837d("tag_web_view | " + consoleMessage.message());
        return true;
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f19850d != null && !TextUtils.isEmpty(str) && !URLUtil.isNetworkUrl(str) && !str.endsWith(".html") && !str.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)) {
            this.f19850d.onReceiveTitle(str);
        }
    }

    public void setOnTitleReceiveListener(WebViewEngine.OnTitleReceiveListener onTitleReceiveListener) {
        this.f19850d = onTitleReceiveListener;
    }
}
