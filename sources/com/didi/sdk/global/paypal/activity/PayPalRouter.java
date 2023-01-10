package com.didi.sdk.global.paypal.activity;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.sdk.global.paypal.model.PayPalModel;
import com.didi.sdk.global.paypal.model.bean.PayPalSignResult;
import com.didi.sdk.payment.view.browser.WebViewListener;
import com.didi.sdk.payment.view.browser.WebViewListenerHolder;
import com.didi.sdk.payment.view.browser.WebViewModelProxy;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class PayPalRouter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f38969a;

    public static void launchAddPayPalActivity(final Activity activity, final int i, boolean z) {
        if (activity != null && !f38969a) {
            f38969a = true;
            if ((activity instanceof FragmentActivity) && z) {
                m29299b(activity);
            }
            new PayPalModel(activity).requestPayPalSignInfo(new RpcService.Callback<PayPalSignResult>() {
                public void onSuccess(PayPalSignResult payPalSignResult) {
                    String str;
                    String str2;
                    String str3;
                    boolean unused = PayPalRouter.f38969a = false;
                    PayPalRouter.m29302c(activity);
                    String str4 = "";
                    String str5 = "about:blank";
                    if (payPalSignResult != null) {
                        if (!TextUtils.isEmpty(payPalSignResult.newSginUrl)) {
                            str5 = payPalSignResult.newSginUrl;
                        }
                        String str6 = !TextUtils.isEmpty(payPalSignResult.backUrl) ? payPalSignResult.backUrl : str4;
                        if (!TextUtils.isEmpty(payPalSignResult.cancelUrl)) {
                            str4 = payPalSignResult.cancelUrl;
                        }
                        str = str4;
                        str3 = str5;
                        str2 = str6;
                    } else {
                        str2 = str4;
                        str = str2;
                        str3 = str5;
                    }
                    PayPalRouter.m29300b(activity, "", str3, str2, str, i);
                }

                public void onFailure(IOException iOException) {
                    boolean unused = PayPalRouter.f38969a = false;
                    PayPalRouter.m29302c(activity);
                    PayPalRouter.m29300b(activity, "", "about:blank", "", "", i);
                }
            });
        }
    }

    public static void launchAddPayPalActivity(final Fragment fragment, final int i, boolean z) {
        if (fragment != null && !f38969a) {
            f38969a = true;
            final FragmentActivity activity = fragment.getActivity();
            if (z) {
                m29299b(activity);
            }
            new PayPalModel(activity).requestPayPalSignInfo(new RpcService.Callback<PayPalSignResult>() {
                public void onSuccess(PayPalSignResult payPalSignResult) {
                    String str;
                    String str2;
                    String str3;
                    boolean unused = PayPalRouter.f38969a = false;
                    PayPalRouter.m29302c(activity);
                    String str4 = "";
                    String str5 = "about:blank";
                    if (payPalSignResult != null) {
                        if (!TextUtils.isEmpty(payPalSignResult.newSginUrl)) {
                            str5 = payPalSignResult.newSginUrl;
                        }
                        String str6 = !TextUtils.isEmpty(payPalSignResult.backUrl) ? payPalSignResult.backUrl : str4;
                        if (!TextUtils.isEmpty(payPalSignResult.cancelUrl)) {
                            str4 = payPalSignResult.cancelUrl;
                        }
                        str = str4;
                        str3 = str5;
                        str2 = str6;
                    } else {
                        str2 = str4;
                        str = str2;
                        str3 = str5;
                    }
                    PayPalRouter.m29301b(fragment, "", str3, str2, str, i);
                }

                public void onFailure(IOException iOException) {
                    boolean unused = PayPalRouter.f38969a = false;
                    PayPalRouter.m29302c(activity);
                    PayPalRouter.m29301b(fragment, "", "about:blank", "", "", i);
                }
            });
        }
    }

    public static void launchPayPalDetailActivity(Activity activity, int i) {
        GlobalPayPalDetailActivity.launch(activity, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29300b(Activity activity, String str, String str2, String str3, String str4, int i) {
        WebViewListener listener = WebViewListenerHolder.getListener();
        if (listener != null) {
            WebViewModelProxy webViewModelProxy = new WebViewModelProxy();
            webViewModelProxy.setActivity(activity);
            webViewModelProxy.setTitle(str);
            webViewModelProxy.setUrl(str2);
            webViewModelProxy.setType(2);
            webViewModelProxy.setBackUrl(str3);
            webViewModelProxy.setCancelUrl(str4);
            webViewModelProxy.setRequestCode(i);
            listener.callPaypalWebView(webViewModelProxy);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29301b(Fragment fragment, String str, String str2, String str3, String str4, int i) {
        WebViewListener listener = WebViewListenerHolder.getListener();
        if (listener != null) {
            WebViewModelProxy webViewModelProxy = new WebViewModelProxy();
            webViewModelProxy.setFragment(fragment);
            webViewModelProxy.setActivity(fragment.getActivity());
            webViewModelProxy.setTitle(str);
            webViewModelProxy.setUrl(str2);
            webViewModelProxy.setType(3);
            webViewModelProxy.setBackUrl(str3);
            webViewModelProxy.setCancelUrl(str4);
            webViewModelProxy.setRequestCode(i);
            listener.callPaypalWebView(webViewModelProxy);
        }
    }

    /* renamed from: b */
    private static void m29299b(Activity activity) {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m29302c(Activity activity) {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }
}
