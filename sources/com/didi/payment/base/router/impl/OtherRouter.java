package com.didi.payment.base.router.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.utils.IntentUtil;
import java.util.Map;

public class OtherRouter implements IPayRouter {

    /* renamed from: a */
    private String f32394a;

    public void destroy() {
    }

    public void route(Context context, String str, Map<String, Object> map, final RouteCallback routeCallback) {
        this.f32394a = str;
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(str);
        ActivityLauncher.init((Activity) context).startActivityForResult(intent, (ActivityLauncher.Callback) new ActivityLauncher.Callback() {
            public void onActivityResult(int i, Intent intent) {
                RouteCallback routeCallback = routeCallback;
                if (routeCallback != null) {
                    routeCallback.onResult(i == -1, IntentUtil.getIntent(intent));
                }
            }
        });
    }

    public String getUrl() {
        return this.f32394a;
    }
}
