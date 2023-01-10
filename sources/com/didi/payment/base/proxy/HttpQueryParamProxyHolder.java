package com.didi.payment.base.proxy;

import android.content.Context;
import java.util.HashMap;

public class HttpQueryParamProxyHolder {

    /* renamed from: a */
    private static IQueryParamProxy f32377a;

    public interface IQueryParamProxy {
        HashMap<String, Object> getQueryParams(Context context);
    }

    public static IQueryParamProxy getProxy() {
        return f32377a;
    }

    public static void setProxy(IQueryParamProxy iQueryParamProxy) {
        f32377a = iQueryParamProxy;
    }
}
