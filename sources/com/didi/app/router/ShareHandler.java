package com.didi.app.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.apm.SystemUtils;

public class ShareHandler implements IRouterHandler {

    /* renamed from: a */
    private static final int f10509a = 0;

    /* renamed from: b */
    private static final String f10510b = "channel";

    /* renamed from: c */
    private static final String f10511c = "universal_link";

    /* renamed from: d */
    private static final String f10512d = "source";

    public void handle(Request request, Result result) {
        int i;
        Uri uri = request.getUri();
        try {
            i = Integer.parseInt(uri.getQueryParameter("channel"));
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        String queryParameter = uri.getQueryParameter(f10511c);
        uri.getQueryParameter("source");
        if (i == 0) {
            m9196a(request.getContext(), queryParameter);
        }
    }

    /* renamed from: a */
    private void m9196a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setData(Uri.parse(str));
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
                SystemUtils.log(6, "ShareHandler", "No activity to handle intent", (Throwable) null, "com.didi.app.router.ShareHandler", 69);
            }
        }
    }
}
