package com.didi.sdk.webview;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.sdk.push.ServerParam;

public class TicketUrlOverrider implements OverrideUrlLoader {

    /* renamed from: a */
    private BaseWebActivity f41111a;

    public TicketUrlOverrider(BaseWebActivity baseWebActivity) {
        this.f41111a = baseWebActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("dcq:")) {
            return false;
        }
        if (str.contains(ServerParam.PARAM_TAXI_TICKET_ID)) {
            String substring = str.substring(str.indexOf(ServerParam.PARAM_TAXI_TICKET_ID) + 6 + 1, str.length());
            if (!TextUtils.isEmpty(substring)) {
                m30832a(substring);
            } else if (!this.f41111a.goBack(false)) {
                m30832a("");
            }
        } else {
            this.f41111a.mo104420a();
        }
        return true;
    }

    /* renamed from: a */
    private void m30832a(String str) {
        Intent intent = new Intent();
        intent.putExtra("taxi_ticket", str);
        this.f41111a.setResult(-1, intent);
        this.f41111a.finish();
    }
}
