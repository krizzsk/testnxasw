package com.didi.payment.base.proxy;

import android.content.Context;
import java.util.HashMap;

public class CommonProxyHolder {

    /* renamed from: a */
    private static ICommonProxy f32372a;

    public interface ICommonProxy {
        void doLogin(Context context);

        HashMap<String, Object> getBaseParams(Context context);

        Object getTerminalId(Context context);

        boolean isLogin(Context context);
    }

    public static ICommonProxy getProxy() {
        return f32372a;
    }

    public static void setProxy(ICommonProxy iCommonProxy) {
        f32372a = iCommonProxy;
    }
}
