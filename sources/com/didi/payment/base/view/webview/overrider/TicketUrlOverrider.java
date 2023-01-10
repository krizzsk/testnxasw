package com.didi.payment.base.view.webview.overrider;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.push.ServerParam;

public class TicketUrlOverrider implements OverrideUrlLoader {

    /* renamed from: a */
    private PayBaseWebActivity f32513a;

    public TicketUrlOverrider(PayBaseWebActivity payBaseWebActivity) {
        this.f32513a = payBaseWebActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("dcq:")) {
            return false;
        }
        if (str.contains(ServerParam.PARAM_TAXI_TICKET_ID)) {
            String substring = str.substring(str.indexOf(ServerParam.PARAM_TAXI_TICKET_ID) + 6 + 1);
            if (!TextUtils.isEmpty(substring)) {
                m24653a(substring);
            } else if (!this.f32513a.goBack(false)) {
                m24653a("");
            }
        } else {
            this.f32513a.finishWithResultCodeCanceled();
        }
        return true;
    }

    /* renamed from: a */
    private void m24653a(String str) {
        Intent intent = new Intent();
        intent.putExtra("taxi_ticket", str);
        this.f32513a.setResult(-1, intent);
        this.f32513a.finish();
    }
}
