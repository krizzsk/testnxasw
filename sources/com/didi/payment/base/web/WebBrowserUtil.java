package com.didi.payment.base.web;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.payment.base.proxy.WebViewProxyHolder;

public class WebBrowserUtil {
    public static void startInternalWebActivity(Object obj, String str, String str2) {
        WebViewProxyHolder.IWebViewProxy proxy;
        if (m24702a(obj, str) && (proxy = WebViewProxyHolder.getProxy()) != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.type = 0;
            webViewModel.activity = m24700a(obj);
            webViewModel.fragment = m24703b(obj);
            webViewModel.url = str;
            webViewModel.title = str2;
            webViewModel.isPostBaseParams = true;
            proxy.callWebActivity(webViewModel);
        }
    }

    public static void startCreditCardWebActivity(WebSignParam webSignParam) {
        m24701a(1, webSignParam);
    }

    public static void startPayPalSignWebActivity(WebSignParam webSignParam) {
        m24701a(2, webSignParam);
    }

    public static void startZftWebActivity(WebSignParam webSignParam) {
        m24701a(3, webSignParam);
    }

    public static void startCmbWebActivity(WebSignParam webSignParam) {
        m24701a(4, webSignParam);
    }

    /* renamed from: a */
    private static void m24701a(int i, WebSignParam webSignParam) {
        WebViewProxyHolder.IWebViewProxy proxy;
        if (webSignParam != null && !TextUtils.isEmpty(webSignParam.url)) {
            if ((webSignParam.fragment != null || webSignParam.activity != null) && (proxy = WebViewProxyHolder.getProxy()) != null) {
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.type = i;
                webViewModel.activity = webSignParam.activity;
                webViewModel.fragment = webSignParam.fragment;
                webViewModel.url = webSignParam.url;
                webViewModel.title = webSignParam.title;
                webViewModel.postData = webSignParam.postData;
                webViewModel.backUrl = webSignParam.backUrl;
                webViewModel.cancelUrl = webSignParam.cancelUrl;
                webViewModel.requestCode = webSignParam.requestCode;
                proxy.callWebActivity(webViewModel);
            }
        }
    }

    /* renamed from: a */
    private static boolean m24702a(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ((obj instanceof Activity) || (obj instanceof Fragment)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static Activity m24700a(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    /* renamed from: b */
    private static Fragment m24703b(Object obj) {
        if (obj instanceof Fragment) {
            return (Fragment) obj;
        }
        return null;
    }
}
