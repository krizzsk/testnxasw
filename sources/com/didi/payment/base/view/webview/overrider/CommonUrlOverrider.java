package com.didi.payment.base.view.webview.overrider;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import androidx.core.net.MailTo;
import com.didi.sdk.apm.SystemUtils;

public class CommonUrlOverrider implements OverrideUrlLoader {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (str.startsWith("tel:")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                webView.getContext().startActivity(intent);
                return true;
            } else if (str.startsWith("sms:")) {
                webView.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                return true;
            } else if (!str.startsWith(MailTo.MAILTO_SCHEME)) {
                return false;
            } else {
                webView.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                return true;
            }
        } catch (Exception unused) {
            SystemUtils.log(3, "CommonUrlOverrider", "CommonUrlOverrider startacivity error", (Throwable) null, "com.didi.payment.base.view.webview.overrider.CommonUrlOverrider", 41);
            return false;
        }
    }
}
