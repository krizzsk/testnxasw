package com.didi.dimina.webview.dmwebview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
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
import com.didi.dimina.webview.container.FusionWebChromeClient;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;

public class DMWebChromeClient extends FusionWebChromeClient {

    /* renamed from: a */
    private boolean f20112a = false;

    /* renamed from: b */
    private final DMWebView f20113b;

    /* renamed from: c */
    private FileChooser f20114c;

    /* renamed from: d */
    private WebViewEngine.OnTitleReceiveListener f20115d;

    public DMWebChromeClient(DMWebView dMWebView) {
        super(dMWebView);
        this.f20113b = dMWebView;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.f20112a) {
                this.f20112a = false;
            }
        } else if (!this.f20112a) {
            this.f20112a = true;
        }
        if (i < 100) {
            this.f20113b.showLoadProgress(i);
        } else {
            this.f20113b.hiddenLoadProgress();
        }
    }

    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        final Context context = webView.getContext();
        PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(context, Permission.CAMERA, DiminaPermissionDescDialog.createCameraDescInfo(this.f20113b.getDmMina()), new SinglePermissionCallBack() {
            public void onDenied(String str) {
                Context context = context;
                ToastUtil.show(context, context.getString(R.string.dimina_permission_camera_grant_failed));
                valueCallback.onReceiveValue((Object) null);
            }

            public void onGranted(String str) {
                DMWebChromeClient.this.getFileChooser().showFileChooser(valueCallback, fileChooserParams);
            }
        });
        return true;
    }

    public FileChooser getFileChooser() {
        if (this.f20114c == null) {
            DMWebView dMWebView = this.f20113b;
            this.f20114c = new FileChooser(dMWebView, (FileChooserOpener) dMWebView.getDmPage().getHost());
        }
        return this.f20114c;
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
        if (this.f20115d != null && !TextUtils.isEmpty(str) && !URLUtil.isNetworkUrl(str) && !str.endsWith(".html") && !str.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)) {
            this.f20115d.onReceiveTitle(str);
        }
    }

    public void setOnTitleReceiveListener(WebViewEngine.OnTitleReceiveListener onTitleReceiveListener) {
        this.f20115d = onTitleReceiveListener;
    }
}
