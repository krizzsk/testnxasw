package com.didi.payment.base.router.impl;

import android.content.Context;
import java.util.Map;

public class ActivityRouter implements IPayRouter {

    /* renamed from: a */
    private String f32392a;

    public void destroy() {
    }

    public void route(Context context, String str, Map<String, Object> map, RouteCallback routeCallback) {
        this.f32392a = str;
    }

    public String getUrl() {
        return this.f32392a;
    }
}
